package com.turtledove.necropolisofnostalgia.server.ai;

import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityAxeBeak;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityVampireBat;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;

import java.util.List;

public class AnimationVBDiveAI   <T extends NecropolisEntity & IAnimatedEntity> extends AnimationAI<T> {
    public AnimationVBDiveAI(T entity, Animation animation)
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
            EntityVampireBat birb = new EntityVampireBat(this.entity.world);
            birb.setPosition(this.entity.posX,this.entity.posY,this.entity.posZ);
            this.entity.world.spawnEntity(birb);
            this.entity.setDead();
            return;
        }
        if (this.entity.getAnimationTick() == 0)
        {
            this.entity.playSound(NecropolisSounds.BAT_CRY, 1.0f, 1.0f);
        }
        if (this.entity.getAnimationTick() == 10)
        {
            double slopeX = (this.entity.targetofmyrevenge.posX - this.entity.posX)/4.0D;
            double slopeZ = (this.entity.targetofmyrevenge.posZ - this.entity.posZ)/4.0D;
            double dist = this.entity.getDistance(this.entity.targetofmyrevenge);

            this.entity.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, 0.5f, 1.7f);

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
        if (this.entity.getAnimationTick() >= 10)
        {
            List<Entity> swipeEnemies = this.entity.world.getEntitiesWithinAABBExcludingEntity(this.entity,  this.entity.getEntityBoundingBox());
            if (!swipeEnemies.isEmpty()) {
                for (Entity targ : swipeEnemies)
                {
                    if (targ instanceof EntityPlayer)
                    {
                        //targ.attackEntityFrom(DamageSource.causeMobDamage(this.entity), 30);
                        targ.attackEntityFrom(DamageSource.causeMobDamage(this.entity), 1);

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
