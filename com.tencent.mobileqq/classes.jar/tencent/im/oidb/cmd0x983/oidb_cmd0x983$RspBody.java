package tencent.im.oidb.cmd0x983;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0x983$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_addon_list" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField rpt_addon_list = PBField.initRepeatMessage(oidb_cmd0x983.AddonItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x983.oidb_cmd0x983.RspBody
 * JD-Core Version:    0.7.0.1
 */