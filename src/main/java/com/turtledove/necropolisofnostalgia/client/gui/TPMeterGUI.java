package com.turtledove.necropolisofnostalgia.client.gui;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.server.core.NecropolisPlayerData;
import com.turtledove.necropolisofnostalgia.server.core.PlayerData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class TPMeterGUI extends Gui
{
    private static final ResourceLocation TP_BAR = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/gui/xp_bar.png");

    public TPMeterGUI(Minecraft mc)
    {
        ScaledResolution scaled = new ScaledResolution(mc);
        int width = scaled.getScaledWidth();
        int height = scaled.getScaledHeight();

        int x = width / 2 - 91;
        int y = height - 32 + 3;

        int j = 0;
        int k = 5;

        PlayerData data = (PlayerData) NecropolisPlayerData.get(mc.getMinecraft().player);

        float tp_ratio = data.getMana() / 256.0f;
        int tp_width = (int)(182.0f * tp_ratio);

        mc.getTextureManager().bindTexture(TP_BAR);

        GlStateManager.color(1F, 1F, 1F); //Forge: Reset color in case Items change it.
        GlStateManager.enableBlend(); //Forge: Make sure blend is enabled else tabs show a white border.
        this.drawTexturedModalRect(x, y, j, k - 5, 182, 5);

        GlStateManager.color(1F, 1F, 1F); //Forge: Reset color in case Items change it.
        GlStateManager.enableBlend(); //Forge: Make sure blend is enabled else tabs show a white border.
        this.drawTexturedModalRect(x, y, j, k, tp_width, 5);

        //drawCenteredString(mc.fontRenderer, Integer.toString((int)data.getMana()), width / 2, y - 2, Integer.parseInt("81f731", 16));
    }
}
