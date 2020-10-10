package com.turtledove.necropolisofnostalgia.server.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.math.Vec3d;

import javax.annotation.Nullable;
import java.util.List;

public class EntityWMRoamAI extends EntityAIWander
{
    protected final float probability;

    public EntityWMRoamAI(EntityCreature entityIn, double p_i47301_2_)
    {
        this(entityIn, p_i47301_2_, 0.001F);
    }

    public EntityWMRoamAI(EntityCreature p_i47302_1_, double p_i47302_2_, float p_i47302_4_)
    {
        super(p_i47302_1_, p_i47302_2_);
        this.probability = p_i47302_4_;
    }

    @Override
    public boolean shouldExecute()
    {
        if (!this.mustUpdate)
        {
            if (this.entity.getIdleTime() >= 100)
            {
                return false;
            }

            if (this.entity.getRNG().nextInt(this.executionChance) != 0)
            {
                return false;
            }
        }

        Vec3d vec3d = this.getPosition();

        if (vec3d == null)
        {
            return false;
        }
        else
        {
            List<Entity> potentialCustomers = this.entity.world.getEntitiesWithinAABBExcludingEntity(entity,  entity.getEntityBoundingBox().expand(6.0,1.0,6.0).offset(-3.5D,0D,-3.5D));
            if (!potentialCustomers.isEmpty())
                return false;

            this.x = vec3d.x;
            this.y = vec3d.y;
            this.z = vec3d.z;
            this.mustUpdate = false;
            return true;
        }
    }
    @Nullable
    protected Vec3d getPosition()
    {
        if (this.entity.isInWater())
        {
            Vec3d vec3d = RandomPositionGenerator.getLandPos(this.entity, 15, 7);
            return vec3d == null ? super.getPosition() : vec3d;
        }
        else
        {
            return this.entity.getRNG().nextFloat() >= this.probability ? RandomPositionGenerator.getLandPos(this.entity, 10, 7) : super.getPosition();
        }
    }
    @Override
    public boolean shouldContinueExecuting()
    {
        if (!this.entity.getNavigator().noPath())
            return false;
        if (this.entity.ticksExisted %20 == 0)
        {
            List<Entity> potentialCustomers = this.entity.world.getEntitiesWithinAABBExcludingEntity(entity,  entity.getEntityBoundingBox().expand(6.0,1.0,6.0).offset(-3.5D,0D,-3.5D));
            if (!potentialCustomers.isEmpty())
                return false;
        }
        return true;
    }

}