package com.turtledove.necropolisofnostalgia.server.artes.SpecialArtes;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.server.artes.SpecialArte;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityCast;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityNecropolisFireBall;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityPB;
import com.turtledove.necropolisofnostalgia.server.packets.Sounds.SoundPacket;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class PrecipiceBlades extends SpecialArte
{
    public PrecipiceBlades()
    {
        super(new Vec3d(0.0D,0.0D,0.0D),new int[]{40,10},50,new Vec3d(0.0D,0.0D,0.0D),40, 0);
        this.arte_name = "Precipice Blades";
        this.arte_desc = "Base Arte: Raises a wall of earth around the caster.";
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

            Vec3d []pbPos = new Vec3d[] {
                    new Vec3d(this.player.posX+2.6, this.player.posY, this.player.posZ),
                    new Vec3d(this.player.posX-2.6, this.player.posY, this.player.posZ),
                    new Vec3d(this.player.posX, this.player.posY, this.player.posZ+2.6),
                    new Vec3d(this.player.posX, this.player.posY, this.player.posZ-2.6),
                    new Vec3d(this.player.posX+2.3, this.player.posY, this.player.posZ+2.3),
                    new Vec3d(this.player.posX-2.3, this.player.posY, this.player.posZ-2.3),
                    new Vec3d(this.player.posX+2.3, this.player.posY, this.player.posZ-2.3),
                    new Vec3d(this.player.posX-2.3, this.player.posY, this.player.posZ+2.3)};

            for (int i = 0; i < 8; i++)
            {
                EntityPB entityPB1 = new EntityPB(this.player.world, this.player, this.getAttackDamage(false, 3.0F));
                if (this.player.world.isAirBlock(new BlockPos(pbPos[i])) && !this.player.world.isAirBlock((new BlockPos(pbPos[i]).down())))
                {
                    entityPB1.setPosition(pbPos[i].x, pbPos[i].y, pbPos[i].z);
                    this.player.world.spawnEntity(entityPB1);
                    entityPB1.playSound(NecropolisSounds.PB_CAST, 0.7f, 1.0f);
                }
            }
        }
    }
}
