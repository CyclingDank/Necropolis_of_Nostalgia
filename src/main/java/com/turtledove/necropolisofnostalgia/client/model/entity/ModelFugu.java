package com.turtledove.necropolisofnostalgia.client.model.entity;


import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityBedrockGolem;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityFugu;
import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelFugu - dfdf
 * Created using Tabula 7.1.0
 */
public class ModelFugu extends AdvancedModelBase {
    public AdvancedModelRenderer fugu_head;
    public AdvancedModelRenderer fugu_ab;
    public AdvancedModelRenderer fugu_fin_1;
    public AdvancedModelRenderer fugu_bicep_l;
    public AdvancedModelRenderer fugu_bicep_r;
    public AdvancedModelRenderer fugu_butt;
    public AdvancedModelRenderer fugu_tail;
    public AdvancedModelRenderer fugu_forearm_l;
    public AdvancedModelRenderer fugu_hand_l;
    public AdvancedModelRenderer fugu_forearm_r;
    public AdvancedModelRenderer fugu_hand_r;

    public AdvancedModelRenderer[] fugu_parts;
    private ModelAnimator animator;

    public ModelFugu() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.fugu_bicep_l = new AdvancedModelRenderer(this, 36, 32);
        this.fugu_bicep_l.setRotationPoint(6.0F, -8.0F, 0.0F);
        this.fugu_bicep_l.addBox(0.0F, 0.0F, -3.0F, 10, 6, 6, 0.0F);
        this.setRotateAngle(fugu_bicep_l, 0.08726646259971647F, 0.0F, 0.5235987755982988F);
        this.fugu_ab = new AdvancedModelRenderer(this, 0, 32);
        this.fugu_ab.setRotationPoint(0.0F, -8.0F, 7.0F);
        this.fugu_ab.addBox(-4.0F, 0.0F, 0.0F, 8, 16, 10, 0.0F);
        this.setRotateAngle(fugu_ab, -0.3490658503988659F, 0.0F, 0.0F);
        this.fugu_hand_l = new AdvancedModelRenderer(this, 84, 32);
        this.fugu_hand_l.setRotationPoint(2.0F, 10.0F, 0.0F);
        this.fugu_hand_l.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(fugu_hand_l, 0.0F, 0.0F, -0.3490658503988659F);
        this.fugu_butt = new AdvancedModelRenderer(this, 0, 58);
        this.fugu_butt.setRotationPoint(0.0F, 10.0F, 2.0F);
        this.fugu_butt.addBox(-2.5F, 0.0F, 0.0F, 5, 6, 12, 0.0F);
        this.setRotateAngle(fugu_butt, -0.17453292519943295F, 0.0F, 0.0F);
        this.fugu_bicep_r = new AdvancedModelRenderer(this, 36, 32);
        this.fugu_bicep_r.mirror = true;
        this.fugu_bicep_r.setRotationPoint(-6.0F, -8.0F, 0.0F);
        this.fugu_bicep_r.addBox(-10.0F, 0.0F, -3.0F, 10, 6, 6, 0.0F);
        this.setRotateAngle(fugu_bicep_r, 0.08726646259971647F, 0.0F, -0.5235987755982988F);
        this.fugu_head = new AdvancedModelRenderer(this, 0, 0);
        this.fugu_head.setRotationPoint(0.0F, 11.5F, 0.0F);
        this.fugu_head.addBox(-6.0F, -12.0F, -10.0F, 12, 12, 20, 0.0F);
        this.setRotateAngle(fugu_head, 0.17453292519943295F, 0.0F, 0.0F);
        this.fugu_hand_r = new AdvancedModelRenderer(this, 84, 32);
        this.fugu_hand_r.mirror = true;
        this.fugu_hand_r.setRotationPoint(-2.0F, 10.0F, 0.0F);
        this.fugu_hand_r.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(fugu_hand_r, 0.0F, 0.0F, 0.3490658503988659F);
        this.fugu_tail = new AdvancedModelRenderer(this, 64, -9);
        this.fugu_tail.setRotationPoint(0.0F, 3.0F, 10.0F);
        this.fugu_tail.addBox(0.0F, -6.0F, 0.0F, 0, 12, 9, 0.0F);
        this.fugu_forearm_l = new AdvancedModelRenderer(this, 68, 32);
        this.fugu_forearm_l.setRotationPoint(6.0F, 4.0F, 0.0F);
        this.fugu_forearm_l.addBox(0.0F, 0.0F, -2.0F, 4, 11, 4, 0.0F);
        this.setRotateAngle(fugu_forearm_l, -0.2617993877991494F, 0.0F, -0.17453292519943295F);
        this.fugu_fin_1 = new AdvancedModelRenderer(this, 82, -6);
        this.fugu_fin_1.setRotationPoint(0.0F, -10.0F, 9.0F);
        this.fugu_fin_1.addBox(0.0F, -4.0F, 0.0F, 0, 4, 6, 0.0F);
        this.setRotateAngle(fugu_fin_1, 0.17453292519943295F, 0.0F, 0.0F);
        this.fugu_forearm_r = new AdvancedModelRenderer(this, 68, 32);
        this.fugu_forearm_r.mirror = true;
        this.fugu_forearm_r.setRotationPoint(-6.0F, 4.0F, 0.0F);
        this.fugu_forearm_r.addBox(-4.0F, 0.0F, -2.0F, 4, 11, 4, 0.0F);
        this.setRotateAngle(fugu_forearm_r, -0.2617993877991494F, 0.0F, 0.17453292519943295F);
        this.fugu_head.addChild(this.fugu_bicep_l);
        this.fugu_head.addChild(this.fugu_ab);
        this.fugu_forearm_l.addChild(this.fugu_hand_l);
        this.fugu_ab.addChild(this.fugu_butt);
        this.fugu_head.addChild(this.fugu_bicep_r);
        this.fugu_forearm_r.addChild(this.fugu_hand_r);
        this.fugu_butt.addChild(this.fugu_tail);
        this.fugu_bicep_l.addChild(this.fugu_forearm_l);
        this.fugu_head.addChild(this.fugu_fin_1);
        this.fugu_bicep_r.addChild(this.fugu_forearm_r);

