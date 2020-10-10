package com.turtledove.necropolisofnostalgia.server.ai;

import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityNecropolisSkeleton;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityVampireBat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class EntityAIBatFly  extends EntityAIBase {
    protected final NecropolisEntity entity;

    double speed;   //speed of the attacking entity
    double stopDistance;    //the max distance before the entity should stop, from the target to this entity

    protected boolean outofRange;

    public EntityAIBatFly(NecropolisEntity entityIn, double speedIn, double stopDistance) {
        this.entity = entityIn;
        this.speed = speedIn;
        this.stopDistance = stopDistance;
        this.outofRange = true;
        this.setMutexBits(7);
    }

    public boolean shouldExecute() {
        if (entity.targetofmyrevenge != null) {
            if (!this.entity.canEntityBeSeen(this.entity.targetofmyrevenge))
                return false;
        }
        else
            return false;
        return true;
    }

    public void startExecuting()
    {
    }

    public boolean isBlockInFront()
    {
        Vec3d tPos = new Vec3d(this.entity.posX + this.entity.getLookVec().x, this.entity.posY, this.entity.posZ + this.entity.getLookVec().z);
        if (!this.entity.world.isAirBlock(new BlockPos(tPos)) && !this.entity.world.isAirBlock((new BlockPos(tPos).up())))
            return true;
        return false;
    }

    public void updateTask()
    {
        Entity entitybase = this.entity.targetofmyrevenge;
        double dist = this.entity.getDistance(entitybase);
        if (this.entity.getAnimation() != EntityVampireBat.ANNOY_ANIMATION && this.entity.getAnimation() != EntityVampireBat.HURT_ANIMATION)
        {
            if (isBlockInFront())
                this.entity.motionY -= 0.4F;

            if (dist > this.stopDistance)
            {
                this.entity.getLookHelper().setLookPositionWithEntity(entitybase, 30.0F, 30.0F);
                this.entity.getMoveHelper().setMoveTo(this.entity.targetofmyrevenge.posX, this.entity.targetofmyrevenge.posY, this.entity.targetofmyrevenge.posZ, this.speed);
                if (this.entity.posY > this.entity.targetofmyrevenge.posY + 1.5)
                {
                    this.entity.motionY -= 0.2F;
                }
                else if (this.entity.posY + 0.1 < this.entity.targetofmyrevenge.posY)
                {
                    this.entity.motionY += 0.1F;
                }
            } else {
                this.outofRange = false;
                this.entity.getNavigator().clearPath();
                if (this.entity.posY > this.entity.targetofmyrevenge.posY + 2)
                {
                    this.entity.motionY -= 0.2F;
                }
                else if (this.entity.posY + 2 < this.entity.targetofmyrevenge.posY)
                {
                    this.entity.motionY += 0.1F;
                }
                //this.setPositionAndRotationDirect(caster.posX + caster.getLookVec().x * 0.5F,caster.posY + caster.getLookVec().y * 0.75F + 1.2F,caster.posZ + caster.getLookVec().z * 0.5F, caster.rotationYaw, caster.rotationPitch,2,true);
                this.entity.getLookHelper().setLookPositionWithEntity(entitybase, 30.0F, 30.0F);
            }
        }
        else if (this.entity.getAnimation() == EntityVampireBat.HURT_ANIMATION)
        {
            this.entity.motionY = -0.3D;
        }
    }

    public void resetTask() {
        Entity entitybase = this.entity.targetofmyrevenge;
        if (this.entity.targetofmyrevenge instanceof EntityPlayer && (((EntityPlayer) entitybase).isSpectator() || ((EntityPlayer) entitybase).isCreative())) {
            this.entity.targetofmyrevenge = null;
            this.outofRange = true;
        }
    }

    public boolean shouldContinueExecuting() {
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