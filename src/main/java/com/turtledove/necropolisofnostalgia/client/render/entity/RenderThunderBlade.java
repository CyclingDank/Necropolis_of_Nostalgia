package com.turtledove.necropolisofnostalgia.client.render.entity;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelThunderBlade;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityThunderBlade;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderThunderBlade extends RenderLiving<EntityThunderBlade>
{
    private static final ResourceLocation TB_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/thunder_blade.png");

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