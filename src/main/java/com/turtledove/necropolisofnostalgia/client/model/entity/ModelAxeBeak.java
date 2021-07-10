package com.turtledove.necropolisofnostalgia.client.model.entity;

import com.turtledove.necropolisofnostalgia.entity.enemies.EntityAxeBeak;
import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelAxeBeak - Undefined
 * Created using Tabula 7.1.0
 */
public class ModelAxeBeak extends AdvancedModelBase {
    public AdvancedModelRenderer axe_beak_body;
    public AdvancedModelRenderer axe_beak_thigh_r;
    public AdvancedModelRenderer axe_beak_thigh_l;
    public AdvancedModelRenderer axe_beak_chest;
    public AdvancedModelRenderer axe_beak_wing_l;
    public AdvancedModelRenderer axe_beak_wing_r;
    public AdvancedModelRenderer axe_beak_tail_top;
    public AdvancedModelRenderer axe_beak_tail_l;
    public AdvancedModelRenderer axe_beak_tail_r;
    public AdvancedModelRenderer axe_beak_leg_r;
    public AdvancedModelRenderer axe_beak_foot_r;
    public AdvancedModelRenderer axe_beak_leg_l;
    public AdvancedModelRenderer axe_beak_foot_r_1;
    public AdvancedModelRenderer axe_beak_neck;
    public AdvancedModelRenderer axe_beak_top;
    public AdvancedModelRenderer axe_beak_bottom;
    public AdvancedModelRenderer axe_beak_hair;
    public AdvancedModelRenderer axe_beak_edge_top;
    public AdvancedModelRenderer axe_beak_edge_top_point;
    public AdvancedModelRenderer axe_beak_edge_bottom;

    public AdvancedModelRenderer[] axebeak_parts;
    private ModelAnimator animator;


