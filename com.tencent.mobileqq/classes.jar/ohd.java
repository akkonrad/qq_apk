import android.os.Handler;
import android.os.SystemClock;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.Mp4VideoFragmentInfo;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.biz.qqstory.utils.VideoUtils.VideoKeyFrameFragment;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.mediacodec.utils.AudioDataUtil;
import com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil;
import java.util.ArrayList;
import java.util.List;

public class ohd
  implements Runnable
{
  public ohd(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_Boolean) {}
    Object localObject1;
    int i;
    for (long l1 = 10000L;; l1 = 2147483647L)
    {
      localObject1 = null;
      if (this.a.jdField_a_of_type_Boolean) {
        localObject1 = VideoUtils.a(HWEditLocalVideoPlayer.a(this.a), l1);
      }
      if (localObject1 != null) {
        break label628;
      }
      localObject1 = new ArrayList();
      i = 0;
      while (i < this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration / l1)
      {
        ((ArrayList)localObject1).add(new VideoUtils.VideoKeyFrameFragment(i * l1, l1));
        i += 1;
      }
    }
    label371:
    label628:
    for (;;)
    {
      if (((ArrayList)localObject1).size() <= 0) {
        ((ArrayList)localObject1).add(new VideoUtils.VideoKeyFrameFragment(0L, this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration));
      }
      long l3 = SystemClock.uptimeMillis();
      i = 0;
      Object localObject2;
      int j;
      if (i < ((ArrayList)localObject1).size())
      {
        localObject2 = (VideoUtils.VideoKeyFrameFragment)((ArrayList)localObject1).get(i);
        long l4 = SystemClock.uptimeMillis();
        long l2 = Math.min(((VideoUtils.VideoKeyFrameFragment)localObject2).a + ((VideoUtils.VideoKeyFrameFragment)localObject2).b, this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
        l1 = l2;
        if (1000L + l2 > this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration) {
          l1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
        }
        if (i == 5) {
          l1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
        }
        HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = new HWEditLocalVideoPlayer.Mp4VideoFragmentInfo(i, MediaUtil.a(HWEditLocalVideoPlayer.a(this.a), (int)((VideoUtils.VideoKeyFrameFragment)localObject2).a));
        HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, ((VideoUtils.VideoKeyFrameFragment)localObject2).a);
        HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(localMp4VideoFragmentInfo, l1);
        this.a.jdField_a_of_type_JavaUtilList.add(localMp4VideoFragmentInfo);
        SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "create fragment info = %s, cost = %dms", localMp4VideoFragmentInfo, Long.valueOf(SystemClock.uptimeMillis() - l4));
        if (l1 < this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration) {}
      }
      else
      {
        SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "create fragment info count = %d, cost = %dms", Integer.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()), Long.valueOf(SystemClock.uptimeMillis() - l3));
        i = 0;
        if (i >= this.a.jdField_a_of_type_JavaUtilList.size()) {
          break label608;
        }
        localObject1 = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.a.jdField_a_of_type_JavaUtilList.get(i);
        localObject2 = HWEditLocalVideoPlayer.a(this.a) + "_" + i + ".IFrames.audio";
        j = AudioDataUtil.a(HWEditLocalVideoPlayer.b(this.a), (String)localObject2, (float)HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject1) * 1.0F / (float)this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, (float)HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject1) * 1.0F / (float)this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
        if (j != 0) {
          break label544;
        }
        SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "clipAudioFile finished audioFilePath" + (String)localObject2);
        ((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject1).b = ((String)localObject2);
      }
      for (;;)
      {
        i += 1;
        break label371;
        i += 1;
        break;
        SLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", "clipAudioFile failed. errcode =%s,  audioFilePath=%s, duration=%s, startTime=%s, endTime=%s", new Object[] { Integer.valueOf(j), localObject2, Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration), Long.valueOf(HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject1)), Long.valueOf(HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject1)) });
      }
      HWEditLocalVideoPlayer.a(this.a).post(new ohe(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ohd
 * JD-Core Version:    0.7.0.1
 */