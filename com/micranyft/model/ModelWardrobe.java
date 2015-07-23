package com.micranyft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWardrobe extends ModelBase
{
  //fields
    ModelRenderer block;
    ModelRenderer doorr;
    ModelRenderer doorl;
  
  public ModelWardrobe()
  {
    textureWidth = 256;
    textureHeight = 256;
    
      block = new ModelRenderer(this, 0, 0);
      block.addBox(0F, 0F, 0F, 14, 32, 12);
      block.setRotationPoint(-7F, -8F, -5F);
      block.setTextureSize(256, 256);
      block.mirror = true;
      setRotation(block, 0F, 0F, 0F);
      doorr = new ModelRenderer(this, 59, 0);
      doorr.addBox(0F, 0F, 0F, 7, 32, 2);
      doorr.setRotationPoint(-7F, -8F, -7F);
      doorr.setTextureSize(256, 256);
      doorr.mirror = true;
      setRotation(doorr, 0F, 0F, 0F);
      doorl = new ModelRenderer(this, 81, 0);
      doorl.addBox(0F, 0F, 0F, 7, 32, 2);
      doorl.setRotationPoint(7F, -8F, -5F);
      doorl.setTextureSize(256, 256);
      doorl.mirror = true;
      setRotation(doorl, 0F, -3.141593F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    block.render(f5);
    doorr.render(f5);
    doorl.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
