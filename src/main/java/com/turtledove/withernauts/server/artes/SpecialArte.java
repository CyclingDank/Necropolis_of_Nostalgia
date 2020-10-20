package com.turtledove.withernauts.server.artes;

import com.turtledove.withernauts.server.core.NecropolisPlayerData;
import com.turtledove.withernauts.server.core.PlayerData;
import com.turtledove.withernauts.server.entity.items.EntityBook;
import com.turtledove.withernauts.server.item.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSword;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class SpecialArte implements ArteBase
{
    public EntityPlayer player;
    protected String arte_name;
    protected String arte_desc;
    public Entity target;
    private Vec3d targetPos;
    private Vec3d []targetPositions;
    private Vec3d knockDir;
    private int numTargets;
    private int actionLockTime;
    private int tp_cost;
    private int levelLearned;
    protected int weaponUsed;
    public boolean isBase;

    protected ArteUsage tUsage[];

    protected int num_stages;
    private int [] stages;

    public SpecialArte() {}

    public SpecialArte(Entity target, int [] t_s, int actionLockTime, Vec3d knockdir, int cost, int level)
    {
        this.player = null;
        this.levelLearned = level;
        this.weaponUsed = 1;
        this.isBase = true;
        this.tUsage = new ArteUsage[0];

        setTargetEntity(target);
        setActionLockTime(actionLockTime);
        setKnock(knockdir);
        setStages(t_s);
        setTPCost(cost);
    }
    public SpecialArte(Vec3d target, int [] t_s, int actionLockTime, Vec3d knockdir, int cost, int level)
    {
        this.player = null;
        this.target = null;
        this.levelLearned = level;
        this.weaponUsed = 1;
        this.isBase = true;
        this.tUsage = new ArteUsage[0];

        setTargetLocation(target);
        setActionLockTime(actionLockTime);
        setKnock(knockdir);
        setStages(t_s);
        setTPCost(cost);
    }
    public SpecialArte( List<Vec3d> positions, int [] t_s , int actionLockTime, Vec3d knockdir, int cost, int level)
    {
        this.player = null;
        this.target = null;
        this.levelLearned = level;
        this.weaponUsed = 1;
        this.isBase = true;
        this.tUsage = new ArteUsage[0];


        setTargetLocations(positions);
        setActionLockTime(actionLockTime);
        setKnock(knockdir);
        setStages(t_s);
        setTPCost(cost);
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

    public void spawnPlayerBook()
    {
        if (this.player.getHeldItemMainhand().getItem() instanceof ItemNecropolisTome)
        {
            String bookName = ((ItemNecropolisTome)((ItemNecropolisTome) this.player.getHeldItemMainhand().getItem())).getItemName();
            int bookID = 0;
            if (bookName.contains("psychedelia"))
                bookID = 0;
            else if (bookName.contains("grimoire"))
                bookID = 1;
            else if (bookName.contains("seraphim"))
                bookID = 2;
            else
                bookID = 3;
            spawnBookEntity(bookID);
        }
    }

    public void spawnBookEntity(int id)
    {
        EntityBook book = new EntityBook(this.player.world, this.player, this.getActionLockTime(), id);
        this.player.world.spawnEntity(book);
    }

    public float getAttackDamage(boolean isPhysical, float multiplier)
    {
        PlayerData playerDataSource = (PlayerData) NecropolisPlayerData.get(this.player);
        float sAtk;
        if (!isPhysical)
        {
            int attack_boost = playerDataSource.getStatBoost()[1];

            if (attack_boost > 0)
                sAtk = (playerDataSource.getPlayerStats()[1] + (playerDataSource.getPlayerStats()[1] * 0.25F )) * multiplier;
            else
                sAtk = playerDataSource.getPlayerStats()[1] * multiplier;

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
            sAtk = playerDataSource.getPlayerStats()[0] * multiplier;

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
