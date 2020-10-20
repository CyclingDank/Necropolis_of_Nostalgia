package com.turtledove.withernauts.common.NecropolisClasses;

import com.turtledove.withernauts.common.ArteHandler;
import com.turtledove.withernauts.common.ClassBase;

public class RegalClass implements ClassBase
{
    private static int ARTE_COUNT = 14;
    private int[] possible_artes  = new int[ARTE_COUNT];
    private int[] classWeapons = new int[1];
    public RegalClass()
    {
        possible_artes[0] = ArteHandler.ARTES.FLECHE.ordinal();
        possible_artes[1] = ArteHandler.ARTES.DIVIDING_EDGE.ordinal();
        possible_artes[2] =  ArteHandler.ARTES.FIRST_AID.ordinal();
        possible_artes[3] = ArteHandler.ARTES.PHOTON.ordinal();
        possible_artes[4] = ArteHandler.ARTES.SWORD_RAIN.ordinal();
        possible_artes[5] = ArteHandler.ARTES.RECOVER.ordinal();
        possible_artes[6] = ArteHandler.ARTES.SWORD_RAIN_ALPHA.ordinal();
        possible_artes[7] = ArteHandler.ARTES.HEALING_CIRCLE.ordinal();
        possible_artes[8] = ArteHandler.ARTES.JUDGEMENT.ordinal();
        possible_artes[9] = ArteHandler.ARTES.DISPEL.ordinal();
        possible_artes[10] = ArteHandler.ARTES.SHINING_BIND.ordinal();
        possible_artes[11] = ArteHandler.ARTES.ANGEL_RING.ordinal();
        possible_artes[12] = ArteHandler.ARTES.TRI_SLASH.ordinal();
        possible_artes[13] = ArteHandler.ARTES.RAY_STING.ordinal();

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