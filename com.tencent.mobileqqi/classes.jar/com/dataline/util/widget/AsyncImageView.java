package com.dataline.util.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.drawable.BitmapDrawableWithMargin;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import ev;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncImageView
  extends ImageView
{
  private int jdField_a_of_type_Int = 0;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private int c = 0;
  private int d = Color.parseColor("#C8C8C8");
  
  public AsyncImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AsyncImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AsyncImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static URL a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = null;
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {}
    do
    {
      try
      {
        paramString = new URL(paramString);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AsyncImageView", 2, paramString.getMessage(), paramString);
          }
          paramString = null;
        }
      }
      String str2;
      String str1;
      if (FileManagerUtil.a(paramString) == 2)
      {
        str2 = "videothumb";
        str1 = paramString;
        paramString = str2;
      }
      for (;;)
      {
        try
        {
          paramString = new URL(paramString, "", str1);
          return paramString;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          paramString = localObject;
        }
        str1 = "datalineimage";
        str2 = paramString + "|" + paramInt1 + "|" + paramInt2 + "|" + "0" + "|" + paramBoolean;
        paramString = str1;
        str1 = str2;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AsyncImageView", 2, localMalformedURLException.getMessage(), localMalformedURLException);
    return null;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (BaseBubbleBuilder.jdField_a_of_type_Boolean)
    {
      int m = View.MeasureSpec.getMode(paramInt1);
      int j = View.MeasureSpec.getMode(paramInt2);
      int n = View.MeasureSpec.getSize(paramInt1);
      int k = View.MeasureSpec.getSize(paramInt2);
      int i;
      if (m != -2147483648)
      {
        i = paramInt1;
        if (m != 1073741824) {}
      }
      else
      {
        i = paramInt1;
        if (n <= 0) {
          i = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
      }
      if (j != -2147483648)
      {
        paramInt1 = paramInt2;
        if (j != 1073741824) {}
      }
      else
      {
        paramInt1 = paramInt2;
        if (k <= 0) {
          paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
      }
      super.onMeasure(i, paramInt1);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setAsyncClipSize(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void setAsyncImage(String paramString)
  {
    URL localURL = a(paramString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Boolean);
    if ((getDrawable() instanceof URLDrawable))
    {
      paramString = (URLDrawable)getDrawable();
      if (paramString.getURL().toString().equals(localURL.toString()))
      {
        if ((paramString.getStatus() != 1) && (paramString.getStatus() != 0)) {
          paramString.restartDownload();
        }
        return;
      }
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      paramString = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    for (;;)
    {
      paramString = URLDrawable.getDrawable(localURL, paramString, paramString, false);
      setImageDrawable(paramString);
      paramString.setURLDrawableListener(new ev(this));
      return;
      if (this.jdField_b_of_type_Boolean) {
        paramString = new ColorDrawable(this.d);
      } else {
        paramString = getResources().getDrawable(this.c);
      }
    }
  }
  
  public void setDefaultColorDrawable(int paramInt)
  {
    this.d = paramInt;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void setDefaultImage(int paramInt)
  {
    this.c = paramInt;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void setDefaultImageByMargin()
  {
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_b_of_type_Int;
    Resources localResources = getResources();
    if ((URLDrawableHelper.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof SkinnableBitmapDrawable))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawableWithMargin(localResources, ((SkinnableBitmapDrawable)URLDrawableHelper.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap(), i, j, -921103);
      return;
    }
    if ((URLDrawableHelper.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawableWithMargin(localResources, ((BitmapDrawable)URLDrawableHelper.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap(), i, j, -921103);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = URLDrawableHelper.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public void setImageDrawableDefault()
  {
    setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void setIsDrawRound(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.util.widget.AsyncImageView
 * JD-Core Version:    0.7.0.1
 */