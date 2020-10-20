package com.turtledove.withernauts.server.entity.Spiral_Draco;
import com.turtledove.withernauts.server.entity.EntityNecropolisFireCharge;

import com.google.common.base.Predicates;
import com.turtledove.withernauts.server.entity.NecropolisEntity;
import com.turtledove.withernauts.server.entity.NecropolisMultiPart;
import  com.turtledove.withernauts.server.ai.Spiral_DracoChargeTargetAI;
import  com.turtledove.withernauts.server.ai.AnimationAggroAI;

import javax.annotation.Nullable;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.world.storage.loot.LootTableList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import net.ilexiconn.llibrary.server.entity.multipart.IMultipartEntity;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;


public class EntitySpiral_Draco extends NecropolisEntity implements IMultipartEntity
{
    private static final Logger LOGGER = LogManager.getLogger();

    public NecropolisMultiPart[] spiral_dracoPartArray;
    public NecropolisMultiPart spiral_dracoPartFRLeg = new NecropolisMultiPart(this, 2F, -45, 0.0F, 1F, 4F, 0.5F);
    public NecropolisMultiPart spiral_dracoPartFLLeg = new NecropolisMultiPart(this, 2F, 45, 0.0F, 1F, 4F, 0.5F);

    private boolean isModelDead;
    protected float maxDistanceForPlayer;
    private boolean LisBreathingFire;

    private int castingTick;

    private float biteRadius;
    private float breathRadius;
    private float tailSwipeRadius;

    private static final DataParameter<Boolean> MODEL_DEAD = EntityDataManager.createKey(EntitySpiral_Draco.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> ACTIVE = EntityDataManager.createKey(EntitySpiral_Draco.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> L_FIREBREATHING = EntityDataManager.createKey(EntitySpiral_Draco.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> R_FIREBREATHING = EntityDataManager.createKey(EntitySpiral_Draco.class, DataSerializers.BOOLEAN);

    public static final Animation AGGRO_ANIMATION = Animation.create(45);
    public static final Animation DEAGGRO_ANIMATION = Animation.create(15);
    public static final Animation L_BREATHING_ANIMATION = Animation.create(45);
    private static final Animation[] ANIMATIONS = {AGGRO_ANIMATION,DEAGGRO_ANIMATION};

    public EntitySpiral_Draco(World worldIn)
    {
        super(worldIn);
        this.spiral_dracoPartArray = new NecropolisMultiPart[] {this.spiral_dracoPartFRLeg,this.spiral_dracoPartFLLeg};
        this.isBoss = true;
        this.setHealth(this.getMaxHealth());
        this.setSize(1F, 1F);
        this.noClip = false;
        this.isImmuneToFire = true;
        this.ignoreFrustumCheck = true;
        this.active = false;
        this.hitbyarrow = false;
        this.maxDistanceForPlayer = 80.0F;
        this.breathRadius = 20.0F;
        this.biteRadius = 10.0F;
        this.castingTick = 0;
        LisBreathingFire = false;
    }

    protected void initEntityAI()
    {
        tasks.addTask(1, new AnimationAggroAI<>(this, AGGRO_ANIMATION));
        tasks.addTask(1, new AnimationAggroAI<>(this, DEAGGRO_ANIMATION));
        tasks.addTask(1, new AnimationAggroAI<>(this, DEAGGRO_ANIMATION));
        tasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, 0, true, false, null));
        tasks.addTask(2, new EntityAIAttackMelee(this, 1, true));
        tasks.addTask(2, new Spiral_DracoChargeTargetAI(this, EntityPlayer.class, maxDistanceForPlayer, 0.6F));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0);
    }

