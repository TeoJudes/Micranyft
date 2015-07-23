package com.micranyft.render;

import com.micranyft.model.ModelShark;

import mod.micranyft.entity.EntityShark;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderShark extends RenderLiving {
	
	private static final ResourceLocation texture = new ResourceLocation("mmp:" + "textures/model/shark.png");
	
	protected ModelShark modelEntity;

	public RenderShark(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		modelEntity = ((ModelShark) mainModel);
	}

	public void renderShark(EntityShark entity, double x, double y, double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}
	
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
		renderShark((EntityShark)entityLiving, x, y, z, u, v);
	}
	
	public void doRender(Entity entity, double x, double y, double z, float u, float v) {
		renderShark((EntityShark)entity, x, y, z, u, v);
	}
	
	
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return texture;
	}
}