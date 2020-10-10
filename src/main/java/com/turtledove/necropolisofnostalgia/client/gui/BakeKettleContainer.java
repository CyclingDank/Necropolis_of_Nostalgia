package com.turtledove.necropolisofnostalgia.client.gui;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class BakeKettleContainer extends SyncedContainer
{
    private final IInventory tileFurnace;
    private int cookTime;

    public BakeKettleContainer(InventoryPlayer playerInventory, IInventory furnaceInventory)
    {
        super(furnaceInventory);
        this.tileFurnace = furnaceInventory;

        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                this.addSlotToContainer(new Slot(furnaceInventory, j + i * 3, 28 + 18 * j, 19 + i * 18));
            }
        }
        this.addSlotToContainer(new SlotFurnaceOutput(playerInventory.player, furnaceInventory, 6, 127, 34));

        for (int i1 = 0; i1 < 9; ++i1)
        {
            this.addSlotToContainer(new Slot(playerInventory, i1, 7 + i1 * 18, 141));
        }
        for (int l = 0; l < 3; ++l)
        {
            for (int j1 = 0; j1 < 9; ++j1)
            {
                this.addSlotToContainer(new Slot(playerInventory, j1 + (l + 1) * 9, 7 + j1 * 18, 83 + l * 18));
            }
        }
    }
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.tileFurnace.isUsableByPlayer(playerIn);
    }

    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 6)
            {
                if (!this.mergeItemStack(itemstack1, 8, 43, true))
                {
                    return ItemStack.EMPTY;
                }
                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index < 6)
            {
                if (!this.mergeItemStack(itemstack1, 8, 43, true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (index > 6 && index < 17)
            {
                if (!this.mergeItemStack(itemstack1, 17, 43, true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 8, 43, false))
            {
                return ItemStack.EMPTY;
            }
        }
        return itemstack;
    }
}
