package com.turtledove.withernauts.server.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

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
