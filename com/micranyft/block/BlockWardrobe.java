package com.micranyft.block;
	import java.util.Random;

import com.jcraft.jorbis.Block;
import com.micranyft.mod.MicranyftMod;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mod.micranyft.tileentity.TileEntityChair;
import mod.micranyft.tileentity.TileEntityStool;
import mod.micranyft.tileentity.TileEntityWardrobe;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import java.util.Random;



import mod.micranyft.tileentity.TileEntityBarrel;
import mod.micranyft.tileentity.TileEntityTable;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



public class BlockWardrobe extends BlockContainer{
	
	private Random rand = new Random();
		
		public BlockWardrobe(Material material) {
			super(material);
			
			this.setHardness(2.0F);
			this.setResistance(5.0F);
			this.setBlockBounds(0F, 0F, 0F, 1F, 2.0F, 1F);
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
			return new TileEntityWardrobe();
		}
		
		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister iconRegister) {
			this.blockIcon = iconRegister.registerIcon("mmp:wardrobe");
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
			public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
				if(!world.isRemote) {
					FMLNetworkHandler.openGui(player, MicranyftMod.instance, MicranyftMod.guiIDWardrobe, world, x, y, z);
				}
				return true;
			}
			public Item getItem(World world, int x, int y, int z) {
				return Item.getItemFromBlock(MicranyftMod.wardrobe);
			}
			public Item getItemDropped(int i, Random random, int j) {
				return Item.getItemFromBlock(MicranyftMod.wardrobe);
			}
			
			public void breakBlock(World world, int x, int y, int z, net.minecraft.block.Block oldblock, int oldMetadata) {

					TileEntityWardrobe tileentity = (TileEntityWardrobe) world.getTileEntity(x, y, z);
					
					if(tileentity != null) {
						for(int i = 0; i < tileentity.getSizeInventory(); i++) {
							ItemStack itemstack = tileentity.getStackInSlot(i);
							
							if(itemstack != null) {
								float f = this.rand.nextFloat() * 0.8F + 0.1F;
								float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
								float f2 = this.rand.nextFloat() * 0.8F + 0.1F;
								
								while(itemstack.stackSize > 0) {
									int j = this.rand.nextInt(21) + 10;
									
									if(j > itemstack.stackSize) {
										j = itemstack.stackSize;
									}
									
									itemstack.stackSize -= j;
									
									EntityItem item = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));
									
									if(itemstack.hasTagCompound()) {
										item.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
									}
									
									world.spawnEntityInWorld(item);
								}
							}
						}
						
						world.func_147453_f(x, y, z, oldblock);
					}
			    
				super.breakBlock(world, x, y, z, oldblock, oldMetadata);
			}			

	}