package com.turtledove.withernauts.server.tiles;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.server.entity.NecropolisEntity;
import com.turtledove.withernauts.server.entity.NecropolisNPC;
import com.turtledove.withernauts.server.entity.enemies.*;
import com.turtledove.withernauts.server.entity.npc.EntityDwigt;
import com.turtledove.withernauts.server.entity.npc.EntityTea;
import com.turtledove.withernauts.server.entity.npc.EntityYam;
import com.turtledove.withernauts.server.packets.Player.PlayerParticlePacket;
import com.turtledove.withernauts.server.packets.Player.SyncPlayerServerExperience;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class TileEntityBarrierBlastia extends TileEntity implements ITickable
{
    private static int tileCount = 4;

    private int[] enemyIDs = new int[0];

    private int[] tileRunning = new int[128];
    private BlockPos[] tilePos = new BlockPos[128];

    private int[] levelRequirements = {100, 200, 300, 400,600, 800, 1000};

    private int ticksExisted;

    private int level;
    private int soulCount;  //resets to 0 when complete
    private boolean blastiaActive;
    private int waveCount;

    protected class InvasionMobs
    {
        public int [][] waveMob; //0 is axebeak, 1 is skeleton, 2 is sorceress, 3 is spider, 4 is booglin, 5 is fugu, 6 is bedrock golem
        public InvasionMobs(int[]a, int[]b, int[]c, int[]d)
        {
            waveMob = new int[4][];
            waveMob[0] = a.clone();
            waveMob[1] = b.clone();
            waveMob[2] = c.clone();
            waveMob[3] = d.clone();
        }
    }

    private InvasionMobs[] invasions = new InvasionMobs[levelRequirements.length];

    public TileEntityBarrierBlastia()
    {
        super();
        this.level = 0;
        this.ticksExisted = 0;
        this.soulCount = 0;
        this.waveCount = 0;
        this.blastiaActive = true;

        this.invasions[0] = new InvasionMobs(new int[]{0},new int[]{0,0},new int[]{0,0},new int[]{1,0,0});
        this.invasions[1] = new InvasionMobs(new int[]{0,0},new int[]{1,0},new int[]{1,0},new int[]{0,1,1});
        this.invasions[2] = new InvasionMobs(new int[]{0,1},new int[]{1,2},new int[]{1,2},new int[]{1, 2, 0});
        this.invasions[3] = new InvasionMobs(new int[]{0,1},new int[]{1, 2},new int[]{0, 2},new int[]{2, 2, 3});
        this.invasions[4] = new InvasionMobs(new int[]{1, 3},new int[]{3, 2},new int[]{1, 1, 3},new int[]{2, 3, 4});
        this.invasions[5] = new InvasionMobs(new int[]{1,3, 4},new int[]{1, 3, 4},new int[]{3, 3, 4},new int[]{4, 4, 5});
        this.invasions[6] = new InvasionMobs(new int[]{3, 4, 5},new int[]{3, 4, 5},new int[]{4, 4, 5},new int[]{4, 5, 6});

        for (int i = 0; i < 128; i++)
        {
            this.tileRunning[i] = 0;
            this.tilePos[i] = this.pos;
        }
    }
    @Override
    public void update()
    {

        if (!this.world.isRemote)
        {
            int range = this.getRange();
            if (this.blastiaActive)
            {
                List<NecropolisEntity> list = this.world.getEntitiesWithinAABB(NecropolisEntity.class, (new AxisAlignedBB(getPos())).expand(range * 2.0, range * 2.0, range * 2.0).offset(-range, -range, -range));
                if (!list.isEmpty())
                {
                    for (NecropolisEntity monster : list)
                    {
                        monster.setDead();
                    }
                }
                if (this.ticksExisted % 60 == 0)
                {
                    for (int i = -this.getRange(); i < this.getRange()+1; i++)
                    {
                        Withernauts.packetHandler.sendToAll(new PlayerParticlePacket(0, pos.getX() + this.getRange()+1, pos.getY(), pos.getZ() + i, 0.0D, -0.3D, 0.0D));
                        Withernauts.packetHandler.sendToAll(new PlayerParticlePacket(0, pos.getX() - this.getRange(), pos.getY(), pos.getZ() + i, 0.0D, -0.3D, 0.0D));

                        Withernauts.packetHandler.sendToAll(new PlayerParticlePacket(0, pos.getX() + i, pos.getY(), pos.getZ() + this.getRange()+1, 0.0D, -0.3D, 0.0D));
                        Withernauts.packetHandler.sendToAll(new PlayerParticlePacket(0, pos.getX() + i, pos.getY(), pos.getZ() - this.getRange(), 0.0D, -0.3D, 0.0D));
                    }
                }
            }
            else
            {
                if (this.enemyIDs.length == 0)
                    endWave();
                else
                {
                    for (int i = 0; i < this.enemyIDs.length; i++)
                    {
                        if (this.world.getEntityByID(this.enemyIDs[i]) != null)
                        {
                            return;
                        }
                    }
                    endWave();
                }
            }
            this.ticksExisted++;
        }
    }

    public int getLevel()
    {
        return this.level;
    }


    public int getRange()
    {
        return 8 + this.level * 4;
    }
    private void startInvasion()
    {
        this.blastiaActive = false;
        this.waveCount = 0;
        this.startWave();
    }

    private void endWave()
    {
        if (this.waveCount == 4)
        {
            this.endInvasion();
        }
        else
        {
            this.waveCount++;
            this.startWave();
        }
    }

    public void startWave()
    {
        if (this.waveCount == 4)
        {
            this.endInvasion();
            return;
        }
        int enemyCount = this.invasions[this.level].waveMob[this.waveCount].length;
        enemyIDs = new int[enemyCount];
        for (int i = 0; i < enemyCount; i++)
        {
            int tEnemy = this.invasions[this.level].waveMob[this.waveCount][i];
            NecropolisEntity invader = this.getWaveMob(tEnemy);
            this.world.spawnEntity(invader);
            enemyIDs[i] = invader.getEntityId();
        }
    }

    public NecropolisEntity getWaveMob(int enemyIndex)
    {
        if (enemyIndex == 0)
        {
            EntityAxeBeak invader = new EntityAxeBeak(this.world);
            invader.setRaider();
            BlockPos dest = this.getMonsterSpawn();
            invader.setPosition(dest.getX(), dest.getY(), dest.getZ());
            return invader;
        }
        else if (enemyIndex == 1)
        {
            EntityNecropolisSkeleton invader = new EntityNecropolisSkeleton(this.world);
            invader.setRaider();
            BlockPos dest = this.getMonsterSpawn();
            invader.setPosition(dest.getX(), dest.getY(), dest.getZ());
            return invader;
        }
        else if (enemyIndex == 2)
        {
            EntityCultSorceress invader = new EntityCultSorceress(this.world);
            invader.setRaider();
            BlockPos dest = this.getMonsterSpawn();
            invader.setPosition(dest.getX(), dest.getY(), dest.getZ());
            return invader;
        }
        else if (enemyIndex == 3)
        {
            EntityNecropolisSpider invader = new EntityNecropolisSpider(this.world);
            invader.setRaider();
            BlockPos dest = this.getMonsterSpawn();
            invader.setPosition(dest.getX(), dest.getY(), dest.getZ());
            return invader;
        }
        else if (enemyIndex == 4)
        {
            EntityBooglin invader = new EntityBooglin(this.world);
            invader.setRaider();
            BlockPos dest = this.getMonsterSpawn();
            invader.setPosition(dest.getX(), dest.getY(), dest.getZ());
            return invader;
        }
        else if (enemyIndex == 5)
        {
            EntityFugu invader = new EntityFugu(this.world);
            invader.setRaider();
            BlockPos dest = this.getMonsterSpawn();
            invader.setPosition(dest.getX(), dest.getY(), dest.getZ());
            return invader;
        }
        else
        {
            EntityBedrockGolem invader = new EntityBedrockGolem(this.world);
            invader.setRaider();
            BlockPos dest = this.getMonsterSpawn();
            invader.setPosition(dest.getX(), dest.getY(), dest.getZ());
            return invader;
        }
    }

    private void endInvasion()
    {
        this.blastiaActive = true;
        this.waveCount = 0;
        this.spawnNewNPC();
        this.levelUp();
    }

    private void spawnNewNPC()
    {
        NecropolisNPC friendNPC;
        BlockPos npcPos = this.getMonsterSpawn();
        switch(this.level)
        {
            case 0:
                friendNPC = new EntityYam(this.world);
                break;
            case 1:
                friendNPC = new EntityTea(this.world);
                break;
            default:
                friendNPC = new EntityDwigt(this.world);
        }
        friendNPC.setPosition(npcPos.getX(), npcPos.getY(), npcPos.getZ());
        this.world.spawnEntity(friendNPC);
    }


    public BlockPos getMonsterSpawn()
    {
        BlockPos monsterPos = this.pos;
        double xOffset = (this.getRange() * Math.random() * 2.0D) - this.getRange();
        double yOffset = (this.getRange() * Math.random() * 2.0D) - this.getRange();

        if (xOffset >= 0)
            xOffset += (8.0);
        else
            xOffset -= (8.0);

        if (yOffset >= 0)
            yOffset += (8.0);
        else
            yOffset -= (8.0);

        monsterPos = monsterPos.add(xOffset, 0.0, yOffset);

        int t = 0;
        for (int i = monsterPos.getY(); i < 256; i++)
        {
            if (this.world.isAirBlock(monsterPos.up(t)) && this.world.isAirBlock(monsterPos.up(t+1)))
            {
                return monsterPos.up(t);
            }
            t++;
        }
        t = 0;
        for (int i = monsterPos.getY(); i > 0; i--)
        {
            if (this.world.isAirBlock(monsterPos.down(t)) && this.world.isAirBlock(monsterPos.down(t+1)))
            {
                return monsterPos.down(t+1);
            }
            t++;
        }
        return monsterPos;
    }

    public void setSouls(EntityPlayer playerIn)
    {
        if (this.blastiaActive == false)
            return;
        if (this.level >= this.levelRequirements.length)
            return;
        int playerLevel = playerIn.experienceLevel;
        float expPercent = playerIn.experience;
        int xpCap = playerIn.xpBarCap();

        double totalExp_1 = getExpTotal(playerLevel);
        int xpTotal = (int)totalExp_1 + (int)(xpCap * expPercent);

        if (xpTotal + this.soulCount >= this.levelRequirements[this.level])
        {
            if (this.levelRequirements[this.level] - this.soulCount > 0)
            {
                xpTotal -= (this.levelRequirements[this.level] - this.soulCount);
            }

            double tLevel = this.getLevel(xpTotal);

            this.soulCount = 0;

            playerIn.experienceLevel = (int)tLevel;
            playerIn.experience = (float)tLevel - (float)((int)tLevel);

            Withernauts.packetHandler.sendTo(new SyncPlayerServerExperience((int)tLevel, (float)tLevel - (float)((int)tLevel)), (EntityPlayerMP)playerIn);

            this.startInvasion();
            //this.levelUp();
        }
        else
        {
            this.soulCount+=xpTotal;
            playerIn.experienceLevel = 0;
            playerIn.experience = 0.0f;
            Withernauts.packetHandler.sendTo(new SyncPlayerServerExperience(0, 0.0F), (EntityPlayerMP)playerIn);

        }
    }

    public int[] getLevelRequirements()
    {
        return this.levelRequirements;
    }
    public double getLevel(int xpTotal)
    {
        double x = 0;
        if (xpTotal <= 352)
        {
            x = (-6.0 + Math.sqrt(36 - 4 * (-xpTotal)))/2.0;
        }
        else if (xpTotal <= 1507)
        {
            x = (40.5 + Math.sqrt(1640.25 - 4 * 2.5 * (360-xpTotal)))/(2.0 * 2.5);
        }
        else
        {
            x = (162.5 + Math.sqrt(26406.25 - 4 * 4.5 * (2220-xpTotal)))/(2.0 * 4.5);
        }
        return x;
    }

    public double getExpTotal(int x)
    {
        double totalExp = 0;
        if (x < 17)
        {
            totalExp = x * x + 6 * x;
        }
        else if (x < 32)
        {
            totalExp = 2.5 * x * x - 40.5 * x + 360;
        }
        else
        {
            totalExp = 4.5 * x * x - 162.5 * x + 2220;
        }
        return totalExp;
    }

    public void setTile(int tileID, BlockPos tilePos)
    {
        this.tilePos[tileID] = tilePos;
        this.tileRunning[tileID] = 2;
    }

    public void resetTile(int tileID)
    {
        this.tileRunning[tileID] = 1;
    }

    public void destroyTile(int tileID, BlockPos tilePos)
    {
        this.tileRunning[tileID] = 0;
    }

    public boolean hasTile(int tileID)
    {
        return this.tileRunning[tileID] == 2;
    }

    public BlockPos getTile(int tileID)
    {
        return this.tilePos[tileID];
    }

    public void levelUp()
    {
        this.level++;
    }

    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.level = compound.getInteger("blastia_level");
        this.soulCount = compound.getInteger("soul_count");
        this.blastiaActive = compound.getBoolean("blastia_active");
        this.waveCount = compound.getInteger("wave_count");
        this.enemyIDs = compound.getIntArray("enemy_ids");
    }
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("blastia_level", this.level);
        compound.setInteger("soul_count", this.soulCount);
        compound.setBoolean("blastia_active", this.blastiaActive);
        compound.setInteger("wave_count", this.waveCount);
        compound.setIntArray("enemy_ids", this.enemyIDs);
        return compound;
    }

}
