package com.turtledove.necropolisofnostalgia.client.model.entity.player.sorcerers_sallet;

import net.minecraft.client.model.ModelBase;
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
public class ModelSorcerersSallet extends ModelBiped {
    public ModelRenderer sallet_1;
    public ModelRenderer sallet_2;
    public ModelRenderer sallet_3;
    public ModelRenderer sallet_4;

    public ModelSorcerersSallet() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.sallet_3 = new ModelRenderer(this, 0, 18);
        this.sallet_3.setRotationPoint(0.0F, -5.25F, 0.0F);
        this.sallet_3.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
        this.setRotateAngle(sallet_3, -0.4553564018453205F, 0.0F, 0.0F);
        this.sallet_1 = new ModelRenderer(this, -10, 50);
        this.sallet_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sallet_1.addBox(-5.0F, 0.1F, -5.0F, 10, 0, 10, 0.0F);
        this.sallet_2 = new ModelRenderer(this, 0, 0);
        this.sallet_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sallet_2.addBox(-4.5F, -9.0F, -4.5F, 9, 9, 9, 0.0F);
        this.sallet_4 = new ModelRenderer(this, 0, 36);
        this.sallet_4.setRotationPoint(0.0F, -7.5F, 0.0F);
        this.sallet_4.addBox(-2.5F, -8.0F, -4.0F, 5, 10, 4, 0.0F);
        this.setRotateAngle(sallet_4, -1.6390387005478748F, 0.0F, 0.0F);
        this.sallet_2.addChild(this.sallet_3);
        this.sallet_1.addChild(this.sallet_2);
        this.sallet_3.addChild(this.sallet_4);

        this.bipedHead.addChild(this.sallet_1);

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
                        copyModelAngles(this.bipedHead, this.sallet_1);
                        this.sallet_1.render(f5);
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
                        copyModelAngles(this.bipedHead, this.sallet_1);
                        this.sallet_1.render(f5);
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
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
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
