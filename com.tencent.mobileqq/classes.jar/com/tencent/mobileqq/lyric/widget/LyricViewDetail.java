package com.tencent.mobileqq.lyric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

public class LyricViewDetail
  extends LyricView
{
  public LyricViewDetail(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = LayoutInflater.from(paramContext).inflate(2130968715, this);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll = ((LyricViewScroll)paramContext.findViewById(2131363396));
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal = ((LyricViewInternal)paramContext.findViewById(2131363397));
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.a(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewAttribute);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.setScrollEnable(this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewDetail
 * JD-Core Version:    0.7.0.1
 */