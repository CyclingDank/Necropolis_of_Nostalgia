package com.turtledove.necropolisofnostalgia.server.packets.Player;

import com.turtledove.necropolisofnostalgia.server.core.NecropolisPlayerData;
import com.turtledove.necropolisofnostalgia.server.core.PlayerData;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class SyncQuestsServerSide implements IMessage
{

    public int[] tQuests = new int[256];
    public SyncQuestsServerSide()
    {
    }

    public SyncQuestsServerSide(int[] a)
    {
        this.tQuests = a.clone();
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        for (int i = 0; i < 256; i++)
            this.tQuests[i] = buf.readInt();
    }
    @Override
    public void toBytes(ByteBuf buf)
    {
        for (int i = 0; i < 256; i++)
            buf.writeInt(this.tQuests[i]);
    }
    public static class Handler extends MessageHandler.Client<SyncQuestsServerSide>
    {
        @Override
        public void handleClientMessage(final EntityPlayer player, SyncQuestsServerSide msg)
        {
            PlayerData data = (PlayerData) NecropolisPlayerData.get(player);
            if (data != null)
            {
                data.setQuestStatus(msg.tQuests);
            }
        }
    }
}
