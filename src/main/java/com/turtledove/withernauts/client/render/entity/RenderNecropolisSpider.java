package com.turtledove.withernauts.client.render.entity;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.client.model.entity.ModelNecropolisSpider;
import com.turtledove.withernauts.server.entity.enemies.EntityNecropolisSpider;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderNecropolisSpider extends RenderLiving<EntityNecropolisSpider>
{
    private static final ResourceLocation SPODER_TEXTURES = new ResourceLocation(Withernauts.MODID,"textures/entity/spider.png");

    public RenderNecropolisSpider(RenderManager mgr)
    {
        super(mgr, new ModelNecropolisSpider(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityNecropolisSpider entityIn){return SPODER_TEXTURES;}
}