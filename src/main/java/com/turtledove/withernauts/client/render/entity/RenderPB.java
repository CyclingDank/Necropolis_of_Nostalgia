package com.turtledove.withernauts.client.render.entity;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.client.model.entity.ModelPB;
import com.turtledove.withernauts.server.entity.Artes.EntityPB;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPB extends RenderLiving<EntityPB>
{
    private static final ResourceLocation PB_TEXTURES = new ResourceLocation(Withernauts.MODID,"textures/entity/precipice_blades.png");
    private static final ResourceLocation CRACKED_TEXTURES = new ResourceLocation(Withernauts.MODID,"textures/entity/precipice_blades_cracked.png");

    public RenderPB(RenderManager mgr)
    {
        super(mgr,new ModelPB(), 0.0F);
    }
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityPB entity)
    {
        if (entity.ticksExisted < 100)
            return PB_TEXTURES;
        else
            return CRACKED_TEXTURES;
    }
}
