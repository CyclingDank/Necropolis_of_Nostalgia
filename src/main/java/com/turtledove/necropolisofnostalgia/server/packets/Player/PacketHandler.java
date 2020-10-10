package com.turtledove.necropolisofnostalgia.server.packets.Player;

import com.turtledove.necropolisofnostalgia.server.packets.Inventory.InventoryPacket;
import com.turtledove.necropolisofnostalgia.server.packets.Log;
import com.turtledove.necropolisofnostalgia.server.packets.Sounds.SoundPacket;
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
        registerPacket(SyncPlayer.class, new SyncPlayer.Handler(),Side.CLIENT);
        registerPacket(SyncPlayerStatsServerSide.class, new SyncPlayerStatsServerSide.Handler(),Side.CLIENT);
        registerPacket(SyncArtesOnServer.class, new SyncArtesOnServer.Handler(), Side.CLIENT);
        registerPacket(SoundPacket.class, new SoundPacket.Handler(), Side.CLIENT);
        registerPacket(SyncServerClientStamina.class, new SyncServerClientStamina.Handler(), Side.CLIENT);
        registerPacket(PlayerParticlePacket.class, new PlayerParticlePacket.Handler(), Side.CLIENT);
        registerPacket(SyncPlayerMerchantServerSide.class, new SyncPlayerMerchantServerSide.Handler(),Side.CLIENT);
        registerPacket(SyncPlayerServerExperience.class, new SyncPlayerServerExperience.Handler(),Side.CLIENT);
        registerPacket(SyncQuestsServerSide.class, new SyncQuestsServerSide.Handler(),Side.CLIENT);
        registerPacket(SyncSingleQuestServerSide.class, new SyncSingleQuestServerSide.Handler(),Side.CLIENT);

        registerPacket(MessagePacket.class, new MessagePacket.Handler(), Side.SERVER);
        registerPacket(SyncPlayerStatsClientSide.class, new SyncPlayerStatsClientSide.Handler(), Side.SERVER);
        registerPacket(SyncPlayerMerchantClientSide.class, new SyncPlayerMerchantClientSide.Handler(), Side.SERVER);
        registerPacket(SyncPlayerExperience.class, new SyncPlayerExperience.Handler(), Side.SERVER);
        registerPacket(WMSpawnItem.class, new WMSpawnItem.Handler(), Side.SERVER);
        registerPacket(InventoryPacket.class, new InventoryPacket.Handler(), Side.SERVER);
        registerPacket(SyncArtesOnClient.class, new SyncArtesOnClient.Handler(), Side.SERVER);
        registerPacket(PlayerSyncCapability.class, new PlayerSyncCapability.Handler(), Side.SERVER);

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