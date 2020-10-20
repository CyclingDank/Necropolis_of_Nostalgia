package com.turtledove.withernauts.client.model.entity.player.sacred_armor;

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
public class ModelSacredArmor extends ModelBiped {
    public ModelRenderer sa_shoulder_r_1;
    public ModelRenderer sa_shoulder_r_2;
    public ModelRenderer sa_shoulder_r_3;
    public ModelRenderer sa_leg_r_1;
    public ModelRenderer sa_boot_r;
    public ModelRenderer sa_helm_1;
    public ModelRenderer sa_helm_2;
    public ModelRenderer sa_torso;
    public ModelRenderer sa_torso_1;
    public ModelRenderer sa_torso_2;
    public ModelRenderer sa_torso_3;
    public ModelRenderer sa_torso_4;
    public ModelRenderer sa_torso_5;
    public ModelRenderer sa_shoulder_l_1;
    public ModelRenderer sa_shoulder_l_2;
    public ModelRenderer sa_shoulder_l_3;
    public ModelRenderer sa_shoulder_l_4;
    public ModelRenderer sa_leg_l_1;
    public ModelRenderer sa_boot_l;

    public ModelRenderer sa_leg_pivot_r;
    public ModelRenderer sa_leg_pivot_l;

    public ModelSacredArmor() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.sa_shoulder_l_4 = new ModelRenderer(this, 46, 35);
        this.sa_shoulder_l_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sa_shoulder_l_4.addBox(-1.0F, -6.0F, -3.5F, 2, 7, 7, 0.0F);
        this.setRotateAngle(sa_shoulder_l_4, 0.0F, 0.0F, 0.36425021489121656F);
        this.sa_torso_3 = new ModelRenderer(this, 46, 0);
        this.sa_torso_3.setRotationPoint(0.0F, 8.0F, -3.25F);
        this.sa_torso_3.addBox(-1.0F, -8.0F, -0.5F, 2, 8, 1, 0.0F);
        this.setRotateAngle(sa_torso_3, 0.22759093446006054F, 0.0F, 0.0F);
        this.sa_shoulder_r_2 = new ModelRenderer(this, 44, 9);
        this.sa_shoulder_r_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sa_shoulder_r_2.addBox(-1.5F, -6.0F, -3.5F, 3, 6, 7, 0.0F);
        this.setRotateAngle(sa_shoulder_r_2, 0.0F, 0.0F, -2.2689280275926285F);
        this.sa_shoulder_r_3 = new ModelRenderer(this, 0, 54);
        this.sa_shoulder_r_3.setRotationPoint(0.0F, -2.5F, 0.0F);
        this.sa_shoulder_r_3.addBox(-1.0F, -2.0F, -3.0F, 1, 2, 6, 0.0F);
        this.sa_helm_2 = new ModelRenderer(this, 0, 18);
        this.sa_helm_2.setRotationPoint(0.0F, -4.5F, 0.0F);
        this.sa_helm_2.addBox(-4.5F, -6.0F, -2.0F, 9, 6, 7, 0.0F);
        this.setRotateAngle(sa_helm_2, 1.1344640137963142F, 0.0F, 0.0F);
        this.sa_boot_r = new ModelRenderer(this, 18, 0);
        this.sa_boot_r.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sa_boot_r.addBox(-2.5F, 7.0F, -2.5F, 5, 5, 5, 0.0F);
        this.sa_torso_4 = new ModelRenderer(this, 0, 31);
        this.sa_torso_4.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.sa_torso_4.addBox(-4.5F, -3.0F, -2.5F, 9, 5, 5, 0.0F);
        this.setRotateAngle(sa_torso_4, 0.7853981633974483F, 0.0F, 0.0F);
        this.sa_boot_l = new ModelRenderer(this, 18, 0);
        this.sa_boot_l.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sa_boot_l.addBox(-2.5F, 7.0F, -2.5F, 5, 5, 5, 0.0F);
        this.sa_torso_2 = new ModelRenderer(this, 36, 0);
        this.sa_torso_2.mirror = true;
        this.sa_torso_2.setRotationPoint(2.25F, 8.0F, -2.5F);
        this.sa_torso_2.addBox(-2.0F, -8.0F, 0.0F, 4, 8, 1, 0.0F);
        this.setRotateAngle(sa_torso_2, 0.2617993877991494F, -0.5235987755982988F, -0.08726646259971647F);
        this.sa_helm_1 = new ModelRenderer(this, 0, 0);
        this.sa_helm_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sa_helm_1.addBox(-4.5F, -9.0F, -4.5F, 9, 9, 9, 0.0F);
        this.sa_torso_5 = new ModelRenderer(this, 28, 34);
        this.sa_torso_5.setRotationPoint(0.0F, 2.0F, 2.0F);
        this.sa_torso_5.addBox(-3.0F, -2.0F, -2.0F, 6, 4, 4, 0.0F);
        this.sa_shoulder_l_2 = new ModelRenderer(this, 46, 22);
        this.sa_shoulder_l_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sa_shoulder_l_2.addBox(-1.0F, -6.0F, -3.5F, 2, 6, 7, 0.0F);
        this.setRotateAngle(sa_shoulder_l_2, 0.0F, 0.0F, 1.9198621771937625F);
        this.sa_shoulder_r_1 = new ModelRenderer(this, 14, 54);
        this.sa_shoulder_r_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sa_shoulder_r_1.addBox(-4.0F, -2.5F, -3.0F, 5, 4, 6, 0.0F);
        this.sa_torso_1 = new ModelRenderer(this, 36, 0);
        this.sa_torso_1.setRotationPoint(-2.25F, 8.0F, -2.5F);
        this.sa_torso_1.addBox(-2.0F, -8.0F, 0.0F, 4, 8, 1, 0.0F);
        this.setRotateAngle(sa_torso_1, 0.2617993877991494F, 0.5235987755982988F, 0.08726646259971647F);
        this.sa_leg_r_1 = new ModelRenderer(this, 0, 0);
        this.sa_leg_r_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sa_leg_r_1.addBox(-3.0F, -2.0F, -3.0F, 3, 8, 6, 0.0F);
        this.setRotateAngle(sa_leg_r_1, 0.0F, 0.0F, 0.17453292519943295F);
        this.sa_torso = new ModelRenderer(this, 0, 41);
        this.sa_torso.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sa_torso.addBox(-4.5F, 0.0F, -2.5F, 9, 8, 5, 0.0F);
        this.sa_shoulder_l_1 = new ModelRenderer(this, 36, 53);
        this.sa_shoulder_l_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sa_shoulder_l_1.addBox(-1.0F, -2.5F, -3.0F, 6, 5, 6, 0.0F);
        this.sa_shoulder_l_3 = new ModelRenderer(this, 28, 44);
        this.sa_shoulder_l_3.setRotationPoint(1.0F, 6.0F, 0.0F);
        this.sa_shoulder_l_3.addBox(0.0F, -4.0F, -2.5F, 4, 4, 5, 0.0F);
        this.sa_leg_l_1 = new ModelRenderer(this, 0, 0);
        this.sa_leg_l_1.mirror = true;
        this.sa_leg_l_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sa_leg_l_1.addBox(0.0F, -2.0F, -3.0F, 3, 8, 6, 0.0F);
        this.setRotateAngle(sa_leg_l_1, 0.0F, 0.0F, -0.17453292519943295F);

