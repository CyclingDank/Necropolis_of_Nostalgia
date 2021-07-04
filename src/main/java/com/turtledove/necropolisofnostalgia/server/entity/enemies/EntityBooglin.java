package com.turtledove.necropolisofnostalgia.server.entity.enemies;

import com.google.common.base.Predicates;
import com.turtledove.necropolisofnostalgia.server.ai.*;
import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class EntityBooglin extends NecropolisEntity
{
    public static final Animation CHARGE_ANIMATION = Animation.create(26);
    public static final Animation SWEEP_ANIMATION = Animation.create(30);
    public static final Animation FLIP_ANIMATION = Animation.create(20);
    public static final Animation FLAIL_ANIMATION = Animation.create(38);
    public static final Animation COMBO_ANIMATION = Animation.create(36);
    public static final Animation HURT_ANIMATION = Animation.create(5);

    public static final Animation BLOCK_40_ANIMATION = Animation.create(45);
    public static final Animation BLOCK_80_ANIMATION = Animation.create(85);


    public static final Animation MINE_ANIMATION = Animation.create(26);

    private static final Animation[] ANIMATIONS = {CHARGE_ANIMATION, SWEEP_ANIMATION, FLIP_ANIMATION, FLAIL_ANIMATION, MINE_ANIMATION, COMBO_ANIMATION, HURT_ANIMATION,
            BLOCK_40_ANIMATION, BLOCK_80_ANIMATION};
    private int maxDistanceForPlayer;

    private int jabCooldown;
    private int sweepCooldown;

    private ArrayList<BlockPos> minePath;
    private boolean isMining;
    private int mineProgress;


    public EntityBooglin(World worldin)
    {
        super(worldin);
        setPathPriority(PathNodeType.WATER, 0);
        this.setSize(0.7F, 1.7F);
        this.active = true;
        this.isImmuneToFire = false;
        this.targetofmyrevenge = null;
        this.struckwhileGuarding = false;
        this.maxDistanceForPlayer = 20;

        this.minePath = new ArrayList<BlockPos>();
        this.isMining = false;
        this.mineProgress = 0;

        this.defense = 12;
        this.sDefense = 6;

        this.elementWeakness[1] = -1;
        this.elementWeakness[2] = 1;
        this.elementWeakness[3] = -1;
        this.elementWeakness[4] = -1;

        this.jabCooldown = 70;
        this.sweepCooldown = 60;

        this.setFoeType(1);
    }
    @Override
    public boolean isCreatureType(EnumCreatureType type, boolean forSpawnCount) {
        if (forSpawnCount && isNoDespawnRequired()) return false;
        return type == EnumCreatureType.MONSTER;
    }

    public boolean getCanSpawnHere()
    {
        return super.getCanSpawnHere();
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(150.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0);
    }
    protected void entityInit()
    {
        super.entityInit();
    }
    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new AnimationBooglinComboAI<>(this, COMBO_ANIMATION));
        this.tasks.addTask(1, new AnimationBooglinJabAI<>(this, CHARGE_ANIMATION));
        this.tasks.addTask(1, new AnimationBooglinSweepAI<>(this, SWEEP_ANIMATION));
        this.tasks.addTask(1, new AnimationBooglinFlipAI<>(this, FLIP_ANIMATION));
        this.tasks.addTask(1, new AnimationBooglinFlailAI<>(this, FLAIL_ANIMATION));

        this.tasks.addTask(1, new AnimationGenericAI<>(this, MINE_ANIMATION));
        this.tasks.addTask(1, new AnimationGenericAI<>(this, HURT_ANIMATION));
        this.tasks.addTask(1, new AnimationGenericAI<>(this, BLOCK_40_ANIMATION));
        this.tasks.addTask(1, new AnimationGenericAI<>(this, BLOCK_80_ANIMATION));


        this.tasks.addTask(2, new EntityAIFaceOff(this,0.3D, 3));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 0.1875D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 2.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.world.isRemote) {
            Entity closestEntity = this.world.getClosestPlayer(this.posX, this.posY, this.posZ, (double) maxDistanceForPlayer, Predicates.and(EntitySelectors.CAN_AI_TARGET, EntitySelectors.notRiding(this)));

            if (closestEntity != null && closestEntity.isEntityAlive())
            {
                this.targetofmyrevenge = (EntityPlayer) closestEntity;
                this.active = true;
                if (this.canEntityBeSeen(this.targetofmyrevenge))
                {
                    float dist = this.getDistance(this.targetofmyrevenge);
                    this.minePath.clear();
                    this.mineProgress = 0;
                    this.isMining = false;
                    if (this.isInWater()) {
                        double slopeX = (this.targetofmyrevenge.posX - this.posX) / 4.0D;
                        double slopeZ = (this.targetofmyrevenge.posZ - this.posZ) / 4.0D;
                        double numerator = Math.sqrt(slopeX * slopeX + slopeZ * slopeZ) * 10.0;
                        this.motionX = slopeX * 0.75F / numerator;
                        this.motionZ = slopeZ * 0.75F / numerator;
                    }

                    if (dist < 3 && this.isMining == false)
                    {

                        if (getAnimation() == NO_ANIMATION || getAnimation() == BLOCK_40_ANIMATION || getAnimation() == BLOCK_80_ANIMATION)
                        {
                            double speed = 0.05D;
                            this.getNavigator().tryMoveToEntityLiving(this.targetofmyrevenge, speed);
                            this.getLookHelper().setLookPositionWithEntity(this.targetofmyrevenge,90.0F, 90.0F);
                        }
                        else
                        {
                            this.getNavigator().clearPath();
                        }



                        if ( dist >= 2.5)
                        {
                            if (getAnimation() == NO_ANIMATION && this.jabCooldown > 5)
                            {
                                AnimationHandler.INSTANCE.sendAnimationMessage(this, CHARGE_ANIMATION);
                                this.jabCooldown = 0;
                                this.sweepCooldown = 6;
                            }
                        }
                        else if (dist < 2.5)
                        {
                            if (getAnimation() == NO_ANIMATION && this.sweepCooldown > 4)
                            {
                                double tRand = Math.random();

                                if (this.getHealth() < this.getMaxHealth() * 0.7)   //phase 2
                                {
                                    if (tRand < 0.25)
                                    {
                                        AnimationHandler.INSTANCE.sendAnimationMessage(this, FLIP_ANIMATION);
                                    }
                                    else if (tRand < 0.6)
                                        AnimationHandler.INSTANCE.sendAnimationMessage(this, COMBO_ANIMATION);
                                    else if (tRand < 0.7)
                                        AnimationHandler.INSTANCE.sendAnimationMessage(this, SWEEP_ANIMATION);
                                    else
                                        AnimationHandler.INSTANCE.sendAnimationMessage(this, FLAIL_ANIMATION);
                                }
                                else
                                {
                                    if (tRand < 0.3)
                                    {
                                        AnimationHandler.INSTANCE.sendAnimationMessage(this, FLIP_ANIMATION);
                                    }
                                    else if (tRand < 0.6)
                                        AnimationHandler.INSTANCE.sendAnimationMessage(this, FLAIL_ANIMATION);
                                    else if (tRand < 0.8)
                                        AnimationHandler.INSTANCE.sendAnimationMessage(this, SWEEP_ANIMATION);
                                    else if (tRand < 0.9)
                                        AnimationHandler.INSTANCE.sendAnimationMessage(this, BLOCK_40_ANIMATION);
                                    else
                                        AnimationHandler.INSTANCE.sendAnimationMessage(this, BLOCK_80_ANIMATION);
                                }
                                this.sweepCooldown = 0;
                            }
                        }

                        if (getAnimation() == NO_ANIMATION || getAnimation() == FLIP_ANIMATION)
                        {
                            this.sweepCooldown++;
                            this.jabCooldown++;
                        }
                    }
                }
                else
                {
                    if (this.getNavigator().noPath() && this.isMining == false)
                    {
                        float dist = this.getDistance(this.targetofmyrevenge);
                        if (dist < 15)
                        {
                            int bPosX = this.getPosition().getX();
                            int bPosY = this.getPosition().getY();
                            int bPosZ = this.getPosition().getZ();

                            int tPosX = this.targetofmyrevenge.getPosition().getX();
                            int tPosY = this.targetofmyrevenge.getPosition().getY();
                            int tPosZ = this.targetofmyrevenge.getPosition().getZ();

                            if (Math.abs(tPosY - bPosY) > 1)
                                return;
                            if (bPosX != tPosX)
                            {
                                for (int i = 0; i < Math.abs(bPosX - tPosX); i++)
                                {
                                    int incr = i;
                                    if (bPosX - tPosX > 0)
                                        incr *= -1;
                                    this.minePath.add(new BlockPos(bPosX + incr, bPosY, bPosZ));
                                }
                            }
                            if (bPosZ != tPosZ)
                            {
                                for (int i = 0; i < Math.abs(bPosZ - tPosZ); i++)
                                {
                                    int incrX = Math.abs(bPosX - tPosX);
                                    if (bPosX - tPosX > 0)
                                        incrX *= -1;

                                    int incr = i;
                                    if (bPosZ - tPosZ > 0)
                                        incr *= -1;
                                    this.minePath.add(new BlockPos(bPosX + incrX, bPosY, bPosZ + incr));
                                }
                            }
                            this.isMining = true;
                        }
                    }
                    else if (this.getNavigator().noPath() && this.isMining == true)
                    {
                        if (this.minePath.size() > 1)
                        {
                            if (this.mineProgress > 26)
                            {
                                if (!this.world.isAirBlock(this.minePath.get(0)) || !this.world.isAirBlock(this.minePath.get(0).up()) )
                                {
                                    this.world.setBlockToAir(this.minePath.get(0));
                                    this.world.setBlockToAir(this.minePath.get(0).up());
                                    this.playSound(SoundEvents.BLOCK_STONE_BREAK, 1.0F, 1.0F);
                                    this.playSound(NecropolisSounds.BOOGLIN_DRILL_1, 0.5F, 1.0F);
                                    this.minePath.remove(0);
                                    this.getNavigator().tryMoveToXYZ(this.minePath.get(0).getX(), this.minePath.get(0).getY(), this.minePath.get(0).getZ(), 0.3D);
                                    this.mineProgress = -1;
                                }
                                else
                                {
                                    this.minePath.remove(0);
                                    this.getNavigator().tryMoveToXYZ(this.minePath.get(0).getX(), this.minePath.get(0).getY(), this.minePath.get(0).getZ(), 0.3D);
                                    this.mineProgress = 27;
                                    return;
                                }
                            }
                            else if (this.mineProgress == 0)
                            {
                                if (getAnimation() == NO_ANIMATION)
                                    AnimationHandler.INSTANCE.sendAnimationMessage(this, MINE_ANIMATION);
                                else
                                    return;
                            }
                            this.mineProgress++;
                        }
                        else
                        {
                            this.isMining = false;
                            this.minePath.clear();
                            this.mineProgress = 0;
                            this.getNavigator().clearPath();
                        }
                    }
                }
            }
            else
            {
                this.targetofmyrevenge = null;
                this.isMining = false;
                this.minePath.clear();
                this.mineProgress = 0;
                this.active = false;
            }
        }
    }
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (!this.world.isRemote)
        {
            if (getAnimation() == BLOCK_40_ANIMATION || getAnimation() == BLOCK_80_ANIMATION)
            {
                this.playSound(SoundEvents.BLOCK_ANVIL_LAND, 0.5F, 1.4F);
                return false;
            }
            if (getAnimation() == NO_ANIMATION)
            {
                AnimationHandler.INSTANCE.sendAnimationMessage(this, HURT_ANIMATION);
                this.playSound(NecropolisSounds.BOOGLIN_CRY, 0.7F, 1.5F);
                this.sweepCooldown = 0;
                this.jabCooldown = 0;
            }
            return super.attackEntityFrom(source, amount);
        }
        else
        {
            return false;
        }
    }
    public void onDeath(DamageSource cause)
    {
        super.onDeath(cause);
        if ((cause.getDamageType() == "melee") || cause.getDamageType() == "arte" || cause.getDamageType() == "physical_artes")
        {
            if (!this.world.isRemote)
            {
                this.dropExperience(8);
                this.entityDropItem(new ItemStack(Items.IRON_INGOT, 5, 0), 0.0F);
            }
        }
    }

    @Override
    public Animation[] getAnimations()
    {
        return ANIMATIONS;
    }

    @Nullable
    protected ResourceLocation getLootTable()
    {
        return LootTableList.ENTITIES_VINDICATION_ILLAGER;
    }
    protected SoundEvent getAmbientSound()
    {
        return NecropolisSounds.BOOGLIN_AMBIENT;
    }

}
