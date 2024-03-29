package com.turtledove.necropolisofnostalgia.client.render.entity;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelAxeBeak;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelVampireBat;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityAxeBeak;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityVampireBat;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderVampireBat extends RenderLiving<EntityVampireBat>
{
    private static final ResourceLocation VAMP_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/vampire_bat.png");

    public RenderVampireBat(RenderManager mgr)
    {
        super(mgr, new ModelVampireBat(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityVampireBat entityIn){return VAMP_TEXTURES;}
}

