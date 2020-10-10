package com.turtledove.necropolisofnostalgia.server.entity.Artes;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.server.entity.EntityCasted;
import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.server.packets.Player.PlayerParticlePacket;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class EntityNosferatu extends EntityCasted
{
    private int ticksAlive;
    private float damage;

    float dirX;
    float dirY;
    float dirZ;

    public EntityNosferatu(World worldIn)
    {
        super(worldIn);
        this.setSize(0.5F, 0.5F);
        this.noClip = true;
        this.setNoGravity(true);
    }
    public EntityNosferatu (World worldIn, EntityPlayer player, double dirX, double dirY, double dirZ, float damage)
    {
        super(worldIn, player);
        this.noClip = true;
        this.setSize(0.5F, 0.5F);
        this.ticksAlive = 0;
        this.arte_element = 4;
        this.damage = damage;

        float d0 = MathHelper.sqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);

        this.dirX = (float)dirX / d0;
        this.dirY = (float)dirY / d0;
        this.dirZ = (float)dirZ / d0;

        this.setNoGravity(true);
    }
    public EntityNosferatu (World worldIn, NecropolisEntity monster, double dirX, double dirY, double dirZ, float damage)
    {
        super(worldIn, monster);
        this.noClip = true;
        this.setSize(0.5F, 0.5F);
        this.ticksAlive = 0;
        this.arte_element = 4;
        this.damage = damage;

        float d0 = MathHelper.sqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);

        this.dirX = (float)dirX / d0;
        this.dirY = (float)dirY / d0;
        this.dirZ = (float)dirZ / d0;

        this.setNoGravity(true);
    }
    protected void entityInit()
    {
        super.entityInit();
        this.setSize(0.5F, 0.5F);
        this.noClip = true;
        this.setNoGravity(true);
    }
    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setFloat("damage", this.damage);
        compound.setInteger("life", this.ticksAlive);
        compound.setFloat("dirX", this.dirX);
        compound.setFloat("dirY", this.dirY);
        compound.setFloat("dirZ", this.dirZ);
    }
    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.damage = compound.getFloat("damage");
        this.ticksAlive = compound.getInteger("life");
        this.dirX = compound.getFloat("dirX");
        this.dirY = compound.getFloat("dirY");
        this.dirZ = compound.getFloat("dirZ");
    }
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.caster == null || this.caster.isDead)
            this.setDead();
        if (this.ticksAlive >= 1000)
            this.setDead();
        if (!world.isRemote)
        {
            this.motionX = this.dirX;
            this.motionY = this.dirY;
            this.motionZ = this.dirZ;
            //this.posX += this.motionX;
            //this.posY += this.motionY;
            //this.posZ += this.motionZ;

            if (this.ticksAlive == 0)
            {
                this.playSound(NecropolisSounds.NOSFERATU_CAST, 1.0f, 1.0f);
            }

            if (!(this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().grow(1.0D))).isEmpty())
                this.collideWithEntities(this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().grow(1.0D)));
            else
                this.blockImpact();
            this.ticksAlive++;
        }
        else
        {
            if (this.ticksExisted % 10 == 0)
            {
                this.world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
            }
            if (this.ticksExisted % 3 == 0)
            {
                this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
            }
        }
    }

    private void blockImpact()
    {
        if (!this.world.isAirBlock(this.getPosition()) && this.world.isBlockFullCube(this.getPosition()))
        {
            if (this.caster instanceof EntityPlayer)
            {
                EntityNosferatuCloud entityNosferatuCloud = new EntityNosferatuCloud(this.world, (EntityPlayer) caster, this.posX, this.posY + 1.0D, this.posZ);
                this.world.spawnEntity(entityNosferatuCloud);
                this.setDead();
            }
            else if (this.caster instanceof NecropolisEntity)
            {
                EntityNosferatuCloud entityNosferatuCloud = new EntityNosferatuCloud(this.world, (NecropolisEntity) caster, this.posX, this.posY + 1.0D, this.posZ);
                this.world.spawnEntity(entityNosferatuCloud);
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
                    if (!entity.isEntityEqual(this.caster) && !(entity instanceof EntityCasted))
                    {
                        if (this.caster instanceof NecropolisEntity)
                        {
                            if (!(entity instanceof NecropolisEntity))
                            {
                                entity.attackEntityFrom(DamageSource.causeMobDamage(this), this.damage);
                                ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.POISON,200));
                                EntityNosferatuCloud entityNosferatuCloud = new EntityNosferatuCloud(this.world, (NecropolisEntity)caster, this.posX, this.posY, this.posZ);
                                this.world.spawnEntity(entityNosferatuCloud);
                                this.setDead();
                            }
                        }
                        else
                        {
                            entity.attackEntityFrom(DamageSource.causeMobDamage(this), this.damage);
                            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.POISON,200));
                            EntityNosferatuCloud entityNosferatuCloud = new EntityNosferatuCloud(this.world, (EntityPlayer) caster, this.posX, this.posY, this.posZ);
                            this.world.spawnEntity(entityNosferatuCloud);
                            this.setDead();
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
