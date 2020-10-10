package com.turtledove.necropolisofnostalgia.server.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;

import java.util.Random;

public class BiomeWarmOcean extends Biome {
    public BiomeWarmOcean()
    {
        super(new BiomeProperties("warmocean").setBaseHeight(-1.0F).setHeightVariation(0.1F).setWaterColor(65502));
        setRegistryName("warmocean");
        this.spawnableCreatureList.clear();
        this.topBlock = Blocks.SAND.getDefaultState();
        this.decorator.treesPerChunk = -999;
        this.decorator.deadBushPerChunk = 0;
        this.decorator.reedsPerChunk = 0;
        this.decorator.cactiPerChunk = 0;
    }
    public Biome.TempCategory getTempCategory()
    {
        return TempCategory.OCEAN;
    }
}
