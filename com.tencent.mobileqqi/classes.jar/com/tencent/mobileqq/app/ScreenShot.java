package com.tencent.mobileqq.app;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fku;
import fkv;
import fkw;
import fkx;
import fky;
import mqq.util.NativeUtil;

public class ScreenShot
{
  static final int jdField_a_of_type_Int = -16847;
  public static final String a;
  public final Context a;
  public Bitmap a;
  public Drawable a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public Window a;
  public Button a;
  public final fky a;
  public Bitmap b;
  public Drawable b;
  public Button b;
  public Bitmap c;
  public Button c;
  public Button d;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.al + "/QQ_Screenshot/";
  }
  
  public ScreenShot(Context paramContext, Window paramWindow)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      for (paramWindow = (Activity)this.jdField_a_of_type_AndroidContentContext; paramWindow.getParent() != null; paramWindow = paramWindow.getParent()) {}
    }
    for (this.jdField_a_of_type_AndroidViewWindow = paramWindow.getWindow();; this.jdField_a_of_type_AndroidViewWindow = paramWindow)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130839690);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130839689);
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2130903941, null));
      this.jdField_a_of_type_Fky = new fky(this, this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_Fky, 0);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131234394));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131234395));
      this.d = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131234393));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131234392));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(new fku(this));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new fkv(this));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new fkw(this));
      return;
    }
  }
  
  public static final Uri a()
  {
    String str = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString("LastScreenShotUri", "");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return Uri.parse(str);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.d.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  private boolean a(Bitmap paramBitmap)
  {
    int k = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    int i = ((DisplayMetrics)localObject).widthPixels;
    int m = ((DisplayMetrics)localObject).heightPixels;
    if (((k == i) && (j == m)) || ((k == m) && (j == i)))
    {
      localObject = new int[k];
      paramBitmap.getPixels((int[])localObject, 0, k, 0, j / 2, k, 1);
      i = 0;
      while (i < k)
      {
        if (localObject[i] != -16777216) {
          return true;
        }
        i += 1;
      }
      localObject = new int[j];
      paramBitmap.getPixels((int[])localObject, 0, 1, k / 2, 0, 1, j);
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label151;
        }
        if (localObject[i] != -16777216) {
          break;
        }
        i += 1;
      }
    }
    label151:
    return false;
  }
  
  private void b()
  {
    WindowManager localWindowManager;
    WindowManager.LayoutParams localLayoutParams;
    if (!a())
    {
      localWindowManager = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
      localLayoutParams = new WindowManager.LayoutParams();
      localLayoutParams.type = 2003;
      localLayoutParams.format = 1;
      localLayoutParams.flags |= 0x100;
      this.d.setOnClickListener(new fkx(this));
    }
    try
    {
      localWindowManager.addView(this.jdField_a_of_type_AndroidViewViewGroup, localLayoutParams);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("qqBaseActivity", 2, "", localThrowable);
    }
  }
  
  private void c()
  {
    if (a()) {
      ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    this.jdField_c_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
  }
  
  private boolean c()
  {
    return (!Build.MODEL.contains("Galaxy Nexus")) && (!Build.MODEL.contains("HTC S720")) && (!Build.MODEL.contains("SM-N9006")) && ((!Build.MODEL.contains("ZTE U930")) || (Build.VERSION.SDK_INT != 16)) && ((!Build.MODEL.contains("HTC One X")) || (Build.VERSION.SDK_INT != 16)) && ((!Build.MODEL.contains("M351")) || (!d())) && ((!Build.MODEL.contains("M353")) || (!d())) && ((!Build.MODEL.contains("GT-I9260")) || (Build.VERSION.SDK_INT != 16));
  }
  
  private boolean d()
  {
    return Build.MANUFACTURER.contains("Meizu");
  }
  
  public static native int snapScreen(int paramInt1, int paramInt2);
  
  public void a()
  {
    c();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup.getParent() != null;
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_Fky.k = 0;
    this.jdField_a_of_type_Fky.a.setEmpty();
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    a(false);
    if (c()) {}
    try
    {
      Bitmap localBitmap = NativeUtil.screenshot(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
      this.jdField_c_of_type_AndroidGraphicsBitmap = localBitmap;
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!a(this.jdField_a_of_type_AndroidGraphicsBitmap)))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        this.jdField_c_of_type_AndroidGraphicsBitmap = null;
      }
      if ((!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (this.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "", localThrowable);
        }
      }
      b();
      ReportController.b(null, "CliOper", "", "", "Shake_screenshot", "Shake_screenshot", 0, 0, "", "", "", "");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ScreenShot
 * JD-Core Version:    0.7.0.1
 */