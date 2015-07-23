package com.micranyft.render;



import com.micranyft.model.ModelWerewolf;

import mod.micranyft.entity.EntityWerewolf;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderWerewolf extends RenderLiving {
	
	private static final ResourceLocation texture = new ResourceLocation("mmp:" + "textures/model/loupgarou.png");
	
	protected ModelWerewolf modelEntity;

	public RenderWerewolf(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		modelEntity = ((ModelWerewolf) mainModel);
	}

	public void renderWerewolf(EntityWerewolf entity, double x, double y, double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}
	
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
		renderWerewolf((EntityWerewolf)entityLiving, x, y, z, u, v);
	}
	
	public void doRender(Entity entity, double x, double y, double z, float u, float v) {
		renderWerewolf((EntityWerewolf)entity, x, y, z, u, v);
	}
	
	
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return texture;
	}

	

}