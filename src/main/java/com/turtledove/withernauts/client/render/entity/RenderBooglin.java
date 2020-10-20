package com.turtledove.withernauts.client.render.entity;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.client.model.entity.ModelBooglin;
import com.turtledove.withernauts.server.entity.enemies.EntityBooglin;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBooglin extends RenderLiving<EntityBooglin>
{
    private static final ResourceLocation BOOG_TEXTURES = new ResourceLocation(Withernauts.MODID,"textures/entity/booglin.png");

    public RenderBooglin(RenderManager mgr)
    {
        super(mgr, new ModelBooglin(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityBooglin entityIn){return BOOG_TEXTURES;}
}

