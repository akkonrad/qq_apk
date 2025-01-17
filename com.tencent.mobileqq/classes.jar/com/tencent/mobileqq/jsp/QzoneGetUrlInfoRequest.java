package com.tencent.mobileqq.jsp;

import NS_MOBILE_EXTRA.mobile_get_urlinfo_req;
import QMF_PROTOCAL.RetryInfo;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;

public class QzoneGetUrlInfoRequest
  extends QzoneExternalRequest
{
  private JceStruct a;
  
  public QzoneGetUrlInfoRequest(String paramString)
  {
    mobile_get_urlinfo_req localmobile_get_urlinfo_req = new mobile_get_urlinfo_req();
    localmobile_get_urlinfo_req.url = paramString;
    this.a = localmobile_get_urlinfo_req;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getUrlInfo";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public Object getRetryInfo()
  {
    return new RetryInfo((short)0, 0, System.currentTimeMillis());
  }
  
  public String uniKey()
  {
    return "getUrlInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.QzoneGetUrlInfoRequest
 * JD-Core Version:    0.7.0.1
 */