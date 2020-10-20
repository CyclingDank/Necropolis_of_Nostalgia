package com.turtledove.withernauts.client.gui;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.server.tiles.TileEntityBakeKettle;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiBakeKettle extends GuiContainer
{
    private static final ResourceLocation BAKE_KETTLE_INVENTROY = new ResourceLocation(Withernauts.MODID,"textures/gui/bake_kettle.png");

    private final InventoryPlayer playerInventory;
    private IInventory tileFurnace;

    public GuiBakeKettle(InventoryPlayer playerInv, IInventory furnaceInv)
    {
        super(new BakeKettleContainer(playerInv, furnaceInv));
        this.playerInventory = playerInv;
        this.tileFurnace = furnaceInv;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        this.mc.getTextureManager().bindTexture(BAKE_KETTLE_INVENTROY);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k,l, 0, 0, this.xSize, this.ySize - 2);

        int cooktime = ((TileEntityBakeKettle)tileFurnace).getField(0);
        int cook_method = ((TileEntityBakeKettle)tileFurnace).getField(1);
        int max_time = 320;
        if (cook_method == 2)
            max_time = 200;
        this.drawTexturedModalRect(k + 101,l + 37, 0, 164,(int)(19 * cooktime / max_time), 10);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

}
