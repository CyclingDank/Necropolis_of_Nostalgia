package com.turtledove.withernauts.server.ai;

import com.turtledove.withernauts.server.entity.NecropolisEntity;
import com.turtledove.withernauts.server.entity.enemies.EntityNecropolisSkeleton;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class AnimationBlockAI <T extends NecropolisEntity & IAnimatedEntity> extends AnimationAI<T>
{
    public AnimationBlockAI(T entity, Animation animation)
    {
        super(entity, animation);
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
        //entity.motionX = 0;
        //entity.motionZ = 0;

        if (this.entity.targetofmyrevenge == null)
        {
            EntityNecropolisSkeleton replacement_skelly = new EntityNecropolisSkeleton(this.entity.world);
            replacement_skelly.setPosition(this.entity.posX,this.entity.posY,this.entity.posZ);
            this.entity.world.spawnEntity(replacement_skelly);
            this.entity.setDead();
            return;
        }

        if (entity.getAnimationTick() == 5 || entity.getAnimationTick() == 12)
        {
            double dX = this.entity.targetofmyrevenge.posX - this.entity.posX;
            double dZ = this.entity.targetofmyrevenge.posZ - this.entity.posZ;

            this.entity.motionX = dX / 4.0;
            this.entity.motionZ = dZ / 4.0;
        }

        if (this.entity.getAnimationTick() == 40)
        {
            entity.playSound(SoundEvents.ENTITY_SKELETON_AMBIENT,1.5F, 0.5F);
        }

        if (entity.getAnimationTick() == 11 || entity.getAnimationTick() == 19)
        {
            entity.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP,1.0F, 0.5F);
            List<Entity> swipeEnemies = this.entity.world.getEntitiesWithinAABBExcludingEntity(entity,  entity.getEntityBoundingBox().expand(5.0,1.0,5.0).offset(-2.5D,0D,-2.5D));
            if (!swipeEnemies.isEmpty())
            {
                for (Entity targ : swipeEnemies)
                {
                    if (targ instanceof EntityPlayer)
                    {
                        if (entityInSlash(entity, targ) == true)
                        {
                            boolean hitTest = targ.attackEntityFrom(DamageSource.causeMobDamage(this.entity),15.0F);
                        }
                    }
                }
            }
        }
        else if (this.entity.getAnimationTick() == 37 || this.entity.getAnimationTick() == 38)
        {
            entity.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP,1.0F, 0.5F);
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

    @Override
    public void resetTask()
    {
        super.resetTask();
        entity.active = true;
    }
    /*HELPERS*/
    public double lineIntersection(Vec3d planePoint, Vec3d planeNormal, Vec3d linePoint, Vec3d lineDirection)
    {
        double t = (planeNormal.dotProduct(planePoint) - planeNormal.dotProduct(linePoint)) / planeNormal.dotProduct(lineDirection);
        return t;
    }
    public Vec3d getHitboxBasis(Entity source, Vec3d target)
    {
        Vec3d player_localSpace_translated = new Vec3d(target.x - source.posX, target.y - (source.posY + 1.5),  target.z - source.posZ);
        float draco_angle = source.rotationYaw * 0.0174533F;
        float t_sin = MathHelper.sin(draco_angle);
        float t_cos = MathHelper.cos(draco_angle);
        Vec3d player_localSpace_rotatedYaw = new Vec3d(player_localSpace_translated.x * t_cos + player_localSpace_translated.z * t_sin, player_localSpace_translated.y,-player_localSpace_translated.x * t_sin + player_localSpace_translated.z * t_cos);
        draco_angle = source.rotationPitch * 0.0174533F;
        t_sin = MathHelper.sin(draco_angle);
        t_cos = MathHelper.cos(draco_angle);
        Vec3d player_localSpace_rotatedPitch = new Vec3d(t_cos * player_localSpace_rotatedYaw.x + -player_localSpace_rotatedYaw.y * t_sin, player_localSpace_rotatedYaw.x * t_sin + t_cos * player_localSpace_rotatedYaw.y, player_localSpace_rotatedYaw.z);
        return player_localSpace_rotatedPitch;
    }
    public boolean entityInSlash(Entity source, Entity target) {
        Vec3d l0 = getHitboxBasis(source, target.getPositionVector());
        Vec3d l1 = getHitboxBasis(source, new Vec3d(target.posX, target.posY + target.height, target.posZ));

        Vec3d AB = l1.subtract(l0).normalize();

        Vec3d Q = new Vec3d(-0.5, -0.3, 0.0);
        Vec3d P = new Vec3d(-0.5, -0.3, 2.5);
        Vec3d R = new Vec3d(0.5, -0.3, 2.5);

        Q = new Vec3d(-1.0, -0.3, 0.0);
        P = new Vec3d(-1.0, -0.3, 2.5);
        R = new Vec3d(1.0, -0.3, 2.5);

        if ((l0.x >= Q.x && l0.x <= R.x)&&(l0.z >= Q.z && l0.z < R.z))
        {
            if ((l0.y >= Q.y && l0.y <= -Q.y) || (l1.y >= Q.y && l1.y <= -Q.y))
                return true;
            else if ((l0.y < Q.y) || (l1.y > -Q.y))
                return true;
        }
        return false;
    }
}
