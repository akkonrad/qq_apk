package tencent.im.oidb.cmd0x7b4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x7b4$ControlPointInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_task_id", "rpt_control_info" }, new Object[] { Long.valueOf(0L), null }, ControlPointInfo.class);
  public final PBRepeatMessageField rpt_control_info = PBField.initRepeatMessage(cmd0x7b4.ControllerInfo.class);
  public final PBUInt64Field uint64_task_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7b4.cmd0x7b4.ControlPointInfo
 * JD-Core Version:    0.7.0.1
 */