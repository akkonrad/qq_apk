package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public abstract interface EditDoodleExport
  extends EditVideoPart.EditExport
{
  public abstract int a();
  
  public abstract Bitmap a();
  
  public abstract Bitmap a(int paramInt, boolean paramBoolean);
  
  @NonNull
  public abstract DoodleLayout a();
  
  public abstract void a(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void a(Bitmap paramBitmap);
  
  public abstract boolean a(int paramInt);
  
  public abstract byte[] a(int paramInt);
  
  public abstract void az_();
  
  public abstract void c();
  
  public abstract boolean c();
  
  public abstract boolean j_();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditDoodleExport
 * JD-Core Version:    0.7.0.1
 */