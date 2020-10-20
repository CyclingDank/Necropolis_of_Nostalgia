package com.turtledove.withernauts.client.render.entity;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.client.model.entity.ModelFugu;
import com.turtledove.withernauts.server.entity.enemies.EntityFugu;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderFugu extends RenderLiving<EntityFugu>
{
    private static final ResourceLocation FUGU_TEXTURES = new ResourceLocation(Withernauts.MODID,"textures/entity/fugu.png");

    public RenderFugu(RenderManager mgr)
    {
        super(mgr, new ModelFugu(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityFugu entityIn){return FUGU_TEXTURES;}
}