        this.animator = ModelAnimator.create();
        fugu_parts = new AdvancedModelRenderer[]{
         fugu_head,
         fugu_ab,
         fugu_fin_1,
         fugu_bicep_l,
         fugu_bicep_r,
         fugu_butt,
         fugu_tail,
         fugu_forearm_l,
         fugu_hand_l,
         fugu_forearm_r,
         fugu_hand_r
        };

        updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animate(f, f1, f2, f3, f4, f5, entity);
        this.fugu_head.render(f5);
    }
    public void animate(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        EntityFugu fugu = (EntityFugu) entity;
        animator.update(fugu);
        if (fugu.getAnimation() == EntityFugu.LEAP_ANIMATION)
        {
            animator.setAnimation(EntityFugu.LEAP_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, fugu);
            this.animator.startKeyframe(0);
            this.animator.rotate(this.fugu_head, 0.0F, 0.0F, 0.0F);
            animator.endKeyframe();

            this.animator.startKeyframe(8);
            this.animator.move(this.fugu_head, 0.0F, 2.0F, 0.0F);
            this.animator.rotate(this.fugu_bicep_l, 0.0F, 0.0F, (float)(Math.toRadians(-20.0D)));
            this.animator.rotate(this.fugu_forearm_l, 0.0F, 0.0F, (float)(Math.toRadians(20.0D)));
            this.animator.rotate(this.fugu_bicep_r, 0.0F, 0.0F, (float)(Math.toRadians(20.0D)));
            this.animator.rotate(this.fugu_forearm_r, 0.0F, 0.0F, (float)(Math.toRadians(-20.0D)));
            animator.endKeyframe();
            animator.startKeyframe(7);
            this.animator.move(this.fugu_head, 0.0F, 13F, 0.0F);
            this.animator.rotate(this.fugu_ab, (float)(Math.toRadians(50.0D)), 0.0F, 0.0F);
            this.animator.rotate(this.fugu_bicep_l, (float)(Math.toRadians(-60.0D)), (float)(Math.toRadians(30.0D)), 0.0F);
            this.animator.rotate(this.fugu_bicep_r, (float)(Math.toRadians(-60.0D)), (float)(Math.toRadians(-30.0D)), 0.0F);
            this.animator.rotate(this.fugu_forearm_l, 0.0F, 0.0F, (float)(Math.toRadians(-20.0D)));
            this.animator.rotate(this.fugu_forearm_r, 0.0F, 0.0F, (float)(Math.toRadians(20.0D)));
            animator.endKeyframe();
            this.animator.setStaticKeyframe(10);
            this.animator.startKeyframe(2);
            this.animator.move(this.fugu_head, 0.0F, 10F, 0.0F);
            this.animator.rotate(this.fugu_ab, (float)(Math.toRadians(50.0D)), 0.0F, 0.0F);
            this.animator.rotate(this.fugu_bicep_l, (float)(Math.toRadians(-60.0D)), (float)(Math.toRadians(30.0D)), 0.0F);
            this.animator.rotate(this.fugu_bicep_r, (float)(Math.toRadians(-60.0D)), (float)(Math.toRadians(-30.0D)), 0.0F);
            this.animator.rotate(this.fugu_forearm_l, 0.0F, 0.0F, (float)(Math.toRadians(-20.0D)));
            this.animator.rotate(this.fugu_forearm_r, 0.0F, 0.0F, (float)(Math.toRadians(20.0D)));
            animator.endKeyframe();
            this.animator.startKeyframe(2);
            this.animator.move(this.fugu_head, 0.0F, 13F, 0.0F);
            this.animator.rotate(this.fugu_ab, (float)(Math.toRadians(50.0D)), 0.0F, 0.0F);
            this.animator.rotate(this.fugu_bicep_l, (float)(Math.toRadians(-60.0D)), (float)(Math.toRadians(30.0D)), 0.0F);
            this.animator.rotate(this.fugu_bicep_r, (float)(Math.toRadians(-60.0D)), (float)(Math.toRadians(-30.0D)), 0.0F);
            this.animator.rotate(this.fugu_forearm_l, 0.0F, 0.0F, (float)(Math.toRadians(-20.0D)));
            this.animator.rotate(this.fugu_forearm_r, 0.0F, 0.0F, (float)(Math.toRadians(20.0D)));
            animator.endKeyframe();
            animator.setStaticKeyframe(5);
            animator.resetKeyframe(10);
        }
        else if (fugu.getAnimation() == EntityFugu.LEAP_FLAIL_ANIMATION) {
            animator.setAnimation(EntityFugu.LEAP_FLAIL_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, fugu);
            this.animator.startKeyframe(0);
            this.animator.rotate(this.fugu_head, 0.0F, 0.0F, 0.0F);
            animator.endKeyframe();

            this.animator.startKeyframe(8);
            this.animator.move(this.fugu_head, 0.0F, 2.0F, 0.0F);
            this.animator.rotate(this.fugu_bicep_l, 0.0F, 0.0F, (float) (Math.toRadians(-20.0D)));
            this.animator.rotate(this.fugu_forearm_l, 0.0F, 0.0F, (float) (Math.toRadians(20.0D)));
            this.animator.rotate(this.fugu_bicep_r, 0.0F, 0.0F, (float) (Math.toRadians(20.0D)));
            this.animator.rotate(this.fugu_forearm_r, 0.0F, 0.0F, (float) (Math.toRadians(-20.0D)));
            animator.endKeyframe();
            animator.startKeyframe(7);
            this.animator.move(this.fugu_head, 0.0F, 13F, 0.0F);
            this.animator.rotate(this.fugu_ab, (float) (Math.toRadians(50.0D)), 0.0F, 0.0F);
            this.animator.rotate(this.fugu_bicep_l, (float) (Math.toRadians(-60.0D)), (float) (Math.toRadians(30.0D)), 0.0F);
            this.animator.rotate(this.fugu_bicep_r, (float) (Math.toRadians(-60.0D)), (float) (Math.toRadians(-30.0D)), 0.0F);
            this.animator.rotate(this.fugu_forearm_l, 0.0F, 0.0F, (float) (Math.toRadians(-20.0D)));
            this.animator.rotate(this.fugu_forearm_r, 0.0F, 0.0F, (float) (Math.toRadians(20.0D)));
            animator.endKeyframe();
            this.animator.setStaticKeyframe(10);
            this.animator.startKeyframe(2);
            this.animator.move(this.fugu_head, 0.0F, 10F, 0.0F);
            this.animator.rotate(this.fugu_ab, (float) (Math.toRadians(50.0D)), 0.0F, 0.0F);
            this.animator.rotate(this.fugu_bicep_l, (float) (Math.toRadians(-60.0D)), (float) (Math.toRadians(30.0D)), 0.0F);
            this.animator.rotate(this.fugu_bicep_r, (float) (Math.toRadians(-60.0D)), (float) (Math.toRadians(-30.0D)), 0.0F);
            this.animator.rotate(this.fugu_forearm_l, 0.0F, 0.0F, (float) (Math.toRadians(-20.0D)));
            this.animator.rotate(this.fugu_forearm_r, 0.0F, 0.0F, (float) (Math.toRadians(20.0D)));
            animator.endKeyframe();
            animator.setStaticKeyframe(5);
            this.animator.startKeyframe(2);
            this.animator.move(this.fugu_head, 0.0F, 13F, 0.0F);
            this.animator.rotate(this.fugu_ab, (float) (Math.toRadians(50.0D)), 0.0F, 0.0F);
            this.animator.rotate(this.fugu_bicep_l, (float) (Math.toRadians(-60.0D)), (float) (Math.toRadians(30.0D)), 0.0F);
            this.animator.rotate(this.fugu_bicep_r, (float) (Math.toRadians(-60.0D)), (float) (Math.toRadians(-30.0D)), 0.0F);
            this.animator.rotate(this.fugu_forearm_l, 0.0F, 0.0F, (float) (Math.toRadians(-20.0D)));
            this.animator.rotate(this.fugu_forearm_r, 0.0F, 0.0F, (float) (Math.toRadians(20.0D)));

            animator.rotate(this.fugu_head, 0.0F, (float)Math.toRadians(30.0F), 0.0F);
            animator.rotate(this.fugu_ab, 0.0F, (float)Math.toRadians(30.0F), 0.0F);
            animator.rotate(this.fugu_butt, 0.0F, (float)Math.toRadians(30.0F), 0.0F);
            animator.rotate(this.fugu_tail, 0.0F, (float)Math.toRadians(30.0F), 0.0F);
            animator.endKeyframe();

            this.animator.startKeyframe(2);
            this.animator.move(this.fugu_head, 0.0F, 13F, 0.0F);
            this.animator.rotate(this.fugu_ab, (float) (Math.toRadians(50.0D)), 0.0F, 0.0F);
            this.animator.rotate(this.fugu_bicep_l, (float) (Math.toRadians(-60.0D)), (float) (Math.toRadians(30.0D)), 0.0F);
            this.animator.rotate(this.fugu_bicep_r, (float) (Math.toRadians(-60.0D)), (float) (Math.toRadians(-30.0D)), 0.0F);
            this.animator.rotate(this.fugu_forearm_l, 0.0F, 0.0F, (float) (Math.toRadians(-20.0D)));
            this.animator.rotate(this.fugu_forearm_r, 0.0F, 0.0F, (float) (Math.toRadians(20.0D)));

            animator.rotate(this.fugu_head, 0.0F, (float)Math.toRadians(-30.0F), 0.0F);
            animator.rotate(this.fugu_ab, 0.0F, (float)Math.toRadians(-30.0F), 0.0F);
            animator.rotate(this.fugu_butt, 0.0F, (float)Math.toRadians(-30.0F), 0.0F);
            animator.rotate(this.fugu_tail, 0.0F, (float)Math.toRadians(-30.0F), 0.0F);
            animator.endKeyframe();

            animator.setStaticKeyframe(5);
            animator.resetKeyframe(10);
        }
        else if (fugu.getAnimation() == EntityFugu.PUNCH_ANIMATION)
        {
            animator.setAnimation(EntityFugu.PUNCH_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, fugu);
            this.animator.startKeyframe(0);
            this.animator.rotate(this.fugu_head, 0.0F, 0.0F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(2);
            animator.rotate(this.fugu_head, 0F, (float)Math.toRadians(-30.0D), 0.0F);
            animator.rotate(this.fugu_bicep_l, (float)Math.toRadians(40.0D), 0.0F, 0.0F);
            animator.rotate(this.fugu_forearm_l, (float)Math.toRadians(-190.0D), 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(4);
            animator.startKeyframe(2);
            animator.rotate(this.fugu_head, 0F, (float)Math.toRadians(30.0D), 0.0F);
            animator.rotate(this.fugu_bicep_l, (float)Math.toRadians(-50.0D),  0.0F, 0.0F);
            animator.rotate(this.fugu_forearm_l, (float)Math.toRadians(-30.0D), 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(3);

            animator.startKeyframe(2);
            animator.rotate(this.fugu_head, 0F, (float)Math.toRadians(-30.0D), 0.0F);
            animator.rotate(this.fugu_bicep_l, (float)Math.toRadians(40.0D), 0.0F, 0.0F);
            animator.rotate(this.fugu_forearm_l, (float)Math.toRadians(-190.0D), 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(3);
            animator.resetKeyframe(4);
        }
        else if (fugu.getAnimation() == EntityFugu.TAIL_ANIMATION)
        {
            animator.setAnimation(EntityFugu.TAIL_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, fugu);
            this.animator.startKeyframe(0);
            this.animator.rotate(this.fugu_head, 0.0F, 0.0F, 0.0F);
            animator.endKeyframe();

            this.animator.startKeyframe(4);
            this.animator.move(this.fugu_head, 0.0F, 2.0F, 0.0F);
            this.animator.rotate(this.fugu_bicep_l, 0.0F, 0.0F, (float) (Math.toRadians(-20.0D)));
            this.animator.rotate(this.fugu_forearm_l, 0.0F, 0.0F, (float) (Math.toRadians(20.0D)));
            this.animator.rotate(this.fugu_bicep_r, 0.0F, 0.0F, (float) (Math.toRadians(20.0D)));
            this.animator.rotate(this.fugu_forearm_r, 0.0F, 0.0F, (float) (Math.toRadians(-20.0D)));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            this.animator.startKeyframe(2);
            this.animator.move(this.fugu_head, 0.0F, 13F, 0.0F);
            this.animator.rotate(this.fugu_head, 0.0F, (float)Math.toRadians(180.0F), 0.0F);
            this.animator.rotate(this.fugu_ab, (float) (Math.toRadians(50.0D)), 0.0F, 0.0F);
            this.animator.rotate(this.fugu_bicep_l, (float) (Math.toRadians(-60.0D)), (float) (Math.toRadians(30.0D)), 0.0F);
            this.animator.rotate(this.fugu_bicep_r, (float) (Math.toRadians(-60.0D)), (float) (Math.toRadians(-30.0D)), 0.0F);
            this.animator.rotate(this.fugu_forearm_l, 0.0F, 0.0F, (float) (Math.toRadians(-20.0D)));
            this.animator.rotate(this.fugu_forearm_r, 0.0F, 0.0F, (float) (Math.toRadians(20.0D)));
            animator.endKeyframe();

            this.animator.startKeyframe(5);
            this.animator.move(this.fugu_head, 0.0F, 13F, 0.0F);
            this.animator.rotate(this.fugu_head, 0.0F, (float)Math.toRadians(180.0F), 0.0F);
            this.animator.rotate(this.fugu_ab, (float) (Math.toRadians(50.0D)), 0.0F, 0.0F);
            this.animator.rotate(this.fugu_bicep_l, (float) (Math.toRadians(-60.0D)), (float) (Math.toRadians(30.0D)), 0.0F);
            this.animator.rotate(this.fugu_bicep_r, (float) (Math.toRadians(-60.0D)), (float) (Math.toRadians(-30.0D)), 0.0F);
            this.animator.rotate(this.fugu_forearm_l, 0.0F, 0.0F, (float) (Math.toRadians(-20.0D)));
            this.animator.rotate(this.fugu_forearm_r, 0.0F, 0.0F, (float) (Math.toRadians(20.0D)));
            animator.rotate(this.fugu_head, 0.0F, (float)Math.toRadians(30.0F), 0.0F);
            animator.rotate(this.fugu_ab, 0.0F, (float)Math.toRadians(30.0F), 0.0F);
            animator.rotate(this.fugu_butt, 0.0F, (float)Math.toRadians(30.0F), 0.0F);
            animator.rotate(this.fugu_tail, 0.0F, (float)Math.toRadians(30.0F), 0.0F);
            animator.endKeyframe();
            this.animator.setStaticKeyframe(5);

            this.animator.startKeyframe(2);
            this.animator.move(this.fugu_head, 0.0F, 13F, 0.0F);
            this.animator.rotate(this.fugu_head, 0.0F, (float)Math.toRadians(180.0F), 0.0F);
            this.animator.rotate(this.fugu_ab, (float) (Math.toRadians(50.0D)), 0.0F, 0.0F);
            this.animator.rotate(this.fugu_bicep_l, (float) (Math.toRadians(-60.0D)), (float) (Math.toRadians(30.0D)), 0.0F);
            this.animator.rotate(this.fugu_bicep_r, (float) (Math.toRadians(-60.0D)), (float) (Math.toRadians(-30.0D)), 0.0F);
            this.animator.rotate(this.fugu_forearm_l, 0.0F, 0.0F, (float) (Math.toRadians(-20.0D)));
            this.animator.rotate(this.fugu_forearm_r, 0.0F, 0.0F, (float) (Math.toRadians(20.0D)));
            animator.rotate(this.fugu_head, 0.0F, (float)Math.toRadians(-30.0F), 0.0F);
            animator.rotate(this.fugu_ab, 0.0F, (float)Math.toRadians(-30.0F), 0.0F);
            animator.rotate(this.fugu_butt, 0.0F, (float)Math.toRadians(-30.0F), 0.0F);
            animator.rotate(this.fugu_tail, 0.0F, (float)Math.toRadians(-30.0F), 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(5);
            this.animator.startKeyframe(5);
            this.animator.move(this.fugu_head, 0.0F, 13F, 0.0F);
            this.animator.rotate(this.fugu_head, 0.0F, (float)Math.toRadians(180.0F), 0.0F);
            this.animator.rotate(this.fugu_ab, (float) (Math.toRadians(50.0D)), 0.0F, 0.0F);
            this.animator.rotate(this.fugu_bicep_l, (float) (Math.toRadians(-60.0D)), (float) (Math.toRadians(30.0D)), 0.0F);
            this.animator.rotate(this.fugu_bicep_r, (float) (Math.toRadians(-60.0D)), (float) (Math.toRadians(-30.0D)), 0.0F);
            this.animator.rotate(this.fugu_forearm_l, 0.0F, 0.0F, (float) (Math.toRadians(-20.0D)));
            this.animator.rotate(this.fugu_forearm_r, 0.0F, 0.0F, (float) (Math.toRadians(20.0D)));
            animator.rotate(this.fugu_head, 0.0F, (float)Math.toRadians(30.0F), 0.0F);
            animator.rotate(this.fugu_ab, 0.0F, (float)Math.toRadians(30.0F), 0.0F);
            animator.rotate(this.fugu_butt, 0.0F, (float)Math.toRadians(30.0F), 0.0F);
            animator.rotate(this.fugu_tail, 0.0F, (float)Math.toRadians(30.0F), 0.0F);
            animator.endKeyframe();
            this.animator.setStaticKeyframe(5);

            this.animator.startKeyframe(2);
            this.animator.move(this.fugu_head, 0.0F, 13F, 0.0F);
            this.animator.rotate(this.fugu_head, 0.0F, (float)Math.toRadians(180.0F), 0.0F);
            this.animator.rotate(this.fugu_ab, (float) (Math.toRadians(50.0D)), 0.0F, 0.0F);
            this.animator.rotate(this.fugu_bicep_l, (float) (Math.toRadians(-60.0D)), (float) (Math.toRadians(30.0D)), 0.0F);
            this.animator.rotate(this.fugu_bicep_r, (float) (Math.toRadians(-60.0D)), (float) (Math.toRadians(-30.0D)), 0.0F);
            this.animator.rotate(this.fugu_forearm_l, 0.0F, 0.0F, (float) (Math.toRadians(-20.0D)));
            this.animator.rotate(this.fugu_forearm_r, 0.0F, 0.0F, (float) (Math.toRadians(20.0D)));
            animator.rotate(this.fugu_head, 0.0F, (float)Math.toRadians(-30.0F), 0.0F);
            animator.rotate(this.fugu_ab, 0.0F, (float)Math.toRadians(-30.0F), 0.0F);
            animator.rotate(this.fugu_butt, 0.0F, (float)Math.toRadians(-30.0F), 0.0F);
            animator.rotate(this.fugu_tail, 0.0F, (float)Math.toRadians(-30.0F), 0.0F);
            animator.endKeyframe();
            animator.resetKeyframe(5);
        }
        else  if (fugu.getAnimation() == EntityFugu.HURT_ANIMATION) {
            animator.setAnimation(EntityFugu.HURT_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, fugu);
            this.animator.startKeyframe(0);
            this.animator.rotate(this.fugu_head, 0.0F, 0.0F, 0.0F);
            animator.endKeyframe();

            this.animator.startKeyframe(2);
            this.animator.move(this.fugu_head, 0.0F, 2.0F, 0.0F);
            this.animator.rotate(this.fugu_head, 0.0F, (float)Math.toRadians(-30.0F), 0.0F);
            this.animator.rotate(this.fugu_bicep_l, 0.0F, 0.0F, (float) (Math.toRadians(-20.0D)));
            this.animator.rotate(this.fugu_forearm_l, 0.0F, 0.0F, (float) (Math.toRadians(20.0D)));
            this.animator.rotate(this.fugu_bicep_r, 0.0F, 0.0F, (float) (Math.toRadians(20.0D)));
            this.animator.rotate(this.fugu_forearm_r, 0.0F, 0.0F, (float) (Math.toRadians(-20.0D)));
            animator.endKeyframe();
            animator.setStaticKeyframe(2);
            animator.resetKeyframe(1);
        }
        else
        {
            setRotationAngles(f, f1, f2, f3, f4, f5, fugu);
        }
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, EntityFugu entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        resetToDefaultPose();

        faceTarget(netHeadYaw, 0.0F, 1.0F, this.fugu_head);

        float walkspeed =1F;
        float walkheight = 1.5F;
        float walkdegree = 1F;

        if (entityIn.getAnimation() == IAnimatedEntity.NO_ANIMATION)
        {
            if (entityIn.motionX == 0 && entityIn.motionZ == 0)
            {
                bob(this.fugu_head,  walkspeed * 0.25F, walkheight, false, entityIn.ticksExisted, 0.5F);
                bob(this.fugu_bicep_l,  walkspeed * 0.25F, -walkheight, false, entityIn.ticksExisted, 0.5F);
                bob(this.fugu_bicep_r,   walkspeed * 0.25F, -walkheight, false, entityIn.ticksExisted, 0.5F);

                walk(this.fugu_ab, walkspeed * 0.125F, walkdegree * 0.25F, false, 0, 0.125F,  entityIn.ticksExisted, 0.5F);
                walk(this.fugu_butt, walkspeed * 0.125F, walkdegree * 0.125F, true, 0, 0.125F,  entityIn.ticksExisted, 0.5F);
            }
        }
        if ((entityIn.getAnimation() != EntityFugu.LEAP_ANIMATION) && entityIn.getAnimation() != EntityFugu.LEAP_FLAIL_ANIMATION)
        {
            swing(this.fugu_head, walkspeed, 0.5F * walkdegree, true, 0, 0.125F,  limbSwing, limbSwingAmount);
            bob(this.fugu_bicep_l, walkspeed, walkheight, true,  limbSwing, limbSwingAmount);
            bob(this.fugu_bicep_r, walkspeed, walkheight, true, limbSwing, limbSwingAmount);
            walk(this.fugu_bicep_l, walkspeed, walkdegree, false, 0, 0.125F,  limbSwing, limbSwingAmount);
            walk(this.fugu_bicep_r, walkspeed, walkdegree, true, 0, 0.125F,  limbSwing, limbSwingAmount);
            walk(this.fugu_forearm_l,  walkspeed, walkdegree, true, 0.5F, 0.125F, limbSwing, limbSwingAmount);
            walk(this.fugu_forearm_r,  walkspeed, walkdegree, false, 0.5F, 0.125F,  limbSwing, limbSwingAmount);

            walk(this.fugu_ab, walkspeed * 0.25F, walkdegree* 0.5F, false, 0, 0.125F,  limbSwing, limbSwingAmount);
            walk(this.fugu_butt, walkspeed * 0.25F, walkdegree * 0.25F, true, 0, 0.125F,  limbSwing, limbSwingAmount);
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
