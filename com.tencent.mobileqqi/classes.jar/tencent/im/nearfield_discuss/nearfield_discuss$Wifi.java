package tencent.im.nearfield_discuss;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearfield_discuss$Wifi
  extends MessageMicro
{
  public static final int INT32_RSSI_FIELD_NUMBER = 2;
  public static final int UINT64_MAC_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_mac", "int32_rssi" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, Wifi.class);
  public final PBInt32Field int32_rssi = PBField.initInt32(0);
  public final PBUInt64Field uint64_mac = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.nearfield_discuss.nearfield_discuss.Wifi
 * JD-Core Version:    0.7.0.1
 */