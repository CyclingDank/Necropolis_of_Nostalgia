package com.turtledove.necropolisofnostalgia.server.packets.Player;

import com.turtledove.necropolisofnostalgia.server.core.NecropolisPlayerData;
import com.turtledove.necropolisofnostalgia.server.core.PlayerData;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class SyncServerClientStamina implements IMessage
{
    private int staminaDecrease;
    public SyncServerClientStamina() {this.staminaDecrease = 0;}
    public SyncServerClientStamina(int decr)
    {
        this.staminaDecrease = decr;
    }
    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.staminaDecrease = buf.readInt();
    }
    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.staminaDecrease);
    }
    public static class Handler extends MessageHandler.Client<SyncServerClientStamina>
    {
        @Override
        public void handleClientMessage(final EntityPlayer player, final SyncServerClientStamina msg)
        {
            PlayerData data = (PlayerData) NecropolisPlayerData.get(player);
            if (data != null)
            {
                data.decreasePlayerStamina(msg.staminaDecrease);
            }
        }
    }
}
