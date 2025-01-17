package com.tencent.mobileqq.teamwork;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;

public class OpenDefaultBrowserQQText
  extends QQText
{
  public OpenDefaultBrowserQQText(CharSequence paramCharSequence, int paramInt)
  {
    super(paramCharSequence, paramInt);
  }
  
  protected void a(View paramView, String paramString)
  {
    paramString = Uri.parse(paramString);
    paramView = paramView.getContext();
    paramString = new Intent("android.intent.action.VIEW", paramString);
    paramString.putExtra("com.android.browser.application_id", paramView.getPackageName());
    try
    {
      paramView.startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramView)
    {
      QLog.w("OpenDefaultBrowserQQText", 1, "Activity was not found for intent, " + paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.OpenDefaultBrowserQQText
 * JD-Core Version:    0.7.0.1
 */