package com.turtledove.necropolisofnostalgia.server.entity;

import com.google.common.collect.Sets;
import com.turtledove.necropolisofnostalgia.server.ai.AnimationAI;
import com.turtledove.necropolisofnostalgia.server.ai.EntityAIDoVillageTasks;
import com.turtledove.necropolisofnostalgia.server.core.NecropolisPlayerData;
import com.turtledove.necropolisofnostalgia.server.core.PlayerData;
import com.turtledove.necropolisofnostalgia.server.item.ItemRiceSeed;
import com.turtledove.necropolisofnostalgia.server.tiles.TileEntityBarrierBlastia;
import com.turtledove.necropolisofnostalgia.server.tiles.TileEntityBlueprint;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class NecropolisNPC extends EntityCreature implements IAnimatedEntity
{
    private static final byte START_IA_HEALTH_UPDATE_ID = 4;

    protected static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(Items.BANNER);


    public int frame;
    public float targetDistance;
    public float targetAngle;
    private int animationTick;

    protected boolean prevOnGround;
    protected boolean prevPrevOnGround;
    protected boolean willLandSoon;

    //Quest related data

    protected int[] primaryQuestID = new int[2];
    protected int[] secondaryQuestID = new int[2];

    protected boolean isWild; //whether NPC has been recruited yet

    protected int homeID;   //the ID of the blueprint block stored in the blastia tile entity
    protected boolean needsHome;
    protected boolean hasHome;

    protected int workID;
    protected boolean needsWork;
    protected boolean hasWork;

    //related to inventory
    protected NonNullList<ItemStack> npcItemStacks = NonNullList.withSize(36, ItemStack.EMPTY);

    //related to farming
    protected int jobID;    //-1 is no specific job, 0 is farmer, 1 is rice farmer

    private Animation animation = NO_ANIMATION;

    public AnimationAI currentAnim = null;

    public NecropolisNPC(World world)
    {
        super(world);
        this.setSize(0.6F, 1.95F);

        this.isImmuneToFire = true;

        this.primaryQuestID[0] = 0;
        this.primaryQuestID[1] = 0;

        this.secondaryQuestID[0] = 0;
        this.secondaryQuestID[1] = 0;

        this.isWild = true;

        this.homeID = 0;
        this.needsHome = true;
        this.hasHome = false;

        this.workID = 0;
        this.needsWork = true;
        this.hasWork = false;

        this.jobID = -1;

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

    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 0.6D));
        this.tasks.addTask(6, new EntityAIDoVillageTasks(this, 0.1875, false));
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

        if (!this.world.isRemote)
        {
            if (!isWild)
            {
                if (this.needsHome == true && this.hasHome == false)
                {
                    if (this.ticksExisted % 20 == 0)
                    {
                        boolean checkHome = checkBlastia(this.homeID);
                        if (checkHome)
                            this.hasHome = true;
                    }
                }

                if (this.ticksExisted % 20 == 0)
                {
                    if (this.needsHome)
                    {
                        boolean checkHome = checkBlastia(this.homeID);
                        if (checkHome == true)
                            this.hasHome = checkHome;
                    }
                    if (this.needsWork)
                    {
                        boolean checkWork = checkBlastia(this.workID);
                        if (checkWork == true)
                            this.hasWork = checkWork;
                    }
                }
            }
        }
    }

    public boolean checkBlastia(int tileID)
    {
        for (TileEntity tEntity : this.world.loadedTileEntityList)
        {
            if (tEntity instanceof TileEntityBarrierBlastia)
            {
                return ((TileEntityBarrierBlastia)tEntity).hasTile(tileID);
            }
        }
        return false;
    }

    public boolean npcIsFarmer()
    {
        return this.jobID == 0;
    }

    public boolean npcIsRiceFarmer()
    {
        return this.jobID == 1;
    }

    public boolean npcHasHome()
    {
        return this.needsHome && this.hasHome;
    }

    public boolean npcHasWork()
    {
        return this.needsWork && this.hasWork;
    }

    public boolean npcNeedsHome()
    {
        return this.needsHome;
    }

    public boolean npcNeedsWork()
    {
        return this.needsWork;
    }

    public BlockPos getHomePos()
    {
        for (TileEntity tEntity : this.world.loadedTileEntityList)
        {
            if (tEntity instanceof TileEntityBarrierBlastia)
            {
                return ((TileEntityBarrierBlastia) tEntity).getTile(this.homeID);
            }
        }
        return this.getPosition();
    }

    public BlockPos getWorkPos()
    {
        for (TileEntity tEntity : this.world.loadedTileEntityList)
        {
            if (tEntity instanceof TileEntityBarrierBlastia)
            {
                return ((TileEntityBarrierBlastia) tEntity).getTile(this.workID);
            }
        }
        return this.getPosition();
    }

    public List<BlockPos> getFarmPos()
    {
        List<BlockPos> farmPos = new ArrayList<>();
        for (TileEntity tEntity : this.world.loadedTileEntityList)
        {
            if (tEntity instanceof TileEntityBlueprint)
            {
                if (((TileEntityBlueprint)tEntity).getTileIndex() == 1 && ((TileEntityBlueprint)tEntity).tileFinished())
                {
                    farmPos.add(tEntity.getPos());
                }
            }
        }
        return farmPos;
    }

    public List<BlockPos> getRiceFarmPos()
    {
        List<BlockPos> farmPos = new ArrayList<>();
        for (TileEntity tEntity : this.world.loadedTileEntityList)
        {
            if (tEntity instanceof TileEntityBlueprint)
            {
                if (((TileEntityBlueprint)tEntity).getTileIndex() == 3 && ((TileEntityBlueprint)tEntity).tileFinished())
                {
                    farmPos.add(tEntity.getPos());
                }
            }
        }
        return farmPos;
    }

    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        if (!this.world.isRemote && hand.equals(EnumHand.MAIN_HAND))
        {
            PlayerData data = (PlayerData) NecropolisPlayerData.get(player);
            if (this.needsHome == true)
            {
                this.isWild = false;
            }
            if (this.needsHome == true && this.hasHome == false)
            {
                //do home building quest
                if (data.getQuest(this.primaryQuestID[0]) == -1)
                {
                    data.setQuest(this.primaryQuestID[0], 0);
                }
                else
                    data.setQuest(this.primaryQuestID[0], 1);   //even setting this to 0 would trigger the dialogue
            }
            else if ((this.needsHome == false || (this.needsHome == true && data.getQuest(this.primaryQuestID[0]) == 2)) && this.needsWork == true && this.hasWork == false)
            {
                if (data.getQuest(this.primaryQuestID[1] )== -1)
                {
                    data.setQuest(this.primaryQuestID[1], 0);
                }
                else
                    data.setQuest(this.primaryQuestID[1], 1);
            }
            else
            {
                if (data.getQuest(this.primaryQuestID[0]) != 2)
                {
                    data.setQuest(this.primaryQuestID[0], 2);
                    return super.processInteract(player, hand);
                }
                //REMEMBER TO CHECK WORK QUESTS HERE
                else if (data.getQuest(this.primaryQuestID[1]) != 2)
                {
                    data.setQuest(this.primaryQuestID[1], 2);
                    return super.processInteract(player, hand);
                }
                else if (secondaryQuestID != null)
                {
                    //Check for secondary quest truth condition
                    for (int i = 0; i < this.secondaryQuestID.length; i++)
                    {
                        if (data.getQuest(this.secondaryQuestID[i]) == 0 || data.getQuest(this.secondaryQuestID[i]) == 1)
                        {
                            int questType = data.getQuestType(this.secondaryQuestID[i]);
                            if (questType == 1)
                            {
                                ItemStack questItemStack = data.getQuestStack(this.secondaryQuestID[i]);
                                if (player.getHeldItemMainhand().getItem().equals(questItemStack.getItem()))
                                {
                                    if (player.getHeldItemMainhand().getCount() >= questItemStack.getCount())
                                    {
                                        if (questItemStack.getItem() instanceof ItemSeeds || questItemStack.getItem() instanceof ItemRiceSeed)
                                        {
                                            this.setItemsInInventory(player.getHeldItemMainhand());
                                            player.getHeldItemMainhand().shrink(player.getHeldItemMainhand().getCount());
                                        }
                                        data.setQuest(this.secondaryQuestID[i], 2);
                                        return super.processInteract(player, hand);
                                    }
                                }
                                data.setQuest(this.secondaryQuestID[i], 1);
                            }
                            return super.processInteract(player, hand);
                        }
                    }
                    //check for any free quests
                    for (int i = 0; i < this.secondaryQuestID.length; i++)
                    {
                        if (data.getQuest(this.secondaryQuestID[i]) == -1)
                        {
                            data.setQuest(this.secondaryQuestID[i], 0);
                            return super.processInteract(player, hand);
                        }
                    }
                }
            }
        }
        return super.processInteract(player, hand);
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

    @Override
    protected boolean canDespawn()
    {
        return false;
    }

    public void setItemsInInventory(ItemStack itemStack)
    {
        ItemStack tItemStack = itemStack.copy();
        for (int i = 0; i < 36; i++)
        {
            if (this.npcItemStacks.get(i).getItem().equals(tItemStack.getItem()) || this.npcItemStacks.get(i).isEmpty())
            {
                tItemStack = this.setInventorySlotContents(i, tItemStack);
                if (tItemStack.isEmpty())
                    return;
            }
        }
    }

    public boolean getIsWild()
    {
        return this.isWild;
    }

    public void setIsWild(boolean value)
    {
        this.isWild = value;
    }

    public ItemStack setInventorySlotContents(int index, ItemStack stack)
    {
        ItemStack itemstack = this.npcItemStacks.get(index);

        int size = itemstack.getCount() + stack.getCount();
        int retStackSize = 0;

        if (size > 64)
        {
            retStackSize = size - 64;
        }

        this.npcItemStacks.set(index, new ItemStack(stack.getItem(), size));

        return new ItemStack(stack.getItem(), retStackSize);
    }

    public void setInventorySlot(int index, ItemStack stack)
    {
        this.npcItemStacks.set(index, stack);
    }

    public ItemStack decrStackSize(int index, int count)
    {
        return ItemStackHelper.getAndSplit(this.npcItemStacks, index, count);
    }

    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.npcItemStacks, index);
    }

    public ItemStack getStackInSlot(int index)
    {
        return this.npcItemStacks.get(index);
    }

    public int getSizeInventory() {
        return this.npcItemStacks.size();
    }

    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.npcItemStacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        this.isWild = compound.getBoolean("isWild");
        ItemStackHelper.loadAllItems(compound, this.npcItemStacks);
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        ItemStackHelper.saveAllItems(compound, this.npcItemStacks);
        compound.setBoolean("isWild", this.isWild);
        return compound;
    }
}