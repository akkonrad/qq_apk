package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "exposure_url", "click_url", "effect_url", "landing_page_report_url", "negative_feedback_url", "trace_info" }, new Object[] { "", "", "", "", "", null }, ReportInfo.class);
  public final PBStringField click_url = PBField.initString("");
  public final PBStringField effect_url = PBField.initString("");
  public final PBStringField exposure_url = PBField.initString("");
  public final PBStringField landing_page_report_url = PBField.initString("");
  public final PBStringField negative_feedback_url = PBField.initString("");
  public qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo trace_info = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo
 * JD-Core Version:    0.7.0.1
 */