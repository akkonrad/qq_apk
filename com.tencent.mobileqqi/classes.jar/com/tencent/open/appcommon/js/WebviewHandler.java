package com.tencent.open.appcommon.js;

import android.os.Handler;
import android.os.Message;
import com.tencent.smtt.sdk.WebView;
import hpf;

public class WebviewHandler
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      paramMessage = (hpf)paramMessage.obj;
    } while ((paramMessage == null) || (paramMessage.jdField_a_of_type_ComTencentSmttSdkWebView == null) || (paramMessage.jdField_a_of_type_JavaLangString == null));
    try
    {
      paramMessage.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramMessage.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.appcommon.js.WebviewHandler
 * JD-Core Version:    0.7.0.1
 */