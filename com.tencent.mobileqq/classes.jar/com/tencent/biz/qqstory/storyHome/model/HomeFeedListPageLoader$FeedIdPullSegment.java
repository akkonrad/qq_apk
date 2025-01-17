package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoSpreadGroupList;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.network.request.GetStoryFeedIdListRequest;
import com.tencent.biz.qqstory.network.request.GetStoryFeedIdListRequest.GetStoryFeedIdListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import nys;

public class HomeFeedListPageLoader$FeedIdPullSegment
  extends JobSegment
{
  private int jdField_a_of_type_Int;
  private BasicLocation jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation;
  private FeedListPageLoaderBase.FeedIdListCache jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache;
  
  public HomeFeedListPageLoader$FeedIdPullSegment(@NonNull FeedListPageLoaderBase.FeedIdListCache paramFeedIdListCache, BasicLocation paramBasicLocation)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache = paramFeedIdListCache;
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation = paramBasicLocation;
  }
  
  public static boolean a(@Nullable GetStoryFeedIdListRequest.GetStoryFeedIdListResponse paramGetStoryFeedIdListResponse, AtomicBoolean paramAtomicBoolean)
  {
    Object localObject2 = "";
    Object localObject1 = null;
    List localList = ((StoryManager)SuperManager.a(5)).a(true);
    Iterator localIterator = paramGetStoryFeedIdListResponse.a.iterator();
    paramGetStoryFeedIdListResponse = (GetStoryFeedIdListRequest.GetStoryFeedIdListResponse)localObject1;
    if (localIterator.hasNext())
    {
      FeedIdListSeqInfo localFeedIdListSeqInfo = (FeedIdListSeqInfo)localIterator.next();
      localObject1 = localObject2;
      if (!((String)localObject2).equals(localFeedIdListSeqInfo.c)) {
        localObject1 = localFeedIdListSeqInfo.c;
      }
      if (!a(localFeedIdListSeqInfo, localList)) {
        break label121;
      }
      localFeedIdListSeqInfo.jdField_b_of_type_Boolean = true;
      paramAtomicBoolean.set(true);
      paramGetStoryFeedIdListResponse = localFeedIdListSeqInfo;
    }
    label121:
    for (;;)
    {
      localObject2 = localObject1;
      break;
      return (paramGetStoryFeedIdListResponse != null) && (((String)localObject2).equals(paramGetStoryFeedIdListResponse.c));
    }
  }
  
  private static boolean a(FeedIdListSeqInfo paramFeedIdListSeqInfo, List paramList)
  {
    Object localObject2;
    do
    {
      paramList = paramList.iterator();
      Object localObject1;
      while (!((Iterator)localObject1).hasNext())
      {
        do
        {
          do
          {
            if (!paramList.hasNext()) {
              break;
            }
            localObject1 = (StoryVideoItem)paramList.next();
          } while (!paramFeedIdListSeqInfo.c.equals(((StoryVideoItem)localObject1).mPublishDate));
          if ((((StoryVideoItem)localObject1).isLocalAddShareGroupVideo()) && (paramFeedIdListSeqInfo.jdField_b_of_type_JavaLangString.equals(((StoryVideoItem)localObject1).shareGroupId)))
          {
            SLog.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has *add* fail video:%s", new Object[] { paramFeedIdListSeqInfo });
            return true;
          }
          localObject2 = StoryVideoTaskInfo.a(((StoryVideoItem)localObject1).mVid);
          if ((localObject2 != null) && (((PublishVideoEntry)localObject2).getBooleanExtra("ignorePersonalPublish", false))) {}
          for (int i = 1; (i == 0) && (paramFeedIdListSeqInfo.jdField_b_of_type_JavaLangString.equals(((StoryVideoItem)localObject1).mOwnerUid)); i = 0)
          {
            SLog.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this personal feed  has fail video:%s", new Object[] { paramFeedIdListSeqInfo });
            return true;
          }
          localObject1 = ((StoryVideoItem)localObject1).mVideoSpreadGroupList;
        } while ((localObject1 == null) || (((VideoSpreadGroupList)localObject1).b == null));
        localObject1 = ((VideoSpreadGroupList)localObject1).b.iterator();
      }
      localObject2 = (String)((Iterator)localObject1).next();
    } while (!paramFeedIdListSeqInfo.jdField_b_of_type_JavaLangString.equals(localObject2));
    SLog.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has fail video:%s", new Object[] { paramFeedIdListSeqInfo });
    return true;
    return false;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache.a(paramInteger.intValue(), 5);
    if ((((FeedListPageLoaderBase.GetFeedIdListResult)localObject).a.size() > 0) || (((FeedListPageLoaderBase.GetFeedIdListResult)localObject).jdField_b_of_type_Boolean))
    {
      SLog.b("Q.qqstory.home.data.HomeFeedListPageLoader", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new AtomicBoolean(false);
    GetStoryFeedIdListRequest localGetStoryFeedIdListRequest = new GetStoryFeedIdListRequest();
    localGetStoryFeedIdListRequest.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation = this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation;
    localGetStoryFeedIdListRequest.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache.a();
    CmdTaskManger.a().a(localGetStoryFeedIdListRequest, new nys(this, paramJobContext, (AtomicBoolean)localObject, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedListPageLoader.FeedIdPullSegment
 * JD-Core Version:    0.7.0.1
 */