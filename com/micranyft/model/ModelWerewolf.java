package com.micranyft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelWerewolf extends ModelBase
{
  //fields
    ModelRenderer rleg1;
    ModelRenderer lleg1;
    ModelRenderer rleg2;
    ModelRenderer lleg2;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer larm;
    ModelRenderer rarm;
    ModelRenderer tail;
    ModelRenderer head;
    ModelRenderer snout;
    ModelRenderer rear;
    ModelRenderer lear;
  
  public ModelWerewolf()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      rleg1 = new ModelRenderer(this, 190, 0);
      rleg1.addBox(0F, 0F, 0F, 6, 12, 6);
      rleg1.setRotationPoint(-8F, 12F, -7F);
      rleg1.setTextureSize(256, 128);
      rleg1.mirror = true;
      setRotation(rleg1, 0F, 0F, 0F);
      lleg1 = new ModelRenderer(this, 220, 0);
      lleg1.addBox(0F, 0F, 0F, 6, 12, 6);
      lleg1.setRotationPoint(2F, 12F, -7F);
      lleg1.setTextureSize(256, 128);
      lleg1.mirror = true;
      setRotation(lleg1, 0F, 0F, 0F);
      rleg2 = new ModelRenderer(this, 130, 0);
      rleg2.addBox(0F, 0F, 0F, 6, 12, 6);
      rleg2.setRotationPoint(-8F, -1F, -1F);
      rleg2.setTextureSize(256, 128);
      rleg2.mirror = true;
      setRotation(rleg2, -0.4363323F, 0F, 0F);
      lleg2 = new ModelRenderer(this, 160, 0);
      lleg2.addBox(0F, 0F, 0F, 6, 12, 6);
      lleg2.setRotationPoint(2F, -1F, -1F);
      lleg2.setTextureSize(256, 128);
      lleg2.mirror = true;
      setRotation(lleg2, -0.4363323F, 0F, 0F);
      body1 = new ModelRenderer(this, 190, 50);
      body1.addBox(0F, 0F, 0F, 16, 16, 14);
      body1.setRotationPoint(-8F, -15F, -6F);
      body1.setTextureSize(256, 128);
      body1.mirror = true;
      setRotation(body1, 0.2617994F, 0F, 0F);
      body2 = new ModelRenderer(this, 133, 50);
      body2.addBox(0F, 0F, 0F, 16, 12, 11);
      body2.setRotationPoint(-8F, -29F, -7F);
      body2.setTextureSize(256, 128);
      body2.mirror = true;
      setRotation(body2, -0.4363323F, 0F, 0F);
      body3 = new ModelRenderer(this, 80, 50);
      body3.addBox(0F, 0F, 0F, 16, 8, 8);
      body3.setRotationPoint(-8F, -24F, 3F);
      body3.setTextureSize(256, 128);
      body3.mirror = true;
      setRotation(body3, -0.8726646F, 0F, 0F);
      larm = new ModelRenderer(this, 51, 50);
      larm.addBox(0F, 0F, 0F, 6, 24, 6);
      larm.setRotationPoint(8F, -24F, -8F);
      larm.setTextureSize(256, 128);
      larm.mirror = true;
      setRotation(larm, -0.1396263F, 0F, 0F);
      rarm = new ModelRenderer(this, 22, 50);
      rarm.addBox(0F, 0F, 0F, 6, 24, 6);
      rarm.setRotationPoint(-14F, -24F, -7F);
      rarm.setTextureSize(256, 128);
      rarm.mirror = true;
      setRotation(rarm, -0.1396263F, 0F, 0F);
      tail = new ModelRenderer(this, 0, 0);
      tail.addBox(0F, 0F, 0F, 6, 15, 6);
      tail.setRotationPoint(-3F, -2F, 8F);
      tail.setTextureSize(256, 128);
      tail.mirror = true;
      setRotation(tail, 1.082104F, 0F, 0F);
      head = new ModelRenderer(this, 88, 0);
      head.addBox(0F, 0F, 0F, 10, 9, 8);
      head.setRotationPoint(-5F, -32F, -15F);
      head.setTextureSize(256, 128);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      snout = new ModelRenderer(this, 54, 0);
      snout.addBox(0F, 0F, 0F, 6, 4, 8);
      snout.setRotationPoint(-3F, -27F, -23F);
      snout.setTextureSize(256, 128);
      snout.mirror = true;
      setRotation(snout, 0F, 0F, 0F);
      rear = new ModelRenderer(this, 40, 0);
      rear.addBox(0F, 0F, 0F, 2, 6, 2);
      rear.setRotationPoint(-7F, -37F, -10F);
      rear.setTextureSize(256, 128);
      rear.mirror = true;
      setRotation(rear, -0.1919862F, 0F, 0F);
      lear = new ModelRenderer(this, 40, 10);
      lear.addBox(0F, 0F, 0F, 2, 6, 2);
      lear.setRotationPoint(5F, -37F, -10F);
      lear.setTextureSize(256, 128);
      lear.mirror = true;
      setRotation(lear, -0.1919862F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    rleg1.render(f5);
    lleg1.render(f5);
    rleg2.render(f5);
    lleg2.render(f5);
    body1.render(f5);
    body2.render(f5);
    body3.render(f5);
    larm.render(f5);
    rarm.render(f5);
    tail.render(f5);
    head.render(f5);
    snout.render(f5);
    rear.render(f5);
    lear.render(f5);
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
    this.rleg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.lleg1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.rleg1.rotateAngleY = 0.0F;
    this.lleg1.rotateAngleY = 0.0F;
    this.rarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
    this.larm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    this.rarm.rotateAngleZ = 0.0F;
    this.larm.rotateAngleZ = 0.0F;
  }

}

