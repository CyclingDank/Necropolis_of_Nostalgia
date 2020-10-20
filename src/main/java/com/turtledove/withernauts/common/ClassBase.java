package com.turtledove.withernauts.common;

/*This class an its extensions are merely meant for lookups. I.e, what skills or attacks are possible to have with this class.*/
public interface ClassBase
{
    /*This method simply returns the possible artes for this class. It is up to elsewhere to determine what the player CURRENTLY knows!*/
    int [] get_possibleArtes();
    public int[] getClassWeapons();
}
