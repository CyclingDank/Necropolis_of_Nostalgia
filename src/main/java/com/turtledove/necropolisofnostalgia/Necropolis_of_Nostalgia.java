package com.turtledove.necropolisofnostalgia;

import com.turtledove.necropolisofnostalgia.client.gui.INecropolisItemHandler;
import com.turtledove.necropolisofnostalgia.client.gui.NecropolisGuiHandler;
import com.turtledove.necropolisofnostalgia.client.gui.NecropolisItemHandler;
import com.turtledove.necropolisofnostalgia.client.inputs.ClientKeyHandler;
import com.turtledove.necropolisofnostalgia.client.render.entity.*;
import com.turtledove.necropolisofnostalgia.client.render.entity.RenderBeast;
import com.turtledove.necropolisofnostalgia.client.render.npc.*;
import com.turtledove.necropolisofnostalgia.server.core.IGuiStorage;
import com.turtledove.necropolisofnostalgia.server.core.IPlayerData;
import com.turtledove.necropolisofnostalgia.server.core.IPlayerDataStorage;
import com.turtledove.necropolisofnostalgia.server.core.PlayerData;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.*;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.*;
import com.turtledove.necropolisofnostalgia.server.entity.items.EntityBook;
import com.turtledove.necropolisofnostalgia.server.entity.npc.*;
import com.turtledove.necropolisofnostalgia.server.events.NecropolisCapabilitiesHandler;
import com.turtledove.necropolisofnostalgia.server.packets.Player.PacketHandler;
import com.turtledove.necropolisofnostalgia.server.world.biome.NecropolisBiomes;
import net.ilexiconn.llibrary.server.ServerEventHandler;
import net.minecraft.world.GameRules;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityLivingBase;

import com.turtledove.necropolisofnostalgia.server.entity.Spiral_Draco.EntitySpiral_Draco;

import java.util.Random;

@Mod(modid = Necropolis_of_Nostalgia.MODID, name = Necropolis_of_Nostalgia.NAME, version = Necropolis_of_Nostalgia.VERSION)
public class Necropolis_of_Nostalgia {
    public static DamageSource dracoFire;
    public static DamageSource artes;
    public static DamageSource physical_artes;

    public static DamageSource melee;

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
            RenderingRegistry.registerEntityRenderingHandler(EntitySpiral_Draco.class, RenderSpiral_Draco::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityCast.class, RenderCast::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityDemonFang.class, RenderDemonFang::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityBook.class, RendereBookBase::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityNecropolisSkeleton.class, RenderNecropolisSkeleton::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityBeast.class, RenderBeast::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityPhoton.class, RenderPhoton::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityHealingCircle.class, RenderHealingCircle::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityJudgement.class, RenderJudgement::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityJudgementController.class, RenderJudgementController::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityGroundStrike.class, RenderGroundStrike::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityDispel.class, RenderDispel::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityNecropolisFireBall.class, RenderNecropolisFireBall::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityPB.class, RenderPB::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityOF.class, RenderOF::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityOFController.class, RenderOFController::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityNosferatu.class, RenderNosferatu::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityNosferatuCloud.class, RenderNosferatuCloud::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityThunderBlade.class, RenderThunderBlade::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityEruption.class, RenderEruption::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityTidalWave.class, RenderTidalWave::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityMeteor.class, RenderMeteor::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityMeteorController.class, RenderMeteorController::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityDestructionField.class, RenderDestructionField::new);


            RenderingRegistry.registerEntityRenderingHandler(EntityAxeBeak.class, RenderAxeBeak::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityCultSorceress.class, RenderCultSorceress::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityVampireBat.class, RenderVampireBat::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityBooglin.class, RenderBooglin::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityNecropolisSpider.class, RenderNecropolisSpider::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityBabyNecropolisSpider.class, RenderBabyNecropolisSpider::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityBedrockGolem.class, RenderBedrockGolem::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityFugu.class, RenderFugu::new);

