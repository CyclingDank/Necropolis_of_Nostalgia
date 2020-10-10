package com.turtledove.necropolisofnostalgia.server.entity;

import com.turtledove.necropolisofnostalgia.server.entity.Spiral_Draco.EntitySpiral_Draco;
import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntityMultipart;

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