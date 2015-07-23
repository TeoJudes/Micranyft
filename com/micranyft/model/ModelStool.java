package com.micranyft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStool extends ModelBase
{
  //fields
    ModelRenderer top;
    ModelRenderer foot1;
    ModelRenderer foot2;
    ModelRenderer foot3;
    ModelRenderer foot4;
    ModelRenderer foots1;
    ModelRenderer foots2;
    ModelRenderer footl1;
    ModelRenderer footl2;
  
  public ModelStool()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      top = new ModelRenderer(this, 0, 0);
      top.addBox(0F, 0F, 0F, 8, 1, 8);
      top.setRotationPoint(-4F, 17F, -4F);
      top.setTextureSize(64, 64);
      top.mirror = true;
      setRotation(top, 0F, 0F, 0F);
      foot1 = new ModelRenderer(this, 38, 0);
      foot1.addBox(0F, 0F, 0F, 1, 6, 1);
      foot1.setRotationPoint(2F, 18F, 2F);
      foot1.setTextureSize(64, 64);
      foot1.mirror = true;
      setRotation(foot1, 0F, 0F, 0F);
      foot2 = new ModelRenderer(this, 34, 0);
      foot2.addBox(0F, 0F, 0F, 1, 6, 1);
      foot2.setRotationPoint(2F, 18F, -3F);
      foot2.setTextureSize(64, 64);
      foot2.mirror = true;
      setRotation(foot2, 0F, 0F, 0F);
      foot3 = new ModelRenderer(this, 42, 0);
      foot3.addBox(0F, 0F, 0F, 1, 6, 1);
      foot3.setRotationPoint(-3F, 18F, 2F);
      foot3.setTextureSize(64, 64);
      foot3.mirror = true;
      setRotation(foot3, 0F, 0F, 0F);
      foot4 = new ModelRenderer(this, 46, 0);
      foot4.addBox(0F, 0F, 0F, 1, 6, 1);
      foot4.setRotationPoint(-3F, 18F, -3F);
      foot4.setTextureSize(64, 64);
      foot4.mirror = true;
      setRotation(foot4, 0F, 0F, 0F);
      foots1 = new ModelRenderer(this, 11, 13);
      foots1.addBox(0F, 0F, 0F, 4, 1, 1);
      foots1.setRotationPoint(-2F, 21F, 2F);
      foots1.setTextureSize(64, 64);
      foots1.mirror = true;
      setRotation(foots1, 0F, 0F, 0F);
      foots2 = new ModelRenderer(this, 34, 13);
      foots2.addBox(0F, 0F, 0F, 4, 1, 1);
      foots2.setRotationPoint(-2F, 21F, -3F);
      foots2.setTextureSize(64, 64);
      foots2.mirror = true;
      setRotation(foots2, 0F, 0F, 0F);
      footl1 = new ModelRenderer(this, 22, 10);
      footl1.addBox(0F, 0F, 0F, 1, 1, 4);
      footl1.setRotationPoint(2F, 21F, -2F);
      footl1.setTextureSize(64, 64);
      footl1.mirror = true;
      setRotation(footl1, 0F, 0F, 0F);
      footl2 = new ModelRenderer(this, 0, 10);
      footl2.addBox(0F, 0F, 0F, 1, 1, 4);
      footl2.setRotationPoint(-3F, 21F, -2F);
      footl2.setTextureSize(64, 64);
      footl2.mirror = true;
      setRotation(footl2, 0F, 0F, 0F);
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
    foots1.render(f5);
    foots2.render(f5);
    footl1.render(f5);
    footl2.render(f5);
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
