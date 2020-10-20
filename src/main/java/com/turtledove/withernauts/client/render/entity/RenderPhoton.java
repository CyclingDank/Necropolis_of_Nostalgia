package com.turtledove.withernauts.client.render.entity;

import com.turtledove.withernauts.Necropolis_of_Nostalgia;
import com.turtledove.withernauts.client.model.entity.ModelCastingCircle;
import com.turtledove.withernauts.server.entity.Artes.EntityPhoton;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPhoton extends RenderLiving<EntityPhoton>
{
    private static final ResourceLocation NEUTRAL_CAST_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/photon.png");

    public RenderPhoton(RenderManager mgr)
    {
        super(mgr,new ModelCastingCircle(), 0.0F);
    }
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityPhoton entity)
    {
        return NEUTRAL_CAST_TEXTURES;
    }
}
