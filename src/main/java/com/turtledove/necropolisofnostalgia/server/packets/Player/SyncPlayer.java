package com.turtledove.necropolisofnostalgia.server.packets.Player;

import com.turtledove.necropolisofnostalgia.server.core.NecropolisPlayerData;
import com.turtledove.necropolisofnostalgia.server.core.PlayerData;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class SyncPlayer implements IMessage
{
    double locX, locY, locZ;

    public SyncPlayer()
    {
        this.locX = 0.0;
        this.locY = 0.0;
        this.locZ = 0.0;
    }
    public SyncPlayer(double a, double b, double c)
    {
        this.locX = a;
        this.locY = b;
        this.locZ = c;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.locX = buf.readDouble();
        this.locY = buf.readDouble();
        this.locZ = buf.readDouble();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeDouble(this.locX);
        buf.writeDouble(this.locY);
        buf.writeDouble(this.locZ);
    }

    public static class Handler extends MessageHandler.Client<SyncPlayer>
    {

        @Override
        public void handleClientMessage(final EntityPlayer player, SyncPlayer msg)
        {
            PlayerData data = (PlayerData) NecropolisPlayerData.get(player);
            if (data != null)
            {
                //data.setAttackProgress(msg.slotIndex);
                player.motionX = msg.locX;
                player.motionY = msg.locY;
                player.motionZ = msg.locZ;
                //if (player.onGround)
                   // Minecraft.getMinecraft().player.addVelocity(msg.locX, msg.locY,msg.locZ);
            }
        }
    }
}
