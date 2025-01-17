package dov.com.tencent.mobileqq.activity.shortvideo;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import aoiw;
import aoix;
import aoiy;
import aoja;
import aojc;
import aojd;
import aoje;
import aojf;
import aojg;
import aojh;
import aoji;
import aojj;
import aojm;
import aojn;
import aojo;
import aojp;
import aojq;
import aojr;
import aojs;
import aojt;
import aoju;
import aojv;
import aojw;
import aojx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.prediction.PredictionReporter;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnNetVideoInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparingListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoReq;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONObject;

@TargetApi(11)
public class ShortVideoPlayActivity
  extends BaseActivity
  implements View.OnClickListener, FileTransferManager.Callback, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnNetVideoInfoListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoPreparedListener, TVK_IMediaPlayer.OnVideoPreparingListener, IVideoViewBase.IVideoViewCallBack
{
  static String[] jdField_b_of_type_ArrayOfJavaLangString;
  static String jdField_l_of_type_JavaLangString = SharedPreUtils.f(BaseApplication.getContext());
  private int A;
  private int B;
  private int C = -1;
  private int D;
  private int E;
  public int a;
  long jdField_a_of_type_Long;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator = null;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Context a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Bundle jdField_a_of_type_AndroidOsBundle;
  public View a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener;
  public SeekBar a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  public MessageForShortVideo a;
  public TVK_IMediaPlayer a;
  TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  public final Runnable a;
  String jdField_a_of_type_JavaLangString;
  public final MqqHandler a;
  boolean jdField_a_of_type_Boolean = false;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  public int b;
  public long b;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  SeekBar jdField_b_of_type_AndroidWidgetSeekBar;
  public TextView b;
  final Runnable jdField_b_of_type_JavaLangRunnable;
  public String b;
  public boolean b;
  int jdField_c_of_type_Int;
  public long c;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  public RelativeLayout c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString = "";
  boolean jdField_c_of_type_Boolean = false;
  public int d;
  long jdField_d_of_type_Long = -1L;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString = "";
  boolean jdField_d_of_type_Boolean = false;
  public int e;
  long jdField_e_of_type_Long = -1L;
  RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  String jdField_e_of_type_JavaLangString;
  boolean jdField_e_of_type_Boolean;
  int jdField_f_of_type_Int;
  public long f;
  private RelativeLayout jdField_f_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  String jdField_f_of_type_JavaLangString;
  public boolean f;
  public int g;
  public long g;
  public String g;
  boolean g;
  public int h;
  private long h;
  public String h;
  public boolean h;
  int jdField_i_of_type_Int = 1;
  private long jdField_i_of_type_Long;
  public String i;
  boolean jdField_i_of_type_Boolean = false;
  private int jdField_j_of_type_Int;
  private long jdField_j_of_type_Long;
  public String j;
  boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private long jdField_k_of_type_Long;
  String jdField_k_of_type_JavaLangString;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private long jdField_l_of_type_Long;
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int;
  private long jdField_m_of_type_Long;
  private String jdField_m_of_type_JavaLangString;
  private boolean jdField_m_of_type_Boolean;
  private int jdField_n_of_type_Int;
  private long jdField_n_of_type_Long;
  private String jdField_n_of_type_JavaLangString;
  private boolean jdField_n_of_type_Boolean;
  private int jdField_o_of_type_Int;
  private long jdField_o_of_type_Long;
  private String jdField_o_of_type_JavaLangString;
  private boolean jdField_o_of_type_Boolean = true;
  private int jdField_p_of_type_Int;
  private long jdField_p_of_type_Long;
  private String jdField_p_of_type_JavaLangString;
  private boolean jdField_p_of_type_Boolean = true;
  private int jdField_q_of_type_Int;
  private long jdField_q_of_type_Long;
  private String jdField_q_of_type_JavaLangString;
  private boolean jdField_q_of_type_Boolean = true;
  private int jdField_r_of_type_Int;
  private long jdField_r_of_type_Long;
  private boolean jdField_r_of_type_Boolean;
  private int jdField_s_of_type_Int;
  private long jdField_s_of_type_Long;
  private boolean jdField_s_of_type_Boolean;
  private int jdField_t_of_type_Int;
  private long jdField_t_of_type_Long;
  private int jdField_u_of_type_Int;
  private long jdField_u_of_type_Long;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  static
  {
    if ((jdField_l_of_type_JavaLangString != null) && (jdField_l_of_type_JavaLangString.length() > 0)) {
      jdField_b_of_type_ArrayOfJavaLangString = jdField_l_of_type_JavaLangString.split("\\|");
    }
  }
  
  public ShortVideoPlayActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_e_of_type_Int = -1;
    this.jdField_j_of_type_JavaLangString = "0";
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.3F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(2500L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new aoiw(this));
    }
    this.jdField_a_of_type_MqqOsMqqHandler = new aojj(this);
    this.jdField_a_of_type_JavaLangRunnable = new aoju(this);
    this.jdField_b_of_type_JavaLangRunnable = new aojv(this);
    this.jdField_j_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aojw(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new aoji(this);
  }
  
  private void A()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.C == -1) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 2003)) {
      break label28;
    }
    label28:
    while (!this.jdField_q_of_type_Boolean) {
      return;
    }
    this.jdField_q_of_type_Boolean = false;
    if (this.jdField_g_of_type_Long == 0L) {}
    for (int i1 = 0;; i1 = (int)(100L * this.jdField_f_of_type_Long / this.jdField_g_of_type_Long))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress < 0) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress = 0;
      }
      int i2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress;
      if (((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1002) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 2002)) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == this.C) && (i1 - i2 < 10)) {
        break;
      }
      if ((this.jdField_c_of_type_Int != 6) && (this.jdField_c_of_type_Int != 17) && (this.jdField_c_of_type_Int != 9))
      {
        i2 = i1;
        if (this.jdField_c_of_type_Int != 20) {}
      }
      else
      {
        if (this.C == 2002) {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.transferedSize = ((int)this.jdField_f_of_type_Long);
        }
        i2 = i1;
        if (this.C == 2003)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.transferedSize = 0;
          i2 = 100;
        }
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 2004) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1004)) && ((this.C == 1002) || (this.C == 2002))) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus = this.C;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.fileType = this.jdField_c_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress = i2;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.mPreUpload) && (this.C == 1003) && (this.jdField_g_of_type_JavaLangString != null)) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5 = this.jdField_g_of_type_JavaLangString;
      }
      if ((this.C == 2003) && (!StringUtil.a(this.jdField_b_of_type_JavaLangString)))
      {
        File localFile = new File(this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.lastModified = localFile.lastModified();
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.serial();
      this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData);
      return;
    }
  }
  
  private int a(String paramString)
  {
    if (paramString == null) {}
    int i1;
    do
    {
      do
      {
        return -1;
        paramString = paramString.trim();
        i1 = paramString.indexOf(' ');
      } while ((i1 < 0) || (i1 + 1 >= paramString.length()));
      paramString = paramString.substring(i1 + 1);
    } while (paramString == null);
    paramString = paramString.trim();
    paramString = paramString.substring(0, paramString.indexOf(' '));
    try
    {
      i1 = Integer.parseInt(paramString);
      return i1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  private ShortVideoDownloadInfo a()
  {
    ShortVideoDownloadInfo localShortVideoDownloadInfo = new ShortVideoDownloadInfo();
    try
    {
      JSONObject localJSONObject = new JSONObject(this.jdField_e_of_type_JavaLangString);
      if (localJSONObject != null)
      {
        localShortVideoDownloadInfo.jdField_a_of_type_Int = localJSONObject.getInt("busi_type");
        localShortVideoDownloadInfo.jdField_a_of_type_JavaLangString = localJSONObject.getString("file_uuid");
        String str = localJSONObject.getString("file_md5");
        localShortVideoDownloadInfo.jdField_e_of_type_JavaLangString = str;
        this.jdField_g_of_type_JavaLangString = str;
        localShortVideoDownloadInfo.jdField_b_of_type_Long = localJSONObject.getInt("file_size");
        localShortVideoDownloadInfo.jdField_b_of_type_Int = this.jdField_e_of_type_Int;
        localShortVideoDownloadInfo.jdField_b_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
        localShortVideoDownloadInfo.jdField_c_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        localShortVideoDownloadInfo.jdField_d_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        localShortVideoDownloadInfo.jdField_e_of_type_Int = 1001;
        this.jdField_c_of_type_Int = 1001;
        localShortVideoDownloadInfo.jdField_h_of_type_JavaLangString = a(localShortVideoDownloadInfo.jdField_e_of_type_JavaLangString);
        return localShortVideoDownloadInfo;
      }
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private String a(long paramLong)
  {
    if (paramLong < 1024L) {
      return paramLong + "B";
    }
    if (paramLong < 1048576L)
    {
      f1 = (float)paramLong / 1024.0F;
      return String.format("%.2f", new Object[] { Float.valueOf(f1) }) + "K";
    }
    float f1 = (float)paramLong / 1048576.0F;
    return String.format("%.2f", new Object[] { Float.valueOf(f1) }) + "M";
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.aJ);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("publicaccount");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(".");
    localStringBuilder.append("mp4");
    return localStringBuilder.toString();
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    int i1 = 0;
    if (paramLong2 != 0L) {
      i1 = (int)(100L * paramLong1 / paramLong2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "updateUploadInfo " + i1 + " " + paramLong1 + " " + paramLong2);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(a(paramLong1) + "/" + a(paramLong2));
    this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i1);
  }
  
  private void a(Dialog paramDialog)
  {
    if ((BaseActivity.mAppForground) && (!isFinishing())) {}
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramDialog) {}
  }
  
  private void a(boolean paramBoolean)
  {
    if (!this.jdField_p_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (!this.jdField_l_of_type_Boolean);
      if (this.B == 0) {
        paramBoolean = true;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null);
    this.jdField_p_of_type_Boolean = false;
    HashMap localHashMap = new HashMap();
    String str = "actShortVideoDownloadVideo";
    if (this.jdField_c_of_type_Int == 6) {
      str = "actShortVideoDownloadVideo";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "reportTag = " + str);
      }
      localHashMap.put("param_uuid", this.jdField_q_of_type_JavaLangString);
      localHashMap.put("param_picSize", String.valueOf(this.jdField_g_of_type_Long));
      localHashMap.put("param_fileMd5", this.jdField_g_of_type_JavaLangString);
      localHashMap.put("param_busiType", this.jdField_b_of_type_Int + "");
      localHashMap.put("param_videoDuration", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime));
      if (!paramBoolean) {
        break;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str, true, this.jdField_q_of_type_Long, this.jdField_g_of_type_Long, localHashMap, "");
      return;
      if ((this.jdField_c_of_type_Int == 9) || (this.jdField_c_of_type_Int == 17))
      {
        str = "actShortVideoDiscussgroupDownloadVideo";
        localHashMap.put("param_grpUin", this.jdField_j_of_type_JavaLangString);
      }
    }
    if (this.B != -9527) {
      localHashMap.remove("param_rspHeader");
    }
    localHashMap.put("param_FailCode", String.valueOf(this.B));
    StatisticCollector.a(BaseApplication.getContext()).a(null, str, false, this.jdField_q_of_type_Long, 0L, localHashMap, "");
  }
  
  private boolean a(Context paramContext)
  {
    File localFile = Environment.getExternalStorageDirectory();
    if ((localFile.exists()) && (localFile.canWrite()))
    {
      i1 = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i1 == 0)) {
        break label72;
      }
    }
    label72:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        break label77;
      }
      QQToast.a(paramContext, 1, 2131434770, 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
      return false;
      i1 = 0;
      break;
    }
    label77:
    return true;
  }
  
  private String b(String paramString)
  {
    if (paramString == null) {}
    do
    {
      int i1;
      do
      {
        return null;
        i1 = paramString.indexOf(':');
      } while ((i1 < 0) || (i1 + 1 >= paramString.length()));
      paramString = paramString.substring(i1 + 1);
    } while (paramString == null);
    return paramString.trim();
  }
  
  private void b(String paramString)
  {
    if (StringUtil.a(paramString)) {}
    for (;;)
    {
      return;
      paramString = paramString.split("\r\n");
      if (paramString != null)
      {
        this.jdField_t_of_type_Int = a(paramString[0]);
        int i1 = 1;
        Object localObject1;
        if (i1 < paramString.length)
        {
          localObject1 = paramString[i1];
          if (((String)localObject1).startsWith("User-ReturnCode")) {
            this.jdField_m_of_type_JavaLangString = b((String)localObject1);
          }
          for (;;)
          {
            i1 += 1;
            break;
            if (((String)localObject1).startsWith("X-RtFlag")) {
              this.jdField_n_of_type_JavaLangString = b((String)localObject1);
            } else if (((String)localObject1).startsWith("Content-Type")) {
              this.jdField_o_of_type_JavaLangString = b((String)localObject1);
            }
          }
        }
        if ((jdField_b_of_type_ArrayOfJavaLangString != null) && (jdField_b_of_type_ArrayOfJavaLangString.length > 0) && (this.jdField_o_of_type_JavaLangString != null) && (this.jdField_o_of_type_JavaLangString.length() > 0))
        {
          if ((jdField_b_of_type_ArrayOfJavaLangString.length == 1) && (jdField_b_of_type_ArrayOfJavaLangString[0] != null) && (jdField_b_of_type_ArrayOfJavaLangString[0].toLowerCase().equals("allin")))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoPlayActivity", 2, "check content all in");
            }
            i1 = 1;
          }
          while (i1 == 0)
          {
            paramString = new StringBuilder();
            localObject1 = jdField_b_of_type_ArrayOfJavaLangString;
            int i2 = localObject1.length;
            i1 = 0;
            while (i1 < i2)
            {
              localObject2 = localObject1[i1];
              if (localObject2 != null)
              {
                paramString.append((String)localObject2);
                paramString.append("|");
              }
              i1 += 1;
              continue;
              paramString = jdField_b_of_type_ArrayOfJavaLangString;
              i2 = paramString.length;
              i1 = 0;
              for (;;)
              {
                if (i1 >= i2) {
                  break label439;
                }
                localObject1 = paramString[i1];
                if ((localObject1 != null) && (this.jdField_o_of_type_JavaLangString.contains((CharSequence)localObject1)))
                {
                  i1 = 1;
                  break;
                }
                i1 += 1;
              }
            }
            localObject1 = "not accept content type: real:" + this.jdField_o_of_type_JavaLangString + ". whiteList_type :" + paramString.toString();
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoPlayActivity", 2, (String)localObject1);
            }
            Object localObject2 = new HashMap();
            ((HashMap)localObject2).put(BaseConstants.RDM_NoChangeFailCode, "");
            ((HashMap)localObject2).put("Content-Type", this.jdField_o_of_type_JavaLangString);
            ((HashMap)localObject2).put("White-List", paramString.toString());
            StatisticCollector.a(BaseApplication.getContext()).a(null, "actSDKDownloadHijacked", true, 0L, 0L, (HashMap)localObject2, "");
            throw new IOException((String)localObject1);
            label439:
            i1 = 0;
          }
        }
      }
    }
  }
  
  private void u()
  {
    if (this.jdField_f_of_type_Boolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((ShortVideoBusiManager.jdField_a_of_type_Boolean) || (System.currentTimeMillis() - ShortVideoBusiManager.jdField_a_of_type_Long < 300000L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "needRemind=false");
        }
        i1 = 0;
      }
      if (i1 != 0)
      {
        Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131437393);
        QQCustomDialog localQQCustomDialog = DialogUtil.b(this.jdField_a_of_type_AndroidContentContext, 230, null, (String)localObject, 2131433012, 2131433011, new aojs(this), new aojt(this));
        localObject = CUOpenCardGuideMng.a(this.jdField_a_of_type_AndroidContentContext, this.app, 1, (String)localObject);
        if ((localObject instanceof SpannableString)) {
          localQQCustomDialog.setMessageWithoutAutoLink((CharSequence)localObject);
        }
        j();
        this.jdField_h_of_type_Boolean = false;
        a(localQQCustomDialog);
      }
      return;
    }
  }
  
  private void v()
  {
    this.jdField_t_of_type_Long = System.currentTimeMillis();
    this.jdField_m_of_type_Boolean = true;
    TVK_SDKMgr.installPlugin(getApplicationContext(), new aoiy(this));
  }
  
  private void w()
  {
    Object localObject;
    if (this.jdField_g_of_type_Boolean)
    {
      localObject = this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      if ((localObject instanceof ShortVideoUploadProcessor))
      {
        localObject = (ShortVideoUploadProcessor)localObject;
        a(((ShortVideoUploadProcessor)localObject).b(), ((ShortVideoUploadProcessor)localObject).a());
      }
      localObject = FileTransferManager.a(this.app);
      if (localObject != null) {
        ((FileTransferManager)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this);
      }
      this.jdField_b_of_type_JavaLangString = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      if (new File(this.jdField_b_of_type_JavaLangString).exists())
      {
        long l1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
        this.jdField_g_of_type_Long = l1;
        this.jdField_f_of_type_Long = l1;
        this.jdField_k_of_type_Int = 10000;
      }
      for (;;)
      {
        a(this.jdField_c_of_type_Long);
        return;
        a("上传状态错误，文件不存在");
      }
    }
    l();
    if ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 2) || (this.jdField_d_of_type_Int == 9501))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if ((this.jdField_b_of_type_Int != 2) || (this.jdField_e_of_type_JavaLangString == null)) {}
    }
    try
    {
      localObject = new JSONObject(this.jdField_e_of_type_JavaLangString);
      this.jdField_c_of_type_Int = 1001;
      this.jdField_b_of_type_JavaLangString = a(((JSONObject)localObject).getString("file_md5"));
      this.jdField_g_of_type_Long = ((JSONObject)localObject).getInt("file_size");
      this.jdField_q_of_type_JavaLangString = ((JSONObject)localObject).getString("file_uuid");
      label277:
      localObject = new File(this.jdField_b_of_type_JavaLangString);
      if ((((File)localObject).exists()) && (((File)localObject).isFile()))
      {
        this.jdField_f_of_type_Long = ((File)localObject).length();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "onCreateVideoSdkView(), #PLAY_CALLER_STRUCT_MSG#, have video size=" + this.jdField_f_of_type_Long + " msg.size=" + this.jdField_g_of_type_Long);
        }
        if (this.jdField_f_of_type_Long < this.jdField_g_of_type_Long) {
          this.jdField_f_of_type_Boolean = true;
        }
        if (this.jdField_f_of_type_Boolean)
        {
          y();
          localObject = FileTransferManager.a(this.app);
          if (localObject != null) {
            ((FileTransferManager)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this);
          }
          this.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress(this.jdField_k_of_type_Int);
        }
      }
      label918:
      label940:
      for (;;)
      {
        this.jdField_l_of_type_Boolean = this.jdField_f_of_type_Boolean;
        if (this.jdField_f_of_type_Boolean) {
          break label942;
        }
        a(this.jdField_c_of_type_Long);
        return;
        this.jdField_f_of_type_Boolean = true;
        break;
        if (this.jdField_b_of_type_Int == 0)
        {
          int i1;
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getBitValue(1) == 0)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getBitValue(0) == 1)
            {
              i1 = 101;
              label492:
              PredictionReporter.a(1000, i1);
              this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.setBitValue(1, (byte)1);
              ThreadManager.getFileThreadHandler().post(new aojc(this));
            }
          }
          else
          {
            this.jdField_b_of_type_JavaLangString = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
            localObject = new File(this.jdField_b_of_type_JavaLangString);
            if (!((File)localObject).exists()) {
              break label918;
            }
            this.jdField_f_of_type_Long = ((File)localObject).length();
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoPlayActivity", 2, "onCreateVideoSdkView(), #PLAY_CALLER_SHORT_VIDEO#, have video size=" + this.jdField_f_of_type_Long + " msg.size=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize + " status=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus);
            }
            this.jdField_g_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
            this.jdField_k_of_type_Int = 10000;
            this.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress(10000);
            this.jdField_e_of_type_Boolean = false;
            if (this.jdField_f_of_type_Long >= this.jdField_g_of_type_Long) {}
          }
          for (this.jdField_f_of_type_Boolean = true;; this.jdField_f_of_type_Boolean = true)
          {
            if (!this.jdField_f_of_type_Boolean) {
              break label940;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoPlayActivity", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, need download, startDownload...");
            }
            if (a(this.jdField_a_of_type_AndroidContentContext))
            {
              localObject = ShortVideoBusiManager.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1);
              if (localObject != null)
              {
                ShortVideoBusiManager.a((ShortVideoReq)localObject, this.app);
                this.jdField_c_of_type_Int = ((ShortVideoReq)localObject).a.jdField_e_of_type_Int;
                a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
              }
            }
            localObject = FileTransferManager.a(this.app);
            if (localObject != null) {
              ((FileTransferManager)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this);
            }
            this.jdField_f_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.transferedSize;
            this.jdField_g_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
            this.jdField_k_of_type_Int = ((int)(10000L * this.jdField_f_of_type_Long / this.jdField_g_of_type_Long));
            this.jdField_j_of_type_Int = 0;
            this.jdField_h_of_type_Long = 0L;
            this.jdField_e_of_type_Boolean = true;
            this.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress(this.jdField_k_of_type_Int);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ShortVideoPlayActivity", 2, "onCreateVideoSdkView() mCacheProgress=" + this.jdField_k_of_type_Int + ",mTransferredSize=" + this.jdField_f_of_type_Long);
            break;
            i1 = 102;
            break label492;
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoPlayActivity", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
            }
          }
        }
      }
      label942:
      p();
      a(4);
      return;
    }
    catch (Exception localException)
    {
      break label277;
    }
  }
  
  private void x()
  {
    if ((VersionUtils.g()) && (!ShortVideoUtils.b()) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setSystemUiVisibility(1284);
    }
  }
  
  private void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "startDownLoadVideoForPubAccount: " + this.jdField_e_of_type_JavaLangString);
    }
    Object localObject = Environment.getExternalStorageDirectory();
    int i1;
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i1 = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i1 == 0)) {
        break label113;
      }
      i1 = 1;
      label74:
      if (i1 != 0) {
        break label118;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131434770, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
    }
    label113:
    label118:
    ShortVideoDownloadInfo localShortVideoDownloadInfo;
    do
    {
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label74;
      localObject = ShortVideoBusiManager.a(2, 0);
      localShortVideoDownloadInfo = a();
      if ((!AppNetConnInfo.isWifiConn()) && (localShortVideoDownloadInfo != null) && (localShortVideoDownloadInfo.jdField_b_of_type_Long > 204800L)) {
        a(DialogUtil.a(this, 230, getString(2131437395), getString(2131437394), new aojd(this), new aoje(this)));
      }
    } while (localShortVideoDownloadInfo == null);
    localShortVideoDownloadInfo.jdField_a_of_type_Boolean = true;
    ((ShortVideoReq)localObject).a = localShortVideoDownloadInfo;
    ShortVideoBusiManager.a((ShortVideoReq)localObject, this.app);
    this.jdField_k_of_type_JavaLangString = localShortVideoDownloadInfo.jdField_h_of_type_JavaLangString;
  }
  
  private void z()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  /* Error */
  public void OnDownloadCallback(String paramString)
  {
    // Byte code:
    //   0: new 349	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 352	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: ldc_w 919
    //   13: invokevirtual 357	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   16: istore_2
    //   17: aload_1
    //   18: ldc_w 921
    //   21: invokevirtual 357	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   24: istore_3
    //   25: iload_3
    //   26: i2l
    //   27: aload_0
    //   28: getfield 231	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_g_of_type_Long	J
    //   31: lcmp
    //   32: ifeq +39 -> 71
    //   35: aload_0
    //   36: iload_3
    //   37: i2l
    //   38: putfield 231	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_g_of_type_Long	J
    //   41: ldc_w 448
    //   44: iconst_2
    //   45: new 388	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 923
    //   55: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 231	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_g_of_type_Long	J
    //   62: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   65: invokevirtual 400	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 458	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: aload_1
    //   72: ldc_w 925
    //   75: invokevirtual 357	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   78: istore 4
    //   80: aload_0
    //   81: aload_1
    //   82: ldc_w 927
    //   85: invokevirtual 357	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   88: i2l
    //   89: putfield 238	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_f_of_type_Long	J
    //   92: aload_1
    //   93: ldc_w 929
    //   96: invokevirtual 357	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   99: istore 5
    //   101: aload_0
    //   102: iload 5
    //   104: putfield 931	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_m_of_type_Int	I
    //   107: iload 5
    //   109: ifle +13 -> 122
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 933	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_n_of_type_Int	I
    //   117: iconst_1
    //   118: iadd
    //   119: putfield 933	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_n_of_type_Int	I
    //   122: aload_1
    //   123: ldc_w 935
    //   126: invokevirtual 357	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   129: istore 6
    //   131: aload_0
    //   132: getfield 937	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_o_of_type_Int	I
    //   135: iload 6
    //   137: if_icmpge +9 -> 146
    //   140: aload_0
    //   141: iload 6
    //   143: putfield 937	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_o_of_type_Int	I
    //   146: aload_0
    //   147: aload_1
    //   148: ldc_w 939
    //   151: invokevirtual 357	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   154: putfield 665	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_l_of_type_Int	I
    //   157: iload_2
    //   158: bipush 7
    //   160: if_icmpeq +8 -> 168
    //   163: iload_2
    //   164: iconst_3
    //   165: if_icmpne +497 -> 662
    //   168: iload_2
    //   169: bipush 7
    //   171: if_icmpne +27 -> 198
    //   174: aload_0
    //   175: iconst_0
    //   176: putfield 152	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_f_of_type_Boolean	Z
    //   179: aload_0
    //   180: aload_0
    //   181: getfield 231	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_g_of_type_Long	J
    //   184: putfield 238	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_f_of_type_Long	J
    //   187: aload_0
    //   188: sipush 2003
    //   191: putfield 166	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:C	I
    //   194: aload_0
    //   195: invokespecial 941	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:A	()V
    //   198: aload_0
    //   199: getfield 943	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_r_of_type_Long	J
    //   202: lconst_0
    //   203: lcmp
    //   204: ifeq +20 -> 224
    //   207: aload_0
    //   208: invokestatic 680	java/lang/System:currentTimeMillis	()J
    //   211: aload_0
    //   212: getfield 943	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_r_of_type_Long	J
    //   215: lsub
    //   216: putfield 539	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_q_of_type_Long	J
    //   219: aload_0
    //   220: lconst_0
    //   221: putfield 943	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_r_of_type_Long	J
    //   224: aload_0
    //   225: getfield 945	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:w	I
    //   228: ifne +14 -> 242
    //   231: aload_0
    //   232: aload_1
    //   233: ldc_w 947
    //   236: invokevirtual 357	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   239: putfield 945	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:w	I
    //   242: aload_0
    //   243: getfield 949	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:x	I
    //   246: ifne +14 -> 260
    //   249: aload_0
    //   250: aload_1
    //   251: ldc_w 951
    //   254: invokevirtual 357	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   257: putfield 949	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:x	I
    //   260: aload_1
    //   261: ldc_w 953
    //   264: invokevirtual 956	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   267: ifeq +21 -> 288
    //   270: aload_0
    //   271: getfield 958	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:y	I
    //   274: ifne +14 -> 288
    //   277: aload_0
    //   278: aload_1
    //   279: ldc_w 953
    //   282: invokevirtual 357	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   285: putfield 958	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:y	I
    //   288: aload_1
    //   289: ldc_w 960
    //   292: invokevirtual 956	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   295: ifeq +21 -> 316
    //   298: aload_0
    //   299: getfield 962	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:z	I
    //   302: ifne +14 -> 316
    //   305: aload_0
    //   306: aload_1
    //   307: ldc_w 960
    //   310: invokevirtual 357	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   313: putfield 962	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:z	I
    //   316: aload_1
    //   317: ldc_w 964
    //   320: invokevirtual 956	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   323: ifeq +21 -> 344
    //   326: aload_0
    //   327: getfield 966	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:A	I
    //   330: ifne +14 -> 344
    //   333: aload_0
    //   334: aload_1
    //   335: ldc_w 964
    //   338: invokevirtual 357	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   341: putfield 966	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:A	I
    //   344: aload_1
    //   345: ldc_w 968
    //   348: invokevirtual 956	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   351: ifeq +21 -> 372
    //   354: aload_0
    //   355: getfield 970	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_p_of_type_JavaLangString	Ljava/lang/String;
    //   358: ifnonnull +14 -> 372
    //   361: aload_0
    //   362: aload_1
    //   363: ldc_w 968
    //   366: invokevirtual 364	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   369: putfield 970	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_p_of_type_JavaLangString	Ljava/lang/String;
    //   372: invokestatic 446	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq +397 -> 772
    //   378: new 388	java/lang/StringBuilder
    //   381: dup
    //   382: ldc_w 972
    //   385: invokespecial 428	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   388: astore_1
    //   389: aload_1
    //   390: ldc_w 974
    //   393: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: iload_2
    //   397: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   400: ldc_w 643
    //   403: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload_1
    //   408: ldc_w 976
    //   411: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: iload_3
    //   415: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   418: ldc_w 643
    //   421: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload_1
    //   426: ldc_w 978
    //   429: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: iload 4
    //   434: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   437: ldc_w 643
    //   440: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload_1
    //   445: ldc_w 980
    //   448: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload_0
    //   452: getfield 238	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_f_of_type_Long	J
    //   455: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   458: ldc_w 643
    //   461: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: aload_1
    //   466: ldc_w 982
    //   469: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: iload 5
    //   474: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   477: ldc_w 643
    //   480: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload_1
    //   485: ldc_w 984
    //   488: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: iload 6
    //   493: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   496: ldc_w 643
    //   499: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload_1
    //   504: ldc_w 986
    //   507: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: aload_0
    //   511: getfield 665	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_l_of_type_Int	I
    //   514: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   517: ldc_w 643
    //   520: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload_1
    //   525: ldc_w 988
    //   528: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: aload_0
    //   532: getfield 945	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:w	I
    //   535: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   538: ldc_w 643
    //   541: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload_1
    //   546: ldc_w 990
    //   549: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: aload_0
    //   553: getfield 949	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:x	I
    //   556: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   559: ldc_w 643
    //   562: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload_1
    //   567: ldc_w 992
    //   570: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: aload_0
    //   574: getfield 958	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:y	I
    //   577: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   580: ldc_w 643
    //   583: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: pop
    //   587: aload_1
    //   588: ldc_w 994
    //   591: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: aload_0
    //   595: getfield 962	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:z	I
    //   598: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   601: ldc_w 643
    //   604: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload_1
    //   609: ldc_w 996
    //   612: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: aload_0
    //   616: getfield 966	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:A	I
    //   619: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   622: ldc_w 643
    //   625: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload_1
    //   630: ldc_w 998
    //   633: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: aload_0
    //   637: getfield 970	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_p_of_type_JavaLangString	Ljava/lang/String;
    //   640: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: ldc_w 643
    //   646: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: ldc_w 448
    //   653: iconst_2
    //   654: aload_1
    //   655: invokevirtual 400	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   658: invokestatic 1000	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   661: return
    //   662: iload_2
    //   663: iconst_1
    //   664: if_icmpne -440 -> 224
    //   667: aload_1
    //   668: ldc_w 1002
    //   671: invokevirtual 956	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   674: ifeq -450 -> 224
    //   677: aload_1
    //   678: ldc_w 1002
    //   681: invokevirtual 364	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   684: astore 7
    //   686: aload_0
    //   687: aload 7
    //   689: invokespecial 1004	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:b	(Ljava/lang/String;)V
    //   692: aload_0
    //   693: getfield 626	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   696: invokestatic 1009	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   699: ifne -475 -> 224
    //   702: aload_0
    //   703: getfield 626	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   706: ldc_w 1011
    //   709: invokevirtual 576	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   712: ifeq -488 -> 224
    //   715: aload_0
    //   716: sipush 5002
    //   719: putfield 166	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:C	I
    //   722: aload_0
    //   723: invokespecial 941	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:A	()V
    //   726: aload_0
    //   727: ldc_w 1013
    //   730: invokevirtual 777	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:a	(Ljava/lang/String;)V
    //   733: goto -509 -> 224
    //   736: astore_1
    //   737: aload_1
    //   738: invokevirtual 1014	org/json/JSONException:printStackTrace	()V
    //   741: return
    //   742: astore 7
    //   744: aload_0
    //   745: sipush 9064
    //   748: putfield 502	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:B	I
    //   751: aload_0
    //   752: sipush 2005
    //   755: putfield 166	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:C	I
    //   758: aload_0
    //   759: invokespecial 941	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:A	()V
    //   762: aload_0
    //   763: ldc_w 1016
    //   766: invokevirtual 777	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:a	(Ljava/lang/String;)V
    //   769: goto -77 -> 692
    //   772: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	773	0	this	ShortVideoPlayActivity
    //   0	773	1	paramString	String
    //   16	649	2	i1	int
    //   24	391	3	i2	int
    //   78	355	4	i3	int
    //   99	374	5	i4	int
    //   129	363	6	i5	int
    //   684	4	7	str	String
    //   742	1	7	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   0	71	736	org/json/JSONException
    //   71	107	736	org/json/JSONException
    //   112	122	736	org/json/JSONException
    //   122	146	736	org/json/JSONException
    //   146	157	736	org/json/JSONException
    //   174	198	736	org/json/JSONException
    //   198	224	736	org/json/JSONException
    //   224	242	736	org/json/JSONException
    //   242	260	736	org/json/JSONException
    //   260	288	736	org/json/JSONException
    //   288	316	736	org/json/JSONException
    //   316	344	736	org/json/JSONException
    //   344	372	736	org/json/JSONException
    //   372	661	736	org/json/JSONException
    //   667	686	736	org/json/JSONException
    //   686	692	736	org/json/JSONException
    //   692	733	736	org/json/JSONException
    //   744	769	736	org/json/JSONException
    //   686	692	742	java/io/IOException
  }
  
  String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "null";
    case 0: 
      return " idle ";
    case 1: 
      return " playing ";
    case 2: 
      return " pause ";
    case 3: 
      return " error ";
    }
    return " buffering ";
  }
  
  public void a()
  {
    int i1 = 1;
    if (!this.jdField_a_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(getApplicationContext(), "N4QejKbz1le475fk++KlIA9kNWH2xNow+G71QpXRu1psQjywa9MBN6kQMJPbznuEpOZWLIO0GU7vxXhzje81pXpZsPVsAmq5X/A8Qyaz6nvyksVQ0Xe60P5RrWFbbyW7GNYRNNbx+LtGEJO15w+yz+bjKUKnL6bB76G7675wHzPPRCaRz7l1GjnOZNOnnUpBURvTdjmxHLNcF44ytr7Hj4AjWfd+RyZq/LgI8nNy32kf8M6o7G/GcfI65N3tE9lufnc0CT8If9CCIBPNpO626AL38jXDrpszN87xdcLzb8PBENbfKhPs4qgXoONpjTpYyn/y9ZMQgh09o2v3GOGe9A==", "");
      this.jdField_a_of_type_Boolean = true;
    }
    if (TVK_SDKMgr.isInstalled(getApplicationContext()))
    {
      b();
      return;
    }
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
    while (i1 != 0)
    {
      v();
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430809), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131558448));
      return;
      i1 = 0;
    }
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 232, null, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430807), new aojx(this), new aoix(this)).show();
  }
  
  void a(int paramInt)
  {
    runOnUiThread(new aojg(this, paramInt));
  }
  
  void a(int paramInt1, int paramInt2)
  {
    this.jdField_i_of_type_Int = 0;
    this.B = 9001;
    String str1 = getString(2131437365);
    Object localObject;
    int i2;
    if ((paramInt1 == 101) && (this.jdField_a_of_type_ArrayOfJavaLangString != null) && (!StringUtil.a(this.jdField_a_of_type_JavaLangString)))
    {
      localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
      i2 = localObject.length;
      i1 = 0;
      while (i1 < i2)
      {
        String str2 = localObject[i1];
        if (!StringUtil.a(str2)) {
          InnerDns.a().a(this.jdField_a_of_type_JavaLangString, InnerDns.a(str2), 1005);
        }
        i1 += 1;
      }
    }
    if (this.jdField_b_of_type_Int == 1)
    {
      p();
      q();
      str1 = getString(2131437385);
      localObject = str1;
      if (paramInt1 == 122) {
        if (paramInt2 != 204)
        {
          localObject = str1;
          if (paramInt2 != 202) {}
        }
        else
        {
          localObject = getString(2131437385);
        }
      }
      a(DialogUtil.a(this, 232, null, (String)localObject, new aojh(this), null));
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "handleError，mPlayCallerType = " + this.jdField_b_of_type_Int);
      }
      this.jdField_d_of_type_Long = -1L;
      this.jdField_e_of_type_Long = -1L;
      return;
    }
    if (this.jdField_b_of_type_Int == 0)
    {
      if (this.jdField_c_of_type_Boolean) {
        break label408;
      }
      i2 = (int)(DeviceInfoUtil.f() / 1024L);
      if (StringUtil.a(this.jdField_b_of_type_JavaLangString)) {
        break label411;
      }
    }
    label408:
    label411:
    for (int i1 = (int)(new File(this.jdField_b_of_type_JavaLangString).length() / 1024L);; i1 = 0)
    {
      localObject = DeviceInfoUtil.e();
      ReportController.b(this.app, "CliOper", "", "", "0X8004674", "0X8004674", 0, 0, "" + i2, "" + i1, (String)localObject, this.jdField_g_of_type_JavaLangString);
      this.jdField_c_of_type_Boolean = true;
      break;
      if (this.jdField_b_of_type_Int == 2)
      {
        a(this.jdField_c_of_type_JavaLangString, 0, 1002, this.jdField_d_of_type_JavaLangString);
        str1 = getString(2131437385);
        break;
      }
      break;
    }
  }
  
  public void a(long paramLong)
  {
    l1 = paramLong;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          l1 = paramLong;
          QLog.d("ShortVideoPlayActivity", 2, "#play#, msec=" + paramLong);
        }
        l1 = paramLong;
        this.jdField_a_of_type_Long = paramLong;
        l1 = paramLong;
        this.jdField_o_of_type_Boolean = true;
        int i1 = 0;
        l1 = paramLong;
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
        {
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(getApplicationContext(), (IVideoViewBase)this.jdField_b_of_type_AndroidViewView);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(this);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(this);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnNetVideoInfoListener(this);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparingListener(this);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(this);
          l1 = paramLong;
          this.jdField_m_of_type_Long = System.currentTimeMillis();
          i1 = 1;
        }
        l1 = paramLong;
        if (this.jdField_k_of_type_Boolean)
        {
          i1 = 1;
          l1 = paramLong;
          this.jdField_r_of_type_Int += 1;
        }
        if (i1 == 0) {
          continue;
        }
        if (paramLong != 0L) {
          continue;
        }
        l1 = paramLong;
        if (this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress() <= 0) {
          continue;
        }
        l1 = paramLong;
        if (this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress() == 100) {
          continue;
        }
        l1 = paramLong;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
          continue;
        }
        l1 = paramLong;
        i1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime * 1000 * this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress() / 100;
        paramLong = i1;
        try
        {
          if ((this.jdField_a_of_type_ArrayOfJavaLangString == null) || (!this.jdField_f_of_type_Boolean)) {
            continue;
          }
          String str;
          if ((this.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
          {
            str = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
            localObject = new TVK_PlayerVideoInfo();
            ((TVK_PlayerVideoInfo)localObject).setConfigMap("file_dir", str);
            ((TVK_PlayerVideoInfo)localObject).setConfigMap("cache_servers_type", "20160518");
            ((TVK_PlayerVideoInfo)localObject).setConfigMap("keep_last_frame", "true");
            HashMap localHashMap = new HashMap();
            localHashMap.put("shouq_bus_type", "bus_type_aio_shortvideo_url");
            ((TVK_PlayerVideoInfo)localObject).setReportInfoMap(localHashMap);
            if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) {
              ((TVK_PlayerVideoInfo)localObject).setConfigMap("duration", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime));
            }
            ((TVK_PlayerVideoInfo)localObject).setVid(this.jdField_g_of_type_JavaLangString);
            ((TVK_PlayerVideoInfo)localObject).setPlayMode("cache_extend_video");
            if (QLog.isColorLevel())
            {
              QLog.d("ShortVideoPlayActivity", 2, "#play#, setVid =" + this.jdField_g_of_type_JavaLangString + " videoPath=" + str);
              QLog.d("ShortVideoPlayActivity", 2, "#play#, url0 =" + this.jdField_a_of_type_ArrayOfJavaLangString[0]);
            }
            this.jdField_r_of_type_Long = System.currentTimeMillis();
            this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ArrayOfJavaLangString, paramLong, 0L, (TVK_PlayerVideoInfo)localObject, null);
            l1 = paramLong;
            this.jdField_k_of_type_Boolean = false;
            l1 = paramLong;
            if (this.jdField_b_of_type_Int == 0)
            {
              l1 = paramLong;
              if (!this.jdField_b_of_type_Boolean)
              {
                l1 = paramLong;
                if (this.jdField_d_of_type_Int != 0) {
                  continue;
                }
                l1 = paramLong;
                ReportController.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "1", "", "");
                l1 = paramLong;
                this.jdField_b_of_type_Boolean = true;
              }
            }
            l1 = paramLong;
            if (this.jdField_e_of_type_Long >= 0L)
            {
              l1 = paramLong;
              this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_e_of_type_Long;
            }
            l1 = paramLong;
            this.jdField_e_of_type_Long = System.currentTimeMillis();
            return;
          }
          if ((this.jdField_b_of_type_Int == 2) && (this.jdField_e_of_type_JavaLangString != null))
          {
            str = this.jdField_k_of_type_JavaLangString;
            continue;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ShortVideoPlayActivity", 2, "#play#, mVideo caller type not right:" + this.jdField_b_of_type_Int);
          return;
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        Object localObject;
        TVK_PlayerVideoInfo localTVK_PlayerVideoInfo;
        paramLong = l1;
        continue;
      }
      QLog.d("ShortVideoPlayActivity", 1, "#play#, msec=" + paramLong, localException1);
      i();
      a(0, 0);
      return;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "#play#, videoPath=" + this.jdField_b_of_type_JavaLangString);
        }
        localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
        localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
        localTVK_PlayerVideoInfo.setPlayType(4);
        localObject = new HashMap();
        ((Map)localObject).put("shouq_bus_type", "bus_type_aio_shortvideo_local");
        localTVK_PlayerVideoInfo.setReportInfoMap((Map)localObject);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_b_of_type_JavaLangString, paramLong, 0L, localTVK_PlayerVideoInfo);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoPlayActivity", 2, "#play#, mVideoPath should not be null!");
        return;
        l1 = paramLong;
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo((int)paramLong);
        continue;
        l1 = paramLong;
        if (this.jdField_d_of_type_Int == 3000)
        {
          l1 = paramLong;
          ReportController.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "2", "", "");
          l1 = paramLong;
          this.jdField_b_of_type_Boolean = true;
        }
        else
        {
          l1 = paramLong;
          if (this.jdField_d_of_type_Int == 1)
          {
            l1 = paramLong;
            ReportController.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "3", "", "");
            l1 = paramLong;
            this.jdField_b_of_type_Boolean = true;
          }
          else
          {
            l1 = paramLong;
            ReportController.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "4", "", "");
            l1 = paramLong;
            this.jdField_b_of_type_Boolean = true;
          }
        }
      }
    }
  }
  
  void a(Intent paramIntent)
  {
    this.jdField_b_of_type_JavaLangString = paramIntent.getExtras().getString("file_send_path");
    this.jdField_b_of_type_Int = paramIntent.getExtras().getInt("video_play_caller", 0);
    this.jdField_c_of_type_JavaLangString = paramIntent.getExtras().getString("ad_gdt");
    this.jdField_d_of_type_JavaLangString = paramIntent.getExtras().getString("msg_id");
    this.jdField_e_of_type_Int = paramIntent.getExtras().getInt("from_uin_type");
    this.jdField_j_of_type_JavaLangString = paramIntent.getExtras().getString("from_session_uin");
    this.jdField_d_of_type_Int = paramIntent.getExtras().getInt("uintype");
    this.jdField_e_of_type_JavaLangString = paramIntent.getExtras().getString("struct_msg_video_info");
    this.jdField_f_of_type_JavaLangString = paramIntent.getExtras().getString("from_uin");
    this.jdField_k_of_type_Long = paramIntent.getExtras().getLong("message_click_start");
    this.jdField_q_of_type_JavaLangString = paramIntent.getExtras().getString("file_uuid");
    this.jdField_g_of_type_JavaLangString = paramIntent.getExtras().getString("file_shortvideo_md5");
    this.jdField_h_of_type_JavaLangString = paramIntent.getExtras().getString("thumbfile_md5");
    if (this.jdField_b_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)paramIntent.getExtras().getParcelable("key_message_for_shortvideo"));
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)
      {
        QQToast.a(this, 1, "参数错误，传入的shortvideoMsg为空！", 0).b(getTitleBarHeight());
        finish();
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "initData(), PLAY_CALLER_SHORT_VIDEO, msg = " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.toLogString() + ", mUinType = " + this.jdField_d_of_type_Int);
      }
    }
    QLog.d("ShortVideoPlayActivity", 2, "initData(): mVideoPath=" + this.jdField_b_of_type_JavaLangString + ", mPlayCallerType=" + this.jdField_b_of_type_Int + ", mCursessionType = " + this.jdField_e_of_type_Int + ", mCurSessionUin = " + this.jdField_j_of_type_JavaLangString + ", mUinType = " + this.jdField_d_of_type_Int);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if (((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq != paramFileMsg.jdField_b_of_type_Long)) && (this.jdField_b_of_type_Int != 2)) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, " handleMessage what==" + paramInt1 + ", arg1:" + paramInt2);
        }
        if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
          QLog.d("ShortVideoPlayActivity", 2, "handleMessage msg.uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + ",fileType:" + ShortVideoUtils.a(paramFileMsg.jdField_b_of_type_Int) + " ===> fileStatus:" + ShortVideoUtils.b(paramFileMsg.jdField_d_of_type_Int));
        }
      } while ((paramFileMsg.jdField_b_of_type_Int != 6) && (paramFileMsg.jdField_b_of_type_Int != 17) && (paramFileMsg.jdField_b_of_type_Int != 9) && (paramFileMsg.jdField_b_of_type_Int != 20));
      switch (paramFileMsg.jdField_d_of_type_Int)
      {
      case 2004: 
      default: 
        return;
      case 1002: 
        a(paramFileMsg.jdField_e_of_type_Long, paramFileMsg.jdField_a_of_type_Long);
        return;
      case 2003: 
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "handleMessage STATUS_RECV_FINISHED");
        }
        this.jdField_k_of_type_Int = 10000;
        return;
      case 2005: 
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437367, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        this.B = paramFileMsg.jdField_g_of_type_Int;
        return;
      case 5001: 
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437368, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        this.B = paramFileMsg.jdField_g_of_type_Int;
        return;
      case 5002: 
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437369, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        this.B = paramFileMsg.jdField_g_of_type_Int;
        return;
      case 2002: 
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "STATUS_RECV_PROCESS: get url finished");
        }
        this.jdField_f_of_type_Int = ((int)(System.currentTimeMillis() - this.jdField_e_of_type_Long));
      }
    } while (paramFileMsg.c == null);
    this.jdField_a_of_type_ArrayOfJavaLangString = paramFileMsg.c;
    this.jdField_a_of_type_JavaLangString = paramFileMsg.u;
    this.jdField_u_of_type_Long = paramFileMsg.jdField_f_of_type_Long;
    paramInt1 = i1;
    while (paramInt1 < 1)
    {
      if (!StringUtil.a(this.jdField_a_of_type_JavaLangString))
      {
        paramView = new StringBuilder();
        paramFileMsg = this.jdField_a_of_type_ArrayOfJavaLangString;
        paramFileMsg[paramInt1] = (paramFileMsg[paramInt1] + "&txhost=" + this.jdField_a_of_type_JavaLangString);
      }
      paramInt1 += 1;
    }
    a(0L);
    return;
    z();
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo)
  {
    String str = ShortVideoUtils.d(NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext));
    if ((paramMessageForShortVideo.istroop == 0) || (paramMessageForShortVideo.istroop == 1008))
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "1", str, "");
      return;
    }
    if (paramMessageForShortVideo.istroop == 3000)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "2", str, "");
      return;
    }
    if (paramMessageForShortVideo.istroop == 1)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "3", str, "");
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "4", str, "");
  }
  
  public void a(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onCompletion(), mPlayProgress=" + this.jdField_j_of_type_Int + ", mCacheProgress=" + this.jdField_k_of_type_Int + ", mCurPlayPosition" + this.jdField_h_of_type_Long + ", mDuration=" + this.jdField_b_of_type_Long);
    }
    this.jdField_j_of_type_Int = 10000;
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(10000);
    if ((this.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_Int == 1)) {
      a(this.jdField_c_of_type_JavaLangString, 2, 1002, this.jdField_d_of_type_JavaLangString);
    }
    a(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_AndroidWidgetTextView.getText());
    d();
    this.jdField_c_of_type_Long = 0L;
    this.jdField_k_of_type_Boolean = true;
    if (this.jdField_e_of_type_Long >= 0L)
    {
      this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_e_of_type_Long;
      if (!this.jdField_d_of_type_Boolean)
      {
        new DCShortVideo(BaseApplication.getContext()).a(this.app, 2002, (int)(this.jdField_b_of_type_Long / 1000L), this.jdField_e_of_type_Int, this.jdField_j_of_type_JavaLangString, this.jdField_d_of_type_Long / 1000L);
        this.jdField_d_of_type_Boolean = true;
      }
    }
    t();
  }
  
  public void a(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.jdField_u_of_type_Int = paramInt1;
    this.v = paramInt2;
    t();
    a(false);
    this.C = 2005;
    a(3);
    i();
    a(paramInt1, paramInt2);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new aoja(this, paramString));
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    String str;
    if (!TextUtils.isEmpty(paramString1)) {
      str = "0";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString1);
      paramString1 = str;
      if (localJSONObject.has("ad_id")) {
        paramString1 = localJSONObject.getString("ad_id");
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "parse ad_id error");
        }
        paramString1 = "0";
      }
    }
    ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D93", "0X8005D93", paramInt2, 1, paramInt1, paramString1, paramString2, "", "");
  }
  
  public boolean a()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "#resume#");
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_Int == 2))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      a(1);
    }
    for (;;)
    {
      if (this.jdField_e_of_type_Long >= 0L) {
        this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_e_of_type_Long;
      }
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      return bool;
      bool = false;
    }
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null)
      {
        this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView(this));
        this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-16777216);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        ((IVideoViewBase)this.jdField_b_of_type_AndroidViewView).addViewCallBack(this);
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidViewView, 0);
        w();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4)) {
      break label24;
    }
    label24:
    do
    {
      do
      {
        return;
      } while (paramInt == this.jdField_a_of_type_Int);
      if (isFinishing())
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ShortVideoPlayActivity", 2, "changePlayState, while finishing");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "changePlayState, " + a(this.jdField_a_of_type_Int) + " ==> " + a(paramInt));
      }
      if ((this.jdField_a_of_type_Int == 1) && (paramInt != 1)) {
        if (this.jdField_j_of_type_Long != 0L) {
          this.jdField_i_of_type_Long += System.currentTimeMillis() - this.jdField_j_of_type_Long;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Int = paramInt;
        switch (paramInt)
        {
        default: 
          return;
        case 0: 
          this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843009);
          return;
          if ((this.jdField_a_of_type_Int == 4) && (paramInt != 4) && (this.jdField_p_of_type_Long != 0L)) {
            this.jdField_o_of_type_Long += System.currentTimeMillis() - this.jdField_p_of_type_Long;
          }
          break;
        }
      }
      this.jdField_j_of_type_Long = System.currentTimeMillis();
      this.jdField_p_of_type_Int += 1;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843011);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 50L);
      e();
      p();
      q();
    } while (this.jdField_f_of_type_AndroidWidgetRelativeLayout == null);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    return;
    this.jdField_q_of_type_Int += 1;
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843009);
    return;
    this.jdField_p_of_type_Long = System.currentTimeMillis();
    this.jdField_s_of_type_Int += 1;
    if (this.jdField_f_of_type_Boolean) {
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 50L);
    return;
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843009);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      long l1 = paramLong;
      if (paramLong < 0L) {
        l1 = 0L;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(l1));
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying());
  }
  
  void c()
  {
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)getLayoutInflater().inflate(2130970623, null, false));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131362840));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371482));
    x();
    this.jdField_a_of_type_AndroidViewView = this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371477);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131368869));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371474));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131368871));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131364678));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131364680));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131364679));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(10000);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371483));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371475));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371476));
    if ((this.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1001) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1002)) && (this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq) != null))
    {
      this.jdField_g_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371478));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371480));
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(100);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371479));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371481));
    }
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131371467));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_e_of_type_AndroidWidgetRelativeLayout);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131365222));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.bringToFront();
    localObject = (RelativeLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131371468);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
    localLayoutParams.topMargin = ImmersiveUtils.a(getApplicationContext());
    ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368089));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    b(0L);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
    n();
    o();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Int == 4;
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "startShowing : mHidden = " + this.jdField_j_of_type_Boolean);
    }
    if (!this.jdField_j_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    if (Build.VERSION.SDK_INT > 11) {
      this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    if (Build.VERSION.SDK_INT > 11) {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setAlpha(1.0F);
    }
    this.jdField_j_of_type_Boolean = false;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10001) {
      switch (paramInt2)
      {
      }
    }
    while (paramInt1 != 21)
    {
      return;
      QQToast.a(this, 2131437360, 0).a();
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    }
    ForwardUtils.a((QQAppInterface)getAppRuntime(), this, getApplicationContext(), paramIntent, null);
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    g();
    overridePendingTransition(0, 2131034423);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2130970622);
    getWindow().addFlags(128);
    this.D = getResources().getDisplayMetrics().widthPixels;
    this.E = getResources().getDisplayMetrics().heightPixels;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("DeviceInfo:");
      localStringBuilder.append("PRODUCT=").append(Build.PRODUCT).append("|");
      localStringBuilder.append("MODEL=").append(Build.MODEL).append("|");
      localStringBuilder.append("BOARD=").append(Build.BOARD).append("|");
      localStringBuilder.append("BOOTLOADER=").append(Build.BOOTLOADER).append("|");
      localStringBuilder.append("CPU_ABI=").append(Build.CPU_ABI).append("|");
      localStringBuilder.append("CPU_ABI2=").append(Build.CPU_ABI2).append("|");
      localStringBuilder.append("DEVICE=").append(Build.DEVICE).append("|");
      localStringBuilder.append("DISPLAY=").append(Build.DISPLAY).append("|");
      localStringBuilder.append("FLNGERPRINT=").append(Build.FINGERPRINT).append("|");
      localStringBuilder.append("HARDWARE=").append(Build.HARDWARE).append("|");
      localStringBuilder.append("ID=").append(Build.ID).append("|");
      localStringBuilder.append("MANUFACTURER=").append(Build.MANUFACTURER).append("|");
      localStringBuilder.append("SDK_INT=").append(Build.VERSION.SDK_INT).append("|");
      QLog.i("ShortVideoPlayActivity", 2, localStringBuilder.toString());
    }
    if (paramBundle != null)
    {
      this.jdField_c_of_type_Long = paramBundle.getInt("state_play_position");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "onCreate(), savedInstanceState != null, mCurrentPosition : " + this.jdField_c_of_type_Long);
      }
    }
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getExtras();
    a(super.getIntent());
    c();
    a();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    paramBundle.addAction("tencent.av.v2q.StartVideoChat");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    this.app.setHandler(ShortVideoPlayActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    ReportController.b(this.app, "dc00898", "", "", "0X8007425", "0X8007425", 0, 0, "", "", "", "");
    ReportController.b(this.app, "dc00898", "", "", "0X8007427", "0X8007427", 0, 0, "", "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "doOnDestroy");
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) {
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    }
    g();
    TVK_SDKMgr.setOnLogListener(null);
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_b_of_type_AndroidViewView);
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      ((IVideoViewBase)this.jdField_b_of_type_AndroidViewView).removeViewCallBack(this);
      this.jdField_b_of_type_AndroidViewView = null;
    }
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label111:
      this.app.removeHandler(ShortVideoPlayActivity.class);
      if (this.jdField_e_of_type_Long >= 0L)
      {
        this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_e_of_type_Long;
        if (!this.jdField_d_of_type_Boolean)
        {
          new DCShortVideo(BaseApplication.getContext()).a(this.app, 2002, (int)(this.jdField_b_of_type_Long / 1000L), this.jdField_e_of_type_Int, this.jdField_j_of_type_JavaLangString, this.jdField_d_of_type_Long / 1000L);
          this.jdField_d_of_type_Boolean = true;
        }
      }
      if (this.jdField_e_of_type_Boolean) {
        new DCShortVideo(BaseApplication.getContext()).a(true, this.jdField_f_of_type_Int, this.jdField_j_of_type_Int / 100, this.jdField_k_of_type_Int / 100, (int)this.jdField_b_of_type_Long, (int)this.jdField_g_of_type_Long, 0, this.jdField_g_of_type_Int, this.jdField_i_of_type_Int, this.jdField_d_of_type_Long);
      }
      if (!this.jdField_g_of_type_Boolean)
      {
        t();
        a(true);
        A();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uiOperatorFlag == 2) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress != 100))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus = 2009;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.serial();
        this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label111;
    }
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    do
    {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
    } while (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0);
    if (this.jdField_d_of_type_Int != 9501) {
      m();
    }
    return true;
  }
  
  public void doOnPause()
  {
    if (!this.jdField_k_of_type_Boolean) {
      this.jdField_i_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
      this.jdField_h_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "pause mCurrentPosition:" + this.jdField_c_of_type_Long);
      }
    }
    for (;;)
    {
      super.doOnPause();
      return;
      if (c()) {
        this.jdField_h_of_type_Boolean = true;
      }
    }
  }
  
  @TargetApi(10)
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "doOnResume: mInterrupted = " + this.jdField_i_of_type_Boolean + ", mNeedPlay = " + this.jdField_h_of_type_Boolean + " mSurfaceViewDestroyed=" + this.jdField_r_of_type_Boolean);
    }
    x();
    if ((this.jdField_i_of_type_Boolean) || (this.jdField_k_of_type_Boolean))
    {
      if (!this.jdField_h_of_type_Boolean) {
        break label126;
      }
      if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) && (!a())) {
        a(this.jdField_c_of_type_Long);
      }
    }
    label126:
    do
    {
      do
      {
        return;
      } while (Build.VERSION.SDK_INT < 10);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "onResume, restore last pause, mCurrentPosition=" + this.jdField_c_of_type_Long);
      }
      if (this.jdField_r_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoPlayActivity", 2, "onResume, restore last pause mSurfaceViewDestroyed=" + this.jdField_r_of_type_Boolean);
    return;
    if (this.jdField_b_of_type_Int == 0) {
      if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!FileUtils.b(this.jdField_b_of_type_JavaLangString))) {}
    }
    for (;;)
    {
      try
      {
        MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
        localMediaMetadataRetriever.setDataSource(this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidGraphicsBitmap = localMediaMetadataRetriever.getFrameAtTime(this.jdField_c_of_type_Long * 1000L);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        localMediaMetadataRetriever.release();
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new ColorDrawable(0));
        continue;
      }
      if (this.jdField_b_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new ColorDrawable(0));
      }
    }
  }
  
  protected void doOnStart()
  {
    MediaPlayerManager.a(this.app).a(true);
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
    super.doOnStart();
  }
  
  protected void doOnStop()
  {
    if (!this.jdField_k_of_type_Boolean) {
      this.jdField_i_of_type_Boolean = true;
    }
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    }
    super.doOnStop();
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "delayStartHiding");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 2500L);
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "startHiding : mHidden = " + this.jdField_j_of_type_Boolean + ",playState:" + a(this.jdField_a_of_type_Int));
    }
    if (this.jdField_j_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Int != 1);
      this.jdField_j_of_type_Boolean = true;
    } while (((this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) && (this.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) || (Build.VERSION.SDK_INT < 11));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  void g()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
    a(0);
  }
  
  public void h()
  {
    long l1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "initDuration: duration=" + l1);
    }
    if (l1 != 0L)
    {
      this.jdField_b_of_type_Long = ((int)l1);
      this.jdField_i_of_type_JavaLangString = ShortVideoUtils.a(this.jdField_b_of_type_Long);
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (!this.jdField_b_of_type_AndroidWidgetTextView.getText().equals(this.jdField_i_of_type_JavaLangString))) {
        runOnUiThread(new aojf(this));
      }
    }
  }
  
  void i()
  {
    a(0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void j()
  {
    if (b())
    {
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
    a(2);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "#pause# , mCurrentPosition = " + this.jdField_c_of_type_Long);
    }
    if (this.jdField_e_of_type_Long >= 0L) {
      this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_e_of_type_Long;
    }
  }
  
  void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "handleClick: mPlayState = " + a(this.jdField_a_of_type_Int) + ", mCurrentPosition = " + this.jdField_c_of_type_Long);
    }
    switch (this.jdField_a_of_type_Int)
    {
    case 4: 
    default: 
    case 0: 
    case 1: 
    case 2: 
      do
      {
        return;
        a(this.jdField_c_of_type_Long);
        return;
        j();
        return;
        a();
      } while ((this.jdField_c_of_type_Long == 0L) || (!this.jdField_r_of_type_Boolean));
      a(this.jdField_c_of_type_Long);
      return;
    }
    a(0L);
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onClick surfaceView, mHidden=" + this.jdField_j_of_type_Boolean);
    }
    if (this.jdField_j_of_type_Boolean)
    {
      d();
      e();
    }
  }
  
  void m()
  {
    int i1 = 0;
    String str2 = getResources().getString(2131437382);
    getResources().getString(2131437383);
    String str3 = getResources().getString(2131437359);
    String str4 = getResources().getString(2131437364);
    String str5 = getResources().getString(2131433015);
    String str1;
    boolean bool1;
    ActionSheet localActionSheet;
    if (this.jdField_b_of_type_Int == 0)
    {
      str1 = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      bool1 = FileUtils.a(str1);
      if (this.jdField_f_of_type_Boolean) {
        bool1 = false;
      }
      boolean bool2 = "1".equals(DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"));
      if (getIntent().getIntExtra("from_busi_type", 0) == 2) {
        i1 = 1;
      }
      localActionSheet = ActionSheet.a(this);
      if ((bool2) && (this.jdField_d_of_type_Int != 9501) && (i1 == 0)) {
        localActionSheet.c(str2);
      }
      if (this.jdField_b_of_type_Int != 3)
      {
        if (!bool1) {
          break label239;
        }
        localActionSheet.c(str3);
        localActionSheet.c(str4);
      }
    }
    for (;;)
    {
      localActionSheet.d(str5);
      localActionSheet.show();
      localActionSheet.a(new aojm(this, localActionSheet, str2, str1, str3, bool1, str1, str4));
      return;
      str1 = this.jdField_b_of_type_JavaLangString;
      break;
      label239:
      localActionSheet.a(str3, 7);
      localActionSheet.a(str4, 7);
    }
  }
  
  void n()
  {
    if (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != 0) {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  void o()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)
    {
      localObject = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbMD5, "jpg");
      if (!FileUtils.b((String)localObject)) {}
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(-16777216);
      localObject = URLDrawable.getDrawable(new File((String)localObject), localURLDrawableOptions);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "showLoadingImage crashed =" + localException.toString());
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    s();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131371477: 
    default: 
      return;
    case 2131371467: 
      s();
      return;
    case 2131371479: 
      this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      s();
      return;
    case 2131371483: 
      l();
      k();
      return;
    case 2131368871: 
      l();
      if (this.jdField_a_of_type_Int == 1) {
        j();
      }
      m();
      return;
    }
    s();
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    runOnUiThread(new aojp(this, paramTVK_IMediaPlayer));
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onError what=" + paramInt1 + ",extra=" + paramInt2 + ",mCacheProgress=" + this.jdField_k_of_type_Int + ", mPlayProgress=" + this.jdField_j_of_type_Int + ", mCurPlayPosition=" + this.jdField_h_of_type_Long);
    }
    runOnUiThread(new aojq(this, paramTVK_IMediaPlayer, paramInt1, paramInt2, paramInt3, paramString, paramObject));
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onInfo what=" + paramInt + ",extra=" + paramObject + ",mCacheProgress=" + this.jdField_k_of_type_Int + ", mPlayProgress=" + this.jdField_j_of_type_Int + ", mCurPlayPosition=" + this.jdField_h_of_type_Long);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "video start buffering !");
      }
      a(4);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "video end buffering !");
      }
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) {
        a(1);
      } else {
        a(2);
      }
    }
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onNetVideoInfo what=" + paramTVK_NetVideoInfo.getErrInfo() + ",extra=" + paramTVK_NetVideoInfo.getState() + ",mCacheProgress=" + this.jdField_k_of_type_Int + ", mPlayProgress=" + this.jdField_j_of_type_Int + ", mCurPlayPosition=" + this.jdField_h_of_type_Long);
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (!this.jdField_k_of_type_Boolean) {
      this.jdField_i_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
      this.jdField_h_of_type_Boolean = true;
    }
    paramBundle.putLong("state_play_position", this.jdField_c_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onSaveInstanceState: mCurrentPosition: " + this.jdField_c_of_type_Long);
    }
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onSeekComplete mCacheProgress=" + this.jdField_k_of_type_Int + ", mPlayProgress=" + this.jdField_j_of_type_Int + ", mCurPlayPosition=" + this.jdField_h_of_type_Long);
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onSurfaceDestory");
    }
    this.jdField_r_of_type_Boolean = true;
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onVideoPrepared: mDuration=" + this.jdField_b_of_type_Long + " mInterrupted" + this.jdField_i_of_type_Boolean + " mNeedPlay" + this.jdField_h_of_type_Boolean);
    }
    this.jdField_r_of_type_Boolean = false;
    runOnUiThread(new aojr(this));
    if (this.jdField_b_of_type_Int == 2) {
      a(this.jdField_c_of_type_JavaLangString, 1, 1002, this.jdField_d_of_type_JavaLangString);
    }
    if (this.jdField_k_of_type_Long != 0L)
    {
      this.jdField_l_of_type_Long = (System.currentTimeMillis() - this.jdField_k_of_type_Long);
      this.jdField_k_of_type_Long = 0L;
    }
    if (this.jdField_m_of_type_Long != 0L)
    {
      this.jdField_n_of_type_Long = (System.currentTimeMillis() - this.jdField_m_of_type_Long);
      this.jdField_m_of_type_Long = 0L;
    }
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_i_of_type_Boolean = false;
      if (!this.jdField_h_of_type_Boolean) {
        return;
      }
    }
    this.jdField_h_of_type_Boolean = false;
    if (this.jdField_b_of_type_Long <= 0L) {
      h();
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    if (this.jdField_a_of_type_Long > 0L) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo((int)this.jdField_a_of_type_Long);
    }
    a(1);
  }
  
  public void onVideoPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onVideoPreparing mCacheProgress=" + this.jdField_k_of_type_Int + ", mPlayProgress=" + this.jdField_j_of_type_Int + ", mCurPlayPosition=" + this.jdField_h_of_type_Long);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      x();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onWindowFocusChanged: hasFocus: " + paramBoolean);
    }
  }
  
  public void p()
  {
    if ((this.jdField_e_of_type_AndroidWidgetTextView != null) && (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  void q()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  public void r()
  {
    a(DialogUtil.a(this, 232, null, getString(2131437384), new aojn(this), new aojo(this)));
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "userBackPressed");
    }
    g();
    setResult(-1, getIntent());
    finish();
    try
    {
      overridePendingTransition(2131034165, 2131034167);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] overridePendingTransition=" + localException);
    }
  }
  
  public void t()
  {
    if (!this.jdField_o_of_type_Boolean) {}
    while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    StringBuffer localStringBuffer = new StringBuffer();
    if (!this.jdField_f_of_type_Boolean)
    {
      i1 = 1;
      if (this.jdField_i_of_type_Int == 0) {
        i1 = 3;
      }
      localHashMap.put("player_state", String.valueOf(i1));
      localStringBuffer.append(" player_state " + i1);
      localHashMap.put("Download", String.valueOf(this.jdField_l_of_type_Boolean));
      localStringBuffer.append(" Download" + this.jdField_l_of_type_Boolean);
      localHashMap.put("FileSize", String.valueOf(this.jdField_g_of_type_Long));
      localStringBuffer.append(" FileSize" + this.jdField_g_of_type_Long);
      localHashMap.put("HttpDownloadSum", String.valueOf(this.jdField_m_of_type_Int));
      localStringBuffer.append(" HttpDownloadSum" + this.jdField_m_of_type_Int);
      if (this.jdField_l_of_type_Boolean) {
        break label1216;
      }
      localHashMap.put("DataFromCacheSize", String.valueOf(this.jdField_g_of_type_Long));
      localStringBuffer.append(" DataFromCacheSize" + this.jdField_g_of_type_Long);
      label277:
      localHashMap.put("FileDuration", String.valueOf(this.jdField_b_of_type_Long));
      localStringBuffer.append(" FileDuration" + this.jdField_b_of_type_Long);
      localHashMap.put("PlayTime", String.valueOf(this.jdField_i_of_type_Long));
      localStringBuffer.append(" PlayTime" + this.jdField_i_of_type_Long);
      localHashMap.put("PlayStateCount", String.valueOf(this.jdField_p_of_type_Int));
      localStringBuffer.append(" PlayStateCount" + this.jdField_p_of_type_Int);
      localHashMap.put("PlayProgress", String.valueOf(this.jdField_j_of_type_Int / 100));
      localStringBuffer.append(" PlayProgress" + this.jdField_j_of_type_Int / 100);
      localHashMap.put("FirstPlayTime", String.valueOf(this.jdField_l_of_type_Long));
      localStringBuffer.append(" FirstPlayTime" + this.jdField_l_of_type_Long);
      localHashMap.put("FirstBufferTime", String.valueOf(this.jdField_n_of_type_Long));
      localStringBuffer.append(" FirstBufferTime" + this.jdField_n_of_type_Long);
      localHashMap.put("SeekTimes", String.valueOf(this.jdField_h_of_type_Int));
      localStringBuffer.append(" SeekTimes" + this.jdField_h_of_type_Int);
      if (this.jdField_s_of_type_Int != 0) {
        break label1264;
      }
      i1 = this.jdField_s_of_type_Int;
      label610:
      localHashMap.put("BufferTimes", String.valueOf(i1));
      localStringBuffer.append(" BufferTimes" + i1);
      localHashMap.put("BufferCostTime", String.valueOf(this.jdField_o_of_type_Long));
      localStringBuffer.append(" BufferCostTime" + this.jdField_o_of_type_Long);
      if (this.jdField_r_of_type_Long != 0L)
      {
        this.jdField_q_of_type_Long = (System.currentTimeMillis() - this.jdField_r_of_type_Long);
        this.jdField_r_of_type_Long = 0L;
      }
      i1 = 0;
      if (this.jdField_n_of_type_Int != 0) {
        i1 = this.jdField_m_of_type_Int / (this.jdField_n_of_type_Int * 1000);
      }
      localHashMap.put("SpeedKBS", String.valueOf(i1));
      localStringBuffer.append(" SpeedKBS" + i1);
      if (this.jdField_r_of_type_Int <= 0) {
        break label1274;
      }
      str1 = "1";
      label794:
      localHashMap.put("IsRePlay", str1);
      localStringBuffer.append(" IsRePlay" + this.jdField_r_of_type_Int);
      localHashMap.put("SuspendTimes", String.valueOf(this.jdField_q_of_type_Int));
      localStringBuffer.append(" SuspendTimes" + this.jdField_q_of_type_Int);
      if (this.B == 0) {
        break label1281;
      }
      localHashMap.put("param_FailCode", String.valueOf(this.B));
    }
    Object localObject;
    int i3;
    label1281:
    for (boolean bool = false;; bool = true)
    {
      localHashMap.put("ErrorCode", String.valueOf(this.jdField_u_of_type_Int));
      localHashMap.put("ErrorDetailCode", String.valueOf(this.v));
      localHashMap.put("HttpStatus", String.valueOf(this.jdField_t_of_type_Int));
      localStringBuffer.append(" HttpStatus" + this.jdField_t_of_type_Int);
      localHashMap.put("User-ReturnCode", this.jdField_m_of_type_JavaLangString);
      localStringBuffer.append(" User-ReturnCode" + this.jdField_m_of_type_JavaLangString);
      localHashMap.put("X-RtFlag", this.jdField_n_of_type_JavaLangString);
      localStringBuffer.append(" X-RtFlag" + this.jdField_n_of_type_JavaLangString);
      int i2 = -1;
      localObject = new StringBuffer("");
      str1 = null;
      if (!StringUtil.a(this.jdField_p_of_type_JavaLangString)) {
        str1 = InnerDns.a(this.jdField_p_of_type_JavaLangString);
      }
      i3 = i2;
      if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
        break label1287;
      }
      i3 = i2;
      if (this.jdField_a_of_type_ArrayOfJavaLangString.length <= 0) {
        break label1287;
      }
      i1 = 0;
      for (;;)
      {
        i3 = i2;
        if (i1 >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
          break;
        }
        String str2 = InnerDns.a(this.jdField_a_of_type_ArrayOfJavaLangString[i1]);
        ((StringBuffer)localObject).append(str2 + ",");
        i3 = i2;
        if (i2 == -1)
        {
          i3 = i2;
          if (!StringUtil.a(str1))
          {
            i3 = i2;
            if (str1.equals(str2)) {
              i3 = i1;
            }
          }
        }
        i1 += 1;
        i2 = i3;
      }
      i1 = 2;
      break;
      label1216:
      localHashMap.put("DataFromCacheSize", String.valueOf(this.jdField_o_of_type_Int));
      localStringBuffer.append(" DataFromCacheSize" + this.jdField_o_of_type_Int);
      break label277;
      label1264:
      i1 = this.jdField_s_of_type_Int - 1;
      break label610;
      label1274:
      str1 = "0";
      break label794;
    }
    label1287:
    localHashMap.put("IpList", ((StringBuffer)localObject).toString());
    int i1 = i3 + 1;
    localHashMap.put("SuccIpIndex", String.valueOf(i1));
    localStringBuffer.append(" SuccIpIndex" + i1);
    localHashMap.put("HttpDomain", this.jdField_a_of_type_JavaLangString);
    localStringBuffer.append(" HttpDomain" + this.jdField_a_of_type_JavaLangString);
    localHashMap.put("HttpRedirectNum", String.valueOf(this.w));
    localStringBuffer.append(" HttpRedirectNum" + this.w);
    localHashMap.put("HttpRedirectCostMs", String.valueOf(this.x));
    localStringBuffer.append(" HttpRedirectCostMs" + this.x);
    localHashMap.put("HttpDnsCostMs", String.valueOf(this.y));
    localStringBuffer.append(" HttpDnsCostMs" + this.y);
    localHashMap.put("HttpConnectCostMs", String.valueOf(this.z));
    localStringBuffer.append(" HttpConnectCostMs" + this.z);
    localHashMap.put("HttpFirstRecvCostMs", String.valueOf(this.A));
    localStringBuffer.append(" HttpFirstRecvCostMs" + this.A);
    localHashMap.put("RetrySuccessTimes", "0");
    localHashMap.put("RetryFailedTimes", "0");
    localHashMap.put("ApplyCostTime", String.valueOf(this.jdField_u_of_type_Long));
    localStringBuffer.append(" ApplyCostTime" + this.jdField_u_of_type_Long);
    localHashMap.put("HttpCostTime", String.valueOf(this.jdField_q_of_type_Long));
    localStringBuffer.append(" HttpCostTime" + this.jdField_q_of_type_Long);
    localHashMap.put("DownType", "1");
    localHashMap.put("SceneType", "2");
    localHashMap.put("BusiType", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("SubBusiType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.subBusiType));
    localHashMap.put("FromUin", String.valueOf(this.jdField_f_of_type_JavaLangString));
    localHashMap.put("GrpUin", String.valueOf(this.jdField_j_of_type_JavaLangString));
    localHashMap.put("Uuid", String.valueOf(this.jdField_q_of_type_JavaLangString));
    localHashMap.put("MsgFileMd5", String.valueOf(this.jdField_g_of_type_JavaLangString));
    localHashMap.put("DownFileMd5", String.valueOf(this.jdField_g_of_type_JavaLangString));
    String str1 = String.valueOf(NetworkUtil.a(BaseApplicationImpl.getApplication().getApplicationContext()));
    localHashMap.put("NetworkInfo", str1);
    localStringBuffer.append(" NetworkInfo" + str1);
    localHashMap.put("ProductVersion", String.valueOf(this.app.getAppid()));
    localHashMap.put("EncryptKey", "0");
    if (this.jdField_m_of_type_Boolean)
    {
      str1 = "1";
      localHashMap.put("IsUpdateSuit", str1);
      localObject = new StringBuilder().append(" IsUpdateSuit");
      if (!this.jdField_m_of_type_Boolean) {
        break label2264;
      }
      str1 = "1";
      label1994:
      localStringBuffer.append(str1);
      localHashMap.put("UpdateSuitCostTime", String.valueOf(this.jdField_s_of_type_Long));
      localStringBuffer.append(" UpdateSuitCostTime" + this.jdField_s_of_type_Long);
      if (!this.jdField_n_of_type_Boolean) {
        break label2271;
      }
      str1 = "1";
      label2067:
      localHashMap.put("UpdateSuitResult", str1);
      localObject = new StringBuilder().append(" UpdateSuitResult");
      if (!this.jdField_n_of_type_Boolean) {
        break label2278;
      }
    }
    label2264:
    label2271:
    label2278:
    for (str1 = "1";; str1 = "0")
    {
      localStringBuffer.append(str1);
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoPlayActivity", 2, localStringBuffer.toString());
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actStreamingVideoPlay", bool, this.jdField_q_of_type_Long, this.jdField_g_of_type_Long, localHashMap, "");
      this.jdField_o_of_type_Boolean = false;
      this.jdField_p_of_type_Int = 0;
      this.jdField_h_of_type_Int = 0;
      this.jdField_s_of_type_Int = 0;
      this.jdField_q_of_type_Int = 0;
      this.jdField_o_of_type_Long = 0L;
      this.jdField_q_of_type_Long = 0L;
      this.jdField_i_of_type_Long = 0L;
      this.z = 0;
      this.y = 0;
      this.jdField_l_of_type_Long = 0L;
      this.jdField_n_of_type_Long = 0L;
      this.jdField_u_of_type_Long = 0L;
      this.A = 0;
      this.x = 0;
      this.jdField_s_of_type_Long = 0L;
      this.jdField_u_of_type_Int = 0;
      this.v = 0;
      return;
      str1 = "0";
      break;
      str1 = "0";
      break label1994;
      str1 = "0";
      break label2067;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity
 * JD-Core Version:    0.7.0.1
 */