package com.turtledove.necropolisofnostalgia.client.render.entity;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelCastingCircle;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelPB;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityPB;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityPhoton;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPB extends RenderLiving<EntityPB>
{
    private static final ResourceLocation PB_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/precipice_blades.png");
    private static final ResourceLocation CRACKED_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/precipice_blades_cracked.png");

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
