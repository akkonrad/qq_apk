import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.view.player.VideoViewTVKImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import mqq.os.MqqHandler;

public class aeyr
  implements TVK_IMediaPlayer.OnCompletionListener
{
  public aeyr(VideoViewTVKImpl paramVideoViewTVKImpl) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoViewTVKImpl", 2, "onCompletion() called with: tvk_iMediaPlayer = [" + paramTVK_IMediaPlayer + "]");
    }
    ThreadManager.getUIHandler().post(new aeys(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeyr
 * JD-Core Version:    0.7.0.1
 */