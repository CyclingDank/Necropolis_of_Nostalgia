package com.turtledove.withernauts.client.model.entity.player.thiefs_hood;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelThiefsHood extends ModelBiped {
    public ModelRenderer head;
    public ModelRenderer th_hood_1;
    public ModelRenderer th_hood_2;

    public ModelThiefsHood() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.th_hood_2 = new ModelRenderer(this, 0, 18);
        this.th_hood_2.setRotationPoint(0.0F, -9.0F, 4.5F);
        this.th_hood_2.addBox(-4.5F, 0.0F, 0.0F, 9, 3, 3, 0.0F);
        this.setRotateAngle(th_hood_2, -0.36425021489121656F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 40);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.th_hood_1 = new ModelRenderer(this, 0, 0);
        this.th_hood_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.th_hood_1.addBox(-4.5F, -9.0F, -4.5F, 9, 9, 9, 0.0F);
        this.th_hood_1.addChild(this.th_hood_2);
        this.bipedHead.addChild(this.th_hood_1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        this.setRotationAngles(f, f1,f2,f3,f4,f5,entity);
        GlStateManager.pushMatrix();

        if (entity.isSneaking())
        {
            GlStateManager.translate(0.0F, 0.2F, 0.0F);
        }
        if (entity instanceof EntityPlayer) {
            for (ItemStack iArmor : ((EntityPlayer) entity).getArmorInventoryList())
            {
                if (iArmor.getItem() instanceof ItemArmor) {
                    ItemArmor tArmor = (ItemArmor) iArmor.getItem();
                    if (tArmor.renderIndex == 0) {
                        copyModelAngles(this.bipedHead, this.th_hood_1);
                        this.th_hood_1.render(f5);
                    }
                }
            }
        }
        else if (entity instanceof EntityArmorStand)
        {
            for (ItemStack iArmor : ((EntityArmorStand) entity).getArmorInventoryList())
            {
                if (iArmor.getItem() instanceof ItemArmor) {
                    ItemArmor tArmor = (ItemArmor) iArmor.getItem();
                    if (tArmor.renderIndex == 0) {
                        copyModelAngles(this.bipedHead, this.th_hood_1);
                        this.th_hood_1.render(f5);
                    }
                }
            }
        }
        GlStateManager.popMatrix();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        if (entityIn instanceof EntityArmorStand) {
            EntityArmorStand entityarmorstand = (EntityArmorStand) entityIn;
            this.bipedHead.rotateAngleX = 0.017453292F * entityarmorstand.getHeadRotation().getX();
            this.bipedHead.rotateAngleY = 0.017453292F * entityarmorstand.getHeadRotation().getY();
            this.bipedHead.rotateAngleZ = 0.017453292F * entityarmorstand.getHeadRotation().getZ();
            this.bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
            this.bipedBody.rotateAngleX = 0.017453292F * entityarmorstand.getBodyRotation().getX();
            this.bipedBody.rotateAngleY = 0.017453292F * entityarmorstand.getBodyRotation().getY();
            this.bipedBody.rotateAngleZ = 0.017453292F * entityarmorstand.getBodyRotation().getZ();
            this.bipedLeftArm.rotateAngleX = 0.017453292F * entityarmorstand.getLeftArmRotation().getX();
            this.bipedLeftArm.rotateAngleY = 0.017453292F * entityarmorstand.getLeftArmRotation().getY();
            this.bipedLeftArm.rotateAngleZ = 0.017453292F * entityarmorstand.getLeftArmRotation().getZ();
            this.bipedRightArm.rotateAngleX = 0.017453292F * entityarmorstand.getRightArmRotation().getX();
            this.bipedRightArm.rotateAngleY = 0.017453292F * entityarmorstand.getRightArmRotation().getY();
            this.bipedRightArm.rotateAngleZ = 0.017453292F * entityarmorstand.getRightArmRotation().getZ();
            this.bipedLeftLeg.rotateAngleX = 0.017453292F * entityarmorstand.getLeftLegRotation().getX();
            this.bipedLeftLeg.rotateAngleY = 0.017453292F * entityarmorstand.getLeftLegRotation().getY();
            this.bipedLeftLeg.rotateAngleZ = 0.017453292F * entityarmorstand.getLeftLegRotation().getZ();
            this.bipedLeftLeg.setRotationPoint(1.9F, 11.0F, 0.0F);
            this.bipedRightLeg.rotateAngleX = 0.017453292F * entityarmorstand.getRightLegRotation().getX();
            this.bipedRightLeg.rotateAngleY = 0.017453292F * entityarmorstand.getRightLegRotation().getY();
            this.bipedRightLeg.rotateAngleZ = 0.017453292F * entityarmorstand.getRightLegRotation().getZ();
            this.bipedRightLeg.setRotationPoint(-1.9F, 11.0F, 0.0F);
            copyModelAngles(this.bipedHead, this.bipedHeadwear);
        } else {
            super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        }
    }
}
