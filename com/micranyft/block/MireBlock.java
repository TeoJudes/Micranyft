package com.micranyft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class MireBlock extends Block {

	 public MireBlock(int id, Material material) {
		super(material);
		this.setResistance(15.0F);
		this.setStepSound(Block.soundTypeMetal);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(7.0F);
	}
	 
	 @Override
	 public void registerBlockIcons(IIconRegister p_149651_1_){
		 this.blockIcon = p_149651_1_.registerIcon("mmp:mire_block");
	 }

}