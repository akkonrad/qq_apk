package nearby_interact_state;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class interact_value$InteractValue
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_one_interact" }, new Object[] { null }, InteractValue.class);
  public final PBRepeatMessageField rpt_one_interact = PBField.initRepeatMessage(interact_value.OneInteract.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     nearby_interact_state.interact_value.InteractValue
 * JD-Core Version:    0.7.0.1
 */