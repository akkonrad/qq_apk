package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import ahod;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.Matrix;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;
import javax.microedition.khronos.egl.EGLContext;

public class FlowDecodeScreenSurface
  extends FlowDecodeScreenSurfaceBase
  implements SurfaceTexture.OnFrameAvailableListener, FlowDecodeSurface
{
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private FrameBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFrameBuffer;
  private TextureRender jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int c;
  
  FlowDecodeScreenSurface(EGLContext paramEGLContext, int paramInt1, int paramInt2)
  {
    super(paramEGLContext, paramInt1, paramInt2);
    c();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = new TextureRender();
    this.c = GlUtil.a(36197);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.c);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFrameBuffer = new FrameBuffer(paramInt1, paramInt2);
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
  }
  
  public Surface a()
  {
    return this.jdField_a_of_type_AndroidViewSurface;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(@NonNull ahod paramahod, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      for (;;)
      {
        paramBoolean = this.jdField_a_of_type_Boolean;
        if (!paramBoolean) {
          try
          {
            this.jdField_a_of_type_JavaLangObject.wait();
            if (!this.jdField_a_of_type_Boolean) {
              throw new RuntimeException("frame wait timed out");
            }
          }
          catch (InterruptedException paramahod)
          {
            throw new RuntimeException(paramahod);
          }
        }
      }
    }
    GlUtil.a("before updateTexImage");
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
    paramahod.jdField_a_of_type_ArrayOfFloat = ((float[])this.jdField_a_of_type_ArrayOfFloat.clone());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFrameBuffer.a(paramahod.a());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(36197, this.c, null, null);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFrameBuffer.a();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b()
  {
    SLog.b("FlowEdit_FlowDecodeScreenSurface", "awaitNewImage");
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    SLog.b("FlowEdit_FlowDecodeScreenSurface", "onFrameAvailable");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean) {
        SLog.d("FlowEdit_FlowDecodeScreenSurface", "mFrameAvailable already set, frame could be dropped");
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurface
 * JD-Core Version:    0.7.0.1
 */