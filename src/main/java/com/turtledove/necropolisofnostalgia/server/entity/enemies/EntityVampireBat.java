package com.turtledove.necropolisofnostalgia.server.entity.enemies;

import com.google.common.base.Predicates;
import com.turtledove.necropolisofnostalgia.server.ai.*;
import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
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

public class EntityVampireBat extends NecropolisEntity
{
    public static final Animation DIVE_ANIMATION = Animation.create(20);
    public static final Animation ANNOY_ANIMATION = Animation.create(40);
    public static final Animation HURT_ANIMATION = Animation.create(15);

    private static final Animation[] ANIMATIONS = {DIVE_ANIMATION, ANNOY_ANIMATION, HURT_ANIMATION};

    protected float maxDistanceForPlayer;
    private double tSpeed;

    private BlockPos spawnPosition;

    private int diveCooldown;


    public EntityVampireBat(World worldin)
    {
        super(worldin);
        this.setSize(0.6F, 0.6F);
        this.active = true;
        this.isImmuneToFire = false;
        this.maxDistanceForPlayer = 20.0F;
        this.targetofmyrevenge = null;
        this.struckwhileGuarding = false;
        this.tSpeed = 0.375D * 3D;

        this.elementWeakness[6] = -1;
        this.elementWeakness[7] = 1;
        this.elementWeakness[4] = -1;

        this.defense = 8;
        this.sDefense = 7;
        this.setNoGravity(true);
        this.spawnPosition = this.getPosition();

        this.diveCooldown = 0;

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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.setSize(0.6F, 0.6F);
    }

    @Override
    protected void initEntityAI()
    {
        this.tSpeed = 0.375D * 3D;
        this.tasks.addTask(1, new AnimationVBDiveAI<>(this, DIVE_ANIMATION));
        this.tasks.addTask(1, new AnimationVBAnnoyAI<>(this, ANNOY_ANIMATION));
        this.tasks.addTask(1, new AnimationGenericAI<>(this, HURT_ANIMATION));

        this.tasks.addTask(2, new EntityAIBatFly(this,this.tSpeed, 5));
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (this.world.isRemote) {
            this.setHealth(this.getHealth());
        }
        if (!this.world.isRemote)
        {
            this.clearActivePotions();
            if (this.ticksExisted % 45 == 0)
            {
                this.playSound(SoundEvents.ENTITY_PARROT_FLY, 0.3F, 0.6F);
            }
            Entity closestEntity = this.world.getClosestPlayer(this.posX, this.posY, this.posZ, (double)maxDistanceForPlayer, Predicates.and(EntitySelectors.CAN_AI_TARGET, EntitySelectors.notRiding(this)));
            float f = 0.91F;
            if (getAnimation() != HURT_ANIMATION)
            {
                if (this.onGround)
                {
                    BlockPos underPos = new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.getEntityBoundingBox().minY) - 1, MathHelper.floor(this.posZ));
                    IBlockState underState = this.world.getBlockState(underPos);
                    f = underState.getBlock().getSlipperiness(underState, this.world, underPos, this) * 0.91F;
                }
                this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
                this.motionX *= (double)f;
                this.motionY *= (double)f;
                this.motionZ *= (double)f;
            }
            if (!this.world.isAirBlock(this.getPosition().down()) && this.getAnimation() != EntityVampireBat.HURT_ANIMATION)
            {
                this.motionY=0.3F;
            }
            if (closestEntity != null && closestEntity.isEntityAlive()) {

                this.targetofmyrevenge = (EntityPlayer) closestEntity;
                this.active = true;
                if (this.canEntityBeSeen(this.targetofmyrevenge))
                {
                    float dist = this.getDistance(this.targetofmyrevenge);
                    if (dist < 5)
                    {
                        if (getAnimation() == NO_ANIMATION)
                        {
                            if (this.diveCooldown > 10)
                            {
                                double tRand = Math.random();
                                if (tRand < 0.8)
                                {
                                    AnimationHandler.INSTANCE.sendAnimationMessage(this, DIVE_ANIMATION);
                                    this.diveCooldown = 0;
                                }
                                else
                                {
                                    AnimationHandler.INSTANCE.sendAnimationMessage(this, ANNOY_ANIMATION);
                                    this.diveCooldown = -10;
                                }
                            }
                            this.diveCooldown++;
                        }

                    }
                }
            }
            else
            {
                this.targetofmyrevenge = null;
                this.active = false;
                if (this.spawnPosition != null && (!this.world.isAirBlock(this.spawnPosition) || this.spawnPosition.getY() < 1))
                {
                    this.spawnPosition = null;
                }

                if (this.spawnPosition == null || this.rand.nextInt(30) == 0 || this.spawnPosition.distanceSq((double)((int)this.posX), (double)((int)this.posY), (double)((int)this.posZ)) < 4.0D)
                {
                    this.spawnPosition = new BlockPos((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
                }

                double d0 = (double)this.spawnPosition.getX() + 0.5D - this.posX;
                double d1 = (double)this.spawnPosition.getY() + 0.1D - this.posY;
                double d2 = (double)this.spawnPosition.getZ() + 0.5D - this.posZ;
                this.motionX += (Math.signum(d0) * 0.5D - this.motionX) * 0.10000000149011612D;
                this.motionY += (Math.signum(d1) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
                this.motionZ += (Math.signum(d2) * 0.5D - this.motionZ) * 0.10000000149011612D;
                float g = (float)(MathHelper.atan2(this.motionZ, this.motionX) * (180D / Math.PI)) - 90.0F;
                float f1 = MathHelper.wrapDegrees(g - this.rotationYaw);
                this.moveForward = 0.5F;
                this.rotationYaw += f1;
            }
        }
    }
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (!this.world.isRemote)
        {
            if (source.equals(DamageSource.FALL))
                return false;
            if (getAnimation() == NO_ANIMATION)
            {
                AnimationHandler.INSTANCE.sendAnimationMessage(this, HURT_ANIMATION);
                this.playSound(NecropolisSounds.BAT_AMBIENT, 0.7F, 0.7F);
                this.diveCooldown = 0;
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
                this.dropExperience(24);
                this.entityDropItem(new ItemStack(Items.LEATHER, 12, 0), 0.0F);
            }
        }
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

    /**
     * Return whether this entity should NOT trigger a pressure plate or a tripwire.
     */
    public boolean doesEntityNotTriggerPressurePlate()
    {
        return true;
    }
    @Override
    public Animation[] getAnimations()
    {
        return ANIMATIONS;
    }

    protected SoundEvent getAmbientSound()
    {
        return NecropolisSounds.BAT_AMBIENT;
    }
}
