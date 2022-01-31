package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import crr;

public class ForceLogoutActivity
  extends BaseActivity
  implements AppConstants
{
  protected boolean b()
  {
    finish();
    startActivity(new Intent(this, LoginActivity.class).addFlags(67108864));
    return true;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903234);
    paramBundle = getIntent().getStringExtra("title");
    String str = getIntent().getStringExtra("msg");
    if ((paramBundle != null) && (paramBundle.length() > 0)) {
      ((TextView)findViewById(2131231707)).setText(paramBundle);
    }
    if ((str != null) && (str.length() > 0)) {
      ((TextView)findViewById(2131231708)).setText(str);
    }
    ((Button)findViewById(2131231709)).setOnClickListener(new crr(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForceLogoutActivity
 * JD-Core Version:    0.7.0.1
 */