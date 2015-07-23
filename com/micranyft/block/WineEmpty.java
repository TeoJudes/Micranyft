package com.micranyft.block;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WineEmpty extends Item{
	
	public WineEmpty(int id){
		super();
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(8);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg){
		this.itemIcon= reg.registerIcon("mmp:wine_empty");
	}

}
