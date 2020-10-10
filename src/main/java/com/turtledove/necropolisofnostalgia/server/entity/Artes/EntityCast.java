package com.turtledove.necropolisofnostalgia.server.entity.Artes;
import com.turtledove.necropolisofnostalgia.server.entity.EntityCasted;
import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.server.item.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityCast extends EntityCasted
{
    private int ticksAlive;
    private int ticksLifetime;

    public EntityCast(World worldIn)
    {
        super(worldIn);
        this.setSize(1.0F, 1.0F);
    }
    public EntityCast (World worldIn, EntityPlayer player, int ticksLifetime)
    {
        super(worldIn, player);
        this.noClip = true;
        this.setPosition(player.posX + 0.125f,player.posY,player.posZ);
        this.ticksLifetime = ticksLifetime;
        this.ticksAlive = 0;
        this.arte_element = 0;
        this.setNoGravity(true);
    }
    public EntityCast (World worldIn, NecropolisEntity monster, int ticksLifetime)
    {
        super(worldIn, monster);
        this.noClip = true;
        this.setPosition(monster.posX + 0.125f,monster.posY,monster.posZ);
        this.ticksLifetime = ticksLifetime;
        this.ticksAlive = 0;
        this.arte_element = 0;
        this.setNoGravity(true);
    }
    protected void entityInit()
    {
        super.entityInit();
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
        if (this.caster instanceof EntityPlayer)
        {
            if (!(this.caster.getHeldItemMainhand().getItem() instanceof ItemDiamondRapier ||
                    this.caster.getHeldItemMainhand().getItem() instanceof ItemIronRapier ||
                    this.caster.getHeldItemMainhand().getItem() instanceof ItemGoldRapier ||
                    this.caster.getHeldItemMainhand().getItem() instanceof ItemStoneRapier ||
                    this.caster.getHeldItemMainhand().getItem() instanceof ItemWoodenRapier || this.caster.getHeldItemMainhand().getItem() instanceof ItemNecropolisRapier || this.caster.getHeldItemMainhand().getItem() instanceof ItemNecropolisTome))
                this.setDead();
        }
        if (!this.world.isRemote)
        {
            if (ticksAlive < ticksLifetime)
            {
                this.setPosition(caster.posX,caster.posY,caster.posZ);
                ticksAlive++;
            }
            else
            {
                ticksAlive = 0;
                this.setDead();
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
