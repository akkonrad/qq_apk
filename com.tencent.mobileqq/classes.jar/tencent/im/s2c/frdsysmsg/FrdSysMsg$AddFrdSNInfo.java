package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FrdSysMsg$AddFrdSNInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_not_see_dynamic", "uint32_set_sn" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, AddFrdSNInfo.class);
  public final PBUInt32Field uint32_not_see_dynamic = PBField.initUInt32(0);
  public final PBUInt32Field uint32_set_sn = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.frdsysmsg.FrdSysMsg.AddFrdSNInfo
 * JD-Core Version:    0.7.0.1
 */