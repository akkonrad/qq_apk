package tencent.im.oidb.cmd0x8d3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8d3$ReqBody
  extends MessageMicro
{
  public static final int RPT_UINT64_APPIDLIST_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint64_appidlist" }, new Object[] { Long.valueOf(0L) }, ReqBody.class);
  public final PBRepeatField rpt_uint64_appidlist = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8d3.oidb_0x8d3.ReqBody
 * JD-Core Version:    0.7.0.1
 */