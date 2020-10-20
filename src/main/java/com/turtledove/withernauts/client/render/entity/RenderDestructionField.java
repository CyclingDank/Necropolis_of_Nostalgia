package com.turtledove.withernauts.client.render.entity;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.client.model.entity.ModelDF;
import com.turtledove.withernauts.server.entity.Artes.EntityDestructionField;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDestructionField extends RenderLiving<EntityDestructionField>
{
    private static final ResourceLocation DF1_TEXTURES = new ResourceLocation(Withernauts.MODID,"textures/entity/destruction_field_1.png");
    private static final ResourceLocation DF2_TEXTURES = new ResourceLocation(Withernauts.MODID,"textures/entity/destruction_field_2.png");


    public RenderDestructionField(RenderManager mgr)
    {
        super(mgr,new ModelDF(), 0.0F);
    }
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityDestructionField entity)
    {
        if (entity.ticksExisted < 3)
            return DF1_TEXTURES;
        return DF2_TEXTURES;
    }
}
