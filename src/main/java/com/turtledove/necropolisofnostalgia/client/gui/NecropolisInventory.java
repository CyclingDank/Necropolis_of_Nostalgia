package com.turtledove.necropolisofnostalgia.client.gui;

import com.google.common.collect.Sets;
import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;

import com.turtledove.necropolisofnostalgia.common.food.FoodEffects;
import com.turtledove.necropolisofnostalgia.server.artes.ArteBase;
import com.turtledove.necropolisofnostalgia.server.core.NecropolisPlayerData;
import com.turtledove.necropolisofnostalgia.server.core.PlayerData;
import com.turtledove.necropolisofnostalgia.server.packets.Player.SyncArtesOnClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

@SideOnly(Side.CLIENT)
public class NecropolisInventory extends GuiScreen
{
    /** The size of the inventory window in pixels. */
    protected int xSize = 178;
    protected int ySize = 166;

    private static int selectedTabIndex = NecropolisTabs.INVENTORY.getTabIndex();
    private static int tabPage = 0;

    private static int selectedArteTreeIndex[] = {-1,-1};   //row, column
    private static int global_index_top = 0;

    private static boolean isPrimary = true;

    private float xSize_lo;
    private float ySize_lo;

    protected int guiLeft;
    protected int guiTop;

    private Slot hoveredSlot;
    private Slot lastClickSlot;
    private long lastClickTime;
    private int lastClickButton;
    private boolean doubleClick;
    private boolean ignoreMouseUp;

    protected boolean dragSplitting;
    private int dragSplittingLimit;
    private int dragSplittingRemnant;
    private int dragSplittingButton;
    protected final Set<Slot> dragSplittingSlots = Sets.<Slot>newHashSet();
    private ItemStack shiftClickedSlot = ItemStack.EMPTY;

    /*For item dragging and touch*/
    private Slot clickedSlot;
    private boolean isRightMouseClick;
    private ItemStack draggedStack = ItemStack.EMPTY;
    private ItemStack returningStack = ItemStack.EMPTY;
    private Slot currentDragTargetSlot;
    private long dragItemDropDelay;
    private Slot returningStackDestSlot;
    private long returningStackTime;
    private int touchUpX;
    private int touchUpY;

    private static final ResourceLocation INVENTORY_BASIC = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/gui/tab_items.png");
    private static final ResourceLocation ITEM_DESC = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/gui/tab_description.png");
    private static final ResourceLocation EQUIPMENT_DESC = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/gui/tab_equipment.png");
    private static final ResourceLocation GENERAL = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/gui/tab_general.png");
    private static final ResourceLocation ARTES = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/gui/tab_artes.png");
    private static final ResourceLocation ARTES_BUTTONS = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/gui/arte_buttons.png");
    private static final ResourceLocation INVENTORY_TABS = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/gui/tabs.png");

    private final InventoryContainer inventory;

    public NecropolisInventory(InventoryContainer container)
    {
        this.inventory = container;
        this.allowUserInput = true;
        this.ignoreMouseUp = true;
    }

    public void initGui()
    {
        if (this.mc.playerController.isInCreativeMode())
        {
            this.mc.displayGuiScreen(new GuiContainerCreative(this.mc.player));
        }
        else
        {
            super.initGui();
            this.mc.player.openContainer = this.inventory;
        }
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        super.keyTyped(typedChar, keyCode);
        switch (typedChar)
        {
            case 'e':
                this.mc.player.closeScreen();
                break;
            case '1':
                selectedTabIndex = 0;
                break;
            case '2':
                selectedTabIndex = 1;
                break;
            case '3':
                selectedTabIndex = 2;
                break;
            case '4':
                selectedTabIndex = 3;
                break;
            case '5':
                selectedTabIndex = 4;
                break;
            case '6':
                selectedTabIndex = 5;
                break;
            case '7':
                selectedTabIndex = 6;
                break;
            default:

        }

    }


    public void updateScreen()
    {
        if (this.mc.playerController.isInCreativeMode())
        {
            this.mc.displayGuiScreen(new GuiContainerCreative(this.mc.player));

        }
        else
        {
            super.updateScreen();
        }
    }

