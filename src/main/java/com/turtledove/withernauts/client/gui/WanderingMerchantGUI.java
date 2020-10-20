package com.turtledove.withernauts.client.gui;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.server.core.IPlayerData;
import com.turtledove.withernauts.server.events.NecropolisCapabilities;
import com.turtledove.withernauts.server.item.ItemHandler;
import com.turtledove.withernauts.server.packets.Player.SyncPlayerExperience;
import com.turtledove.withernauts.server.packets.Player.WMSpawnItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;

import java.io.IOException;

public class WanderingMerchantGUI extends GuiScreen
{
    private static final ResourceLocation WM_GUI = new ResourceLocation(Withernauts.MODID,"textures/gui/wm_gui.png");
    private static final ResourceLocation WM_CLOSED_GUI = new ResourceLocation(Withernauts.MODID,"textures/gui/wm_closed_gui.png");

    private static final ResourceLocation WM_BUTTONS = new ResourceLocation(Withernauts.MODID,"textures/gui/wm_buttons.png");

    protected int guiLeft;
    protected int guiTop;

    protected int xSize = 176;
    protected int ySize = 166;

    int count = 1;

    private boolean ignoreMouseUp;

    private String welcomeText1 = "Welcome to Turtledove's! Your membership is ";
    private String welcomeText2 = ", shop with any of my siblings to raise your membership. It'll get ya rarer goods and steep discounts.";

    private String priceText = "Souls required: ";

    int selectedTab;
    int selectedItem;

    public WanderingMerchantGUI(EntityPlayer playerIn)
    {
        super();
        this.allowUserInput = true;
        this.ignoreMouseUp = true;

        this.selectedTab = 0;
        this.selectedItem = -1;
    }

