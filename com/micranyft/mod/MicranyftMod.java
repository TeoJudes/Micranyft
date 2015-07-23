package com.micranyft.mod;

import com.micranyft.block.BlockBarrel;
import com.micranyft.block.BlockChair;
import com.micranyft.block.BlockStool;
import com.micranyft.block.BlockTable;
import com.micranyft.block.BlockWardrobe;
import com.micranyft.block.CropGrapes;
import com.micranyft.block.CropHop;
import com.micranyft.block.MireBlock;
import com.micranyft.block.MireOre;
import com.micranyft.block.SlabLog;
import com.micranyft.block.SlabPurestone;
import com.micranyft.block.StairMicranyft;
import com.micranyft.block.WineEmpty;
import com.micranyft.item.Beer;
import com.micranyft.item.BeerEmpty;
import com.micranyft.item.Grapes;
import com.micranyft.item.Hop;
import com.micranyft.item.MireArmor;
import com.micranyft.item.MireAxe;
import com.micranyft.item.MireHoe;
import com.micranyft.item.MireIngot;
import com.micranyft.item.MirePickaxe;
import com.micranyft.item.MireShovel;
import com.micranyft.item.MireSword;
import com.micranyft.item.ObsidianArmor;
import com.micranyft.item.ObsidianAxe;
import com.micranyft.item.ObsidianDust;
import com.micranyft.item.ObsidianHoe;
import com.micranyft.item.ObsidianIngot;
import com.micranyft.item.ObsidianPickaxe;
import com.micranyft.item.ObsidianShovel;
import com.micranyft.item.ObsidianSword;
import com.micranyft.item.RedstoneArmor;
import com.micranyft.item.RedstoneAxe;
import com.micranyft.item.RedstoneHoe;
import com.micranyft.item.RedstoneIngot;
import com.micranyft.item.RedstonePickaxe;
import com.micranyft.item.RedstoneShovel;
import com.micranyft.item.RedstoneSword;
import com.micranyft.item.Sharkraw;
import com.micranyft.item.SharkrawCooked;
import com.micranyft.item.SilverArmor;
import com.micranyft.item.SilverAxe;
import com.micranyft.item.SilverBlock;
import com.micranyft.item.SilverHoe;
import com.micranyft.item.SilverIngot;
import com.micranyft.item.SilverOre;
import com.micranyft.item.SilverPickaxe;
import com.micranyft.item.SilverShovel;
import com.micranyft.item.SilverSword;
import com.micranyft.item.Wine;
import com.micranyft.mod.proxy.CommonProxy;

import mod.micranyft.entity.EntityHandler;
import mod.micranyft.entity.EntityShark;
import mod.micranyft.entity.EntityWerewolf;
import mod.micranyft.handler.GuiHandler;
import mod.micranyft.tileentity.TileEntityBarrel;
import mod.micranyft.tileentity.TileEntityChair;
import mod.micranyft.tileentity.TileEntityWardrobe;
import mod.micranyft.worldgen.MireWorldGen;
import mod.micranyft.worldgen.SilverWorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid= "mmp" , name="Micranyft ModPack", version="0.0")
public class MicranyftMod {
	
	@SidedProxy(clientSide = "com.micranyft.mod.proxy.ClientProxy", serverSide = "com.micranyft.mod.proxy.CommonProxy")
	public static CommonProxy micranyftProxy;
	
	
	/*--------------------------------------------Material armor and Tool------------------------------------------*/
	
	public static ToolMaterial materialSilver = EnumHelper.addToolMaterial("SILVER", 2 , 801, 7.0F, 2.5F, 15);
	public static ToolMaterial materialMire = EnumHelper.addToolMaterial("MIRE", 5 , 3501, 12.0F, 6.0F, 8);
	public static ToolMaterial materialObsidian = EnumHelper.addToolMaterial("OBSIDIAN", 1 , 4000, 10.0F, 1.5F, 15);
	public static ToolMaterial materialRedstone = EnumHelper.addToolMaterial("REDSTONE", 1 , 201, 6.0F, 1.0F, 20);
	
