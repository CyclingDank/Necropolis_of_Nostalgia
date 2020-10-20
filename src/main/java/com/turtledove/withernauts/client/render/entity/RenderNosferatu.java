package com.turtledove.withernauts.client.render.entity;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.client.model.entity.ModelNecropolisFireBall;
import com.turtledove.withernauts.server.entity.Artes.EntityNosferatu;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderNosferatu extends RenderLiving<EntityNosferatu>
{
    private static final ResourceLocation NOSFERATU_TEXTURES = new ResourceLocation(Withernauts.MODID,"textures/entity/nosferatu.png");

    public RenderNosferatu(RenderManager mgr)
    {
        super(mgr,new ModelNecropolisFireBall(), 0.0F);
    }
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityNosferatu entity)
    {
        return NOSFERATU_TEXTURES;
    }
}