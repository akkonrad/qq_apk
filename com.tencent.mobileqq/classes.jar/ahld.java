import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class ahld
  implements GLSurfaceView.EGLContextFactory
{
  private int jdField_a_of_type_Int = 12440;
  
  public ahld(CameraCaptureView paramCameraCaptureView) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int i = this.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 1, "createContext. display = " + paramEGLDisplay + " tid = " + Thread.currentThread().getId());
    }
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.o();
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext)) {
      QLog.e("CameraCaptureView", 1, "destroyContext. display = " + paramEGLDisplay + " context = " + paramEGLContext + " tid = " + Thread.currentThread().getId());
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 1, "destroyContext. display = " + paramEGLDisplay + " context = " + paramEGLContext + " tid = " + Thread.currentThread().getId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahld
 * JD-Core Version:    0.7.0.1
 */