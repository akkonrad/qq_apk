package tencent.im.oidb.cmd0x8bb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x8bb$WriteReq
  extends MessageMicro
{
  public static final int RPT_MSG_GROUP_CONCERNED_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_group_concerned" }, new Object[] { null }, WriteReq.class);
  public final PBRepeatMessageField rpt_msg_group_concerned = PBField.initRepeatMessage(oidb_0x8bb.GroupConcernedInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8bb.oidb_0x8bb.WriteReq
 * JD-Core Version:    0.7.0.1
 */