package com.turtledove.necropolisofnostalgia.client.render.entity;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelBeast;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelDemonFang;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityBeast;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityDemonFang;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBeast extends RenderLiving<EntityBeast>
{
    private static final ResourceLocation BEAST_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/beast_texture.png");

    public RenderBeast(RenderManager mgr)
    {
        super(mgr,new ModelBeast(), 0.0F);
    }
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityBeast entity)
    {
        return BEAST_TEXTURES;
    }
}
