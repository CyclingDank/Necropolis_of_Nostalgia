package com.turtledove.withernauts.server.events;

import com.turtledove.withernauts.server.core.IPlayerData;
import com.turtledove.withernauts.server.core.PlayerData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;

public class PlayerDataProvider implements ICapabilitySerializable<NBTTagCompound>
{
    private IPlayerData data = NecropolisCapabilities.PLAYER_DATA_CAPABILITY.getDefaultInstance();
    private EntityPlayer tmp;

    public PlayerDataProvider(EntityPlayer player)
    {
        this.data = new PlayerData(player);
        this.tmp = player;
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, EnumFacing facing)
    {
        return capability == NecropolisCapabilities.PLAYER_DATA_CAPABILITY;
    }

    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, EnumFacing facing)
    {
        if (hasCapability(capability, facing)) {
            return NecropolisCapabilities.PLAYER_DATA_CAPABILITY.cast(data);
        }
        return null;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt)
    {
        NecropolisCapabilities.PLAYER_DATA_CAPABILITY.readNBT(data, null, nbt);
    }

    @Override
    public NBTTagCompound serializeNBT()
    {
        NBTTagCompound tmp = (NBTTagCompound) NecropolisCapabilities.PLAYER_DATA_CAPABILITY.writeNBT(data, null);
        return tmp;
    }
}
