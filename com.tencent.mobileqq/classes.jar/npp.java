import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import mqq.os.MqqHandler;

public class npp
  implements TVK_IMediaPlayer.OnErrorListener
{
  public npp(VideoViewTVKImpl paramVideoViewTVKImpl) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    ThreadManager.getUIHandler().post(new npq(this, paramInt1, paramInt2, paramInt3, paramString, paramObject));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npp
 * JD-Core Version:    0.7.0.1
 */