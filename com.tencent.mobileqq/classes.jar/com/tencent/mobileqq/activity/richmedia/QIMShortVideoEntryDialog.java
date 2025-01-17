package com.tencent.mobileqq.activity.richmedia;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.utils.StringUtil;

public class QIMShortVideoEntryDialog
  extends Dialog
  implements View.OnClickListener
{
  QIMShortVideoEntryDialog.IAdvertiseJumpDialogCallBack jdField_a_of_type_ComTencentMobileqqActivityRichmediaQIMShortVideoEntryDialog$IAdvertiseJumpDialogCallBack;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  String d;
  
  public QIMShortVideoEntryDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131624514);
    paramContext = getLayoutInflater().inflate(2130971575, null);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    super.setContentView(paramContext);
  }
  
  public void a()
  {
    if (!StringUtil.a(this.jdField_a_of_type_JavaLangString))
    {
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString);
      CornerImageView localCornerImageView = (CornerImageView)findViewById(2131375091);
      float f = (int)getContext().getResources().getDimension(2131559448);
      localCornerImageView.setRadius(new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F });
      localCornerImageView.setImageDrawable((Drawable)localObject);
    }
    if (!StringUtil.a(this.b)) {
      ((TextView)findViewById(2131375092)).setText(this.b);
    }
    int i;
    if (!StringUtil.a(this.c))
    {
      ((TextView)findViewById(2131375094)).setText(this.c);
      localObject = (RelativeLayout)findViewById(2131375093);
      ((RelativeLayout)localObject).setOnClickListener(this);
      if (!StringUtil.a(this.d)) {
        i = Color.parseColor("#57d4d9");
      }
    }
    try
    {
      int j = Color.parseColor(this.d);
      i = j;
    }
    catch (Exception localException)
    {
      label190:
      break label190;
    }
    ((GradientDrawable)((RelativeLayout)localObject).getBackground()).setColor(i);
    Object localObject = (ImageView)findViewById(2131363978);
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(this);
    }
  }
  
  public void a(QIMShortVideoEntryDialog.IAdvertiseJumpDialogCallBack paramIAdvertiseJumpDialogCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQIMShortVideoEntryDialog$IAdvertiseJumpDialogCallBack = paramIAdvertiseJumpDialogCallBack;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.c = paramString3;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.d = paramString4;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQIMShortVideoEntryDialog$IAdvertiseJumpDialogCallBack == null) || (paramView == null)) {}
    do
    {
      return;
      if (paramView.getId() == 2131375093)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQIMShortVideoEntryDialog$IAdvertiseJumpDialogCallBack.a();
        return;
      }
    } while (paramView.getId() != 2131363978);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaQIMShortVideoEntryDialog$IAdvertiseJumpDialogCallBack.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.QIMShortVideoEntryDialog
 * JD-Core Version:    0.7.0.1
 */