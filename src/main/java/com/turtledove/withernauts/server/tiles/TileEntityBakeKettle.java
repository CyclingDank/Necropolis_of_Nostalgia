package com.turtledove.withernauts.server.tiles;

import com.turtledove.withernauts.client.gui.BakeKettleContainer;
import com.turtledove.withernauts.common.recipe.NecropolisCookingRecipes;
import com.turtledove.withernauts.server.item.ItemHandler;
import com.turtledove.withernauts.server.sounds.NecropolisSounds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;

import java.util.ArrayList;
import java.util.List;

public class TileEntityBakeKettle extends TileEntity implements ITickable, ISidedInventory
{
    private int cookTime;
    private static final int[] SLOTS_TOP = new int[]{0, 1};
    private static final int[] SLOTS_BOTTOM = new int[]{2};
    private static final int[] SLOTS_SIDES = new int[]{0, 1};

    private int cook_method;    //0 is none, 1 is bake, 2 is boil
    private final int[] cook_time = new int[]{0,320,200};
    private int ticks_existed;

    private NonNullList<ItemStack> forgeItemStacks = NonNullList.withSize(8, ItemStack.EMPTY);

    public TileEntityBakeKettle()
    {
        super();
        this.cook_method = 0;
        this.cookTime = 0;
        this.ticks_existed = 0;
    }

    public void update()
    {
        if (this.ticks_existed > 600)
            this.ticks_existed = 0;
        if (!this.world.isRemote)
        {
            this.cook_food();
            this.play_sound();
        }
        else
        {
            if (this.ticks_existed % 30 == 0)
            {
                this.world.spawnParticle(EnumParticleTypes.CLOUD, this.getPos().getX()  + 0.5f, this.getPos().getY() + 1F,this.getPos().getZ() + 0.5f,
                        0.0D, 0.2D, 0.0D);
            }
            else if (this.ticks_existed % 40 == 0)
            {
                this.world.spawnParticle(EnumParticleTypes.CLOUD, this.getPos().getX()  + 0.3f, this.getPos().getY() + 1F,this.getPos().getZ() + 0.5f,
                        0.0D, 0.3D, 0.0D);
            }
            else if (this.ticks_existed % 10 == 0)
            {
                this.world.spawnParticle(EnumParticleTypes.FLAME, this.getPos().getX()  + 0.3f, this.getPos().getY() + 0.1F,this.getPos().getZ() + 0.5f,
                        0.0D, 0.0D, 0.0D);
                this.world.spawnParticle(EnumParticleTypes.FLAME, this.getPos().getX()  + 0.5f, this.getPos().getY() + 0.1F,this.getPos().getZ() + 0.5f,
                        0.0D, 0.0D, 0.0D);
                this.world.spawnParticle(EnumParticleTypes.FLAME, this.getPos().getX()  + 0.4f, this.getPos().getY() + 0.1F,this.getPos().getZ() + 0.2f,
                        0.0D, 0.0D, 0.0D);
            }
        }
        this.ticks_existed++;
    }

    public void play_sound()
    {
        float sec = this.cookTime * 20;
        if (this.cook_method == 1 && this.cookTime > 0)
        {
            if (this.cookTime % 10 == 0)
            {
                int song_index = this.cookTime % 40;
                if (song_index == 0)
                {
                    this.world.playSound(null,this.getPos().getX(), this.getPos().getY(),this.getPos().getZ(), NecropolisSounds.FRYING_1, SoundCategory.BLOCKS,0.1F, 1.0F);
                }
                else if (song_index == 10)
                {
                    this.world.playSound(null,this.getPos().getX(), this.getPos().getY(),this.getPos().getZ(), NecropolisSounds.FRYING_2, SoundCategory.BLOCKS,0.1F, 1.0F);
                }
                else if (song_index == 20)
                {
                    this.world.playSound(null,this.getPos().getX(), this.getPos().getY(),this.getPos().getZ(), NecropolisSounds.FRYING_3, SoundCategory.BLOCKS,0.1F, 1.0F);
                }
                else if (song_index == 30)
                {
                    this.world.playSound(null,this.getPos().getX(), this.getPos().getY(),this.getPos().getZ(), NecropolisSounds.FRYING_4, SoundCategory.BLOCKS,0.1F, 1.0F);
                }
            }
            else if (this.cookTime % 25 == 0)
            {
                this.world.playSound(null,this.getPos().getX(), this.getPos().getY(),this.getPos().getZ(), SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS,1.0F, 1.0F);
            }
            else if (this.cookTime % 4 == 0)
            {
                this.world.playSound(null,this.getPos().getX(), this.getPos().getY(),this.getPos().getZ(), SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS,1.0F, 1.0F);
            }
        }
        else
        {
            if (this.ticks_existed % 30 == 0)
                this.world.playSound(null,this.getPos().getX(), this.getPos().getY(),this.getPos().getZ(), SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS,1.0F, 1.0F);
        }
    }

