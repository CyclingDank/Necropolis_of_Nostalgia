package com.turtledove.necropolisofnostalgia.server.ai;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;

import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;

public class AnimationAI<T extends NecropolisEntity & IAnimatedEntity> extends net.ilexiconn.llibrary.server.animation.AnimationAI<T>
{
    protected Animation animation;

    public AnimationAI(T entity, Animation animation) {
        super(entity);
        this.animation = animation;
    }

    public AnimationAI(T entity, Animation animation, boolean interruptsAI) {
        super(entity);
        this.animation = animation;
        if (!interruptsAI)
        {
            setMutexBits(8);
        }
    }

    public boolean shouldExecute()
    {
        if (this.isAutomatic()) {
            return this.entity.getAnimation() == this.getAnimation();
        }
        return this.shouldAnimate();
    }

    @Override
    public Animation getAnimation() {
        return animation;
    }

    @Override
    public boolean isAutomatic() {
        return true;
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
        entity.currentAnim = this;
    }

    @Override
    public void resetTask() {
        super.resetTask();
        entity.currentAnim = null;
    }
}