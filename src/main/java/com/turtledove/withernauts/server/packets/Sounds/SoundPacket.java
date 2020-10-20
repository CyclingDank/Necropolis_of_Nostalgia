package com.turtledove.withernauts.server.packets.Sounds;

import com.turtledove.withernauts.server.packets.Player.MessageHandler;
import com.turtledove.withernauts.server.sounds.NecropolisSounds;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

/*This class is responsible for playing sounds requested from the server.*/
public class SoundPacket implements IMessage
{
    public SoundEvent[] arrayofsounds = new SoundEvent[] {NecropolisSounds.CASTING_40, NecropolisSounds.HEAL, NecropolisSounds.DEMON_FANG,NecropolisSounds.GUARD_HIT,
                                                        NecropolisSounds.DAMAGE, NecropolisSounds.HEALTH_INCREASE, NecropolisSounds.BEAST, NecropolisSounds.CASTING_80,
                                                        NecropolisSounds.ARTE_COMPLETE, NecropolisSounds.RECOVER, NecropolisSounds.LIGHT_CAST};
    private int sound_index;
    private float sound_volume;
    private float sound_pitch;
    public SoundPacket()
    {
        this.sound_index = 0;
        this.sound_volume = 0.0F;
        this.sound_pitch = 1.0F;
    }
    public SoundPacket(int index, float vol, float pitch)
    {
        this.sound_index = index;
        this.sound_volume = vol;
        this.sound_pitch = pitch;
    }
    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.sound_index = buf.readInt();
        this.sound_volume = buf.readFloat();
        this.sound_pitch = buf.readFloat();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.sound_index);
        buf.writeFloat(this.sound_volume);
        buf.writeFloat(this.sound_pitch);
    }
    public static class Handler extends MessageHandler.Client<SoundPacket>
    {
        @Override
        public void handleClientMessage(final EntityPlayer player, final SoundPacket msg)
        {
            player.playSound(msg.arrayofsounds[msg.sound_index],msg.sound_volume, msg.sound_pitch);
        }
    }
}
