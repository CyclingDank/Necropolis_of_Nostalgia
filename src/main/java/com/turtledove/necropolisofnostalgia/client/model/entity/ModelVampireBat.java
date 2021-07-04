package com.turtledove.necropolisofnostalgia.client.model.entity;

import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityAxeBeak;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityVampireBat;
import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelVampireBat - Undefined
 * Created using Tabula 7.1.0
 */
public class ModelVampireBat extends AdvancedModelBase {
    public AdvancedModelRenderer vb_torso;
    public AdvancedModelRenderer vb_abdomen;
    public AdvancedModelRenderer vb_head;
    public AdvancedModelRenderer vb_wing_1_l;
    public AdvancedModelRenderer vb_wing_1_r;
    public AdvancedModelRenderer vb_leg_l;
    public AdvancedModelRenderer vb_leg_r;
    public AdvancedModelRenderer vb_tail;
    public AdvancedModelRenderer vb_mouth;
    public AdvancedModelRenderer vb_snout;
    public AdvancedModelRenderer vb_ear_r;
    public AdvancedModelRenderer vb_ear_l;
    public AdvancedModelRenderer vb_teeth_1;
    public AdvancedModelRenderer vb_teeth_2;
    public AdvancedModelRenderer vb_wing_2_l;
    public AdvancedModelRenderer vb_wing_2_r;

    public AdvancedModelRenderer[] vb_parts;
    private ModelAnimator animator;

