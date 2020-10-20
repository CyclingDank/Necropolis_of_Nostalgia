package com.turtledove.withernauts.client.render.entity;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.client.model.entity.ModelCultSorceress;
import com.turtledove.withernauts.server.entity.enemies.EntityCultSorceress;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCultSorceress extends RenderLiving<EntityCultSorceress> {
    private static final ResourceLocation CS_TEXTURES = new ResourceLocation(Withernauts.MODID,"textures/entity/cult_sorceress.png");

    public RenderCultSorceress(RenderManager mgr)
    {
        super(mgr, new ModelCultSorceress(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityCultSorceress entityIn){return CS_TEXTURES;}
}
