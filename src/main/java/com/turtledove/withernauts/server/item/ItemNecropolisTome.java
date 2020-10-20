package com.turtledove.withernauts.server.item;

public class ItemNecropolisTome extends ItemNecropolisWeapon
{
    public ItemNecropolisTome(float damage, String registryName, String unlocalName, String[] skills)
    {
        super(ToolMaterial.WOOD, registryName, unlocalName, 1.0f, damage, skills);
    }
}
