package pb.unite.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DynamicSearch$ResultItem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField extension = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field group_mask = PBField.initUInt64(0L);
  public final PBBytesField jmp_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField layout_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field layout_id = PBField.initUInt32(0);
  public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField report_ext_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField result_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field result_item_type = PBField.initUInt64(0L);
  public final PBRepeatMessageField rpt_meaning = PBField.initRepeatMessage(DynamicSearch.Meaning.class);
  public final PBUInt32Field seporator_type = PBField.initUInt32(0);
  public final PBRepeatMessageField sub_item_list = PBField.initRepeatMessage(DynamicSearch.SubItem.class);
  public final PBRepeatMessageField sub_result_items = PBField.initRepeatMessage(ResultItem.class);
  public final PBBytesField word = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 74, 80, 90, 170, 176, 184, 194 }, new String[] { "result_id", "name", "pic_url", "jmp_url", "word", "extension", "rpt_meaning", "group_mask", "sub_item_list", "layout_id", "layout_content", "sub_result_items", "result_item_type", "seporator_type", "report_ext_data" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, null, Long.valueOf(0L), null, Integer.valueOf(0), localByteStringMicro7, null, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro8 }, ResultItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     pb.unite.search.DynamicSearch.ResultItem
 * JD-Core Version:    0.7.0.1
 */