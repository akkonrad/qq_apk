import android.os.Handler;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.child.MsgTabPlayMode;
import com.tencent.biz.qqstory.playmode.child.MsgTabPlayMode.StoryVideoPublishStatusReceiver;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo.IBatchGetVideoInfoCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class njw
  implements BatchGetVideoInfo.IBatchGetVideoInfoCallback
{
  public njw(MsgTabPlayMode.StoryVideoPublishStatusReceiver paramStoryVideoPublishStatusReceiver, MsgTabPlayMode paramMsgTabPlayMode, StoryVideoItem paramStoryVideoItem) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e(MsgTabPlayMode.StoryVideoPublishStatusReceiver.b(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode$StoryVideoPublishStatusReceiver), 2, new Object[] { "get self publish success video info failed. vid=", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(MsgTabPlayMode.StoryVideoPublishStatusReceiver.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode$StoryVideoPublishStatusReceiver), 2, new Object[] { "get self publish success video info finish. size=", Integer.valueOf(paramArrayList.size()) });
    }
    if (!paramArrayList.isEmpty()) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.a.post(new njx(this, paramArrayList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     njw
 * JD-Core Version:    0.7.0.1
 */