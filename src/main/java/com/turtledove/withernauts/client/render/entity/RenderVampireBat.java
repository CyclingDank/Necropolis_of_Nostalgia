package com.turtledove.withernauts.client.render.entity;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.client.model.entity.ModelVampireBat;
import com.turtledove.withernauts.server.entity.enemies.EntityVampireBat;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderVampireBat extends RenderLiving<EntityVampireBat>
{
    private static final ResourceLocation VAMP_TEXTURES = new ResourceLocation(Withernauts.MODID,"textures/entity/vampire_bat.png");

    public RenderVampireBat(RenderManager mgr)
    {
        super(mgr, new ModelVampireBat(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityVampireBat entityIn){return VAMP_TEXTURES;}
}

