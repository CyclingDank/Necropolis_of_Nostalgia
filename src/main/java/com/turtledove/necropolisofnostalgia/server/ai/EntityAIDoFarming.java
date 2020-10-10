package com.turtledove.necropolisofnostalgia.server.ai;

import com.turtledove.necropolisofnostalgia.server.entity.NecropolisNPC;
import com.turtledove.necropolisofnostalgia.server.entity.npc.EntityYam;
import com.turtledove.necropolisofnostalgia.server.tiles.TileEntityBarrierBlastia;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.Sys;

import java.util.List;
import java.util.Random;

public class EntityAIDoFarming extends EntityAIBase
{
    private final NecropolisNPC entity;
    private final double movementSpeed;
    private final boolean isNocturnal;
    private Path path;

    private boolean isGoingFarming;
    private BlockPos currentFarmPlot;

    private boolean startedFarming;
    private BlockPos currentCropPos;

    private boolean isMeandering;

    private int cropType; //0 is wheat, 1 is potato, 2 is beet, 3 is carrot, 4 is misc

    public EntityAIDoFarming(NecropolisNPC entityIn, int cropID, double movementSpeedIn, boolean isNocturnalIn)
    {
        this.entity = entityIn;
        this.cropType = cropID;
        this.movementSpeed = movementSpeedIn;
        this.isNocturnal = isNocturnalIn;

        this.isGoingFarming = false;
        this.startedFarming = false;

        this.currentFarmPlot = entityIn.getPosition();
        this.currentCropPos = entityIn.getPosition();

        this.isMeandering = true;
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
            if (this.entity.world.isDaytime() == false)
                return false;

            if (this.entity.npcIsFarmer() == false)
                return false;
            if (this.entity.npcHasWork() == false || this.entity.npcHasHome() == false)
                return false;
            if (this.worldHasBarrierBlastia() == false)
                return false;

            BlockPos blastiaPos = this.entity.getPosition();
            int range = 0;
            for (TileEntity tEntity : this.entity.world.loadedTileEntityList)
            {
                if (tEntity instanceof TileEntityBarrierBlastia)
                {
                    blastiaPos = tEntity.getPos();
                    range = ((TileEntityBarrierBlastia) tEntity).getRange() - 2;
                }
            }


            BlockPos dest = blastiaPos.add((range * Math.random() * 2.0D) - range, -2.0D, (range * Math.random() * 2.0D)  - range);


            //get farmplot blueprints
            if (this.entity.npcHasWork())
            {

                List<BlockPos> localFarms = this.entity.getFarmPos();
                for (BlockPos farmPlotPos : localFarms)
                {
                    if (this.plotNeedsSeeds(farmPlotPos) == true || this.plotNeedsHarvest(farmPlotPos) == true)
                    {
                        dest = farmPlotPos;
                        this.isMeandering = false;
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
        this.isGoingFarming == false && this.isMeandering == false)
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
                    && this.entity.world.getBlockState(new BlockPos(this.currentFarmPlot.getX() + i, this.currentFarmPlot.getY() + 1, this.currentFarmPlot.getZ() + j)).getBlock().equals(Blocks.FARMLAND))
                    {
                        this.currentCropPos = new BlockPos(this.currentFarmPlot.getX() + i, this.currentFarmPlot.getY() + 2, this.currentFarmPlot.getZ() + j);
                        this.startedFarming = true;

                        PathNavigateGround pathnavigateground = (PathNavigateGround)this.entity.getNavigator();
                        pathnavigateground.setBreakDoors(false);
                        pathnavigateground.setEnterDoors(true);
                        this.path = pathnavigateground.getPathToPos(this.currentCropPos);
                        this.entity.getNavigator().setPath(this.path, this.movementSpeed);
                        return;
                    }
                }
            }
        }
        if (this.startedFarming == true)
        {
            if (this.entity.getDistanceSq(this.currentCropPos.getX(), this.currentCropPos.getY(), this.currentCropPos.getZ()) <= 4.0)
            {
                if (this.entity.world.isAirBlock(this.currentCropPos))
                {

                    for (int i = 0; i < 36; i++)
                    {
                        ItemStack itemstack = entity.getStackInSlot(i);
                        if (itemstack.getItem() instanceof ItemSeeds)
                        {
                            IBlockState tPlant = ((ItemSeeds)itemstack.getItem()).getPlant(this.entity.world, this.currentCropPos);
                            this.entity.world.setBlockState(this.currentCropPos, tPlant);
                            entity.decrStackSize(i, 1);
                            this.entity.playSound(SoundEvents.BLOCK_GRASS_PLACE, 0.7F, 1.0F);
                            break;
                        }
                        else if (itemstack.getItem() instanceof ItemSeedFood)
                        {
                            IBlockState tPlant = ((ItemSeedFood)itemstack.getItem()).getPlant(this.entity.world, this.currentCropPos);
                            this.entity.world.setBlockState(this.currentCropPos, tPlant);
                            entity.decrStackSize(i, 1);
                            this.entity.playSound(SoundEvents.BLOCK_GRASS_PLACE, 0.7F, 1.0F);
                            break;
                        }
                    }
                }
                else if (this.blockCanHarvet(this.currentCropPos))
                {
                    ItemStack seedDropped = new ItemStack(((BlockCrops)this.entity.world.getBlockState(this.currentCropPos).getBlock()).getItemDropped(this.entity.world.getBlockState(this.currentCropPos), new Random(), 0));
                    if (seedDropped.getItem() instanceof ItemSeedFood)
                    {
                        this.entity.setItemsInInventory(new ItemStack(seedDropped.getItem(), 2));
                    }
                    else
                    {
                        this.entity.setItemsInInventory(new ItemStack(((BlockCrops)this.entity.world.getBlockState(this.currentCropPos).getBlock()).getItemDropped(this.entity.world.getBlockState(this.currentCropPos), new Random(), 0), 2));
                        this.entity.setItemsInInventory(new ItemStack((((BlockCrops)this.entity.world.getBlockState(this.currentCropPos).getBlock()).getItem(this.entity.world, this.currentCropPos, this.entity.world.getBlockState(this.currentCropPos))).getItem(), 2));
                    }
                    this.entity.world.spawnEntity(new EntityXPOrb(this.entity.world, this.entity.posX, this.entity.posY + 0.3, this.entity.posZ,2));
                    this.entity.world.setBlockToAir(this.currentCropPos);
                    this.entity.playSound(SoundEvents.BLOCK_GRASS_BREAK, 0.7F, 1.0F);
                }
                this.startedFarming = false;
            }
        }
    }

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
                if (this.entity.world.getBlockState(new BlockPos(pos.getX() + i, pos.getY() + 1, pos.getZ() + j)).getBlock().equals(Blocks.FARMLAND))
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
        if (this.getCropType(iblockstate) != this.cropType)
            return false;

        if (block instanceof BlockCrops && ((BlockCrops)block).isMaxAge(iblockstate))
        {
            return true;
        }
        return false;
    }

    public int getCropType(IBlockState iBlockState)
    {
        if (iBlockState.getBlock().equals(Blocks.WHEAT))
            return 0;
        else if (iBlockState.getBlock().equals(Blocks.POTATOES))
            return 1;
        else if (iBlockState.getBlock().equals(Blocks.BEETROOTS))
            return 2;
        else if (iBlockState.getBlock().equals(Blocks.CARROTS))
            return 3;
        else return 4;
    }


    public boolean plotNeedsHarvest(BlockPos pos)
    {
        for (int i = -2; i < 3; i++)
        {
            for (int j = -2; j < 3; j++)
            {
                BlockPos blockpos = new BlockPos(pos.getX() + i, pos.getY() + 2, pos.getZ() + j);

                if (this.entity.world.getBlockState(blockpos.down()).getBlock().equals(Blocks.FARMLAND))
                {
                    IBlockState iblockstate = this.entity.world.getBlockState(blockpos);
                    Block block = iblockstate.getBlock();

                    if (block instanceof BlockCrops && ((BlockCrops)block).isMaxAge(iblockstate))
                    {
                        if (this.cropType == this.getCropType(iblockstate))
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
        this.isMeandering = true;
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
