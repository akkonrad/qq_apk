package com.tencent.mobileqq.apollo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import mqq.os.MqqHandler;
import ynh;
import yni;
import ynj;
import ynl;
import ynm;
import ynn;
import ynp;
import ynq;
import yns;

@TargetApi(14)
public class GLTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  public static final int DEBUG_CHECK_GL_ERROR = 1;
  public static final int DEBUG_LOG_GL_CALLS = 2;
  private static final boolean LOG_ATTACH_DETACH = false;
  private static final boolean LOG_EGL = false;
  private static final boolean LOG_PAUSE_RESUME = false;
  private static final boolean LOG_RENDERER = false;
  private static final boolean LOG_RENDERER_DRAW_FRAME = false;
  private static final boolean LOG_SURFACE = false;
  private static final boolean LOG_THREADS = false;
  public static final int RENDERMODE_CONTINUOUSLY = 1;
  public static final int RENDERMODE_WHEN_DIRTY = 0;
  private static final String TAG = "GLTextureView";
  private static int sGLESVersion;
  private static final ynq sGLThreadManager = new ynq(null);
  private static int sThreadName;
  private int mDebugFlags;
  private boolean mDetached;
  private GLTextureView.EGLConfigChooser mEGLConfigChooser;
  private int mEGLContextClientVersion;
  private GLTextureView.EGLContextFactory mEGLContextFactory;
  private GLTextureView.EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
  private Runnable mForceSetAlphaTask = new yni(this);
  protected ynp mGLThread;
  private GLTextureView.GLWrapper mGLWrapper;
  private boolean mPreserveEGLContextOnPause;
  private GLSurfaceView.Renderer mRenderer;
  private boolean mSurfaceHadDraw;
  int mSurfaceHeight = 0;
  private boolean mSurfaceTextureAvailable;
  int mSurfaceWidth = 0;
  private final WeakReference mThisWeakRef = new WeakReference(this);
  
  public GLTextureView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public GLTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void checkRenderThreadState()
  {
    if (this.mGLThread != null) {
      throw new IllegalStateException("setRenderer has already been called for this instance.");
    }
  }
  
  @SuppressLint({"UseValueOf"})
  public static Integer getInt(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (Integer)paramContext.getMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(paramContext, new Object[] { new String(paramString), new Integer(paramInt) });
      return paramContext;
    }
    catch (IllegalArgumentException paramContext)
    {
      throw paramContext;
    }
    catch (Exception paramContext) {}
    return Integer.valueOf(paramInt);
  }
  
  @TargetApi(14)
  private float getViewAlpha()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return getAlpha();
    }
    return 1.0F;
  }
  
  private void init()
  {
    sGLESVersion = getInt(getContext(), "ro.opengles.version", 0).intValue();
    setSurfaceTextureListener(this);
    addOnLayoutChangeListener(new ynh(this));
    setViewAlpha(0.0F);
  }
  
  @TargetApi(14)
  private void setViewAlpha(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      setAlpha(paramFloat);
    }
  }
  
  public void checkSetAlpha()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, "TextureView mSurfaceHadDraw:" + this.mSurfaceHadDraw + ",alpha:" + getViewAlpha());
    }
    if ((this.mSurfaceTextureAvailable) && (this.mSurfaceHadDraw))
    {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        ThreadManager.getUIHandler().post(new ynj(this));
      }
    }
    else {
      return;
    }
    setViewAlpha(1.0F);
  }
  
  protected void finalize()
  {
    try
    {
      if (this.mGLThread != null) {
        this.mGLThread.f();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getDebugFlags()
  {
    return this.mDebugFlags;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.mPreserveEGLContextOnPause;
  }
  
  public int getRenderMode()
  {
    return this.mGLThread.a();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.mDetached) && (this.mRenderer != null)) {
      if (this.mGLThread == null) {
        break label74;
      }
    }
    label74:
    for (int i = this.mGLThread.a();; i = 1)
    {
      this.mGLThread = new ynp(this.mThisWeakRef);
      if (i != 1) {
        this.mGLThread.a(i);
      }
      this.mGLThread.start();
      this.mDetached = false;
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.mGLThread != null) {
      this.mGLThread.f();
    }
    this.mDetached = true;
    super.onDetachedFromWindow();
  }
  
  public void onPause()
  {
    this.mGLThread.d();
  }
  
  public void onResume()
  {
    this.mGLThread.e();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.mSurfaceTextureAvailable = true;
    this.mSurfaceHadDraw = false;
    this.mSurfaceWidth = 0;
    this.mSurfaceHeight = 0;
    Log.d("GLTextureView", "onSurfaceTextureAvailable");
    long l = System.currentTimeMillis();
    surfaceCreated(paramSurfaceTexture);
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, " TextureView onSurfaceTextureAvailable surfaceCreated use:" + (System.currentTimeMillis() - l));
    }
    surfaceChanged(paramSurfaceTexture, 0, paramInt1, paramInt2);
    removeCallbacks(this.mForceSetAlphaTask);
    postDelayed(this.mForceSetAlphaTask, 250L);
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, " TextureView onSurfaceTextureAvailable surfaceChanged use:" + (System.currentTimeMillis() - l));
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.mSurfaceTextureAvailable = false;
    this.mSurfaceHadDraw = false;
    Log.d("GLTextureView", "onSurfaceTextureDestroyed");
    surfaceDestroyed(paramSurfaceTexture);
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, " TextureView onSurfaceTextureDestroyed");
    }
    removeCallbacks(this.mForceSetAlphaTask);
    setViewAlpha(0.0F);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    Log.d("GLTextureView", "onSurfaceTextureSizeChanged");
    surfaceChanged(paramSurfaceTexture, 0, paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, " TextureView onSurfaceTextureSizeChanged surfaceChanged use:" + (System.currentTimeMillis() - l));
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void queueEvent(Runnable paramRunnable)
  {
    this.mGLThread.a(paramRunnable);
  }
  
  public void requestRender()
  {
    this.mGLThread.a();
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.mDebugFlags = paramInt;
  }
  
  public void setEGLConfigChooser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    setEGLConfigChooser(new ynl(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }
  
  public void setEGLConfigChooser(GLTextureView.EGLConfigChooser paramEGLConfigChooser)
  {
    checkRenderThreadState();
    this.mEGLConfigChooser = paramEGLConfigChooser;
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    setEGLConfigChooser(new yns(this, paramBoolean));
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    checkRenderThreadState();
    this.mEGLContextClientVersion = paramInt;
  }
  
  public void setEGLContextFactory(GLTextureView.EGLContextFactory paramEGLContextFactory)
  {
    checkRenderThreadState();
    this.mEGLContextFactory = paramEGLContextFactory;
  }
  
  public void setEGLWindowSurfaceFactory(GLTextureView.EGLWindowSurfaceFactory paramEGLWindowSurfaceFactory)
  {
    checkRenderThreadState();
    this.mEGLWindowSurfaceFactory = paramEGLWindowSurfaceFactory;
  }
  
  public void setGLWrapper(GLTextureView.GLWrapper paramGLWrapper)
  {
    this.mGLWrapper = paramGLWrapper;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.mPreserveEGLContextOnPause = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mGLThread.a(paramInt);
  }
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    checkRenderThreadState();
    if (this.mEGLConfigChooser == null) {
      this.mEGLConfigChooser = new yns(this, true);
    }
    if (this.mEGLContextFactory == null) {
      this.mEGLContextFactory = new ynm(this, null);
    }
    if (this.mEGLWindowSurfaceFactory == null) {
      this.mEGLWindowSurfaceFactory = new ynn(null);
    }
    this.mRenderer = paramRenderer;
    this.mGLThread = new ynp(this.mThisWeakRef);
    this.mGLThread.start();
  }
  
  public void surfaceChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis();
    if ((this.mSurfaceWidth != paramInt2) || (this.mSurfaceHeight != paramInt3))
    {
      this.mSurfaceWidth = paramInt2;
      this.mSurfaceHeight = paramInt3;
      this.mSurfaceHadDraw = false;
      this.mGLThread.a(paramInt2, paramInt3);
      if (QLog.isColorLevel()) {
        QLog.d("GLTextureView", 2, " surfaceChanged, onWindowResize");
      }
    }
    checkSetAlpha();
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, " surfaceChanged, w:" + paramInt2 + ",h:" + paramInt3 + " use:" + (System.currentTimeMillis() - l));
    }
  }
  
  public void surfaceCreated(SurfaceTexture paramSurfaceTexture)
  {
    this.mGLThread.b();
  }
  
  public void surfaceDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.mGLThread.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.GLTextureView
 * JD-Core Version:    0.7.0.1
 */