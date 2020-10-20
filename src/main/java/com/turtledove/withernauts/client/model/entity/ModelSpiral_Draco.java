package com.turtledove.withernauts.client.model.entity;

import com.turtledove.withernauts.server.entity.Spiral_Draco.EntitySpiral_Draco;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.ilexiconn.llibrary.client.model.ModelAnimator;

/**
 * Spiral_Draco - Turtledove
 * Created using Tabula 7.1.0
 */

/*Addiitonal flags*/
enum Draco_CHeadState {IDLING,ROARING,HEALING,CASTING,DEAD}
enum Draco_LHeadState {IDLING,FIRING,DEAD}
enum Draco_RHeadState {IDLING,FIRING,DEAD}
enum Draco_BodyState {IDLING,RUNNING,DEAD}
enum Draco_TailState {IDLING,FLAILING,DEAD}

public class ModelSpiral_Draco extends AdvancedModelBase {
    public AdvancedModelRenderer Draco_CTorso_Joint;
    public AdvancedModelRenderer Draco_CTorso_1;
    public AdvancedModelRenderer Draco_Groin;
    public AdvancedModelRenderer Draco_LTorso_1;
    public AdvancedModelRenderer Draco_RTorso_1;
    public AdvancedModelRenderer Draco_CTorso_2;
    public AdvancedModelRenderer Draco_CTorso_3;
    public AdvancedModelRenderer Draco_CFace;
    public AdvancedModelRenderer Draco_CNeck;
    public AdvancedModelRenderer Draco_F_R_Wing_1;
    public AdvancedModelRenderer Draco_F_L_Wing_1;
    public AdvancedModelRenderer Draco_CHorn_1;
    public AdvancedModelRenderer Draco_CHorn_2;
    public AdvancedModelRenderer Draco_CHorn_3;
    public AdvancedModelRenderer Draco_F_R_Wing_2;
    public AdvancedModelRenderer Draco_F_R_Wing_3;
    public AdvancedModelRenderer Draco_F_R_Wing_4;
    public AdvancedModelRenderer Draco_F_L_Wing_2;
    public AdvancedModelRenderer Draco_F_L_Wing_3;
    public AdvancedModelRenderer Draco_F_L_Wing_4;
    public AdvancedModelRenderer Draco_Body;
    public AdvancedModelRenderer Draco_F_Right_Thigh_1;
    public AdvancedModelRenderer Draco_F_Left_Thigh_1;
    public AdvancedModelRenderer Draco_Body_1;
    public AdvancedModelRenderer Draco_Body_2;
    public AdvancedModelRenderer Draco_R_Right_Thigh_1;
    public AdvancedModelRenderer Draco_R_Left_Thigh_1;
    public AdvancedModelRenderer Draco_Tail_1;
    public AdvancedModelRenderer Draco_R_Right_Thigh_2;
    public AdvancedModelRenderer Draco_R_Right_Foot_1;
    public AdvancedModelRenderer Draco_R_Right_Foot_2;
    public AdvancedModelRenderer Draco_R_Right_RearClaw;
    public AdvancedModelRenderer Draco_R_Right_RightClaw;
    public AdvancedModelRenderer Draco_R_Right_LeftClaw;
    public AdvancedModelRenderer Draco_R_Left_Thigh_2;
    public AdvancedModelRenderer Draco_R_Left_Foot_1;
    public AdvancedModelRenderer Draco_R_Left_Foot_2;
    public AdvancedModelRenderer Draco_R_Left_RearClaw;
    public AdvancedModelRenderer Draco_R_Left_RightClaw;
    public AdvancedModelRenderer Draco_R_Left_LeftClaw;
    public AdvancedModelRenderer Draco_Tail_2;
    public AdvancedModelRenderer Draco_Tail_3;
    public AdvancedModelRenderer Draco_Tail_4;
    public AdvancedModelRenderer Draco_Tail_5;
    public AdvancedModelRenderer Draco_Tail_BottonClaw_1;
    public AdvancedModelRenderer Draco_Tail_TopClaw_1;
    public AdvancedModelRenderer Draco_Tail_RightClaw_1;
    public AdvancedModelRenderer Draco_Tail_LeftClaw_1;
    public AdvancedModelRenderer Draco_Tail_BottonClaw_2;
    public AdvancedModelRenderer Draco_Tail_TopClaw_2;
    public AdvancedModelRenderer Draco_Tail_RightClaw_2;
    public AdvancedModelRenderer Draco_Tail_LeftClaw_2;
    public AdvancedModelRenderer Draco_F_Right_Thigh_2;
    public AdvancedModelRenderer Draco_F_Right_Foot_1;
    public AdvancedModelRenderer Draco_F_Right_Foot_2;
    public AdvancedModelRenderer Draco_F_Right_RearClaw;
    public AdvancedModelRenderer Draco_F_Right_RightClaw;
    public AdvancedModelRenderer Draco_F_Right_LeftClaw;
    public AdvancedModelRenderer Draco_F_Left_Thigh_2;
    public AdvancedModelRenderer Draco_F_Left_Foot_1;
    public AdvancedModelRenderer Draco_F_Left_Foot_2;
    public AdvancedModelRenderer Draco_F_Left_RearClaw;
    public AdvancedModelRenderer Draco_F_Left_RightClaw;
    public AdvancedModelRenderer Draco_F_Left_LeftClaw;
    public AdvancedModelRenderer Draco_LTorso_2;
    public AdvancedModelRenderer Draco_LNeck;
    public AdvancedModelRenderer Draco_LFace;
    public AdvancedModelRenderer Draco_LHead;
    public AdvancedModelRenderer Draco_L_RHorn_1;
    public AdvancedModelRenderer Draco_L_LHorn_1;
    public AdvancedModelRenderer Draco_L_RHorn_2;
    public AdvancedModelRenderer Draco_L_RHorn_3;
    public AdvancedModelRenderer Draco_L_LHorn_2;
    public AdvancedModelRenderer Draco_L_LHorn_3;
    public AdvancedModelRenderer Draco_RTorso_2;
    public AdvancedModelRenderer Draco_RNeck;
    public AdvancedModelRenderer Draco_RFace;
    public AdvancedModelRenderer Draco_RHead;
    public AdvancedModelRenderer Draco_R_RHorn_1;
    public AdvancedModelRenderer Draco_R_LHorn_1;
    public AdvancedModelRenderer Draco_R_RHorn_2;
    public AdvancedModelRenderer Draco_R_RHorn_3;
    public AdvancedModelRenderer Draco_R_LHorn_2;
    public AdvancedModelRenderer Draco_R_LHorn_3;

    public AdvancedModelRenderer[] spiral_draco_parts;
    private ModelAnimator animator;

    protected float prevLimbSwing;
    protected float currentLimbSwing;

    protected Draco_CHeadState draco_chead_state;
    protected Draco_LHeadState draco_lhead_state;
    protected Draco_RHeadState draco_rhead_state;
    protected Draco_TailState draco_tail_state;

