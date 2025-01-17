package com.tencent.token.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.token.global.e;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class RealNameTakeIDPhotoPreview
  extends SurfaceView
  implements Camera.AutoFocusCallback, SurfaceHolder.Callback
{
  public Camera a;
  private SurfaceHolder b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private Timer i;
  private TimerTask j;
  private Handler k;
  
  public RealNameTakeIDPhotoPreview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.g = paramContext.widthPixels;
    this.h = paramContext.heightPixels;
    if (this.g < this.h)
    {
      this.g = paramContext.heightPixels;
      this.h = paramContext.widthPixels;
    }
    e.b("screenWidth =" + this.g + ",screenHeight=" + this.h);
  }
  
  private static String a(Collection paramCollection, String... paramVarArgs)
  {
    int m;
    String str;
    if (paramCollection != null)
    {
      int n = paramVarArgs.length;
      m = 0;
      if (m < n)
      {
        str = paramVarArgs[m];
        if (!paramCollection.contains(str)) {}
      }
    }
    for (paramCollection = str;; paramCollection = null)
    {
      e.b("resolution Settable value: " + paramCollection);
      return paramCollection;
      m += 1;
      break;
    }
  }
  
  private static void a(Camera paramCamera, int paramInt)
  {
    try
    {
      Method localMethod = paramCamera.getClass().getMethod("setDisplayOrientation", new Class[] { Integer.TYPE });
      if (localMethod != null) {
        localMethod.invoke(paramCamera, new Object[] { Integer.valueOf(paramInt) });
      }
      return;
    }
    catch (Exception paramCamera) {}
  }
  
  private void a(List paramList)
  {
    this.c = ((Camera.Size)paramList.get(0)).width;
    this.e = ((Camera.Size)paramList.get(0)).height;
    int m = 1;
    while (m < paramList.size())
    {
      if (Math.abs(this.c / this.e - this.g / this.h) > Math.abs(((Camera.Size)paramList.get(m)).width / ((Camera.Size)paramList.get(m)).height - this.g / this.h))
      {
        this.c = ((Camera.Size)paramList.get(m)).width;
        this.e = ((Camera.Size)paramList.get(m)).height;
      }
      m += 1;
    }
    e.c("debug------------bestPreviewWidth=" + this.c + ",bestPreviewHeight=" + this.e + ", screenWidth=" + this.g + ",screenHeight=" + this.h);
  }
  
  private void b(List paramList)
  {
    this.d = ((Camera.Size)paramList.get(0)).width;
    this.f = ((Camera.Size)paramList.get(0)).height;
    int m = 1;
    while (m < paramList.size())
    {
      double d1 = Math.abs(this.d / this.f - this.g / this.h);
      double d2 = Math.abs(((Camera.Size)paramList.get(m)).width / ((Camera.Size)paramList.get(m)).height - this.g / this.h);
      if (d1 > d2)
      {
        this.d = ((Camera.Size)paramList.get(m)).width;
        this.f = ((Camera.Size)paramList.get(m)).height;
        if ((d1 == d2) && (this.d < ((Camera.Size)paramList.get(m)).width))
        {
          this.d = ((Camera.Size)paramList.get(m)).width;
          this.f = ((Camera.Size)paramList.get(m)).height;
        }
      }
      m += 1;
    }
    e.c("debug------------mPictureWidth=" + this.d + ",mPictureHeight=" + this.f);
  }
  
  public final void a()
  {
    if (this.a != null)
    {
      this.a.setPreviewCallback(null);
      this.a.stopPreview();
      this.a.release();
      this.a = null;
    }
    if (this.i != null)
    {
      this.i.cancel();
      this.i = null;
    }
    if (this.j != null)
    {
      this.j.cancel();
      this.j = null;
    }
  }
  
  public final void a(Context paramContext, Handler paramHandler)
  {
    this.k = paramHandler;
    paramHandler = new Camera.CameraInfo();
    int n = Camera.getNumberOfCameras();
    int m = 0;
    for (;;)
    {
      if (m < n)
      {
        Camera.getCameraInfo(m, paramHandler);
        if (paramHandler.facing == 0) {}
        try
        {
          this.a = Camera.open(m);
          m += 1;
        }
        catch (RuntimeException localRuntimeException)
        {
          for (;;)
          {
            e.c("CameraOpen camera=" + this.a);
            localRuntimeException.printStackTrace();
          }
        }
      }
    }
    if (this.a == null)
    {
      e.c("CameraOpen camera=" + this.a);
      paramHandler = this.k.obtainMessage(0);
      paramHandler.what = 2;
      paramHandler.sendToTarget();
    }
    this.b = getHolder();
    this.b.addCallback(this);
    this.b.setType(3);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.g = paramContext.widthPixels;
    this.h = paramContext.heightPixels;
    if (this.g < this.h)
    {
      this.g = paramContext.heightPixels;
      this.h = paramContext.widthPixels;
    }
    e.b("screenWidth =" + this.g + ",screenHeight=" + this.h);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    int m = 0;
    if (this.b.getSurface() == null) {}
    for (;;)
    {
      return;
      try
      {
        this.a.stopPreview();
        e.b("width =" + paramInt2 + ",height=" + paramInt3);
        if (this.a == null) {
          continue;
        }
      }
      catch (Exception paramSurfaceHolder)
      {
        try
        {
          Object localObject1;
          for (;;)
          {
            paramSurfaceHolder = this.a.getParameters();
            paramSurfaceHolder.setPictureFormat(256);
            localObject1 = this.a.getParameters().getSupportedPictureSizes();
            if (localObject1 == null) {
              break;
            }
            paramInt1 = 0;
            while (paramInt1 < ((List)localObject1).size())
            {
              localObject2 = (Camera.Size)((List)localObject1).get(paramInt1);
              e.b("picSizes,width: " + ((Camera.Size)localObject2).width + " height" + ((Camera.Size)localObject2).height);
              paramInt1 += 1;
            }
            paramSurfaceHolder = paramSurfaceHolder;
            paramSurfaceHolder.printStackTrace();
          }
          Object localObject2 = this.a.getParameters().getSupportedPreviewSizes();
          if (localObject2 != null)
          {
            paramInt1 = m;
            while (paramInt1 < ((List)localObject2).size())
            {
              Camera.Size localSize = (Camera.Size)((List)localObject2).get(paramInt1);
              e.b("presize,width: " + localSize.width + " height" + localSize.height);
              paramInt1 += 1;
            }
          }
          if (getResources().getConfiguration().orientation != 2)
          {
            a(this.a, 90);
            label293:
            a((List)localObject2);
            b((List)localObject1);
            paramSurfaceHolder.setPreviewSize(this.c, this.e);
            paramSurfaceHolder.setPictureSize(this.d, this.f);
            e.c("mPreviewWidth!" + this.c);
            e.c("mPreviewHeight!" + this.e);
            e.c("mPictureWidth!" + this.d);
            e.c("mPictureHeight!" + this.f);
            localObject1 = a(paramSurfaceHolder.getSupportedFocusModes(), new String[] { "continuous-video" });
            if (localObject1 == null) {
              break label569;
            }
            paramSurfaceHolder.setFocusMode((String)localObject1);
          }
          for (;;)
          {
            this.a.setParameters(paramSurfaceHolder);
            this.a.startPreview();
            if ((!this.a.getParameters().getFocusMode().equals("auto")) && (!this.a.getParameters().getFocusMode().equals("macro"))) {
              break;
            }
            this.i = new Timer(false);
            this.j = new yk(this);
            this.i.schedule(this.j, 500L, 2000L);
            return;
            a(this.a, 0);
            break label293;
            label569:
            localObject1 = a(paramSurfaceHolder.getSupportedFocusModes(), new String[] { "auto" });
            if (localObject1 != null) {
              paramSurfaceHolder.setFocusMode((String)localObject1);
            }
          }
          return;
        }
        catch (Exception paramSurfaceHolder) {}
      }
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      this.a.setPreviewDisplay(this.b);
      this.a.startPreview();
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      do
      {
        paramSurfaceHolder.printStackTrace();
      } while (this.a == null);
      this.a.release();
      this.a = null;
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    e.c("surfaceDestroyed!");
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameTakeIDPhotoPreview
 * JD-Core Version:    0.7.0.1
 */