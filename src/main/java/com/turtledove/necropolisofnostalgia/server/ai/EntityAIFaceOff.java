package com.turtledove.necropolisofnostalgia.server.ai;

import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityBedrockGolem;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityFugu;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityNecropolisSkeleton;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;

import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.Path;

/*AI to set the entity to follow the player, while looking at them. */
public class EntityAIFaceOff extends EntityAIBase
{
    protected final NecropolisEntity entity;

    double speed;   //speed of the attacking entity
    double stopDistance;    //the max distance before the entity should stop, from the target to this entity

    protected boolean outofRange;

    /** The PathEntity of our entity. */
    Path path;

    public EntityAIFaceOff(NecropolisEntity entityIn, double speedIn, double stopDistance)
    {
        this.entity = entityIn;
        this.speed = speedIn;
        this.stopDistance = stopDistance;
        this.outofRange = true;
        this.setMutexBits(7);
    }
    public boolean shouldExecute()
    {
        if (entity.targetofmyrevenge != null)
        {
            if (!this.entity.canEntityBeSeen(this.entity.targetofmyrevenge))
                return false;
            this.path = this.entity.getNavigator().getPathToEntityLiving(entity.targetofmyrevenge);

            if (this.path != null)
            {
                this.outofRange = false;
                return true;
            }
        }
        return false;
    }
    public void startExecuting()
    {
        this.entity.getNavigator().setPath(this.path, this.speed);
    }

    public void updateTask()
    {
        Entity entitybase = this.entity.targetofmyrevenge;
        double dist = this.entity.getDistance(entitybase);
        if (this.entity.getAnimation() != EntityNecropolisSkeleton.SWING_ANIMATION && this.entity.getAnimation() != EntityBedrockGolem.GROUND_ANIMATION && this.entity.getAnimation() != EntityBedrockGolem.STOMP_ANIMATION
        && this.entity.getAnimation() != EntityFugu.LEAP_ANIMATION && this.entity.getAnimation() != EntityFugu.LEAP_FLAIL_ANIMATION && this.entity.getAnimation() != EntityFugu.TAIL_ANIMATION)
        {
            if (dist > this.stopDistance)
            {

                this.entity.getLookHelper().setLookPositionWithEntity(entitybase,360.0F, 360.0F);
                this.path = this.entity.getNavigator().getPathToEntityLiving(entity.targetofmyrevenge);
                if (path == null)
                {
                    this.outofRange = true;
                }
                else
                    this.outofRange = false;
                this.entity.getNavigator().setPath(this.path, this.speed);
                this.entity.getNavigator().tryMoveToEntityLiving(entitybase, this.speed);
            }
            else
            {
                this.outofRange = false;

                //this.setPositionAndRotationDirect(caster.posX + caster.getLookVec().x * 0.5F,caster.posY + caster.getLookVec().y * 0.75F + 1.2F,caster.posZ + caster.getLookVec().z * 0.5F, caster.rotationYaw, caster.rotationPitch,2,true);
            }
        }
    }
    public void resetTask()
    {
        Entity entitybase = this.entity.targetofmyrevenge;
        if (this.entity.targetofmyrevenge instanceof EntityPlayer && (((EntityPlayer)entitybase).isSpectator() || ((EntityPlayer)entitybase).isCreative()))
        {
            this.entity.targetofmyrevenge = null;
            this.outofRange = true;
        }
        this.entity.getNavigator().clearPath();
    }
    public boolean shouldContinueExecuting()
    {
        if (entity.targetofmyrevenge == null)
            return false;
        if (!entity.targetofmyrevenge.isEntityAlive())
            return false;
        if (this.outofRange == true)
            return false;
        double dist = this.entity.getDistance(this.entity.targetofmyrevenge);
        if (dist > 20)
            return false;
        return true;
    }
}
