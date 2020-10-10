package com.turtledove.necropolisofnostalgia.server.artes.SpecialArtes;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.server.artes.SpecialArte;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityCast;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityPhoton;
import com.turtledove.necropolisofnostalgia.server.packets.Sounds.SoundPacket;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.Vec3d;

public class AngelRing  extends SpecialArte
{
    public AngelRing()
    {
        super(new Vec3d(0.0D,0.0D,0.0D),new int[]{40,10},50,new Vec3d(0.0D,0.0D,0.0D),45,0);
        this.setArteWeapon(1);
        this.arte_name = "Angel Ring";
        this.arte_desc = "Altered Arte: Attack enemies with discs of light that scatter in all directions, and return.";

        this.isBase = false;
        this.tUsage = new ArteUsage[1];
        this.tUsage[0] = new ArteUsage(14, 100);
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

            double lX = cX * Math.cos(0.523599) - cZ * Math.sin(0.523599);
            double lZ = cX * Math.sin(0.523599) + cZ * Math.cos(0.523599);

            double rX = cX * Math.cos(-0.523599) - cZ * Math.sin(-0.523599);
            double rZ = cX * Math.sin(-0.523599) + cZ * Math.cos(-0.523599);

            double llX = cX * Math.cos(1.0472) - cZ * Math.sin(1.0472);
            double llZ = cX * Math.sin(1.0472) + cZ * Math.cos(1.0472);

            double rrX = cX * Math.cos(-1.0472) - cZ * Math.sin(-1.0472);
            double rrZ = cX * Math.sin(-1.0472) + cZ * Math.cos(-1.0472);

            EntityPhoton tPhotonC = new EntityPhoton(this.player.world, this.player, cX * 0.75, cZ * 0.75, this.getAttackDamage(false, 2.0F));
            EntityPhoton tPhotonL = new EntityPhoton(this.player.world, this.player, lX * 0.75, lZ * 0.75, this.getAttackDamage(false, 2.0F));
            EntityPhoton tPhotonR = new EntityPhoton(this.player.world, this.player, rX * 0.75, rZ * 0.75, this.getAttackDamage(false, 2.0F));
            EntityPhoton tPhotonLL = new EntityPhoton(this.player.world, this.player, llX * 0.75, llZ * 0.75, this.getAttackDamage(false, 2.0F));
            EntityPhoton tPhotonRR = new EntityPhoton(this.player.world, this.player, rrX * 0.75, rrZ * 0.75, this.getAttackDamage(false, 2.0F));

            this.player.world.spawnEntity(tPhotonC);
            this.player.world.spawnEntity(tPhotonL);
            this.player.world.spawnEntity(tPhotonR);
            this.player.world.spawnEntity(tPhotonLL);
            this.player.world.spawnEntity(tPhotonRR);

        }
    }
}
