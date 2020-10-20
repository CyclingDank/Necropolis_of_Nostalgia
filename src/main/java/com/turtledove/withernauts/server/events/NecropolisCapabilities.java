package com.turtledove.withernauts.server.events;

import com.turtledove.withernauts.client.gui.INecropolisItemHandler;
import com.turtledove.withernauts.server.core.IPlayerData;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class NecropolisCapabilities
{
    @CapabilityInject(IPlayerData.class)
    public static Capability<IPlayerData> PLAYER_DATA_CAPABILITY = null;

    @CapabilityInject(INecropolisItemHandler.class)
    public static Capability<INecropolisItemHandler> ITEM_HANDLER_CAPABILITY = null;
}
