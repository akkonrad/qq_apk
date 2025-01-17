package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.widget.QQToast;

public class TroopLocationModifyActivity
  extends TroopCreateMapViewSupportActivity
{
  long jdField_a_of_type_Long = 0L;
  Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, TroopLocationModifyActivity.class);
    localIntent.putExtra("url", "http://admin.qun.qq.com/mcreatev3/location.html?_bid=206&from=edit&_wv=2097152");
    localIntent.putExtra("troopUin", paramString1);
    localIntent.putExtra("troopLocation", paramString2);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, TroopLocationModifyActivity.class);
    localIntent.putExtra("url", "http://admin.qun.qq.com/mcreatev3/location.html?_bid=206&from=edit&_wv=2097152");
    localIntent.putExtra("saveDirect", false);
    localIntent.putExtra("troopUin", paramString1);
    localIntent.putExtra("troopLocation", paramString2);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    if ((paramIntent == null) || (paramInt2 != -1))
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    int i = paramIntent.getIntExtra("errCode", -1);
    boolean bool = paramIntent.getBooleanExtra("isClear", false);
    String str = paramIntent.getStringExtra("location");
    int j = paramIntent.getIntExtra("lat", 0);
    int k = paramIntent.getIntExtra("lon", 0);
    if (i == 0)
    {
      if (bool) {
        QQToast.a(this, 2131435559, 0).b(getTitleBarHeight());
      }
      for (;;)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("location", str);
        localIntent.putExtra("lat", j);
        localIntent.putExtra("lon", k);
        setResult(-1, localIntent);
        finish();
        break;
        QQToast.a(this, 2131435557, 0).b(getTitleBarHeight());
      }
    }
    if (i == 1002) {
      str = getString(2131435561);
    }
    for (;;)
    {
      QQToast.a(this, str, 0).b(getTitleBarHeight());
      break;
      if (bool) {
        str = getString(2131435560);
      } else {
        str = getString(2131435558);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    String str = paramBundle.getString("troopUin");
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBundle.getBoolean("saveDirect", true));
    this.jdField_a_of_type_Long = Long.parseLong(str);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity
 * JD-Core Version:    0.7.0.1
 */