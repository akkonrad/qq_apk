package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import ahod;
import ahol;
import ahom;
import ahon;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.os.Trace;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder;
import com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder.AudioDecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.IVideoDecoder;
import com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

@TargetApi(18)
public class NeoVideoFilterPlayView
  extends VideoFilterPlayView
{
  private ahod jdField_a_of_type_Ahod;
  private ahon jdField_a_of_type_Ahon;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private EditorEGLContextFactory jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowEditorEGLContextFactory;
  private NeoVideoFilterPlayView.PlayProgressListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$PlayProgressListener = new NeoVideoFilterPlayView.JustLogPlayProgressListener();
  private VideoFlowDecodeWrapper.FlowListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecodeWrapper$FlowListener;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  private boolean d;
  private int h = -1;
  private int i;
  
  public NeoVideoFilterPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NeoVideoFilterPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new HandlerThread("NeoVideoFilterPlayView");
    paramContext.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramContext.getLooper(), new ahol(this));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecodeWrapper$FlowListener = new ahom(this);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowEditorEGLContextFactory = new EditorEGLContextFactory();
      setEGLContextFactory(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowEditorEGLContextFactory);
      super.a();
      StoryReportor.b("video_edit", "flow_view_create", 0, 0, new String[] { Build.MANUFACTURER, Build.MODEL, String.valueOf(Build.VERSION.SDK_INT) });
    }
    SLog.d("FlowEdit_NeoVideoFilterPlayView", "Model=%s, Manufacture=%s, SDK=%d", new Object[] { Build.MODEL, Build.MANUFACTURER, Integer.valueOf(Build.VERSION.SDK_INT) });
  }
  
  private void a(GL10 paramGL10)
  {
    Object localObject = (VideoFlowDecodeWrapper)this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderIVideoDecoder;
    paramGL10 = ((VideoFlowDecodeWrapper)localObject).b();
    ahod localahod = ((VideoFlowDecodeWrapper)localObject).c();
    int m;
    int j;
    int n;
    int k;
    if (paramGL10 != null)
    {
      if ((Math.abs(paramGL10.a()) > this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.b * 1000L) || (Math.abs(paramGL10.a()) < this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_Long)) {
        SLog.d("FlowEdit_NeoVideoFilterPlayView", "find invalid frame : %s us, current config start - end : [%d - %d] ms", new Object[] { paramGL10, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_Long), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.b) });
      }
      m = 0;
      if ((this.jdField_a_of_type_Ahon == null) || (paramGL10.b() != ahon.a(this.jdField_a_of_type_Ahon)))
      {
        m = 1;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$PlayProgressListener.a();
      }
      j = a();
      n = 0;
      if ((this.h == -1) || (this.h != j))
      {
        n = 1;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$PlayProgressListener.a(this.h, j);
      }
      this.h = j;
      if (a() == 1)
      {
        j = 2;
        k = 1;
      }
    }
    for (;;)
    {
      label201:
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)) || (this.jdField_a_of_type_Ahon == null) || (m != 0) || (n != 0))
      {
        this.jdField_a_of_type_Ahon = new ahon(SystemClock.uptimeMillis(), paramGL10.a(), paramGL10.b(), null);
        SLog.c("FlowEdit_NeoVideoFilterPlayView", "start render : " + this.jdField_a_of_type_Ahon);
      }
      long l2 = SystemClock.uptimeMillis();
      long l3 = ahon.a(this.jdField_a_of_type_Ahon) + (paramGL10.a() - ahon.b(this.jdField_a_of_type_Ahon)) * k / (j * 1000);
      long l1;
      if ((localahod != null) && (localahod.b() == paramGL10.b()))
      {
        l1 = ahon.a(this.jdField_a_of_type_Ahon) + (localahod.a() - ahon.b(this.jdField_a_of_type_Ahon)) * k / (j * 1000);
        label367:
        if (l2 >= l3 - 5L) {
          break label548;
        }
        paramGL10 = this.jdField_a_of_type_Ahod;
        l1 = l3 - l2;
        label391:
        if (paramGL10 != null)
        {
          Trace.beginSection("AVEditor:DrawFrameOnScreen");
          localObject = FilterUtil.a(this.b, this.c, this.b, this.c);
          a(paramGL10.a(), paramGL10.a, (float[])localObject);
          if ((this.jdField_a_of_type_Ahod != null) && (this.jdField_a_of_type_Ahod != paramGL10)) {
            this.jdField_a_of_type_Ahod.b();
          }
          this.jdField_a_of_type_Ahod = paramGL10;
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$PlayProgressListener.a(paramGL10.a());
          Trace.endSection();
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        if (l1 >= 0L) {
          if (l1 <= 5L) {
            break label681;
          }
        }
      }
      label548:
      label681:
      for (l1 -= 5L;; l1 = 0L)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, l1);
        return;
        if (a() != 2) {
          break label687;
        }
        j = 1;
        k = 2;
        break label201;
        l1 = 30L + l3;
        break label367;
        if (l2 < l1)
        {
          localObject = ((VideoFlowDecodeWrapper)localObject).a();
          l2 = l1 - l2;
          l1 = l2;
          paramGL10 = (GL10)localObject;
          if (this.i <= 0) {
            break label391;
          }
          SLog.a("FlowEdit_NeoVideoFilterPlayView", "drawFrameFlow : drop %d frames, decoder is slow", Integer.valueOf(this.i));
          this.i = 0;
          l1 = l2;
          paramGL10 = (GL10)localObject;
          break label391;
        }
        paramGL10 = ((VideoFlowDecodeWrapper)localObject).a();
        if (localahod != null)
        {
          if (paramGL10 != null) {
            paramGL10.b();
          }
          for (;;)
          {
            this.i += 1;
            break;
            SLog.d("FlowEdit_NeoVideoFilterPlayView", "drawFrameFlow : peekNextDecodedFrame != null, but pollNextDecodedFrame == null");
          }
        }
        l1 = 0L;
        break label391;
        SLog.b("FlowEdit_NeoVideoFilterPlayView", "drawFrameFlow : waiting ∞ ms ( no frame )");
        paramGL10 = null;
        l1 = -1L;
        break label391;
      }
      label687:
      j = 1;
      k = 1;
    }
  }
  
  protected IVideoDecoder a()
  {
    this.jdField_a_of_type_Boolean = Constants.b;
    SLog.d("FlowEdit_NeoVideoFilterPlayView", "NeoVideoFilterPlayView ENABLE = %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (this.jdField_a_of_type_Boolean) {
      return new VideoFlowDecodeWrapper();
    }
    return super.a();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    super.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      SLog.b("FlowEdit_NeoVideoFilterPlayView", "startPlay: ");
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_JavaLangString)) {
        throw new RuntimeException("startPlay failed. videoFilePath is empty.");
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderIVideoDecoder.a();
      EGLContext localEGLContext = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowEditorEGLContextFactory.a();
      if (localEGLContext != null)
      {
        FlowDecodeConfig localFlowDecodeConfig = new FlowDecodeConfig(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig);
        localFlowDecodeConfig.b = true;
        localFlowDecodeConfig.a = localEGLContext;
        localFlowDecodeConfig.c = 1;
        this.jdField_a_of_type_Ahon = null;
        ((VideoFlowDecodeWrapper)this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderIVideoDecoder).a(localFlowDecodeConfig, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecodeWrapper$FlowListener);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig);
        }
        return;
      }
      SLog.c("FlowEdit_NeoVideoFilterPlayView", "eglContext is null, ignore start play", new Throwable());
      return;
    }
    super.b();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      SLog.b("FlowEdit_NeoVideoFilterPlayView", "pausePlay: ");
      this.d = true;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.c();
      return;
    }
    super.c();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.d = false;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.d();
      return;
    }
    super.d();
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      a(this.jdField_a_of_type_JavaUtilLinkedList);
      a(paramGL10);
      return;
    }
    super.onDrawFrame(paramGL10);
  }
  
  public void setPlayListener(NeoVideoFilterPlayView.PlayProgressListener paramPlayProgressListener)
  {
    if (paramPlayProgressListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$PlayProgressListener = paramPlayProgressListener;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$PlayProgressListener = new NeoVideoFilterPlayView.JustLogPlayProgressListener();
  }
  
  public void setSpeedType(int paramInt)
  {
    int k = 0;
    int m = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_a_of_type_Int;
    super.setSpeedType(paramInt);
    if ((m == 3) && (paramInt != 3)) {}
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        j = k;
        if (m != 3)
        {
          j = k;
          if (paramInt != 3) {}
        }
      }
      else
      {
        j = 1;
      }
      if (j != 0) {
        f();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.NeoVideoFilterPlayView
 * JD-Core Version:    0.7.0.1
 */