package com.micranyft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SilverIngot extends Item {
	
	public SilverIngot(int id){
		super();
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(64);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg){
		this.itemIcon= reg.registerIcon("mmp:silver_ingot");
	}

}
