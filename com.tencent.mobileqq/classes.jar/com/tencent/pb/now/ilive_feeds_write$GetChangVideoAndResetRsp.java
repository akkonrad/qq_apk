package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ilive_feeds_write$GetChangVideoAndResetRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField chang = PBField.initRepeatMessage(ilive_feeds_tmem.Chang.class);
  public final PBBytesField errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field ret = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ret", "errmsg", "chang" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, GetChangVideoAndResetRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_write.GetChangVideoAndResetRsp
 * JD-Core Version:    0.7.0.1
 */