package com.tencent.mobileqq.dating.widget;

import android.content.res.Resources;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.dating.DatingUtil;

public class DatingCommentTextView$ViewProfileCardSpan
  extends ClickableSpan
{
  private long jdField_a_of_type_Long;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private String jdField_a_of_type_JavaLangString;
  
  public void onClick(View paramView)
  {
    if ((paramView == null) || (!(paramView instanceof TextView))) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Long > 0L) {
        DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, null, 18, null, -1, -1, 0, false);
      }
      paramView = ((TextView)paramView).getText();
    } while ((paramView == null) || (!(paramView instanceof Spannable)));
    Selection.removeSelection((Spannable)paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131494305));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.dating.widget.DatingCommentTextView.ViewProfileCardSpan
 * JD-Core Version:    0.7.0.1
 */