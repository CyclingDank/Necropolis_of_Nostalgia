package com.turtledove.withernauts.server.blocks;

import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockForestShrub  extends BlockBush
{
    private static final AxisAlignedBB BOUNDING_BOX;

    static
    {
        final float size = 0.4F;
        BOUNDING_BOX = new AxisAlignedBB(0.5F - size, 0.0F, 0.5F - size, 0.5F + size, 0.8F, 0.5F + size);
    }
    public BlockForestShrub()
    {
        super(Material.PLANTS);
        this.setRegistryName("forest_shrub");
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setUnlocalizedName("forest_shrub");
        this.setTickRandomly(true);
        this.setSoundType(SoundType.PLANT);
    }
    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        IBlockState soil = worldIn.getBlockState(pos.down());
        return super.canPlaceBlockAt(worldIn, pos) && this.canSustainBush(soil);
    }
    @Override
    protected boolean canSustainBush(IBlockState state)
    {
        return state.getBlock() == Blocks.GRASS;
    }
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return null;
    }
    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
    {
        if (worldIn.isRemote)
            return;
        if (stack.getItem() == Items.SHEARS)
        {
            worldIn.setBlockToAir(pos);
            spawnAsEntity(worldIn, pos, new ItemStack(BlockHandler.FOREST_SHRUB, 1));
        }
        else
        {
            return;
        }
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
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }
    @Override
    public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        return false;
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
    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

}
