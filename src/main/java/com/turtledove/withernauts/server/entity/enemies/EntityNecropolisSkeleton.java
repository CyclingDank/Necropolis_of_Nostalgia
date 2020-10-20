package com.turtledove.withernauts.server.entity.enemies;

import com.google.common.base.Predicates;
import com.turtledove.withernauts.server.ai.*;
import com.turtledove.withernauts.server.entity.NecropolisEntity;

import com.turtledove.withernauts.server.sounds.NecropolisSounds;
import net.ilexiconn.llibrary.server.animation.Animation;

import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

import javax.annotation.Nullable;

public class EntityNecropolisSkeleton extends NecropolisEntity
{
    public static final Animation RETALIATE_ANIMATION = Animation.create(67);
    public static final Animation SWING_ANIMATION = Animation.create(60);
    public static final Animation LEAP_ANIMATION = Animation.create(40);
    public static final Animation HURT_R_ANIMATION = Animation.create(5);
    public static final Animation HURT_L_ANIMATION = Animation.create(5);

    public static final Animation BLOCK_40_ANIMATION = Animation.create(45);
    public static final Animation BLOCK_80_ANIMATION = Animation.create(85);
    public static final Animation BLOCK_160_ANIMATION = Animation.create(165);

    private static final Animation[] ANIMATIONS = {RETALIATE_ANIMATION, SWING_ANIMATION, LEAP_ANIMATION, HURT_R_ANIMATION, HURT_L_ANIMATION, BLOCK_40_ANIMATION, BLOCK_80_ANIMATION, BLOCK_160_ANIMATION};


    protected float maxDistanceForPlayer;
    protected boolean isBlocking;
    protected boolean guard_broken;

    protected static int distToPlayer = 5;

    protected int guardCoolDown;
    protected int attackCoolDown;

    private double x,y,z;

    private static final DataParameter<Boolean> AGGRO = EntityDataManager.createKey(EntityNecropolisSkeleton.class, DataSerializers.BOOLEAN);

