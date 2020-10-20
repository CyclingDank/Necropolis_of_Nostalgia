package com.turtledove.withernauts.client.render.npc;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.client.model.entity.npc.ModelNPC;
import com.turtledove.withernauts.server.entity.npc.EntityCarlson;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCarlsonNPC extends RenderLiving<EntityCarlson>
{
    private static final ResourceLocation NPC_TEXTURES = new ResourceLocation(Withernauts.MODID,"textures/entity/carlson_npc.png");

    public RenderCarlsonNPC(RenderManager mgr)
    {
        super(mgr, new ModelNPC(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityCarlson entityIn){return NPC_TEXTURES;}
}