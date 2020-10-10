package com.turtledove.necropolisofnostalgia.client.render.entity;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelEruption;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelOF;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityEruption;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityOF;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderEruption extends RenderLiving<EntityEruption>
{
    private static final ResourceLocation E_1_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/eruption_1.png");
    private static final ResourceLocation E_2_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/eruption_2.png");
    private static final ResourceLocation E_3_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/eruption_3.png");
    private static final ResourceLocation E_4_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/eruption_4.png");


    public RenderEruption(RenderManager mgr)
    {
        super(mgr,new ModelEruption(), 0.0F);
    }
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityEruption entity)
    {
        if (entity.ticksExisted % 10 < 2)
            return E_4_TEXTURES;
        else if (entity.ticksExisted % 10 < 4)
            return E_3_TEXTURES;
        else if (entity.ticksExisted % 10 < 6)
            return E_2_TEXTURES;
        else
            return E_1_TEXTURES;
    }
}