package com.turtledove.necropolisofnostalgia.server.packets.Player;

import com.turtledove.necropolisofnostalgia.server.packets.MessageHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PlayerParticlePacket  implements IMessage
{
    public int particleIndex;
    double x, y, z;
    double sx, sy, sz;
    public PlayerParticlePacket() {this.particleIndex = 0;}
    public PlayerParticlePacket(int decr, double pX, double pY, double pZ, double sX, double sY, double sZ)
    {
        this.particleIndex = decr;
        this.x = pX;
        this.y = pY;
        this.z = pZ;
        this.sx = sX;
        this.sy = sY;
        this.sz = sZ;
    }
    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.particleIndex = buf.readInt();
        this.x = buf.readDouble();
        this.y = buf.readDouble();
        this.z = buf.readDouble();
        this.sx = buf.readDouble();
        this.sy = buf.readDouble();
        this.sz = buf.readDouble();

    }
    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.particleIndex);
        buf.writeDouble(this.x);
        buf.writeDouble(this.y);
        buf.writeDouble(this.z);
        buf.writeDouble(this.sx);
        buf.writeDouble(this.sy);
        buf.writeDouble(this.sz);

    }
    public static class Handler extends MessageHandler.Client<PlayerParticlePacket>
    {
        @Override
        public void handleClientMessage(final EntityPlayer player, final PlayerParticlePacket msg)
        {
            if (msg.particleIndex == 0)
            {
                player.world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, msg.x,  msg.y,  msg.z, msg.sx, msg.sy, msg.sz);
            }
            else if (msg.particleIndex == 1)
            {
                player.world.spawnParticle(EnumParticleTypes.SPELL, msg.x,  msg.y,  msg.z, msg.sx, msg.sy, msg.sz);
            }
        }
    }
}
