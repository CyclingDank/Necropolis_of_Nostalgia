package com.turtledove.withernauts.server.entity.Artes;

import com.turtledove.withernauts.server.entity.EntityCasted;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityOFController extends EntityCasted
{
    private int ticksAlive;
    private float damage;

    double dirX, dirZ, centerX, centerZ;

    public EntityOFController(World worldIn)
    {
        super(worldIn);
        this.setSize(3.0F, 0.25F);
    }
    public EntityOFController (World worldIn, EntityPlayer player, double dX, double dZ, float damage)
    {
        super(worldIn, player);
        this.noClip = true;
        this.setPosition(player.posX,player.posY,player.posZ);
        centerX = player.posX;
        centerZ = player.posZ;

        double d0 = Math.sqrt(dX * dX + dZ * dZ);

        if (d0 == 0.0)
            d0 = 1.0D;

        this.dirX = dX / d0;
        this.dirZ = dZ / d0;
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

        compound.setDouble("centerX", this.centerX);
        compound.setDouble("centerZ", this.centerZ);
        compound.setDouble("dirX", this.dirX);
        compound.setDouble("dirZ", this.dirZ);

    }
    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.damage = compound.getFloat("damage");
        this.ticksAlive = compound.getInteger("life");

        this.centerX = compound.getDouble("centerX");
        this.centerZ = compound.getDouble("centerZ");
        this.dirX = compound.getDouble("dirX");
        this.dirZ = compound.getDouble("dirZ");
    }
    @Override
    public void onUpdate()
    {
        super.onUpdate();
        if (this.world.isRemote)
            return;
        if (this.caster == null || this.caster.isDead)
            this.setDead();

        if (this.ticksAlive % 5 == 0)
        {
            Vec3d tesPos = getGeyserPos(new Vec3d(this.posX, this.posY, this.posZ), this.ticksAlive / 5);

            if (!(tesPos.equals(new Vec3d(this.posX, this.posY, this.posZ))))
            {
                if (isSpaceValid(tesPos) || isBlockValid(tesPos))
                {
                    EntityOF entityOF1 = new EntityOF(this.world, (EntityPlayer)this.caster, this.damage);
                    entityOF1.setPosition(tesPos.x, tesPos.y, tesPos.z);
                    this.world.spawnEntity(entityOF1);
                }
            }
        }
        if (this.ticksAlive > 90)
            this.setDead();
        this.ticksAlive++;
    }

    public boolean isBlockValid(Vec3d tesPos)
    {
        return (!this.world.isBlockFullCube((new BlockPos(tesPos)).up()) && this.world.isBlockFullCube(new BlockPos(tesPos)));
    }

    public Vec3d checkUp(Vec3d testPos, int depth)
    {
        for (int i = 0; i < depth; i++)
        {
            Vec3d neighborPos = new Vec3d(testPos.x, testPos.y + i, testPos.z);
            if (isSpaceValid(neighborPos))
                return neighborPos;
        }
        return testPos;
    }

    public Vec3d checkDown(Vec3d testPos, int depth)
    {
        for (int i = 0; i < depth; i++)
        {
            Vec3d neighborPos = new Vec3d(testPos.x, testPos.y - i, testPos.z);
            if (isBlockValid(neighborPos))
                return neighborPos;
        }
        return testPos;
    }

    public Vec3d getGeyserPos(Vec3d testPos, int index)
    {
        Vec3d startPos = testPos;
        for (int i = 0; i < index; i++)
        {
            Vec3d actualPos = checkUp(startPos, 5);
            if (actualPos.equals(startPos))
            {
                actualPos = checkDown(startPos, 5);
            }
            startPos = new Vec3d(actualPos.x + dirX, actualPos.y, actualPos.z + dirZ);
        }
        return startPos;
    }

    public boolean isSpaceValid(Vec3d tesPos)
    {
        return (!this.world.isBlockFullCube(new BlockPos(tesPos)) && this.world.isBlockFullCube((new BlockPos(tesPos).down())));
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
