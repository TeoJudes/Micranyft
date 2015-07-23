package com.micranyft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelShark extends ModelBase
{
  //fields
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer fintop;
    ModelRenderer finbot1;
    ModelRenderer finbot2;
    ModelRenderer headtop;
    ModelRenderer headbot;
    ModelRenderer finr;
    ModelRenderer finl;
  
  public ModelShark()
  {
    textureWidth = 256;
    textureHeight = 256;
    
      body1 = new ModelRenderer(this, 100, 0);
      body1.addBox(0F, 0F, 0F, 8, 8, 18);
      body1.setRotationPoint(-4F, 15F, -9F);
      body1.setTextureSize(256, 256);
      body1.mirror = true;
      setRotation(body1, 0F, 0F, 0F);
      body2 = new ModelRenderer(this, 50, 0);
      body2.addBox(0F, 0F, 0F, 6, 6, 14);
      body2.setRotationPoint(-3F, 17F, 9F);
      body2.setTextureSize(256, 256);
      body2.mirror = true;
      setRotation(body2, 0F, 0F, 0F);
      fintop = new ModelRenderer(this, 0, 86);
      fintop.addBox(0F, 0F, 0F, 1, 8, 4);
      fintop.setRotationPoint(-0.5F, 9F, 4F);
      fintop.setTextureSize(256, 256);
      fintop.mirror = true;
      setRotation(fintop, -0.6108652F, 0F, 0F);
      finbot1 = new ModelRenderer(this, 0, 50);
      finbot1.addBox(0F, 0F, 0F, 1, 10, 4);
      finbot1.setRotationPoint(-0.5F, 12F, 28F);
      finbot1.setTextureSize(256, 256);
      finbot1.mirror = true;
      setRotation(finbot1, -1.047198F, 0F, 0F);
      finbot2 = new ModelRenderer(this, 21, 50);
      finbot2.addBox(0F, 0F, 0F, 1, 6, 4);
      finbot2.setRotationPoint(-0.5F, 23F, 19F);
      finbot2.setTextureSize(256, 256);
      finbot2.mirror = true;
      setRotation(finbot2, 1.047198F, 0F, 0F);
      headtop = new ModelRenderer(this, 0, 14);
      headtop.addBox(0F, 0F, 0F, 7, 3, 9);
      headtop.setRotationPoint(-3.5F, 20.5F, -16F);
      headtop.setTextureSize(256, 256);
      headtop.mirror = true;
      setRotation(headtop, 0.6108652F, 0F, 0F);
      headbot = new ModelRenderer(this, 0, 0);
      headbot.addBox(0F, 0F, 0F, 7, 3, 4);
      headbot.setRotationPoint(-3.5F, 18.5F, -11F);
      headbot.setTextureSize(256, 256);
      headbot.mirror = true;
      setRotation(headbot, -0.5235988F, 0F, 0F);
      finr = new ModelRenderer(this, 0, 70);
      finr.addBox(0F, 0F, 0F, 1, 4, 8);
      finr.setRotationPoint(-2F, 20F, -2F);
      finr.setTextureSize(256, 256);
      finr.mirror = true;
      setRotation(finr, -0.418879F, -0.2617994F, 0.7853982F);
      finl = new ModelRenderer(this, 22, 70);
      finl.addBox(0F, 0F, -1F, 1, 4, 8);
      finl.setRotationPoint(2F, 21F, -1F);
      finl.setTextureSize(256, 256);
      finl.mirror = true;
      setRotation(finl, -0.418879F, 0.2617994F, -0.7853982F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    body1.render(f5);
    body2.render(f5);
    fintop.render(f5);
    finbot1.render(f5);
    finbot2.render(f5);
    headtop.render(f5);
    headbot.render(f5);
    finr.render(f5);
    finl.render(f5);
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
