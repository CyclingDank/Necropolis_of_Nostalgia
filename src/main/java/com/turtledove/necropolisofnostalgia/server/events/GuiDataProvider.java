package com.turtledove.necropolisofnostalgia.server.events;

import com.turtledove.necropolisofnostalgia.client.gui.NecropolisItemHandler;
import com.turtledove.necropolisofnostalgia.server.core.PlayerData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;

public class GuiDataProvider  implements ICapabilitySerializable<NBTTagCompound>
{
    private NecropolisItemHandler data;

    public GuiDataProvider(EntityPlayer player)
    {
        this.data = new NecropolisItemHandler();
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, EnumFacing facing)
    {
        return capability == NecropolisCapabilities.ITEM_HANDLER_CAPABILITY;
    }

    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, EnumFacing facing)
    {
        if (hasCapability(capability, facing))
        {
            return NecropolisCapabilities.ITEM_HANDLER_CAPABILITY.cast(data);
        }
        return null;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt)
    {
        NecropolisCapabilities.ITEM_HANDLER_CAPABILITY.readNBT( data,null,nbt);
    }

    @Override
    public NBTTagCompound serializeNBT()
    {
        return (NBTTagCompound) NecropolisCapabilities.ITEM_HANDLER_CAPABILITY.writeNBT(data, null);
    }
}
