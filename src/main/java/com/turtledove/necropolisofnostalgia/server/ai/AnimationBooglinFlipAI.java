package com.turtledove.necropolisofnostalgia.server.ai;

import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityBooglin;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.Vec3d;

public class AnimationBooglinFlipAI  <T extends NecropolisEntity & IAnimatedEntity> extends AnimationAI<T> {
    public AnimationBooglinFlipAI(T entity, Animation animation) {
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
            EntityBooglin sorceress = new EntityBooglin(this.entity.world);
            sorceress.setPosition(this.entity.posX, this.entity.posY, this.entity.posZ);
            this.entity.world.spawnEntity(sorceress);
            this.entity.setDead();
            return;
        }
        if (entity.getAnimationTick() == 8)
        {
            Vec3d vec3d = this.entity.getForward();
            this.entity.motionX = -vec3d.x / 2.0D;
            this.entity.motionZ = -vec3d.z / 2.0D;
            this.entity.motionY = 0.3D;
            this.entity.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, 0.7F, 0.3F);

        }
    }

    @Override
    public void resetTask() {
        super.resetTask();
        entity.active = false;
    }
}
