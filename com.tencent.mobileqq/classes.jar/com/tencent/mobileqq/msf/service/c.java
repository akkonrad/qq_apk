package com.tencent.mobileqq.msf.service;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.push.f;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class c
{
  private static final String k = "MSF.S.AppProcessInfo";
  volatile boolean a = true;
  volatile long b = 0L;
  volatile boolean c = false;
  volatile long d = 0L;
  volatile boolean e = false;
  volatile long f = 0L;
  String g;
  String h;
  ConcurrentLinkedQueue i = new ConcurrentLinkedQueue();
  public m j;
  private IMsfServiceCallbacker l;
  
  public String a()
  {
    return this.g + "," + b() + "," + this.a;
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (this.j != null) {
      this.j.a(paramInt, paramLong1, paramLong2);
    }
  }
  
  public void a(int paramInt, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getUin();
    if (this.j != null) {
      this.j.a(paramInt);
    }
    while ((paramInt != 0) || (TextUtils.isEmpty(this.h))) {
      return;
    }
    paramInt = d.e.getUinPushStatus(str);
    l.a(BaseApplication.getContext(), this.g, str, this.h, paramInt, paramFromServiceMsg);
    MsfService.getCore().pushManager.i.a();
  }
  
  public void a(IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    this.l = paramIMsfServiceCallbacker;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.i.add(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
    d.d.a();
  }
  
  public void a(Exception paramException, boolean paramBoolean) {}
  
  public void a(String paramString)
  {
    this.h = paramString;
  }
  
  public void a(String paramString1, String paramString2, IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    this.g = paramString1;
    a(paramString2);
    if (paramIMsfServiceCallbacker != null)
    {
      a(paramIMsfServiceCallbacker);
      this.a = true;
    }
    for (;;)
    {
      this.d = 0L;
      this.c = false;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.S.AppProcessInfo", 2, paramString1 + " onAppBind, isAppConnected " + this.a);
      }
      if ((MsfService.getCore() != null) && (MsfService.getCore().getStatReporter() != null))
      {
        paramString2 = new HashMap();
        paramString2.put("appProcessName", paramString1);
        if (MsfService.getCore().getStatReporter() != null) {
          MsfService.getCore().getStatReporter().a("dim.Msf.AppConnectFail", this.a, 0L, 0L, paramString2, false, false);
        }
      }
      if (this.j != null) {
        this.j.a(paramIMsfServiceCallbacker);
      }
      return;
      if (c() == null) {
        this.a = false;
      } else {
        this.a = true;
      }
    }
  }
  
  public String b()
  {
    return this.h;
  }
  
  public IMsfServiceCallbacker c()
  {
    return this.l;
  }
  
  public void d()
  {
    a(null);
    this.a = false;
    this.c = false;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.S.AppProcessInfo", 2, this.g + " setAppDisConnected, isAppConnected " + this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.c
 * JD-Core Version:    0.7.0.1
 */