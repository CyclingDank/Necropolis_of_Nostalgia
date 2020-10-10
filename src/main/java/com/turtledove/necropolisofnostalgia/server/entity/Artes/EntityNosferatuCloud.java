package com.turtledove.necropolisofnostalgia.server.entity.Artes;

import com.turtledove.necropolisofnostalgia.server.entity.EntityCasted;
import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class EntityNosferatuCloud extends EntityCasted
{
    private int ticksAlive;

    public EntityNosferatuCloud(World worldIn)
    {
        super(worldIn);
        this.setSize(3.0F, 1.0F);
    }
    public EntityNosferatuCloud (World worldIn, EntityPlayer player, double dX, double dY, double dZ)
    {
        super(worldIn, player);
        this.noClip = true;
        this.setPosition(dX, dY, dZ);
        this.ticksAlive = 0;
        this.setNoGravity(true);
    }
    public EntityNosferatuCloud (World worldIn, NecropolisEntity player, double dX, double dY, double dZ)
    {
        super(worldIn, player);
        this.noClip = true;
        this.setPosition(dX, dY, dZ);
        this.ticksAlive = 0;
        this.setNoGravity(true);
    }
    protected void entityInit()
    {
        super.entityInit();
        this.noClip = true;
    }
    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setInteger("life", this.ticksAlive);
    }
    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.ticksAlive = compound.getInteger("life");
    }
    @Override
    public void onUpdate()
    {
        super.onUpdate();
        if (this.world.isRemote)
        {
            if (this.ticksExisted == 1)
            {
                for (int j = 0; j < 8 * 4; ++j) {
                    float f = this.rand.nextFloat() * ((float) Math.PI * 2F);
                    float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
                    float f2 = MathHelper.sin(f) * 0.5F * 3.0F * f1;
                    float f3 = MathHelper.cos(f) * 0.5F * 3.0F * f1;

                    double d0 = this.posX + (double) f2;
                    double d1 = this.posZ + (double) f3;

                    this.world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, d0, this.posY, d1, 0.0f, 0.0f, 0.0f);
                }
            }
            return;
        }
        if (this.caster == null || this.caster.isDead)
            this.setDead();
        if (this.ticksAlive > 100)
        {
            this.setDead();
        }
        else if (this.ticksAlive == 0)
        {
            this.playSound(NecropolisSounds.NOSFERATU_END, 1.0f, 1.0f);
        }
        this.collideWithEntities(this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().grow(1.0D)));
        this.ticksAlive++;
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
                                ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.POISON,200));
                            }
                        }
                        else
                        {
                            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.POISON,200));
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
