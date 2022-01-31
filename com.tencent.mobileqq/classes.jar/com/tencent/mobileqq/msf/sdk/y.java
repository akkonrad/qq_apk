package com.tencent.mobileqq.msf.sdk;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class y
{
  public static CommandCallbackerInfo a(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = new JceInputStream((byte[])paramToServiceMsg.getAttribute("to_push_cmdCallbackerInfo"));
    CommandCallbackerInfo localCommandCallbackerInfo = new CommandCallbackerInfo();
    localCommandCallbackerInfo.readFrom(paramToServiceMsg);
    return localCommandCallbackerInfo;
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, CommandCallbackerInfo paramCommandCallbackerInfo)
  {
    JceOutputStream localJceOutputStream = new JceOutputStream();
    paramCommandCallbackerInfo.writeTo(localJceOutputStream);
    paramToServiceMsg.addAttribute("to_push_cmdCallbackerInfo", localJceOutputStream.toByteArray());
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, NotifyRegisterInfo paramNotifyRegisterInfo)
  {
    JceOutputStream localJceOutputStream = new JceOutputStream();
    paramNotifyRegisterInfo.writeTo(localJceOutputStream);
    paramToServiceMsg.addAttribute("to_push_notifyRegisterInfo", localJceOutputStream.toByteArray());
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, PushRegisterInfo paramPushRegisterInfo)
  {
    JceOutputStream localJceOutputStream = new JceOutputStream();
    paramPushRegisterInfo.writeTo(localJceOutputStream);
    paramToServiceMsg.addAttribute("to_push_pushRegisterInfo", localJceOutputStream.toByteArray());
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, x paramx)
  {
    JceOutputStream localJceOutputStream = new JceOutputStream();
    paramx.writeTo(localJceOutputStream);
    paramToServiceMsg.addAttribute("to_push_proxyRegisterInfo", localJceOutputStream.toByteArray());
  }
  
  public static PushRegisterInfo b(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = new JceInputStream((byte[])paramToServiceMsg.getAttribute("to_push_pushRegisterInfo"));
    PushRegisterInfo localPushRegisterInfo = new PushRegisterInfo();
    localPushRegisterInfo.readFrom(paramToServiceMsg);
    return localPushRegisterInfo;
  }
  
  public static NotifyRegisterInfo c(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = new JceInputStream((byte[])paramToServiceMsg.getAttribute("to_push_notifyRegisterInfo"));
    NotifyRegisterInfo localNotifyRegisterInfo = new NotifyRegisterInfo();
    localNotifyRegisterInfo.readFrom(paramToServiceMsg);
    return localNotifyRegisterInfo;
  }
  
  public static x d(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = new JceInputStream((byte[])paramToServiceMsg.getAttribute("to_push_proxyRegisterInfo"));
    x localx = new x();
    localx.readFrom(paramToServiceMsg);
    return localx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.y
 * JD-Core Version:    0.7.0.1
 */