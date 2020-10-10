package com.turtledove.necropolisofnostalgia.client.render.entity;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelDemonFang;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityDemonFang;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDemonFang extends RenderLiving<EntityDemonFang>
{
    private static final ResourceLocation DEMON_FANG_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/demon_fang.png");

    public RenderDemonFang(RenderManager mgr)
    {
        super(mgr,new ModelDemonFang(), 0.0F);
    }
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityDemonFang entity)
    {
        return DEMON_FANG_TEXTURES;
    }
}
