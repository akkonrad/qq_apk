package com.tencent.av.gaudio;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import jif;
import jig;
import jih;
import mqq.app.BaseActivity;

public abstract class BaseGaInvite
  extends BaseActivity
{
  public int a;
  public long a;
  public ImageView a;
  public TextView a;
  public VideoController a;
  public VideoAppInterface a;
  BaseGaInvite.GetGaFaceRunnable.OnGetSink jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable$OnGetSink = new jif(this);
  BaseGaInvite.GetGaFaceRunnable jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = null;
  public String a;
  Timer jdField_a_of_type_JavaUtilTimer = null;
  public jig a;
  public long[] a;
  public int b;
  public long b;
  public TextView b;
  public final String b;
  
  public BaseGaInvite()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfLong = null;
    this.jdField_a_of_type_Jig = new jig(this);
    this.jdField_b_of_type_JavaLangString = (getClass().getSimpleName() + "_" + AudioHelper.a());
  }
  
  public static int a(int paramInt)
  {
    int i = 1000;
    if (paramInt == 2) {
      i = 1004;
    }
    while (paramInt != 1) {
      return i;
    }
    return 1000;
  }
  
  public static Intent a(Intent paramIntent, String paramString)
  {
    return paramIntent.putExtra("_from", paramString);
  }
  
  public static String a(Intent paramIntent)
  {
    return paramIntent.getStringExtra("_from");
  }
  
  public static String a(VideoAppInterface paramVideoAppInterface, TextView paramTextView, int paramInt1, int paramInt2, String paramString, long[] paramArrayOfLong)
  {
    return a(paramVideoAppInterface, paramTextView, paramVideoAppInterface.getDisplayName(paramInt1, paramString, null), paramInt2, paramString, paramArrayOfLong);
  }
  
  public static String a(VideoAppInterface paramVideoAppInterface, TextView paramTextView, String paramString1, int paramInt, String paramString2, long[] paramArrayOfLong)
  {
    String str = paramString1;
    if (paramTextView != null)
    {
      float f = paramVideoAppInterface.getApp().getResources().getDimensionPixelSize(2131559831);
      str = UITools.a(paramVideoAppInterface.getApp(), paramString1, paramTextView, f);
    }
    paramTextView = paramVideoAppInterface.getApp().getString(2131428963);
    int i = paramVideoAppInterface.a(paramInt, paramString2);
    paramInt = i;
    if (i == 0) {
      if (paramArrayOfLong == null) {
        break label109;
      }
    }
    label109:
    for (paramInt = paramArrayOfLong.length + 1;; paramInt = 1)
    {
      paramVideoAppInterface = String.format(paramTextView, new Object[] { Integer.valueOf(paramInt) });
      return str + paramVideoAppInterface;
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_Jig != null)
    {
      this.jdField_a_of_type_Jig.removeMessages(0);
      this.jdField_a_of_type_Jig = null;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer(true);
    jih localjih = new jih(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(localjih, paramInt);
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    int i;
    do
    {
      return;
      AudioHelper.a(this.jdField_b_of_type_JavaLangString, paramIntent.getExtras());
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("uinType", 0);
      this.jdField_a_of_type_Long = paramIntent.getLongExtra("discussId", 0L);
      this.jdField_b_of_type_Long = paramIntent.getLongExtra("friendUin", 0L);
      this.jdField_b_of_type_Int = paramIntent.getIntExtra("relationType", this.jdField_b_of_type_Int);
      i = UITools.b(this.jdField_b_of_type_Int);
    } while (i == this.jdField_a_of_type_Int);
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "processIntent, mUinType与mRelationType不匹配，mRelationType[" + this.jdField_b_of_type_Int + "], uinTpye[" + i + "], mUinType[" + this.jdField_a_of_type_Int + "]");
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable == null)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
        break label94;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838543);
      if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
        break label129;
      }
      String str = Long.toString(this.jdField_b_of_type_Long);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = new BaseGaInvite.GetGaFaceRunnable(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable$OnGetSink);
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable.a(paramString);
      return;
      label94:
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "refreshUI[" + paramString + "], mHeadImage为空");
      break;
      label129:
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "refreshUI[" + paramString + "], mCallersName为空");
    }
  }
  
  boolean a()
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "initEnvParam");
    }
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().g()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().h()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "initEnvParam closeSession");
          }
          this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvVideoController.a().c, 2);
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public abstract void b();
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3000);
  }
  
  public void finish()
  {
    a();
    if (this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable.a();
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = null;
    }
    super.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)getAppRuntime());
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a();
    if (this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable.a();
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.gaudio.BaseGaInvite
 * JD-Core Version:    0.7.0.1
 */