package dov.com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.TextView;
import aogh;
import aogj;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr.ThumbGenItem;
import dov.com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import dov.com.tencent.mobileqq.shortvideo.ptvfilter.test.PerformenceDataTag;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mqq.os.MqqHandler;

public class FlowSendTask
  extends AsyncTask
{
  private static AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  static long jdField_d_of_type_Long = 20000L;
  double jdField_a_of_type_Double;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public Activity a;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FlowComponentInterface jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowComponentInterface;
  public RMVideoStateMgr a;
  public String a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean;
  double jdField_b_of_type_Double;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  public boolean d;
  int jdField_e_of_type_Int;
  String jdField_e_of_type_JavaLangString;
  boolean jdField_e_of_type_Boolean;
  int jdField_f_of_type_Int;
  String jdField_f_of_type_JavaLangString;
  boolean jdField_f_of_type_Boolean = false;
  int jdField_g_of_type_Int;
  String jdField_g_of_type_JavaLangString;
  boolean jdField_g_of_type_Boolean;
  int jdField_h_of_type_Int;
  String jdField_h_of_type_JavaLangString;
  boolean jdField_h_of_type_Boolean;
  int jdField_i_of_type_Int;
  String jdField_i_of_type_JavaLangString;
  int j;
  public String j;
  public int k;
  String k;
  int jdField_l_of_type_Int;
  String jdField_l_of_type_JavaLangString;
  int jdField_m_of_type_Int;
  String jdField_m_of_type_JavaLangString;
  int n;
  
  static
  {
    boolean bool = CameraCompatibleList.e(CameraCompatibleList.t);
    if (QLog.isColorLevel()) {
      QLog.d("FlowSendTask", 2, "KEY_IO_RW_VERY_SLOW_MODLE: ioSlow=" + bool);
    }
    if (bool) {
      jdField_d_of_type_Long = 46000L;
    }
  }
  
  public FlowSendTask(Activity paramActivity, RMVideoStateMgr paramRMVideoStateMgr, String paramString1, int paramInt1, String paramString2, float paramFloat, boolean paramBoolean1, double paramDouble1, double paramDouble2, FlowComponentInterface paramFlowComponentInterface, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    this.jdField_j_of_type_Int = 0;
    this.jdField_j_of_type_JavaLangString = "";
    a(paramActivity, paramRMVideoStateMgr, paramString1, paramInt1, paramString2, paramFloat, paramBoolean1, paramDouble1, paramDouble2, paramFlowComponentInterface, paramInt2, paramInt3);
  }
  
  private void a(Activity paramActivity, RMVideoStateMgr paramRMVideoStateMgr, String paramString1, int paramInt1, String paramString2, float paramFloat, boolean paramBoolean, double paramDouble1, double paramDouble2, FlowComponentInterface paramFlowComponentInterface, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = paramRMVideoStateMgr;
    this.jdField_a_of_type_JavaLangString = paramRMVideoStateMgr.jdField_a_of_type_JavaLangString;
    if (this.jdField_c_of_type_Long != 0L)
    {
      this.jdField_a_of_type_Int = ((int)this.jdField_c_of_type_Long);
      this.jdField_b_of_type_Long = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement();
      this.jdField_j_of_type_JavaLangString = ("FlowSendTask_[mSessionId=" + this.jdField_b_of_type_Long + "]");
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_j_of_type_JavaLangString, 2, "FlowSendTask(): structureMethod: totalFrame=" + paramInt3);
      }
      if (paramInt3 > 0) {
        break label803;
      }
      this.jdField_b_of_type_Int = paramRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_j_of_type_JavaLangString, 2, "FlowSendTask(): structureMethod: recordFrames=" + this.jdField_b_of_type_Int);
      }
      label163:
      this.jdField_l_of_type_Int = (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_e_of_type_Int * this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_f_of_type_Int * 3 / 2);
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowComponentInterface = paramFlowComponentInterface;
      this.jdField_f_of_type_Boolean = false;
      this.jdField_j_of_type_Int = paramInt2;
      this.jdField_c_of_type_JavaLangString = paramString1;
      this.jdField_d_of_type_Int = paramInt1;
      this.jdField_d_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_Float = paramFloat;
      this.jdField_d_of_type_Boolean = paramBoolean;
      this.jdField_e_of_type_Boolean = false;
      this.jdField_g_of_type_Int = ((this.jdField_a_of_type_Int + 500) / 1000);
      this.jdField_e_of_type_Int = 320;
      if ((RMVideoStateMgr.jdField_a_of_type_Boolean) && (!paramBoolean)) {
        this.jdField_e_of_type_Int = paramRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_e_of_type_Int;
      }
      if (paramBoolean)
      {
        paramActivity = paramActivity.getIntent();
        this.jdField_h_of_type_Int = paramActivity.getIntExtra("param_entrance", 0);
        this.jdField_b_of_type_Boolean = paramActivity.getBooleanExtra("edit_web", false);
        this.jdField_h_of_type_JavaLangString = paramActivity.getStringExtra("fake_id");
        this.jdField_g_of_type_JavaLangString = paramActivity.getStringExtra("bless_ptv_mp4_path");
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_j_of_type_JavaLangString, 2, "FlowSendTask() constructor : isPTV:" + this.jdField_d_of_type_Boolean + ", mVideoCacheDir:" + this.jdField_a_of_type_JavaLangString + " recordTime=" + this.jdField_a_of_type_Int + " mVideoRecordTime=" + this.jdField_g_of_type_Int + " recordFrames=" + this.jdField_b_of_type_Int);
      }
      this.jdField_f_of_type_Int = ((int)(this.jdField_e_of_type_Int / this.jdField_a_of_type_Float));
      if (this.jdField_f_of_type_Int % 2 > 0) {
        this.jdField_f_of_type_Int -= 1;
      }
      this.jdField_k_of_type_Int = 0;
      if (!VideoEnvironment.d()) {
        break label812;
      }
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new aogh(this));
    }
    for (;;)
    {
      paramActivity = paramRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a();
      if ((paramActivity != null) && (paramActivity.jdField_c_of_type_JavaLangString != null) && (paramActivity.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3))
      {
        this.jdField_e_of_type_Int = paramActivity.jdField_a_of_type_Int;
        this.jdField_f_of_type_Int = paramActivity.jdField_b_of_type_Int;
        this.jdField_e_of_type_JavaLangString = paramActivity.jdField_c_of_type_JavaLangString;
        this.jdField_f_of_type_JavaLangString = paramActivity.jdField_d_of_type_JavaLangString;
        this.jdField_e_of_type_Boolean = true;
      }
      boolean bool = CameraCompatibleList.d(CameraCompatibleList.jdField_c_of_type_JavaLangString);
      if (bool) {
        this.jdField_e_of_type_Boolean = false;
      }
      if ((!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) && (FileUtils.b(this.jdField_i_of_type_JavaLangString))) {
        this.jdField_e_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
      }
      if (bool) {
        this.jdField_e_of_type_JavaLangString = null;
      }
      paramRMVideoStateMgr.e();
      this.jdField_a_of_type_Double = paramDouble1;
      this.jdField_b_of_type_Double = paramDouble2;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_j_of_type_JavaLangString, 2, "FlowSendTask(): isPTV:" + paramBoolean + ", mVideoCacheDir:" + this.jdField_a_of_type_JavaLangString + ",mVideoRecordTime: " + this.jdField_g_of_type_Int + ", recordFrames: " + this.jdField_b_of_type_Int + ",mThumbWidth: " + this.jdField_e_of_type_Int + ", mThumbHeight:" + this.jdField_f_of_type_Int + ", mLatitude:" + this.jdField_a_of_type_Double + ", mLongitude:" + this.jdField_b_of_type_Double + ", mThumbOK:" + this.jdField_e_of_type_Boolean + ", mergeThumbPath:" + this.jdField_i_of_type_JavaLangString + ", saveMode:" + this.jdField_i_of_type_Int);
      }
      return;
      this.jdField_a_of_type_Int = ((int)paramRMVideoStateMgr.jdField_a_of_type_Double);
      break;
      label803:
      this.jdField_b_of_type_Int = paramInt3;
      break label163;
      try
      {
        label812:
        RecordManager.a().a().recordSubmit();
      }
      catch (UnsatisfiedLinkError paramActivity)
      {
        paramActivity.printStackTrace();
        this.jdField_k_of_type_Int = -6;
      }
    }
  }
  
  int a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {}
    File localFile;
    String[] arrayOfString;
    do
    {
      do
      {
        return -3;
        if (this.jdField_a_of_type_Int <= 0) {
          return -9;
        }
        localFile = new File(this.jdField_a_of_type_JavaLangString);
      } while ((!localFile.exists()) || (!localFile.isDirectory()));
      arrayOfString = localFile.list();
    } while (arrayOfString == null);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_j_of_type_JavaLangString, 2, "checkVideoSourceValidate(), sourceDirFile =" + localFile.getAbsolutePath() + ",files = " + Arrays.toString(arrayOfString) + ",filse count = " + localFile.listFiles().length);
    }
    int i5 = arrayOfString.length;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    while (i1 < i5)
    {
      String str = arrayOfString[i1];
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_j_of_type_JavaLangString, 2, "checkVideoSourceValidate(), current file = " + str);
      }
      if (str.endsWith(".af")) {
        i3 = 1;
      }
      int i4 = i2;
      if (str.endsWith(".vf"))
      {
        long l1 = FileUtils.a(localFile.getAbsolutePath() + "/" + str);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_j_of_type_JavaLangString, 2, "checkVideoSourceValidate(), videofilesize = " + l1);
        }
        if (this.jdField_b_of_type_Int >= 10) {
          this.jdField_l_of_type_Int *= 5;
        }
        i4 = i2;
        if (l1 > this.jdField_l_of_type_Int) {
          i4 = 1;
        }
      }
      i1 += 1;
      i2 = i4;
    }
    if (this.jdField_b_of_type_Int <= 0) {
      return -8;
    }
    if (i3 == 0) {
      return -4;
    }
    if (i2 == 0) {
      return -5;
    }
    return 0;
  }
  
  /* Error */
  protected Integer a(java.lang.Void... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 397	android/os/SystemClock:elapsedRealtime	()J
    //   4: putfield 399	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_a_of_type_Long	J
    //   7: aload_0
    //   8: getfield 222	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_k_of_type_Int	I
    //   11: ifeq +11 -> 22
    //   14: aload_0
    //   15: getfield 222	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_k_of_type_Int	I
    //   18: invokestatic 405	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: areturn
    //   22: invokestatic 226	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	()Z
    //   25: ifeq +269 -> 294
    //   28: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +14 -> 45
    //   34: aload_0
    //   35: getfield 94	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   38: iconst_2
    //   39: ldc_w 407
    //   42: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: lconst_0
    //   46: lstore 7
    //   48: aload_0
    //   49: getfield 105	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   52: getfield 410	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   55: astore_1
    //   56: aload_1
    //   57: monitorenter
    //   58: aload_0
    //   59: getfield 105	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   62: getfield 410	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   65: invokevirtual 414	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   68: istore 9
    //   70: lload 7
    //   72: lstore 5
    //   74: iload 9
    //   76: ifne +128 -> 204
    //   79: lload 7
    //   81: lstore_3
    //   82: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +17 -> 102
    //   88: lload 7
    //   90: lstore_3
    //   91: aload_0
    //   92: getfield 94	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   95: iconst_2
    //   96: ldc_w 416
    //   99: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: lload 7
    //   104: lstore_3
    //   105: invokestatic 397	android/os/SystemClock:elapsedRealtime	()J
    //   108: lstore 5
    //   110: lload 7
    //   112: lstore_3
    //   113: aload_0
    //   114: getfield 103	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   117: new 418	aogi
    //   120: dup
    //   121: aload_0
    //   122: invokespecial 419	aogi:<init>	(Ldov/com/tencent/mobileqq/activity/richmedia/FlowSendTask;)V
    //   125: invokevirtual 422	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   128: lload 7
    //   130: lstore_3
    //   131: aload_0
    //   132: getfield 105	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   135: getfield 410	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   138: getstatic 45	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_d_of_type_Long	J
    //   141: invokevirtual 427	java/lang/Object:wait	(J)V
    //   144: lload 7
    //   146: lstore_3
    //   147: invokestatic 397	android/os/SystemClock:elapsedRealtime	()J
    //   150: lload 5
    //   152: lsub
    //   153: lstore 7
    //   155: lload 7
    //   157: lstore 5
    //   159: lload 7
    //   161: lstore_3
    //   162: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq +39 -> 204
    //   168: lload 7
    //   170: lstore_3
    //   171: aload_0
    //   172: getfield 94	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   175: iconst_2
    //   176: new 63	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 429
    //   186: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: lload 7
    //   191: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   194: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: lload 7
    //   202: lstore 5
    //   204: aload_1
    //   205: monitorexit
    //   206: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq +14 -> 223
    //   212: aload_0
    //   213: getfield 94	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   216: iconst_2
    //   217: ldc_w 431
    //   220: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: lload 5
    //   225: getstatic 45	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_d_of_type_Long	J
    //   228: lcmp
    //   229: iflt +65 -> 294
    //   232: bipush 249
    //   234: invokestatic 405	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: areturn
    //   238: astore 10
    //   240: lload_3
    //   241: lstore 5
    //   243: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq -42 -> 204
    //   249: aload_0
    //   250: getfield 94	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   253: iconst_2
    //   254: new 63	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 433
    //   264: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 10
    //   269: invokevirtual 436	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   272: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: lload_3
    //   282: lstore 5
    //   284: goto -80 -> 204
    //   287: astore 10
    //   289: aload_1
    //   290: monitorexit
    //   291: aload 10
    //   293: athrow
    //   294: aload_0
    //   295: invokevirtual 438	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:a	()I
    //   298: istore_2
    //   299: iload_2
    //   300: ifeq +42 -> 342
    //   303: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   306: ifeq +31 -> 337
    //   309: aload_0
    //   310: getfield 94	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   313: iconst_2
    //   314: new 63	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   321: ldc_w 440
    //   324: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: iload_2
    //   328: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   331: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: iload_2
    //   338: invokestatic 405	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   341: areturn
    //   342: aload_0
    //   343: getfield 168	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_Boolean	Z
    //   346: ifne +13 -> 359
    //   349: aload_0
    //   350: getfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   353: invokestatic 282	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   356: ifne +256 -> 612
    //   359: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +14 -> 376
    //   365: aload_0
    //   366: getfield 94	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   369: iconst_2
    //   370: ldc_w 442
    //   373: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   376: aload_0
    //   377: getfield 88	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_Int	I
    //   380: bipush 90
    //   382: if_icmpeq +13 -> 395
    //   385: aload_0
    //   386: getfield 88	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_Int	I
    //   389: sipush 270
    //   392: if_icmpne +21 -> 413
    //   395: aload_0
    //   396: getfield 171	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_Int	I
    //   399: istore_2
    //   400: aload_0
    //   401: aload_0
    //   402: getfield 220	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_f_of_type_Int	I
    //   405: putfield 171	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_Int	I
    //   408: aload_0
    //   409: iload_2
    //   410: putfield 220	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_f_of_type_Int	I
    //   413: aload_0
    //   414: getfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   417: aload_0
    //   418: getfield 290	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_a_of_type_Double	D
    //   421: aload_0
    //   422: getfield 292	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_b_of_type_Double	D
    //   425: invokestatic 447	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;DD)Z
    //   428: ifeq +119 -> 547
    //   431: new 336	java/io/File
    //   434: dup
    //   435: aload_0
    //   436: getfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   439: invokespecial 339	java/io/File:<init>	(Ljava/lang/String;)V
    //   442: astore 10
    //   444: new 449	java/io/FileInputStream
    //   447: dup
    //   448: aload_0
    //   449: getfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   452: invokespecial 450	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   455: astore_1
    //   456: aload_0
    //   457: aload_1
    //   458: aload 10
    //   460: invokevirtual 453	java/io/File:length	()J
    //   463: invokestatic 459	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   466: invokestatic 465	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   469: putfield 271	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   472: aload_1
    //   473: ifnull +7 -> 480
    //   476: aload_1
    //   477: invokevirtual 468	java/io/FileInputStream:close	()V
    //   480: aload_0
    //   481: getfield 271	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   484: invokestatic 282	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   487: ifeq +33 -> 520
    //   490: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   493: ifeq +14 -> 507
    //   496: aload_0
    //   497: getfield 94	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   500: iconst_2
    //   501: ldc_w 470
    //   504: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   507: iconst_m1
    //   508: invokestatic 405	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   511: areturn
    //   512: astore_1
    //   513: aload_1
    //   514: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   517: goto -37 -> 480
    //   520: aload_0
    //   521: getfield 271	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   524: ldc_w 475
    //   527: invokestatic 480	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   530: astore_1
    //   531: aload_0
    //   532: getfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   535: aload_1
    //   536: invokestatic 483	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   539: ifeq +13 -> 552
    //   542: aload_0
    //   543: aload_1
    //   544: putfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   547: iconst_0
    //   548: invokestatic 405	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   551: areturn
    //   552: aload_1
    //   553: invokestatic 286	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   556: ifne -9 -> 547
    //   559: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   562: ifeq +44 -> 606
    //   565: aload_0
    //   566: getfield 94	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   569: iconst_2
    //   570: new 63	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   577: ldc_w 485
    //   580: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: aload_0
    //   584: getfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   587: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: ldc_w 487
    //   593: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload_1
    //   597: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   606: bipush 254
    //   608: invokestatic 405	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   611: areturn
    //   612: aload_0
    //   613: aload_0
    //   614: getfield 110	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   617: aload_0
    //   618: getfield 171	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_Int	I
    //   621: aload_0
    //   622: getfield 220	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_f_of_type_Int	I
    //   625: aload_0
    //   626: getfield 88	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_Int	I
    //   629: getstatic 493	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   632: invokestatic 498	dov/com/tencent/mobileqq/shortvideo/cover/RecordThumbnailUtils:b	(Ljava/lang/String;IIILandroid/graphics/Bitmap$Config;)Ljava/lang/String;
    //   635: putfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   638: aload_0
    //   639: getfield 88	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_Int	I
    //   642: bipush 90
    //   644: if_icmpeq +13 -> 657
    //   647: aload_0
    //   648: getfield 88	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_Int	I
    //   651: sipush 270
    //   654: if_icmpne +21 -> 675
    //   657: aload_0
    //   658: getfield 171	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_Int	I
    //   661: istore_2
    //   662: aload_0
    //   663: aload_0
    //   664: getfield 220	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_f_of_type_Int	I
    //   667: putfield 171	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_Int	I
    //   670: aload_0
    //   671: iload_2
    //   672: putfield 220	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_f_of_type_Int	I
    //   675: aload_0
    //   676: getfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   679: invokestatic 282	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   682: ifeq +26 -> 708
    //   685: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   688: ifeq +14 -> 702
    //   691: aload_0
    //   692: getfield 94	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   695: iconst_2
    //   696: ldc_w 500
    //   699: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   702: bipush 254
    //   704: invokestatic 405	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   707: areturn
    //   708: aload_0
    //   709: getfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   712: aload_0
    //   713: getfield 290	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_a_of_type_Double	D
    //   716: aload_0
    //   717: getfield 292	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_b_of_type_Double	D
    //   720: invokestatic 447	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;DD)Z
    //   723: pop
    //   724: new 336	java/io/File
    //   727: dup
    //   728: aload_0
    //   729: getfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   732: invokespecial 339	java/io/File:<init>	(Ljava/lang/String;)V
    //   735: astore 11
    //   737: aload 11
    //   739: invokevirtual 342	java/io/File:exists	()Z
    //   742: ifeq +473 -> 1215
    //   745: new 449	java/io/FileInputStream
    //   748: dup
    //   749: aload_0
    //   750: getfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   753: invokespecial 450	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   756: astore 10
    //   758: aload 10
    //   760: astore_1
    //   761: aload_0
    //   762: aload 10
    //   764: aload 11
    //   766: invokevirtual 453	java/io/File:length	()J
    //   769: invokestatic 459	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   772: invokestatic 465	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   775: putfield 271	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   778: aload 10
    //   780: ifnull +8 -> 788
    //   783: aload 10
    //   785: invokevirtual 468	java/io/FileInputStream:close	()V
    //   788: aload_0
    //   789: getfield 271	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   792: invokestatic 282	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   795: ifeq +33 -> 828
    //   798: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   801: ifeq +14 -> 815
    //   804: aload_0
    //   805: getfield 94	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   808: iconst_2
    //   809: ldc_w 470
    //   812: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   815: iconst_m1
    //   816: invokestatic 405	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   819: areturn
    //   820: astore_1
    //   821: aload_1
    //   822: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   825: goto -37 -> 788
    //   828: aload_0
    //   829: getfield 271	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   832: ldc_w 475
    //   835: invokestatic 480	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   838: astore_1
    //   839: aload_0
    //   840: getfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   843: aload_1
    //   844: invokestatic 483	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   847: ifeq +13 -> 860
    //   850: aload_0
    //   851: aload_1
    //   852: putfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   855: iconst_0
    //   856: invokestatic 405	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   859: areturn
    //   860: aload_1
    //   861: invokestatic 286	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   864: ifne -9 -> 855
    //   867: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   870: ifeq +44 -> 914
    //   873: aload_0
    //   874: getfield 94	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   877: iconst_2
    //   878: new 63	java/lang/StringBuilder
    //   881: dup
    //   882: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   885: ldc_w 485
    //   888: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: aload_0
    //   892: getfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   895: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: ldc_w 487
    //   901: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: aload_1
    //   905: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   911: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   914: bipush 254
    //   916: invokestatic 405	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   919: areturn
    //   920: astore 11
    //   922: aconst_null
    //   923: astore 10
    //   925: aload 10
    //   927: astore_1
    //   928: aload 11
    //   930: invokevirtual 501	java/io/FileNotFoundException:printStackTrace	()V
    //   933: aload 10
    //   935: ifnull +8 -> 943
    //   938: aload 10
    //   940: invokevirtual 468	java/io/FileInputStream:close	()V
    //   943: aload_0
    //   944: getfield 271	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   947: invokestatic 282	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   950: ifeq +33 -> 983
    //   953: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   956: ifeq +14 -> 970
    //   959: aload_0
    //   960: getfield 94	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   963: iconst_2
    //   964: ldc_w 470
    //   967: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   970: iconst_m1
    //   971: invokestatic 405	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   974: areturn
    //   975: astore_1
    //   976: aload_1
    //   977: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   980: goto -37 -> 943
    //   983: aload_0
    //   984: getfield 271	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   987: ldc_w 475
    //   990: invokestatic 480	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   993: astore_1
    //   994: aload_0
    //   995: getfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   998: aload_1
    //   999: invokestatic 483	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1002: ifeq +11 -> 1013
    //   1005: aload_0
    //   1006: aload_1
    //   1007: putfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1010: goto -155 -> 855
    //   1013: aload_1
    //   1014: invokestatic 286	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   1017: ifne -162 -> 855
    //   1020: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1023: ifeq +44 -> 1067
    //   1026: aload_0
    //   1027: getfield 94	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   1030: iconst_2
    //   1031: new 63	java/lang/StringBuilder
    //   1034: dup
    //   1035: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1038: ldc_w 485
    //   1041: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: aload_0
    //   1045: getfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1048: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: ldc_w 487
    //   1054: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: aload_1
    //   1058: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1064: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1067: bipush 254
    //   1069: invokestatic 405	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1072: areturn
    //   1073: astore 10
    //   1075: aconst_null
    //   1076: astore_1
    //   1077: aload_1
    //   1078: ifnull +7 -> 1085
    //   1081: aload_1
    //   1082: invokevirtual 468	java/io/FileInputStream:close	()V
    //   1085: aload_0
    //   1086: getfield 271	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1089: invokestatic 282	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1092: ifeq +33 -> 1125
    //   1095: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1098: ifeq +14 -> 1112
    //   1101: aload_0
    //   1102: getfield 94	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   1105: iconst_2
    //   1106: ldc_w 470
    //   1109: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1112: iconst_m1
    //   1113: invokestatic 405	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1116: areturn
    //   1117: astore_1
    //   1118: aload_1
    //   1119: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   1122: goto -37 -> 1085
    //   1125: aload_0
    //   1126: getfield 271	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1129: ldc_w 475
    //   1132: invokestatic 480	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1135: astore_1
    //   1136: aload_0
    //   1137: getfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1140: aload_1
    //   1141: invokestatic 483	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1144: ifeq +11 -> 1155
    //   1147: aload_0
    //   1148: aload_1
    //   1149: putfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1152: aload 10
    //   1154: athrow
    //   1155: aload_1
    //   1156: invokestatic 286	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   1159: ifne -7 -> 1152
    //   1162: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1165: ifeq +44 -> 1209
    //   1168: aload_0
    //   1169: getfield 94	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   1172: iconst_2
    //   1173: new 63	java/lang/StringBuilder
    //   1176: dup
    //   1177: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1180: ldc_w 485
    //   1183: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: aload_0
    //   1187: getfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1190: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: ldc_w 487
    //   1196: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: aload_1
    //   1200: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1206: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1209: bipush 254
    //   1211: invokestatic 405	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1214: areturn
    //   1215: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1218: ifeq +34 -> 1252
    //   1221: aload_0
    //   1222: getfield 94	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   1225: iconst_2
    //   1226: new 63	java/lang/StringBuilder
    //   1229: dup
    //   1230: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1233: ldc_w 503
    //   1236: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: aload_0
    //   1240: getfield 268	dov/com/tencent/mobileqq/activity/richmedia/FlowSendTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1243: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1249: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1252: bipush 254
    //   1254: invokestatic 405	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1257: areturn
    //   1258: astore 10
    //   1260: goto -183 -> 1077
    //   1263: astore 11
    //   1265: goto -340 -> 925
    //   1268: astore_1
    //   1269: aconst_null
    //   1270: astore_1
    //   1271: goto -799 -> 472
    //   1274: astore 10
    //   1276: goto -804 -> 472
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1279	0	this	FlowSendTask
    //   0	1279	1	paramVarArgs	java.lang.Void[]
    //   298	374	2	i1	int
    //   81	201	3	l1	long
    //   72	211	5	l2	long
    //   46	155	7	l3	long
    //   68	7	9	bool	boolean
    //   238	30	10	localInterruptedException	java.lang.InterruptedException
    //   287	5	10	localObject1	java.lang.Object
    //   442	497	10	localObject2	java.lang.Object
    //   1073	80	10	localObject3	java.lang.Object
    //   1258	1	10	localObject4	java.lang.Object
    //   1274	1	10	localFileNotFoundException1	java.io.FileNotFoundException
    //   735	30	11	localFile	File
    //   920	9	11	localFileNotFoundException2	java.io.FileNotFoundException
    //   1263	1	11	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   82	88	238	java/lang/InterruptedException
    //   91	102	238	java/lang/InterruptedException
    //   105	110	238	java/lang/InterruptedException
    //   113	128	238	java/lang/InterruptedException
    //   131	144	238	java/lang/InterruptedException
    //   147	155	238	java/lang/InterruptedException
    //   162	168	238	java/lang/InterruptedException
    //   171	200	238	java/lang/InterruptedException
    //   58	70	287	finally
    //   82	88	287	finally
    //   91	102	287	finally
    //   105	110	287	finally
    //   113	128	287	finally
    //   131	144	287	finally
    //   147	155	287	finally
    //   162	168	287	finally
    //   171	200	287	finally
    //   204	206	287	finally
    //   243	281	287	finally
    //   289	291	287	finally
    //   476	480	512	java/io/IOException
    //   783	788	820	java/io/IOException
    //   745	758	920	java/io/FileNotFoundException
    //   938	943	975	java/io/IOException
    //   745	758	1073	finally
    //   1081	1085	1117	java/io/IOException
    //   761	778	1258	finally
    //   928	933	1258	finally
    //   761	778	1263	java/io/FileNotFoundException
    //   444	456	1268	java/io/FileNotFoundException
    //   456	472	1274	java/io/FileNotFoundException
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e(this.jdField_j_of_type_JavaLangString, 2, "cancleProgressDailog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e(this.jdField_j_of_type_JavaLangString, 2, "showProgressDialog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        a();
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131624516);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130969180);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131363399));
      }
      return;
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_j_of_type_JavaLangString, 2, "showProgressDialog", paramContext);
      }
    }
  }
  
  void a(Intent paramIntent)
  {
    paramIntent.putExtra("file_video_source_dir", this.jdField_a_of_type_JavaLangString);
    paramIntent.putExtra("thumbfile_send_path", this.jdField_e_of_type_JavaLangString);
    paramIntent.putExtra("thumbfile_send_width", this.jdField_e_of_type_Int);
    paramIntent.putExtra("thumbfile_send_height", this.jdField_f_of_type_Int);
    paramIntent.putExtra("thumbfile_md5", this.jdField_f_of_type_JavaLangString);
    paramIntent.putExtra("file_send_duration", this.jdField_g_of_type_Int);
    paramIntent.putExtra("sv_encode_max_bitrate", CodecParam.r);
    paramIntent.putExtra("sv_encode_min_bitrate", CodecParam.s);
    paramIntent.putExtra("sv_encode_qmax", CodecParam.t);
    paramIntent.putExtra("sv_encode_qmin", CodecParam.u);
    paramIntent.putExtra("sv_encode_qmaxdiff", CodecParam.v);
    paramIntent.putExtra("sv_encode_ref_frame", CodecParam.w);
    paramIntent.putExtra("sv_encode_smooth", CodecParam.x);
    paramIntent.putExtra("sv_total_frame_count", this.jdField_b_of_type_Int);
    paramIntent.putExtra("sv_total_record_time", this.jdField_a_of_type_Int);
    paramIntent.putExtra("sv_encode_totaltime_adjust", CodecParam.E);
    paramIntent.putExtra("sv_encode_timestamp_fix", CodecParam.F);
    paramIntent.putExtra("sv_encode_bless_audio_time_low", CodecParam.G);
    paramIntent.putExtra("sv_encode_bless_audio_time_high", CodecParam.H);
    paramIntent.putExtra("sv_encode_bless_audio_time_ratio", CodecParam.I);
    paramIntent.putExtra("sv_encode_baseline_mp4", false);
    paramIntent.putExtra("video_mood_content", this.jdField_b_of_type_JavaLangString);
    paramIntent.putExtra("video_mood_priv", this.jdField_c_of_type_Int);
    paramIntent.putExtra("video_mood_privUinList", this.jdField_a_of_type_JavaUtilArrayList);
    paramIntent.putExtra("enable_edit_video", this.jdField_a_of_type_Boolean);
    paramIntent.putExtra("video_topic_id", this.jdField_k_of_type_JavaLangString);
    paramIntent.putExtra("video_topic_sync_qzone", this.jdField_g_of_type_Boolean);
    paramIntent.putExtra("video_new_fake_vid", this.jdField_m_of_type_JavaLangString);
    paramIntent.putExtra("video_is_generate_gif", this.jdField_h_of_type_Boolean);
    paramIntent.putExtra("video_sync_to_story", this.jdField_c_of_type_Boolean);
    paramIntent.putExtra("extra_key_font_id", this.jdField_m_of_type_Int);
    paramIntent.putExtra("extra_key_font_format_type", this.n);
    paramIntent.putExtra("extra_key_font_url", this.jdField_l_of_type_JavaLangString);
    PerformenceDataTag.a("sv_filter_mp4_fps", this.jdField_b_of_type_Int * 1000 / this.jdField_a_of_type_Int);
    String str = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("forward_source_to_qzone");
    if (!TextUtils.isEmpty(str)) {
      paramIntent.putExtra("forward_source_to_qzone", str);
    }
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    a();
    boolean bool = this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("forward_source_from_shoot_quick", false);
    if (paramInteger.intValue() == 0)
    {
      if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowComponentInterface == null) {}
      for (paramInteger = "";; paramInteger = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowComponentInterface.a())
      {
        if ((VideoEnvironment.d()) && (!"From_HealthBusiness".equals(paramInteger)) && (!bool) && (((this.jdField_a_of_type_AndroidAppActivity instanceof FlowCameraActivity2)) || (((this.jdField_a_of_type_AndroidAppActivity instanceof QIMCameraCaptureActivity)) && (!this.jdField_d_of_type_Boolean))))
        {
          this.jdField_a_of_type_AndroidAppActivity.setResult(1001);
          this.jdField_a_of_type_AndroidAppActivity.finish();
        }
        paramInteger = new Intent();
        a(paramInteger);
        if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowComponentInterface == null) {
          break;
        }
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowComponentInterface.a(this.jdField_a_of_type_AndroidAppActivity, paramInteger);
        return;
      }
      paramInteger.putExtra("uin", this.jdField_c_of_type_JavaLangString);
      paramInteger.putExtra("uintype", this.jdField_d_of_type_Int);
      paramInteger.putExtra("troop_uin", this.jdField_d_of_type_JavaLangString);
      if (!this.jdField_d_of_type_Boolean) {
        break label517;
      }
    }
    label517:
    for (int i1 = 3;; i1 = 2)
    {
      paramInteger.putExtra("file_send_business_type", i1);
      paramInteger.putExtra("ab_test_send_btn_click_time", this.jdField_a_of_type_AndroidAppActivity.getIntent().getLongExtra("ab_test_send_btn_click_time", 0L));
      paramInteger.putExtra("ab_test_generate_thumb_cost_time", SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_j_of_type_JavaLangString, 2, "onPostExecute(), SendVideoTask is to start  SendVideoActivity,mVideoCacheDir = " + this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("fake_id");
      if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.equals(MessageForBlessPTV.BLESS_REQ_UIN))) {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "群发祝福下架", 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131558448));
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidAppActivity = null;
        if (!this.jdField_f_of_type_Boolean) {
          break;
        }
        FileUtils.a(this.jdField_a_of_type_JavaLangString);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.jdField_j_of_type_JavaLangString, 2, "onPostExecute() delete cache...");
        return;
        paramInteger.setClass(this.jdField_a_of_type_AndroidAppActivity, SendVideoActivity.class);
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramInteger);
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "系统处理超时,短视频发送失败", 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131558448));
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_j_of_type_JavaLangString, 2, "onPostExecute(), SendVideoTask error = " + paramInteger);
      }
      if (!VideoEnvironment.d()) {
        break;
      }
      if ((!this.jdField_d_of_type_Boolean) && ((this.jdField_a_of_type_AndroidAppActivity instanceof FlowCameraActivity2)) && (!bool))
      {
        ThreadManager.getSubThreadHandler().postDelayed(new aogj(this), 1000L);
        return;
      }
      this.jdField_a_of_type_AndroidAppActivity = null;
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.FlowSendTask
 * JD-Core Version:    0.7.0.1
 */