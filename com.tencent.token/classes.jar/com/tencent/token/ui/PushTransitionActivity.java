package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;

public class PushTransitionActivity
  extends BaseActivity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    IndexActivity.setFromWhere(19);
    if (BaseActivity.isAppOpen()) {}
    for (paramBundle = new Intent(this, IndexActivity.class);; paramBundle = new Intent(this, LogoActivity.class))
    {
      startActivity(paramBundle);
      finish();
      return;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.PushTransitionActivity
 * JD-Core Version:    0.7.0.1
 */