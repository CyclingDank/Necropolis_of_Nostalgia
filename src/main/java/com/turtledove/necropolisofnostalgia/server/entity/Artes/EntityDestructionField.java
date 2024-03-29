package com.turtledove.necropolisofnostalgia.server.entity.Artes;

import com.turtledove.necropolisofnostalgia.server.entity.EntityCasted;
import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
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

public class EntityDestructionField  extends EntityCasted
{
    private int ticksAlive;
    private float damage;

    public EntityDestructionField(World worldIn)
    {
        super(worldIn);
        this.setSize(2.4F, 0.25F);
    }
    public EntityDestructionField (World worldIn, EntityPlayer player, Vec3d pos, float damage)
    {
        super(worldIn, player);
        this.noClip = true;
        this.setPosition(pos.x,pos.y,pos.z);
        this.setSize(2.4F, 0.25F);
        this.ticksAlive = 0;
        this.damage = damage;
        this.playSound(NecropolisSounds.BEAST, 1.0f, 1.0f);
        this.setNoGravity(true);
    }
    public EntityDestructionField (World worldIn, NecropolisEntity monster, Vec3d pos, float damage)
    {
        super(worldIn, monster);
        this.noClip = true;
        this.setPosition(pos.x,pos.y,pos.z);
        this.setSize(2.4F, 0.25F);
        this.ticksAlive = 0;
        this.damage = damage;
        this.playSound(NecropolisSounds.BEAST, 1.0f, 1.0f);
        this.setNoGravity(true);
    }
    protected void entityInit()
    {
        super.entityInit();
        this.setSize(2.4F, 0.25F);
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
        if (this.caster == null || this.caster.isDead)
            this.setDead();
        if (this.ticksAlive >= 6)
        {
            this.setDead();
        }
        this.ticksAlive++;
        this.collideWithEntities(this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().grow(1.0D)));
    }
    private void collideWithEntities(List<Entity> p_70970_1_)
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
                                entity.attackEntityFrom(DamageSource.causeMobDamage(this), this.damage);
                                entity.motionY = 0.4;
                            }
                        }
                        else
                        {
                            entity.attackEntityFrom(DamageSource.causeMobDamage(this), this.damage);
                            entity.motionY = 0.4;
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