            //NPCs
            RenderingRegistry.registerEntityRenderingHandler(EntityYam.class, RenderYamNPC::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityTea.class, RenderTeaNPC::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityDwigt.class, RenderDwigtNPC::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityRita.class, RenderRitaNPC::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityCarlson.class, RenderCarlsonNPC::new);

            RenderingRegistry.registerEntityRenderingHandler(EntityWM.class, RenderTurtNPC::new);
        }

        CapabilityManager.INSTANCE.register(IPlayerData.class, new IPlayerDataStorage(), PlayerData::new);
        CapabilityManager.INSTANCE.register(INecropolisItemHandler.class, new IGuiStorage(), NecropolisItemHandler::new);
        NetworkRegistry.INSTANCE.registerGuiHandler(Necropolis_of_Nostalgia.MODID, new NecropolisGuiHandler());

        ClientKeyHandler.initKeybinds();
        NecropolisBiomes.registerBiomes();


        MinecraftForge.EVENT_BUS.register(new ClientKeyHandler());  //handler for key events
        MinecraftForge.EVENT_BUS.register(new NecropolisCapabilitiesHandler()); //handler for player events
    }

    @Mod.EventHandler
    public void serverStarted(FMLServerStartedEvent event) {
        GameRules gr = FMLCommonHandler.instance().getMinecraftServerInstance().worlds[0].getGameRules();
        gr.setOrCreateGameRule("keepInventory", Boolean.toString(Boolean.TRUE));
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        dracoFire = new DamageSource("draco_fire") {
            @Override
            public ITextComponent getDeathMessage(EntityLivingBase entityLivingBaseIn)
            {
                String s = "death.attack.draco_fire";
                String s1 = s + ".player_" + new Random().nextInt(2);
                return new TextComponentString(entityLivingBaseIn.getDisplayName().getFormattedText() + " ").appendSibling(new TextComponentTranslation(s1, entityLivingBaseIn.getDisplayName()));
            }
        }.setFireDamage();
        artes = new DamageSource("arte") {
            @Override
            public ITextComponent getDeathMessage(EntityLivingBase entityLivingBaseIn)
            {
                String s = "death.attack.arte";
                String s1 = s + ".player_" + new Random().nextInt(2);
                return new TextComponentString(entityLivingBaseIn.getDisplayName().getFormattedText() + " ").appendSibling(new TextComponentTranslation(s1, entityLivingBaseIn.getDisplayName()));
            }
        }.setDamageBypassesArmor();
        physical_artes = new DamageSource("physical_artes") {
            @Override
            public ITextComponent getDeathMessage(EntityLivingBase entityLivingBaseIn)
            {
                String s = "death.attack.physical_artes";
                String s1 = s + ".player_" + new Random().nextInt(2);
                return new TextComponentString(entityLivingBaseIn.getDisplayName().getFormattedText() + " ").appendSibling(new TextComponentTranslation(s1, entityLivingBaseIn.getDisplayName()));
            }
        }.setDamageBypassesArmor();
        melee = new DamageSource("melee") {
            @Override
            public ITextComponent getDeathMessage(EntityLivingBase entityLivingBaseIn)
            {
                String s = "death.attack.melee";
                String s1 = s + ".player_" + new Random().nextInt(2);
                return new TextComponentString(entityLivingBaseIn.getDisplayName().getFormattedText() + " ").appendSibling(new TextComponentTranslation(s1, entityLivingBaseIn.getDisplayName()));
            }
        }.setDamageBypassesArmor();
        Necropolis_of_Nostalgia.packetHandler = new PacketHandler(Necropolis_of_Nostalgia.MODID);
        Necropolis_of_Nostalgia.packetHandler.registerPackets();

    }

    @Mod.InstanceFactory
    public static Necropolis_of_Nostalgia instance() {
        return Holder.INSTANCE;
    }
}
