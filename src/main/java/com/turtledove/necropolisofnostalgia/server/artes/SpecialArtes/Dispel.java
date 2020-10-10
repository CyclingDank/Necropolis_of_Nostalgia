package com.turtledove.necropolisofnostalgia.server.artes.SpecialArtes;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.server.artes.SpecialArte;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityCast;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityDispel;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityHealingCircle;
import com.turtledove.necropolisofnostalgia.server.packets.Sounds.SoundPacket;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.Vec3d;

public class Dispel extends SpecialArte
{
    public Dispel()
    {
        super(new Vec3d(0.0D,0.0D,0.0D),new int[]{40,10},50,new Vec3d(0.0D,0.0D,0.0D),0,0);
        this.setArteWeapon(1);
        this.arte_name = "Dispel";
        this.arte_desc = "Altered Arte: Cures allies of negative status conditions while inside a curing circle.";

        this.isBase = false;
        this.tUsage = new ArteUsage[1];
        this.tUsage[0] = new ArteUsage(16, 100);
    }
    @Override
    public void startAttack(int arte_stage)
    {
        if (arte_stage == 0)
        {
            EntityCast entityFireCast = new EntityCast(this.player.world,this.player, 40);
            this.player.world.spawnEntity(entityFireCast);

            this.player.playSound(NecropolisSounds.CASTING_40,1.0f,1.0f);
            Necropolis_of_Nostalgia.packetHandler.sendTo(new SoundPacket(0,0.5f,1.0f),(EntityPlayerMP)this.player);
        }
        else
        {
            this.player.playSound(NecropolisSounds.HEAL,0.5f,1.0f);
            Necropolis_of_Nostalgia.packetHandler.sendTo(new SoundPacket(1,1.0f,1.0f),(EntityPlayerMP)this.player);
            EntityDispel tHealing = new EntityDispel(this.player.world, this.player, 120);
            this.player.world.spawnEntity(tHealing);
        }
    }
}
