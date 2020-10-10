package com.turtledove.necropolisofnostalgia.server.artes.PhysicalArtes;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.server.artes.PhysicalArte;
import com.turtledove.necropolisofnostalgia.server.core.NecropolisPlayerData;
import com.turtledove.necropolisofnostalgia.server.core.PlayerData;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityDemonFang;
import com.turtledove.necropolisofnostalgia.server.packets.Sounds.SoundPacket;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.Vec3d;

/*Basic medium range attack for swordsmen. Deals non-elemental physical damage*/
public class DemonFang extends PhysicalArte
{
    public DemonFang()
    {
        super(new Vec3d(0.0D,0.0D,0.0D),new int[]{10},10,new Vec3d(0.0D,0.0D,0.0D),10, 0);
        this.arte_name = "Demon Fang";
        this.arte_desc = "Base Arte: A traveling blast of energy created by concentrating mana into sheer physical power.";
    }
    @Override
    public void startAttack(int arte_stage)
    {

        PlayerData playerDataSource = (PlayerData) NecropolisPlayerData.get(this.player);
        int attack = playerDataSource.getPlayerStats()[0];

        EntityDemonFang cast = new EntityDemonFang(this.player.world, this.player, this.player.getPositionVector(),this.player.rotationYaw, this.getAttackDamage(true, 1.0f), 40);
        Vec3d slope = new Vec3d(this.player.getForward().x, 0.0D, this.player.getForward().z);
        cast.setLocationAndAngles(this.player.posX + slope.x,this.player.posY, this.player.posZ + slope.z, this.player.rotationYaw, 0.0F);
        this.player.world.spawnEntity(cast);

        this.player.playSound(NecropolisSounds.DEMON_FANG,1.0f,1.0f);
        Necropolis_of_Nostalgia.packetHandler.sendTo(new SoundPacket(2,1.0f,1.0f),(EntityPlayerMP)this.player);
    }
}
