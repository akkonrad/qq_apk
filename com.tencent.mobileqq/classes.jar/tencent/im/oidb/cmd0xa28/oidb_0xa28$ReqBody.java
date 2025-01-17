package tencent.im.oidb.cmd0xa28;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xa28$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_request_uin", "uint32_sourceID", "uint32_sourceSubID" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field uint32_sourceID = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sourceSubID = PBField.initUInt32(0);
  public final PBUInt64Field uint64_request_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa28.oidb_0xa28.ReqBody
 * JD-Core Version:    0.7.0.1
 */