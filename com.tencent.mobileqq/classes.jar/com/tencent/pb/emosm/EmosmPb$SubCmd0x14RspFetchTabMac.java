package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class EmosmPb$SubCmd0x14RspFetchTabMac
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 29, 32, 42, 50, 58, 64 }, new String[] { "fixed32_timestamp_ios", "int32_segment_flag_ios", "fixed32_timestamp_android", "int32_segment_flag_android", "rpt_msg_tabinfo", "rpt_magic_tabinfo", "rpt_smallbq_tabinfo", "uint32_tab_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, Integer.valueOf(0) }, SubCmd0x14RspFetchTabMac.class);
  public final PBFixed32Field fixed32_timestamp_android = PBField.initFixed32(0);
  public final PBFixed32Field fixed32_timestamp_ios = PBField.initFixed32(0);
  public final PBInt32Field int32_segment_flag_android = PBField.initInt32(0);
  public final PBInt32Field int32_segment_flag_ios = PBField.initInt32(0);
  public final PBRepeatMessageField rpt_magic_tabinfo = PBField.initRepeatMessage(EmosmPb.SubCmd0x14RspFetchTabMac.TabInfo.class);
  public final PBRepeatMessageField rpt_msg_tabinfo = PBField.initRepeatMessage(EmosmPb.SubCmd0x14RspFetchTabMac.TabInfo.class);
  public final PBRepeatMessageField rpt_smallbq_tabinfo = PBField.initRepeatMessage(EmosmPb.SubCmd0x14RspFetchTabMac.TabInfo.class);
  public final PBRepeatField uint32_tab_id = PBField.initRepeat(PBInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x14RspFetchTabMac
 * JD-Core Version:    0.7.0.1
 */