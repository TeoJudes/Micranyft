package com.micranyft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class SilverSword extends ItemSword{
	
	public SilverSword(int id, Item.ToolMaterial material){
		super(material);
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	@SideOnly(Side.CLIENT)
	
	public void registerIcons(IIconRegister reg){
		this.itemIcon= reg.registerIcon("mmp:silver_sword");
	}
}
