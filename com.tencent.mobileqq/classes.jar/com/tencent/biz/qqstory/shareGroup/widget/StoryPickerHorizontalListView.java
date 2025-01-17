package com.tencent.biz.qqstory.shareGroup.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import ntc;

@TargetApi(9)
public class StoryPickerHorizontalListView
  extends HorizontalListView
{
  int a;
  public StoryPickerHorizontalListAdapter a;
  public StoryPickerHorizontalListView.OnHorizontalScrollListener a;
  int b;
  
  public StoryPickerHorizontalListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public StoryPickerHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.b = DisplayUtil.a(paramContext, 105.0F);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListAdapter = new StoryPickerHorizontalListAdapter(getContext());
    super.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListAdapter);
    super.setOnItemClickListener(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListAdapter);
    super.setOnScrollStateChangedListener(new ntc(this));
    setOverScrollMode(1);
  }
  
  public BaseAdapter a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListAdapter;
  }
  
  public void setData(List paramList, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListAdapter.a(paramList, paramString);
    int i = this.jdField_a_of_type_Int / this.b;
    if (paramList.size() >= i)
    {
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public void setOnHorizontalScrollListener(StoryPickerHorizontalListView.OnHorizontalScrollListener paramOnHorizontalScrollListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$OnHorizontalScrollListener = paramOnHorizontalScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView
 * JD-Core Version:    0.7.0.1
 */