package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowNearbyVideoCommentProto$GetCommentListReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "feed_type", "feed_id", "page", "count", "filter" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, GetCommentListReq.class);
  public final PBUInt64Field count = PBField.initUInt64(0L);
  public final PBStringField feed_id = PBField.initString("");
  public final PBUInt64Field feed_type = PBField.initUInt64(0L);
  public final PBUInt64Field filter = PBField.initUInt64(0L);
  public final PBUInt64Field page = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.NowNearbyVideoCommentProto.GetCommentListReq
 * JD-Core Version:    0.7.0.1
 */