package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.qphone.base.util.QLog;

public abstract class TroopAppMgr$ClickReportObserver
  extends ProtoUtils.TroopProtocolObserver
{
  public TroopAppMgr$ClickReportObserver()
  {
    super(false);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i(".troop.troop_app", 2, "clickReport errorCode = " + paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
  
  public abstract void a(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAppMgr.ClickReportObserver
 * JD-Core Version:    0.7.0.1
 */