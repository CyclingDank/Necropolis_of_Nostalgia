package com.turtledove.necropolisofnostalgia.server.ai;

import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityPhoton;
import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityAxeBeak;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityCultSorceress;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class AnimationCSPhotonCastAI<T extends NecropolisEntity & IAnimatedEntity> extends AnimationAI<T> {
    public AnimationCSPhotonCastAI(T entity, Animation animation) {
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
            this.entity.playSound(NecropolisSounds.CASTING_40, 1.0f, 1.0f);
        }
        else if (this.entity.getAnimationTick() == 40)
        {
            this.entity.playSound(NecropolisSounds.ARTE_COMPLETE, 1.0f, 1.0f);

            Vec3d pV = this.entity.getLookVec().normalize();
            double cX = pV.x;
            double cZ = pV.z;

            double lX = cX * Math.cos(0.523599) - cZ * Math.sin(0.523599);
            double lZ = cX * Math.sin(0.523599) + cZ * Math.cos(0.523599);

            double rX = cX * Math.cos(-0.523599) - cZ * Math.sin(-0.523599);
            double rZ = cX * Math.sin(-0.523599) + cZ * Math.cos(-0.523599);

            double llX = cX * Math.cos(1.0472) - cZ * Math.sin(1.0472);
            double llZ = cX * Math.sin(1.0472) + cZ * Math.cos(1.0472);

            double rrX = cX * Math.cos(-1.0472) - cZ * Math.sin(-1.0472);
            double rrZ = cX * Math.sin(-1.0472) + cZ * Math.cos(-1.0472);

            EntityPhoton tPhotonC = new EntityPhoton(this.entity.world, this.entity, cX * 0.75, cZ * 0.75, 4);
            EntityPhoton tPhotonL = new EntityPhoton(this.entity.world, this.entity, lX * 0.75, lZ * 0.75, 4);
            EntityPhoton tPhotonR = new EntityPhoton(this.entity.world, this.entity, rX * 0.75, rZ * 0.75, 4);
            EntityPhoton tPhotonLL = new EntityPhoton(this.entity.world, this.entity, llX * 0.75, llZ * 0.75, 4);
            EntityPhoton tPhotonRR = new EntityPhoton(this.entity.world, this.entity, rrX * 0.75, rrZ * 0.75, 4);

            this.entity.world.spawnEntity(tPhotonC);
            this.entity.world.spawnEntity(tPhotonL);
            this.entity.world.spawnEntity(tPhotonR);
            this.entity.world.spawnEntity(tPhotonLL);
            this.entity.world.spawnEntity(tPhotonRR);
        }

    }

    @Override
    public void resetTask()
    {
        super.resetTask();
        entity.active = false;
    }
}