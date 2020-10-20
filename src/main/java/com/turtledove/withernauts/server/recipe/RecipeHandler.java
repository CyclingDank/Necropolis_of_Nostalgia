package com.turtledove.withernauts.server.recipe;

import com.turtledove.withernauts.Necropolis_of_Nostalgia;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Necropolis_of_Nostalgia.MODID)
public class RecipeHandler
{
    private RecipeHandler() {}

    @SubscribeEvent
    public static void register(RegistryEvent.Register<IRecipe> event)
    {

    }
}
