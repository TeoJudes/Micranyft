package com.micranyft.mod.proxy;

import com.micranyft.mod.MicranyftMod;
import com.micranyft.model.ModelShark;
import com.micranyft.model.ModelWerewolf;
import com.micranyft.render.RenderBarrel;
import com.micranyft.render.RenderChair;
import com.micranyft.render.RenderFenceSide;
import com.micranyft.render.RenderShark;
import com.micranyft.render.RenderStool;
import com.micranyft.render.RenderTable;
import com.micranyft.render.RenderWardrobe;
import com.micranyft.render.RenderWerewolf;

import mod.micranyft.entity.EntityShark;
import mod.micranyft.entity.EntityWerewolf;
import mod.micranyft.itemrender.ItemRenderBarrel;
import mod.micranyft.itemrender.ItemRenderChair;
import mod.micranyft.itemrender.ItemRenderFenceSide;
import mod.micranyft.itemrender.ItemRenderStool;
import mod.micranyft.itemrender.ItemRenderTable;
import mod.micranyft.itemrender.ItemRenderWardrobe;
import mod.micranyft.tileentity.TileEntityBarrel;
import mod.micranyft.tileentity.TileEntityChair;
import mod.micranyft.tileentity.TileEntityFenceSide;
import mod.micranyft.tileentity.TileEntityStool;
import mod.micranyft.tileentity.TileEntityTable;
import mod.micranyft.tileentity.TileEntityWardrobe;
import net.minecraft.client.renderer.entity.Render;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy{
	
	@Override
	public  void registerRenderThings() {
		
		TileEntitySpecialRenderer render = new RenderTable();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTable.class, render);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MicranyftMod.table), new ItemRenderTable(render, new TileEntityTable()));
		
		TileEntitySpecialRenderer renderstool = new RenderStool();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStool.class, renderstool);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MicranyftMod.stool), new ItemRenderStool(renderstool, new TileEntityStool()));
		
		TileEntitySpecialRenderer renderbarrel = new RenderBarrel();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarrel.class, renderbarrel);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MicranyftMod.barrel), new ItemRenderBarrel(renderbarrel, new TileEntityBarrel()));
		
		TileEntitySpecialRenderer renderchair = new RenderChair();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChair.class, renderchair);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MicranyftMod.chair), new ItemRenderChair(renderchair, new TileEntityChair()));
		
		TileEntitySpecialRenderer renderfenceside = new RenderFenceSide();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFenceSide.class, renderfenceside);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MicranyftMod.fenceSide), new ItemRenderFenceSide(renderfenceside, new TileEntityFenceSide()));
		
		
		//entities
		RenderingRegistry.registerEntityRenderingHandler(EntityWerewolf.class, new RenderWerewolf(new ModelWerewolf(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityShark.class, new RenderShark(new ModelShark(), 0.3F));

	}
	@Override
	public int addArmor(String armor){
		return RenderingRegistry.addNewArmourRendererPrefix(armor);


	}
	@Override
	public void registerTileEntitySpecialRenderer(){
		
		TileEntitySpecialRenderer renderwardrobe = new RenderWardrobe();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWardrobe.class, renderwardrobe);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MicranyftMod.wardrobe), new ItemRenderWardrobe(renderwardrobe, new TileEntityWardrobe()));
		
	}

	
}
