package com.tencent.biz.qqstory.network.request;

import java.util.List;

public class BatchGetFeedLikeRequest$FeedLikeInfo
{
  public int a;
  public String a;
  public List a;
  public int b;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (FeedLikeInfo)paramObject;
      if (this.a != null) {
        return this.a.equals(paramObject.a);
      }
    } while (paramObject.a == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.a != null) {
      return this.a.hashCode();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.BatchGetFeedLikeRequest.FeedLikeInfo
 * JD-Core Version:    0.7.0.1
 */