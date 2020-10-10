package com.turtledove.necropolisofnostalgia.common.NecropolisClasses;

import com.turtledove.necropolisofnostalgia.common.ArteHandler;
import com.turtledove.necropolisofnostalgia.common.ClassBase;

public class LancerClass implements ClassBase
{
    private static int ARTE_COUNT = 13;
    private int[] possible_artes = new int[ARTE_COUNT];
    private int[] classWeapons = new int[2];

    public LancerClass() {
        possible_artes[0] = ArteHandler.ARTES.QUICK_SLASH.ordinal();
        possible_artes[1] = ArteHandler.ARTES.SCATTERING_SLASH.ordinal();
        possible_artes[2] = ArteHandler.ARTES.DEMON_FANG.ordinal();
        possible_artes[3] = ArteHandler.ARTES.METAL_SWARM.ordinal();
        possible_artes[4] = ArteHandler.ARTES.BEAST.ordinal();
        possible_artes[5] = ArteHandler.ARTES.HURRICANE_BLADE.ordinal();

        possible_artes[6] = ArteHandler.ARTES.COILING_SERPENT.ordinal();
        possible_artes[7] = ArteHandler.ARTES.WHIRLING_TOP.ordinal();
        possible_artes[8] = ArteHandler.ARTES.CLEANSING_LANCE.ordinal();
        possible_artes[9] = ArteHandler.ARTES.CAVALRY.ordinal();
        possible_artes[10] = ArteHandler.ARTES.RISING_WHIRLWIND.ordinal();
        possible_artes[11] = ArteHandler.ARTES.LANCE_RAIN.ordinal();
        possible_artes[12] = ArteHandler.ARTES.ASTRA.ordinal();

        classWeapons[0] = 0;
        classWeapons[1] = 3;
    }

    public int[] getClassWeapons() {
        return this.classWeapons;
    }

    public int[] get_possibleArtes() {
        return possible_artes;
    }
}
