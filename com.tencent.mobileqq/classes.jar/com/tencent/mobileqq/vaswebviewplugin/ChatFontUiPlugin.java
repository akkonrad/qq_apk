package com.tencent.mobileqq.vaswebviewplugin;

import java.util.Map;

public class ChatFontUiPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "ChatFontUiPlugin";
  private boolean mIsDpcWriteUser;
  
  protected boolean excuteEvent(String paramString, long paramLong, Map paramMap)
  {
    if (8589934593L == paramLong) {}
    return false;
  }
  
  protected long getPluginBusiness()
  {
    return 4096L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatFontUiPlugin
 * JD-Core Version:    0.7.0.1
 */