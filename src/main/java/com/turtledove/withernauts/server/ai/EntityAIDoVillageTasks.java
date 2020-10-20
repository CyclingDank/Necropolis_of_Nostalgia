package com.turtledove.withernauts.server.ai;

import com.turtledove.withernauts.server.entity.NecropolisNPC;
import com.turtledove.withernauts.server.item.ItemRiceSeed;
import com.turtledove.withernauts.server.tiles.TileEntityBarrierBlastia;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class EntityAIDoVillageTasks extends EntityAIBase
{
    private final NecropolisNPC entity;
    private final double movementSpeed;
    private final boolean isNocturnal;
    private int taskState = -1; //-1 is none, 0 is going home, 1 is going to work.
    private Path path;

    public EntityAIDoVillageTasks(NecropolisNPC entityIn, double movementSpeedIn, boolean isNocturnalIn)
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
            if (this.entity.npcHasWork() == false && this.entity.npcHasHome() == false)
                return false;
            if (this.worldHasBarrierBlastia() == false)
                return false;

            BlockPos blastiaPos = this.entity.getPosition();
            for (TileEntity tEntity : this.entity.world.loadedTileEntityList)
            {
                if (tEntity instanceof TileEntityBarrierBlastia)
                {
                    blastiaPos = tEntity.getPos();
                }
            }

            BlockPos dest = this.entity.getPosition();
            if (this.entity.world.isDaytime())
            {
                this.taskState = 0;
                if (this.entity.npcIsFarmer() == true || this.entity.npcIsRiceFarmer() == true)
                    return false;
                if (this.entity.npcHasWork())
                {
                    dest = this.entity.getWorkPos();
                }
                else
                {
                    dest = blastiaPos;
                }
            }
            else
            {
                this.taskState = 1;
                if (this.entity.npcHasHome())
                {
                    dest = this.entity.getHomePos();
                }
                else
                {
                    dest = blastiaPos;
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
        if (this.taskState == 0 && this.entity.world.isDaytime() == true)
            return false;
        else if (this.taskState == 1 && this.entity.world.isDaytime() == false)
        {
            if (this.entity.npcHasHome() && (this.entity.npcIsFarmer() || this.entity.npcIsRiceFarmer())) {
                BlockPos homePos = this.entity.getHomePos();
                if (this.entity.world.getBlockState(homePos.up().north(1)).getBlock().equals(Blocks.CHEST)) {
                    TileEntity chestContainer = this.entity.world.getTileEntity(homePos.up().north(2));
                    this.setStorageContents(chestContainer);
                }
                else if (this.entity.world.getBlockState(homePos.up().south(1)).getBlock().equals(Blocks.CHEST)) {
                    TileEntity chestContainer = this.entity.world.getTileEntity(homePos.up().south(1));
                    this.setStorageContents(chestContainer);
                }
                else if (this.entity.world.getBlockState(homePos.up().east(1)).getBlock().equals(Blocks.CHEST)) {
                    TileEntity chestContainer = this.entity.world.getTileEntity(homePos.up().east(1));
                    this.setStorageContents(chestContainer);
                }
                else if (this.entity.world.getBlockState(homePos.up().west(1)).getBlock().equals(Blocks.CHEST)) {
                    TileEntity chestContainer = this.entity.world.getTileEntity(homePos.up().west(1));
                    this.setStorageContents(chestContainer);
                }
            }
            return false;
        }
        return true;
    }

    private void setStorageContents(TileEntity chestContainer)
    {
        if (chestContainer instanceof TileEntityChest) {
            IItemHandler chestContents = chestContainer.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
            for (int j = 0; j < 36; j++)
            {
                ItemStack itemInventory = this.entity.getStackInSlot(j);
                if (!(itemInventory.getItem() instanceof ItemSeeds) && !(itemInventory.getItem() instanceof ItemSeedFood))
                {

                    for (int i = 0; i < chestContents.getSlots(); i++)
                    {
                        if (itemInventory.isEmpty())
                            break;
                        if (chestContents.getStackInSlot(i).getItem().equals(itemInventory.getItem()) || chestContents.getStackInSlot(i).isEmpty())
                        {
                            int size = chestContents.getStackInSlot(i).getCount() + itemInventory.getCount();
                            int retStackSize = 0;
                            if (size > 64) {
                                retStackSize = size - 64;
                                size = 64;
                            }

                            chestContents.insertItem(i, new ItemStack(itemInventory.getItem(), size), false);
                            itemInventory.setCount(retStackSize);
                        }
                        else
                        {
                            break;
                        }
                    }
                    this.entity.setInventorySlot(j, itemInventory);
                }
                else if ((itemInventory.getItem() instanceof ItemRiceSeed || itemInventory.getItem() instanceof ItemSeedFood) && itemInventory.getCount() > 1 )
                {
                    for (int i = 0; i < chestContents.getSlots(); i++)
                    {
                        if (itemInventory.isEmpty())
                            break;

                        if (chestContents.getStackInSlot(i).getItem().equals(itemInventory.getItem()) || chestContents.getStackInSlot(i).isEmpty())
                        {
                            int size = chestContents.getStackInSlot(i).getCount() + itemInventory.getCount() / 2;
                            int retStackSize = itemInventory.getCount() - itemInventory.getCount() / 2;
                            if (size > 64) {
                                retStackSize = size - 64 + retStackSize;
                                size = 64;
                            }
                            chestContents.insertItem(i, new ItemStack(itemInventory.getItem(), size), false);
                            itemInventory.setCount(retStackSize);
                        }
                        else
                        {
                            break;
                        }
                    }
                    this.entity.setInventorySlot(j, itemInventory);
                }
            }
        }
    }

    public void updateTask()
    {
        super.updateTask();
    }

    public void startExecuting()
    {
        this.entity.getNavigator().setPath(this.path, this.movementSpeed);
    }

    public void resetTask()
    {
        this.taskState = -1;
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
