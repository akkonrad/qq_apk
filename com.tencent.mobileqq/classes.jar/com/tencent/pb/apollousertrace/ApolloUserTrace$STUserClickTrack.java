package com.tencent.pb.apollousertrace;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ApolloUserTrace$STUserClickTrack
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50 }, new String[] { "screenScale", "screenX", "screenY", "time", "list", "name" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, "" }, STUserClickTrack.class);
  public final PBRepeatMessageField list = PBField.initRepeatMessage(ApolloUserTrace.STClickInfo.class);
  public final PBStringField name = PBField.initString("");
  public final PBInt32Field screenScale = PBField.initInt32(0);
  public final PBInt32Field screenX = PBField.initInt32(0);
  public final PBInt32Field screenY = PBField.initInt32(0);
  public final PBUInt32Field time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.apollousertrace.ApolloUserTrace.STUserClickTrack
 * JD-Core Version:    0.7.0.1
 */