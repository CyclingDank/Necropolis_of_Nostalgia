package com.turtledove.necropolisofnostalgia.client.model.entity.player.bastille_plate;

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
public class ModelBastillePlate extends ModelBiped {
    public ModelRenderer bp_shoulder_r_1;
    public ModelRenderer bp_shoulder_r_2;
    public ModelRenderer bp_shoulder_r_3;
    public ModelRenderer bp_leg_r_1;
    public ModelRenderer bp_boot_r;
    public ModelRenderer bp_leg_r_2;
    public ModelRenderer bp_helm_1;
    public ModelRenderer bp_helm_2;
    public ModelRenderer bp_helm_3;
    public ModelRenderer bp_torso;
    public ModelRenderer bp_torso_1;
    public ModelRenderer bp_torso_2;
    public ModelRenderer bp_torso_3;
    public ModelRenderer bp_torso_6;
    public ModelRenderer bp_torso_7;
    public ModelRenderer bp_torso_8;
    public ModelRenderer bp_shoulder_l_1;
    public ModelRenderer bp_shoulder_l_2;
    public ModelRenderer bp_shoulder_l_3;
    public ModelRenderer bp_leg_l_1;
    public ModelRenderer bp_boot_l;
    public ModelRenderer bp_leg_l_2;

    public ModelBastillePlate() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bp_boot_r = new ModelRenderer(this, 20, 0);
        this.bp_boot_r.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bp_boot_r.addBox(-2.5F, 7.0F, -2.5F, 5, 5, 5, 0.0F);
        this.bp_torso = new ModelRenderer(this, 0, 16);
        this.bp_torso.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bp_torso.addBox(-4.5F, 0.0F, -2.5F, 9, 12, 5, 0.0F);
        this.bp_shoulder_l_3 = new ModelRenderer(this, 47, 53);
        this.bp_shoulder_l_3.mirror = true;
        this.bp_shoulder_l_3.setRotationPoint(3.0F, 8.0F, 0.0F);
        this.bp_shoulder_l_3.addBox(-2.0F, -6.0F, -2.5F, 2, 6, 5, 0.0F);
        this.setRotateAngle(bp_shoulder_l_3, 0.0F, 0.0F, 0.22689280275926282F);
        this.bp_leg_l_1 = new ModelRenderer(this, 0, 0);
        this.bp_leg_l_1.mirror = true;
        this.bp_leg_l_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bp_leg_l_1.addBox(-2.5F, 0.0F, -2.5F, 5, 5, 5, 0.0F);
        this.bp_shoulder_r_3 = new ModelRenderer(this, 47, 53);
        this.bp_shoulder_r_3.setRotationPoint(-3.0F, 8.0F, 0.0F);
        this.bp_shoulder_r_3.addBox(0.0F, -6.0F, -2.5F, 2, 6, 5, 0.0F);
        this.setRotateAngle(bp_shoulder_r_3, 0.0F, 0.0F, -0.22689280275926282F);
        this.bp_shoulder_r_1 = new ModelRenderer(this, 21, 52);
        this.bp_shoulder_r_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bp_shoulder_r_1.addBox(-5.0F, -4.0F, -3.5F, 6, 5, 7, 0.0F);
        this.bp_shoulder_l_2 = new ModelRenderer(this, 0, 43);
        this.bp_shoulder_l_2.mirror = true;
        this.bp_shoulder_l_2.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.bp_shoulder_l_2.addBox(-1.5F, -6.0F, -4.0F, 6, 6, 8, 0.0F);
        this.setRotateAngle(bp_shoulder_l_2, 0.0F, 0.0F, 0.6373942428283291F);
        this.bp_torso_6 = new ModelRenderer(this, 28, 16);
        this.bp_torso_6.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.bp_torso_6.addBox(-2.5F, 0.0F, -3.0F, 5, 5, 6, 0.0F);
        this.bp_helm_2 = new ModelRenderer(this, 0, 33);
        this.bp_helm_2.setRotationPoint(0.0F, -4.0F, -2.0F);
        this.bp_helm_2.addBox(-5.0F, -4.0F, -3.0F, 10, 4, 6, 0.0F);
        this.setRotateAngle(bp_helm_2, 1.48352986419518F, 0.0F, 0.0F);
        this.bp_torso_7 = new ModelRenderer(this, 28, 46);
        this.bp_torso_7.setRotationPoint(0.0F, 1.25F, -3.0F);
        this.bp_torso_7.addBox(-3.5F, -2.0F, -2.0F, 7, 3, 2, 0.0F);
        this.setRotateAngle(bp_torso_7, 0.5009094953223726F, 0.0F, 0.0F);
        this.bp_helm_1 = new ModelRenderer(this, 0, 0);
        this.bp_helm_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bp_helm_1.addBox(-4.5F, -9.0F, -4.5F, 9, 7, 9, 0.0F);
        this.bp_helm_3 = new ModelRenderer(this, 0, 60);
        this.bp_helm_3.setRotationPoint(0.0F, -9.0F, 0.0F);
        this.bp_helm_3.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
        this.bp_torso_3 = new ModelRenderer(this, 46, 0);
        this.bp_torso_3.setRotationPoint(0.0F, 8.0F, -3.1F);
        this.bp_torso_3.addBox(-1.0F, -8.0F, -0.5F, 2, 11, 1, 0.0F);
        this.setRotateAngle(bp_torso_3, 0.22689280275926282F, 0.0F, 0.0F);
        this.bp_leg_r_1 = new ModelRenderer(this, 0, 0);
        this.bp_leg_r_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bp_leg_r_1.addBox(-2.5F, 0.0F, -2.5F, 5, 5, 5, 0.0F);
        this.bp_torso_1 = new ModelRenderer(this, 36, 0);
        this.bp_torso_1.setRotationPoint(-2.25F, 8.0F, -2.5F);
        this.bp_torso_1.addBox(-2.0F, -8.0F, 0.0F, 4, 11, 1, 0.0F);
        this.setRotateAngle(bp_torso_1, 0.2617993877991494F, 0.5235987755982988F, 0.08726646259971647F);
        this.bp_leg_r_2 = new ModelRenderer(this, 0, 10);
        this.bp_leg_r_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bp_leg_r_2.addBox(-3.0F, -2.0F, -3.5F, 3, 8, 7, 0.0F);
        this.setRotateAngle(bp_leg_r_2, 0.0F, 0.0F, 0.2617993877991494F);
        this.bp_boot_l = new ModelRenderer(this, 20, 0);
        this.bp_boot_l.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bp_boot_l.addBox(-2.5F, 7.0F, -2.5F, 5, 5, 5, 0.0F);
        this.bp_torso_8 = new ModelRenderer(this, 32, 31);
        this.bp_torso_8.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.bp_torso_8.addBox(-4.5F, -3.0F, -3.0F, 9, 6, 6, 0.0F);
        this.setRotateAngle(bp_torso_8, 0.7853981633974483F, 0.0F, 0.0F);
        this.bp_shoulder_l_1 = new ModelRenderer(this, 21, 52);
        this.bp_shoulder_l_1.mirror = true;
        this.bp_shoulder_l_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bp_shoulder_l_1.addBox(-1.0F, -4.0F, -3.5F, 6, 5, 7, 0.0F);
        this.bp_leg_l_2 = new ModelRenderer(this, 0, 10);
        this.bp_leg_l_2.mirror = true;
        this.bp_leg_l_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bp_leg_l_2.addBox(0.0F, -2.0F, -3.5F, 3, 8, 7, 0.0F);
        this.setRotateAngle(bp_leg_l_2, 0.0F, 0.0F, -0.2617993877991494F);
        this.bp_torso_2 = new ModelRenderer(this, 36, 0);
        this.bp_torso_2.mirror = true;
        this.bp_torso_2.setRotationPoint(2.25F, 8.0F, -2.5F);
        this.bp_torso_2.addBox(-2.0F, -8.0F, 0.0F, 4, 11, 1, 0.0F);
        this.setRotateAngle(bp_torso_2, 0.2617993877991494F, -0.5235987755982988F, -0.08726646259971647F);
        this.bp_shoulder_r_2 = new ModelRenderer(this, 0, 43);
        this.bp_shoulder_r_2.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.bp_shoulder_r_2.addBox(-4.5F, -6.0F, -4.0F, 6, 6, 8, 0.0F);
        this.setRotateAngle(bp_shoulder_r_2, 0.0F, 0.0F, -0.6373942428283291F);

