package com.turtledove.necropolisofnostalgia.server.artes.SpecialArtes;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.server.artes.SpecialArte;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityCast;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityEruption;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityTidalWave;
import com.turtledove.necropolisofnostalgia.server.packets.Sounds.SoundPacket;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class TidalWave  extends SpecialArte
{
    public TidalWave()
    {
        super(new Vec3d(0.0D,0.0D,0.0D),new int[]{40,10},50,new Vec3d(0.0D,0.0D,0.0D),50, 0);
        this.arte_name = "Tidal Wave";
        this.arte_desc = "Base Arte: Summons an inescapable torrent of water.";
        this.setArteWeapon(2);

        this.isBase = false;
        this.tUsage = new ArteUsage[1];
        this.tUsage[0] = new ArteUsage(22, 100);
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

            Vec3d summonPos = getSummonPos();
            EntityTidalWave entityTidalWave = new EntityTidalWave(this.player.world, this.player, this.getAttackDamage( false, 2.0f));
            entityTidalWave.setPosition(summonPos.x, (int)summonPos.y, summonPos. z);
            this.player.world.spawnEntity(entityTidalWave);
        }
    }
    public boolean isSpaceValid(Vec3d tesPos)
    {
        return (!this.player.world.isBlockFullCube((new BlockPos(tesPos)).up()) && this.player.world.isBlockFullCube(new BlockPos(tesPos)));
    }

    public boolean isSpaceInvalid(Vec3d tesPos)
    {
        return (this.player.world.isBlockFullCube((new BlockPos(tesPos)).up()));
    }

    private Vec3d getSummonPos()
    {
        Vec3d fPos = this.player.getPositionVector();
        Vec3d lDir = this.player.getLookVec();
        Vec3d playerPos = new Vec3d(this.player.posX, this.player.posY + this.player.getEyeHeight(), this.player.posZ);

        for (int i = 1; i < 50; i++)
        {
            Vec3d point = playerPos.add(new Vec3d(lDir.x * i, lDir.y * i, lDir.z * i));
            if (isSpaceValid(point))
            {
                return new Vec3d(point.x, point.y + 1.0f, point.z);
            }
            else if (isSpaceInvalid(point))
            {
                return fPos;
            }
        }


        return fPos;
    }
}