package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GetTinyID$STCheckGameRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field expTs = PBField.initUInt32(0);
  public final PBUInt32Field isPatch = PBField.initUInt32(0);
  public final PBUInt32Field needGCoins = PBField.initUInt32(0);
  public final PBStringField openId = PBField.initString("");
  public final PBStringField openKey = PBField.initString("");
  public final PBUInt64Field packageSize = PBField.initUInt64(0L);
  public final PBBytesField patchContent = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField patchUrl = PBField.initString("");
  public final PBUInt32Field remainPlays = PBField.initUInt32(0);
  public final PBStringField sessionOpenId = PBField.initString("");
  public final PBStringField ssoCmdRule = PBField.initString("");
  public final PBStringField st = PBField.initString("");
  public final PBStringField stKey = PBField.initString("");
  public final PBUInt32Field svrResVer = PBField.initUInt32(0);
  public final PBUInt64Field tipsSize = PBField.initUInt64(0L);
  public final PBUInt32Field updateFlag = PBField.initUInt32(0);
  public final PBStringField wording = PBField.initString("");
  public final PBStringField wordingV2 = PBField.initString("");
  public final PBStringField zipMd5 = PBField.initString("");
  public final PBStringField zipUrl = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50, 58, 66, 72, 82, 88, 96, 106, 114, 122, 130, 136, 144, 152, 162 }, new String[] { "st", "stKey", "expTs", "remainPlays", "wording", "openId", "openKey", "sessionOpenId", "needGCoins", "wordingV2", "updateFlag", "isPatch", "patchContent", "patchUrl", "zipMd5", "zipUrl", "svrResVer", "packageSize", "tipsSize", "ssoCmdRule" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, "", "", "", Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "" }, STCheckGameRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.apollo.GetTinyID.STCheckGameRsp
 * JD-Core Version:    0.7.0.1
 */