package com.tencent.mobileqq.activity.aio.zhitu;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class ZhituObserver
  implements BusinessObserver
{
  private Handler a;
  
  ZhituObserver(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramInt = paramBundle.getInt("ErrorCode");
    String str1 = paramBundle.getString("UniqueKey");
    if (QLog.isColorLevel()) {
      QLog.d("ZhituObserver", 2, ZhituManager.a(str1, "onReceive", "observer onReceive with code: " + paramInt));
    }
    String str2 = ZhituManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if (!str2.equals(str1)) {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituObserver", 2, ZhituManager.a(str1, "onReceive", "response with " + str1 + " but the last one is " + str2 + ", skip."));
      }
    }
    while (this.a == null) {
      return;
    }
    paramBundle = this.a.obtainMessage(2, paramBundle);
    this.a.sendMessage(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituObserver
 * JD-Core Version:    0.7.0.1
 */