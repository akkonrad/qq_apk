package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.token.ah;
import com.tencent.token.global.e;

public class StartPwdDigitVerifyActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final int VERIFY_REASON_DEL_PWD = 3;
  public static final int VERIFY_REASON_DUALMSG = 5;
  public static final int VERIFY_REASON_MODIFY_PWD = 2;
  public static final int VERIFY_REASON_SAFEMSG = 4;
  public static final int VERIFY_REASON_WELCOME = 1;
  int mEnterType = 1;
  EditText mTokenPwdInpuText = null;
  private long mUin = 0L;
  
  private void hideKeyBoard()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
  }
  
  protected int getBtnStringId()
  {
    if (1 == this.mEnterType) {
      return 2131361940;
    }
    return 2131361800;
  }
  
  public void onClick(View paramView)
  {
    if (ah.a().a(this.mTokenPwdInpuText.getText().toString()))
    {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
      e.a("verify_token_pwd: " + this.mEnterType);
      setResult(257);
      finish();
      return;
    }
    showToast(2131361942);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getBundleExtra("com.tencent.input_param");
    if (paramBundle != null)
    {
      this.mEnterType = paramBundle.getInt("enter_type");
      this.mUin = paramBundle.getLong("uin");
    }
    setContentView(2130903254);
    paramBundle = findViewById(2131297299);
    paramBundle.setOnClickListener(this);
    ((Button)paramBundle).setText(getBtnStringId());
    setBtnWidth(paramBundle.getLayoutParams());
    this.mTokenPwdInpuText = ((EditText)findViewById(2131297298));
    if (this.mTokenPwdInpuText != null) {
      this.mTokenPwdInpuText.clearFocus();
    }
    e.a("verify_token_pwd: " + this.mEnterType + ", uin: " + this.mUin);
  }
  
  protected void setBtnWidth(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (1 == this.mEnterType) {
      paramLayoutParams.width = ((int)getResources().getDimension(2131230739));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdDigitVerifyActivity
 * JD-Core Version:    0.7.0.1
 */