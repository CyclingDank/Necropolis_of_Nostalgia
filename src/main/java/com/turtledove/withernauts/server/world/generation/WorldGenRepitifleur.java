package com.turtledove.withernauts.server.world.generation;

import com.turtledove.withernauts.server.blocks.BlockHandler;
import com.turtledove.withernauts.server.blocks.BlockRepitifleur;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;


public class WorldGenRepitifleur extends WorldGenerator
{
    public WorldGenRepitifleur() {}
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        BlockRepitifleur tPlant = new BlockRepitifleur();

        for (int i = 0; i < 32; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 255) && tPlant.canBlockStay(worldIn, blockpos, tPlant.getDefaultState()))
            {
                worldIn.setBlockState(blockpos, BlockHandler.REPITIFLEUR.getDefaultState(), 2);
            }
        }

        return true;
    }
}