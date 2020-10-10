package com.turtledove.necropolisofnostalgia.server.entity.enemies;

import com.google.common.base.Predicates;
import com.turtledove.necropolisofnostalgia.server.ai.*;
import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.minecraft.block.Block;
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
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityFugu  extends NecropolisEntity
{
    private int attack_cooldown;

    public static final Animation PUNCH_ANIMATION = Animation.create(20);
    public static final Animation LEAP_ANIMATION = Animation.create(44);
    public static final Animation LEAP_FLAIL_ANIMATION = Animation.create(52);
    public static final Animation TAIL_ANIMATION = Animation.create(58);

    public static final Animation HURT_ANIMATION = Animation.create(5);



    private static final Animation[] ANIMATIONS = {PUNCH_ANIMATION, LEAP_ANIMATION, LEAP_FLAIL_ANIMATION, TAIL_ANIMATION, HURT_ANIMATION};
    private int maxDistanceForPlayer;



    public EntityFugu(World worldin) {
        super(worldin);
        this.setSize(0.7F, 1.7F);
        this.active = true;
        this.isImmuneToFire = false;

        this.defense = 20;
        this.sDefense = 20;

        this.maxDistanceForPlayer = 20;

        this.attack_cooldown = 0;


        this.elementWeakness[1] = -1;
        this.elementWeakness[2] = -1;
        this.elementWeakness[5] = 1;
        this.elementWeakness[6] = -1;
        this.elementWeakness[7] = 1;
        this.attack_cooldown = 0;
        this.setFoeType(2);
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

        this.tasks.addTask(1, new AnimationFuguPunchAI<>(this, PUNCH_ANIMATION));
        this.tasks.addTask(1, new AnimationFuguLeapAI<>(this, LEAP_ANIMATION));
        this.tasks.addTask(1, new AnimationFuguLeapFlailAI<>(this, LEAP_FLAIL_ANIMATION));
        this.tasks.addTask(1, new AnimationFuguTailAI<>(this, TAIL_ANIMATION));
        this.tasks.addTask(1, new AnimationGenericAI<>(this, HURT_ANIMATION));


        this.tasks.addTask(2, new EntityAIFaceOff(this,0.1875D, 5));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 0.1875D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (this.world.isRemote)
        {
            this.setHealth(this.getHealth());
        }
        if (!this.world.isRemote)
        {
            Entity closestEntity = this.world.getClosestPlayer(this.posX, this.posY, this.posZ, (double)maxDistanceForPlayer, Predicates.and(EntitySelectors.CAN_AI_TARGET, EntitySelectors.notRiding(this)));
            if (closestEntity != null && closestEntity.isEntityAlive())
            {
                if (this.targetofmyrevenge == null && this.canEntityBeSeen(closestEntity))
                {
                    this.targetofmyrevenge = (EntityPlayer)closestEntity;
                    this.active = true;
                }
                if (this.targetofmyrevenge == null)
                    return;
                if (this.canEntityBeSeen(this.targetofmyrevenge))
                {
                    float dist = this.getDistance(this.targetofmyrevenge);

                    if (this.isInWater())
                    {
                        double slopeX = (this.targetofmyrevenge.posX - this.posX)/4.0D;
                        double slopeZ = (this.targetofmyrevenge.posZ - this.posZ)/4.0D;
                        double numerator = Math.sqrt(slopeX * slopeX + slopeZ * slopeZ) * 10.0;
                        this.motionX = slopeX * 0.75F / numerator;
                        this.motionZ = slopeZ * 0.75F  / numerator;
                    }

                    if (dist <= 5)
                    {
                        if (getAnimation() == NO_ANIMATION || (getAnimation() == LEAP_ANIMATION && getAnimationTick() < 8) || (getAnimation() == LEAP_FLAIL_ANIMATION && getAnimationTick() < 8) )
                        {
                            double speed = 0.05D;
                            if (dist > 2)
                                speed = 0.25D;
                            if (getAnimation() == LEAP_ANIMATION || getAnimation() == LEAP_FLAIL_ANIMATION)
                                speed = 0.05D;
                            this.getNavigator().tryMoveToEntityLiving(this.targetofmyrevenge, speed);
                            this.getLookHelper().setLookPositionWithEntity(this.targetofmyrevenge,90.0F, 90.0F);
                        }
                        else
                        {
                            this.getNavigator().clearPath();
                        }
                    }
                    if (dist <= 5 && getAnimation() == NO_ANIMATION)
                    {
                        double tRand = Math.random();
                        if (attack_cooldown > 4)
                        {
                            if (dist <= 2)
                            {
                                if (tRand < 0.4)
                                    AnimationHandler.INSTANCE.sendAnimationMessage(this, PUNCH_ANIMATION);
                                else if (tRand < 0.8)
                                    AnimationHandler.INSTANCE.sendAnimationMessage(this, TAIL_ANIMATION);
                                else
                                    AnimationHandler.INSTANCE.sendAnimationMessage(this, LEAP_FLAIL_ANIMATION);
                            }
                            else
                            {
                                AnimationHandler.INSTANCE.sendAnimationMessage(this, LEAP_ANIMATION);
                            }
                            this.attack_cooldown = 0;
                        }
                    }
                    if (getAnimation() == NO_ANIMATION)
                    {
                        this.attack_cooldown++;
                    }
                }
            }
            else
            {
                this.targetofmyrevenge = null;
                this.active = false;
            }
        }
    }
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (!this.world.isRemote)
        {
            if (getAnimation() == NO_ANIMATION)
            {
                AnimationHandler.INSTANCE.sendAnimationMessage(this, HURT_ANIMATION);
                float pitch = (float)Math.random()/2.0F - 0.5F;
                this.playSound(NecropolisSounds.FUGU_CRY, 0.7F, 1.0F + pitch);
                this.attack_cooldown = -4;
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
                this.dropExperience(30);
                this.entityDropItem(new ItemStack(Items.DIAMOND, 1, 0), 0.0F);
            }
        }
    }
    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.BLOCK_SLIME_FALL, 0.7F, 1.0F);
    }
    @Override
    public Animation[] getAnimations()
    {
        return ANIMATIONS;
    }

}
