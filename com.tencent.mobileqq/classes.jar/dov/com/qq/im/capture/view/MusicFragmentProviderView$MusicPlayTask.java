package dov.com.qq.im.capture.view;

import com.tencent.util.WeakReferenceHandler;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class MusicFragmentProviderView$MusicPlayTask
  extends TimerTask
{
  protected MusicFragmentProviderView$MusicPlayTask(MusicFragmentProviderView paramMusicFragmentProviderView) {}
  
  public void run()
  {
    if (MusicFragmentProviderView.a(this.a) != null)
    {
      MusicFragmentProviderView.a(this.a).incrementAndGet();
      if (this.a.a != null) {
        this.a.a.sendEmptyMessage(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.MusicFragmentProviderView.MusicPlayTask
 * JD-Core Version:    0.7.0.1
 */