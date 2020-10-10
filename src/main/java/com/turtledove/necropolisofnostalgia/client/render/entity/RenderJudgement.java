package com.turtledove.necropolisofnostalgia.client.render.entity;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelCastingCircle;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelJudgement;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityJudgement;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityPhoton;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderJudgement  extends RenderLiving<EntityJudgement>
{
    private static final ResourceLocation NEUTRAL_CAST_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/judgement.png");

    public RenderJudgement(RenderManager mgr)
    {
        super(mgr,new ModelJudgement(), 0.0F);
    }
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityJudgement entity)
    {
        return NEUTRAL_CAST_TEXTURES;
    }
}
