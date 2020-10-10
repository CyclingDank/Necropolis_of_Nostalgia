package com.turtledove.necropolisofnostalgia.client.model.entity;

import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityAxeBeak;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityCultSorceress;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityNecropolisSkeleton;
import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelCultSorceress extends AdvancedModelBase 
{
    public AdvancedModelRenderer cs_torso;
    public AdvancedModelRenderer cs_hood;
    public AdvancedModelRenderer cs_cloak;
    public AdvancedModelRenderer cs_sleeve_r;
    public AdvancedModelRenderer cs_sleeve_l;
    public AdvancedModelRenderer cs_head;
    public AdvancedModelRenderer cs_arm_l;
    public AdvancedModelRenderer cs_leg_l;
    public AdvancedModelRenderer cs_leg_r;
    public AdvancedModelRenderer cs_arm_r;
    public AdvancedModelRenderer cs_staff;
    public AdvancedModelRenderer cs_staff_top;

    public AdvancedModelRenderer[] cs_parts;
    private ModelAnimator animator;

    public ModelCultSorceress() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.cs_sleeve_r = new AdvancedModelRenderer(this, 78, 0);
        this.cs_sleeve_r.setRotationPoint(-5.0F, 2.5F, 0.0F);
        this.cs_sleeve_r.addBox(-2.0F, -2.0F, -2.0F, 3, 8, 4, 0.0F);
        this.setRotateAngle(cs_sleeve_r, -0.5235987755982988F, 0.0F, 0.17453292519943295F);
        this.cs_leg_r = new AdvancedModelRenderer(this, 0, 16);
        this.cs_leg_r.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.cs_leg_r.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.cs_torso = new AdvancedModelRenderer(this, 16, 16);
        this.cs_torso.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.cs_torso.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.cs_arm_r = new AdvancedModelRenderer(this, 40, 16);
        this.cs_arm_r.setRotationPoint(-5.0F, 2.5F, 0.0F);
        this.cs_arm_r.addBox(-2.0F, -2.0F, -2.0F, 3, 12, 4, 0.0F);
        this.setRotateAngle(cs_arm_r, -0.5235987755982988F, 0.0F, 0.17453292519943295F);
        this.cs_head = new AdvancedModelRenderer(this, 0, 0);
        this.cs_head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.cs_head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.cs_sleeve_l = new AdvancedModelRenderer(this, 92, 0);
        this.cs_sleeve_l.setRotationPoint(5.0F, 2.5F, 0.0F);
        this.cs_sleeve_l.addBox(-1.0F, -2.0F, -2.0F, 3, 8, 4, 0.0F);
        this.setRotateAngle(cs_sleeve_l, 0.0F, 0.0F, -0.17453292519943295F);
        this.cs_leg_l = new AdvancedModelRenderer(this, 16, 48);
        this.cs_leg_l.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.cs_leg_l.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.cs_staff = new AdvancedModelRenderer(this, 0, 65);
        this.cs_staff.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.cs_staff.addBox(-0.5F, -8.0F, -0.5F, 1, 20, 1, 0.0F);
        this.setRotateAngle(cs_staff, 0.7853981633974483F, 0.0F, 0.0F);
        this.cs_arm_l = new AdvancedModelRenderer(this, 32, 48);
        this.cs_arm_l.setRotationPoint(5.0F, 2.5F, 0.0F);
        this.cs_arm_l.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, 0.0F);
        this.setRotateAngle(cs_arm_l, 0.0F, 0.0F, -0.17453292519943295F);
        this.cs_hood = new AdvancedModelRenderer(this, 0, 32);
        this.cs_hood.setRotationPoint(0.0F, 0.75F, 0.0F);
        this.cs_hood.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.cs_cloak = new AdvancedModelRenderer(this, 54, 0);
        this.cs_cloak.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.cs_cloak.addBox(-4.0F, 0.0F, -2.0F, 8, 17, 4, 0.0F);
        this.cs_staff_top = new AdvancedModelRenderer(this, 10, 65);
        this.cs_staff_top.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.cs_staff_top.addBox(-1.5F, -4.0F, -0.5F, 3, 4, 1, 0.0F);
        this.cs_torso.addChild(this.cs_leg_r);
        this.cs_torso.addChild(this.cs_arm_r);
        this.cs_torso.addChild(this.cs_head);
        this.cs_torso.addChild(this.cs_leg_l);
        this.cs_arm_r.addChild(this.cs_staff);
        this.cs_torso.addChild(this.cs_arm_l);
        this.cs_staff.addChild(this.cs_staff_top);


        animator = ModelAnimator.create();
        cs_parts = new AdvancedModelRenderer[] { cs_torso, cs_hood, cs_cloak, cs_sleeve_r, cs_sleeve_l, cs_head, cs_arm_l, cs_leg_l, cs_leg_r, cs_arm_r, cs_staff, cs_staff_top};
        updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        animate(f, f1, f2, f3, f4, f5, entity);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.cs_sleeve_r.offsetX, this.cs_sleeve_r.offsetY, this.cs_sleeve_r.offsetZ);
        GlStateManager.translate(this.cs_sleeve_r.rotationPointX * f5, this.cs_sleeve_r.rotationPointY * f5, this.cs_sleeve_r.rotationPointZ * f5);
        GlStateManager.scale(1.1D, 1.1D, 1.1D);
        GlStateManager.translate(-this.cs_sleeve_r.offsetX, -this.cs_sleeve_r.offsetY, -this.cs_sleeve_r.offsetZ);
        GlStateManager.translate(-this.cs_sleeve_r.rotationPointX * f5, -this.cs_sleeve_r.rotationPointY * f5, -this.cs_sleeve_r.rotationPointZ * f5);
        this.cs_sleeve_r.render(f5);
        GlStateManager.popMatrix();
        this.cs_torso.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.cs_sleeve_l.offsetX, this.cs_sleeve_l.offsetY, this.cs_sleeve_l.offsetZ);
        GlStateManager.translate(this.cs_sleeve_l.rotationPointX * f5, this.cs_sleeve_l.rotationPointY * f5, this.cs_sleeve_l.rotationPointZ * f5);
        GlStateManager.scale(1.1D, 1.1D, 1.1D);
        GlStateManager.translate(-this.cs_sleeve_l.offsetX, -this.cs_sleeve_l.offsetY, -this.cs_sleeve_l.offsetZ);
        GlStateManager.translate(-this.cs_sleeve_l.rotationPointX * f5, -this.cs_sleeve_l.rotationPointY * f5, -this.cs_sleeve_l.rotationPointZ * f5);
        this.cs_sleeve_l.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.cs_hood.offsetX, this.cs_hood.offsetY, this.cs_hood.offsetZ);
        GlStateManager.translate(this.cs_hood.rotationPointX * f5, this.cs_hood.rotationPointY * f5, this.cs_hood.rotationPointZ * f5);
        GlStateManager.scale(1.1D, 1.1D, 1.1D);
        GlStateManager.translate(-this.cs_hood.offsetX, -this.cs_hood.offsetY, -this.cs_hood.offsetZ);
        GlStateManager.translate(-this.cs_hood.rotationPointX * f5, -this.cs_hood.rotationPointY * f5, -this.cs_hood.rotationPointZ * f5);
        this.cs_hood.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.cs_cloak.offsetX, this.cs_cloak.offsetY, this.cs_cloak.offsetZ);
        GlStateManager.translate(this.cs_cloak.rotationPointX * f5, this.cs_cloak.rotationPointY * f5, this.cs_cloak.rotationPointZ * f5);
        GlStateManager.scale(1.1D, 1.1D, 1.1D);
        GlStateManager.translate(-this.cs_cloak.offsetX, -this.cs_cloak.offsetY, -this.cs_cloak.offsetZ);
        GlStateManager.translate(-this.cs_cloak.rotationPointX * f5, -this.cs_cloak.rotationPointY * f5, -this.cs_cloak.rotationPointZ * f5);
        this.cs_cloak.render(f5);
        GlStateManager.popMatrix();

        resetToDefaultPose();

    }

    public void animate(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        EntityCultSorceress cs = (EntityCultSorceress)entity;
        animator.update(cs);
        setRotationAngles(f, f1, f2, f3, f4, f5, cs);

        if (cs.getAnimation() == EntityCultSorceress.PHOTON_CAST_ANIMATION)
        {
            animator.setAnimation(EntityCultSorceress.PHOTON_CAST_ANIMATION);
            animator.startKeyframe(0);
            animator.rotate(this.cs_torso, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(10);
            animator.rotate(this.cs_arm_r, -1.22173F, 0.0F,0.0F);
            animator.rotate(this.cs_sleeve_r, -1.22173F, 0.0F,0.0F);

            animator.rotate(this.cs_arm_l, 0.174533F, 0.0F,0.0F);
            animator.rotate(this.cs_sleeve_l, 0.174533F, 0.0F,0.0F);

            animator.rotate(this.cs_staff, 0.785398F, 0.0F,0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(30);
            animator.resetKeyframe(10);
        }
        else if (cs.getAnimation() == EntityCultSorceress.HURT_ANIMATION)
        {
            animator.setAnimation(EntityCultSorceress.HURT_ANIMATION);
            animator.startKeyframe(0);
            animator.rotate(this.cs_torso, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(5);
            animator.rotate(this.cs_arm_l, (float)Math.toRadians(20.0D), 0.0F, 0.0F);
            animator.rotate(this.cs_sleeve_l, (float)Math.toRadians(20.0D), 0.0F, 0.0F);

            animator.rotate(this.cs_arm_r, 0.0F, 0.0F, (float)Math.toRadians(20.0D));
            animator.rotate(this.cs_sleeve_r, 0.0F, 0.0F, (float)Math.toRadians(20.0D));

            animator.endKeyframe();
            animator.setStaticKeyframe(10);
            animator.resetKeyframe(5);
        }
        else if (cs.getAnimation() == EntityCultSorceress.FIRSTAID_CAST_ANIMATION)
        {
            animator.setAnimation(EntityCultSorceress.FIRSTAID_CAST_ANIMATION);
            animator.startKeyframe(0);
            animator.rotate(this.cs_torso, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(10);
            animator.rotate(this.cs_arm_r, -1.22173F, 0.0F,0.0F);
            animator.rotate(this.cs_sleeve_r, -1.22173F, 0.0F,0.0F);

            animator.rotate(this.cs_arm_l, 0.174533F, 0.0F,0.0F);
            animator.rotate(this.cs_sleeve_l, 0.174533F, 0.0F,0.0F);

            animator.rotate(this.cs_staff, 0.785398F, 0.0F,0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(70);
            animator.resetKeyframe(10);
        }
        else if (cs.getAnimation() == EntityCultSorceress.STRIKE_ANIMATION)
        {
            animator.setAnimation(EntityCultSorceress.STRIKE_ANIMATION);
            animator.startKeyframe(0);
            animator.rotate(this.cs_torso, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(2);
            animator.rotate(this.cs_arm_r, 0.174533F, 0.0F,0.0F);
            animator.rotate(this.cs_sleeve_r, 0.174533F, 0.0F,0.0F);

            animator.rotate(this.cs_arm_l, -0.698132F, -0.698132F,0.0F);
            animator.rotate(this.cs_sleeve_l, -0.698132F, -0.698132F,0.0F);

            animator.rotate(this.cs_staff, 0.174533F, 0.0F,0.0F);
            animator.endKeyframe();

            animator.startKeyframe(3);
            animator.rotate(this.cs_arm_r, 0.698132F, 0.0F,0.0F);
            animator.rotate(this.cs_sleeve_r, 0.698132F, 0.0F,0.0F);

            animator.rotate(this.cs_arm_l, -0.698132F, -0.698132F,0.0F);
            animator.rotate(this.cs_sleeve_l, -0.698132F, -0.698132F,0.0F);

            animator.rotate(this.cs_staff, 0.174533F, 0.0F,0.0F);
            animator.endKeyframe();
            animator.startKeyframe(2);
            animator.rotate(this.cs_arm_r, -0.942478F, 0.0F,0.0F);
            animator.rotate(this.cs_sleeve_r, -0.942478F, 0.0F,0.0F);

            animator.rotate(this.cs_arm_l, 0.575959F, -0.349066F,0.0F);
            animator.rotate(this.cs_sleeve_l, 0.575959F, -0.349066F,0.0F);

            animator.rotate(this.cs_leg_l, 0.436332F, 0.0F,0.0F);
            animator.rotate(this.cs_staff, 1.5708F, 0.0F,0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(5);
            animator.resetKeyframe(3);
        }

    }
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, EntityCultSorceress entityIn)
    {
        if (netHeadYaw > 70) {
            netHeadYaw = 70f;
        }
        if (netHeadYaw < -70) {
            netHeadYaw = -70f;
        }
        float walkheight = 1.5F;
        float walkspeed = 0.75F;
        float walkdegree = 2F;

        faceTarget(netHeadYaw, headPitch, 1.0F, this.cs_head);
        faceTarget(netHeadYaw, headPitch, 1.0F, this.cs_hood);

        walk(this.cs_leg_l, walkspeed, walkdegree, false, 0F, 0.0F, limbSwing, 0.5F * limbSwingAmount);
        walk(this.cs_leg_r, walkspeed, walkdegree, true, 0F, 0.0F, limbSwing, 0.5F * limbSwingAmount);

        if (entityIn.getAnimation() == EntityCultSorceress.NO_ANIMATION)
        {
            walk(this.cs_arm_l, walkspeed, walkdegree * 0.5F, false, 0F, 0.0F, limbSwing, limbSwingAmount);
            walk(this.cs_sleeve_l, walkspeed, walkdegree * 0.5F, false, 0F, 0.0F, limbSwing, limbSwingAmount);
            walk(this.cs_arm_r, walkspeed, walkdegree * 0.5F, true, 0F, 0.0F, limbSwing, limbSwingAmount);
            walk(this.cs_sleeve_r, walkspeed, walkdegree * 0.5F, true, 0F, 0.0F, limbSwing, limbSwingAmount);
        }

        bob(this.cs_torso, walkspeed, -2F * walkheight, true,  limbSwing, 0.5F * limbSwingAmount);
        bob(this.cs_cloak, walkspeed, -2F * walkheight, true,  limbSwing, 0.5F * limbSwingAmount);
        bob(this.cs_sleeve_l, walkspeed, -2F * walkheight, true,  limbSwing, 0.5F * limbSwingAmount);
        bob(this.cs_sleeve_r, walkspeed, -2F * walkheight, true,  limbSwing, 0.5F * limbSwingAmount);
        bob(this.cs_hood, walkspeed, -2F * walkheight, true,  limbSwing, 0.5F * limbSwingAmount);
        bob(this.cs_hood, walkspeed, -1F * walkheight, true,  limbSwing, 0.5F * limbSwingAmount);
        bob(this.cs_head, walkspeed, -1F * walkheight, true,  limbSwing, 0.5F * limbSwingAmount);
        bob(this.cs_leg_l, walkspeed,  2F * walkheight, true,  limbSwing, 0.5F * limbSwingAmount);
        bob(this.cs_leg_r, walkspeed,  2F * walkheight, true,  limbSwing, 0.5F * limbSwingAmount);



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
