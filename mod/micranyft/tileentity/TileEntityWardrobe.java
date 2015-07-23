package mod.micranyft.tileentity;

import java.util.Iterator;
import java.util.List;

import com.micranyft.container.WardrobeContainer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;


public class TileEntityWardrobe extends TileEntityDirectional implements IInventory {

	 private byte direction;
	 private ItemStack[] inventory = new ItemStack[72];
	 private String customName;
	 public float doorrAngle;
	 public float prevDoorrAngle;
	 public int numUsingPlayers;
	 private int ticksSinceSync;
	    public int numPlayersUsing;

	 
	     @Override
	     public void readFromNBT(NBTTagCompound nbttag)
	 	{
	 		super.readFromNBT(nbttag);
	 		 this.direction = nbttag.getByte("Direction");
	 		NBTTagList nbttaglist = nbttag.getTagList("Items", Constants.NBT.TAG_COMPOUND);
	 		this.inventory = new ItemStack[this.getSizeInventory()];

	 		if(nbttag.hasKey("CustomName"))
	 		{
	 			this.customName = nbttag.getString("CustomName");
	 		}

	 		for(int i = 0; i < nbttaglist.tagCount(); i++)
	 		{
	 			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
	 			int j = nbttagcompound1.getByte("Slot");

	 			if(j >= 0 && j < this.inventory.length)
	 			{
	 				this.inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
	 			}
	 		}
	 	}

	 	public void writeToNBT(NBTTagCompound nbttag)
	 	{
	 		super.writeToNBT(nbttag);
	         nbttag.setByte("Direction", this.direction);
	 		NBTTagList nbttaglist = new NBTTagList();

	 		for(int i = 0; i < this.inventory.length; i++)
	 		{
	 			if(this.inventory[i] != null)
	 			{
	 				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
	 				nbttagcompound1.setByte("Slot", (byte)i);
	 				this.inventory[i].writeToNBT(nbttagcompound1);
	 				nbttaglist.appendTag(nbttagcompound1);
	 			}
	 		}

	 		nbttag.setTag("Items", nbttaglist);

	 		if(this.hasCustomInventoryName())
	 		{
	 			nbttag.setString("CustomName", this.customName);
	 		}
	 	}
	 
	     public byte getDirection()
	     {
	         return direction;
	     }
	 
	     public void setDirection(byte direction)
	     {
	         this.direction = direction;
	         this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	     }
	 
	     public Packet getDescriptionPacket()
	     {
	         NBTTagCompound nbttagcompound = new NBTTagCompound();
	         this.writeToNBT(nbttagcompound);
	         return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 0, nbttagcompound);
	     }
	 
	     public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	     {
	         this.readFromNBT(pkt.func_148857_g());
	         this.worldObj.markBlockRangeForRenderUpdate(this.xCoord, this.yCoord, this.zCoord, this.xCoord, this.yCoord, this.zCoord);
	     }
	     

		public int getSizeInventory()
		{
			return inventory.length;
		}


		public ItemStack getStackInSlot(int slotId)
		{
			return inventory[slotId];
		}

		public ItemStack decrStackSize(int slotId, int quantity)
		{
			if(this.inventory[slotId] != null)
			{
				ItemStack itemstack;

				if(this.inventory[slotId].stackSize <= quantity)
				{
					itemstack = this.inventory[slotId];
					this.inventory[slotId] = null;
					this.markDirty();
					return itemstack;
				}
				else
				{
					itemstack = this.inventory[slotId].splitStack(quantity);

					if(this.inventory[slotId].stackSize == 0)
					{
						this.inventory[slotId] = null;
					}

					this.markDirty();
					return itemstack;
				}
			}
			else
			{
				return null;
			}
		}


		public ItemStack getStackInSlotOnClosing(int slotId)
		{
			if(this.inventory[slotId] != null)
			{
				ItemStack itemstack = this.inventory[slotId];
				this.inventory[slotId] = null;
				return itemstack;
			}
			else
			{
				return null;
			}
		}

		public void setInventorySlotContents(int slotId, ItemStack stack)
		{
			this.inventory[slotId] = stack;

			if(stack != null && stack.stackSize > this.getInventoryStackLimit())
			{
				stack.stackSize = this.getInventoryStackLimit();
			}

			this.markDirty();
		}
		

		public String getInventoryName()
		{
			return this.hasCustomInventoryName() ? this.customName : "Wardrobe";
		}


		public boolean hasCustomInventoryName()
		{
			return this.customName != null && this.customName.length() > 0;
		}

		public void setCustomGuiName(String name)
		{
			this.customName = name;
		}


		public int getInventoryStackLimit()
		{
			return 64;
		}


		public boolean isUseableByPlayer(EntityPlayer player)
		{
			return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
		}


		public boolean receiveClientEvent(int eventId, int eventValue)
		{
			if(eventId == 1)
			{
				this.numUsingPlayers = eventValue;
				return true;
			}
			else
			{
				return super.receiveClientEvent(eventId, eventValue);
			}
		}


		public void openInventory()
		{
			if(this.numUsingPlayers < 0)
			{
				this.numUsingPlayers = 0;
			}

			++this.numUsingPlayers;
			this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType(), 1, this.numUsingPlayers);
		}


		public void closeInventory()
		{
			--this.numUsingPlayers;
			this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType(), 1, this.numUsingPlayers);
		}


		public boolean isItemValidForSlot(int slotId, ItemStack stack)
		{
			return true;
		}
		public void eraseDoorrAngle()
		{
			if(!this.worldObj.isRemote && this.doorrAngle < 1F)
			{
				doorrAngle += 0.05F;
				this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, zCoord);
			}
		}

		public void deraseDoorrAngle()
		{
			if(!this.worldObj.isRemote && this.doorrAngle > -1F)
			{
				doorrAngle -= 0.05F;
				this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, zCoord);
			}
		}
		
		public void updateEntity()
		{
		   super.updateEntity();
	        ++this.ticksSinceSync;
	        float f;

	    		this.prevDoorrAngle = this.doorrAngle;
	    		this.doorrAngle += this.doorrAngle / 10;
	    		if(doorrAngle >= 0)
	    		{
	    			if(doorrAngle > (prevDoorrAngle + (doorrAngle - prevDoorrAngle)) * (float)Math.PI * 2.0F)
	    			{
	    				doorrAngle = 0.0F;
	    			}
	    		}
	    		else
	    		{
	    			if(doorrAngle > (prevDoorrAngle + (doorrAngle - prevDoorrAngle)) * (float)Math.PI * 2.0F)
	    			{
	    				doorrAngle = 1.0F;
	    			}
	    		}
	    	}

}