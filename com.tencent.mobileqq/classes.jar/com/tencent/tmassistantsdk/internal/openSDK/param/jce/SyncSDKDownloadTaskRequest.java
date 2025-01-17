package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SyncSDKDownloadTaskRequest
  extends JceStruct
{
  static IPCSDKDownloadInfo a = new IPCSDKDownloadInfo();
  public IPCSDKDownloadInfo data = null;
  
  public SyncSDKDownloadTaskRequest() {}
  
  public SyncSDKDownloadTaskRequest(IPCSDKDownloadInfo paramIPCSDKDownloadInfo)
  {
    this.data = paramIPCSDKDownloadInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.data = ((IPCSDKDownloadInfo)paramJceInputStream.read(a, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.data, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.jce.SyncSDKDownloadTaskRequest
 * JD-Core Version:    0.7.0.1
 */