	public static ArmorMaterial armorSilver = EnumHelper.addArmorMaterial("SILVER", 19 , new int[]{3,7,6,2}, 10);
	public static ArmorMaterial armorMire = EnumHelper.addArmorMaterial("MIRE", 40 , new int[]{6,16,12,6}, 12);
	public static ArmorMaterial armorObsidian = EnumHelper.addArmorMaterial("OBSIDIAN", 15 , new int[]{3,5,4,3}, 12);
	public static ArmorMaterial armorRedstone = EnumHelper.addArmorMaterial("REDSTONE", 9, new int[] {1, 4, 3, 1}, 17);
	
	/*--------------------------------------------------------------------------------------------------------------*/
	@Instance("mmp")
	public static MicranyftMod instance;
	
	@Metadata
	public static ModMetadata meta;
	
	/*-----------------------------------------------------------Block---------------------------------------------------------------------*/
	public static Block silverOre;	
	int silverOreID = 500;
	
	public static Block mireOre;
	int mireOreID = 501;
	
	public static Block mireBlock;
	int mireBlockID = 502;
	
	public static Block silverBlock;
	int silverBlockID = 503;
	
	public static Block slabPurestone, slabDoublePurestone;
	int slabPurestoneID = 505;
	int slabDoublePurestoneID = 506;
	
	public static Block stairPurestone;
	int stairPurestoneID = 507;
	
	public static Block stairLog;
	int stairLogID = 508;
	
	public static Block slabLog, slabDoubleLog;
	int slabLogID = 509;
	int slabDoubleLogID = 510;
	
	public static Block hopPlant;
	int hopPlantID = 511;
	
	public static Block grapesPlant;
	int grapesPlantID = 512;
	
	public static Block table;
	public static Block chair;
	public static Block stool;
	
	public static Block barrel;
	public static Block barrelIdle;
	
	public static Block wardrobe;
	
	
	
	/*---------------------------------------------Material( ingot, food, ect...)----------------------------------------------------*/
	public static Item silverIngot;
	int silverIngotID = 700;
	
	public static Item mireIngot;
	int mireIngotID = 710;
	
	public static Item obsidianDust;
	int obsidianDustID = 720;
	
	public static Item obsidianIngot;
	int obsidianIngotID = 721;
	
	public static Item redstoneIngot;
	int redstoneIngotID = 731;
	
	public static Item hopSeeds;
	int hopSeedsID = 740;
	
	public static Item hop;
	int hopID = 741;
	
	public static Item beer;
	
	public static Item beerEmpty;
	int beerEmptyID = 742;
	
	public static Item grapesSeeds;
	int grapesSeedsID = 745;
	
	public static Item grapes;
	int grapesID = 743;
	
	public static Item wine;
	
	public static Item wineEmpty;
	int wineEmptyID = 744;
	/*-------------------------------------------------tool , weapon , armor---------------------------------------------------------------*/
	public static Item silverSword;
	int silverSwordID = 701;
	
	public static Item silverPickaxe;
	int silverPickaxeID = 702;
	
	public static Item silverShovel;
	int silverShovelID = 703;
	
	public static Item silverAxe;
	int silverAxeID = 704;
	
	public static Item silverHoe;
	int silverHoeID = 705;
	
	public static Item silverHelmet;
	int silverHelmetID = 706;
	
	public static Item silverChestplate;
	int silverChestplateID = 707;
	
	public static Item silverLegs;
	int silverLegsID = 708;
	
	public static Item silverBoots;
	int silverBootsID = 709;
	
	public static Item mireHelmet;
	int mireHelmetID = 711;
	
	public static Item mireChestplate;
	int mireChestplateID = 712;
	
	public static Item mireLegs;
	int mireLegsID = 713;
	
