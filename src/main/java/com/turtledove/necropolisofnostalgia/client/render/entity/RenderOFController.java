package com.turtledove.necropolisofnostalgia.client.render.entity;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelArteController;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityJudgementController;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityOFController;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderOFController  extends RenderLiving<EntityOFController>
{
    private static final ResourceLocation NEUTRAL_CAST_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/artecontroller.png");

    public RenderOFController(RenderManager mgr)
    {
        super(mgr,new ModelArteController(), 0.0F);
    }
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityOFController entity)
    {
        return NEUTRAL_CAST_TEXTURES;
    }
}
