package com.turtledove.withernauts.client.model.entity;

import com.turtledove.withernauts.server.entity.enemies.EntityBooglin;
import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelBooglin - Undefined
 * Created using Tabula 7.1.0
 */
public class ModelBooglin extends AdvancedModelBase {
    public AdvancedModelRenderer booglin_torso;
    public AdvancedModelRenderer booglin_waist;
    public AdvancedModelRenderer booglin_head;
    public AdvancedModelRenderer booglin_shoulder_r;
    public AdvancedModelRenderer booglin_shoulder_l;
    public AdvancedModelRenderer booglin_thigh_r;
    public AdvancedModelRenderer booglin_thigh_l;
    public AdvancedModelRenderer booglin_cloth;
    public AdvancedModelRenderer booglin_calf_r;
    public AdvancedModelRenderer booglin_calf_l;
    public AdvancedModelRenderer booglin_nose;
    public AdvancedModelRenderer booglin_ear_l;
    public AdvancedModelRenderer booglin_ear_r;
    public AdvancedModelRenderer booglin_hair_1;
    public AdvancedModelRenderer booglin_hair_2;
    public AdvancedModelRenderer booglin_hair_3;
    public AdvancedModelRenderer booglin_hair_4;
    public AdvancedModelRenderer booglin_teeth;
    public AdvancedModelRenderer booglin_bicep_r;
    public AdvancedModelRenderer booglin_forearm_r;
    public AdvancedModelRenderer booglin_elbow_r;
    public AdvancedModelRenderer booglin_bicep_l;
    public AdvancedModelRenderer booglin_forearm_l;
    public AdvancedModelRenderer booglin_elbow_l;
    public AdvancedModelRenderer booglin_staff;
    public AdvancedModelRenderer booglin_drill_1;
    public AdvancedModelRenderer booglin_drill_2;
    public AdvancedModelRenderer booglin_drill_3;

    public AdvancedModelRenderer[] booglin_parts;
    private ModelAnimator animator;

