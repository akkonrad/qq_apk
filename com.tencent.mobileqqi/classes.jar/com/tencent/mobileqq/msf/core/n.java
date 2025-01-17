package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.auth.g;
import com.tencent.mobileqq.msf.core.c.e;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.mobileqq.msf.service.h;
import com.tencent.msf.service.protocol.push.RequestMSFForceOffline;
import com.tencent.msf.service.protocol.security.k;
import com.tencent.msf.service.protocol.security.m;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

public class n
{
  public static HashSet a = new HashSet();
  public static final int b = 210;
  public static final int c = -12003;
  public static final int d = -10001;
  public static final int e = -10003;
  public static final int f = -10004;
  public static final int g = -10005;
  public static final int h = -10006;
  public static final int i = -10000;
  public static final int j = -10007;
  public static final int k = -10009;
  public static final int l = -10101;
  public static final int m = -10102;
  public static final int n = -10103;
  public static final int o = -10104;
  public static final int p = -10105;
  public static final int q = -10106;
  static final String r = "OverLoadPush.notify";
  private static final String v = "MSF.C.SSORespHandler";
  private static final int w = 1000;
  MsfCore s;
  long t = -1L;
  long u = -1L;
  private Handler x = new o(this);
  
  public n(MsfCore paramMsfCore)
  {
    this.s = paramMsfCore;
  }
  
