package com.turtledove.necropolisofnostalgia.entity;

import com.google.common.primitives.Ints;
import com.turtledove.necropolisofnostalgia.ai.AnimationAI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;


public abstract class NecropolisEntity extends EntityCreature implements IAnimatedEntity {
    private static final byte START_IA_HEALTH_UPDATE_ID = 4;

    private static final DataParameter<Boolean> ISRAIDER = EntityDataManager.<Boolean>createKey(NecropolisEntity.class, DataSerializers.BOOLEAN);


    public int frame;
    public float targetDistance;
    public float targetAngle;
    private int animationTick;

    protected boolean prevOnGround;
    protected boolean prevPrevOnGround;
    protected boolean willLandSoon;

    private Animation animation = NO_ANIMATION;

    protected int[] elementWeakness = new int[8];
    // 0 is neutral, 1 is fire, 2 is water, 3 is earth, 4 is poison, 5 is lightning, 6 is darkness, 7 is light. -1 is resist, 0 is neutral, 1 is weakness
    public AnimationAI currentAnim = null;

    protected int[] dimensions;
    protected float height_max;
    protected float height_min;
    protected boolean needsDarkness;
    protected boolean needsSeeSky;
    protected String[] allowed_blocks;
    protected boolean isBoss;

    public boolean active;
    public boolean hitbyarrow;
    public boolean struckwhileGuarding;
    protected int defense;
    protected int sDefense;

    protected boolean isRaidMob;

    public Entity targetofmyrevenge;

    public NecropolisEntity(World world)
    {
        super(world);
        this.hitbyarrow = false;
        this.targetofmyrevenge = null;
        this.struckwhileGuarding = false;
        this.defense = 0;
        this.sDefense = 0;
        this.isBoss = false;
        this.isRaidMob = false;
        for (int i = 0; i < 8; i++)
            this.elementWeakness[i] = 0;
        setFoeType(0);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(ISRAIDER,Boolean.valueOf(false));
    }

    public void setFoeType(int type)
    {
        switch(type)
        {
            case 0: //SURFACE. OVERWORLD ONLY.
                this.dimensions = new int[1];
                this.dimensions[0] = 0;
                this.height_max = 256;
                this.height_min = 40;
                this.needsDarkness = false;
                this.needsSeeSky = false;
                this.allowed_blocks = new String[] {"grass", "stone", "sand"};
                break;
            case 1: //UNDERGROUND. OVERWORLD ONLY.
                this.dimensions = new int[1];
                this.dimensions[0] = 0;
                this.height_max = 40;
                this.height_min = 22;
                this.needsDarkness = true;
                this.needsSeeSky = false;
                this.allowed_blocks = new String[] {"grass", "stone", "sand"};
            case 2: //BEDROCK. OVERWORLD ONLY.
                this.dimensions = new int[1];
                this.dimensions[0] = 0;
                this.height_max = 22;
                this.height_min = 1;
                this.needsDarkness = true;
                this.needsSeeSky = false;
                this.allowed_blocks = new String[] {"stone"};
        }
    }

    @Override
    public boolean getCanSpawnHere()
    {
        if (isBoss == true)
            return false;
        int i = MathHelper.floor(this.posX);
        int j = MathHelper.floor(this.getEntityBoundingBox().minY);
        int k = MathHelper.floor(this.posZ);
        BlockPos pos = new BlockPos(i, j, k);

        // Dimension check
        List<Integer> dimensionIDs = Ints.asList(dimensions);
        if (!dimensionIDs.contains(world.provider.getDimension())) {
            return false;
        }
        // Height check
        float heightMax = height_max;
        float heightMin = height_min;
        if (posY > heightMax && heightMax >= 0) {
            return false;
        }
        if (posY < heightMin) {
            return false;
        }

        // Light level check
        if (needsDarkness && !isValidLightLevel())
        {
            return false;
        }
        // Block check
        ResourceLocation blockName = world.getBlockState(pos.down()).getBlock().getRegistryName();
        List<String> allowedBlocks = Arrays.asList(allowed_blocks);
        if (blockName == null) return false;

        // See sky
        if (needsSeeSky && !world.canSeeSky(pos))
        {
            return false;
        }
        if (!needsSeeSky && world.canSeeSky(pos)) {
            return false;
        }
        return true;
    }
    protected boolean isValidLightLevel()
    {
        BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

        if (this.world.getLightFor(EnumSkyBlock.SKY, blockpos) > this.rand.nextInt(32))
        {
            return false;
        }
        else
        {
            int i = this.world.getLightFromNeighbors(blockpos);

            if (this.world.isThundering())
            {
                int j = this.world.getSkylightSubtracted();
                this.world.setSkylightSubtracted(10);
                i = this.world.getLightFromNeighbors(blockpos);
                this.world.setSkylightSubtracted(j);
            }

            return i <= this.rand.nextInt(8);
        }
    }

