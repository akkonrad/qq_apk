import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import com.tencent.av.widget.stageview.OverScroller;

public class kid
{
  private static final float[] jdField_a_of_type_ArrayOfFloat;
  private static final float[] jdField_b_of_type_ArrayOfFloat;
  private static float jdField_d_of_type_Float;
  private static float jdField_e_of_type_Float;
  private double jdField_a_of_type_Double;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private float jdField_c_of_type_Float = ViewConfiguration.getScrollFriction();
  private int jdField_c_of_type_Int;
  private int jdField_d_of_type_Int;
  private int jdField_e_of_type_Int;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
  private int g;
  private int h;
  private int i = 0;
  
  static
  {
    float f2 = 0.0F;
    jdField_e_of_type_Float = (float)(Math.log(0.78D) / Math.log(0.9D));
    jdField_a_of_type_ArrayOfFloat = new float[101];
    jdField_b_of_type_ArrayOfFloat = new float[101];
    int j = 0;
    float f1 = 0.0F;
    if (j < 100)
    {
      float f5 = j / 100.0F;
      float f3 = 1.0F;
      label55:
      float f4 = (f3 - f1) / 2.0F + f1;
      float f6 = 3.0F * f4 * (1.0F - f4);
      float f7 = ((1.0F - f4) * 0.175F + 0.35F * f4) * f6 + f4 * f4 * f4;
      if (Math.abs(f7 - f5) < 1.E-005D)
      {
        jdField_a_of_type_ArrayOfFloat[j] = (f4 * (f4 * f4) + f6 * ((1.0F - f4) * 0.5F + f4));
        f3 = 1.0F;
      }
      for (;;)
      {
        f4 = (f3 - f2) / 2.0F + f2;
        f6 = 3.0F * f4 * (1.0F - f4);
        f7 = ((1.0F - f4) * 0.5F + f4) * f6 + f4 * f4 * f4;
        if (Math.abs(f7 - f5) < 1.E-005D)
        {
          jdField_b_of_type_ArrayOfFloat[j] = (f4 * (f4 * f4) + ((1.0F - f4) * 0.175F + 0.35F * f4) * f6);
          j += 1;
          break;
          if (f7 > f5)
          {
            f3 = f4;
            break label55;
          }
          f1 = f4;
          break label55;
        }
        if (f7 > f5) {
          f3 = f4;
        } else {
          f2 = f4;
        }
      }
    }
    float[] arrayOfFloat = jdField_a_of_type_ArrayOfFloat;
    jdField_b_of_type_ArrayOfFloat[100] = 1.0F;
    arrayOfFloat[100] = 1.0F;
  }
  
  private double a(int paramInt)
  {
    return Math.log(0.35F * Math.abs(paramInt) / (this.jdField_c_of_type_Float * jdField_d_of_type_Float));
  }
  
  private int a(int paramInt)
  {
    return (int)(Math.exp(a(paramInt) / (jdField_e_of_type_Float - 1.0D)) * 1000.0D);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = Math.abs((paramInt3 - paramInt1) / (paramInt2 - paramInt1));
    paramInt1 = (int)(100.0F * f1);
    if (paramInt1 < 100)
    {
      float f2 = paramInt1 / 100.0F;
      float f3 = (paramInt1 + 1) / 100.0F;
      float f4 = jdField_b_of_type_ArrayOfFloat[paramInt1];
      float f5 = jdField_b_of_type_ArrayOfFloat[(paramInt1 + 1)];
      this.jdField_e_of_type_Int = ((int)(((f1 - f2) / (f3 - f2) * (f5 - f4) + f4) * this.jdField_e_of_type_Int));
    }
  }
  
  public static void a(Context paramContext)
  {
    jdField_d_of_type_Float = paramContext.getResources().getDisplayMetrics().density * 160.0F * 386.0878F * 0.84F;
  }
  
  private double b(int paramInt)
  {
    double d1 = a(paramInt);
    double d2 = jdField_e_of_type_Float;
    double d3 = this.jdField_c_of_type_Float * jdField_d_of_type_Float;
    return Math.exp(d1 * (jdField_e_of_type_Float / (d2 - 1.0D))) * d3;
  }
  
