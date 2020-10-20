package com.turtledove.withernauts.client.model.entity.player.lamellar;

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
public class ModelLamellarArmor extends ModelBiped {
    public ModelRenderer ll_shoulder_r;
    public ModelRenderer ll_elbow_r;
    public ModelRenderer ll_leg_r;
    public ModelRenderer ll_foot_r;
    public ModelRenderer ll_helm;
    public ModelRenderer ll_hair;
    public ModelRenderer ll_torso;
    public ModelRenderer ll_collar;
    public ModelRenderer ll_shoulder_l;
    public ModelRenderer ll_elbow_l;
    public ModelRenderer ll_leg_l;
    public ModelRenderer ll_foot_l;

    public ModelLamellarArmor(boolean leg) {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.ll_shoulder_r = new ModelRenderer(this, 36, 8);
        this.ll_shoulder_r.mirror = true;
        this.ll_shoulder_r.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ll_shoulder_r.addBox(-4.0F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
        this.ll_elbow_l = new ModelRenderer(this, 0, 18);
        this.ll_elbow_l.mirror = true;
        this.ll_elbow_l.setRotationPoint(3.0F, 3.0F, 0.0F);
        this.ll_elbow_l.addBox(-1.0F, 0.0F, -2.5F, 2, 2, 5, 0.0F);
        this.ll_elbow_r = new ModelRenderer(this, 0, 18);
        this.ll_elbow_r.mirror = true;
        this.ll_elbow_r.setRotationPoint(-3.0F, 3.0F, 0.0F);
        this.ll_elbow_r.addBox(-1.0F, 0.0F, -2.5F, 2, 2, 5, 0.0F);
        this.ll_collar = new ModelRenderer(this, 0, 35);
        this.ll_collar.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ll_collar.addBox(-4.5F, -1.0F, -2.0F, 9, 3, 5, 0.0F);
        this.ll_hair = new ModelRenderer(this, 0, 53);
        this.ll_hair.setRotationPoint(0.0F, -9.0F, 0.0F);
        this.ll_hair.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 5, 0.0F);
        this.ll_torso = new ModelRenderer(this, 14, 18);
        this.ll_torso.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ll_torso.addBox(-4.5F, 0.0F, -2.5F, 9, 12, 5, 0.0F);
        this.ll_helm = new ModelRenderer(this, 0, 0);
        this.ll_helm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ll_helm.addBox(-4.5F, -9.0F, -4.5F, 9, 9, 9, 0.0F);
        this.ll_shoulder_l = new ModelRenderer(this, 36, 8);
        this.ll_shoulder_l.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ll_shoulder_l.addBox(-1.0F, -2.5F, -2.5F, 5, 5, 5, 0.0F);

        this.ll_leg_r = new ModelRenderer(this, 0, 0);
        this.ll_leg_r.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ll_leg_r.addBox(-3.0F, 0.0F, -2.5F, 5, 6, 5, 0.0F);
        this.ll_leg_l = new ModelRenderer(this, 0, 0);
        this.ll_leg_l.mirror = true;
        this.ll_leg_l.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ll_leg_l.addBox(-2.0F, 0.0F, -2.5F, 5, 6, 5, 0.0F);
        this.ll_foot_r = new ModelRenderer(this, 0, 43);
        this.ll_foot_r.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ll_foot_r.addBox(-3.0F, 7.0F, -2.5F, 5, 5, 5, 0.0F);
        this.ll_foot_l = new ModelRenderer(this, 0, 43);
        this.ll_foot_l.mirror = true;
        this.ll_foot_l.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ll_foot_l.addBox(-2.0F, 7.0F, -2.5F, 5, 5, 5, 0.0F);

        this.ll_shoulder_r.addChild(this.ll_elbow_r);
        this.ll_helm.addChild(this.ll_hair);
        this.ll_torso.addChild(this.ll_collar);
        this.ll_shoulder_l.addChild(this.ll_elbow_l);

        this.bipedRightLeg.addChild(this.ll_leg_r);
        this.bipedLeftLeg.addChild(this.ll_leg_l);
        this.bipedHead.addChild(this.ll_helm);
        this.bipedRightArm.addChild(this.ll_shoulder_r);
        this.bipedBody.addChild(this.ll_torso);
        this.bipedLeftArm.addChild(this.ll_shoulder_l);
        this.bipedRightLeg.addChild(this.ll_foot_r);
        this.bipedLeftLeg.addChild(this.ll_foot_l);
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
        if (entity instanceof EntityPlayer)
        {
            for (ItemStack iArmor : ((EntityPlayer)entity).getArmorInventoryList())
            {
                if (iArmor.getItem() instanceof ItemArmor)
                {
                    ItemArmor tArmor = (ItemArmor)iArmor.getItem();
                    if (tArmor.renderIndex == 0)
                    {
                        copyModelAngles(this.bipedHead, this.ll_helm);
                        this.ll_helm.render(f5);
                    }
                    else if (tArmor.renderIndex == 1)
                    {
                        copyModelAngles(this.bipedBody, this.ll_torso);
                        copyModelAngles(this.bipedRightArm, this.ll_shoulder_r);
                        copyModelAngles(this.bipedLeftArm, this.ll_shoulder_l);
                        this.ll_torso.render(f5);
                        this.ll_shoulder_r.render(f5);
                        this.ll_shoulder_l.render(f5);
                    }
                    else if (tArmor.renderIndex == 2)
                    {
                        copyModelAngles(this.bipedLeftLeg, this.ll_leg_l);
                        copyModelAngles(this.bipedRightLeg, this.ll_leg_r);
                        this.ll_leg_l.render(f5);
                        this.ll_leg_r.render(f5);
                    }
                    else if (tArmor.renderIndex == 3)
                    {
                        copyModelAngles(this.bipedLeftLeg, this.ll_foot_l);
                        copyModelAngles(this.bipedRightLeg, this.ll_foot_r);
                        this.ll_foot_r.render(f5);
                        this.ll_foot_l.render(f5);
                    }
                }
            }
        }
        else if (entity instanceof EntityArmorStand)
        {
            for (ItemStack iArmor : ((EntityArmorStand)entity).getArmorInventoryList())
            {
                if (iArmor.getItem() instanceof ItemArmor)
                {
                    ItemArmor tArmor = (ItemArmor)iArmor.getItem();
                    if (tArmor.renderIndex == 0)
                    {
                        copyModelAngles(this.bipedHead, this.ll_helm);
                        this.ll_helm.render(f5);
                    }
                    else if (tArmor.renderIndex == 1)
                    {
                        copyModelAngles(this.bipedBody, this.ll_torso);
                        copyModelAngles(this.bipedRightArm, this.ll_shoulder_r);
                        copyModelAngles(this.bipedLeftArm, this.ll_shoulder_l);

                        this.ll_torso.render(f5);
                        this.ll_shoulder_r.render(f5);
                        this.ll_shoulder_l.render(f5);
                    }
                    else if (tArmor.renderIndex == 2)
                    {
                        copyModelAngles(this.bipedLeftLeg, this.ll_leg_l);
                        copyModelAngles(this.bipedRightLeg, this.ll_leg_r);

                        this.ll_leg_l.render(f5);
                        this.ll_leg_r.render(f5);
                    }
                    else if (tArmor.renderIndex == 3)
                    {
                        copyModelAngles(this.bipedLeftLeg, this.ll_foot_l);
                        copyModelAngles(this.bipedRightLeg, this.ll_foot_r);

                        this.ll_foot_r.render(f5);
                        this.ll_foot_l.render(f5);
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
