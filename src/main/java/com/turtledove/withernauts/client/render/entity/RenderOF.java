package com.turtledove.withernauts.client.render.entity;

import com.turtledove.withernauts.Necropolis_of_Nostalgia;
import com.turtledove.withernauts.client.model.entity.ModelOF;
import com.turtledove.withernauts.server.entity.Artes.EntityOF;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderOF extends RenderLiving<EntityOF>
{
    private static final ResourceLocation OF_1_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/old_faithful_1.png");
    private static final ResourceLocation OF_2_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/old_faithful_2.png");
    private static final ResourceLocation OF_3_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/old_faithful_3.png");


    public RenderOF(RenderManager mgr)
    {
        super(mgr,new ModelOF(), 0.0F);
    }
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityOF entity)
    {
        if (entity.ticksExisted < 3)
            return OF_3_TEXTURES;
        else if (entity.ticksExisted < 6)
            return OF_2_TEXTURES;
        else
            return OF_1_TEXTURES;
    }
}