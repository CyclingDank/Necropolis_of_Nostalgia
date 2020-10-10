package com.turtledove.necropolisofnostalgia.server.ai;
import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;

public class AnimationDeaggroAI<T extends NecropolisEntity & IAnimatedEntity> extends AnimationAI<T>
{
    public AnimationDeaggroAI(T entity, Animation animation)
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