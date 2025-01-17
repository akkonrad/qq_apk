package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x791$SetRedDotAppids
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_cmd_uin", "uint64_to_uin", "rpt_appid_opt" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null }, SetRedDotAppids.class);
  public final PBRepeatMessageField rpt_appid_opt = PBField.initRepeatMessage(oidb_0x791.SetAppidOpt.class);
  public final PBUInt64Field uint64_cmd_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x791.oidb_0x791.SetRedDotAppids
 * JD-Core Version:    0.7.0.1
 */