	public static Item mireBoots;
	int mireBootsID = 714;
	
	public static Item mireSword;
	int mireSwordID = 715;
	
	public static Item mirePickaxe;
	int mirePickaxeID = 716;
	
	public static Item mireShovel;
	int mireShovelID = 717;
	
	public static Item mireAxe;
	int mireAxeID = 718;
	
	public static Item mireHoe;
	int mireHoeID = 719;
	
	public static Item obsidianHelmet;
	int obsidianHelmetID;
	
	public static Item obsidianChestplate;
	int obsidianChestplateID;
	
	public static Item obsidianLegs;
	int obsidianLegsID;
	
	public static Item obsidianBoots;
	int obsidianBootsID;
	
	public static Item obsidianSword;
	int obsidianSwordID = 726;
	
	public static Item obsidianPickaxe;
	int obsidianPickaxeID = 727;
	
	public static Item obsidianShovel;
	int obsidianShovelID = 728;
	
	public static Item obsidianAxe;
	int obsidianAxeID = 729;
	
	public static Item obsidianHoe;
	int obsidianHoeID = 730;

	public static Item redstoneSword;
	int redstoneSwordID = 731;
	
	public static Item redstonePickaxe;
	int redstonePickaxeID = 732;
	
	public static Item redstoneShovel;
	int redstoneShovelID = 733;
	
	public static Item redstoneAxe;
	int redstoneAxeID = 734;
	
	public static Item redstoneHoe;
	int redstoneHoeID = 735;
	
	public static Item redstoneHelmet;
	int redstoneHelmetID = 736;
	
	public static Item redstoneChestplate;
	int redstoneChestplateID = 737;
	
	public static Item redstoneLegs;
	int redstoneLegsID = 738;
	
	public static Item redstoneBoots;
	int redstoneBootsID = 739;
	
	public static Item sharkraw;
	
	public static Item sharkrawCooked;
	
	/*<---------------------------------------------------Gui------------------------------------------------------------------------->*/
	public static final int guiIDBarrel = 0;
	public static final int guiIDWardrobe = 1;
	
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//Itemm/Block init and registering
		
		//Config Handling

		
		obsidianDust = new ObsidianDust(obsidianDustID).setUnlocalizedName("ObsidianDust");
		obsidianIngot = new ObsidianIngot(obsidianIngotID).setUnlocalizedName("ObsidianIngot");
		redstoneIngot = new RedstoneIngot(redstoneIngotID).setUnlocalizedName("RedstoneIngot");	
		silverIngot = new SilverIngot(silverIngotID).setUnlocalizedName("SilverIngot");
		silverOre = new SilverOre(silverOreID, Material.rock).setBlockName("SilverOre");
		mireIngot = new MireIngot(mireIngotID).setUnlocalizedName("MireIngot");
		mireOre = new MireOre(mireOreID, Material.rock).setBlockName("MireOre");
		silverBlock = new SilverBlock(silverBlockID, Material.iron).setBlockName("SilverBlock");
		mireBlock = new MireBlock(mireBlockID, Material.iron).setBlockName("MireBlock");
		slabPurestone = new SlabPurestone(false, Material.rock).setBlockName("SlabPurestone");
		slabDoublePurestone = new SlabPurestone(true, Material.rock).setBlockName("SlabDoublePurestone");
		stairPurestone = new StairMicranyft(Blocks.stone, 0).setBlockName("StairPurestone");
		stairLog = new StairMicranyft(Blocks.log, 0).setBlockName("StairLog");
		slabLog = new SlabLog(false, Material.wood).setBlockName("SlabLog");
		slabDoubleLog = new SlabLog(true, Material.wood).setBlockName("SlabDoubleLog");
		
