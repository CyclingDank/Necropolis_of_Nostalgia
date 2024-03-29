package com.turtledove.necropolisofnostalgia.server.artes.SpecialArtes;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.server.artes.SpecialArte;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityCast;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityPhoton;
import com.turtledove.necropolisofnostalgia.server.packets.Sounds.SoundPacket;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;

public class Photon extends SpecialArte
{
    public Photon()
    {
        super(new Vec3d(0.0D,0.0D,0.0D),new int[]{40,10},50,new Vec3d(0.0D,0.0D,0.0D),20,5);
        this.setArteWeapon(1);
        this.arte_name = "Photon";
        this.arte_desc = "Base Arte: Attack enemies with a disc of light.";
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
            this.player.playSound(NecropolisSounds.ARTE_COMPLETE,0.5f,1.0f);
            Necropolis_of_Nostalgia.packetHandler.sendTo(new SoundPacket(8,1.0f,1.0f),(EntityPlayerMP)this.player);

            this.player.playSound(NecropolisSounds.LIGHT_CAST,0.5f,1.0f);
            Necropolis_of_Nostalgia.packetHandler.sendTo(new SoundPacket(10,1.0f,1.0f),(EntityPlayerMP)this.player);

            Vec3d pV = this.player.getLookVec().normalize();
            double cX = pV.x;
            double cZ = pV.z;

            EntityPhoton tPhotonC = new EntityPhoton(this.player.world, this.player, cX * 0.75, cZ * 0.75, this.getAttackDamage(false, 2.0F), false);

            this.player.world.spawnEntity(tPhotonC);
        }
    }
}
