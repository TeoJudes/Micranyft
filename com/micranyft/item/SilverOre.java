package com.micranyft.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class SilverOre extends Block {

	 public SilverOre(int id, Material material) {
		super(material);
		this.setResistance(15.0F);
		this.setStepSound(Block.soundTypeStone);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(7.0F);
	}
	 
	 @Override
	 public void registerBlockIcons(IIconRegister p_149651_1_){
		 this.blockIcon = p_149651_1_.registerIcon("mmp:silver_ore");
	 }
	 
	 /*public Item func_149650 a(int par1, Random rand, int par2){
		 return MicranyftMod.silverIngot;
	 }*/
}
