package com.turtledove.necropolisofnostalgia.server.packets.Player;

import com.turtledove.necropolisofnostalgia.server.core.IPlayerData;
import com.turtledove.necropolisofnostalgia.server.core.NecropolisPlayerData;
import com.turtledove.necropolisofnostalgia.server.core.PlayerData;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class SyncArtesOnClient  implements IMessage
{
    int[] primary;
    int arteSize;
    int[]arteCount;
    int isPrimary;  //-1 is bind, 0 is primary, 1 is secondary

    public SyncArtesOnClient() {}
    public SyncArtesOnClient (int[] inPrimary, int[] inArteCount, int isPrimary)
    {
        this.primary = new int[9];
        this.primary = inPrimary;
        this.arteSize = inArteCount.length;
        this.arteCount = new int[this.arteSize];
        this.isPrimary = isPrimary;

        this.arteCount = inArteCount;
    }
    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.isPrimary = buf.readInt();
        this.arteSize = buf.readInt();
        this.primary = new int[9];
        arteCount = new int[this.arteSize];

        for(int i = 0; i < 9; i++)
        {
            this.primary[i] = buf.readInt();
        }
        for(int i = 0; i < arteSize; i++)
        {
            this.arteCount[i] = buf.readInt();
        }
    }
    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.isPrimary);
        buf.writeInt(this.arteSize);
        for(int i = 0; i < 9; i++)
        {
            buf.writeInt(this.primary[i]);
        }
        for(int i = 0; i < this.arteSize; i++)
        {
            buf.writeInt(this.arteCount[i]);
        }
    }
    public static class Handler extends MessageHandler.Server<SyncArtesOnClient>
    {
        @Override
        public void handleServerMessage(final EntityPlayer player, final SyncArtesOnClient message)
        {
            IPlayerData pData = NecropolisPlayerData.get(player);
            if (pData == null)
                return;
            int cond = message.isPrimary;
            pData.setArteCount(message.arteCount);

            if (cond == -1)
                pData.setBindedArtes(message.primary);
            else if (cond == 0)
                pData.setArteAtIndices(true, message.primary);
            else
                pData.setArteAtIndices(false, message.primary);
        }
    }
}
