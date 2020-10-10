package com.turtledove.necropolisofnostalgia.server.entity;

import com.turtledove.necropolisofnostalgia.server.entity.Spiral_Draco.EntitySpiral_Draco;
import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.util.DamageSource;


public class EntityNecropolisFireCharge extends EntityFireball
{
    public int ticksInAir;
    public EntityNecropolisFireCharge(World worldIn)
    {
        super(worldIn);
    }
    private int damage;
    public EntityNecropolisFireCharge(World worldIn, EntitySpiral_Draco shooter,double accelX, double accelY, double accelZ)
    {
        super(worldIn, shooter, accelX, accelY, accelZ);
        double d0 = (double) MathHelper.sqrt(accelX * accelX + accelY * accelY + accelZ * accelZ);
        this.accelerationX = accelX / d0 * 0.07D;
        this.accelerationY = accelY / d0 * 0.07D;
        this.accelerationZ = accelZ / d0 * 0.07D;
        this.damage = 50;
        this.playSound(SoundEvents.ITEM_FIRECHARGE_USE,1.0F,1.0F);
    }
    public EntityNecropolisFireCharge(World worldIn, int damage, EntityPlayer shooter, double accelX, double accelY, double accelZ)
    {
        super(worldIn, shooter, accelX, accelY, accelZ);
        double d0 = (double) MathHelper.sqrt(accelX * accelX + accelY * accelY + accelZ * accelZ);
        this.accelerationX = accelX / d0 * 0.07D;
        this.accelerationY = accelY / d0 * 0.07D;
        this.accelerationZ = accelZ / d0 * 0.07D;
        this.damage = damage;
        this.playSound(SoundEvents.ITEM_FIRECHARGE_USE,1.0F,1.0F);
    }
    public EntityNecropolisFireCharge(World worldIn, int damage, double posX, double posY, double posZ, double accelX, double accelY, double accelZ) {
        super(worldIn, posX, posY, posZ, accelX, accelY, accelZ);
        double d0 = (double) MathHelper.sqrt(accelX * accelX + accelY * accelY + accelZ * accelZ);
        this.accelerationX = accelX / d0 * 0.07D;
        this.accelerationY = accelY / d0 * 0.07D;
        this.accelerationZ = accelZ / d0 * 0.07D;
        this.damage = damage;
        this.playSound(SoundEvents.ITEM_FIRECHARGE_USE,1.0F,1.0F);
    }

    public void onUpdate()
    {
        if (this.damage == -1)
            this.damage = 2;
        for (int i = 0; i < 4; ++i)
        {
            this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX + ((this.rand.nextDouble() - 0.5D) * width), this.posY + ((this.rand.nextDouble() - 0.5D) * width), this.posZ + ((this.rand.nextDouble() - 0.5D) * width), 0.0D, 0.0D, 0.0D);
        }
        if (!world.isRemote)
        {
            super.onUpdate();
            this.setFire(1);
            ++this.ticksInAir;
            RayTraceResult raytraceresult = ProjectileHelper.forwardsRaycast(this, false, this.ticksInAir >= 25, this.shootingEntity);

            if (raytraceresult != null)
            {
                this.onImpact(raytraceresult);
            }
            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            ProjectileHelper.rotateTowardsMovement(this, 0.2F);
            float f = this.getMotionFactor();
            this.motionX += this.accelerationX;
            this.motionY += this.accelerationY;
            this.motionZ += this.accelerationZ;
            this.motionX *= (double) f;
            this.motionY *= (double) f;
            this.motionZ *= (double) f;
            this.world.spawnParticle(this.getParticleType(), this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
            this.setPosition(this.posX, this.posY, this.posZ);
        }
        else {
            this.setDead();
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setInteger("damage", this.damage);
    }
    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.damage = compound.getInteger("damage");
    }

