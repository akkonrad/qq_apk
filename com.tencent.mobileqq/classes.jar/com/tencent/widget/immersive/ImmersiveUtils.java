package com.tencent.widget.immersive;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ImmersiveUtils
{
  private static float a;
  public static int a;
  public static String a;
  public static boolean a;
  public static int b;
  public static boolean b;
  public static int c;
  public static volatile boolean c;
  private static int d;
  public static boolean d;
  private static int e;
  
  static
  {
    String str;
    if (!"Success".equals(BaseApplicationImpl.sInjectResult))
    {
      str = "sInjectResult:" + BaseApplicationImpl.sInjectResult;
      try
      {
        throw new IllegalAccessError("ImmersiveUtils escapes!");
      }
      catch (Throwable localThrowable)
      {
        BaseApplicationImpl.sImmersiveUtilsEscapedMsg = str + "\n" + QLog.getStackTraceString(localThrowable);
        QLog.e("DexLoad", 1, "ImmersiveUtils escapes!");
      }
    }
    for (;;)
    {
      jdField_a_of_type_JavaLangString = "ImmersiveUtils";
      jdField_a_of_type_Float = -1.0F;
      jdField_d_of_type_Int = -1;
      e = -1;
      jdField_a_of_type_Int = -1;
      jdField_a_of_type_Boolean = true;
      jdField_b_of_type_Int = 67108864;
      jdField_c_of_type_Int = -1;
      str = Build.MANUFACTURER + "-" + Build.MODEL;
      if (str.equalsIgnoreCase("smartisan-sm705")) {
        jdField_b_of_type_Boolean = true;
      }
      if (str.equalsIgnoreCase("vivo-vivo Y35A")) {
        jdField_b_of_type_Boolean = true;
      }
      jdField_d_of_type_Boolean = true;
      return;
      BaseApplicationImpl.sImmersiveUtilsEscapedMsg = "";
    }
  }
  
  public static float a()
  {
    a();
    return jdField_a_of_type_Float;
  }
  
  public static int a()
  {
    a();
    return jdField_d_of_type_Int;
  }
  
  public static int a(float paramFloat)
  {
    return Math.round(a() * paramFloat);
  }
  
  public static int a(Context paramContext)
  {
    int i = 0;
    float f2 = 1.0F;
    SharedPreferences localSharedPreferences;
    float f1;
    if (jdField_c_of_type_Int == -1)
    {
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
      jdField_c_of_type_Int = localSharedPreferences.getInt("status_bar_height", -1);
      if (jdField_c_of_type_Int == -1)
      {
        Resources localResources = paramContext.getResources();
        int j = localResources.getIdentifier("status_bar_height", "dimen", "android");
        if (j > 0) {
          i = localResources.getDimensionPixelSize(j);
        }
        f1 = FontSettingManager.a.density;
        if (QLog.isColorLevel()) {
          QLog.d("systembar", 2, "getStatusBarHeight org=" + i + ", sys density=" + f1 + ", cur density=" + paramContext.getResources().getDisplayMetrics().density);
        }
        f1 /= paramContext.getResources().getDisplayMetrics().density;
        if (i > 0) {
          break label244;
        }
        if (f1 > 0.0F) {
          break label241;
        }
        f1 = 1.0F;
      }
    }
    label241:
    for (;;)
    {
      i = a(f1 * 25.0F);
      jdField_c_of_type_Int = i;
      localSharedPreferences.edit().putInt("status_bar_height", jdField_c_of_type_Int).apply();
      if (QLog.isColorLevel()) {
        QLog.i("systembar", 2, "height=" + jdField_c_of_type_Int);
      }
      return jdField_c_of_type_Int;
    }
    label244:
    float f3 = i;
    if (f1 <= 0.0F) {
      f1 = f2;
    }
    for (;;)
    {
      i = (int)Math.ceil(f3 * f1 + 0.5F);
      break;
    }
  }
  
  private static void a()
  {
    DisplayMetrics localDisplayMetrics;
    if (jdField_a_of_type_Float == -1.0F)
    {
      localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
      jdField_a_of_type_Float = localDisplayMetrics.density;
      if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels)
      {
        jdField_d_of_type_Int = localDisplayMetrics.widthPixels;
        e = localDisplayMetrics.heightPixels;
      }
    }
    else
    {
      return;
    }
    e = localDisplayMetrics.widthPixels;
    jdField_d_of_type_Int = localDisplayMetrics.heightPixels;
  }
  
  @TargetApi(11)
  public static void a(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView.setAlpha(paramFloat);
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    paramView.startAnimation(localAlphaAnimation);
  }
  
  @TargetApi(14)
  public static void a(View paramView, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      paramView.setFitsSystemWindows(paramBoolean);
      paramView.setPadding(0, a(paramView.getContext()), 0, 0);
    }
  }
  
  public static boolean a()
  {
    return (VersionUtils.i()) && (((jdField_d_of_type_Boolean) && (SystemUtil.b())) || (SystemUtil.d()));
  }
  
  public static boolean a(Window paramWindow)
  {
    boolean bool = true;
    Rect localRect = new Rect();
    paramWindow.getDecorView().getWindowVisibleDisplayFrame(localRect);
    if ((localRect.top <= 0) || (localRect.top > 200))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "invalid status height: " + localRect.top);
      bool = false;
    }
    do
    {
      return bool;
      if ((localRect.top <= 0) || (Math.abs(localRect.top - jdField_c_of_type_Int) <= 1)) {
        break;
      }
      jdField_c_of_type_Int = localRect.top;
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0).edit().putInt("status_bar_height", jdField_c_of_type_Int).apply();
      jdField_c_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.i("systembar", 2, "correct status bar height: " + jdField_c_of_type_Int);
    return true;
    return false;
  }
  
  public static boolean a(Window paramWindow, boolean paramBoolean)
  {
    if (!VersionUtils.i()) {}
    do
    {
      return false;
      if ((jdField_d_of_type_Boolean) && (SystemUtil.b())) {
        return b(paramWindow, paramBoolean);
      }
    } while (!SystemUtil.d());
    return c(paramWindow, paramBoolean);
  }
  
  public static int b()
  {
    a();
    return e;
  }
  
  private static boolean b(Window paramWindow, boolean paramBoolean)
  {
    if ((paramWindow != null) && (jdField_d_of_type_Boolean))
    {
      Object localObject = paramWindow.getClass();
      try
      {
        Class localClass = Class.forName("android.view.MiuiWindowManager$LayoutParams");
        int j = localClass.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(localClass);
        localObject = ((Class)localObject).getMethod("setExtraFlags", new Class[] { Integer.TYPE, Integer.TYPE });
        if (paramBoolean) {}
        for (int i = j;; i = 0)
        {
          ((Method)localObject).invoke(paramWindow, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          return true;
        }
        return false;
      }
      catch (Exception paramWindow)
      {
        jdField_d_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "setStatusBarDarkModeForMIUI: failed");
        }
      }
    }
  }
  
  private static boolean c(Window paramWindow, boolean paramBoolean)
  {
    if (paramWindow != null) {
      try
      {
        WindowManager.LayoutParams localLayoutParams = paramWindow.getAttributes();
        Field localField1 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
        Field localField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
        localField1.setAccessible(true);
        localField2.setAccessible(true);
        int i = localField1.getInt(null);
        int j = localField2.getInt(localLayoutParams);
        if (paramBoolean) {
          i |= j;
        }
        for (;;)
        {
          localField2.setInt(localLayoutParams, i);
          paramWindow.setAttributes(localLayoutParams);
          return true;
          i = (i ^ 0xFFFFFFFF) & j;
        }
        return false;
      }
      catch (Exception paramWindow)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "setStatusBarDarkModeForFlyme: failed");
        }
      }
    }
  }
  
  public static int isSupporImmersive()
  {
    if (jdField_a_of_type_Int != -1) {
      return jdField_a_of_type_Int;
    }
    if (Build.VERSION.SDK_INT < 19)
    {
      jdField_a_of_type_Int = 0;
      return jdField_a_of_type_Int;
    }
    String str1 = Build.MANUFACTURER.toUpperCase();
    String str2 = str1 + "-" + Build.MODEL;
    if ((str1.endsWith("BBK")) || ((str1.endsWith("VIVO")) && (Build.VERSION.SDK_INT < 20)) || (str2.equals("OPPO-3007"))) {}
    for (jdField_a_of_type_Int = 0;; jdField_a_of_type_Int = 1) {
      return jdField_a_of_type_Int;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.immersive.ImmersiveUtils
 * JD-Core Version:    0.7.0.1
 */