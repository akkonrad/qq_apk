package tencent.im.oidb;

import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x5fb$ReqInfo
  extends MessageMicro
{
  public static final int BYTES_COOKIE_FIELD_NUMBER = 9;
  public static final int MSG_DESTINATION_FIELD_NUMBER = 10;
  public static final int UINT32_AGE_LOW_FIELD_NUMBER = 6;
  public static final int UINT32_AGE_UP_FIELD_NUMBER = 7;
  public static final int UINT32_GENDER_FIELD_NUMBER = 5;
  public static final int UINT32_PROFESSION_FIELD_NUMBER = 8;
  public static final int UINT32_SUBJECT_FIELD_NUMBER = 4;
  public static final int UINT32_TIME_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public appoint_define.LocaleInfo msg_destination = new appoint_define.LocaleInfo();
  public final PBUInt32Field uint32_age_low = PBField.initUInt32(0);
  public final PBUInt32Field uint32_age_up = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profession = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subject = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 24, 32, 40, 48, 56, 64, 74, 82 }, new String[] { "uint32_time", "uint32_subject", "uint32_gender", "uint32_age_low", "uint32_age_up", "uint32_profession", "bytes_cookie", "msg_destination" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null }, ReqInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5fb.ReqInfo
 * JD-Core Version:    0.7.0.1
 */