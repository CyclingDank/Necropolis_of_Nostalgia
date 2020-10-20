package com.turtledove.withernauts.client.model.entity.npc;

import com.turtledove.withernauts.server.entity.NecropolisNPC;
import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelTurtNPC extends AdvancedModelBase {
    public AdvancedModelRenderer cs_torso;
    public AdvancedModelRenderer cs_leg_l;
    public AdvancedModelRenderer cs_leg_r;
    public AdvancedModelRenderer cs_head;
    public AdvancedModelRenderer cs_arm_l;
    public AdvancedModelRenderer cs_arm_r;
    public AdvancedModelRenderer cs_shell;
    public AdvancedModelRenderer cs_cloak;
    public AdvancedModelRenderer cs_hood;

    public AdvancedModelRenderer[] cs_parts;
    private ModelAnimator animator;

    public ModelTurtNPC() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.cs_cloak = new AdvancedModelRenderer(this, 54, 0);
        this.cs_cloak.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.cs_cloak.addBox(-4.5F, 0.0F, -2.5F, 9, 19, 5, 0.0F);
        this.cs_leg_l = new AdvancedModelRenderer(this, 0, 16);
        this.cs_leg_l.mirror = true;
        this.cs_leg_l.setRotationPoint(1.9F, 11.0F, 0.0F);
        this.cs_leg_l.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
        this.cs_head = new AdvancedModelRenderer(this, 0, 0);
        this.cs_head.setRotationPoint(0.0F, 0.25F, 0.0F);
        this.cs_head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.cs_arm_l = new AdvancedModelRenderer(this, 40, 16);
        this.cs_arm_l.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.cs_arm_l.addBox(-1.0F, -1.5F, -2.0F, 3, 11, 4, 0.0F);
        this.setRotateAngle(cs_arm_l, 0.0F, 0.0F, -0.17453292519943295F);
        this.cs_leg_r = new AdvancedModelRenderer(this, 0, 16);
        this.cs_leg_r.setRotationPoint(-1.9F, 11.0F, 0.0F);
        this.cs_leg_r.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
        this.cs_torso = new AdvancedModelRenderer(this, 16, 16);
        this.cs_torso.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.cs_torso.addBox(-4.0F, 0.0F, -2.0F, 8, 11, 4, 0.0F);
        this.cs_shell = new AdvancedModelRenderer(this, 0, 32);
        this.cs_shell.setRotationPoint(0.0F, -1.0F, 2.0F);
        this.cs_shell.addBox(-7.0F, 0.0F, -0.0F, 14, 20, 8, 0.0F);
        this.cs_arm_r = new AdvancedModelRenderer(this, 40, 16);
        this.cs_arm_r.mirror = true;
        this.cs_arm_r.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.cs_arm_r.addBox(-2.0F, -1.5F, -2.0F, 3, 11, 4, 0.0F);
        this.setRotateAngle(cs_arm_r, 0.0F, 0.0F, 0.17453292519943295F);
        this.cs_hood = new AdvancedModelRenderer(this, 82, 0);
        this.cs_hood.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.cs_hood.addBox(-4.5F, -9.0F, -4.5F, 9, 9, 9, 0.0F);
        this.cs_torso.addChild(this.cs_cloak);
        this.cs_torso.addChild(this.cs_leg_l);
        this.cs_torso.addChild(this.cs_head);
        this.cs_torso.addChild(this.cs_arm_l);
        this.cs_torso.addChild(this.cs_leg_r);
        this.cs_torso.addChild(this.cs_shell);
        this.cs_torso.addChild(this.cs_arm_r);
        this.cs_head.addChild(this.cs_hood);

        animator = ModelAnimator.create();
        cs_parts = new AdvancedModelRenderer[] { cs_torso, cs_head, cs_arm_l, cs_leg_l, cs_leg_r, cs_arm_r, cs_hood, cs_shell, cs_cloak};
        updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        animate(f, f1, f2, f3, f4, f5, entity);
        this.cs_torso.render(f5);
        resetToDefaultPose();

    }

    public void animate(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        NecropolisNPC cs = (NecropolisNPC)entity;
        animator.update(cs);
        setRotationAngles(f, f1, f2, f3, f4, f5, cs);

    }
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, NecropolisNPC entityIn)
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
        faceTarget(netHeadYaw, 0.0F, 1.0F, this.cs_torso);

        walk(this.cs_leg_l, walkspeed, walkdegree, false, 0F, 0.0F, limbSwing, 0.5F * limbSwingAmount);
        walk(this.cs_leg_r, walkspeed, walkdegree, true, 0F, 0.0F, limbSwing, 0.5F * limbSwingAmount);

        walk(this.cs_arm_l, walkspeed, walkdegree * 0.5F, false, 0F, 0.0F, limbSwing, limbSwingAmount);
        walk(this.cs_arm_r, walkspeed, walkdegree * 0.5F, true, 0F, 0.0F, limbSwing, limbSwingAmount);

        bob(this.cs_torso, walkspeed, -2F * walkheight, true,  limbSwing, 0.5F * limbSwingAmount);
        bob(this.cs_shell, walkspeed, 1F * walkheight, true,  limbSwing, 0.5F * limbSwingAmount);
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
