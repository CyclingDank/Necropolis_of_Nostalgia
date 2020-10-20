package com.turtledove.withernauts.client.render.entity;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.client.model.entity.ModelBookBase;
import com.turtledove.withernauts.server.entity.items.EntityBook;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RendereBookBase  extends RenderLiving<EntityBook>
{
    private static final ResourceLocation PSYCHEDELIA = new ResourceLocation(Withernauts.MODID,"textures/entity/psychedelia.png");

    private static final ResourceLocation GRIMOIRE = new ResourceLocation(Withernauts.MODID,"textures/entity/grimoire.png");

    private static final ResourceLocation SERAPHIM = new ResourceLocation(Withernauts.MODID,"textures/entity/seraphim.png");

    private static final ResourceLocation NOTUNG = new ResourceLocation(Withernauts.MODID,"textures/entity/notung.png");


    public RendereBookBase(RenderManager mgr)
    {
        super(mgr,new ModelBookBase(), 0.0F);
    }
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityBook entity)
    {
        if (entity.getTextureID() == 0)
            return PSYCHEDELIA;
        else if (entity.getTextureID() == 1)
            return GRIMOIRE;
        else if (entity.getTextureID() == 2)
            return SERAPHIM;
        else
            return NOTUNG;
    }
}
