package com.turtledove.withernauts.server.packets.Player;

import com.turtledove.withernauts.server.core.NecropolisPlayerData;
import com.turtledove.withernauts.server.core.PlayerData;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class SyncPlayerStatsClientSide  implements IMessage
{
    double playermana;

    public SyncPlayerStatsClientSide()
    {
        this.playermana = 256;
    }

    public SyncPlayerStatsClientSide(double val)
    {
        this.playermana = val;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.playermana = buf.readDouble();
    }
    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeDouble(this.playermana);
    }
    public static class Handler extends MessageHandler.Server<SyncPlayerStatsClientSide>
    {
        @Override
        public void handleServerMessage(final EntityPlayer player, SyncPlayerStatsClientSide msg)
        {
            PlayerData data = (PlayerData) NecropolisPlayerData.get(player);
            if (data != null)
            {
                data.setMana((float)msg.playermana);
            }
        }
    }
}
