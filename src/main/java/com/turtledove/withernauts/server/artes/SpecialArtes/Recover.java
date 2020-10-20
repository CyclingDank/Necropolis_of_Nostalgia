package com.turtledove.withernauts.server.artes.SpecialArtes;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.server.artes.SpecialArte;
import com.turtledove.withernauts.server.entity.Artes.EntityCast;
import com.turtledove.withernauts.server.packets.Sounds.SoundPacket;
import com.turtledove.withernauts.server.sounds.NecropolisSounds;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.Vec3d;

public class Recover extends SpecialArte
{
    public Recover()
    {
        super(new Vec3d(0.0D,0.0D,0.0D),new int[]{40,10},50,new Vec3d(0.0D,0.0D,0.0D),15,15);
        this.setArteWeapon(1);
        this.arte_name = "Recover";
        this.arte_desc = "Base Arte: Cures all negative status effects.";
    }
    @Override
    public void startAttack(int arte_stage)
    {
        if (arte_stage == 0)
        {
            EntityCast entityFireCast = new EntityCast(this.player.world,this.player, 40);
            this.player.world.spawnEntity(entityFireCast);

            this.player.playSound(NecropolisSounds.CASTING_40,1.0f,1.0f);
            Withernauts.packetHandler.sendTo(new SoundPacket(0,0.5f,1.0f),(EntityPlayerMP)this.player);
        }
        else
        {
            this.player.clearActivePotions();
            this.player.playSound(NecropolisSounds.HEAL,0.5f,1.0f);
            this.player.playSound(NecropolisSounds.RECOVER,0.5f,1.0f);
            Withernauts.packetHandler.sendTo(new SoundPacket(9,1.0f,1.0f),(EntityPlayerMP)this.player);
            Withernauts.packetHandler.sendTo(new SoundPacket(1,1.0f,1.0f),(EntityPlayerMP)this.player);
        }
    }
}
