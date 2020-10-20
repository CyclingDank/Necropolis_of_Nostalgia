package com.turtledove.withernauts.client.render.entity;

import com.turtledove.withernauts.Necropolis_of_Nostalgia;
import com.turtledove.withernauts.client.model.entity.ModelArteCircle;
import com.turtledove.withernauts.server.entity.Artes.EntityHealingCircle;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderHealingCircle  extends RenderLiving<EntityHealingCircle>
{
    private static final ResourceLocation NEUTRAL_CAST_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/arte_circle.png");

    public RenderHealingCircle(RenderManager mgr)
    {
        super(mgr,new ModelArteCircle(), 0.0F);
    }
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityHealingCircle entity)
    {
        return NEUTRAL_CAST_TEXTURES;
    }
}