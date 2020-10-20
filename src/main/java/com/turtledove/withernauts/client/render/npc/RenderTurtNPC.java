package com.turtledove.withernauts.client.render.npc;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.client.model.entity.npc.ModelTurtNPC;
import com.turtledove.withernauts.server.entity.npc.EntityWM;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTurtNPC extends RenderLiving<EntityWM>
{
    private static final ResourceLocation NPC_TEXTURES = new ResourceLocation(Withernauts.MODID,"textures/entity/turtledove.png");

    public RenderTurtNPC(RenderManager mgr)
    {
        super(mgr, new ModelTurtNPC(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityWM entityIn){return NPC_TEXTURES;}
}