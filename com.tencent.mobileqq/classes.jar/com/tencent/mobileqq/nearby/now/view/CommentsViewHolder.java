package com.tencent.mobileqq.nearby.now.view;

import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.nearby.now.model.MedalInfo;
import com.tencent.mobileqq.nearby.now.utils.CommentsUtil;
import java.util.List;

public class CommentsViewHolder
{
  public ImageView a;
  public TextView a;
  public ImageView b;
  public TextView b;
  public ImageView c;
  public TextView c;
  public ImageView d;
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText(CommentsUtil.a(1000L * paramLong));
  }
  
  public void a(MedalInfo paramMedalInfo, int paramInt, Paint paramPaint, boolean paramBoolean)
  {
    paramInt = (int)(paramInt - (int)paramPaint.measureText(this.jdField_c_of_type_AndroidWidgetTextView.getText().toString()) - UITools.a(this.jdField_c_of_type_AndroidWidgetTextView.getContext(), 30.0F));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    if ((paramMedalInfo == null) || (paramMedalInfo.a == null) || (paramMedalInfo.a.size() < 0))
    {
      this.a.setMaxWidth(paramInt);
      return;
    }
    this.a.setMaxWidth(paramInt);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!paramString1.equals("")))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append("回复");
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-8947849), 0, localSpannableStringBuilder.length(), 17);
      int i = localSpannableStringBuilder.length();
      String str = paramString1;
      if (paramString1.length() > 6)
      {
        paramString1 = paramString1.substring(0, 6);
        str = paramString1 + "...";
      }
      localSpannableStringBuilder.append(str);
      localSpannableStringBuilder.append(": ");
      localSpannableStringBuilder.append(paramString2);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-16777216), i, str.length() + i, 17);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-8947849), i + str.length(), localSpannableStringBuilder.length(), 17);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
      return;
    }
    a(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.CommentsViewHolder
 * JD-Core Version:    0.7.0.1
 */