		table = new BlockTable(Material.wood).setBlockName("BlockTable");
		stool = new BlockStool(Material.wood).setBlockName("BlockStool");
		chair = new BlockChair(Material.wood).setBlockName("BlockChair");
		barrel = new BlockBarrel(Material.wood, true).setBlockName("BlockBarrel");
		wardrobe = new BlockWardrobe(Material.wood).setBlockName("BlockWardrobe");
				
		
		hopPlant = new CropHop().setBlockName("HopPlant");
		hopSeeds = new ItemSeeds(hopPlant, Blocks.farmland).setUnlocalizedName("HopSeeds").setTextureName("mmp:hop_seeds").setCreativeTab(CreativeTabs.tabMaterials);
		hop = new Hop(hopID).setUnlocalizedName("Hop");
		beer= new Beer(2,0.3F, false).setUnlocalizedName("Beer");
		beerEmpty = new BeerEmpty(beerEmptyID).setUnlocalizedName("BeerEmpty");
		
		sharkraw = new Sharkraw(2,0.3F, true).setUnlocalizedName("Sharkraw");
		sharkrawCooked = new SharkrawCooked(6,1.0F, true).setUnlocalizedName("SharkrawCooked");
		
		grapesPlant = new CropGrapes().setBlockName("GrapesPlant");
		grapesSeeds = new ItemSeeds(grapesPlant, Blocks.farmland).setUnlocalizedName("GrapesSeeds").setTextureName("mmp:grapes_seeds").setCreativeTab(CreativeTabs.tabMaterials);
		grapes = new Grapes(grapesID).setUnlocalizedName("Grapes");
		wine= new Wine(2,0.3F, false).setUnlocalizedName("Wine");
		wineEmpty = new WineEmpty(wineEmptyID).setUnlocalizedName("WineEmpty");	
		
		silverSword = new SilverSword(silverSwordID, MicranyftMod.materialSilver).setUnlocalizedName("SilverSword");
		silverPickaxe = new SilverPickaxe(silverPickaxeID, MicranyftMod.materialSilver).setUnlocalizedName("SilverPickaxe");
		silverShovel = new SilverShovel(silverShovelID, MicranyftMod.materialSilver).setUnlocalizedName("SilverShovel");
		silverAxe = new SilverAxe(silverAxeID, MicranyftMod.materialSilver).setUnlocalizedName("SilverAxe");
		silverHoe = new SilverHoe(silverHoeID, MicranyftMod.materialSilver).setUnlocalizedName("SilverHoe");
			
		mireSword = new MireSword(mireSwordID, MicranyftMod.materialMire).setUnlocalizedName("MireSword");
		mirePickaxe = new MirePickaxe(mirePickaxeID, MicranyftMod.materialMire).setUnlocalizedName("MirePickaxe");
		mireShovel = new MireShovel(mireShovelID, MicranyftMod.materialMire).setUnlocalizedName("MireShovel");
		mireAxe = new MireAxe(mireAxeID, MicranyftMod.materialMire).setUnlocalizedName("MireAxe");
		mireHoe = new MireHoe(mireHoeID, MicranyftMod.materialMire).setUnlocalizedName("MireHoe");	
		
		obsidianSword = new ObsidianSword(obsidianSwordID, MicranyftMod.materialObsidian).setUnlocalizedName("ObsidianSword");
		obsidianPickaxe = new ObsidianPickaxe(obsidianPickaxeID, MicranyftMod.materialObsidian).setUnlocalizedName("ObsidianPickaxe");
		obsidianShovel = new ObsidianShovel(obsidianShovelID, MicranyftMod.materialObsidian).setUnlocalizedName("ObsidianShovel");
		obsidianAxe = new ObsidianAxe(obsidianAxeID, MicranyftMod.materialObsidian).setUnlocalizedName("ObsidianAxe");
		obsidianHoe = new ObsidianHoe(obsidianHoeID, MicranyftMod.materialObsidian).setUnlocalizedName("ObsidianHoe");
		
