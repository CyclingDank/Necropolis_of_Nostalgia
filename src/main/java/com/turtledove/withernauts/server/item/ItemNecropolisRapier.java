package com.turtledove.withernauts.server.item;

public class ItemNecropolisRapier  extends ItemNecropolisWeapon
{
    public ItemNecropolisRapier(float pAtk, float sAtk, String registryName, String unlocalName, String[] skills)
    {
        super(ToolMaterial.DIAMOND, registryName, unlocalName, pAtk, sAtk, skills);
    }
}
