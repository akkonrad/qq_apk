package com.tencent.biz.qqstory.storyHome.detail.model.cmment;

import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.lang.ref.WeakReference;

public class DetailGeneralCommentEventProxy$OnActionSheetButtonClickListener
  implements ActionSheet.OnButtonClickListener
{
  private final int jdField_a_of_type_Int;
  private final CommentEntry jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
  private final ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public DetailGeneralCommentEventProxy$OnActionSheetButtonClickListener(ActionSheet paramActionSheet, CommentEntry paramCommentEntry, int paramInt, DetailGeneralCommentEventProxy.ActionSheetEventCallback paramActionSheetEventCallback)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = paramActionSheet;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActionSheetEventCallback);
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
    SLog.a("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on action sheet item click. item is %s.", paramView);
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
    {
      SLog.e("Q.qqstory.detail.DetailGeneralCommentEventProxy", "callback is null when action sheet item click.");
      return;
    }
    DetailGeneralCommentEventProxy.ActionSheetEventCallback localActionSheetEventCallback = (DetailGeneralCommentEventProxy.ActionSheetEventCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ("删除".equals(paramView)) {
      localActionSheetEventCallback.a(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if ("回复".equals(paramView)) {
        localActionSheetEventCallback.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, this.jdField_a_of_type_Int);
      } else if ("举报".equals(paramView)) {
        localActionSheetEventCallback.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      } else if ("重发".equals(paramView)) {
        localActionSheetEventCallback.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      } else if ("复制".equals(paramView)) {
        localActionSheetEventCallback.c(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailGeneralCommentEventProxy.OnActionSheetButtonClickListener
 * JD-Core Version:    0.7.0.1
 */