		redstoneSword = new RedstoneSword(redstoneSwordID, MicranyftMod.materialRedstone).setUnlocalizedName("RedstoneSword");
		redstonePickaxe = new RedstonePickaxe(redstonePickaxeID, MicranyftMod.materialRedstone).setUnlocalizedName("RedstonePickaxe");
		redstoneShovel = new RedstoneShovel(redstoneShovelID, MicranyftMod.materialRedstone).setUnlocalizedName("RedstoneShovel");
		redstoneAxe = new RedstoneAxe(redstoneAxeID, MicranyftMod.materialRedstone).setUnlocalizedName("RedstoneAxe");
		redstoneHoe = new RedstoneHoe(redstoneHoeID, MicranyftMod.materialRedstone).setUnlocalizedName("RedstoneHoe");
		
		redstoneHelmet = new RedstoneArmor( MicranyftMod.armorRedstone,0).setUnlocalizedName("RedstoneHelmet");
		redstoneChestplate = new RedstoneArmor( MicranyftMod.armorRedstone,1).setUnlocalizedName("RedstoneChestplate");
		redstoneLegs = new RedstoneArmor( MicranyftMod.armorRedstone,2).setUnlocalizedName("RedstoneLegs");
		redstoneBoots= new RedstoneArmor(MicranyftMod.armorRedstone,3).setUnlocalizedName("RedstoneBoots");
		
		mireHelmet = new MireArmor(MicranyftMod.armorMire,  0).setUnlocalizedName("MireHelmet");
		mireChestplate = new MireArmor( MicranyftMod.armorMire,1).setUnlocalizedName("MireChestplate");
		mireLegs = new MireArmor( MicranyftMod.armorMire,2).setUnlocalizedName("MireLegs");
		mireBoots= new MireArmor(MicranyftMod.armorMire,3).setUnlocalizedName("MireBoots");
		
		silverHelmet = new SilverArmor( MicranyftMod.armorSilver,0).setUnlocalizedName("SilverHelmet");
		silverChestplate = new SilverArmor( MicranyftMod.armorSilver,1).setUnlocalizedName("SilverChestplate");
		silverLegs = new SilverArmor( MicranyftMod.armorSilver,2).setUnlocalizedName("SilverLegs");
		silverBoots= new SilverArmor(MicranyftMod.armorSilver,3).setUnlocalizedName("SilverBoots");
		
		obsidianHelmet = new ObsidianArmor( MicranyftMod.armorObsidian,0).setUnlocalizedName("ObsidianHelmet");
		obsidianChestplate = new ObsidianArmor( MicranyftMod.armorObsidian,1).setUnlocalizedName("ObsidianChestplate");
		obsidianLegs = new ObsidianArmor(MicranyftMod.armorObsidian,2).setUnlocalizedName("ObsidianLegs");
		obsidianBoots= new ObsidianArmor(MicranyftMod.armorObsidian,3).setUnlocalizedName("ObsidianBoots");
		
		
		

								
		/**-------------------------------------------Register----------------------------------------------------------------- */
		
		GameRegistry.registerItem(obsidianDust, "ObsidianDust");
		GameRegistry.registerItem(obsidianIngot, "ObsidianIngot");
		GameRegistry.registerItem(redstoneIngot, "RedstoneIngot");
		GameRegistry.registerItem(silverIngot, "SilverIngot");
		GameRegistry.registerItem(silverSword, "SilverSword");
		GameRegistry.registerItem(silverPickaxe, "SilverPickaxe");
		GameRegistry.registerItem(silverShovel, "SilverShovel");
		GameRegistry.registerItem(silverAxe, "SilverAxe");
		GameRegistry.registerItem(silverHoe, "SilverHoe");
		
		GameRegistry.registerItem(mireIngot, "MireIngot");
		
		GameRegistry.registerItem(mireSword, "MireSword");
		GameRegistry.registerItem(mirePickaxe, "MirePickaxe");
		GameRegistry.registerItem(mireShovel, "MireShovel");
		GameRegistry.registerItem(mireAxe, "MireAxe");
		GameRegistry.registerItem(mireHoe, "MireHoe");
		
