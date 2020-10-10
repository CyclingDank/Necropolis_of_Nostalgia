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

public class EntityBedrockGolem extends NecropolisEntity
{
    public static final Animation PUNCH_ANIMATION = Animation.create(17);
    public static final Animation STAB_ANIMATION = Animation.create(14);
    public static final Animation STAB_STAB_ANIMATION = Animation.create(30);

    public static final Animation SWIPE_ANIMATION = Animation.create(17);
    public static final Animation GROUND_ANIMATION = Animation.create(87);
    public static final Animation STOMP_ANIMATION = Animation.create(47);
    public static final Animation PUNCH_SWIPE_ANIMATION = Animation.create(24);

    public static final Animation HURT_ANIMATION = Animation.create(5);


    private int attack_cooldown;

    private static final Animation[] ANIMATIONS = {PUNCH_ANIMATION, GROUND_ANIMATION, SWIPE_ANIMATION, PUNCH_SWIPE_ANIMATION, STOMP_ANIMATION, STAB_ANIMATION, STAB_STAB_ANIMATION, HURT_ANIMATION};
    private int maxDistanceForPlayer;



    public EntityBedrockGolem(World worldin) {
        super(worldin);
        this.setSize(0.7F, 1.7F);
        this.active = true;
        this.isImmuneToFire = true;

        this.defense = 25;
        this.sDefense = 20;

        this.maxDistanceForPlayer = 20;


        this.elementWeakness[1] = -1;
        this.elementWeakness[2] = 1;
        this.elementWeakness[3] = -1;
        this.elementWeakness[4] = -1;
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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200.0D);
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
        this.tasks.addTask(1, new AnimationBGPunchAI<>(this, PUNCH_ANIMATION));
        this.tasks.addTask(1, new AnimationBGSwipeAI<>(this, SWIPE_ANIMATION));
        this.tasks.addTask(1, new AnimationBGGroundAI<>(this, GROUND_ANIMATION));
        this.tasks.addTask(1, new AnimationBGPunchSwipeAI<>(this, PUNCH_SWIPE_ANIMATION));
        this.tasks.addTask(1, new AnimationBGStompAI<>(this, STOMP_ANIMATION));
        this.tasks.addTask(1, new AnimationBGStabAI<>(this, STAB_ANIMATION));
        this.tasks.addTask(1, new AnimationBGStabStabAI<>(this, STAB_STAB_ANIMATION));
        this.tasks.addTask(1, new AnimationGenericAI<>(this, HURT_ANIMATION));


        this.tasks.addTask(2, new EntityAIFaceOff(this,0.15D, 5));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 0.15D));
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
            for (int i = 0; i < 2; ++i)
            {
                this.world.spawnParticle(EnumParticleTypes.PORTAL, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
            }
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
                        if (getAnimation() == NO_ANIMATION || (getAnimation() == STAB_STAB_ANIMATION && (getAnimationTick() > 15 && getAnimationTick() < 23)))
                        {
                            double speed = 0.05D;
                            this.getNavigator().tryMoveToEntityLiving(this.targetofmyrevenge, speed);
                            this.getLookHelper().setLookPositionWithEntity(this.targetofmyrevenge,90.0F, 90.0F);
                        }
                        else
                        {
                            this.getNavigator().clearPath();
                        }
                    }

                    if (dist <= 5)
                    {
                        if (this.getAnimation() == NO_ANIMATION)
                        {
                            double tRand = Math.random();
                            if (dist > 3)
                            {
                                if (this.attack_cooldown > 4)
                                {
                                    if (tRand < 0.2)
                                        AnimationHandler.INSTANCE.sendAnimationMessage(this, PUNCH_ANIMATION);
                                    else if (tRand < 0.5)
                                        AnimationHandler.INSTANCE.sendAnimationMessage(this, SWIPE_ANIMATION);
                                    else if (tRand < 0.9)
                                        AnimationHandler.INSTANCE.sendAnimationMessage(this, PUNCH_SWIPE_ANIMATION);
                                    else
                                        AnimationHandler.INSTANCE.sendAnimationMessage(this, GROUND_ANIMATION);
                                }

                            }
                            else
                            {
                                if (this.attack_cooldown > 4)
                                {
                                    if (tRand < 0.1)
                                    {
                                        AnimationHandler.INSTANCE.sendAnimationMessage(this, GROUND_ANIMATION);
                                        this.attack_cooldown = 5;
                                    }
                                    else if (tRand < 0.3)
                                    {
                                        AnimationHandler.INSTANCE.sendAnimationMessage(this, STOMP_ANIMATION);
                                        this.attack_cooldown = 5;
                                    }
                                    else if (tRand < 0.6)
                                    {
                                        AnimationHandler.INSTANCE.sendAnimationMessage(this, STAB_STAB_ANIMATION);
                                        this.attack_cooldown = -10;
                                    }
                                    else
                                    {
                                        AnimationHandler.INSTANCE.sendAnimationMessage(this, STAB_ANIMATION);
                                        this.attack_cooldown = -10;
                                    }
                                }
                            }
                            attack_cooldown++;
                        }
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
                this.playSound(SoundEvents.ENTITY_ENDERMITE_HURT, 1.0F, 1.0F);
                this.playSound(SoundEvents.ENTITY_IRONGOLEM_HURT, 0.7F, 0.7F);

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
                this.playSound(SoundEvents.ENTITY_ENDERMITE_DEATH, 1.0F, 0.7F);
                this.playSound(SoundEvents.ENTITY_IRONGOLEM_DEATH, 0.7F, 0.7F);

                this.entityDropItem(new ItemStack(Items.DIAMOND, 1, 0), 0.0F);
            }
        }
    }
    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_ENDERMITE_AMBIENT;
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_IRONGOLEM_STEP, 0.8F, 1.0F);
    }
    @Override
    public Animation[] getAnimations()
    {
        return ANIMATIONS;
    }

}
