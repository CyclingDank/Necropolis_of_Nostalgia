package com.turtledove.withernauts.server.core;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.common.ArteHandler;
import com.turtledove.withernauts.common.ClassHandler;
import com.turtledove.withernauts.common.quests.NecropolisQuestHandler;
import com.turtledove.withernauts.server.artes.ArteBase;
import com.turtledove.withernauts.server.artes.SpecialArte;
import com.turtledove.withernauts.server.item.*;
import com.turtledove.withernauts.server.packets.Log;
import com.turtledove.withernauts.server.packets.Player.*;

import com.turtledove.withernauts.server.packets.Player.SyncPlayerStatsClientSide;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.SoundCategory;

import java.util.ArrayList;

public class PlayerData implements IPlayerData
{
    private final int ARTE_LENGTH = 9;
    private final int QUEST_LENGTH = 256;
    private final int BUFFER_LENGTH = 4;

    private boolean isOldFace;

    private int syncCount = 1200;  //syncs every minute, aka 1200 ticks


    //DIALOGUE RELATED
    NecropolisQuestHandler questHandler = new NecropolisQuestHandler();
    private  int current_quest = -1;
    private int current_quest_status = -1;
    private int current_page = 0;
    public int[] questStatus = new int[256];    //-1 is not started, 0 is started, 1 is nearly complete, 2 is complete.

    //MERCHANT RELATED
    private int merchantPoints;

    /*THESE MUST BE SET ACCORDING TO CLASS, ABILITIES, OR SKILLS*/
    private float manaRegenTime;
    private float regenTime;
    public float regenRate;
    protected float playermaxMana;
    protected float playerMana;

    //class and weapon checks
    private int current_class;  //0 is knight, 1 is noblesse, 2 is scholar, 3 is general, 4 is halberdier, 5 is regal
    private int current_weapon; //-1 is N/A, 0 is a sword, 1 is a rapier, 2 is a tome, 3 is a halberd.
    private int prev_weapon;

    //player stamina
    private int playerStamina;
    private boolean staminaPunish;

    //player artes
    public int[] bindedArtes = new int[9]; //binding of player artes. 0 is first click, 1 is second, etc. The value is the index of the arte in ArteHandler.
    public int[] primaryArtes = new int[9];
    public int[] secondaryArtes = new int[9];
    public ArteHandler artes = new ArteHandler();
    public ClassHandler n_classes = new ClassHandler();
    public int[] arteCount = new int[artes.NUM_ARTES];
    protected int pArteCoolDown;    //The duration of the cast. If chainCount is 0, it does nothing.
    public int currentCol;  //Whether the selected arte is on left, middle, or right
    public int currentpArte;
    public float attackProgress;
    private boolean inBufferZone;
    public boolean activatepArte;
    private float current_artetime;
    private float prev_artetime;

    //player stat buff cooldown
    private int[] buff_cooldown = new int [4];

    private final EntityPlayer player;
    //private final EntityDataManager privateData;

