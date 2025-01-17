package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.component.media.annotation.Public;
import pib;

@Public
public class ScaleDrawable
  extends DrawableContainer
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private pib jdField_a_of_type_Pib;
  private float b = 0.0F;
  
  @Public
  public ScaleDrawable(Drawable paramDrawable)
  {
    this(paramDrawable, -1);
  }
  
  @Public
  public ScaleDrawable(Drawable paramDrawable, int paramInt)
  {
    this.jdField_a_of_type_Pib = new pib(paramDrawable, this);
    setConstantState(this.jdField_a_of_type_Pib);
    setScaleType(paramInt);
  }
  
  private ScaleDrawable(pib parampib, Resources paramResources)
  {
    this.jdField_a_of_type_Pib = new pib(parampib, this, paramResources);
    setConstantState(this.jdField_a_of_type_Pib);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsMatrix == null) {
      this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    }
    getMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_Int, getIntrinsicWidth(), getIntrinsicHeight(), getBounds().width(), getBounds().height(), this.jdField_a_of_type_Float, this.b);
  }
  
  public static void getMatrix(Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2)
  {
    if (paramInt1 == -1)
    {
      if (paramMatrix != null) {
        paramMatrix.reset();
      }
      return;
    }
    Matrix localMatrix = paramMatrix;
    if (paramMatrix == null) {
      localMatrix = new Matrix();
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      paramFloat2 = 0.0F;
      paramFloat1 = 0.0F;
      if (paramInt2 * paramInt5 > paramInt4 * paramInt3)
      {
        f1 = paramInt5 / paramInt3;
        paramFloat2 = (paramInt4 - paramInt2 * f1) * 0.5F;
      }
      for (;;)
      {
        localMatrix.setScale(f1, f1);
        localMatrix.postTranslate((int)(paramFloat2 + 0.5F), (int)(paramFloat1 + 0.5F));
        return;
        f1 = paramInt4 / paramInt2;
        paramFloat1 = (paramInt5 - paramInt3 * f1) * 0.5F;
      }
    case 1: 
      if (paramInt2 * paramInt5 > paramInt4 * paramInt3) {}
      for (paramFloat1 = paramInt5 / paramInt3;; paramFloat1 = paramInt4 / paramInt2)
      {
        localMatrix.setScale(paramFloat1, paramFloat1);
        localMatrix.postTranslate((int)(0.0F + 0.5F), (int)(0.0F + 0.5F));
        return;
      }
    case 2: 
      paramFloat2 = 0.0F;
      paramFloat1 = 0.0F;
      if (paramInt2 * paramInt5 > paramInt4 * paramInt3)
      {
        f1 = paramInt5 / paramInt3;
        paramFloat2 = (paramInt4 - paramInt2 * f1) * 1.0F;
      }
      for (;;)
      {
        localMatrix.setScale(f1, f1);
        localMatrix.postTranslate((int)(paramFloat2 + 0.5F), (int)(paramFloat1 + 0.5F));
        return;
        f1 = paramInt4 / paramInt2;
        paramFloat1 = (paramInt5 - paramInt3 * f1) * 1.0F;
      }
    case 3: 
      paramFloat2 = 0.0F;
      paramFloat1 = 0.0F;
      if (paramInt2 * paramInt5 > paramInt4 * paramInt3)
      {
        f1 = paramInt4 / paramInt2;
        paramFloat1 = (paramInt5 - paramInt3 * f1) * 0.5F;
      }
      for (;;)
      {
        localMatrix.setScale(f1, f1);
        localMatrix.postTranslate((int)(paramFloat2 + 0.5F), (int)(paramFloat1 + 0.5F));
        return;
        f1 = paramInt5 / paramInt3;
        paramFloat2 = (paramInt4 - paramInt2 * f1) * 0.5F;
      }
    case 4: 
      if (paramInt2 * paramInt5 > paramInt4 * paramInt3) {}
      for (paramFloat1 = paramInt4 / paramInt2;; paramFloat1 = paramInt5 / paramInt3)
      {
        localMatrix.setScale(paramFloat1, paramFloat1);
        localMatrix.postTranslate((int)(0.0F + 0.5F), (int)(0.0F + 0.5F));
        return;
      }
    case 5: 
      paramFloat2 = 0.0F;
      paramFloat1 = 0.0F;
      if (paramInt2 * paramInt5 > paramInt4 * paramInt3)
      {
        f1 = paramInt4 / paramInt2;
        paramFloat1 = (paramInt5 - paramInt3 * f1) * 1.0F;
      }
    case 6: 
      for (;;)
      {
        localMatrix.setScale(f1, f1);
        localMatrix.postTranslate((int)(paramFloat2 + 0.5F), (int)(paramFloat1 + 0.5F));
        paramFloat1 = paramInt4 / paramInt2;
        localMatrix.setScale(paramFloat1, paramFloat1);
        localMatrix.postTranslate((int)(0.0F + 0.5F), (int)(0.0F + 0.5F));
        return;
        f1 = paramInt5 / paramInt3;
        paramFloat2 = (paramInt4 - paramInt2 * f1) * 1.0F;
      }
    case 7: 
      paramFloat1 = paramInt4 / paramInt2;
      paramFloat2 = paramInt5;
      f1 = paramInt3;
      localMatrix.setScale(paramFloat1, paramFloat1);
      localMatrix.postTranslate((int)(0.0F + 0.5F), (int)(0.5F + (paramFloat2 - f1 * paramFloat1) * 1.0F));
      return;
    case 8: 
      paramFloat1 = paramInt4 / paramInt2;
      paramFloat2 = paramInt5;
      f1 = paramInt3;
      localMatrix.setScale(paramFloat1, paramFloat1);
      localMatrix.postTranslate((int)(0.0F + 0.5F), (int)(0.5F + (paramFloat2 - f1 * paramFloat1) * 0.5F));
      return;
    case 9: 
      paramFloat1 = paramInt5 - paramInt3;
      localMatrix.postTranslate((int)((paramInt4 - paramInt2) * 0.5F + 0.5F), (int)(paramFloat1 * 0.5F + 0.5F));
      return;
    }
    if (paramInt2 * paramInt5 > paramInt4 * paramInt3) {}
    for (float f1 = paramInt5 / paramInt3;; f1 = paramInt4 / paramInt2)
    {
      float f5 = paramInt4 * 0.5F;
      float f4 = paramInt5 * 0.5F;
      float f3 = 0.0F;
      float f2 = 0.0F;
      paramInt1 = (int)(paramInt2 * f1);
      paramInt2 = (int)(paramInt3 * f1);
      float f7 = paramInt1 * paramFloat1;
      float f6 = paramInt2 * paramFloat2;
      paramFloat1 = f3;
      if (paramInt1 > paramInt4)
      {
        paramFloat1 = f3;
        if (f7 > f5) {
          paramFloat1 = Math.min(paramInt1 - paramInt4, f7 - f5);
        }
      }
      paramFloat2 = f2;
      if (paramInt2 > paramInt5)
      {
        paramFloat2 = f2;
        if (f6 > f4) {
          paramFloat2 = Math.min(paramInt2 - paramInt5, f6 - f4);
        }
      }
      localMatrix.setScale(f1, f1);
      localMatrix.postTranslate((int)(paramFloat1 + 0.5F) * -1, (int)(paramFloat2 + 0.5F) * -1);
      return;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Matrix localMatrix = this.jdField_a_of_type_AndroidGraphicsMatrix;
    if ((localMatrix == null) || (localMatrix.isIdentity()))
    {
      super.draw(paramCanvas);
      return;
    }
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    paramCanvas.concat(localMatrix);
    super.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (this.jdField_a_of_type_Pib.a())
    {
      this.jdField_a_of_type_Pib.jdField_a_of_type_Int = getChangingConfigurations();
      return this.jdField_a_of_type_Pib;
    }
    return null;
  }
  
  public Matrix getMatrix()
  {
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
  }
  
  public int getMinimumHeight()
  {
    return 0;
  }
  
  public int getMinimumWidth()
  {
    return 0;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    int i = getIntrinsicWidth();
    int j = getIntrinsicHeight();
    Rect localRect = paramRect;
    if (i > 0)
    {
      localRect = paramRect;
      if (j > 0)
      {
        localRect = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect.set(0, 0, i, j);
      }
    }
    super.onBoundsChange(localRect);
    a();
  }
  
  @Public
  public void setPivot(float paramFloat1, float paramFloat2)
  {
    if ((this.jdField_a_of_type_Float != paramFloat1) || (this.b != paramFloat2))
    {
      this.jdField_a_of_type_Float = paramFloat1;
      this.b = paramFloat2;
      a();
    }
  }
  
  @Public
  public void setScaleType(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.ScaleDrawable
 * JD-Core Version:    0.7.0.1
 */