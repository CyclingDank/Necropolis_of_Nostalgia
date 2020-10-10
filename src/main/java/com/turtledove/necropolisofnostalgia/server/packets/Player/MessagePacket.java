package com.turtledove.necropolisofnostalgia.server.packets.Player;

import com.turtledove.necropolisofnostalgia.server.core.IPlayerData;
import com.turtledove.necropolisofnostalgia.server.core.NecropolisPlayerData;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessagePacket implements IMessage
{
    private int slotIndex;
    int isEntityAimedAt;    //0 is false, 1 is true
    double locX, locY, locZ;
    int arte_stage;

    public MessagePacket()
    {
        this.isEntityAimedAt = 0;
        this.locX = 0.0;
        this.locY = 0.0;
        this.locZ = 0.0;
        this.arte_stage = 0;
    }

    public MessagePacket(int slotIndex, int a, double b, double c, double d, int e)
    {
        this.slotIndex = slotIndex;
        this.isEntityAimedAt = a;
        this.locX = b;
        this.locY = c;
        this.locZ = d;
        this.arte_stage = e;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.slotIndex = buf.readInt();
        this.isEntityAimedAt = buf.readInt();
        this.locX = buf.readDouble();
        this.locY = buf.readDouble();
        this.locZ = buf.readDouble();
        this.arte_stage = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.slotIndex);
        buf.writeInt(this.isEntityAimedAt);
        buf.writeDouble(this.locX);
        buf.writeDouble(this.locY);
        buf.writeDouble(this.locZ);
        buf.writeInt(this.arte_stage);
    }


    public static class Handler extends MessageHandler.Server<MessagePacket>
    {
        @Override
        public void handleServerMessage(final EntityPlayer player, final MessagePacket message)
        {
            IPlayerData pData = NecropolisPlayerData.get(player);

            if (pData == null)
                return;
            pData.doAttack(message.slotIndex, message.arte_stage);
        }
    }
}