    public ModelAxeBeak() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.axe_beak_bottom = new AdvancedModelRenderer(this, 35, 65);
        this.axe_beak_bottom.setRotationPoint(0.0F, -2.0F, -7.0F);
        this.axe_beak_bottom.addBox(-1.0F, 0.0F, -4.0F, 2, 2, 4, 0.0F);
        this.axe_beak_thigh_r = new AdvancedModelRenderer(this, 0, 26);
        this.axe_beak_thigh_r.setRotationPoint(-3.5F, 4.0F, 2.0F);
        this.axe_beak_thigh_r.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F);
        this.setRotateAngle(axe_beak_thigh_r, 0.3490658503988659F, 0.0F, 0.0F);
        this.axe_beak_tail_r = new AdvancedModelRenderer(this, 60, 20);
        this.axe_beak_tail_r.setRotationPoint(-3.0F, -3.0F, 7.0F);
        this.axe_beak_tail_r.addBox(-1.0F, 0.0F, 0.0F, 1, 6, 10, 0.0F);
        this.setRotateAngle(axe_beak_tail_r, 0.0F, -0.3490658503988659F, 0.0F);
        this.axe_beak_top = new AdvancedModelRenderer(this, 20, 65);
        this.axe_beak_top.setRotationPoint(0.0F, -2.0F, -7.0F);
        this.axe_beak_top.addBox(-1.0F, -2.0F, -4.0F, 2, 2, 4, 0.0F);
        this.axe_beak_wing_l = new AdvancedModelRenderer(this, 84, 0);
        this.axe_beak_wing_l.setRotationPoint(6.0F, -3.0F, -5.0F);
        this.axe_beak_wing_l.addBox(0.0F, 0.0F, 0.0F, 1, 7, 9, 0.0F);
        this.axe_beak_chest = new AdvancedModelRenderer(this, 0, 45);
        this.axe_beak_chest.setRotationPoint(0.0F, 0.5F, -9.0F);
        this.axe_beak_chest.addBox(-4.0F, -10.0F, -3.0F, 8, 10, 6, 0.0F);
        this.setRotateAngle(axe_beak_chest, -0.5235987755982988F, 0.0F, 0.0F);
        this.axe_beak_foot_r = new AdvancedModelRenderer(this, 18, 36);
        this.axe_beak_foot_r.setRotationPoint(0.0F, 4.0F, -1.0F);
        this.axe_beak_foot_r.addBox(-1.0F, 0.0F, -3.0F, 2, 0, 3, 0.0F);
        this.axe_beak_hair = new AdvancedModelRenderer(this, 0, 60);
        this.axe_beak_hair.setRotationPoint(0.0F, -3.0F, 2.0F);
        this.axe_beak_hair.addBox(0.0F, -4.0F, -5.0F, 0, 5, 7, 0.0F);
        this.axe_beak_edge_top = new AdvancedModelRenderer(this, 55, 60);
        this.axe_beak_edge_top.setRotationPoint(0.0F, 1.0F, -2.0F);
        this.axe_beak_edge_top.addBox(-1.0F, -5.0F, -5.0F, 2, 5, 5, 0.0F);
        this.axe_beak_edge_top_point = new AdvancedModelRenderer(this, 0, 0);
        this.axe_beak_edge_top_point.setRotationPoint(0.0F, -5.0F, -5.0F);
        this.axe_beak_edge_top_point.addBox(-1.0F, -2.0F, 0.0F, 2, 2, 5, 0.0F);
        this.setRotateAngle(axe_beak_edge_top_point, -0.31869712141416456F, 0.0F, 0.0F);
        this.axe_beak_neck = new AdvancedModelRenderer(this, 30, 45);
        this.axe_beak_neck.setRotationPoint(0.0F, -9.0F, 0.0F);
        this.axe_beak_neck.addBox(-2.0F, -5.0F, -7.0F, 4, 5, 9, 0.0F);
        this.setRotateAngle(axe_beak_neck, 0.5235987755982988F, 0.0F, 0.0F);
        this.axe_beak_body = new AdvancedModelRenderer(this, 0, 0);
        this.axe_beak_body.setRotationPoint(0.0F, 11.5F, 1.0F);
        this.axe_beak_body.addBox(-6.0F, -5.5F, -8.0F, 12, 11, 15, 0.0F);
        this.axe_beak_leg_r = new AdvancedModelRenderer(this, 0, 36);
        this.axe_beak_leg_r.setRotationPoint(0.0F, 5.0F, 1.0F);
        this.axe_beak_leg_r.addBox(-1.0F, 0.0F, -2.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(axe_beak_leg_r, -0.3490658503988659F, 0.0F, 0.0F);
        this.axe_beak_leg_l = new AdvancedModelRenderer(this, 10, 36);
        this.axe_beak_leg_l.setRotationPoint(0.0F, 5.0F, 1.0F);
        this.axe_beak_leg_l.addBox(-1.0F, 0.0F, -2.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(axe_beak_leg_l, -0.3490658503988659F, 0.0F, 0.0F);
        this.axe_beak_tail_top = new AdvancedModelRenderer(this, 70, 40);
        this.axe_beak_tail_top.setRotationPoint(0.0F, -3.0F, 7.0F);
        this.axe_beak_tail_top.addBox(-3.0F, -1.0F, 0.0F, 6, 1, 10, 0.0F);
        this.setRotateAngle(axe_beak_tail_top, 0.3490658503988659F, 0.0F, 0.0F);
        this.axe_beak_foot_r_1 = new AdvancedModelRenderer(this, 25, 36);
        this.axe_beak_foot_r_1.setRotationPoint(0.0F, 4.0F, -1.0F);
        this.axe_beak_foot_r_1.addBox(-1.0F, 0.0F, -3.0F, 2, 0, 3, 0.0F);
        this.axe_beak_edge_bottom = new AdvancedModelRenderer(this, 74, 60);
        this.axe_beak_edge_bottom.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.axe_beak_edge_bottom.addBox(-1.0F, 0.0F, -4.0F, 2, 5, 4, 0.0F);
        this.axe_beak_tail_l = new AdvancedModelRenderer(this, 84, 20);
        this.axe_beak_tail_l.setRotationPoint(3.0F, -3.0F, 7.0F);
        this.axe_beak_tail_l.addBox(0.0F, 0.0F, 0.0F, 1, 6, 10, 0.0F);
        this.setRotateAngle(axe_beak_tail_l, 0.0F, 0.3490658503988659F, 0.0F);
        this.axe_beak_thigh_l = new AdvancedModelRenderer(this, 18, 26);
        this.axe_beak_thigh_l.setRotationPoint(3.5F, 4.0F, 2.0F);
        this.axe_beak_thigh_l.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F);
        this.setRotateAngle(axe_beak_thigh_l, 0.3490658503988659F, 0.0F, 0.0F);
        this.axe_beak_wing_r = new AdvancedModelRenderer(this, 60, 0);
        this.axe_beak_wing_r.setRotationPoint(-6.0F, -3.0F, -5.0F);
        this.axe_beak_wing_r.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 9, 0.0F);
        this.axe_beak_neck.addChild(this.axe_beak_bottom);
        this.axe_beak_body.addChild(this.axe_beak_thigh_r);
        this.axe_beak_body.addChild(this.axe_beak_tail_r);
        this.axe_beak_neck.addChild(this.axe_beak_top);
        this.axe_beak_body.addChild(this.axe_beak_wing_l);
        this.axe_beak_body.addChild(this.axe_beak_chest);
        this.axe_beak_leg_r.addChild(this.axe_beak_foot_r);
        this.axe_beak_neck.addChild(this.axe_beak_hair);
        this.axe_beak_top.addChild(this.axe_beak_edge_top);
        this.axe_beak_edge_top.addChild(this.axe_beak_edge_top_point);
        this.axe_beak_chest.addChild(this.axe_beak_neck);
        this.axe_beak_thigh_r.addChild(this.axe_beak_leg_r);
        this.axe_beak_thigh_l.addChild(this.axe_beak_leg_l);
        this.axe_beak_body.addChild(this.axe_beak_tail_top);
        this.axe_beak_leg_l.addChild(this.axe_beak_foot_r_1);
        this.axe_beak_bottom.addChild(this.axe_beak_edge_bottom);
        this.axe_beak_body.addChild(this.axe_beak_tail_l);
        this.axe_beak_body.addChild(this.axe_beak_thigh_l);
        this.axe_beak_body.addChild(this.axe_beak_wing_r);

        animator = ModelAnimator.create();
        axebeak_parts = new AdvancedModelRenderer[] {axe_beak_body, axe_beak_thigh_r, axe_beak_thigh_l, axe_beak_chest, axe_beak_wing_l, axe_beak_wing_r, axe_beak_tail_top, axe_beak_tail_l, axe_beak_tail_r, axe_beak_leg_r, axe_beak_foot_r, axe_beak_leg_l, axe_beak_foot_r_1, axe_beak_neck, axe_beak_top, axe_beak_bottom, axe_beak_hair, axe_beak_edge_top, axe_beak_edge_top_point, axe_beak_edge_bottom};
        updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        animate(f, f1, f2, f3, f4, f5, entity);
        this.axe_beak_body.render(f5);
        resetToDefaultPose();
    }

    public void animate(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        EntityAxeBeak birb = (EntityAxeBeak)entity;
        animator.update(birb);

        if (birb.getAnimation() == EntityAxeBeak.LEAP_ANIMATION)
        {
            animator.setAnimation(EntityAxeBeak.LEAP_ANIMATION);
            animator.startKeyframe(0);
            animator.rotate(this.axe_beak_body, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(5);
            animator.rotate(this.axe_beak_body, -0.872665F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_chest, 0.523599F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_neck, 0.349066F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_wing_l, 0.0F, 0.0F, -1.74533F);
            animator.rotate(this.axe_beak_wing_r, 0.0F, 0.0F, 1.74533F);
            animator.rotate(this.axe_beak_thigh_r, 0.523599F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_thigh_l, 0.523599F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(5);
            animator.rotate(this.axe_beak_body, -0.872665F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_chest, 0.523599F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_neck, 0.349066F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_thigh_r, 0.523599F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_thigh_l, 0.523599F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(5);
            animator.rotate(this.axe_beak_body, -0.872665F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_chest, 0.523599F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_neck, 0.349066F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_wing_l, 0.0F, 0.0F, -1.74533F);
            animator.rotate(this.axe_beak_wing_r, 0.0F, 0.0F, 1.74533F);
            animator.rotate(this.axe_beak_thigh_r, 0.523599F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_thigh_l, 0.523599F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(5);
            animator.rotate(this.axe_beak_body, -0.872665F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_chest, 0.523599F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_neck, 0.349066F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_thigh_r, 0.523599F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_thigh_l, 0.523599F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(10);
            animator.rotate(this.axe_beak_body, 0.872665F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_top, -0.174533F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_bottom, 0.34906F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_wing_l, 0.0F, 0.0F, -1.74533F);
            animator.rotate(this.axe_beak_wing_r, 0.0F, 0.0F, 1.74533F);
            animator.endKeyframe();
            animator.resetKeyframe(10);
        }
        else if (birb.getAnimation() == EntityAxeBeak.EAT_ANIMATION)
        {
            animator.setAnimation(EntityAxeBeak.EAT_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, birb);
            animator.startKeyframe(0);
            animator.rotate(this.axe_beak_body, 0F, 0.0F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(5);
            animator.rotate(this.axe_beak_top, -0.174533F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_bottom, 0.34906F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.resetKeyframe(5);
            animator.startKeyframe(3);
            animator.rotate(this.axe_beak_top, -0.174533F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_bottom, 0.34906F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(82);
            animator.resetKeyframe(5);
        }
        else if (birb.getAnimation() == EntityAxeBeak.JAB_ANIMATION)
        {
            animator.setAnimation(EntityAxeBeak.JAB_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, birb);
            animator.startKeyframe(0);
            animator.rotate(this.axe_beak_body, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(5);
            animator.rotate(this.axe_beak_wing_l, 0.0F, 0.0F, -1.74533F);
            animator.rotate(this.axe_beak_wing_r, 0.0F, 0.0F, 1.74533F);
            animator.rotate(this.axe_beak_top, -0.174533F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_bottom, 0.34906F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(3);
            animator.rotate(this.axe_beak_body, 0F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_wing_l, 0.0F, 0.0F, -1.74533F);
            animator.rotate(this.axe_beak_wing_r, 0.0F, 0.0F, 1.74533F);
            animator.rotate(this.axe_beak_chest, 1.0472F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_neck, -0.523599F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_top, -0.174533F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_bottom, 0.34906F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.resetKeyframe(5);
            animator.startKeyframe(3);
            animator.rotate(this.axe_beak_body, 0F, -0.523599F, 0.0F);
            animator.rotate(this.axe_beak_wing_l, 0.0F, 0.0F, -1.74533F);
            animator.rotate(this.axe_beak_wing_r, 0.0F, 0.0F, 1.74533F);
            animator.rotate(this.axe_beak_chest, 1.0472F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_neck, -0.523599F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_top, -0.174533F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_bottom, 0.34906F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.resetKeyframe(5);
            animator.startKeyframe(3);
            animator.rotate(this.axe_beak_body, 0F, 0.523599F, 0.0F);
            animator.rotate(this.axe_beak_wing_l, 0.0F, 0.0F, -1.74533F);
            animator.rotate(this.axe_beak_wing_r, 0.0F, 0.0F, 1.74533F);
            animator.rotate(this.axe_beak_chest, 1.0472F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_neck, -0.523599F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_top, -0.174533F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_bottom, 0.34906F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.resetKeyframe(5);
        }
        else if (birb.getAnimation() == EntityAxeBeak.HURT_ANIMATION)
        {
            animator.setAnimation(EntityAxeBeak.HURT_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, birb);
            animator.startKeyframe(0);
            animator.rotate(this.axe_beak_body, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(2);
            animator.rotate(this.axe_beak_bottom, (float)Math.toRadians(20.0D), 0.0f, 0.0f);
            animator.rotate(this.axe_beak_neck, (float)Math.toRadians(-20.0D), 0.0f, 0.0f);
            animator.rotate(this.axe_beak_wing_l, 0.0F, 0.0f, (float)Math.toRadians(-45.0D));
            animator.rotate(this.axe_beak_wing_r, 0.0F, 0.0f, (float)Math.toRadians(45.0D));
            animator.rotate(this.axe_beak_thigh_l, 0.0F, 0.0f, (float)Math.toRadians(-10.0D));
            animator.rotate(this.axe_beak_thigh_r, 0.0F, 0.0f, (float)Math.toRadians(20.0D));
            animator.rotate(this.axe_beak_body, 0.0F, 0.0f, (float)Math.toRadians(-20.0D));
            animator.endKeyframe();
            animator.setStaticKeyframe(2);
            animator.resetKeyframe(1);
        }
        else if (birb.getAnimation() == EntityAxeBeak.RUSH_ANIMATION) {
            animator.setAnimation(EntityAxeBeak.RUSH_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, birb);
            animator.startKeyframe(0);
            animator.rotate(this.axe_beak_body, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(5);
            animator.rotate(this.axe_beak_wing_l, 0.0F, 0.0F, -1.74533F);
            animator.rotate(this.axe_beak_wing_r, 0.0F, 0.0F, 1.74533F);
            animator.rotate(this.axe_beak_top, -0.174533F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_bottom, 0.34906F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(3);
            animator.rotate(this.axe_beak_body, 0F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_wing_l, 0.0F, 0.0F, -1.74533F);
            animator.rotate(this.axe_beak_wing_r, 0.0F, 0.0F, 1.74533F);
            animator.rotate(this.axe_beak_chest, 1.0472F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_neck, -0.523599F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_top, -0.174533F, 0.0F, 0.0F);
            animator.rotate(this.axe_beak_bottom, 0.34906F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.resetKeyframe(5);
        }
        else
        {
            setRotationAngles(f, f1, f2, f3, f4, f5, birb);
        }
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, EntityAxeBeak entityIn)
    {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        resetToDefaultPose();

        faceTarget(netHeadYaw, 0.0f, 1.0F, this.axe_beak_body);

        float walkheight = 1.5F;
        float walkspeed = 0.75F;
        float walkdegree = 2F;

        walk(this.axe_beak_thigh_r, walkspeed, walkdegree, false, 0F, 0.0F, limbSwing, limbSwingAmount);
        walk(this.axe_beak_leg_r, walkspeed, walkdegree, true, 0F, 0.125F, limbSwing, limbSwingAmount);
        walk(this.axe_beak_thigh_l, walkspeed, walkdegree, true, 0F, 0.0F, limbSwing, limbSwingAmount);
        walk(this.axe_beak_leg_r, walkspeed, walkdegree, false, 0F, 0.125F, limbSwing, limbSwingAmount);

        //flap(this.axe_beak_wing_l, walkspeed, walkdegree * 0.5F, true, 0.5F, 0.5F, limbSwing, limbSwingAmount);
        //flap(this.axe_beak_wing_r, walkspeed, walkdegree * 0.5F, false, 0.5F, 0.5F, limbSwing, limbSwingAmount);

        walk(this.axe_beak_tail_top, walkspeed, walkdegree * 0.125F, false, 0.5F, 0.5F, limbSwing, limbSwingAmount);
        swing(this.axe_beak_tail_l, walkspeed, walkdegree * 0.125F, false, 0.5F, 0.5F, limbSwing, limbSwingAmount);
        swing(this.axe_beak_tail_r, walkspeed, walkdegree * 0.125F, true, 0.5F, 0.5F, limbSwing, limbSwingAmount);

        bob(this.axe_beak_body, walkspeed, -2F * walkheight, true,  limbSwing, 0.5F * limbSwingAmount);
        bob(this.axe_beak_chest, walkspeed, -1F * walkheight, true,  limbSwing, 0.5F * limbSwingAmount);
        bob(this.axe_beak_neck, walkspeed, -1F * walkheight, true,  limbSwing, 0.5F * limbSwingAmount);

        bob(this.axe_beak_thigh_r, walkspeed,  2F * walkheight, true,  limbSwing, 0.5F * limbSwingAmount);
        bob(this.axe_beak_thigh_l, walkspeed,  2F * walkheight, true,  limbSwing, 0.5F * limbSwingAmount);
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
