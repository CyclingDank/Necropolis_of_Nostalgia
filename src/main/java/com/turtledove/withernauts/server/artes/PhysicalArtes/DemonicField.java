package com.turtledove.withernauts.server.artes.PhysicalArtes;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.server.artes.PhysicalArte;
import com.turtledove.withernauts.server.core.NecropolisPlayerData;
import com.turtledove.withernauts.server.core.PlayerData;
import com.turtledove.withernauts.server.entity.Artes.EntityDemonFang;
import com.turtledove.withernauts.server.entity.Artes.EntityDestructionField;
import com.turtledove.withernauts.server.packets.Sounds.SoundPacket;
import com.turtledove.withernauts.server.sounds.NecropolisSounds;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.Vec3d;

public class DemonicField extends PhysicalArte {
    public DemonicField() {
        super(new Vec3d(0.0D, 0.0D, 0.0D), new int[]{7, 7}, 14, new Vec3d(0.0D, 0.0D, 0.0D), 35, 0);
        this.arte_name = "Demonic Field";
        this.arte_desc = "Altered Arte: Unleashes a wide and travelling blast of energy.";

        this.isBase = false;
        this.tUsage = new ArteUsage[2];
        this.tUsage[0] = new ArteUsage(2, 200);
        this.tUsage[0] = new ArteUsage(31, 200);

    }

    @Override
    public void startAttack(int arte_stage) {

        PlayerData playerDataSource = (PlayerData) NecropolisPlayerData.get(this.player);
        int attack = playerDataSource.getPlayerStats()[0];

        if (arte_stage == 0)
        {
            EntityDemonFang entityDemonFang = new EntityDemonFang(this.player.world, this.player, this.player.getPositionVector(),this.player.rotationYaw, this.getAttackDamage(true, 1.0f), 40);
            Vec3d slope = new Vec3d(this.player.getForward().x, 0.0D, this.player.getForward().z);
            entityDemonFang.setLocationAndAngles(this.player.posX + slope.x,this.player.posY, this.player.posZ + slope.z, this.player.rotationYaw, 0.0F);
            this.player.world.spawnEntity(entityDemonFang);
            this.player.playSound(NecropolisSounds.DEMON_FANG,1.0f,1.0f);
            Withernauts.packetHandler.sendTo(new SoundPacket(2,1.0f,1.0f),(EntityPlayerMP)this.player);
        }
        else
        {
            EntityDestructionField cast = new EntityDestructionField(this.player.world, this.player, new Vec3d(this.player.posX + this.player.getLookVec().x, this.player.posY, this.player.posZ + this.player.getLookVec().z), this.getAttackDamage(true, 1.0f));
            this.player.world.spawnEntity(cast);
        }
    }
}