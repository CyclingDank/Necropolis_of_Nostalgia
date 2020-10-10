package com.turtledove.necropolisofnostalgia.client.model.entity.npc;

import com.turtledove.necropolisofnostalgia.server.entity.NecropolisNPC;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityCultSorceress;
import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelNPC extends AdvancedModelBase
{
    public AdvancedModelRenderer cs_torso;
    public AdvancedModelRenderer cs_head;
    public AdvancedModelRenderer cs_arm_l;
    public AdvancedModelRenderer cs_leg_l;
    public AdvancedModelRenderer cs_leg_r;
    public AdvancedModelRenderer cs_arm_r;

    public AdvancedModelRenderer[] cs_parts;
    private ModelAnimator animator;

    public ModelNPC() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.cs_leg_r = new AdvancedModelRenderer(this, 0, 16);
        this.cs_leg_r.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.cs_leg_r.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.cs_head = new AdvancedModelRenderer(this, 0, 0);
        this.cs_head.setRotationPoint(0.0F, 0.25F, 0.0F);
        this.cs_head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.cs_arm_l = new AdvancedModelRenderer(this, 40, 16);
        this.cs_arm_l.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.cs_arm_l.addBox(-1.0F, -1.5F, -2.0F, 3, 12, 4, 0.0F);
        this.setRotateAngle(cs_arm_l, 0.0F, 0.0F, -0.17453292519943295F);
        this.cs_torso = new AdvancedModelRenderer(this, 16, 16);
        this.cs_torso.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.cs_torso.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.cs_arm_r = new AdvancedModelRenderer(this, 40, 16);
        this.cs_arm_r.mirror = true;
        this.cs_arm_r.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.cs_arm_r.addBox(-2.0F, -1.5F, -2.0F, 3, 12, 4, 0.0F);
        this.setRotateAngle(cs_arm_r, 0.0F, 0.0F, 0.17453292519943295F);
        this.cs_leg_l = new AdvancedModelRenderer(this, 0, 16);
        this.cs_leg_l.mirror = true;
        this.cs_leg_l.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.cs_leg_l.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.cs_torso.addChild(this.cs_leg_r);
        this.cs_torso.addChild(this.cs_head);
        this.cs_torso.addChild(this.cs_arm_l);
        this.cs_torso.addChild(this.cs_arm_r);
        this.cs_torso.addChild(this.cs_leg_l);


        animator = ModelAnimator.create();
        cs_parts = new AdvancedModelRenderer[] { cs_torso, cs_head, cs_arm_l, cs_leg_l, cs_leg_r, cs_arm_r};
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
