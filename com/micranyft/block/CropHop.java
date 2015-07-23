package com.micranyft.block;

import java.util.Random;

import com.micranyft.mod.MicranyftMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class CropHop extends BlockCrops{
	
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		this.iconArray = new IIcon[8];
		
		for (int i =0; i< this.iconArray.length ; i++){
			this.iconArray[i] = iconRegister.registerIcon("mmp:crop_hop_" + (i+1));
		}
		
	}
	public IIcon getIcon(int side, int metadata){
		if(metadata < 7){
			if (metadata == 6){
				metadata = 5;
			}
		return this.iconArray[metadata >> 1];
		}
		
		return this.iconArray[7];
	}
	
	public int quantityDropped(Random rand) {
		
		return 1;
		
	}
	protected Item func_149866_i(){
		
		return MicranyftMod.hopSeeds;
		
	}
	protected Item func_149865_P(){
		return MicranyftMod.hop;
	}

}