  public static void a(FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg.setBusinessFail(2002, "verifyCode");
    paramFromServiceMsg.setMsfCommand(MsfCommand.onRecvVerifyCode);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.getAttributes().remove("to_timeoutCallbacker");
      if (this.s.getMsfAppid() == -1) {
        this.s.setMsfAppid(paramToServiceMsg.getAppId());
      }
    }
    if (paramFromServiceMsg.getServiceCmd().startsWith("SharpSvr."))
    {
      l1 = SystemClock.elapsedRealtime();
      if ((l.k > 0L) && (l1 - l.k > 0L) && (l1 - l.k <= 30000L)) {
        paramFromServiceMsg.addAttribute("__timestamp_msf2net_boot_sharp_c2s", Long.valueOf(l.k));
      }
    }
    else
    {
      if (!a(paramFromServiceMsg, paramToServiceMsg)) {
        break label143;
      }
      if ((paramFromServiceMsg.getServiceCmd().startsWith("wtlogin.")) && (paramToServiceMsg != null)) {
        com.tencent.mobileqq.msf.core.auth.i.a(paramToServiceMsg, paramFromServiceMsg);
      }
    }
    label143:
    int i1;
    label338:
    do
    {
      do
      {
        return;
        paramFromServiceMsg.addAttribute("__timestamp_msf2net_boot_sharp_c2s", Integer.valueOf(-1));
        break;
        if ((com.tencent.mobileqq.msf.core.a.a.t) && (paramToServiceMsg != null) && (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_RegPush) && (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_queryPush) && (this.s.pushManager != null)) {
          this.s.pushManager.b(System.currentTimeMillis());
        }
        if ((paramToServiceMsg != null) && (paramToServiceMsg.getAttribute("to_wtlogin_oldcmd") != null)) {}
        for (i1 = 1;; i1 = 0)
        {
          if ((!paramFromServiceMsg.getServiceCmd().startsWith("login.")) || (i1 != 0)) {
            break label338;
          }
          if (paramToServiceMsg == null) {
            break;
          }
          this.s.getAccountCenter().f.a(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (((paramFromServiceMsg.getServiceCmd().equals("login.auth")) || (paramFromServiceMsg.getServiceCmd().equals("login.chguin"))) && (paramFromServiceMsg.getResultCode() == 1000)) {
          this.s.getStatReporter().a(paramFromServiceMsg.getServiceCmd().equals("login.chguin"));
        }
      } while (!QLog.isColorLevel());
      QLog.d("MSF.C.SSORespHandler", 2, "found timeoutResp " + paramFromServiceMsg);
      return;
      if ((!paramFromServiceMsg.getServiceCmd().startsWith("wtlogin.")) || (i1 == 0)) {
        break label431;
      }
      if (paramToServiceMsg != null)
      {
        com.tencent.mobileqq.msf.core.auth.i.a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ((paramFromServiceMsg.getServiceCmd().equals("wtlogin.login")) && (paramFromServiceMsg.getResultCode() == 1000)) {
        this.s.getStatReporter().a(false);
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.SSORespHandler", 2, "found timeoutResp " + paramFromServiceMsg);
    return;
    label431:
    if (paramFromServiceMsg.getServiceCmd().equals("wtlogin.PushChangeToken"))
    {
      this.s.getAccountCenter().g.b();
      QLog.d("MSF.C.SSORespHandler", 1, "push req to refre token.");
      return;
    }
    Object localObject;
    if (paramFromServiceMsg.getServiceCmd().equals("OnlinePush.SidTicketExpired"))
    {
      localObject = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
      ((ToServiceMsg)localObject).setRequestSsoSeq(paramFromServiceMsg.getRequestSsoSeq());
      ((ToServiceMsg)localObject).setAppId(this.s.getMsfAppid());
      ((ToServiceMsg)localObject).setNeedCallback(false);
      ((ToServiceMsg)localObject).setTimeout(30000L);
      this.s.sendSsoMsg((ToServiceMsg)localObject);
      localObject = this.x.obtainMessage();
      ((Message)localObject).what = 1000;
      ((Message)localObject).obj = paramFromServiceMsg.getUin();
      if (this.x.hasMessages(1000)) {
        this.x.removeMessages(1000);
      }
      this.x.sendMessageDelayed((Message)localObject, 3000L);
    }
    if (paramFromServiceMsg.getServiceCmd().equals("ConfigPushSvc.PushReq"))
    {
      this.s.ssoListManager.a(paramFromServiceMsg);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("SSO.HelloPush"))
    {
      this.s.ssoListManager.b(paramFromServiceMsg);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("QualityTest.PushList"))
    {
      com.tencent.mobileqq.msf.core.b.a.c.d = this.s;
      com.tencent.mobileqq.msf.core.b.a.c.a(paramFromServiceMsg);
      paramToServiceMsg = new ToServiceMsg("", "0", paramFromServiceMsg.getServiceCmd());
      paramToServiceMsg.setMsfCommand(MsfCommand._msf_QualityTest);
      paramToServiceMsg.setRequestSsoSeq(paramFromServiceMsg.getRequestSsoSeq());
      paramToServiceMsg.setAppId(this.s.getMsfAppid());
      paramToServiceMsg.setNeedCallback(false);
      paramToServiceMsg.setTimeout(30000L);
      this.s.sendSsoMsg(paramToServiceMsg);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OnlinePush.PbPushOffMsg"))
    {
      this.s.pushManager.c(paramFromServiceMsg);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OnlinePush.PushOffReadedNotify"))
    {
      this.s.pushManager.b(paramFromServiceMsg);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("MessageSvc.PullUnreadMsgCount"))
    {
      this.s.pushManager.a(paramFromServiceMsg, paramToServiceMsg);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.infoLogin")) {
      this.s.mbIsInfoLoginGetted.set(true);
    }
    if ((paramToServiceMsg != null) && (paramFromServiceMsg.getServiceCmd().equals("ConfigService.ClientReq")))
    {
      if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_getConfig)
      {
        this.s.configManager.a(paramFromServiceMsg, paramToServiceMsg);
        return;
      }
      this.s.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))
    {
      localObject = new ToServiceMsg("", paramFromServiceMsg.getUin(), "SharpSvr.s2cackMSF");
      ((ToServiceMsg)localObject).setAppId(this.s.getMsfAppid());
      ((ToServiceMsg)localObject).setRequestSsoSeq(paramFromServiceMsg.getRequestSsoSeq());
      ((ToServiceMsg)localObject).setNeedCallback(false);
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).putWupBuffer(paramFromServiceMsg.getWupBuffer());
      this.s.sender.b((ToServiceMsg)localObject);
    }
    if (paramToServiceMsg == null)
    {
      if (paramFromServiceMsg.getServiceCmd().equals("OverLoadPush.notify"))
      {
        this.s.configManager.a(paramFromServiceMsg);
        return;
      }
      this.s.pushManager.a(paramFromServiceMsg);
      return;
    }
    switch (1.a[paramToServiceMsg.getMsfCommand().ordinal()])
    {
    default: 
      paramFromServiceMsg.setAppId(paramToServiceMsg.getAppId());
      paramFromServiceMsg.setAppSeq(paramToServiceMsg.getAppSeq());
      paramFromServiceMsg.setMsfCommand(paramToServiceMsg.getMsfCommand());
      this.s.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
      return;
    case 1: 
      this.s.pushManager.a(paramToServiceMsg, paramFromServiceMsg);
      return;
    case 2: 
      this.s.pushManager.a(paramToServiceMsg, paramFromServiceMsg);
      return;
    case 3: 
      this.s.pushManager.b(paramToServiceMsg, paramFromServiceMsg);
      return;
    case 4: 
      this.s.sender.a(paramFromServiceMsg);
      return;
    case 5: 
      this.s.getAccountCenter().c.a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    l2 = System.currentTimeMillis() / 1000L;
    l1 = l2;
    try
    {
      if (paramFromServiceMsg.isSuccess())
      {
        i1 = MsfSdkUtils.convertBytes2Int(paramFromServiceMsg.getWupBuffer(), 4);
        l1 = i1;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        l1 = l2;
        if (QLog.isDevelopLevel())
        {
          QLog.d("MSF.C.SSORespHandler", 4, "handle serverTime error " + paramToServiceMsg);
          l1 = l2;
        }
      }
    }
    NetConnInfoCenter.handleGetServerTimeResp(l1);
  }
  
  protected boolean a(int paramInt)
  {
    return (paramInt == -12003) || (paramInt == 210) || (paramInt == -10001) || (paramInt == -10003) || (paramInt == -10004) || (paramInt == -10006) || (paramInt == -10106);
  }
  
  protected boolean a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    int i1 = paramFromServiceMsg.getBusinessFailCode();
    boolean bool2 = a(i1);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (i1 == -10005)
      {
        if (this.t == -1L) {
          this.t = System.currentTimeMillis();
        }
        if (this.s.sender.z.get()) {
          break label294;
        }
        bool1 = bool2;
        if (!this.s.getAccountCenter().a(paramFromServiceMsg.getUin()))
        {
          QLog.d("MSF.C.SSORespHandler", 1, "reload D2 failed");
          this.s.sender.y = 1;
          bool1 = true;
        }
        this.s.sender.z.set(true);
      }
    }
    for (;;)
    {
      if (bool1)
      {
        this.s.getAccountCenter().m(paramFromServiceMsg.getUin());
        if ((!h.b()) && ((this.u == -1L) || (System.currentTimeMillis() - this.u > 10000L))) {}
        try
        {
          String str = h.c();
          int i2 = this.s.getUinPushStatus(paramFromServiceMsg.getUin());
          h.a(BaseApplication.getContext(), BaseApplication.getContext().getPackageName(), paramFromServiceMsg.getUin(), str, i2);
          QLog.d("MSF.C.SSORespHandler", 1, "sendBootAction for mainProcess for " + MD5.toMD5(paramFromServiceMsg.getUin()));
          this.u = System.currentTimeMillis();
          paramFromServiceMsg.setBusinessFail(2001, paramFromServiceMsg.getBusinessFailMsg());
          MsfSdkUtils.addFromMsgProcessName("*", paramFromServiceMsg);
          this.s.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
          this.s.getStatReporter().a(0L, i1, 0L);
          return true;
          label294:
          if ((paramToServiceMsg != null) && (this.s.sender.y != -1) && (paramToServiceMsg.getRequestSsoSeq() >= this.s.sender.y))
          {
            bool2 = true;
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("MSF.C.SSORespHandler", 2, "set userTokenExpired. afterReloadD2SendSeq is " + this.s.sender.y);
              bool1 = bool2;
            }
          }
          else
          {
            bool1 = bool2;
            if (this.t != -1L)
            {
              bool1 = bool2;
              if (System.currentTimeMillis() - this.t > 60000L)
              {
                bool2 = true;
                bool1 = bool2;
                if (QLog.isColorLevel())
                {
                  QLog.d("MSF.C.SSORespHandler", 2, "set userTokenExpired after so long wait. ");
                  bool1 = bool2;
                }
              }
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.d("MSF.C.SSORespHandler", 1, "sendBootAction for mainProcess error " + localException, localException);
          }
        }
      }
    }
    if (i1 == -10101)
    {
      paramFromServiceMsg.setBusinessFail(2011, paramFromServiceMsg.getBusinessFailMsg());
      MsfSdkUtils.addFromMsgProcessName("*", paramFromServiceMsg);
      this.s.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
      return true;
    }
    if (i1 == -10102)
    {
      this.s.suspend();
      paramFromServiceMsg.setBusinessFail(2009, paramFromServiceMsg.getBusinessFailMsg());
      MsfSdkUtils.addFromMsgProcessName("*", paramFromServiceMsg);
      this.s.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
      return true;
    }
    if (i1 == -10103)
    {
      this.s.getAccountCenter().m(paramFromServiceMsg.getUin());
      paramFromServiceMsg.setBusinessFail(2012, paramFromServiceMsg.getBusinessFailMsg());
      MsfSdkUtils.addFromMsgProcessName("*", paramFromServiceMsg);
      this.s.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
      return true;
    }
    if (i1 == -10009)
    {
      paramFromServiceMsg.setBusinessFail(2015, paramFromServiceMsg.getBusinessFailMsg());
      MsfSdkUtils.addFromMsgProcessName("*", paramFromServiceMsg);
      this.s.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
      this.s.sender.a(com.tencent.qphone.base.a.m);
      return true;
    }
    if (i1 == -10104)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.SSORespHandler", 2, "get CODE_SSO_FORCEQUIT kill " + BaseApplication.getContext().getPackageName() + ":qq now");
      }
      MsfSdkUtils.killProcess(BaseApplication.getContext(), BaseApplication.getContext().getPackageName());
      return true;
    }
    if (i1 == -10105)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.SSORespHandler", 2, "get CODE_SSO_FORCEQUITSDK kill " + BaseApplication.getContext().getPackageName() + ":msf now");
      }
      MsfSdkUtils.killProcess(BaseApplication.getContext(), BaseApplication.getContext().getPackageName() + ":MSF");
      return true;
    }
    if ((a.contains(paramFromServiceMsg.getUin())) && (!paramFromServiceMsg.getServiceCmd().startsWith("login.")) && (!paramToServiceMsg.getServiceCmd().equals("GrayUinPro.Check")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.SSORespHandler", 2, "error, " + paramFromServiceMsg.getUin() + " not in gray list");
      }
      if (paramToServiceMsg != null)
      {
        paramFromServiceMsg.setBusinessFail(2008, "QQ号不在灰度名单内");
        MsfSdkUtils.addFromMsgProcessName("*", paramFromServiceMsg);
        this.s.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
      }
      return true;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("MessageSvc.PushForceOffline")) {
      try
      {
        this.s.pushManager.b(paramFromServiceMsg.getUin());
        paramFromServiceMsg.addAttribute("_attr_sameDevice", Boolean.valueOf(false));
        paramFromServiceMsg.setBusinessFail(2013, paramFromServiceMsg.getBusinessFailMsg());
        MsfSdkUtils.addFromMsgProcessName("*", paramFromServiceMsg);
        this.s.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
        return true;
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("MSF.C.SSORespHandler", 2, "handle forceLogout error " + paramFromServiceMsg);
          }
        }
      }
    }
    if (paramFromServiceMsg.getServiceCmd().equals("StatSvc.ReqMSFOffline")) {
      try
      {
        this.s.pushManager.b(paramFromServiceMsg.getUin());
        paramToServiceMsg = new UniPacket(true);
        paramToServiceMsg.setEncodeName("utf-8");
        paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = (RequestMSFForceOffline)paramToServiceMsg.getByClass("RequestMSFForceOffline", new RequestMSFForceOffline());
        paramToServiceMsg = new com.tencent.msf.service.protocol.push.a(paramToServiceMsg.lUin, paramToServiceMsg.iSeqno, (byte)0);
        ToServiceMsg localToServiceMsg = new ToServiceMsg("", paramFromServiceMsg.getUin(), "StatSvc.RspMSFForceOffline");
        localToServiceMsg.addAttribute("_attr_sameDevice", Boolean.valueOf(false));
        UniPacket localUniPacket = new UniPacket(true);
        localUniPacket.setEncodeName("utf-8");
        localUniPacket.setServantName("StatSvc");
        localUniPacket.setFuncName("RspMSFForceOffline");
        localUniPacket.put("RspMSFForceOffline", paramToServiceMsg);
        localToServiceMsg.setMsfCommand(MsfCommand._msf_kickedAndCleanTokenResp);
        localToServiceMsg.setNeedCallback(false);
        localToServiceMsg.putWupBuffer(localUniPacket.encode());
        localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
        localToServiceMsg.setAppId(this.s.getMsfAppid());
        localToServiceMsg.setTimeout(30000L);
        localToServiceMsg.addAttribute(localToServiceMsg.getServiceCmd(), paramFromServiceMsg);
        this.s.sender.b(localToServiceMsg);
        return true;
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("MSF.C.SSORespHandler", 2, "send offlineResp error " + paramFromServiceMsg);
          }
        }
      }
    }
    return false;
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(paramFromServiceMsg);
    Object localObject = new UniPacket(true);
    ((UniPacket)localObject).setEncodeName("UTF-8");
    ((UniPacket)localObject).decode(paramFromServiceMsg.getWupBuffer());
    paramToServiceMsg = (k)((UniPacket)localObject).getByClass("RespondHeader", new k());
    VerifyCodeInfo localVerifyCodeInfo = new VerifyCodeInfo();
    localVerifyCodeInfo.ssoSeq = paramFromServiceMsg.getRequestSsoSeq();
    localVerifyCodeInfo.wupSeq = paramToServiceMsg.c;
    switch (paramToServiceMsg.b)
    {
    }
    for (;;)
    {
      VerifyCodeInfo.putVerifyCodeInfo(paramFromServiceMsg, localVerifyCodeInfo);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.SSORespHandler", 2, "rece businessVerifyCode from:" + paramFromServiceMsg + " svrseqNo:" + localVerifyCodeInfo.svrSeqNo + " vipsid:" + localVerifyCodeInfo.vpicSid + " wupSeq:" + localVerifyCodeInfo.wupSeq);
      }
      return;
      localObject = (com.tencent.msf.service.protocol.security.i)((UniPacket)localObject).getByClass("RespondAuth", new com.tencent.msf.service.protocol.security.i());
      localVerifyCodeInfo.vpicSid = ((com.tencent.msf.service.protocol.security.i)localObject).c;
      localVerifyCodeInfo.svrSeqNo = paramToServiceMsg.e;
      localVerifyCodeInfo.verifyimage = ((com.tencent.msf.service.protocol.security.i)localObject).a;
      localVerifyCodeInfo.verifyNote = ((com.tencent.msf.service.protocol.security.i)localObject).b;
      continue;
      localObject = (com.tencent.msf.service.protocol.security.n)((UniPacket)localObject).getByClass("RespondVerifyPic", new com.tencent.msf.service.protocol.security.n());
      localVerifyCodeInfo.vpicSid = ((com.tencent.msf.service.protocol.security.n)localObject).b;
      localVerifyCodeInfo.svrSeqNo = paramToServiceMsg.e;
      localVerifyCodeInfo.verifyimage = ((com.tencent.msf.service.protocol.security.n)localObject).a;
      localVerifyCodeInfo.verifyNote = "";
      continue;
      localObject = (m)((UniPacket)localObject).getByClass("RespondRefreshVPic", new m());
      localVerifyCodeInfo.vpicSid = ((m)localObject).c;
      localVerifyCodeInfo.svrSeqNo = paramToServiceMsg.e;
      localVerifyCodeInfo.verifyimage = ((m)localObject).a;
      localVerifyCodeInfo.verifyNote = ((m)localObject).b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.n
 * JD-Core Version:    0.7.0.1
 */