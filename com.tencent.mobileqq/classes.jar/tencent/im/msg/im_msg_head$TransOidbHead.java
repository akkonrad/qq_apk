package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_head$TransOidbHead
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_command", "uint32_service_type", "uint32_result", "str_error_msg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, TransOidbHead.class);
  public final PBStringField str_error_msg = PBField.initString("");
  public final PBUInt32Field uint32_command = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_head.TransOidbHead
 * JD-Core Version:    0.7.0.1
 */