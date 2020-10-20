package com.turtledove.withernauts.server.item;

public class ItemNecropolisSpear extends ItemNecropolisWeapon
{
    public ItemNecropolisSpear(float pAtk, String registryName, String unlocalName, String[] skills)
    {
        super(ToolMaterial.DIAMOND, registryName, unlocalName, pAtk, 0.0f, skills);
    }
}