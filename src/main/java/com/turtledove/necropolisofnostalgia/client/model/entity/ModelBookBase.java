package com.turtledove.necropolisofnostalgia.client.model.entity;

import com.turtledove.necropolisofnostalgia.server.entity.items.EntityBook;
import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelBook - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelBookBase  extends AdvancedModelBase
{
    public AdvancedModelRenderer book_spine;
    public AdvancedModelRenderer book_core_right;
    public AdvancedModelRenderer book_core_left;
    public AdvancedModelRenderer book_page_right;
    public AdvancedModelRenderer book_page_left;
    public AdvancedModelRenderer book_cover_right;
    public AdvancedModelRenderer book_cover_left;

    public AdvancedModelRenderer[] book_parts;
    private ModelAnimator animator;

    public ModelBookBase() {

        animator = ModelAnimator.create();

        this.textureWidth = 64;
        this.textureHeight = 32;
        this.book_core_right = new AdvancedModelRenderer(this, 0, 10);
        this.book_core_right.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.book_core_right.addBox(0.0F, -4.0F, 0.0F, 5, 8, 1, 0.0F);
        this.setRotateAngle(book_core_right, 0.0F, -1.5707963267948966F, 0.0F);
        this.book_cover_left = new AdvancedModelRenderer(this, 16, 0);
        this.book_cover_left.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.book_cover_left.addBox(0.0F, -5.0F, 0.0F, 6, 10, 0, 0.0F);
        this.book_cover_right = new AdvancedModelRenderer(this, 0, 0);
        this.book_cover_right.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.book_cover_right.addBox(-6.0F, -5.0F, 0.0F, 6, 10, 0, 0.0F);
        this.setRotateAngle(book_cover_right, 0.0F, 3.141592653589793F, 0.0F);
        this.book_spine = new AdvancedModelRenderer(this, 12, 0);
        this.book_spine.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.book_spine.addBox(-1.0F, -5.0F, 0.0F, 2, 10, 0, 0.0F);
        this.setRotateAngle(book_spine, 1.5707963267948966F, 3.141592653589793F, 0.0F);
        this.book_core_left = new AdvancedModelRenderer(this, 12, 10);
        this.book_core_left.setRotationPoint(-1.0F, 0.0F, 0.0F);
        this.book_core_left.addBox(0.0F, -4.0F, -1.0F, 5, 8, 1, 0.0F);
        this.setRotateAngle(book_core_left, 0.0F, -1.5707963267948966F, 0.0F);
        this.book_page_left = new AdvancedModelRenderer(this, 24, 10);
        this.book_page_left.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.book_page_left.addBox(0.0F, -4.0F, 0.0F, 5, 8, 0, 0.0F);
        this.setRotateAngle(book_page_left, 0.0F, -1.5707963267948966F, 0.0F);
        this.book_page_right = new AdvancedModelRenderer(this, 24, 10);
        this.book_page_right.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.book_page_right.addBox(0.0F, -4.0F, 0.0F, 5, 8, 0, 0.0F);
        this.setRotateAngle(book_page_right, 0.0F, -1.5707963267948966F, 0.0F);
        this.book_spine.addChild(this.book_core_right);
        this.book_core_left.addChild(this.book_cover_left);
        this.book_core_right.addChild(this.book_cover_right);
        this.book_spine.addChild(this.book_core_left);
        this.book_spine.addChild(this.book_page_left);
        this.book_spine.addChild(this.book_page_right);

        book_parts = new AdvancedModelRenderer[] { book_spine,
         book_core_right,
         book_core_left,
         book_page_right,
         book_page_left,
         book_cover_right,
         book_cover_left};
        updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        animate( f,  f1,  f2,  f3,  f4,  f5,  entity);
        this.book_spine.render(f5);
        resetToDefaultPose();
    }
    public void animate(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        EntityBook tBook = (EntityBook)entity;
        animator.update(tBook);
        if (tBook.getAnimation() == EntityBook.OPEN_ANIMATION)
        {
            animator.setAnimation(EntityBook.OPEN_ANIMATION);
            animator.startKeyframe(0);
            animator.rotate(this.book_spine, 0F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(20);
            animator.rotate(this.book_core_left,0.0F,-1.0472F,0.0F);
            animator.rotate(this.book_core_right,0.0F, 1.0472F,0.0F);

            animator.rotate(this.book_cover_left,0.0F,-0.488692F,0.0F);
            animator.rotate(this.book_cover_right,0.0F, 0.488692F,0.0F);

            animator.rotate(this.book_page_left,0.0F,-0.488692F,0.0F);
            animator.rotate(this.book_page_right,0.0F, 0.488692F,0.0F);
            animator.endKeyframe();
            animator.setStaticKeyframe(100);
        }
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(AdvancedModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
