package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class FeedInfoChangeEvent
  extends BaseEvent
{
  public final int a;
  public CommentLikeFeedItem a;
  public final String a;
  public int b = 0;
  public int c;
  
  public FeedInfoChangeEvent(int paramInt1, String paramString, int paramInt2)
  {
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  public FeedInfoChangeEvent(int paramInt1, String paramString, int paramInt2, CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  public String toString()
  {
    return "InteractionInfoChangeEvent{, feedId=" + this.jdField_a_of_type_JavaLangString + ", what=" + this.b + ", commentLikeFeedItem=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem + ", commentId=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedInfoChangeEvent
 * JD-Core Version:    0.7.0.1
 */