    public ModelSpiral_Draco()
    {
        draco_chead_state = Draco_CHeadState.IDLING;
        draco_lhead_state = Draco_LHeadState.IDLING;
        draco_rhead_state = Draco_RHeadState.IDLING;
        draco_tail_state = Draco_TailState.IDLING;
        prevLimbSwing = 0;
        currentLimbSwing = 0;
        animator = ModelAnimator.create();
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.Draco_R_LHorn_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_R_LHorn_1.setRotationPoint(0.1F, -3.3F, -0.4F);
        this.Draco_R_LHorn_1.addBox(0.0F, -6.3F, -0.8F, 1, 6, 1, 0.0F);
        this.setRotateAngle(Draco_R_LHorn_1, -2.548180707911721F, -1.5481070465189704F, 0.0F);
        this.Draco_R_Left_Foot_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_R_Left_Foot_2.setRotationPoint(0.6F, -3.3F, 8.2F);
        this.Draco_R_Left_Foot_2.addBox(-3.0F, -3.0F, 0.0F, 3, 7, 2, 0.0F);
        this.setRotateAngle(Draco_R_Left_Foot_2, 0.136659280431156F, 0.0F, 0.0F);
        this.Draco_Tail_LeftClaw_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_Tail_LeftClaw_1.setRotationPoint(-2.3F, 0.0F, 4.9F);
        this.Draco_Tail_LeftClaw_1.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 6, 0.0F);
        this.setRotateAngle(Draco_Tail_LeftClaw_1, 0.0F, -0.6829473363053812F, 0.0F);
        this.Draco_Tail_TopClaw_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_Tail_TopClaw_1.setRotationPoint(0.0F, -2.3F, 4.9F);
        this.Draco_Tail_TopClaw_1.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 6, 0.0F);
        this.setRotateAngle(Draco_Tail_TopClaw_1, 0.6829473363053812F, 0.0F, 0.0F);
        this.Draco_CHorn_3 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_CHorn_3.setRotationPoint(-1.1F, -7.6F, 1.1F);
        this.Draco_CHorn_3.addBox(1.0F, -9.0F, -2.0F, 1, 9, 1, 0.0F);
        this.setRotateAngle(Draco_CHorn_3, -0.136659280431156F, 0.0F, -0.136659280431156F);
        this.Draco_R_Left_Thigh_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_R_Left_Thigh_2.setRotationPoint(-2.5F, 8.8F, -0.4F);
        this.Draco_R_Left_Thigh_2.addBox(-2.0F, -4.0F, 0.0F, 4, 4, 7, 0.0F);
        this.setRotateAngle(Draco_R_Left_Thigh_2, -0.5918411493512771F, 0.5009094953223726F, 0.0F);
        this.Draco_R_RHorn_3 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_R_RHorn_3.setRotationPoint(0.0F, -2.5F, 0.1F);
        this.Draco_R_RHorn_3.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(Draco_R_RHorn_3, 1.0927506446736497F, 0.0F, 0.0F);
        this.Draco_Tail_BottonClaw_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_Tail_BottonClaw_2.setRotationPoint(0.0F, 0.0F, 5.6F);
        this.Draco_Tail_BottonClaw_2.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(Draco_Tail_BottonClaw_2, 0.9560913642424937F, 0.0F, 0.0F);
        this.Draco_F_Right_Foot_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_Right_Foot_1.setRotationPoint(0.0F, 3.3F, 2.5F);
        this.Draco_F_Right_Foot_1.addBox(-1.0F, 0.0F, 0.0F, 2, 10, 3, 0.0F);
        this.setRotateAngle(Draco_F_Right_Foot_1, -1.1838568316277536F, 0.0F, 0.0F);
        this.Draco_LTorso_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_LTorso_2.setRotationPoint(0.0F, -3.0F, -0.3F);
        this.Draco_LTorso_2.addBox(-3.0F, -4.0F, -5.0F, 6, 4, 6, 0.0F);
        this.setRotateAngle(Draco_LTorso_2, -0.27314402793711257F, 0.0F, 0.012740903539558604F);
        this.Draco_Tail_LeftClaw_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_Tail_LeftClaw_2.setRotationPoint(0.0F, 0.0F, 5.6F);
        this.Draco_Tail_LeftClaw_2.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(Draco_Tail_LeftClaw_2, 0.0F, 1.0016444577195458F, 0.0F);
        this.Draco_LHead = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_LHead.setRotationPoint(-1.3F, -7.6F, 1.3F);
        this.Draco_LHead.addBox(-1.0F, -9.0F, -2.0F, 3, 9, 3, 0.0F);
        this.setRotateAngle(Draco_LHead, 0.136659280431156F, -0.091106186954104F, 0.136659280431156F);
        this.Draco_Tail_RightClaw_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_Tail_RightClaw_1.setRotationPoint(2.3F, 0.0F, 4.9F);
        this.Draco_Tail_RightClaw_1.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 6, 0.0F);
        this.setRotateAngle(Draco_Tail_RightClaw_1, 0.0F, 0.6829473363053812F, 0.0F);
        this.Draco_RTorso_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_RTorso_1.setRotationPoint(2.0F, 0.0F, 0.0F);
        this.Draco_RTorso_1.addBox(-2.5F, -6.0F, -4.0F, 5, 6, 4, 0.0F);
        this.setRotateAngle(Draco_RTorso_1, 0.9105382707654417F, -0.9560913642424937F, 0.0F);
        this.Draco_CHorn_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_CHorn_1.setRotationPoint(-1.3F, -7.6F, 1.3F);
        this.Draco_CHorn_1.addBox(-1.0F, -9.0F, -2.0F, 3, 9, 3, 0.0F);
        this.setRotateAngle(Draco_CHorn_1, 0.136659280431156F, -0.091106186954104F, 0.136659280431156F);
        this.Draco_F_R_Wing_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_R_Wing_2.setRotationPoint(0.0F, 0.1F, 9.6F);
        this.Draco_F_R_Wing_2.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 15, 0.0F);
        this.setRotateAngle(Draco_F_R_Wing_2, 1.1383037381507017F, 0.0F, 0.0F);
        this.Draco_F_Right_Thigh_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_Right_Thigh_2.setRotationPoint(2.0F, 9.6F, 0.9F);
        this.Draco_F_Right_Thigh_2.addBox(-1.5F, 0.0F, 0.0F, 3, 6, 4, 0.0F);
        this.setRotateAngle(Draco_F_Right_Thigh_2, 1.5481070465189704F, 0.0F, 0.0F);
        this.Draco_CFace = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_CFace.setRotationPoint(0.0F, -15.6F, -13.1F);
        this.Draco_CFace.addBox(-3.0F, 0.0F, -2.0F, 5, 3, 5, 0.0F);
        this.setRotateAngle(Draco_CFace, -0.27314402793711257F, 0.7285004297824331F, -0.18203784098300857F);
        this.Draco_Body_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_Body_1.setRotationPoint(0.0F, -0.4F, 8.4F);
        this.Draco_Body_1.addBox(-4.0F, 1.0F, 0.0F, 8, 7, 8, 0.0F);
        this.Draco_R_Right_Foot_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_R_Right_Foot_1.setRotationPoint(1.3F, -1.9F, 3.4F);
        this.Draco_R_Right_Foot_1.addBox(-2.0F, -4.0F, 0.0F, 2, 3, 10, 0.0F);
        this.setRotateAngle(Draco_R_Right_Foot_1, -1.1383037381507017F, -0.18203784098300857F, 0.18203784098300857F);
        this.Draco_F_L_Wing_4 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_L_Wing_4.setRotationPoint(0.9F, 0.4F, 0.0F);
        this.Draco_F_L_Wing_4.addBox(-0.5F, -0.5F, -4.0F, 0, 20, 27, 0.0F);
        this.Draco_L_RHorn_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_L_RHorn_1.setRotationPoint(-0.1F, -3.3F, -0.4F);
        this.Draco_L_RHorn_1.addBox(0.0F, -6.3F, -0.8F, 1, 6, 1, 0.0F);
        this.setRotateAngle(Draco_L_RHorn_1, -2.5497515042385164F, 0.0F, 0.1494001839707146F);
        this.Draco_CHorn_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_CHorn_2.setRotationPoint(-1.3F, -7.6F, 1.3F);
        this.Draco_CHorn_2.addBox(0.0F, -9.0F, -2.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(Draco_CHorn_2, 0.136659280431156F, 0.0F, 0.1494001839707146F);
        this.Draco_CTorso_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_CTorso_2.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.Draco_CTorso_2.addBox(-2.6F, -6.0F, -4.0F, 5, 6, 4, 0.0F);
        this.setRotateAngle(Draco_CTorso_2, 0.31869712141416456F, 0.0F, 0.0F);
        this.Draco_L_RHorn_3 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_L_RHorn_3.setRotationPoint(0.0F, -2.5F, 0.1F);
        this.Draco_L_RHorn_3.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(Draco_L_RHorn_3, 1.0927506446736497F, 0.0F, 0.0F);
        this.Draco_LTorso_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_LTorso_1.setRotationPoint(-2.0F, 0.1F, 0.1F);
        this.Draco_LTorso_1.addBox(-2.5F, -6.0F, -4.0F, 5, 6, 4, 0.0F);
        this.setRotateAngle(Draco_LTorso_1, 1.0927506446736497F, 0.9105382707654417F, 0.0F);
        this.Draco_R_RHorn_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_R_RHorn_2.setRotationPoint(0.5F, -5.9F, -0.3F);
        this.Draco_R_RHorn_2.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(Draco_R_RHorn_2, -1.0471975511965976F, -0.045553093477052F, 0.0F);
        this.Draco_Tail_3 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_Tail_3.setRotationPoint(0.0F, 3.2F, 12.0F);
        this.Draco_Tail_3.addBox(-2.5F, -2.5F, 0.0F, 5, 5, 15, 0.0F);
        this.setRotateAngle(Draco_Tail_3, 0.091106186954104F, 0.0F, 0.0F);
        this.Draco_R_Left_LeftClaw = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_R_Left_LeftClaw.setRotationPoint(-5.0F, 0.0F, 1.0F);
        this.Draco_R_Left_LeftClaw.addBox(2.0F, 2.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Draco_F_Left_RightClaw = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_Left_RightClaw.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.Draco_F_Left_RightClaw.addBox(-4.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Draco_RTorso_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_RTorso_2.setRotationPoint(0.0F, -3.0F, -0.3F);
        this.Draco_RTorso_2.addBox(-3.0F, -4.0F, -5.0F, 6, 4, 6, 0.0F);
        this.setRotateAngle(Draco_RTorso_2, -0.136659280431156F, 0.0F, 0.012740903539558604F);
        this.Draco_R_Right_Thigh_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_R_Right_Thigh_2.setRotationPoint(2.5F, 9.6F, -0.4F);
        this.Draco_R_Right_Thigh_2.addBox(-2.0F, -4.0F, 0.0F, 4, 4, 7, 0.0F);
        this.setRotateAngle(Draco_R_Right_Thigh_2, -0.5918411493512771F, -0.5009094953223726F, 0.0F);
        this.Draco_CTorso_3 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_CTorso_3.setRotationPoint(0.0F, -5.7F, -0.3F);
        this.Draco_CTorso_3.addBox(-3.0F, -4.0F, -5.0F, 6, 4, 6, 0.0F);
        this.setRotateAngle(Draco_CTorso_3, 0.40980330836826856F, 0.0F, 0.012827404733494452F);
        this.Draco_R_RHorn_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_R_RHorn_1.setRotationPoint(-0.1F, -3.3F, -0.4F);
        this.Draco_R_RHorn_1.addBox(0.0F, -6.3F, -0.8F, 1, 6, 1, 0.0F);
        this.setRotateAngle(Draco_R_RHorn_1, -2.5497515042385164F, 0.0F, 0.1494001839707146F);
        this.Draco_Body = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_Body.setRotationPoint(0.1F, 0.1F, 0.0F);
        this.Draco_Body.addBox(-5.5F, 0.0F, 0.0F, 11, 10, 10, 0.0F);
        this.setRotateAngle(Draco_Body, 0.5649630788705644F, 0.0F, 0.0F);
        this.Draco_CNeck = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_CNeck.setRotationPoint(0.0F, -2.6F, -1.7F);
        this.Draco_CNeck.addBox(-2.0F, -9.0F, -2.0F, 4, 9, 4, 0.0F);
        this.setRotateAngle(Draco_CNeck, 0.4553564018453205F, 0.6829473363053812F, 0.27314402793711257F);
        this.Draco_LNeck = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_LNeck.setRotationPoint(0.0F, -2.6F, -1.7F);
        this.Draco_LNeck.addBox(-2.0F, -9.0F, -2.0F, 4, 9, 4, 0.0F);
        this.setRotateAngle(Draco_LNeck, 0.4553564018453205F, 0.6829473363053812F, 0.27314402793711257F);
        this.Draco_R_Left_RearClaw = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_R_Left_RearClaw.setRotationPoint(-3.0F, -5.0F, 1.0F);
        this.Draco_R_Left_RearClaw.addBox(1.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Draco_RNeck = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_RNeck.setRotationPoint(0.0F, -2.6F, -1.7F);
        this.Draco_RNeck.addBox(-2.0F, -9.0F, -2.0F, 4, 9, 4, 0.0F);
        this.setRotateAngle(Draco_RNeck, 0.4553564018453205F, 0.6829473363053812F, 0.27314402793711257F);
        this.Draco_RHead = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_RHead.setRotationPoint(-1.3F, -7.6F, 1.3F);
        this.Draco_RHead.addBox(-1.0F, -9.0F, -2.0F, 3, 9, 3, 0.0F);
        this.setRotateAngle(Draco_RHead, 0.136659280431156F, -0.091106186954104F, 0.136659280431156F);
        this.Draco_R_Left_Foot_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_R_Left_Foot_1.setRotationPoint(0.8F, -1.7F, 2.9F);
        this.Draco_R_Left_Foot_1.addBox(-2.0F, -4.0F, 0.0F, 2, 3, 10, 0.0F);
        this.setRotateAngle(Draco_R_Left_Foot_1, -1.1383037381507017F, 0.18203784098300857F, -0.18203784098300857F);
        this.Draco_L_LHorn_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_L_LHorn_1.setRotationPoint(0.1F, -3.3F, -0.4F);
        this.Draco_L_LHorn_1.addBox(0.0F, -6.3F, -0.8F, 1, 6, 1, 0.0F);
        this.setRotateAngle(Draco_L_LHorn_1, -2.548180707911721F, -1.5481070465189704F, 0.0F);
        this.Draco_L_LHorn_3 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_L_LHorn_3.setRotationPoint(0.0F, -2.5F, 0.1F);
        this.Draco_L_LHorn_3.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(Draco_L_LHorn_3, 1.0927506446736497F, 0.0F, 0.0F);
        this.Draco_F_Right_RearClaw = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_Right_RearClaw.setRotationPoint(0.0F, -3.4F, 1.0F);
        this.Draco_F_Right_RearClaw.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Draco_Body_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_Body_2.setRotationPoint(0.0F, 1.5F, 6.6F);
        this.Draco_Body_2.addBox(-5.0F, 0.0F, 0.0F, 10, 8, 8, 0.0F);
        this.Draco_L_LHorn_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_L_LHorn_2.setRotationPoint(0.5F, -5.9F, -0.3F);
        this.Draco_L_LHorn_2.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(Draco_L_LHorn_2, -1.0471975511965976F, -0.045553093477052F, 0.0F);
        this.Draco_F_R_Wing_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_R_Wing_1.setRotationPoint(2.0F, -5.8F, -3.0F);
        this.Draco_F_R_Wing_1.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 10, 0.0F);
        this.setRotateAngle(Draco_F_R_Wing_1, 0.0F, 0.6373942428283291F, 0.0F);
        this.Draco_R_Right_LeftClaw = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_R_Right_LeftClaw.setRotationPoint(-5.0F, 0.0F, 1.0F);
        this.Draco_R_Right_LeftClaw.addBox(2.0F, 2.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Draco_R_Left_RightClaw = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_R_Left_RightClaw.setRotationPoint(-3.0F, 0.0F, 1.0F);
        this.Draco_R_Left_RightClaw.addBox(2.0F, 2.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Draco_F_Right_Thigh_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_Right_Thigh_1.setRotationPoint(3.5F, 3.2F, 3.1F);
        this.Draco_F_Right_Thigh_1.addBox(0.0F, -0.2F, -2.0F, 4, 10, 5, 0.0F);
        this.setRotateAngle(Draco_F_Right_Thigh_1, 0.045553093477052F, 0.0F, 0.0F);
        this.Draco_F_Right_LeftClaw = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_Right_LeftClaw.setRotationPoint(-2.0F, 0.0F, 1.0F);
        this.Draco_F_Right_LeftClaw.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Draco_Tail_BottonClaw_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_Tail_BottonClaw_1.setRotationPoint(0.0F, 2.3F, 4.9F);
        this.Draco_Tail_BottonClaw_1.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 6, 0.0F);
        this.setRotateAngle(Draco_Tail_BottonClaw_1, -0.6829473363053812F, 0.0F, 0.0F);
        this.Draco_F_Left_Thigh_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_Left_Thigh_2.setRotationPoint(2.0F, 9.6F, 0.9F);
        this.Draco_F_Left_Thigh_2.addBox(-5.5F, 0.0F, 0.0F, 3, 6, 4, 0.0F);
        this.setRotateAngle(Draco_F_Left_Thigh_2, 1.5481070465189704F, 0.0F, 0.0F);
        this.Draco_R_LHorn_3 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_R_LHorn_3.setRotationPoint(0.0F, -2.5F, 0.1F);
        this.Draco_R_LHorn_3.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(Draco_R_LHorn_3, 1.0927506446736497F, 0.0F, 0.0F);
        this.Draco_CTorso_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_CTorso_1.setRotationPoint(0.3F, -1.0F, -2.5F);
        this.Draco_CTorso_1.addBox(-3.6F, -5.0F, -4.0F, 7, 6, 4, 0.0F);
        this.setRotateAngle(Draco_CTorso_1, 0.40980330836826856F, 0.0F, 0.0F);
        this.Draco_LFace = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_LFace.setRotationPoint(0.0F, -14.6F, -7.1F);
        this.Draco_LFace.addBox(-2.5F, 0.0F, -2.5F, 5, 3, 5, 0.0F);
        this.setRotateAngle(Draco_LFace, -0.27314402793711257F, 0.7285004297824331F, -0.18203784098300857F);
        this.Draco_R_LHorn_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_R_LHorn_2.setRotationPoint(0.5F, -5.9F, -0.3F);
        this.Draco_R_LHorn_2.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(Draco_R_LHorn_2, -1.0471975511965976F, -0.045553093477052F, 0.0F);
        this.Draco_F_R_Wing_4 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_R_Wing_4.setRotationPoint(0.0F, 0.4F, 0.0F);
        this.Draco_F_R_Wing_4.addBox(-0.5F, -0.5F, -4.0F, 0, 20, 27, 0.0F);
        this.Draco_RFace = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_RFace.setRotationPoint(0.0F, -14.6F, -7.1F);
        this.Draco_RFace.addBox(-2.5F, 0.0F, -2.5F, 5, 3, 5, 0.0F);
        this.setRotateAngle(Draco_RFace, -0.27314402793711257F, 0.7285004297824331F, -0.18203784098300857F);
        this.Draco_R_Right_Foot_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_R_Right_Foot_2.setRotationPoint(0.6F, -3.3F, 8.5F);
        this.Draco_R_Right_Foot_2.addBox(-3.0F, -3.0F, 0.0F, 3, 7, 2, 0.0F);
        this.setRotateAngle(Draco_R_Right_Foot_2, 0.136659280431156F, 0.0F, 0.0F);
        this.Draco_Tail_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_Tail_1.setRotationPoint(0.0F, 0.7F, 5.0F);
        this.Draco_Tail_1.addBox(-3.5F, 0.0F, 0.0F, 7, 7, 10, 0.0F);
        this.Draco_F_L_Wing_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_L_Wing_2.setRotationPoint(0.0F, 0.1F, 9.6F);
        this.Draco_F_L_Wing_2.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 15, 0.0F);
        this.setRotateAngle(Draco_F_L_Wing_2, 1.1383037381507017F, 0.0F, 0.0F);
        this.Draco_CTorso_Joint = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_CTorso_Joint.setRotationPoint(-0.3F, -86.0F, 9.0F);
        this.Draco_CTorso_Joint.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.Draco_F_Right_RightClaw = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_Right_RightClaw.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.Draco_F_Right_RightClaw.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Draco_F_R_Wing_3 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_R_Wing_3.setRotationPoint(0.0F, 0.0F, 13.0F);
        this.Draco_F_R_Wing_3.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 20, 0.0F);
        this.setRotateAngle(Draco_F_R_Wing_3, -1.8668041679331349F, 0.0F, 0.0F);
        this.Draco_Groin = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_Groin.setRotationPoint(0.3F, -1.8F, -6.4F);
        this.Draco_Groin.addBox(-3.5F, 0.0F, 0.0F, 7, 9, 6, 0.0F);
        this.setRotateAngle(Draco_Groin, -0.5649630788705644F, 0.0F, 0.0F);
        this.Draco_F_Left_Foot_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_Left_Foot_2.setRotationPoint(0.5F, 9.1F, 1.5F);
        this.Draco_F_Left_Foot_2.addBox(-6.0F, -2.0F, 0.0F, 3, 6, 2, 0.0F);
        this.setRotateAngle(Draco_F_Left_Foot_2, -1.4114477660878142F, 0.0F, 0.0F);
        this.Draco_Tail_4 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_Tail_4.setRotationPoint(0.0F, 0.0F, 13.6F);
        this.Draco_Tail_4.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 5, 0.0F);
        this.setRotateAngle(Draco_Tail_4, 0.136659280431156F, 0.0F, 0.0F);
        this.Draco_F_Left_RearClaw = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_Left_RearClaw.setRotationPoint(0.0F, -3.4F, 1.0F);
        this.Draco_F_Left_RearClaw.addBox(-5.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Draco_R_Right_RightClaw = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_R_Right_RightClaw.setRotationPoint(-3.0F, 0.0F, 1.0F);
        this.Draco_R_Right_RightClaw.addBox(2.0F, 2.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Draco_F_Left_LeftClaw = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_Left_LeftClaw.setRotationPoint(-2.0F, 0.0F, 1.0F);
        this.Draco_F_Left_LeftClaw.addBox(-4.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Draco_R_Right_RearClaw = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_R_Right_RearClaw.setRotationPoint(-3.0F, -5.0F, 1.0F);
        this.Draco_R_Right_RearClaw.addBox(1.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.Draco_F_Right_Foot_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_Right_Foot_2.setRotationPoint(0.5F, 9.1F, 1.5F);
        this.Draco_F_Right_Foot_2.addBox(-2.0F, -2.0F, 0.0F, 3, 6, 2, 0.0F);
        this.setRotateAngle(Draco_F_Right_Foot_2, -1.4114477660878142F, 0.0F, 0.0F);
        this.Draco_L_RHorn_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_L_RHorn_2.setRotationPoint(0.5F, -5.9F, -0.3F);
        this.Draco_L_RHorn_2.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(Draco_L_RHorn_2, -1.0471975511965976F, -0.045553093477052F, 0.0F);
        this.Draco_Tail_5 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_Tail_5.setRotationPoint(0.0F, 0.0F, 3.7F);
        this.Draco_Tail_5.addBox(-3.5F, -3.5F, 0.0F, 7, 7, 6, 0.0F);
        this.Draco_F_Left_Foot_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_Left_Foot_1.setRotationPoint(0.0F, 3.3F, 2.5F);
        this.Draco_F_Left_Foot_1.addBox(-5.0F, 0.0F, 0.0F, 2, 10, 3, 0.0F);
        this.setRotateAngle(Draco_F_Left_Foot_1, -1.1838568316277536F, 0.0F, 0.0F);
        this.Draco_F_L_Wing_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_L_Wing_1.setRotationPoint(-2.0F, -5.8F, -3.0F);
        this.Draco_F_L_Wing_1.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 10, 0.0F);
        this.setRotateAngle(Draco_F_L_Wing_1, 0.0F, -0.6373942428283291F, 0.0F);
        this.Draco_Tail_TopClaw_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_Tail_TopClaw_2.setRotationPoint(0.0F, 0.0F, 5.6F);
        this.Draco_Tail_TopClaw_2.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(Draco_Tail_TopClaw_2, -1.0016444577195458F, 0.0F, 0.0F);
        this.Draco_R_Right_Thigh_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_R_Right_Thigh_1.setRotationPoint(3.5F, 3.2F, 5.0F);
        this.Draco_R_Right_Thigh_1.addBox(0.0F, 0.0F, -2.5F, 5, 10, 5, 0.0F);
        this.setRotateAngle(Draco_R_Right_Thigh_1, 0.0F, 0.5009094953223726F, -0.27314402793711257F);
        this.Draco_R_Left_Thigh_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_R_Left_Thigh_1.setRotationPoint(-3.5F, 4.0F, 5.0F);
        this.Draco_R_Left_Thigh_1.addBox(-5.0F, -0.7F, -2.5F, 5, 10, 5, 0.0F);
        this.setRotateAngle(Draco_R_Left_Thigh_1, 0.0F, -0.5009094953223726F, 0.27314402793711257F);
        this.Draco_Tail_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_Tail_2.setRotationPoint(0.0F, 0.6F, 8.0F);
        this.Draco_Tail_2.addBox(-3.0F, 0.0F, 0.0F, 6, 6, 14, 0.0F);
        this.setRotateAngle(Draco_Tail_2, -0.091106186954104F, 0.0F, 0.0F);
        this.Draco_Tail_RightClaw_2 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_Tail_RightClaw_2.setRotationPoint(0.0F, 0.0F, 5.6F);
        this.Draco_Tail_RightClaw_2.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(Draco_Tail_RightClaw_2, 0.0F, -1.0016444577195458F, 0.0F);
        this.Draco_F_L_Wing_3 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_L_Wing_3.setRotationPoint(0.0F, 0.0F, 13.0F);
        this.Draco_F_L_Wing_3.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 20, 0.0F);
        this.setRotateAngle(Draco_F_L_Wing_3, -1.8668041679331349F, 0.0F, 0.0F);
        this.Draco_F_Left_Thigh_1 = new AdvancedModelRenderer(this, 0, 0);
        this.Draco_F_Left_Thigh_1.setRotationPoint(-3.5F, 3.2F, 3.1F);
        this.Draco_F_Left_Thigh_1.addBox(-4.0F, -0.2F, -2.0F, 4, 10, 5, 0.0F);
        this.setRotateAngle(Draco_F_Left_Thigh_1, 0.045553093477052F, 0.0F, 0.0F);
        this.Draco_RHead.addChild(this.Draco_R_LHorn_1);
        this.Draco_R_Left_Foot_1.addChild(this.Draco_R_Left_Foot_2);
        this.Draco_Tail_5.addChild(this.Draco_Tail_LeftClaw_1);
        this.Draco_Tail_5.addChild(this.Draco_Tail_TopClaw_1);
        this.Draco_CHorn_2.addChild(this.Draco_CHorn_3);
        this.Draco_R_Left_Thigh_1.addChild(this.Draco_R_Left_Thigh_2);
        this.Draco_R_RHorn_2.addChild(this.Draco_R_RHorn_3);
        this.Draco_Tail_BottonClaw_1.addChild(this.Draco_Tail_BottonClaw_2);
        this.Draco_F_Right_Thigh_2.addChild(this.Draco_F_Right_Foot_1);
        this.Draco_LTorso_1.addChild(this.Draco_LTorso_2);
        this.Draco_Tail_LeftClaw_1.addChild(this.Draco_Tail_LeftClaw_2);
        this.Draco_LNeck.addChild(this.Draco_LHead);
        this.Draco_Tail_5.addChild(this.Draco_Tail_RightClaw_1);
        this.Draco_CTorso_Joint.addChild(this.Draco_RTorso_1);
        this.Draco_CNeck.addChild(this.Draco_CHorn_1);
        this.Draco_F_R_Wing_1.addChild(this.Draco_F_R_Wing_2);
        this.Draco_F_Right_Thigh_1.addChild(this.Draco_F_Right_Thigh_2);
        this.Draco_CTorso_2.addChild(this.Draco_CFace);
        this.Draco_Body.addChild(this.Draco_Body_1);
        this.Draco_R_Right_Thigh_2.addChild(this.Draco_R_Right_Foot_1);
        this.Draco_F_L_Wing_3.addChild(this.Draco_F_L_Wing_4);
        this.Draco_LHead.addChild(this.Draco_L_RHorn_1);
        this.Draco_CHorn_1.addChild(this.Draco_CHorn_2);
        this.Draco_CTorso_1.addChild(this.Draco_CTorso_2);
        this.Draco_L_RHorn_2.addChild(this.Draco_L_RHorn_3);
        this.Draco_CTorso_Joint.addChild(this.Draco_LTorso_1);
        this.Draco_R_RHorn_1.addChild(this.Draco_R_RHorn_2);
        this.Draco_Tail_2.addChild(this.Draco_Tail_3);
        this.Draco_R_Left_Foot_2.addChild(this.Draco_R_Left_LeftClaw);
        this.Draco_F_Left_Foot_2.addChild(this.Draco_F_Left_RightClaw);
        this.Draco_RTorso_1.addChild(this.Draco_RTorso_2);
        this.Draco_R_Right_Thigh_1.addChild(this.Draco_R_Right_Thigh_2);
        this.Draco_CTorso_2.addChild(this.Draco_CTorso_3);
        this.Draco_RHead.addChild(this.Draco_R_RHorn_1);
        this.Draco_Groin.addChild(this.Draco_Body);
        this.Draco_CTorso_3.addChild(this.Draco_CNeck);
        this.Draco_LTorso_2.addChild(this.Draco_LNeck);
        this.Draco_R_Left_Foot_2.addChild(this.Draco_R_Left_RearClaw);
        this.Draco_RTorso_2.addChild(this.Draco_RNeck);
        this.Draco_RNeck.addChild(this.Draco_RHead);
        this.Draco_R_Left_Thigh_2.addChild(this.Draco_R_Left_Foot_1);
        this.Draco_LHead.addChild(this.Draco_L_LHorn_1);
        this.Draco_L_LHorn_2.addChild(this.Draco_L_LHorn_3);
        this.Draco_F_Right_Foot_2.addChild(this.Draco_F_Right_RearClaw);
        this.Draco_Body_1.addChild(this.Draco_Body_2);
        this.Draco_L_LHorn_1.addChild(this.Draco_L_LHorn_2);
        this.Draco_CTorso_3.addChild(this.Draco_F_R_Wing_1);
        this.Draco_R_Right_Foot_2.addChild(this.Draco_R_Right_LeftClaw);
        this.Draco_R_Left_Foot_2.addChild(this.Draco_R_Left_RightClaw);
        this.Draco_Groin.addChild(this.Draco_F_Right_Thigh_1);
        this.Draco_F_Right_Foot_2.addChild(this.Draco_F_Right_LeftClaw);
        this.Draco_Tail_5.addChild(this.Draco_Tail_BottonClaw_1);
        this.Draco_F_Left_Thigh_1.addChild(this.Draco_F_Left_Thigh_2);
        this.Draco_R_LHorn_2.addChild(this.Draco_R_LHorn_3);
        this.Draco_CTorso_Joint.addChild(this.Draco_CTorso_1);
        this.Draco_LTorso_2.addChild(this.Draco_LFace);
        this.Draco_R_LHorn_1.addChild(this.Draco_R_LHorn_2);
        this.Draco_F_R_Wing_3.addChild(this.Draco_F_R_Wing_4);
        this.Draco_RTorso_2.addChild(this.Draco_RFace);
        this.Draco_R_Right_Foot_1.addChild(this.Draco_R_Right_Foot_2);
        this.Draco_Body_2.addChild(this.Draco_Tail_1);
        this.Draco_F_L_Wing_1.addChild(this.Draco_F_L_Wing_2);
        this.Draco_F_Right_Foot_2.addChild(this.Draco_F_Right_RightClaw);
        this.Draco_F_R_Wing_2.addChild(this.Draco_F_R_Wing_3);
        this.Draco_CTorso_Joint.addChild(this.Draco_Groin);
        this.Draco_F_Left_Foot_1.addChild(this.Draco_F_Left_Foot_2);
        this.Draco_Tail_3.addChild(this.Draco_Tail_4);
        this.Draco_F_Left_Foot_2.addChild(this.Draco_F_Left_RearClaw);
        this.Draco_R_Right_Foot_2.addChild(this.Draco_R_Right_RightClaw);
        this.Draco_F_Left_Foot_2.addChild(this.Draco_F_Left_LeftClaw);
        this.Draco_R_Right_Foot_2.addChild(this.Draco_R_Right_RearClaw);
        this.Draco_F_Right_Foot_1.addChild(this.Draco_F_Right_Foot_2);
        this.Draco_L_RHorn_1.addChild(this.Draco_L_RHorn_2);
        this.Draco_Tail_4.addChild(this.Draco_Tail_5);
        this.Draco_F_Left_Thigh_2.addChild(this.Draco_F_Left_Foot_1);
        this.Draco_CTorso_3.addChild(this.Draco_F_L_Wing_1);
        this.Draco_Tail_TopClaw_1.addChild(this.Draco_Tail_TopClaw_2);
        this.Draco_Body_2.addChild(this.Draco_R_Right_Thigh_1);
        this.Draco_Body_2.addChild(this.Draco_R_Left_Thigh_1);
        this.Draco_Tail_1.addChild(this.Draco_Tail_2);
        this.Draco_Tail_RightClaw_1.addChild(this.Draco_Tail_RightClaw_2);
        this.Draco_F_L_Wing_2.addChild(this.Draco_F_L_Wing_3);
        this.Draco_Groin.addChild(this.Draco_F_Left_Thigh_1);
        spiral_draco_parts = new AdvancedModelRenderer[]{Draco_CTorso_Joint,Draco_CTorso_1,Draco_Groin,Draco_LTorso_1,Draco_RTorso_1,Draco_CTorso_2,Draco_CTorso_3,Draco_CFace,Draco_CNeck,Draco_F_R_Wing_1,Draco_F_L_Wing_1,Draco_CHorn_1,Draco_CHorn_2,Draco_CHorn_3,Draco_F_R_Wing_2,Draco_F_R_Wing_3,Draco_F_R_Wing_4,Draco_F_L_Wing_2,Draco_F_L_Wing_3,Draco_F_L_Wing_4,Draco_Body,Draco_F_Right_Thigh_1,Draco_F_Left_Thigh_1,Draco_Body_1,Draco_Body_2,Draco_R_Right_Thigh_1,Draco_R_Left_Thigh_1,Draco_Tail_1,Draco_R_Right_Thigh_2,Draco_R_Right_Foot_1,Draco_R_Right_Foot_2,Draco_R_Right_RearClaw,Draco_R_Right_RightClaw,Draco_R_Right_LeftClaw,Draco_R_Left_Thigh_2,Draco_R_Left_Foot_1,Draco_R_Left_Foot_2,Draco_R_Left_RearClaw,Draco_R_Left_RightClaw,Draco_R_Left_LeftClaw,Draco_Tail_2,Draco_Tail_3,Draco_Tail_4,Draco_Tail_5,Draco_Tail_BottonClaw_1,Draco_Tail_TopClaw_1,Draco_Tail_RightClaw_1,Draco_Tail_LeftClaw_1,Draco_Tail_BottonClaw_2,Draco_Tail_TopClaw_2,Draco_Tail_RightClaw_2,Draco_Tail_LeftClaw_2,Draco_F_Right_Thigh_2,Draco_F_Right_Foot_1,Draco_F_Right_Foot_2,Draco_F_Right_RearClaw,Draco_F_Right_RightClaw,Draco_F_Right_LeftClaw,Draco_F_Left_Thigh_2,Draco_F_Left_Foot_1,Draco_F_Left_Foot_2,Draco_F_Left_RearClaw,Draco_F_Left_RightClaw,Draco_F_Left_LeftClaw,Draco_LTorso_2,Draco_LNeck,Draco_LFace,Draco_LHead,Draco_L_RHorn_1,Draco_L_LHorn_1,Draco_L_RHorn_2,Draco_L_RHorn_3,Draco_L_LHorn_2,Draco_L_LHorn_3,Draco_RTorso_2,Draco_RNeck,Draco_RFace,Draco_RHead,Draco_R_RHorn_1,Draco_R_LHorn_1,Draco_R_RHorn_2,Draco_R_RHorn_3,Draco_R_LHorn_2,Draco_R_LHorn_3};
        updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animate(f, f1, f2, f3, f4, f5, entity);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.Draco_CTorso_Joint.offsetX, this.Draco_CTorso_Joint.offsetY, this.Draco_CTorso_Joint.offsetZ);
        GlStateManager.translate(this.Draco_CTorso_Joint.rotationPointX * f5, this.Draco_CTorso_Joint.rotationPointY * f5, this.Draco_CTorso_Joint.rotationPointZ * f5);
        GlStateManager.scale(5.0D, 5.0D, 5.0D);
        GlStateManager.translate(-this.Draco_CTorso_Joint.offsetX, -this.Draco_CTorso_Joint.offsetY, -this.Draco_CTorso_Joint.offsetZ);
        GlStateManager.translate(-this.Draco_CTorso_Joint.rotationPointX * f5, -this.Draco_CTorso_Joint.rotationPointY * f5, -this.Draco_CTorso_Joint.rotationPointZ * f5);
        this.Draco_CTorso_Joint.render(f5);
        GlStateManager.popMatrix();
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
        animator.update((EntitySpiral_Draco)entity);
        EntitySpiral_Draco entity_Draco = (EntitySpiral_Draco)entity;
        if (entity_Draco.getAnimation() == EntitySpiral_Draco.AGGRO_ANIMATION)
        {
            draco_chead_state = Draco_CHeadState.ROARING;
        }
        setRotationAngles(f, f1, f2, f3, f4, f5, entity_Draco);
        /*Makes the draco roar*/
        if (entity_Draco.getAnimation() == EntitySpiral_Draco.AGGRO_ANIMATION)
        {
            animator.setAnimation(EntitySpiral_Draco.AGGRO_ANIMATION);
            animator.startKeyframe(0);
            animator.rotate(Draco_CTorso_1, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(20);
            animator.rotate(Draco_CTorso_1, -0.4F, 0.0F, 0.0F);
            animator.rotate(Draco_CTorso_2, -0.6F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(20);
            animator.resetKeyframe(20);
            draco_chead_state = Draco_CHeadState.IDLING;
        }
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, EntitySpiral_Draco entityIn)
    {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        resetToDefaultPose();
        float walkspeed = 1.5F;
        float walkheight = 1.5F;
        float walkdegree = 1;

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

        /*This handles which idle animation the draco should be in. If limbSwingAmount is 0, that means it is not walking around.*/
        if (isStill == false)
        {
            bob(Draco_CTorso_Joint, 0.5F * walkspeed, 1 * walkheight, false, limbSwing, limbSwingAmount);
            bob(Draco_Groin, 0.5F * walkspeed, 1 * walkheight, false, limbSwing, limbSwingAmount);
            bob(Draco_Body_2, 0.25F * walkspeed, 1 * walkheight, true, limbSwing, limbSwingAmount);
            walk(Draco_F_Right_Thigh_1, 0.5F * walkspeed, 0.5F * walkdegree, false, 0, 0.5F, limbSwing, limbSwingAmount);
            walk(Draco_F_Right_Thigh_2, 0.5F * walkspeed, 0.5F * walkdegree, true, 1.5F, 0.3F, limbSwing, limbSwingAmount);
            walk(Draco_F_Right_Foot_1, 0.5F * walkspeed, 0.5F * walkdegree, false, 0, 0.5F, limbSwing, limbSwingAmount);
            walk(Draco_F_Right_Foot_2, 0.5F * walkspeed, 0.5F * walkdegree, false, -1.5F, 0.5F, limbSwing, limbSwingAmount);

            walk(Draco_F_Left_Thigh_1, 0.5F * walkspeed, 0.5F * walkdegree, true, 0, 0.5F, limbSwing, limbSwingAmount);
            walk(Draco_F_Left_Thigh_2, 0.5F * walkspeed, 0.5F * walkdegree, false, 1.5F, 0.3F, limbSwing, limbSwingAmount);
            walk(Draco_F_Left_Foot_1, 0.5F * walkspeed, 0.5F * walkdegree, true, 0, 0.5F, limbSwing, limbSwingAmount);
            walk(Draco_F_Left_Foot_2, 0.5F * walkspeed, 0.5F * walkdegree, true, -1.5F, 0.5F, limbSwing, limbSwingAmount);

            walk(Draco_R_Right_Thigh_1, 0.5F * walkspeed, 0.5F * walkdegree, true, 0, 0.5F, limbSwing, limbSwingAmount);
            walk(Draco_R_Right_Thigh_2, 0.5F * walkspeed, 0.5F * walkdegree, false, 1.5F, 0.3F, limbSwing, limbSwingAmount);
            walk(Draco_R_Right_Foot_1, 0.5F * walkspeed, 0.5F * walkdegree, true, 0, 0.5F, limbSwing, limbSwingAmount);
            walk(Draco_R_Right_Foot_2, 0.5F * walkspeed, 0.5F * walkdegree, true, -1.5F, 0.5F, limbSwing, limbSwingAmount);

            walk(Draco_R_Left_Thigh_1, 0.5F * walkspeed, 0.5F * walkdegree, false, 0, 0.5F, limbSwing, limbSwingAmount);
            walk(Draco_R_Left_Thigh_2, 0.5F * walkspeed, 0.5F * walkdegree, true, 1.5F, 0.3F, limbSwing, limbSwingAmount);
            walk(Draco_R_Left_Foot_1, 0.5F * walkspeed, 0.5F * walkdegree, false, 0, 0.5F, limbSwing, limbSwingAmount);
            walk(Draco_R_Left_Foot_2, 0.5F * walkspeed, 0.5F * walkdegree, false, 0, 0.5F, limbSwing, limbSwingAmount);

            walk(Draco_CTorso_1, 0.5F * walkspeed, 0.5F * walkdegree, false, 0, 0.5F, limbSwing, limbSwingAmount);
            walk(Draco_CTorso_2, 0.5F * walkspeed, 0.5F * walkdegree, true, 0, 0.5F, limbSwing, limbSwingAmount);
            walk(Draco_LTorso_1, 0.25F * walkspeed, 0.25F * walkdegree, false, 0, 0.5F, limbSwing, limbSwingAmount);
            walk(Draco_LTorso_2, 0.25F * walkspeed, 0.25F * walkdegree, false, 0, 0.5F, limbSwing, limbSwingAmount);
            walk(Draco_RTorso_1, 0.25F * walkspeed, 0.25F * walkdegree, false, 1.5F, 0.5F, limbSwing, limbSwingAmount);
            walk(Draco_RTorso_2, 0.25F * walkspeed, 0.25F * walkdegree, false, 1.5F, 0.5F, limbSwing, limbSwingAmount);

            walk(Draco_Tail_1, 0.5F * walkspeed, 0.25F * walkdegree, true, 0, 0.5F, limbSwing, limbSwingAmount);
            walk(Draco_Tail_2, 0.5F * walkspeed, 0.25F * walkdegree, false, 1.5F, 0.5F, limbSwing, limbSwingAmount);
            walk(Draco_Tail_3, 0.5F * walkspeed, 0.25F * walkdegree, true, 1.5F, 0.5F, limbSwing, limbSwingAmount);
            walk(Draco_Tail_4, 0.5F * walkspeed, 0.25F * walkdegree, false, 1.5F, 0.5F, limbSwing, limbSwingAmount);
        }
        else
        {
            limbSwing = entityIn.ticksExisted;
            limbSwingAmount = 0.5f;
            bob(Draco_Groin, 0.25F * bobspeed, 1F * bobheight, false, limbSwing, limbSwingAmount);

            bob(Draco_F_Right_Thigh_1, 0.25F * bobspeed, 0.5F * -bobheight, false, limbSwing, limbSwingAmount);
            walk(Draco_F_Right_Thigh_2, 0.25F * bobspeed, 0.25F * bobdegree, true, 1.5F, 0.5F, limbSwing, limbSwingAmount * 0.5F);
            walk(Draco_F_Right_Foot_1, 0.25F * bobspeed, 0.25F * bobdegree, false, 1.5F, 1F, limbSwing, limbSwingAmount * 0.5F);
            walk(Draco_F_Right_Foot_2, 0.25F * bobspeed, 0.25F * bobdegree, true, -1.5F, 1F, limbSwing, limbSwingAmount * 0.25F);
            bob(Draco_F_Right_Foot_2, 0.25F * bobspeed, 0.125F * -bobheight, false, limbSwing, limbSwingAmount);

            bob(Draco_F_Left_Thigh_1, 0.25F * bobspeed, 0.5F * -bobheight, false, limbSwing, limbSwingAmount);
            walk(Draco_F_Left_Thigh_2, 0.25F * bobspeed, 0.25F * bobdegree, true, 1.5F, 0.5F, limbSwing, limbSwingAmount * 0.5F);
            walk(Draco_F_Left_Foot_1, 0.25F * bobspeed, 0.25F * bobdegree, false, 1.5F, 1F, limbSwing, limbSwingAmount * 0.5F);
            walk(Draco_F_Left_Foot_2, 0.25F * bobspeed, 0.25F * bobdegree, true, -1.5F, 1F, limbSwing, limbSwingAmount * 0.25F);
            bob(Draco_F_Left_Foot_2, 0.25F * bobspeed, 0.125F * -bobheight, false, limbSwing, limbSwingAmount);

            bob(Draco_R_Right_Thigh_1, 0.25F * bobspeed, 0.5F * -bobheight, false, limbSwing, limbSwingAmount);
            walk(Draco_R_Right_Thigh_2, 0.25F * bobspeed, 0.25F * bobdegree, true, 1.5F, 0.5F, limbSwing, limbSwingAmount * 0.5F);
            walk(Draco_R_Right_Foot_1, 0.25F * bobspeed, 0.25F * bobdegree, false, 1.5F, 1F, limbSwing, limbSwingAmount * 0.5F);
            walk(Draco_R_Right_Foot_2, 0.25F * bobspeed, 0.25F * bobdegree, true, -1F, 1F, limbSwing, limbSwingAmount * 0.25F);
            bob(Draco_R_Right_Foot_2, 0.25F * bobspeed, 0.125F * -bobheight, false, limbSwing, limbSwingAmount);

            bob(Draco_R_Left_Thigh_1, 0.25F * bobspeed, 0.5F * -bobheight, false, limbSwing, limbSwingAmount);
            walk(Draco_R_Left_Thigh_2, 0.25F * bobspeed, 0.25F * bobdegree, true, 1.5F, 0.5F, limbSwing, limbSwingAmount * 0.5F);
            walk(Draco_R_Left_Foot_1, 0.25F * bobspeed, 0.25F * bobdegree, false, 1.5F, 1F, limbSwing, limbSwingAmount * 0.5F);
            walk(Draco_R_Left_Foot_2, 0.25F * bobspeed, 0.25F * bobdegree, true, -1F, 1F, limbSwing, limbSwingAmount * 0.25F);
            bob(Draco_R_Left_Foot_2, 0.25F * bobspeed, 0.125F * -bobheight, false, limbSwing, limbSwingAmount);

            bob(Draco_CTorso_1, 0.25F * bobspeed, 1F * bobheight, false, limbSwing, limbSwingAmount);
            bob(Draco_LTorso_1, 0.25F * bobspeed, 1F * bobheight, false, limbSwing, limbSwingAmount);
            bob(Draco_RTorso_1, 0.25F * bobspeed, 1F * bobheight, false, limbSwing, limbSwingAmount);

            if (draco_chead_state == Draco_CHeadState.IDLING)
            {
                walk(Draco_CTorso_1, 0.25F * bobspeed, 0.125F * bobdegree, false, -1F, 1F, limbSwing, limbSwingAmount * 0.25F);
                swing(Draco_CTorso_1, 0.25F * bobspeed, 1F * bobdegree, false, 0F, 0F, limbSwing, limbSwingAmount * 0.125F);
            }
            if (draco_lhead_state == Draco_LHeadState.IDLING)
            {
                walk(Draco_LTorso_1, 0.125F * bobspeed, 0.25F * bobdegree, false, 0F, 1F, limbSwing, limbSwingAmount * 0.25F);
                swing(Draco_LTorso_1, 0.125F * bobspeed, 0.5F * bobdegree, false, 0F, 0.5F, limbSwing, limbSwingAmount * 1F);
                swing(Draco_LTorso_2, 0.25F * bobspeed, 0.5F * bobdegree, false, 0F, 0.5F, limbSwing, limbSwingAmount * 0.5F);
            }
            if (draco_rhead_state == Draco_RHeadState.IDLING)
            {
                walk(Draco_RTorso_1, 0.125F * bobspeed, 0.25F * bobdegree, false, 0.75F, 1F, limbSwing, limbSwingAmount * 0.25F);
                swing(Draco_RTorso_1, 0.125F * bobspeed, 0.5F * bobdegree, true, 0.75F, 0.5F, limbSwing, limbSwingAmount * 1F);
                swing(Draco_RTorso_2, 0.25F * bobspeed, 0.5F * bobdegree, true, 0.75F, 0.5F, limbSwing, limbSwingAmount * 0.5F);
            }
            if (draco_tail_state == Draco_TailState.IDLING)
            {
                AdvancedModelRenderer[] spiral_draco_tail = new AdvancedModelRenderer[]{Draco_Tail_1,Draco_Tail_2,Draco_Tail_3,Draco_Tail_5};
                chainWave(spiral_draco_tail, 0.25F * bobspeed, 1F * bobdegree, 0F, limbSwing, limbSwingAmount * 0.125F);
            }
        }
    }
}
