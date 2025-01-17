package com.tencent.mobileqq.profile.PersonalityLabel.tagCloud;

import android.graphics.Paint.FontMetricsInt;
import android.graphics.Point;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View.MeasureSpec;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class Tag
{
  private static final BoringLayout.Metrics jdField_b_of_type_AndroidTextBoringLayout$Metrics = new BoringLayout.Metrics();
  static int f;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = -16777216;
  Point jdField_a_of_type_AndroidGraphicsPoint = new Point(-1, -1);
  BoringLayout.Metrics jdField_a_of_type_AndroidTextBoringLayout$Metrics;
  Layout jdField_a_of_type_AndroidTextLayout;
  TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
  CharSequence jdField_a_of_type_JavaLangCharSequence;
  List jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean;
  float jdField_b_of_type_Float = 1.0F;
  int jdField_b_of_type_Int = 0;
  public Point b;
  List jdField_b_of_type_JavaUtilList;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int = 0;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int;
  boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int = 0;
  boolean jdField_e_of_type_Boolean = false;
  
  public Tag()
  {
    this.d = 0;
    this.jdField_b_of_type_AndroidGraphicsPoint = new Point(0, 0);
  }
  
  private static int a(Layout paramLayout)
  {
    int i = 0;
    int j = 0;
    while (i < paramLayout.getLineCount())
    {
      j = Math.max((int)(paramLayout.getLineMax(i) + 0.5F), j);
      i += 1;
    }
    return j;
  }
  
  private static CharSequence a(CharSequence paramCharSequence)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramCharSequence.length() * 2);
    int i = 0;
    while (i < paramCharSequence.length())
    {
      localStringBuilder.append(paramCharSequence.charAt(i));
      if (i != paramCharSequence.length() - 1) {
        localStringBuilder.append('\n');
      }
      i += 1;
    }
    return localStringBuilder.toString().subSequence(0, localStringBuilder.length());
  }
  
  public static void a(int paramInt)
  {
    f = paramInt;
  }
  
  private int b(int paramInt)
  {
    Object localObject;
    boolean bool;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onMeasureHorizontal text:").append(this.jdField_a_of_type_JavaLangCharSequence).append(" hasImg:");
      if (this.jdField_e_of_type_Int == 2)
      {
        bool = true;
        QLog.i("Tag", 2, bool + " ems:" + this.jdField_c_of_type_Int);
      }
    }
    else
    {
      if (this.jdField_e_of_type_Int != 2) {
        break label307;
      }
      i = this.jdField_c_of_type_Int;
      label84:
      if (!TagUtil.a()) {
        break label842;
      }
    }
    label169:
    label307:
    label321:
    label449:
    label842:
    for (int j = 0;; j = i)
    {
      int m = f;
      int i1 = View.MeasureSpec.getMode(paramInt);
      int n = View.MeasureSpec.getSize(paramInt);
      localObject = jdField_b_of_type_AndroidTextBoringLayout$Metrics;
      localObject = BoringLayout.isBoring(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, null);
      if (localObject != null) {
        this.jdField_a_of_type_AndroidTextBoringLayout$Metrics = ((BoringLayout.Metrics)localObject);
      }
      if ((localObject == null) || (localObject == jdField_b_of_type_AndroidTextBoringLayout$Metrics))
      {
        i = (int)Math.ceil(Layout.getDesiredWidth(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint));
        k = i;
        if (j > 0) {
          k = Math.min(i, a() * j);
        }
        if (i1 != -2147483648)
        {
          i = k;
          if (i1 != 1073741824) {}
        }
        else
        {
          if (this.jdField_e_of_type_Int != 2) {
            break label321;
          }
          i = Math.min(n - m * 3, k);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidTextLayout = a(i, (BoringLayout.Metrics)localObject, i, this.jdField_a_of_type_JavaLangCharSequence, 0.92F);
        if ((j > 0) || (this.jdField_a_of_type_AndroidTextLayout.getLineCount() <= 1)) {
          break label356;
        }
        this.jdField_a_of_type_Float *= 0.8F;
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
        if (QLog.isColorLevel()) {
          QLog.i("Tag", 2, "onMeasureHorizontal maxEms=0 another round");
        }
        return b(paramInt);
        bool = false;
        break;
        i = 0;
        break label84;
        i = ((BoringLayout.Metrics)localObject).width;
        break label169;
        if (this.jdField_e_of_type_Int == 1) {
          i = Math.min(n - m * 2, k);
        } else {
          i = Math.min(n, k);
        }
      }
      label356:
      int k = j;
      if (j == 0)
      {
        k = j;
        if (this.jdField_a_of_type_AndroidTextLayout.getLineCount() > 1)
        {
          if (i % a() <= 0) {
            break label675;
          }
          bool = true;
          j = i / a();
          if (QLog.isColorLevel()) {
            QLog.i("Tag", 2, "onMeasureHorizontal baseEms:" + j + " hasExtra:" + bool);
          }
          if (!bool) {
            break label681;
          }
          j += 1;
          k = j;
        }
      }
      if ((k > 1) && (this.jdField_a_of_type_AndroidTextLayout.getLineCount() > 1))
      {
        k -= 1;
        if (QLog.isDebugVersion()) {
          QLog.i("Tag", 4, "onMeasureHorizontal ems--" + k);
        }
        j = k * a();
        if (j <= i) {}
      }
      else
      {
        j = i;
        if (this.jdField_a_of_type_AndroidTextLayout.getLineCount() >= 1)
        {
          j = a(this.jdField_a_of_type_AndroidTextLayout);
          if (QLog.isColorLevel()) {
            QLog.i("Tag", 2, "onMeasureHorizontal want:" + i + " actual:" + j);
          }
        }
        k = this.jdField_a_of_type_AndroidTextLayout.getHeight() - this.d;
        if (this.jdField_e_of_type_Int != 1) {
          break label724;
        }
        i = j + m * 2;
      }
      for (;;)
      {
        if (i <= n) {
          break label747;
        }
        this.jdField_a_of_type_Float *= 0.8F;
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
        if (QLog.isColorLevel()) {
          QLog.i("Tag", 2, "onMeasureHorizontal width oversize.another round " + this.jdField_a_of_type_JavaLangCharSequence);
        }
        return b(paramInt);
        bool = false;
        break;
        break label446;
        Layout localLayout = a(j, (BoringLayout.Metrics)localObject, j, this.jdField_a_of_type_JavaLangCharSequence, 0.92F);
        if (localLayout.getLineCount() != this.jdField_a_of_type_AndroidTextLayout.getLineCount()) {
          break label517;
        }
        this.jdField_a_of_type_AndroidTextLayout = localLayout;
        break label449;
        label724:
        i = j;
        if (this.jdField_e_of_type_Int == 2) {
          i = j + (m * 3 + k);
        }
      }
      label747:
      if (this.jdField_e_of_type_Int > 0) {
        this.jdField_b_of_type_AndroidGraphicsPoint.set(i, k + m * 2);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Tag", 2, "onMeasureHorizontal w:" + this.jdField_b_of_type_AndroidGraphicsPoint.x + " h:" + this.jdField_b_of_type_AndroidGraphicsPoint.y);
        }
        return this.jdField_b_of_type_AndroidGraphicsPoint.y;
        this.jdField_b_of_type_AndroidGraphicsPoint.set(i, k);
      }
    }
  }
  
  private int c(int paramInt)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i("Tag", 2, "onMeasureVertical text:" + this.jdField_a_of_type_JavaLangCharSequence);
    }
    int i;
    int m;
    int n;
    int i1;
    label79:
    int k;
    if (this.jdField_e_of_type_Int == 2)
    {
      i = this.jdField_c_of_type_Int;
      m = f;
      n = View.MeasureSpec.getMode(paramInt);
      i1 = View.MeasureSpec.getSize(paramInt);
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        if (i > 0) {
          break label316;
        }
        paramInt = 1;
        this.jdField_a_of_type_JavaUtilList = new ArrayList(paramInt);
      }
      if ((i <= 0) || (this.jdField_a_of_type_JavaLangCharSequence.length() <= i)) {
        break label392;
      }
      k = this.jdField_a_of_type_JavaLangCharSequence.length() / i;
      paramInt = k;
      if (this.jdField_a_of_type_JavaLangCharSequence.length() % i > 0) {
        paramInt = k + 1;
      }
      k = this.jdField_a_of_type_JavaLangCharSequence.length() / paramInt;
      i = Math.min(i, this.jdField_a_of_type_JavaLangCharSequence.length() % paramInt + k);
      paramInt = 0;
      label177:
      if (paramInt < this.jdField_a_of_type_JavaLangCharSequence.length())
      {
        if (paramInt + i < this.jdField_a_of_type_JavaLangCharSequence.length()) {
          break label362;
        }
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaLangCharSequence.subSequence(paramInt, this.jdField_a_of_type_JavaLangCharSequence.length()));
      }
    }
    for (;;)
    {
      paramInt = 2147483647;
      if ((n == 1073741824) || (n == -2147483648)) {
        paramInt = i1 - m * 2;
      }
      k = d(paramInt);
      i = 0;
      paramInt = j;
      while (paramInt < this.jdField_b_of_type_JavaUtilList.size())
      {
        i = Math.max(((Layout)this.jdField_b_of_type_JavaUtilList.get(paramInt)).getHeight(), i);
        paramInt += 1;
      }
      i = 0;
      break;
      label316:
      if (this.jdField_a_of_type_JavaLangCharSequence.length() % i > 0)
      {
        paramInt = this.jdField_a_of_type_JavaLangCharSequence.length() / i + 1;
        break label79;
      }
      paramInt = this.jdField_a_of_type_JavaLangCharSequence.length() / i;
      break label79;
      label362:
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaLangCharSequence.subSequence(paramInt, paramInt + i));
      paramInt += i;
      break label177;
      label392:
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaLangCharSequence);
    }
    paramInt = i - this.d;
    if (this.jdField_e_of_type_Int > 0) {
      if (this.jdField_e_of_type_Int == 2)
      {
        paramInt = paramInt + k + m * 3;
        this.jdField_b_of_type_AndroidGraphicsPoint.set(m * 2 + k, paramInt);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Tag", 2, "onMeasureVertical w:" + this.jdField_b_of_type_AndroidGraphicsPoint.x + " h:" + this.jdField_b_of_type_AndroidGraphicsPoint.y);
      }
      return this.jdField_b_of_type_AndroidGraphicsPoint.y;
      paramInt += m * 2;
      break;
      this.jdField_b_of_type_AndroidGraphicsPoint.set(k, paramInt);
    }
  }
  
  private int d(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    ArrayList localArrayList2 = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    int j = 0;
    int i = 0;
    Object localObject;
    while (j < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject = a((CharSequence)this.jdField_a_of_type_JavaUtilList.get(j));
      int k = (int)Math.ceil(Layout.getDesiredWidth((CharSequence)localObject, this.jdField_a_of_type_AndroidTextTextPaint));
      i += k;
      if (((i >= paramInt) && (j < this.jdField_a_of_type_JavaUtilList.size() - 1)) || ((j == this.jdField_a_of_type_JavaUtilList.size() - 1) && (i > paramInt)))
      {
        this.jdField_a_of_type_Float *= 0.5F;
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
        paramInt = d(paramInt);
        return paramInt;
      }
      localArrayList1.add(Integer.valueOf(k));
      localArrayList2.add(localObject);
      j += 1;
    }
    j = 0;
    for (;;)
    {
      paramInt = i;
      if (j >= localArrayList2.size()) {
        break;
      }
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
      }
      localObject = (CharSequence)localArrayList2.get(j);
      localObject = a(((Integer)localArrayList1.get(j)).intValue(), null, ((Integer)localArrayList1.get(j)).intValue(), (CharSequence)localObject, 0.87F);
      this.jdField_b_of_type_JavaUtilList.add(localObject);
      j += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt(null);
  }
  
  public int a(int paramInt)
  {
    int i = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt().top;
    this.d = ((int)((this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt().ascent - i) * 0.5F));
    if (this.jdField_b_of_type_Boolean) {
      return b(paramInt);
    }
    return c(paramInt);
  }
  
  public Point a()
  {
    if (this.jdField_c_of_type_Boolean) {
      return new Point(0, 0);
    }
    return new Point(this.jdField_a_of_type_AndroidGraphicsPoint.x + (int)(this.jdField_b_of_type_AndroidGraphicsPoint.x * 0.5F), this.jdField_a_of_type_AndroidGraphicsPoint.y + (int)(this.jdField_b_of_type_AndroidGraphicsPoint.y * 0.5F));
  }
  
  protected Layout a(int paramInt1, BoringLayout.Metrics paramMetrics, int paramInt2, CharSequence paramCharSequence, float paramFloat)
  {
    Layout.Alignment localAlignment = Layout.Alignment.ALIGN_NORMAL;
    if ((paramCharSequence instanceof Spannable)) {
      return new DynamicLayout(paramCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, paramFloat, 0.0F, false);
    }
    if (paramMetrics == jdField_b_of_type_AndroidTextBoringLayout$Metrics)
    {
      BoringLayout.Metrics localMetrics = BoringLayout.isBoring(paramCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_a_of_type_AndroidTextBoringLayout$Metrics);
      paramMetrics = localMetrics;
      if (localMetrics != null)
      {
        this.jdField_a_of_type_AndroidTextBoringLayout$Metrics = localMetrics;
        paramMetrics = localMetrics;
      }
    }
    for (;;)
    {
      if (paramMetrics != null)
      {
        if (paramMetrics.width <= paramInt1) {
          return BoringLayout.make(paramCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, paramFloat, 0.0F, paramMetrics, false);
        }
        return new StaticLayout(paramCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, paramFloat, 0.0F, false);
      }
      return new StaticLayout(paramCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, paramFloat, 0.0F, false);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPoint.set(-1, -1);
    this.jdField_b_of_type_AndroidGraphicsPoint.set(0, 0);
    this.jdField_a_of_type_AndroidTextLayout = null;
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_b_of_type_Boolean) {}
    while ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
    {
      if ((this.jdField_a_of_type_AndroidTextLayout == null) || (this.jdField_a_of_type_AndroidGraphicsPoint.x < 0) || (this.jdField_a_of_type_AndroidGraphicsPoint.y < 0) || (this.jdField_b_of_type_AndroidGraphicsPoint.x <= 0) || (this.jdField_b_of_type_AndroidGraphicsPoint.y <= 0)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public int b()
  {
    int j = this.jdField_b_of_type_AndroidGraphicsPoint.x;
    int i = this.jdField_b_of_type_AndroidGraphicsPoint.y;
    int k = f;
    if (this.jdField_e_of_type_Int == 2) {
      if (this.jdField_b_of_type_Boolean) {
        i = j - (i - k * 2 + k * 3);
      }
    }
    do
    {
      return i;
      return j - k * 2;
      i = j;
    } while (this.jdField_e_of_type_Int != 1);
    return j - k * 2;
  }
  
  public int c()
  {
    int i = this.jdField_b_of_type_AndroidGraphicsPoint.x;
    int j = this.jdField_b_of_type_AndroidGraphicsPoint.y;
    int k = f;
    if (this.jdField_e_of_type_Int == 2) {
      if (this.jdField_b_of_type_Boolean) {
        i = j - k * 2;
      }
    }
    do
    {
      return i;
      return j - (i - k * 2 + k * 3);
      i = j;
    } while (this.jdField_e_of_type_Int != 1);
    return j - k * 2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("texts:").append(this.jdField_a_of_type_JavaLangCharSequence).append(" w:").append(this.jdField_b_of_type_AndroidGraphicsPoint.x).append(" h:").append(this.jdField_b_of_type_AndroidGraphicsPoint.y);
    localStringBuilder.append(" textSize:").append(this.jdField_a_of_type_Float);
    localStringBuilder.append(" cord.x:").append(this.jdField_a_of_type_AndroidGraphicsPoint.x);
    localStringBuilder.append(" cord.y:").append(this.jdField_a_of_type_AndroidGraphicsPoint.y);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.Tag
 * JD-Core Version:    0.7.0.1
 */