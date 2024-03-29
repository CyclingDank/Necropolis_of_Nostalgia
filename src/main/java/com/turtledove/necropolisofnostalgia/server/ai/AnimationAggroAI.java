package com.turtledove.necropolisofnostalgia.server.ai;
import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;

public class AnimationAggroAI<T extends NecropolisEntity & IAnimatedEntity> extends AnimationAI<T>
{
    public AnimationAggroAI(T entity, Animation animation)
    {
        super(entity, animation);
    }

    @Override
    public void resetTask()
    {
        super.resetTask();
        entity.active = true;
    }
}