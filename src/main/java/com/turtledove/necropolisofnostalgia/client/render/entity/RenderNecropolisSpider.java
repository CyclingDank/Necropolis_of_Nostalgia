package com.turtledove.necropolisofnostalgia.client.render.entity;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelNecropolisSpider;
import com.turtledove.necropolisofnostalgia.entity.enemies.EntityNecropolisSpider;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderNecropolisSpider extends RenderLiving<EntityNecropolisSpider>
{
    private static final ResourceLocation SPODER_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/spider.png");

    public RenderNecropolisSpider(RenderManager mgr)
    {
        super(mgr, new ModelNecropolisSpider(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityNecropolisSpider entityIn){return SPODER_TEXTURES;}
}