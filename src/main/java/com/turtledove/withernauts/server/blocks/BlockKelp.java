package com.turtledove.withernauts.server.blocks;

import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockKelp  extends BlockBush
{
    private static final AxisAlignedBB BOUNDING_BOX;

    static {
        final float size = 0.4F;
        BOUNDING_BOX = new AxisAlignedBB(0.5F - size, 0.0F, 0.5F - size, 0.5F + size, 0.8F, 0.5F + size);
    }
    public BlockKelp()
    {
        super(Material.WATER);
        this.setRegistryName("kelp");
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setUnlocalizedName("kelp");
        this.setSoundType(SoundType.PLANT);
        this.setTickRandomly(true);
        this.setDefaultState(blockState.getBaseState().withProperty(BlockLiquid.LEVEL, 0));
    }
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        for (int i = 0; i < 255; i++)
        {
            if ((worldIn.getBlockState(pos.up(i)).getBlock() != BlockHandler.KELP) && (worldIn.getBlockState(pos.up(i+1)).getBlock() == Blocks.WATER))
            {
                if (worldIn.getBlockState(pos.up(i)).getBlock() == Blocks.WATER)
                {
                    worldIn.setBlockState(pos.up(i), BlockHandler.KELP.getDefaultState());
                }
                break;
            }
        }

        return true;
    }
    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState state, final IBlockAccess source, final BlockPos pos) {
        return BOUNDING_BOX;
    }

    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        IBlockState soil = worldIn.getBlockState(pos.down());
        return this.canSustainKelp(soil);
    }
    @Override
    protected boolean canSustainBush(IBlockState state)
    {
        return this.canSustainKelp(state);
    }
    @Override
    public boolean canBlockStay(final World worldIn, final BlockPos pos, final IBlockState state)
    {
        return (worldIn.getBlockState(pos.up()).getBlock() == Blocks.WATER || worldIn.getBlockState(pos.up()).getBlock() == BlockHandler.KELP) && super.canBlockStay(worldIn, pos, state);
    }
    @Override
    public boolean canPlaceBlockOnSide(final World worldIn, final BlockPos pos, final EnumFacing side) {
        return canBlockStay(worldIn, pos, this.getDefaultState());
    }
    public boolean canSustainKelp(IBlockState state)
    {
        return (state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.SAND || state.getBlock() == Blocks.GRAVEL || state.getBlock() == BlockHandler.KELP
                || state.getBlock() == Blocks.CLAY);
    }


    @Override
    public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        return false;
    }
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, BlockLiquid.LEVEL);
    }
    @Override
    public int getMetaFromState(final IBlockState state)
    {
        return 0;
    }
    @Override
    public void onBlockDestroyedByPlayer(final World worldIn, final BlockPos pos, final IBlockState state) {
        worldIn.setBlockState(pos, Blocks.WATER.getDefaultState());
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return null;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
}
