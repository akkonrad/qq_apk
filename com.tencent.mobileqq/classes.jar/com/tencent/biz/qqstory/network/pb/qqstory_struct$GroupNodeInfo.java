package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$GroupNodeInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field feed_time = PBField.initUInt64(0L);
  public final PBUInt32Field feed_type = PBField.initUInt32(0);
  public final PBUInt32Field feed_video_total = PBField.initUInt32(0);
  public final PBUInt32Field isend = PBField.initUInt32(0);
  public final PBBytesField more_start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField storyid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatMessageField video_list = PBField.initRepeatMessage(qqstory_struct.GroupStoryInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 56, 66 }, new String[] { "feed_id", "feed_type", "feed_time", "feed_video_total", "video_list", "storyid_list", "isend", "more_start_cookie" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3 }, GroupNodeInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.GroupNodeInfo
 * JD-Core Version:    0.7.0.1
 */