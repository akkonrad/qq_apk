package tencent.im.statsvc.getonline;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class StatSvcGetOnline$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50 }, new String[] { "error_code", "error_msg", "uint64_uin", "uint32_appid", "uint32_time_interval", "msg_instances" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null }, RspBody.class);
  public final PBUInt32Field error_code = PBField.initUInt32(0);
  public final PBStringField error_msg = PBField.initString("");
  public final PBRepeatMessageField msg_instances = PBField.initRepeatMessage(StatSvcGetOnline.Instance.class);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time_interval = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.statsvc.getonline.StatSvcGetOnline.RspBody
 * JD-Core Version:    0.7.0.1
 */