package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$RspSystemMsgNew
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField bytes_game_nick = PBField.initString("");
  public final PBBytesField bytes_undecid_for_qim = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField checktype = PBField.initEnum(1);
  public final PBUInt64Field following_friend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field following_group_seq = PBField.initUInt64(0L);
  public final PBRepeatMessageField friendmsgs = PBField.initRepeatMessage(structmsg.StructMsg.class);
  public final PBRepeatMessageField groupmsgs = PBField.initRepeatMessage(structmsg.StructMsg.class);
  public final PBStringField grp_msg_display = PBField.initString("");
  public structmsg.RspHead head = new structmsg.RspHead();
  public final PBUInt64Field latest_friend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field latest_group_seq = PBField.initUInt64(0L);
  public final PBStringField msg_display = PBField.initString("");
  public structmsg.StructMsg msg_ribbon_friend = new structmsg.StructMsg();
  public structmsg.StructMsg msg_ribbon_group = new structmsg.StructMsg();
  public final PBUInt32Field uint32_over = PBField.initUInt32(0);
  public final PBUInt32Field unread_friend_count = PBField.initUInt32(0);
  public final PBUInt32Field unread_group_count = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 74, 82, 90, 98, 106, 114, 120, 160, 802, 810 }, new String[] { "head", "unread_friend_count", "unread_group_count", "latest_friend_seq", "latest_group_seq", "following_friend_seq", "following_group_seq", "friendmsgs", "groupmsgs", "msg_ribbon_friend", "msg_ribbon_group", "msg_display", "grp_msg_display", "uint32_over", "checktype", "bytes_game_nick", "bytes_undecid_for_qim" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, null, null, null, "", "", Integer.valueOf(0), Integer.valueOf(1), "", localByteStringMicro }, RspSystemMsgNew.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.RspSystemMsgNew
 * JD-Core Version:    0.7.0.1
 */