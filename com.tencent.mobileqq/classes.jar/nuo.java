import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.network.request.GetFeedFeatureRequest;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment;
import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;
import java.util.ArrayList;

public class nuo
  extends ParallelJobSegment
{
  public nuo(DetailFeedAllInfoPullSegment paramDetailFeedAllInfoPullSegment) {}
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    GetFeedFeatureRequest localGetFeedFeatureRequest = new GetFeedFeatureRequest();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localGetFeedFeatureRequest.a = localArrayList;
    CmdTaskManger.a().a(localGetFeedFeatureRequest, new nup(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nuo
 * JD-Core Version:    0.7.0.1
 */