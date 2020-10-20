package com.turtledove.withernauts.server.packets.Inventory;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.client.gui.INecropolisItemHandler;
import com.turtledove.withernauts.server.events.NecropolisCapabilities;
import com.turtledove.withernauts.server.packets.Player.MessageHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class InventoryPacket implements IMessage
{


    public InventoryPacket()
    {

    }

    @Override
    public void fromBytes(ByteBuf buf) {

    }

    @Override
    public void toBytes(ByteBuf buf) {

    }

    public static class Handler extends MessageHandler.Server<InventoryPacket>
    {
        @Override
        public void handleServerMessage(final EntityPlayer player, final InventoryPacket message)
        {
            INecropolisItemHandler iData = player.getCapability(NecropolisCapabilities.ITEM_HANDLER_CAPABILITY, null);
            if (iData == null)
                return;

            //synchronize client/server mana data here, possibly other stats.

            player.openGui(Withernauts.MODID, 0,player.world, (int)player.posX,(int)player.posY,(int)player.posZ);
            //pData.activateArte(message.slotIndex);
        }
    }
}
