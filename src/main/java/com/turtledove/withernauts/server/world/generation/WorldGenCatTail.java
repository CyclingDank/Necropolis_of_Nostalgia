package com.turtledove.withernauts.server.world.generation;

import com.turtledove.withernauts.server.blocks.BlockCatTail;
import com.turtledove.withernauts.server.blocks.BlockHandler;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenCatTail extends WorldGenerator
{
    public WorldGenCatTail() {}
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        BlockCatTail tPlant = new BlockCatTail();

        if (worldIn.getBlockState(position.down()).getMaterial() == Material.WATER)
        {
            BlockPos waterPos = position;
            if (isSwampFloor(worldIn, waterPos))
            {
                for (int i = 0; i < 64; ++i)
                {
                    BlockPos blockpos = waterPos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
                    if (this.isSwampFloor(worldIn, blockpos))
                    {
                        BlockPos startPos = blockpos;
                        worldIn.setBlockState(startPos, BlockHandler.CAT_TAIL.getDefaultState(), 2);

                    }
                }
                for (int i = 0; i < 64; ++i)
                {
                    BlockPos blockpos = waterPos.add(rand.nextInt(8) - rand.nextInt(8), 0.0, rand.nextInt(8) - rand.nextInt(8));
                    Biome biome = worldIn.getBiomeForCoordsBody(blockpos);

                    if (isSwamp(worldIn, blockpos) && biome.isHighHumidity())
                    {
                        BlockPos startPos = blockpos;
                        BlockPos neighborW = startPos.west();
                        BlockPos neighborE = startPos.east();
                        BlockPos neighborN = startPos.north();
                        BlockPos neighborS = startPos.south();

                        worldIn.setBlockState(startPos, BlockHandler.DUCKWEED.getDefaultState(), 2);

                        if (isSwamp(worldIn, neighborW))
                            worldIn.setBlockState(neighborW, BlockHandler.DUCKWEED.getDefaultState(), 2);
                        if (isSwamp(worldIn, neighborE))
                            worldIn.setBlockState(neighborE, BlockHandler.DUCKWEED.getDefaultState(), 2);
                        if (isSwamp(worldIn, neighborS))
                            worldIn.setBlockState(neighborS, BlockHandler.DUCKWEED.getDefaultState(), 2);
                        if (isSwamp(worldIn, neighborN))
                            worldIn.setBlockState(neighborN, BlockHandler.DUCKWEED.getDefaultState(), 2);
                    }
                }
            }
        }
        return true;
    }

    public static boolean isMaterial(Material material, World world, BlockPos pos) {
        return world.getBlockState(pos).getMaterial() == material;
    }
    public static boolean isSwampFloor(World world, BlockPos pos) {
        return isMaterial(Material.AIR, world, pos)
                && isMaterial(Material.WATER, world, pos.down())
                && (isMaterial(Material.GROUND, world, pos.down().down()));
    }
    public static boolean isSwamp(World world, BlockPos pos) {
        return isMaterial(Material.AIR, world, pos)
                && isMaterial(Material.WATER, world, pos.down());
    }
}