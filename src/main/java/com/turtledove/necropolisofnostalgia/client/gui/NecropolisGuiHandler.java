package com.turtledove.necropolisofnostalgia.client.gui;

import com.turtledove.necropolisofnostalgia.server.events.NecropolisCapabilities;
import com.turtledove.necropolisofnostalgia.server.tiles.TileEntityBakeKettle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class NecropolisGuiHandler implements IGuiHandler
{
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        Entity entity = world.getEntityByID(x);
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));

        if (ID == 0)
        {
            INecropolisItemHandler iData = player.getCapability(NecropolisCapabilities.ITEM_HANDLER_CAPABILITY, null);
            return new InventoryContainer(player.inventory,iData, player);
        }
        else if (ID == 1)
        {
            return new BakeKettleContainer(player.inventory,(TileEntityBakeKettle)tile);
        }
        return null;
    }
    @Nullable
    @Override
    @SideOnly(Side.CLIENT)
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        Entity entity = world.getEntityByID(x);
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));

        if (ID == 0)
        {
            INecropolisItemHandler iData = player.getCapability(NecropolisCapabilities.ITEM_HANDLER_CAPABILITY, null);
            return new NecropolisInventory(new InventoryContainer(player.inventory,iData, player));
        }
        else if (ID == 1)
        {
            return new GuiBakeKettle(player.inventory, (TileEntityBakeKettle)tile);
        }
        else if (ID == 2)
        {
            return new WanderingMerchantGUI(player);
        }
        return entity;
    }
}