        this.bp_shoulder_l_1.addChild(this.bp_shoulder_l_3);
        this.bp_shoulder_r_1.addChild(this.bp_shoulder_r_3);
        this.bp_shoulder_l_1.addChild(this.bp_shoulder_l_2);
        this.bp_torso.addChild(this.bp_torso_6);
        this.bp_helm_1.addChild(this.bp_helm_2);
        this.bp_torso.addChild(this.bp_torso_7);
        this.bp_helm_1.addChild(this.bp_helm_3);
        this.bp_torso.addChild(this.bp_torso_3);
        this.bp_torso.addChild(this.bp_torso_1);
        this.bp_leg_r_1.addChild(this.bp_leg_r_2);
        this.bp_torso.addChild(this.bp_torso_8);
        this.bp_leg_l_1.addChild(this.bp_leg_l_2);
        this.bp_torso.addChild(this.bp_torso_2);
        this.bp_shoulder_r_1.addChild(this.bp_shoulder_r_2);

        this.bipedHead.addChild(this.bp_helm_1);
        this.bipedRightArm.addChild(this.bp_shoulder_r_1);
        this.bipedLeftArm.addChild(this.bp_shoulder_l_1);
        this.bipedLeftLeg.addChild(this.bp_boot_l);
        this.bipedRightLeg.addChild(this.bp_boot_r);
        this.bipedRightLeg.addChild(this.bp_leg_r_1);
        this.bipedLeftLeg.addChild(this.bp_leg_l_1);
        this.bipedBody.addChild(this.bp_torso);
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
                        copyModelAngles(this.bipedHead, this.bp_helm_1);
                        this.bp_helm_1.render(f5);
                    }
                    else if (tArmor.renderIndex == 1)
                    {
                        copyModelAngles(this.bipedBody, this.bp_torso);
                        copyModelAngles(this.bipedRightArm, this.bp_shoulder_r_1);
                        copyModelAngles(this.bipedLeftArm, this.bp_shoulder_l_1);
                        this.bp_torso.render(f5);
                        this.bp_shoulder_r_1.render(f5);
                        this.bp_shoulder_l_1.render(f5);
                    }
                    else if (tArmor.renderIndex == 2)
                    {
                        copyModelAngles(this.bipedLeftLeg, this.bp_leg_l_1);
                        copyModelAngles(this.bipedRightLeg, this.bp_leg_r_1);
                        this.bp_leg_l_1.render(f5);
                        this.bp_leg_r_1.render(f5);
                    }
                    else if (tArmor.renderIndex == 3)
                    {
                        copyModelAngles(this.bipedLeftLeg, this.bp_boot_l);
                        copyModelAngles(this.bipedRightLeg, this.bp_boot_r);
                        this.bp_boot_r.render(f5);
                        this.bp_boot_l.render(f5);
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
                        copyModelAngles(this.bipedHead, this.bp_helm_1);
                        this.bp_helm_1.render(f5);
                    }
                    else if (tArmor.renderIndex == 1)
                    {
                        copyModelAngles(this.bipedBody, this.bp_torso);
                        copyModelAngles(this.bipedRightArm, this.bp_shoulder_r_1);
                        copyModelAngles(this.bipedLeftArm, this.bp_shoulder_l_1);
                        this.bp_torso.render(f5);
                        this.bp_shoulder_r_1.render(f5);
                        this.bp_shoulder_l_1.render(f5);
                    }
                    else if (tArmor.renderIndex == 2)
                    {
                        copyModelAngles(this.bipedLeftLeg, this.bp_leg_l_1);
                        copyModelAngles(this.bipedRightLeg, this.bp_leg_r_1);
                        this.bp_leg_l_1.render(f5);
                        this.bp_leg_r_1.render(f5);
                    }
                    else if (tArmor.renderIndex == 3)
                    {
                        copyModelAngles(this.bipedLeftLeg, this.bp_boot_l);
                        copyModelAngles(this.bipedRightLeg, this.bp_boot_r);
                        this.bp_boot_r.render(f5);
                        this.bp_boot_l.render(f5);
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
