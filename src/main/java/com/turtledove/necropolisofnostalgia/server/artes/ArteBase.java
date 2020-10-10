package com.turtledove.necropolisofnostalgia.server.artes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;

import java.util.List;

/*
*  Artes do not contain any model information, they only contain attack and effect logic.
*
*/

public interface ArteBase
{
    public class ArteUsage
    {
        public int index;
        public int usage;
        public ArteUsage(int i, int u)
        {
            this.index = i;
            this.usage = u;
        }
    }
    public void setPlayer(EntityPlayer player);
    public void setTargetEntity(Entity entityIn);
    public void setTargetLocation(Vec3d pos);
    public void setTargetLocations(List<Vec3d>positions); //For artes with multiple targets, i.e. Aether Storm
    public void setActionLockTime(int time);    //Count of how long the player cannot swing or cast while this arte is active
    public void startAttack(int arte_stage);
    public void setKnock(Vec3d direction); //sets the knockback (or knock forward, sides, etc, depending) of the attack in question. Direction is in world space.
    public void setStages(int[] t_s);
    public void setTPCost(int c);
    public ArteUsage[] getUsageRequirements();
    public boolean isBase();
    public int getArteWeapon();
    public int getLevelLearned();
    public int getTPCost();
    public int[] getStages();
    public int getActionLockTime();
    public String getArteName();
    public String getArteDesc();
    public double lineIntersection(Vec3d planePoint, Vec3d planeNormal, Vec3d linePoint, Vec3d lineDirection);
    public Vec3d getHitboxBasis(EntityPlayer source, Vec3d target); //Gets the target position relative to the hitbox (at the player's head)
}
