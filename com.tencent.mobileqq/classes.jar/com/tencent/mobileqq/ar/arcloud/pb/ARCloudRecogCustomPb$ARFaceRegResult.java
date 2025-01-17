package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ARCloudRecogCustomPb$ARFaceRegResult
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "errorcode", "errormsg", "ar_face_reg_errorcode", "ar_face_reg_errormsg", "session_id" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", "" }, ARFaceRegResult.class);
  public final PBInt32Field ar_face_reg_errorcode = PBField.initInt32(0);
  public final PBStringField ar_face_reg_errormsg = PBField.initString("");
  public final PBInt32Field errorcode = PBField.initInt32(0);
  public final PBStringField errormsg = PBField.initString("");
  public final PBStringField session_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARFaceRegResult
 * JD-Core Version:    0.7.0.1
 */