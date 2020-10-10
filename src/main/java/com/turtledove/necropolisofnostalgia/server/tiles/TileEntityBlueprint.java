package com.turtledove.necropolisofnostalgia.server.tiles;

import com.turtledove.necropolisofnostalgia.common.structures.BlueprintHandler;
import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class TileEntityBlueprint extends TileEntity implements ITickable
{

    int tileIndex; // 0 is house1, 1 is etc...
    private boolean isFinished;
    BlueprintHandler blueprintHandler = new BlueprintHandler();

    public TileEntityBlueprint()
    {
        super();
        this.tileIndex = 0;
        this.isFinished = false;
    }
    public TileEntityBlueprint(int tileIndex)
    {
        this.tileIndex = tileIndex;
    }
    public void update()
    {
        if (!this.world.isRemote)
        {
            if (blueprintHandler.isFinished(this.world, this.pos, this.tileIndex))
            {
                if (this.isFinished == false)
                {
                    this.isFinished = true;
                    sendToBlastia();
                    System.out.print("HOME FINISHED");
                    System.out.printf("%n");
                }
                this.isFinished = true;
            }
            else
            {
                if (this.isFinished == true)
                {
                    this.isFinished = false;
                    System.out.print("HOME BROKEN");
                    System.out.printf("%n");
                    sendToBlastia();
                }
                this.isFinished = false;
            }
        }
    }

    public void sendToBlastia()
    {
        for (TileEntity tEntity : this.world.loadedTileEntityList)
        {
            if (tEntity instanceof TileEntityBarrierBlastia)
            {
                if (this.isFinished == true)
                    ((TileEntityBarrierBlastia)(tEntity)).setTile(this.tileIndex, this.pos);
                else
                    ((TileEntityBarrierBlastia)(tEntity)).resetTile(this.tileIndex);
            }
        }
    }

    public void destroyBlueprint(BlockPos pos)
    {
        for (TileEntity tEntity : this.world.loadedTileEntityList)
        {
            if (tEntity instanceof TileEntityBarrierBlastia)
            {
                ((TileEntityBarrierBlastia)(tEntity)).destroyTile(this.tileIndex, pos);
            }
        }
    }

    public int getTileIndex()
    {
        return this.tileIndex;
    }

    public boolean tileFinished()
    {
        return this.isFinished;
    }



    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.tileIndex = compound.getInteger("tile_index");
    }
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("tile_index", this.tileIndex);
        return compound;
    }
}