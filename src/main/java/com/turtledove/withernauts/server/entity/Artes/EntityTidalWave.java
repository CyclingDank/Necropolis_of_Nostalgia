package com.turtledove.withernauts.server.entity.Artes;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.server.entity.EntityCasted;
import com.turtledove.withernauts.server.entity.NecropolisEntity;
import com.turtledove.withernauts.server.packets.Player.SyncPlayer;
import com.turtledove.withernauts.server.sounds.NecropolisSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class EntityTidalWave extends EntityCasted
{
    private int ticksAlive;
    private float damage;

    public EntityTidalWave(World worldIn)
    {
        super(worldIn);
        this.setSize(15.5F, 3.0F);
        this.noClip = true;
        this.setNoGravity(true);
    }
    public EntityTidalWave (World worldIn, EntityPlayer player, float damage)
    {
        super(worldIn, player);
        this.noClip = true;
        this.setSize(15.5F, 3.0F);
        this.ticksAlive = 0;
        this.arte_element = 2;
        this.damage = damage;
        this.setNoGravity(true);
    }
    public EntityTidalWave (World worldIn, NecropolisEntity monster, float damage)
    {
        super(worldIn, monster);
        this.noClip = true;
        this.setSize(15.5F, 3.0F);
        this.ticksAlive = 0;
        this.arte_element = 2;
        this.damage = damage;
        this.playSound(NecropolisSounds.OF_CAST, 1.0f, 1.0f);
        this.setNoGravity(true);
    }
    protected void entityInit()
    {
        super.entityInit();
        this.setSize(15.5F, 3.0F);
        this.noClip = true;
        this.setNoGravity(true);
    }
    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setFloat("damage", this.damage);
        compound.setInteger("life", this.ticksAlive);

    }
    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.damage = compound.getFloat("damage");
        this.ticksAlive = compound.getInteger("life");
    }
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.caster == null || this.caster.isDead)
            this.setDead();
        if (this.ticksExisted == 100)
        {
            int mult = 3;
            for (int j = 0; j < 8 * mult; ++j) {
                float f = this.rand.nextFloat() * ((float) Math.PI * 2F);
                float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
                float f2 = MathHelper.sin(f)* 6.0F * f1;
                float f3 = MathHelper.cos(f)* 6.0F * f1;

                double d0 = this.posX + (double) f2;
                double d1 = this.posZ + (double) f3;

                this.world.spawnParticle(EnumParticleTypes.CLOUD, d0, this.posY, d1, 0.0f, 0.05f, 0.0f);
            }
        }
        if (this.ticksAlive >= 100)
        {
            this.setDead();
        }
        if (!world.isRemote)
        {
            if (this.ticksExisted % 9 == 0)
            {
                this.playSound(NecropolisSounds.OF_CAST, 1.0f, 1.0f);
            }
            this.collideWithEntities(this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().grow(1.0D)), this.ticksExisted % 10 == 0);
            this.ticksAlive++;
        }
        else
        {
            if (this.ticksExisted % 3 == 0 || this.ticksExisted % 9 == 0)
            {
                int mult = 3;
                for (int j = 0; j < 8 * mult; ++j) {
                    float f = this.rand.nextFloat() * ((float) Math.PI * 2F);
                    float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
                    float f2 = MathHelper.sin(f)* 6.0F * f1;
                    float f3 = MathHelper.cos(f)* 6.0F * f1;

                    double d0 = this.posX + (double) f2;
                    double d1 = this.posZ + (double) f3;

                    if (this.ticksExisted % 9 == 0)
                        this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, d0, this.posY + 0.1f, d1, 0.0f, 0.15f, 0.0f);
                    if (this.ticksExisted % 3 == 0)
                    {
                        this.world.spawnParticle(EnumParticleTypes.WATER_SPLASH, d0, this.posY, d1, 0.0f, 0.05f, 0.0f);

                    }
                }
            }
        }
    }

    private void collideWithEntities(List<Entity> p_70970_1_, boolean shouldDamage)
    {
        for (Entity entity : p_70970_1_)
        {
            if (entity instanceof EntityLivingBase)
            {
                if (this.caster != null)
                {
                    if (!entity.isEntityEqual(this.caster) && !(entity instanceof EntityCasted))
                    {
                        if (this.caster instanceof NecropolisEntity)
                        {
                            if (!(entity instanceof NecropolisEntity))
                            {
                                if (shouldDamage)
                                {
                                    entity.attackEntityFrom(DamageSource.causeMobDamage(this), this.damage);
                                    entity.motionY += 0.4f;
                                    if (entity instanceof EntityPlayer)
                                    {
                                        Withernauts.packetHandler.sendTo(new SyncPlayer(0.0, 0.4, 0.0), (EntityPlayerMP)entity);
                                    }
                                }
                            }
                        }
                        else
                        {
                            if (shouldDamage)
                            {
                                entity.attackEntityFrom(DamageSource.causeMobDamage(this), this.damage);
                                entity.motionY += 0.4f;
                                if (entity instanceof EntityPlayer)
                                {
                                    Withernauts.packetHandler.sendTo(new SyncPlayer(0.0, 0.4, 0.0), (EntityPlayerMP)entity);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        return false;
    }
    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public boolean canBeCollidedWith()
    {
        return false;
    }
    public float getBrightness()
    {
        return 1.0F;
    }
    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender()
    {
        return 15728880;
    }

}