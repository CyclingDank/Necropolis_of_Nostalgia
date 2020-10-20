package com.turtledove.withernauts.server.world.generation;

import com.turtledove.withernauts.server.blocks.BlockRepitifleur;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenForestFloor extends WorldGenerator
{
    public WorldGenForestFloor() {}
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        BlockRepitifleur tPlant = new BlockRepitifleur();

        for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), 0.0, rand.nextInt(8) - rand.nextInt(8));
            this.setDirt(worldIn, blockpos);
            this.setDirt(worldIn, blockpos.north());
            this.setDirt(worldIn, blockpos.south());
            this.setDirt(worldIn, blockpos.east());
            this.setDirt(worldIn, blockpos.west());
        }

        return true;
    }
    public void setDirt(World worldIn, BlockPos blockpos)
    {
        if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 255) && worldIn.getBlockState(blockpos.down()).getBlock() instanceof BlockGrass)
        {
            worldIn.setBlockState(blockpos.down(), Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT), 2);
        }
    }
}