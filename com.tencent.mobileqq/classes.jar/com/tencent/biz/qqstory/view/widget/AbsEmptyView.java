package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import oqr;
import oqs;

public abstract class AbsEmptyView
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private int jdField_c_of_type_Int = 0;
  private View jdField_c_of_type_AndroidViewView;
  private View d;
  
  public AbsEmptyView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AbsEmptyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (this.jdField_c_of_type_Int != paramInt) {}
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_c_of_type_Int == 0) && (paramInt == 3));
      this.jdField_c_of_type_Int = paramInt;
      this.d.setVisibility(8);
      if (paramInt == 0)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      if (paramInt == 3)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      if (paramInt == 1)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131371967));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131371966));
        return;
      }
      if (paramInt == 2)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362728));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131371969));
        return;
      }
    } while (paramInt != 4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.d.setVisibility(0);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2130970819, this);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131365225);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131371968);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131371965);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131368875));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362728));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131371969));
    this.d = super.findViewById(2131371970);
    this.jdField_a_of_type_Int = UIUtils.a(getContext());
    this.jdField_b_of_type_Int = a();
    a(0, true);
    super.postDelayed(new oqs(this), 500L);
  }
  
  public abstract int a();
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int, 1073741824), View.MeasureSpec.makeMeasureSpec(this.jdField_b_of_type_Int, 1073741824));
  }
  
  public void setRetryClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(null);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new oqr(this, paramOnClickListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.AbsEmptyView
 * JD-Core Version:    0.7.0.1
 */