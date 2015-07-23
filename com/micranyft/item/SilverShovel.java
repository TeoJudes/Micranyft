package com.micranyft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;

public class SilverShovel extends ItemSpade{
	
	public SilverShovel(int id, Item.ToolMaterial material){
		super(material);
		this.setCreativeTab(CreativeTabs.tabTools);
	}
	
	@SideOnly(Side.CLIENT)
	
	public void registerIcons(IIconRegister reg){
		this.itemIcon= reg.registerIcon("mmp:silver_shovel");
	}
}
