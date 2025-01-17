package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqWatchVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspWatchVideo;
import com.tencent.biz.qqstory.network.response.WatchVideoResponse;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class WatchVideoRequest
  extends NetworkRequest
{
  public static final String a;
  public long a;
  public boolean a;
  public String b;
  public int c;
  public String c;
  public int d;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.video_watch_no_expired");
  }
  
  public WatchVideoResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspWatchVideo localRspWatchVideo = new qqstory_service.RspWatchVideo();
    try
    {
      localRspWatchVideo.mergeFrom(paramArrayOfByte);
      return new WatchVideoResponse(localRspWatchVideo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqWatchVideo localReqWatchVideo = new qqstory_service.ReqWatchVideo();
    localReqWatchVideo.vid.set(ByteStringMicro.copyFromUtf8(this.b));
    localReqWatchVideo.to_union_id.set(ByteStringMicro.copyFromUtf8(a(this.jdField_c_of_type_JavaLangString)));
    PBUInt32Field localPBUInt32Field = localReqWatchVideo.is_live_video;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      localReqWatchVideo.source.set(this.jdField_c_of_type_Int);
      if (this.jdField_a_of_type_Long > 0L) {
        localReqWatchVideo.create_time.set(this.jdField_a_of_type_Long / 1000L);
      }
      if (this.d > 0) {
        localReqWatchVideo.vid_type.set(this.d);
      }
      return localReqWatchVideo.toByteArray();
    }
  }
  
  public String toString()
  {
    return "WatchVideoRequest{vid='" + this.b + '\'' + ", videoUid=" + this.jdField_c_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.WatchVideoRequest
 * JD-Core Version:    0.7.0.1
 */