import android.view.SurfaceHolder;
import com.tencent.mobileqq.hotpic.VideoBaseItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;

public class adsf
  implements IVideoViewBase.IVideoViewCallBack
{
  public adsf(VideoBaseItem paramVideoBaseItem) {}
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder)
  {
    QLog.d("VideoBaseItem", 2, "key:" + this.a.b + ";broad finish start show here onsurface changed  here");
  }
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    QLog.d("VideoBaseItem", 2, "key:" + this.a.b + "; broad finish start show here onsurface create ok here");
  }
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    this.a.a = true;
    QLog.d("VideoBaseItem", 2, "key:" + this.a.b + "; broad finish start show here onsurface Destroy  here");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsf
 * JD-Core Version:    0.7.0.1
 */