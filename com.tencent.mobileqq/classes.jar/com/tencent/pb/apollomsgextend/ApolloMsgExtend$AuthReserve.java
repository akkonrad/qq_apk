package com.tencent.pb.apollomsgextend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ApolloMsgExtend$AuthReserve
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field action_type = PBField.initUInt32(0);
  public final PBInt64Field action_ver = PBField.initInt64(0L);
  public final PBInt64Field diy_voice_begin_ts = PBField.initInt64(0L);
  public final PBUInt32Field diy_voice_id = PBField.initUInt32(0);
  public final PBBytesField extend_json = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field game_id = PBField.initUInt32(0);
  public final PBUInt32Field game_mode = PBField.initUInt32(0);
  public final PBBytesField game_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField game_share_ark_json = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField game_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field game_ver = PBField.initInt64(0L);
  public final PBInt64Field game_ver_735 = PBField.initInt64(0L);
  public final PBUInt32Field img_type = PBField.initUInt32(0);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public final PBInt64Field sign_ts = PBField.initInt64(0L);
  public final PBUInt32Field slave_action_id = PBField.initUInt32(0);
  public final PBRepeatField slave_uin_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field sub_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 72, 80, 90, 96, 104, 112, 120, 130, 136, 146 }, new String[] { "diy_voice_id", "diy_voice_begin_ts", "sign_ts", "sub_type", "game_id", "room_id", "img_type", "game_text", "game_ver", "action_ver", "game_name", "game_mode", "slave_action_id", "slave_uin_list", "action_type", "extend_json", "game_ver_735", "game_share_ark_json" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Long.valueOf(0L), localByteStringMicro4 }, AuthReserve.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.apollomsgextend.ApolloMsgExtend.AuthReserve
 * JD-Core Version:    0.7.0.1
 */