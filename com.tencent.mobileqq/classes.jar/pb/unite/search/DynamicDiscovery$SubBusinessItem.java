package pb.unite.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DynamicDiscovery$SubBusinessItem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field bzid = PBField.initUInt32(0);
  public final PBRepeatField group_masks = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field has_red_dot = PBField.initUInt32(0);
  public final PBBytesField icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_hot_words_list = PBField.initUInt32(0);
  public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field red_seq = PBField.initUInt32(0);
  public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 56, 64 }, new String[] { "title", "icon_url", "group_masks", "is_hot_words_list", "jump_url", "has_red_dot", "red_seq", "bzid" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SubBusinessItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     pb.unite.search.DynamicDiscovery.SubBusinessItem
 * JD-Core Version:    0.7.0.1
 */