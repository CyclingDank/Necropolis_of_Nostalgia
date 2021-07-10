package com.turtledove.necropolisofnostalgia.ai;

import com.turtledove.necropolisofnostalgia.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.entity.enemies.EntityNecropolisSpider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.Path;

public class EntityAISpiderFaceOff  extends EntityAIBase
{
    protected final NecropolisEntity entity;

    double speed;   //speed of the attacking entity
    double stopDistance;    //the max distance before the entity should stop, from the target to this entity

    protected boolean outofRange;

    /** The PathEntity of our entity. */
    Path path;

    public EntityAISpiderFaceOff(NecropolisEntity entityIn, double speedIn, double stopDistance)
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
        if (this.entity.getAnimation() != EntityNecropolisSpider.RAMPAGE_ANIMATION && this.entity.getAnimation() != EntityNecropolisSpider.REAR_JAB_ANIMATION)
        {
            if (dist > this.stopDistance)
            {

                this.entity.getLookHelper().setLookPositionWithEntity(entitybase,30.0F, 30.0F);
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
        else
        {
            this.entity.getNavigator().clearPath();
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
