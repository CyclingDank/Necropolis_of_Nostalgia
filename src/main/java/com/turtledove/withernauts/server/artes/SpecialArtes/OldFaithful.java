package com.turtledove.withernauts.server.artes.SpecialArtes;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.server.artes.SpecialArte;
import com.turtledove.withernauts.server.entity.Artes.EntityCast;
import com.turtledove.withernauts.server.entity.Artes.EntityOFController;
import com.turtledove.withernauts.server.packets.Sounds.SoundPacket;
import com.turtledove.withernauts.server.sounds.NecropolisSounds;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.Vec3d;

public class OldFaithful  extends SpecialArte
{
    public OldFaithful()
    {
        super(new Vec3d(0.0D,0.0D,0.0D),new int[]{40,10},50,new Vec3d(0.0D,0.0D,0.0D),35, 5);
        this.arte_name = "Old Faithful";
        this.arte_desc = "Base Arte: Summons steaming jets of geysers from below.";
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
            Withernauts.packetHandler.sendTo(new SoundPacket(0,0.5f,1.0f),(EntityPlayerMP)this.player);
        }
        else
        {
            this.player.playSound(NecropolisSounds.HEAL,0.5f,1.0f);
            Withernauts.packetHandler.sendTo(new SoundPacket(1,1.0f,1.0f),(EntityPlayerMP)this.player);

            EntityOFController entityOFController = new EntityOFController(this.player.world, this.player, this.player.getLookVec().x, this.player.getLookVec().z, this.getAttackDamage(false, 3.0f));
            this.player.world.spawnEntity(entityOFController);
        }
    }
}
