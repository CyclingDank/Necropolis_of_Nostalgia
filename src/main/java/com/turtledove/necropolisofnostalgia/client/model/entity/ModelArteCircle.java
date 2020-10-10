package com.turtledove.necropolisofnostalgia.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelArteCircle - Undefined
 * Created using Tabula 7.1.0
 */
public class ModelArteCircle extends ModelBase {
    public ModelRenderer arte_circle_center;
    public ModelRenderer arte_circle_r;
    public ModelRenderer arte_circle_l;
    public ModelRenderer arte_circle_ll;
    public ModelRenderer arte_circle_rr;
    public ModelRenderer arte_circle_center_top1;
    public ModelRenderer arte_circle_center_top2;
    public ModelRenderer arte_circle_center_bottom1;
    public ModelRenderer arte_circle_center_bottom2;
    public ModelRenderer arte_circle_r_top1;
    public ModelRenderer arte_circle_r_top2;
    public ModelRenderer arte_circle_r_bottom1;
    public ModelRenderer arte_circle_r_bottom2;
    public ModelRenderer arte_circle_l_top1;
    public ModelRenderer arte_circle_l_top2;
    public ModelRenderer arte_circle_l_bottom1;
    public ModelRenderer arte_circle_l_bottom2;
    public ModelRenderer arte_circle_ll_top1;
    public ModelRenderer arte_circle_ll_top2;
    public ModelRenderer arte_circle_ll_bottom1;
    public ModelRenderer arte_circle_ll_bottom2;
    public ModelRenderer arte_circle_rr_top1;
    public ModelRenderer arte_circle_rr_top2;
    public ModelRenderer arte_circle_rr_bottom1;
    public ModelRenderer arte_circle_rr_bottom2;

