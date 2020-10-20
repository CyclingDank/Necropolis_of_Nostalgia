package com.turtledove.withernauts.server.ai;

import com.turtledove.withernauts.server.entity.NecropolisEntity;
import com.turtledove.withernauts.server.tiles.TileEntityBarrierBlastia;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class EntityAIOccupyVillage extends EntityAIBase
{
    private final NecropolisEntity entity;
    private final double movementSpeed;
    private Path path;

    public EntityAIOccupyVillage(NecropolisEntity entityIn, double movementSpeedIn)
    {
        this.entity = entityIn;
        this.movementSpeed = movementSpeedIn;

        this.setMutexBits(7);
    }
    public boolean shouldExecute()
    {
        if (this.entity.targetofmyrevenge != null || this.entity.isRaider() == false)
        {
            return false;
        }
        else
        {
            if (this.worldHasBarrierBlastia() == false)
                return false;

            BlockPos blastiaPos = this.entity.getPosition();
            double range = 0.0;
            for (TileEntity tEntity : this.entity.world.loadedTileEntityList)
            {
                double min = Double.POSITIVE_INFINITY;
                if (tEntity instanceof TileEntityBarrierBlastia)
                {
                    double x1 = Math.pow(blastiaPos.getX() - this.entity.posX, 2.0);
                    double z1 = Math.pow(blastiaPos.getZ() - this.entity.posZ, 2.0);
                    if (Math.sqrt(x1 + z1) < min)
                    {
                        min = Math.sqrt(x1 + z1);
                        blastiaPos = tEntity.getPos();
                        range = (double)(((TileEntityBarrierBlastia) tEntity).getRange()) - 2.0;
                    }
                }
            }

            BlockPos dest = blastiaPos.add((range * Math.random() * 2.0D) - range, -2.0D, (range * Math.random() * 2.0D)  - range);

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
                this.entity.getNavigator().tryMoveToXYZ(blastiaPos.getX(), blastiaPos.getY() - 2, blastiaPos.getZ(), this.movementSpeed);
                return false;
            }
        }
    }

    @Override
    public boolean shouldContinueExecuting()
    {
        if (this.entity.getNavigator().noPath())
            return false;
        if (this.entity.targetofmyrevenge != null || this.entity.isRaider() == false)
            return false;

        return true;
    }

    public void startExecuting()
    {
        this.entity.getNavigator().setPath(this.path, this.movementSpeed);
    }

    @Override
    public void resetTask()
    {
        super.resetTask();
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
