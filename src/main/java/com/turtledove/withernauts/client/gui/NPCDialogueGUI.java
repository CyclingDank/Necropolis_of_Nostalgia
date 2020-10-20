package com.turtledove.withernauts.client.gui;

import com.turtledove.withernauts.server.core.NecropolisPlayerData;
import com.turtledove.withernauts.server.core.PlayerData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

public class NPCDialogueGUI extends Gui
{

    public NPCDialogueGUI(Minecraft mc)
    {
        ScaledResolution scaled = new ScaledResolution(mc);
        int width = scaled.getScaledWidth();
        int height = scaled.getScaledHeight();

        int x = width / 2 - 91;
        int y = height - 60;

        int j = 0;
        int k = 5;

        PlayerData data = (PlayerData) NecropolisPlayerData.get(mc.getMinecraft().player);

        drawCenteredString(mc.fontRenderer, data.getDialogue(), width / 2, y, Integer.parseInt("81f731", 16));
    }
}