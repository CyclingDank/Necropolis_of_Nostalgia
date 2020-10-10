package com.turtledove.necropolisofnostalgia.client.render.artes;


import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;

/*this class handles rendering for multi-staged artes*/
public interface ArteRenderBase
{
    void renderArte(AbstractClientPlayer abstractclientplayer, ItemStack item, float partialTicks);

    void renderSwordInFirstPerson(AbstractClientPlayer player, float partialTicks, float p_187457_3_, EnumHand hand, float swing_ratio, ItemStack stack, float equip_ratio);
    void renderItemSide(EntityLivingBase entitylivingbaseIn, ItemStack heldStack, ItemCameraTransforms.TransformType transform);

    void transformSwordSideFirstPerson(EnumHandSide hand, float equip_ratio, float swing_ratio);
    void transformSwordFirstPerson(EnumHandSide hand, float swing_ratio);

    void setLightmap();
    void rotateArroundXAndY(float angle, float angleY);
    void rotateArm(float p_187458_1_);
}
