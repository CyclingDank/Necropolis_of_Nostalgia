package com.turtledove.necropolisofnostalgia.client.render.npc;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.model.entity.npc.ModelNPC;
import com.turtledove.necropolisofnostalgia.server.entity.npc.EntityDwigt;
import com.turtledove.necropolisofnostalgia.server.entity.npc.EntityTea;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDwigtNPC extends RenderLiving<EntityDwigt>
{
    private static final ResourceLocation NPC_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/dwigt_npc.png");

    public RenderDwigtNPC(RenderManager mgr)
    {
        super(mgr, new ModelNPC(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityDwigt entityIn){return NPC_TEXTURES;}
}