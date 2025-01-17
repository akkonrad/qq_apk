package tencent.im.oidb.cmd0x80a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x80a$KDEventReportReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "event_id", "event_name", "att_list" }, new Object[] { Integer.valueOf(0), "", null }, KDEventReportReq.class);
  public final PBRepeatMessageField att_list = PBField.initRepeatMessage(oidb_cmd0x80a.AttributeList.class);
  public final PBUInt32Field event_id = PBField.initUInt32(0);
  public final PBStringField event_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.KDEventReportReq
 * JD-Core Version:    0.7.0.1
 */