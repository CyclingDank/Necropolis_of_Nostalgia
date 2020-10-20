package com.turtledove.withernauts.client.gui;

import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemHandlerHelper;

import javax.annotation.Nonnull;

public class NecropolisItemHandler implements INecropolisItemHandler, IItemHandlerModifiable, INBTSerializable<NBTTagCompound>
{
    protected NonNullList<ItemStack> stacks;

    protected int size = 135;
    public NecropolisItemHandler()
    {
        stacks = NonNullList.withSize(size, ItemStack.EMPTY);
    }

    public NecropolisItemHandler(NonNullList<ItemStack> stacks)
    {
        this.stacks = stacks;
    }


    public void setSize()
    {
        stacks = NonNullList.withSize(size, ItemStack.EMPTY);
    }

    public NonNullList<ItemStack> getStack()
    {
        return this.stacks;
    }

    public void copyContents(NonNullList<ItemStack> oldStack)
    {
        for (int i = 0; i < oldStack.size(); i++)
        {
            this.setStackInSlot(i, oldStack.get(i));
        }
    }

    @Override
    public void setStackInSlot(int slot, @Nonnull ItemStack stack)
    {
        validateSlotIndex(slot);
        this.stacks.set(slot, stack);
        onContentsChanged(slot);
    }
    @Override
    public int getSlots()
    {
        return stacks.size();
    }

    @Override
    @Nonnull
    public ItemStack getStackInSlot(int slot)
    {
        validateSlotIndex(slot);
        return this.stacks.get(slot);
    }

