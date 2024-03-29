package com.turtledove.necropolisofnostalgia.client.render.entity;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelBooglin;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelFugu;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityBooglin;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityFugu;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderFugu extends RenderLiving<EntityFugu>
{
    private static final ResourceLocation FUGU_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/fugu.png");

    public RenderFugu(RenderManager mgr)
    {
        super(mgr, new ModelFugu(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityFugu entityIn){return FUGU_TEXTURES;}
}