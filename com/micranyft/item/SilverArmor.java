package com.micranyft.item;

import com.micranyft.mod.MicranyftMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;


public class SilverArmor extends ItemArmor {
	
	
	public SilverArmor(ArmorMaterial armorMaterial, int type)
	{
		super(armorMaterial, 5, type);
		this.setCreativeTab(CreativeTabs.tabCombat);
		if(type == 0) {
			this.setTextureName("mmp:silver_helmet");
		}else if (type == 1) {
			this.setTextureName("mmp:silver_plate");
		}else if (type == 2) {
			this.setTextureName("mmp:silver_legs");
		}else if (type == 3) {
			this.setTextureName("mmp:silver_boots");
		}	
	}

	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
		if(itemstack.getItem().equals(MicranyftMod.silverLegs))
		{
			return "mmp:textures/model/armor/silver_2.png";
		}
		else
		{
			return "mmp:textures/model/armor/silver_1.png";
		}
	}
}
