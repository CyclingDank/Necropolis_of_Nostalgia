package com.turtledove.withernauts.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * DemonFang - Undefined
 * Created using Tabula 7.1.0
 */
public class ModelDemonFang extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape1_1;

    public ModelDemonFang() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape1 = new ModelRenderer(this, -16, 0);
        this.shape1.setRotationPoint(-3.25F, 16.0F, 0.0F);
        this.shape1.addBox(-8.0F, 0.0F, -8.0F, 16, 0, 16, 0.0F);
        this.setRotateAngle(shape1, 1.5707963267948966F, 1.1344640137963142F, 0.0F);
        this.shape1_1 = new ModelRenderer(this, 0, 16);
        this.shape1_1.setRotationPoint(3.35F, 16.0F, 0.0F);
        this.shape1_1.addBox(-8.0F, 0.0F, -8.0F, 16, 0, 16, 0.0F);
        this.setRotateAngle(shape1_1, 1.5707963267948966F, -1.1344640137963142F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape1.render(f5);
        this.shape1_1.render(f5);
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
