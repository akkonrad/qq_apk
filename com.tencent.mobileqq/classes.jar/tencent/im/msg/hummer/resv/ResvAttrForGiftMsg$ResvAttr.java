package tencent.im.msg.hummer.resv;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ResvAttrForGiftMsg$ResvAttr
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_charm_heroism = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_recv_score = PBField.initInt32(0);
  public final PBInt32Field int32_send_score = PBField.initInt32(0);
  public ResvAttrForGiftMsg.InteractGift msg_interact_gift = new ResvAttrForGiftMsg.InteractGift();
  public final PBUInt32Field uint32_animation_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_button_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_obj_color = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 58 }, new String[] { "int32_send_score", "int32_recv_score", "bytes_charm_heroism", "uint32_button_flag", "uint32_obj_color", "uint32_animation_type", "msg_interact_gift" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, ResvAttr.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.hummer.resv.ResvAttrForGiftMsg.ResvAttr
 * JD-Core Version:    0.7.0.1
 */