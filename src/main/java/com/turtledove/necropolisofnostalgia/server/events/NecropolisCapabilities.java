package com.turtledove.necropolisofnostalgia.server.events;

import com.turtledove.necropolisofnostalgia.client.gui.INecropolisItemHandler;
import com.turtledove.necropolisofnostalgia.server.core.IPlayerData;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class NecropolisCapabilities
{
    @CapabilityInject(IPlayerData.class)
    public static Capability<IPlayerData> PLAYER_DATA_CAPABILITY = null;

    @CapabilityInject(INecropolisItemHandler.class)
    public static Capability<INecropolisItemHandler> ITEM_HANDLER_CAPABILITY = null;
}
