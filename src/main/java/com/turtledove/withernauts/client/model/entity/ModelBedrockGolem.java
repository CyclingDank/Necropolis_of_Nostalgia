package com.turtledove.withernauts.client.model.entity;

import com.turtledove.withernauts.server.entity.enemies.EntityBedrockGolem;
import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelBedrockGolem - dfdf
 * Created using Tabula 7.1.0
 */
public class ModelBedrockGolem extends AdvancedModelBase {
    public AdvancedModelRenderer bg_ab;
    public AdvancedModelRenderer bg_chest;
    public AdvancedModelRenderer bg_thigh_r;
    public AdvancedModelRenderer bg_thigh_l;
    public AdvancedModelRenderer bg_bicep_r;
    public AdvancedModelRenderer bg_bicep_l;
    public AdvancedModelRenderer bg_waist;
    public AdvancedModelRenderer bg_eye;
    public AdvancedModelRenderer bg_forearm_r;
    public AdvancedModelRenderer bg_forearm_l;
    public AdvancedModelRenderer bg_sword_1;
    public AdvancedModelRenderer bg_calf_r;
    public AdvancedModelRenderer bg_calf_l;

    public AdvancedModelRenderer[] bg_parts;
    private ModelAnimator animator;

    public ModelBedrockGolem() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.bg_waist = new AdvancedModelRenderer(this, 0, 64);
        this.bg_waist.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bg_waist.addBox(-5.0F, -2.0F, -5.0F, 10, 4, 10, 0.0F);
        this.setRotateAngle(bg_waist, 0.0F, 0.7853981633974483F, 0.0F);
        this.bg_thigh_r = new AdvancedModelRenderer(this, 0, 43);
        this.bg_thigh_r.setRotationPoint(-4.0F, 0.0F, 2.5F);
        this.bg_thigh_r.addBox(-5.0F, 0.0F, -2.5F, 5, 8, 5, 0.0F);
        this.setRotateAngle(bg_thigh_r, -0.6981317007977318F, 0.0F, 0.17453292519943295F);
        this.bg_sword_1 = new AdvancedModelRenderer(this, 0, 90);
        this.bg_sword_1.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.bg_sword_1.addBox(-0.5F, 0.0F, -2.0F, 1, 14, 4, 0.0F);
        this.bg_calf_l = new AdvancedModelRenderer(this, 0, 56);
        this.bg_calf_l.mirror = true;
        this.bg_calf_l.setRotationPoint(2.5F, 8.0F, 0.0F);
        this.bg_calf_l.addBox(-2.5F, 0.0F, -1.0F, 5, 3, 5, 0.0F);
        this.setRotateAngle(bg_calf_l, 0.6981317007977318F, 0.0F, 0.17453292519943295F);
        this.bg_forearm_r = new AdvancedModelRenderer(this, 64, 0);
        this.bg_forearm_r.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.bg_forearm_r.addBox(-2.5F, 0.0F, -3.5F, 5, 10, 7, 0.0F);
        this.setRotateAngle(bg_forearm_r, -1.3962634015954636F, 0.0F, -0.3490658503988659F);
        this.bg_thigh_l = new AdvancedModelRenderer(this, 0, 43);
        this.bg_thigh_l.mirror = true;
        this.bg_thigh_l.setRotationPoint(4.0F, 0.0F, 2.5F);
        this.bg_thigh_l.addBox(0.0F, 0.0F, -2.5F, 5, 8, 5, 0.0F);
        this.setRotateAngle(bg_thigh_l, -0.6981317007977318F, 0.0F, -0.17453292519943295F);
        this.bg_chest = new AdvancedModelRenderer(this, 0, 0);
        this.bg_chest.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.bg_chest.addBox(-9.0F, -13.0F, -7.0F, 18, 13, 14, 0.0F);
        this.setRotateAngle(bg_chest, 0.17453292519943295F, 0.0F, 0.0F);
        this.bg_bicep_r = new AdvancedModelRenderer(this, 88, 0);
        this.bg_bicep_r.setRotationPoint(-9.0F, -9.0F, 0.0F);
        this.bg_bicep_r.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, 0.0F);
        this.setRotateAngle(bg_bicep_r, -0.17453292519943295F, 0.0F, 0.5235987755982988F);
        this.bg_eye = new AdvancedModelRenderer(this, 100, 0);
        this.bg_eye.setRotationPoint(5.0F, -9.0F, -8.0F);
        this.bg_eye.addBox(-3.0F, -2.5F, -1.0F, 6, 5, 2, 0.0F);
        this.setRotateAngle(bg_eye, 0.0F, 0.0F, -0.5462880558742251F);
        this.bg_ab = new AdvancedModelRenderer(this, 0, 27);
        this.bg_ab.setRotationPoint(0.0F, 15.5F, 0.0F);
        this.bg_ab.addBox(-3.5F, -9.0F, -3.5F, 7, 9, 7, 0.0F);
        this.bg_forearm_l = new AdvancedModelRenderer(this, 64, 0);
        this.bg_forearm_l.mirror = true;
        this.bg_forearm_l.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.bg_forearm_l.addBox(-2.5F, 0.0F, -3.5F, 5, 10, 7, 0.0F);
        this.setRotateAngle(bg_forearm_l, -0.6981317007977318F, 0.0F, 0.17453292519943295F);
        this.bg_bicep_l = new AdvancedModelRenderer(this, 88, 0);
        this.bg_bicep_l.mirror = true;
        this.bg_bicep_l.setRotationPoint(9.0F, -9.0F, 0.0F);
        this.bg_bicep_l.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, 0.0F);
        this.setRotateAngle(bg_bicep_l, -0.17453292519943295F, 0.0F, -0.5235987755982988F);
        this.bg_calf_r = new AdvancedModelRenderer(this, 0, 56);
        this.bg_calf_r.setRotationPoint(-2.5F, 8.0F, 0.0F);
        this.bg_calf_r.addBox(-2.5F, 0.0F, -1.0F, 5, 3, 5, 0.0F);
        this.setRotateAngle(bg_calf_r, 0.6981317007977318F, 0.0F, -0.17453292519943295F);
        this.bg_ab.addChild(this.bg_thigh_r);
        this.bg_forearm_l.addChild(this.bg_sword_1);
        this.bg_thigh_l.addChild(this.bg_calf_l);
        this.bg_bicep_r.addChild(this.bg_forearm_r);
        this.bg_ab.addChild(this.bg_thigh_l);
        this.bg_ab.addChild(this.bg_chest);
        this.bg_chest.addChild(this.bg_bicep_r);
        this.bg_chest.addChild(this.bg_eye);
        this.bg_bicep_l.addChild(this.bg_forearm_l);
        this.bg_chest.addChild(this.bg_bicep_l);
        this.bg_thigh_r.addChild(this.bg_calf_r);
        this.bg_ab.addChild(this.bg_waist);

        animator = ModelAnimator.create();
        bg_parts = new AdvancedModelRenderer[] {
        bg_ab,
        bg_chest,
        bg_thigh_r,
        bg_thigh_l,
        bg_bicep_r,
        bg_bicep_l,
        bg_eye,
        bg_forearm_r,
        bg_forearm_l,
        bg_sword_1,
        bg_calf_r,
        bg_calf_l
        };
        updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animate(f, f1, f2, f3, f4, f5, entity);
        this.bg_ab.render(f5);
    }
    public void animate(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        EntityBedrockGolem bGolem = (EntityBedrockGolem)entity;
        animator.update(bGolem);
        if (bGolem.getAnimation() == EntityBedrockGolem.PUNCH_ANIMATION)
        {
            animator.setAnimation(EntityBedrockGolem.PUNCH_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, bGolem);

            animator.startKeyframe(0);
            animator.rotate(this.bg_ab, 0F, 0.0F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(5);
            animator.rotate(this.bg_chest, 0F, (float)Math.toRadians(30.0D), 0.0F);
            animator.rotate(this.bg_bicep_r, (float)Math.toRadians(40.0D), 0.0F, 0.0F);
            animator.rotate(this.bg_forearm_r, (float)Math.toRadians(-30.0D), 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(3);

            animator.startKeyframe(3);
            animator.rotate(this.bg_chest, 0F, (float)Math.toRadians(-30.0D), 0.0F);
            animator.rotate(this.bg_bicep_r, (float)Math.toRadians(-60.0D), 0.0F, 0.0F);
            animator.rotate(this.bg_forearm_r, (float)Math.toRadians(70.0D), 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(3);
            animator.resetKeyframe(3);
        }
        else if (bGolem.getAnimation() == EntityBedrockGolem.GROUND_ANIMATION)
        {
            animator.setAnimation(EntityBedrockGolem.GROUND_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, bGolem);

            animator.startKeyframe(0);
            animator.rotate(this.bg_ab, 0F, 0.0F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(5);
            animator.rotate(this.bg_chest, 0F, (float)Math.toRadians(30.0D), 0.0F);
            animator.rotate(this.bg_bicep_r, (float)Math.toRadians(40.0D), 0.0F, 0.0F);
            animator.rotate(this.bg_forearm_r, (float)Math.toRadians(-30.0D), 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(3);

            animator.startKeyframe(3);
            animator.rotate(this.bg_chest, (float)Math.toRadians(35.0D), (float)Math.toRadians(-30.0D), 0.0F);
            animator.rotate(this.bg_ab, (float)Math.toRadians(20.0D), 0.0F, 0.0F);

            animator.rotate(this.bg_bicep_r, (float)Math.toRadians(-60.0D), 0.0F, 0.0F);
            animator.rotate(this.bg_forearm_r, (float)Math.toRadians(70.0D), 0.0F, 0.0F);
            animator.rotate(this.bg_thigh_r, (float)Math.toRadians(-20.0D), 0.0F, 0.0F);
            animator.rotate(this.bg_thigh_l, (float)Math.toRadians(-10.0D), 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(73);
            animator.resetKeyframe(3);
        }
        else if (bGolem.getAnimation() == EntityBedrockGolem.SWIPE_ANIMATION)
        {
            animator.setAnimation(EntityBedrockGolem.SWIPE_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, bGolem);

            animator.startKeyframe(0);
            animator.rotate(this.bg_ab, 0F, 0.0F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(3);
            animator.rotate(this.bg_chest, 0F, (float)Math.toRadians(-30.0D), 0.0F);
            animator.rotate(this.bg_bicep_l, (float)Math.toRadians(30.0D), 0.0F, 0.0F);
            animator.rotate(this.bg_forearm_l, (float)Math.toRadians(40.0D), 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(3);
            animator.startKeyframe(5);
            animator.rotate(this.bg_chest, 0F, (float)Math.toRadians(30.0D), 0.0F);
            animator.rotate(this.bg_bicep_l, (float)Math.toRadians(-70.0D), 0.0F, 0.0F);
            animator.rotate(this.bg_forearm_l, (float)Math.toRadians(-20.0D), 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(3);
            animator.resetKeyframe(3);
        }
        else if (bGolem.getAnimation() == EntityBedrockGolem.PUNCH_SWIPE_ANIMATION)
        {
            animator.setAnimation(EntityBedrockGolem.PUNCH_SWIPE_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, bGolem);

            animator.startKeyframe(0);
            animator.rotate(this.bg_ab, 0F, 0.0F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(5);
            animator.rotate(this.bg_chest, 0F, (float)Math.toRadians(30.0D), 0.0F);
            animator.rotate(this.bg_bicep_r, (float)Math.toRadians(40.0D), 0.0F, 0.0F);
            animator.rotate(this.bg_forearm_r, (float)Math.toRadians(-30.0D), 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(1);

            animator.startKeyframe(3);
            animator.rotate(this.bg_chest, 0F, (float)Math.toRadians(-30.0D), 0.0F);
            animator.rotate(this.bg_bicep_r, (float)Math.toRadians(-60.0D), 0.0F, 0.0F);
            animator.rotate(this.bg_forearm_r, (float)Math.toRadians(70.0D), 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(4);

            animator.startKeyframe(3);
            animator.rotate(this.bg_chest, 0F, (float)Math.toRadians(30.0D), 0.0F);
            animator.rotate(this.bg_bicep_l, (float)Math.toRadians(-70.0D), 0.0F, 0.0F);
            animator.rotate(this.bg_forearm_l, (float)Math.toRadians(-20.0D), 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(5);
            animator.resetKeyframe(3);
        }
        else if (bGolem.getAnimation() == EntityBedrockGolem.STOMP_ANIMATION) {
            animator.setAnimation(EntityBedrockGolem.STOMP_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, bGolem);
            animator.startKeyframe(0);
            animator.rotate(this.bg_ab, 0F, 0.0F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(5);
            animator.rotate(this.bg_ab, 0.0F, 0.0F, (float)Math.toRadians(-20.0D));
            animator.rotate(this.bg_thigh_r, 0.0F, 0.0F, (float)Math.toRadians(20.0D));
            animator.rotate(this.bg_thigh_l, (float)Math.toRadians(-30.0D), 0.0F, 0.0F);
            animator.rotate(this.bg_bicep_l, 0.0F, 0.0F, (float)Math.toRadians(-10.0D));
            animator.rotate(this.bg_bicep_r, 0.0F, 0.0F, (float)Math.toRadians(10.0D));
            animator.endKeyframe();
            animator.setStaticKeyframe(10);

            animator.startKeyframe(3);
            animator.rotate(this.bg_ab, 0.0F, 0.0F, (float)Math.toRadians(30.0D));
            animator.rotate(this.bg_thigh_r, 0.0F, 0.0F, (float)Math.toRadians(-30.0D));

            animator.endKeyframe();
            animator.setStaticKeyframe(20);
            animator.resetKeyframe(4);
        }
        else if (bGolem.getAnimation() == EntityBedrockGolem.STAB_ANIMATION) {
            animator.setAnimation(EntityBedrockGolem.STAB_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, bGolem);
            animator.startKeyframe(0);
            animator.rotate(this.bg_ab, 0F, 0.0F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(2);
            animator.rotate(this.bg_chest, 0F, (float)Math.toRadians(-30.0D), 0.0F);
            animator.rotate(this.bg_bicep_l, (float)Math.toRadians(40.0D), 0.0F, 0.0F);
            animator.rotate(this.bg_forearm_l, (float)Math.toRadians(-70.0D), 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(4);
            animator.startKeyframe(2);
            animator.rotate(this.bg_chest, 0F, (float)Math.toRadians(30.0D), 0.0F);
            animator.rotate(this.bg_bicep_l, (float)Math.toRadians(-50.0D),  (float)Math.toRadians(-30.0D), 0.0F);
            animator.rotate(this.bg_forearm_l, (float)Math.toRadians(30.0D), 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(3);
            animator.resetKeyframe(3);
        }

        else if (bGolem.getAnimation() == EntityBedrockGolem.STAB_STAB_ANIMATION) {
            animator.setAnimation(EntityBedrockGolem.STAB_STAB_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, bGolem);
            animator.startKeyframe(0);
            animator.rotate(this.bg_ab, 0F, 0.0F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(2);
            animator.rotate(this.bg_chest, 0F, (float)Math.toRadians(-30.0D), 0.0F);
            animator.rotate(this.bg_bicep_l, (float)Math.toRadians(40.0D), 0.0F, 0.0F);
            animator.rotate(this.bg_forearm_l, (float)Math.toRadians(-70.0D), 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(4);
            animator.startKeyframe(2);
            animator.rotate(this.bg_chest, 0F, (float)Math.toRadians(30.0D), 0.0F);
            animator.rotate(this.bg_bicep_l, (float)Math.toRadians(-50.0D),  (float)Math.toRadians(-30.0D), 0.0F);
            animator.rotate(this.bg_forearm_l, (float)Math.toRadians(30.0D), 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(3);

            animator.startKeyframe(2);
            animator.rotate(this.bg_chest, 0F, (float)Math.toRadians(-30.0D), 0.0F);
            animator.rotate(this.bg_bicep_l, (float)Math.toRadians(40.0D), 0.0F, 0.0F);
            animator.rotate(this.bg_forearm_l, (float)Math.toRadians(-70.0D), 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(12);
            animator.startKeyframe(2);
            animator.rotate(this.bg_chest, 0F, (float)Math.toRadians(30.0D), 0.0F);
            animator.rotate(this.bg_bicep_l, (float)Math.toRadians(-50.0D),  (float)Math.toRadians(-30.0D), 0.0F);
            animator.rotate(this.bg_forearm_l, (float)Math.toRadians(30.0D), 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(3);
            animator.resetKeyframe(3);
        }
        else if (bGolem.getAnimation() == EntityBedrockGolem.HURT_ANIMATION) {
            animator.setAnimation(EntityBedrockGolem.HURT_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, bGolem);
            animator.startKeyframe(0);
            animator.rotate(this.bg_ab, 0F, 0.0F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(2);
            animator.rotate(this.bg_ab, 0.0F, 0.0F, (float)Math.toRadians(-20.0D));
            animator.rotate(this.bg_thigh_r, 0.0F, 0.0F, (float)Math.toRadians(20.0D));
            animator.rotate(this.bg_thigh_l, (float)Math.toRadians(-30.0D), 0.0F, 0.0F);
            animator.rotate(this.bg_bicep_l, 0.0F, 0.0F, (float)Math.toRadians(-10.0D));
            animator.rotate(this.bg_bicep_r, 0.0F, 0.0F, (float)Math.toRadians(10.0D));
            animator.endKeyframe();
            animator.setStaticKeyframe(4);
            animator.resetKeyframe(1);
        }
        else
        {
            setRotationAngles(f, f1, f2, f3, f4, f5, bGolem);
        }
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, EntityBedrockGolem entityIn)
    {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        resetToDefaultPose();

        faceTarget(netHeadYaw, 0.0F, 1.0F, this.bg_ab);

        float walkheight =1.5F;
        float walkspeed = 1F;
        float walkdegree = 2F;

        walk(this.bg_thigh_r, walkspeed, walkdegree, false, 0F, 0F, limbSwing, limbSwingAmount * 0.5F);
        walk(this.bg_thigh_l, walkspeed, walkdegree, true, 0F, 0F, limbSwing, limbSwingAmount * 0.5F);
        if (entityIn.getAnimation() == IAnimatedEntity.NO_ANIMATION)
        {
            walk(this.bg_bicep_r, walkspeed, walkdegree / 4F, true, 0F, 0F, limbSwing, limbSwingAmount * 0.5F);
            walk(this.bg_bicep_l, walkspeed, walkdegree / 4F, false, 0F, 0F, limbSwing, limbSwingAmount * 0.5F);
            swing(this.bg_chest,  walkspeed, 0.06F * walkdegree, false, 0, 0.125F, limbSwing, limbSwingAmount * 0.5F);
            swing(this.bg_waist,  walkspeed, 0.06F * walkdegree, false, 0, 0.125F, limbSwing, limbSwingAmount * 0.5F);

            walk(this.bg_forearm_l, walkspeed, walkdegree / 4F, false, 0F, 0F, limbSwing, limbSwingAmount * 0.5F);

            bob(this.bg_ab, walkspeed, -1F * walkheight, true, limbSwing, limbSwingAmount * 0.5F);
            bob(this.bg_chest, walkspeed, -2F * walkheight, true, limbSwing, limbSwingAmount * 0.5F);
            bob(this.bg_bicep_l, walkspeed, -1F * walkheight, true, limbSwing, limbSwingAmount * 0.5F);
            bob(this.bg_bicep_r, walkspeed, -1F * walkheight, true, limbSwing, limbSwingAmount * 0.5F);

            if (entityIn.motionX == 0 && entityIn.motionZ == 0)
            {
                bob(this.bg_chest,  walkspeed * 0.25F, walkheight, false, entityIn.ticksExisted, 0.5F);
                bob(this.bg_bicep_l,  walkspeed * 0.25F, walkheight, true, entityIn.ticksExisted, 0.5F);
                bob(this.bg_bicep_r,   walkspeed * 0.25F, walkheight, true, entityIn.ticksExisted, 0.5F);
            }
        }
        bob(this.bg_thigh_r, walkspeed ,  2.0F * walkheight, true, limbSwing, limbSwingAmount);
        bob(this.bg_thigh_l, walkspeed,  2.0F * walkheight, true, limbSwing, limbSwingAmount);
        bob(this.bg_calf_l, walkspeed, -1F * walkheight, true, limbSwing, limbSwingAmount * 0.5F);
        bob(this.bg_calf_r, walkspeed, -1F * walkheight, true, limbSwing, limbSwingAmount * 0.5F);
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
