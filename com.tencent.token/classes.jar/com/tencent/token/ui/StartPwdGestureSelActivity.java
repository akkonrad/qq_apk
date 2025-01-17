package com.tencent.token.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.ah;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.p;
import com.tencent.token.ui.base.SwitchButton;

public class StartPwdGestureSelActivity
  extends BaseActivity
{
  public static final int K_SEL2CLEAR_INTENT_REQUESTCODE = 256;
  public static final int K_SEL2CLEAR_INTENT_RESULTCODE = 257;
  public static final int K_SEL2MODIFY_INTENT_REQUESTCODE = 258;
  public static final int K_SEL2MODIFY_INTENT_RESULTCODE = 259;
  private Button mButtonClear;
  private Button mButtonModify;
  private boolean mIsChecked = false;
  private int mSetStartPwd;
  private SwitchButton mSwitchStartPwd;
  private TextView mTextOpName;
  
  private void initUI()
  {
    this.mButtonModify.setOnClickListener(new acb(this));
    this.mButtonClear.setOnClickListener(new acc(this));
    try
    {
      this.mSetStartPwd = RqdApplication.i().getSharedPreferences("start_pwd_config", 0).getInt("is_set_start_pwd_show", 1);
      if (this.mSetStartPwd == 1) {
        this.mSwitchStartPwd.a(false, false);
      }
      for (this.mIsChecked = true;; this.mIsChecked = false)
      {
        this.mSwitchStartPwd.setOnCheckedChangeListener(new acd(this));
        this.mTitleBar.setBackgroundColor(getResources().getColor(2131165236));
        this.mTitleDivider.setBackgroundColor(getResources().getColor(2131165298));
        this.mBackArrowImg.setImageDrawable(getResources().getDrawable(2130837537));
        this.mTitleText.setTextColor(getResources().getColor(2131165297));
        return;
        this.mSwitchStartPwd.a(true, false);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 256) {
      if (paramInt2 == 257)
      {
        p.a().a(System.currentTimeMillis(), 22);
        startActivity(new Intent(this, StartPwdUpdateInfoActivity.class));
        showOrangeToast(2131362155, 2130837966);
        finish();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (ah.a().c());
        finish();
        return;
      } while (paramInt1 != 258);
      if (paramInt2 == 259)
      {
        p.a().a(System.currentTimeMillis(), 16);
        showOrangeToast(2131362154, 2130837966);
        return;
      }
    } while (ah.a().c());
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903207);
    this.mButtonModify = ((Button)findViewById(2131297128));
    this.mButtonClear = ((Button)findViewById(2131297129));
    this.mSwitchStartPwd = ((SwitchButton)findViewById(2131297127));
    this.mTextOpName = ((TextView)findViewById(2131296280));
    initUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdGestureSelActivity
 * JD-Core Version:    0.7.0.1
 */