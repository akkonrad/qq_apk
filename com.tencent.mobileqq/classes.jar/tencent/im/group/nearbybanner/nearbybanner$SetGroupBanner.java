package tencent.im.group.nearbybanner;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearbybanner$SetGroupBanner
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_group_code" }, new Object[] { Long.valueOf(0L) }, SetGroupBanner.class);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.group.nearbybanner.nearbybanner.SetGroupBanner
 * JD-Core Version:    0.7.0.1
 */