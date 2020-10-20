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

import java.util.List;

public class EntityPB  extends EntityCasted
{
    private int ticksAlive;
    private float damage;

    private double centerX;
    private double centerZ;


    public EntityPB(World worldIn)
    {
        super(worldIn);
        this.setSize(0.8F, 2.8F);
        this.noClip = true;
        this.setNoGravity(true);
    }
    public EntityPB (World worldIn, EntityPlayer player, float damage)
    {
        super(worldIn, player);
        this.noClip = true;
        this.setSize(0.8F, 2.8F);
        this.ticksAlive = 0;
        this.arte_element = 3;
        this.damage = damage;

        centerX = player.getPositionVector().x;
        centerZ = player.getPositionVector().z;


        this.setNoGravity(true);
    }
    public EntityPB (World worldIn, NecropolisEntity monster, float damage)
    {
        super(worldIn, monster);
        this.noClip = true;
        this.setSize(0.8F, 2.8F);
        this.ticksAlive = 0;
        this.arte_element = 3;
        this.damage = damage;

        centerX = monster.getPositionVector().x;
        centerZ = monster.getPositionVector().z;
        this.setNoGravity(true);
    }
    protected void entityInit()
    {
        super.entityInit();
        this.setSize(0.8F, 2.8F);
        this.noClip = true;
        this.setNoGravity(true);
    }
    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setFloat("damage", this.damage);
        compound.setInteger("life", this.ticksAlive);
        compound.setDouble("centerX", this.centerX);
        compound.setDouble("centerZ", this.centerZ);

    }
    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.damage = compound.getFloat("damage");
        this.ticksAlive = compound.getInteger("life");
        this.centerX = compound.getDouble("centerX");
        this.centerZ = compound.getDouble("centerZ");

    }
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.caster == null || this.caster.isDead)
            this.setDead();
        if (this.ticksAlive >= 200)
        {
            this.playSound(NecropolisSounds.PB_END, 0.7f, 1.0f);
            this.setDead();
        }
        else if (this.ticksAlive == 100)
        {
            this.playSound(NecropolisSounds.PB_CRACK, 0.7f, 1.0f);
        }
        if (!world.isRemote)
        {
            this.collideWithEntities(this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().grow(1.0D)), this.ticksExisted == 3);
            this.ticksAlive++;
        }
        else
        {
            if (this.ticksExisted == 1 || this.ticksExisted == 199)
            {
                for (int j = 0; j < 8 * 3; ++j) {
                    float f = this.rand.nextFloat() * ((float) Math.PI * 2F);
                    float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
                    float f2 = MathHelper.sin(f) * 0.5F * 3.0F * f1;
                    float f3 = MathHelper.cos(f) * 0.5F * 3.0F * f1;
                    World world = this.world;

                    double d0 = this.posX + (double) f2;
                    double d1 = this.posZ + (double) f3;

                    this.world.spawnParticle(EnumParticleTypes.CLOUD, d0, this.posY, d1, 0.0f, 0.05f, 0.0f);
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
                                }
                                else
                                {
                                    if (entity.motionX == 0.0f && entity.motionZ == 0.0f)
                                    {
                                        double xDir = entity.posX - centerX;
                                        double zDir = entity.posZ - centerZ;

                                        if (xDir== 0.0f && zDir == 0.0f)
                                            return;

                                        double m0 = Math.sqrt(xDir * xDir + zDir * zDir);
                                        entity.motionX = xDir / m0;
                                        entity.motionZ = zDir / m0;
                                        if (entity instanceof EntityPlayer)
                                        {
                                            Withernauts.packetHandler.sendTo(new SyncPlayer( 0.0, 0.0, 0.0), (EntityPlayerMP)entity);
                                        }
                                        return;
                                    }
                                    double m0 = Math.sqrt(entity.motionX * entity.motionX + entity.motionZ * entity.motionZ);

                                    entity.motionX = 0.0;
                                    entity.motionZ = 0.0;
                                    if (entity instanceof EntityPlayer)
                                    {
                                        Withernauts.packetHandler.sendTo(new SyncPlayer( -entity.motionX / m0, 0.0, -entity.motionZ / m0), (EntityPlayerMP)entity);
                                    }
                                }
                            }
                        }
                        else
                        {
                            if (shouldDamage)
                            {
                                entity.attackEntityFrom(DamageSource.causeMobDamage(this), this.damage);
                            }
                            else
                            {
                                if (entity.motionX == 0.0f && entity.motionZ == 0.0f)
                                {
                                    double xDir = entity.posX - centerX;
                                    double zDir = entity.posZ - centerZ;

                                    if (xDir== 0.0f && zDir == 0.0f)
                                        return;

                                    double m0 = Math.sqrt(xDir * xDir + zDir * zDir);
                                    entity.motionX = 0.0;
                                    entity.motionZ = 0.0;
                                    if (entity instanceof EntityPlayer)
                                    {
                                        Withernauts.packetHandler.sendTo(new SyncPlayer( 0.0, 0.0, 0.0), (EntityPlayerMP)entity);
                                    }
                                    return;
                                }
                                double m0 = Math.sqrt(entity.motionX * entity.motionX + entity.motionZ * entity.motionZ);
                                entity.motionX = 0.0;
                                entity.motionZ = 0.0;
                                if (entity instanceof EntityPlayer)
                                {
                                    Withernauts.packetHandler.sendTo(new SyncPlayer( 0.0, 0.0, 0.0), (EntityPlayerMP)entity);
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

}
