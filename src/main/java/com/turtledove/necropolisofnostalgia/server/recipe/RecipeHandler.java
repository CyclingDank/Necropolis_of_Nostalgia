package com.turtledove.necropolisofnostalgia.server.recipe;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber(modid = Necropolis_of_Nostalgia.MODID)
public class RecipeHandler
{
    private RecipeHandler() {}

    @SubscribeEvent
    public static void register(RegistryEvent.Register<IRecipe> event)
    {

    }
}
