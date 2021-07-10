package com.turtledove.necropolisofnostalgia.gui;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;

public class GuiWithernautsConfig extends GuiConfig
{
    public GuiWithernautsConfig(GuiScreen parent) {
        super(parent, new ConfigElement(Necropolis_of_Nostalgia.config.getCategory("all")).getChildElements(), Necropolis_of_Nostalgia.MODID, false, false, "Withernauts Zoology Config");
        titleLine2 = Necropolis_of_Nostalgia.config.getConfigFile().getAbsolutePath();
    }

    @Override
    public void onGuiClosed()
    {
        super.onGuiClosed();
    }
}
