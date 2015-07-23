package com.micranyft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTable extends ModelBase
{
  //fields
    ModelRenderer top;
    ModelRenderer foot1;
    ModelRenderer foot2;
    ModelRenderer foot3;
    ModelRenderer foot4;
  
  public ModelTable()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      top = new ModelRenderer(this, 0, 0);
      top.addBox(0F, 0F, 0F, 16, 4, 16);
      top.setRotationPoint(-8F, 8F, -8F);
      top.setTextureSize(64, 64);
      top.mirror = true;
      setRotation(top, 0F, 0F, 0F);
      foot1 = new ModelRenderer(this, 16, 20);
      foot1.addBox(0F, 0F, 0F, 4, 12, 4);
      foot1.setRotationPoint(4F, 12F, 4F);
      foot1.setTextureSize(64, 64);
      foot1.mirror = true;
      setRotation(foot1, 0F, 0F, 0F);
      foot2 = new ModelRenderer(this, 0, 20);
      foot2.addBox(0F, 0F, 0F, 4, 12, 4);
      foot2.setRotationPoint(-8F, 12F, 4F);
      foot2.setTextureSize(64, 64);
      foot2.mirror = true;
      setRotation(foot2, 0F, 0F, 0F);
      foot3 = new ModelRenderer(this, 0, 36);
      foot3.addBox(0F, 0F, 0F, 4, 12, 4);
      foot3.setRotationPoint(-8F, 12F, -8F);
      foot3.setTextureSize(64, 64);
      foot3.mirror = true;
      setRotation(foot3, 0F, 0F, 0F);
      foot4 = new ModelRenderer(this, 16, 36);
      foot4.addBox(0F, 0F, 0F, 4, 12, 4);
      foot4.setRotationPoint(4F, 12F, -8F);
      foot4.setTextureSize(64, 64);
      foot4.mirror = true;
      setRotation(foot4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    top.render(f5);
    foot1.render(f5);
    foot2.render(f5);
    foot3.render(f5);
    foot4.render(f5);
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
