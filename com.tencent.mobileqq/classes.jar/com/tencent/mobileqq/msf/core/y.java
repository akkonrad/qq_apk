package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class y
  extends BroadcastReceiver
{
  y(x paramx) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.SCREEN_ON")) {
      x.a(this.a, true);
    }
    do
    {
      do
      {
        return;
        if (paramContext.equals("android.intent.action.SCREEN_OFF"))
        {
          x.a(this.a, false);
          return;
        }
      } while (!paramContext.equals("android.net.wifi.SCAN_RESULTS"));
      try
      {
        x.a(this.a);
        return;
      }
      catch (Throwable paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.e("QQWiFiScanManager", 2, "onReceive, SCAN_RESULTS_AVAILABLE_ACTION", paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.y
 * JD-Core Version:    0.7.0.1
 */