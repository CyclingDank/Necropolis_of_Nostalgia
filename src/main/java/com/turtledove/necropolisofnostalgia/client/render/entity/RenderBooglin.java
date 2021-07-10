package com.turtledove.necropolisofnostalgia.client.render.entity;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelBooglin;
import com.turtledove.necropolisofnostalgia.entity.enemies.EntityBooglin;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBooglin extends RenderLiving<EntityBooglin>
{
    private static final ResourceLocation BOOG_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/booglin.png");

    public RenderBooglin(RenderManager mgr)
    {
        super(mgr, new ModelBooglin(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityBooglin entityIn){return BOOG_TEXTURES;}
}

