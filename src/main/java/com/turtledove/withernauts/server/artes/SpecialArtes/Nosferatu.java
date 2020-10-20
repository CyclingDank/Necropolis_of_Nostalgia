package com.turtledove.withernauts.server.artes.SpecialArtes;

import com.turtledove.withernauts.Necropolis_of_Nostalgia;
import com.turtledove.withernauts.server.artes.SpecialArte;
import com.turtledove.withernauts.server.entity.Artes.EntityCast;
import com.turtledove.withernauts.server.entity.Artes.EntityNosferatu;
import com.turtledove.withernauts.server.packets.Sounds.SoundPacket;
import com.turtledove.withernauts.server.sounds.NecropolisSounds;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.Vec3d;

public class Nosferatu   extends SpecialArte
{
    public Nosferatu()
    {
        super(new Vec3d(0.0D,0.0D,0.0D),new int[]{40,10},50,new Vec3d(0.0D,0.0D,0.0D),30, 13);
        this.arte_name = "Nosferatu";
        this.arte_desc = "Base Arte: Launches a toxic orb that explodes into a poisonous mist.";
        this.setArteWeapon(2);
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

            double d2 = this.player.getLookVec().x;
            double d3 = this.player.getLookVec().y;
            double d4 = this.player.getLookVec().z;

            EntityNosferatu entityNosferatu = new EntityNosferatu(this.player.world, this.player, d2, d3, d4, this.getAttackDamage(false, 3.0F));
            entityNosferatu.setPosition(this.player.posX, this.player.posY + 0.75F, this.player.posZ);
            this.player.world.spawnEntity(entityNosferatu);
        }
    }
}
