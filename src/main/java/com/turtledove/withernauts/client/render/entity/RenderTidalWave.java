package com.turtledove.withernauts.client.render.entity;

import com.turtledove.withernauts.Necropolis_of_Nostalgia;
import com.turtledove.withernauts.client.model.entity.ModelTidalWave;
import com.turtledove.withernauts.server.entity.Artes.EntityTidalWave;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTidalWave extends RenderLiving<EntityTidalWave>
{
    private static final ResourceLocation TW_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/tidal_wave.png");

    public RenderTidalWave(RenderManager mgr)
    {
        super(mgr,new ModelTidalWave(), 0.0F);
    }
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityTidalWave entity)
    {
        return TW_TEXTURES;
    }
}