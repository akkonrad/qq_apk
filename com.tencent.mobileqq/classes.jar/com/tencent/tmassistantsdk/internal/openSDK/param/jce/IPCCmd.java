package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import java.io.Serializable;

public final class IPCCmd
  implements Serializable
{
  public static final IPCCmd BatchDownloadAction;
  public static final IPCCmd BatchSDKDownloadAction;
  public static final IPCCmd Empty;
  public static final IPCCmd GetDownloadProgress;
  public static final IPCCmd GetDownloadState;
  public static final IPCCmd OperateDownloadTask;
  public static final IPCCmd QueryDownloadTask;
  public static final IPCCmd QueryLoginInfo;
  public static final IPCCmd QueryLoginState;
  public static final IPCCmd ServiceFreeAction;
  public static final IPCCmd SubScribeSDKDownloadTaskByVia;
  public static final IPCCmd SyncSDKDownloadTask;
  public static final IPCCmd SyncSDKHandShake;
  public static final IPCCmd URIAction;
  public static final int _BatchDownloadAction = 9;
  public static final int _BatchSDKDownloadAction = 13;
  public static final int _Empty = 0;
  public static final int _GetDownloadProgress = 3;
  public static final int _GetDownloadState = 2;
  public static final int _OperateDownloadTask = 1;
  public static final int _QueryDownloadTask = 4;
  public static final int _QueryLoginInfo = 6;
  public static final int _QueryLoginState = 7;
  public static final int _ServiceFreeAction = 8;
  public static final int _SubScribeSDKDownloadTaskByVia = 10;
  public static final int _SyncSDKDownloadTask = 11;
  public static final int _SyncSDKHandShake = 12;
  public static final int _URIAction = 5;
  private static IPCCmd[] __values;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!IPCCmd.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      __values = new IPCCmd[14];
      Empty = new IPCCmd(0, 0, "Empty");
      OperateDownloadTask = new IPCCmd(1, 1, "OperateDownloadTask");
      GetDownloadState = new IPCCmd(2, 2, "GetDownloadState");
      GetDownloadProgress = new IPCCmd(3, 3, "GetDownloadProgress");
      QueryDownloadTask = new IPCCmd(4, 4, "QueryDownloadTask");
      URIAction = new IPCCmd(5, 5, "URIAction");
      QueryLoginInfo = new IPCCmd(6, 6, "QueryLoginInfo");
      QueryLoginState = new IPCCmd(7, 7, "QueryLoginState");
      ServiceFreeAction = new IPCCmd(8, 8, "ServiceFreeAction");
      BatchDownloadAction = new IPCCmd(9, 9, "BatchDownloadAction");
      SubScribeSDKDownloadTaskByVia = new IPCCmd(10, 10, "SubScribeSDKDownloadTaskByVia");
      SyncSDKDownloadTask = new IPCCmd(11, 11, "SyncSDKDownloadTask");
      SyncSDKHandShake = new IPCCmd(12, 12, "SyncSDKHandShake");
      BatchSDKDownloadAction = new IPCCmd(13, 13, "BatchSDKDownloadAction");
      return;
    }
  }
  
  private IPCCmd(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static IPCCmd convert(int paramInt)
  {
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    if (!a) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static IPCCmd convert(String paramString)
  {
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].toString().equals(paramString)) {
        return __values[i];
      }
      i += 1;
    }
    if (!a) {
      throw new AssertionError();
    }
    return null;
  }
  
  public String toString()
  {
    return this.__T;
  }
  
  public int value()
  {
    return this.__value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd
 * JD-Core Version:    0.7.0.1
 */