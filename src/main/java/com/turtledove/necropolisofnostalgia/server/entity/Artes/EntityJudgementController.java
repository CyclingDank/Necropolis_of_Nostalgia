package com.turtledove.necropolisofnostalgia.server.entity.Artes;

import com.turtledove.necropolisofnostalgia.server.entity.EntityCasted;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityJudgementController extends EntityCasted
{
    private int ticksAlive;
    private float damage;

    public EntityJudgementController(World worldIn)
    {
        super(worldIn);
        this.setSize(3.0F, 0.25F);
    }
    public EntityJudgementController (World worldIn, EntityPlayer player, float damage)
    {
        super(worldIn, player);
        this.noClip = true;
        this.setPosition(player.posX,player.posY,player.posZ);
        this.ticksAlive = 0;
        this.damage = damage;
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
        if (this.world.isRemote)
            return;
        if (this.caster == null || this.caster.isDead)
            this.setDead();
        if (this.ticksAlive >= 60)
            this.setDead();
        if (this.ticksAlive % 2 == 0)
        {
            EntityJudgement entityJudgement1 = new EntityJudgement(this.world, (EntityPlayer)this.caster, this.getPositionVector(),this.damage);
            EntityJudgement entityJudgement2 = new EntityJudgement(this.world, (EntityPlayer)this.caster, this.getPositionVector(),this.damage);
            this.world.spawnEntity(entityJudgement1);
            this.world.spawnEntity(entityJudgement2);

        }
        if (this.ticksAlive % 5 == 0)
        {
            EntityJudgement entityJudgement = new EntityJudgement(this.world, (EntityPlayer)this.caster, this.getPositionVector(),this.damage);
            this.world.spawnEntity(entityJudgement);
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
