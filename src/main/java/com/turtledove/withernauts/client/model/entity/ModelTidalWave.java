package com.turtledove.withernauts.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * ModelTidalWave - Undefined
 * Created using Tabula 7.1.0
 */
public class ModelTidalWave extends ModelBase {
    public ModelRenderer tw_2;
    public ModelRenderer tw_1;

    public ModelTidalWave() {
        this.textureWidth = 512;
        this.textureHeight = 512;
        this.tw_2 = new ModelRenderer(this, -256, 256);
        this.tw_2.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.tw_2.addBox(-128.0F, 0.0F, -128.0F, 256, 0, 256, 0.0F);
        this.tw_1 = new ModelRenderer(this, -256, 0);
        this.tw_1.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.tw_1.addBox(-128.0F, 0.0F, -128.0F, 256, 0, 256, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
        GL11.glEnable(GL11.GL_NORMALIZE);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        float deg = (entity.ticksExisted * 8.0f) % 360.0f;
        this.tw_1.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.rotate(deg, 0.0f, 1.0f, 0.0f);
        this.tw_2.render(f5);
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
