package com.tencent.mobileqq.customviews;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.item.AIOSendMask;

public class FilePicMesProgressTextView
  extends MessageProgressTextView
{
  int a;
  public boolean a;
  int b;
  private boolean d;
  
  public void setDisplayInTextView(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void setProgress(int paramInt)
  {
    if ((this.d) && (this.jdField_a_of_type_Boolean)) {
      setText(paramInt + "%");
    }
    for (;;)
    {
      Drawable localDrawable = getBackground();
      if (localDrawable != null)
      {
        localDrawable.setLevel((100 - paramInt) * 100);
        if (((localDrawable instanceof AIOSendMask)) && (!this.jdField_a_of_type_Boolean)) {
          ((AIOSendMask)localDrawable).a(this.jdField_a_of_type_Int, this.b);
        }
      }
      return;
      setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.FilePicMesProgressTextView
 * JD-Core Version:    0.7.0.1
 */