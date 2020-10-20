package com.turtledove.withernauts.client.model.entity.player.avalon_mail;

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
public class ModelAvalonMail extends ModelBiped {
    public ModelRenderer am_shoulder_r_1;
    public ModelRenderer am_shoulder_r_2;
    public ModelRenderer am_shoulder_r_3;
    public ModelRenderer am_shoulder_r_4;
    public ModelRenderer am_shoulder_r_5;
    public ModelRenderer am_boot_r;
    public ModelRenderer am_leg_pivot_r;
    public ModelRenderer am_leg_r_1;
    public ModelRenderer am_leg_r_2;
    public ModelRenderer am_helm_1;
    public ModelRenderer am_helm_2;
    public ModelRenderer am_torso;
    public ModelRenderer am_torso_1;
    public ModelRenderer am_torso_2;
    public ModelRenderer am_torso_3;
    public ModelRenderer am_torso_4;
    public ModelRenderer am_torso_5;
    public ModelRenderer am_shoulder_l_1;
    public ModelRenderer am_shoulder_l_3;
    public ModelRenderer am_shoulder_l_4;
    public ModelRenderer am_shoulder_l_5;
    public ModelRenderer am_shoulder_l_6;
    public ModelRenderer am_boot_l;
    public ModelRenderer am_leg_pivot_l;
    public ModelRenderer am_leg_l_1;
    public ModelRenderer am_leg_l_2;

