package tencent.im.oidb.cmd0x7c9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7c9$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_req_type", "uint32_has_data", "rpt_hello_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(1), null }, ReqBody.class);
  public final PBRepeatMessageField rpt_hello_type = PBField.initRepeatMessage(cmd0x7c9.ReqHelloType.class);
  public final PBUInt32Field uint32_has_data = PBField.initUInt32(1);
  public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7c9.cmd0x7c9.ReqBody
 * JD-Core Version:    0.7.0.1
 */