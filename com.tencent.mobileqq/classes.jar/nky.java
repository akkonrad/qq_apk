import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.playmode.child.NewFriendsPlayMode;
import com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.GetVideoListEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qphone.base.util.QLog;

public class nky
  extends UIBaseEventReceiver
{
  public nky(NewFriendsPlayMode paramNewFriendsPlayMode)
  {
    super(paramNewFriendsPlayMode);
  }
  
  public void a(@NonNull NewFriendsPlayMode paramNewFriendsPlayMode, @NonNull VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent)
  {
    SLog.c(this.TAG, "FeedVideoListReceiver onSuccess, event:" + paramGetVideoListEvent.toString());
    paramNewFriendsPlayMode.a.post(new nkz(this, paramNewFriendsPlayMode, paramGetVideoListEvent));
  }
  
  public Class acceptEventClass()
  {
    return VideoListPageLoader.GetVideoListEvent.class;
  }
  
  public void b(NewFriendsPlayMode paramNewFriendsPlayMode, VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.e(this.TAG, 2, "FeedVideoListReceiver onError:" + paramGetVideoListEvent.a());
    }
    paramNewFriendsPlayMode.a.post(new nla(this, paramNewFriendsPlayMode, paramGetVideoListEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nky
 * JD-Core Version:    0.7.0.1
 */