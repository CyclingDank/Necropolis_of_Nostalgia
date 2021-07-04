package com.turtledove.necropolisofnostalgia.server.entity.enemies;

import com.google.common.base.Predicates;
import com.turtledove.necropolisofnostalgia.server.ai.*;
import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

import javax.annotation.Nullable;

public class EntityNecropolisSpider extends NecropolisEntity
{
    public static final Animation HANG_ANIMATION = Animation.create(5);
    public static final Animation RAMPAGE_ANIMATION = Animation.create(10);
    public static final Animation REAR_JAB_ANIMATION = Animation.create(26);
    public static final Animation LEAP_ANIMATION = Animation.create(18);
    public static final Animation HURT_ANIMATION = Animation.create(5);


    private static final Animation[] ANIMATIONS = {HANG_ANIMATION, RAMPAGE_ANIMATION, REAR_JAB_ANIMATION, LEAP_ANIMATION, HURT_ANIMATION};
    private int maxDistanceForPlayer;

    private BlockPos hangPos;

    private boolean isHanging;
    private int hangProgress;

    public boolean isAnimationEnded;

    private int attack_cooldown;

    private boolean laidEggs;

    private static final DataParameter<Byte> CLIMBING = EntityDataManager.<Byte>createKey(EntityNecropolisSpider.class, DataSerializers.BYTE);


    public EntityNecropolisSpider(World worldin)
    {
        super(worldin);
        setPathPriority(PathNodeType.WATER, 0);
        this.setSize(0.8F, 0.8F);
        this.active = true;
        this.isImmuneToFire = false;
        this.targetofmyrevenge = null;
        this.struckwhileGuarding = false;
        this.maxDistanceForPlayer = 20;

        this.isHanging = false;
        this.hangProgress = 0;

        this.laidEggs = false;

        this.defense = 11;
        this.sDefense = 10;
        this.attack_cooldown = 0;

        this.isAnimationEnded = false;

        this.elementWeakness[1] = 1;
        this.elementWeakness[4] = -1;
        this.elementWeakness[6] = -1;
        this.elementWeakness[7] = 1;

        this.setFoeType(1);
    }

