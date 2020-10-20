package com.turtledove.withernauts.server.entity;

import net.ilexiconn.llibrary.server.entity.multipart.PartEntity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public class NecropolisEntityMultipart extends PartEntity
{

    public NecropolisEntityMultipart(EntityLiving parent, float radius, float angleYaw, float offsetY, float sizeX, float sizeY, float damageMultiplier)
    {
        super(parent, radius, angleYaw, offsetY, sizeX, sizeY, damageMultiplier);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        return this.isEntityInvulnerable(source) ? false : this.parent.attackEntityFrom(source, amount);
    }

    public EntityLivingBase getParent() {
        return this.parent;
    }

    public void resize(float width, float height) {
        this.setSize(width, height);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.parent == null) {
            this.world.removeEntityDangerously(this);
        }
    }
}