    public void cook_food()
    {
        ItemStack itemstack_0 = this.forgeItemStacks.get(0);
        ItemStack itemstack_1 = this.forgeItemStacks.get(1);
        ItemStack itemstack_2 = this.forgeItemStacks.get(2);
        ItemStack itemstack_3 = this.forgeItemStacks.get(3);
        ItemStack itemstack_4 = this.forgeItemStacks.get(4);
        ItemStack itemstack_5 = this.forgeItemStacks.get(5);

        ItemStack resultstack = this.forgeItemStacks.get(6);

        if (resultstack.isEmpty())
        {
            if (!(itemstack_0.isEmpty() && itemstack_1.isEmpty() && itemstack_2.isEmpty() && itemstack_3.isEmpty()
                    && itemstack_4.isEmpty() && itemstack_5.isEmpty()))
            {
                if (this.cookTime == 0)
                {
                    this.cook_method = 1;
                    /*for (int i = 0; i < 6; i++)
                    {
                        if (!this.forgeItemStacks.get(i).isEmpty())
                        {
                            if (this.forgeItemStacks.get(i).isItemEqual(new ItemStack(Item.getItemById(326))) ||
                                    this.forgeItemStacks.get(i).isItemEqual(new ItemStack(Item.getItemById(335)))
                            )
                            {
                                this.cook_method = 2;
                            }
                        }
                    }*/
                    NecropolisCookingRecipes recipeBook = new NecropolisCookingRecipes();
                    List<String> ingredients = new ArrayList<>();
                    for (int i = 0; i < 6; i++)
                    {
                        if (!this.forgeItemStacks.get(i).isEmpty())
                            ingredients.add(this.forgeItemStacks.get(i).getItem().getRegistryName().toString());
                    }
                    ItemStack meal = recipeBook.getRecipeResult(ingredients);
                    if (!meal.isEmpty())
                    {
                        this.cookTime = 0;
                    }
                    else
                    {
                        this.cookTime = 0;
                        this.cook_method = 0;
                    }
                }

                NecropolisCookingRecipes recipeBook = new NecropolisCookingRecipes();
                List<String> ingredients = new ArrayList<>();
                int portionSize = 64;
                for (int i = 0; i < 6; i++)
                {
                    if (!this.forgeItemStacks.get(i).isEmpty())
                    {
                        ingredients.add(this.forgeItemStacks.get(i).getItem().getRegistryName().toString());
                        portionSize = Math.min(this.forgeItemStacks.get(i).getCount(), portionSize);
                    }
                }
                ItemStack meal = recipeBook.getRecipeResult(ingredients);
                if (!meal.isEmpty())
                {
                    if (this.cookTime == this.cook_time[cook_method] && this.cook_method > 0)
                    {
                        for (int i = 0; i < 6; i++)
                        {
                            if (!this.forgeItemStacks.get(i).isEmpty())
                            {
                                if (this.forgeItemStacks.get(i).getItem().getRegistryName().toString().equals(ItemHandler.BROTH.getRegistryName().toString()) ||
                                this.forgeItemStacks.get(i).getItem().getRegistryName().toString().equals(Items.WATER_BUCKET.getRegistryName().toString()))
                                {
                                    this.forgeItemStacks.get(i).shrink(portionSize);
                                    this.forgeItemStacks.set(i, new ItemStack(Item.REGISTRY.getObjectById(325)));
                                }
                                else
                                {
                                    this.forgeItemStacks.get(i).shrink(portionSize);
                                }
                            }
                        }
                        this.forgeItemStacks.set(6,new ItemStack(meal.getItem(), portionSize));
                        this.cook_method = 0;
                        this.cookTime = 0;
                    }
                }
                else
                {
                    this.cook_method = 0;
                    this.cookTime = 0;
                }
                if (this.cook_method > 0)
                {
                    this.cookTime++;
                }
            }
            else
            {
                this.cook_method = 0;
                this.cookTime = 0;
            }
        }
    }

    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return new BakeKettleContainer(playerInventory, this);
    }

    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.forgeItemStacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.forgeItemStacks);
        this.cook_method = compound.getInteger("CookMethod");
        this.cookTime = compound.getInteger("CookTime");
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("CookMethod", (short) this.cook_method);
        compound.setInteger("CookTime", (short) this.cookTime);
        ItemStackHelper.saveAllItems(compound, this.forgeItemStacks);
        return compound;
    }

    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction)
    {
        return true;
    }

    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
    {
        return this.isItemValidForSlot(index, itemStackIn);
    }

    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        if (index == 6)
        {
            return false;
        }
        else if (index >= 0 && index < 6)
        {
            if (!(stack.getItem() instanceof ItemFood))
                return false;
        }
        return true;
    }

    public boolean isEmpty() {
        for (ItemStack itemstack : this.forgeItemStacks)
        {
            if (!itemstack.isEmpty())
            {
                return false;
            }
        }

        return true;
    }

    public boolean isUsableByPlayer(EntityPlayer player)
    {
        if (this.world.getTileEntity(this.pos) != this)
        {
            return false;
        }
        else
            {
            return player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
        }
    }

    public void setInventorySlotContents(int index, ItemStack stack)
    {
        ItemStack itemstack = this.forgeItemStacks.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
        this.forgeItemStacks.set(index, stack);

        if (stack.getCount() > this.getInventoryStackLimit()) {
            stack.setCount(this.getInventoryStackLimit());
        }

        if (index == 0 && !flag) {
            this.cookTime = 0;
            this.markDirty();
        }
    }

    public ItemStack decrStackSize(int index, int count)
    {
        return ItemStackHelper.getAndSplit(this.forgeItemStacks, index, count);
    }

    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.forgeItemStacks, index);
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public ItemStack getStackInSlot(int index)
    {
        return this.forgeItemStacks.get(index);
    }

    public void setField(int id, int value) {
        cookTime = value;
    }

    public int getFieldCount() {
        return 1;
    }

    public void clear() {
        this.forgeItemStacks.clear();
    }

    public int getField(int id)
    {
        if (id == 0)
            return cookTime;
        else
            return cook_method;
    }

    public int getSizeInventory() {
        return this.forgeItemStacks.size();
    }

    public String getName()
    {
        return "Baking Kettle";
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    public void openInventory(EntityPlayer player) {
    }

    public void closeInventory(EntityPlayer player) {
    }

    public int[] getSlotsForFace(EnumFacing side) {
        if (side == EnumFacing.DOWN) {
            return SLOTS_BOTTOM;
        } else {
            return side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES;
        }
    }
}
