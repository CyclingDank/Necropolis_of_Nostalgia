package com.turtledove.necropolisofnostalgia.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

/**
 * ModelPB - Undefined
 * Created using Tabula 7.1.0
 */
public class ModelPB extends ModelBase {
    public ModelRenderer pb_1;
    public ModelRenderer pb_2;
    public ModelRenderer pb_3;

    public ModelPB() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.pb_2 = new ModelRenderer(this, 0, 26);
        this.pb_2.setRotationPoint(0.0F, 39.5F, 0.0F);
        this.pb_2.addBox(-5.0F, -14.0F, -5.0F, 10, 14, 10, 0.0F);
        this.pb_3 = new ModelRenderer(this, 0, 50);
        this.pb_3.setRotationPoint(0.0F, 39.5F, 0.0F);
        this.pb_3.addBox(-3.5F, -6.0F, -3.5F, 7, 6, 7, 0.0F);
        this.pb_1 = new ModelRenderer(this, 0, 0);
        this.pb_1.setRotationPoint(0.0F, 39.5F, 0.0F);
        this.pb_1.addBox(-5.5F, -15.0F, -5.5F, 11, 15, 11, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        if (entity.ticksExisted < 2)
        {
            float h = -15.5f * (entity.ticksExisted + 1.0f) / 2.0f;
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, h / 16.0f, 0.0f);
            this.pb_1.render(f5);
            GlStateManager.popMatrix();
        }
        else if (entity.ticksExisted < 4)
        {
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, -15.5f / 16.0f, 0.0f);
            this.pb_1.render(f5);
            GlStateManager.popMatrix();

            float h = -16.5f - (14.0f * (entity.ticksExisted + 1.0f - 2.0f) / 2.0f);
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, h / 16.0f, 0.0f);
            this.pb_2.render(f5);
            GlStateManager.popMatrix();
        }
        else if (entity.ticksExisted < 6)
        {
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, -15.5f / 16.0f, 0.0f);
            this.pb_1.render(f5);
            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, -30.5f / 16.0f, 0.0f);
            this.pb_2.render(f5);
            GlStateManager.popMatrix();

            float h = -38.5f - (6.0f * (entity.ticksExisted + 1.0f - 4.0f) / 2.0f);
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, h / 16.0f, 0.0f);
            this.pb_3.render(f5);
            GlStateManager.popMatrix();
        }
        else
        {
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, -15.5f / 16.0f, 0.0f);
            this.pb_1.render(f5);
            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, -30.5f / 16.0f, 0.0f);
            this.pb_2.render(f5);
            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, -44.5f / 16.0f, 0.0f);
            this.pb_3.render(f5);
            GlStateManager.popMatrix();
        }
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
