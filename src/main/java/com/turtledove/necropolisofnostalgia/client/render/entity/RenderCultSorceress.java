package com.turtledove.necropolisofnostalgia.client.render.entity;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelAxeBeak;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelCultSorceress;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityAxeBeak;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityCultSorceress;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCultSorceress extends RenderLiving<EntityCultSorceress> {
    private static final ResourceLocation CS_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/cult_sorceress.png");

    public RenderCultSorceress(RenderManager mgr)
    {
        super(mgr, new ModelCultSorceress(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityCultSorceress entityIn){return CS_TEXTURES;}
}
