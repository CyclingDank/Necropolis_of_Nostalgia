package com.turtledove.withernauts.common.NecropolisClasses;

import com.turtledove.withernauts.common.ArteHandler;
import com.turtledove.withernauts.common.ClassBase;

public class NoblesseClass implements ClassBase
{
    private static int ARTE_COUNT = 6;
    private int[] possible_artes  = new int[ARTE_COUNT];
    private int[] classWeapons = new int[1];
    public NoblesseClass()
    {
        possible_artes[0] = ArteHandler.ARTES.FLECHE.ordinal();
        possible_artes[1] = ArteHandler.ARTES.DIVIDING_EDGE.ordinal();
        possible_artes[2] =  ArteHandler.ARTES.FIRST_AID.ordinal();
        possible_artes[3] = ArteHandler.ARTES.PHOTON.ordinal();
        possible_artes[4] = ArteHandler.ARTES.SWORD_RAIN.ordinal();
        possible_artes[5] = ArteHandler.ARTES.RECOVER.ordinal();

        classWeapons[0] = 1;
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
