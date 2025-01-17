package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import java.util.ArrayList;
import java.util.List;

public class DateCollectionListPageLoader$GetCollectionListEvent
  extends BasePageLoaderEvent
{
  public int a;
  public String a;
  public List a;
  public boolean e = true;
  
  public DateCollectionListPageLoader$GetCollectionListEvent(String paramString, ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    return "GetCollectionListEvent{isEnd=" + this.jdField_a_of_type_Boolean + ", isUpdated=" + this.e + ", isLocalData=" + this.b + ", isFirstPage=" + this.c + ", isRefreshFromLoadMore=" + this.d + ", collectionList=" + this.jdField_a_of_type_JavaUtilList + ", totalVideoCount=" + this.jdField_a_of_type_Int + ", context='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent
 * JD-Core Version:    0.7.0.1
 */