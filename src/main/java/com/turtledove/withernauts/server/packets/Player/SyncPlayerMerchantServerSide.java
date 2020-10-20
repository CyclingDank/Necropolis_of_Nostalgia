package com.turtledove.withernauts.server.packets.Player;

import com.turtledove.withernauts.server.core.NecropolisPlayerData;
import com.turtledove.withernauts.server.core.PlayerData;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class SyncPlayerMerchantServerSide  implements IMessage
{
    int merchantPoints;
    public SyncPlayerMerchantServerSide()
    {
        this.merchantPoints = 0;
    }

    public SyncPlayerMerchantServerSide(int val)
    {
        this.merchantPoints = val;
    }
    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.merchantPoints = buf.readInt();
    }
    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.merchantPoints);
    }

    public static class Handler extends MessageHandler.Client<SyncPlayerMerchantServerSide>
    {
        @Override
        public void handleClientMessage(final EntityPlayer player, SyncPlayerMerchantServerSide msg)
        {
            PlayerData data = (PlayerData) NecropolisPlayerData.get(player);
            if (data != null)
            {
                data.setMerchantPoints(msg.merchantPoints);
            }
        }
    }
}
