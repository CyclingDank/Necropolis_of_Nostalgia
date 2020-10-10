package com.turtledove.necropolisofnostalgia.server.blocks;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID)
@Mod.EventBusSubscriber(modid = Necropolis_of_Nostalgia.MODID)
public final class BlockHandler
{
    public BlockHandler() {}

    public static final BlockBakeKettle BAKE_KETTLE = null;
    public static final BlockRepitifleur REPITIFLEUR = null;
    public static final BlockKelp KELP = null;
    public static final BlockRice RICE = null;
    public static final BlockCatTail CAT_TAIL = null;
    public static final BlockDuckWeed DUCKWEED = null;
    public static final BlockBarrierBlastia BARRIER_BLASTIA = null;
    public static final BlockBlueprintBase YAM_BLUEPRINT = null;
    public static final BlockBlueprintBase FARM_PLOT = null;
    public static final BlockBlueprintBase TEA_BLUEPRINT = null;
    public static final BlockBlueprintBase RICE_FARM_PLOT = null;
    public static final BlockBlueprintBase DWIGT_BLUEPRINT = null;
    public static final BlockBlueprintBase RITA_BLUEPRINT = null;
    public static final BlockBlueprintBase CARLSON_BLUEPRINT = null;
    @SubscribeEvent
    public static void register(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(
                new BlockBakeKettle(),
                new BlockRepitifleur(),
                new BlockKelp(),
                new BlockRice(),
                new BlockCatTail(),
                new BlockDuckWeed(),
                new BlockBarrierBlastia(),
                new BlockBlueprintBase("yam_blueprint", 0),
                new BlockBlueprintBase("farm_plot", 1),
                new BlockBlueprintBase("tea_blueprint", 2),
                new BlockBlueprintBase("rice_farm_plot", 3),
                new BlockBlueprintBase("dwigt_blueprint", 4),
                new BlockBlueprintBase("rita_blueprint", 5),
                new BlockBlueprintBase("carlson_blueprint", 6)

        );
    }
}
