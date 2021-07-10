package com.turtledove.necropolisofnostalgia.ai;

import com.turtledove.necropolisofnostalgia.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.entity.enemies.EntityAxeBeak;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;

public class AnimationABEatAI  <T extends NecropolisEntity & IAnimatedEntity> extends AnimationAI<T> {
    public AnimationABEatAI(T entity, Animation animation)
    {
        super(entity, animation, true);
        this.setMutexBits(8);
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
    }

    @Override
    public void updateTask()
    {
        if (this.entity.getAnimationTick() == 7 || this.entity.getAnimationTick() == 15)
        {
            this.entity.playSound(SoundEvents.ENTITY_PARROT_EAT, 1.0F, 0.75F);
        }
        else if (this.entity.getAnimationTick() > 15 && this.entity.getAnimationTick() < 80)
        {
            if (this.entity.getAnimationTick() % 2 == 0)
            {
                this.entity.playSound(SoundEvents.BLOCK_NOTE_SNARE, 0.7F, 0.4F);
            }
        }
        else if (this.entity.getAnimationTick() == 99)
        {
            if (Math.random() < 0.80)
                ((EntityAxeBeak)entity).setAggroLevel(true);
            else
            {
                this.entity.playSound(SoundEvents.BLOCK_NOTE_CHIME, 1.0F, 1.5F);
                this.entity.dropItem(Items.WHEAT_SEEDS, 2);
            }
        }
    }
    @Override
    public void resetTask()
    {
        super.resetTask();
        entity.active = false;
    }
}