package tencent.im.oidb.cmd0xa80;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xa80$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_rsp_group_info" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField rpt_msg_rsp_group_info = PBField.initRepeatMessage(oidb_cmd0xa80.RspGroupInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa80.oidb_cmd0xa80.RspBody
 * JD-Core Version:    0.7.0.1
 */