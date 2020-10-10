package com.turtledove.necropolisofnostalgia.server.packets.Player;

import com.turtledove.necropolisofnostalgia.server.core.NecropolisPlayerData;
import com.turtledove.necropolisofnostalgia.server.core.PlayerData;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class SyncSingleQuestServerSide implements IMessage
{

    public int questID;
    public int questStatus;
    public SyncSingleQuestServerSide()
    {
    }

    public SyncSingleQuestServerSide(int aID, int aStatus)
    {
        this.questID = aID;
        this.questStatus = aStatus;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.questID = buf.readInt();
        this.questStatus = buf.readInt();
    }
    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.questID);
        buf.writeInt(this.questStatus);
    }
    public static class Handler extends MessageHandler.Client<SyncSingleQuestServerSide>
    {
        @Override
        public void handleClientMessage(final EntityPlayer player, SyncSingleQuestServerSide msg)
        {
            PlayerData data = (PlayerData) NecropolisPlayerData.get(player);
            if (data != null)
            {
                data.setQuest(msg.questID, msg.questStatus);
            }
        }
    }
}