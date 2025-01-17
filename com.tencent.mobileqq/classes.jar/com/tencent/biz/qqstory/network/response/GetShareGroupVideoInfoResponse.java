package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchGetVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GroupStoryInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetShareGroupVideoInfoResponse
  extends BaseResponse
{
  public List a;
  
  public GetShareGroupVideoInfoResponse(qqstory_service.RspBatchGetVideoInfo paramRspBatchGetVideoInfo)
  {
    super(paramRspBatchGetVideoInfo.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramRspBatchGetVideoInfo.vid_info_list.has())
    {
      paramRspBatchGetVideoInfo = paramRspBatchGetVideoInfo.vid_info_list.get().iterator();
      while (paramRspBatchGetVideoInfo.hasNext())
      {
        qqstory_struct.GroupStoryInfo localGroupStoryInfo = (qqstory_struct.GroupStoryInfo)paramRspBatchGetVideoInfo.next();
        StoryVideoItem localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.convertFrom("Q.qqstory.shareGroup:GetShareGroupVideoInfoResponse", localGroupStoryInfo);
        this.jdField_a_of_type_JavaUtilList.add(localStoryVideoItem);
      }
    }
  }
  
  public String toString()
  {
    return "GetShareGroupVideoInfoResponse{errorCode=" + this.jdField_a_of_type_Int + ", errorMsg='" + this.b + '\'' + ", mVideoItemList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetShareGroupVideoInfoResponse
 * JD-Core Version:    0.7.0.1
 */