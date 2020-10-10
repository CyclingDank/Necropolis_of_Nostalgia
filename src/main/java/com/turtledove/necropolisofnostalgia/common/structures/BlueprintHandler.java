package com.turtledove.necropolisofnostalgia.common.structures;

import com.turtledove.necropolisofnostalgia.server.blocks.BlockHandler;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class BlueprintHandler
{
    Map<Integer, BlueprintStructure> blueprintStructureMap = new HashMap<Integer, BlueprintStructure>();
    public BlueprintHandler()
    {
        //base house
        BlueprintStructure yamHouse = new BlueprintStructure();
        yamHouse.addBlocktoStructure(new BlockPos(2.0,1.0,0.0), Blocks.OAK_DOOR);

        yamHouse.addBlocktoStructure(new BlockPos(-2.0,0.0,2.0), Blocks.COBBLESTONE);
        yamHouse.addBlocktoStructure(new BlockPos(-1.0,0.0,2.0), Blocks.COBBLESTONE);
        yamHouse.addBlocktoStructure(new BlockPos(0.0,0.0,2.0), Blocks.COBBLESTONE);
        yamHouse.addBlocktoStructure(new BlockPos(1.0,0.0,2.0), Blocks.COBBLESTONE);
        yamHouse.addBlocktoStructure(new BlockPos(2.0,0.0,2.0), Blocks.COBBLESTONE);

        yamHouse.addBlocktoStructure(new BlockPos(-2.0,0.0,1.0), Blocks.COBBLESTONE);
        yamHouse.addBlocktoStructure(new BlockPos(2.0,0.0,1.0), Blocks.COBBLESTONE);

        yamHouse.addBlocktoStructure(new BlockPos(-2.0,0.0,0.0), Blocks.COBBLESTONE);
        yamHouse.addBlocktoStructure(new BlockPos(2.0,0.0,0.0), Blocks.COBBLESTONE);

        yamHouse.addBlocktoStructure(new BlockPos(-2.0,0.0,-1.0), Blocks.COBBLESTONE);
        yamHouse.addBlocktoStructure(new BlockPos(2.0,0.0,-1.0), Blocks.COBBLESTONE);

        yamHouse.addBlocktoStructure(new BlockPos(-2.0,0.0,-2.0), Blocks.COBBLESTONE);
        yamHouse.addBlocktoStructure(new BlockPos(2.0,0.0,-2.0), Blocks.COBBLESTONE);

        yamHouse.addBlocktoStructure(new BlockPos(-2.0,0.0,-3.0), Blocks.COBBLESTONE);
        yamHouse.addBlocktoStructure(new BlockPos(2.0,0.0,-3.0), Blocks.COBBLESTONE);

        yamHouse.addBlocktoStructure(new BlockPos(-2.0,0.0,-4.0), Blocks.COBBLESTONE);
        yamHouse.addBlocktoStructure(new BlockPos(-1.0,0.0,-4.0), Blocks.COBBLESTONE);
        yamHouse.addBlocktoStructure(new BlockPos(0.0,0.0,-4.0), Blocks.COBBLESTONE);
        yamHouse.addBlocktoStructure(new BlockPos(1.0,0.0,-4.0), Blocks.COBBLESTONE);
        yamHouse.addBlocktoStructure(new BlockPos(2.0,0.0,-4.0), Blocks.COBBLESTONE);

        //base farm
        BlueprintStructure farmPlot = new BlueprintStructure();
        farmPlot.addBlocktoStructure(new BlockPos(-2.0,1.0,2.0), Blocks.FARMLAND);
        farmPlot.addBlocktoStructure(new BlockPos(-1.0,1.0,2.0), Blocks.FARMLAND);
        farmPlot.addBlocktoStructure(new BlockPos(0.0,1.0,2.0), Blocks.FARMLAND);
        farmPlot.addBlocktoStructure(new BlockPos(1.0,1.0,2.0), Blocks.FARMLAND);
        farmPlot.addBlocktoStructure(new BlockPos(2.0,1.0,2.0), Blocks.FARMLAND);

        farmPlot.addBlocktoStructure(new BlockPos(-2.0,1.0,1.0), Blocks.FARMLAND);
        farmPlot.addBlocktoStructure(new BlockPos(-1.0,1.0,1.0), Blocks.FARMLAND);
        farmPlot.addBlocktoStructure(new BlockPos(0.0,1.0,1.0), Blocks.FARMLAND);
        farmPlot.addBlocktoStructure(new BlockPos(1.0,1.0,1.0), Blocks.FARMLAND);
        farmPlot.addBlocktoStructure(new BlockPos(2.0,1.0,1.0), Blocks.FARMLAND);

        farmPlot.addBlocktoStructure(new BlockPos(-2.0,1.0,0.0), Blocks.FARMLAND);
        farmPlot.addBlocktoStructure(new BlockPos(-1.0,1.0,0.0), Blocks.FARMLAND);
        farmPlot.addBlocktoStructure(new BlockPos(0.0,1.0,0.0), Blocks.WATER);
        farmPlot.addBlocktoStructure(new BlockPos(1.0,1.0,0.0), Blocks.FARMLAND);
        farmPlot.addBlocktoStructure(new BlockPos(2.0,1.0,0.0), Blocks.FARMLAND);

        farmPlot.addBlocktoStructure(new BlockPos(-2.0,1.0,-1.0), Blocks.FARMLAND);
        farmPlot.addBlocktoStructure(new BlockPos(-1.0,1.0,-1.0), Blocks.FARMLAND);
        farmPlot.addBlocktoStructure(new BlockPos(0.0,1.0,-1.0), Blocks.FARMLAND);
        farmPlot.addBlocktoStructure(new BlockPos(1.0,1.0,-1.0), Blocks.FARMLAND);
        farmPlot.addBlocktoStructure(new BlockPos(2.0,1.0,-1.0), Blocks.FARMLAND);

        farmPlot.addBlocktoStructure(new BlockPos(-2.0,1.0,-2.0), Blocks.FARMLAND);
        farmPlot.addBlocktoStructure(new BlockPos(-1.0,1.0,-2.0), Blocks.FARMLAND);
        farmPlot.addBlocktoStructure(new BlockPos(0.0,1.0,-2.0), Blocks.FARMLAND);
        farmPlot.addBlocktoStructure(new BlockPos(1.0,1.0,-2.0), Blocks.FARMLAND);
        farmPlot.addBlocktoStructure(new BlockPos(2.0,1.0,-2.0), Blocks.FARMLAND);

        //rice farm
        BlueprintStructure riceFarmPlot = new BlueprintStructure();
        riceFarmPlot.addBlocktoStructure(new BlockPos(-2.0,1.0,2.0), Blocks.GRASS_PATH);
        riceFarmPlot.addBlocktoStructure(new BlockPos(-1.0,1.0,2.0), Blocks.WATER);
        riceFarmPlot.addBlocktoStructure(new BlockPos(0.0,1.0,2.0), Blocks.WATER);
        riceFarmPlot.addBlocktoStructure(new BlockPos(1.0,1.0,2.0), Blocks.WATER);
        riceFarmPlot.addBlocktoStructure(new BlockPos(2.0,1.0,2.0), Blocks.GRASS_PATH);

        riceFarmPlot.addBlocktoStructure(new BlockPos(-2.0,1.0,1.0), Blocks.GRASS_PATH);
        riceFarmPlot.addBlocktoStructure(new BlockPos(-1.0,1.0,1.0), Blocks.WATER);
        riceFarmPlot.addBlocktoStructure(new BlockPos(0.0,1.0,1.0), Blocks.WATER);
        riceFarmPlot.addBlocktoStructure(new BlockPos(1.0,1.0,1.0), Blocks.WATER);
        riceFarmPlot.addBlocktoStructure(new BlockPos(2.0,1.0,1.0), Blocks.GRASS_PATH);

        riceFarmPlot.addBlocktoStructure(new BlockPos(-2.0,1.0,0.0), Blocks.GRASS_PATH);
        riceFarmPlot.addBlocktoStructure(new BlockPos(-1.0,1.0,0.0), Blocks.WATER);
        riceFarmPlot.addBlocktoStructure(new BlockPos(0.0,1.0,0.0), Blocks.WATER);
        riceFarmPlot.addBlocktoStructure(new BlockPos(1.0,1.0,0.0), Blocks.WATER);
        riceFarmPlot.addBlocktoStructure(new BlockPos(2.0,1.0,0.0), Blocks.GRASS_PATH);

        riceFarmPlot.addBlocktoStructure(new BlockPos(-2.0,1.0,-1.0), Blocks.GRASS_PATH);
        riceFarmPlot.addBlocktoStructure(new BlockPos(-1.0,1.0,-1.0), Blocks.WATER);
        riceFarmPlot.addBlocktoStructure(new BlockPos(0.0,1.0,-1.0), Blocks.WATER);
        riceFarmPlot.addBlocktoStructure(new BlockPos(1.0,1.0,-1.0), Blocks.WATER);
        riceFarmPlot.addBlocktoStructure(new BlockPos(2.0,1.0,-1.0), Blocks.GRASS_PATH);

        riceFarmPlot.addBlocktoStructure(new BlockPos(-2.0,1.0,-2.0), Blocks.GRASS_PATH);
        riceFarmPlot.addBlocktoStructure(new BlockPos(-1.0,1.0,-2.0), Blocks.WATER);
        riceFarmPlot.addBlocktoStructure(new BlockPos(0.0,1.0,-2.0), Blocks.WATER);
        riceFarmPlot.addBlocktoStructure(new BlockPos(1.0,1.0,-2.0), Blocks.WATER);
        riceFarmPlot.addBlocktoStructure(new BlockPos(2.0,1.0,-2.0), Blocks.GRASS_PATH);

        riceFarmPlot.addBlocktoStructure(new BlockPos(-1.0,0.0,2.0), Blocks.DIRT);
        riceFarmPlot.addBlocktoStructure(new BlockPos(0.0,0.0,2.0), Blocks.DIRT);
        riceFarmPlot.addBlocktoStructure(new BlockPos(1.0,0.0,2.0), Blocks.DIRT);

        riceFarmPlot.addBlocktoStructure(new BlockPos(-1.0,0.0,1.0), Blocks.DIRT);
        riceFarmPlot.addBlocktoStructure(new BlockPos(0.0,0.0,1.0), Blocks.DIRT);
        riceFarmPlot.addBlocktoStructure(new BlockPos(1.0,0.0,1.0), Blocks.DIRT);

        riceFarmPlot.addBlocktoStructure(new BlockPos(-1.0,0.0,0.0), Blocks.DIRT);
        riceFarmPlot.addBlocktoStructure(new BlockPos(1.0,0.0,0.0), Blocks.DIRT);

        riceFarmPlot.addBlocktoStructure(new BlockPos(-1.0,0.0,-1.0), Blocks.DIRT);
        riceFarmPlot.addBlocktoStructure(new BlockPos(0.0,0.0,-1.0), Blocks.DIRT);
        riceFarmPlot.addBlocktoStructure(new BlockPos(1.0,0.0,-1.0), Blocks.DIRT);

        riceFarmPlot.addBlocktoStructure(new BlockPos(-1.0,0.0,-2.0), Blocks.DIRT);
        riceFarmPlot.addBlocktoStructure(new BlockPos(0.0,0.0,-2.0), Blocks.DIRT);
        riceFarmPlot.addBlocktoStructure(new BlockPos(1.0,0.0,-2.0), Blocks.DIRT);

        blueprintStructureMap.put(0, yamHouse);
        blueprintStructureMap.put(1, farmPlot);
        blueprintStructureMap.put(2, yamHouse);
        blueprintStructureMap.put(3, riceFarmPlot);
        blueprintStructureMap.put(4, yamHouse);
        blueprintStructureMap.put(5, yamHouse);
        blueprintStructureMap.put(6, yamHouse);
    }

    public boolean isFinished(World worldIn, BlockPos tilePos, int key)
    {
        if (this.blueprintStructureMap.containsKey(key))
        {
            BlueprintStructure tStructure = this.blueprintStructureMap.get(key);
            for (int i = 0; i < 4; i++)
            {
                int j = 0;
                boolean foundMismatch = false;
                for (BlueprintStructure.BluePrintPiece tPiece: tStructure.tStructure)
                {
                    BlockPos cPos = tStructure.getStructureWorldPos(tilePos, tPiece, i);
                    if (tStructure.arePiecesEqual(worldIn, cPos, tPiece) && j == tStructure.tStructure.size() - 1 && foundMismatch == false)
                    {
                        return true;
                    }
                    else
                    {
                        if (!tStructure.arePiecesEqual(worldIn, cPos, tPiece))
                            foundMismatch = true;
                    }
                    j++;
                }
            }
        }
        return false;
    }


}
