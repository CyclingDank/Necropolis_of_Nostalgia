package com.turtledove.withernauts.server.entity.enemies;

import com.google.common.base.Predicates;
import com.turtledove.withernauts.server.ai.*;
import com.turtledove.withernauts.server.entity.NecropolisEntity;
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
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

import javax.annotation.Nullable;

public class EntityCultSorceress extends NecropolisEntity
{
    public static final Animation FIRSTAID_CAST_ANIMATION = Animation.create(90);
    public static final Animation PHOTON_CAST_ANIMATION = Animation.create(50);

    public static final Animation STRIKE_ANIMATION = Animation.create(15);

    public static final Animation HURT_ANIMATION = Animation.create(20);


    private static final Animation[] ANIMATIONS = {PHOTON_CAST_ANIMATION, FIRSTAID_CAST_ANIMATION, HURT_ANIMATION, STRIKE_ANIMATION};
    private double distToPlayer;
    private int maxDistanceForPlayer;
    private int castCooldown;
    private int jabCooldown;
    private boolean isHurt;
    private boolean canCast;


    public EntityCultSorceress(World worldin)
    {
        super(worldin);
        setPathPriority(PathNodeType.WATER, 0);
        this.setSize(0.7F, 1.7F);
        this.active = true;
        this.isImmuneToFire = false;
        this.targetofmyrevenge = null;
        this.struckwhileGuarding = false;
        this.maxDistanceForPlayer = 30;
        this.distToPlayer = 10;
        this.isHurt = false;

        this.canCast = false;

        this.castCooldown = 0;
        this.jabCooldown = 0;

        this.defense = 3;
        this.sDefense = 6;
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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0);
    }
    public void setCastState(boolean cond)
    {
        this.canCast = cond;
    }
    public void setHurt(boolean cond)
    {
        this.isHurt = cond;
    }
    public boolean isHurt()
    {
        return this.isHurt;
    }
    protected void entityInit()
    {
        super.entityInit();
    }
    @Override
    protected void initEntityAI()
    {
        this.distToPlayer = 10;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new AnimationCSStrikeAI<>(this, STRIKE_ANIMATION));
        this.tasks.addTask(1, new AnimationCSPhotonCastAI<>(this, PHOTON_CAST_ANIMATION));
        this.tasks.addTask(1, new AnimationFirstAidCast<>(this, FIRSTAID_CAST_ANIMATION));
        this.tasks.addTask(1, new AnimationGenericAI<>(this, HURT_ANIMATION));


        this.tasks.addTask(1, new EntityAIRetreat(this, 0.3D, this.distToPlayer));
        this.tasks.addTask(6, new EntityAIOccupyVillage(this, 0.1875D));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 0.1875D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 2.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));    }
    @Override
    public void onUpdate()
    {
        super.onUpdate();
        if (!this.world.isRemote)
        {
            Entity closestEntity = this.world.getClosestPlayer(this.posX, this.posY, this.posZ, (double) maxDistanceForPlayer, Predicates.and(EntitySelectors.CAN_AI_TARGET, EntitySelectors.notRiding(this)));

            if (closestEntity != null && closestEntity.isEntityAlive())
            {
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

                    if (getAnimation() == PHOTON_CAST_ANIMATION)
                    {
                        this.getLookHelper().setLookPositionWithEntity(this.targetofmyrevenge,90.0F, 90.0F);
                        this.getNavigator().tryMoveToEntityLiving(this.targetofmyrevenge, 0.05D);
                    }

                    if (canCast)
                    {
                        if (getAnimation() == NO_ANIMATION && this.castCooldown > 10)
                        {
                            if (Math.random() < 0.4)
                            {
                                if (this.getHealth() < this.getMaxHealth() * 0.7)
                                    AnimationHandler.INSTANCE.sendAnimationMessage(this, FIRSTAID_CAST_ANIMATION);
                                else
                                    AnimationHandler.INSTANCE.sendAnimationMessage(this, PHOTON_CAST_ANIMATION);
                            }
                            else
                                AnimationHandler.INSTANCE.sendAnimationMessage(this, PHOTON_CAST_ANIMATION);
                            this.castCooldown = 0;
                        }
                        else if (getAnimation() == NO_ANIMATION && this.castCooldown <= 10)
                        {
                            if (dist <= 2)
                            {
                                if (this.jabCooldown > 30)
                                {
                                    AnimationHandler.INSTANCE.sendAnimationMessage(this, STRIKE_ANIMATION);
                                    this.jabCooldown = 0;
                                }
                            }
                        }
                        if (getAnimation() == NO_ANIMATION || getAnimation() == STRIKE_ANIMATION)
                        {
                            this.castCooldown++;
                            this.jabCooldown++;
                        }
                    }
                }
            }
            else
            {
                this.targetofmyrevenge = null;
                this.active = false;
                this.castCooldown = 0;
                this.jabCooldown = 0;
            }
        }
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (!this.world.isRemote)
        {
            if ((source.getDamageType() == "melee") || source.getDamageType() == "arte" || source.getDamageType() == "physical_artes")
            {
                if (castCooldown > 5)
                {
                    this.isHurt = true;
                }

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
                this.dropExperience(16);
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
}
