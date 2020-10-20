package com.turtledove.withernauts.client.render.npc;

import com.turtledove.withernauts.Necropolis_of_Nostalgia;
import com.turtledove.withernauts.client.model.entity.npc.ModelNPC;
import com.turtledove.withernauts.server.entity.npc.EntityTea;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTeaNPC extends RenderLiving<EntityTea>
{
    private static final ResourceLocation NPC_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/tea_npc.png");

    public RenderTeaNPC(RenderManager mgr)
    {
        super(mgr, new ModelNPC(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityTea entityIn){return NPC_TEXTURES;}
}