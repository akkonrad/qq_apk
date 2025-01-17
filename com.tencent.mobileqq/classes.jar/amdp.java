import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.os.SystemClock;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.tencent.mobileqq.statistics.QQCatchedExceptionReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableColorStateList;
import java.lang.reflect.Method;
import java.util.Arrays;

public class amdp
{
  private static boolean b;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private Paint.FontMetrics jdField_a_of_type_AndroidGraphicsPaint$FontMetrics;
  final TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
  public String a;
  private Method jdField_a_of_type_JavaLangReflectMethod;
  public boolean a;
  public int b;
  public int c;
  int d;
  
  public amdp(Resources paramResources)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.density = paramResources.getDisplayMetrics().density;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(-7829368);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentResColorStateList.getDefaultColor();
    a();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return 0;
    }
    if (this.c < 0) {
      this.c = ((int)Math.ceil(Layout.getDesiredWidth(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidTextTextPaint)));
    }
    return this.c;
  }
  
  public Paint.FontMetrics a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics == null) {
      this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
    }
    return this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = "";
    this.c = 0;
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(Canvas paramCanvas, int[] paramArrayOfInt, float paramFloat1, float paramFloat2)
  {
    if (paramCanvas != null)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.drawableState = paramArrayOfInt;
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, paramFloat1, paramFloat2, this.jdField_a_of_type_AndroidTextTextPaint);
    }
  }
  
  public boolean a(float paramFloat, Context paramContext)
  {
    if (Math.abs(this.jdField_a_of_type_Float - paramFloat) > 0.01F)
    {
      this.jdField_a_of_type_Float = paramFloat;
      if (paramContext == null) {}
      for (paramContext = Resources.getSystem();; paramContext = paramContext.getResources())
      {
        paramFloat = TypedValue.applyDimension(1, paramFloat, paramContext.getDisplayMetrics());
        if (paramFloat == this.jdField_a_of_type_AndroidTextTextPaint.getTextSize()) {
          break;
        }
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat);
        this.c = -1;
        this.d = -1;
        this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics = null;
        return true;
      }
    }
    return false;
  }
  
  public boolean a(ColorStateList paramColorStateList, int[] paramArrayOfInt)
  {
    if (paramColorStateList == null) {
      return false;
    }
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    return a(paramArrayOfInt);
  }
  
  public boolean a(int[] paramArrayOfInt)
  {
    int i = this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(paramArrayOfInt, 0);
    int j = i;
    if ((i != 0) || (this.jdField_a_of_type_JavaLangReflectMethod == null)) {}
    try
    {
      this.jdField_a_of_type_JavaLangReflectMethod = SkinnableColorStateList.class.getMethod("getColorForState", new Class[] { [I.class, Integer.TYPE });
      try
      {
        j = ((Integer)this.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidContentResColorStateList, new Object[] { paramArrayOfInt, Integer.valueOf(0) })).intValue();
        i = j;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str;
          localException.printStackTrace();
        }
      }
      if (!jdField_b_of_type_Boolean)
      {
        str = "get color from state list fail, state is " + Arrays.toString(paramArrayOfInt) + " but the state list is " + this.jdField_a_of_type_AndroidContentResColorStateList + " curTs: " + SystemClock.uptimeMillis();
        str = str + " colorFromReflect: " + i;
        QLog.e("SingleLineTextView", 1, str);
        QQCatchedExceptionReporter.reportQQCatchedException(new IllegalStateException(str), "GetColorFailCatchedException", str);
        jdField_b_of_type_Boolean = true;
      }
      j = i;
      if ((this.jdField_a_of_type_AndroidContentResColorStateList instanceof SkinnableColorStateList)) {
        ((SkinnableColorStateList)this.jdField_a_of_type_AndroidContentResColorStateList).reset();
      }
      if (j != this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Int = j;
        this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidTextTextPaint.drawableState = paramArrayOfInt;
        return true;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        localNoSuchMethodException.printStackTrace();
      }
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return 0;
    }
    if (this.d < 0) {
      this.d = Math.round(this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt(null));
    }
    return this.d;
  }
  
  public String toString()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      return "";
    }
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amdp
 * JD-Core Version:    0.7.0.1
 */