    @Override
    public boolean isCreatureType(EnumCreatureType type, boolean forSpawnCount) {
        if (forSpawnCount && isNoDespawnRequired()) return false;
        return type == EnumCreatureType.MONSTER;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setBoolean("laidEggs", this.laidEggs);
    }
    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.laidEggs = compound.getBoolean("laidEggs");
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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(120.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0);
    }
    protected void entityInit()
    {
        super.entityInit();
        this.setSize(0.8F, 0.8F);
        this.dataManager.register(CLIMBING, Byte.valueOf((byte)0));
    }
    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new AnimationGenericAI<>(this, HANG_ANIMATION));
        this.tasks.addTask(1, new AnimationGenericAI<>(this, HURT_ANIMATION));
        this.tasks.addTask(1, new AnimationSpiderLeap<>(this, LEAP_ANIMATION));
        this.tasks.addTask(1, new AnimationSpiderRearJab<>(this, REAR_JAB_ANIMATION));
        this.tasks.addTask(1, new AnimationSpiderRampage<>(this, RAMPAGE_ANIMATION));
        this.tasks.addTask(2, new EntityAISpiderFaceOff(this,0.375D, 4));
    }
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.world.isRemote)
        {
            this.setBesideClimbableBlock(this.collidedHorizontally);
            Entity closestEntity = this.world.getClosestPlayer(this.posX, this.posY, this.posZ, (double) maxDistanceForPlayer, Predicates.and(EntitySelectors.CAN_AI_TARGET, EntitySelectors.notRiding(this)));

            if (closestEntity != null && closestEntity.isEntityAlive())
            {
                this.doSpiderLogic(closestEntity);
            }
            else if (this.isHanging == true)
            {
                AnimationHandler.INSTANCE.sendAnimationMessage(this, HANG_ANIMATION);

                if (this.hangProgress == 0)
                {
                    this.setNoGravity(true);
                    this.motionX = 0;
                    this.motionZ = 0;
                    this.motionY = 0.05D;
                    this.hangProgress++;
                }
                else
                {
                    if (this.getPosition().equals(hangPos))
                    {
                        this.motionX = 0;
                        this.motionZ = 0;
                        this.motionY = 0;

                        if (this.world.isAirBlock(this.hangPos.up()))
                        {
                            this.isHanging = false;
                            this.setNoGravity(false);
                            this.hangProgress = 0;
                        }
                    }
                    else
                    {
                        this.motionX = 0;
                        this.motionZ = 0;
                        this.motionY = 0.05D;
                        this.hangProgress++;
                    }
                }
            }
            else
            {
                this.targetofmyrevenge = null;
                this.active = false;
                this.getNavigator().clearPath();
                this.setNoGravity(false);

                this.attack_cooldown = 0;
                this.hangProgress = 0;

                if (this.isHanging == false)
                    this.isHanging = this.canHangHere();
            }
            this.isAnimationEnded = false;
        }
    }
    private void doSpiderLogic(Entity closestEntity)
    {
        this.targetofmyrevenge = (EntityPlayer) closestEntity;
        if (this.canEntityBeSeen(this.targetofmyrevenge))
        {
            float dist = this.getDistance(this.targetofmyrevenge);

            if (this.isHanging == true)
            {
                if (dist <= 4)
                {
                    if (this.laidEggs == false)
                    {

                        int numChilds = (int)(Math.random() * 3.0f + 2.0f);
                        for (int i = 0; i < numChilds; i++)
                        {
                            EntityBabyNecropolisSpider child_1 = new EntityBabyNecropolisSpider(this.world);
                            child_1.setPosition(this.posX, this.posY, this.posZ);
                            this.world.spawnEntity(child_1);
                        }
                    }
                    this.laidEggs = true;
                    this.setNoGravity(false);
                    this.hangProgress = 0;
                    this.isHanging = false;
                }
                else
                {
                    AnimationHandler.INSTANCE.sendAnimationMessage(this, HANG_ANIMATION);
                }
            }

            if (this.isInWater()) {
                double slopeX = (this.targetofmyrevenge.posX - this.posX) / 4.0D;
                double slopeZ = (this.targetofmyrevenge.posZ - this.posZ) / 4.0D;
                double numerator = Math.sqrt(slopeX * slopeX + slopeZ * slopeZ) * 10.0;
                this.motionX = slopeX * 0.75F / numerator;
                this.motionZ = slopeZ * 0.75F / numerator;
            }
            if (dist <= 4)
            {
                if (this.laidEggs == false)
                {

                    int numChilds = (int)(Math.random() * 3.0f + 2.0f);
                    for (int i = 0; i < numChilds; i++)
                    {
                        EntityBabyNecropolisSpider child_1 = new EntityBabyNecropolisSpider(this.world);
                        child_1.setPosition(this.posX, this.posY, this.posZ);
                        this.world.spawnEntity(child_1);
                    }
                }

                if (getAnimation() == NO_ANIMATION)
                {
                    double speed = 0.05D;
                    this.getNavigator().tryMoveToEntityLiving(this.targetofmyrevenge, speed);
                    this.getLookHelper().setLookPositionWithEntity(this.targetofmyrevenge,90.0F, 90.0F);
                }
                else
                {
                    this.getNavigator().clearPath();
                }

                if (getAnimation() == NO_ANIMATION && this.attack_cooldown > 4)
                {
                    double tRand = Math.random();
                    if (tRand < 0.2)
                        AnimationHandler.INSTANCE.sendAnimationMessage(this, RAMPAGE_ANIMATION);
                    else if (tRand < 0.6)
                        AnimationHandler.INSTANCE.sendAnimationMessage(this, LEAP_ANIMATION);
                    else
                        AnimationHandler.INSTANCE.sendAnimationMessage(this, REAR_JAB_ANIMATION);
                    this.attack_cooldown = 0;
                }
                this.laidEggs = true;
            }
            if (getAnimation() == NO_ANIMATION)
            {
                this.attack_cooldown++;
            }
        }
    }

    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (!this.world.isRemote)
        {
            if (getAnimation() == NO_ANIMATION)
            {
                AnimationHandler.INSTANCE.sendAnimationMessage(this, HURT_ANIMATION);
                this.playSound(NecropolisSounds.SPIDER_CRY, 0.5F, 1.0F);
                this.attack_cooldown = 0;
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
                this.entityDropItem(new ItemStack(Items.STRING, 12, 0), 0.0F);
            }
        }
    }

    protected PathNavigate createNavigator(World worldIn)
    {
        return new PathNavigateClimber(this, worldIn);
    }

    public boolean canHangHere()
    {
        //minimum height is 4, max is 8.
        int ceiling = 40;

        if (this.posY > ceiling - 4)
            return false;
        if (this.targetofmyrevenge != null)
            return false;
        int i = 0;
        for (i = 0; i < 8; i++)
        {
            if (!this.world.isAirBlock(this.getPosition().up(i)))
            {
                i -= 1;
                break;
            }
        }
        if (i < 4 || i == 8)
            return false;
        if (this.posY + i > ceiling)
            return false;
        this.hangPos = this.getPosition().up(i);
        return true;
    }

    public void setBesideClimbableBlock(boolean climbing)
    {
        byte b0 = ((Byte)this.dataManager.get(CLIMBING)).byteValue();

        if (climbing)
        {
            b0 = (byte)(b0 | 1);
        }
        else
        {
            b0 = (byte)(b0 & -2);
        }

        this.dataManager.set(CLIMBING, Byte.valueOf(b0));
    }


    public boolean isBesideClimbableBlock()
    {
        return (((Byte)this.dataManager.get(CLIMBING)).byteValue() & 1) != 0;
    }

    protected boolean canTriggerWalking()
    {
        return false;
    }

    public void fall(float distance, float damageMultiplier)
    {
    }

    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos)
    {
    }

    public boolean isOnLadder()
    {
        return this.isBesideClimbableBlock();
    }

    /**
     * Sets the Entity inside a web block.
     */
    public void setInWeb()
    {
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
        return NecropolisSounds.SPIDER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_SPIDER_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_SPIDER_DEATH;
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.5F, 1.0F);
    }

}
