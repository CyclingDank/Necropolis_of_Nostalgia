package com.turtledove.necropolisofnostalgia.client.render.artes;

import com.google.common.base.MoreObjects;
import com.turtledove.necropolisofnostalgia.server.core.NecropolisPlayerData;
import com.turtledove.necropolisofnostalgia.server.core.PlayerData;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class RenderFireBall implements ArteRenderBase
{
    public void renderArte(AbstractClientPlayer abstractclientplayer, ItemStack item, float partialTicks)
    {
    }

    public void renderSwordInFirstPerson(AbstractClientPlayer player, float partialTicks, float p_187457_3_, EnumHand hand, float swing_ratio, ItemStack stack, float equip_ratio)
    {
    }
    public void setLightmap()
    {
    }
    public void rotateArroundXAndY(float angle, float angleY)
    {
    }
    public void rotateArm(float p_187458_1_)
    {
    }
    public void transformSwordSideFirstPerson(EnumHandSide hand, float equip_ratio,  float swing_ratio)
    {
    }
    public void transformSwordFirstPerson(EnumHandSide hand, float swing_ratio)
    {
    }
    public void renderItemSide(EntityLivingBase entitylivingbaseIn, ItemStack heldStack, ItemCameraTransforms.TransformType transform)
    {
    }
}
