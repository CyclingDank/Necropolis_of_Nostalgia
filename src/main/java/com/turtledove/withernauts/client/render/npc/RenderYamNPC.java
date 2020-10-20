package com.turtledove.withernauts.client.render.npc;

import com.turtledove.withernauts.Necropolis_of_Nostalgia;
import com.turtledove.withernauts.client.model.entity.npc.ModelNPC;
import com.turtledove.withernauts.server.entity.npc.EntityYam;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderYamNPC extends RenderLiving<EntityYam>
{
    private static final ResourceLocation NPC_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/yam_npc.png");

    public RenderYamNPC(RenderManager mgr)
    {
        super(mgr, new ModelNPC(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityYam entityIn){return NPC_TEXTURES;}
}