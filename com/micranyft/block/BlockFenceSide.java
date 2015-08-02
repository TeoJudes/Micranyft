package com.micranyft.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import com.jcraft.jorbis.Block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mod.micranyft.tileentity.TileEntityFenceSide;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockFenceSide extends BlockContainer{
	
	public BlockFenceSide(Material material) {
		super(material);
		
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}
	
	public int getRenderType() {
		return -1;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityFenceSide();
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon("mmp:fence_side");
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack) {
		int l = MathHelper.floor_double((double)(entityplayer.rotationYaw * 4.0F / 360.F) + 0.5D) & 3;
		
		if(l == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		
		if(l == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		
		if(l == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		
		if(l == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
		
	}

	 @SideOnly(Side.CLIENT)
	    public IIcon getIcon(int side, int metadata)
	    {
	        return side == 3 && metadata == 0 ? this.blockIcon : (side == 4 && metadata == 1 ? this.blockIcon : (side == 2 && metadata == 2 ? this.blockIcon : (side == 5 && metadata == 3 ? this.blockIcon : this.blockIcon)));
	    }
	
	  public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection axis)
	    {
	        if((axis == ForgeDirection.UP || axis == ForgeDirection.DOWN) && !world.isRemote)
	        {
	            int direction = world.getBlockMetadata(x, y, z) + 1;
	            if(direction > 3)
	            {
	                direction = 0;
	            }
	            world.setBlockMetadataWithNotify(x, y, z, direction, 3);
	            return true;
	        }
	        return false;
	    }
	    
	    public ForgeDirection[] getValidRotations(World world, int x, int y, int z)
	    {
	        return new ForgeDirection[] {ForgeDirection.UP, ForgeDirection.DOWN};
	    }


}
