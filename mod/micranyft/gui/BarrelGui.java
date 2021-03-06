package mod.micranyft.gui;

import org.lwjgl.opengl.GL11;

import com.micranyft.container.BarrelContainer;

import mod.micranyft.tileentity.TileEntityBarrel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class BarrelGui extends GuiContainer {
	
	public static final ResourceLocation bground = new ResourceLocation("mmp:textures/gui/barrel_gui.png");
	
	public TileEntityBarrel barrel;

	public BarrelGui(InventoryPlayer inventoryPlayer, TileEntityBarrel entity) {
		super(new BarrelContainer(inventoryPlayer, entity));
		
		this.barrel = entity;
		
		this.xSize = 176;
		this.ySize = 166;
	}


	public void drawGuiContainerForegroundLayer(int par1, int par2) {
		
		String name = this.barrel.hasCustomInventoryName() ? this.barrel.getInventoryName() : I18n.format(this.barrel.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString("Barrel", this.xSize / 2 - this.fontRendererObj.getStringWidth("Barrel") / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 118, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	
		if(this.barrel.isBurning()) {
			int k = this.barrel.getBurnTimeRemainingScaled(40);
			int j = 40 - k;
			drawTexturedModalRect(guiLeft + 29, guiTop + 65, 176, 0, 40 - j, 10);
		}
		
		int k = this.barrel.getCookProgressScaled(24);
		drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 10, k + 1, 16);
	}

}
