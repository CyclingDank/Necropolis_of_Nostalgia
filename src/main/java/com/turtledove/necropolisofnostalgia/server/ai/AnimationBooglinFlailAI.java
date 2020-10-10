package com.turtledove.necropolisofnostalgia.server.ai;

import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityBooglin;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class AnimationBooglinFlailAI  <T extends NecropolisEntity & IAnimatedEntity> extends AnimationAI<T> {
    public AnimationBooglinFlailAI(T entity, Animation animation) {
        super(entity, animation, true);
        this.setMutexBits(8);
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
    }

    @Override
    public void updateTask() {
        if (this.entity.targetofmyrevenge == null) {
            EntityBooglin sorceress = new EntityBooglin(this.entity.world);
            sorceress.setPosition(this.entity.posX, this.entity.posY, this.entity.posZ);
            this.entity.world.spawnEntity(sorceress);
            this.entity.setDead();
            return;
        }
        if (this.entity.getAnimationTick() == 14)
        {
            this.entity.playSound(NecropolisSounds.BOOGLIN_CRY, 1.0f, 1.0f);
            this.entity.playSound(NecropolisSounds.BOOGLIN_DRILL_2, 1.0f, 1.0f);

            this.entity.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, 0.7F, 0.7F);
            List<Entity> swipeEnemies = this.entity.world.getEntitiesWithinAABBExcludingEntity(entity,  entity.getEntityBoundingBox().expand(5.0,1.0,5.0).offset(-2.5D,0D,-2.5D));
            hitTargets(swipeEnemies);
        }
        else if (this.entity.getAnimationTick() == 21)
        {
            this.entity.playSound(NecropolisSounds.BOOGLIN_CRY, 1.0f, 1.0f);
            this.entity.playSound(NecropolisSounds.BOOGLIN_DRILL_2, 1.0f, 1.0f);

            this.entity.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, 0.7F, 0.7F);
            List<Entity> swipeEnemies = this.entity.world.getEntitiesWithinAABBExcludingEntity(entity,  entity.getEntityBoundingBox().expand(5.0,1.0,5.0).offset(-2.5D,0D,-2.5D));
            hitTargets(swipeEnemies);
        }
        else if (this.entity.getAnimationTick() == 4)
        {
            if (this.entity.targetofmyrevenge.posY - this.entity.posY >= 0.9 )
            {
                this.entity.motionY = 0.5;
            }
        }
    }

    @Override
    public void resetTask() {
        super.resetTask();
        entity.active = false;
    }
    public void hitTargets(List<Entity> swipeEnemies) {
        if (!swipeEnemies.isEmpty()) {
            for (Entity targ : swipeEnemies) {
                if (targ instanceof EntityPlayer)
                {
                    if (entityInSlash(entity, targ) == true) {
                        boolean hitTest = targ.attackEntityFrom(DamageSource.causeMobDamage(this.entity), 15.0F);

                    }
                }
            }
        }
    }

    /*HELPERS*/
    public double lineIntersection(Vec3d planePoint, Vec3d planeNormal, Vec3d linePoint, Vec3d lineDirection) {
        double t = (planeNormal.dotProduct(planePoint) - planeNormal.dotProduct(linePoint)) / planeNormal.dotProduct(lineDirection);
        return t;
    }

    public Vec3d getHitboxBasis(Entity source, Vec3d target) {
        Vec3d player_localSpace_translated = new Vec3d(target.x - source.posX, target.y - (source.posY + 1.5), target.z - source.posZ);
        float draco_angle = source.rotationYaw * 0.0174533F;
        float t_sin = MathHelper.sin(draco_angle);
        float t_cos = MathHelper.cos(draco_angle);
        Vec3d player_localSpace_rotatedYaw = new Vec3d(player_localSpace_translated.x * t_cos + player_localSpace_translated.z * t_sin, player_localSpace_translated.y, -player_localSpace_translated.x * t_sin + player_localSpace_translated.z * t_cos);
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
        Vec3d P = new Vec3d(-0.5, -0.3, 3.9);
        Vec3d R = new Vec3d(0.5, -0.3, 2.5);

        Q = new Vec3d(-0.5, -0.3, 0.0);
        P = new Vec3d(-0.5, -0.3, 3.9);
        R = new Vec3d(0.5, -0.3, 3.9);

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