    protected void entityInit()
    {
        super.entityInit();
        getDataManager().register(ACTIVE, false);
        getDataManager().register(L_FIREBREATHING,false);
        getDataManager().register(R_FIREBREATHING,false);
        getDataManager().register(MODEL_DEAD, false);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        updateParts();
        if (this.world.isRemote)
        {
            this.setHealth(this.getHealth());
        }
        if (this.getHealth() <= 0.0F)
        {
            float f12 = (this.rand.nextFloat() - 0.5F) * 8.0F;
            float f13 = (this.rand.nextFloat() - 0.5F) * 4.0F;
            float f15 = (this.rand.nextFloat() - 0.5F) * 8.0F;
            this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX + (double)f12, this.posY + 2.0D + (double)f13, this.posZ + (double)f15, 0.0D, 0.0D, 0.0D);
        }
        else
        {
            if (!this.world.isRemote)
            {
                if (isActive() == false)
                {
                    if (getAnimation() == NO_ANIMATION && !isAIDisabled())
                    {
                        Entity closestEntity = this.world.getClosestPlayer(this.posX, this.posY, this.posZ, (double)maxDistanceForPlayer, Predicates.and(EntitySelectors.CAN_AI_TARGET, EntitySelectors.notRiding(this)));
                        if (closestEntity != null)
                        {
                            AnimationHandler.INSTANCE.sendAnimationMessage(this, AGGRO_ANIMATION);
                            setActive(true);
                            this.active = true;
                        }
                    }
                }
                else
                {
                    Entity closestEntity = this.world.getClosestPlayer(this.posX, this.posY, this.posZ, (double)maxDistanceForPlayer, Predicates.and(EntitySelectors.CAN_AI_TARGET, EntitySelectors.notRiding(this)));
                    if (closestEntity == null)
                    {
                        AnimationHandler.INSTANCE.sendAnimationMessage(this, NO_ANIMATION);
                        this.active = false;
                        castingTick = 0;
                        setActive(false);
                    }
                    else
                    {
                        Vec3d playerPos = worldToDraco(closestEntity);
                        if (isInRange(playerPos,breathRadius) && !isInRange(playerPos,biteRadius))
                        {
                            if (playerPos.x <=0 && playerPos.z > -4)
                            {
                                AnimationHandler.INSTANCE.sendAnimationMessage(this, L_BREATHING_ANIMATION);
                                this.dataManager.set(L_FIREBREATHING, true);

                                if (!world.isRemote)
                                {
                                    this.LisBreathingFire = true;
                                    Vec3d headVec = this.getHeadPosition(0);
                                    double d2 = closestEntity.posX - headVec.x;
                                    double d3 = closestEntity.posY - headVec.y;
                                    double d4 = closestEntity.posZ - headVec.z;
                                    float inaccuracy = 1.0F;
                                    d2 = d2 + this.rand.nextGaussian() * 0.007499999832361937D * (double) inaccuracy;
                                    d3 = d3 + this.rand.nextGaussian() * 0.007499999832361937D * (double) inaccuracy;
                                    d4 = d4 + this.rand.nextGaussian() * 0.007499999832361937D * (double) inaccuracy;
                                    EntityNecropolisFireCharge entitylargefireball = new EntityNecropolisFireCharge(world, this, d2, d3, d4);
                                    float size = 1.3F;
                                    entitylargefireball.setSizes(size, size);
                                    entitylargefireball.setPosition(headVec.x, headVec.y, headVec.z);
                                    world.spawnEntity(entitylargefireball);
                                    if (castingTick == 0)
                                    {
                                        //EntityCast entityFireCast = new EntityCast(this.player, 100, 1);
                                        //world.spawnEntity(entityFireCast);
                                        castingTick++;
                                    }
                                    else if (castingTick >= 100)
                                    {
                                        castingTick = 0;
                                    }
                                    else
                                    {
                                        castingTick++;
                                    }

                                    if (closestEntity.isDead || closestEntity == null)
                                    {
                                        AnimationHandler.INSTANCE.sendAnimationMessage(this, NO_ANIMATION);
                                        this.dataManager.set(L_FIREBREATHING, false);
                                    }
                                }
                            }
                        }
                    }
                }
                this.collideWithEntities(this.world.getEntitiesWithinAABBExcludingEntity(this, this.spiral_dracoPartFRLeg.getEntityBoundingBox().grow(1.0D)));
                this.collideWithEntities(this.world.getEntitiesWithinAABBExcludingEntity(this, this.spiral_dracoPartFLLeg.getEntityBoundingBox().grow(1.0D)));
            }
        }
    }

    public void updateParts()
    {
        if (spiral_dracoPartFRLeg != null)
        {
            spiral_dracoPartFRLeg.onUpdate();
        }
        if (spiral_dracoPartFLLeg != null)
        {
            spiral_dracoPartFLLeg.onUpdate();
        }
    }
    /*Gets the position of the player relative to the draco, */
    public Vec3d worldToDraco(Entity entityIn)
    {
        Vec3d player_dracoSpace_translated = new Vec3d(entityIn.posX - this.posX,entityIn.posY - this.posY,entityIn.posZ - this.posZ);
        float draco_angle = this.rotationYaw * 0.0174533F;
        float t_sin = MathHelper.sin(draco_angle);
        float t_cos = MathHelper.cos(draco_angle);
        Vec3d player_dracoSpace_rotated = new Vec3d(player_dracoSpace_translated.x * t_cos + player_dracoSpace_translated.z * t_sin, player_dracoSpace_translated.y,-player_dracoSpace_translated.x * t_sin + player_dracoSpace_translated.z * t_cos);
        return player_dracoSpace_rotated;
    }
    public Vec3d DracoToWorld(Vec3d vecIn)
    {
        float draco_angle = this.rotationYaw * 0.0174533F;
        float t_sin = MathHelper.sin(draco_angle);
        float t_cos = MathHelper.cos(draco_angle);
        Vec3d player_dracoSpace_rotated = new Vec3d(vecIn.x * t_cos - vecIn.z * t_sin + this.posX, vecIn.y + this.posY,vecIn.x * t_sin + vecIn.z * t_cos + this.posZ);
        return player_dracoSpace_rotated;
    }
    /*Gets the position of the player relative to the draco, and returns whether it is in range of the dracos' breath. Makes no distinction between left or right. */
    public boolean isInRange(Vec3d player, float range)
    {
        double dist = player.x * player.x + player.z * player.z;
        if (dist < (double)(range * range))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //0 is left, 1 is 2, 3 is right
    protected Vec3d getHeadPosition(int flag)
    {
        Vec3d transl = new Vec3d(-5.5D, 7.5D,0.0D);
        Vec3d cofbasis = DracoToWorld(transl);
        return cofbasis;
    }

    /**
     * Pushes all entities inside the list away from the enderdragon.
     */
    private void collideWithEntities(List<Entity> p_70970_1_)
    {
        double FR_leg_1 = (this.spiral_dracoPartFRLeg.getEntityBoundingBox().minX + this.spiral_dracoPartFRLeg.getEntityBoundingBox().maxX) / 2.0D;
        double FR_leg_2 = (this.spiral_dracoPartFRLeg.getEntityBoundingBox().minZ + this.spiral_dracoPartFRLeg.getEntityBoundingBox().maxZ) / 2.0D;

        double FL_leg_1 = (this.spiral_dracoPartFLLeg.getEntityBoundingBox().minX + this.spiral_dracoPartFLLeg.getEntityBoundingBox().maxX) / 2.0D;
        double FL_leg_2 = (this.spiral_dracoPartFLLeg.getEntityBoundingBox().minZ + this.spiral_dracoPartFLLeg.getEntityBoundingBox().maxZ) / 2.0D;

        for (Entity entity : p_70970_1_)
        {
            if (entity instanceof EntityLivingBase)
            {
                double d2 = entity.posX - FR_leg_1;
                double d3 = entity.posZ - FR_leg_2;
                double d4 = d2 * d2 + d3 * d3;
                entity.addVelocity(d2 / d4 * 4.0D, 0.20000000298023224D, d3 / d4 * 4.0D);

                entity.attackEntityFrom(DamageSource.causeMobDamage(this), 20.0F);
            }
        }

        for (Entity entity : p_70970_1_)
        {
            if (entity instanceof EntityLivingBase)
            {
                double d2 = entity.posX - FL_leg_1;
                double d3 = entity.posZ - FL_leg_2;
                double d4 = d2 * d2 + d3 * d3;
                entity.addVelocity(d2 / d4 * 4.0D, 0.20000000298023224D, d3 / d4 * 4.0D);
                entity.attackEntityFrom(DamageSource.causeMobDamage(this), 20.0F);
            }
        }
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (source.getTrueSource() instanceof EntityPlayer)
        {
            if (source.getDamageType() == "arrow" && this.active == true)
            {
                targetofmyrevenge = source.getTrueSource();
                hitbyarrow = true;
            }
            return super.attackEntityFrom(source, amount);
        }
        return false;
    }

    /**
     * Called by the /kill command.
     */
    public void onKillCommand()
    {
        this.setDead();
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
    }

    /**
     * Makes the entity despawn if requirements are reached
     */
    protected void despawnEntity()
    {
    }
    public boolean isPart(Entity entityHit)
    {
        for (Entity element:this.spiral_dracoPartArray)
        {
            if (element == entityHit)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Return the Entity parts making up this Entity (currently only for dragons)
     */
    public Entity[] getParts()
    {
        return this.spiral_dracoPartArray;
    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    public boolean canBeCollidedWith()
    {
        return false;
    }

    public World getWorld()
    {
        return this.world;
    }

    public SoundCategory getSoundCategory()
    {
        return SoundCategory.HOSTILE;
    }

    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_ENDERDRAGON_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_ENDERDRAGON_HURT;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 3.0F;
    }

    @Nullable
    protected ResourceLocation getLootTable()
    {
        return LootTableList.ENTITIES_ENDER_DRAGON;
    }

    public void notifyDataManagerChange(DataParameter<?> key)
    {
        super.notifyDataManagerChange(key);
    }

    /**
     * adds a PotionEffect to the entity
     */
    public void addPotionEffect(PotionEffect potioneffectIn)
    {
    }

    protected boolean canBeRidden(Entity entityIn)
    {
        return false;
    }

    /**
     * Returns false if this Entity is a boss, true otherwise.
     */
    public boolean isNonBoss()
    {
        return false;
    }
    public boolean isModelDead()
    {
        if (world.isRemote) {
            return this.isModelDead = Boolean.valueOf(this.dataManager.get(MODEL_DEAD).booleanValue());
        }
        return isModelDead;
    }
    public float getEyeHeight()
    {
        return 0.65F;
    }
    @Override
    public Animation[] getAnimations() {
        return ANIMATIONS;
    }
    public boolean isActive() {
        return getDataManager().get(ACTIVE);
    }
    public void setActive(boolean isActive) {
        getDataManager().set(ACTIVE, isActive);
    }
}