package com.turtledove.withernauts.common.NecropolisClasses;

import com.turtledove.withernauts.common.ArteHandler;
import com.turtledove.withernauts.common.ClassBase;

public class ScholarClass implements ClassBase {
    private static int ARTE_COUNT = 18;
    private int[] possible_artes = new int[ARTE_COUNT];
    private int[] classWeapons = new int[2];

    public ScholarClass() {
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
        possible_artes[10] = ArteHandler.ARTES.FIRE_BALL.ordinal();
        possible_artes[11] = ArteHandler.ARTES.PRECIPICE_BLADES.ordinal();
        possible_artes[12] = ArteHandler.ARTES.OLD_FAITHFUL.ordinal();
        possible_artes[13] = ArteHandler.ARTES.NOSFERATU.ordinal();
        possible_artes[14] = ArteHandler.ARTES.THUNDER_BLADE.ordinal();
        possible_artes[15] = ArteHandler.ARTES.ERUPTION.ordinal();
        possible_artes[16] = ArteHandler.ARTES.TIDAL_WAVE.ordinal();
        possible_artes[17] = ArteHandler.ARTES.METEOR_SHOWER.ordinal();

        classWeapons[0] = 1;
        classWeapons[1] = 2;
    }

    public int[] getClassWeapons() {
        return this.classWeapons;
    }

    public int[] get_possibleArtes() {
        return possible_artes;
    }
}
