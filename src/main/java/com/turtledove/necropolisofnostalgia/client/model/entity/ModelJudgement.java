package com.turtledove.necropolisofnostalgia.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * ModelJudgement - Undefined
 * Created using Tabula 7.1.0
 */
public class ModelJudgement extends ModelBase {
    public ModelRenderer judgement_staff;
    public ModelRenderer judgement_tip;

    public ModelJudgement() {
        this.textureWidth = 64;
        this.textureHeight = 256;
        this.judgement_tip = new ModelRenderer(this, 16, 0);
        this.judgement_tip.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.judgement_tip.addBox(-1.5F, -2.5F, -2.5F, 3, 5, 5, 0.0F);
        this.setRotateAngle(judgement_tip, 0.7853981633974483F, 0.0F, 0.0F);
        this.judgement_staff = new ModelRenderer(this, 0, 0);
        this.judgement_staff.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.judgement_staff.addBox(-1.5F, -200.0F, -1.5F, 3, 200, 3, 0.0F);
        this.judgement_staff.addChild(this.judgement_tip);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
        GL11.glEnable(GL11.GL_NORMALIZE);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        this.judgement_staff.render(f5);
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
