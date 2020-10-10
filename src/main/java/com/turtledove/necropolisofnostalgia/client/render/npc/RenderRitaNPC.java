package com.turtledove.necropolisofnostalgia.client.render.npc;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.model.entity.npc.ModelNPC;
import com.turtledove.necropolisofnostalgia.server.entity.npc.EntityRita;
import com.turtledove.necropolisofnostalgia.server.entity.npc.EntityYam;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderRitaNPC extends RenderLiving<EntityRita>
{
    private static final ResourceLocation NPC_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/rita_npc.png");

    public RenderRitaNPC(RenderManager mgr)
    {
        super(mgr, new ModelNPC(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityRita entityIn){return NPC_TEXTURES;}
}