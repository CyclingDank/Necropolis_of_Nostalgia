package com.turtledove.necropolisofnostalgia.server.entity.Artes;

import com.turtledove.necropolisofnostalgia.server.entity.EntityCasted;
import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class EntityPhoton extends EntityCasted
{
    private int ticksAlive;
    private float damage;

    private boolean shouldReturn;

    float dirX;
    float dirZ;

    public EntityPhoton(World worldIn)
    {
        super(worldIn);
        this.setSize(3.0F, 0.25F);
    }
    public EntityPhoton (World worldIn, EntityPlayer player, double dirX, double dirZ, float damage)
    {
        super(worldIn, player);
        this.noClip = true;
        this.setPosition(player.posX,player.posY + 0.5F,player.posZ);
        this.setSize(3.0F, 0.25F);
        this.motionX = dirX;
        this.motionZ = dirZ;
        this.ticksAlive = 0;
        this.arte_element = 7;
        this.damage = damage;
        this.shouldReturn = true;

        this.dirX = (float)dirX;
        this.dirZ = (float)dirZ;
        this.setNoGravity(true);
    }

    public EntityPhoton (World worldIn, EntityPlayer player, double dirX, double dirZ, float damage, boolean doesReturn)
    {
        super(worldIn, player);
        this.noClip = true;
        this.setPosition(player.posX,player.posY + 0.5F,player.posZ);
        this.setSize(3.0F, 0.25F);
        this.motionX = dirX;
        this.motionZ = dirZ;
        this.ticksAlive = 0;
        this.arte_element = 7;
        this.damage = damage;

        this.shouldReturn = doesReturn;

        this.dirX = (float)dirX;
        this.dirZ = (float)dirZ;
        this.setNoGravity(true);
    }
    public EntityPhoton (World worldIn, NecropolisEntity monster, double dirX, double dirZ, float damage)
    {
        super(worldIn, monster);
        this.noClip = true;
        this.setPosition(monster.posX,monster.posY + 0.5F,monster.posZ);
        this.setSize(3.0F, 0.25F);
        this.motionX = dirX;
        this.motionZ = dirZ;
        this.ticksAlive = 0;
        this.arte_element = 7;
        this.damage = damage;
        this.shouldReturn = true;

        this.dirX = (float)dirX;
        this.dirZ = (float)dirZ;
        this.setNoGravity(true);
    }
    protected void entityInit()
    {
        super.entityInit();
        this.setSize(3.0F, 0.25F);
        this.noClip = true;
    }
    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setFloat("damage", this.damage);
        compound.setInteger("life", this.ticksAlive);
        compound.setFloat("dirX", this.dirX);
        compound.setFloat("dirZ", this.dirZ);
        compound.setBoolean("shouldReturn", this.shouldReturn);
    }
    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.damage = compound.getFloat("damage");
        this.ticksAlive = compound.getInteger("life");
        this.dirX = compound.getFloat("dirX");
        this.dirZ = compound.getFloat("dirZ");
        this.shouldReturn = compound.getBoolean("shouldReturn");
    }
    @Override
    public void onUpdate()
    {
        super.onUpdate();
        if (this.caster == null || this.caster.isDead)
            this.setDead();
        if (this.world.isRemote)
            return;
        if (this.ticksAlive < 40)
        {
            this.motionX = dirX;
            this.motionZ = dirZ;
        }
        else if (this.ticksAlive >= 40 && this.ticksAlive < 50)
        {
            this.motionX = dirX *  (1.0 - (this.ticksAlive - 40.0F) / 10.0);
            this.motionZ = dirZ * (1.0 - (this.ticksAlive - 40.0F) / 10.0);
        }
        else if (this.ticksAlive >= 50 && this.ticksAlive < 90)
        {
            if (this.shouldReturn == false)
            {
                this.setDead();
                return;
            }
            this.motionX = -dirX;
            this.motionZ = -dirZ;
        }
        else if (this.ticksAlive >= 95)
            this.setDead();
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
                                entity.attackEntityFrom(DamageSource.causeMobDamage(this), this.damage);
                        }
                        else
                        {
                            entity.attackEntityFrom(DamageSource.causeMobDamage(this), this.damage);
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
