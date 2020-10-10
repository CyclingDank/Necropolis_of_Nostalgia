package com.turtledove.necropolisofnostalgia.server.core;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.Vec3d;

public interface IPlayerData
{
    public void consumeMana(float points);

    public void fillMana(float points);
    public void doAttack(int key, int stage);
    public void setcurrentPArte(int key);
    public void setMana(float points);
    public boolean getInBufferZone();
    public int getCurrentArteIndex();
    public float getMana();
    public float getManaRegenTime();
    public void setManaRegen(float points);
    public void setArteAtIndices(boolean isPrimary, int[] args);
    public int[] getArteAtIndices(boolean isPrimary);
    public void setArteAtIndex(boolean isPrimary, int i1, int i2);
    public void setStatBoost(int[] stats);
    public void setBindedArtes(int[] args);
    public int getMerchantPoints();
    public void syncMerchantPoints();
    public void addMerchantPoints(int val);
    public void setMerchantPoints(int val);
    public void setQuestStatus(int[]args);
    public int[] getQuestStatus();
    public void syncQuests();
    public int[] getArteCount();
    public int getQuestType(int id);
    public ItemStack getQuestStack(int id);
    public boolean doDialogue();
    public void doDialogueGUIControlls();
    public void setArteCount(int[]count);
    public int[] getStatBoost();
    public boolean is_special_attack();
    public int get_current_stage();
    public int[] getPlayerStats();
    public int getCurrentArteTP(int test_col);
    public int getArteAtIndex(boolean isPrimary, int i1);
    public void setMouseClick(int key);
    public void set_class(int key);
    public int get_class( );
    public void activateArte(int arteIndex);

    public void set_oldface(boolean val);
    public boolean get_oldface();

    public void serialize(NBTTagCompound nbt);
    public void deserialize(NBTTagCompound nbt);
}
