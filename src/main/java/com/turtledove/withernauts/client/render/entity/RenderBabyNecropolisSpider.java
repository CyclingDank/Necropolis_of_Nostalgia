package com.turtledove.withernauts.client.render.entity;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.client.model.entity.ModelBabySpider;
import com.turtledove.withernauts.server.entity.enemies.EntityBabyNecropolisSpider;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBabyNecropolisSpider  extends RenderLiving<EntityBabyNecropolisSpider>
{
    private static final ResourceLocation BSPODER_TEXTURES = new ResourceLocation(Withernauts.MODID,"textures/entity/bab_spider.png");

    public RenderBabyNecropolisSpider(RenderManager mgr)
    {
        super(mgr, new ModelBabySpider(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityBabyNecropolisSpider entityIn){return BSPODER_TEXTURES;}
}
