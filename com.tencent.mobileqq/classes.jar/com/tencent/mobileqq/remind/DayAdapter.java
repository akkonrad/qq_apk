package com.tencent.mobileqq.remind;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.widget.VerticalGallery.LayoutParams;

public class DayAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 25;
  private Context jdField_a_of_type_AndroidContentContext;
  private int b;
  private int c;
  
  public DayAdapter(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.b = paramContext.getColor(2131494273);
    this.jdField_a_of_type_Int = ((int)TypedValue.applyDimension(1, paramInt, paramContext.getDisplayMetrics()));
    this.c = paramContext.getColor(2131494255);
  }
  
  public View a(int paramInt)
  {
    return getView(paramInt, null, null);
  }
  
  public int getCount()
  {
    return TimeHelper.jdField_a_of_type_Int;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    if (paramView == null)
    {
      paramViewGroup = new WheelTextView(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.setLayoutParams(new VerticalGallery.LayoutParams(-1, this.jdField_a_of_type_Int));
    }
    for (paramView = (WheelTextView)paramViewGroup;; paramView = (View)localObject)
    {
      localObject = paramView;
      if (paramView == null) {
        localObject = (WheelTextView)paramViewGroup;
      }
      paramView = TimeHelper.a(paramInt);
      ((WheelTextView)localObject).setTextSize(20.0F);
      ((WheelTextView)localObject).setTextColor(this.b);
      ((WheelTextView)localObject).setGravity(17);
      ((WheelTextView)localObject).setText(paramView);
      ((WheelTextView)localObject).setBackgroundColor(this.c);
      return paramViewGroup;
      paramViewGroup = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.remind.DayAdapter
 * JD-Core Version:    0.7.0.1
 */