package com.turtledove.necropolisofnostalgia.server.blocks;

import com.turtledove.necropolisofnostalgia.server.tiles.TileEntityBarrierBlastia;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBarrierBlastia extends BlockContainer {
    private int showBounds;
    public BlockBarrierBlastia()
    {
        super(Material.IRON);
        this.setBlockUnbreakable().setResistance(6000000.0F);
        this.setRegistryName("barrier_blastia");
        this.setUnlocalizedName("barrier_blastia");
        this.setLightLevel(1.0F);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityBarrierBlastia();
        //return tile entity
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        //open gui here
        if (!worldIn.isRemote && hand.equals(EnumHand.MAIN_HAND))
        {
            TileEntity tEntity = worldIn.getTileEntity(pos);
            if (tEntity instanceof TileEntityBarrierBlastia)
            {
                TileEntityBarrierBlastia blastiaEntity = ((TileEntityBarrierBlastia) tEntity);
                blastiaEntity.setSouls(playerIn);
            }
        }
        return false;
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
        return BlockRenderLayer.CUTOUT_MIPPED;
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
