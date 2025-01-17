package com.tencent.mobileqq.richmedia.capture.view;

import ahmy;
import ahmz;
import ahna;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.opengl.GLES20;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureTimer;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraOperator;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.capture.audio.AudioDataCache;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.CustomSize;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(17)
public class SplitEffectsCameraCaptureView
  extends EffectsCameraCaptureView
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, CameraCaptureView.CaptureListener
{
  private long jdField_a_of_type_Long;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private ReadInJoyCameraCaptureTimer jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraCaptureTimer;
  private SplitEffectsCameraCaptureView.EventListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView$EventListener;
  private SplitEffectsCameraCaptureView.SegmentInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView$SegmentInfo;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private SurfaceTexture jdField_b_of_type_AndroidGraphicsSurfaceTexture;
  private CameraCaptureView.CaptureListener jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener;
  protected RenderBuffer b;
  private final float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  private boolean j;
  private boolean k = true;
  private boolean l;
  private int o;
  private int p;
  private int q;
  private int r;
  
  public SplitEffectsCameraCaptureView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SplitEffectsCameraCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    C();
  }
  
  private void C()
  {
    super.setCaptureListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraCaptureTimer = new ReadInJoyCameraCaptureTimer();
  }
  
  private void D()
  {
    if (!this.k) {}
    while (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      return;
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
  }
  
  private void E()
  {
    if (!this.k) {}
    while ((this.jdField_a_of_type_AndroidMediaMediaPlayer == null) || (!this.j)) {
      return;
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
  }
  
  private void F()
  {
    if (!this.k) {}
    while (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      return;
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    this.j = false;
  }
  
  private String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(c());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("segment_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(".mp4");
    return localStringBuilder.toString();
  }
  
  private void c(int paramInt)
  {
    if (!this.k) {}
    while ((this.jdField_a_of_type_AndroidMediaMediaPlayer == null) || (!this.j)) {
      return;
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(paramInt);
  }
  
  public void A()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.cameracapture.SplitEffectsCameraCaptureView", 2, "deleteLastSegment()：mCurSegmentIndex=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    }
    for (;;)
    {
      int i;
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) {
          return;
        }
        if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) || (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() - 1)))) {
          break label298;
        }
        i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
        SplitEffectsCameraCaptureView.SegmentInfo localSegmentInfo1 = (SplitEffectsCameraCaptureView.SegmentInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(i));
        if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localSegmentInfo1.jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty(localSegmentInfo1.jdField_b_of_type_JavaLangString)) {
          break label304;
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localSegmentInfo1.jdField_b_of_type_JavaLangString);
      }
      finally {}
      if ((i != 0) && (this.k))
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) {
          c(0);
        }
      }
      else
      {
        if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0)) {
          ThreadManager.post(new ahmy(this), 5, null, true);
        }
        if (this.k) {
          break label303;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraCaptureTimer.c();
        return;
      }
      SplitEffectsCameraCaptureView.SegmentInfo localSegmentInfo2 = (SplitEffectsCameraCaptureView.SegmentInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() - 1));
      if (localSegmentInfo2 != null)
      {
        c(localSegmentInfo2.jdField_b_of_type_Int);
        continue;
        label298:
        i = 0;
        continue;
        label303:
        return;
        label304:
        i = 1;
      }
    }
  }
  
  public void A_()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener != null) {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.A_();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.cameracapture.SplitEffectsCameraCaptureView", 2, "onFirstFrameShown()");
    }
  }
  
  public void B()
  {
    if (this.k) {
      F();
    }
  }
  
  public void B_()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener != null) {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.B_();
    }
  }
  
  protected int a(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    paramInt = super.a(paramInt);
    long l2 = System.currentTimeMillis();
    if ((QLog.isColorLevel()) && (l2 - l1 > 20L)) {
      QLog.w("Q.pubaccount.video.cameracapture.SplitEffectsCameraCaptureView", 2, "process filter cost : " + (l2 - l1));
    }
    if (!this.k) {
      return paramInt;
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer == null) || (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b() != this.jdField_a_of_type_Int) || (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c() != this.jdField_b_of_type_Int)) {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 33984);
    }
    this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
    l1 = System.currentTimeMillis();
    GLES20.glViewport(0, 0, this.jdField_a_of_type_Int / 2, this.jdField_b_of_type_Int);
    float[] arrayOfFloat = GPUBaseFilter.a(this.f, this.g, this.jdField_a_of_type_Int / 2, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(3553, paramInt, null, arrayOfFloat);
    l2 = System.currentTimeMillis();
    if ((QLog.isColorLevel()) && (l2 - l1 > 20L)) {
      QLog.w("Q.pubaccount.video.cameracapture.SplitEffectsCameraCaptureView", 2, "draw split left part cost : " + (l2 - l1));
    }
    l1 = System.currentTimeMillis();
    GLES20.glViewport(this.jdField_a_of_type_Int / 2, 0, this.jdField_a_of_type_Int / 2, this.jdField_b_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_b_of_type_ArrayOfFloat);
    arrayOfFloat = GPUBaseFilter.a(this.q, this.r, this.jdField_a_of_type_Int / 2, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(36197, this.p, this.jdField_b_of_type_ArrayOfFloat, arrayOfFloat);
    this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
    l2 = System.currentTimeMillis();
    if ((QLog.isColorLevel()) && (l2 - l1 > 20L)) {
      QLog.w("Q.pubaccount.video.cameracapture.SplitEffectsCameraCaptureView", 2, "draw split right part cost : " + (l2 - l1));
    }
    return this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
  }
  
  public long a()
  {
    if (!this.k) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraCaptureTimer.a();
    }
    return this.jdField_a_of_type_Long;
  }
  
  public CameraCaptureView.CaptureParam a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam;
  }
  
  public void a(int paramInt) {}
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener != null) {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.a(paramPhotoCaptureResult);
    }
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener != null) {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.a(paramVideoCaptureResult);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.cameracapture.SplitEffectsCameraCaptureView", 2, "onVideoCaptured, VideoCaptureResult = " + paramVideoCaptureResult);
    }
    int i;
    if (paramVideoCaptureResult.errorCode == 0)
    {
      i = 1;
      if (i == 0) {
        break label324;
      }
    }
    label324:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
        }
        if ((!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()))) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView$SegmentInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView$SegmentInfo.jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()))
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView$SegmentInfo.jdField_b_of_type_JavaLangString = paramVideoCaptureResult.audioDataFilePath;
          paramVideoCaptureResult = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView$SegmentInfo;
          i = h();
          paramVideoCaptureResult.jdField_b_of_type_Int = i;
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView$SegmentInfo);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView$SegmentInfo = null;
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.cameracapture.SplitEffectsCameraCaptureView", 2, "onVideoCaptured success, add segment success!! mCurSegmentIndex = " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", endPosition=" + i);
          }
          FileUtils.c(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_JavaLangString + File.separator + ".nomedia");
          return;
          i = 0;
          break;
        }
        if (QLog.isColorLevel())
        {
          QLog.e("Q.pubaccount.video.cameracapture.SplitEffectsCameraCaptureView", 2, "onVideoCaptured success, add segment failure!! mCurSegmentIndex = " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
          continue;
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView$SegmentInfo = null;
        }
      }
      finally {}
    }
  }
  
  protected void a(CameraControl.CustomSize paramCustomSize)
  {
    this.e = paramCustomSize.jdField_a_of_type_Int;
    this.d = paramCustomSize.jdField_b_of_type_Int;
    int[] arrayOfInt = CaptureUtil.a(this.d, this.e, this.o, this.jdField_b_of_type_Int, 1.0F);
    this.f = arrayOfInt[0];
    this.g = arrayOfInt[1];
    arrayOfInt = CaptureUtil.a(this.d, this.e, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Float);
    this.h = arrayOfInt[0];
    this.i = arrayOfInt[1];
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator.a(paramCustomSize.jdField_a_of_type_Int, paramCustomSize.jdField_b_of_type_Int, this.o, this.jdField_b_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.cameracapture.SplitEffectsCameraCaptureView", 2, "onCameraSizeSelected(): cameraPreviewWidth=" + this.d + ",cameraPreviewHeight=" + this.e + "， cameraClipWidth=" + this.f + ",cameraClipHeight=" + this.g + ", videoWidth=" + this.h + ",videoHeight=" + this.i);
    }
    queueEvent(new ahmz(this));
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView$EventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView$EventListener.a(this.h, this.i);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView$EventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView$EventListener.a(paramBoolean);
    }
  }
  
  public void aj_()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener != null) {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.aj_();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.cameracapture.SplitEffectsCameraCaptureView", 2, "onVideoCaptureStart()");
    }
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("video_data_cache");
    return localStringBuilder.toString();
  }
  
  public String d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a.c();
    }
    return null;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
    }
    return 0;
  }
  
  public int f()
  {
    return this.h;
  }
  
  public int g()
  {
    return this.i;
  }
  
  public void g() {}
  
  public void g_(boolean paramBoolean) {}
  
  /* Error */
  public int h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	com/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView:k	Z
    //   4: ifne +13 -> 17
    //   7: aload_0
    //   8: getfield 74	com/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView:jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraCaptureTimer	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureTimer;
    //   11: invokevirtual 455	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureTimer:b	()I
    //   14: istore_2
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 77	com/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: ifnull +63 -> 84
    //   24: aload_0
    //   25: getfield 85	com/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView:j	Z
    //   28: ifeq +56 -> 84
    //   31: aload_0
    //   32: getfield 77	com/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   35: invokevirtual 458	android/media/MediaPlayer:getCurrentPosition	()I
    //   38: istore_1
    //   39: iload_1
    //   40: i2l
    //   41: lstore_3
    //   42: iload_1
    //   43: istore_2
    //   44: lload_3
    //   45: aload_0
    //   46: getfield 312	com/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView:jdField_a_of_type_Long	J
    //   49: lcmp
    //   50: ifle -35 -> 15
    //   53: aload_0
    //   54: getfield 312	com/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView:jdField_a_of_type_Long	J
    //   57: lstore_3
    //   58: lload_3
    //   59: l2i
    //   60: istore_2
    //   61: iload_1
    //   62: ireturn
    //   63: astore 5
    //   65: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +14 -> 82
    //   71: ldc 139
    //   73: iconst_2
    //   74: ldc_w 460
    //   77: aload 5
    //   79: invokestatic 463	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   82: iconst_0
    //   83: ireturn
    //   84: iconst_0
    //   85: ireturn
    //   86: astore 5
    //   88: iconst_0
    //   89: ireturn
    //   90: astore 5
    //   92: iload_1
    //   93: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	SplitEffectsCameraCaptureView
    //   38	55	1	i	int
    //   14	47	2	m	int
    //   41	18	3	l1	long
    //   63	15	5	localException	java.lang.Exception
    //   86	1	5	localObject1	Object
    //   90	1	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   31	39	63	java/lang/Exception
    //   44	58	63	java/lang/Exception
    //   31	39	86	finally
    //   65	82	86	finally
    //   44	58	90	finally
  }
  
  public void i()
  {
    int m = 1;
    super.i();
    int i;
    if (this.c == 1) {
      i = 1;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      if (this.k) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("camera_type", m);
        PublicAccountReportUtils.a(null, "", "0X80081CF", "0X80081CF", 0, 0, String.valueOf(i), "", "", VideoReporter.a(localJSONObject), false);
        return;
        i = 2;
        continue;
        m = 2;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.cameracapture.SplitEffectsCameraCaptureView", 2, "startCaptureVideo() ==>");
    }
    super.k();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView$SegmentInfo = new SplitEffectsCameraCaptureView.SegmentInfo();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView$SegmentInfo.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView$SegmentInfo.jdField_a_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView$SegmentInfo.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView$SegmentInfo.jdField_a_of_type_JavaLangString;
    if (this.k)
    {
      E();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraCaptureTimer.b();
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.cameracapture.SplitEffectsCameraCaptureView", 2, "<== stopCapture()");
    }
    super.l();
    if (this.k)
    {
      D();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraCaptureTimer.a();
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.cameracapture.SplitEffectsCameraCaptureView", 2, "#MediaPlayer# onCompletion(): ");
    }
    l();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView$EventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView$EventListener.b();
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.jdField_b_of_type_AndroidGraphicsSurfaceTexture != null) {
      this.jdField_b_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
    }
    super.onDrawFrame(paramGL10);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.pubaccount.video.cameracapture.SplitEffectsCameraCaptureView", 2, "#MediaPlayer# onError(): what=" + paramInt1 + ", extra=" + paramInt2);
    }
    F();
    return false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.a().post(new ahna(this, paramSurfaceTexture));
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.q = paramMediaPlayer.getVideoWidth();
    this.r = paramMediaPlayer.getVideoHeight();
    this.jdField_a_of_type_Long = paramMediaPlayer.getDuration();
    this.j = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.cameracapture.SplitEffectsCameraCaptureView", 2, "#MediaPlayer# onPrepared(): mSourceVideoWidth=" + this.q + ",mSourceVideoHeight=" + this.r + ", mSourceVideoDuration=" + this.jdField_a_of_type_Long);
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    super.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    if (this.k)
    {
      this.o = (this.jdField_a_of_type_Int / 2);
      return;
    }
    this.o = this.jdField_a_of_type_Int;
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    if (this.k)
    {
      this.p = GlUtil.a(36197);
      this.jdField_b_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.p);
      this.jdField_b_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
      if (this.l)
      {
        this.l = false;
        setSourceVideoPath(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void setCaptureListener(CameraCaptureView.CaptureListener paramCaptureListener)
  {
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener = paramCaptureListener;
  }
  
  public void setEventListener(SplitEffectsCameraCaptureView.EventListener paramEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView$EventListener = paramEventListener;
  }
  
  public void setSourceVideoPath(String paramString)
  {
    if (!this.k) {}
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(paramString))
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.pubaccount.video.cameracapture.SplitEffectsCameraCaptureView", 2, "videoLocalPath should not be empty,just return.");
        return;
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      if (this.jdField_b_of_type_AndroidGraphicsSurfaceTexture == null)
      {
        this.l = true;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.pubaccount.video.cameracapture.SplitEffectsCameraCaptureView", 2, "setSourceVideoPath mPlayerSurfaceTexture == null, make mSetVideoLocalPathPending true.");
        return;
      }
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setSurface(new Surface(this.jdField_b_of_type_AndroidGraphicsSurfaceTexture));
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(false);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.pubaccount.video.cameracapture.SplitEffectsCameraCaptureView", 2, "setSourceVideoPath(): prepare MediaPlayer. videoLocalPath=" + paramString);
        return;
      }
      catch (IOException paramString)
      {
        throw new RuntimeException("Could not open input video!");
      }
    }
  }
  
  public void setSplitEnable(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.SplitEffectsCameraCaptureView
 * JD-Core Version:    0.7.0.1
 */