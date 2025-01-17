package com.tencent.token.ui.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import com.tencent.token.utils.t;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LockPatternSmallView
  extends View
  implements cb
{
  LockPatternView a;
  public int b = 1;
  private Paint c = new Paint();
  private boolean[][] d = (boolean[][])Array.newInstance(Boolean.TYPE, new int[] { 3, 3 });
  private LockPatternView.DisplayMode e = LockPatternView.DisplayMode.Correct;
  private float f;
  private float g;
  private Bitmap h;
  private Bitmap i;
  private Bitmap j;
  private Bitmap k;
  private int l;
  private int m;
  private ArrayList n;
  private Activity o;
  private int p;
  
  public LockPatternSmallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.o = ((Activity)paramContext);
    setClickable(false);
    paramContext = new DisplayMetrics();
    this.o.getWindowManager().getDefaultDisplay().getMetrics(paramContext);
    this.p = paramContext.widthPixels;
    int i1 = this.p * 14 / 320;
    this.h = t.a(getResources(), 2130837928, i1);
    this.i = t.a(getResources(), 2130837927, i1);
    this.j = t.a(getResources(), 2130837929, i1);
    this.k = t.a(getResources(), 2130837930, i1);
    this.l = this.h.getWidth();
    this.m = this.h.getHeight();
  }
  
  public final void a()
  {
    if (this.b != 1) {
      return;
    }
    int i1 = 0;
    while (i1 < 3)
    {
      int i2 = 0;
      while (i2 < 3)
      {
        this.d[i1][i2] = 0;
        i2 += 1;
      }
      i1 += 1;
    }
    this.n = this.a.b();
    this.e = this.a.c();
    invalidate();
  }
  
  public final void a(LockPatternView.DisplayMode paramDisplayMode)
  {
    this.e = paramDisplayMode;
    postInvalidate();
  }
  
  public final void a(LockPatternView paramLockPatternView)
  {
    this.a = paramLockPatternView;
    paramLockPatternView.a(this);
  }
  
  public final void a(List paramList)
  {
    if (this.b == 2) {
      return;
    }
    this.n = this.a.b();
    this.e = this.a.c();
    invalidate();
  }
  
  public final void b()
  {
    if (this.b != 1) {
      return;
    }
    this.n = this.a.b();
    this.e = this.a.c();
    invalidate();
  }
  
  public final void c()
  {
    if (this.b != 1) {
      return;
    }
    this.n = this.a.b();
    this.e = this.a.c();
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.n == null) {
      this.n = new ArrayList();
    }
    Object localObject = this.n;
    ((ArrayList)localObject).size();
    boolean[][] arrayOfBoolean = this.d;
    float f1 = this.f;
    float f2 = this.g;
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ca localca = (ca)((Iterator)localObject).next();
      this.d[localca.a()][localca.b()] = 1;
    }
    int i3 = getPaddingTop();
    int i4 = getPaddingLeft();
    int i1 = 0;
    while (i1 < 3)
    {
      float f3 = i3;
      float f4 = i1;
      int i2 = 0;
      if (i2 < 3)
      {
        int i5 = (int)(i4 + i2 * f1);
        int i6 = (int)(f3 + f4 * f2);
        if (arrayOfBoolean[i1][i2] == 0) {
          localObject = this.h;
        }
        for (;;)
        {
          int i8 = this.l;
          int i7 = this.m;
          float f5 = this.f;
          float f6 = this.g;
          i8 = (int)((f5 - i8) / 2.0F);
          i7 = (int)((f6 - i7) / 2.0F);
          paramCanvas.drawBitmap((Bitmap)localObject, i5 + i8, i6 + i7, this.c);
          i2 += 1;
          break;
          if (this.b != 3)
          {
            if (this.e == LockPatternView.DisplayMode.Wrong) {
              localObject = this.k;
            } else {
              localObject = this.i;
            }
          }
          else
          {
            if (this.b != 3) {
              break label304;
            }
            localObject = this.j;
          }
        }
        label304:
        throw new IllegalStateException("unknown display mode " + this.e);
      }
      i1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
    setMeasuredDimension(paramInt1, paramInt1);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f = ((paramInt1 - getPaddingLeft() - getPaddingRight()) / 3.0F);
    this.g = ((paramInt2 - getPaddingTop() - getPaddingBottom()) / 3.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.LockPatternSmallView
 * JD-Core Version:    0.7.0.1
 */