package com.turtledove.withernauts.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * CastingCircle - Undefined
 * Created using Tabula 7.1.0
 */
public class ModelCastingCircle extends ModelBase
{
    public ModelRenderer casthalf_center;
    public ModelRenderer casthalf_center_left;
    public ModelRenderer casthalf_top_left;
    public ModelRenderer casthalf_top_center;
    public ModelRenderer casthalf_bottom_left;
    public ModelRenderer casthalf_bottom_center;
    public ModelRenderer casthalf_top_right;
    public ModelRenderer casthalf_center_right;
    public ModelRenderer casthalf_bottom_right;

    public ModelCastingCircle() {
        this.textureWidth = 96;
        this.textureHeight = 48;
        this.casthalf_top_center = new ModelRenderer(this, 16, 0);
        this.casthalf_top_center.setRotationPoint(16.0F, 24.0F, 0.0F);
        this.casthalf_top_center.addBox(-8.0F, 0.0F, -8.0F, 16, 0, 16, 0.0F);
        this.setRotateAngle(casthalf_top_center, 0.0F, 1.5707963267948966F, 0.0F);
        this.casthalf_bottom_left = new ModelRenderer(this, -16, 32);
        this.casthalf_bottom_left.setRotationPoint(-16.0F, 24.0F, 16.0F);
        this.casthalf_bottom_left.addBox(-8.0F, 0.0F, -8.0F, 16, 0, 16, 0.0F);
        this.setRotateAngle(casthalf_bottom_left, 0.0F, 1.5707963267948966F, 0.0F);
        this.casthalf_top_left = new ModelRenderer(this, -16, 0);
        this.casthalf_top_left.setRotationPoint(16.0F, 24.0F, 16.0F);
        this.casthalf_top_left.addBox(-8.0F, 0.0F, -8.0F, 16, 0, 16, 0.0F);
        this.setRotateAngle(casthalf_top_left, 0.0F, 1.5707963267948966F, 0.0F);
        this.casthalf_center_left = new ModelRenderer(this, -16, 16);
        this.casthalf_center_left.setRotationPoint(0.0F, 24.0F, 16.0F);
        this.casthalf_center_left.addBox(-8.0F, 0.0F, -8.0F, 16, 0, 16, 0.0F);
        this.setRotateAngle(casthalf_center_left, 0.0F, 1.5707963267948966F, 0.0F);
        this.casthalf_center_right = new ModelRenderer(this, 48, 16);
        this.casthalf_center_right.setRotationPoint(-8.0F, 24.0F, -8.0F);
        this.casthalf_center_right.addBox(0.0F, 0.0F, 0.0F, 16, 0, 16, 0.0F);
        this.setRotateAngle(casthalf_center_right, 0.0F, 1.5707963267948966F, 0.0F);
        this.casthalf_center = new ModelRenderer(this, 16, 16);
        this.casthalf_center.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.casthalf_center.addBox(-8.0F, 0.0F, -8.0F, 16, 0, 16, 0.0F);
        this.setRotateAngle(casthalf_center, 0.0F, -1.5707963267948966F, 0.0F);
        this.casthalf_bottom_center = new ModelRenderer(this, 16, 32);
        this.casthalf_bottom_center.setRotationPoint(-16.0F, 24.0F, 0.0F);
        this.casthalf_bottom_center.addBox(-8.0F, 0.0F, -8.0F, 16, 0, 16, 0.0F);
        this.setRotateAngle(casthalf_bottom_center, 0.0F, 1.5707963267948966F, 0.0F);
        this.casthalf_bottom_right = new ModelRenderer(this, 48, 32);
        this.casthalf_bottom_right.setRotationPoint(-16.0F, 24.0F, -16.0F);
        this.casthalf_bottom_right.addBox(-8.0F, 0.0F, -8.0F, 16, 0, 16, 0.0F);
        this.setRotateAngle(casthalf_bottom_right, 0.0F, 1.5707963267948966F, 0.0F);
        this.casthalf_top_right = new ModelRenderer(this, 48, 0);
        this.casthalf_top_right.setRotationPoint(16.0F, 24.0F, -16.0F);
        this.casthalf_top_right.addBox(-8.0F, 0.0F, -8.0F, 16, 0, 16, 0.0F);
        this.setRotateAngle(casthalf_top_right, 0.0F, 1.5707963267948966F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
        GL11.glEnable(GL11.GL_NORMALIZE);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        this.casthalf_top_center.render(f5);
        this.casthalf_bottom_left.render(f5);
        this.casthalf_top_left.render(f5);
        this.casthalf_center_left.render(f5);
        this.casthalf_center_right.render(f5);
        this.casthalf_center.render(f5);
        this.casthalf_bottom_center.render(f5);
        this.casthalf_bottom_right.render(f5);
        this.casthalf_top_right.render(f5);
        GL11.glPopAttrib();

    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
