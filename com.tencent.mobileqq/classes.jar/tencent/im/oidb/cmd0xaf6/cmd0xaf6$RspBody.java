package tencent.im.oidb.cmd0xaf6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0xaf6$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18 }, new String[] { "group_member" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField group_member = PBField.initRepeatMessage(cmd0xaf6.GroupMember.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xaf6.cmd0xaf6.RspBody
 * JD-Core Version:    0.7.0.1
 */