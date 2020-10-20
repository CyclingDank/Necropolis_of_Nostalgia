package com.turtledove.withernauts.server.packets.Player;

import com.turtledove.withernauts.server.item.ItemHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class WMSpawnItem implements IMessage
{
    int itemIndex;
    int count;

    Item[] items = {ItemHandler.RICE_SEED, Items.POTATO, Items.EGG, Items.CARROT, Items.BEETROOT_SEEDS,
            Items.STRING, Items.MELON_SEEDS, Items.REEDS, Items.PUMPKIN_SEEDS, Items.FLINT,
            Items.GOLD_INGOT, Items.IRON_INGOT, Items.LEATHER, Items.BONE, Items.FEATHER,
            Items.GUNPOWDER, Items.REDSTONE, ItemHandler.MYSTERY_MEAL, Items.EMERALD, Items.SLIME_BALL,
            Items.GUNPOWDER, Items.REDSTONE, ItemHandler.MYSTERY_MEAL, Items.EMERALD, Items.SLIME_BALL
    };

    public WMSpawnItem()
    {
        this.itemIndex = 0;
        this.count = 0;
    }

    public WMSpawnItem(int index, int c)
    {
        this.itemIndex = index;
        this.count = c;
    }
    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.itemIndex = buf.readInt();
        this.count = buf.readInt();
    }
    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.itemIndex);
        buf.writeInt(this.count);
    }

    public static class Handler extends MessageHandler.Server<WMSpawnItem>
    {
        @Override
        public void handleServerMessage(final EntityPlayer player, WMSpawnItem msg)
        {
            EntityItem dItem = new EntityItem(player.world, player.posX, player.posY, player.posZ, new ItemStack(msg.items[msg.itemIndex], msg.count));
            player.world.spawnEntity(dItem);
        }
    }
}