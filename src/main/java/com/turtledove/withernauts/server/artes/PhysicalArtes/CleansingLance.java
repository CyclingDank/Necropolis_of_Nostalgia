package com.turtledove.withernauts.server.artes.PhysicalArtes;

import com.turtledove.withernauts.Necropolis_of_Nostalgia;
import com.turtledove.withernauts.server.artes.PhysicalArte;
import com.turtledove.withernauts.server.packets.Player.SyncPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class CleansingLance  extends PhysicalArte
{
    public CleansingLance()
    {
        super(new Vec3d(0.0D,0.0D,0.0D),new int[]{10},10,new Vec3d(0.0D,0.0D,0.0D),25, 0);
        this.arte_name = "Cleansing Lance";
        this.arte_desc = "Base Arte: A far reaching jab.";

        this.setArteWeapon(3);
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
                    entity.attackEntityFrom(DamageSource.causeMobDamage(player),1.0F);
                    double d2 =   entity.posX - this.player.posX;
                    double d3 =   entity.posZ - this.player.posZ;
                    double d4 = 8.0D;

                    double d5 = 0.0D;

                    if (entity.onGround == false)
                    {
                        d4 = 16.0D;
                        d5 = 0.4;
                        if (this.player.onGround == false)
                            Necropolis_of_Nostalgia.packetHandler.sendTo(new SyncPlayer(entity.motionX, d5, entity.motionZ),(EntityPlayerMP)this.player);
                    }

                    if (entity instanceof EntityPlayer)
                    {
                        Necropolis_of_Nostalgia.packetHandler.sendTo(new SyncPlayer(d2 / d4, d5,  d3 / d4),(EntityPlayerMP)entity);
                    }
                    else
                    {
                        entity.motionX = d2 / d4;
                        entity.motionZ = d3 / d4;
                        entity.motionY = d5;
                    }
                }
            }
        }
    }
    public boolean entityInSlash(EntityPlayer source, Entity target)
    {
        Vec3d l0 = getHitboxBasis(source, target.getPositionVector());
        Vec3d l1 = getHitboxBasis(source, new Vec3d(target.posX, target.posY + target.height, target.posZ));

        Vec3d AB = l1.subtract(l0).normalize();

        Vec3d Q = new Vec3d(0.5,-0.5,0.0);
        Vec3d P = new Vec3d(0.5,-0.5,4.5);
        Vec3d R = new Vec3d(-0.5,-0.5,4.5);

        Vec3d PQ = Q.subtract(P);
        Vec3d PR = R.subtract(P);
        Vec3d N = PQ.crossProduct(PR).normalize();

        if (N.dotProduct(AB) != 0.0)
        {
            double t = lineIntersection(P,N,l0,AB);
            if (t >= 0.0 && t <= 1)
            {
                Vec3d intersectPoint = l0.add(AB.normalize().scale(t));
                if ((intersectPoint.x >= -0.5 && intersectPoint.x <= 0.5 ) && (intersectPoint.z >= 0.0 && intersectPoint.z <= 4.5))
                    return true;
            }
        }

        Q = new Vec3d(0.5,0.5,0.0);
        P = new Vec3d(0.5,0.5,4.5);
        R = new Vec3d(-0.5,0.5,4.5);

        PQ = Q.subtract(P);
        PR = R.subtract(P);
        N = PQ.crossProduct(PR).normalize();

        if (N.dotProduct(AB) != 0.0)
        {
            double t = lineIntersection(P,N,l0,AB);
            if (t >= 0.0 && t <= 1)
            {
                Vec3d intersectPoint = l0.add(AB.normalize().scale(t));
                if ((intersectPoint.x >= -0.5 && intersectPoint.x <= 0.5 ) && (intersectPoint.z >= 0.0 && intersectPoint.z <= 4.51))
                    return true;
            }
        }

        //checking if the segment is inside the rectangle
        if ((l0.x >= -0.5 && l0.x <= 0.5 ) && (l0.z >= 0.0 && l0.z <= 4.5) && (l0.y >= -0.5 && l0.y <= 0.5))
            return true;
        if ((l1.x >= -0.5 && l1.x <= 0.5 ) && (l1.z >= 0.0 && l1.z <= 4.5) && (l1.y >= -0.5 && l1.y <= 0.5))
            return true;

        return false;
    }
}
