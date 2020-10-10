package com.turtledove.necropolisofnostalgia.client.gui;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.server.core.NecropolisPlayerData;
import com.turtledove.necropolisofnostalgia.server.core.PlayerData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class PlayerSoulsGUI extends Gui
{
    private static final ResourceLocation TP_BAR = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/gui/souls_display.png");

    public PlayerSoulsGUI(Minecraft mc)
    {
        ScaledResolution scaled = new ScaledResolution(mc);
        int width = scaled.getScaledWidth();
        int height = scaled.getScaledHeight();

        int x = width/2 + 90;
        int y = height - 23;

        int j = 0;
        int k = 0;

        EntityPlayer player = Minecraft.getMinecraft().player;
        int a = player.experienceLevel;

        double totalExp_1 = this.getExpTotal(a);
        int xpCap = player.xpBarCap();

        int xpTotal = (int)totalExp_1 + (int)(xpCap * player.experience);

        mc.getTextureManager().bindTexture(TP_BAR);

        GlStateManager.color(1F, 1F, 1F); //Forge: Reset color in case Items change it.
        GlStateManager.enableBlend(); //Forge: Make sure blend is enabled else tabs show a white border.
        GlStateManager.enableAlpha();
        this.drawTexturedModalRect(x, y, j, k, 36, 23);

        this.drawString(mc.fontRenderer, Integer.toString(xpTotal), x+3, y+3, Integer.parseInt("FFFFFF", 16));
        this.drawString(mc.fontRenderer, Integer.toString(a), x+ 3, y + 10 +3, Integer.parseInt("FFFFFF", 16));
        GlStateManager.disableAlpha();
    }
    public double getExpTotal(int x)
    {
        double totalExp = 0;
        if (x < 17)
        {
            totalExp = x * x + 6 * x;
        }
        else if (x < 32)
        {
            totalExp = 2.5 * x * x - 40.5 * x + 360;
        }
        else
        {
            totalExp = 4.5 * x * x - 162.5 * x + 2200;
        }
        return totalExp;
    }
}