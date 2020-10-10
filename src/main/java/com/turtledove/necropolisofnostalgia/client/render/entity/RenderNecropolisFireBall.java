package com.turtledove.necropolisofnostalgia.client.render.entity;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelBeast;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelNecropolisFireBall;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityBeast;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityNecropolisFireBall;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderNecropolisFireBall  extends RenderLiving<EntityNecropolisFireBall>
{
    private static final ResourceLocation FIRE_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/fireball.png");

    public RenderNecropolisFireBall(RenderManager mgr)
    {
        super(mgr,new ModelNecropolisFireBall(), 0.0F);
    }
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityNecropolisFireBall entity)
    {
        return FIRE_TEXTURES;
    }
}