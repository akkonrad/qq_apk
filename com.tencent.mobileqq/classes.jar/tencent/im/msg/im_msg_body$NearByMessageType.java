package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$NearByMessageType
  extends MessageMicro
{
  public static final int ETypeClearingImg = 2;
  public static final int ETypeClearingText = 1;
  public static final int ETypeDefault = 0;
  public static final int ETypeIdentify = 1;
  public static final int ETypeNormal = 0;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_type", "uint32_identify_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, NearByMessageType.class);
  public final PBUInt32Field uint32_identify_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.NearByMessageType
 * JD-Core Version:    0.7.0.1
 */