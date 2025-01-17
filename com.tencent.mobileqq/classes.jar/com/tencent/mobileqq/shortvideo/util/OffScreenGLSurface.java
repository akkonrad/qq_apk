package com.tencent.mobileqq.shortvideo.util;

import aidr;
import aids;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import com.tencent.mobileqq.activity.richmedia.view.GLSurfaceUtil;
import com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext.VFrameData;
import com.tencent.mobileqq.shortvideo.ptvfilter.test.PerformenceDataTag;
import com.tencent.mobileqq.shortvideo.ptvfilter.test.SVFilterPreprocessFpsTest;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class OffScreenGLSurface
  implements Handler.Callback
{
  private static boolean jdField_a_of_type_Boolean = CameraCompatibleList.c(CameraCompatibleList.z);
  private int jdField_a_of_type_Int;
  private aids jdField_a_of_type_Aids = new aids(null);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  GLVideoClipUtil jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLVideoClipUtil;
  private PreviewContext jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
  public OffScreenGLSurface.GLSharedData a;
  OffScreenInputSurface jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface;
  PtvFilterOpenglFrameBuffer jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private int jdField_b_of_type_Int;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 270;
  private volatile boolean jdField_e_of_type_Boolean;
  private boolean f = true;
  private boolean g;
  private boolean h;
  private boolean i;
  
  public OffScreenGLSurface()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface$GLSharedData = new OffScreenGLSurface.GLSharedData();
    f();
    this.jdField_a_of_type_AndroidOsHandlerThread = null;
    this.jdField_b_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLVideoClipUtil = new GLVideoClipUtil();
  }
  
  private TextureDataPipe a()
  {
    TextureDataPipe localTextureDataPipe = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface$GLSharedData.a.b();
    if (localTextureDataPipe != null) {
      return localTextureDataPipe;
    }
    localTextureDataPipe = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface$GLSharedData.a.a();
    if (localTextureDataPipe != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer.a(localTextureDataPipe.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      return localTextureDataPipe;
    }
    return null;
  }
  
  private void a(AVIOStruct paramAVIOStruct)
  {
    this.jdField_a_of_type_Aids.jdField_a_of_type_Int = paramAVIOStruct.pFrameIndex;
    paramAVIOStruct.pFrameIndex = 0;
    this.jdField_a_of_type_Aids.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Aids.jdField_b_of_type_Int = 0;
    GLSurfaceUtil.a("handleMessage:writeVideoFrame[false]  mThumbPicControl.mSendThumbOKIndex=" + this.jdField_a_of_type_Aids.jdField_a_of_type_Int);
  }
  
  private boolean a()
  {
    boolean bool2 = true;
    bool1 = false;
    synchronized (OffScreenGLSurface.GLSharedData.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface$GLSharedData))
    {
      Object localObject2 = OffScreenGLSurface.GLSharedData.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface$GLSharedData);
      if (localObject2 == null) {
        return false;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface != null) && ((this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.b()) || (!this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.a((EGLContext)localObject2))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OffScreenGLSurface", 2, "initInputSurface[releasePBufferAndFrameBuffer]1 glContextH=" + OffScreenInputSurface.a((EGLContext)localObject2));
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.b()) && (QLog.isColorLevel())) {
          QLog.d("OffScreenGLSurface", 2, "initInputSurface[releasePBufferAndFrameBuffer]2 mSharedDataContextH=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.a());
        }
        h();
      }
      OffScreenInputSurface localOffScreenInputSurface = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface;
      if (localOffScreenInputSurface == null) {}
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface = new OffScreenInputSurface(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, (EGLContext)localObject2);
        bool1 = bool2;
      }
      catch (OffScreenInputSurface.EGLCreateContextException localEGLCreateContextException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OffScreenGLSurface", 2, "createInputSurface[EGLCreateContextException]exp=", localEGLCreateContextException);
          }
          PerformenceDataTag.a(1);
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface = null;
          bool1 = false;
          continue;
        }
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface;
      if (localObject2 != null)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.c();
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.a()) {
            break label299;
          }
          throw new RuntimeException("checkEGL failed");
        }
        catch (OffScreenInputSurface.EGLMakeCurrentException localEGLMakeCurrentException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OffScreenGLSurface", 2, "createInputSurface[EGLMakeCurrentException]exp=", localEGLMakeCurrentException);
          }
          PerformenceDataTag.a(2);
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.b();
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface = null;
        }
        return bool1;
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLVideoClipUtil.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLVideoClipUtil.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void f()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.h = false;
    this.i = false;
  }
  
  private void g()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLVideoClipUtil.a(this.jdField_d_of_type_Boolean);
    int j = GLES20.glGetError();
    if (j != 0) {
      GLSurfaceUtil.a("glDrawFrame:err=" + j);
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer = null;
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface = null;
  }
  
  public Handler a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread != null) && (this.jdField_b_of_type_AndroidOsHandler != null)) {
      return this.jdField_b_of_type_AndroidOsHandler;
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("glProcess");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_b_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler = this.jdField_b_of_type_AndroidOsHandler;
    }
  }
  
  public void a(int paramInt1, int paramInt2, RMVideoClipSpec paramRMVideoClipSpec)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_a_of_type_Int = paramRMVideoClipSpec.jdField_c_of_type_Int;
    this.jdField_b_of_type_Int = paramRMVideoClipSpec.jdField_d_of_type_Int;
    com.tencent.ttpic.config.MediaConfig.VIDEO_OUTPUT_WIDTH = this.jdField_a_of_type_Int;
    com.tencent.ttpic.config.MediaConfig.VIDEO_OUTPUT_HEIGHT = this.jdField_b_of_type_Int;
    com.tencent.ttpic.config.MediaConfig.VIDEO_IMAGE_WIDTH = this.jdField_a_of_type_Int;
    com.tencent.ttpic.config.MediaConfig.VIDEO_IMAGE_HEIGHT = this.jdField_b_of_type_Int;
    this.jdField_e_of_type_Int = CameraControl.a().b();
    if (this.jdField_e_of_type_Int == 270) {}
    for (this.f = false;; this.f = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OffScreenGLSurface", 2, "setPreviewSize: backCamera=" + this.f + " mVideoClipDegree=" + this.jdField_e_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLVideoClipUtil.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.f);
      this.jdField_e_of_type_Boolean = true;
      return;
    }
  }
  
  public void a(PreviewContext paramPreviewContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = paramPreviewContext;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mPTVRealBeauty = true;
      if (this.jdField_b_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler = this.jdField_b_of_type_AndroidOsHandler;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface != null)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer = new PtvFilterOpenglFrameBuffer();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer.a(false, false);
        d();
      }
      SVFilterPreprocessFpsTest.b();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer = null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler = null;
      }
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      PtvFilterUtils.a(this.jdField_a_of_type_AndroidOsHandlerThread);
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      this.jdField_b_of_type_AndroidOsHandler = null;
    }
  }
  
  public void c()
  {
    b(false);
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLVideoClipUtil.a()) {
      this.jdField_b_of_type_Boolean = false;
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void e()
  {
    GLES20.glClear(16384);
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean)) {
      g();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = null;
    boolean bool2 = false;
    if (paramMessage.what == -16716524)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OffScreenGLSurface", 2, "handleMessage SETPREVIEW=" + paramMessage.arg1 + "*" + paramMessage.arg2);
      }
      a(paramMessage.arg1, paramMessage.arg2, (RMVideoClipSpec)paramMessage.obj);
      this.h = true;
      if (this.i) {
        a(a());
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          if (paramMessage.what != -16716523) {
            break;
          }
          this.i = true;
          if (this.h) {
            a(a());
          }
        } while (!QLog.isColorLevel());
        QLog.d("OffScreenGLSurface", 2, "[FILE_CACHE_OPENGL_RANDER_DATA_INIT]");
        return true;
        if (paramMessage.what != -16716522) {
          break;
        }
        f();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface$GLSharedData.a();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface$GLSharedData.a = null;
        this.jdField_a_of_type_Aids.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_Aids.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Aids.jdField_a_of_type_Int = -1;
        h();
      } while (!QLog.isColorLevel());
      QLog.d("OffScreenGLSurface", 2, "[FILE_CACHE_OPENGL_RANDER_DATA_FINISH]");
      return true;
    } while (paramMessage.what != -16716526);
    if (QLog.isColorLevel()) {
      QLog.d("OffScreenGLSurface", 2, "[CAMERA_OPENGL_RANDER_DATA]");
    }
    int j = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (j != 0)
    {
      GLSurfaceUtil.a("handleMessage:[RenderModeCheck-Recorder][May Lost Frame] mode=" + j);
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer != null) {
      SVFilterPreprocessFpsTest.a(PtvFilterUtils.a() / 1000L);
    }
    boolean bool1;
    if (paramMessage.obj != null)
    {
      if (paramMessage.arg1 == 0) {
        localObject = (byte[])paramMessage.obj;
      }
      for (;;)
      {
        l1 = PtvFilterUtils.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLVideoClipUtil.a((byte[])localObject);
        l1 = (PtvFilterUtils.a() - l1) / 1000L;
        GLSurfaceUtil.a("handleMessage:[copyDataToByteBuffer] steptime=" + l1 + " us");
        SVFilterPreprocessFpsTest.d(l1);
        if ((paramMessage.arg2 == 1) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.addUserBufferRecycle((byte[])localObject);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer == null) {
          break label1143;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface$GLSharedData.a != null) {
          break;
        }
        GLSurfaceUtil.a("handleMessage:[RenderModeCheck-Recorder][May Lost Frame] mode=" + j);
        return true;
        if (paramMessage.arg1 == 1) {
          localObject = ((PreviewContext.VFrameData)paramMessage.obj).jdField_a_of_type_ArrayOfByte;
        }
      }
      long l1 = PtvFilterUtils.a();
      TextureDataPipe localTextureDataPipe = a();
      if (localTextureDataPipe != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer.a(localTextureDataPipe.jdField_a_of_type_Int);
        GLSurfaceUtil.a("handleMessage:[CAMERA_OPENGL_RANDER_DATA] bindTextureId=" + localTextureDataPipe.jdField_a_of_type_Int);
        GLSurfaceUtil.a("handleMessage:[CAMERA_OPENGL_RANDER_DATA] Begin drawFrame mWidth=" + this.jdField_a_of_type_Int + " mHeight=" + this.jdField_b_of_type_Int);
        e();
        GLSurfaceUtil.a("handleMessage:[CAMERA_OPENGL_RANDER_DATA] End drawFrame");
        if (!jdField_a_of_type_Boolean) {}
        AVIOStruct localAVIOStruct;
        for (bool1 = true;; bool1 = false)
        {
          PtvFilterUtils.a(bool1);
          GLSurfaceUtil.a("handleMessage:[CAMERA_OPENGL_RANDER_DATA] glSyncCommand OK: sNeedSyncUseFlush=" + jdField_a_of_type_Boolean);
          if (paramMessage.arg1 != 1) {
            break label1126;
          }
          localAVIOStruct = ((PreviewContext.VFrameData)paramMessage.obj).jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct;
          if (localAVIOStruct != null) {
            break;
          }
          throw new RuntimeException("OffScreenGLSurface:msg.arg1=" + paramMessage.arg1 + " frame=null");
        }
        localObject = localAVIOStruct;
        if (localAVIOStruct.pFrameIndex == 0)
        {
          this.jdField_a_of_type_Aids.jdField_a_of_type_Boolean = true;
          localObject = localAVIOStruct;
        }
        label713:
        long l2 = SystemClock.elapsedRealtime();
        ((AVIOStruct)localObject).vFrameTime = l2;
        j = paramMessage.arg1;
        if (this.f) {
          break label1138;
        }
        bool1 = true;
        label739:
        localTextureDataPipe.a(j, localObject, bool1);
        localTextureDataPipe.e();
        bool1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface$GLSharedData.a.a();
        GLSurfaceUtil.a("handleMessage:writeVideoFrame  mNewSession=" + this.jdField_a_of_type_Aids.jdField_a_of_type_Boolean + "  Make data ready: frameIndex= " + ((AVIOStruct)localObject).pFrameIndex + "  hasRenaderFrame=" + bool1);
        if (!bool1)
        {
          if (this.jdField_a_of_type_Aids.jdField_a_of_type_Boolean) {
            a((AVIOStruct)localObject);
          }
          localTextureDataPipe.a();
        }
        GLSurfaceUtil.a("handleMessage:writeVideoFrame frameBufferTime=" + l2 + "  sNeedSyncUseFlush=" + jdField_a_of_type_Boolean);
      }
      l1 = (PtvFilterUtils.a() - l1) / 1000L;
      SVFilterPreprocessFpsTest.c(l1);
      paramMessage = new StringBuilder().append("handleMessage:writeVideoFrame[Draw] steptime=").append(l1).append("  currentPipe=");
      bool1 = bool2;
      if (localTextureDataPipe != null) {
        bool1 = true;
      }
      GLSurfaceUtil.a(bool1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OffScreenGLSurface", 2, "[CAMERA_OPENGL_RANDER_DATA]videoContext=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
      }
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)) {
        QLog.d("OffScreenGLSurface", 2, "[CAMERA_OPENGL_RANDER_DATA]videoContext.notifyFirstFrame=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) && (QLog.isColorLevel()))
      {
        if ((this.g) && (!this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame)) {
          QLog.d("OffScreenGLSurface", 2, "this log is for qzonetest : the camera create successful!");
        }
        this.g = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame)) {
        this.jdField_a_of_type_AndroidOsHandler.post(new aidr(this));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterOpenglFrameBuffer == null) {
        break;
      }
      SVFilterPreprocessFpsTest.b(PtvFilterUtils.a() / 1000L);
      SVFilterPreprocessFpsTest.a();
      return true;
      label1126:
      localObject = new AVIOStruct();
      break label713;
      label1138:
      bool1 = false;
      break label739;
      label1143:
      GLSurfaceUtil.a("handleMessage:byteBufferProcessFrame  framebuffer=null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.OffScreenGLSurface
 * JD-Core Version:    0.7.0.1
 */