package com.turtledove.necropolisofnostalgia.client.render.npc;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.model.entity.npc.ModelNPC;
import com.turtledove.necropolisofnostalgia.server.entity.npc.EntityCarlson;
import com.turtledove.necropolisofnostalgia.server.entity.npc.EntityRita;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCarlsonNPC extends RenderLiving<EntityCarlson>
{
    private static final ResourceLocation NPC_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/carlson_npc.png");

    public RenderCarlsonNPC(RenderManager mgr)
    {
        super(mgr, new ModelNPC(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityCarlson entityIn){return NPC_TEXTURES;}
}