    @Override
    protected void onImpact(RayTraceResult movingObject)
    {
        if (!this.world.isRemote)
        {
            if (movingObject.entityHit != null && movingObject.entityHit instanceof EntityFireball)
            {
                return;
            }
            if (movingObject.entityHit == null || !(movingObject.entityHit instanceof EntityFireball) && movingObject.entityHit != shootingEntity)
            {
                if (this.shootingEntity != null && movingObject.entityHit == this.shootingEntity)
                {
                    return;
                }
                if (this.shootingEntity != null)
                {
                    BlockPos blockpos1 = new BlockPos(posX, posY, posZ);
                    BlockPos blockpos2 = new BlockPos(posX+1, posY, posZ);
                    BlockPos blockpos3 = new BlockPos(posX-1, posY, posZ);
                    BlockPos blockpos4 = new BlockPos(posX, posY, posZ+1);
                    BlockPos blockpos5 = new BlockPos(posX, posY, posZ-1);

                    if (world.isAirBlock(blockpos1.up()))
                        world.setBlockState(blockpos1.up(), Blocks.FIRE.getDefaultState());
                    if (world.isAirBlock(blockpos2.up()))
                        world.setBlockState(blockpos2.up(), Blocks.FIRE.getDefaultState());
                    if (world.isAirBlock(blockpos3.up()))
                        world.setBlockState(blockpos3.up(), Blocks.FIRE.getDefaultState());
                    if (world.isAirBlock(blockpos4.up()))
                        world.setBlockState(blockpos4.up(), Blocks.FIRE.getDefaultState());
                    if (world.isAirBlock(blockpos5.up()))
                        world.setBlockState(blockpos5.up(), Blocks.FIRE.getDefaultState());
                }
                this.setDead();
            }
            if (movingObject.entityHit != null && !(movingObject.entityHit instanceof EntityFireball) && !movingObject.entityHit.isEntityEqual(shootingEntity))
            {
                if (this.shootingEntity != null)
                {
                    if (movingObject.entityHit.isEntityEqual(shootingEntity))
                    {
                        return;
                    }
                    else
                    {
                        movingObject.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this,this.shootingEntity), damage);
                    }
                }
                movingObject.entityHit.setFire(5);
                this.applyEnchantments(this.shootingEntity, movingObject.entityHit);
                BlockPos blockpos1 = new BlockPos(posX, posY, posZ);
                BlockPos blockpos2 = new BlockPos(posX+1, posY, posZ);
                BlockPos blockpos3 = new BlockPos(posX-1, posY, posZ);
                BlockPos blockpos4 = new BlockPos(posX, posY, posZ+1);
                BlockPos blockpos5 = new BlockPos(posX, posY, posZ-1);
                if (world.isAirBlock(blockpos1.up()))
                    world.setBlockState(blockpos1.up(), Blocks.FIRE.getDefaultState());
                if (world.isAirBlock(blockpos2.up()))
                    world.setBlockState(blockpos2.up(), Blocks.FIRE.getDefaultState());
                if (world.isAirBlock(blockpos3.up()))
                    world.setBlockState(blockpos3.up(), Blocks.FIRE.getDefaultState());
                if (world.isAirBlock(blockpos4.up()))
                    world.setBlockState(blockpos4.up(), Blocks.FIRE.getDefaultState());
                if (world.isAirBlock(blockpos5.up()))
                    world.setBlockState(blockpos5.up(), Blocks.FIRE.getDefaultState());
                this.setDead();
            }
        }
    }

    public void setAim(Entity fireball, Entity entity, float yaw, float pitch, float a, float b, float c) {
        float f = -MathHelper.sin(pitch * 0.017453292F) * MathHelper.cos(yaw * 0.017453292F);
        float f1 = -MathHelper.sin(yaw * 0.017453292F);
        float f2 = MathHelper.cos(pitch * 0.017453292F) * MathHelper.cos(yaw * 0.017453292F);
        this.setThrowableHeading(fireball, (double) f, (double) f1, (double) f2, b, c);
        fireball.motionX += entity.motionX;
        fireball.motionZ += entity.motionZ;

        if (!entity.onGround) {
            fireball.motionY += entity.motionY;
        }
    }

    public void setThrowableHeading(Entity fireball, double x, double y, double z, float velocity, float inaccuracy) {
        float f = MathHelper.sqrt(x * x + y * y + z * z);
        x = x / (double) f;
        y = y / (double) f;
        z = z / (double) f;
        x = x + this.rand.nextGaussian() * 0.007499999832361937D * (double) inaccuracy;
        y = y + this.rand.nextGaussian() * 0.007499999832361937D * (double) inaccuracy;
        z = z + this.rand.nextGaussian() * 0.007499999832361937D * (double) inaccuracy;
        x = x * (double) velocity;
        y = y * (double) velocity;
        z = z * (double) velocity;
        fireball.motionX = x;
        fireball.motionY = y;
        fireball.motionZ = z;
        float f1 = MathHelper.sqrt(x * x + z * z);
        fireball.rotationYaw = (float) (MathHelper.atan2(x, z) * (180D / Math.PI));
        fireball.rotationPitch = (float) (MathHelper.atan2(y, (double) f1) * (180D / Math.PI));
        fireball.prevRotationYaw = fireball.rotationYaw;
        fireball.prevRotationPitch = fireball.rotationPitch;
    }

    public void setSizes(float width, float height)
    {
        this.setSize(width, height);
    }
    @Override
    public boolean canBeCollidedWith() {
        return false;
    }
    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        return false;
    }
}
