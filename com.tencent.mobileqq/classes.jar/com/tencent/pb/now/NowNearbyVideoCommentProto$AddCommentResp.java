package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowNearbyVideoCommentProto$AddCommentResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "result", "comment_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, AddCommentResp.class);
  public final PBUInt64Field comment_id = PBField.initUInt64(0L);
  public final PBUInt64Field result = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.NowNearbyVideoCommentProto.AddCommentResp
 * JD-Core Version:    0.7.0.1
 */