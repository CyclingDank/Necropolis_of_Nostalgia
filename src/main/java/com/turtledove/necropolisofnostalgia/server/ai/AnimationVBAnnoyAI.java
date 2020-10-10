package com.turtledove.necropolisofnostalgia.server.ai;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityCast;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityNosferatu;
import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityVampireBat;
import com.turtledove.necropolisofnostalgia.server.packets.Player.PlayerParticlePacket;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class AnimationVBAnnoyAI <T extends NecropolisEntity & IAnimatedEntity> extends AnimationAI<T> {

    private int annoyEffect;
    public AnimationVBAnnoyAI(T entity, Animation animation)
    {
        super(entity, animation, true);
        double chance = Math.random();
        if (chance <= 0.2)
            this.annoyEffect = 0;
        else if (chance <= 1.0)
            this.annoyEffect = 1;
        this.setMutexBits(8);
    }

    @Override
    public void startExecuting()
    {
        super.startExecuting();
        double chance = Math.random();
        if (chance <= 0.3)
            this.annoyEffect = 0;
        else if (chance <= 1.0)
            this.annoyEffect = 1;
    }

    @Override
    public void updateTask()
    {
        if (this.entity.targetofmyrevenge == null)
        {
            EntityVampireBat birb = new EntityVampireBat(this.entity.world);
            birb.setPosition(this.entity.posX,this.entity.posY,this.entity.posZ);
            this.entity.world.spawnEntity(birb);
            this.entity.setDead();
            return;
        }
        if (this.entity.getAnimationTick() == 0)
        {
            this.entity.playSound(SoundEvents.ENTITY_BAT_TAKEOFF, 0.6f, 1.0f);
            this.entity.playSound(NecropolisSounds.CASTING_40, 1.0f, 1.0f);

            EntityCast entityFireCast = new EntityCast(this.entity.world,this.entity, 40);
            this.entity.world.spawnEntity(entityFireCast);
        }
        else if (this.entity.getAnimationTick() == 39)
        {
            this.entity.playSound(NecropolisSounds.ARTE_COMPLETE, 1.0f, 1.0f);

            double d2 = this.entity.targetofmyrevenge.posX - this.entity.posX;
            double d3 = this.entity.targetofmyrevenge.posY - this.entity.posY;
            double d4 = this.entity.targetofmyrevenge.posZ - this.entity.posZ;

            double d5 = Math.sqrt(d2 * d2 + d3 * d3 + d4 * d4);

            EntityNosferatu entityNosferatu = new EntityNosferatu(this.entity.world, this.entity, d2/d5, d3/d5, d4/d5, 15.0F);
            entityNosferatu.setPosition(this.entity.posX, this.entity.posY + 0.75F, this.entity.posZ);
            this.entity.world.spawnEntity(entityNosferatu);
        }
    }
    @Override
    public void resetTask()
    {
        super.resetTask();
        entity.active = false;
    }
}
