package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class oidb_cmd0x68b$LBSInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_latitude", "int32_longitude" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, LBSInfo.class);
  public final PBInt32Field int32_latitude = PBField.initInt32(0);
  public final PBInt32Field int32_longitude = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.LBSInfo
 * JD-Core Version:    0.7.0.1
 */