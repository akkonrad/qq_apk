package com.tencent.wordsegment;

import java.util.ArrayList;

public class WordSegment
{
  public static final int ContextMatchType_HotWordWholeWord = 2;
  public static final int ContextMatchType_None = 0;
  public static final int ContextMatchType_Pattern = 1;
  public static final int ContextMatchType_Precontext = 3;
  private static ILogCallback _logCallback;
  
  public static final native String bussinesReport(String paramString);
  
  public static final long getARMv7LibCRC32()
  {
    return 3627058812L;
  }
  
  public static final int getARMv7LibSize()
  {
    return 186176;
  }
  
  public static final int getPlatformBuildNumber()
  {
    return 912;
  }
  
  public static final native int init(String paramString);
  
  public static final native boolean recognize(String paramString, ArrayList<Integer> paramArrayList, ArrayList<ContextItem> paramArrayList1);
  
  public static final native String[] segment(String paramString);
  
  public static void setLogCallback(ILogCallback paramILogCallback)
  {
    _logCallback = paramILogCallback;
  }
  
  public static final native void uninit();
  
  public static final native int updateDict(int paramInt, String paramString);
  
  public static void writeLog(String paramString1, String paramString2)
  {
    if (_logCallback != null) {
      _logCallback.OnLog(paramString1, paramString2);
    }
  }
  
  public static abstract interface ILogCallback
  {
    public abstract void OnLog(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wordsegment.WordSegment
 * JD-Core Version:    0.7.0.1
 */