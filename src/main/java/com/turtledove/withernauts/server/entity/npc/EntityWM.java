package com.turtledove.withernauts.server.entity.npc;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.server.ai.EntityWMRoamAI;
import com.turtledove.withernauts.server.core.IPlayerData;
import com.turtledove.withernauts.server.entity.NecropolisNPC;
import com.turtledove.withernauts.server.events.NecropolisCapabilities;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class EntityWM extends NecropolisNPC
{
    private static final Animation[] ANIMATIONS = {};
    public EntityWM(World worldin)
    {
        super(worldin);
        setPathPriority(PathNodeType.DOOR_WOOD_CLOSED, 0);
    }

    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(2, new EntityWMRoamAI(this, 0.1875D));
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        /*if (!this.world.isRemote && hand.equals(EnumHand.MAIN_HAND))
        {
            return true;
        }
        return false;*/
        if (player.world.isRemote == false)
        {
            IPlayerData iData = player.getCapability(NecropolisCapabilities.PLAYER_DATA_CAPABILITY, null);
            iData.syncMerchantPoints();
        }
        player.openGui(Withernauts.MODID,2,player.world,(int)player.posX, (int)player.posY, (int)player.posZ);
        return true;
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

    @Override
    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor(this.posX);
        int j = MathHelper.floor(this.getEntityBoundingBox().minY);
        int k = MathHelper.floor(this.posZ);
        BlockPos pos = new BlockPos(i, j, k);

        // Dimension check
        if (world.provider.getDimension() != 0)
        {
            return false;
        }
        // Height check
        float heightMax = 255;
        float heightMin = 60;
        if (posY > heightMax && heightMax >= 0) {
            return false;
        }
        if (posY < heightMin) {
            return false;
        }

        // Light level check
        if (world.isDaytime() == false)
        {
            return false;
        }
        // Block check
        ResourceLocation blockName = world.getBlockState(pos.down()).getBlock().getRegistryName();
        if (blockName == null) return false;

        // See sky
        if (!world.canSeeSky(pos))
        {
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
    @Override
    protected boolean canDespawn()
    {
        return false;
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
