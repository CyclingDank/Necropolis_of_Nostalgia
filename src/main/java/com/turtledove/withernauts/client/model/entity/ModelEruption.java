package com.turtledove.withernauts.client.model.entity;


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * ModelOF - Undefined
 * Created using Tabula 7.1.0
 */
public class ModelEruption extends ModelBase {
    public ModelRenderer eruption_1;
    public ModelRenderer eruption_2;
    public ModelRenderer eruption_3;

    public ModelEruption() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.eruption_3 = new ModelRenderer(this, 0, 140);
        this.eruption_3.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.eruption_3.addBox(-32.0F, -20.0F, -32.0F, 64, 20, 64, 0.0F);
        this.eruption_1 = new ModelRenderer(this, 0, 0);
        this.eruption_1.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.eruption_1.addBox(-10.0F, -40.0F, -10.0F, 20, 40, 20, 0.0F);
        this.eruption_2 = new ModelRenderer(this, 0, 60);
        this.eruption_2.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.eruption_2.addBox(-25.0F, -30.0F, -25.0F, 50, 30, 50, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
        GL11.glEnable(GL11.GL_NORMALIZE);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        this.eruption_1.render(f5);
        this.eruption_2.render(f5);
        this.eruption_3.render(f5);
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
