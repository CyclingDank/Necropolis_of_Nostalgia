package com.turtledove.withernauts.client.render.npc;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.client.model.entity.npc.ModelNPC;
import com.turtledove.withernauts.server.entity.npc.EntityRita;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderRitaNPC extends RenderLiving<EntityRita>
{
    private static final ResourceLocation NPC_TEXTURES = new ResourceLocation(Withernauts.MODID,"textures/entity/rita_npc.png");

    public RenderRitaNPC(RenderManager mgr)
    {
        super(mgr, new ModelNPC(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityRita entityIn){return NPC_TEXTURES;}
}