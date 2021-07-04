package com.turtledove.necropolisofnostalgia;

import com.turtledove.necropolisofnostalgia.client.render.entity.*;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.*;
import com.turtledove.necropolisofnostalgia.server.packets.PacketHandler;
import net.ilexiconn.llibrary.server.ServerEventHandler;
import net.minecraft.world.GameRules;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.client.registry.RenderingRegistry;

@Mod(modid = Necropolis_of_Nostalgia.MODID, name = Necropolis_of_Nostalgia.NAME, version = Necropolis_of_Nostalgia.VERSION)
public class Necropolis_of_Nostalgia {
    public static final String MODID = "turtdance";
    public static final String NAME = "Necropolis of Nostalgia";
    public static final String VERSION = "1.0";

    private static Logger logger;
    private static int nextEntityId;

    public static PacketHandler packetHandler;
    public static Logger LOG;

    private static final class Holder {
        private static final Necropolis_of_Nostalgia INSTANCE = new Necropolis_of_Nostalgia();
    }


    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LOG = event.getModLog();
        MinecraftForge.EVENT_BUS.register(ServerEventHandler.INSTANCE);
        if (event.getSide() == Side.CLIENT)
        {
            RenderingRegistry.registerEntityRenderingHandler(EntityNecropolisSkeleton.class, RenderNecropolisSkeleton::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityAxeBeak.class, RenderAxeBeak::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityVampireBat.class, RenderVampireBat::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityBooglin.class, RenderBooglin::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityNecropolisSpider.class, RenderNecropolisSpider::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityBabyNecropolisSpider.class, RenderBabyNecropolisSpider::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityFugu.class, RenderFugu::new);
        }
    }

    @Mod.EventHandler
    public void serverStarted(FMLServerStartedEvent event) {
        GameRules gr = FMLCommonHandler.instance().getMinecraftServerInstance().worlds[0].getGameRules();
        gr.setOrCreateGameRule("keepInventory", Boolean.toString(Boolean.TRUE));
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        Necropolis_of_Nostalgia.packetHandler = new PacketHandler(Necropolis_of_Nostalgia.MODID);
        Necropolis_of_Nostalgia.packetHandler.registerPackets();
    }

    @Mod.InstanceFactory
    public static Necropolis_of_Nostalgia instance() {
        return Holder.INSTANCE;
    }
}
