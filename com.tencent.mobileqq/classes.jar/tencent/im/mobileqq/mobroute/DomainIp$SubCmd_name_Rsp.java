package tencent.im.mobileqq.mobroute;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DomainIp$SubCmd_name_Rsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_uip", "uint32_qq", "iplistInfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, SubCmd_name_Rsp.class);
  public final PBRepeatMessageField iplistInfo = PBField.initRepeatMessage(DomainIp.DomainiplistInfo.class);
  public final PBUInt32Field uint32_qq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uip = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.mobileqq.mobroute.DomainIp.SubCmd_name_Rsp
 * JD-Core Version:    0.7.0.1
 */