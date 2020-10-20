package com.turtledove.withernauts.server.entity.Artes;

import com.turtledove.withernauts.server.entity.EntityCasted;
import com.turtledove.withernauts.server.sounds.NecropolisSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class EntityDispel extends EntityCasted
{
    private int ticksAlive;
    private int ticksLifetime;

    public EntityDispel(World worldIn)
    {
        super(worldIn);
        this.setSize(5.0F, 1.0F);
    }
    public EntityDispel (World worldIn, EntityPlayer player, int ticksLifetime)
    {
        super(worldIn, player);
        this.noClip = true;
        this.setPosition(player.posX,player.posY,player.posZ);
        this.setSize(5.0F, 1.0F);
        this.ticksLifetime = ticksLifetime;
        this.ticksAlive = 0;
        this.arte_element = 0;
        this.setNoGravity(true);
    }
    protected void entityInit()
    {
        super.entityInit();
        this.setSize(5.0F, 1.0F);
        this.noClip = true;
    }
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        compound.setInteger("life", this.ticksAlive);
    }
    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate()
    {
        super.onUpdate();
        if (this.caster == null || this.caster.isDead)
            this.setDead();
        if (!this.world.isRemote)
        {
            if (ticksAlive < ticksLifetime)
            {
                if (ticksAlive % 10 == 0)
                {
                    this.collideWithEntities(this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().grow(1.0D)));
                }
                ticksAlive++;
            }
            else
            {
                ticksAlive = 0;
                this.setDead();
            }
        }
    }

    private void collideWithEntities(List<Entity> p_70970_1_) {
        for (Entity entity : p_70970_1_) {
            if (entity instanceof EntityLivingBase)
            {
                if (entity instanceof EntityPlayer)
                {
                    EntityPlayer player = (EntityPlayer)entity;
                    this.playSound(NecropolisSounds.LIGHT_CAST, 1.0f, 1.0f);
                    player.clearActivePotions();
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
    public void readEntityFromNBT(NBTTagCompound compound)
    {

    }
    public void setSizes(float width, float height)
    {
        this.setSize(width, height);
    }
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