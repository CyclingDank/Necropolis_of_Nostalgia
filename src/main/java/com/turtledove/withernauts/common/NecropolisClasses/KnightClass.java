package com.turtledove.withernauts.common.NecropolisClasses;

import com.turtledove.withernauts.common.ArteHandler;
import com.turtledove.withernauts.common.ClassBase;

public class KnightClass implements ClassBase
{
    public ArteHandler artes = new ArteHandler();
    private int[] possible_artes  = new int[6];
    private int[] classWeapons = new int[1];
    public KnightClass()
    {
        possible_artes[0] = ArteHandler.ARTES.QUICK_SLASH.ordinal();
        possible_artes[1] = ArteHandler.ARTES.SCATTERING_SLASH.ordinal();
        possible_artes[2] = ArteHandler.ARTES.DEMON_FANG.ordinal();
        possible_artes[3] = ArteHandler.ARTES.METAL_SWARM.ordinal();
        possible_artes[4] = ArteHandler.ARTES.BEAST.ordinal();
        possible_artes[5] = ArteHandler.ARTES.HURRICANE_BLADE.ordinal();

        classWeapons[0] = 0;
    }
    public int[] getClassWeapons()
    {
        return this.classWeapons;
    }
    public int [] get_possibleArtes()
    {
        return possible_artes;
    }

}