  private void b()
  {
    long l = this.jdField_a_of_type_Long;
    l = this.jdField_e_of_type_Int + l;
    int j = (int)(this.jdField_e_of_type_Int / this.jdField_f_of_type_Int * 100.0F);
    float f1 = 0.0F;
    if (j < 100)
    {
      f1 = j / 100.0F;
      float f2 = (j + 1) / 100.0F;
      float f3 = jdField_a_of_type_ArrayOfFloat[j];
      f1 = (jdField_a_of_type_ArrayOfFloat[(j + 1)] - f3) / (f2 - f1);
    }
    this.jdField_a_of_type_Float = (f1 * this.g / this.jdField_f_of_type_Int * 1000.0F);
    this.jdField_b_of_type_Float = ((float)((this.jdField_a_of_type_Float - this.jdField_a_of_type_Double) / (l - this.jdField_b_of_type_Long) * 1000.0D));
    a(this.jdField_c_of_type_Int, this.h, (int)this.jdField_a_of_type_Float, 400);
    this.jdField_a_of_type_Long = l;
    b();
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Boolean = false;
    this.i = 1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.h = (paramInt2 - paramInt1);
    this.jdField_e_of_type_Int = 400;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_c_of_type_Float = paramFloat;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = 0.09606F * paramInt2 / (1.E-005F * paramInt4);
    if (paramInt3 > 0) {}
    for (float f1 = 10.0F;; f1 = -10.0F)
    {
      if (Math.abs(paramInt3) < f2) {
        f1 = paramInt3 * 10.0F / f2;
      }
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_c_of_type_Int = paramInt1;
      this.jdField_d_of_type_Int = paramInt3;
      this.h = paramInt2;
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      this.jdField_e_of_type_Int = paramInt4;
      this.jdField_f_of_type_Float = f1;
      this.i = 3;
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.h = paramInt5;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_a_of_type_Float = paramInt2;
    this.jdField_f_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt1;
    if ((paramInt1 > paramInt4) || (paramInt1 < paramInt3))
    {
      if (paramInt1 > paramInt4) {}
      for (;;)
      {
        b(paramInt1, paramInt4, paramInt2);
        return;
        paramInt4 = paramInt3;
      }
    }
    this.i = 0;
    double d1 = 0.0D;
    if (paramInt2 != 0)
    {
      paramInt5 = a(paramInt2);
      this.jdField_f_of_type_Int = paramInt5;
      this.jdField_e_of_type_Int = paramInt5;
      this.jdField_b_of_type_Float = ((float)(a(paramInt2) * 1000.0D));
      d1 = b(paramInt2);
    }
    this.g = ((int)(d1 * Math.signum(paramInt2)));
    this.jdField_c_of_type_Int = (this.g + paramInt1);
    if (this.jdField_c_of_type_Int < paramInt3)
    {
      a(this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, paramInt3);
      this.jdField_c_of_type_Int = paramInt3;
    }
    do
    {
      for (;;)
      {
        this.jdField_a_of_type_Double = paramInt2;
        this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        return;
        if (this.jdField_c_of_type_Int <= paramInt4) {
          break;
        }
        a(this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, paramInt4);
        this.jdField_c_of_type_Int = paramInt4;
      }
    } while ((this.g == 0) || (paramInt6 <= 0) || (this.jdField_c_of_type_Int % paramInt6 == 0));
    if (paramInt2 > 0)
    {
      paramInt3 = this.jdField_c_of_type_Int / paramInt6 * paramInt6;
      paramInt4 = (this.jdField_c_of_type_Int / paramInt6 + 1) * paramInt6;
      if ((Math.abs(paramInt4 - this.jdField_c_of_type_Int) < Math.abs(this.jdField_c_of_type_Int - paramInt3)) || (paramInt3 < paramInt1)) {
        this.jdField_c_of_type_Int = paramInt4;
      }
    }
    for (;;)
    {
      this.g = (this.jdField_c_of_type_Int - paramInt1);
      break;
      this.jdField_c_of_type_Int = paramInt3;
      continue;
      paramInt3 = this.jdField_c_of_type_Int / paramInt6 * paramInt6;
      paramInt4 = (this.jdField_c_of_type_Int / paramInt6 - 1) * paramInt6;
      if ((Math.abs(paramInt4 - this.jdField_c_of_type_Int) < Math.abs(this.jdField_c_of_type_Int - paramInt3)) || (paramInt3 > paramInt1)) {
        this.jdField_c_of_type_Int = paramInt4;
      } else {
        this.jdField_c_of_type_Int = paramInt3;
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    switch (this.i)
    {
    }
    for (;;)
    {
      b();
      bool1 = true;
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.jdField_e_of_type_Int >= this.jdField_f_of_type_Int);
      b();
    }
  }
  
  public void b(float paramFloat)
  {
    this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int + Math.round((this.jdField_c_of_type_Int - this.jdField_a_of_type_Int) * paramFloat));
  }
  
  public boolean b()
  {
    float f2 = 1.0F;
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    long l2 = l1 - this.jdField_a_of_type_Long;
    if (l2 > this.jdField_e_of_type_Int) {
      return false;
    }
    double d1;
    switch (this.i)
    {
    case 2: 
    default: 
      d1 = 0.0D;
    }
    for (;;)
    {
      int j = this.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = ((int)Math.round(d1) + j);
      return true;
      float f3 = (float)l2 / this.jdField_f_of_type_Int;
      j = (int)(100.0F * f3);
      float f1 = 0.0F;
      if (j < 100)
      {
        f2 = j / 100.0F;
        f1 = (j + 1) / 100.0F;
        float f4 = jdField_a_of_type_ArrayOfFloat[j];
        f1 = (jdField_a_of_type_ArrayOfFloat[(j + 1)] - f4) / (f1 - f2);
        f2 = (f3 - f2) * f1 + f4;
      }
      d1 = f2 * this.g;
      this.jdField_a_of_type_Float = (f1 * this.g / this.jdField_f_of_type_Int * 1000.0F);
      this.jdField_b_of_type_Float = ((float)((this.jdField_a_of_type_Float - this.jdField_a_of_type_Double) / (l1 - this.jdField_b_of_type_Long) * 1000.0D));
      continue;
      d1 = OverScroller.a((float)l2 / this.jdField_e_of_type_Int) * this.h;
      continue;
      f1 = (float)l2 / this.jdField_e_of_type_Int - 1.0F;
      f2 = this.h;
      d1 = (f1 * this.jdField_f_of_type_Float + this.jdField_f_of_type_Float) * (f2 * f1 * f1 * f1 * f1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kid
 * JD-Core Version:    0.7.0.1
 */