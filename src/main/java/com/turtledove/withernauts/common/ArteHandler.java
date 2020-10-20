package com.turtledove.withernauts.common;

import com.turtledove.withernauts.client.render.artes.*;
import com.turtledove.withernauts.server.artes.ArteBase;
import com.turtledove.withernauts.server.artes.PhysicalArtes.*;
import com.turtledove.withernauts.server.artes.SpecialArtes.*;

/*
This class handles information retrieval for every type of Arte, physical, healing, or magical.
This is only for quick lookups, it is NOT FOR ARTE BINDS!!!!!!!!!! That should be set on the player attributes.
* */

public class ArteHandler
{
    public static int NUM_ARTES = 43;
    public ArteBase[] t_arte = new ArteBase[NUM_ARTES];

    public ArteRenderBase[] r_arte = new ArteRenderBase[NUM_ARTES];

    public enum ARTES
    {
        QUICK_SLASH, SCATTERING_SLASH, DEMON_FANG, METAL_SWARM, FLECHE, DIVIDING_EDGE, FIRST_AID, FIRE_BALL, BEAST, HURRICANE_BLADE, SWORD_DANCER, REVOLVING_SLASH,
        DEMONIC_CHAOS, SUPERSONIC_SLASH, PHOTON, SWORD_RAIN, RECOVER, SWORD_RAIN_ALPHA, HEALING_CIRCLE, JUDGEMENT, DISPEL, PRECIPICE_BLADES, OLD_FAITHFUL, NOSFERATU,
        THUNDER_BLADE, ERUPTION, TIDAL_WAVE, METEOR_SHOWER, TWIN_HURRICANE_BLADE, HURRICANE_BEAST, DESTRUCTION_FIELD, DEMONIC_FIELD, SHINING_BIND, ANGEL_RING, TRI_SLASH,
        RAY_STING, COILING_SERPENT, WHIRLING_TOP, CLEANSING_LANCE, CAVALRY, RISING_WHIRLWIND, LANCE_RAIN, ASTRA
    }

    public ArteHandler()
    {
        t_arte[0] = new QuickSlash();
        t_arte[1] = new ScatteringSlash();
        t_arte[2] = new DemonFang();
        t_arte[3] = new MetalSwarm();
        t_arte[4] = new Fleche();
        t_arte[5] = new DividingEdge();
        t_arte[6] = new FirstAid();
        t_arte[7] = new FireBall();
        t_arte[8] = new Beast();
        t_arte[9] = new HurricaneBlade();
        t_arte[10] = new SwordDancer();
        t_arte[11] = new RevolvingSlash();
        t_arte[12] = new DemonicChaos();
        t_arte[13] = new SuperSonicSlash();
        t_arte[14] = new Photon();
        t_arte[15] = new SwordRain();
        t_arte[16] = new Recover();
        t_arte[17] = new SwordRainAlpha();
        t_arte[18] = new HealingCircle();
        t_arte[19] = new Judgement();
        t_arte[20] = new Dispel();
        t_arte[21] = new PrecipiceBlades();
        t_arte[22] = new OldFaithful();
        t_arte[23] = new Nosferatu();
        t_arte[24] = new ThunderBlade();
        t_arte[25] = new Eruption();
        t_arte[26] = new TidalWave();
        t_arte[27] = new MeteorShower();
        t_arte[28] = new TwinHurricaneBlade();
        t_arte[29] = new HurricaneBeast();
        t_arte[30] = new DestructionField();
        t_arte[31] = new DemonicField();
        t_arte[32] = new ShiningBind();
        t_arte[33] = new AngelRing();
        t_arte[34] = new TriSlash();
        t_arte[35] = new RaySting();
        t_arte[36] = new CoilingSerpent();
        t_arte[37] = new WhirlingTop();
        t_arte[38] = new CleansingLance();
        t_arte[39] = new Cavalry();
        t_arte[40] = new RisingWhirlwind();
        t_arte[41] = new LanceRain();
        t_arte[42] = new Astra();


        r_arte[0] = new RenderMetalSwarm();
        r_arte[1] = new RenderScatteringSlash();
        r_arte[2] = new RenderDemonFangSwing();
        r_arte[3] = new RenderMetalSwarm();
        r_arte[4] = new RenderFleche();
        r_arte[5] = new RenderDividingEdge();
        r_arte[6] = new RenderFirstAid();
        r_arte[7] = new RenderFireBall();
        r_arte[8] = new RenderBeastSwing();
        r_arte[9] = new RenderHurricaneBlade();
        r_arte[10] = new RenderSwordDancer();
        r_arte[11] =  new RenderRevolvingSlash();
        r_arte[12] =  new RenderDemonicChaos();
        r_arte[13] = new RenderSuperSonicSlash();
        r_arte[14] = new RenderPhotonSwing();
        r_arte[15] = new RenderSwordRain();
        r_arte[16] = new RenderFirstAid();
        r_arte[17] = new RenderSwordRainAlpha();
        r_arte[18] = new RenderFirstAid();
        r_arte[19] = new RenderFirstAid();
        r_arte[20] = new RenderFirstAid();
        r_arte[21] = new RenderFireBall();
        r_arte[22] = new RenderFireBall();
        r_arte[23] = new RenderFireBall();
        r_arte[24] = new RenderFireBall();
        r_arte[25] = new RenderFireBall();
        r_arte[26] = new RenderFireBall();
        r_arte[27] = new RenderFireBall();
        r_arte[28] = new RenderHurricaneBlade();
        r_arte[29] = new RenderHurricaneBeast();
        r_arte[30] = new RenderDemonFangSwing();
        r_arte[31] = new RenderDemonFangSwing();
        r_arte[32] = new RenderQuickSlash();
        r_arte[33] = new RenderFirstAid();
        r_arte[34] = new RenderTriSlash();
        r_arte[35] = new RenderRaySting();
        r_arte[36] = new RenderMetalSwarm();
        r_arte[37] =  new RenderRevolvingSlash();
        r_arte[38] =  new RenderCleansingLance();
        r_arte[39] =  new RenderCleansingLance();
        r_arte[40] =  new RenderRisingWhirlwind();
        r_arte[41] =  new RenderLanceRain();
        r_arte[42] =  new RenderAstra();

    }
}
