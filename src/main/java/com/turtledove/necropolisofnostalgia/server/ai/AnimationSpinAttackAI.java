package com.turtledove.necropolisofnostalgia.server.ai;

import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;

import java.util.List;

public class AnimationSpinAttackAI  <T extends NecropolisEntity & IAnimatedEntity> extends AnimationAI<T>
{
    public AnimationSpinAttackAI(T entity, Animation animation)
    {
        super(entity, animation, true);
        this.setMutexBits(8);
    }

    @Override
    public void startExecuting()
    {
        super.startExecuting();
    }
    @Override
    public void updateTask()
    {
        if (entity.getAnimationTick() < 2)
        {
            entity.motionX = 0;
            entity.motionZ = 0;
        }
        if (this.entity.getAnimationTick() == 25 || this.entity.getAnimationTick() == 32)
        {
            entity.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP,1.0F, 0.7F);
        }
        if (this.entity.getAnimationTick() == 37)
        {
            entity.playSound(SoundEvents.ENTITY_SKELETON_AMBIENT,1.5F, 0.5F);
        }
        if (this.entity.getAnimationTick() == 25 || this.entity.getAnimationTick() == 35)
        {
            List<Entity> swipeEnemies = this.entity.world.getEntitiesWithinAABBExcludingEntity(entity,  entity.getEntityBoundingBox().expand(3.0,1.0,3.0).offset(-1.5D,0D,-1.5D));
            if (!swipeEnemies.isEmpty())
            {
                for (Entity targ : swipeEnemies)
                {
                    if (targ instanceof EntityPlayer)
                        targ.attackEntityFrom(DamageSource.causeMobDamage(this.entity),15.0F);
                }
            }
        }
    }
}