    public void drawScreen(int mouseX, int mouseY, float f)
    {
        this.drawDefaultBackground();
        this.hoveredSlot = null;
        xSize_lo = mouseX;
        ySize_lo = mouseY;

        int i = this.guiLeft;
        int j = this.guiTop;

        this.drawGuiContainerBackgroundLayer(f, mouseX, mouseY);
        GlStateManager.pushMatrix();

        //handles the logic for drawing the vanilla slots
        for (int i1 = 0; i1 < this.inventory.inventorySlots.size(); ++i1)
        {
            Slot slot = this.inventory.inventorySlots.get(i1);
            if (selectedTabIndex == 0)
            {
                if (slot.slotNumber >= 36 && slot.slotNumber <= 44 )
                {
                    drawslotQuad(slot, mouseX, mouseY);
                }
                else if (slot.slotNumber >= 46 && slot.slotNumber <= 72)
                {
                    drawslotQuad(slot, mouseX, mouseY);
                }
            }
            else if (selectedTabIndex == 1)
            {
                if (slot.slotNumber >= 36 && slot.slotNumber <= 44 )
                {
                    drawslotQuad(slot, mouseX, mouseY);
                }
                else if (slot.slotNumber >= 73 && slot.slotNumber <= 99)
                {
                    drawslotQuad(slot, mouseX, mouseY);
                }
            }
            else if (selectedTabIndex == 2)
            {
                if ((slot.slotNumber >= 5 && slot.slotNumber <= 8 ) || slot.slotNumber == 45 || (slot.slotNumber >= 100 && slot.slotNumber <= 108))
                {
                    drawslotQuad(slot, mouseX, mouseY);
                }
                else if (slot.slotNumber >= 36 && slot.slotNumber <= 44 )
                {
                    drawslotQuad(slot, mouseX, mouseY);
                }
            }
            else if (selectedTabIndex == 3)
            {
                if (slot.slotNumber >= 36 && slot.slotNumber <= 44 )
                {
                    drawslotQuad(slot, mouseX, mouseY);
                }
                else if (slot.slotNumber >= 109 && slot.slotNumber <= 135)
                {
                    drawslotQuad(slot, mouseX, mouseY);
                }
            }
            else if (selectedTabIndex == 5)
            {
                if (slot.slotNumber >= 36 && slot.slotNumber <= 44 )
                {
                    drawslotQuad(slot, mouseX, mouseY);
                }
                else if (slot.slotNumber >= 136)
                {
                    drawslotQuad(slot, mouseX, mouseY);
                }
            }
            else if (selectedTabIndex == 6)
            {
                if ((slot.slotNumber < 5 || slot.slotNumber > 8 ) && slot.slotNumber < 45 )
                {
                    drawslotQuad(slot, mouseX, mouseY);
                }
            }
        }
        //handles the logic for drawing the tab slots

        drawCurrentTab();

        RenderHelper.disableStandardItemLighting();
        this.drawGuiContainerForegroundLayer(mouseX, mouseY);
        RenderHelper.enableGUIStandardItemLighting();
        //net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.GuiContainerEvent.DrawForeground(this, mouseX, mouseY));
        InventoryPlayer inventoryplayer = this.mc.player.inventory;
        ItemStack itemstack = this.draggedStack.isEmpty() ? inventoryplayer.getItemStack() : this.draggedStack;

        if (!itemstack.isEmpty())
        {
            int j2 = 8;
            int k2 = this.draggedStack.isEmpty() ? 8 : 16;
            String s = null;

            if (!this.draggedStack.isEmpty() && this.isRightMouseClick)
            {
                itemstack = itemstack.copy();
                itemstack.setCount(MathHelper.ceil((float)itemstack.getCount() / 2.0F));
            }
            else if (this.dragSplitting && this.dragSplittingSlots.size() > 1)
            {
                itemstack = itemstack.copy();
                itemstack.setCount(this.dragSplittingRemnant);

                if (itemstack.isEmpty())
                {
                    s = "" + TextFormatting.YELLOW + "0";
                }
            }

            this.drawItemStack(itemstack, mouseX - 8, mouseY - k2, s);
        }

        if (!this.returningStack.isEmpty())
        {
            float t_f = (float)(Minecraft.getSystemTime() - this.returningStackTime) / 100.0F;

            if (t_f >= 1.0F)
            {
                t_f = 1.0F;
                this.returningStack = ItemStack.EMPTY;
            }

            int l2 = this.returningStackDestSlot.xPos - this.touchUpX;
            int i3 = this.returningStackDestSlot.yPos - this.touchUpY;
            int l1 = this.touchUpX + (int)((float)l2 * t_f);
            int i2 = this.touchUpY + (int)((float)i3 * t_f);
            this.drawItemStack(this.returningStack, l1, i2, (String)null);
        }

        GlStateManager.popMatrix();
        GlStateManager.enableLighting();
        GlStateManager.enableDepth();
        RenderHelper.enableStandardItemLighting();
    }

    private void drawslotQuad(Slot slot, int mouseX, int mouseY)
    {
        if (slot.isEnabled())
        {
            this.drawSlot(slot);
        }

        if (this.isMouseOverSlot(slot, mouseX - this.guiLeft, mouseY - this.guiTop) && slot.isEnabled())
        {
            this.hoveredSlot = slot;
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            int j1 = slot.xPos + this.guiLeft;
            int k1 = slot.yPos + this.guiTop;
            GlStateManager.colorMask(true, true, true, false);
            this.drawGradientRect(j1, k1, j1 + 16, k1 + 16, -2130706433, -2130706433);
            GlStateManager.colorMask(true, true, true, true);
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
        }
    }

    private void drawSlot(Slot slotIn)
    {
        int i = slotIn.xPos + this.guiLeft;
        int j = slotIn.yPos + this.guiTop;
        ItemStack itemstack = slotIn.getStack();
        boolean flag = false;
        ItemStack itemstack1 = this.mc.player.inventory.getItemStack();
        String s = null;

        if (slotIn == this.clickedSlot && !this.draggedStack.isEmpty() && this.isRightMouseClick && !itemstack.isEmpty())
        {
            itemstack = itemstack.copy();
            itemstack.setCount(itemstack.getCount() / 2);
        }
        else if (this.dragSplitting && this.dragSplittingSlots.contains(slotIn) && !itemstack1.isEmpty())
        {
            if (this.dragSplittingSlots.size() == 1)
            {
                return;
            }

            if (Container.canAddItemToSlot(slotIn, itemstack1, true) && this.inventory.canDragIntoSlot(slotIn))
            {
                itemstack = itemstack1.copy();
                flag = true;
                Container.computeStackSize(this.dragSplittingSlots, this.dragSplittingLimit, itemstack, slotIn.getStack().isEmpty() ? 0 : slotIn.getStack().getCount());
                int k = Math.min(itemstack.getMaxStackSize(), slotIn.getItemStackLimit(itemstack));

                if (itemstack.getCount() > k)
                {
                    s = TextFormatting.YELLOW.toString() + k;
                    itemstack.setCount(k);
                }
            }
            else
            {
                this.dragSplittingSlots.remove(slotIn);
                this.updateDragSplitting();
            }
        }

        this.zLevel = 100.0F;
        this.itemRender.zLevel = 100.0F;

        if (itemstack.isEmpty() && slotIn.isEnabled())
        {
            TextureAtlasSprite textureatlassprite = slotIn.getBackgroundSprite();

            if (textureatlassprite != null)
            {
                GlStateManager.disableLighting();
                this.mc.getTextureManager().bindTexture(slotIn.getBackgroundLocation());
                this.drawTexturedModalRect(i, j, textureatlassprite, 16, 16);
                GlStateManager.enableLighting();
            }
        }

        if (flag)
        {
            drawRect(i, j, i + 16, j + 16, -2130706433);
        }

        GlStateManager.enableDepth();
        this.itemRender.renderItemAndEffectIntoGUI(this.mc.player, itemstack, i, j);
        this.itemRender.renderItemOverlayIntoGUI(this.fontRenderer, itemstack, i, j, s);

        this.itemRender.zLevel = 0.0F;
        this.zLevel = 0.0F;
    }

    private void drawCurrentTab()
    {
        this.mc.getTextureManager().bindTexture(INVENTORY_TABS);
        int i = selectedTabIndex;
        int j = i * 21;
        int k = 21;
        int l = this.guiLeft + this.xSize - 21 * (7 - i);
        int i1 = this.guiTop - 19;
        int j1 = 21;

        GlStateManager.disableLighting();
        GlStateManager.color(1F, 1F, 1F); //Forge: Reset color in case Items change it.
        GlStateManager.enableBlend(); //Forge: Make sure blend is enabled else tabs show a white border.
        this.drawTexturedModalRect(l, i1, j, k, 21, 21);
        this.zLevel = 100.0F;
        this.itemRender.zLevel = 100.0F;
        l = l + 2;
        i1 = i1 + 2;
        GlStateManager.enableLighting();
        GlStateManager.enableRescaleNormal();
        ItemStack itemstack = NecropolisTabs.NECROPOLIS_TAB_ARRAY[i].getIconItemStack();
        this.itemRender.renderItemAndEffectIntoGUI(itemstack, l, i1);
        this.itemRender.renderItemOverlays(this.fontRenderer, itemstack, l, i1);
        //GlStateManager.disableLighting();
        this.itemRender.zLevel = 0.0F;
        this.zLevel = 0.0F;
    }

