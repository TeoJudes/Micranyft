package mod.micranyft.handler;

import com.micranyft.container.BarrelContainer;
import com.micranyft.container.WardrobeContainer;
import com.micranyft.mod.MicranyftMod;

import mod.micranyft.gui.BarrelGui;
import mod.micranyft.gui.WardrobeGui;
import mod.micranyft.tileentity.TileEntityBarrel;
import mod.micranyft.tileentity.TileEntityWardrobe;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {


	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		if(entity != null) {
			switch(ID) {
			case MicranyftMod.guiIDBarrel:
				if (entity instanceof TileEntityBarrel) {
					return new BarrelContainer(player.inventory, (TileEntityBarrel) entity);
				}
				return null;
			case MicranyftMod.guiIDWardrobe:
				if (entity instanceof TileEntityWardrobe) {
					return new WardrobeContainer(player.inventory, (TileEntityWardrobe) entity);
				}
				return null;
				
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null) {
			switch(ID) {
			case MicranyftMod.guiIDBarrel:
				if (entity instanceof TileEntityBarrel) 
				{
					return new BarrelGui(player.inventory, (TileEntityBarrel) entity);
				}
				return null;
			case MicranyftMod.guiIDWardrobe:
				if (entity instanceof TileEntityWardrobe) 
				{
					return new WardrobeGui(player.inventory, (TileEntityWardrobe) entity);
				}
				return null;
				
			}
		}
		return null;
	}
}




