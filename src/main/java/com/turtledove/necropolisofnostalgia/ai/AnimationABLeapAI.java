package com.turtledove.necropolisofnostalgia.ai;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.entity.enemies.EntityAxeBeak;
import com.turtledove.necropolisofnostalgia.sound.NecropolisSounds;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;

import java.util.List;

public class AnimationABLeapAI <T extends NecropolisEntity & IAnimatedEntity> extends AnimationAI<T> {
    public AnimationABLeapAI(T entity, Animation animation)
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
        if (this.entity.targetofmyrevenge == null)
        {
            EntityAxeBeak birb = new EntityAxeBeak(this.entity.world);
            birb.setPosition(this.entity.posX,this.entity.posY,this.entity.posZ);
            this.entity.world.spawnEntity(birb);
            this.entity.setDead();
            return;
        }
        if (this.entity.getAnimationTick() < 19)
        {
            if (this.entity.getAnimationTick() %9 == 0)
            {
                this.entity.motionY = 0.35F;
                this.entity.playSound(SoundEvents.ENTITY_PARROT_FLY, 1.0f, 1.0f);
            }

        }
        else if (this.entity.getAnimationTick() == 20)
        {
            double slopeX = (this.entity.targetofmyrevenge.posX - this.entity.posX)/4.0D;
            double slopeZ = (this.entity.targetofmyrevenge.posZ - this.entity.posZ)/4.0D;
            double dist = this.entity.getDistance(this.entity.targetofmyrevenge);

            this.entity.playSound(NecropolisSounds.AB_CRY, 1.0f, 1.0f);

            if (dist > 5)
            {
                double numerator = Math.sqrt(slopeX * slopeX + slopeZ * slopeZ);
                this.entity.motionX = slopeX * 0.75F / numerator;
                this.entity.motionZ = slopeZ * 0.75F  / numerator;
                this.entity.motionY-= 0.2F;
            }
            else
            {
                this.entity.motionX = slopeX * 0.75F;
                this.entity.motionZ = slopeZ * 0.75F;
            }
        }

        List<Entity> swipeEnemies = this.entity.world.getEntitiesWithinAABBExcludingEntity(this.entity, this.entity.getEntityBoundingBox());

        if (this.entity.getAnimationTick() >= 20)
        {
            if (!swipeEnemies.isEmpty()) {
                for (Entity targ : swipeEnemies)
                {
                    if (targ instanceof EntityPlayer)
                    {
                        targ.attackEntityFrom(DamageSource.causeMobDamage(this.entity), (float) Necropolis_of_Nostalgia.CONFIG.axebeakDamage);
                    }
                }
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