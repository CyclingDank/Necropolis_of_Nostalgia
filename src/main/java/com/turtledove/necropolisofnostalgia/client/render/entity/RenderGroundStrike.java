package com.turtledove.necropolisofnostalgia.client.render.entity;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelCastingCircle;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityGroundStrike;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityPhoton;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGroundStrike extends RenderLiving<EntityGroundStrike>
{
    private static final ResourceLocation NEUTRAL_CAST_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/photon.png");

    public RenderGroundStrike(RenderManager mgr)
    {
        super(mgr,new ModelCastingCircle(), 0.0F);
    }
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityGroundStrike entity)
    {
        return NEUTRAL_CAST_TEXTURES;
    }
}
