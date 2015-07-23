package com.micranyft.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.micranyft.mod.MicranyftMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SharkrawCooked extends ItemFood {
	
	public SharkrawCooked(int heal, float saturation, boolean p_i45339_3_){
		super(heal,saturation,p_i45339_3_);
		this.setMaxStackSize(64);
		
	}

	public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.eat;
    }
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg){
		this.itemIcon= reg.registerIcon("mmp:sharkraw_cooked");
	}
}