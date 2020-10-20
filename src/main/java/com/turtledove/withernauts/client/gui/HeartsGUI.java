package com.turtledove.withernauts.client.gui;

import com.turtledove.withernauts.Necropolis_of_Nostalgia;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class HeartsGUI  extends Gui
{
    private static final ResourceLocation ICONS = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/gui/icons.png");
    public HeartsGUI(Minecraft mc)
    {
        ScaledResolution scaled = new ScaledResolution(mc);
        int width = scaled.getScaledWidth();
        int height = scaled.getScaledHeight();

        int x = width / 2 - 91;
        int y = height - 29 - 14;

        mc.getTextureManager().bindTexture(ICONS);

        float player_health = mc.getMinecraft().player.getHealth() - 1;
        int num_hearts = (int)(player_health / 4.0f);
        int max_hearts = (int)( mc.getMinecraft().player.getMaxHealth() / 4.0f);

        for(int i = 0; i < max_hearts; i++)
        {
            if (i != num_hearts || mc.getMinecraft().player.getHealth() == 0 )
            {
                int j = 9;
                int k = 0;

                GlStateManager.color(1F, 1F, 1F); //Forge: Reset color in case Items change it.
                GlStateManager.enableBlend(); //Forge: Make sure blend is enabled else tabs show a white border.
                this.drawTexturedModalRect(x + 9 * i, y, j, k, 9, 9);
            }
        }
        for(int i = 0; i < num_hearts; i++)
        {
            int j = 0;
            int k = 0;

            if (mc.getMinecraft().player.isPotionActive(Potion.getPotionById(19)))
            {
                k+=9;
            }

            GlStateManager.color(1F, 1F, 1F); //Forge: Reset color in case Items change it.
            GlStateManager.enableBlend(); //Forge: Make sure blend is enabled else tabs show a white border.
            this.drawTexturedModalRect(x + 9 * i, y, j, k, 9, 9);
        }
        if (player_health >= 0.0)
        {
            int remainder = ((int)player_health - (int)(num_hearts * 4.0f));
            int j = 18 + 11 * remainder;
            int k = 0;

            if (mc.getMinecraft().player.isPotionActive(Potion.getPotionById(19)))
            {
                k+=11;
            }

            GlStateManager.color(1F, 1F, 1F); //Forge: Reset color in case Items change it.
            GlStateManager.enableBlend(); //Forge: Make sure blend is enabled else tabs show a white border.
            this.drawTexturedModalRect(x + 9 * (num_hearts) - 1, y - 1, j, k, 11, 11);
        }
    }
}
