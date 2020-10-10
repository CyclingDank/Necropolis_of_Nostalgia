package com.turtledove.necropolisofnostalgia.server.ai;

import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityPhoton;
import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityCultSorceress;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class AnimationFirstAidCast<T extends NecropolisEntity & IAnimatedEntity> extends AnimationAI<T> {
    public AnimationFirstAidCast(T entity, Animation animation) {
        super(entity, animation, true);
        this.setMutexBits(8);
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
    }

    @Override
    public void updateTask() {
        this.entity.motionX = 0;
        this.entity.motionZ = 0;
        if (this.entity.targetofmyrevenge == null)
        {
            EntityCultSorceress birb = new EntityCultSorceress(this.entity.world);
            birb.setPosition(this.entity.posX, this.entity.posY, this.entity.posZ);
            this.entity.world.spawnEntity(birb);
            birb.setHealth(this.entity.getHealth());
            this.entity.setDead();
            return;
        }
        if (this.entity.getAnimationTick() == 0)
        {
            this.entity.playSound(NecropolisSounds.CASTING_80, 1.0f, 1.0f);
        }
        else if (this.entity.getAnimationTick() == 80)
        {
            this.entity.playSound(NecropolisSounds.HEAL, 1.0f, 1.0f);
            List<Entity> potentialAllies = this.entity.world.getEntitiesWithinAABBExcludingEntity(this.entity,  this.entity.getEntityBoundingBox().grow(20.0D).offset(-10.0, 0.0d, -10.0D));
            if (!potentialAllies.isEmpty())
            {
                for (Entity ally : potentialAllies)
                {
                    if (ally instanceof NecropolisEntity)
                    {
                        if (((NecropolisEntity) ally).getHealth() < ((NecropolisEntity) ally).getMaxHealth() * 0.7)
                        {
                            ((NecropolisEntity) ally).heal(((NecropolisEntity) ally).getMaxHealth() - ((NecropolisEntity) ally).getHealth());
                            return;
                        }
                    }
                }
            }
            this.entity.heal(this.entity.getMaxHealth() - this.entity.getHealth());
        }

    }

    @Override
    public void resetTask()
    {
        super.resetTask();
        entity.active = false;
    }
}