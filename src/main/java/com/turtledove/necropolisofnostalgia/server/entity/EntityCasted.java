package com.turtledove.necropolisofnostalgia.server.entity;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

import java.util.List;

public class EntityCasted extends NecropolisEntity
{
    public EntityLivingBase caster;
    private static final DataParameter<Integer> CASTER = EntityDataManager.createKey(EntityCasted.class, DataSerializers.VARINT);

    public static final Animation OPEN_ANIMATION = Animation.create(120);
    private static final Animation[] ANIMATIONS = {OPEN_ANIMATION};

    protected int arte_element;    //0 is neutral, 1 is fire, 2 is water, 3 is earth, 4 is poison, 5 is lightning, 6 is darkness, 7 is light



    public EntityCasted(World worldIn)
    {
        super(worldIn);
    }
    public EntityCasted(World worldIn, EntityPlayer player)
    {
        super(worldIn);
        this.setCasterID(player.getEntityId());
        this.caster = (EntityLivingBase) world.getEntityByID(getCasterID());
        this.arte_element = 0;
    }

    public EntityCasted(World worldIn, NecropolisEntity monster)
    {
        super(worldIn);
        this.setCasterID(monster.getEntityId());
        this.caster = (EntityLivingBase) world.getEntityByID(getCasterID());
        this.arte_element = 0;
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        getDataManager().register(CASTER, -1);
    }

    public int getArte_element()
    {
        return this.arte_element;
    }

    public int getCasterID() {
        return getDataManager().get(CASTER);
    }

    public void setCasterID(int id) {
        getDataManager().set(CASTER, id);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        if (this.ticksExisted == 1)
            this.caster = (EntityLivingBase) world.getEntityByID(getCasterID());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {

    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {

    }

    @Override
    public Animation[] getAnimations()
    {
        return ANIMATIONS;
    }

    public List<EntityLivingBase> getEntityLivingBaseNearby(double radius)
    {
        return getEntitiesNearby(EntityLivingBase.class, radius);
    }

    public <T extends Entity> List<T> getEntitiesNearby(Class<T> entityClass, double r) {
        return world.getEntitiesWithinAABB(entityClass, getEntityBoundingBox().grow(r, r, r), e -> e != this && getDistance(e) <= r);
    }

    public <T extends Entity> List<T> getEntitiesNearbyCube(Class<T> entityClass, double r) {
        return world.getEntitiesWithinAABB(entityClass, getEntityBoundingBox().grow(r, r, r), e -> e != this);
    }
}
