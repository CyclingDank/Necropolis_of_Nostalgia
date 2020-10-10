package com.turtledove.necropolisofnostalgia.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * Beast - Undefined
 * Created using Tabula 7.1.0
 */
public class ModelBeast extends ModelBase {
    public ModelRenderer beast_face;
    public ModelRenderer beast_snout;
    public ModelRenderer beast_lip_1;
    public ModelRenderer beast_lip_2;
    public ModelRenderer beast_jaw;
    public ModelRenderer beast_ear_1;
    public ModelRenderer beast_ear_2;
    public ModelRenderer beast_mane;

    public ModelBeast() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.beast_snout = new ModelRenderer(this, 0, 43);
        this.beast_snout.setRotationPoint(0.0F, 14.0F, -10.3F);
        this.beast_snout.addBox(-2.0F, -3.0F, -3.0F, 4, 3, 6, 0.0F);
        this.setRotateAngle(beast_snout, 0.045553093477052F, 0.0F, 0.0F);
        this.beast_lip_2 = new ModelRenderer(this, 24, 52);
        this.beast_lip_2.setRotationPoint(2.0F, 14.0F, -11.0F);
        this.beast_lip_2.addBox(-2.0F, -2.0F, -3.0F, 4, 4, 8, 0.0F);
        this.setRotateAngle(beast_lip_2, -0.17453292519943295F, 0.0F, 0.17453292519943295F);
        this.beast_lip_1 = new ModelRenderer(this, 0, 52);
        this.beast_lip_1.setRotationPoint(-2.0F, 14.0F, -11.0F);
        this.beast_lip_1.addBox(-2.0F, -2.0F, -3.0F, 4, 4, 8, 0.0F);
        this.setRotateAngle(beast_lip_1, -0.17453292519943295F, 0.0F, -0.17453292519943295F);
        this.beast_face = new ModelRenderer(this, 0, 0);
        this.beast_face.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.beast_face.addBox(-5.0F, -6.0F, -8.0F, 10, 11, 8, 0.0F);
        this.beast_ear_2 = new ModelRenderer(this, 0, 5);
        this.beast_ear_2.setRotationPoint(-3.0F, 10.0F, -3.0F);
        this.beast_ear_2.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 1, 0.0F);
        this.beast_mane = new ModelRenderer(this, 0, 19);
        this.beast_mane.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.beast_mane.addBox(-8.0F, -8.0F, -4.0F, 16, 16, 8, 0.0F);
        this.setRotateAngle(beast_mane, -0.18203784098300857F, 0.0F, 0.0F);
        this.beast_jaw = new ModelRenderer(this, 36, 8);
        this.beast_jaw.setRotationPoint(0.0F, 20.0F, -8.8F);
        this.beast_jaw.addBox(-2.5F, -2.0F, -4.0F, 5, 3, 8, 0.0F);
        this.setRotateAngle(beast_jaw, 0.5235987755982988F, 0.0F, 0.0F);
        this.beast_ear_1 = new ModelRenderer(this, 0, 0);
        this.beast_ear_1.setRotationPoint(3.0F, 10.0F, -3.0F);
        this.beast_ear_1.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        if (entity.ticksExisted > 4)
        {
            GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
            GL11.glEnable(GL11.GL_NORMALIZE);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            this.beast_snout.render(f5);
            this.beast_lip_2.render(f5);
            this.beast_lip_1.render(f5);
            this.beast_face.render(f5);
            this.beast_ear_2.render(f5);
            this.beast_mane.render(f5);
            this.beast_jaw.render(f5);
            this.beast_ear_1.render(f5);
            GL11.glPopAttrib();
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
