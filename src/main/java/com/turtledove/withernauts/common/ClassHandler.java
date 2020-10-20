package com.turtledove.withernauts.common;

import com.turtledove.withernauts.common.NecropolisClasses.*;

public class ClassHandler
{

    public ClassBase[] t_classes = new ClassBase[6];

    public enum NECROPOLIS_CLASSES
    {
        KNIGHT, NOBLESSE, SCHOLAR, GENERAL, LANCER, REGAL
    }

    public ClassHandler()
    {
        t_classes[0] = new KnightClass();
        t_classes[1] = new NoblesseClass();
        t_classes[2] = new ScholarClass();
        t_classes[3] = new GeneralClass();
        t_classes[4] = new LancerClass();
        t_classes[5] = new RegalClass();
    }
}
