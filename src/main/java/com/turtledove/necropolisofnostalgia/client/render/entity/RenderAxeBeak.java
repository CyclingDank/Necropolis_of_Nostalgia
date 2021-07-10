package com.turtledove.necropolisofnostalgia.client.render.entity;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelAxeBeak;
import com.turtledove.necropolisofnostalgia.entity.enemies.EntityAxeBeak;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderAxeBeak extends RenderLiving<EntityAxeBeak>
{
    private static final ResourceLocation BIRB_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/axebeak.png");

    public RenderAxeBeak(RenderManager mgr)
    {
        super(mgr, new ModelAxeBeak(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityAxeBeak entityIn){return BIRB_TEXTURES;}
}
