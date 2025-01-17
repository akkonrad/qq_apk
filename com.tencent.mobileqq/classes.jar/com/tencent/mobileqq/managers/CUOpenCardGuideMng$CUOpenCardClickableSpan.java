package com.tencent.mobileqq.managers;

import aeev;
import aeew;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;

public class CUOpenCardGuideMng$CUOpenCardClickableSpan
  extends ClickableSpan
{
  public final int a;
  final Context jdField_a_of_type_AndroidContentContext;
  final String jdField_a_of_type_JavaLangString;
  final int jdField_b_of_type_Int;
  final String jdField_b_of_type_JavaLangString;
  
  public CUOpenCardGuideMng$CUOpenCardClickableSpan(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = Color.parseColor("#00a5e0");
    ThreadManager.post(new aeev(this), 5, null, false);
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    paramView.putExtra("uin", this.jdField_b_of_type_JavaLangString);
    paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
    paramView.putExtra("hide_more_button", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    ThreadManager.post(new aeew(this), 5, null, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.jdField_b_of_type_Int);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.managers.CUOpenCardGuideMng.CUOpenCardClickableSpan
 * JD-Core Version:    0.7.0.1
 */