    public ModelBooglin() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.booglin_shoulder_r = new AdvancedModelRenderer(this, 24, 0);
        this.booglin_shoulder_r.setRotationPoint(-5.0F, -5.0F, 0.0F);
        this.booglin_shoulder_r.addBox(-4.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
        this.booglin_elbow_l = new AdvancedModelRenderer(this, 44, 16);
        this.booglin_elbow_l.setRotationPoint(0.0F, 5.0F, 0.5F);
        this.booglin_elbow_l.addBox(-1.5F, -1.0F, -1.5F, 3, 2, 3, 0.0F);
        this.booglin_drill_3 = new AdvancedModelRenderer(this, 44, 46);
        this.booglin_drill_3.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.booglin_drill_3.addBox(-0.5F, -3.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(booglin_drill_3, 0.0F, 0.4363323129985824F, 0.0F);
        this.booglin_hair_4 = new AdvancedModelRenderer(this, 0, 0);
        this.booglin_hair_4.setRotationPoint(-2.0F, -8.0F, 3.0F);
        this.booglin_hair_4.addBox(0.0F, -1.0F, 0.0F, 1, 1, 0, 0.0F);
        this.setRotateAngle(booglin_hair_4, -0.3490658503988659F, 0.0F, 0.0F);
        this.booglin_forearm_r = new AdvancedModelRenderer(this, 40, 21);
        this.booglin_forearm_r.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.booglin_forearm_r.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3, 0.0F);
        this.setRotateAngle(booglin_forearm_r, -1.3658946726107624F, -0.31869712141416456F, 0.18203784098300857F);
        this.booglin_head = new AdvancedModelRenderer(this, 0, 0);
        this.booglin_head.setRotationPoint(0.0F, -4.5F, 0.0F);
        this.booglin_head.addBox(-4.0F, -8.0F, -4.0F, 8, 9, 8, 0.0F);
        this.booglin_teeth = new AdvancedModelRenderer(this, 50, 29);
        this.booglin_teeth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.booglin_teeth.addBox(-1.0F, 0.0F, -0.5F, 2, 4, 1, 0.0F);
        this.booglin_forearm_l = new AdvancedModelRenderer(this, 52, 21);
        this.booglin_forearm_l.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.booglin_forearm_l.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3, 0.0F);
        this.setRotateAngle(booglin_forearm_l, -1.1383037381507017F, 0.31869712141416456F, 0.0F);
        this.booglin_nose = new AdvancedModelRenderer(this, 40, 29);
        this.booglin_nose.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.booglin_nose.addBox(-1.5F, -2.0F, -1.0F, 3, 3, 2, 0.0F);
        this.booglin_thigh_l = new AdvancedModelRenderer(this, 20, 45);
        this.booglin_thigh_l.setRotationPoint(2.5F, 2.0F, 0.0F);
        this.booglin_thigh_l.addBox(-2.0F, 0.0F, -2.5F, 4, 4, 5, 0.0F);
        this.booglin_bicep_r = new AdvancedModelRenderer(this, 32, 8);
        this.booglin_bicep_r.setRotationPoint(-2.0F, 3.0F, 0.0F);
        this.booglin_bicep_r.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3, 0.0F);
        this.setRotateAngle(booglin_bicep_r, -0.6829473363053812F, -0.31869712141416456F, 0.27314402793711257F);
        this.booglin_elbow_r = new AdvancedModelRenderer(this, 32, 16);
        this.booglin_elbow_r.setRotationPoint(0.0F, 5.0F, 0.5F);
        this.booglin_elbow_r.addBox(-1.5F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
        this.booglin_drill_2 = new AdvancedModelRenderer(this, 44, 49);
        this.booglin_drill_2.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.booglin_drill_2.addBox(-1.5F, -4.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(booglin_drill_2, 0.0F, 0.4363323129985824F, 0.0F);
        this.booglin_hair_1 = new AdvancedModelRenderer(this, 0, 0);
        this.booglin_hair_1.setRotationPoint(0.0F, -8.0F, -2.0F);
        this.booglin_hair_1.addBox(0.0F, -1.0F, 0.0F, 1, 1, 0, 0.0F);
        this.setRotateAngle(booglin_hair_1, -0.3490658503988659F, 0.0F, 0.0F);
        this.booglin_bicep_l = new AdvancedModelRenderer(this, 44, 8);
        this.booglin_bicep_l.setRotationPoint(2.0F, 3.0F, 0.0F);
        this.booglin_bicep_l.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3, 0.0F);
        this.setRotateAngle(booglin_bicep_l, -0.27314402793711257F, 0.0F, -0.136659280431156F);
        this.booglin_torso = new AdvancedModelRenderer(this, 0, 17);
        this.booglin_torso.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.booglin_torso.addBox(-5.5F, -4.5F, -4.5F, 11, 9, 9, 0.0F);
        this.booglin_cloth = new AdvancedModelRenderer(this, 40, 34);
        this.booglin_cloth.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.booglin_cloth.addBox(-2.5F, 0.0F, -0.5F, 5, 6, 1, 0.0F);
        this.booglin_ear_r = new AdvancedModelRenderer(this, 56, 29);
        this.booglin_ear_r.setRotationPoint(-3.5F, -5.0F, 0.0F);
        this.booglin_ear_r.addBox(-3.0F, -1.0F, 0.0F, 3, 2, 0, 0.0F);
        this.setRotateAngle(booglin_ear_r, 0.0F, 0.4363323129985824F, 0.2617993877991494F);
        this.booglin_ear_l = new AdvancedModelRenderer(this, 56, 31);
        this.booglin_ear_l.setRotationPoint(3.5F, -5.0F, 0.0F);
        this.booglin_ear_l.addBox(0.0F, -1.0F, 0.0F, 3, 2, 0, 0.0F);
        this.setRotateAngle(booglin_ear_l, 0.0F, -0.4363323129985824F, -0.2617993877991494F);
        this.booglin_calf_l = new AdvancedModelRenderer(this, 20, 54);
        this.booglin_calf_l.setRotationPoint(0.0F, 4.0F, -2.5F);
        this.booglin_calf_l.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 5, 0.0F);
        this.booglin_shoulder_l = new AdvancedModelRenderer(this, 40, 0);
        this.booglin_shoulder_l.setRotationPoint(5.0F, -5.0F, 0.0F);
        this.booglin_shoulder_l.addBox(0.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
        this.booglin_waist = new AdvancedModelRenderer(this, 0, 35);
        this.booglin_waist.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.booglin_waist.addBox(-5.0F, 0.0F, -3.5F, 10, 3, 7, 0.0F);
        this.booglin_hair_2 = new AdvancedModelRenderer(this, 0, 1);
        this.booglin_hair_2.setRotationPoint(2.5F, -8.0F, 1.0F);
        this.booglin_hair_2.addBox(0.0F, -1.0F, 0.0F, 1, 1, 0, 0.0F);
        this.setRotateAngle(booglin_hair_2, -0.3490658503988659F, 0.0F, 0.0F);
        this.booglin_drill_1 = new AdvancedModelRenderer(this, 44, 56);
        this.booglin_drill_1.setRotationPoint(0.0F, -15.0F, 0.0F);
        this.booglin_drill_1.addBox(-2.5F, -3.0F, -2.5F, 5, 3, 5, 0.0F);
        this.setRotateAngle(booglin_drill_1, 0.0F, 0.4363323129985824F, 0.0F);
        this.booglin_calf_r = new AdvancedModelRenderer(this, 0, 54);
        this.booglin_calf_r.setRotationPoint(0.0F, 4.0F, -2.5F);
        this.booglin_calf_r.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 5, 0.0F);
        this.booglin_hair_3 = new AdvancedModelRenderer(this, 0, 2);
        this.booglin_hair_3.setRotationPoint(-3.0F, -8.0F, 0.0F);
        this.booglin_hair_3.addBox(0.0F, -1.0F, 0.0F, 1, 1, 0, 0.0F);
        this.setRotateAngle(booglin_hair_3, -0.3490658503988659F, 0.0F, 0.0F);
        this.booglin_staff = new AdvancedModelRenderer(this, 40, 41);
        this.booglin_staff.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.booglin_staff.addBox(-0.5F, -15.0F, -0.5F, 1, 22, 1, 0.0F);
        this.setRotateAngle(booglin_staff, 1.9577358219620393F, 0.9105382707654417F, 0.0F);
        this.booglin_thigh_r = new AdvancedModelRenderer(this, 0, 45);
        this.booglin_thigh_r.setRotationPoint(-2.5F, 2.0F, 0.0F);
        this.booglin_thigh_r.addBox(-2.0F, 0.0F, -2.5F, 4, 4, 5, 0.0F);
        this.booglin_torso.addChild(this.booglin_shoulder_r);
        this.booglin_bicep_l.addChild(this.booglin_elbow_l);
        this.booglin_drill_2.addChild(this.booglin_drill_3);
        this.booglin_head.addChild(this.booglin_hair_4);
        this.booglin_bicep_r.addChild(this.booglin_forearm_r);
        this.booglin_torso.addChild(this.booglin_head);
        this.booglin_nose.addChild(this.booglin_teeth);
        this.booglin_bicep_l.addChild(this.booglin_forearm_l);
        this.booglin_head.addChild(this.booglin_nose);
        this.booglin_waist.addChild(this.booglin_thigh_l);
        this.booglin_shoulder_r.addChild(this.booglin_bicep_r);
        this.booglin_bicep_r.addChild(this.booglin_elbow_r);
        this.booglin_drill_1.addChild(this.booglin_drill_2);
        this.booglin_head.addChild(this.booglin_hair_1);
        this.booglin_shoulder_l.addChild(this.booglin_bicep_l);
        this.booglin_waist.addChild(this.booglin_cloth);
        this.booglin_head.addChild(this.booglin_ear_r);
        this.booglin_head.addChild(this.booglin_ear_l);
        this.booglin_thigh_l.addChild(this.booglin_calf_l);
        this.booglin_torso.addChild(this.booglin_shoulder_l);
        this.booglin_torso.addChild(this.booglin_waist);
        this.booglin_head.addChild(this.booglin_hair_2);
        this.booglin_staff.addChild(this.booglin_drill_1);
        this.booglin_thigh_r.addChild(this.booglin_calf_r);
        this.booglin_head.addChild(this.booglin_hair_3);
        this.booglin_forearm_l.addChild(this.booglin_staff);
        this.booglin_waist.addChild(this.booglin_thigh_r);

        animator = ModelAnimator.create();
        booglin_parts = new AdvancedModelRenderer[] {booglin_torso, booglin_waist, booglin_head, booglin_shoulder_r, booglin_shoulder_l, booglin_thigh_r, booglin_thigh_l, booglin_cloth, booglin_calf_r, booglin_calf_l, booglin_nose, booglin_ear_l, booglin_ear_r, booglin_hair_1, booglin_hair_2, booglin_hair_3, booglin_hair_4, booglin_teeth, booglin_bicep_r, booglin_forearm_r, booglin_elbow_r, booglin_bicep_l, booglin_forearm_l, booglin_elbow_l, booglin_staff, booglin_drill_1, booglin_drill_2, booglin_drill_3};
        updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animate(f, f1, f2, f3, f4, f5, entity);
        this.booglin_torso.render(f5);
        resetToDefaultPose();
    }

    public void animate(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        EntityBooglin boog = (EntityBooglin) entity;
        animator.update(boog);
        if (boog.getAnimation() == EntityBooglin.CHARGE_ANIMATION)
        {
            animator.setAnimation(EntityBooglin.CHARGE_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, boog);
            animator.startKeyframe(0);
            animator.rotate(this.booglin_torso, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(8);
            animator.rotate(this.booglin_forearm_r, 1.3658946726107624F, 0.31869712141416456F, -0.18203784098300857F);
            animator.rotate(this.booglin_bicep_r, 0.6829473363053812F, 0.31869712141416456F, -0.27314402793711257F);
            animator.rotate(this.booglin_forearm_l, 1.1383037381507017F, -0.31869712141416456F, 0.0F);
            animator.rotate(this.booglin_bicep_l, 0.27314402793711257F, 0.0F, 0.136659280431156F);
            animator.rotate(this.booglin_staff, -1.9577358219620393F, -0.9105382707654417F, 0.0F);

            animator.rotate(this.booglin_torso, 0F, -0.872665F, 0.0F);
            animator.rotate(this.booglin_waist, 0F, 0.872665F, 0.0F);
            animator.rotate(this.booglin_head, 0F, 0.872665F, 0.0F);

            animator.rotate(this.booglin_bicep_r, -0.872665F, -0.314159F, 0.314159F);
            animator.rotate(this.booglin_forearm_r, -0.523599F, -0.314159F, 0.174533F);

            animator.rotate(this.booglin_bicep_l, -0.261799F, 0.523599F, -0.174533F);
            animator.rotate(this.booglin_forearm_l, -1.13446F, 0.314159F, 0F);

            animator.rotate(this.booglin_thigh_l, -0.226893F, 0.0F, 0.0F);
            animator.rotate(this.booglin_calf_l, 0.226893F, 0.0F, 0.0F);

            animator.rotate(this.booglin_staff, 2.79253F, 0.907571F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(5);

            animator.startKeyframe(3);
            animator.rotate(this.booglin_forearm_r, 1.3658946726107624F, 0.31869712141416456F, -0.18203784098300857F);
            animator.rotate(this.booglin_bicep_r, 0.6829473363053812F, 0.31869712141416456F, -0.27314402793711257F);
            animator.rotate(this.booglin_forearm_l, 1.1383037381507017F, -0.31869712141416456F, 0.0F);
            animator.rotate(this.booglin_bicep_l, 0.27314402793711257F, 0.0F, 0.136659280431156F);
            animator.rotate(this.booglin_staff, -1.9577358219620393F, -0.9105382707654417F, 0.0F);

            animator.rotate(this.booglin_torso, 0.261799F, 0.872665F, 0.174533F);
            animator.rotate(this.booglin_waist, -0.261799F, -0.872665F, 0.0F);
            animator.rotate(this.booglin_head, 0F, -0.872665F, 0.0F);

            animator.rotate(this.booglin_bicep_r, -0.628319F, 0.628319F, 0.314159F);
            animator.rotate(this.booglin_forearm_r, -0.523599F, -0.314159F, 0.174533F);

            animator.rotate(this.booglin_bicep_l, -0.785398F, -1.13446F, -0.139626F);
            animator.rotate(this.booglin_forearm_l, -0.575959F, 0.314159F, 0F);

            animator.rotate(this.booglin_thigh_l, -0.349066F, 0.0F, 0.0F);
            animator.rotate(this.booglin_calf_l, 0.261799F, 0.0F, 0.0F);
            animator.rotate(this.booglin_thigh_r, 0.785398F, 0.0F, 0.0F);

            animator.rotate(this.booglin_staff, 2.79253F, 0.523599F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(8);
            animator.resetKeyframe(2);
        }
        else if (boog.getAnimation() == EntityBooglin.SWEEP_ANIMATION)
        {
            animator.setAnimation(EntityBooglin.SWEEP_ANIMATION);
            animator.startKeyframe(0);
            animator.rotate(this.booglin_torso, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(10);
            animator.rotate(this.booglin_forearm_r, 1.3658946726107624F, 0.31869712141416456F, -0.18203784098300857F);
            animator.rotate(this.booglin_bicep_r, 0.6829473363053812F, 0.31869712141416456F, -0.27314402793711257F);
            animator.rotate(this.booglin_forearm_l, 1.1383037381507017F, -0.31869712141416456F, 0.0F);
            animator.rotate(this.booglin_bicep_l, 0.27314402793711257F, 0.0F, 0.136659280431156F);
            animator.rotate(this.booglin_staff, -1.9577358219620393F, -0.9105382707654417F, 0.0F);

            animator.rotate(this.booglin_torso, 0F, 0.872665F, 0.0F);
            animator.rotate(this.booglin_waist, 0F, -0.872665F, 0.0F);
            animator.rotate(this.booglin_head, 0F, -0.872665F, 0.0F);

            animator.rotate(this.booglin_bicep_r, -0.872665F, -0.314159F, 0.314159F);
            animator.rotate(this.booglin_forearm_r, -0.523599F, -0.314159F, 0.174533F);

            animator.rotate(this.booglin_bicep_l, -0.261799F, 0.523599F, -0.174533F);
            animator.rotate(this.booglin_forearm_l, -1.13446F, 0.314159F, 0F);

            animator.rotate(this.booglin_thigh_l, -0.226893F, 0.0F, 0.0F);
            animator.rotate(this.booglin_calf_l, 0.226893F, 0.0F, 0.0F);
            animator.rotate(this.booglin_thigh_r, 0.785398F, 0.0F, 0.0F);

            animator.rotate(this.booglin_staff, 2.79253F, 0.907571F, 0.0F);

            animator.endKeyframe();
            animator.setStaticKeyframe(9);
            animator.startKeyframe(3);
            animator.rotate(this.booglin_forearm_r, 1.3658946726107624F, 0.31869712141416456F, -0.18203784098300857F);
            animator.rotate(this.booglin_bicep_r, 0.6829473363053812F, 0.31869712141416456F, -0.27314402793711257F);
            animator.rotate(this.booglin_forearm_l, 1.1383037381507017F, -0.31869712141416456F, 0.0F);
            animator.rotate(this.booglin_bicep_l, 0.27314402793711257F, 0.0F, 0.136659280431156F);
            animator.rotate(this.booglin_staff, -1.9577358219620393F, -0.9105382707654417F, 0.0F);

            animator.rotate(this.booglin_torso, 0.261799F, -0.698132F, 0.174533F);
            animator.rotate(this.booglin_waist, -0.261799F, -0.872665F, 0.0F);
            animator.rotate(this.booglin_head, 0F, -0.872665F, 0.0F);

            animator.rotate(this.booglin_bicep_r, -0.628319F, 0.628319F, 0.314159F);
            animator.rotate(this.booglin_forearm_r, -0.523599F, -0.314159F, 0.174533F);

            animator.rotate(this.booglin_bicep_l, -0.785398F, -1.13446F, -0.139626F);
            animator.rotate(this.booglin_forearm_l, -0.575959F, 0.314159F, 0F);

            animator.rotate(this.booglin_thigh_l, -0.349066F, 0.0F, 0.0F);
            animator.rotate(this.booglin_calf_l, 0.261799F, 0.0F, 0.0F);

            animator.rotate(this.booglin_staff, 2.79253F, 0.523599F, 0.0F);

            animator.endKeyframe();
            animator.setStaticKeyframe(3);
            animator.resetKeyframe(5);
        }
        else if (boog.getAnimation() == EntityBooglin.FLIP_ANIMATION)
        {
            animator.setAnimation(EntityBooglin.FLIP_ANIMATION);
            animator.startKeyframe(0);
            animator.rotate(this.booglin_torso, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(5);
            animator.rotate(booglin_thigh_l, -0.261799F, 0.0F,0.0F);
            animator.rotate(booglin_thigh_r, -0.261799F, 0.0F,0.0F);
            animator.rotate(booglin_calf_l, 0.261799F, 0.0F,0.0F);
            animator.rotate(booglin_calf_r, 0.261799F, 0.0F,0.0F);
            animator.move(booglin_torso, 0.0F, 1.0F,0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(5);
            animator.startKeyframe(10);
            animator.rotate(booglin_thigh_l, -0.261799F, 0.0F,0.0F);
            animator.rotate(booglin_thigh_r, -0.261799F, 0.0F,0.0F);
            animator.rotate(booglin_calf_l, 0.261799F, 0.0F,0.0F);
            animator.rotate(booglin_calf_r, 0.261799F, 0.0F,0.0F);
            animator.rotate(booglin_torso, -6.28319F, 0.0F, 0.0F);
            animator.endKeyframe();
        }
        else if (boog.getAnimation() == EntityBooglin.FLAIL_ANIMATION)
        {
            animator.setAnimation(EntityBooglin.FLAIL_ANIMATION);
            animator.startKeyframe(0);
            animator.rotate(this.booglin_torso, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(8);
            animator.rotate(this.booglin_forearm_r, 1.3658946726107624F, 0.31869712141416456F, -0.18203784098300857F);
            animator.rotate(this.booglin_bicep_r, 0.6829473363053812F, 0.31869712141416456F, -0.27314402793711257F);
            animator.rotate(this.booglin_forearm_l, 1.1383037381507017F, -0.31869712141416456F, 0.0F);
            animator.rotate(this.booglin_bicep_l, 0.27314402793711257F, 0.0F, 0.136659280431156F);
            animator.rotate(this.booglin_staff, -1.9577358219620393F, -0.9105382707654417F, 0.0F);

            animator.rotate(this.booglin_torso, 0F, -0.872665F, 0.0F);
            animator.rotate(this.booglin_waist, 0F, 0.872665F, 0.0F);
            animator.rotate(this.booglin_head, 0F, 0.872665F, 0.0F);

            animator.rotate(this.booglin_bicep_r, -0.872665F, -0.314159F, 0.314159F);
            animator.rotate(this.booglin_forearm_r, -0.523599F, -0.314159F, 0.174533F);

            animator.rotate(this.booglin_bicep_l, -0.261799F, 0.523599F, -0.174533F);
            animator.rotate(this.booglin_forearm_l, -1.13446F, 0.314159F, 0F);

            animator.rotate(this.booglin_thigh_l, -0.226893F, 0.0F, 0.0F);
            animator.rotate(this.booglin_calf_l, 0.226893F, 0.0F, 0.0F);

            animator.rotate(this.booglin_staff, 2.79253F, 0.907571F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(5);

            animator.startKeyframe(3);
            animator.rotate(this.booglin_forearm_r, 1.3658946726107624F, 0.31869712141416456F, -0.18203784098300857F);
            animator.rotate(this.booglin_bicep_r, 0.6829473363053812F, 0.31869712141416456F, -0.27314402793711257F);
            animator.rotate(this.booglin_forearm_l, 1.1383037381507017F, -0.31869712141416456F, 0.0F);
            animator.rotate(this.booglin_bicep_l, 0.27314402793711257F, 0.0F, 0.136659280431156F);
            animator.rotate(this.booglin_staff, -1.9577358219620393F, -0.9105382707654417F, 0.0F);

            animator.rotate(this.booglin_torso, 0.261799F, 0.872665F, 0.174533F);
            animator.rotate(this.booglin_waist, -0.261799F, -0.872665F, 0.0F);
            animator.rotate(this.booglin_head, 0F, -0.872665F, 0.0F);

            animator.rotate(this.booglin_bicep_r, -0.628319F, 0.628319F, 0.314159F);
            animator.rotate(this.booglin_forearm_r, -0.523599F, -0.314159F, 0.174533F);

            animator.rotate(this.booglin_bicep_l, -0.785398F, -1.13446F, -0.139626F);
            animator.rotate(this.booglin_forearm_l, -0.575959F, 0.314159F, 0F);

            animator.rotate(this.booglin_thigh_l, -0.349066F, 0.0F, 0.0F);
            animator.rotate(this.booglin_calf_l, 0.261799F, 0.0F, 0.0F);
            animator.rotate(this.booglin_thigh_r, 0.785398F, 0.0F, 0.0F);

            animator.rotate(this.booglin_staff, 2.79253F, 0.523599F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(4);
            animator.rotate(this.booglin_forearm_r, 1.3658946726107624F, 0.31869712141416456F, -0.18203784098300857F);
            animator.rotate(this.booglin_bicep_r, 0.6829473363053812F, 0.31869712141416456F, -0.27314402793711257F);
            animator.rotate(this.booglin_forearm_l, 1.1383037381507017F, -0.31869712141416456F, 0.0F);
            animator.rotate(this.booglin_bicep_l, 0.27314402793711257F, 0.0F, 0.136659280431156F);
            animator.rotate(this.booglin_staff, -1.9577358219620393F, -0.9105382707654417F, 0.0F);

            animator.rotate(this.booglin_torso, 0F, -0.872665F, 0.0F);
            animator.rotate(this.booglin_waist, 0F, 0.872665F, 0.0F);
            animator.rotate(this.booglin_head, 0F, 0.872665F, 0.0F);

            animator.rotate(this.booglin_bicep_r, -0.872665F, -0.314159F, 0.314159F);
            animator.rotate(this.booglin_forearm_r, -0.523599F, -0.314159F, 0.174533F);

            animator.rotate(this.booglin_bicep_l, -0.261799F, 0.523599F, -0.174533F);
            animator.rotate(this.booglin_forearm_l, -1.13446F, 0.314159F, 0F);

            animator.rotate(this.booglin_thigh_l, -0.226893F, 0.0F, 0.0F);
            animator.rotate(this.booglin_calf_l, 0.226893F, 0.0F, 0.0F);

            animator.rotate(this.booglin_staff, 2.79253F, 0.907571F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(3);
            animator.rotate(this.booglin_forearm_r, 1.3658946726107624F, 0.31869712141416456F, -0.18203784098300857F);
            animator.rotate(this.booglin_bicep_r, 0.6829473363053812F, 0.31869712141416456F, -0.27314402793711257F);
            animator.rotate(this.booglin_forearm_l, 1.1383037381507017F, -0.31869712141416456F, 0.0F);
            animator.rotate(this.booglin_bicep_l, 0.27314402793711257F, 0.0F, 0.136659280431156F);
            animator.rotate(this.booglin_staff, -1.9577358219620393F, -0.9105382707654417F, 0.0F);

            animator.rotate(this.booglin_torso, 0.261799F, 0.872665F, 0.174533F);
            animator.rotate(this.booglin_waist, -0.261799F, -0.872665F, 0.0F);
            animator.rotate(this.booglin_head, 0F, -0.872665F, 0.0F);

            animator.rotate(this.booglin_bicep_r, -0.628319F, 0.628319F, 0.314159F);
            animator.rotate(this.booglin_forearm_r, -0.523599F, -0.314159F, 0.174533F);

            animator.rotate(this.booglin_bicep_l, -0.785398F, -1.13446F, -0.139626F);
            animator.rotate(this.booglin_forearm_l, -0.575959F, 0.314159F, 0F);

            animator.rotate(this.booglin_thigh_l, -0.349066F, 0.0F, 0.0F);
            animator.rotate(this.booglin_calf_l, 0.261799F, 0.0F, 0.0F);
            animator.rotate(this.booglin_thigh_r, 0.785398F, 0.0F, 0.0F);
            animator.rotate(this.booglin_staff, 2.79253F, 0.523599F, 0.0F);


            animator.endKeyframe();
            animator.setStaticKeyframe(7);
            animator.resetKeyframe(8);
        }
        else if (boog.getAnimation() == EntityBooglin.COMBO_ANIMATION) {
            animator.setAnimation(EntityBooglin.COMBO_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, boog);

            animator.startKeyframe(0);
            animator.rotate(this.booglin_torso, 0F, 0.0F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(3);
            animator.rotate(this.booglin_forearm_r, 1.3658946726107624F, 0.31869712141416456F, -0.18203784098300857F);
            animator.rotate(this.booglin_bicep_r, 0.6829473363053812F, 0.31869712141416456F, -0.27314402793711257F);
            animator.rotate(this.booglin_forearm_l, 1.1383037381507017F, -0.31869712141416456F, 0.0F);
            animator.rotate(this.booglin_bicep_l, 0.27314402793711257F, 0.0F, 0.136659280431156F);
            animator.rotate(this.booglin_staff, -1.9577358219620393F, -0.9105382707654417F, 0.0F);

            animator.rotate(this.booglin_torso, 0F, 0.872665F, 0.0F);
            animator.rotate(this.booglin_waist, 0F, -0.872665F, 0.0F);
            animator.rotate(this.booglin_head, 0F, -0.872665F, 0.0F);

            animator.rotate(this.booglin_bicep_r, -0.872665F, -0.314159F, 0.314159F);
            animator.rotate(this.booglin_forearm_r, -0.523599F, -0.314159F, 0.174533F);

            animator.rotate(this.booglin_bicep_l, -0.261799F, 0.523599F, -0.174533F);
            animator.rotate(this.booglin_forearm_l, -1.13446F, 0.314159F, 0F);

            animator.rotate(this.booglin_thigh_l, -0.226893F, 0.0F, 0.0F);
            animator.rotate(this.booglin_calf_l, 0.226893F, 0.0F, 0.0F);
            animator.rotate(this.booglin_thigh_r, 0.785398F, 0.0F, 0.0F);

            animator.rotate(this.booglin_staff, 2.79253F, 0.907571F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(8);

            animator.startKeyframe(3);
            animator.rotate(this.booglin_forearm_r, 1.3658946726107624F, 0.31869712141416456F, -0.18203784098300857F);
            animator.rotate(this.booglin_bicep_r, 0.6829473363053812F, 0.31869712141416456F, -0.27314402793711257F);
            animator.rotate(this.booglin_forearm_l, 1.1383037381507017F, -0.31869712141416456F, 0.0F);
            animator.rotate(this.booglin_bicep_l, 0.27314402793711257F, 0.0F, 0.136659280431156F);
            animator.rotate(this.booglin_staff, -1.9577358219620393F, -0.9105382707654417F, 0.0F);

            animator.rotate(this.booglin_torso, 0.261799F, -0.698132F, 0.174533F);
            animator.rotate(this.booglin_waist, -0.261799F, -0.872665F, 0.0F);
            animator.rotate(this.booglin_head, 0F, -0.872665F, 0.0F);

            animator.rotate(this.booglin_bicep_r, -0.628319F, 0.628319F, 0.314159F);
            animator.rotate(this.booglin_forearm_r, -0.523599F, -0.314159F, 0.174533F);

            animator.rotate(this.booglin_bicep_l, -0.785398F, -1.13446F, -0.139626F);
            animator.rotate(this.booglin_forearm_l, -0.575959F, 0.314159F, 0F);

            animator.rotate(this.booglin_thigh_l, -0.349066F, 0.0F, 0.0F);
            animator.rotate(this.booglin_calf_l, 0.261799F, 0.0F, 0.0F);

            animator.rotate(this.booglin_staff, 2.79253F, 0.523599F, 0.0F);

            animator.endKeyframe();
            animator.setStaticKeyframe(3);

            animator.startKeyframe(4);
            animator.rotate(this.booglin_forearm_r, 1.3658946726107624F, 0.31869712141416456F, -0.18203784098300857F);
            animator.rotate(this.booglin_bicep_r, 0.6829473363053812F, 0.31869712141416456F, -0.27314402793711257F);
            animator.rotate(this.booglin_forearm_l, 1.1383037381507017F, -0.31869712141416456F, 0.0F);
            animator.rotate(this.booglin_bicep_l, 0.27314402793711257F, 0.0F, 0.136659280431156F);
            animator.rotate(this.booglin_staff, -1.9577358219620393F, -0.9105382707654417F, 0.0F);

            animator.rotate(this.booglin_torso, 0F, -0.872665F, 0.0F);
            animator.rotate(this.booglin_waist, 0F, 0.872665F, 0.0F);
            animator.rotate(this.booglin_head, 0F, 0.872665F, 0.0F);

            animator.rotate(this.booglin_bicep_r, -0.872665F, -0.314159F, 0.314159F);
            animator.rotate(this.booglin_forearm_r, -0.523599F, -0.314159F, 0.174533F);

            animator.rotate(this.booglin_bicep_l, -0.261799F, 0.523599F, -0.174533F);
            animator.rotate(this.booglin_forearm_l, -1.5708F, 0.314159F, 0F);

            animator.rotate(this.booglin_thigh_l, -0.226893F, 0.0F, 0.0F);
            animator.rotate(this.booglin_calf_l, 0.226893F, 0.0F, 0.0F);

            animator.rotate(this.booglin_staff, 2.79253F, 0.907571F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(3);
            animator.rotate(this.booglin_forearm_r, 1.3658946726107624F, 0.31869712141416456F, -0.18203784098300857F);
            animator.rotate(this.booglin_bicep_r, 0.6829473363053812F, 0.31869712141416456F, -0.27314402793711257F);
            animator.rotate(this.booglin_forearm_l, 1.1383037381507017F, -0.31869712141416456F, 0.0F);
            animator.rotate(this.booglin_bicep_l, 0.27314402793711257F, 0.0F, 0.136659280431156F);
            animator.rotate(this.booglin_staff, -1.9577358219620393F, -0.9105382707654417F, 0.0F);

            animator.rotate(this.booglin_torso, 0.261799F, 0.872665F, 0.174533F);
            animator.rotate(this.booglin_waist, -0.261799F, -0.872665F, 0.0F);
            animator.rotate(this.booglin_head, 0F, -0.872665F, 0.0F);

            animator.rotate(this.booglin_bicep_r, -0.628319F, 0.628319F, 0.314159F);
            animator.rotate(this.booglin_forearm_r, -0.523599F, -0.314159F, 0.174533F);

            animator.rotate(this.booglin_bicep_l, -0.785398F, -1.13446F, -0.139626F);
            animator.rotate(this.booglin_forearm_l, -0.575959F, 0.314159F, 0F);
            animator.rotate(this.booglin_shoulder_l, -0.785398F, 0.0F, 0.0F);

            animator.rotate(this.booglin_thigh_l, -0.349066F, 0.0F, 0.0F);
            animator.rotate(this.booglin_calf_l, 0.261799F, 0.0F, 0.0F);
            animator.rotate(this.booglin_thigh_r, 0.785398F, 0.0F, 0.0F);

            animator.rotate(this.booglin_staff, 2.79253F, 0.523599F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(7);
            animator.resetKeyframe(5);

        }
        else if (boog.getAnimation() == EntityBooglin.HURT_ANIMATION) {
            animator.setAnimation(EntityBooglin.HURT_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, boog);
            animator.startKeyframe(0);
            animator.rotate(this.booglin_torso, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(2);
            animator.rotate(this.booglin_torso, (float)Math.toRadians(-10.0f), 0.0F, (float)Math.toRadians(-10.0f));
            animator.rotate(this.booglin_calf_r, (float)Math.toRadians(10.0f), 0.0F, (float)Math.toRadians(10.0f));
            animator.rotate(this.booglin_thigh_l, (float)Math.toRadians(20.0f), 0.0F, (float)Math.toRadians(-20.0f));
            animator.rotate(this.booglin_shoulder_l, (float)Math.toRadians(-20.0f), 0.0F, 0.0f);
            animator.endKeyframe();
            animator.setStaticKeyframe(2);
            animator.resetKeyframe(1);
        }
        else if (boog.getAnimation() == EntityBooglin.BLOCK_40_ANIMATION)
        {
            animator.setAnimation(EntityBooglin.BLOCK_40_ANIMATION);
            animator.startKeyframe(0);
            animator.rotate(this.booglin_torso, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(3);
            animator.rotate(this.booglin_forearm_r, 1.3658946726107624F, 0.31869712141416456F, -0.18203784098300857F);
            animator.rotate(this.booglin_bicep_r, 0.6829473363053812F, 0.31869712141416456F, -0.27314402793711257F);
            animator.rotate(this.booglin_forearm_l, 1.1383037381507017F, -0.31869712141416456F, 0.0F);
            animator.rotate(this.booglin_bicep_l, 0.27314402793711257F, 0.0F, 0.136659280431156F);
            animator.rotate(this.booglin_staff, -1.9577358219620393F, -0.9105382707654417F, 0.0F);

            animator.rotate(this.booglin_bicep_r, (float)Math.toRadians(-90.0D), (float)Math.toRadians(-20.0D), (float)Math.toRadians(20.0D));
            animator.rotate(this.booglin_forearm_r, (float)Math.toRadians(-40.0D), (float)Math.toRadians(-20.0D), (float)Math.toRadians(20.0D));

            animator.rotate(this.booglin_bicep_l, (float)Math.toRadians(-60.0D), 0.0F, (float)Math.toRadians(15.0D));
            animator.rotate(this.booglin_forearm_l, (float)Math.toRadians(-30.0D), (float)Math.toRadians(20.0D), 0.0F);
            animator.rotate(this.booglin_staff, (float)Math.toRadians(90.0D), (float)Math.toRadians(70.0D), 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(40);
            animator.resetKeyframe(2);
        }
        else if (boog.getAnimation() == EntityBooglin.BLOCK_80_ANIMATION)
        {
            animator.setAnimation(EntityBooglin.BLOCK_80_ANIMATION);
            animator.startKeyframe(0);
            animator.rotate(this.booglin_torso, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(3);
            animator.rotate(this.booglin_forearm_r, 1.3658946726107624F, 0.31869712141416456F, -0.18203784098300857F);
            animator.rotate(this.booglin_bicep_r, 0.6829473363053812F, 0.31869712141416456F, -0.27314402793711257F);
            animator.rotate(this.booglin_forearm_l, 1.1383037381507017F, -0.31869712141416456F, 0.0F);
            animator.rotate(this.booglin_bicep_l, 0.27314402793711257F, 0.0F, 0.136659280431156F);
            animator.rotate(this.booglin_staff, -1.9577358219620393F, -0.9105382707654417F, 0.0F);

            animator.rotate(this.booglin_bicep_r, (float)Math.toRadians(-90.0D), (float)Math.toRadians(-20.0D), (float)Math.toRadians(20.0D));
            animator.rotate(this.booglin_forearm_r, (float)Math.toRadians(-40.0D), (float)Math.toRadians(-20.0D), (float)Math.toRadians(20.0D));

            animator.rotate(this.booglin_bicep_l, (float)Math.toRadians(-60.0D), 0.0F, (float)Math.toRadians(15.0D));
            animator.rotate(this.booglin_forearm_l, (float)Math.toRadians(-30.0D), (float)Math.toRadians(20.0D), 0.0F);
            animator.rotate(this.booglin_staff, (float)Math.toRadians(90.0D), (float)Math.toRadians(70.0D), 0.0F);

            animator.rotate(this.booglin_head, (float)Math.toRadians(10.0D), 0.0f, 0.0f);
            animator.endKeyframe();
            animator.setStaticKeyframe(80);
            animator.resetKeyframe(2);
        }
        else if (boog.getAnimation() == EntityBooglin.MINE_ANIMATION)
        {
            animator.setAnimation(EntityBooglin.MINE_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, boog);
            animator.startKeyframe(0);
            animator.rotate(this.booglin_torso, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(8);
            animator.rotate(this.booglin_forearm_r, 1.3658946726107624F, 0.31869712141416456F, -0.18203784098300857F);
            animator.rotate(this.booglin_bicep_r, 0.6829473363053812F, 0.31869712141416456F, -0.27314402793711257F);
            animator.rotate(this.booglin_forearm_l, 1.1383037381507017F, -0.31869712141416456F, 0.0F);
            animator.rotate(this.booglin_bicep_l, 0.27314402793711257F, 0.0F, 0.136659280431156F);
            animator.rotate(this.booglin_staff, -1.9577358219620393F, -0.9105382707654417F, 0.0F);

            animator.rotate(this.booglin_torso, 0F, -0.872665F, 0.0F);
            animator.rotate(this.booglin_waist, 0F, 0.872665F, 0.0F);
            animator.rotate(this.booglin_head, 0F, 0.872665F, 0.0F);

            animator.rotate(this.booglin_bicep_r, -0.872665F, -0.314159F, 0.314159F);
            animator.rotate(this.booglin_forearm_r, -0.523599F, -0.314159F, 0.174533F);

            animator.rotate(this.booglin_bicep_l, -0.261799F, 0.523599F, -0.174533F);
            animator.rotate(this.booglin_forearm_l, -1.13446F, 0.314159F, 0F);

            animator.rotate(this.booglin_thigh_l, -0.226893F, 0.0F, 0.0F);
            animator.rotate(this.booglin_calf_l, 0.226893F, 0.0F, 0.0F);

            animator.rotate(this.booglin_staff, 2.79253F, 0.907571F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(5);

            animator.startKeyframe(3);
            animator.rotate(this.booglin_forearm_r, 1.3658946726107624F, 0.31869712141416456F, -0.18203784098300857F);
            animator.rotate(this.booglin_bicep_r, 0.6829473363053812F, 0.31869712141416456F, -0.27314402793711257F);
            animator.rotate(this.booglin_forearm_l, 1.1383037381507017F, -0.31869712141416456F, 0.0F);
            animator.rotate(this.booglin_bicep_l, 0.27314402793711257F, 0.0F, 0.136659280431156F);
            animator.rotate(this.booglin_staff, -1.9577358219620393F, -0.9105382707654417F, 0.0F);

            animator.rotate(this.booglin_torso, 0.261799F, 0.872665F, 0.174533F);
            animator.rotate(this.booglin_waist, -0.261799F, -0.872665F, 0.0F);
            animator.rotate(this.booglin_head, 0F, -0.872665F, 0.0F);

            animator.rotate(this.booglin_bicep_r, -0.628319F, 0.628319F, 0.314159F);
            animator.rotate(this.booglin_forearm_r, -0.523599F, -0.314159F, 0.174533F);

            animator.rotate(this.booglin_bicep_l, -0.785398F, -1.13446F, -0.139626F);
            animator.rotate(this.booglin_forearm_l, -0.575959F, 0.314159F, 0F);

            animator.rotate(this.booglin_thigh_l, -0.349066F, 0.0F, 0.0F);
            animator.rotate(this.booglin_calf_l, 0.261799F, 0.0F, 0.0F);
            animator.rotate(this.booglin_thigh_r, 0.785398F, 0.0F, 0.0F);

            animator.rotate(this.booglin_staff, 2.79253F, 0.523599F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(8);
            animator.resetKeyframe(2);
        }
        else
            setRotationAngles(f, f1, f2, f3, f4, f5, boog);
    }
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, EntityBooglin entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        resetToDefaultPose();

        if (netHeadYaw > 70) {
            netHeadYaw = 70f;
        }
        if (netHeadYaw < -70) {
            netHeadYaw = -70f;
        }

        faceTarget(netHeadYaw, 0.0f, 1.0F, this.booglin_torso);

        float walkheight = 0.75F;
        float walkspeed = 1F;
        float walkdegree = 2F;

        walk(this.booglin_thigh_r, walkspeed, walkdegree, false, 0F, 0F, limbSwing, limbSwingAmount * 0.5F);
        walk(this.booglin_calf_r, walkspeed, walkdegree / 4F, true, 0F, 0F, limbSwing, limbSwingAmount * 0.5F);
        walk(this.booglin_thigh_l, walkspeed, walkdegree, true, 0F, 0F, limbSwing, limbSwingAmount * 0.5F);
        walk(this.booglin_calf_l, walkspeed, walkdegree / 4F, false, 0F, 0F, limbSwing, limbSwingAmount * 0.5F);
        walk(this.booglin_cloth, walkspeed, walkdegree/ 4F, false, 0F, 0F, limbSwing, limbSwingAmount * 0.5F);

        bob(this.booglin_torso, walkspeed, -2F * walkheight, true, limbSwing, limbSwingAmount * 0.5F);
        bob(this.booglin_head, walkspeed, -1F * walkheight, true, limbSwing, limbSwingAmount * 0.5F);
        bob(this.booglin_shoulder_l, walkspeed, -1F * walkheight, true, limbSwing, limbSwingAmount * 0.5F);
        bob(this.booglin_shoulder_r, walkspeed, -1F * walkheight, true, limbSwing, limbSwingAmount * 0.5F);
        bob(this.booglin_thigh_r, walkspeed ,  2F * walkheight, true, limbSwing, limbSwingAmount * 0.5F);
        bob(this.booglin_thigh_l, walkspeed,  2F * walkheight, true, limbSwing, limbSwingAmount * 0.5F);


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
