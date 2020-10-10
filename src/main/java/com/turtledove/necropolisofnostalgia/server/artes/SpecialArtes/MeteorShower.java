package com.turtledove.necropolisofnostalgia.server.artes.SpecialArtes;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.server.artes.SpecialArte;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityCast;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityJudgementController;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityMeteorController;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityOFController;
import com.turtledove.necropolisofnostalgia.server.packets.Sounds.SoundPacket;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.Vec3d;

public class MeteorShower extends SpecialArte
{
    public MeteorShower()
    {
        super(new Vec3d(0.0D,0.0D,0.0D),new int[]{40,10},50,new Vec3d(0.0D,0.0D,0.0D),45, 0);
        this.arte_name = "Meteor Shower";
        this.arte_desc = "Base Arte: Casts a shower of extraterrestrial stones from the heavens.";
        this.setArteWeapon(2);

        this.isBase = false;
        this.tUsage = new ArteUsage[1];
        this.tUsage[0] = new ArteUsage(21, 100);
    }
    @Override
    public void startAttack(int arte_stage)
    {
        if (arte_stage == 0)
        {
            EntityCast entityFireCast = new EntityCast(this.player.world,this.player, 40);
            this.player.world.spawnEntity(entityFireCast);

            this.spawnPlayerBook();

            this.player.playSound(NecropolisSounds.CASTING_40,1.0f,1.0f);
            Necropolis_of_Nostalgia.packetHandler.sendTo(new SoundPacket(0,0.5f,1.0f),(EntityPlayerMP)this.player);
        }
        else
        {
            this.player.playSound(NecropolisSounds.HEAL,0.5f,1.0f);
            Necropolis_of_Nostalgia.packetHandler.sendTo(new SoundPacket(1,1.0f,1.0f),(EntityPlayerMP)this.player);

            EntityMeteorController entityMeteorController = new EntityMeteorController(this.player.world, this.player, this.getAttackDamage(false, 3.0F));
            this.player.world.spawnEntity(entityMeteorController);
        }
    }
}
