package com.turtledove.withernauts.client.model.entity;

import com.turtledove.withernauts.server.entity.enemies.EntityBabyNecropolisSpider;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;

/**
 * ModelSpider - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelBabySpider extends ModelBase {
    public ModelRenderer ns_sternum;
    public ModelRenderer ns_butt_2;
    public ModelRenderer ns_butt;
    public ModelRenderer ns_head;
    public ModelRenderer ns_leg_r1;
    public ModelRenderer ns_leg_r2;
    public ModelRenderer ns_leg_r3;
    public ModelRenderer ns_leg_r4;
    public ModelRenderer ns_leg_l1;
    public ModelRenderer ns_leg_l2;
    public ModelRenderer ns_leg_l3;
    public ModelRenderer ns_leg_l4;
    public ModelRenderer ns_p_r;
    public ModelRenderer ns_p_l;
    public ModelRenderer ns_fang_r;
    public ModelRenderer ns_fang_l;
    public ModelRenderer ns_q_r;
    public ModelRenderer ns_q_l;

    public ModelBabySpider() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.ns_sternum = new ModelRenderer(this, 0, 0);
        this.ns_sternum.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.ns_sternum.addBox(-2.5F, -2.0F, -3.0F, 5, 4, 6, 0.0F);
        this.ns_leg_l3 = new ModelRenderer(this, 20, 0);
        this.ns_leg_l3.mirror = true;
        this.ns_leg_l3.setRotationPoint(4.0F, 0.0F, 0.0F);
        this.ns_leg_l3.addBox(0.0F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(ns_leg_l3, 0.0F, 0.39269908169872414F, 0.5811946409141118F);
        this.ns_head = new ModelRenderer(this, 18, 4);
        this.ns_head.setRotationPoint(0.0F, -1.5F, -8.0F);
        this.ns_head.addBox(-3.5F, -3.0F, -4.5F, 7, 7, 9, 0.0F);
        this.ns_fang_l = new ModelRenderer(this, 0, 21);
        this.ns_fang_l.setRotationPoint(2.5F, 2.0F, -4.0F);
        this.ns_fang_l.addBox(-1.5F, 0.0F, -2.0F, 3, 3, 2, 0.0F);
        this.setRotateAngle(ns_fang_l, -0.2617993877991494F, 0.0F, 0.0F);
        this.ns_butt_2 = new ModelRenderer(this, 12, 50);
        this.ns_butt_2.setRotationPoint(0.0F, 19.5F, 0.0F);
        this.ns_butt_2.addBox(-3.0F, -4.0F, 0.0F, 6, 4, 8, 0.0F);
        this.setRotateAngle(ns_butt_2, -0.17453292519943295F, 0.0F, 0.0F);
        this.ns_p_l = new ModelRenderer(this, 0, 44);
        this.ns_p_l.setRotationPoint(4.0F, 0.0F, 6.0F);
        this.ns_p_l.addBox(-1.0F, -1.0F, -8.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(ns_p_l, 0.3490658503988659F, -0.22689280275926282F, 0.0F);
        this.ns_butt = new ModelRenderer(this, 0, 24);
        this.ns_butt.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.ns_butt.addBox(-5.0F, -4.0F, 0.0F, 10, 5, 10, 0.0F);
        this.setRotateAngle(ns_butt, -0.17453292519943295F, 0.0F, 0.0F);
        this.ns_leg_r2 = new ModelRenderer(this, 20, 0);
        this.ns_leg_r2.setRotationPoint(-4.0F, 0.0F, 1.0F);
        this.ns_leg_r2.addBox(-12.0F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(ns_leg_r2, 0.0F, 0.39269908169872414F, -0.5811946409141118F);
        this.ns_leg_l4 = new ModelRenderer(this, 20, 0);
        this.ns_leg_l4.mirror = true;
        this.ns_leg_l4.setRotationPoint(4.0F, 0.0F, -1.0F);
        this.ns_leg_l4.addBox(0.0F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(ns_leg_l4, 0.0F, 0.7853981633974483F, 0.7853981633974483F);
        this.ns_q_l = new ModelRenderer(this, 20, 44);
        this.ns_q_l.setRotationPoint(1.0F, 0.0F, -8.0F);
        this.ns_q_l.addBox(-2.0F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(ns_q_l, 0.0F, 0.3490658503988659F, 0.0F);
        this.ns_leg_r3 = new ModelRenderer(this, 20, 0);
        this.ns_leg_r3.setRotationPoint(-4.0F, 0.0F, 0.0F);
        this.ns_leg_r3.addBox(-12.0F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(ns_leg_r3, 0.0F, -0.37908551353316833F, -0.5811946409141118F);
        this.ns_leg_r1 = new ModelRenderer(this, 20, 0);
        this.ns_leg_r1.setRotationPoint(-4.0F, 0.0F, 2.0F);
        this.ns_leg_r1.addBox(-11.0F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(ns_leg_r1, 0.0F, 0.7853981633974483F, -0.7853981633974483F);
        this.ns_leg_l1 = new ModelRenderer(this, 20, 0);
        this.ns_leg_l1.mirror = true;
        this.ns_leg_l1.setRotationPoint(4.0F, 0.0F, 2.0F);
        this.ns_leg_l1.addBox(0.0F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(ns_leg_l1, 0.0F, -0.7853981633974483F, 0.7853981633974483F);
        this.ns_leg_l2 = new ModelRenderer(this, 20, 0);
        this.ns_leg_l2.mirror = true;
        this.ns_leg_l2.setRotationPoint(4.0F, 0.0F, 1.0F);
        this.ns_leg_l2.addBox(0.0F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(ns_leg_l2, 0.0F, -0.39269908169872414F, 0.5811946409141118F);
        this.ns_q_r = new ModelRenderer(this, 20, 44);
        this.ns_q_r.setRotationPoint(-1.0F, 0.0F, -8.0F);
        this.ns_q_r.addBox(0.0F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(ns_q_r, 0.0F, -0.3490658503988659F, 0.0F);
        this.ns_leg_r4 = new ModelRenderer(this, 20, 0);
        this.ns_leg_r4.setRotationPoint(-4.0F, 0.0F, -1.0F);
        this.ns_leg_r4.addBox(-12.0F, -1.0F, -1.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(ns_leg_r4, 0.0F, -0.7853981633974483F, -0.7853981633974483F);
        this.ns_fang_r = new ModelRenderer(this, 0, 13);
        this.ns_fang_r.setRotationPoint(-2.6F, 2.0F, -4.0F);
        this.ns_fang_r.addBox(-1.5F, 0.0F, -2.0F, 3, 3, 2, 0.0F);
        this.setRotateAngle(ns_fang_r, -0.2617993877991494F, 0.0F, 0.0F);
        this.ns_p_r = new ModelRenderer(this, 0, 44);
        this.ns_p_r.setRotationPoint(-4.0F, 0.0F, 6.0F);
        this.ns_p_r.addBox(-1.0F, -1.0F, -8.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(ns_p_r, 0.3490658503988659F, 0.22689280275926282F, 0.0F);
        this.ns_sternum.addChild(this.ns_leg_l3);
        this.ns_sternum.addChild(this.ns_head);
        this.ns_head.addChild(this.ns_fang_l);
        this.ns_head.addChild(this.ns_p_l);
        this.ns_sternum.addChild(this.ns_leg_r2);
        this.ns_sternum.addChild(this.ns_leg_l4);
        this.ns_p_l.addChild(this.ns_q_l);
        this.ns_sternum.addChild(this.ns_leg_r3);
        this.ns_sternum.addChild(this.ns_leg_r1);
        this.ns_sternum.addChild(this.ns_leg_l1);
        this.ns_sternum.addChild(this.ns_leg_l2);
        this.ns_p_r.addChild(this.ns_q_r);
        this.ns_sternum.addChild(this.ns_leg_r4);
        this.ns_head.addChild(this.ns_fang_r);
        this.ns_head.addChild(this.ns_p_r);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        setRotationAngles(f, f1, f2, f3, f4, f5, ((EntityBabyNecropolisSpider)entity));

        float fRatio = ((EntityBabyNecropolisSpider)entity).getIgniteRatio();
        fRatio = ((float)Math.sin(31.415 * fRatio) + 10.0f * fRatio) / 10.0F;

        GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
        GL11.glEnable(GL11.GL_NORMALIZE);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.ns_sternum.offsetX, this.ns_sternum.offsetY, this.ns_sternum.offsetZ);
        GlStateManager.translate(this.ns_sternum.rotationPointX * f5, this.ns_sternum.rotationPointY * f5, this.ns_sternum.rotationPointZ * f5);
        GlStateManager.scale(0.75D, 0.75D, 0.75D);
        GlStateManager.translate(-this.ns_sternum.offsetX, -this.ns_sternum.offsetY, -this.ns_sternum.offsetZ);
        GlStateManager.translate(-this.ns_sternum.rotationPointX * f5, -this.ns_sternum.rotationPointY * f5, -this.ns_sternum.rotationPointZ * f5);
        this.ns_sternum.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.ns_butt_2.offsetX, this.ns_butt_2.offsetY, this.ns_butt_2.offsetZ);
        GlStateManager.translate(this.ns_butt_2.rotationPointX * f5, this.ns_butt_2.rotationPointY * f5, this.ns_butt_2.rotationPointZ * f5);
        GlStateManager.scale(0.75D + fRatio / 2.0D, 0.75D + fRatio / 2.0D, 0.75D + fRatio / 2.0D);
        GlStateManager.translate(-this.ns_butt_2.offsetX, -this.ns_butt_2.offsetY, -this.ns_butt_2.offsetZ);
        GlStateManager.translate(-this.ns_butt_2.rotationPointX * f5, -this.ns_butt_2.rotationPointY * f5, -this.ns_butt_2.rotationPointZ * f5);
        this.ns_butt_2.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.ns_butt.offsetX, this.ns_butt.offsetY, this.ns_butt.offsetZ);
        GlStateManager.translate(this.ns_butt.rotationPointX * f5, this.ns_butt.rotationPointY * f5, this.ns_butt.rotationPointZ * f5);
        GlStateManager.scale(0.75D + fRatio / 2.0D, 0.75D + fRatio / 2.0D, 0.75D + fRatio / 2.0D);
        GlStateManager.translate(-this.ns_butt.offsetX, -this.ns_butt.offsetY, -this.ns_butt.offsetZ);
        GlStateManager.translate(-this.ns_butt.rotationPointX * f5, -this.ns_butt.rotationPointY * f5, -this.ns_butt.rotationPointZ * f5);
        this.ns_butt.render(f5);
        GlStateManager.popMatrix();
        GL11.glPopAttrib();

    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, EntityBabyNecropolisSpider entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        this.ns_head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.ns_head.rotateAngleX = headPitch * 0.017453292F;
        float f = ((float)Math.PI / 4F);
        this.ns_leg_r1.rotateAngleZ = -((float)Math.PI / 4F);
        this.ns_leg_l1.rotateAngleZ = ((float)Math.PI / 4F);
        this.ns_leg_r2.rotateAngleZ = -0.58119464F;
        this.ns_leg_l2.rotateAngleZ = 0.58119464F;
        this.ns_leg_r3.rotateAngleZ = -0.58119464F;
        this.ns_leg_l3.rotateAngleZ = 0.58119464F;
        this.ns_leg_r4.rotateAngleZ = -((float)Math.PI / 4F);
        this.ns_leg_l4.rotateAngleZ = ((float)Math.PI / 4F);
        float f1 = -0.0F;
        float f2 = 0.3926991F;
        this.ns_leg_r1.rotateAngleY = ((float)Math.PI / 4F);
        this.ns_leg_l1.rotateAngleY = -((float)Math.PI / 4F);
        this.ns_leg_r2.rotateAngleY = 0.3926991F;
        this.ns_leg_l2.rotateAngleY = -0.3926991F;
        this.ns_leg_r3.rotateAngleY = -0.3926991F;
        this.ns_leg_l3.rotateAngleY = 0.3926991F;
        this.ns_leg_r4.rotateAngleY = -((float)Math.PI / 4F);
        this.ns_leg_l4.rotateAngleY = ((float)Math.PI / 4F);
        float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
        float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
        this.ns_leg_r1.rotateAngleY += f3;
        this.ns_leg_l1.rotateAngleY += -f3;
        this.ns_leg_r2.rotateAngleY += f4;
        this.ns_leg_l2.rotateAngleY += -f4;
        this.ns_leg_r3.rotateAngleY += f5;
        this.ns_leg_l3.rotateAngleY += -f5;
        this.ns_leg_r4.rotateAngleY += f6;
        this.ns_leg_l4.rotateAngleY += -f6;
        this.ns_leg_r1.rotateAngleZ += f7;
        this.ns_leg_l1.rotateAngleZ += -f7;
        this.ns_leg_r2.rotateAngleZ += f8;
        this.ns_leg_l2.rotateAngleZ += -f8;
        this.ns_leg_r3.rotateAngleZ += f9;
        this.ns_leg_l3.rotateAngleZ += -f9;
        this.ns_leg_r4.rotateAngleZ += f10;
        this.ns_leg_l4.rotateAngleZ += -f10;
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
