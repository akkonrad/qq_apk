package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_mp$GetUserEqqListResponse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "ret_info", "accountInfo", "seqno", "is_over", "next_pos" }, new Object[] { null, null, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0) }, GetUserEqqListResponse.class);
  public final PBRepeatMessageField accountInfo = PBField.initRepeatMessage(mobileqq_mp.EqqAccountInfo.class);
  public final PBBoolField is_over = PBField.initBool(false);
  public final PBUInt32Field next_pos = PBField.initUInt32(0);
  public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  public final PBUInt32Field seqno = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.GetUserEqqListResponse
 * JD-Core Version:    0.7.0.1
 */