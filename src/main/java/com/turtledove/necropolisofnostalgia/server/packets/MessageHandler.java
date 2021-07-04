package com.turtledove.necropolisofnostalgia.server.packets;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public abstract class MessageHandler<T extends IMessage> implements IMessageHandler<T, IMessage> {

    @SideOnly(Side.CLIENT)
    public abstract void handleClientMessage(final EntityPlayer player, final T msg);

    public abstract void handleServerMessage(final EntityPlayer player, final T msg);

    @SideOnly(Side.CLIENT)
    private void runHandleClient(T message, MessageContext ctx) {
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer player = ctx.side.isClient() ? mc.player : ctx.getServerHandler().player;
        mc.addScheduledTask(() -> handleClientMessage(player, message));
    }

    private void runHandleServer(T message, MessageContext ctx) {
        EntityPlayer player = ctx.getServerHandler().player;
        FMLCommonHandler.instance().getMinecraftServerInstance()
                .addScheduledTask(() -> handleServerMessage(player, message));
    }

    @Override
    public final IMessage onMessage(T message, MessageContext ctx) {
        if (ctx.side.isClient()) {
            this.runHandleClient(message, ctx);
        } else {
            this.runHandleServer(message, ctx);
        }
        return null;
    }

    public static abstract class Client<T extends IMessage> extends MessageHandler<T> {
        @Override
        public final void handleServerMessage(EntityPlayer player, T message) {
        }
    }

    public static abstract class Server<T extends IMessage> extends MessageHandler<T> {
        @Override
        public final void handleClientMessage(EntityPlayer player, T message) {
        }
    }
}