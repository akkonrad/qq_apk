package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.database.VideoUrlEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetShareVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoFullInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoUrl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetShareVideoListResponse
  extends BaseResponse
{
  public String a;
  public List a;
  public boolean a;
  public List b = new ArrayList();
  public String c;
  
  public GetShareVideoListResponse(String paramString, qqstory_service.RspGetShareVideoList paramRspGetShareVideoList)
  {
    super(paramRspGetShareVideoList.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramRspGetShareVideoList.is_end.get() == 1)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.c = paramRspGetShareVideoList.next_cookie.get().toStringUtf8();
      paramString = paramRspGetShareVideoList.full_video_info_list.get().iterator();
    }
    for (;;)
    {
      if (!paramString.hasNext()) {
        return;
      }
      Object localObject1 = (qqstory_struct.StoryVideoFullInfo)paramString.next();
      paramRspGetShareVideoList = new StoryVideoItem();
      paramRspGetShareVideoList.convertFrom((qqstory_struct.StoryVideoFullInfo)localObject1);
      this.jdField_a_of_type_JavaUtilList.add(paramRspGetShareVideoList);
      Object localObject2 = ((qqstory_struct.StoryVideoFullInfo)localObject1).compressed_video.get();
      if (localObject2 != null)
      {
        localObject1 = new ArrayList(((List)localObject2).size());
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            qqstory_struct.VideoUrl localVideoUrl = (qqstory_struct.VideoUrl)((Iterator)localObject2).next();
            VideoUrlEntry localVideoUrlEntry = new VideoUrlEntry();
            localVideoUrlEntry.vid = paramRspGetShareVideoList.mVid;
            localVideoUrlEntry.videoUrlLevel = localVideoUrl.video_level.get();
            localVideoUrlEntry.videoUrl = localVideoUrl.video_url.get();
            ((List)localObject1).add(localVideoUrlEntry);
            continue;
            bool = false;
            break;
          }
        }
        this.b.add(localObject1);
      }
    }
  }
  
  public String toString()
  {
    return "GetShareVideoListResponse{unionId=" + this.jdField_a_of_type_JavaLangString + "isEnd=" + this.jdField_a_of_type_Boolean + ", nextCookie='" + this.c + '\'' + ", videoItems=" + StoryVideoItem.dump(this.jdField_a_of_type_JavaUtilList) + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetShareVideoListResponse
 * JD-Core Version:    0.7.0.1
 */