    private void drawTab(NecropolisTabs tab)
    {
        boolean flag = tab.getTabIndex() == selectedTabIndex;
        int i = tab.getTabIndex();
        int j = i * 21;
        int k = 0;
        int l = this.guiLeft + this.xSize - 21 * (7 - i);
        int i1 = this.guiTop - 19;
        int j1 = 21;

        if (flag)
        {
            k += 21;
        }

        GlStateManager.disableLighting();
        GlStateManager.color(1F, 1F, 1F); //Forge: Reset color in case Items change it.
        GlStateManager.enableBlend(); //Forge: Make sure blend is enabled else tabs show a white border.
        this.drawTexturedModalRect(l, i1, j, k, 21, 21);
        this.zLevel = 100.0F;
        this.itemRender.zLevel = 100.0F;
        l = l + 2;
        i1 = i1 + 2;
        GlStateManager.enableLighting();
        GlStateManager.enableRescaleNormal();
        ItemStack itemstack = tab.getIconItemStack();
        this.itemRender.renderItemAndEffectIntoGUI(itemstack, l, i1);
        this.itemRender.renderItemOverlays(this.fontRenderer, itemstack, l, i1);
        //GlStateManager.disableLighting();
        this.itemRender.zLevel = 0.0F;
        this.zLevel = 0.0F;
    }

    public void drawArtesPage(int mouseX, int mouseY)
    {
        for (int i = 0; i < 3; i++) //column
        {
            for (int j = 0; j < 3; j++) //row
            {
                this.mc.getTextureManager().bindTexture(ARTES_BUTTONS);
                drawArteTreeButton(j,i, mouseX, mouseY);
            }
            drawGlobalArtesButton(i,mouseX,mouseY);
        }
        drawGlobalNavigatorButton(0,mouseX,mouseY);
        drawGlobalNavigatorButton(1,mouseX,mouseY);
        drawArtesSelectorOVerlay();
    }

    public void drawArteTreeButton(int row, int col, int mouseX, int mouseY)
    {
        int x_offset = 8 + this.guiLeft + col * 4 + col * 51;
        int y_offset = 8 + this.guiTop + row * 3 + row * 18;
        int j = 0;
        int k = 18;
        if (isMouseOverArteTreeButton(row, col, mouseX, mouseY))
        {
            k = 0;
        }
        if (selectedArteTreeIndex[0] == row && selectedArteTreeIndex[1] == col)
        {
            k = 36;
        }
        //GlStateManager.disableLighting();
        GlStateManager.color(1F, 1F, 1F); //Forge: Reset color in case Items change it.
        GlStateManager.enableBlend(); //Forge: Make sure blend is enabled else tabs show a white border.
        this.drawTexturedModalRect(x_offset, y_offset, j, k, 51, 18);
    }
    public void drawGlobalArtesButton(int row, int mouseX, int mouseY)
    {
        int x_offset = 9 + this.guiLeft;
        int y_offset = 74 + this.guiTop + row * 18;
        int j = 0;
        int k = 18;
        //GlStateManager.disableLighting();
        GlStateManager.color(1F, 1F, 1F); //Forge: Reset color in case Items change it.
        GlStateManager.enableBlend(); //Forge: Make sure blend is enabled else tabs show a white border.
        this.drawTexturedModalRect(x_offset, y_offset, j, k, 51, 18);
    }

    public void drawGlobalNavigatorButton(int row, int mouseX, int mouseY)
    {
        int x_offset = 60 + this.guiLeft;
        int y_offset = 73 + this.guiTop + row * 28;
        int j = 0;
        int k = 54 + row * 28;
        //GlStateManager.disableLighting();
        GlStateManager.color(1F, 1F, 1F); //Forge: Reset color in case Items change it.
        GlStateManager.enableBlend(); //Forge: Make sure blend is enabled else tabs show a white border.
        this.drawTexturedModalRect(x_offset, y_offset, j, k, 5, 28);
    }
    public void drawArtesSelectorOVerlay()
    {
        int x_offset = 9 + this.guiLeft;
        int y_offset = 74 + this.guiTop + 18;
        int j = 51;
        int k = 0;
        //GlStateManager.disableLighting();
        GlStateManager.color(1F, 1F, 1F); //Forge: Reset color in case Items change it.
        GlStateManager.enableBlend(); //Forge: Make sure blend is enabled else tabs show a white border.
        this.drawTexturedModalRect(x_offset, y_offset, j, k, 51, 18);
    }

    private void drawItemStack(ItemStack stack, int x, int y, String altText)
    {
        GlStateManager.translate(0.0F, 0.0F, 32.0F);
        this.zLevel = 200.0F;
        this.itemRender.zLevel = 200.0F;
        net.minecraft.client.gui.FontRenderer font = stack.getItem().getFontRenderer(stack);
        if (font == null) font = fontRenderer;
        this.itemRender.renderItemAndEffectIntoGUI(stack, x, y);
        this.itemRender.renderItemOverlayIntoGUI(font, stack, x, y - (this.draggedStack.isEmpty() ? 0 : 8), altText);
        this.zLevel = 0.0F;
        this.itemRender.zLevel = 0.0F;
    }

    public void onGuiClosed()
    {
        if (this.mc.player != null)
        {
            selectedArteTreeIndex[0] = -1;
            selectedArteTreeIndex[1] = -1;

            this.inventory.onContainerClosed(this.mc.player);
            PlayerData data = (PlayerData) NecropolisPlayerData.get(Minecraft.getMinecraft().player);
            if (isPrimary)
            {
                Necropolis_of_Nostalgia.packetHandler.sendToServer(new SyncArtesOnClient(data.primaryArtes, data.arteCount, 0));
                //data.setBindedArtes(data.primaryArtes);
            }
            else
            {
                Necropolis_of_Nostalgia.packetHandler.sendToServer(new SyncArtesOnClient(data.secondaryArtes, data.arteCount, 1));
                //data.setBindedArtes(data.secondaryArtes);
            }
        }
    }

