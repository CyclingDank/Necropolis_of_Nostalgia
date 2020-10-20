package com.turtledove.withernauts.server.artes.SpecialArtes;

import com.turtledove.withernauts.Necropolis_of_Nostalgia;
import com.turtledove.withernauts.server.artes.SpecialArte;
import com.turtledove.withernauts.server.entity.Artes.EntityCast;
import com.turtledove.withernauts.server.entity.Artes.EntityThunderBlade;
import com.turtledove.withernauts.server.packets.Sounds.SoundPacket;
import com.turtledove.withernauts.server.sounds.NecropolisSounds;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class ThunderBlade extends SpecialArte
{
    public ThunderBlade()
    {
        super(new Vec3d(0.0D,0.0D,0.0D),new int[]{40,10},50,new Vec3d(0.0D,0.0D,0.0D),35,20);
        this.setArteWeapon(2);
        this.arte_name = "Thunder Blade";
        this.arte_desc = "Base Arte: Summons a blade of lightning from the heavens.";
    }

    @Override
    public void startAttack(int arte_stage)
    {
        if (arte_stage == 0)
        {
            EntityCast entityFireCast = new EntityCast(this.player.world,this.player, 40);
            this.player.world.spawnEntity(entityFireCast);

            this.spawnPlayerBook();

            this.player.playSound(NecropolisSounds.CASTING_80,1.0f,1.0f);
            Necropolis_of_Nostalgia.packetHandler.sendTo(new SoundPacket(0,0.5f,1.0f),(EntityPlayerMP)this.player);
        }
        else
        {
            Vec3d summonPos = getSummonPos();
            EntityThunderBlade entityThunderBlade = new EntityThunderBlade(this.player.world, this.player, this.getAttackDamage( false, 4.0f));
            entityThunderBlade.setPosition(summonPos.x, (int)summonPos.y, summonPos. z);
            this.player.world.spawnEntity(entityThunderBlade);
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
