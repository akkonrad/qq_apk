package com.tencent.component.media.image.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.component.media.annotation.Public;
import phv;

@Public
public abstract class DrawableContainer
  extends Drawable
  implements Drawable.Callback
{
  private phv jdField_a_of_type_Phv;
  private boolean jdField_a_of_type_Boolean;
  
  public void draw(Canvas paramCanvas)
  {
    this.jdField_a_of_type_Phv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.jdField_a_of_type_Phv.jdField_a_of_type_Int | this.jdField_a_of_type_Phv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getChangingConfigurations();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (this.jdField_a_of_type_Phv.a())
    {
      this.jdField_a_of_type_Phv.jdField_a_of_type_Int = getChangingConfigurations();
      return this.jdField_a_of_type_Phv;
    }
    return null;
  }
  
  public Drawable getDrawable()
  {
    return this.jdField_a_of_type_Phv.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public int getIntrinsicHeight()
  {
    return this.jdField_a_of_type_Phv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_a_of_type_Phv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
  }
  
  public int getMinimumHeight()
  {
    if (this.jdField_a_of_type_Phv.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      return this.jdField_a_of_type_Phv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight();
    }
    return 0;
  }
  
  public int getMinimumWidth()
  {
    if (this.jdField_a_of_type_Phv.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      return this.jdField_a_of_type_Phv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth();
    }
    return 0;
  }
  
  public int getOpacity()
  {
    return this.jdField_a_of_type_Phv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    return this.jdField_a_of_type_Phv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getPadding(paramRect);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isStateful()
  {
    return this.jdField_a_of_type_Phv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.isStateful();
  }
  
  public Drawable mutate()
  {
    if ((!this.jdField_a_of_type_Boolean) && (super.mutate() == this))
    {
      this.jdField_a_of_type_Phv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.mutate();
      this.jdField_a_of_type_Boolean = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.jdField_a_of_type_Phv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    this.jdField_a_of_type_Phv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setLevel(paramInt);
    invalidateSelf();
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool = this.jdField_a_of_type_Phv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(paramArrayOfInt);
    onBoundsChange(getBounds());
    return bool;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_Phv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_Phv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(paramColorFilter);
  }
  
  @Public
  protected void setConstantState(phv paramphv)
  {
    this.jdField_a_of_type_Phv = paramphv;
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.jdField_a_of_type_Phv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setDither(paramBoolean);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    this.jdField_a_of_type_Phv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(paramBoolean1, paramBoolean2);
    return bool;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.DrawableContainer
 * JD-Core Version:    0.7.0.1
 */