    public ModelArteCircle() {
        this.textureWidth = 192;
        this.textureHeight = 192;
        this.arte_circle_rr_top1 = new ModelRenderer(this, 112, 16);
        this.arte_circle_rr_top1.setRotationPoint(-8.0F, 0.0F, 8.0F);
        this.arte_circle_rr_top1.addBox(0.0F, 0.0F, 0.0F, 16, 0, 16, 0.0F);
        this.arte_circle_r = new ModelRenderer(this, 80, 32);
        this.arte_circle_r.setRotationPoint(0.0F, 23.8F, -16.0F);
        this.arte_circle_r.addBox(-8.0F, 0.0F, -8.0F, 16, 0, 16, 0.0F);
        this.setRotateAngle(arte_circle_r, 0.0F, 1.5707963267948966F, 0.0F);
        this.arte_circle_l = new ModelRenderer(this, 16, 32);
        this.arte_circle_l.setRotationPoint(0.0F, 23.8F, 16.0F);
        this.arte_circle_l.addBox(-8.0F, 0.0F, -8.0F, 16, 0, 16, 0.0F);
        this.setRotateAngle(arte_circle_l, 0.0F, 1.5707963267948966F, 0.0F);
        this.arte_circle_r_bottom2 = new ModelRenderer(this, 80, 64);
        this.arte_circle_r_bottom2.setRotationPoint(-8.0F, 0.0F, -40.0F);
        this.arte_circle_r_bottom2.addBox(0.0F, 0.0F, 0.0F, 16, 0, 16, 0.0F);
        this.arte_circle_ll_top2 = new ModelRenderer(this, -16, 0);
        this.arte_circle_ll_top2.setRotationPoint(-8.0F, 0.0F, 24.0F);
        this.arte_circle_ll_top2.addBox(0.0F, 0.0F, 0.0F, 16, 0, 16, 0.0F);
        this.arte_circle_rr_top2 = new ModelRenderer(this, 112, 0);
        this.arte_circle_rr_top2.setRotationPoint(-8.0F, 0.0F, 24.0F);
        this.arte_circle_rr_top2.addBox(0.0F, 0.0F, 0.0F, 16, 0, 16, 0.0F);
        this.arte_circle_l_top1 = new ModelRenderer(this, 16, 16);
        this.arte_circle_l_top1.setRotationPoint(-8.0F, 0.0F, 8.0F);
        this.arte_circle_l_top1.addBox(0.0F, 0.0F, 0.0F, 16, 0, 16, 0.0F);
        this.arte_circle_r_top2 = new ModelRenderer(this, 80, 0);
        this.arte_circle_r_top2.setRotationPoint(-8.0F, 0.0F, 24.0F);
        this.arte_circle_r_top2.addBox(0.0F, 0.0F, 0.0F, 16, 0, 16, 0.0F);
        this.arte_circle_center_top1 = new ModelRenderer(this, 48, 16);
        this.arte_circle_center_top1.setRotationPoint(-8.0F, 0.0F, 8.0F);
        this.arte_circle_center_top1.addBox(0.0F, 0.0F, 0.0F, 16, 0, 16, 0.0F);
        this.arte_circle_rr = new ModelRenderer(this, 112, 32);
        this.arte_circle_rr.setRotationPoint(0.0F, 23.8F, -32.0F);
        this.arte_circle_rr.addBox(-8.0F, 0.0F, -8.0F, 16, 0, 16, 0.0F);
        this.setRotateAngle(arte_circle_rr, 0.0F, 1.5707963267948966F, 0.0F);
        this.arte_circle_center_bottom2 = new ModelRenderer(this, 48, 64);
        this.arte_circle_center_bottom2.setRotationPoint(-8.0F, 0.0F, -40.0F);
        this.arte_circle_center_bottom2.addBox(0.0F, 0.0F, 0.0F, 16, 0, 16, 0.0F);
        this.arte_circle_l_bottom1 = new ModelRenderer(this, 16, 48);
        this.arte_circle_l_bottom1.setRotationPoint(-8.0F, 0.0F, -24.0F);
        this.arte_circle_l_bottom1.addBox(0.0F, 0.0F, 0.0F, 16, 0, 16, 0.0F);
        this.arte_circle_ll_top1 = new ModelRenderer(this, -16, 16);
        this.arte_circle_ll_top1.setRotationPoint(-8.0F, 0.0F, 8.0F);
        this.arte_circle_ll_top1.addBox(0.0F, 0.0F, 0.0F, 16, 0, 16, 0.0F);
        this.arte_circle_center_bottom1 = new ModelRenderer(this, 48, 48);
        this.arte_circle_center_bottom1.setRotationPoint(-8.0F, 0.0F, -24.0F);
        this.arte_circle_center_bottom1.addBox(0.0F, 0.0F, 0.0F, 16, 0, 16, 0.0F);
        this.arte_circle_r_top1 = new ModelRenderer(this, 80, 16);
        this.arte_circle_r_top1.setRotationPoint(-8.0F, 0.0F, 8.0F);
        this.arte_circle_r_top1.addBox(0.0F, 0.0F, 0.0F, 16, 0, 16, 0.0F);
        this.arte_circle_ll_bottom2 = new ModelRenderer(this, -16, 64);
        this.arte_circle_ll_bottom2.setRotationPoint(-8.0F, 0.0F, -40.0F);
        this.arte_circle_ll_bottom2.addBox(0.0F, 0.0F, 0.0F, 16, 0, 16, 0.0F);
        this.arte_circle_center_top2 = new ModelRenderer(this, 48, 0);
        this.arte_circle_center_top2.setRotationPoint(-8.0F, 0.0F, 24.0F);
        this.arte_circle_center_top2.addBox(0.0F, 0.0F, 0.0F, 16, 0, 16, 0.0F);
        this.arte_circle_center = new ModelRenderer(this, 48, 32);
        this.arte_circle_center.setRotationPoint(0.0F, 23.8F, 0.0F);
        this.arte_circle_center.addBox(-8.0F, 0.0F, -8.0F, 16, 0, 16, 0.0F);
        this.setRotateAngle(arte_circle_center, 0.0F, 1.5707963267948966F, 0.0F);
        this.arte_circle_rr_bottom1 = new ModelRenderer(this, 112, 48);
        this.arte_circle_rr_bottom1.setRotationPoint(-8.0F, 0.0F, -24.0F);
        this.arte_circle_rr_bottom1.addBox(0.0F, 0.0F, 0.0F, 16, 0, 16, 0.0F);
        this.arte_circle_ll = new ModelRenderer(this, -16, 32);
        this.arte_circle_ll.setRotationPoint(0.0F, 23.8F, 32.0F);
        this.arte_circle_ll.addBox(-8.0F, 0.0F, -8.0F, 16, 0, 16, 0.0F);
        this.setRotateAngle(arte_circle_ll, 0.0F, 1.5707963267948966F, 0.0F);
        this.arte_circle_r_bottom1 = new ModelRenderer(this, 80, 48);
        this.arte_circle_r_bottom1.setRotationPoint(-8.0F, 0.0F, -24.0F);
        this.arte_circle_r_bottom1.addBox(0.0F, 0.0F, 0.0F, 16, 0, 16, 0.0F);
        this.arte_circle_l_bottom2 = new ModelRenderer(this, 16, 64);
        this.arte_circle_l_bottom2.setRotationPoint(-8.0F, 0.0F, -40.0F);
        this.arte_circle_l_bottom2.addBox(0.0F, 0.0F, 0.0F, 16, 0, 16, 0.0F);
        this.arte_circle_ll_bottom1 = new ModelRenderer(this, -16, 48);
        this.arte_circle_ll_bottom1.setRotationPoint(-8.0F, 0.0F, -24.0F);
        this.arte_circle_ll_bottom1.addBox(0.0F, 0.0F, 0.0F, 16, 0, 16, 0.0F);
        this.arte_circle_rr_bottom2 = new ModelRenderer(this, 112, 64);
        this.arte_circle_rr_bottom2.setRotationPoint(-8.0F, 0.0F, -40.0F);
        this.arte_circle_rr_bottom2.addBox(0.0F, 0.0F, 0.0F, 16, 0, 16, 0.0F);
        this.arte_circle_l_top2 = new ModelRenderer(this, 16, 0);
        this.arte_circle_l_top2.setRotationPoint(-8.0F, 0.0F, 24.0F);
        this.arte_circle_l_top2.addBox(0.0F, 0.0F, 0.0F, 16, 0, 16, 0.0F);
        this.arte_circle_rr.addChild(this.arte_circle_rr_top1);
        this.arte_circle_r.addChild(this.arte_circle_r_bottom2);
        this.arte_circle_ll.addChild(this.arte_circle_ll_top2);
        this.arte_circle_rr.addChild(this.arte_circle_rr_top2);
        this.arte_circle_l.addChild(this.arte_circle_l_top1);
        this.arte_circle_r.addChild(this.arte_circle_r_top2);
        this.arte_circle_center.addChild(this.arte_circle_center_top1);
        this.arte_circle_center.addChild(this.arte_circle_center_bottom2);
        this.arte_circle_l.addChild(this.arte_circle_l_bottom1);
        this.arte_circle_ll.addChild(this.arte_circle_ll_top1);
        this.arte_circle_center.addChild(this.arte_circle_center_bottom1);
        this.arte_circle_r.addChild(this.arte_circle_r_top1);
        this.arte_circle_ll.addChild(this.arte_circle_ll_bottom2);
        this.arte_circle_center.addChild(this.arte_circle_center_top2);
        this.arte_circle_rr.addChild(this.arte_circle_rr_bottom1);
        this.arte_circle_r.addChild(this.arte_circle_r_bottom1);
        this.arte_circle_l.addChild(this.arte_circle_l_bottom2);
        this.arte_circle_ll.addChild(this.arte_circle_ll_bottom1);
        this.arte_circle_rr.addChild(this.arte_circle_rr_bottom2);
        this.arte_circle_l.addChild(this.arte_circle_l_top2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.arte_circle_r.render(f5);
        this.arte_circle_l.render(f5);
        this.arte_circle_rr.render(f5);
        this.arte_circle_center.render(f5);
        this.arte_circle_ll.render(f5);
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
