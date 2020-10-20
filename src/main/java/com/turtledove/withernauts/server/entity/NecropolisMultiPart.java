package com.turtledove.withernauts.server.entity;

import com.turtledove.withernauts.server.entity.Spiral_Draco.EntitySpiral_Draco;

public class NecropolisMultiPart extends NecropolisEntityMultipart
{
    private EntitySpiral_Draco draco;

    public NecropolisMultiPart(EntitySpiral_Draco draco, float radius, float angleYaw, float offsetY, float sizeX, float sizeY, float damageMultiplier)
    {
        super(draco, radius, angleYaw, offsetY, sizeX, sizeY, damageMultiplier);
        this.draco = draco;
        this.isImmuneToFire = true;
    }

    public void collideWithNearbyEntities() {
    }
}