import android.text.TextUtils;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest;
import com.tencent.biz.qqstory.network.request.GetFeedFeatureRequest;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class nfn
  implements Runnable
{
  public nfn(GetFeedFeatureHandler paramGetFeedFeatureHandler) {}
  
  public void run()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.a.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a((String)localObject3) == null)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((List)localObject1).add(localObject3);
        }
      }
      else {
        this.a.b.add(localObject3);
      }
    }
    if (!((List)localObject1).isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request FeedItem: first=", ((List)localObject1).get(0) });
      }
      localObject2 = new BatchGetFriendStoryFeedInfoRequest();
      ((BatchGetFriendStoryFeedInfoRequest)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = new FeedIdListSeqInfo((String)((Iterator)localObject1).next(), 0, "", "");
        ((BatchGetFriendStoryFeedInfoRequest)localObject2).jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      CmdTaskManger.a().a((NetworkRequest)localObject2, this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request FeedFeature: first=", this.a.jdField_a_of_type_JavaUtilList.get(0) });
    }
    localObject1 = new GetFeedFeatureRequest();
    ((GetFeedFeatureRequest)localObject1).jdField_a_of_type_JavaUtilList = this.a.jdField_a_of_type_JavaUtilList;
    CmdTaskManger.a().a((NetworkRequest)localObject1, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfn
 * JD-Core Version:    0.7.0.1
 */