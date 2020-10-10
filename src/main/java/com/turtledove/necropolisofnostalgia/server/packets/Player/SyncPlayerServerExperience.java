package com.turtledove.necropolisofnostalgia.server.packets.Player;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class SyncPlayerServerExperience implements IMessage
{
    int pLevel;
    double pExp;

    public SyncPlayerServerExperience()
    {
        this.pLevel = 0;
        this.pExp = 0.0;
    }

    public SyncPlayerServerExperience(int level, double xp)
    {
        this.pLevel = level;
        this.pExp = xp;
    }
    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.pLevel = buf.readInt();
        this.pExp = buf.readDouble();
    }
    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.pLevel);
        buf.writeDouble(this.pExp);
    }

    public static class Handler extends MessageHandler.Client<SyncPlayerServerExperience>
    {
        @Override
        public void handleClientMessage(final EntityPlayer player, SyncPlayerServerExperience msg)
        {
            player.experienceLevel = msg.pLevel;
            player.experience = (float)msg.pExp;
        }
    }
}
