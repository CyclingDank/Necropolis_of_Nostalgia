package com.turtledove.withernauts.client.render.entity;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.client.model.entity.ModelThunderBlade;
import com.turtledove.withernauts.server.entity.Artes.EntityThunderBlade;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderThunderBlade extends RenderLiving<EntityThunderBlade>
{
    private static final ResourceLocation TB_TEXTURES = new ResourceLocation(Withernauts.MODID,"textures/entity/thunder_blade.png");

    public RenderThunderBlade(RenderManager mgr)
    {
        super(mgr,new ModelThunderBlade(), 0.0F);
    }
/**
 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
 */
    @Override
    protected ResourceLocation getEntityTexture(EntityThunderBlade entity)
    {
            return TB_TEXTURES;
    }
}