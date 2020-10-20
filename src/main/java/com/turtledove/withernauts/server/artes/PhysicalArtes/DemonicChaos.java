package com.turtledove.withernauts.server.artes.PhysicalArtes;

import com.turtledove.withernauts.Necropolis_of_Nostalgia;
import com.turtledove.withernauts.server.artes.PhysicalArte;
import com.turtledove.withernauts.server.core.NecropolisPlayerData;
import com.turtledove.withernauts.server.core.PlayerData;
import com.turtledove.withernauts.server.entity.Artes.EntityDemonFang;
import com.turtledove.withernauts.server.packets.Sounds.SoundPacket;
import com.turtledove.withernauts.server.sounds.NecropolisSounds;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.Vec3d;

public class DemonicChaos extends PhysicalArte
{
    public DemonicChaos()
    {
        super(new Vec3d(0.0D,0.0D,0.0D),new int[]{8,8,8,8},32,new Vec3d(0.0D,0.0D,0.0D),25, 0);
        this.arte_name = "Demonic Chaos";
        this.arte_desc = "Altered Arte: Powerful waves of physical energy.";

        this.isBase = false;
        this.tUsage = new ArteUsage[1];
        this.tUsage[0] = new ArteUsage(2, 200);
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
