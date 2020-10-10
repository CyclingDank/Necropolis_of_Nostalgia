package com.turtledove.necropolisofnostalgia.server.artes.PhysicalArtes;

import com.turtledove.necropolisofnostalgia.server.artes.PhysicalArte;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class MetalSwarm extends PhysicalArte
{
    public MetalSwarm()
    {
        super(new Vec3d(0.0D,0.0D,0.0D),new int[]{6,6,6,6},24,new Vec3d(0.0D,0.0D,0.0D),16, 5);
        this.arte_name = "Metal Swarm";
        this.arte_desc = "Base Arte: A furious flurry of metal.";
    }
    @Override
    public void startAttack(int arte_stage)
    {
        List<Entity> swipeEnemies = this.player.world.getEntitiesWithinAABBExcludingEntity(player,  player.getEntityBoundingBox().expand(5.0,5.0,5.0).offset(-2.5,0.0,-2.5));
        if (!swipeEnemies.isEmpty())
        {
            for (Entity entity : swipeEnemies)
            {
                if (entityInSlash(player, entity) == true)
                {
                    entity.attackEntityFrom(DamageSource.causeMobDamage(player),1.5F);
                    double d2 = entity.posX - this.player.posX;
                    double d3 = entity.posZ - this.player.posZ;
                    double d4 = d2 * d2 + d3 * d3;
                }
            }
        }
        Vec3d forDir = player.getForward();
        //Necropolis_of_Nostalgia.packetHandler.sendTo(new SyncPlayer(forDir.x  * 0.25D, 0.0D, forDir.z * 0.25D),(EntityPlayerMP)this.player);
    }
    public boolean entityInSlash(EntityPlayer source, Entity target)
    {
        Vec3d l0 = getHitboxBasis(source, target.getPositionVector());
        Vec3d l1 = getHitboxBasis(source, new Vec3d(target.posX, target.posY + target.height, target.posZ));

        Vec3d AB = l1.subtract(l0).normalize();

        Vec3d Q = new Vec3d(0.5,-0.5,0.0);
        Vec3d P = new Vec3d(0.5,-0.5,1.75);
        Vec3d R = new Vec3d(-0.5,-0.5,1.75);

        Vec3d PQ = Q.subtract(P);
        Vec3d PR = R.subtract(P);
        Vec3d N = PQ.crossProduct(PR).normalize();

        if (N.dotProduct(AB) != 0.0)
        {
            double t = lineIntersection(P,N,l0,AB);
            if (t >= 0.0 && t <= 1)
            {
                Vec3d intersectPoint = l0.add(AB.normalize().scale(t));
                if ((intersectPoint.x >= -0.5 && intersectPoint.x <= 0.5 ) && (intersectPoint.z >= 0.0 && intersectPoint.z <= 1.75))
                    return true;
            }
        }

        Q = new Vec3d(0.5,0.5,0.0);
        P = new Vec3d(0.5,0.5,1.75);
        R = new Vec3d(-0.5,0.5,1.75);

        PQ = Q.subtract(P);
        PR = R.subtract(P);
        N = PQ.crossProduct(PR).normalize();

        if (N.dotProduct(AB) != 0.0)
        {
            double t = lineIntersection(P,N,l0,AB);
            if (t >= 0.0 && t <= 1)
            {
                Vec3d intersectPoint = l0.add(AB.normalize().scale(t));
                if ((intersectPoint.x >= -0.5 && intersectPoint.x <= 0.5 ) && (intersectPoint.z >= 0.0 && intersectPoint.z <= 1.75))
                    return true;
            }
        }

        //checking if the segment is inside the rectangle
        if ((l0.x >= -0.5 && l0.x <= 0.5 ) && (l0.z >= 0.0 && l0.z <= 1.75) && (l0.y >= -0.5 && l0.y <= 0.5))
            return true;
        if ((l1.x >= -0.5 && l1.x <= 0.5 ) && (l1.z >= 0.0 && l1.z <= 1.75) && (l1.y >= -0.5 && l1.y <= 0.5))
            return true;

        return false;
    }
}
