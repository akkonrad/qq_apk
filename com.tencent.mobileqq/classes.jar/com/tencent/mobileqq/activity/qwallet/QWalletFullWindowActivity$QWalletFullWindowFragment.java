package com.tencent.mobileqq.activity.qwallet;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import xaq;

public class QWalletFullWindowActivity$QWalletFullWindowFragment
  extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
{
  BroadcastReceiver a = new xaq(this);
  
  protected int a(Bundle paramBundle)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_close_camera");
    localIntentFilter.addAction("cn.abel.action.broadcast");
    BaseApplicationImpl.getApplication().registerReceiver(this.a, localIntentFilter);
    return super.a(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {}
    try
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.a);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletFullWindowActivity.QWalletFullWindowFragment
 * JD-Core Version:    0.7.0.1
 */