    public ModelVampireBat() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.vb_ear_r = new AdvancedModelRenderer(this, 2, 16);
        this.vb_ear_r.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.vb_ear_r.addBox(-5.0F, 0.0F, 0.0F, 5, 0, 8, 0.0F);
        this.setRotateAngle(vb_ear_r, 0.3490658503988659F, -0.3490658503988659F, 0.0F);
        this.vb_leg_l = new AdvancedModelRenderer(this, 77, 0);
        this.vb_leg_l.setRotationPoint(1.5F, 6.0F, -1.5F);
        this.vb_leg_l.addBox(-0.5F, 0.0F, -1.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(vb_leg_l, -0.7853981633974483F, 0.0F, 0.0F);
        this.vb_tail = new AdvancedModelRenderer(this, 66, 0);
        this.vb_tail.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.vb_tail.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 0, 0.0F);
        this.setRotateAngle(vb_tail, 0.22759093446006054F, 0.0F, 0.0F);
        this.vb_head = new AdvancedModelRenderer(this, 0, 0);
        this.vb_head.setRotationPoint(0.0F, -4.0F, 2.5F);
        this.vb_head.addBox(-3.5F, -5.0F, -4.0F, 7, 5, 4, 0.0F);
        this.setRotateAngle(vb_head, 0.17453292519943295F, 0.0F, 0.0F);
        this.vb_torso = new AdvancedModelRenderer(this, 22, 0);
        this.vb_torso.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.vb_torso.addBox(-2.5F, -4.0F, -2.5F, 5, 8, 5, 0.0F);
        this.setRotateAngle(vb_torso, 1.3962634015954636F, 0.0F, 0.0F);
        this.vb_wing_1_r = new AdvancedModelRenderer(this, 46, 16);
        this.vb_wing_1_r.setRotationPoint(-2.0F, -4.0F, 0.0F);
        this.vb_wing_1_r.addBox(-10.0F, 0.0F, 0.0F, 10, 11, 0, 0.0F);
        this.setRotateAngle(vb_wing_1_r, -0.08726646259971647F, 0.0F, 0.0F);
        this.vb_snout = new AdvancedModelRenderer(this, 0, 26);
        this.vb_snout.setRotationPoint(0.0F, -5.0F, -1.0F);
        this.vb_snout.addBox(-1.5F, -1.0F, -2.0F, 3, 2, 4, 0.0F);
        this.setRotateAngle(vb_snout, 0.18203784098300857F, 0.0F, 0.0F);
        this.vb_abdomen = new AdvancedModelRenderer(this, 44, 0);
        this.vb_abdomen.setRotationPoint(0.0F, 4.0F, 2.5F);
        this.vb_abdomen.addBox(-2.0F, 0.0F, -4.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(vb_abdomen, -0.36425021489121656F, 0.0F, 0.0F);
        this.vb_leg_r = new AdvancedModelRenderer(this, 86, 0);
        this.vb_leg_r.setRotationPoint(-1.5F, 6.0F, -1.5F);
        this.vb_leg_r.addBox(-0.5F, 0.0F, -1.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(vb_leg_r, -0.7853981633974483F, 0.0F, 0.0F);
        this.vb_wing_2_r = new AdvancedModelRenderer(this, 46, 28);
        this.vb_wing_2_r.setRotationPoint(-10.0F, 0.0F, 0.0F);
        this.vb_wing_2_r.addBox(-11.0F, 0.0F, 0.0F, 11, 11, 0, 0.0F);
        this.vb_mouth = new AdvancedModelRenderer(this, 0, 36);
        this.vb_mouth.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.vb_mouth.addBox(-2.5F, -4.0F, -1.0F, 5, 4, 1, 0.0F);
        this.vb_ear_l = new AdvancedModelRenderer(this, -8, 16);
        this.vb_ear_l.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.vb_ear_l.addBox(0.0F, 0.0F, 0.0F, 5, 0, 8, 0.0F);
        this.setRotateAngle(vb_ear_l, 0.3490658503988659F, 0.3490658503988659F, 0.0F);
        this.vb_wing_1_l = new AdvancedModelRenderer(this, 22, 16);
        this.vb_wing_1_l.setRotationPoint(2.0F, -4.0F, 0.0F);
        this.vb_wing_1_l.addBox(-0.0F, 0.0F, 0.0F, 10, 11, 0, 0.0F);
        this.setRotateAngle(vb_wing_1_l, -0.08726646259971647F, 0.0F, 0.0F);
        this.vb_teeth_2 = new AdvancedModelRenderer(this, 6, 14);
        this.vb_teeth_2.setRotationPoint(1.0F, -4.0F, 0.0F);
        this.vb_teeth_2.addBox(0.0F, 0.0F, 0.0F, 1, 0, 1, 0.0F);
        this.vb_wing_2_l = new AdvancedModelRenderer(this, 22, 28);
        this.vb_wing_2_l.setRotationPoint(10.0F, 0.0F, 0.0F);
        this.vb_wing_2_l.addBox(0.0F, 0.0F, 0.0F, 11, 11, 0, 0.0F);
        this.vb_teeth_1 = new AdvancedModelRenderer(this, 0, 14);
        this.vb_teeth_1.setRotationPoint(-2.0F, -4.0F, 0.0F);
        this.vb_teeth_1.addBox(0.0F, 0.0F, 0.0F, 1, 0, 1, 0.0F);
        this.vb_head.addChild(this.vb_ear_r);
        this.vb_torso.addChild(this.vb_leg_l);
        this.vb_abdomen.addChild(this.vb_tail);
        this.vb_torso.addChild(this.vb_head);
        this.vb_torso.addChild(this.vb_wing_1_r);
        this.vb_head.addChild(this.vb_snout);
        this.vb_torso.addChild(this.vb_abdomen);
        this.vb_torso.addChild(this.vb_leg_r);
        this.vb_wing_1_r.addChild(this.vb_wing_2_r);
        this.vb_head.addChild(this.vb_mouth);
        this.vb_head.addChild(this.vb_ear_l);
        this.vb_torso.addChild(this.vb_wing_1_l);
        this.vb_mouth.addChild(this.vb_teeth_2);
        this.vb_wing_1_l.addChild(this.vb_wing_2_l);
        this.vb_mouth.addChild(this.vb_teeth_1);

        animator = ModelAnimator.create();
        vb_parts = new AdvancedModelRenderer[] {vb_torso, vb_abdomen, vb_head, vb_wing_1_l, vb_wing_1_r, vb_leg_l, vb_leg_r, vb_tail, vb_mouth, vb_snout, vb_ear_r, vb_ear_l, vb_teeth_1, vb_teeth_2, vb_wing_2_l, vb_wing_2_r};
        updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        animate(f, f1, f2, f3, f4, f5, entity);
        this.vb_torso.render(f5);
        resetToDefaultPose();
    }

    public void animate(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        EntityVampireBat birb = (EntityVampireBat)entity;
        animator.update(birb);
        if (birb.getAnimation() == EntityVampireBat.DIVE_ANIMATION)
        {
            animator.setAnimation(EntityVampireBat.DIVE_ANIMATION);
            animator.startKeyframe(0);
            animator.rotate(this.vb_torso, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(4);
            animator.rotate(this.vb_torso, -0.872665F, 0.0F, 0.0F);
            animator.rotate(this.vb_head, 0.261799F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(6);
            animator.startKeyframe(10);
            animator.rotate(this.vb_torso, 0.174533F, 0.0F, 0.0F);
            animator.rotate(this.vb_torso, 0.0F, 0.0F, 12.5664F);
            animator.rotate(this.vb_wing_1_l, 0.0F, -0.785398F, 0.0F);
            animator.rotate(this.vb_wing_2_l, 0.0F, -2.0944F, 0.0F);
            animator.rotate(this.vb_wing_1_r, 0.0F, -0.785398F, 0.0F);
            animator.rotate(this.vb_wing_2_r, 0.0F, -2.0944F, 0.0F);
            animator.endKeyframe();
        }
        else if (birb.getAnimation() == EntityVampireBat.HURT_ANIMATION) {
            animator.setAnimation(EntityVampireBat.HURT_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, birb);
            animator.startKeyframe(0);
            animator.rotate(this.vb_torso, 0F, 0.0F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(2);
            animator.rotate(this.vb_torso, -0.872665F, 0.0F, 0.0F);
            animator.rotate(this.vb_head, 0.261799F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(2);
            animator.rotate(this.vb_torso, -0.872665F, 0.0F, 0.0F);
            animator.rotate(this.vb_head, 0.261799F, 0.0F, 0.0F);
            animator.rotate(this.vb_mouth, 0.174533F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(10);
            animator.resetKeyframe(1);
        }
        else
            setRotationAngles(f, f1, f2, f3, f4, f5, birb);

    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, EntityVampireBat entityIn)
    {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        resetToDefaultPose();

        this.vb_mouth.rotateAngleX = 0.349066F;

        float walkheight = 1.5F;
        float walkspeed = 1F;
        float walkdegree = 2F;

        swing(this.vb_wing_1_l, walkspeed, walkdegree, true, 0F, 0.0F, entityIn.ticksExisted, 0.5F);
        swing(this.vb_wing_1_r, walkspeed, walkdegree, false, 0F, 0.0F, entityIn.ticksExisted, 0.5F);
        swing(this.vb_wing_2_l, walkspeed, walkdegree, true, 0.5F, 0.0F, entityIn.ticksExisted, 0.5F);
        swing(this.vb_wing_2_r, walkspeed, walkdegree, false, 0.5F, 0.0F, entityIn.ticksExisted, 0.5F);
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
