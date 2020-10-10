package com.turtledove.necropolisofnostalgia.client.gui;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class InventorySlotHandler extends SlotItemHandler
{

    public InventorySlotHandler(INecropolisItemHandler itemHandler, int index, int xPosition, int yPosition)
    {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(@Nonnull ItemStack stack)
    {
        return super.isItemValid(stack);
    }


}