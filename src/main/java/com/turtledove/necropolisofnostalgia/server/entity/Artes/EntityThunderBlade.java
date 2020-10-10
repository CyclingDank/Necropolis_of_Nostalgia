package com.turtledove.necropolisofnostalgia.server.entity.Artes;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.server.entity.EntityCasted;
import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.server.packets.Player.SyncPlayer;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class EntityThunderBlade extends EntityCasted
{
    private int ticksAlive;
    private float damage;

    public EntityThunderBlade(World worldIn)
    {
        super(worldIn);
        this.setSize(3.6F, 0.7F);
        this.noClip = true;
        this.setNoGravity(true);
    }
    public EntityThunderBlade (World worldIn, EntityPlayer player, float damage)
    {
        super(worldIn, player);
        this.noClip = true;
        this.setSize(3.6F, 0.7F);
        this.ticksAlive = 0;
        this.arte_element = 5;
        this.damage = damage;

        this.setNoGravity(true);
    }
    public EntityThunderBlade (World worldIn, NecropolisEntity monster, float damage)
    {
        super(worldIn, monster);
        this.noClip = true;
        this.setSize(3.6F, 0.7F);
        this.ticksAlive = 0;
        this.arte_element = 5;
        this.damage = damage;

        this.setNoGravity(true);
    }
    protected void entityInit()
    {
        super.entityInit();
        this.setSize(3.6F, 0.7F);
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
        if (this.ticksAlive >= 10)
        {
            this.setDead();
        }
        if (!world.isRemote)
        {
            if (this.ticksAlive == 0)
            {
                this.playSound(NecropolisSounds.TB_CAST, 1.0f, 1.0f);
            }
            if (this.ticksAlive > 3)
            {
                if (this.ticksAlive == 4)
                    this.collideWithEntities(this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().grow(1.0D)));
            }
            this.ticksAlive++;
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
                    if (!entity.isEntityEqual(this.caster) && !(entity instanceof EntityCasted))
                    {
                        if (this.caster instanceof NecropolisEntity)
                        {
                            if (!(entity instanceof NecropolisEntity))
                            {
                                entity.attackEntityFrom(DamageSource.causeMobDamage(this), this.damage);
                                entity.motionY = 0.4f;
                                if (entity instanceof EntityPlayer)
                                {
                                    Necropolis_of_Nostalgia.packetHandler.sendTo(new SyncPlayer(0.0, 0.4, 0.0), (EntityPlayerMP)entity);
                                }
                            }
                        }
                        else
                        {
                            entity.attackEntityFrom(DamageSource.causeMobDamage(this), this.damage);

                            entity.motionY = 0.4f;
                            if (entity instanceof EntityPlayer)
                            {
                                Necropolis_of_Nostalgia.packetHandler.sendTo(new SyncPlayer(0.0, 0.4, 0.0), (EntityPlayerMP)entity);
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