        this.sa_leg_pivot_l = new ModelRenderer(this, 0,0);
        this.sa_leg_pivot_l.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sa_leg_pivot_l.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.sa_leg_pivot_r = new ModelRenderer(this, 0,0);
        this.sa_leg_pivot_r.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sa_leg_pivot_r.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);

        this.sa_shoulder_l_1.addChild(this.sa_shoulder_l_4);
        this.sa_torso.addChild(this.sa_torso_3);
        this.sa_shoulder_r_1.addChild(this.sa_shoulder_r_2);
        this.sa_shoulder_r_1.addChild(this.sa_shoulder_r_3);
        this.sa_helm_1.addChild(this.sa_helm_2);
        this.bipedRightLeg.addChild(this.sa_boot_r);
        this.sa_torso.addChild(this.sa_torso_4);
        this.bipedLeftLeg.addChild(this.sa_boot_l);
        this.sa_torso.addChild(this.sa_torso_2);
        this.bipedHead.addChild(this.sa_helm_1);
        this.sa_torso.addChild(this.sa_torso_5);
        this.sa_shoulder_l_1.addChild(this.sa_shoulder_l_2);
        this.bipedRightArm.addChild(this.sa_shoulder_r_1);
        this.sa_torso.addChild(this.sa_torso_1);
        this.bipedBody.addChild(this.sa_torso);
        this.bipedLeftArm.addChild(this.sa_shoulder_l_1);
        this.sa_shoulder_l_1.addChild(this.sa_shoulder_l_3);

        this.sa_leg_pivot_r.addChild(this.sa_leg_r_1);
        this.sa_leg_pivot_l.addChild(this.sa_leg_l_1);
        this.bipedRightLeg.addChild(this.sa_leg_pivot_r);
        this.bipedLeftLeg.addChild(this.sa_leg_pivot_l);
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
                        copyModelAngles(this.bipedHead, this.sa_helm_1);
                        this.sa_helm_1.render(f5);
                    }
                    else if (tArmor.renderIndex == 1)
                    {
                        copyModelAngles(this.bipedBody, this.sa_torso);
                        copyModelAngles(this.bipedRightArm, this.sa_shoulder_r_1);
                        copyModelAngles(this.bipedLeftArm, this.sa_shoulder_l_1);
                        this.sa_torso.render(f5);
                        this.sa_shoulder_r_1.render(f5);
                        this.sa_shoulder_l_1.render(f5);
                    }
                    else if (tArmor.renderIndex == 2)
                    {
                        copyModelAngles(this.bipedLeftLeg, this.sa_leg_pivot_l);
                        copyModelAngles(this.bipedRightLeg, this.sa_leg_pivot_r);
                        this.sa_leg_pivot_l.render(f5);
                        this.sa_leg_pivot_r.render(f5);
                    }
                    else if (tArmor.renderIndex == 3)
                    {
                        copyModelAngles(this.bipedLeftLeg, this.sa_boot_l);
                        copyModelAngles(this.bipedRightLeg, this.sa_boot_r);
                        this.sa_boot_r.render(f5);
                        this.sa_boot_l.render(f5);
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
                        copyModelAngles(this.bipedHead, this.sa_helm_1);
                        this.sa_helm_1.render(f5);
                    }
                    else if (tArmor.renderIndex == 1)
                    {
                        copyModelAngles(this.bipedBody, this.sa_torso);
                        copyModelAngles(this.bipedRightArm, this.sa_shoulder_r_1);
                        copyModelAngles(this.bipedLeftArm, this.sa_shoulder_l_1);
                        this.sa_torso.render(f5);
                        this.sa_shoulder_r_1.render(f5);
                        this.sa_shoulder_l_1.render(f5);
                    }
                    else if (tArmor.renderIndex == 2)
                    {
                        copyModelAngles(this.bipedLeftLeg, this.sa_leg_pivot_l);
                        copyModelAngles(this.bipedRightLeg, this.sa_leg_pivot_r);
                        this.sa_leg_pivot_l.render(f5);
                        this.sa_leg_pivot_r.render(f5);
                    }
                    else if (tArmor.renderIndex == 3)
                    {
                        copyModelAngles(this.bipedLeftLeg, this.sa_boot_l);
                        copyModelAngles(this.bipedRightLeg, this.sa_boot_r);
                        this.sa_boot_r.render(f5);
                        this.sa_boot_l.render(f5);
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
