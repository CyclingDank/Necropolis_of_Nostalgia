package com.turtledove.withernauts.server.entity.items;

import com.turtledove.withernauts.server.entity.EntityCasted;
import com.turtledove.withernauts.server.item.ItemNecropolisTome;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityBook extends EntityCasted
{
    public int ticksLifetime;
    private int ticksAlive;

    private static final DataParameter<Integer> VARIANT = EntityDataManager.<Integer>createKey(EntityBook.class, DataSerializers.VARINT);
    private int variant;

    public EntityBook(World worldIn)
    {
        super(worldIn);
        this.noClip = true;
    }
    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(VARIANT, Integer.valueOf(this.variant));
    }
    public EntityBook (World worldIn, EntityPlayer player, int ticksLifetime, int id)
    {
        super(worldIn, player);
        this.noClip = true;
        this.ignoreFrustumCheck = true;
        this.setSize(1.0F, 1.0F);
        this.setLocationAndAngles(caster.posX + caster.getLookVec().x * 0.5F,caster.posY + caster.getLookVec().y * 0.75F + 1.2F,caster.posZ + caster.getLookVec().z * 0.5F, caster.rotationYaw, caster.rotationPitch);
        this.ticksLifetime = ticksLifetime;
        this.ticksAlive = 0;
        this.setNoGravity(true);

        this.variant = id;
    }

    public int getTextureID()
    {
        return ((Integer)this.dataManager.get(VARIANT)).intValue();
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setInteger("book_id", this.variant);
    }
    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.variant = compound.getInteger("book_id");
    }


    @Override
    public void onUpdate()
    {
        super.onUpdate();
        if (this.caster == null || this.caster.isDead)
            this.setDead();
        if (this.caster != null)
        {
            this.setPositionAndRotationDirect(caster.posX + caster.getLookVec().x * 0.5F,caster.posY + caster.getLookVec().y * 0.75F + 1.2F,caster.posZ + caster.getLookVec().z * 0.5F, caster.rotationYaw, caster.rotationPitch,2,true);
            prevRotationYaw = rotationYaw;
            prevRotationPitch = rotationPitch;
        }
        if (!(((EntityPlayer)this.caster).getHeldItemMainhand().getItem() instanceof ItemNecropolisTome))
            this.setDead();
        if (!this.world.isRemote)
        {
            this.dataManager.set(VARIANT, Integer.valueOf(this.variant));
            if (this.ticksAlive > ticksLifetime)
                this.setDead();
            if (this.ticksAlive == 1)
                AnimationHandler.INSTANCE.sendAnimationMessage(this, OPEN_ANIMATION);
            this.ticksAlive++;
        }
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
