package com.turtledove.necropolisofnostalgia.server.entity.Artes;

import com.turtledove.necropolisofnostalgia.server.entity.EntityCasted;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class EntityDemonFang  extends EntityCasted
{
    private int ticksAlive;
    private int ticksLifetime = 40;
    private float damage;

    public EntityDemonFang(World worldIn)
    {
        super(worldIn);
        this.setSize(0.75F, 0.75F);
        this.damage = 0F;
    }
    public EntityDemonFang (World worldIn, EntityPlayer player, Vec3d pos, float dir, float damage, int ticksLifetime)
    {
        super(worldIn, player);
        this.noClip = false;
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
            if (this.ticksAlive < this.ticksLifetime)
            {
                Vec3d slope = new Vec3d((this.getLookVec().x) * 0.6D, 0.0D, (this.getLookVec().z) * 0.6D);
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
                        this.setDead();
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
