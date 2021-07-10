package com.turtledove.necropolisofnostalgia.ai;

import com.turtledove.necropolisofnostalgia.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.entity.enemies.EntityNecropolisSpider;
import com.turtledove.necropolisofnostalgia.sound.NecropolisSounds;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;

public class AnimationSpiderFrontJab  <T extends NecropolisEntity & IAnimatedEntity> extends AnimationAI<T> {
    public AnimationSpiderFrontJab(T entity, Animation animation)
    {
        super(entity, animation, true);
        this.setMutexBits(8);
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
    }

    @Override
    public void updateTask() {
        if (this.entity.targetofmyrevenge == null) {
            EntityNecropolisSpider spoderman = new EntityNecropolisSpider(this.entity.world);
            spoderman.setPosition(this.entity.posX, this.entity.posY, this.entity.posZ);
            this.entity.world.spawnEntity(spoderman);
            this.entity.setDead();
            return;
        }
        this.entity.getNavigator().clearPath();
        this.entity.motionX = 0;
        this.entity.motionZ = 0;
        if (entity.getAnimationTick() == 2)
        {
            this.entity.playSound(NecropolisSounds.SPIDER_CRY, 1.0f, 1.0f);
        }
    }

    @Override
    public void resetTask()
    {
        super.resetTask();
        entity.active = false;
        ((EntityNecropolisSpider)entity).isAnimationEnded = true;
    }
}