    public ModelAvalonMail() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.am_leg_pivot_r = new ModelRenderer(this, 0, 0);
        this.am_leg_pivot_r.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.am_leg_pivot_r.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.am_torso_4 = new ModelRenderer(this, 0, 27);
        this.am_torso_4.setRotationPoint(0.0F, 13.0F, 0.0F);
        this.am_torso_4.addBox(-2.0F, -3.0F, -2.5F, 4, 4, 5, 0.0F);
        this.am_shoulder_l_1 = new ModelRenderer(this, 0, 54);
        this.am_shoulder_l_1.mirror = true;
        this.am_shoulder_l_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.am_shoulder_l_1.addBox(-1.0F, -2.5F, -3.0F, 5, 4, 6, 0.0F);
        this.am_helm_2 = new ModelRenderer(this, 0, 18);
        this.am_helm_2.setRotationPoint(0.0F, -5.0F, -4.0F);
        this.am_helm_2.addBox(-2.5F, -6.0F, -1.5F, 5, 6, 3, 0.0F);
        this.am_shoulder_r_2 = new ModelRenderer(this, 48, 55);
        this.am_shoulder_r_2.setRotationPoint(-0.5F, 4.0F, 0.0F);
        this.am_shoulder_r_2.addBox(-3.0F, -4.0F, -2.5F, 2, 4, 5, 0.0F);
        this.am_boot_l = new ModelRenderer(this, 36, 8);
        this.am_boot_l.mirror = true;
        this.am_boot_l.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.am_boot_l.addBox(-2.5F, 7.0F, -2.5F, 5, 5, 5, 0.0F);
        this.am_torso_2 = new ModelRenderer(this, 36, 0);
        this.am_torso_2.mirror = true;
        this.am_torso_2.setRotationPoint(2.25F, 9.0F, -2.0F);
        this.am_torso_2.addBox(-2.0F, -8.0F, 0.0F, 4, 5, 1, 0.0F);
        this.setRotateAngle(am_torso_2, 0.3141592653589793F, -0.5235987755982988F, -0.10471975511965977F);
        this.am_shoulder_r_4 = new ModelRenderer(this, 22, 56);
        this.am_shoulder_r_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.am_shoulder_r_4.addBox(-5.0F, 0.5F, -3.5F, 6, 1, 7, 0.0F);
        this.am_leg_l_2 = new ModelRenderer(this, 28, 28);
        this.am_leg_l_2.mirror = true;
        this.am_leg_l_2.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.am_leg_l_2.addBox(0.0F, 0.0F, -3.5F, 4, 1, 7, 0.0F);
        this.am_shoulder_r_5 = new ModelRenderer(this, 0, 51);
        this.am_shoulder_r_5.setRotationPoint(-4.4F, 1.5F, 0.0F);
        this.am_shoulder_r_5.addBox(-0.5F, -3.0F, -1.0F, 1, 3, 2, 0.0F);
        this.am_torso = new ModelRenderer(this, 0, 36);
        this.am_torso.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.am_torso.addBox(-4.5F, 0.0F, -2.5F, 9, 10, 5, 0.0F);
        this.am_shoulder_r_1 = new ModelRenderer(this, 0, 54);
        this.am_shoulder_r_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.am_shoulder_r_1.addBox(-4.0F, -2.5F, -3.0F, 5, 4, 6, 0.0F);
        this.am_shoulder_l_4 = new ModelRenderer(this, 16, 18);
        this.am_shoulder_l_4.mirror = true;
        this.am_shoulder_l_4.setRotationPoint(0.0F, -2.5F, 0.0F);
        this.am_shoulder_l_4.addBox(0.0F, -2.0F, -3.0F, 1, 2, 6, 0.0F);
        this.am_shoulder_l_6 = new ModelRenderer(this, 0, 51);
        this.am_shoulder_l_6.mirror = true;
        this.am_shoulder_l_6.setRotationPoint(4.4F, 0.5F, 0.0F);
        this.am_shoulder_l_6.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
        this.am_leg_r_1 = new ModelRenderer(this, 28, 36);
        this.am_leg_r_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.am_leg_r_1.addBox(-3.0F, -2.0F, -3.0F, 3, 6, 6, 0.0F);
        this.setRotateAngle(am_leg_r_1, 0.0F, 0.0F, 0.17453292519943295F);
        this.am_leg_pivot_l = new ModelRenderer(this, 0, 0);
        this.am_leg_pivot_l.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.am_leg_pivot_l.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.am_shoulder_l_5 = new ModelRenderer(this, 22, 56);
        this.am_shoulder_l_5.mirror = true;
        this.am_shoulder_l_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.am_shoulder_l_5.addBox(-1.0F, 0.5F, -3.5F, 6, 1, 7, 0.0F);
        this.am_torso_3 = new ModelRenderer(this, 46, 0);
        this.am_torso_3.setRotationPoint(0.0F, 9.0F, -2.5F);
        this.am_torso_3.addBox(-1.0F, -8.0F, -0.5F, 2, 5, 1, 0.0F);
        this.setRotateAngle(am_torso_3, 0.296705972839036F, 0.0F, 0.0F);
        this.am_leg_l_1 = new ModelRenderer(this, 28, 36);
        this.am_leg_l_1.mirror = true;
        this.am_leg_l_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.am_leg_l_1.addBox(0.0F, -2.0F, -3.0F, 3, 6, 6, 0.0F);
        this.setRotateAngle(am_leg_l_1, 0.0F, 0.0F, -0.17453292519943295F);
        this.am_shoulder_l_3 = new ModelRenderer(this, 48, 55);
        this.am_shoulder_l_3.mirror = true;
        this.am_shoulder_l_3.setRotationPoint(1.5F, 4.0F, 0.0F);
        this.am_shoulder_l_3.addBox(0.0F, -4.0F, -2.5F, 2, 4, 5, 0.0F);
        this.am_torso_5 = new ModelRenderer(this, 28, 48);
        this.am_torso_5.setRotationPoint(0.0F, 9.0F, -1.0F);
        this.am_torso_5.addBox(-2.0F, -4.0F, -2.0F, 4, 4, 4, 0.0F);
        this.am_leg_r_2 = new ModelRenderer(this, 28, 28);
        this.am_leg_r_2.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.am_leg_r_2.addBox(-4.0F, 0.0F, -3.5F, 4, 1, 7, 0.0F);
        this.am_torso_1 = new ModelRenderer(this, 36, 0);
        this.am_torso_1.setRotationPoint(-2.25F, 9.0F, -2.0F);
        this.am_torso_1.addBox(-2.0F, -8.0F, 0.0F, 4, 5, 1, 0.0F);
        this.setRotateAngle(am_torso_1, 0.3141592653589793F, 0.5235987755982988F, 0.10471975511965977F);
        this.am_helm_1 = new ModelRenderer(this, 0, 0);
        this.am_helm_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.am_helm_1.addBox(-4.5F, -9.0F, -4.5F, 9, 9, 9, 0.0F);
        this.am_boot_r = new ModelRenderer(this, 36, 8);
        this.am_boot_r.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.am_boot_r.addBox(-2.5F, 7.0F, -2.5F, 5, 5, 5, 0.0F);
        this.am_shoulder_r_3 = new ModelRenderer(this, 16, 18);
        this.am_shoulder_r_3.setRotationPoint(0.0F, -2.5F, 0.0F);
        this.am_shoulder_r_3.addBox(-1.0F, -2.0F, -3.0F, 1, 2, 6, 0.0F);