		GameRegistry.registerItem(obsidianSword, "ObsidianSword");
		GameRegistry.registerItem(obsidianPickaxe, "ObsidianPickaxe");
		GameRegistry.registerItem(obsidianShovel, "ObsidianShovel");
		GameRegistry.registerItem(obsidianAxe, "ObsidianAxe");
		GameRegistry.registerItem(obsidianHoe, "ObsidianHoe");
		GameRegistry.registerItem(redstoneSword, "RedstoneSword");
		GameRegistry.registerItem(redstonePickaxe, "RedstonePickaxe");
		GameRegistry.registerItem(redstoneShovel, "RedstoneShovel");
		GameRegistry.registerItem(redstoneAxe, "RedstoneAxe");
		GameRegistry.registerItem(redstoneHoe, "RedstoneHoe");
		
		GameRegistry.registerItem(redstoneHelmet, "RedstoneHelmet");
		GameRegistry.registerItem(redstoneChestplate, "RedstoneChestplate");
		GameRegistry.registerItem(redstoneLegs, "RedstoneLegs");
		GameRegistry.registerItem(redstoneBoots, "RedstoneBoots");	
		GameRegistry.registerItem(silverHelmet, "SilverHelmet");
		GameRegistry.registerItem(silverChestplate, "SilverChestplate");
		GameRegistry.registerItem(silverLegs, "SilverLegs");
		GameRegistry.registerItem(silverBoots, "SilverBoots");
		GameRegistry.registerItem(mireHelmet, "MireHelmet");
		GameRegistry.registerItem(mireChestplate, "MireChestplate");
		GameRegistry.registerItem(mireLegs, "MireLegs");
		GameRegistry.registerItem(mireBoots, "MireBoots");
		GameRegistry.registerItem(obsidianHelmet, "ObsidianHelmet");
		GameRegistry.registerItem(obsidianChestplate, "ObsidianChestplate");
		GameRegistry.registerItem(obsidianLegs, "ObsidianLegs");
		GameRegistry.registerItem(obsidianBoots, "ObsidianBoots");
		
		GameRegistry.registerItem(hopSeeds, "HopSeeds");
		GameRegistry.registerItem(hop, "Hop");
		GameRegistry.registerItem(beer, "Beer");
		GameRegistry.registerItem(beerEmpty, "BeerEmpty");
		
		GameRegistry.registerItem(sharkraw,"Sharkraw");
		
		GameRegistry.registerItem(sharkrawCooked,"SharkrawCooked");
		
		GameRegistry.registerItem(grapesSeeds, "GrapesSeeds");
		GameRegistry.registerItem(grapes, "Grapes");
		GameRegistry.registerItem(wine, "Wine");
		GameRegistry.registerItem(wineEmpty, "GrapesEmpty");
		
		GameRegistry.registerBlock(silverOre, "SilverOre");
		GameRegistry.registerBlock(mireOre, "MireOre");
		GameRegistry.registerBlock(mireBlock, "MireBlock");
		GameRegistry.registerBlock(silverBlock, "SilverBlock");
		GameRegistry.registerBlock(slabPurestone, "SlabPurestone");
		GameRegistry.registerBlock(slabDoublePurestone, "SlabDoublePurestone");
		GameRegistry.registerBlock(stairPurestone, "StairPurestone");
		GameRegistry.registerBlock(stairLog, "StairLog");
		GameRegistry.registerBlock(slabLog, "SlabLog");
		GameRegistry.registerBlock(slabDoubleLog, "SlabDoubleLog");
		GameRegistry.registerBlock(hopPlant, "HopPlant");
		GameRegistry.registerBlock(grapesPlant, "GrapesPlant");
		GameRegistry.registerBlock(table, "BlockTable");
		GameRegistry.registerBlock(stool,"BlockStool");
		GameRegistry.registerBlock(barrel, "BlockBarrel");
		GameRegistry.registerBlock(chair, "BlockChair");
		GameRegistry.registerBlock(wardrobe, "BlockWardrobe");
		
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		
		//Proxy , TileEntity, entity,GUI and Packet Registering

