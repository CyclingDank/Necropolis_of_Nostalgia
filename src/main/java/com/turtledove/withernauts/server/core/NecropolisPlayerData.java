package com.turtledove.withernauts.server.core;

import com.turtledove.withernauts.server.events.NecropolisCapabilities;
import net.minecraft.entity.player.EntityPlayer;

import javax.annotation.Nullable;

public class NecropolisPlayerData
{
    @Nullable
    public static IPlayerData get(EntityPlayer player) {
        if (player.hasCapability(NecropolisCapabilities.PLAYER_DATA_CAPABILITY, null)) {
            return player.getCapability(NecropolisCapabilities.PLAYER_DATA_CAPABILITY, null);
        }
        return null;
    }
}
