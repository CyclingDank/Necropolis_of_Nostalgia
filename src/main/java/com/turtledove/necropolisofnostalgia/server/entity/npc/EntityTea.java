package com.turtledove.necropolisofnostalgia.server.entity.npc;

import com.turtledove.necropolisofnostalgia.server.ai.EntityAIDoFarming;
import com.turtledove.necropolisofnostalgia.server.ai.EntityAIDoRiceFarming;
import com.turtledove.necropolisofnostalgia.server.ai.EntityAIDoVillageTasks;
import com.turtledove.necropolisofnostalgia.server.ai.EntityAIHeadToVillage;
import com.turtledove.necropolisofnostalgia.server.entity.NecropolisNPC;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityTea extends NecropolisNPC
{
    private static final Animation[] ANIMATIONS = {};
    public EntityTea(World worldin)
    {
        super(worldin);
        setPathPriority(PathNodeType.DOOR_WOOD_CLOSED, 0);

        this.isWild = true;

        this.primaryQuestID[0] = 2;
        this.primaryQuestID[1] = 3;
        this.secondaryQuestID = null;

        this.homeID = 2;
        this.needsHome = true;
        this.hasHome = false;

        this.workID = 3;
        this.needsWork = true;
        this.hasWork = false;

        this.jobID = 1;
    }
    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(3, new EntityAITempt(this, 0.1875, false, TEMPTATION_ITEMS));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 0.6D));
        this.tasks.addTask(5, new EntityAIDoRiceFarming(this, 0.1875, false));
        this.tasks.addTask(6, new EntityAIDoVillageTasks(this, 0.1875, false));
        this.tasks.addTask(7, new EntityAIHeadToVillage(this, 0.1875, false));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0);
    }

    protected void entityInit()
    {
        super.entityInit();
    }
    @Override
    public void onUpdate()
    {
        super.onUpdate();
    }

    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        return false;
    }

    @Override
    public Animation[] getAnimations()
    {
        return ANIMATIONS;
    }
}
