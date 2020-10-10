package com.turtledove.necropolisofnostalgia.server.entity.enemies;

import com.google.common.base.Predicates;
import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.server.ai.*;
import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.server.packets.Player.PlayerParticlePacket;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

import javax.annotation.Nullable;
import java.util.List;

public class EntityBabyNecropolisSpider extends NecropolisEntity
{
    private static final Animation[] ANIMATIONS = {};
    private int maxDistanceForPlayer;

    private static final DataParameter<Byte> CLIMBING = EntityDataManager.<Byte>createKey(EntityBabyNecropolisSpider.class, DataSerializers.BYTE);
    private static final DataParameter<Boolean> IGNITED = EntityDataManager.<Boolean>createKey(EntityBabyNecropolisSpider.class, DataSerializers.BOOLEAN);


    private int leapCooldown;
    public boolean startExplosion;
    private int explosionCount;

    private int igniteCount;

    public EntityBabyNecropolisSpider(World worldin)
    {
        super(worldin);
        setPathPriority(PathNodeType.WATER, 0);
        this.setSize(0.8F, 0.8F);
        this.active = true;
        this.isImmuneToFire = false;
        this.targetofmyrevenge = null;
        this.struckwhileGuarding = false;
        this.maxDistanceForPlayer = 20;

        this.defense = 20;
        this.sDefense = 20;

        this.elementWeakness[1] = 1;
        this.elementWeakness[4] = -1;
        this.elementWeakness[6] = -1;
        this.elementWeakness[7] = 1;

        this.leapCooldown = 21;
        this.startExplosion = false;
        this.explosionCount = 0;

        this.igniteCount = 0;

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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0);
    }
    protected void entityInit()
    {
        super.entityInit();
        this.setSize(0.8F, 0.8F);
        this.dataManager.register(CLIMBING, Byte.valueOf((byte)0));
        this.dataManager.register(IGNITED,Boolean.valueOf(false));
    }
    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAISpiderFaceOff(this,0.3f, 3));
    }
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.world.isRemote)
        {
            this.setBesideClimbableBlock(this.collidedHorizontally);
            Entity closestEntity = this.world.getClosestPlayer(this.posX, this.posY, this.posZ, (double) maxDistanceForPlayer, Predicates.and(EntitySelectors.CAN_AI_TARGET, EntitySelectors.notRiding(this)));

            if (startExplosion == true)
            {
                if (this.explosionCount > 50)
                {
                    List<Entity> swipeEnemies = this.world.getEntitiesWithinAABBExcludingEntity(this,  this.getEntityBoundingBox().expand(4.0,0.0,4.0).offset(-1.6D,0D,-1.6D));
                    if (!swipeEnemies.isEmpty()) {
                        for (Entity targ : swipeEnemies)
                        {
                            if (targ instanceof EntityPlayer)
                            {
                                targ.attackEntityFrom(DamageSource.causeMobDamage(this), 26.0f);
                                ((EntityPlayer) targ).addPotionEffect(new PotionEffect(MobEffects.POISON, 100));
                            }
                        }
                    }
                    for (int j = 0; j < 8 * 3; ++j)
                    {
                        float f = this.rand.nextFloat() * ((float)Math.PI * 2F);
                        float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
                        float f2 = MathHelper.sin(f) * 0.5F * 3.0F * f1;
                        float f3 = MathHelper.cos(f) * 0.5F * 3.0F * f1;
                        World world = this.world;

                        double d0 = this.posX + (double)f2;
                        double d1 = this.posZ + (double)f3;
                        Necropolis_of_Nostalgia.packetHandler.sendToAll(new PlayerParticlePacket(1,  d0, this.posY, d1, 0.0D, 0.0D, 0.0D));
                    }
                    this.playSound(NecropolisSounds.BABY_SPIDER_GONE, 1.0f, 1.0f);
                    this.setDead();
                    return;
                }
                else
                {
                    if (this.explosionCount % 10 == 0)
                        this.playSound(NecropolisSounds.BABY_SPIDER_GROW, 1.0f, 1.0f);
                    this.getNavigator().clearPath();
                    this.getLookHelper().setLookPosition(this.posX, this.posY, this.posZ, 30.0f, 30.0f);
                    this.targetofmyrevenge = null;
                    this.active = false;
                    this.motionX = 0;
                    this.motionZ = 0;
                    this.ignite();
                    this.explosionCount++;
                }
                return;
            }

            if (closestEntity != null && closestEntity.isEntityAlive())
            {
                this.targetofmyrevenge = closestEntity;
                this.active = true;
                if (this.canEntityBeSeen(this.targetofmyrevenge))
                {
                    if (this.isInWater()) {
                        double slopeX = (this.targetofmyrevenge.posX - this.posX) / 4.0D;
                        double slopeZ = (this.targetofmyrevenge.posZ - this.posZ) / 4.0D;
                        double numerator = Math.sqrt(slopeX * slopeX + slopeZ * slopeZ) * 10.0;
                        this.motionX = slopeX * 0.75F / numerator;
                        this.motionZ = slopeZ * 0.75F / numerator;
                    }

                    float dist = this.getDistance(this.targetofmyrevenge);
                    if (dist <= 3)
                    {
                        this.getNavigator().clearPath();
                        this.getLookHelper().setLookPositionWithEntity(this.targetofmyrevenge, 30.0f,30.0f);
                        if (this.leapCooldown > 20)
                        {
                            if (this.leapCooldown == 21)
                            {
                                this.getNavigator().tryMoveToEntityLiving(this.targetofmyrevenge, 0.3f);
                                this.leapCooldown++;
                            }
                            else
                            {
                                if (this.getNavigator().noPath())
                                {
                                    List<Entity> swipeEnemies = this.world.getEntitiesWithinAABBExcludingEntity(this,  this.getEntityBoundingBox().expand(2.0,0.0,2.0).offset(-0.8D,0D,-0.8D));
                                    if (!swipeEnemies.isEmpty())
                                    {
                                        for (Entity targ : swipeEnemies)
                                        {
                                            if (targ instanceof EntityPlayer)
                                            {
                                                this.leapCooldown = 0;
                                                this.startExplosion = true;
                                                this.explosionCount = 0;
                                                return;
                                            }
                                        }
                                    }
                                    else
                                    {
                                        this.leapCooldown = 0;
                                    }
                                }
                            }
                        }
                        else
                        {
                            this.getNavigator().clearPath();
                            //this.getLookHelper().setLookPositionWithEntity(this.targetofmyrevenge, 30.0f,30.0f);
                            this.leapCooldown++;
                        }
                    }
                }
            }
            else
            {
                this.targetofmyrevenge = null;
                this.active = false;
                this.explosionCount = 0;
                this.startExplosion = false;
                this.leapCooldown = 21;
            }
        }
        else
        {
            if (hasIgnited())
            {
                this.igniteCount++;
            }
            else
            {
                this.igniteCount = 0;
            }
        }
    }

    public float getIgniteRatio()
    {
        float iRatio = ((float)(this.igniteCount)) / 50.0f;
        if (iRatio > 1.0f)
            return 1.0f;
        return iRatio;
    }

    public boolean hasIgnited()
    {
        return ((Boolean)this.dataManager.get(IGNITED)).booleanValue();
    }
    public void ignite()
    {
        this.dataManager.set(IGNITED, Boolean.valueOf(true));
    }

    public void unignite()
    {
        this.dataManager.set(IGNITED, Boolean.valueOf(false));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setBoolean("ignited", this.hasIgnited());
    }

    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        if (compound.getBoolean("ignited"))
        {
            this.ignite();
        }
    }

    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (!this.world.isRemote)
        {
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
        return SoundEvents.ENTITY_SPIDER_AMBIENT;
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
