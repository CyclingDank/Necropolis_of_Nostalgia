package com.turtledove.necropolisofnostalgia.server.world.generation;

import com.turtledove.necropolisofnostalgia.server.blocks.BlockHandler;
import com.turtledove.necropolisofnostalgia.server.blocks.BlockKelp;
import com.turtledove.necropolisofnostalgia.server.blocks.BlockRepitifleur;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenKelp  extends WorldGenerator
{
    public WorldGenKelp() {}
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        BlockKelp tPlant = new BlockKelp();

        if (worldIn.getBlockState(position.down()).getMaterial() == Material.WATER)
        {
            BlockPos waterPos = position.down();
            for (int m = 0; m < 30; m++)
            {
                if (isOceanFloor(worldIn, waterPos.down(m)))
                {
                    for (int i = 0; i < 64; ++i)
                    {
                        BlockPos blockpos = waterPos.down(m).add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

                        if (tPlant.canSustainKelp(worldIn.getBlockState(blockpos)))
                        {
                            int h = 2;
                            h += (int)(Math.random() * 20.0D);
                            BlockPos startPos = blockpos;
                            for (int j = 0; j < h; j++)
                            {
                                startPos = startPos.up();
                                if (worldIn.getBlockState(startPos.up()).getBlock() == Blocks.WATER)
                                {
                                    worldIn.setBlockState(startPos, BlockHandler.KELP.getDefaultState(), 2);
                                }
                                else
                                {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isMaterial(Material material, World world, BlockPos pos) {
        return world.getBlockState(pos).getMaterial() == material;
    }
    public static boolean isOceanFloor(World world, BlockPos pos) {
        return isMaterial(Material.WATER, world, pos.up(1))
                && isMaterial(Material.WATER, world, pos)
                && !(isMaterial(Material.WATER, world, pos.down()));
    }
}