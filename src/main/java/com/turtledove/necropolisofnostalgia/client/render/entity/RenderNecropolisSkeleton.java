package com.turtledove.necropolisofnostalgia.client.render.entity;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelNecropolisSkeleton;
import com.turtledove.necropolisofnostalgia.entity.enemies.EntityNecropolisSkeleton;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderNecropolisSkeleton  extends RenderLiving<EntityNecropolisSkeleton>
{
    private static final ResourceLocation SKELTON_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/necropolis_skeleton.png");

    public RenderNecropolisSkeleton(RenderManager mgr)
    {
        super(mgr, new ModelNecropolisSkeleton(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityNecropolisSkeleton entityIn){return SKELTON_TEXTURES;}
}
