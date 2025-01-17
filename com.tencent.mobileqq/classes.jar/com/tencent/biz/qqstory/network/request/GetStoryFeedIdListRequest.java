package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetStoryFeedIdListRequest
  extends NetworkRequest
{
  public static final String a;
  public BasicLocation a;
  public String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.homepage_batch_feeds_720");
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspStoryFeedIdList localRspStoryFeedIdList = new qqstory_service.RspStoryFeedIdList();
    try
    {
      localRspStoryFeedIdList.mergeFrom(paramArrayOfByte);
      return new GetStoryFeedIdListRequest.GetStoryFeedIdListResponse(localRspStoryFeedIdList);
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
    return jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqStoryFeedIdList localReqStoryFeedIdList = new qqstory_service.ReqStoryFeedIdList();
    localReqStoryFeedIdList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.b));
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation != null)
    {
      localReqStoryFeedIdList.coordinate.set(this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation.c);
      localReqStoryFeedIdList.gps.setHasFlag(true);
      localReqStoryFeedIdList.gps.lat.set(this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation.a);
      localReqStoryFeedIdList.gps.lng.set(this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation.b);
    }
    localReqStoryFeedIdList.client_version.set(6);
    return localReqStoryFeedIdList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetStoryFeedIdListRequest
 * JD-Core Version:    0.7.0.1
 */