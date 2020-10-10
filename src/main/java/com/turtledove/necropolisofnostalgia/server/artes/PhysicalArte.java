package com.turtledove.necropolisofnostalgia.server.artes;

import com.turtledove.necropolisofnostalgia.server.core.NecropolisPlayerData;
import com.turtledove.necropolisofnostalgia.server.core.PlayerData;
import com.turtledove.necropolisofnostalgia.server.item.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSword;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class PhysicalArte implements ArteBase
{
    public EntityPlayer player;
    protected String arte_name;
    protected String arte_desc;
    public Entity target;
    private Vec3d targetPos;
    private Vec3d []targetPositions;
    protected int weaponUsed;
    private Vec3d knockDir;
    private int numTargets;
    private int actionLockTime;
    private int tp_cost;
    protected int levelLearned;

    protected ArteUsage tUsage[];

    public boolean isBase;

    private int num_stages;
    private int [] stages;


    public PhysicalArte() {}
    public PhysicalArte(Entity target, int [] t_s, int actionLockTime, Vec3d knockdir, int cost)
    {
        this.player = null;
        this.weaponUsed = 0;
        this.levelLearned = 0;
        this.isBase = true;
        this.tUsage = new ArteUsage[0];
        setTargetEntity(target);
        setActionLockTime(actionLockTime);
        setKnock(knockdir);
        setStages(t_s);
        setTPCost(cost);
    }
    public PhysicalArte(Vec3d target, int [] t_s, int actionLockTime, Vec3d knockdir, int cost, int level)
    {
        this.player = null;
        this.weaponUsed = 0;
        this.target = null;
        this.levelLearned = level;
        this.isBase = true;
        this.tUsage = new ArteUsage[0];
        setTargetLocation(target);
        setActionLockTime(actionLockTime);
        setKnock(knockdir);
        setStages(t_s);
        setTPCost(cost);
    }
    public PhysicalArte( List<Vec3d> positions, int [] t_s , int actionLockTime, Vec3d knockdir, int cost, int level)
    {
        this.player = null;
        this.target = null;
        this.weaponUsed = 0;
        this.levelLearned = level;
        this.isBase = true;
        this.tUsage = new ArteUsage[0];
        setTargetLocations(positions);
        setActionLockTime(actionLockTime);
        setKnock(knockdir);
        setStages(t_s);
        setTPCost(cost);
    }
    public void setPlayer(EntityPlayer player)
    {
        this.player = player;
    }
    @Override
    public void startAttack(int arte_stage) {}
    public void setTargetEntity(Entity entityIn)
    {
        this.target = entityIn;
    }
    public void setTargetLocation(Vec3d pos)
    {
        this.targetPos = pos;
    }
    public void setTargetLocations(List<Vec3d> positions)
    {
        this.numTargets = positions.size();
        targetPositions = new Vec3d[numTargets];
        int i = 0;
        for (Vec3d pos : positions)
        {
            targetPositions[i] = pos;
            i++;
        }
    }
    public void setActionLockTime(int time)
    {
        this.actionLockTime = time;
    }
    public void setKnock(Vec3d direction)
    {
        this.knockDir = direction;
    }
    public void setStages(int[] t_s)
    {
        this.num_stages = t_s.length;
        this.stages = t_s;
    }
    public void setTPCost(int c)
    {
        this.tp_cost = c;
    }
    public void setArteWeapon(int val)
    {
        this.weaponUsed = val;
    }

    public ArteUsage[] getUsageRequirements()
    {
        return tUsage;
    }
    public boolean isBase()
    {
        return this.isBase;
    }

    public int getArteWeapon()
    {
        return this.weaponUsed;
    }
    public int getLevelLearned()
    {
        return this.levelLearned;
    }
    public int getAttackDamage(boolean isPhysical, float multiplier)
    {
        PlayerData playerDataSource = (PlayerData) NecropolisPlayerData.get(this.player);
        int sAtk;
        if (!isPhysical)
        {
            sAtk = playerDataSource.getPlayerStats()[1] * (int) multiplier;
            if (this.player.getHeldItemMainhand().getItem() instanceof ItemNecropolisWeapon)
            {
                ItemNecropolisWeapon necropolisWeapon = (ItemNecropolisWeapon)this.player.getHeldItemMainhand().getItem();
                sAtk += necropolisWeapon.getAttack(true);
            }
            else if (this.player.getHeldItemMainhand().getItem() instanceof ItemDiamondRapier ||
                    this.player.getHeldItemMainhand().getItem() instanceof ItemIronRapier ||
                    this.player.getHeldItemMainhand().getItem() instanceof ItemGoldRapier ||
                    this.player.getHeldItemMainhand().getItem() instanceof ItemStoneRapier ||
                    this.player.getHeldItemMainhand().getItem() instanceof ItemWoodenRapier)
            {
                sAtk += ((ItemSword) this.player.getHeldItemMainhand().getItem()).getAttackDamage() + 2.0f;
            }
        }
        else
        {
            sAtk = playerDataSource.getPlayerStats()[0] * (int) multiplier;

            if (this.player.getHeldItemMainhand().getItem() instanceof ItemDiamondRapier ||
                    this.player.getHeldItemMainhand().getItem() instanceof ItemIronRapier ||
                    this.player.getHeldItemMainhand().getItem() instanceof ItemGoldRapier ||
                    this.player.getHeldItemMainhand().getItem() instanceof ItemStoneRapier ||
                    this.player.getHeldItemMainhand().getItem() instanceof ItemWoodenRapier)
            {
                sAtk += ((ItemSword) this.player.getHeldItemMainhand().getItem()).getAttackDamage() + 1.0f;
            }
            else if (this.player.getHeldItemMainhand().getItem() instanceof ItemNecropolisWeapon)
            {
                ItemNecropolisWeapon necropolisWeapon = (ItemNecropolisWeapon)this.player.getHeldItemMainhand().getItem();
                sAtk += necropolisWeapon.getAttack(false);
            }
            else
            {
                sAtk += ((ItemSword) this.player.getHeldItemMainhand().getItem()).getAttackDamage() + 3.0f;
            }

        }

        return sAtk;
    }

    public int getTPCost()
    {
        return this.tp_cost;
    }
    public int[] getStages()
    {
        return this.stages;
    }
    public int getActionLockTime()
    {
        return this.actionLockTime;
    }
    public double lineIntersection(Vec3d planePoint, Vec3d planeNormal, Vec3d linePoint, Vec3d lineDirection)
    {
        double t = (planeNormal.dotProduct(planePoint) - planeNormal.dotProduct(linePoint)) / planeNormal.dotProduct(lineDirection);
        return t;
    }
    public Vec3d getHitboxBasis(EntityPlayer source, Vec3d target)
    {
        Vec3d player_localSpace_translated = new Vec3d(target.x - source.posX, target.y - (source.posY + 1.6),  target.z - source.posZ);
        float draco_angle = source.rotationYaw * 0.0174533F;
        float t_sin = MathHelper.sin(draco_angle);
        float t_cos = MathHelper.cos(draco_angle);
        Vec3d player_localSpace_rotatedYaw = new Vec3d(player_localSpace_translated.x * t_cos + player_localSpace_translated.z * t_sin, player_localSpace_translated.y,-player_localSpace_translated.x * t_sin + player_localSpace_translated.z * t_cos);
        draco_angle = -source.rotationPitch * 0.0174533F;
        t_sin = MathHelper.sin(draco_angle);
        t_cos = MathHelper.cos(draco_angle);
        Vec3d player_localSpace_rotatedPitch = new Vec3d(player_localSpace_rotatedYaw.x, t_cos * player_localSpace_rotatedYaw.y + -player_localSpace_rotatedYaw.z * t_sin, player_localSpace_rotatedYaw.y * t_sin + t_cos * player_localSpace_rotatedYaw.z);
        return player_localSpace_rotatedPitch;
    }
    public String getArteName()
    {
        return this.arte_name;
    }
    public String getArteDesc() {return this.arte_desc;}
}