        this.bipedRightLeg.addChild(this.am_leg_pivot_r);
        this.am_torso.addChild(this.am_torso_4);
        this.bipedLeftArm.addChild(this.am_shoulder_l_1);
        this.am_helm_1.addChild(this.am_helm_2);
        this.am_shoulder_r_1.addChild(this.am_shoulder_r_2);
        this.bipedLeftLeg.addChild(this.am_boot_l);
        this.am_torso.addChild(this.am_torso_2);
        this.am_shoulder_r_1.addChild(this.am_shoulder_r_4);
        this.am_leg_l_1.addChild(this.am_leg_l_2);
        this.am_shoulder_r_1.addChild(this.am_shoulder_r_5);
        this.bipedBody.addChild(this.am_torso);
        this.bipedRightArm.addChild(this.am_shoulder_r_1);
        this.am_shoulder_l_1.addChild(this.am_shoulder_l_4);
        this.am_shoulder_l_1.addChild(this.am_shoulder_l_6);
        this.am_leg_pivot_r.addChild(this.am_leg_r_1);
        this.bipedLeftLeg.addChild(this.am_leg_pivot_l);
        this.am_shoulder_l_1.addChild(this.am_shoulder_l_5);
        this.am_torso.addChild(this.am_torso_3);
        this.am_leg_pivot_l.addChild(this.am_leg_l_1);
        this.am_shoulder_l_1.addChild(this.am_shoulder_l_3);
        this.am_torso.addChild(this.am_torso_5);
        this.am_leg_r_1.addChild(this.am_leg_r_2);
        this.am_torso.addChild(this.am_torso_1);
        this.bipedHead.addChild(this.am_helm_1);
        this.bipedRightLeg.addChild(this.am_boot_r);
        this.am_shoulder_r_1.addChild(this.am_shoulder_r_3);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
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
                        copyModelAngles(this.bipedHead, this.am_helm_1);
                        this.am_helm_1.render(f5);
                    }
                    else if (tArmor.renderIndex == 1)
                    {
                        copyModelAngles(this.bipedBody, this.am_torso);
                        copyModelAngles(this.bipedRightArm, this.am_shoulder_r_1);
                        copyModelAngles(this.bipedLeftArm, this.am_shoulder_l_1);
                        this.am_torso.render(f5);
                        this.am_shoulder_r_1.render(f5);
                        this.am_shoulder_l_1.render(f5);
                    }
                    else if (tArmor.renderIndex == 2)
                    {
                        copyModelAngles(this.bipedLeftLeg, this.am_leg_pivot_l);
                        copyModelAngles(this.bipedRightLeg, this.am_leg_pivot_r);
                        this.am_leg_pivot_l.render(f5);
                        this.am_leg_pivot_r.render(f5);
                    }
                    else if (tArmor.renderIndex == 3)
                    {
                        copyModelAngles(this.bipedLeftLeg, this.am_boot_l);
                        copyModelAngles(this.bipedRightLeg, this.am_boot_r);
                        this.am_boot_r.render(f5);
                        this.am_boot_l.render(f5);
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
                        copyModelAngles(this.bipedHead, this.am_helm_1);
                        this.am_helm_1.render(f5);
                    }
                    else if (tArmor.renderIndex == 1)
                    {
                        copyModelAngles(this.bipedBody, this.am_torso);
                        copyModelAngles(this.bipedRightArm, this.am_shoulder_r_1);
                        copyModelAngles(this.bipedLeftArm, this.am_shoulder_l_1);
                        this.am_torso.render(f5);
                        this.am_shoulder_r_1.render(f5);
                        this.am_shoulder_l_1.render(f5);
                    }
                    else if (tArmor.renderIndex == 2)
                    {
                        copyModelAngles(this.bipedLeftLeg, this.am_leg_pivot_l);
                        copyModelAngles(this.bipedRightLeg, this.am_leg_pivot_r);
                        this.am_leg_pivot_l.render(f5);
                        this.am_leg_pivot_r.render(f5);
                    }
                    else if (tArmor.renderIndex == 3)
                    {
                        copyModelAngles(this.bipedLeftLeg, this.am_boot_l);
                        copyModelAngles(this.bipedRightLeg, this.am_boot_r);
                        this.am_boot_r.render(f5);
                        this.am_boot_l.render(f5);
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
