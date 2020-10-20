package com.turtledove.withernauts.server.packets.Player;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PlayerSyncCapability implements IMessage
{
    public PlayerSyncCapability()
    {
    }

    @Override
    public void fromBytes(ByteBuf buf) {
    }

    @Override
    public void toBytes(ByteBuf buf) {
    }

    public static class Handler extends MessageHandler.Server<PlayerSyncCapability>
    {

        @Override
        public void handleServerMessage(final EntityPlayer player, final PlayerSyncCapability msg)
        {
        }
    }
}
