package com.qq.wx.voice.data.recognizer;

public class InfoSender
{
  public static final String DefaultDomain = "api.pr.weixin.qq.com";
  public static final int DefaultPort = 80;
  public static final String DefaultUri = "/cgi-bin/wxvoicereco";
  public static String Domain = "api.pr.weixin.qq.com";
  public static int Port = 80;
  public static String Uri = "/cgi-bin/wxvoicereco";
  
  public static void resetDomain()
  {
    Domain = "api.pr.weixin.qq.com";
    Port = 80;
  }
  
  public static void resetUri()
  {
    Uri = "/cgi-bin/wxvoicereco";
  }
  
  public static void setDomain(String paramString1, int paramInt, String paramString2)
  {
    Domain = paramString1;
    Port = paramInt;
  }
  
  public static void setUri(String paramString)
  {
    Uri = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.qq.wx.voice.data.recognizer.InfoSender
 * JD-Core Version:    0.7.0.1
 */