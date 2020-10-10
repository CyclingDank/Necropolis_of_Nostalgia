package com.turtledove.necropolisofnostalgia.server.ai;

import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityCultSorceress;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityNecropolisSkeleton;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.math.Vec3d;

public class EntityAIRetreat extends EntityAIBase
{
    protected final NecropolisEntity entity;

    private final PathNavigate navigation;
    double speed;   //speed of the attacking entity
    double stopDistance;    //the max distance before the entity should stop, from the target to this entity
    protected boolean outofRange;
    protected boolean inPersonalSpace;

    private boolean updateTick;
    /**
     * The PathEntity of our entity.
     */
    Path path;

    public EntityAIRetreat(NecropolisEntity entityIn, double speedIn, double stopDistance) {
        this.entity = entityIn;
        this.speed = speedIn;
        this.stopDistance = stopDistance;
        this.navigation = entityIn.getNavigator();
        this.outofRange = true;
        this.inPersonalSpace = false;
        this.updateTick = false;
        this.setMutexBits(7);
    }

    public boolean shouldExecute() {
        if (entity.targetofmyrevenge != null)
        {
            if (!this.entity.canEntityBeSeen(this.entity.targetofmyrevenge))
                return false;
            if (entity.getAnimation() == ((EntityCultSorceress)(entity)).HURT_ANIMATION)
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
        this.navigation.setPath(this.path, this.speed);
    }

    public void updateTask()
    {
        EntityCultSorceress sorceress = (EntityCultSorceress)this.entity;
        Entity entitybase = this.entity.targetofmyrevenge;
        double dist = this.entity.getDistance(entitybase);
        if (this.entity.getAnimation() == EntityCultSorceress.NO_ANIMATION)
        {
            if (dist > this.stopDistance && this.inPersonalSpace == false)
            {
                sorceress.setCastState(false);
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
                if (this.inPersonalSpace == false)
                {
                    sorceress.setCastState(true);
                    if (dist > 2)
                    {
                        this.outofRange = false;
                        this.entity.getLookHelper().setLookPositionWithEntity(entitybase,30.0F, 30.0F);
                        this.entity.getNavigator().tryMoveToEntityLiving(entitybase, 0);
                        return;
                    }

                    Vec3d vec3d = RandomPositionGenerator.findRandomTargetBlockAwayFrom(this.entity, 16, 7, new Vec3d(this.entity.targetofmyrevenge.posX, this.entity.targetofmyrevenge.posY, this.entity.targetofmyrevenge.posZ));
                    if (!sorceress.isHurt())
                    {
                        this.entity.getNavigator().clearPath();
                    }
                    else if (vec3d == null)
                    {
                        this.entity.getNavigator().clearPath();
                    }
                    else if (this.entity.targetofmyrevenge.getDistanceSq(vec3d.x, vec3d.y, vec3d.z) < this.entity.targetofmyrevenge.getDistanceSq(this.entity))
                    {
                        this.entity.getNavigator().clearPath();
                    }
                    else
                    {
                        sorceress.setHurt(false);
                        sorceress.setCastState(false);
                        this.entity.getNavigator().clearPath();
                        this.path = this.navigation.getPathToXYZ(vec3d.x, vec3d.y, vec3d.z);
                        this.navigation.setPath(this.path, this.speed);
                        this.inPersonalSpace = true;
                    }
                }
                else
                {
                    if (this.navigation.noPath())
                    {
                        sorceress.setCastState(true);
                        this.inPersonalSpace = false;
                        this.entity.getLookHelper().setLookPositionWithEntity(entitybase,30.0F, 30.0F);
                    }
                }
            }
        }
        else
        {
            updateTick = true;
            this.entity.getNavigator().tryMoveToEntityLiving(entitybase, 0);
            this.entity.getLookHelper().setLookPositionWithEntity(entitybase,30.0F, 30.0F);
        }
    }

    public void resetTask() {
        Entity entitybase = this.entity.targetofmyrevenge;
        if (this.entity.targetofmyrevenge instanceof EntityPlayer && (((EntityPlayer) entitybase).isSpectator() || ((EntityPlayer) entitybase).isCreative())) {
            this.entity.targetofmyrevenge = null;
        }
        this.inPersonalSpace = false;
        this.entity.getNavigator().clearPath();
    }

    public boolean shouldContinueExecuting()
    {
        if (entity.targetofmyrevenge == null)
            return false;
        if (!entity.targetofmyrevenge.isEntityAlive())
            return false;
        if (entity.getAnimation() == ((EntityCultSorceress)(entity)).HURT_ANIMATION)
            return false;
        return true;
    }
}