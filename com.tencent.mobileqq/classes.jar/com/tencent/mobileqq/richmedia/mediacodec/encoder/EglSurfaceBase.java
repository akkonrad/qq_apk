package com.tencent.mobileqq.richmedia.mediacodec.encoder;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import com.tencent.qphone.base.util.QLog;

@TargetApi(17)
public class EglSurfaceBase
{
  private EGLSurface a;
  protected EglCore a;
  
  public EglSurfaceBase(EglCore paramEglCore)
  {
    this.jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.EGL_NO_SURFACE;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore = paramEglCore;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore.a(this.jdField_a_of_type_AndroidOpenglEGLSurface);
    this.jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.EGL_NO_SURFACE;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidOpenglEGLSurface != EGL14.EGL_NO_SURFACE) {
      throw new IllegalStateException("surface already created");
    }
    this.jdField_a_of_type_AndroidOpenglEGLSurface = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore.a(paramInt1, paramInt2);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore.a(this.jdField_a_of_type_AndroidOpenglEGLSurface, paramLong);
  }
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_AndroidOpenglEGLSurface != EGL14.EGL_NO_SURFACE) {
      throw new IllegalStateException("surface already created");
    }
    this.jdField_a_of_type_AndroidOpenglEGLSurface = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore.a(paramObject);
  }
  
  public boolean a()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore.a(this.jdField_a_of_type_AndroidOpenglEGLSurface);
    if ((!bool) && (QLog.isColorLevel())) {
      QLog.d("EglSurfaceBase", 2, "WARNING: swapBuffers() failed");
    }
    return bool;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore.b(this.jdField_a_of_type_AndroidOpenglEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.encoder.EglSurfaceBase
 * JD-Core Version:    0.7.0.1
 */