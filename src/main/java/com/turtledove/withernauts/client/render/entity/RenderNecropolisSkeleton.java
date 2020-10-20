package com.turtledove.withernauts.client.render.entity;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.client.model.entity.ModelNecropolisSkeleton;
import com.turtledove.withernauts.server.entity.enemies.EntityNecropolisSkeleton;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderNecropolisSkeleton  extends RenderLiving<EntityNecropolisSkeleton>
{
    private static final ResourceLocation SKELTON_TEXTURES = new ResourceLocation(Withernauts.MODID,"textures/entity/necropolis_skeleton.png");

    public RenderNecropolisSkeleton(RenderManager mgr)
    {
        super(mgr, new ModelNecropolisSkeleton(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityNecropolisSkeleton entityIn){return SKELTON_TEXTURES;}
}
