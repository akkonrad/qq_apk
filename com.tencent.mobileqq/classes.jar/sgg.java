import android.opengl.GLSurfaceView.Renderer;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class sgg
  implements GLSurfaceView.Renderer
{
  public sgg(Conversation paramConversation) {}
  
  public void onDrawFrame(GL10 paramGL10) {}
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2) {}
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.a.a = paramGL10.glGetString(7937);
    if (this.a.a != null) {
      ThreadManager.post(new sgh(this), 5, null, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_GPU", 2, "onSurfaceCreated|GL_RENDERER= " + this.a.a);
    }
    this.a.a(new sgi(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sgg
 * JD-Core Version:    0.7.0.1
 */