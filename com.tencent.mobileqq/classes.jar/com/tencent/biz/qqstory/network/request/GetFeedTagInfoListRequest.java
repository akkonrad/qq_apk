package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStoryFeedTagInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryFeedTagInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetFeedTagInfoListRequest
  extends NetworkRequest
{
  public List a = new ArrayList();
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspStoryFeedTagInfo localRspStoryFeedTagInfo = new qqstory_service.RspStoryFeedTagInfo();
    try
    {
      localRspStoryFeedTagInfo.mergeFrom(paramArrayOfByte);
      return new GetFeedTagInfoListRequest.GetFeedTagInfoListResponse(localRspStoryFeedTagInfo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public String a()
  {
    return "StorySvc.homepage_batch_feeds_label";
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqStoryFeedTagInfo localReqStoryFeedTagInfo = new qqstory_service.ReqStoryFeedTagInfo();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localReqStoryFeedTagInfo.feed_id_list.add(ByteStringMicro.copyFromUtf8(str));
    }
    return localReqStoryFeedTagInfo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetFeedTagInfoListRequest
 * JD-Core Version:    0.7.0.1
 */