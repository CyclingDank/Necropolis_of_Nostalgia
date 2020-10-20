package com.turtledove.withernauts.client.model.entity;

import com.turtledove.withernauts.server.entity.enemies.EntityNecropolisSpider;
import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelSpider - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelNecropolisSpider extends AdvancedModelBase {
    public AdvancedModelRenderer ns_sternum;
    public AdvancedModelRenderer ns_head;
    public AdvancedModelRenderer ns_leg_r1;
    public AdvancedModelRenderer ns_leg_r2;
    public AdvancedModelRenderer ns_leg_r3;
    public AdvancedModelRenderer ns_leg_r4;
    public AdvancedModelRenderer ns_butt;
    public AdvancedModelRenderer ns_leg_l1;
    public AdvancedModelRenderer ns_leg_l2;
    public AdvancedModelRenderer ns_leg_l3;
    public AdvancedModelRenderer ns_leg_l4;
    public AdvancedModelRenderer ns_p_r;
    public AdvancedModelRenderer ns_p_l;
    public AdvancedModelRenderer ns_fang_r;
    public AdvancedModelRenderer ns_fang_l;
    public AdvancedModelRenderer ns_hair_1;
    public AdvancedModelRenderer ns_hair_2;
    public AdvancedModelRenderer ns_hair_3;
    public AdvancedModelRenderer ns_hair_4;
    public AdvancedModelRenderer ns_q_r;
    public AdvancedModelRenderer ns_q_l;

    public AdvancedModelRenderer[] spider_parts;
    private ModelAnimator animator;

    public ModelNecropolisSpider() {

        this.textureWidth = 64;
        this.textureHeight = 64;
        this.ns_hair_1 = new AdvancedModelRenderer(this, 0, 0);
        this.ns_hair_1.setRotationPoint(2.0F, -5.0F, -1.0F);
        this.ns_hair_1.addBox(0.0F, -1.0F, 0.0F, 1, 1, 0, 0.0F);
        this.setRotateAngle(ns_hair_1, -0.3490658503988659F, 0.0F, 0.0F);
        this.ns_p_r = new AdvancedModelRenderer(this, 0, 44);
        this.ns_p_r.setRotationPoint(-4.0F, 0.0F, 6.0F);
        this.ns_p_r.addBox(-1.0F, -1.0F, -8.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(ns_p_r, 0.3490658503988659F, 0.22689280275926282F, 0.0F);
        this.ns_butt = new AdvancedModelRenderer(this, 0, 24);
        this.ns_butt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ns_butt.addBox(-6.0F, -5.0F, 0.0F, 12, 6, 14, 0.0F);
        this.setRotateAngle(ns_butt, -0.17453292519943295F, 0.0F, 0.0F);
        this.ns_sternum = new AdvancedModelRenderer(this, 0, 0);
        this.ns_sternum.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.ns_sternum.addBox(-3.0F, -2.5F, -4.0F, 6, 5, 8, 0.0F);
        this.ns_hair_3 = new AdvancedModelRenderer(this, 0, 0);
        this.ns_hair_3.setRotationPoint(0.0F, -5.0F, 2.0F);
        this.ns_hair_3.addBox(0.0F, -1.0F, 0.0F, 1, 1, 0, 0.0F);
        this.setRotateAngle(ns_hair_3, -0.3490658503988659F, 0.0F, 0.0F);
        this.ns_leg_r1 = new AdvancedModelRenderer(this, 20, 0);
        this.ns_leg_r1.setRotationPoint(-4.0F, 0.0F, 2.0F);
        this.ns_leg_r1.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(ns_leg_r1, 0.0F, 0.7853981633974483F, -0.7853981633974483F);
        this.ns_q_r = new AdvancedModelRenderer(this, 20, 44);
        this.ns_q_r.setRotationPoint(-1.0F, 0.0F, -8.0F);
        this.ns_q_r.addBox(0.0F, -1.0F, -8.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(ns_q_r, 0.0F, -0.3490658503988659F, 0.0F);
        this.ns_p_l = new AdvancedModelRenderer(this, 0, 44);
        this.ns_p_l.setRotationPoint(4.0F, 0.0F, 6.0F);
        this.ns_p_l.addBox(-1.0F, -1.0F, -8.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(ns_p_l, 0.3490658503988659F, -0.22689280275926282F, 0.0F);
        this.ns_fang_r = new AdvancedModelRenderer(this, 0, 13);
        this.ns_fang_r.setRotationPoint(-2.6F, 2.0F, -6.0F);
        this.ns_fang_r.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3, 0.0F);
        this.setRotateAngle(ns_fang_r, -0.2617993877991494F, 0.0F, 0.0F);
        this.ns_fang_l = new AdvancedModelRenderer(this, 0, 21);
        this.ns_fang_l.setRotationPoint(2.5F, 2.0F, -6.0F);
        this.ns_fang_l.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3, 0.0F);
        this.setRotateAngle(ns_fang_l, -0.2617993877991494F, 0.0F, 0.0F);
        this.ns_leg_r2 = new AdvancedModelRenderer(this, 20, 0);
        this.ns_leg_r2.setRotationPoint(-4.0F, 0.0F, 1.0F);
        this.ns_leg_r2.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(ns_leg_r2, 0.0F, 0.39269908169872414F, -0.5811946409141118F);
        this.ns_head = new AdvancedModelRenderer(this, 18, 4);
        this.ns_head.setRotationPoint(0.0F, -1.5F, -9.0F);
        this.ns_head.addBox(-4.5F, -5.0F, -5.0F, 9, 10, 10, 0.0F);
        this.ns_leg_r3 = new AdvancedModelRenderer(this, 20, 0);
        this.ns_leg_r3.setRotationPoint(-4.0F, 0.0F, 0.0F);
        this.ns_leg_r3.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(ns_leg_r3, 0.0F, -0.39269908169872414F, -0.5811946409141118F);
        this.ns_q_l = new AdvancedModelRenderer(this, 20, 44);
        this.ns_q_l.setRotationPoint(1.0F, 0.0F, -8.0F);
        this.ns_q_l.addBox(-2.0F, -1.0F, -8.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(ns_q_l, 0.0F, 0.3490658503988659F, 0.0F);
        this.ns_leg_r4 = new AdvancedModelRenderer(this, 20, 0);
        this.ns_leg_r4.setRotationPoint(-4.0F, 0.0F, -1.0F);
        this.ns_leg_r4.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(ns_leg_r4, 0.0F, -0.7853981633974483F, -0.7853981633974483F);
        this.ns_leg_l2 = new AdvancedModelRenderer(this, 20, 0);
        this.ns_leg_l2.mirror = true;
        this.ns_leg_l2.setRotationPoint(4.0F, 0.0F, 1.0F);
        this.ns_leg_l2.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(ns_leg_l2, 0.0F, -0.39269908169872414F, 0.5811946409141118F);
        this.ns_hair_2 = new AdvancedModelRenderer(this, 0, 0);
        this.ns_hair_2.setRotationPoint(-3.0F, -5.0F, -2.0F);
        this.ns_hair_2.addBox(0.0F, -1.0F, 0.0F, 1, 1, 0, 0.0F);
        this.setRotateAngle(ns_hair_2, -0.3490658503988659F, 0.0F, 0.0F);
        this.ns_leg_l1 = new AdvancedModelRenderer(this, 20, 0);
        this.ns_leg_l1.mirror = true;
        this.ns_leg_l1.setRotationPoint(4.0F, 0.0F, 2.0F);
        this.ns_leg_l1.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(ns_leg_l1, 0.0F, -0.7853981633974483F, 0.7853981633974483F);
        this.ns_leg_l4 = new AdvancedModelRenderer(this, 20, 0);
        this.ns_leg_l4.mirror = true;
        this.ns_leg_l4.setRotationPoint(4.0F, 0.0F, -1.0F);
        this.ns_leg_l4.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(ns_leg_l4, 0.0F, 0.7853981633974483F, 0.7853981633974483F);
        this.ns_hair_4 = new AdvancedModelRenderer(this, 0, 0);
        this.ns_hair_4.setRotationPoint(-3.5F, -5.0F, 4.0F);
        this.ns_hair_4.addBox(0.0F, -1.0F, 0.0F, 1, 1, 0, 0.0F);
        this.setRotateAngle(ns_hair_4, -0.3490658503988659F, 0.0F, 0.0F);
        this.ns_leg_l3 = new AdvancedModelRenderer(this, 20, 0);
        this.ns_leg_l3.mirror = true;
        this.ns_leg_l3.setRotationPoint(4.0F, 0.0F, 0.0F);
        this.ns_leg_l3.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(ns_leg_l3, 0.0F, 0.39269908169872414F, 0.5811946409141118F);
        this.ns_head.addChild(this.ns_hair_1);
        this.ns_head.addChild(this.ns_p_r);
        this.ns_sternum.addChild(this.ns_butt);
        this.ns_head.addChild(this.ns_hair_3);
        this.ns_sternum.addChild(this.ns_leg_r1);
        this.ns_p_r.addChild(this.ns_q_r);
        this.ns_head.addChild(this.ns_p_l);
        this.ns_head.addChild(this.ns_fang_r);
        this.ns_head.addChild(this.ns_fang_l);
        this.ns_sternum.addChild(this.ns_leg_r2);
        this.ns_sternum.addChild(this.ns_head);
        this.ns_sternum.addChild(this.ns_leg_r3);
        this.ns_p_l.addChild(this.ns_q_l);
        this.ns_sternum.addChild(this.ns_leg_r4);
        this.ns_sternum.addChild(this.ns_leg_l2);
        this.ns_head.addChild(this.ns_hair_2);
        this.ns_sternum.addChild(this.ns_leg_l1);
        this.ns_sternum.addChild(this.ns_leg_l4);
        this.ns_head.addChild(this.ns_hair_4);
        this.ns_sternum.addChild(this.ns_leg_l3);

        animator = ModelAnimator.create();
        spider_parts = new AdvancedModelRenderer[] {ns_sternum, ns_head, ns_leg_r1, ns_leg_r2, ns_leg_r3, ns_leg_r4, ns_butt, ns_leg_l1, ns_leg_l2, ns_leg_l3, ns_leg_l4, ns_p_r, ns_p_l, ns_fang_r, ns_fang_l, ns_hair_1, ns_hair_2, ns_hair_3, ns_hair_4, ns_q_r, ns_q_l};
        updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        animate(f, f1, f2, f3, f4, f5, entity);
        this.ns_sternum.render(f5);
        resetToDefaultPose();
    }

    public void animate(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        EntityNecropolisSpider spoderman = (EntityNecropolisSpider) entity;
        animator.update(spoderman);

        if (spoderman.getAnimation() == EntityNecropolisSpider.HANG_ANIMATION)
        {
            animator.setAnimation(EntityNecropolisSpider.HANG_ANIMATION);
            this.ns_sternum.rotateAngleX = 1.5708F;
        }
        else if (spoderman.getAnimation() == EntityNecropolisSpider.RAMPAGE_ANIMATION) {
            animator.setAnimation(EntityNecropolisSpider.RAMPAGE_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, spoderman);
            animator.startKeyframe(0);
            animator.rotate(this.ns_sternum, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(3);
            //resets arms
            animator.rotate(this.ns_p_r, -0.3490658503988659F, -0.22689280275926282F, 0.0F);
            animator.rotate(this.ns_q_r, 0.0F, 0.3490658503988659F, 0.0F);
            animator.rotate(this.ns_p_l, -0.3490658503988659F, 0.22689280275926282F, 0.0F);
            animator.rotate(this.ns_q_l, 0.0F, -0.3490658503988659F, 0.0F);

            animator.rotate(this.ns_head, -0.261799F, 0.0F, 0.0F);
            animator.rotate(this.ns_fang_l, -0.785398F, 0.0F, 0.0F);
            animator.rotate(this.ns_fang_r, -0.785398F, 0.0F, 0.0F);

            animator.rotate(this.ns_p_r, -0.698132F, 0.698132F, 0.0F);
            animator.rotate(this.ns_q_r, 0.0F, -0.349066F, 0.0F);
            animator.rotate(this.ns_p_l, -0.698132F, -0.698132F, 0.0F);
            animator.rotate(this.ns_q_l, 0.0F, 0.349066F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(4);
            animator.resetKeyframe(3);
        }
        else if (spoderman.getAnimation() == EntityNecropolisSpider.REAR_JAB_ANIMATION)
        {
            animator.setAnimation(EntityNecropolisSpider.REAR_JAB_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, spoderman);
            animator.startKeyframe(0);
            animator.rotate(this.ns_sternum, 0F, 0.0F, 0.0F);
            animator.endKeyframe();


            //left
            animator.startKeyframe(3);
            animator.rotate(this.ns_sternum, 0F, (float)Math.toRadians(180.0D), 0F);
            animator.rotate(this.ns_sternum, 0F, 0.523599F, 0.0F);
            animator.rotate(this.ns_butt, 0.523599F, 0.523599F, 0.0F);
            animator.rotate(this.ns_head, 0F, -0.698132F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(3);
            animator.rotate(this.ns_sternum, 0F, (float)Math.toRadians(180.0D), 0F);

            animator.rotate(this.ns_sternum, 0F, 0.523599F, 0.0F);
            animator.rotate(this.ns_butt, 0.523599F, 0.523599F, 0.0F);
            animator.rotate(this.ns_head, 0F, -0.698132F, 0.0F);
            animator.move(this.ns_butt, 1.0f, 0.0f, 1.0f);
            animator.endKeyframe();

            animator.startKeyframe(2);
            animator.rotate(this.ns_sternum, 0F, (float)Math.toRadians(180.0D), 0F);
            animator.rotate(this.ns_sternum, 0F, 0.523599F, 0.0F);
            animator.rotate(this.ns_butt, 0.523599F, 0.523599F, 0.0F);
            animator.rotate(this.ns_head, 0F, -0.698132F, 0.0F);
            animator.endKeyframe();

            //center
            animator.startKeyframe(3);
            animator.rotate(this.ns_sternum, 0F, (float)Math.toRadians(180.0D), 0F);
            animator.rotate(this.ns_butt, 0.523599F, 0.0F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(3);
            animator.rotate(this.ns_sternum, 0F, (float)Math.toRadians(180.0D), 0F);
            animator.rotate(this.ns_butt, 0.523599F, 0.0F, 0.0F);
            animator.move(this.ns_butt, 1.5f, 0.0f, 1.0f);
            animator.endKeyframe();

            animator.startKeyframe(2);
            animator.rotate(this.ns_sternum, 0F, (float)Math.toRadians(180.0D), 0F);
            animator.rotate(this.ns_butt, 0.523599F, 0.0F, 0.0F);
            animator.endKeyframe();

            //right
            animator.startKeyframe(3);
            animator.rotate(this.ns_sternum, 0F, (float)Math.toRadians(180.0D), 0F);
            animator.rotate(this.ns_sternum, 0F, -0.523599F, 0.0F);
            animator.rotate(this.ns_butt, 0.523599F, -0.523599F, 0.0F);
            animator.rotate(this.ns_head, 0F, 0.698132F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(3);
            animator.rotate(this.ns_sternum, 0F, (float)Math.toRadians(180.0D), 0F);
            animator.rotate(this.ns_sternum, 0F, -0.523599F, 0.0F);
            animator.rotate(this.ns_butt, 0.523599F, -0.523599F, 0.0F);
            animator.rotate(this.ns_head, 0F, 0.698132F, 0.0F);
            animator.move(this.ns_butt, -1.0f, 0.0f, 1.0f);
            animator.endKeyframe();

            animator.startKeyframe(2);
            animator.rotate(this.ns_sternum, 0F, (float)Math.toRadians(180.0D), 0F);
            animator.rotate(this.ns_sternum, 0F, -0.523599F, 0.0F);
            animator.rotate(this.ns_butt, 0.523599F, -0.523599F, 0.0F);
            animator.rotate(this.ns_head, 0F, 0.698132F, 0.0F);
            animator.endKeyframe();

            animator.resetKeyframe(2);
        }
        else if (spoderman.getAnimation() == EntityNecropolisSpider.LEAP_ANIMATION)
        {
            animator.setAnimation(EntityNecropolisSpider.LEAP_ANIMATION);
            animator.startKeyframe(0);
            animator.rotate(this.ns_sternum, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(3);
            //resets arms
            animator.rotate(this.ns_p_r, -0.3490658503988659F, -0.22689280275926282F, 0.0F);
            animator.rotate(this.ns_q_r, 0.0F, 0.3490658503988659F, 0.0F);
            animator.rotate(this.ns_p_l, -0.3490658503988659F, 0.22689280275926282F, 0.0F);
            animator.rotate(this.ns_q_l, 0.0F, -0.3490658503988659F, 0.0F);
            animator.rotate(this.ns_head, -0.261799F, 0.0F, 0.0F);
            animator.rotate(this.ns_fang_l, -0.785398F, 0.0F, 0.0F);
            animator.rotate(this.ns_fang_r, -0.785398F, 0.0F, 0.0F);
            animator.rotate(this.ns_p_r, -0.698132F, 0.698132F, 0.0F);
            animator.rotate(this.ns_q_r, 0.0F, -0.349066F, 0.0F);
            animator.rotate(this.ns_p_l, -0.698132F, -0.698132F, 0.0F);
            animator.rotate(this.ns_q_l, 0.0F, 0.349066F, 0.0F);

            animator.rotate(this.ns_sternum, (float)Math.toRadians(-50.0D), 0.0f, 0.0f);
            animator.rotate(this.ns_head, (float)Math.toRadians(40.0D), 0.0f, 0.0f);
            animator.endKeyframe();
            animator.setStaticKeyframe(2);

            animator.startKeyframe(5);
            animator.rotate(this.ns_sternum, (float)Math.toRadians(-50.0D), 0.0f, 0.0f);
            animator.rotate(this.ns_head, (float)Math.toRadians(40.0D), 0.0f, 0.0f);
            animator.rotate(this.ns_butt, (float)Math.toRadians(-80.0D), 0.0f, 0.0f);
            animator.endKeyframe();
            animator.setStaticKeyframe(1);
            animator.resetKeyframe(2);
        }
        else if (spoderman.getAnimation() == EntityNecropolisSpider.HURT_ANIMATION)
        {
            animator.setAnimation(EntityNecropolisSpider.HURT_ANIMATION);
            animator.startKeyframe(0);
            animator.rotate(this.ns_sternum, 0F, 0.0F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(2);
            animator.rotate(this.ns_sternum, 0F, 0.0F, (float)Math.toRadians(20.0D));
            animator.rotate(this.ns_leg_r1, 0F, 0F, (float)Math.toRadians(-30.0D) );
            animator.rotate(this.ns_leg_r2, 0F, 0F, (float)Math.toRadians(-30.0D) );
            animator.rotate(this.ns_leg_r3, 0F, 0F, (float)Math.toRadians(-30.0D) );
            animator.rotate(this.ns_leg_r4, 0F, 0F, (float)Math.toRadians(-30.0D) );
            animator.endKeyframe();
            animator.setStaticKeyframe(2);
            animator.resetKeyframe(1);
        }
        else
            setRotationAngles(f, f1, f2, f3, f4, f5, spoderman);
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, EntityNecropolisSpider entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        resetToDefaultPose();
        this.ns_head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.ns_head.rotateAngleX = headPitch * 0.017453292F;
        float f = ((float)Math.PI / 4F);
        this.ns_leg_r1.rotateAngleZ = -((float)Math.PI / 4F);
        this.ns_leg_l1.rotateAngleZ = ((float)Math.PI / 4F);
        this.ns_leg_r2.rotateAngleZ = -0.58119464F;
        this.ns_leg_l2.rotateAngleZ = 0.58119464F;
        this.ns_leg_r3.rotateAngleZ = -0.58119464F;
        this.ns_leg_l3.rotateAngleZ = 0.58119464F;
        this.ns_leg_r4.rotateAngleZ = -((float)Math.PI / 4F);
        this.ns_leg_l4.rotateAngleZ = ((float)Math.PI / 4F);
        float f1 = -0.0F;
        float f2 = 0.3926991F;
        this.ns_leg_r1.rotateAngleY = ((float)Math.PI / 4F);
        this.ns_leg_l1.rotateAngleY = -((float)Math.PI / 4F);
        this.ns_leg_r2.rotateAngleY = 0.3926991F;
        this.ns_leg_l2.rotateAngleY = -0.3926991F;
        this.ns_leg_r3.rotateAngleY = -0.3926991F;
        this.ns_leg_l3.rotateAngleY = 0.3926991F;
        this.ns_leg_r4.rotateAngleY = -((float)Math.PI / 4F);
        this.ns_leg_l4.rotateAngleY = ((float)Math.PI / 4F);
        float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
        float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
        this.ns_leg_r1.rotateAngleY += f3;
        this.ns_leg_l1.rotateAngleY += -f3;
        this.ns_leg_r2.rotateAngleY += f4;
        this.ns_leg_l2.rotateAngleY += -f4;
        this.ns_leg_r3.rotateAngleY += f5;
        this.ns_leg_l3.rotateAngleY += -f5;
        this.ns_leg_r4.rotateAngleY += f6;
        this.ns_leg_l4.rotateAngleY += -f6;
        this.ns_leg_r1.rotateAngleZ += f7;
        this.ns_leg_l1.rotateAngleZ += -f7;
        this.ns_leg_r2.rotateAngleZ += f8;
        this.ns_leg_l2.rotateAngleZ += -f8;
        this.ns_leg_r3.rotateAngleZ += f9;
        this.ns_leg_l3.rotateAngleZ += -f9;
        this.ns_leg_r4.rotateAngleZ += f10;
        this.ns_leg_l4.rotateAngleZ += -f10;
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
