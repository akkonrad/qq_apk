package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.c.j.c;
import com.tencent.mobileqq.msf.core.net.b.o;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.core.push.f;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.a.a.b;
import com.tencent.mobileqq.msf.sdk.a.a.c;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.security.c;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class v
  implements a.b, a.c
{
  public static final String a = "MSF.D.NetCenterNewImpl";
  public static MsfCore b;
  public static final String c = "recordSysTimeKey";
  public static final int d = 100;
  private static final String k = "servetTimeDiff";
  private static long l = -1L;
  private static long m;
  int e;
  int f;
  int g;
  boolean h = true;
  private com.tencent.mobileqq.msf.sdk.a.a i;
  private String j = "MSF.C.NetConnInfoCenter";
  private ThreadLocal n = new ThreadLocal();
  private AtomicBoolean o = new AtomicBoolean(false);
  private ThreadLocal p = new ThreadLocal();
  private boolean q;
  private AtomicBoolean r = new AtomicBoolean();
  private long s;
  private long t;
  private int u;
  private long v;
  
  private v()
  {
    QLog.i("MSF.D.NetCenterNewImpl", 1, BaseApplication.processName + " create NetConnInfoCenterNewImpl instance");
    this.i = new com.tencent.mobileqq.msf.sdk.a.a();
    this.i.a(this);
    this.i.a(u.d());
  }
  
  private void E()
  {
    this.r.set(false);
    this.s = 0L;
  }
  
  private void F()
  {
    if ((this.i.i() > 0) && (this.r.get()))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_Reason", String.valueOf((System.currentTimeMillis() - this.s) / 1000L));
      localHashMap.put("param_connecttrycount", String.valueOf(this.i.i()));
      if (b.getStatReporter() != null) {
        b.getStatReporter().a("dim.Msf.NoNetInfoConnSucc", false, 0L, 0L, localHashMap, false, false);
      }
      E();
    }
  }
  
  private void G()
  {
    F();
    af.c("");
    af.d(0);
    I();
    if ((b != null) && (b.pushManager != null)) {
      b.pushManager.c();
    }
  }
  
  private void H()
  {
    if ((p()) && (b != null) && (b.standbyModeManager != null)) {
      b.standbyModeManager.d();
    }
  }
  
  private void I()
  {
    if ((b != null) && (b.sender != null) && (b.getStatReporter() != null)) {
      b.getStatReporter().i();
    }
  }
  
  private void J()
  {
    if (b != null)
    {
      localToServiceMsg = new ToServiceMsg("", "0", "login.time");
      localToServiceMsg.setMsfCommand(MsfCommand.getServerTime);
      if (b.sender.j() == -1)
      {
        i1 = 100;
        localToServiceMsg.setAppId(i1);
        localToServiceMsg.setTimeout(30000L);
        localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
        localUniPacket = new UniPacket(true);
        localUniPacket.setServantName("test");
        localUniPacket.setFuncName("cmdstr");
        locald = new com.tencent.msf.service.protocol.security.d(1, 15, MsfCore.getNextSeq(), 1, "0", b.sender.j(), String.valueOf(b.sender.j()), "123", 0);
        localc = new c();
        localc.a = ((int)(System.currentTimeMillis() / 1000L));
        localUniPacket.put("RequestHeader", locald);
        localUniPacket.put("RequestGetServerTime", localc);
        localToServiceMsg.putWupBuffer(localUniPacket.encode());
        b.sender.b(localToServiceMsg);
      }
    }
    while (!QLog.isDevelopLevel()) {
      for (;;)
      {
        ToServiceMsg localToServiceMsg;
        UniPacket localUniPacket;
        com.tencent.msf.service.protocol.security.d locald;
        c localc;
        return;
        int i1 = b.sender.j();
      }
    }
    QLog.d("MSF.D.NetCenterNewImpl", 4, "msfCore not inited. can not send checkServerTimeMsg.");
  }
  
  private void K()
  {
    if (b != null)
    {
      localToServiceMsg = new ToServiceMsg("", "0", "Client.CorrectTime");
      localToServiceMsg.setMsfCommand(MsfCommand.getServerTime);
      if (b.sender.j() == -1)
      {
        i1 = 100;
        localToServiceMsg.setAppId(i1);
        localToServiceMsg.setTimeout(30000L);
        localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
        localToServiceMsg.addAttribute("__base_tag_isAppMsg", Boolean.valueOf(true));
        localToServiceMsg.putWupBuffer(MsfSdkUtils.convertInt2Bytes(4));
        b.sender.b(localToServiceMsg);
      }
    }
    while (!QLog.isDevelopLevel()) {
      for (;;)
      {
        ToServiceMsg localToServiceMsg;
        return;
        int i1 = b.sender.j();
      }
    }
    QLog.d("MSF.D.NetCenterNewImpl", 4, "msfCore not inited. can not send checkServerTimeMsg.");
  }
  
  public static v a()
  {
    return a.a();
  }
  
  private void a(String paramString)
  {
    if ((b != null) && (b.sender != null))
    {
      b.sender.a.h.a(paramString);
      if (b.standbyModeManager != null) {
        b.standbyModeManager.e();
      }
    }
  }
  
  public int A()
  {
    if ((this.e == 0) && (o())) {
      D();
    }
    return this.e;
  }
  
  public int B()
  {
    return this.g;
  }
  
  public int C()
  {
    return this.f;
  }
  
  public void D()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.h;
        if (!bool) {
          break label144;
        }
        try
        {
          Object localObject1 = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
          if (localObject1 != null)
          {
            localObject1 = ((WifiManager)localObject1).getConnectionInfo();
            if (localObject1 == null) {
              continue;
            }
            i1 = 1;
            if (((WifiInfo)localObject1).getBSSID() == null) {
              continue;
            }
            i2 = 1;
            if ((i2 & i1) != 0) {
              this.e = WifiManager.calculateSignalLevel(((WifiInfo)localObject1).getRssi(), 32);
            }
          }
        }
        catch (Exception localException)
        {
          int i1;
          int i2;
          QLog.d("MSF.D.NetCenterNewImpl", 1, "check WifiState error " + localException, localException);
          this.h = false;
          continue;
        }
        com.tencent.mobileqq.a.a.a.a().a(0, this.e);
        return;
      }
      finally {}
      i1 = 0;
      continue;
      i2 = 0;
      continue;
      label144:
      this.e = 0;
    }
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.D.NetCenterNewImpl", 4, "handleGetServerTimeResp servertime is " + paramLong);
    }
    NetConnInfoCenter.servetTimeSecondInterv = paramLong - System.currentTimeMillis() / 1000L;
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(this.j, 0).edit();
    localEditor.putLong("servetTimeDiff", NetConnInfoCenter.servetTimeSecondInterv);
    localEditor.commit();
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.NetCenterNewImpl", 2, "set serverTime is " + b.timeFormatter.format(Long.valueOf(System.currentTimeMillis() + NetConnInfoCenter.servetTimeSecondInterv * 1000L)));
    }
    MsfCore.initAppProMsg("*", b.sender.j());
  }
  
  public void a(Context paramContext)
  {
    Object localObject = new c(null);
    ((TelephonyManager)paramContext.getSystemService("phone")).listen((PhoneStateListener)localObject, 256);
    localObject = new d(null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.RSSI_CHANGED");
    paramContext.registerReceiver((BroadcastReceiver)localObject, localIntentFilter);
  }
  
  public void a(Context paramContext, NetworkInfo paramNetworkInfo, boolean paramBoolean)
  {
    this.n.set(Boolean.valueOf(paramBoolean));
    if (this.o.compareAndSet(false, true)) {
      this.i.a(paramContext, paramNetworkInfo);
    }
  }
  
  public void a(MsfCore paramMsfCore)
  {
    b = paramMsfCore;
    NetConnInfoCenter.servetTimeSecondInterv = BaseApplication.getContext().getSharedPreferences(this.j, 0).getLong("servetTimeDiff", 0L);
    a(BaseApplication.getContext());
    if (Build.VERSION.SDK_INT >= 23) {
      c(BaseApplication.getContext());
    }
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    NetConnInfoCenter.socketConnState = 1;
    if ((b != null) || (b.pushManager != null)) {
      try
      {
        b.pushManager.a(parama);
        if ((b.standbyModeManager != null) && (!b.standbyModeManager.b()))
        {
          parama = new FromServiceMsg(b.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_connClosed");
          parama.setMsgSuccess();
          parama.setMsfCommand(MsfCommand.onConnClosed);
          MsfSdkUtils.addFromMsgProcessName("*", parama);
          b.addRespToQuque(null, parama);
          return;
        }
        QLog.d("MSF.D.NetCenterNewImpl", 1, "onConnClosed, stop notify by standby");
        return;
      }
      catch (Exception parama)
      {
        QLog.d("MSF.D.NetCenterNewImpl", 1, "", parama);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && ((paramString1 == null) || (!paramString1.equals(paramString2))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.NetCenterNewImpl", 2, "SSID changed, new ssid :  " + paramString2 + " old ssid: " + paramString1);
      }
      if ((b != null) && (b.ssoListManager != null)) {
        b.ssoListManager.f();
      }
    }
  }
  
  public void b()
  {
    long l1 = SystemClock.uptimeMillis();
    this.p.set(Long.valueOf(l1));
  }
  
  protected void b(Context paramContext)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    if ((MsfCore.sCore == null) || (MsfCore.sCore.statReporter == null)) {
      return;
    }
    paramContext = (PowerManager)paramContext.getSystemService("power");
    for (;;)
    {
      try
      {
        localMethod = paramContext.getClass().getMethod("isDeviceIdleMode", new Class[0]);
        localMethod.setAccessible(true);
        bool2 = ((Boolean)localMethod.invoke(paramContext, new Object[0])).booleanValue();
        bool1 = bool3;
      }
      catch (Exception paramContext)
      {
        Method localMethod;
        boolean bool4;
        boolean bool2 = false;
        paramContext.printStackTrace();
        QLog.d("MSF.D.NetCenterNewImpl", 1, paramContext, new Object[0]);
        b.statReporter.a(bool2, 0L, 0L, 0L, 0L, bool1, false);
        return;
      }
      try
      {
        localMethod = paramContext.getClass().getMethod("isPowerSaveMode", new Class[0]);
        bool1 = bool3;
        localMethod.setAccessible(true);
        bool1 = bool3;
        bool3 = ((Boolean)localMethod.invoke(paramContext, new Object[0])).booleanValue();
        bool1 = bool3;
        localMethod = paramContext.getClass().getMethod("isInteractive", new Class[0]);
        bool1 = bool3;
        localMethod.setAccessible(true);
        bool1 = bool3;
        bool4 = ((Boolean)localMethod.invoke(paramContext, new Object[0])).booleanValue();
        l1 = 0L;
        l2 = 0L;
        l6 = 0L;
        if (b.statReporter.Q == null) {
          b.statReporter.Q = new j.c();
        }
        b.statReporter.Q.a = bool2;
        if (!bool2) {
          break label606;
        }
        b.statReporter.Q.b = System.currentTimeMillis();
        if (b.statReporter.Q.c > 0L) {
          l1 = System.currentTimeMillis() - b.statReporter.Q.c;
        }
        l3 = l6;
        if (b.statReporter.Q.e > 0L)
        {
          l4 = System.currentTimeMillis() - b.statReporter.Q.e;
          l3 = l6;
          l2 = l4;
          if (b.statReporter.Q.f > 0L)
          {
            l3 = b.statReporter.Q.f - b.statReporter.Q.e;
            l2 = l4;
          }
        }
        l5 = l1;
        l6 = l3;
        l4 = l2;
        if (b.pushManager == null) {
          break label754;
        }
        b.pushManager.a(b.pushManager.e());
        b.pushManager.o = System.currentTimeMillis();
        l5 = 0L;
        l4 = l3;
        l3 = l5;
      }
      catch (Exception paramContext)
      {
        continue;
        l3 = 0L;
        l1 = l5;
        l2 = l4;
        l4 = l6;
        continue;
      }
      paramContext = new StringBuilder(128);
      paramContext.append(" deviceIdleChanged: isDeviceIdleMode=").append(bool2);
      paramContext.append(" takeTimes=").append(l1);
      paramContext.append(" alarmCost=").append(l3);
      paramContext.append(" connFailCost=").append(l4);
      paramContext.append(" screenOffCost=").append(l2);
      paramContext.append(" isPowerSaveMode=").append(bool3);
      paramContext.append(" isInteractive=").append(bool4);
      QLog.d("MSF.D.NetCenterNewImpl", 1, paramContext.toString());
      if (l1 <= 0L) {
        break;
      }
      b.statReporter.a(bool2, l1, l3, l2, l4, bool3, bool4);
      return;
      label606:
      b.statReporter.Q.c = System.currentTimeMillis();
      b.statReporter.Q.e = 0L;
      b.statReporter.Q.f = 0L;
      l5 = l1;
      l4 = l2;
      if (b.statReporter.Q.b <= 0L) {
        break label754;
      }
      l1 = System.currentTimeMillis();
      l4 = b.statReporter.Q.b;
      l3 = b.statReporter.Q.d;
      b.statReporter.Q.d = 0L;
      if (b.pushManager != null) {
        b.pushManager.o = 0L;
      }
      l1 -= l4;
      l4 = 0L;
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && ((paramString1 == null) || (!paramString1.equals(paramString2))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.NetCenterNewImpl", 2, "Mobile APN changed, load sso list new apn :  " + paramString2 + " old apn: " + paramString1);
      }
      if ((b != null) && (b.ssoListManager != null)) {
        b.ssoListManager.e();
      }
    }
  }
  
  public void c()
  {
    this.o.set(false);
    long l1 = ((Long)this.p.get()).longValue();
    if ((!this.q) && (Math.abs(SystemClock.uptimeMillis() - ((Long)this.p.get()).longValue()) > 120000L))
    {
      this.q = true;
      QLog.w("MSF.D.NetCenterNewImpl", 1, "checkConnInfo refresh held 2min!!! enter=" + l1 + " now=" + System.currentTimeMillis());
      MsfCore.sCore.statReporter.a("", 0L);
    }
  }
  
  public void c(Context paramContext)
  {
    b localb = new b(null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
    paramContext.registerReceiver(localb, localIntentFilter);
  }
  
  public void c(String paramString1, String paramString2)
  {
    NetConnInfoCenter.socketConnState = 2;
    if (b == null)
    {
      QLog.d("MSF.D.NetCenterNewImpl", 1, "onConnOpened, return by msfCore null");
      return;
    }
    b.pushManager.d();
    if ((b.standbyModeManager != null) && (!b.standbyModeManager.b()))
    {
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(b.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_connOpened");
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localFromServiceMsg.setMsfCommand(MsfCommand.onConnOpened);
      localFromServiceMsg.addAttribute("resp_connopen_serverAdd", paramString1);
      localFromServiceMsg.addAttribute("resp_connopen_localAdd", paramString2);
      if (b.pushManager.b()) {
        localFromServiceMsg.addAttribute("resp_needBootApp", Integer.valueOf(1));
      }
      MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
      b.addRespToQuque(null, localFromServiceMsg);
      return;
    }
    if (b.standbyModeManager != null) {
      b.standbyModeManager.g();
    }
    QLog.d("MSF.D.NetCenterNewImpl", 1, "onConnOpened, stop notify by standby");
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.NetCenterNewImpl", 2, "wifiConnected");
    }
    try
    {
      WifiInfo localWifiInfo = ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getConnectionInfo();
      if (localWifiInfo != null)
      {
        int i1 = localWifiInfo.getIpAddress();
        if (QLog.isColorLevel()) {
          QLog.d("MSF.D.NetCenterNewImpl", 2, "wifiConnected localAddress " + i1 + "(" + NetConnInfoCenter.intToInetAddress(i1).getHostAddress() + "), " + localWifiInfo.toString());
        }
        if ((b != null) && (b.getStatReporter() != null)) {
          b.getStatReporter().a(localWifiInfo);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    D();
    a(this.i.k());
    G();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.NetCenterNewImpl", 2, "wifiDisConnected");
    }
    if ((b != null) && (b.sender != null)) {
      b.sender.a.h.a();
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.NetCenterNewImpl", 2, "mobileConnected");
    }
    H();
    G();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.NetCenterNewImpl", 2, "mobileDisConnected");
    }
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.NetCenterNewImpl", 2, "unknowConnected");
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.NetCenterNewImpl", 2, "unknowDisConnected");
    }
  }
  
  public boolean j()
  {
    return this.i.e();
  }
  
  public void k()
  {
    this.s = System.currentTimeMillis();
    this.r.set(true);
  }
  
  public int l()
  {
    if (o()) {
      return 2;
    }
    if (p()) {
      return 1;
    }
    return 0;
  }
  
  public NetworkInfo m()
  {
    return this.i.f();
  }
  
  public boolean n()
  {
    return (this.i.a()) || (this.i.b());
  }
  
  public boolean o()
  {
    return this.i.a();
  }
  
  public boolean p()
  {
    return this.i.b();
  }
  
  public void q()
  {
    if ((b != null) && (b.standbyModeManager != null) && (!b.standbyModeManager.b()))
    {
      NetConnInfoCenter.socketConnState = 3;
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(b.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_connAllFailed");
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localFromServiceMsg.setMsfCommand(MsfCommand.onOepnConnAllFailed);
      if (b.pushManager.b()) {
        localFromServiceMsg.addAttribute("resp_needBootApp", Integer.valueOf(1));
      }
      MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
      b.addRespToQuque(null, localFromServiceMsg);
    }
    for (;;)
    {
      if ((b != null) && (b.sender != null)) {
        b.sender.a.h.b();
      }
      return;
      QLog.d("MSF.D.NetCenterNewImpl", 1, "onOepnConnAllFailed, stop notify by standby");
    }
  }
  
  public String r()
  {
    return this.i.k();
  }
  
  public void s()
  {
    if ((o()) && (b != null) && (b.sender != null)) {
      b.sender.a.h.b(this.i.k());
    }
    if ((b.standbyModeManager != null) && (!b.standbyModeManager.b()))
    {
      NetConnInfoCenter.socketConnState = 4;
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(b.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_recvFirstResp");
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localFromServiceMsg.setMsfCommand(MsfCommand.onReceFirstResp);
      if (b.pushManager.b()) {
        localFromServiceMsg.addAttribute("resp_needBootApp", Integer.valueOf(1));
      }
      MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
      b.addRespToQuque(null, localFromServiceMsg);
      return;
    }
    QLog.d("MSF.D.NetCenterNewImpl", 1, "onRecvFirstResp, stop notify by standby");
  }
  
  public int t()
  {
    return this.i.g();
  }
  
  public String u()
  {
    return this.i.l();
  }
  
  public String v()
  {
    return this.i.h();
  }
  
  public int w()
  {
    int i1 = 0;
    if (o()) {
      i1 = this.i.i();
    }
    while (!p()) {
      return i1;
    }
    return this.i.g() + 10000;
  }
  
  public int x()
  {
    return this.i.i();
  }
  
  public void y()
  {
    System.currentTimeMillis();
    long l1 = SystemClock.elapsedRealtime();
    if ((l1 - this.v > 0L) && (l1 - this.v <= com.tencent.mobileqq.msf.core.a.a.J()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.NetCenterNewImpl", 2, "quit to checkTimeMsg too frequency.");
      }
      return;
    }
    if (this.u < 10)
    {
      K();
      this.u += 1;
      this.v = l1;
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if ((this.t == 0L) || (l1 - this.t > 600000L))
      {
        this.t = l1;
        this.u = 0;
      }
      l = l2;
      if (MsfStore.getNativeConfigStore() == null) {
        break;
      }
      MsfStore.getNativeConfigStore().n_setConfig("recordSysTimeKey", String.valueOf(l2));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.NetCenterNewImpl", 2, "also send checkTimeMsg " + this.u);
      }
    }
  }
  
  public void z()
  {
    try
    {
      long l1 = SystemClock.elapsedRealtime();
      if ((0L != m) && (l1 > m + com.tencent.mobileqq.msf.core.a.a.M()))
      {
        m = l1;
        String str;
        if ((-1L == l) && (MsfStore.getNativeConfigStore() != null))
        {
          str = MsfStore.getNativeConfigStore().getConfig("recordSysTimeKey");
          if (str == null) {}
        }
        try
        {
          l = Long.parseLong(str);
          l1 = System.currentTimeMillis();
          if (-1L != l)
          {
            if (l1 <= l + com.tencent.mobileqq.msf.core.a.a.K() + Math.random() * com.tencent.mobileqq.msf.core.a.a.L()) {
              return;
            }
            y();
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.D.NetCenterNewImpl", 2, "get lastCheckTime catch Exception " + localException1);
            }
          }
        }
      }
      return;
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.D.NetCenterNewImpl", 2, "checkRecordTime catch Exception " + localException2);
        return;
        l = l1;
        if (MsfStore.getNativeConfigStore() != null)
        {
          MsfStore.getNativeConfigStore().n_setConfig("recordSysTimeKey", String.valueOf(l));
          return;
          if (0L == m) {
            m = l1;
          }
        }
      }
    }
  }
  
  private static class a
  {
    private static final v a = new v(null);
  }
  
  private class b
    extends BroadcastReceiver
  {
    private b() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent == null) {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.D.NetCenterNewImpl", 2, "idleChaned receive broadcast intent == null return");
        }
      }
      do
      {
        do
        {
          return;
          QLog.d("MSF.D.NetCenterNewImpl", 1, "idleChaned receive broadcast " + paramIntent);
          if (paramIntent.getAction() != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("MSF.D.NetCenterNewImpl", 2, "idleChaned receive broadcast intent.getAction() == null return");
        return;
      } while ((!paramIntent.getAction().equals("android.os.action.DEVICE_IDLE_MODE_CHANGED")) || (Build.VERSION.SDK_INT < 23));
      v.this.b(paramContext);
    }
  }
  
  private class c
    extends PhoneStateListener
  {
    private c() {}
    
    public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
    {
      super.onSignalStrengthsChanged(paramSignalStrength);
      int i = paramSignalStrength.getCdmaDbm();
      v.this.g = i;
      int j = paramSignalStrength.getGsmSignalStrength();
      i = j;
      if (j == 99) {
        i = -3;
      }
      v.this.f = i;
      v.this.D();
    }
  }
  
  private class d
    extends BroadcastReceiver
  {
    private d() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      v.this.D();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.v
 * JD-Core Version:    0.7.0.1
 */