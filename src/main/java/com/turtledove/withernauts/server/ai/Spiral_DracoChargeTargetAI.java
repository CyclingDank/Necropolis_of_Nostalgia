package com.turtledove.withernauts.server.ai;

import com.turtledove.withernauts.server.entity.NecropolisEntity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;


public class Spiral_DracoChargeTargetAI<T extends NecropolisEntity> extends EntityAIBase
{
    protected T entity;
    protected Class <? extends Entity > targetEntity;
    protected Entity closestEntity;

    public boolean isCharging;
    protected float maxDistanceForPlayer;
    protected final double speed;
    protected double x;
    protected double y;
    protected double z;
    protected boolean moving;

    protected int turn_tick;

    public Spiral_DracoChargeTargetAI(T entity, Class<? extends Entity> targetClass, float maxDistance, float speed)
    {
        this.isCharging = false;
        this.entity = entity;
        this.targetEntity = targetClass;
        this.maxDistanceForPlayer = maxDistance;
        this.speed = speed;
        turn_tick = 0;
        this.moving = false;
        this.setMutexBits(8);
    }

    @Override
    public boolean shouldExecute()
    {
        if (this.targetEntity == EntityPlayer.class && entity.active == true && this.entity.hitbyarrow)
        {
            this.closestEntity = entity.targetofmyrevenge;
            if (this.closestEntity != null)
            {
                x = this.closestEntity.posX;
                y = this.closestEntity.posY;
                z = this.closestEntity.posZ;
                entity.hitbyarrow = false;
            }
        }
        return this.closestEntity != null;
    }
    public boolean shouldContinueExecuting()
    {
        //if (moving == true && this.entity.getNavigator().noPath() == false)
        //if ((int)this.entity.posX == (int)this.x && (int)this.entity.posZ == (int)this.z)
        if (moving == true && this.entity.getNavigator().noPath() == false)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public void resetTask()
    {
        this.closestEntity = null;
    }
    @Override
    public void updateTask()
    {

        /*double d0 = x - this.entity.posX;
        double d1 = z - this.entity.posZ;
        float f = MathHelper.sqrt(d0 * d0 + d1 * d1);
        this.entity.motionX += d0 / (double) f * speed * 0.800000011920929D + this.entity.motionX * 0.20000000298023224D;
        this.entity.motionZ += d1 / (double) f * speed * 0.800000011920929D + this.entity.motionZ * 0.20000000298023224D;
        this.entity.getLookHelper().setLookPositionWithEntity(closestEntity, 30.0F, 30.0F);*/
        if (turn_tick > 30)
        {
            entity.getNavigator().tryMoveToEntityLiving(closestEntity, 1.0);
            moving = true;
            turn_tick = 0;
        }
        else
        {
            this.entity.getLookHelper().setLookPositionWithEntity(closestEntity, 30.0F, 30.0F);
        }
        turn_tick++;
    }
}