    public int getElementResponse(int i)
    {
        return this.elementWeakness[i];
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        String id = getPickedEntityId();
        if (id == null) {
            return ItemStack.EMPTY;
        }
        return ItemStack.EMPTY;
    }

    protected String getPickedEntityId() {
        return getEntityString();
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
    }

    public int getDef()
    {
        return this.defense;
    }
    public int getSDef()
    {
        return this.sDefense;
    }

    @Override
    public void onUpdate()
    {
        prevPrevOnGround = prevOnGround;
        prevOnGround = onGround;
        super.onUpdate();
        frame++;
        if (getAnimation() != NO_ANIMATION)
        {
            animationTick++;
            if (world.isRemote && animationTick >= animation.getDuration()) {
                setAnimation(NO_ANIMATION);
            }
        }
        if (getAttackTarget() != null)
        {
            targetDistance = getDistance(getAttackTarget());
            targetAngle = (float) getAngleBetweenEntities(this, getAttackTarget());
        }
        willLandSoon = !onGround && world.collidesWithAnyBlock(getEntityBoundingBox().offset(new Vec3d(motionX, motionY, motionZ)));

        if (this.world.isRemote && (Boolean)this.dataManager.get(ISRAIDER).booleanValue() == true && this.ticksExisted % 30 == 0)
        {
            this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY + this.height + 1.0, this.posZ, 0.0, 0.0, 0.0);
        }
    }

    public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        float f = (float)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
        int i = 0;

        if (entityIn instanceof EntityLivingBase)
        {
            f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((EntityLivingBase)entityIn).getCreatureAttribute());
            i += EnchantmentHelper.getKnockbackModifier(this);
        }

        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);

        if (flag)
        {
            if (i > 0 && entityIn instanceof EntityLivingBase)
            {
                ((EntityLivingBase)entityIn).knockBack(this, (float)i * 0.5F, (double) MathHelper.sin(this.rotationYaw * 0.017453292F), (double)(-MathHelper.cos(this.rotationYaw * 0.017453292F)));
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }

            int j = EnchantmentHelper.getFireAspectModifier(this);

            if (j > 0)
            {
                entityIn.setFire(j * 4);
            }

            if (entityIn instanceof EntityPlayer)
            {
                EntityPlayer entityplayer = (EntityPlayer)entityIn;
                ItemStack itemstack = this.getHeldItemMainhand();
                ItemStack itemstack1 = entityplayer.isHandActive() ? entityplayer.getActiveItemStack() : ItemStack.EMPTY;

                if (!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.getItem() instanceof ItemAxe && itemstack1.getItem() == Items.SHIELD)
                {
                    float f1 = 0.25F + (float)EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;

                    if (this.rand.nextFloat() < f1)
                    {
                        entityplayer.getCooldownTracker().setCooldown(Items.SHIELD, 100);
                        this.world.setEntityState(entityplayer, (byte)30);
                    }
                }
            }

            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }

    public Vec3d worldToThisEntity(Entity entityIn)
    {
        Vec3d player_dracoSpace_translated = new Vec3d(entityIn.posX - this.posX,entityIn.posY - this.posY,entityIn.posZ - this.posZ);
        float draco_angle = this.rotationYaw * 0.0174533F;
        float t_sin = MathHelper.sin(draco_angle);
        float t_cos = MathHelper.cos(draco_angle);
        Vec3d player_dracoSpace_rotated = new Vec3d(player_dracoSpace_translated.x * t_cos + player_dracoSpace_translated.z * t_sin, player_dracoSpace_translated.y,-player_dracoSpace_translated.x * t_sin + player_dracoSpace_translated.z * t_cos);
        return player_dracoSpace_rotated;
    }

    public double getAngleBetweenEntities(Entity first, Entity second) {
        return Math.atan2(second.posZ - first.posZ, second.posX - first.posX) * (180 / Math.PI) + 90;
    }

    public List<EntityPlayer> getPlayersNearby(double distanceX, double distanceY, double distanceZ, double radius) {
        List<Entity> nearbyEntities = world.getEntitiesWithinAABBExcludingEntity(this, getEntityBoundingBox().grow(distanceX, distanceY, distanceZ));
        List<EntityPlayer> listEntityPlayers = nearbyEntities.stream().filter(entityNeighbor -> entityNeighbor instanceof EntityPlayer && getDistance(entityNeighbor) <= radius).map(entityNeighbor -> (EntityPlayer) entityNeighbor).collect(Collectors.toList());
        return listEntityPlayers;
    }

    public List<EntityLivingBase> getAttackableEntityLivingBaseNearby(double distanceX, double distanceY, double distanceZ, double radius) {
        List<Entity> nearbyEntities = world.getEntitiesWithinAABBExcludingEntity(this, getEntityBoundingBox().grow(distanceX, distanceY, distanceZ));
        List<EntityLivingBase> listEntityLivingBase = nearbyEntities.stream().filter(entityNeighbor -> entityNeighbor instanceof EntityLivingBase && ((EntityLivingBase)entityNeighbor).attackable() && (!(entityNeighbor instanceof EntityPlayer) || !((EntityPlayer)entityNeighbor).isCreative()) && getDistance(entityNeighbor) <= radius).map(entityNeighbor -> (EntityLivingBase) entityNeighbor).collect(Collectors.toList());
        return listEntityLivingBase;
    }

    public  List<EntityLivingBase> getEntityLivingBaseNearby(double distanceX, double distanceY, double distanceZ, double radius) {
        return getEntitiesNearby(EntityLivingBase.class, distanceX, distanceY, distanceZ, radius);
    }

    public <T extends Entity> List<T> getEntitiesNearby(Class<T> entityClass, double r) {
        return world.getEntitiesWithinAABB(entityClass, getEntityBoundingBox().grow(r, r, r), e -> e != this && getDistance(e) <= r);
    }

    public <T extends Entity> List<T> getEntitiesNearby(Class<T> entityClass, double dX, double dY, double dZ, double r) {
        return world.getEntitiesWithinAABB(entityClass, getEntityBoundingBox().grow(dX, dY, dZ), e -> e != this && getDistance(e) <= r && e.posY <= posY + dY);
    }

    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
        if (getHealth() <= 0.0F) {
            onDeathUpdate(20);
        }
    }

    private void onDeathUpdate(int deathDuration) {
        onDeathAIUpdate();
        if (++deathTime >= deathDuration) {
            boolean isPlayerKill = recentlyHit > 0;
            if (!world.isRemote && isPlayerKill && canDropLoot() && world.getGameRules().getBoolean("doMobLoot")) {
                for (int remaining = getExperiencePoints(attackingPlayer), value; remaining > 0; remaining -= value) {
                    world.spawnEntity(new EntityXPOrb(world, posX, posY, posZ, value = EntityXPOrb.getXPSplit(remaining)));
                }
            }

            if (!world.isRemote && world.getGameRules().getBoolean("doMobLoot")) {
                dropLoot();
            }

            setDead();
            for (int n = 0; n < 20; n++) {
                double d2 = rand.nextGaussian() * 0.02D;
                double d0 = rand.nextGaussian() * 0.02D;
                double d1 = rand.nextGaussian() * 0.02D;
                world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, posX + (double) (rand.nextFloat() * width * 2.0F) - (double) width, posY + (double) (rand.nextFloat() * height), posZ + (double) (rand.nextFloat() * width * 2.0F) - (double) width, d2, d0, d1);
            }
        }
    }

    protected void onDeathAIUpdate() {}

    @Override
    protected final void onDeathUpdate()
    {this.setDead();}

    @Override
    protected final void dropLoot(boolean isPlayerKill, int lootingModifier, DamageSource source) {}

    @Override
    protected final void dropFewItems(boolean isPlayerKill, int lootingModifier) {}

    protected void dropExperience(int p_184668_1_)
    {
        while (p_184668_1_ > 0)
        {
            int i = EntityXPOrb.getXPSplit(p_184668_1_);
            p_184668_1_ -= i;
            this.world.spawnEntity(new EntityXPOrb(this.world, this.posX, this.posY, this.posZ, i));
        }
    }

    @Override
    protected final void dropEquipment(boolean isPlayerKill, int lootingModifier) {}

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        return super.attackEntityFrom(source, damage);
    }

    @Override
    protected boolean canDespawn()
    {
        if (this.isRaidMob == true)
            return false;
        return true;
    }

    @Override
    public void handleStatusUpdate(byte id) {
        super.handleStatusUpdate(id);
    }

    protected void dropLoot() {

    }
    protected void onAnimationFinish(Animation animation) {}
    @Override
    public Animation getAnimation() {
        return this.animation;
    }
    @Override
    public int getAnimationTick() {
        return this.animationTick;
    }
    @Override
    public void setAnimationTick(int tick) {
        this.animationTick = tick;
    }
    @Override
    public void setAnimation(Animation animation) {
        if (animation == NO_ANIMATION) {
            onAnimationFinish(this.animation);
        }
        this.animation = animation;
        setAnimationTick(0);
    }

    public void setRaider()
    {
        this.isRaidMob = true;
        this.dataManager.set(ISRAIDER, Boolean.valueOf(true));
    }

    public boolean isRaider()
    {
        return this.isRaidMob;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setBoolean("is_raider", this.isRaidMob);
    }
    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.isRaidMob = compound.getBoolean("is_raider");
        this.dataManager.set(ISRAIDER, Boolean.valueOf(isRaidMob));
    }
}