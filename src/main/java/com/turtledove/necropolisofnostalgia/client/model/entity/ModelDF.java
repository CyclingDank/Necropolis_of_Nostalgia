package com.turtledove.necropolisofnostalgia.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * ModelDF - dfdf
 * Created using Tabula 7.1.0
 */
public class ModelDF extends ModelBase {
    public ModelRenderer df_1;

    public ModelDF() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.df_1 = new ModelRenderer(this, -64, 0);
        this.df_1.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.df_1.addBox(-32.0F, 0.0F, -32.0F, 64, 0, 64, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
        GL11.glEnable(GL11.GL_NORMALIZE);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        this.df_1.render(f5);
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
