package com.tencent.biz.qqstory.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import oqg;
import oqh;

public class StoryNewGuideDialog
  extends Dialog
{
  protected TextView a;
  protected AnimationPoint a;
  
  public StoryNewGuideDialog(Context paramContext)
  {
    super(paramContext, 2131624205);
    paramContext = LayoutInflater.from(paramContext).inflate(2130970788, null);
    paramContext.setOnTouchListener(new oqg(this));
    super.setContentView(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint = ((AnimationPoint)super.findViewById(2131371921));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370057));
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setDuration(-1L);
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setOnAnimationListener(new oqh(this));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void dismiss()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.b();
    super.dismiss();
  }
  
  public void show()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.a();
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.StoryNewGuideDialog
 * JD-Core Version:    0.7.0.1
 */