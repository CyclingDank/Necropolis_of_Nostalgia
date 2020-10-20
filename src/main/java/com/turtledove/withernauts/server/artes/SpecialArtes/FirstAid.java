package com.turtledove.withernauts.server.artes.SpecialArtes;

import com.turtledove.withernauts.Necropolis_of_Nostalgia;
import com.turtledove.withernauts.server.artes.SpecialArte;
import com.turtledove.withernauts.server.entity.Artes.EntityCast;
import com.turtledove.withernauts.server.packets.Sounds.SoundPacket;
import com.turtledove.withernauts.server.sounds.NecropolisSounds;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.Vec3d;

public class FirstAid extends SpecialArte
{
    public FirstAid()
    {
        super(new Vec3d(0.0D,0.0D,0.0D),new int[]{80,10},90,new Vec3d(0.0D,0.0D,0.0D),15,0);
        this.setArteWeapon(1);
        this.arte_name = "First Aid";
        this.arte_desc = "Base Arte: Heal 35% of max HP.";
    }
    @Override
    public void startAttack(int arte_stage)
    {
        if (arte_stage == 0)
        {
            EntityCast entityFireCast = new EntityCast(this.player.world,this.player, 80);
            this.player.world.spawnEntity(entityFireCast);

            this.player.playSound(NecropolisSounds.CASTING_80,1.0f,1.0f);
            Necropolis_of_Nostalgia.packetHandler.sendTo(new SoundPacket(7,0.5f,1.0f),(EntityPlayerMP)this.player);
        }
        else
        {
            float player_max_hp = this.player.getMaxHealth();
            float player_current_hp = this.player.getHealth();

            if ((player_current_hp + player_max_hp * 0.35F) < player_max_hp)
            {
                this.player.heal(player_max_hp * 0.35F);
            }
            else
            {
                this.player.setHealth(player_max_hp);
            }
            this.player.playSound(NecropolisSounds.HEAL,0.5f,1.0f);
            Necropolis_of_Nostalgia.packetHandler.sendTo(new SoundPacket(1,1.0f,1.0f),(EntityPlayerMP)this.player);
        }
    }
}
