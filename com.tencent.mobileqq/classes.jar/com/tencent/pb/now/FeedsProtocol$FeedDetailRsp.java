package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedsProtocol$FeedDetailRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "result", "media_infos", "is_end", "total" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, FeedDetailRsp.class);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBRepeatMessageField media_infos = PBField.initRepeatMessage(FeedsProtocol.MediaInfo.class);
  public final PBInt32Field result = PBField.initInt32(0);
  public final PBUInt32Field total = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.FeedDetailRsp
 * JD-Core Version:    0.7.0.1
 */