package com.turtledove.necropolisofnostalgia.server.artes.PhysicalArtes;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.server.artes.PhysicalArte;
import com.turtledove.necropolisofnostalgia.server.packets.Player.SyncPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class WhirlingTop  extends PhysicalArte
{
    public WhirlingTop()
    {
        super(new Vec3d(0.0D,0.0D,0.0D), new int[]{30, 6}, 36,new Vec3d(0.0D,0.0D,0.0D),35, 0);
        this.arte_name = "Whirling Top";
        this.arte_desc = "Base Arte: A spin attack that strike all around.";

        this.setArteWeapon(3);
    }
    @Override
    public void startAttack(int arte_stage)
    {
        if (arte_stage == 1)
        {
            List<Entity> swipeEnemies = this.player.world.getEntitiesWithinAABBExcludingEntity(player,  player.getEntityBoundingBox().expand(5.0,1.0,5.0).offset(-2.5,0.0,-2.5));
            if (!swipeEnemies.isEmpty())
            {
                for (Entity entity : swipeEnemies)
                {
                    entity.attackEntityFrom(DamageSource.causeMobDamage(player),1.0F);
                    double d2 =  entity.posX - this.player.posX;
                    double d3 =  entity.posZ - this.player.posZ;
                    double d4 = 2.0D;
                    if (entity instanceof EntityPlayer)
                    {
                        Necropolis_of_Nostalgia.packetHandler.sendTo(new SyncPlayer(d2 / d4, 0.0D,  d3 / d4),(EntityPlayerMP)entity);
                    }
                    else
                    {
                        entity.motionX = d2 / d4;
                        entity.motionZ = d3 / d4;
                    }
                }
            }
        }
    }
}
