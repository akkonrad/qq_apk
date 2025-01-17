package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.reactive.SimpleObserver;

public class FeedListPageLoaderBase$RequestFeedObserver
  extends SimpleObserver
{
  public FeedListPageLoaderBase$RequestFeedObserver(FeedListPageLoaderBase paramFeedListPageLoaderBase) {}
  
  public void a(FeedListPageLoaderBase.FeedData paramFeedData)
  {
    super.onNext(paramFeedData);
    this.a.b();
    SLog.b("Q.qqstory.home.data.FeedListPageLoaderBase", "refresh data finish %s", paramFeedData);
    paramFeedData.d = this.a.jdField_a_of_type_Boolean;
    this.a.a(paramFeedData.a, paramFeedData.c);
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache.b();
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$OnFeedItemPageLoadListener.a(paramFeedData);
    this.a.a("Q.qqstory.home.data.FeedListPageLoaderBase");
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.d("Q.qqstory.home.data.FeedListPageLoaderBase", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    paramError = (ErrorMessage)paramError;
    paramError = this.a.a(paramError);
    paramError.d = this.a.jdField_a_of_type_Boolean;
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$OnFeedItemPageLoadListener.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.RequestFeedObserver
 * JD-Core Version:    0.7.0.1
 */