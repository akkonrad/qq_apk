package com.tencent.biz.anonymous;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import ko;

public class QQAnonymousDialog
  extends Dialog
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 291;
  public Context a;
  public Handler a;
  public LayoutInflater a;
  public View a;
  public ImageView a;
  public TextView a;
  public String a;
  public int e;
  public int f;
  
  public QQAnonymousDialog(Context paramContext)
  {
    super(paramContext, 2131624120);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(new ko(this));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903370, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297850));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297849));
  }
  
  public void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838422);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      return;
    case 3: 
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838416);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      return;
    }
    this.f = 0;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838421);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131362631));
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.setContentView(this.jdField_a_of_type_AndroidViewView);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    localLayoutParams.gravity = 17;
    paramBundle.setAttributes(localLayoutParams);
    setCanceledOnTouchOutside(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.anonymous.QQAnonymousDialog
 * JD-Core Version:    0.7.0.1
 */