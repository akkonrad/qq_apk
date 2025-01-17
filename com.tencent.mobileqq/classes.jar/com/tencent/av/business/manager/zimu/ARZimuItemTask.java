package com.tencent.av.business.manager.zimu;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.av.ui.funchat.zimu.IZimuItemView;
import com.tencent.av.ui.funchat.zimu.IZimuItemView.FontPara;
import com.tencent.qphone.base.util.QLog;

public abstract class ARZimuItemTask
  implements IZimuItemView
{
  protected int a;
  protected Bitmap a;
  protected Canvas a;
  protected Paint a;
  protected SentenceInfo a;
  protected IZimuItemView.FontPara a;
  protected boolean a;
  protected int b;
  protected boolean b;
  
  public ARZimuItemTask(SentenceInfo paramSentenceInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = 32;
    this.jdField_b_of_type_Int = 255;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo = paramSentenceInfo;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public abstract int a();
  
  public int a(long paramLong)
  {
    return 0;
  }
  
  Bitmap a()
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.a))
    {
      AVLog.c("ARZimuItemTask", "TextUtils.isEmpty(mSentenceInfo.src_text) == null");
      localObject3 = localObject1;
    }
    do
    {
      for (;;)
      {
        return localObject3;
        AVLog.c("ARZimuItemTask", "build:" + toString());
        localObject1 = localObject3;
        Object localObject2 = localObject4;
        try
        {
          int i = a();
          localObject1 = localObject3;
          localObject2 = localObject4;
          int j = b();
          localObject1 = localObject3;
          localObject2 = localObject4;
          localObject3 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          localObject1 = localObject3;
          localObject2 = localObject3;
          this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap((Bitmap)localObject3);
          localObject1 = localObject3;
          localObject2 = localObject3;
          a(this.jdField_a_of_type_AndroidGraphicsCanvas, i, j);
          return localObject3;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localObject3 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.e("ARZimuItemTask", 2, localOutOfMemoryError.getMessage());
            return localObject1;
          }
        }
        catch (Exception localException)
        {
          localObject3 = localOutOfMemoryError;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("ARZimuItemTask", 2, localException.getMessage());
    return localOutOfMemoryError;
  }
  
  protected abstract void a(Canvas paramCanvas, int paramInt1, int paramInt2);
  
  public void a(Typeface paramTypeface, int paramInt, IZimuItemView.FontPara paramFontPara)
  {
    if (paramTypeface != null) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(paramTypeface);
    }
    this.jdField_a_of_type_ComTencentAvUiFunchatZimuIZimuItemView$FontPara = paramFontPara;
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramInt);
  }
  
  public void a(SentenceInfo paramSentenceInfo)
  {
    this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo = paramSentenceInfo;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return false;
  }
  
  public abstract int b();
  
  public Bitmap b()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = a();
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.zimu.ARZimuItemTask
 * JD-Core Version:    0.7.0.1
 */