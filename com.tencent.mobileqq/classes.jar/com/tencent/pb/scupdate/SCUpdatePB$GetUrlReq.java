package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SCUpdatePB$GetUrlReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "delta_mode", "storage_mode", "compress_mode", "item_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, GetUrlReq.class);
  public final PBUInt32Field compress_mode = PBField.initUInt32(0);
  public final PBUInt32Field delta_mode = PBField.initUInt32(0);
  public final PBRepeatMessageField item_list = PBField.initRepeatMessage(SCUpdatePB.ItemVersion.class);
  public final PBUInt32Field storage_mode = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.scupdate.SCUpdatePB.GetUrlReq
 * JD-Core Version:    0.7.0.1
 */