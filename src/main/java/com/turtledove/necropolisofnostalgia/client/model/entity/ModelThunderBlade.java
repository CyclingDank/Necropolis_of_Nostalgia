package com.turtledove.necropolisofnostalgia.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * ModelThunderBlade - Undefined
 * Created using Tabula 7.1.0
 */
public class ModelThunderBlade extends ModelBase {
    public ModelRenderer tb_base_2;
    public ModelRenderer tb_sword_1;
    public ModelRenderer tb_base_1;
    public ModelRenderer tb_sword_2;
    public ModelRenderer tb_sword_3;
    public ModelRenderer tb_sword_5;
    public ModelRenderer tb_sword_4;

    public ModelThunderBlade() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.tb_sword_5 = new ModelRenderer(this, 44, 0);
        this.tb_sword_5.setRotationPoint(0.0F, -29.0F, 0.0F);
        this.tb_sword_5.addBox(-6.0F, -9.0F, 0.0F, 12, 9, 0, 0.0F);
        this.tb_base_2 = new ModelRenderer(this, -128, 128);
        this.tb_base_2.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.tb_base_2.addBox(-64.0F, 0.0F, -64.0F, 128, 0, 128, 0.0F);
        this.tb_sword_4 = new ModelRenderer(this, 32, 0);
        this.tb_sword_4.setRotationPoint(0.0F, -14.0F, 0.0F);
        this.tb_sword_4.addBox(-1.5F, -3.0F, -1.5F, 3, 3, 3, 0.0F);
        this.tb_sword_1 = new ModelRenderer(this, 0, 0);
        this.tb_sword_1.setRotationPoint(0.0F, -38.0F, 0.0F);
        this.tb_sword_1.addBox(-1.5F, -32.0F, -0.5F, 3, 32, 1, 0.0F);
        this.tb_base_1 = new ModelRenderer(this, 4, 0);
        this.tb_base_1.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.tb_base_1.addBox(-32.0F, 0.0F, -32.0F, 64, 0, 64, 0.0F);
        this.tb_sword_3 = new ModelRenderer(this, 24, 0);
        this.tb_sword_3.setRotationPoint(0.0F, -37.0F, 0.0F);
        this.tb_sword_3.addBox(-1.0F, -14.0F, -1.0F, 2, 14, 2, 0.0F);
        this.tb_sword_2 = new ModelRenderer(this, 8, 0);
        this.tb_sword_2.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.tb_sword_2.addBox(-3.0F, -38.0F, -1.0F, 6, 38, 2, 0.0F);
        this.tb_sword_2.addChild(this.tb_sword_5);
        this.tb_sword_3.addChild(this.tb_sword_4);
        this.tb_sword_2.addChild(this.tb_sword_3);
        this.tb_sword_1.addChild(this.tb_sword_2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
        GL11.glEnable(GL11.GL_NORMALIZE);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        if (entity.ticksExisted > 5 && entity.ticksExisted < 8)
        {
            this.tb_base_2.render(f5);
        }
        else if (entity.ticksExisted > 3 && entity.ticksExisted <= 5)
        {
            this.tb_base_1.render(f5);
        }
        float h = 0.0f;
        if (entity.ticksExisted > 3)
        {
            h = 4.0f;
        }
        else
        {
            h = Math.min(1.0f, (entity.ticksExisted - 5.0f) / 3.0f);
        }
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0f, h, 0.0f);
        this.tb_sword_1.render(f5);
        GlStateManager.popMatrix();
        GL11.glPopAttrib();
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