    public PlayerData()
    {
        this.player = null;

        this.pArteCoolDown = 0;
        this.currentpArte = 0;
        this.currentCol = 0;
        this.attackProgress = 1.0F;
        this.activatepArte = false;
        this.inBufferZone = true;

        this.current_artetime = 0.0F;
        this.prev_artetime = 0.0F;
        this.current_weapon = -1;
        this.prev_weapon = -1;
        this.playerStamina = 400;
        this.staminaPunish = false;
        this.isOldFace = false;

        this.current_class = -1;


        this.set_class(-1);

        this.initializeMerchantVar();
        this.initializeManaVar();
        this.initializeDialogueVar();
        this.initializeArtes();
        this.initializeBufferCooldowns();
        this.initializeArteUsageCount();
    }
    public PlayerData(EntityPlayer player)
    {
        this.player = player;

        this.pArteCoolDown = 0;
        this.currentpArte = 0;
        this.currentCol = 0;
        this.attackProgress = 1.0F;
        this.activatepArte = false;
        this.inBufferZone = true;

        this.current_weapon = -1;
        this.prev_weapon = -1;
        this.playerStamina = 400;
        this.staminaPunish = false;
        this.isOldFace = false;

        this.set_class(-1);

        this.initializeMerchantVar();
        this.initializeManaVar();
        this.initializeDialogueVar();
        this.initializeArtes();
        this.initializeBufferCooldowns();
        this.initializeArteUsageCount();

        //privateData = player.getDataManager();

        //artes.initializeArteHandler(this.player);
    }
    public void onJoinWorld()
    {
        setPlayerStats();
        if (this.player.world.isRemote)
        {
            Log.trace("PlayerData@onJoinWorld - Client sending sync req\n");
            this.initializeQuestStatus();
        }
    }
    public void onTick()
    {
        this.player.getFoodStats().setFoodLevel(10);
        if (this.player.world.isRemote)
        {
            this.setWeaponCheck();
            if (this.player.isCreative())
                this.playerStamina = 1600;

            if (this.player.swingProgress > 0.0 && this.player.getHeldItemMainhand().getItem() instanceof ItemSword)
            {
                int sneak = Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode();
                Minecraft.getMinecraft().gameSettings.keyBindSneak.setKeyBindState(sneak, false);
            }
            if (this.staminaPunish == true)
            {
                int move_sprint = Minecraft.getMinecraft().gameSettings.keyBindSprint.getKeyCode();
                int sneak = Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode();
                Minecraft.getMinecraft().gameSettings.keyBindSprint.setKeyBindState(move_sprint,false);
                Minecraft.getMinecraft().gameSettings.keyBindSneak.setKeyBindState(sneak, false);
                this.player.setSprinting(false);
                this.player.setSneaking(false);
            }
            if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown())
            {
                if (!this.player.isInWater())
                {
                    this.playerStamina = Math.max(0, this.playerStamina + this.getStaminaDecrease() - 5);
                }
                else
                {
                    if (this.playerStamina > 3)
                        playerStamina-=4;
                }
            }
            if (this.player.isSprinting())
            {
                this.playerStamina = Math.max(0, this.playerStamina + this.getStaminaDecrease());
                if (this.playerStamina == 0)
                    this.staminaPunish = true;
            }
            else
            {
                if (this.playerStamina < 400)
                {
                    this.playerStamina = Math.min (400, this.playerStamina + this.getStaminaIncrease());
                }
                else
                {
                    this.staminaPunish = false;
                }
            }
            if (this.currentpArte ==  3)
            {
                this.currentpArte = 0;
            }
            if (this.activatepArte == true)
            {
                if (this.inBufferZone == false)
                {
                    if (this.pArteCoolDown >= artes.t_arte[bindedArtes[this.currentpArte + this.currentCol * 3]].getActionLockTime())
                    {
                        this.incrementArteCount();
                        this.inBufferZone = true;
                        this.activatepArte = false;
                        this.pArteCoolDown = 0;
                        if (this.currentpArte ==  2)
                        {
                            this.currentpArte = 0;
                        }
                        else
                        {
                            this.currentpArte++;
                        }
                    }
                    else
                    {

                        if (get_stage_cooldown() == 1)
                        {
                            Minecraft.getMinecraft().world.playSound(player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, SoundCategory.MASTER,0.8F, 1.4F, false);
                            Withernauts.packetHandler.sendToServer(new MessagePacket(getCurrentArteIndex(),0,0.0,0.0,0.0, get_current_stage()));
                        }
                        if (get_current_stage() == 0)
                        {
                            if (is_special_attack())
                            {
                                int move_L = Minecraft.getMinecraft().gameSettings.keyBindLeft.getKeyCode();
                                int move_R = Minecraft.getMinecraft().gameSettings.keyBindRight.getKeyCode();
                                int move_U = Minecraft.getMinecraft().gameSettings.keyBindForward.getKeyCode();
                                int move_D = Minecraft.getMinecraft().gameSettings.keyBindBack.getKeyCode();
                                int move_sprint = Minecraft.getMinecraft().gameSettings.keyBindSprint.getKeyCode();
                                int move_sneak = Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode();
                                int move_Jump = Minecraft.getMinecraft().gameSettings.keyBindJump.getKeyCode();
                                player.setSprinting(false);
                                Minecraft.getMinecraft().gameSettings.keyBindJump.setKeyBindState(move_L,false);
                                Minecraft.getMinecraft().gameSettings.keyBindJump.setKeyBindState(move_R,false);
                                Minecraft.getMinecraft().gameSettings.keyBindJump.setKeyBindState(move_U,false);
                                Minecraft.getMinecraft().gameSettings.keyBindJump.setKeyBindState(move_D,false);
                                Minecraft.getMinecraft().gameSettings.keyBindJump.setKeyBindState(move_Jump,false);
                                Minecraft.getMinecraft().gameSettings.keyBindJump.setKeyBindState(move_sprint,false);
                                Minecraft.getMinecraft().gameSettings.keyBindJump.setKeyBindState(move_sneak,false);
                            }
                        }
                        this.pArteCoolDown++;
                    }
                }
                else
                {
                    if (this.pArteCoolDown >= 24)
                    {
                        this.pArteCoolDown = 0;
                        this.currentpArte = 0;
                    }
                    else
                    {
                        this.inBufferZone = false;
                        this.pArteCoolDown = 0;
                    }
                }

            }
            else
            {
                if (this.inBufferZone == true)
                {
                    if (this.pArteCoolDown >= 24)
                    {
                        this.pArteCoolDown = 0;
                        this.currentpArte = 0;
                    }
                    else
                    {
                        this.pArteCoolDown++;
                    }
                }
            }
        }
        else
        {
            if (this.syncCount == 1200)
            {
                //Necropolis_of_Nostalgia.packetHandler.sendTo(new SyncPlayerStatsClientSide(this.playerMana),(EntityPlayerMP) this.player);
                Withernauts.packetHandler.sendTo(new SyncArtesOnServer( primaryArtes, secondaryArtes, arteCount, this.current_class),(EntityPlayerMP) this.player);
            }
            else if (this.syncCount == 1199)
            {
                Withernauts.packetHandler.sendTo(new SyncPlayerStatsServerSide(this.playerMana, this.getStatBoost()),(EntityPlayerMP) this.player);
                syncQuests();
            }
            else if (this.syncCount == 0)
            {
                this.syncCount = 1199;
            }

            this.syncCount-=1;
        }
        updateStatsBoost();
        updateMana();
    }
    public void doDialogueGUIControlls()
    {
        if (this.current_quest == -1)
            return;
        else
        {
            this.current_page++;
            if (this.current_page >= questHandler.getQuestStatusPages(this.current_quest, this.current_quest_status))
            {
                this.current_quest = -1;
                this.current_page = 0;
            }
        }
    }

    public boolean doDialogue()
    {
        return this.current_quest != -1;
    }

    public String getDialogue()
    {
        return this.questHandler.getQuestDialogue(this.current_quest, this.current_quest_status, this.current_page);
    }
    public void doAttack(int key, int stage)
    {
        artes.t_arte[bindedArtes[key]].setPlayer(this.player);
        artes.t_arte[bindedArtes[key]].startAttack(stage);
    }

    public boolean isStaminaPunished()
    {
        return this.staminaPunish;
    }

    public int getArmor(boolean isSpecial)
    {
        int armorTotal = 0;
        for (ItemStack val : this.player.getEquipmentAndArmor())
        {
            if (val.getItem() instanceof ItemNecropolisArmor)
            {
                ItemNecropolisArmor necropolisArmor = (ItemNecropolisArmor)val.getItem();
                armorTotal += necropolisArmor.getStrength(isSpecial);
            }
            else if (val.getItem() instanceof ItemArmor)
            {
                if (!isSpecial)
                {
                    ItemArmor basicArmor = (ItemArmor)val.getItem();
                    armorTotal += basicArmor.damageReduceAmount;
                }
            }
        }
        return armorTotal;
    }

    public int getArmorWeight()
    {
        int weight = 0;
        for (ItemStack val : this.player.getEquipmentAndArmor())
        {
            if (val.getItem() instanceof ItemNecropolisArmor)
            {
                ItemNecropolisArmor necropolisArmor = (ItemNecropolisArmor)val.getItem();
                weight += necropolisArmor.getWeight();
            }
            else if (val.getItem() instanceof ItemArmor)
            {
                ItemArmor basicArmor = (ItemArmor)val.getItem();
                switch (basicArmor.getArmorMaterial())
                {
                    case LEATHER:
                        weight += 3;
                    case CHAIN:
                        weight += 4;
                    case GOLD:
                        weight += 4;
                    case IRON:
                        weight += 6;
                    case DIAMOND:
                        weight += 5;
                    default:
                        weight += 4;
                }
            }
        }
        return weight;
    }

    public int getStaminaDecrease()
    {
        int weight = getArmorWeight();
        if (weight < 5)
            return -1;
        else if (weight < 7)
            return -2;
        else if (weight < 14)
            return -3;
        else if (weight < 17)
            return -4;
        else if (weight < 20)
            return -5;
        else
            return -6;
    }
    public int getStaminaIncrease()
    {
        int weight = getArmorWeight();
        if (weight < 5)
            return 6;
        else if (weight < 7)
            return 5;
        else if (weight < 14)
            return 4;
        else if (weight < 17)
            return 3;
        else if (weight < 20)
            return 2;
        else
            return 1;
    }

    public void incrementArteCount()
    {
        this.arteCount[bindedArtes[this.currentpArte + this.currentCol * 3]]++;
        Withernauts.packetHandler.sendToServer(new SyncArtesOnClient(this.bindedArtes, arteCount, -1));
    }

    public void decreasePlayerStamina(int stamina)
    {
        if (this.playerStamina - stamina < 0)
        {
            this.playerStamina = 0;
            this.staminaPunish = true;
        }
        else
            this.playerStamina -= stamina;
        if (this.playerStamina > 1600)
            this.playerStamina = 1600;
    }

    public void setPlayerStamina(int inStamina)
    {
        if ((this.playerStamina + inStamina) > 1600)
        {
            this.playerStamina = 1600;
        }
        else
        {
            this.playerStamina += inStamina;
        }
    }

    public int getPlayerStamina()
    {
        return this.playerStamina;
    }


    public void activateArte(int arteIndex)
    {
        this.consumeMana(50.0F);
    }
    public void consumeMana(float points)
    {
        if (this.playerMana - points < 0.0F)
        {
            this.playerMana = 0.0F;
        }
        else
        {
            this.playerMana -= points;
        }

        if (!this.player.world.isRemote)
        {
            Withernauts.packetHandler.sendTo(new SyncPlayerStatsServerSide(this.playerMana, this.getStatBoost()),(EntityPlayerMP) this.player);
        }
        else
        {
            Withernauts.packetHandler.sendToServer(new SyncPlayerStatsClientSide(this.playerMana));
        }
    }

    public void restoreMana(float points)
    {
        if (this.playerMana + points > playermaxMana)
        {
            this.playerMana = this.playermaxMana;
        }
        else
        {
            this.playerMana += points;
        }
        if (!this.player.world.isRemote)
        {
            Withernauts.packetHandler.sendTo(new SyncPlayerStatsServerSide(this.playerMana, this.getStatBoost()),(EntityPlayerMP) this.player);
        }
        else
        {
            Withernauts.packetHandler.sendToServer(new SyncPlayerStatsClientSide(this.playerMana));
        }
    }
    public void fillMana(float points)
    {
        if (this.playerMana + points > playermaxMana)
        {
            this.playerMana = this.playermaxMana;
        }
        else
        {
            this.playerMana += points;
        }
    }
    private void updateMana()
    {
        if (getMana() > playermaxMana)
        {
            setMana(playermaxMana);
        }
        else
        {
            regenTime += 1.0F/ 20.0F;
            if (regenTime >= 3.0F / manaRegenTime)
            {
                if (this.getMana() < this.playermaxMana)
                {
                    this.fillMana(regenRate);
                }
                regenTime-= 3.0F / manaRegenTime;
            }
        }
    }

    public ArrayList<Integer> getArteGlobalIndex(boolean isPrimary)
    {
        int[] classArtes = n_classes.t_classes[get_class()].get_possibleArtes();
        ArrayList<Integer>globalClassArtes = new ArrayList<Integer>();
        int x = this.player.experienceTotal;
        if (x > 2000)
            x = 2000;
        int totalLevel = (int)(1.04 + 0.0739 * x + -1.34E-04* Math.pow(x, 2) + 1.64E-07* Math.pow(x, 3) + -1.14E-10* Math.pow(x, 4) + 4.07E-14 * Math.pow(x, 5) + -5.81E-18* Math.pow(x, 6));
        for (int i = 0; i < classArtes.length; i++)
        {
            if (totalLevel >= artes.t_arte[classArtes[i]].getLevelLearned())
            {
                if (isPrimary)
                {
                    if (artes.t_arte[classArtes[i]].getArteWeapon() == 0 || artes.t_arte[classArtes[i]].getArteWeapon() == 1)
                    {
                        if (artes.t_arte[classArtes[i]].isBase())
                            globalClassArtes.add(classArtes[i]);
                        else
                        {
                            int uSize = artes.t_arte[classArtes[i]].getUsageRequirements().length;
                            boolean canAdd = true;
                            for (int j = 0; j < uSize; j++)
                            {
                                if (this.arteCount[artes.t_arte[classArtes[i]].getUsageRequirements()[j].index] > artes.t_arte[classArtes[i]].getUsageRequirements()[j].usage)
                                {
                                    canAdd = true;
                                }
                                else
                                    canAdd = false;
                            }
                            if (canAdd)
                            {
                                globalClassArtes.add(classArtes[i]);
                            }
                        }
                    }
                }
                else
                {
                    if (artes.t_arte[classArtes[i]].getArteWeapon() > 1)
                    {
                        if (artes.t_arte[classArtes[i]].isBase())
                            globalClassArtes.add(classArtes[i]);
                        else
                        {
                            int uSize = artes.t_arte[classArtes[i]].getUsageRequirements().length;
                            boolean canAdd = true;
                            for (int j = 0; j < uSize; j++)
                            {
                                if (this.arteCount[artes.t_arte[classArtes[i]].getUsageRequirements()[j].index] > artes.t_arte[classArtes[i]].getUsageRequirements()[j].usage)
                                {
                                    canAdd = true;
                                }
                                else
                                    canAdd = false;
                            }
                            if (canAdd)
                            {
                                globalClassArtes.add(classArtes[i]);
                            }
                        }
                    }
                }
            }
        }
        return globalClassArtes;
    }

    public ArrayList<ArteBase> getLearnedArtes(boolean isPrimary)
    {
        int[] classArtes = n_classes.t_classes[get_class()].get_possibleArtes();

        ArrayList<ArteBase>globalClassArtes = new ArrayList<ArteBase>();

        for (int i = 0; i < classArtes.length; i++)
        {
            int x = this.player.experienceTotal;
            if (x > 2000)
                x = 2000;
            int totalLevel = (int)(1.04 + 0.0739 * x + -1.34E-04* Math.pow(x, 2) + 1.64E-07* Math.pow(x, 3) + -1.14E-10* Math.pow(x, 4) + 4.07E-14 * Math.pow(x, 5) + -5.81E-18* Math.pow(x, 6));
            if (totalLevel >= artes.t_arte[classArtes[i]].getLevelLearned())
            {
                if (isPrimary)
                {
                    if (artes.t_arte[classArtes[i]].getArteWeapon() == 0 || artes.t_arte[classArtes[i]].getArteWeapon() == 1)
                    {
                        if (artes.t_arte[classArtes[i]].isBase())
                            globalClassArtes.add(artes.t_arte[classArtes[i]]);
                        else
                        {
                            int uSize = artes.t_arte[classArtes[i]].getUsageRequirements().length;
                            boolean canAdd = true;
                            for (int j = 0; j < uSize; j++)
                            {
                                if (this.arteCount[artes.t_arte[classArtes[i]].getUsageRequirements()[j].index] > artes.t_arte[classArtes[i]].getUsageRequirements()[j].usage)
                                {
                                    canAdd = true;
                                }
                                else
                                    canAdd = false;
                            }
                            if (canAdd)
                                globalClassArtes.add(artes.t_arte[classArtes[i]]);
                        }
                    }
                }
                else
                {
                    if (artes.t_arte[classArtes[i]].getArteWeapon() > 1)
                    {
                        if (artes.t_arte[classArtes[i]].isBase())
                            globalClassArtes.add(artes.t_arte[classArtes[i]]);
                        else
                        {
                            int uSize = artes.t_arte[classArtes[i]].getUsageRequirements().length;
                            boolean canAdd = true;
                            for (int j = 0; j < uSize; j++)
                            {
                                if (this.arteCount[artes.t_arte[classArtes[i]].getUsageRequirements()[j].index] > artes.t_arte[classArtes[i]].getUsageRequirements()[j].usage)
                                {
                                    canAdd = true;
                                }
                                else
                                    canAdd = false;
                            }
                            if (canAdd)
                                globalClassArtes.add(artes.t_arte[classArtes[i]]);
                        }
                    }
                }
            }
        }

        return globalClassArtes;
    }

    public void setQuest(int questID, int questStatus)
    {
        this.questStatus[questID] = questStatus;
        if (!this.player.world.isRemote)
        {
            this.syncQuest(questID);
        }
        else
        {
            this.current_quest = questID;
            this.current_page = 0;
            this.current_quest_status = this.questStatus[questID];

            this.questStatus[questID] = questStatus;
        }
    }

    public int getQuest(int questID)
    {
        return this.questStatus[questID];
    }

    public void syncQuests()
    {
        if (!this.player.world.isRemote)
        {
            Withernauts.packetHandler.sendTo(new SyncQuestsServerSide(this.questStatus),(EntityPlayerMP) this.player);
        }
    }
    public void syncQuest(int qID)
    {
        if (!this.player.world.isRemote)
        {
            Withernauts.packetHandler.sendTo(new SyncSingleQuestServerSide(qID, this.questStatus[qID]),(EntityPlayerMP) this.player);
        }
    }


    public int[] getArteCount()
    {
        return this.arteCount;
    }
    public void setArteCount(int[]count)
    {
        for (int i = 0; i <artes.NUM_ARTES; i++)
        {
            if (count.length > 0)
            {
                this.arteCount[i] = count[i];
            }
            else
            {
                this.arteCount[i] = 0;
            }
        }
    }
    private void setPlayerStats()
    {
        //this.setMana(256.0F);
        this.setManaRegenRate(1.0F);
        //this.setAccuracy(0.5F);
        this.playermaxMana = 256F;
        this.pArteCoolDown = 0;
        this.currentpArte = 0;
        this.attackProgress = 1.0F;
        this.activatepArte = false;
        this.inBufferZone = true;
        //bindArtes();
    }
    public void setActivatepArte(boolean val)
    {
        this.activatepArte = val;
    }
    public void setMana(float points)
    {
        this.playerMana = points;
    }
    public void setManaRegen(float points)
    {
        this.manaRegenTime = points;
    }
    public void setManaRegenRate(float points)
    {
        this.regenRate = points;
    }
    public void setcurrentPArte(int key)
    {
        this.currentpArte = key;
        this.pArteCoolDown = 0;
    }

    public boolean isArrayEmpty(int [] args)
    {
        for (int i = 0; i < 9; i++)
        {
            if (args[i] == -1)
                return true;
        }
        return false;
    }

    public void setQuestStatus(int[]args)
    {
        if (args.length == 256)
        {
            for (int i = 0; i < 256; i++)
            {
                this.questStatus[i] = args[i];
            }
        }
    }

    public int[] getQuestStatus()
    {
        return this.questStatus;
    }


    public void set_oldface(boolean val)
    {
        this.isOldFace = val;
    }
    public boolean get_oldface()
    {
        return this.isOldFace;
    }

    public void setBindedArtes(int[] args)
    {
        this.bindedArtes = args;
    }

    public void syncMerchantPoints()
    {
        if (this.player.world.isRemote)
        {
            Withernauts.packetHandler.sendToServer(new SyncPlayerMerchantClientSide(this.merchantPoints));
        }
        else
        {
            Withernauts.packetHandler.sendTo(new SyncPlayerMerchantServerSide(this.merchantPoints),(EntityPlayerMP) this.player);
        }
    }

    public void addMerchantPoints(int val)
    {
        this.merchantPoints+= val;
    }

    public void setMerchantPoints(int val)
    {
        this.merchantPoints = val;
    }

    public int getMerchantPoints()
    {
        return this.merchantPoints;
    }

    public void setArteAtIndices(boolean isPrimary, int[] args)
    {
        if (args.length == 9 && isArrayEmpty(args) == false)
        {
            for (int i = 0; i < 9; i++)
            {
                if (isPrimary)
                    this.primaryArtes[i] = args[i];
                else
                    this.secondaryArtes[i] = args[i];
            }
        }
        else
        {
            if (this.current_class == 0 || this.current_class == 3)
            {
                if (isPrimary)
                {
                    for (int i = 0; i < 3; i++)
                        primaryArtes[i] = ArteHandler.ARTES.QUICK_SLASH.ordinal();
                    for (int i = 3; i < 6; i++)
                        primaryArtes[i] = ArteHandler.ARTES.SCATTERING_SLASH.ordinal();
                    for (int i = 6; i < 9; i++)
                        primaryArtes[i] = ArteHandler.ARTES.DEMON_FANG.ordinal();
                }
                else
                {
                    for (int i = 0; i < 9; i++)
                        secondaryArtes[i] = -1;
                }
            }
            else if (this.current_class == 1 || this.current_class == 5)
            {
                if (isPrimary)
                {
                    for (int i = 0; i < 3; i++)
                        primaryArtes[i] = ArteHandler.ARTES.FLECHE.ordinal();
                    for (int i = 3; i < 6; i++)
                        primaryArtes[i] = ArteHandler.ARTES.DIVIDING_EDGE.ordinal();
                    for (int i = 6; i < 9; i++)
                        primaryArtes[i] = ArteHandler.ARTES.FIRST_AID.ordinal();
                }
                else
                {
                    for (int i = 0; i < 9; i++)
                        secondaryArtes[i] = -1;
                }
            }
            else if (this.current_class == 2)
            {
                if (isPrimary)
                {
                    for (int i = 0; i < 3; i++)
                        primaryArtes[i] = ArteHandler.ARTES.FLECHE.ordinal();
                    for (int i = 3; i < 6; i++)
                        primaryArtes[i] = ArteHandler.ARTES.DIVIDING_EDGE.ordinal();
                    for (int i = 6; i < 9; i++)
                        primaryArtes[i] = ArteHandler.ARTES.FIRST_AID.ordinal();
                }
                else
                {
                    for (int i = 0; i < 9; i++)
                        secondaryArtes[i] = ArteHandler.ARTES.FIRE_BALL.ordinal();
                }
            }
            else if (this.current_class == 4)
            {
                if (isPrimary)
                {
                    for (int i = 0; i < 3; i++)
                        primaryArtes[i] = ArteHandler.ARTES.QUICK_SLASH.ordinal();
                    for (int i = 3; i < 6; i++)
                        primaryArtes[i] = ArteHandler.ARTES.SCATTERING_SLASH.ordinal();
                    for (int i = 6; i < 9; i++)
                        primaryArtes[i] = ArteHandler.ARTES.DEMON_FANG.ordinal();
                }
                else
                {
                    for (int i = 0; i < 9; i++)
                        secondaryArtes[i] = ArteHandler.ARTES.COILING_SERPENT.ordinal();
                }
            }
            else
            {
                System.out.print("whatdefok");
                System.out.printf("%n");
            }
        }
    }

    public void setArteAtIndex(boolean isPrimary, int i1, int i2)  //i2 is the index within the full list of artes
    {
        if (isPrimary)
            this.primaryArtes[i1] = primaryArtes[i2];
        else
            this.secondaryArtes[i1] = secondaryArtes[i2];
    }
    public void setArteAtGlobalIndex(boolean isPrimary, int i1, int i2)
    {
        if (isPrimary)
            this.primaryArtes[i1] = i2;
        else
            this.secondaryArtes[i1] = i2;
    }

    public void setMouseClick(int key)
    {
        this.currentCol = key;
    }
    public void set_class(int key)
    {
        if (key == -1)
            this.current_class = 0;
        else
            this.current_class = key;
    }
    public int getCurrent_weapon()
    {
        return this.current_weapon;
    }
    public int [] getClassWeapons()
    {
        return n_classes.t_classes[current_class].getClassWeapons();
    }
    public void setWeaponCheck()
    {

        if (player.getHeldItemMainhand().getItem() instanceof ItemNecropolisWeapon)
        {
            if (this.player.ticksExisted % 400 == 0)
                ((ItemNecropolisWeapon)player.getHeldItemMainhand().getItem()).doPassive(this.player);
        }

        if (player.getHeldItemMainhand().getItem() instanceof ItemDiamondRapier ||
                player.getHeldItemMainhand().getItem() instanceof ItemIronRapier ||
                player.getHeldItemMainhand().getItem() instanceof ItemGoldRapier ||
                player.getHeldItemMainhand().getItem() instanceof ItemStoneRapier ||
                player.getHeldItemMainhand().getItem() instanceof ItemWoodenRapier || player.getHeldItemMainhand().getItem() instanceof ItemNecropolisRapier)
        {
            this.setCurrentWeapon(1);
        }
        else if (player.getHeldItemMainhand().getItem() instanceof ItemNecropolisTome)
        {
            this.setCurrentWeapon(2);
        }
        else if (player.getHeldItemMainhand().getItem() instanceof ItemNecropolisSpear)
        {
            this.setCurrentWeapon(3);
        }
        else if (player.getHeldItemMainhand().getItem() instanceof ItemNecropolisSword || player.getHeldItemMainhand().getItem() instanceof ItemSword)
        {
            this.setCurrentWeapon(0);
        }
        else
        {
            this.setCurrentWeapon(-1);
        }
    }
    public void setCurrentWeapon(int weapon_key)
    {
        this.prev_weapon = this.current_weapon;
        this.current_weapon = weapon_key;

        if (this.current_weapon != this.prev_weapon)
        {
            this.inBufferZone = true;
            this.activatepArte = false;
            this.pArteCoolDown = 0;
            this.currentpArte = 0;

            bindArteToCurrentWeapon();
        }
    }

    public int getQuestType(int id)
    {
        return this.questHandler.getQuestType(id);
    }

    public ItemStack getQuestStack(int id)
    {
        return this.questHandler.getQuestItemStack(id);
    }

    public void bindArteToCurrentWeapon()
    {
        if (this.current_class == 0 || this.current_class == 1 || this.current_class == 3 || this.current_class == 5)
        {
            this.bindedArtes = this.primaryArtes;
        }
        else
        {
            if (this.current_weapon == n_classes.t_classes[current_class].getClassWeapons()[0])
            {
                this.bindedArtes = this.primaryArtes;
            }
            else
            {
                if (this.current_weapon != n_classes.t_classes[current_class].getClassWeapons()[1])
                    return;
                this.bindedArtes = this.secondaryArtes;
            }
        }
        Withernauts.packetHandler.sendToServer(new SyncArtesOnClient( this.bindedArtes, arteCount, -1));
    }

    public void updateStatsBoost()
    {
        for (int i = 0; i < this.buff_cooldown.length; i++)
        {
            if (this.buff_cooldown[i] > 0)
            {
                this.buff_cooldown[i]--;
            }
        }
    }

    public void setStatBoost(int[] stats)
    {
        if (stats.length == 4)
        {
            for (int i = 0; i < stats.length; i++)
            {
                if (stats[i] > 0 && this.buff_cooldown[i] == 0)
                {
                    this.buff_cooldown[i] = stats[i];
                }
            }
        }
        else
        {
            for (int i = 0; i < this.buff_cooldown.length; i++)
            {
                this.buff_cooldown[i] = 0;
            }
        }
        if (!this.player.world.isRemote)
        {
            Withernauts.packetHandler.sendTo(new SyncPlayerStatsServerSide(this.playerMana, this.getStatBoost()),(EntityPlayerMP) this.player);
        }
    }
    public int[] getStatBoost()
    {
        return this.buff_cooldown;
    }

    public int get_class()
    {
        return this.current_class;
    }
    public int getArteAtIndex(boolean isPrimary, int i1)
    {
        if (isPrimary)
            return this.primaryArtes[i1];
        else
            return this.secondaryArtes[i1];
    }
    public int[] getArteAtIndices(boolean isPrimary)
    {
        if (isPrimary)
            return this.primaryArtes;
        else
            return this.secondaryArtes;
    }
    public boolean getInBufferZone()
    {
        return this.inBufferZone;
    }
    public int getCurrentpArte()
    {
        return bindedArtes[this.currentpArte + this.currentCol * 3];
    }
    public int getCurrentArteIndex()
    {
        return this.currentpArte + this.currentCol * 3;
    }
    public boolean is_special_attack()
    {
        return (artes.t_arte[bindedArtes[this.currentpArte + this.currentCol * 3]] instanceof SpecialArte);
    }
    public int[] getPlayerStats()
    {
        int[] stats = new int[4];

        int player_level = this.player.experienceLevel;

        int boon = 5;
        int bane = 3;

        double boon_stat = 2 * Math.log10(Math.pow(player_level, 4) + 3.0);
        double bane_stat = 1.5 * Math.log10(Math.pow(player_level, 4.0) + 3.0);

        if (current_class == 0 )
        {
            stats[0] = (int)(boon + boon_stat);
            stats[1] = (int)(bane + bane_stat);
            stats[2] = (int)(boon + boon_stat - 3);
            stats[3] = (int)(bane + bane_stat - 3);
        }
        else if (current_class == 3)
        {
            stats[0] = (int)(boon + boon_stat + 1);
            stats[1] = (int)(bane + bane_stat);
            stats[2] = (int)(boon + boon_stat);
            stats[3] = (int)(bane + bane_stat - 2);
        }
        else if (current_class == 4)
        {
            stats[0] = (int)(boon + boon_stat + 1);
            stats[1] = (int)(bane + bane_stat);
            stats[2] = (int)(boon + boon_stat - 1);
            stats[3] = (int)(bane + bane_stat - 1);
        }
        else if (current_class == 1)
        {
            stats[0] = (int)(bane + bane_stat);
            stats[1] = (int)(boon + boon_stat);
            stats[2] = (int)(bane + bane_stat - 3);
            stats[3] = (int)(boon + boon_stat - 3);

        }
        else if (current_class == 2)
        {
            stats[0] = (int)(bane + bane_stat - 2);
            stats[1] = (int)(boon + boon_stat + 3);
            stats[2] = (int)(bane + bane_stat - 1);
            stats[3] = (int)(boon + boon_stat - 1);
        }
        else if (current_class == 5)
        {
            stats[0] = (int)(bane + bane_stat + 2);
            stats[1] = (int)(boon + boon_stat);
            stats[2] = (int)(bane + bane_stat - 1);
            stats[3] = (int)(boon + boon_stat - 2);
        }
        for (ItemStack mItem : this.player.getEquipmentAndArmor())
        {
            if (mItem.getItem() instanceof ItemNecropolisArmor)
            {
                stats[0] += ((ItemNecropolisArmor) mItem.getItem()).getAtkBoost(false);
                stats[1] += ((ItemNecropolisArmor) mItem.getItem()).getAtkBoost(true);
            }
        }

        if (this.player.getHeldItemMainhand().getItem() instanceof ItemNecropolisWeapon)
        {
            if (((ItemNecropolisWeapon)this.player.getHeldItemMainhand().getItem()).stringContains("Magic Shield"))
            {
                stats[3] += Math.max(2, stats[3] * 0.35);
            }
            if (((ItemNecropolisWeapon)this.player.getHeldItemMainhand().getItem()).stringContains("Guard Plus"))
            {
                stats[2] += Math.max(2, stats[2] * 0.15);
                stats[3] += Math.max(2, stats[3] * 0.15);
            }
            if (((ItemNecropolisWeapon)this.player.getHeldItemMainhand().getItem()).stringContains("Defend Conversion"))
            {
                stats[2] += Math.max(2, stats[3] * 0.3);
            }
            if (((ItemNecropolisWeapon)this.player.getHeldItemMainhand().getItem()).stringContains("TP Condition"))
            {
                if (this.getMana() > 256.0f * 0.85F)
                {
                    stats[2] += Math.max(2, stats[2] * 0.35);
                }
            }
            if (((ItemNecropolisWeapon)this.player.getHeldItemMainhand().getItem()).stringContains("TP Condition 2"))
            {
                if (this.getMana() > 256.0f * 0.7F)
                {
                    stats[2] += Math.max(2, stats[2] * 0.4);
                }
            }
            if (((ItemNecropolisWeapon)this.player.getHeldItemMainhand().getItem()).stringContains("Light Magic"))
            {
                stats[1] = (int)(stats[1] * 0.75);
            }
            if (((ItemNecropolisWeapon)this.player.getHeldItemMainhand().getItem()).stringContains("Heavy Magic"))
            {
                stats[1] = (int)(stats[1] * 1.3);
            }
            if (((ItemNecropolisWeapon)this.player.getHeldItemMainhand().getItem()).stringContains("Fatal Exceed"))
            {
                if (this.player.getHealth() < 8.0f)
                {
                    stats[1] += Math.max(2, stats[1] * 0.35f);
                }
            }
        }
        stats[2] += getArmor(false);
        stats[3] += getArmor(true);

        return stats;
    }

    public int get_current_stage()
    {
        int running_length = 0;
        int current_stage = 0;
        for (int i = 0; i < artes.t_arte[bindedArtes[this.currentpArte + this.currentCol * 3]].getStages().length; i++)
        {
            running_length+=artes.t_arte[bindedArtes[this.currentpArte + this.currentCol * 3]].getStages()[i];
            if (this.pArteCoolDown <= running_length)
            {
                current_stage = i;
                break;
            }
        }
        return current_stage;
    }
    public int get_stage_cooldown()
    {
        int current_stage = get_current_stage();

        int stagecooldown = this.pArteCoolDown;

        for (int i = 0; i < current_stage; i++)
        {
            stagecooldown -=  (artes.t_arte[bindedArtes[this.currentpArte + this.currentCol * 3]].getStages()[i]);
        }
        return stagecooldown;
    }
    public int getCurrentArteTP(int test_col)
    {
        return artes.t_arte[bindedArtes[this.currentpArte + test_col * 3]].getTPCost();
    }
    public float getpArteTime(float partialtick)
    {
        this.prev_artetime = this.current_artetime;

        int current_stage = get_current_stage();
        int stage_action_time = artes.t_arte[bindedArtes[this.currentpArte + this.currentCol * 3]].getStages()[current_stage];

        int stagecooldown = get_stage_cooldown();
        this.current_artetime = (float)stagecooldown / (float)stage_action_time;
        float f = this.current_artetime - this.prev_artetime;

        if (f < 0.0F)
        {
            ++f;
        }

        return this.prev_artetime + f * partialtick;
    }
    public float getMana()
    {
        return this.playerMana;
    }
    public float getManaRegenTime()
    {
        return this.manaRegenTime;
    }

    @Override
    public void serialize(NBTTagCompound nbt)
    {
        System.out.print("WRITING THINGIE");
        System.out.printf("%n");
        nbt.setFloat("mana", getMana());
    }
    @Override
    public void deserialize(NBTTagCompound nbt)
    {
        System.out.print("READING THINGIE");
        System.out.printf("%n");
        if (nbt.hasKey("mana"))
            setMana(nbt.getFloat("mana"));
    }
    //Helpers
    private void initializeArtes()
    {
        for (int i = 0; i < ARTE_LENGTH; i++)
        {
            bindedArtes[i] = -1;
            this.primaryArtes[i] = -1;
            this.secondaryArtes[i] = -1;
        }
    }

    private void initializeQuestStatus()
    {
        for (int i = 0; i < QUEST_LENGTH; i++)
        {
            this.questStatus[i] = -1;
        }
    }

    private void initializeBufferCooldowns()
    {
        for (int i = 0; i < BUFFER_LENGTH; i++)
        {
            buff_cooldown[i] = 0;
        }
    }
    private void initializeArteUsageCount()
    {
        for (int i = 0; i < arteCount.length; i++)
        {
            arteCount[i] = 0;
        }
    }

    private void initializeDialogueVar()
    {
        this.current_quest = -1;
        this.current_quest_status = -1;
        this.current_page = 0;
        this.initializeQuestStatus();
    }

    private void initializeMerchantVar()
    {
        this.merchantPoints = 0;
    }

    private void initializeManaVar()
    {
        this.regenRate = 1.0F;
        this.manaRegenTime = 1.25F;
        this.regenTime = 0;
        this.playermaxMana = 256;
        this.playerMana = playermaxMana;
    }

}
