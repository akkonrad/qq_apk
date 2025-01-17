package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetCollectionVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetCollectionVideoList;
import com.tencent.biz.qqstory.network.response.GetCollectionVideoListResponse;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetCollectionVideoListRequest
  extends NetworkRequest
{
  public static final String a = StoryApi.a("StorySvc.new_get_date_share_list");
  public static final String b = StoryApi.a("StorySvc.get_share_video_info_list");
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  
  public GetCollectionVideoListRequest()
  {
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_d_of_type_Int = -1;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetCollectionVideoList localRspGetCollectionVideoList = new qqstory_service.RspGetCollectionVideoList();
    try
    {
      localRspGetCollectionVideoList.mergeFrom(paramArrayOfByte);
      return new GetCollectionVideoListResponse(this.jdField_c_of_type_JavaLangString, localRspGetCollectionVideoList);
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
    if (this.jdField_e_of_type_JavaLangString == null) {
      return a;
    }
    return b;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetCollectionVideoList localReqGetCollectionVideoList = new qqstory_service.ReqGetCollectionVideoList();
    localReqGetCollectionVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
    localReqGetCollectionVideoList.count.set(this.jdField_c_of_type_Int);
    if (this.jdField_e_of_type_JavaLangString == null)
    {
      localReqGetCollectionVideoList.collection_id.set(this.jdField_d_of_type_Int);
      if (this.jdField_e_of_type_Int != -1) {
        localReqGetCollectionVideoList.time_zone.set(this.jdField_e_of_type_Int);
      }
    }
    for (;;)
    {
      AssertUtils.a(this.jdField_c_of_type_JavaLangString);
      localReqGetCollectionVideoList.union_id.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
      return localReqGetCollectionVideoList.toByteArray();
      localReqGetCollectionVideoList.feed_id.set(ByteStringMicro.copyFromUtf8(this.jdField_e_of_type_JavaLangString));
      localReqGetCollectionVideoList.identify.set(this.f);
    }
  }
  
  public String toString()
  {
    return super.toString() + " GetCollectionVideoListRequest{targetUid=" + this.jdField_c_of_type_JavaLangString + ", startCookie='" + this.jdField_d_of_type_JavaLangString + ", count=" + this.jdField_c_of_type_Int + ", collectionId=" + this.jdField_d_of_type_Int + ", timeZoneOffset=" + this.jdField_e_of_type_Int + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetCollectionVideoListRequest
 * JD-Core Version:    0.7.0.1
 */