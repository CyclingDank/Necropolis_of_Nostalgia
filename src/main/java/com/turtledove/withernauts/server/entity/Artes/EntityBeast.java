package com.turtledove.withernauts.server.entity.Artes;

import com.turtledove.withernauts.server.entity.EntityCasted;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class EntityBeast extends EntityCasted
{
    private int ticksAlive;
    private int ticksLifetime = 2;
    private float damage;

    public EntityBeast(World worldIn)
    {
        super(worldIn);
        this.setSize(0.75F, 0.75F);
        this.damage = 0F;
    }
    public EntityBeast (World worldIn, EntityPlayer player, Vec3d pos, float dir, float damage, int ticksLifetime)
    {
        super(worldIn, player);
        this.noClip = true;
        this.ignoreFrustumCheck = true;
        this.setSize(0.75F, 0.75F);
        this.setRotation(dir,0.0F);
        this.setPositionAndRotation(pos.x,pos.y,pos.z, dir, 0.0F);
        this.ticksLifetime = ticksLifetime;
        this.damage = damage;
        this.ticksAlive = 0;
    }
    protected void entityInit()
    {
        super.entityInit();
        this.setSize(0.75F, 0.75F);
        this.setNoGravity(true);

        this.noClip = true;
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
    public void onUpdate()
    {
        super.onUpdate();
        if (!this.world.isRemote)
        {
            if (this.ticksAlive >= this.ticksLifetime - 10)
            {
                this.motionX = 0;
                this.motionZ = 0;
            }
            if (this.ticksAlive < this.ticksLifetime)
            {
                Vec3d slope = new Vec3d((this.getLookVec().x) * 0.05D, 0.0D, (this.getLookVec().z) * 0.05D);
                Vec3d updatedPos = this.getPositionVector().add(slope);
                this.setPosition(updatedPos.x,updatedPos.y,updatedPos.z);
                this.collideWithEntities(this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().grow(1.0D)));
                this.ticksAlive++;
            }
            else
            {
                this.setDead();
            }
        }
    }

    private void collideWithEntities(List<Entity> p_70970_1_)
    {
        for (Entity entity : p_70970_1_)
        {
            if (entity instanceof EntityLivingBase)
            {
                if (this.caster != null)
                {
                    if (!entity.isEntityEqual(this.caster))
                    {
                        entity.attackEntityFrom(DamageSource.causeMobDamage(this), this.damage);
                        Vec3d slope = (new Vec3d(entity.posX - this.posX, 0.0D, entity.posZ - this.posZ)).normalize();

                        entity.motionX = slope.x * 0.6F;
                        entity.motionZ = slope.z * 0.6F;
                        entity.motionY = 0.1F;
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
