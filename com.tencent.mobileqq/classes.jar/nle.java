import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.playmode.child.SelectVideosPlayMode;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import java.util.ArrayList;

class nle
  implements Runnable
{
  nle(nld paramnld) {}
  
  public void run()
  {
    this.a.a.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.setCurrentItem(this.a.a.a.b, false);
    if ((this.a.a.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a != null) && (this.a.a.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size() > 0))
    {
      this.a.a.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.a.a.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a);
      this.a.a.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a.a(1);
    }
    this.a.a.a.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nle
 * JD-Core Version:    0.7.0.1
 */