    public EntityNecropolisSkeleton(World worldin)
    {
        super(worldin);
        this.setSize(0.7F, 1.7F);
        this.active = true;
        this.isImmuneToFire = false;
        this.isBlocking = false;
        this.maxDistanceForPlayer = 20.0F;
        this.targetofmyrevenge = null;
        this.struckwhileGuarding = false;
        this.attackCoolDown = 0;

        this.elementWeakness[4] = -1;
        this.elementWeakness[6] = -1;
        this.elementWeakness[7] = 1;

        this.guard_broken = false;
        this.guardCoolDown = 0;

        this.defense = 5;
        this.sDefense = 3;

        this.needsDarkness = true;
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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0);
    }

    protected void entityInit()
    {
        super.entityInit();
        getDataManager().register(AGGRO, false);
    }

    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(1, new AnimationLeapStrikeAI<>(this, LEAP_ANIMATION));
        this.tasks.addTask(1, new AnimationSpinAttackAI<>(this, SWING_ANIMATION));
        this.tasks.addTask(1, new AnimationBlockAI<>(this, RETALIATE_ANIMATION));
        this.tasks.addTask(1, new AnimationGenericAI<>(this, HURT_R_ANIMATION));
        this.tasks.addTask(1, new AnimationGenericAI<>(this, HURT_L_ANIMATION));
        this.tasks.addTask(1, new AnimationGenericAI<>(this, BLOCK_40_ANIMATION));
        this.tasks.addTask(1, new AnimationGenericAI<>(this, BLOCK_80_ANIMATION));
        this.tasks.addTask(1, new AnimationGenericAI<>(this, BLOCK_160_ANIMATION));

        this.tasks.addTask(2, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIFaceOff(this,0.1875D, distToPlayer));
        this.tasks.addTask(3, new EntityAIWanderAvoidWater(this, 0.1875D));
        this.tasks.addTask(6, new EntityAIOccupyVillage(this, 0.1875D));
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
                setAggro(true);
                if (this.targetofmyrevenge == null && this.canEntityBeSeen(closestEntity))
                {
                    this.playSound(NecropolisSounds.SKELETON_DETECT,1.0F,1.0F);
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

                    if (dist <= distToPlayer)
                    {
                        if (getAnimation() == NO_ANIMATION || getAnimation() == BLOCK_40_ANIMATION || getAnimation() == BLOCK_80_ANIMATION || getAnimation() == BLOCK_160_ANIMATION)
                        {
                            double speed = 0.1875D;
                            if (dist < 2.0f)
                                speed = 0.01D;
                            this.getNavigator().tryMoveToEntityLiving(this.targetofmyrevenge, speed);
                            this.getLookHelper().setLookPositionWithEntity(this.targetofmyrevenge,90.0F, 90.0F);
                        }
                        else
                        {
                            this.getNavigator().clearPath();
                        }
                    }
                    if (dist <= distToPlayer &&  this.attackCoolDown >= 5 && getAnimation() == NO_ANIMATION)
                    {

                        if (dist >= distToPlayer - 1 && dist <= distToPlayer && this.canEntityBeSeen(this.targetofmyrevenge))
                        {
                            this.isBlocking = false;
                            double tRand = Math.random();
                            if (tRand < 0.4)
                            {
                                if (tRand < 0.1)
                                    AnimationHandler.INSTANCE.sendAnimationMessage(this, BLOCK_40_ANIMATION);
                                else if (tRand < 0.3)
                                    AnimationHandler.INSTANCE.sendAnimationMessage(this, BLOCK_80_ANIMATION);
                                else
                                    AnimationHandler.INSTANCE.sendAnimationMessage(this, BLOCK_160_ANIMATION);
                            }
                            else
                            {
                                AnimationHandler.INSTANCE.sendAnimationMessage(this, LEAP_ANIMATION);
                            }
                        }
                        else
                        {
                            this.isBlocking = false;

                            if (Math.random() < 0.3)
                            {
                                AnimationHandler.INSTANCE.sendAnimationMessage(this, BLOCK_80_ANIMATION);
                            }
                            else if (Math.random() < 0.6)
                            {
                                AnimationHandler.INSTANCE.sendAnimationMessage(this, RETALIATE_ANIMATION);
                            }
                            else
                            {
                                AnimationHandler.INSTANCE.sendAnimationMessage(this, SWING_ANIMATION);
                            }
                            this.attackCoolDown = 0;
                        }
                    }
                    if (getAnimation() == NO_ANIMATION)
                        this.attackCoolDown++;
                }
            }
            else
            {
                setAggro(false);
                this.targetofmyrevenge = null;
                this.active = false;
                this.isBlocking = false;
                this.attackCoolDown = 0;
            }
        }
    }

    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (!this.world.isRemote)
        {
            if (source.equals(DamageSource.DROWN))
                return false;
            if (getAnimation() == BLOCK_40_ANIMATION || getAnimation() == BLOCK_80_ANIMATION || getAnimation() == BLOCK_160_ANIMATION)
            {
                this.playSound(NecropolisSounds.GUARD_HIT, 1.0F, 1.0F);
                return false;
            }
            else if (getAnimation() == NO_ANIMATION)
            {
                this.playSound(NecropolisSounds.SKELETON_DETECT, 0.5f, 1.0f);
                this.attackCoolDown = 0;
                if (Math.random() < 0.5)
                {
                    AnimationHandler.INSTANCE.sendAnimationMessage(this, HURT_L_ANIMATION);
                }
                else
                {
                    AnimationHandler.INSTANCE.sendAnimationMessage(this, HURT_R_ANIMATION);
                }
            }
            return super.attackEntityFrom(source, Math.max(1.0f,amount));
        }
        else
        {
            return false;
        }
    }

    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource cause)
    {
        super.onDeath(cause);

        if (cause.getTrueSource() instanceof EntityCreeper)
        {
            EntityCreeper entitycreeper = (EntityCreeper)cause.getTrueSource();

            if (entitycreeper.getPowered() && entitycreeper.ableToCauseSkullDrop())
            {
                entitycreeper.incrementDroppedSkulls();
                this.entityDropItem(new ItemStack(Items.SKULL, 1, 0), 0.0F);
            }
        }
        else if ((cause.getDamageType() == "melee") || cause.getDamageType() == "arte" || cause.getDamageType() == "physical_artes")
        {
            if (!this.world.isRemote)
            {
                this.dropExperience(12);
                this.entityDropItem(new ItemStack(Items.BONE, 2, 0), 0.0F);
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
        return LootTableList.ENTITIES_SKELETON;
    }

    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_SKELETON_AMBIENT;
    }



    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_SKELETON_DEATH;
    }

    protected SoundEvent getStepSound()
    {
        return SoundEvents.ENTITY_SKELETON_STEP;
    }

    public void setAggro(boolean isActive)
    {
        getDataManager().set(AGGRO, isActive);
    }

    public boolean isAggro() {
        return getDataManager().get(AGGRO);
    }

}
