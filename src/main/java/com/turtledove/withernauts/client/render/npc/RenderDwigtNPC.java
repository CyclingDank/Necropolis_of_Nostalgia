package com.turtledove.withernauts.client.render.npc;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.client.model.entity.npc.ModelNPC;
import com.turtledove.withernauts.server.entity.npc.EntityDwigt;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDwigtNPC extends RenderLiving<EntityDwigt>
{
    private static final ResourceLocation NPC_TEXTURES = new ResourceLocation(Withernauts.MODID,"textures/entity/dwigt_npc.png");

    public RenderDwigtNPC(RenderManager mgr)
    {
        super(mgr, new ModelNPC(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityDwigt entityIn){return NPC_TEXTURES;}
}