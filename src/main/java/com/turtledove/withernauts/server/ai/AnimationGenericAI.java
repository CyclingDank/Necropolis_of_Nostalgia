package com.turtledove.withernauts.server.ai;

import com.turtledove.withernauts.server.entity.NecropolisEntity;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;

public class AnimationGenericAI <T extends NecropolisEntity & IAnimatedEntity> extends AnimationAI<T>
{
    public AnimationGenericAI(T entity, Animation animation)
    {
        super(entity, animation);
    }

    @Override
    public void resetTask()
    {
        super.resetTask();
        entity.active = false;
    }
}