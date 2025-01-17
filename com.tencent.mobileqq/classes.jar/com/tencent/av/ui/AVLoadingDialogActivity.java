package com.tencent.av.ui;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import jqh;

public class AVLoadingDialogActivity
  extends BaseActivity
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new jqh(this);
  Handler jdField_a_of_type_AndroidOsHandler = new AVLoadingDialogActivity.MyHandler(this.jdField_a_of_type_JavaLangString);
  final String jdField_a_of_type_JavaLangString = "AVLoadingDialogActivity_" + AudioHelper.a();
  
  Dialog a()
  {
    Dialog localDialog = new Dialog(this, 2131624516);
    localDialog.setContentView(2130969180);
    localDialog.setCancelable(false);
    TextView localTextView = (TextView)localDialog.findViewById(2131363399);
    if (localTextView != null) {
      localTextView.setText(2131429519);
    }
    return localDialog;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "avideo doOnCreate");
    paramBundle = getIntent();
    String str = this.jdField_a_of_type_JavaLangString + ".doOnCreate";
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getExtras();; paramBundle = null)
    {
      AudioHelper.a(str, paramBundle);
      return bool;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "doOnDestroy");
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "doOnResume");
    showDialog(0);
    WeakReference localWeakReference = new WeakReference(this);
    Message localMessage = new Message();
    localMessage.what = 0;
    localMessage.obj = localWeakReference;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 300L);
    localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = localWeakReference;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 5000L);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return a();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.AVLoadingDialogActivity
 * JD-Core Version:    0.7.0.1
 */