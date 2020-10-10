package com.turtledove.necropolisofnostalgia.server.world.biome;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import net.minecraft.init.Biomes;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.lang.reflect.Method;

public class NecropolisBiomes
{
    public final static BiomeWarmOcean wOcean = new BiomeWarmOcean();
    @SubscribeEvent
    public static void registerBiomes()
    {
        System.out.printf("%n");
        System.out.print("REGISTERING BIOMES");
        System.out.printf("%n");

        NecropolisBiomes.initBiomeManagerAndDictionary();
    }

    public static Biome initBiomeManagerAndDictionary()
    {
        ForgeRegistries.BIOMES.register(wOcean);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(wOcean, 100));
        BiomeManager.addSpawnBiome(wOcean);
        BiomeDictionary.addTypes(wOcean, BiomeDictionary.Type.OCEAN
        );
        return wOcean;
    }
}
