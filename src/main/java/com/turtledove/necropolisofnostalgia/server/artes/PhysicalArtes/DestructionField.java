package com.turtledove.necropolisofnostalgia.server.artes.PhysicalArtes;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.server.artes.PhysicalArte;
import com.turtledove.necropolisofnostalgia.server.core.NecropolisPlayerData;
import com.turtledove.necropolisofnostalgia.server.core.PlayerData;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityDemonFang;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityDestructionField;
import com.turtledove.necropolisofnostalgia.server.packets.Sounds.SoundPacket;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.Vec3d;

public class DestructionField extends PhysicalArte
{
    public DestructionField()
    {
        super(new Vec3d(0.0D,0.0D,0.0D),new int[]{10},10,new Vec3d(0.0D,0.0D,0.0D),25, 0);
        this.arte_name = "Destruction Field";
        this.arte_desc = "Base Arte: A wide blast of energy created by striking the ground.";
    }
    @Override
    public void startAttack(int arte_stage)
    {

        PlayerData playerDataSource = (PlayerData) NecropolisPlayerData.get(this.player);
        int attack = playerDataSource.getPlayerStats()[0];

        EntityDestructionField cast = new EntityDestructionField(this.player.world, this.player, new Vec3d(this.player.posX + this.player.getLookVec().x, this.player.posY, this.player.posZ + this.player.getLookVec().z), this.getAttackDamage(true, 1.0f));
        this.player.world.spawnEntity(cast);
    }
}