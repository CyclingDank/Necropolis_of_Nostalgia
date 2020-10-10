package com.turtledove.necropolisofnostalgia.common.NecropolisClasses;

import com.turtledove.necropolisofnostalgia.common.ArteHandler;
import com.turtledove.necropolisofnostalgia.common.ClassBase;

public class GeneralClass  implements ClassBase
{
    public ArteHandler artes = new ArteHandler();
    private int[] possible_artes  = new int[14];
    private int[] classWeapons = new int[1];
    public GeneralClass()
    {
        possible_artes[0] = ArteHandler.ARTES.QUICK_SLASH.ordinal();
        possible_artes[1] = ArteHandler.ARTES.SCATTERING_SLASH.ordinal();
        possible_artes[2] = ArteHandler.ARTES.DEMON_FANG.ordinal();
        possible_artes[3] = ArteHandler.ARTES.METAL_SWARM.ordinal();
        possible_artes[4] = ArteHandler.ARTES.BEAST.ordinal();
        possible_artes[5] = ArteHandler.ARTES.HURRICANE_BLADE.ordinal();
        possible_artes[6] = ArteHandler.ARTES.SWORD_DANCER.ordinal();
        possible_artes[7] = ArteHandler.ARTES.REVOLVING_SLASH.ordinal();
        possible_artes[8] = ArteHandler.ARTES.DEMONIC_CHAOS.ordinal();
        possible_artes[9] = ArteHandler.ARTES.SUPERSONIC_SLASH.ordinal();
        possible_artes[10] = ArteHandler.ARTES.TWIN_HURRICANE_BLADE.ordinal();
        possible_artes[11] = ArteHandler.ARTES.HURRICANE_BEAST.ordinal();
        possible_artes[12] = ArteHandler.ARTES.DESTRUCTION_FIELD.ordinal();
        possible_artes[13] = ArteHandler.ARTES.DEMONIC_FIELD.ordinal();

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