    /**
     * Returns true if this GUI should pause the game when it is displayed in single-player
     */
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    /**
     * Called from the main game loop to update the screen.
     */

    protected void draw_arte_names(String artename, int x_offset, int y_offset)
    {
        String[] words = artename.split(" ");

        /*Arte names are not expected to be longer than 32 characters (including spaces)*/
        String firstline = "";
        String secondline = "";
        int char_count = 0;

        for (int k = 0; k < words.length; k++)
        {
            char_count+=words[k].length();
            if (char_count < 16)
            {
                if (firstline.length() > 0)
                    firstline = firstline.concat(" ");
                firstline = firstline.concat(words[k]);
            }
            else
            {
                if (secondline.length() > 0)
                    secondline = secondline.concat(" ");
                secondline = secondline.concat(words[k]);
            }
        }
        if (secondline.length() == 0)
        {
            int text_offset = 21 - firstline.length();
            x_offset+=text_offset;
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5, 0.5, 0.5);
            this.fontRenderer.drawString(I18n.format(firstline), x_offset * 2, y_offset * 2, 4210752);
            GlStateManager.popMatrix();
        }
        else
        {
            int text_offset = firstline.length();

            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5, 0.5, 0.5);
            this.fontRenderer.drawString(I18n.format(firstline), (x_offset + 21 - text_offset) * 2, (y_offset - 3) * 2, 4210752);
            GlStateManager.popMatrix();

