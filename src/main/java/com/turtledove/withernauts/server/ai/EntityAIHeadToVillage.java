package com.turtledove.withernauts.server.ai;

import com.turtledove.withernauts.server.entity.NecropolisNPC;
import com.turtledove.withernauts.server.tiles.TileEntityBarrierBlastia;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class EntityAIHeadToVillage extends EntityAIBase
{
    private final NecropolisNPC entity;
    private final double movementSpeed;
    private final boolean isNocturnal;
    private Path path;

    public EntityAIHeadToVillage(NecropolisNPC entityIn, double movementSpeedIn, boolean isNocturnalIn)
    {
        this.entity = entityIn;
        this.movementSpeed = movementSpeedIn;
        this.isNocturnal = isNocturnalIn;
        this.setMutexBits(1);
    }
    public boolean shouldExecute()
    {
        if ((this.isNocturnal && this.entity.world.isDaytime() ))
        {
            return false;
        }
        else
        {
            if (this.entity.getIsWild() == true)
                return false;
            if (this.worldHasBarrierBlastia() == false)
                return false;
            if (this.entity.npcHasWork() == true || this.entity.npcHasHome() == true)
                return false;
            BlockPos blastiaPos = this.entity.getPosition();
            for (TileEntity tEntity : this.entity.world.loadedTileEntityList)
            {
                if (tEntity instanceof TileEntityBarrierBlastia)
                {
                    blastiaPos = tEntity.getPos();
                    double x1 = Math.pow(blastiaPos.getX() - this.entity.posX, 2.0);
                    double z1 = Math.pow(blastiaPos.getZ() - this.entity.posZ, 2.0);
                    if (Math.sqrt(x1 + z1) <= ((TileEntityBarrierBlastia) tEntity).getRange())
                    {
                        return false;
                    }
                }
            }

            BlockPos dest = this.entity.getPosition();
            dest = blastiaPos;


            PathNavigateGround pathnavigateground = (PathNavigateGround)this.entity.getNavigator();
            pathnavigateground.setBreakDoors(false);
            pathnavigateground.setEnterDoors(true);
            this.path = pathnavigateground.getPathToPos(dest);

            if (this.path != null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    public boolean shouldContinueExecuting()
    {
        if (this.entity.getNavigator().noPath())
        {
            return false;
        }
        for (TileEntity tEntity : this.entity.world.loadedTileEntityList)
        {
            if (tEntity instanceof TileEntityBarrierBlastia)
            {
                BlockPos blastiaPos = tEntity.getPos();
                double x1 = Math.pow(blastiaPos.getX() - this.entity.posX, 2.0);
                double z1 = Math.pow(blastiaPos.getZ() - this.entity.posZ, 2.0);
                if (Math.sqrt(x1 + z1) <= ((TileEntityBarrierBlastia) tEntity).getRange())
                {
                    return false;
                }
            }
        }
        return true;
    }

    public void updateTask()
    {
        super.updateTask();
    }

    public void startExecuting()
    {
        this.entity.getNavigator().setPath(this.path, this.movementSpeed);
    }

    public boolean worldHasBarrierBlastia()
    {
        for (TileEntity tEntity : this.entity.world.loadedTileEntityList)
        {
            if (tEntity instanceof TileEntityBarrierBlastia)
            {
                return true;
            }
        }
        return false;
    }
}
