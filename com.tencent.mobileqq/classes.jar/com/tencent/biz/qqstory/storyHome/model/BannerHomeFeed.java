package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.BannerFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import java.util.ArrayList;
import java.util.List;

public class BannerHomeFeed
  extends CommentLikeHomeFeed
{
  public BannerHomeFeed(@NonNull BannerFeedItem paramBannerFeedItem)
  {
    super(paramBannerFeedItem);
  }
  
  public List a()
  {
    return new ArrayList(0);
  }
  
  public void a() {}
  
  public boolean a(qqstory_struct.StoryFeed paramStoryFeed)
  {
    qqstory_struct.BannerFeed localBannerFeed = (qqstory_struct.BannerFeed)paramStoryFeed.banner_feed.get();
    ((BannerFeedItem)this.a).covertFrom(paramStoryFeed.feed_id.get().toStringUtf8(), localBannerFeed);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.BannerHomeFeed
 * JD-Core Version:    0.7.0.1
 */