		micranyftProxy.registerRenderThings();
		micranyftProxy.registerTileEntitySpecialRenderer();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		micranyftProxy.addArmor("5");
		micranyftProxy.addArmor("6");
		micranyftProxy.addArmor("7");
		micranyftProxy.addArmor("8");
		
		EntityHandler.registerEntities(EntityWerewolf.class, "Werewolf");
		EntityHandler.registerEntities(EntityShark.class, "Shark");
		GameRegistry.registerTileEntity(TileEntityBarrel.class, "BlockBarrel");
		GameRegistry.registerTileEntity(TileEntityChair.class, "BlockChair");
		GameRegistry.registerTileEntity(TileEntityWardrobe.class, "BlockWardrobe");
		
		GameRegistry.registerWorldGenerator(new SilverWorldGen(), 0);
		GameRegistry.registerWorldGenerator(new MireWorldGen(), 0);
		
		GameRegistry.addRecipe(new ItemStack(obsidianDust), new Object[]{"OOO","ORO","OOO", 'O', Blocks.obsidian, 'R', Items.redstone});
		
		GameRegistry.addRecipe(new ItemStack(silverSword), new Object[]{"I","I","S", 'I', silverIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(silverPickaxe), new Object[]{"III"," S "," S ", 'I', silverIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(silverHoe), new Object[]{"II","S ","S ", 'I', silverIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(silverAxe), new Object[]{"II","SI","S ", 'I', silverIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(silverShovel), new Object[]{"I","S","S", 'I', silverIngot, 'S', Items.stick});
		
		GameRegistry.addRecipe(new ItemStack(mireSword), new Object[]{"I","I","S", 'I', mireIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(mirePickaxe), new Object[]{"III"," S "," S ", 'I', mireIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(mireHoe), new Object[]{"II","S ","S ", 'I', mireIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(mireAxe), new Object[]{"II","SI","S ", 'I', mireIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(mireShovel), new Object[]{"I","S","S", 'I', mireIngot, 'S', Items.stick});
		
		GameRegistry.addRecipe(new ItemStack(obsidianSword), new Object[]{"I","I","S", 'I', obsidianIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(obsidianPickaxe), new Object[]{"III"," S "," S ", 'I', obsidianIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(obsidianHoe), new Object[]{"II","S ","S ", 'I', obsidianIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(obsidianAxe), new Object[]{"II","SI","S ", 'I', obsidianIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(obsidianShovel), new Object[]{"I","S","S", 'I', obsidianIngot, 'S', Items.stick});
		
		GameRegistry.addRecipe(new ItemStack(redstoneSword), new Object[]{"I","I","S", 'I', redstoneIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(redstonePickaxe), new Object[]{"III"," S "," S ", 'I', redstoneIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(redstoneHoe), new Object[]{"II","S ","S ", 'I', redstoneIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(redstoneAxe), new Object[]{"II","SI","S ", 'I', redstoneIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(redstoneShovel), new Object[]{"I","S","S", 'I', redstoneIngot, 'S', Items.stick});
		
		GameRegistry.addRecipe(new ItemStack(silverHelmet), new Object[]{"XXX","X X",'X', silverIngot});
		GameRegistry.addRecipe(new ItemStack(silverChestplate), new Object[]{"X X","XXX","XXX", 'X', silverIngot});
		GameRegistry.addRecipe(new ItemStack(silverLegs), new Object[]{"XXX","X X","X X", 'X', silverIngot});
		GameRegistry.addRecipe(new ItemStack(silverBoots), new Object[]{"X X","X X", 'X', silverIngot});
		
		GameRegistry.addRecipe(new ItemStack(mireHelmet), new Object[]{"XXX","X X", 'X', mireIngot});
		GameRegistry.addRecipe(new ItemStack(mireChestplate), new Object[]{"X X","XXX","XXX", 'X', mireIngot});
		GameRegistry.addRecipe(new ItemStack(mireLegs), new Object[]{"XXX","X X","X X", 'X', mireIngot});
		GameRegistry.addRecipe(new ItemStack(mireBoots), new Object[]{"X X","X X", 'X', mireIngot});
		
		GameRegistry.addRecipe(new ItemStack(obsidianHelmet), new Object[]{"XXX","X X", 'X', obsidianIngot});
		GameRegistry.addRecipe(new ItemStack(obsidianChestplate), new Object[]{"X X","XXX","XXX", 'X', obsidianIngot});
		GameRegistry.addRecipe(new ItemStack(obsidianLegs), new Object[]{"XXX","X X","X X", 'X', obsidianIngot});
		GameRegistry.addRecipe(new ItemStack(obsidianBoots), new Object[]{"X X","X X", 'X', obsidianIngot});
		
		GameRegistry.addRecipe(new ItemStack(redstoneHelmet), new Object[]{"XXX","X X", 'X', redstoneIngot});
		GameRegistry.addRecipe(new ItemStack(redstoneChestplate), new Object[]{"X X","XXX","XXX", 'X', redstoneIngot});
		GameRegistry.addRecipe(new ItemStack(redstoneLegs), new Object[]{"XXX","X X","X X", 'X', redstoneIngot});
		GameRegistry.addRecipe(new ItemStack(redstoneBoots), new Object[]{"X X","X X", 'X', redstoneIngot});
		
		GameRegistry.addRecipe(new ItemStack(silverBlock), new Object[]{"XXX","XXX","XXX", 'X', silverIngot});
		GameRegistry.addRecipe(new ItemStack(mireBlock), new Object[]{"XXX","XXX","XXX", 'X', mireIngot});
		GameRegistry.addRecipe(new ItemStack(stairLog, 4), new Object[]{"X  ","XX ","XXX", 'X', Blocks.log});
		GameRegistry.addRecipe(new ItemStack(stairPurestone, 4), new Object[]{"X  ","XX ","XXX", 'X', Blocks.stone});
		GameRegistry.addRecipe(new ItemStack(slabLog, 6), new Object[]{"XXX", 'X', Blocks.log});
		GameRegistry.addRecipe(new ItemStack(slabPurestone, 6), new Object[]{"XXX", 'X', Blocks.stone});
		GameRegistry.addRecipe(new ItemStack(table), new Object[]{"XXX","X X","X X", 'X', Blocks.planks});
		GameRegistry.addRecipe(new ItemStack(stool), new Object[]{"XXX","S S", 'X', Blocks.planks, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(barrel), new Object[]{"XXX","III", "XXX", 'X', Blocks.planks, 'I', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(chair), new Object[]{"X  ","XXX","S S", 'X', Blocks.planks, 'S', Items.stick});
		
		GameRegistry.addSmelting(mireOre, new ItemStack(mireIngot), 10.0F);
		GameRegistry.addSmelting(silverOre, new ItemStack(silverIngot), 5.0F);
		GameRegistry.addSmelting(sharkraw, new ItemStack(sharkrawCooked), 1.0F);
		GameRegistry.addSmelting(obsidianDust, new ItemStack(obsidianIngot), 5.0F);
		GameRegistry.addSmelting(Blocks.redstone_block, new ItemStack(redstoneIngot), 2.0F);
		GameRegistry.addSmelting(beerEmpty, new ItemStack(beer), 1.0F);
		GameRegistry.addSmelting(wineEmpty, new ItemStack(wine), 1.0F);
		
	
		//Entities

		

	}
	
	@EventHandler
	public void postInit(FMLInitializationEvent event){
		
	}

}
