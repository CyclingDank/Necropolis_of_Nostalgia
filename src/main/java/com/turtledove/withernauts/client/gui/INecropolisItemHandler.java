package com.turtledove.withernauts.client.gui;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nonnull;

public interface INecropolisItemHandler extends IItemHandler
{
    public void setSize();

    public void setStackInSlot(int slot, @Nonnull ItemStack stack);

    public int getSlots();

    public void copyContents(NonNullList<ItemStack> oldStack);

    public NonNullList<ItemStack> getStack();

    @Nonnull
    public ItemStack getStackInSlot(int slot);

    @Nonnull
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate);
    @Nonnull
    public ItemStack extractItem(int slot, int amount, boolean simulate);
    public int getSlotLimit(int slot);

    public int getStackLimit(int slot, @Nonnull ItemStack stack);

    public boolean isItemValid(int slot, @Nonnull ItemStack stack);

    public NBTTagCompound serializeNBT();
    public void deserializeNBT(NBTTagCompound nbt);

    public void validateSlotIndex(int slot);

    public void onLoad();

    public void onContentsChanged(int slot);
}