package com.turtledove.withernauts.client.gui;

import com.turtledove.withernauts.Necropolis_of_Nostalgia;
import com.turtledove.withernauts.server.core.NecropolisPlayerData;
import com.turtledove.withernauts.server.core.PlayerData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class StaminaMeterGUI extends Gui
{
    private static final ResourceLocation TP_BAR = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/gui/xp_bar.png");

    public StaminaMeterGUI(Minecraft mc)
    {
        PlayerData data = (PlayerData) NecropolisPlayerData.get(mc.getMinecraft().player);
        ScaledResolution scaled = new ScaledResolution(mc);
        int width = scaled.getScaledWidth();
        int height = scaled.getScaledHeight();

        int x = width / 2 - 91;
        int y = height - 34;

        int j = 0;
        int k = 15;

        int stamina = data.getPlayerStamina();

        float s_ratio;

        if (stamina > 400 && stamina < 801)
        {
            s_ratio = (stamina - 400) / 400.0f;
            k +=5;
        }
        else if (stamina > 800 && stamina < 1201)
        {
            s_ratio = (stamina - 800) / 400.0f;
            k +=10;
        }
        else if (stamina > 1200 && stamina < 1601)
        {
            s_ratio = (stamina - 1200) / 400.0f;
            k +=15;
        }
        else
        {
            s_ratio = data.getPlayerStamina() / 400.0f;
        }

        int s_width = (int)(182.0f * s_ratio);

        mc.getTextureManager().bindTexture(TP_BAR);

        GlStateManager.color(1F, 1F, 1F); //Forge: Reset color in case Items change it.
        GlStateManager.enableBlend(); //Forge: Make sure blend is enabled else tabs show a white border.
        this.drawTexturedModalRect(x, y, j, k - 5, 182, 5);

        if (data.isStaminaPunished())
        {
            k = 35;
        }

        GlStateManager.color(1F, 1F, 1F); //Forge: Reset color in case Items change it.
        GlStateManager.enableBlend(); //Forge: Make sure blend is enabled else tabs show a white border.
        this.drawTexturedModalRect(x, y, j, k, s_width, 5);


        //this.drawCenteredString(mc.fontRenderer, Integer.toString(data.getPlayerStamina()), width/2, height/2, Integer.parseInt("81f731", 16));
    }
}
