package com.turtledove.withernauts.server.packets.Player;

import com.turtledove.withernauts.server.core.NecropolisPlayerData;
import com.turtledove.withernauts.server.core.PlayerData;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

//Syncs client data to the server
public class SyncPlayerStatsServerSide  implements IMessage
{
    double playermana;
    int atk;
    int sAtk;
    int def;
    int sDef;

    public SyncPlayerStatsServerSide()
    {
        this.playermana = 256;
        this.atk = 0;
        this.sAtk = 0;
        this.def = 0;
        this.sDef = 0;
    }

    public SyncPlayerStatsServerSide(double val, int[] a)
    {
        this.playermana = val;
        this.atk = a[0];
        this.sAtk = a[1];
        this.def = a[2];
        this.sDef = a[3];
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.playermana = buf.readDouble();
        this.atk = buf.readInt();
        this.sAtk = buf.readInt();
        this.def = buf.readInt();
        this.sDef = buf.readInt();
    }
    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeDouble(this.playermana);
        buf.writeInt(this.atk);
        buf.writeInt(this.sAtk);
        buf.writeInt(this.def);
        buf.writeInt(this.sDef);
    }
    public static class Handler extends MessageHandler.Client<SyncPlayerStatsServerSide>
    {
        @Override
        public void handleClientMessage(final EntityPlayer player, SyncPlayerStatsServerSide msg)
        {
            PlayerData data = (PlayerData) NecropolisPlayerData.get(player);
            if (data != null)
            {
                data.setMana((float)msg.playermana);
                int[]stats = new int[4];
                stats[0] = msg.atk;
                stats[1] = msg.sAtk;
                stats[2] = msg.def;
                stats[3] = msg.sDef;
                data.setStatBoost(stats);
            }
        }
    }
}
