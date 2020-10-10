package com.turtledove.necropolisofnostalgia.server.core;

import com.turtledove.necropolisofnostalgia.server.events.NecropolisCapabilities;
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
