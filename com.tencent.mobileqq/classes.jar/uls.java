import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;

public class uls
  implements MediaPlayer.OnCompletionListener
{
  public uls(MediaPlayerManager paramMediaPlayerManager) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    com.tencent.mobileqq.utils.AudioUtil.a = null;
    if ((MediaPlayerManager.a(this.a) != null) && (MediaPlayerManager.a(this.a))) {
      return;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uls
 * JD-Core Version:    0.7.0.1
 */