package com.turtledove.withernauts.client.gui;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class NecropolisTabs
{
    public static NecropolisTabs[] NECROPOLIS_TAB_ARRAY = new NecropolisTabs[2];
    private final int tabIndex;
    private final String tabLabel;
    private String backgroundTexture = "items.png";
    private ItemStack iconItemStack;

    public static final NecropolisTabs COMBAT = (new NecropolisTabs(0, "combat")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem()
        {
            return new ItemStack(Items.IRON_SWORD);
        }
    });
    public static final NecropolisTabs TOOLS = (new NecropolisTabs(1, "tools")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem()
        {
            return new ItemStack(Items.IRON_PICKAXE);
        }
    });
    public static final NecropolisTabs EQUIPMENT = (new NecropolisTabs(2, "equipment")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem()
        {
            return new ItemStack(Items.IRON_CHESTPLATE);
        }
    });
    public static final NecropolisTabs CONSUMABLES = (new NecropolisTabs(3, "consumables")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem()
        {
            return new ItemStack(Items.GOLDEN_APPLE);
        }
    });
    public static final NecropolisTabs SKILLS = (new NecropolisTabs(4, "artes")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem()
        {
            return new ItemStack(Items.NETHER_STAR);
        }
    });
    public static final NecropolisTabs BLOCKS = (new NecropolisTabs(5, "blocks")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem()
        {
            return new ItemStack(Item.getItemFromBlock(Blocks.LOG));
        }
    });
    public static final NecropolisTabs INVENTORY = (new NecropolisTabs(6, "inventory")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem()
        {
            return new ItemStack(Item.getItemFromBlock(Blocks.CHEST));
        }
    }).setBackgroundImageName("inventory.png");

    public NecropolisTabs(int index, String label)
    {
        if (index >= NECROPOLIS_TAB_ARRAY.length)
        {
            NecropolisTabs[] tmp = new NecropolisTabs[index + 1];
            for (int x = 0; x < NECROPOLIS_TAB_ARRAY.length; x++)
            {
                tmp[x] = NECROPOLIS_TAB_ARRAY[x];
            }
            NECROPOLIS_TAB_ARRAY = tmp;
        }
        this.tabIndex = index;
        this.tabLabel = label;
        this.iconItemStack = ItemStack.EMPTY;
        NECROPOLIS_TAB_ARRAY[index] = this;
    }
    @SideOnly(Side.CLIENT)
    public int getTabIndex()
    {
        return this.tabIndex;
    }

    @SideOnly(Side.CLIENT)
    public abstract ItemStack getTabIconItem();

    @SideOnly(Side.CLIENT)
    public ItemStack getIconItemStack()
    {
        if (this.iconItemStack.isEmpty())
        {
            this.iconItemStack = this.getTabIconItem();
        }

        return this.iconItemStack;
    }

    public NecropolisTabs setBackgroundImageName(String texture)
    {
        this.backgroundTexture = texture;
        return this;
    }
}
