import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qphone.base.util.QLog;

class dqf
  implements MediaPlayer.OnPreparedListener
{
  dqf(dqc paramdqc) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Splash.testCanPlayMp4", 4, "onPrepare");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dqf
 * JD-Core Version:    0.7.0.1
 */