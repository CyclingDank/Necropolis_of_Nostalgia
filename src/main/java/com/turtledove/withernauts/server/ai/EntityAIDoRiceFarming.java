package com.turtledove.withernauts.server.ai;

import com.turtledove.withernauts.server.blocks.BlockHandler;
import com.turtledove.withernauts.server.blocks.BlockRice;
import com.turtledove.withernauts.server.entity.NecropolisNPC;
import com.turtledove.withernauts.server.item.ItemHandler;
import com.turtledove.withernauts.server.item.ItemRiceSeed;
import com.turtledove.withernauts.server.tiles.TileEntityBarrierBlastia;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class EntityAIDoRiceFarming extends EntityAIBase
{
    private final NecropolisNPC entity;
    private final double movementSpeed;
    private final boolean isNocturnal;
    private Path path;

    private boolean isGoingFarming;
    private BlockPos currentFarmPlot;

    private boolean startedFarming;
    private BlockPos currentCropPos;

    public EntityAIDoRiceFarming(NecropolisNPC entityIn, double movementSpeedIn, boolean isNocturnalIn)
    {
        this.entity = entityIn;
        this.movementSpeed = movementSpeedIn;
        this.isNocturnal = isNocturnalIn;

        this.isGoingFarming = false;
        this.startedFarming = false;

        this.currentFarmPlot = entityIn.getPosition();
        this.currentCropPos = entityIn.getPosition();
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
            if (this.entity.npcIsRiceFarmer() == false)
                return false;
            if (this.entity.world.isDaytime() == false)
                return false;
            if (this.entity.npcHasWork() == false || this.entity.npcHasHome() == false)
                return false;
            if (this.worldHasBarrierBlastia() == false)
                return false;

            BlockPos blastiaPos = this.entity.getPosition();
            double range = 0.0;
            for (TileEntity tEntity : this.entity.world.loadedTileEntityList)
            {
                if (tEntity instanceof TileEntityBarrierBlastia)
                {
                    blastiaPos = tEntity.getPos();
                    range = (double)(((TileEntityBarrierBlastia) tEntity).getRange()) - 2.0;
                }
            }

            BlockPos dest = blastiaPos.add((range * Math.random() * 2.0D) - range, -2.0D, (range * Math.random() * 2.0D)  - range);

            //get farmplot blueprints
            if (this.entity.npcHasWork())
            {

                List<BlockPos> localFarms = this.entity.getRiceFarmPos();
                for (BlockPos farmPlotPos : localFarms)
                {
                    if (this.plotNeedsSeeds(farmPlotPos) == true || this.plotNeedsHarvest(farmPlotPos) == true)
                    {
                        dest = farmPlotPos;
                        this.currentFarmPlot = farmPlotPos;
                    }
                }
            }
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
    public void updateTask()
    {
        super.updateTask();
        if (this.entity.getDistance(this.currentFarmPlot.getX(), this.currentFarmPlot.getY(), this.currentFarmPlot.getZ()) <= 4.0 &&
                this.isGoingFarming == false)
        {
            this.setFarmerTask(true);
        }
        if (this.isGoingFarming == true && this.startedFarming == false)
        {
            for (int i = -2; i < 3; i++)
            {
                for (int j = -2; j < 3; j++)
                {
                    if ((this.entity.world.isAirBlock(new BlockPos(this.currentFarmPlot.getX() + i, this.currentFarmPlot.getY() + 2, this.currentFarmPlot.getZ() + j))
                            || this.blockCanHarvet(new BlockPos(this.currentFarmPlot.getX() + i, this.currentFarmPlot.getY() + 2, this.currentFarmPlot.getZ() + j)))
                            && this.entity.world.getBlockState(new BlockPos(this.currentFarmPlot.getX() + i, this.currentFarmPlot.getY() + 1, this.currentFarmPlot.getZ() + j)).getBlock().equals(Blocks.WATER)
                            && this.entity.world.getBlockState(new BlockPos(this.currentFarmPlot.getX() + i, this.currentFarmPlot.getY(), this.currentFarmPlot.getZ() + j)).getBlock().equals(Blocks.DIRT))
                    {
                        this.currentCropPos = new BlockPos(this.currentFarmPlot.getX() + i, this.currentFarmPlot.getY() + 2, this.currentFarmPlot.getZ() + j);
                        this.startedFarming = true;

                        this.entity.getNavigator().clearPath();
                    }
                }
            }
        }
        if (this.startedFarming == true)
        {
            if (this.entity.world.isAirBlock(this.currentCropPos))
            {

                for (int i = 0; i < 36; i++)
                {
                    ItemStack itemstack = entity.getStackInSlot(i);
                    if (itemstack.getItem() instanceof ItemRiceSeed)
                    {
                        this.entity.world.setBlockState(this.currentCropPos, BlockHandler.RICE.getDefaultState());
                        entity.decrStackSize(i, 1);
                        this.entity.playSound(SoundEvents.BLOCK_GRASS_PLACE, 0.7F, 1.0F);
                        break;
                    }
                }
            }
            else if (this.blockCanHarvet(this.currentCropPos))
            {
                this.entity.setItemsInInventory(new ItemStack(ItemHandler.RICE_SEED, 3));
                this.entity.world.spawnEntity(new EntityXPOrb(this.entity.world, this.entity.posX, this.entity.posY + 0.3, this.entity.posZ,2));
                this.entity.world.setBlockToAir(this.currentCropPos);
                this.entity.playSound(SoundEvents.BLOCK_GRASS_BREAK, 0.7F, 1.0F);
            }
            this.startedFarming = false;
        }
    }
    @Override
    public boolean shouldContinueExecuting()
    {
        if (this.entity.world.isDaytime() == false)
            return false;

        if (this.entity.getNavigator().noPath())
            return false;

        if (this.entity.ticksExisted % 20 == 0)
        {
            if (this.isGoingFarming == true)
            {
                if (this.plotNeedsSeeds(this.currentFarmPlot) == false && this.plotNeedsHarvest(this.currentFarmPlot) == false)
                    return false;
            }
        }

        return true;
    }

    public boolean plotNeedsSeeds(BlockPos pos)
    {
        for (int i = -2; i < 3; i++)
        {
            for (int j = -2; j < 3; j++)
            {
                if (this.entity.world.getBlockState(new BlockPos(pos.getX() + i, pos.getY() + 1, pos.getZ() + j)).getBlock().equals(Blocks.WATER)
                && this.entity.world.getBlockState(new BlockPos(pos.getX() + i, pos.getY(), pos.getZ() + j)).getBlock().equals(Blocks.DIRT))
                {
                    if (this.entity.world.isAirBlock(new BlockPos(pos.getX() + i, pos.getY() + 2, pos.getZ() + j)))
                    {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public boolean blockCanHarvet(BlockPos pos)
    {
        BlockPos blockpos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        IBlockState iblockstate = this.entity.world.getBlockState(blockpos);
        Block block = iblockstate.getBlock();

        if (block instanceof BlockRice && ((BlockRice)block).isMaxAge(iblockstate))
        {
            return true;
        }
        return false;
    }


    public boolean plotNeedsHarvest(BlockPos pos)
    {
        for (int i = -2; i < 3; i++)
        {
            for (int j = -2; j < 3; j++)
            {
                BlockPos blockpos = new BlockPos(pos.getX() + i, pos.getY() + 2, pos.getZ() + j);

                if (this.entity.world.getBlockState(blockpos.down()).getBlock().equals(Blocks.WATER)
                && this.entity.world.getBlockState(blockpos.down().down()).getBlock().equals(Blocks.DIRT))
                {
                    IBlockState iblockstate = this.entity.world.getBlockState(blockpos);
                    Block block = iblockstate.getBlock();

                    if (block instanceof BlockRice && ((BlockRice)block).isMaxAge(iblockstate))
                    {
                        return true;
                    }
                }

            }
        }
        return false;
    }


    public void setFarmerTask(boolean val)
    {
        this.isGoingFarming = val;
    }

    public void startExecuting()
    {
        this.entity.getNavigator().setPath(this.path, this.movementSpeed);
    }

    @Override
    public void resetTask()
    {
        super.resetTask();
        this.isGoingFarming = false;
        this.startedFarming = false;
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