            text_offset = 21 - secondline.length();
            x_offset+=text_offset;
            y_offset+=4;
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5, 0.5, 0.5);
            this.fontRenderer.drawString(I18n.format(secondline), x_offset * 2, (y_offset) * 2, 4210752);
            GlStateManager.popMatrix();
        }
    }

    protected void drawStatsDisplay()
    {
        int x_offset = 136 + this.guiLeft;
        int y_offset = 14 + this.guiTop;

        int[] stats =  ((PlayerData) (NecropolisPlayerData.get(Minecraft.getMinecraft().player))).getPlayerStats();
        int [] buffedStats = ((PlayerData) (NecropolisPlayerData.get(Minecraft.getMinecraft().player))).getStatBoost();

        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5, 0.5, 0.5);
        this.fontRenderer.drawString(I18n.format("STR"), x_offset * 2, y_offset * 2,16777215);
        this.fontRenderer.drawString(I18n.format(Integer.toString(stats[0])), (x_offset + 12) * 2, y_offset * 2,16777215);

        this.fontRenderer.drawString(I18n.format("SKL"), x_offset * 2, (y_offset + 7) * 2,16777215);
        this.fontRenderer.drawString(I18n.format(Integer.toString(stats[1])), (x_offset + 12) * 2, (y_offset + 7) * 2,16777215);

        this.fontRenderer.drawString(I18n.format("DEF"), x_offset * 2, (y_offset + 14) * 2,16777215);
        this.fontRenderer.drawString(I18n.format(Integer.toString(stats[2])), (x_offset + 12) * 2, (y_offset + 14) * 2,16777215);

        this.fontRenderer.drawString(I18n.format("RES"), x_offset * 2, (y_offset + 21) * 2,16777215);
        this.fontRenderer.drawString(I18n.format(Integer.toString(stats[3])), (x_offset + 12) * 2, (y_offset + 21) * 2,16777215);

        for (int i = 0; i < 4; i++)
        {
            if (buffedStats[i] > 0)
            {
                this.fontRenderer.drawString(" +" + I18n.format(Integer.toString((int)(stats[i] * 0.17F))), (x_offset + 17) * 2, (y_offset + 7 * i) * 2,8579941);
            }
        }

        GlStateManager.popMatrix();
    }

    public void drawArtesDescription(String name, String desc, int tp)
    {
        int x_offset = 67 + this.guiLeft;
        int y_offset = 79 + this.guiTop;
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5, 0.5, 0.5);
        this.fontRenderer.drawStringWithShadow(name, x_offset * 2, y_offset * 2, 16118229);
        GlStateManager.popMatrix();

        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5, 0.5, 0.5);
        this.fontRenderer.drawSplitString(desc, x_offset * 2, (y_offset + 7) * 2, 100 * 2, 16777215);
        GlStateManager.popMatrix();

        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5, 0.5, 0.5);
        this.fontRenderer.drawStringWithShadow("TP consumption    " + I18n.format(Integer.toString(tp)), x_offset * 2, (y_offset + 30) * 2, 8579941);
        GlStateManager.popMatrix();

        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5, 0.5, 0.5);
        this.fontRenderer.drawStringWithShadow("Usage    ", x_offset * 2, (y_offset + 37) * 2, 8579941);
        GlStateManager.popMatrix();

    }
    protected void drawItemThumb()
    {
        int x_offset = (10 + this.guiLeft)/2;
        int y_offset = (12 + this.guiTop)/2;

        GlStateManager.pushMatrix();
        GlStateManager.scale(2.0f,2.0f,2.0f);
        this.itemRender.renderItemIntoGUI(this.hoveredSlot.getStack(), x_offset, y_offset);
        GlStateManager.popMatrix();
    }


    protected void drawItemDesc()
    {
        if (this.mc.player.inventory.getItemStack().isEmpty() && this.hoveredSlot != null && this.hoveredSlot.getHasStack())
        {
            if (this.hoveredSlot.getStack().getItem() instanceof ItemFood)
            {
                FoodEffects fEffect = new FoodEffects();
                drawItemThumb();
                int x_offset = 46 + this.guiLeft;
                int y_offset = 13 + this.guiTop;

                int[] itemEffect = fEffect.getStatBoosts((ItemFood)this.hoveredSlot.getStack().getItem());

                /*String [] statName = new String[6];
                statName[0] = "Health ";
                statName[1] = "TP ";
                statName[2] = "Attack ";
                statName[3] = "Skill ";
                statName[4] = "Defense ";
                statName[5] = "Resistance ";

                GlStateManager.pushMatrix();
                GlStateManager.scale(0.5f,0.5f,0.5f);
                this.fontRenderer.drawString(statName[0] + I18n.format(Integer.toString(itemEffect[0])), x_offset * 2, y_offset * 2, 16777215);
                this.fontRenderer.drawString(statName[1] + I18n.format(Integer.toString(itemEffect[1])), (x_offset + 30) * 2, y_offset * 2, 16777215);

                this.fontRenderer.drawString(statName[2] + I18n.format(Integer.toString(itemEffect[2])), x_offset * 2, (y_offset + 8) * 2, 16777215);
                this.fontRenderer.drawString(statName[3] + I18n.format(Integer.toString(itemEffect[3])), (x_offset + 30) * 2, (y_offset + 8) * 2, 16777215);
                this.fontRenderer.drawString(statName[4] + I18n.format(Integer.toString(itemEffect[4])), x_offset * 2, (y_offset + 16) * 2, 16777215);
                this.fontRenderer.drawString(statName[5] + I18n.format(Integer.toString(itemEffect[5])), (x_offset + 30) * 2, (y_offset + 16) * 2, 16777215);
                GlStateManager.popMatrix();*/

            }
        }
    }

    protected void drawPrimaryButton(int mouseX, int mouseY)
    {
        PlayerData data = (PlayerData) NecropolisPlayerData.get(Minecraft.getMinecraft().player);
        int x_offset = 170 + this.guiLeft;
        int y_offset = 73 + this.guiTop;
        this.mc.getTextureManager().bindTexture(ARTES_BUTTONS);
        GlStateManager.disableLighting();
        GlStateManager.color(1F, 1F, 1F); //Forge: Reset color in case Items change it.
        GlStateManager.enableBlend(); //Forge: Make sure blend is enabled else tabs show a white border.
        if (isPrimary)
        {
            if (data.n_classes.t_classes[data.get_class()].getClassWeapons().length == 1)
            {
                this.drawTexturedModalRect(x_offset, y_offset, 102, 0, 5, 12);
            }
            else
            {
                this.drawTexturedModalRect(x_offset, y_offset, 107, 0, 5, 12);
            }
        }
        else
        {
            this.drawTexturedModalRect(x_offset, y_offset, 112, 0, 5, 12);
        }
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {

        //int i = (int)this.xSize_lo;
        //int j = (int)this.ySize_lo;

        if (selectedTabIndex == 4)
        {

            PlayerData data = (PlayerData) NecropolisPlayerData.get(Minecraft.getMinecraft().player);
            for (int i = 0; i < 3; i++) //column
            {
                for (int j = 0; j < 3; j++) //row
                {
                    int index = j + i * 3;
                    int x_offset = 8 + this.guiLeft + i * 4 + i * 51;
                    int y_offset = 15 + this.guiTop + j * 3 + j * 18;

                    String artename;
                    artename = data.artes.t_arte[data.getArteAtIndex(isPrimary, index)].getArteName();
                    draw_arte_names(artename, x_offset, y_offset);
                }
            }
            ArrayList<ArteBase> learnedArtes = data.getLearnedArtes(isPrimary);
            for (int i = 0; i < 3; i++) //column
            {
                int index = global_index_top+i;

                int possible_artes_length = learnedArtes.size();

                index = Math.floorMod(index, possible_artes_length);

                int x_offset = 9 + this.guiLeft;
                int y_offset = 81 + this.guiTop + i * 18;

                String artename = learnedArtes.get(index).getArteName();
                String desc = learnedArtes.get(index).getArteDesc();
                int tp = learnedArtes.get(index).getTPCost();
                draw_arte_names(artename, x_offset, y_offset);
                if (i == 1)
                    drawArtesDescription(artename, desc, tp);
            }
            drawPrimaryButton(mouseX, mouseY);
        }
        else if (selectedTabIndex == 0 || selectedTabIndex == 1 || selectedTabIndex == 3)
            this.drawItemDesc();
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float f, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        RenderHelper.enableGUIStandardItemLighting();

        NecropolisTabs t_tabs = NecropolisTabs.NECROPOLIS_TAB_ARRAY[selectedTabIndex];

        for (int i = 0; i <  NecropolisTabs.NECROPOLIS_TAB_ARRAY.length; ++i)
        {
            this.mc.getTextureManager().bindTexture(INVENTORY_TABS);
            if (NecropolisTabs.NECROPOLIS_TAB_ARRAY[i] == null) continue;
            if (NecropolisTabs.NECROPOLIS_TAB_ARRAY[i].getTabIndex() != selectedTabIndex)
            {
                this.drawTab(NecropolisTabs.NECROPOLIS_TAB_ARRAY[i]);
            }
        }

        if (selectedTabIndex == 6)
        {
            this.mc.getTextureManager().bindTexture(INVENTORY_BASIC);
            int i = this.guiLeft;
            int j = this.guiTop;
            this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
        }
        else if (selectedTabIndex == 0 || selectedTabIndex == 1 || selectedTabIndex == 3)
        {
            this.mc.getTextureManager().bindTexture(ITEM_DESC);
            int i = this.guiLeft;
            int j = this.guiTop;
            this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
            this.drawStatsDisplay();

        }
        else if (selectedTabIndex == 2)
        {
            this.mc.getTextureManager().bindTexture(EQUIPMENT_DESC);
            int i = this.guiLeft;
            int j = this.guiTop;
            this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
            drawEntityOnScreen(i +30, j + 102, 23, (float)(i + 51) - this.xSize_lo, (float)(j + 75 - 50) - this.ySize_lo, this.mc.player);
            this.drawStatsDisplay();
        }
        else if (selectedTabIndex == 4)
        {
            this.mc.getTextureManager().bindTexture(ARTES);
            int i = this.guiLeft;
            int j = this.guiTop;
            this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

            drawArtesPage(mouseX, mouseY);
        }
        else
        {
            this.mc.getTextureManager().bindTexture(GENERAL);
            int i = this.guiLeft;
            int j = this.guiTop;
            this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
        }
    }

    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        boolean flag = this.mc.gameSettings.keyBindPickBlock.isActiveAndMatches(mouseButton - 100);
        Slot slot = this.getSlotAtPosition(mouseX - this.guiLeft, mouseY - this.guiTop);
        long i = Minecraft.getSystemTime();
        this.doubleClick = this.lastClickSlot == slot && i - this.lastClickTime < 250L && this.lastClickButton == mouseButton;
        this.ignoreMouseUp = false;

        for (int t = 0; t < 7; t++)
        {
            if (isMouseOverTab(t, mouseX, mouseY))
                selectedTabIndex = t;
        }


        if (selectedTabIndex == 4)
        {
            PlayerData data = (PlayerData) NecropolisPlayerData.get(Minecraft.getMinecraft().player);

            for (int c = 0; c < 3; c++) //column
            {
                for (int r = 0; r < 3; r++) //row
                {
                    if (isMouseOverArteTreeButton(r,c,mouseX, mouseY))
                    {
                        if (selectedArteTreeIndex[0] != -1 && selectedArteTreeIndex[1] != -1)
                        {
                            int copied_index = selectedArteTreeIndex[0] + selectedArteTreeIndex[1] * 3;
                            int copy_index = r + c * 3;
                            data.setArteAtIndex(isPrimary, copied_index, copy_index);
                            selectedArteTreeIndex[0] = -1;
                            selectedArteTreeIndex[1] = -1;
                        }
                        else
                        {
                            selectedArteTreeIndex[0] = r;
                            selectedArteTreeIndex[1] = c;
                        }

                    }
                }
            }
            if (isMouseOverGlobalArtesNavigator(0,mouseX,mouseY))
            {
                global_index_top--;
            }
            else if (isMouseOverGlobalArtesNavigator(1,mouseX,mouseY))
            {
                global_index_top++;
            }
            for (int r = 0; r < 3; r++)
            {
                if (isMouseOverGlobalArtesButton(r,mouseX,mouseY))
                {
                    if (selectedArteTreeIndex[0] != -1 && selectedArteTreeIndex[1] != -1)
                    {
                        int player_class = data.get_class();
                        int index = global_index_top+r;
                        int possible_artes_length = data.getLearnedArtes(isPrimary).size();

                        index = Math.floorMod(index, possible_artes_length);

                        int real_index = data.getArteGlobalIndex(isPrimary).get(index);

                        int copied_index = selectedArteTreeIndex[0] + selectedArteTreeIndex[1] * 3;
                        data.setArteAtGlobalIndex(isPrimary, copied_index, real_index);
                        selectedArteTreeIndex[0] = -1;
                        selectedArteTreeIndex[1] = -1;
                    }
                }
            }
            if (data.n_classes.t_classes[data.get_class()].getClassWeapons().length == 2)
            {
                if (isMouseOverPrimaryButton(0, mouseX, mouseY))
                {
                    isPrimary = true;
                }
                else if (isMouseOverPrimaryButton(1, mouseX, mouseY))
                {
                    isPrimary = false;
                }

            }
        }

        if (this.hasClickedOutside(mouseX,mouseY,this.guiLeft,this.guiTop))
        {
            selectedArteTreeIndex[0] = -1;
            selectedArteTreeIndex[1] = -1;
        }

        if (mouseButton == 0 || mouseButton == 1 || flag)
        {
            int j = this.guiLeft;
            int k = this.guiTop;
            boolean flag1 = this.hasClickedOutside(mouseX, mouseY, j, k);
            if (slot != null) flag1 = false; // Forge, prevent dropping of items through slots outside of GUI boundaries
            int l = -1;

            if (slot != null)
            {
                l = slot.slotNumber;
            }

            if (flag1)
            {
                l = -999;
            }

            if (this.mc.gameSettings.touchscreen && flag1 && this.mc.player.inventory.getItemStack().isEmpty())
            {
                this.mc.displayGuiScreen((GuiScreen)null);
                return;
            }

            if (l != -1)
            {
                if (this.mc.gameSettings.touchscreen)
                {
                    if (slot != null && slot.getHasStack())
                    {
                        this.clickedSlot = slot;
                        this.draggedStack = ItemStack.EMPTY;
                        this.isRightMouseClick = mouseButton == 1;
                    }
                    else
                    {
                        this.clickedSlot = null;
                    }
                }
                else if (!this.dragSplitting)
                {
                    if (this.mc.player.inventory.getItemStack().isEmpty())
                    {
                        if (this.mc.gameSettings.keyBindPickBlock.isActiveAndMatches(mouseButton - 100))
                        {
                            this.handleMouseClick(slot, l, mouseButton, ClickType.CLONE);
                        }
                        else
                        {
                            boolean flag2 = l != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                            ClickType clicktype = ClickType.PICKUP;

                            if (flag2)
                            {
                                this.shiftClickedSlot = slot != null && slot.getHasStack() ? slot.getStack().copy() : ItemStack.EMPTY;
                                clicktype = ClickType.QUICK_MOVE;
                            }
                            else if (l == -999)
                            {
                                clicktype = ClickType.THROW;
                            }

                            this.handleMouseClick(slot, l, mouseButton, clicktype);
                        }

                        this.ignoreMouseUp = true;
                    }
                    else
                    {
                        this.dragSplitting = true;
                        this.dragSplittingButton = mouseButton;
                        this.dragSplittingSlots.clear();

                        if (mouseButton == 0)
                        {
                            this.dragSplittingLimit = 0;
                        }
                        else if (mouseButton == 1)
                        {
                            this.dragSplittingLimit = 1;
                        }
                        else if (this.mc.gameSettings.keyBindPickBlock.isActiveAndMatches(mouseButton - 100))
                        {
                            this.dragSplittingLimit = 2;
                        }
                    }
                }
            }
        }
        this.lastClickSlot = slot;
        this.lastClickTime = i;
        this.lastClickButton = mouseButton;
    }

    protected void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick)
    {
        Slot slot = this.getSlotAtPosition(mouseX - this.guiLeft, mouseY - this.guiTop);
        ItemStack itemstack = this.mc.player.inventory.getItemStack();

        if (this.clickedSlot != null && this.mc.gameSettings.touchscreen)
        {
            if (clickedMouseButton == 0 || clickedMouseButton == 1)
            {
                if (this.draggedStack.isEmpty())
                {
                    if (slot != this.clickedSlot && !this.clickedSlot.getStack().isEmpty())
                    {
                        this.draggedStack = this.clickedSlot.getStack().copy();
                    }
                }
                else if (this.draggedStack.getCount() > 1 && slot != null && Container.canAddItemToSlot(slot, this.draggedStack, false))
                {
                    long i = Minecraft.getSystemTime();

                    if (this.currentDragTargetSlot == slot)
                    {
                        if (i - this.dragItemDropDelay > 500L)
                        {
                            this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, 0, ClickType.PICKUP);
                            this.handleMouseClick(slot, slot.slotNumber, 1, ClickType.PICKUP);
                            this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, 0, ClickType.PICKUP);
                            this.dragItemDropDelay = i + 750L;
                            this.draggedStack.shrink(1);
                        }
                    }
                    else
                    {
                        this.currentDragTargetSlot = slot;
                        this.dragItemDropDelay = i;
                    }
                }
            }
        }
        else if (this.dragSplitting && slot != null && !itemstack.isEmpty() && (itemstack.getCount() > this.dragSplittingSlots.size() || this.dragSplittingLimit == 2) && Container.canAddItemToSlot(slot, itemstack, true) && slot.isItemValid(itemstack) && this.inventory.canDragIntoSlot(slot))
        {
            this.dragSplittingSlots.add(slot);
            this.updateDragSplitting();
        }
    }

    protected void mouseReleased(int mouseX, int mouseY, int state)
    {
        super.mouseReleased(mouseX, mouseY, state); //Forge, Call parent to release buttons
        Slot slot = this.getSlotAtPosition(mouseX - this.guiLeft, mouseY - this.guiTop);
        int i = this.guiLeft;
        int j = this.guiTop;
        boolean flag = this.hasClickedOutside(mouseX, mouseY, i, j);
        if (slot != null) flag = false; // Forge, prevent dropping of items through slots outside of GUI boundaries
        int k = -1;

        if (slot != null)
        {
            k = slot.slotNumber;
        }

        if (flag)
        {
            k = -999;
        }

        if (this.doubleClick && slot != null && state == 0 && this.inventory.canMergeSlot(ItemStack.EMPTY, slot))
        {
            if (isShiftKeyDown())
            {
                if (!this.shiftClickedSlot.isEmpty())
                {
                    for (Slot slot2 : this.inventory.inventorySlots)
                    {
                        if (slot2 != null && slot2.canTakeStack(this.mc.player) && slot2.getHasStack() && slot2.isSameInventory(slot) && Container.canAddItemToSlot(slot2, this.shiftClickedSlot, true))
                        {
                            this.handleMouseClick(slot2, slot2.slotNumber, state, ClickType.QUICK_MOVE);
                        }
                    }
                }
            }
            else
            {
                this.handleMouseClick(slot, k, state, ClickType.PICKUP_ALL);
            }

            this.doubleClick = false;
            this.lastClickTime = 0L;
        }
        else
        {
            if (this.dragSplitting && this.dragSplittingButton != state)
            {
                this.dragSplitting = false;
                this.dragSplittingSlots.clear();
                this.ignoreMouseUp = true;
                return;
            }

            if (this.ignoreMouseUp)
            {
                this.ignoreMouseUp = false;
                return;
            }

            if (this.clickedSlot != null && this.mc.gameSettings.touchscreen)
            {
                if (state == 0 || state == 1)
                {
                    if (this.draggedStack.isEmpty() && slot != this.clickedSlot)
                    {
                        this.draggedStack = this.clickedSlot.getStack();
                    }

                    boolean flag2 = Container.canAddItemToSlot(slot, this.draggedStack, false);

                    if (k != -1 && !this.draggedStack.isEmpty() && flag2)
                    {
                        this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, state, ClickType.PICKUP);
                        this.handleMouseClick(slot, k, 0, ClickType.PICKUP);

                        if (this.mc.player.inventory.getItemStack().isEmpty())
                        {
                            this.returningStack = ItemStack.EMPTY;
                        }
                        else
                        {
                            this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, state, ClickType.PICKUP);
                            this.touchUpX = mouseX - i;
                            this.touchUpY = mouseY - j;
                            this.returningStackDestSlot = this.clickedSlot;
                            this.returningStack = this.draggedStack;
                            this.returningStackTime = Minecraft.getSystemTime();
                        }
                    }
                    else if (!this.draggedStack.isEmpty())
                    {
                        this.touchUpX = mouseX - i;
                        this.touchUpY = mouseY - j;
                        this.returningStackDestSlot = this.clickedSlot;
                        this.returningStack = this.draggedStack;
                        this.returningStackTime = Minecraft.getSystemTime();
                    }

                    this.draggedStack = ItemStack.EMPTY;
                    this.clickedSlot = null;
                }
            }
            else if (this.dragSplitting && !this.dragSplittingSlots.isEmpty())
            {
                this.handleMouseClick((Slot)null, -999, Container.getQuickcraftMask(0, this.dragSplittingLimit), ClickType.QUICK_CRAFT);

                for (Slot slot1 : this.dragSplittingSlots)
                {
                    this.handleMouseClick(slot1, slot1.slotNumber, Container.getQuickcraftMask(1, this.dragSplittingLimit), ClickType.QUICK_CRAFT);
                }

                this.handleMouseClick((Slot)null, -999, Container.getQuickcraftMask(2, this.dragSplittingLimit), ClickType.QUICK_CRAFT);
            }
            else if (!this.mc.player.inventory.getItemStack().isEmpty())
            {
                if (this.mc.gameSettings.keyBindPickBlock.isActiveAndMatches(state - 100))
                {
                    this.handleMouseClick(slot, k, state, ClickType.CLONE);
                }
                else
                {
                    boolean flag1 = k != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));

                    if (flag1)
                    {
                        this.shiftClickedSlot = slot != null && slot.getHasStack() ? slot.getStack().copy() : ItemStack.EMPTY;
                    }

                    this.handleMouseClick(slot, k, state, flag1 ? ClickType.QUICK_MOVE : ClickType.PICKUP);
                }
            }
        }

        if (this.mc.player.inventory.getItemStack().isEmpty())
        {
            this.lastClickTime = 0L;
        }

        this.dragSplitting = false;
    }

    private boolean isMouseOverTab(int tabIndex, int mouseX, int mouseY)
    {
        int i = tabIndex;
        int l = this.guiLeft + this.xSize - 21 * (7 - i);
        int i1 = this.guiTop - 19;
        if ((mouseX > l && mouseX < l + 21) && (mouseY > i1 && mouseY < i1 + 21))
        {
            return true;
        }
        return false;
    }

    protected boolean isMouseOverPrimaryButton(int row, int mouseX, int mouseY)
    {
        int x_offset = 170 + this.guiLeft;
        int y_offset = 73 + this.guiTop + row * 6;

        if ((mouseX > x_offset && mouseX < x_offset + 5) && (mouseY > y_offset && mouseY < y_offset + 6))
            return true;

        return false;
    }

    private boolean isMouseOverSlot(Slot slotIn, int mouseX, int mouseY)
    {
        if (mouseX - 8 <= slotIn.xPos + 8 && mouseX - 8 >= slotIn.xPos - 8 && mouseY - 8 <= slotIn.yPos + 8 && mouseY - 8 >= slotIn.yPos - 8)
            return true;
        else
            return false;
    }

    private boolean isMouseOverArteTreeButton(int row, int col, int mouseX, int mouseY)
    {
        int x_offset = 8 + this.guiLeft + col * 4 + col * 51;
        int y_offset = 8 + this.guiTop + row * 3 + row * 18;

        if ((mouseX > x_offset && mouseX < x_offset + 51) && (mouseY > y_offset && mouseY < y_offset + 18))
            return true;
        else
            return false;
    }
    private boolean isMouseOverGlobalArtesButton(int row, int mouseX, int mouseY)
    {
        int x_offset = 9 + this.guiLeft;
        int y_offset = 74 + this.guiTop + row * 18;
        if ((mouseX > x_offset && mouseX < x_offset + 51) && (mouseY > y_offset && mouseY < y_offset + 18))
            return true;
        else
            return false;
    }
    private boolean isMouseOverGlobalArtesNavigator(int row, int mouseX, int mouseY)
    {
        int x_offset = 60 + this.guiLeft;
        int y_offset = 73 + this.guiTop + row * 28;
        int j = 0;
        int k = 54 + row * 28;

        if ((mouseX > x_offset && mouseX < x_offset + 5) && (mouseY > y_offset && mouseY < y_offset + 28))
            return true;
        else
            return false;
    }

    protected boolean hasClickedOutside(int p_193983_1_, int p_193983_2_, int p_193983_3_, int p_193983_4_)
    {
        for (int i = 0; i < 7; ++i)
        {
            if (isMouseOverTab(i,p_193983_1_, p_193983_2_))
            {
                return false;
            }
        }
        return p_193983_1_ < p_193983_3_ || p_193983_2_ < p_193983_4_ || p_193983_1_ >= p_193983_3_ + this.xSize || p_193983_2_ >= p_193983_4_ + this.ySize;
    }

    protected void handleMouseClick(Slot slotIn, int slotId, int mouseButton, ClickType type)
    {

        if (slotIn != null)
        {
            slotId = slotIn.slotNumber;
        }
        this.mc.playerController.windowClick(this.inventory.windowId, slotId, mouseButton, type, this.mc.player);
    }

    private Slot getSlotAtPosition(int x, int y)
    {
        for (int i = 0; i < this.inventory.inventorySlots.size(); ++i)
        {
            Slot slot = this.inventory.inventorySlots.get(i);

            if (slot != null)
            {
                if (selectedTabIndex == 0)
                {
                    if (slot.slotNumber < 36 || slot.slotNumber == 45 || slot.slotNumber > 72)
                    {
                        continue;
                    }
                }
                if (selectedTabIndex == 1)
                {
                    if (slot.slotNumber < 36 || slot.slotNumber == 45 || (slot.slotNumber >=46 && slot.slotNumber <= 72) ||slot.slotNumber > 99)
                    {
                        continue;
                    }
                }
                else if (selectedTabIndex == 2)
                {
                    if ((slot.slotNumber >= 9 && slot.slotNumber <= 35 ) || slot.slotNumber == 0 || (slot.slotNumber >= 1 && slot.slotNumber <= 4 )
                    || (slot.slotNumber >= 46 && slot.slotNumber < 100) || slot.slotNumber > 108)
                    {
                        continue;
                    }
                }
                else if (selectedTabIndex == 3)
                {
                    if (slot.slotNumber < 36 || slot.slotNumber == 45 || (slot.slotNumber >=46 && slot.slotNumber <= 108) || slot.slotNumber > 135)
                    {
                        continue;
                    }
                }
                else if (selectedTabIndex == 4)
                {
                    continue;
                }
                else if (selectedTabIndex == 5)
                {
                    if (slot.slotNumber < 36 || slot.slotNumber == 45 || (slot.slotNumber >=46 && slot.slotNumber <= 135))
                    {
                        continue;
                    }
                }
                else if (selectedTabIndex == 6)
                {
                    if ((slot.slotNumber >= 5 && slot.slotNumber <= 8 ) || slot.slotNumber >= 45)
                    {
                        continue;
                    }
                }
            }
            if (this.isMouseOverSlot(slot, x, y) && slot.isEnabled())
            {
                return slot;
            }
        }

        return null;
    }

    private void updateDragSplitting()
    {
        ItemStack itemstack = this.mc.player.inventory.getItemStack();

        if (!itemstack.isEmpty() && this.dragSplitting)
        {
            if (this.dragSplittingLimit == 2)
            {
                this.dragSplittingRemnant = itemstack.getMaxStackSize();
            }
            else
            {
                this.dragSplittingRemnant = itemstack.getCount();

                for (Slot slot : this.dragSplittingSlots)
                {
                    ItemStack itemstack1 = itemstack.copy();
                    ItemStack itemstack2 = slot.getStack();
                    int i = itemstack2.isEmpty() ? 0 : itemstack2.getCount();
                    Container.computeStackSize(this.dragSplittingSlots, this.dragSplittingLimit, itemstack1, i);
                    int j = Math.min(itemstack1.getMaxStackSize(), slot.getItemStackLimit(itemstack1));

                    if (itemstack1.getCount() > j)
                    {
                        itemstack1.setCount(j);
                    }

                    this.dragSplittingRemnant -= itemstack1.getCount() - i;
                }
            }
        }
    }

    /**
     * Draws an entity on the screen looking toward the cursor.
     */
    public static void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent)
    {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)posX, (float)posY, 50.0F);
        GlStateManager.scale((float)(-scale), (float)scale, (float)scale);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        float f = ent.renderYawOffset;
        float f1 = ent.rotationYaw;
        float f2 = ent.rotationPitch;
        float f3 = ent.prevRotationYawHead;
        float f4 = ent.rotationYawHead;
        GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-((float)Math.atan((double)(mouseY / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        ent.renderYawOffset = (float)Math.atan((double)(mouseX / 40.0F)) * 20.0F;
        ent.rotationYaw = (float)Math.atan((double)(mouseX / 40.0F)) * 40.0F;
        ent.rotationPitch = -((float)Math.atan((double)(mouseY / 40.0F))) * 20.0F;
        ent.rotationYawHead = ent.rotationYaw;
        ent.prevRotationYawHead = ent.rotationYaw;
        GlStateManager.translate(0.0F, 0.0F, 0.0F);
        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
        rendermanager.setPlayerViewY(180.0F);
        rendermanager.setRenderShadow(false);
        rendermanager.renderEntity(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
        rendermanager.setRenderShadow(true);
        ent.renderYawOffset = f;
        ent.rotationYaw = f1;
        ent.rotationPitch = f2;
        ent.prevRotationYawHead = f3;
        ent.rotationYawHead = f4;
        GlStateManager.popMatrix();
        //RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
    @javax.annotation.Nullable
    public Slot getSlotUnderMouse() { return this.hoveredSlot; }
    public int getGuiLeft() { return guiLeft; }
    public int getGuiTop() { return guiTop; }
    public int getXSize() { return xSize; }
    public int getYSize() { return ySize; }
}