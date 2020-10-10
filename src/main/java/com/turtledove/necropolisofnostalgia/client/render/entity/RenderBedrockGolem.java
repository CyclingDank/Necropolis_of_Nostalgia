package com.turtledove.necropolisofnostalgia.client.render.entity;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelBedrockGolem;
import com.turtledove.necropolisofnostalgia.client.model.entity.ModelBooglin;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityBedrockGolem;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityBooglin;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBedrockGolem extends RenderLiving<EntityBedrockGolem>
{
    private static final ResourceLocation BG_1_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/bedrock_golem_1.png");
    private static final ResourceLocation BG_2_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/bedrock_golem_2.png");
    private static final ResourceLocation BG_3_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/bedrock_golem_3.png");
    private static final ResourceLocation BG_4_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/bedrock_golem_4.png");
    private static final ResourceLocation BG_5_TEXTURES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/bedrock_golem_5.png");

    private static final ResourceLocation[] textArray = new ResourceLocation[]{BG_1_TEXTURES, BG_2_TEXTURES, BG_3_TEXTURES, BG_4_TEXTURES, BG_5_TEXTURES};

    private static int texIndex = 0;

    public RenderBedrockGolem(RenderManager mgr)
    {
        super(mgr, new ModelBedrockGolem(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(EntityBedrockGolem entityIn)
    {
        if (entityIn.ticksExisted % 15 == 0)
        {
            texIndex += 1;
            if (texIndex == 5)
                texIndex = 0;
        }

        return textArray[texIndex];
    }
}