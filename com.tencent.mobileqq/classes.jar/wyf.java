import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.video.IMediaPlayer;
import com.tencent.qphone.base.util.QLog;

public class wyf
  implements SurfaceHolder.Callback
{
  public wyf(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "surfaceCreated ");
    }
    if ((this.a.q == 1) && (this.a.p > 0))
    {
      this.a.a(this.a.p);
      this.a.p = 0;
      this.a.q = 0;
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "surfaceDestroyed ");
    }
    if (this.a.a != null) {
      this.a.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wyf
 * JD-Core Version:    0.7.0.1
 */