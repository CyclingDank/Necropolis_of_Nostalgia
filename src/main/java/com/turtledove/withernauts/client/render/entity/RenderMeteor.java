package com.turtledove.withernauts.client.render.entity;

import com.turtledove.withernauts.Necropolis_of_Nostalgia;
import com.turtledove.withernauts.client.model.entity.ModelMeteor;
import com.turtledove.withernauts.server.entity.Artes.EntityMeteor;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderMeteor extends RenderLiving<EntityMeteor>
{
    private static final ResourceLocation M_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/meteor_storm.png");


    public RenderMeteor(RenderManager mgr)
    {
        super(mgr,new ModelMeteor(), 0.0F);
    }
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityMeteor entity)
    {
        return M_TEXTURES;
    }
}