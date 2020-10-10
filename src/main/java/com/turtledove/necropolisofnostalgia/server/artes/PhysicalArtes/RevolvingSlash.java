package com.turtledove.necropolisofnostalgia.server.artes.PhysicalArtes;

import com.turtledove.necropolisofnostalgia.server.artes.PhysicalArte;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class RevolvingSlash extends PhysicalArte {
    public RevolvingSlash()
    {
        super(new Vec3d(0.0D,0.0D,0.0D), new int[]{30, 6}, 36,new Vec3d(0.0D,0.0D,0.0D),20, 0);
        this.arte_name = "Revolving Slash";
        this.arte_desc = "Altered Arte: Attack enemies in all directions.";
        this.isBase = false;
        this.tUsage = new ArteUsage[1];
        this.tUsage[0] = new ArteUsage(1, 100);
    }
    @Override
    public void startAttack(int arte_stage)
    {
        if (arte_stage == 1)
        {
            List<Entity> swipeEnemies = this.player.world.getEntitiesWithinAABBExcludingEntity(player,  player.getEntityBoundingBox().expand(3.0,1.0,3.0).offset(-1.5,0.0,-1.5));
            if (!swipeEnemies.isEmpty())
            {
                ItemSword item = (ItemSword)this.player.getHeldItemMainhand().getItem();
                double num_in_range = 0.0;
                for (Entity entity : swipeEnemies)
                {
                    num_in_range++;
                }
                for (Entity entity : swipeEnemies)
                {
                    entity.attackEntityFrom(DamageSource.causeMobDamage(player),1.5F);
                }
            }
        }
    }
}
