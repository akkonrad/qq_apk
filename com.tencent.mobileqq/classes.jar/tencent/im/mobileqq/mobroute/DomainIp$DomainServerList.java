package tencent.im.mobileqq.mobroute;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DomainIp$DomainServerList
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "string_IP", "uint32_Port" }, new Object[] { "", Integer.valueOf(0) }, DomainServerList.class);
  public final PBStringField string_IP = PBField.initString("");
  public final PBUInt32Field uint32_Port = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.mobileqq.mobroute.DomainIp.DomainServerList
 * JD-Core Version:    0.7.0.1
 */