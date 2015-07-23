package mod.micranyft.entity;

import com.jcraft.jorbis.Block;
import com.micranyft.mod.MicranyftMod;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityWerewolf  extends EntityMob{
	
	public EntityWerewolf(World world){
		super(world);
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityVillager.class, 2.0D, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 2.0D, false));
        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, true));


	}
	
	protected void applyEntityAttributes(){
		
		super.applyEntityAttributes();
		 this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(2.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
		
		
	}
	
	 protected Item getDropItem()
	    {
	        return MicranyftMod.silverIngot;
	    }
	 
	 protected void dropRareDrop(int par1) {
	    	this.entityDropItem(new ItemStack(MicranyftMod.silverSword, 1, 1), 0.0F);
	    }
     protected boolean isAIEnabled()
	    {
	        return true;
	    }
     protected String getLivingSound()
     {
         return "mmp:werewolf-grunt";
     }

     /**
      * Returns the sound this mob makes when it is hurt.
      */
     protected String getHurtSound()
     {
         return "mmp:werewolf-hurt";
     }

     /**
      * Returns the sound this mob makes on death.
      */
     protected String getDeathSound()
     {
         return "mmp:werewolf-death";
     }

     protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
     {
         this.playSound("mob.zombie.step", 0.15F, 1.0F);
     }
}
