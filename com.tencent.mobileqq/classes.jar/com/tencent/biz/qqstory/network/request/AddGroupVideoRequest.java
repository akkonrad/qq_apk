package com.tencent.biz.qqstory.network.request;

import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_group.GroupVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqAddGroupVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspAddGroupVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_group.VideoObject;
import com.tencent.biz.qqstory.network.response.AddGroupVideoResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class AddGroupVideoRequest
  extends NetworkRequest
{
  private final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final List jdField_a_of_type_JavaUtilList;
  private final List b;
  private final int c;
  
  public AddGroupVideoRequest(String paramString, List paramList1, List paramList2, List paramList3, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("union_id should not be empty");
    }
    if ((paramList1 == null) || (paramList1.isEmpty())) {
      throw new IllegalArgumentException("vidList is empty");
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Collections.unmodifiableList(paramList1));
    this.jdField_a_of_type_JavaUtilList = paramList2;
    this.b = paramList3;
    this.c = paramInt;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_group.RspAddGroupVideo localRspAddGroupVideo = new qqstory_group.RspAddGroupVideo();
    try
    {
      localRspAddGroupVideo.mergeFrom(paramArrayOfByte);
      return new AddGroupVideoResponse(localRspAddGroupVideo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        SLog.b("AddGroupVideoRequest", "decodeResponse", paramArrayOfByte);
      }
    }
  }
  
  public String a()
  {
    return StoryApi.a("StoryGroupSvc.add_video");
  }
  
  protected byte[] a()
  {
    qqstory_group.ReqAddGroupVideo localReqAddGroupVideo = new qqstory_group.ReqAddGroupVideo();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      qqstory_group.GroupVideo localGroupVideo = new qqstory_group.GroupVideo();
      localGroupVideo.source.set(this.c);
      localGroupVideo.union_id.set(ByteStringMicro.copyFromUtf8((String)((Map.Entry)localObject).getKey()));
      int i = 0;
      localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        qqstory_group.VideoObject localVideoObject = new qqstory_group.VideoObject();
        localVideoObject.vid.set(ByteStringMicro.copyFromUtf8(str));
        localVideoObject.ts.set(((Long)this.jdField_a_of_type_JavaUtilList.get(i)).longValue() / 1000L);
        localVideoObject.time_zone.set(((Integer)this.b.get(i)).intValue());
        localGroupVideo.video_obj_list.add(localVideoObject);
        i += 1;
      }
      localReqAddGroupVideo.group_video_list.add(localGroupVideo);
    }
    return localReqAddGroupVideo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.AddGroupVideoRequest
 * JD-Core Version:    0.7.0.1
 */