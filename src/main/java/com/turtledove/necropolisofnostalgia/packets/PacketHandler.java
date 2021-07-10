package com.turtledove.necropolisofnostalgia.packets;

import com.turtledove.necropolisofnostalgia.packets.Player.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public final class PacketHandler {

    /**
     * The ID for the next packet registration.
     */

    private byte nextPacketID = 0;
    /**
     * The internal network wrapper.
     */
    private SimpleNetworkWrapper wrapper;
    /**
     * The channelid.
     */
    private String channelid;

    /**
     * Instantiates a new packet handler with the given channelid and reserves
     * the channel.
     *
     * @param channelid the channelid. This is mostly the modid.
     */
    public PacketHandler(String channelid) {
        this.wrapper = NetworkRegistry.INSTANCE.newSimpleChannel(channelid);
        this.channelid = channelid;
    }

    public void registerPackets()
    {
        registerPacket(PlayerParticlePacket.class, new PlayerParticlePacket.Handler(), Side.CLIENT);
    }

    /**
     * Register an IMessage packet with it's corresponding message handler.
     *
     * @param packetClass    the packet's class that should be registered.
     * @param messageHandler the message handler for this packet type.
     * @param target         The side to which this packet can be sent.
     * @return <code>true</code>, if successful
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public boolean registerPacket(Class<? extends IMessage> packetClass, MessageHandler messageHandler, Side target) {
        if (this.nextPacketID == -1)
            throw new IllegalStateException("Too many packets registered for channel " + this.channelid);

        this.wrapper.registerMessage(messageHandler, packetClass, this.nextPacketID, target);
        Log.debug("Registered packet class %s with handler class %s for the channel %s. Send direction: to %s. The discriminator is %s.", packetClass.getSimpleName(), messageHandler.getClass().getSimpleName(), this.channelid, target.name().toLowerCase(), this.nextPacketID);
        this.nextPacketID++;
        return true;
    }

    /**
     * Sends the given packet to every client.
     *
     * @param message the packet to send.
     */
    public void sendToAll(IMessage message) {
        this.wrapper.sendToAll(message);
    }

    /**
     * Sends the given packet to the given player.
     *
     * @param message the packet to send.
     * @param player  the player to send the packet to.
     */
    public void sendTo(IMessage message, EntityPlayerMP player) {
        if (player.connection != null)
            this.wrapper.sendTo(message, player);
    }

    /**
     * Sends the given packet to all players around the given target point.
     *
     * @param message the packet to send.
     * @param point   the target point.
     */
    public void sendToAllAround(IMessage message, NetworkRegistry.TargetPoint point) {
        this.wrapper.sendToAllAround(message, point);
    }

    /**
     * Sends the given packet to all players within the radius around the given coordinates.
     *
     * @param message   the packet to send.
     * @param dimension the dimension.
     * @param x         the x coordinate.
     * @param y         the y coordinate.
     * @param z         the z coordinate.
     * @param range     the radius.
     */
    public void sendToAllAround(IMessage message, int dimension, double x, double y, double z, double range) {
        this.sendToAllAround(message, new NetworkRegistry.TargetPoint(dimension, x, y, z, range));
    }

    /**
     * Sends the given packet to all players within the radius around the given entity.
     *
     * @param message the packet to send.
     * @param entity  the entity.
     * @param range   the radius.
     */
    public void sendToAllAround(IMessage message, Entity entity, double range) {
        this.sendToAllAround(message, entity.dimension, entity.posX, entity.posY, entity.posZ, range);
    }

    /**
     * Sends the given packet to the server.
     *
     * @param message the packet to send.
     */
    public void sendToServer(IMessage message)
    {
        this.wrapper.sendToServer(message);
    }

    public void sendToAllTracking(IMessage message, Entity entity) {
        this.wrapper.sendToAllTracking(message, entity);
    }
}