    @Override
    public void initGui()
    {
        super.initGui();
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;

        this.allowUserInput = true;
        this.ignoreMouseUp = true;
    }

    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return true;
    }

    @Override
    public void onGuiClosed()
    {
        IPlayerData iData = Minecraft.getMinecraft().player.getCapability(NecropolisCapabilities.PLAYER_DATA_CAPABILITY, null);
        iData.syncMerchantPoints();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        int i = this.guiLeft;
        int j = this.guiTop;

        this.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    }

    protected void drawMembershipTab(int index)
    {
        int l = this.guiLeft + 7 + index * 11;
        int i1 = this.guiTop + 7;

        int j = 0;

        if (index == this.selectedTab)
            j = 11;

        IPlayerData iData = Minecraft.getMinecraft().player.getCapability(NecropolisCapabilities.PLAYER_DATA_CAPABILITY, null);
        int merchantPoints = iData.getMerchantPoints();

        if ((index == 1 && merchantPoints < 50) || (index == 2 && merchantPoints < 100) || (index == 3 && merchantPoints < 500) || (index == 4 && merchantPoints < 1000))
            j = 22;

            GlStateManager.disableLighting();
        GlStateManager.color(1F, 1F, 1F); //Forge: Reset color in case Items change it.
        GlStateManager.enableBlend(); //Forge: Make sure blend is enabled else tabs show a white border.

        this.mc.getTextureManager().bindTexture(WM_BUTTONS);
        this.drawTexturedModalRect(l, i1, 0, j, 11, 11);

        GlStateManager.enableLighting();
        GlStateManager.enableRescaleNormal();
    }

    protected void drawProducts(int index)
    {
        int l = this.guiLeft + 7;
        int i1 = this.guiTop + 18 + index * 18;

        int j = 0;

        if (index == this.selectedItem)
            j = 18;

        IPlayerData iData = Minecraft.getMinecraft().player.getCapability(NecropolisCapabilities.PLAYER_DATA_CAPABILITY, null);
        int merchantPoints = iData.getMerchantPoints();

        if ((this.selectedTab == 1 && merchantPoints < 50) || (this.selectedTab == 2 && merchantPoints < 100) || (this.selectedTab == 3 && merchantPoints < 500) || (this.selectedTab == 4 && merchantPoints < 1000))
            j = 36;

        GlStateManager.disableLighting();
        GlStateManager.color(1F, 1F, 1F); //Forge: Reset color in case Items change it.
        GlStateManager.enableBlend(); //Forge: Make sure blend is enabled else tabs show a white border.

        this.mc.getTextureManager().bindTexture(WM_BUTTONS);
        this.drawTexturedModalRect(l, i1, 11, j, 18, 18);

        GlStateManager.enableLighting();
        GlStateManager.enableRescaleNormal();
    }


    protected void drawItemIcons(int index)
    {
        int l = this.guiLeft + 8;
        int i1 = this.guiTop + 19 + index * 18;

        Item pItems[] = new Item[5];
        if (this.selectedTab == 0)
        {
            pItems[0] = ItemHandler.RICE_SEED;
            pItems[1] = Items.POTATO;
            pItems[2] = Items.EGG;
            pItems[3] = Items.CARROT;
            pItems[4] = Items.BEETROOT_SEEDS;
        }
        else if (this.selectedTab == 1)
        {
            pItems[0] = Items.STRING;
            pItems[1] = Items.MELON_SEEDS;
            pItems[2] = Items.REEDS;
            pItems[3] = Items.PUMPKIN_SEEDS;
            pItems[4] = Items.FLINT;
        }
        else if (this.selectedTab == 2)
        {
            pItems[0] = Items.GOLD_INGOT;
            pItems[1] = Items.IRON_INGOT;
            pItems[2] = Items.LEATHER;
            pItems[3] = Items.BONE;
            pItems[4] = Items.FEATHER;
        }
        else if (this.selectedTab == 3)
        {
            pItems[0] = Items.GUNPOWDER;
            pItems[1] = Items.REDSTONE;
            pItems[2] = ItemHandler.MYSTERY_MEAL;
            pItems[3] = Items.EMERALD;
            pItems[4] = Items.SLIME_BALL;
        }
        else
        {
            pItems[0] = Items.GUNPOWDER;
            pItems[1] = Items.REDSTONE;
            pItems[2] = ItemHandler.MYSTERY_MEAL;
            pItems[3] = Items.EMERALD;
            pItems[4] = Items.SLIME_BALL;
        }
        int tItemCount = 1;
        if (index == this.selectedItem)
            tItemCount = this.count;
        this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(pItems[index],tItemCount), l, i1);
        this.itemRender.renderItemOverlays(this.fontRenderer, new ItemStack(pItems[index],tItemCount), l, i1);
        int color = 7631737;
        if (index == this.selectedItem)
        {
            color = 16777215;
        }
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5, 0.5, 0.5);
        this.fontRenderer.drawString((new ItemStack(pItems[index],1)).getDisplayName(), (l + 20) * 2, (i1 + 6) * 2, color);
        GlStateManager.popMatrix();

        if (this.selectedItem != -1)
        {
            if (this.selectedItem == index)
                this.drawBagItem(pItems[index]);
        }
    }

    public void drawWelcomeText()
    {
        String[] memberships = {"Wood", "Stone", "Iron", "Diamond", "VIP"};
        IPlayerData iData = Minecraft.getMinecraft().player.getCapability(NecropolisCapabilities.PLAYER_DATA_CAPABILITY, null);
        int merchantPoints = iData.getMerchantPoints();
        int index = 0;
        if (merchantPoints < 50)
            index = 0;
        else if (merchantPoints < 100)
            index = 1;
        else if (merchantPoints < 500)
            index = 2;
        else if (merchantPoints < 1000)
            index = 3;
        else
            index = 4;


        String pItemsCost[] = new String[5];
        if (this.selectedTab == 0)
        {
            pItemsCost[0] = "Seeds to start your own rice farm! Or eat it, go wild.";
            pItemsCost[1] = "You want some potatoes?";
            pItemsCost[2] = "Do I really need to sell you on eggs? *Sigh* I need to work on my customer service...";
            pItemsCost[3] = "What's up doc? Carrots are tasty and good for you!";
            pItemsCost[4] = "Bears, beets...Never mind.";
        }
        else if (this.selectedTab == 1)
        {
            pItemsCost[0] = "Get your high quality and multi-purpose string here!";
            pItemsCost[1] = "Get some melon seeds, grow some tasty melons!";
            pItemsCost[2] = "Difficult to grow, but oh so tasty! Get your sugar reeds today!";
            pItemsCost[3] = "No matter the time of year, pumpkins always have some use!";
            pItemsCost[4] = "If you need to start a fire, this is a must. Spare yourself the trouble of digging for one!";
        }
        else if (this.selectedTab == 2)
        {
            pItemsCost[0] = "Gold isn't very strong, but it's so beautiful and shiny!";
            pItemsCost[1] = "Iron ingots, the most bang-for-your-souls you'll ever have!";
            pItemsCost[2] = "Leather for those cold nights. I source them so you don't need to!";
            pItemsCost[3] = "The bones of many a dangerous monsters. But they work great as fertilizer ground up.";
            pItemsCost[4] = "It's a feather, what more do you expect?";
        }
        else if (this.selectedTab == 3)
        {
            pItemsCost[0] = "Ah gunpowder. So rare but so useful and explosive!";
            pItemsCost[1] = "I'm not smart enough to work with redstone, but maybe you are!";
            pItemsCost[2] = "This is just a scrapped original recipe idea from the Gourmet, but even so, it's really popular...";
            pItemsCost[3] = "Emeralds, so rare, but beautiful. What can you do with them? Uhh...the possibilities are infinite!";
            pItemsCost[4] = "While it doesn't look like much, these sticky slimes are great for your pistons!";
        }
        else
        {
            pItemsCost[0] = "Ah gunpowder. So rare but so useful and explosive!";
            pItemsCost[1] = "I'm not smart enough to work with redstone, but maybe you are!";
            pItemsCost[2] = "This is just a scrapped original recipe idea from the Gourmet, but even so, it's really popular...";
            pItemsCost[3] = "Emeralds, so rare, but beautiful. What can you do with them? Uhh...the possibilities are infinite!";
            pItemsCost[4] = "While it doesn't look like much, these sticky slimes are great for your pistons!";
        }


        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5, 0.5, 0.5);

        if (this.selectedItem == -1)
        {
            this.fontRenderer.drawSplitString(welcomeText1 + memberships[index] + welcomeText2, (this.guiLeft + 78) * 2, (this.guiTop + 74) * 2, 170, 16777215);
        }
        else
        {
            this.fontRenderer.drawSplitString(pItemsCost[this.selectedItem], (this.guiLeft + 78) * 2, (this.guiTop + 74) * 2, 170, 16777215);

            int cost = this.getMerchantCost();
            int discountedCost = this.getDiscountedCost(cost);
            this.fontRenderer.drawString(this.priceText + Integer.toString(discountedCost * this.count), (this.guiLeft + 110) * 2, (this.guiTop + 99) * 2, 16777215);
        }
        GlStateManager.popMatrix();
    }

    protected void drawBagItem(Item tItem)
    {
        int l = this.guiLeft + 109;
        int i1 = this.guiTop + 6;

        GlStateManager.pushMatrix();
        GlStateManager.scale(2.0, 2.0, 2.0);
        this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(tItem, this.count), l / 2, i1 / 2);
        this.itemRender.renderItemOverlays(this.fontRenderer, new ItemStack(tItem, this.count), l / 2, i1 / 2);
        GlStateManager.popMatrix();
    }

    protected void drawGuiContainerBackgroundLayer(float f, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        RenderHelper.enableGUIStandardItemLighting();

        GlStateManager.disableLighting();
        GlStateManager.color(1F, 1F, 1F); //Forge: Reset color in case Items change it.
        GlStateManager.enableBlend(); //Forge: Make sure blend is enabled else tabs show a white border.

        if (this.selectedItem != -1)
            this.mc.getTextureManager().bindTexture(WM_GUI);
        else
            this.mc.getTextureManager().bindTexture(WM_CLOSED_GUI);


        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        GlStateManager.enableLighting();
        GlStateManager.enableRescaleNormal();

        //draw membership tabs
        for (int i = 0; i < 5; i++)
        {
            this.drawMembershipTab(i);
        }
        //draw product buttons
        for (int i = 0; i < 5; i++)
        {
            this.drawProducts(i);
            this.drawItemIcons(i);
        }
        this.drawWelcomeText();

    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        super.keyTyped(typedChar, keyCode);
    }

    protected boolean isMouseOverTab(int index, int mouseX, int mouseY)
    {
        int l = this.guiLeft + 7 + index * 11;
        int i1 = this.guiTop + 7;
        int width = 11;
        int height = 11;

        IPlayerData iData = Minecraft.getMinecraft().player.getCapability(NecropolisCapabilities.PLAYER_DATA_CAPABILITY, null);
        int merchantPoints = iData.getMerchantPoints();

        if ((index == 1 && merchantPoints < 50) || (index == 2 && merchantPoints < 100) || (index == 3 && merchantPoints < 500) || (index == 4 && merchantPoints < 1000))
            return false;

        if ((mouseX > l && mouseX < l + width) && (mouseY > i1 && mouseY < i1 + height))
            return true;
        return false;
    }

    protected boolean isMouseOverButton(int index, int mouseX, int mouseY)
    {
        int l = this.guiLeft + 7;
        int i1 = this.guiTop + 18 + index * 18;
        int width = 18;
        int height = 18;

        if ((mouseX > l && mouseX < l + width) && (mouseY > i1 && mouseY < i1 + height))
            return true;
        return false;
    }

    protected boolean isMouseOverUp(int mouseX, int mouseY)
    {
        int l = this.guiLeft + 77;
        int i1 = this.guiTop + 96;
        int width = 5;
        int height = 5;
        if ((mouseX > l && mouseX < l + width) && (mouseY > i1 && mouseY < i1 + height))
        {
            return true;
        }
        return false;
    }
    protected boolean isMouseOverDown(int mouseX, int mouseY)
    {
        int l = this.guiLeft + 77;
        int i1 = this.guiTop + 100;
        int width = 5;
        int height = 5;
        if ((mouseX > l && mouseX < l + width) && (mouseY > i1 && mouseY < i1 + height))
        {
            return true;
        }
        return false;
    }

    protected boolean isMouseOverSelect(int mouseX, int mouseY)
    {
        int l = this.guiLeft + 84;
        int i1 = this.guiTop + 100;
        int width = 10;
        int height = 10;
        if ((mouseX > l && mouseX < l + width) && (mouseY > i1 && mouseY < i1 + height))
        {
            return true;
        }
        return false;
    }

    protected int getMerchantCost()
    {
        int pItemsCost[] = new int[5];
        if (this.selectedTab == 0)
        {
            pItemsCost[0] = 10;
            pItemsCost[1] = 10;
            pItemsCost[2] = 20;
            pItemsCost[3] = 10;
            pItemsCost[4] = 10;
        }
        else if (this.selectedTab == 1)
        {
            pItemsCost[0] = 30;
            pItemsCost[1] = 10;
            pItemsCost[2] = 10;
            pItemsCost[3] = 10;
            pItemsCost[4] = 10;
        }
        else if (this.selectedTab == 2)
        {
            pItemsCost[0] = 90;
            pItemsCost[1] = 80;
            pItemsCost[2] = 10;
            pItemsCost[3] = 40;
            pItemsCost[4] = 25;
        }
        else if (this.selectedTab == 3)
        {
            pItemsCost[0] = 100;
            pItemsCost[1] = 80;
            pItemsCost[2] = 50;
            pItemsCost[3] = 120;
            pItemsCost[4] = 30;
        }
        else
        {
            pItemsCost[0] = 100;
            pItemsCost[1] = 80;
            pItemsCost[2] = 50;
            pItemsCost[3] = 120;
            pItemsCost[4] = 30;
        }
        return pItemsCost[this.selectedItem];
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        super.mouseClicked(mouseX, mouseY, mouseButton);

        boolean mouseOverButton = false;
        for (int i = 0; i < 5; i++)
        {
            if (this.isMouseOverTab(i, mouseX, mouseY))
            {
                this.count = 1;
                this.selectedTab = i;
                mouseOverButton = true;
            }
            else if (this.isMouseOverButton(i, mouseX, mouseY))
            {
                this.count = 1;
                this.selectedItem = i;
                mouseOverButton = true;
            }
        }

        if (this.isMouseOverUp(mouseX, mouseY) && this.selectedItem != -1)
        {
            this.count++;
            mouseOverButton = true;
        }
        else if (this.isMouseOverDown(mouseX, mouseY) && this.selectedItem != -1)
        {
            this.count = Math.max(1, this.count - 1);
            mouseOverButton = true;
        }
        else if (this.isMouseOverSelect(mouseX, mouseY) && this.selectedItem != -1)
        {
            mouseOverButton = true;
            EntityPlayer player = Minecraft.getMinecraft().player;
            int itemCost = this.getMerchantCost() * this.count;


            IPlayerData iData = Minecraft.getMinecraft().player.getCapability(NecropolisCapabilities.PLAYER_DATA_CAPABILITY, null);
            int merchantPoints = iData.getMerchantPoints();
            double discount = 0.0;
            int index = 0;
            if (merchantPoints < 50)
            {
                discount = 0.0;
                index = 0;
            }
            else if (merchantPoints < 100)
            {
                discount = 0.1;
                index = 1;
            }
            else if (merchantPoints < 500)
            {
                discount = 0.2;
                index = 2;
            }
            else if (merchantPoints < 1000)
            {
                discount = 0.3;
                index = 3;
            }
            else
            {
                discount = 0.4;
                index = 4;
            }

            int discountedItemCost = itemCost;
            if (this.selectedTab != index)
                discountedItemCost = itemCost - (int)((double)itemCost * discount);

            int x = player.experienceLevel;

            double totalExp_1 = this.getExpTotal(x);
            double totalExp_2 = this.getExpTotal(x+1);
            int xpCap = player.xpBarCap();

            int xpTotal = (int)totalExp_1 + (int)(xpCap * player.experience);

            if (xpTotal < discountedItemCost)
            {
                System.out.print("NOT ENOUGH SOULS");
                System.out.printf("%n");
            }
            else
            {
                xpTotal -= discountedItemCost;

                double tLevel = this.getLevel(xpTotal);

                player.experienceLevel = (int)tLevel;
                player.experience = (float)tLevel - (float)((int)tLevel);


                Withernauts.packetHandler.sendToServer(new WMSpawnItem(this.selectedTab * 5 + this.selectedItem, this.count));

                Withernauts.packetHandler.sendToServer(new SyncPlayerExperience(player.experienceLevel, player.experience));

                this.count = 1;
                iData.addMerchantPoints(itemCost / 2);
            }
        }

        if (mouseOverButton == false)
        {
            this.selectedItem = -1;
        }
        else
        {
            Minecraft.getMinecraft().world.playSound(Minecraft.getMinecraft().player, Minecraft.getMinecraft().player.getPosition(), SoundEvents.BLOCK_DISPENSER_DISPENSE, SoundCategory.PLAYERS, 0.8F, 1.0F);
        }

    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    public double getLevel(int xpTotal)
    {
        double x = 0;
        if (xpTotal <= 352)
        {
            x = (-6.0 + Math.sqrt(36 - 4 * (-xpTotal)))/2.0;
        }
        else if (xpTotal <= 1507)
        {
            x = (40.5 + Math.sqrt(1640.25 - 4 * 2.5 * (360-xpTotal)))/(2.0 * 2.5);
        }
        else
        {
            x = (162.5 + Math.sqrt(26406.25 - 4 * 4.5 * (2220-xpTotal)))/(2.0 * 4.5);
        }
        return x;
    }

    public int getDiscountedCost(int cost)
    {
        IPlayerData iData = Minecraft.getMinecraft().player.getCapability(NecropolisCapabilities.PLAYER_DATA_CAPABILITY, null);
        int merchantPoints = iData.getMerchantPoints();

        double discount = 0.0;
        int index = 0;
        if (merchantPoints < 50)
        {
            discount = 0.0;
            index = 0;
        }
        else if (merchantPoints < 100)
        {
            discount = 0.1;
            index = 1;
        }
        else if (merchantPoints < 500)
        {
            discount = 0.2;
            index = 2;
        }
        else if (merchantPoints < 1000)
        {
            discount = 0.3;
            index = 3;
        }
        else
        {
            discount = 0.4;
            index = 4;
        }
        if (index == this.selectedTab)
            return cost;
        return cost - (int)((double)cost * discount);
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
            totalExp = 4.5 * x * x - 162.5 * x + 2220;
        }
        return totalExp;
    }
}
