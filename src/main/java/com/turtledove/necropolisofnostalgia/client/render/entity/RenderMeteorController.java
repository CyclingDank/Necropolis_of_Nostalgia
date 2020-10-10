package com.turtledove.necropolisofnostalgia.client.render.entity;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelArteController;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityJudgementController;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityMeteorController;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderMeteorController  extends RenderLiving<EntityMeteorController>
{
    private static final ResourceLocation NEUTRAL_CAST_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/artecontroller.png");

    public RenderMeteorController(RenderManager mgr)
    {
        super(mgr,new ModelArteController(), 0.0F);
    }
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityMeteorController entity)
    {
        return NEUTRAL_CAST_TEXTURES;
    }
}