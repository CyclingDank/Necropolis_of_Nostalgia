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

public class LanceRain extends PhysicalArte
{
    public LanceRain()
    {
        super(new Vec3d(0.0D,0.0D,0.0D),new int[]{3,3,3,3,3},15,new Vec3d(0.0D,0.0D,0.0D),40, 5);
        this.arte_name = "Lance Rain";
        this.arte_desc = "Base Arte: A quick flurry of spear thrusts.";

        this.setArteWeapon(3);
    }
    @Override
    public void startAttack(int arte_stage)
    {
        List<Entity> swipeEnemies = this.player.world.getEntitiesWithinAABBExcludingEntity(player,  player.getEntityBoundingBox().expand(5.0,5.0,5.0).offset(-2.5,0.0,-2.5));
        if (!swipeEnemies.isEmpty())
        {
            ItemSword item = (ItemSword)this.player.getHeldItemMainhand().getItem();
            for (Entity entity : swipeEnemies)
            {
                if (entityInSlash(player, entity) == true)
                {
                    entity.attackEntityFrom(DamageSource.causeMobDamage(player),1.0F);
                }
            }
        }
    }
    public boolean entityInSlash(EntityPlayer source, Entity target)
    {
        Vec3d l0 = getHitboxBasis(source, target.getPositionVector());
        Vec3d l1 = getHitboxBasis(source, new Vec3d(target.posX, target.posY + target.height, target.posZ));

        Vec3d AB = l1.subtract(l0).normalize();

        Vec3d Q = new Vec3d(1.5,-0.5,0.0);
        Vec3d P = new Vec3d(1.5,-0.5,3.1);
        Vec3d R = new Vec3d(-1.5,-0.5,3.1);

        Vec3d PQ = Q.subtract(P);
        Vec3d PR = R.subtract(P);
        Vec3d N = PQ.crossProduct(PR).normalize();

        if (N.dotProduct(AB) != 0.0)
        {
            double t = lineIntersection(P,N,l0,AB);
            if (t >= 0.0 && t <= 1)
            {
                Vec3d intersectPoint = l0.add(AB.normalize().scale(t));
                if ((intersectPoint.x >= -1.5 && intersectPoint.x <= 1.5 ) && (intersectPoint.z >= 0.0 && intersectPoint.z <= 3.1))
                    return true;
            }
        }

        Q = new Vec3d(1.5,0.5,0.0);
        P = new Vec3d(1.5,0.5,3.1);
        R = new Vec3d(-1.5,0.5,3.1);

        PQ = Q.subtract(P);
        PR = R.subtract(P);
        N = PQ.crossProduct(PR).normalize();

        if (N.dotProduct(AB) != 0.0)
        {
            double t = lineIntersection(P,N,l0,AB);
            if (t >= 0.0 && t <= 1)
            {
                Vec3d intersectPoint = l0.add(AB.normalize().scale(t));
                if ((intersectPoint.x >= -1.5 && intersectPoint.x <= 1.5 ) && (intersectPoint.z >= 0.0 && intersectPoint.z <= 3.1))
                    return true;
            }
        }

        //checking if the segment is inside the rectangle
        if ((l0.x >= -1.5 && l0.x <= 1.5 ) && (l0.z >= 0.0 && l0.z <= 3.1) && (l0.y >= -0.5 && l0.y <= 0.5))
            return true;
        if ((l1.x >= -1.5 && l1.x <= 1.5 ) && (l1.z >= 0.0 && l1.z <= 3.1) && (l1.y >= -0.5 && l1.y <= 0.5))
            return true;
        return false;
    }
}