package com.micranyft.item;

import com.micranyft.mod.MicranyftMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;


public class ObsidianArmor extends ItemArmor {
	
	public ObsidianArmor(ArmorMaterial armorMaterial, int type)
	{
		super(armorMaterial, 7, type);
		this.setCreativeTab(CreativeTabs.tabCombat);
		if(type == 0) {
			this.setTextureName("mmp:obsidian_helmet");
		}else if (type == 1) {
			this.setTextureName("mmp:obsidian_plate");
		}else if (type == 2) {
			this.setTextureName("mmp:obsidian_legs");
		}else if (type == 3) {
			this.setTextureName("mmp:obsidian_boots");
		}	
	}

	@SideOnly(Side.CLIENT)
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
		if(itemstack.getItem().equals(MicranyftMod.obsidianLegs))
		{
			return "mmp:textures/model/armor/obsidian_2.png";
		}
		else
		{
			return "mmp:textures/model/armor/obsidian_1.png";
		}
	}
}