    @Override
    @Nonnull
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate)
    {
        if (stack.isEmpty())
            return ItemStack.EMPTY;

        validateSlotIndex(slot);
        ItemStack existing = this.stacks.get(slot);

        int limit = getStackLimit(slot, stack);

        if (!existing.isEmpty())
        {
            if (!ItemHandlerHelper.canItemStacksStack(stack, existing))
                return stack;

            limit -= existing.getCount();
        }

        if (limit <= 0)
            return stack;

        boolean reachedLimit = stack.getCount() > limit;

        if (!simulate)
        {
            if (existing.isEmpty())
            {
                this.stacks.set(slot, reachedLimit ? ItemHandlerHelper.copyStackWithSize(stack, limit) : stack);
            }
            else
            {
                existing.grow(reachedLimit ? limit : stack.getCount());
            }
            onContentsChanged(slot);
        }
        return reachedLimit ? ItemHandlerHelper.copyStackWithSize(stack, stack.getCount()- limit) : ItemStack.EMPTY;
    }

    @Override
    @Nonnull
    public ItemStack extractItem(int slot, int amount, boolean simulate)
    {
        if (amount == 0)
            return ItemStack.EMPTY;

        validateSlotIndex(slot);

        ItemStack existing = this.stacks.get(slot);

        if (existing.isEmpty())
            return ItemStack.EMPTY;

        int toExtract = Math.min(amount, existing.getMaxStackSize());

        if (existing.getCount() <= toExtract)
        {
            if (!simulate)
            {
                this.stacks.set(slot, ItemStack.EMPTY);
                onContentsChanged(slot);
            }
            return existing;
        }
        else
        {
            if (!simulate)
            {
                this.stacks.set(slot, ItemHandlerHelper.copyStackWithSize(existing, existing.getCount() - toExtract));
                onContentsChanged(slot);
            }

            return ItemHandlerHelper.copyStackWithSize(existing, toExtract);
        }
    }

    @Override
    public int getSlotLimit(int slot)
    {
        return 64;
    }

    @Override
    public int getStackLimit(int slot, @Nonnull ItemStack stack)
    {
        return Math.min(getSlotLimit(slot), stack.getMaxStackSize());
    }

    @Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack)
    {
        if (slot >= 0 && slot <= 26)
        {
            if (!stack.isEmpty())
            {
                if (!(stack.getItem() instanceof ItemSword) && !(stack.getItem() instanceof ItemBow))
                {
                    return false;
                }
            }
        }
        else if (slot >= 27 && slot <= 53)
        {
            if (!stack.isEmpty())
            {
                if (!(stack.getItem() instanceof ItemAxe) && !(stack.getItem() instanceof ItemPickaxe) && !(stack.getItem() instanceof ItemCompass) && !(stack.getItem() instanceof ItemShears)
                && !(stack.getItem() instanceof ItemHoe) && !(stack.getItem() instanceof ItemSpade) && !(stack.getItem() instanceof ItemFishingRod) && !(stack.getItem() instanceof ItemFlintAndSteel)
                && !(stack.getItem() instanceof ItemClock) && !(stack.getItem() instanceof ItemCarrotOnAStick))
                {
                    return false;
                }
            }
        }
        else if (slot >= 54 && slot <= 62)
        {
            if (!stack.isEmpty())
            {
                if (!(stack.getItem() instanceof ItemArmor) && !(stack.getItem() instanceof ItemShield))
                {
                    return false;
                }
            }
        }
        else if (slot >= 63 && slot <= 89)
        {
            if (!stack.isEmpty())
            {
                if (!(stack.getItem() instanceof ItemFood) && !(stack.getItem() instanceof ItemBucketMilk) && !(stack.getItem() instanceof ItemPotion)  && !(stack.getItem() instanceof ItemSplashPotion)
                        && !(stack.getItem() instanceof ItemEgg)  && !(stack.getItem() instanceof ItemExpBottle)  && !(stack.getItem() instanceof ItemGlassBottle)
                        && !(stack.getItem() instanceof ItemSeeds))
                {
                    return false;
                }
            }
        }
        else if (slot > 62)
        {
            if (!stack.isEmpty())
            {
                if ((stack.getItem() instanceof ItemArmor) || (stack.getItem() instanceof ItemShield) || (stack.getItem() instanceof ItemFood) || (stack.getItem() instanceof ItemBucketMilk) || (stack.getItem() instanceof ItemPotion)  || (stack.getItem() instanceof ItemSplashPotion)
                        || (stack.getItem() instanceof ItemEgg)  || (stack.getItem() instanceof ItemExpBottle)  || (stack.getItem() instanceof ItemGlassBottle)
                        || (stack.getItem() instanceof ItemSeeds) || (stack.getItem() instanceof ItemAxe) || (stack.getItem() instanceof ItemPickaxe) || (stack.getItem() instanceof ItemCompass) || (stack.getItem() instanceof ItemShears)
                        || (stack.getItem() instanceof ItemHoe) || (stack.getItem() instanceof ItemSpade) || (stack.getItem() instanceof ItemFishingRod) || (stack.getItem() instanceof ItemFlintAndSteel)
                        || (stack.getItem() instanceof ItemClock) || (stack.getItem() instanceof ItemCarrotOnAStick) || (stack.getItem() instanceof ItemSword) || (stack.getItem() instanceof ItemBow))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public NBTTagCompound serializeNBT()
    {
        NBTTagList nbtTagList = new NBTTagList();
        for (int i = 0; i < stacks.size(); i++)
        {
            if (!stacks.get(i).isEmpty())
            {
                NBTTagCompound itemTag = new NBTTagCompound();
                itemTag.setInteger("Slot", i);
                stacks.get(i).writeToNBT(itemTag);
                nbtTagList.appendTag(itemTag);
            }
        }
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setTag("Items", nbtTagList);
        nbt.setInteger("Size", stacks.size());
        return nbt;
    }
    @Override
    public void deserializeNBT(NBTTagCompound nbt)
    {
        setSize();
        NBTTagList tagList = nbt.getTagList("Items", Constants.NBT.TAG_COMPOUND);
        for (int i = 0; i < tagList.tagCount(); i++)
        {
            NBTTagCompound itemTags = tagList.getCompoundTagAt(i);
            int slot = itemTags.getInteger("Slot");

            if (slot >= 0 && slot < stacks.size())
            {
                stacks.set(slot, new ItemStack(itemTags));
            }
        }
        onLoad();
    }

    @Override
    public void validateSlotIndex(int slot)
    {
        if (slot < 0 || slot >= stacks.size())
            throw new RuntimeException("Slot " + slot + " not in valid range - [0," + stacks.size() + ")");
    }
    @Override
    public void onLoad()
    {

    }

    @Override
    public void onContentsChanged(int slot)
    {

    }
}
