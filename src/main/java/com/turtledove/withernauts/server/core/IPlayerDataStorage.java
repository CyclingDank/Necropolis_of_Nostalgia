package com.turtledove.withernauts.server.core;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class IPlayerDataStorage implements IStorage<IPlayerData>
{
    @Override
    public NBTBase writeNBT(Capability<IPlayerData> capability, IPlayerData instance, EnumFacing side)
    {
        NBTTagCompound nbtBase = new NBTTagCompound();
        nbtBase.setFloat("mana", instance.getMana());
        nbtBase.setFloat("m_regen", instance.getManaRegenTime());
        nbtBase.setInteger("player_class", instance.get_class());
        nbtBase.setIntArray("primary_artes", instance.getArteAtIndices(true));
        nbtBase.setIntArray("secondary_artes", instance.getArteAtIndices(false));
        nbtBase.setIntArray("boosted_stats", instance.getStatBoost());
        nbtBase.setIntArray("arte_count", instance.getArteCount());
        nbtBase.setBoolean("is_oldface", instance.get_oldface());
        nbtBase.setInteger("merchant_points", instance.getMerchantPoints());
        nbtBase.setIntArray("quest_status", instance.getQuestStatus());
        return nbtBase;
    }

    @Override
    public void readNBT(Capability<IPlayerData> capability, IPlayerData instance, EnumFacing side, NBTBase nbt)
    {
        NBTTagCompound nbtBase = (NBTTagCompound) nbt;
        instance.setMana(nbtBase.getFloat("mana"));
        instance.setManaRegen(nbtBase.getFloat("m_regen"));
        instance.set_class(nbtBase.getInteger("player_class"));
        instance.setArteAtIndices(true, nbtBase.getIntArray("primary_artes"));
        instance.setArteAtIndices(false, nbtBase.getIntArray("secondary_artes"));
        instance.setStatBoost(nbtBase.getIntArray("boosted_stats"));
        instance.setArteCount(nbtBase.getIntArray("arte_count"));
        instance.set_oldface(nbtBase.getBoolean("is_oldface"));
        instance.setMerchantPoints(nbtBase.getInteger("merchant_points"));
        instance.setQuestStatus(nbtBase.getIntArray("quest_status"));
    }
}
