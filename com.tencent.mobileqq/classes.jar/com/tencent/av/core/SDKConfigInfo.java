package com.tencent.av.core;

public class SDKConfigInfo
{
  private static final String TAG = "SDKConfigInfo";
  private boolean isDebugVersion = false;
  private boolean isGrayVersion = false;
  private boolean isPublicVersion = true;
  private String logDir = "";
  private String processName = "";
  
  public String toString()
  {
    return "SDKConfigInfo{logDir='" + this.logDir + '\'' + ", processName='" + this.processName + '\'' + ", isDebugVersion=" + this.isDebugVersion + ", isGrayVersion=" + this.isGrayVersion + ", isPublicVersion=" + this.isPublicVersion + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.core.SDKConfigInfo
 * JD-Core Version:    0.7.0.1
 */