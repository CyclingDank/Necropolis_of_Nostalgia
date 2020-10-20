package com.turtledove.withernauts.common.structures;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public class BlueprintStructure
{
    public class BluePrintPiece
    {
        public BlockPos piecePos;
        public Block pieceBlock;

        public BluePrintPiece(BlockPos tPos, Block tBlock)
        {
            this.piecePos = tPos;
            this.pieceBlock = tBlock;
        }
    }
    public ArrayList<BluePrintPiece>tStructure;

    public BlueprintStructure()
    {
        tStructure = new ArrayList<BluePrintPiece>();
    }
    public void addBlocktoStructure(BlockPos tPos, Block tBlock)
    {
        tStructure.add(new BluePrintPiece(tPos, tBlock));
    }
    public BlockPos rotatePos(BlockPos blueprintPos, int rotation)
    {
        if (rotation == 0)
            return blueprintPos;
        else if (rotation == 1)
            return blueprintPos.rotate(Rotation.CLOCKWISE_90);
        else if (rotation == 2)
            return blueprintPos.rotate(Rotation.CLOCKWISE_180);
        else
            return blueprintPos.rotate(Rotation.COUNTERCLOCKWISE_90);
    }
    public BlockPos getStructureWorldPos(BlockPos blueprintPos, BluePrintPiece worldStructure, int rotation)    //0 is 0, 1 is 90, 2 is 180, 3 is 270
    {
        BlockPos rotatedPos = this.rotatePos(worldStructure.piecePos, rotation);
        BlockPos tBLock = rotatedPos.add(blueprintPos);
        return tBLock;
    }
    public boolean arePiecesEqual(World worldIn, BlockPos worldPos, BluePrintPiece sPiece)
    {
        if (worldIn.getBlockState(worldPos).getBlock().equals(sPiece.pieceBlock))
            return true;
        else if (sPiece.pieceBlock instanceof BlockDoor)
        {
            if (worldIn.getBlockState(worldPos).getBlock() instanceof BlockDoor)
                return true;
        }
        return false;
    }

}
