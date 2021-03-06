package mod.micranyft.gui;

import org.lwjgl.opengl.GL11;

import com.micranyft.container.WardrobeContainer;

import mod.micranyft.tileentity.TileEntityWardrobe;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class WardrobeGui extends GuiContainer
{
	public static ResourceLocation texture = new ResourceLocation("mmp:textures/gui/wardrobe.png");
	private TileEntityWardrobe wardrobe;
	private IInventory playerInventory;
	
	public WardrobeGui(InventoryPlayer playerInv, TileEntityWardrobe tileWardrobe)
	{
		super(new WardrobeContainer(playerInv, tileWardrobe));
		this.wardrobe = tileWardrobe;
		this.playerInventory = playerInv;
		this.ySize = 230;
	}
	
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRendererObj.drawString(this.playerInventory.hasCustomInventoryName() ? this.playerInventory.getInventoryName() : I18n.format(this.playerInventory.getInventoryName()), 8, 129, 0);
        this.fontRendererObj.drawString(this.wardrobe.hasCustomInventoryName() ? this.wardrobe.getInventoryName() : I18n.format(this.wardrobe.getInventoryName()), 8, 7, 0);
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
	}
}