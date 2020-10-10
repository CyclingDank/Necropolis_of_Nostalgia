package com.turtledove.necropolisofnostalgia.server.blocks;

import com.turtledove.necropolisofnostalgia.server.core.NecropolisPlayerData;
import com.turtledove.necropolisofnostalgia.server.core.PlayerData;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockRepitifleur extends BlockBush
{
    public static final PropertyInteger IS_FLOWERED = PropertyInteger.create("isflowered", 0, 1);
    public BlockRepitifleur()
    {
        super(Material.PLANTS);
        this.setRegistryName("repitifleur");
        this.setDefaultState(this.blockState.getBaseState().withProperty(IS_FLOWERED, Integer.valueOf(0)));
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setUnlocalizedName("repitifleur");
        this.setTickRandomly(true);
        this.setSoundType(SoundType.PLANT);

    }
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (state.getValue(IS_FLOWERED) == 0)
        {
            worldIn.setBlockState(pos, state.withProperty(IS_FLOWERED, Integer.valueOf(1)), 3);
            if (playerIn.world.isRemote)
            {
                PlayerData data = (PlayerData) NecropolisPlayerData.get(playerIn);
                data.setPlayerStamina(800);
                playerIn.playSound(SoundEvents.BLOCK_SLIME_BREAK, 0.6F, 1.0F);
                return true;

            }
            playerIn.playSound(SoundEvents.BLOCK_SLIME_BREAK, 0.6F, 1.0F);
        }
        return true;
    }
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        super.updateTick(worldIn, pos, state, rand);
        if (!worldIn.isAreaLoaded(pos, 1)) return;
        if (state.getValue(IS_FLOWERED) == 1)
        {
            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(3) == 0)
            {
                worldIn.setBlockState(pos, state.withProperty(IS_FLOWERED, Integer.valueOf(0)), 3);
            }
        }
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
        if (stack.getItem() == Items.SHEARS && state.getValue(IS_FLOWERED) == 0)
        {
            player.addStat(StatList.getBlockStats(this));
            worldIn.setBlockToAir(pos);
            spawnAsEntity(worldIn, pos, new ItemStack(BlockHandler.REPITIFLEUR, 1));
        }
        else
        {
            return;
            //super.harvestBlock(worldIn, player, pos, state, te, stack);
        }
    }
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
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
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {IS_FLOWERED});
    }
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(IS_FLOWERED, Integer.valueOf(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
            return ((Integer)state.getValue(IS_FLOWERED)).intValue();

    }
    public IBlockState getPlantState()
    {
        return this.blockState.getBaseState().withProperty(IS_FLOWERED, Integer.valueOf(1));
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

}
