package tencent.im.oidb.cmd0x9e9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x9e9$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "msg_user", "uint32_start", "uint32_size" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public cmd0x9e9.User msg_user = new cmd0x9e9.User();
  public final PBUInt32Field uint32_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9e9.cmd0x9e9.ReqBody
 * JD-Core Version:    0.7.0.1
 */