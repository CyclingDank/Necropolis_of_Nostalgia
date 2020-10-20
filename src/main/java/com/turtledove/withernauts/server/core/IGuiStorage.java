package com.turtledove.withernauts.server.core;

import com.turtledove.withernauts.client.gui.INecropolisItemHandler;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class IGuiStorage implements IStorage<INecropolisItemHandler>
{
    @Override
    public NBTBase writeNBT(Capability<INecropolisItemHandler> capability, INecropolisItemHandler instance, EnumFacing side)
    {
        return instance.serializeNBT();
    }

    @Override
    public void readNBT(Capability<INecropolisItemHandler> capability, INecropolisItemHandler instance, EnumFacing side, NBTBase nbt)
    {
        NBTTagCompound nbtBase = (NBTTagCompound) nbt;
        instance.deserializeNBT(nbtBase);
    }
}
