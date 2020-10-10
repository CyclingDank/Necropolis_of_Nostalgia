package com.turtledove.necropolisofnostalgia.server.packets.Player;

import com.turtledove.necropolisofnostalgia.server.core.NecropolisPlayerData;
import com.turtledove.necropolisofnostalgia.server.core.PlayerData;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class SyncPlayerMerchantClientSide implements IMessage
{
    int merchantPoints;
    public SyncPlayerMerchantClientSide()
    {
        this.merchantPoints = 0;
    }

    public SyncPlayerMerchantClientSide(int val)
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

    public static class Handler extends MessageHandler.Server<SyncPlayerMerchantClientSide>
    {
        @Override
        public void handleServerMessage(final EntityPlayer player, SyncPlayerMerchantClientSide msg)
        {
            PlayerData data = (PlayerData) NecropolisPlayerData.get(player);
            if (data != null)
            {
                data.setMerchantPoints(msg.merchantPoints);
            }
        }
    }
}
