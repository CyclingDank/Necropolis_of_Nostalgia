package com.turtledove.necropolisofnostalgia.entity.enemies;

import com.google.common.base.Predicates;
import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.ai.*;
import com.turtledove.necropolisofnostalgia.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.sound.NecropolisSounds;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

import javax.annotation.Nullable;

public class EntityAxeBeak extends NecropolisEntity
{
    public static final Animation LEAP_ANIMATION = Animation.create(40);
    public static final Animation JAB_ANIMATION = Animation.create(29);
    public static final Animation HURT_ANIMATION = Animation.create(5);
    public static final Animation RUSH_ANIMATION = Animation.create(13);
    public static final Animation EAT_ANIMATION = Animation.create(100);

    private static final Animation[] ANIMATIONS = {JAB_ANIMATION, LEAP_ANIMATION, HURT_ANIMATION, RUSH_ANIMATION, EAT_ANIMATION};
    private double distToPlayer;
    private int maxDistanceForPlayer;

    private int jabAttempts;
    private int leapStrikeCooldown;
    private int jabStrikeCooldown;

    private boolean isAggro;


    public EntityAxeBeak(World worldin)
    {
        super(worldin);
        setPathPriority(PathNodeType.WATER, 0);
        this.setSize(0.7F, 1.7F);
        this.active = true;
        this.isImmuneToFire = false;
        this.targetofmyrevenge = null;
        this.struckwhileGuarding = false;
        this.maxDistanceForPlayer = 20;
        this.distToPlayer = 3;
        this.leapStrikeCooldown = 0;
        this.jabAttempts = 0;
        this.jabStrikeCooldown = 0;
        this.isAggro = false;

        this.defense = 4;
        this.sDefense = 4;
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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(Necropolis_of_Nostalgia.CONFIG.axebeakMaxHealth);
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
        this.distToPlayer = 3;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new AnimationABRushAI<>(this, RUSH_ANIMATION));
        this.tasks.addTask(1, new AnimationABJabAI<>(this, JAB_ANIMATION));
        this.tasks.addTask(1, new AnimationABLeapAI<>(this, LEAP_ANIMATION));
        this.tasks.addTask(1, new AnimationGenericAI<>(this, HURT_ANIMATION));
        this.tasks.addTask(1, new AnimationABEatAI<>(this, EAT_ANIMATION));
        this.tasks.addTask(2, new EntityAIFaceOff(this,0.375D, this.distToPlayer));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 0.1875D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 2.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }
    @Override
    public void onUpdate()
    {
        super.onUpdate();
        if (!this.world.isRemote)
        {
            Entity closestEntity = this.world.getClosestPlayer(this.posX, this.posY, this.posZ, (double)maxDistanceForPlayer, Predicates.and(EntitySelectors.CAN_AI_TARGET, EntitySelectors.notRiding(this)));

            if (closestEntity != null && closestEntity.isEntityAlive())
            {
                if (isAggro == false)
                {
                    this.targetofmyrevenge = null;
                    this.active = false;
                    if ((this.isValidLightLevel() && this.canEntityBeSeen(closestEntity)) || this.isRaidMob == true)
                        this.isAggro = true;
                    else
                        return;
                }
                if (this.targetofmyrevenge == null)
                    this.playSound(NecropolisSounds.AB_ANGRY, 1.0f, 0.75f);
                this.targetofmyrevenge = (EntityPlayer)closestEntity;
                this.active = true;

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

                    if (dist < distToPlayer)
                    {
                        if (getAnimation() == NO_ANIMATION)
                        {
                            this.getNavigator().tryMoveToEntityLiving(this.targetofmyrevenge, 0.05D);
                            this.getLookHelper().setLookPositionWithEntity(this.targetofmyrevenge,90.0F, 90.0F);
                        }
                        else
                        {
                            this.getNavigator().clearPath();
                        }

                        if (dist >= 2.5)
                        {
                            if (getAnimation() == NO_ANIMATION && this.leapStrikeCooldown > 5)
                            {
                                if (Math.random() < 0.4)
                                {
                                    AnimationHandler.INSTANCE.sendAnimationMessage(this, RUSH_ANIMATION);
                                }
                                else
                                    AnimationHandler.INSTANCE.sendAnimationMessage(this, LEAP_ANIMATION);
                                this.leapStrikeCooldown = 0;
                            }
                        }
                        else if (dist < 2.5)
                        {
                            if (getAnimation() == NO_ANIMATION && this.jabAttempts < 2 && this.jabStrikeCooldown >= 5)
                            {
                                AnimationHandler.INSTANCE.sendAnimationMessage(this, JAB_ANIMATION);
                                this.jabAttempts++;
                                this.jabStrikeCooldown = 0;
                            }
                            if (jabAttempts > 1)
                            {
                                if (getAnimation() == NO_ANIMATION)
                                {
                                    AnimationHandler.INSTANCE.sendAnimationMessage(this, LEAP_ANIMATION);
                                    this.leapStrikeCooldown = 0;
                                    this.jabAttempts = 0;
                                }
                            }
                        }
                        if (getAnimation() == NO_ANIMATION)
                        {
                            this.leapStrikeCooldown++;
                            this.jabStrikeCooldown++;
                        }
                    }
                }
            }
            else
            {
                this.targetofmyrevenge = null;
                this.active = false;
                this.leapStrikeCooldown = 0;
                this.jabStrikeCooldown = 0;
                this.isAggro = false;
            }
        }
    }

    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack itemstack = player.getHeldItem(hand);
        if (!itemstack.isEmpty() && this.isAggro == false && !this.world.isRemote)
        {
            if (itemstack.getItem() instanceof ItemFood && this.getAnimation() == NO_ANIMATION)
            {
                ItemFood itemfood = (ItemFood) itemstack.getItem();
                if (itemfood.isWolfsFavoriteMeat())
                {
                    if (!player.capabilities.isCreativeMode)
                    {
                        itemstack.shrink(1);
                    }
                    this.heal(this.getMaxHealth());
                    AnimationHandler.INSTANCE.sendAnimationMessage(this, EAT_ANIMATION);
                    return true;
                }
            }
        }
        return super.processInteract(player, hand);
    }

    public void setAggroLevel(boolean val)
    {
        this.isAggro = val;
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (!this.world.isRemote)
        {
            if (source.equals(DamageSource.FALL))
                return false;
            if (source.getDamageType() == "melee" || source.getTrueSource() instanceof EntityPlayer)
                this.isAggro = true;
            if (getAnimation() == NO_ANIMATION)
            {
                AnimationHandler.INSTANCE.sendAnimationMessage(this, HURT_ANIMATION);
                this.playSound(NecropolisSounds.AB_GRUNT, 0.5f, 1.0f);
                this.leapStrikeCooldown = 0;
                this.jabStrikeCooldown = 0;

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
                this.entityDropItem(new ItemStack(Items.FEATHER, 5, 0), 0.0F);
                this.entityDropItem(new ItemStack(Items.CHICKEN, 1, 0), 0.0F);
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
        return LootTableList.ENTITIES_CHICKEN;
    }

    protected SoundEvent getAmbientSound()
    {
        return NecropolisSounds.AB_GRUNT;
    }


    protected SoundEvent getStepSound()
    {
        return SoundEvents.ENTITY_COW_STEP;
    }
}
