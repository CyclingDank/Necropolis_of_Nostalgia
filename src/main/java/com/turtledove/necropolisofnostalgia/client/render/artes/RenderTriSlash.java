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

public class RenderTriSlash implements ArteRenderBase
{
    public void renderArte(AbstractClientPlayer abstractclientplayer, ItemStack item, float partialTicks)
    {
        PlayerData data = (PlayerData) NecropolisPlayerData.get(Minecraft.getMinecraft().player);
        float f = data.getpArteTime(partialTicks);

        EnumHand enumhand = (EnumHand) MoreObjects.firstNonNull(abstractclientplayer.swingingHand, EnumHand.MAIN_HAND);
        float f1 = abstractclientplayer.prevRotationPitch + (abstractclientplayer.rotationPitch - abstractclientplayer.prevRotationPitch) * partialTicks;
        float f2 = abstractclientplayer.prevRotationYaw + (abstractclientplayer.rotationYaw - abstractclientplayer.prevRotationYaw) * partialTicks;
        boolean flag = true;

        this.rotateArroundXAndY(f1, f2);
        this.setLightmap();
        this.rotateArm(partialTicks);
        GlStateManager.enableRescaleNormal();
        if (flag)
        {
            float swing_ratio = data.getpArteTime(partialTicks);
            float equip_ratio = 1.0F;

            this.renderSwordInFirstPerson(abstractclientplayer, partialTicks, f1, EnumHand.MAIN_HAND, 1.0f - swing_ratio, item, equip_ratio);
        }
        GlStateManager.disableRescaleNormal();
        RenderHelper.disableStandardItemLighting();
    }

    public void renderSwordInFirstPerson(AbstractClientPlayer player, float partialTicks, float p_187457_3_, EnumHand hand, float swing_ratio, ItemStack stack, float equip_ratio)
    {
        EnumHandSide enumhandside = player.getPrimaryHand();
        GlStateManager.pushMatrix();

        int j = 1;
        float f = -0.8F * MathHelper.sin(MathHelper.sqrt(swing_ratio) * (float) Math.PI);
        float f1 = 0.2F * MathHelper.sin(MathHelper.sqrt(swing_ratio) * ((float) Math.PI * 2F));
        float f2 = -0.2F * MathHelper.sin(swing_ratio * (float) Math.PI);
        int i = 1;
        //GlStateManager.translate(0.0F,  f * 0.5, 0.0F);
        this.transformSwordSideFirstPerson(enumhandside, equip_ratio,  swing_ratio);
        this.transformSwordFirstPerson(enumhandside, swing_ratio);

        this.renderItemSide(player, stack, ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND);
        GlStateManager.popMatrix();
    }
    public void setLightmap()
    {
        AbstractClientPlayer abstractclientplayer = Minecraft.getMinecraft().player;
        int i = Minecraft.getMinecraft().world.getCombinedLight(new BlockPos(abstractclientplayer.posX, abstractclientplayer.posY + (double)abstractclientplayer.getEyeHeight(), abstractclientplayer.posZ), 0);
        float f = (float)(i & 65535);
        float f1 = (float)(i >> 16);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, f, f1);
    }
    public void rotateArroundXAndY(float angle, float angleY)
    {
        GlStateManager.pushMatrix();
        GlStateManager.rotate(angle, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(angleY, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.popMatrix();
    }
    public void rotateArm(float p_187458_1_)
    {
        EntityPlayerSP entityplayersp = Minecraft.getMinecraft().player;
        float f = entityplayersp.prevRenderArmPitch + (entityplayersp.renderArmPitch - entityplayersp.prevRenderArmPitch) * p_187458_1_;
        float f1 = entityplayersp.prevRenderArmYaw + (entityplayersp.renderArmYaw - entityplayersp.prevRenderArmYaw) * p_187458_1_;
        GlStateManager.rotate((entityplayersp.rotationPitch - f) * 0.1F, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate((entityplayersp.rotationYaw - f1) * 0.1F, 0.0F, 1.0F, 0.0F);
    }
    public void transformSwordSideFirstPerson(EnumHandSide hand, float equip_ratio,  float swing_ratio)
    {
        PlayerData data = (PlayerData) NecropolisPlayerData.get(Minecraft.getMinecraft().player);
        float f = MathHelper.cos(swing_ratio * swing_ratio * (float)Math.PI);

        if (data.get_current_stage()%2 == 0 )
        {
            GlStateManager.translate(0.56F  - swing_ratio * 1.75F + 0.9F, swing_ratio * 0.25F - 0.4F, -0.52F);
            GlStateManager.rotate(70.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(-90.0F + f * f * 25F, 0.0F, 0.0F, 1.0F);
            GlStateManager.rotate(-15F + 35.0F * f, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate( 25.0F, 0.0F, 1.0F, 0.0F);
        }
        else
        {
            f = MathHelper.cos((1.0f - swing_ratio) * (1.0f - swing_ratio) * (float)Math.PI);
            GlStateManager.translate(-0.56F  + swing_ratio * 1.75F - 0.5F, swing_ratio * 0.25F - 0.4F, -0.52F);
            GlStateManager.rotate(70.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(-90.0F + f * f * 25F, 0.0F, 0.0F, 1.0F);
            GlStateManager.rotate(-15F + 35.0F * f, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate( 25.0F, 0.0F, 1.0F, 0.0F);
        }
    }
    public void transformSwordFirstPerson(EnumHandSide hand, float swing_ratio)
    {
    }
    public void renderItemSide(EntityLivingBase entitylivingbaseIn, ItemStack heldStack, ItemCameraTransforms.TransformType transform)
    {
        if (!heldStack.isEmpty())
        {
            Item item = heldStack.getItem();
            Block block = Block.getBlockFromItem(item);
            GlStateManager.pushMatrix();
            boolean flag = Minecraft.getMinecraft().getRenderItem().shouldRenderItemIn3D(heldStack) && block.getBlockLayer() == BlockRenderLayer.TRANSLUCENT;

            if (flag)
            {
                GlStateManager.depthMask(false);
            }

            Minecraft.getMinecraft().getRenderItem().renderItem(heldStack, entitylivingbaseIn, transform, false);

            if (flag)
            {
                GlStateManager.depthMask(true);
            }
            GlStateManager.popMatrix();
        }
    }
}
