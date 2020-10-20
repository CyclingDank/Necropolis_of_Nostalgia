package com.turtledove.withernauts.server.packets.Player;

import com.turtledove.withernauts.server.core.NecropolisPlayerData;
import com.turtledove.withernauts.server.core.PlayerData;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class SyncArtesOnServer implements IMessage
{
    int[] primary;
    int[] secondary;
    int arteSize;
    int[]arteCount;
    int player_class;
    public SyncArtesOnServer()
    {
        player_class = 0;
    }

    public SyncArtesOnServer(int[] inPrimary, int[] inSecondary, int[] inArteCount, int t_class)
    {
        this.primary = new int[9];
        this.secondary = new int[9];

        this.primary = inPrimary;
        this.secondary = inSecondary;
        this.arteSize = inArteCount.length;
        this.arteCount = new int[this.arteSize];

        this.arteCount = inArteCount;
        this.player_class = t_class;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.arteSize = buf.readInt();
        this.primary = new int[9];
        this.secondary = new int[9];
        arteCount = new int[this.arteSize];

        for(int i = 0; i < 9; i++)
        {
            this.primary[i] = buf.readInt();
        }
        for(int i = 0; i < 9; i++)
        {
            this.secondary[i] = buf.readInt();
        }
        for(int i = 0; i < arteSize; i++)
        {
            this.arteCount[i] = buf.readInt();
        }
        this.player_class = buf.readInt();
    }
    @Override
    public void toBytes(ByteBuf buf)
    {

        buf.writeInt(this.arteSize);
        for(int i = 0; i < 9; i++)
        {
            buf.writeInt(this.primary[i]);
        }
        for(int i = 0; i < 9; i++)
        {
            buf.writeInt(this.secondary[i]);
        }
        for(int i = 0; i < this.arteSize; i++)
        {
            buf.writeInt(this.arteCount[i]);
        }
        buf.writeInt(this.player_class);
    }
    public static class Handler extends MessageHandler.Client<SyncArtesOnServer>
    {
        @Override
        public void handleClientMessage(final EntityPlayer player, SyncArtesOnServer msg)
        {
            PlayerData data = (PlayerData) NecropolisPlayerData.get(player);
            if (data != null)
            {
                data.setArteCount(msg.arteCount);
                data.setArteAtIndices(true, msg.primary);
                data.setArteAtIndices(false, msg.secondary);
                data.setBindedArtes(msg.primary);
                data.set_class(msg.player_class);
            }
        }
    }
}
