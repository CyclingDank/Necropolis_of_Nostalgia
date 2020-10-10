package com.turtledove.necropolisofnostalgia.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * ModelMeteor - ddfdf
 * Created using Tabula 7.1.0
 */
public class ModelMeteor extends ModelBase {
    public ModelRenderer ms_2;
    public ModelRenderer ms_1;

    public ModelMeteor() {
        this.textureWidth = 80;
        this.textureHeight = 80;
        this.ms_1 = new ModelRenderer(this, 0, 0);
        this.ms_1.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.ms_1.addBox(-8.0F, -16.0F, -8.0F, 16, 16, 16, 0.0F);
        this.ms_2 = new ModelRenderer(this, 0, 32);
        this.ms_2.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.ms_2.addBox(-9.0F, -30.0F, -9.0F, 18, 30, 18, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
        GL11.glEnable(GL11.GL_NORMALIZE);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        this.ms_1.render(f5);
        this.ms_2.render(f5);
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
