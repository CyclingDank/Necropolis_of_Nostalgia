package com.turtledove.necropolisofnostalgia.server.entity.Artes;

import com.turtledove.necropolisofnostalgia.server.entity.EntityCasted;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityMeteor extends EntityCasted
{
    private int ticksAlive;
    private float damage;
    private int deathCounter;

    public EntityMeteor(World worldIn)
    {
        super(worldIn);
        this.setSize(3.0F, 0.25F);
    }
    public EntityMeteor (World worldIn, EntityPlayer player, Vec3d pos, float damage)
    {
        super(worldIn, player);
        this.noClip = true;
        this.setPosition(pos.x + this.rand.nextFloat() * 40F - 20F,pos.y + 60,pos.z + this.rand.nextFloat() * 40F - 20F);
        this.setSize(3.0F, 0.25F);
        this.motionY = -2.0F;
        this.ticksAlive = 0;
        this.arte_element = 3;
        this.damage = damage;
        this.deathCounter = 0;

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
        compound.setInteger("deathCounter", this.deathCounter);
    }
    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.damage = compound.getFloat("damage");
        this.ticksAlive = compound.getInteger("life");
        this.deathCounter = compound.getInteger("deathCounter");
    }
    @Override
    public void onUpdate()
    {
        super.onUpdate();
        if (this.caster == null || this.caster.isDead)
        {
            this.setDead();
            return;
        }
        if (this.deathCounter >= 40)
        {
            this.setDead();
            return;
        }
        this.motionY = -2.0F;
        if (this.posY <= this.caster.posY)
        {
            if (Minecraft.getMinecraft().world.getBlockState(this.getPosition()).getBlock() != Blocks.AIR)
            {
                if (this.deathCounter == 0)
                {
                    this.playSound(NecropolisSounds.ERUPTION_CAST, 0.5F,1.0F);
                    int validPos = 0;
                    for (int i = 0; i < 255; i++)
                    {
                        Vec3d nPos = new Vec3d(this.posX, this.posY + i, this.posZ);
                        if (Minecraft.getMinecraft().world.getBlockState(new BlockPos(nPos)).getBlock() == Blocks.AIR)
                        {
                            validPos = i;
                            break;
                        }
                    }
                    Vec3d strikePos = new Vec3d(this.posX, (double)((int)(this.posY + validPos)), this.posZ);
                    EntityGroundStrike entityGroundStrike = new EntityGroundStrike(this.world, (EntityPlayer)this.caster, strikePos,3, this.damage);
                    this.world.spawnEntity(entityGroundStrike);
                }
                this.deathCounter++;
            }
        }
        this.ticksAlive++;
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