package com.turtledove.withernauts.server.world.generation;

import com.turtledove.withernauts.server.blocks.BlockHandler;
import com.turtledove.withernauts.server.blocks.BlockRepitifleur;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenForestShrub extends WorldGenerator
{
    public WorldGenForestShrub() {}
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        BlockRepitifleur tPlant = new BlockRepitifleur();

        for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
            this.setShrub(worldIn, blockpos);
            this.setShrub(worldIn, blockpos.north());
            this.setShrub(worldIn, blockpos.south());
            this.setShrub(worldIn, blockpos.east());
            this.setShrub(worldIn, blockpos.west());
        }

        return true;
    }
    public void setShrub(World worldIn, BlockPos blockpos)
    {
        if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 255) && (worldIn.getBlockState(blockpos.down()).getBlock() instanceof BlockGrass ||
                worldIn.getBlockState(blockpos.down()).getBlock() instanceof BlockDirt))
        {
            worldIn.setBlockState(blockpos, BlockHandler.FOREST_SHRUB.getDefaultState(), 2);
        }
    }
}