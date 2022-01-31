package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import java.util.ArrayList;
import java.util.List;

public class CommentListPageLoader$GetFeedCommentEvent
  extends BasePageLoaderEvent
{
  public int a;
  public String a;
  public List a;
  public int b;
  public String b;
  public int c;
  
  public CommentListPageLoader$GetFeedCommentEvent(ErrorMessage paramErrorMessage, String paramString, int paramInt)
  {
    super(paramErrorMessage);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt;
  }
  
  public String toString()
  {
    return "GetFeedCommentEvent{feedId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mType=" + this.jdField_a_of_type_Int + ", mSource=" + this.c + ", mCommentEntries=" + this.jdField_a_of_type_JavaUtilList.size() + ", mTotalCount=" + this.b + ", isEnd=" + this.jdField_a_of_type_Boolean + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.GetFeedCommentEvent
 * JD-Core Version:    0.7.0.1
 */