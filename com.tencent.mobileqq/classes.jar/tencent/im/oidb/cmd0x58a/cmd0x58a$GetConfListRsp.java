package tencent.im.oidb.cmd0x58a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x58a$GetConfListRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_msg_conf_base_info", "rpt_uint64_other_conf_list" }, new Object[] { null, Long.valueOf(0L) }, GetConfListRsp.class);
  public final PBRepeatMessageField rpt_msg_conf_base_info = PBField.initRepeatMessage(cmd0x58a.ConfBaseInfo.class);
  public final PBRepeatField rpt_uint64_other_conf_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x58a.cmd0x58a.GetConfListRsp
 * JD-Core Version:    0.7.0.1
 */