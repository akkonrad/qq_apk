package pb.unite.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicAssociationWord$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field business = PBField.initUInt32(0);
  public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field key_word_src = PBField.initUInt32(0);
  public final PBUInt32Field need_flag = PBField.initUInt32(0);
  public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "key_word", "version", "business", "key_word_src", "need_flag" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     pb.unite.search.DynamicAssociationWord.ReqBody
 * JD-Core Version:    0.7.0.1
 */