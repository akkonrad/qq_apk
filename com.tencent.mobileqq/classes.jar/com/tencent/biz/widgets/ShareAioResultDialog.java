package com.tencent.biz.widgets;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import pej;
import pek;

public class ShareAioResultDialog
  extends Dialog
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  private TextView c;
  
  public ShareAioResultDialog(Context paramContext)
  {
    super(paramContext, 2131624516);
    super.setContentView(2130969726);
    super.getWindow().setWindowAnimations(2131624572);
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364037));
    this.b = ((TextView)super.findViewById(2131364038));
    this.c = ((TextView)super.findViewById(2131364587));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131364586));
    this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-7745469, PorterDuff.Mode.MULTIPLY);
  }
  
  public void a(DialogInterface.OnClickListener paramOnClickListener)
  {
    if (ChatActivityConstants.N)
    {
      Resources localResources = getContext().getResources();
      this.b.setContentDescription(localResources.getString(2131432759, new Object[] { localResources.getString(2131430150) }));
    }
    this.b.setOnClickListener(new pek(this, paramOnClickListener));
  }
  
  public void a(String paramString)
  {
    if (this.c != null) {
      this.c.setText(paramString);
    }
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    if (ChatActivityConstants.N)
    {
      Resources localResources = getContext().getResources();
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localTextView.setContentDescription(localResources.getString(2131432759, new Object[] { str }));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new pej(this, paramOnClickListener));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.widgets.ShareAioResultDialog
 * JD-Core Version:    0.7.0.1
 */