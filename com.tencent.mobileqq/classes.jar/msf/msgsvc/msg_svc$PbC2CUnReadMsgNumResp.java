package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_svc$PbC2CUnReadMsgNumResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "result", "errmsg", "msg_num" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, PbC2CUnReadMsgNumResp.class);
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt32Field msg_num = PBField.initUInt32(0);
  public final PBUInt32Field result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbC2CUnReadMsgNumResp
 * JD-Core Version:    0.7.0.1
 */