package com.turtledove.withernauts.client.model.entity;

import com.turtledove.withernauts.server.entity.enemies.EntityNecropolisSkeleton;
import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelNecropolisSkeleton  extends AdvancedModelBase
{
    public AdvancedModelRenderer skeleton_thigh_right;
    public AdvancedModelRenderer skeleton_thigh_left;
    public AdvancedModelRenderer skeleton_waist;
    public AdvancedModelRenderer skeleton_calf_right;
    public AdvancedModelRenderer skeleton_knee_right;
    public AdvancedModelRenderer skeleton_calf_left;
    public AdvancedModelRenderer skeleton_knee_left;
    public AdvancedModelRenderer skeleton_spine;
    public AdvancedModelRenderer skeleton_upper_torso;
    public AdvancedModelRenderer skeleton_head;
    public AdvancedModelRenderer skeleton_shouler_left;
    public AdvancedModelRenderer skeleton_shoulder_right;
    public AdvancedModelRenderer skeleton_bicep_left;
    public AdvancedModelRenderer skeleton_elbow_left;
    public AdvancedModelRenderer skeleton_forearm_left;
    public AdvancedModelRenderer skeleton_hand_1_left;
    public AdvancedModelRenderer knife_hilt_left;
    public AdvancedModelRenderer skeleton_hand_2_left;
    public AdvancedModelRenderer knife_pommel_left;
    public AdvancedModelRenderer knife_blade_left;
    public AdvancedModelRenderer skeleton_bicep_right;
    public AdvancedModelRenderer skeleton_elbow_right;
    public AdvancedModelRenderer skeleton_forearm_right;
    public AdvancedModelRenderer skeleton_hand_1_right;
    public AdvancedModelRenderer knife_hilt_right;
    public AdvancedModelRenderer skeleton_hand_2_right;
    public AdvancedModelRenderer knife_pommel_right;
    public AdvancedModelRenderer knife_blade_right;

    public AdvancedModelRenderer[] skeleton_body_parts;
    private ModelAnimator animator;

    protected float prevLimbSwing;
    protected float currentLimbSwing;

    public ModelNecropolisSkeleton()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        animator = ModelAnimator.create();
        prevLimbSwing = 0;
        currentLimbSwing = 0;

        this.skeleton_bicep_right = new AdvancedModelRenderer(this, 0, 14);
        this.skeleton_bicep_right.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.skeleton_bicep_right.addBox(-2.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.skeleton_waist = new AdvancedModelRenderer(this, 30, 37);
        this.skeleton_waist.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.skeleton_waist.addBox(-4.0F, 0.0F, -2.0F, 8, 3, 4, 0.0F);
        this.skeleton_thigh_left = new AdvancedModelRenderer(this, 8, 30);
        this.skeleton_thigh_left.mirror = true;
        this.skeleton_thigh_left.setRotationPoint(2.0F, 12.0F, 0.1F);
        this.skeleton_thigh_left.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(skeleton_thigh_left, -0.2617993877991494F, -0.3490658503988659F, 0.0F);
        this.skeleton_shouler_left = new AdvancedModelRenderer(this, 45, 6);
        this.skeleton_shouler_left.mirror = true;
        this.skeleton_shouler_left.setRotationPoint(5.5F, -5.0F, -1.0F);
        this.skeleton_shouler_left.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(skeleton_shouler_left, -0.3490658503988659F, 0.0F, 0.0F);
        this.skeleton_calf_right = new AdvancedModelRenderer(this, 28, 50);
        this.skeleton_calf_right.setRotationPoint(0.0F, 6.3F, 0.0F);
        this.skeleton_calf_right.addBox(-0.5F, 0.0F, -1.0F, 1, 6, 2, 0.0F);
        this.setRotateAngle(skeleton_calf_right, 0.2617993877991494F, 0.0F, 0.0F);
        this.skeleton_shoulder_right = new AdvancedModelRenderer(this, 45, 0);
        this.skeleton_shoulder_right.setRotationPoint(-5.5F, -5.0F, -1.0F);
        this.skeleton_shoulder_right.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(skeleton_shoulder_right, -0.3490658503988659F, 0.0F, 0.0F);
        this.skeleton_bicep_left = new AdvancedModelRenderer(this, 8, 14);
        this.skeleton_bicep_left.setRotationPoint(-1.0F, 0.0F, -0.5F);
        this.skeleton_bicep_left.addBox(0.0F, 0.0F, -0.5F, 2, 6, 2, 0.0F);
        this.skeleton_thigh_right = new AdvancedModelRenderer(this, 0, 30);
        this.skeleton_thigh_right.setRotationPoint(-2.0F, 12.0F, 0.1F);
        this.skeleton_thigh_right.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(skeleton_thigh_right, -0.2617993877991494F, 0.3490658503988659F, 0.0F);
        this.knife_hilt_left = new AdvancedModelRenderer(this, 28, 19);
        this.knife_hilt_left.setRotationPoint(0.0F, 7.5F, 0.0F);
        this.knife_hilt_left.addBox(-0.5F, -3.0F, -0.5F, 1, 6, 1, 0.0F);
        this.setRotateAngle(knife_hilt_left, 1.5707963267948966F, 0.0F, 0.0F);
        this.skeleton_calf_left = new AdvancedModelRenderer(this, 1, 50);
        this.skeleton_calf_left.setRotationPoint(0.0F, 6.3F, 0.0F);
        this.skeleton_calf_left.addBox(-0.5F, 0.0F, -1.0F, 1, 6, 2, 0.0F);
        this.setRotateAngle(skeleton_calf_left, 0.2617993877991494F, 0.0F, 0.0F);
        this.knife_blade_left = new AdvancedModelRenderer(this, 48, 14);
        this.knife_blade_left.setRotationPoint(-0.5F, -13.0F, -4.0F);
        this.knife_blade_left.addBox(0.0F, 0.0F, 0.0F, 1, 10, 5, 0.0F);
        this.skeleton_spine = new AdvancedModelRenderer(this, 56, 11);
        this.skeleton_spine.mirror = true;
        this.skeleton_spine.setRotationPoint(0.0F, 2.0F, 0.5F);
        this.skeleton_spine.addBox(-1.0F, -6.0F, -1.0F, 2, 6, 2, 0.0F);
        this.skeleton_elbow_left = new AdvancedModelRenderer(this, 26, 14);
        this.skeleton_elbow_left.mirror = true;
        this.skeleton_elbow_left.setRotationPoint(1.0F, 6.0F, 0.5F);
        this.skeleton_elbow_left.addBox(-1.0F, 0.0F, -1.5F, 2, 2, 3, 0.0F);
        this.knife_blade_right = new AdvancedModelRenderer(this, 36, 14);
        this.knife_blade_right.setRotationPoint(-0.5F, -13.0F, -4.0F);
        this.knife_blade_right.addBox(0.0F, 0.0F, 0.0F, 1, 10, 5, 0.0F);
        this.skeleton_hand_1_right = new AdvancedModelRenderer(this, 12, 22);
        this.skeleton_hand_1_right.setRotationPoint(-1.0F, 6.0F, -1.0F);
        this.skeleton_hand_1_right.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
        this.skeleton_head = new AdvancedModelRenderer(this, 0, 44);
        this.skeleton_head.setRotationPoint(0.0F, -7.0F, 0.5F);
        this.skeleton_head.addBox(-3.5F, -7.0F, -5.0F, 7, 7, 7, 0.0F);
        this.setRotateAngle(skeleton_head, -0.3490658503988659F, 0.0F, 0.0F);
        this.skeleton_knee_left = new AdvancedModelRenderer(this, 10, 38);
        this.skeleton_knee_left.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.skeleton_knee_left.addBox(-1.0F, -1.0F, -1.5F, 2, 2, 3, 0.0F);
        this.skeleton_knee_right = new AdvancedModelRenderer(this, 0, 38);
        this.skeleton_knee_right.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.skeleton_knee_right.addBox(-1.0F, -1.0F, -1.5F, 2, 2, 3, 0.0F);
        this.skeleton_upper_torso = new AdvancedModelRenderer(this, 21, 3);
        this.skeleton_upper_torso.setRotationPoint(0.0F, -6.0F, 0.5F);
        this.skeleton_upper_torso.addBox(-4.0F, -7.0F, -3.0F, 8, 7, 4, 0.0F);
        this.setRotateAngle(skeleton_upper_torso, 0.3490658503988659F, 0.0F, 0.0F);
        this.skeleton_hand_2_left = new AdvancedModelRenderer(this, 18, 26);
        this.skeleton_hand_2_left.setRotationPoint(-1.0F, 0.0F, 0.0F);
        this.skeleton_hand_2_left.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.knife_hilt_right = new AdvancedModelRenderer(this, 24, 19);
        this.knife_hilt_right.setRotationPoint(0.0F, 7.5F, 0.0F);
        this.knife_hilt_right.addBox(-0.5F, -3.0F, -0.5F, 1, 6, 1, 0.0F);
        this.setRotateAngle(knife_hilt_right, 1.5707963267948966F, 0.0F, 0.0F);
        this.skeleton_forearm_left = new AdvancedModelRenderer(this, 6, 22);
        this.skeleton_forearm_left.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.skeleton_forearm_left.addBox(-0.5F, 0.0F, -1.0F, 1, 6, 2, 0.0F);
        this.knife_pommel_right = new AdvancedModelRenderer(this, 24, 26);
        this.knife_pommel_right.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.knife_pommel_right.addBox(-0.5F, 0.0F, -1.0F, 1, 2, 2, 0.0F);
        this.skeleton_elbow_right = new AdvancedModelRenderer(this, 16, 14);
        this.skeleton_elbow_right.mirror = true;
        this.skeleton_elbow_right.setRotationPoint(-1.0F, 6.0F, 0.0F);
        this.skeleton_elbow_right.addBox(-1.0F, 0.0F, -1.5F, 2, 2, 3, 0.0F);
        this.knife_pommel_left = new AdvancedModelRenderer(this, 24, 30);
        this.knife_pommel_left.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.knife_pommel_left.addBox(-0.5F, 0.0F, -1.0F, 1, 2, 2, 0.0F);
        this.skeleton_hand_1_left = new AdvancedModelRenderer(this, 18, 22);
        this.skeleton_hand_1_left.setRotationPoint(0.0F, 6.0F, -1.0F);
        this.skeleton_hand_1_left.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
        this.skeleton_hand_2_right = new AdvancedModelRenderer(this, 12, 26);
        this.skeleton_hand_2_right.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.skeleton_hand_2_right.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.skeleton_forearm_right = new AdvancedModelRenderer(this, 0, 22);
        this.skeleton_forearm_right.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.skeleton_forearm_right.addBox(-0.5F, 0.0F, -1.0F, 1, 6, 2, 0.0F);
        this.skeleton_shoulder_right.addChild(this.skeleton_bicep_right);
        this.skeleton_upper_torso.addChild(this.skeleton_shouler_left);
        this.skeleton_thigh_right.addChild(this.skeleton_calf_right);
        this.skeleton_upper_torso.addChild(this.skeleton_shoulder_right);
        this.skeleton_shouler_left.addChild(this.skeleton_bicep_left);
        this.skeleton_forearm_left.addChild(this.knife_hilt_left);
        this.skeleton_thigh_left.addChild(this.skeleton_calf_left);
        this.knife_hilt_left.addChild(this.knife_blade_left);
        this.skeleton_waist.addChild(this.skeleton_spine);
        this.skeleton_bicep_left.addChild(this.skeleton_elbow_left);
        this.knife_hilt_right.addChild(this.knife_blade_right);
        this.skeleton_forearm_right.addChild(this.skeleton_hand_1_right);
        this.skeleton_upper_torso.addChild(this.skeleton_head);
        this.skeleton_thigh_left.addChild(this.skeleton_knee_left);
        this.skeleton_thigh_right.addChild(this.skeleton_knee_right);
        this.skeleton_spine.addChild(this.skeleton_upper_torso);
        this.skeleton_hand_1_left.addChild(this.skeleton_hand_2_left);
        this.skeleton_forearm_right.addChild(this.knife_hilt_right);
        this.skeleton_elbow_left.addChild(this.skeleton_forearm_left);
        this.knife_hilt_right.addChild(this.knife_pommel_right);
        this.skeleton_bicep_right.addChild(this.skeleton_elbow_right);
        this.knife_hilt_left.addChild(this.knife_pommel_left);
        this.skeleton_forearm_left.addChild(this.skeleton_hand_1_left);
        this.skeleton_hand_1_right.addChild(this.skeleton_hand_2_right);
        this.skeleton_elbow_right.addChild(this.skeleton_forearm_right);

        skeleton_body_parts = new AdvancedModelRenderer[] {skeleton_thigh_right, skeleton_thigh_left, skeleton_waist, skeleton_calf_right, skeleton_knee_right, skeleton_calf_left, skeleton_knee_left, skeleton_spine, skeleton_upper_torso, skeleton_head, skeleton_shouler_left, skeleton_shoulder_right, skeleton_bicep_left, skeleton_elbow_left, skeleton_forearm_left, skeleton_hand_1_left, knife_hilt_left, skeleton_hand_2_left, knife_pommel_left, knife_blade_left, skeleton_bicep_right, skeleton_elbow_right, skeleton_forearm_right, skeleton_hand_1_right, knife_hilt_right, skeleton_hand_2_right, knife_pommel_right, knife_blade_right };
        updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        animate(f, f1, f2, f3, f4, f5, entity);
        this.skeleton_waist.render(f5);
        this.skeleton_thigh_left.render(f5);
        this.skeleton_thigh_right.render(f5);

        resetToDefaultPose();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelrenderer, float x, float y, float z) {
        modelrenderer.rotateAngleX = x;
        modelrenderer.rotateAngleY = y;
        modelrenderer.rotateAngleZ = z;
    }
    public void animate(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        EntityNecropolisSkeleton skeletor = (EntityNecropolisSkeleton)entity;
        animator.update(skeletor);
        if (skeletor.getAnimation() == EntityNecropolisSkeleton.RETALIATE_ANIMATION)
        {

            animator.setAnimation(EntityNecropolisSkeleton.RETALIATE_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, skeletor);
            animator.startKeyframe(0);
            animator.rotate(this.skeleton_spine, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(5);
            animator.rotate(this.skeleton_bicep_right, 0.0F,0.0F, 1.74533F);
            animator.rotate(this.skeleton_forearm_right, -3.14159F, 0.523599F, -1.22173F);
            animator.rotate(this.skeleton_bicep_left, 0.0F,0.0F, -0.698132F);
            animator.rotate(this.skeleton_forearm_left, -0.523599F, 0F, 0F);
            animator.endKeyframe();
            animator.startKeyframe(3);
            animator.rotate(this.skeleton_calf_left,0.523599F,0.0F,0.0F);
            animator.rotate(this.skeleton_bicep_right, -0.872665F, 0.0F, 1.0472F);
            animator.rotate(this.skeleton_forearm_right, 0.0F,1.5708F, 0.0F);
            animator.rotate(this.knife_hilt_right, 0.523599F, 0F,0F);
            animator.rotate(this.skeleton_bicep_left, 0.523599F,0F,-1.0472F);
            animator.rotate(this.skeleton_forearm_left, -0.872665F,-1.0472F,0F);
            animator.rotate(this.knife_hilt_left, -1.22173F, 0F,1.13446F);
            animator.endKeyframe();
            animator.startKeyframe(2);
            animator.rotate(this.skeleton_bicep_right, -1.0472F, 0.0F, 0F);
            animator.rotate(this.skeleton_forearm_right, 0.0F,1.5708F, -0.698132F);
            animator.rotate(this.knife_hilt_right, 0.523599F, 0F,0F);
            animator.rotate(this.skeleton_bicep_left, 0.523599F,0F,-1.0472F);
            animator.rotate(this.skeleton_forearm_left, -0.872665F,-1.0472F,0F);
            animator.rotate(this.knife_hilt_left, -1.22173F, 0F,1.5708F);
            animator.rotate(this.skeleton_upper_torso, 0F, -0.349066F,0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(8);
            animator.startKeyframe(5);
            animator.rotate(this.skeleton_bicep_right, 0.0F, 0.0F, 0.349066F);
            animator.rotate(this.skeleton_forearm_right, -0.523599F,0.0F, 0.0F);
            animator.rotate(this.knife_hilt_right, 0.523599F, 0F,0F);
            animator.rotate(this.skeleton_bicep_left, -1.0472F,0F,0F);
            animator.rotate(this.knife_hilt_left, 0F, -1.5708F,0.785398F);
            animator.rotate(this.skeleton_upper_torso, 0F, 0.698132F,0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(4);

            //spin attack
            animator.startKeyframe(10);
            animator.rotate(this.knife_hilt_left, 0.872665F, 0.0F, 0.0F);
            animator.rotate(this.knife_hilt_right, 0.0F, -1.74533F, 0.0F);
            animator.rotate(this.skeleton_bicep_left, 0.523599F, 0.0F, -1.0472F);
            animator.rotate(this.skeleton_bicep_right, -1.39626F, 0.523599F, 0.0F);
            animator.rotate(this.skeleton_forearm_left, 0.0F, -3.14159F, 0.0F);
            animator.rotate(this.skeleton_forearm_right, 0.0F, 0.0F, -0.698132F);
            animator.rotate(this.skeleton_spine, 0F, -0.523599F, 0.0F);
            animator.rotate(this.skeleton_head, 0F, 0.523599F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(10);
            animator.rotate(this.knife_hilt_left, 0.872665F, 0.0F, 0.0F);
            animator.rotate(this.knife_hilt_right, 0.925025F, 0.0F, 0.0F);
            animator.rotate(this.skeleton_bicep_left, 0.523599F, 0.0F, -1.0472F);
            animator.rotate(this.skeleton_bicep_right, 0.0F, 0.0F, 1.22173F);
            animator.rotate(this.skeleton_forearm_left, 0.0F, -3.14159F, 0.0F);
            animator.rotate(this.skeleton_spine, 0F, 6.28319F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(10);
            animator.rotate(this.knife_hilt_left, 0.872665F, 0.0F, 0.0F);
            animator.rotate(this.knife_hilt_right, 0.925025F, 0.0F, 0.0F);
            animator.rotate(this.skeleton_bicep_left, 0.523599F, 0.0F, -1.0472F);
            animator.rotate(this.skeleton_bicep_right, 0.0F, 0.0F, 1.22173F);
            animator.rotate(this.skeleton_forearm_left, 0.0F, -3.14159F, 0.0F);
            animator.rotate(this.skeleton_spine, 0F, 6.28319F, 0.0F);
            animator.rotate(this.skeleton_head, 0F, 6.28319F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(10);
        }
        else if (skeletor.getAnimation() == EntityNecropolisSkeleton.SWING_ANIMATION)
        {
            animator.setAnimation(EntityNecropolisSkeleton.SWING_ANIMATION);
            animator.startKeyframe(0);
            animator.rotate(this.skeleton_spine, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(30);
            animator.rotate(this.knife_hilt_left, 0.872665F, 0.0F, 0.0F);
            animator.rotate(this.knife_hilt_right, 0.0F, -1.74533F, 0.0F);
            animator.rotate(this.skeleton_bicep_left, 0.523599F, 0.0F, -1.0472F);
            animator.rotate(this.skeleton_bicep_right, -1.39626F, 0.523599F, 0.0F);
            animator.rotate(this.skeleton_forearm_left, 0.0F, -3.14159F, 0.0F);
            animator.rotate(this.skeleton_forearm_right, 0.0F, 0.0F, -0.698132F);
            animator.rotate(this.skeleton_spine, 0F, -0.523599F, 0.0F);
            animator.rotate(this.skeleton_head, 0F, 0.523599F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(10);
            animator.rotate(this.knife_hilt_left, 0.872665F, 0.0F, 0.0F);
            animator.rotate(this.knife_hilt_right, 0.925025F, 0.0F, 0.0F);
            animator.rotate(this.skeleton_bicep_left, 0.523599F, 0.0F, -1.0472F);
            animator.rotate(this.skeleton_bicep_right, 0.0F, 0.0F, 1.22173F);
            animator.rotate(this.skeleton_forearm_left, 0.0F, -3.14159F, 0.0F);
            animator.rotate(this.skeleton_spine, 0F, 6.28319F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(10);
            animator.rotate(this.knife_hilt_left, 0.872665F, 0.0F, 0.0F);
            animator.rotate(this.knife_hilt_right, 0.925025F, 0.0F, 0.0F);
            animator.rotate(this.skeleton_bicep_left, 0.523599F, 0.0F, -1.0472F);
            animator.rotate(this.skeleton_bicep_right, 0.0F, 0.0F, 1.22173F);
            animator.rotate(this.skeleton_forearm_left, 0.0F, -3.14159F, 0.0F);
            animator.rotate(this.skeleton_spine, 0F, 6.28319F, 0.0F);
            animator.rotate(this.skeleton_head, 0F, 6.28319F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(10);
        }
        else if (skeletor.getAnimation() == EntityNecropolisSkeleton.LEAP_ANIMATION)
        {
            animator.setAnimation(EntityNecropolisSkeleton.LEAP_ANIMATION);
            animator.startKeyframe(0);
            animator.rotate(this.skeleton_forearm_left, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(10);
            animator.rotate(this.skeleton_upper_torso, 0.0F, -0.523599F, 0.0F);
            animator.rotate(this.skeleton_head, 0.0F, 0.523599F, 0.0F);
            animator.rotate(this.skeleton_forearm_left, -1.2217F, -1.2217F, 0.0F);
            animator.rotate(this.skeleton_bicep_left, 0.0F, 0.0F, -1.2217F);

            animator.rotate(this.skeleton_bicep_right, 0.0F,0.0F, 1.74533F);
            animator.rotate(this.skeleton_forearm_right, -3.14159F, 0.523599F, -1.22173F);

            animator.rotate(this.knife_hilt_left, 1.22173F, -0.872665F, 0.0F);
            animator.rotate(this.skeleton_thigh_right,-0.436332F,0.0F,0.0F);
            animator.rotate(this.skeleton_calf_right,0.872665F,0.0F,0.0F);
            animator.rotate(this.skeleton_thigh_left,0.349066F,0.0F,0.0F);
            animator.endKeyframe();
            animator.startKeyframe(5);
            animator.rotate(this.skeleton_upper_torso, 0.0F, 0.785398F, 0.0F);
            animator.rotate(this.skeleton_head, 0.0F, -0.785398F, 0.0F);
            animator.rotate(this.skeleton_forearm_left, -0.523599F, 0.0F,  0.349066F);
            animator.rotate(this.knife_hilt_left, 0.0F, -0.698132F, 0.0F);
            animator.rotate(this.skeleton_thigh_right,0.436332F,0.0F,0.0F);
            animator.rotate(this.skeleton_thigh_left,-0.261799F,0.0F,0.0F);
            animator.rotate(this.skeleton_calf_left,0.523599F,0.0F,0.0F);
            animator.endKeyframe();
            animator.resetKeyframe(10);
        }
        else if (skeletor.getAnimation() == EntityNecropolisSkeleton.BLOCK_40_ANIMATION)
        {
            animator.setAnimation(EntityNecropolisSkeleton.BLOCK_40_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, skeletor);

            animator.startKeyframe(0);
            animator.rotate(this.skeleton_forearm_left, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(5);
            animator.rotate(this.skeleton_bicep_right, 0.0f, 0.0f, (float)Math.toRadians(40.0D));
            animator.rotate(this.skeleton_forearm_right, (float)Math.toRadians(-90.0D), (float)Math.toRadians(-30.0D), 0.0f);
            animator.rotate(this.knife_hilt_right, 0.0f, 0.0f, (float)Math.toRadians(-30.0D));

            animator.rotate(this.skeleton_bicep_left, 0.0f, 0.0f, (float)Math.toRadians(-40.0D));
            animator.rotate(this.skeleton_forearm_left, (float)Math.toRadians(-70.0D), (float)Math.toRadians(30.0D), 0.0f);
            animator.endKeyframe();
            animator.setStaticKeyframe(35);
            animator.resetKeyframe(5);
        }
        else if (skeletor.getAnimation() == EntityNecropolisSkeleton.BLOCK_80_ANIMATION)
        {
            animator.setAnimation(EntityNecropolisSkeleton.BLOCK_80_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, skeletor);

            animator.startKeyframe(0);
            animator.rotate(this.skeleton_forearm_left, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(5);
            animator.rotate(this.skeleton_bicep_right, 0.0f, 0.0f, (float)Math.toRadians(40.0D));
            animator.rotate(this.skeleton_forearm_right, (float)Math.toRadians(-90.0D), (float)Math.toRadians(-30.0D), 0.0f);
            animator.rotate(this.knife_hilt_right, 0.0f, 0.0f, (float)Math.toRadians(-30.0D));

            animator.rotate(this.skeleton_bicep_left, 0.0f, 0.0f, (float)Math.toRadians(-40.0D));
            animator.rotate(this.skeleton_forearm_left, (float)Math.toRadians(-70.0D), (float)Math.toRadians(30.0D), 0.0f);
            animator.endKeyframe();
            animator.setStaticKeyframe(75);
            animator.resetKeyframe(5);
        }
        else if (skeletor.getAnimation() == EntityNecropolisSkeleton.BLOCK_160_ANIMATION)
        {
            animator.setAnimation(EntityNecropolisSkeleton.BLOCK_160_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, skeletor);

            animator.startKeyframe(0);
            animator.rotate(this.skeleton_forearm_left, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(5);
            animator.rotate(this.skeleton_bicep_right, 0.0f, 0.0f, (float)Math.toRadians(40.0D));
            animator.rotate(this.skeleton_forearm_right, (float)Math.toRadians(-90.0D), (float)Math.toRadians(-30.0D), 0.0f);
            animator.rotate(this.knife_hilt_right, 0.0f, 0.0f, (float)Math.toRadians(-30.0D));

            animator.rotate(this.skeleton_bicep_left, 0.0f, 0.0f, (float)Math.toRadians(-40.0D));
            animator.rotate(this.skeleton_forearm_left, (float)Math.toRadians(-70.0D), (float)Math.toRadians(30.0D), 0.0f);
            animator.endKeyframe();
            animator.setStaticKeyframe(155);
            animator.resetKeyframe(5);
        }
        else if (skeletor.getAnimation() == EntityNecropolisSkeleton.HURT_R_ANIMATION)
        {
            animator.setAnimation(EntityNecropolisSkeleton.HURT_R_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, skeletor);
            animator.startKeyframe(0);
            animator.rotate(this.skeleton_spine, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(2);
            animator.rotate(this.skeleton_spine, 0F, (float)Math.toRadians(30.0D), 0F);
            animator.rotate(this.skeleton_bicep_right, (float)Math.toRadians(-30.0D), 0F, (float)Math.toRadians(30.0D));
            animator.rotate(this.skeleton_forearm_left, (float)Math.toRadians(-50.0D), 0F, 0F);
            animator.rotate(this.skeleton_bicep_left, 0F, 0F, (float)Math.toRadians(-50.0D));
            animator.rotate(this.skeleton_forearm_left, (float)Math.toRadians(-50.0D),  (float)Math.toRadians(-30.0D), 0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(2);
            animator.resetKeyframe(1);
        }
        else if (skeletor.getAnimation() == EntityNecropolisSkeleton.HURT_L_ANIMATION)
        {
            animator.setAnimation(EntityNecropolisSkeleton.HURT_L_ANIMATION);
            setRotationAngles(f, f1, f2, f3, f4, f5, skeletor);
            animator.startKeyframe(0);
            animator.rotate(this.skeleton_spine, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(2);
            animator.rotate(this.skeleton_spine, 0F, (float)Math.toRadians(-30.0D), 0F);
            animator.rotate(this.skeleton_bicep_right, (float)Math.toRadians(-30.0D), 0F, (float)Math.toRadians(30.0D));
            animator.rotate(this.skeleton_forearm_left, (float)Math.toRadians(-50.0D), 0F, 0F);
            animator.rotate(this.skeleton_bicep_left, 0F, 0F, (float)Math.toRadians(-50.0D));
            animator.rotate(this.skeleton_forearm_left, (float)Math.toRadians(-50.0D),  (float)Math.toRadians(-30.0D), 0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(2);
            animator.resetKeyframe(1);
        }
        else
        {
            setRotationAngles(f, f1, f2, f3, f4, f5, skeletor);
        }
    }
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, EntityNecropolisSkeleton entityIn)
    {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        resetToDefaultPose();

        faceTarget(netHeadYaw, 0.0f, 1.0F, this.skeleton_waist);

        float walkspeed =1F;
        float walkheight = 1.5F;
        float walkdegree = 1F;

        float bobspeed = 1F;
        float bobheight = 1F;
        float bobdegree = 1;

        boolean isStill = true;

        float tmp = currentLimbSwing;

        currentLimbSwing = limbSwing;

        if (currentLimbSwing - prevLimbSwing == 0)
        {
            isStill = true;
        }
        else
        {
            isStill = false;
        }
        prevLimbSwing = tmp;

        if (isStill == false)
        {
            bob(this.skeleton_waist, walkspeed, walkheight, true,  limbSwing, limbSwingAmount);
            bob(this.skeleton_upper_torso, walkspeed, -1F * walkheight, true,  limbSwing, limbSwingAmount);
            swing(this.skeleton_upper_torso,  walkspeed, 0.5F * walkdegree, false, 0, 0.125F, limbSwing, limbSwingAmount);
            swing(this.skeleton_head, walkspeed, 0.5F * walkdegree, true, 0, 0.125F,  limbSwing, limbSwingAmount);

            bob(this.skeleton_shouler_left, walkspeed, walkheight, true,  limbSwing, limbSwingAmount);
            bob(this.skeleton_shoulder_right, walkspeed, walkheight, true, limbSwing, limbSwingAmount);

            walk(this.skeleton_thigh_left, walkspeed, walkdegree, false, 0, 0.125F,  limbSwing, limbSwingAmount);
            walk(this.skeleton_thigh_right, walkspeed, walkdegree, true, 0, 0.125F,  limbSwing, limbSwingAmount);

            walk(this.skeleton_calf_left,  walkspeed, walkdegree, true, 0.5F, 0.125F, limbSwing, limbSwingAmount);
            walk(this.skeleton_calf_right,  walkspeed, walkdegree, false, 0.5F, 0.125F,  limbSwing, limbSwingAmount);
        }
        else
        {
            bob(this.skeleton_waist,  walkspeed * 0.25F, walkheight, false, entityIn.ticksExisted, 0.5F);
            bob(this.skeleton_shouler_left,  walkspeed * 0.25F, walkheight, true, entityIn.ticksExisted, 0.5F);
            bob(this.skeleton_shoulder_right,   walkspeed * 0.25F, walkheight, true, entityIn.ticksExisted, 0.5F);

            walk(this.knife_hilt_left,  walkspeed * 0.125F, walkdegree * 0.125F, true, 0.5F, 0.125F, entityIn.ticksExisted, 0.5F);
        }
    }
}
