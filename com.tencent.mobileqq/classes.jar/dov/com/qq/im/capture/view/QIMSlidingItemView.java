package dov.com.qq.im.capture.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class QIMSlidingItemView
  extends LinearLayout
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QIMSlidingItemView.SlidingItemData jdField_a_of_type_DovComQqImCaptureViewQIMSlidingItemView$SlidingItemData;
  
  public QIMSlidingItemView(@NonNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QIMSlidingItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QIMSlidingItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setOrientation(0);
    setGravity(16);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(AIOUtils.a(13.0F, getResources()), AIOUtils.a(12.0F, getResources()));
    localLayoutParams.gravity = 17;
    addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = AIOUtils.a(4.0F, getResources());
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, paramInt1);
    setPadding(paramInt2, 0, paramInt2, 0);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    ImageView localImageView;
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label41;
      }
    }
    label41:
    for (paramInt = this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingItemView$SlidingItemData.b;; paramInt = this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingItemView$SlidingItemData.jdField_a_of_type_Int)
    {
      localImageView.setImageResource(paramInt);
      return;
    }
  }
  
  public void setData(QIMSlidingItemView.SlidingItemData paramSlidingItemData)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingItemView$SlidingItemData = paramSlidingItemData;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingItemView$SlidingItemData.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingItemView$SlidingItemData.jdField_a_of_type_Int != 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingItemView$SlidingItemData.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMSlidingItemView
 * JD-Core Version:    0.7.0.1
 */