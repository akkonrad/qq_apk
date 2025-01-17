package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x68b$PackInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint64_pack_id", "pack_type", "msg_friend_recommend_info", "msg_special_topic_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1), null, null }, PackInfo.class);
  public oidb_cmd0x68b.FriendRecommendInfo msg_friend_recommend_info = new oidb_cmd0x68b.FriendRecommendInfo();
  public oidb_cmd0x68b.SpecialTopicInfo msg_special_topic_info = new oidb_cmd0x68b.SpecialTopicInfo();
  public final PBEnumField pack_type = PBField.initEnum(1);
  public final PBUInt64Field uint64_pack_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PackInfo
 * JD-Core Version:    0.7.0.1
 */