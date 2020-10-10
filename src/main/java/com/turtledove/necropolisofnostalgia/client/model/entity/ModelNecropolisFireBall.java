package com.turtledove.necropolisofnostalgia.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * ModelFireBall - Undefined
 * Created using Tabula 7.1.0
 */
public class ModelNecropolisFireBall extends ModelBase {
    public ModelRenderer fb_outter;
    public ModelRenderer fb_inner;

    public ModelNecropolisFireBall() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.fb_inner = new ModelRenderer(this, 0, 16);
        this.fb_inner.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.fb_inner.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
        this.fb_outter = new ModelRenderer(this, 0, 0);
        this.fb_outter.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.fb_outter.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
        GL11.glEnable(GL11.GL_NORMALIZE);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        this.fb_inner.render(f5);
        this.fb_outter.render(f5);
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
