package com.tencent.common.galleryactivity;

import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.widget.Gallery;

public class AnimationUtils
{
  public static float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = 1.0F;
    float f1;
    if ((paramInt1 >= paramInt3) && (paramInt2 >= paramInt4 * paramInt1 / paramInt3)) {
      f1 = paramInt3 / paramInt1;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return f1;
            if (paramInt1 >= paramInt3) {
              break;
            }
            f1 = f2;
          } while (paramInt2 >= paramInt4);
          if ((paramInt1 >= paramInt3) && (paramInt2 < paramInt4 * paramInt1 / paramInt3)) {
            return paramInt3 / paramInt1;
          }
          if ((paramInt1 > paramInt3) || (paramInt2 > paramInt4)) {
            return Math.min(paramInt4 / paramInt2, paramInt3 / paramInt1);
          }
          f1 = f2;
        } while (paramInt1 >= paramInt3);
        f1 = f2;
      } while (paramInt1 <= paramInt3 / 2);
      f1 = f2;
    } while (paramInt4 <= paramInt3 / paramInt1 * paramInt2);
    return paramInt3 / paramInt1;
  }
  
  public static Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, true, paramObject);
  }
  
  public static Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, Object paramObject)
  {
    float f = Gallery.a(paramInt1, paramInt2, paramInt3, paramInt4, paramObject);
    int i;
    label67:
    label79:
    Rect localRect;
    if (paramInt2 >= paramInt1 * 3)
    {
      i = 1;
      if ((i == 0) || ((paramInt1 <= paramInt3) && (paramInt2 <= paramInt4)) || ((paramInt1 < URLDrawableHelper.c) && (paramInt2 < URLDrawableHelper.c))) {
        break label119;
      }
      f = Math.min(paramInt3 / paramInt1, Gallery.a);
      i = 49;
      if ((paramBoolean) || (f <= 1.0F)) {
        break label126;
      }
      localRect = new Rect(0, 0, paramInt1, paramInt2);
      if (i != 49) {
        break label143;
      }
      localRect.offset((paramInt3 - paramInt1) / 2, 0);
    }
    label119:
    label126:
    do
    {
      do
      {
        do
        {
          return localRect;
          i = 0;
          break;
          i = 17;
          break label67;
          paramInt1 = (int)(paramInt1 * f);
          paramInt2 = (int)(paramInt2 * f);
          break label79;
        } while (i != 17);
        localRect.offset((paramInt3 - paramInt1) / 2, (paramInt4 - paramInt2) / 2);
      } while ((paramObject == null) || (!(paramObject instanceof AIOImageData)));
      paramObject = (AIOImageData)paramObject;
    } while ((paramObject.k == null) || (paramObject.k.length() == 0) || (paramObject.k.equals("null")));
    label143:
    localRect.offset(0, (int)(-15.0F * BaseApplicationImpl.sApplication.getResources().getDisplayMetrics().density * f));
    return localRect;
  }
  
  public static Rect a(View paramView)
  {
    Rect localRect = new Rect(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getWidth() - paramView.getPaddingRight(), paramView.getHeight() - paramView.getPaddingBottom());
    a(paramView, localRect);
    return localRect;
  }
  
  public static boolean a(View paramView, Rect paramRect)
  {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    Point localPoint = new Point();
    if ((i > 0) && (j > 0))
    {
      Rect localRect = paramRect;
      if (paramRect == null)
      {
        localRect = new Rect();
        localRect.set(0, 0, i, j);
      }
      localPoint.set(-paramView.getScrollX(), -paramView.getScrollY());
      localRect.offset((i - localRect.width()) / 2, (j - localRect.height()) / 2);
      return (localViewGroup == null) || (localViewGroup.getChildVisibleRect(paramView, localRect, localPoint));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AnimationUtils
 * JD-Core Version:    0.7.0.1
 */