package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter;
import com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter.FeedPresenterListener;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter;
import com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListHomeFeed;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment;
import com.tencent.biz.qqstory.utils.UIUtils;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class MemoriesFeedSegment
  extends FeedSegment
  implements ProfileFeedPresenter.FeedPresenterListener
{
  public MemoriesFeedSegment(Context paramContext, Activity paramActivity, int paramInt, IMyStoryListView paramIMyStoryListView, boolean paramBoolean)
  {
    super(paramContext, paramActivity, paramInt, paramIMyStoryListView, paramBoolean);
  }
  
  private String a(String paramString)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(1, localCalendar1.get(1));
    localCalendar2.set(2, localCalendar1.get(2));
    localCalendar2.set(5, localCalendar1.get(5) - 1);
    localCalendar2.set(11, 0);
    localCalendar2.set(12, 0);
    localCalendar2.set(13, 0);
    paramString = UIUtils.a(paramString);
    if ((localCalendar1.get(1) + 0 == paramString[0]) && (localCalendar1.get(2) + 1 == paramString[1]) && (localCalendar1.get(5) + 0 == paramString[2])) {
      return "今天";
    }
    if ((localCalendar2.get(1) + 0 == paramString[0]) && (localCalendar2.get(2) + 1 == paramString[1]) && (localCalendar2.get(5) + 0 == paramString[2])) {
      return "昨天";
    }
    return paramString[1] + "月" + paramString[2] + "日";
  }
  
  private String a(String paramString1, String paramString2)
  {
    Calendar localCalendar = Calendar.getInstance();
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(1, localCalendar.get(1));
    ((Calendar)localObject).set(2, localCalendar.get(2));
    ((Calendar)localObject).set(5, localCalendar.get(5) - 1);
    ((Calendar)localObject).set(11, 0);
    ((Calendar)localObject).set(12, 0);
    ((Calendar)localObject).set(13, 0);
    localCalendar = null;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = String.valueOf(UIUtils.a(paramString1)[0]);
    }
    do
    {
      return paramString1;
      paramString2 = UIUtils.a(paramString2);
      localObject = UIUtils.a(paramString1);
      paramString1 = localCalendar;
    } while (paramString2[0] == localObject[0]);
    return String.valueOf(localObject[0]);
  }
  
  private void n()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void J_()
  {
    super.J_();
    n();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (!((ProfileFeedPresenter)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter).jdField_a_of_type_Boolean) {
        return 1;
      }
      if (((ProfileFeedPresenter)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter).jdField_a_of_type_JavaUtilList.size() > 0) {
        return super.a();
      }
    }
    return 0;
  }
  
  protected int a(int paramInt)
  {
    if (((ProfileFeedPresenter)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter).jdField_a_of_type_Boolean) {
      return super.a(paramInt);
    }
    return 4;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return paramBaseViewHolder.a();
    }
    return super.a(paramInt, paramBaseViewHolder, paramViewGroup);
  }
  
  @NonNull
  protected HomeFeedPresenter a(boolean paramBoolean)
  {
    return new ProfileFeedPresenter(this.jdField_a_of_type_Int, this, this, paramBoolean);
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970771, paramViewGroup, false));
    }
    return super.a(paramInt, paramViewGroup);
  }
  
  protected void a(int paramInt, BaseViewHolder paramBaseViewHolder, VideoListHomeFeed paramVideoListHomeFeed, QQUserUIItem paramQQUserUIItem)
  {
    Object localObject = (RelativeLayout)paramBaseViewHolder.a(2131371741);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramBaseViewHolder.a(2131371742);
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131371743);
    paramQQUserUIItem = (TextView)paramBaseViewHolder.a(2131371744);
    paramBaseViewHolder = (Button)paramBaseViewHolder.a(2131371726);
    ((RelativeLayout)localObject).setVisibility(0);
    localRelativeLayout.setVisibility(0);
    localTextView.setText(a(((StoryHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt)).a().date));
    localObject = a(paramVideoListHomeFeed.a());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramQQUserUIItem.setVisibility(0);
      paramQQUserUIItem.setText((CharSequence)localObject);
      if (paramVideoListHomeFeed.a().type != 3) {
        break label255;
      }
      if (!paramVideoListHomeFeed.a().getOwner().isSubscribe()) {
        break label188;
      }
      paramBaseViewHolder.setVisibility(8);
      paramInt = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      UIUtils.a(paramBaseViewHolder, paramInt, paramInt, paramInt, paramInt);
    }
    label188:
    label255:
    while (paramVideoListHomeFeed.a().type != 1) {
      for (;;)
      {
        return;
        paramQQUserUIItem.setVisibility(8);
        break;
        paramInt = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
        int i = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
        paramBaseViewHolder.setText("关注");
        paramBaseViewHolder.setVisibility(0);
        paramBaseViewHolder.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494214));
        paramBaseViewHolder.setBackgroundResource(2130843489);
        paramBaseViewHolder.setPadding(paramInt, i, paramInt, i);
      }
    }
    paramBaseViewHolder.setVisibility(8);
    paramBaseViewHolder.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493774));
    paramBaseViewHolder.setBackgroundDrawable(null);
    paramInt = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
    UIUtils.a(paramBaseViewHolder, paramInt, paramInt, paramInt, paramInt);
  }
  
  protected void a(int paramInt, BaseViewHolder paramBaseViewHolder, boolean paramBoolean)
  {
    Object localObject1 = (RelativeLayout)paramBaseViewHolder.a(2131371652);
    Object localObject2 = (TextView)paramBaseViewHolder.a(2131371739);
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131371740);
    localTextView.setVisibility(8);
    List localList = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a();
    String str = ((StoryHomeFeed)localList.get(paramInt)).a().date;
    paramBaseViewHolder = null;
    if (paramInt > 0) {
      paramBaseViewHolder = ((StoryHomeFeed)localList.get(paramInt - 1)).a().date;
    }
    paramBaseViewHolder = a(str, paramBaseViewHolder);
    if (TextUtils.isEmpty(paramBaseViewHolder)) {
      ((RelativeLayout)localObject1).setVisibility(8);
    }
    do
    {
      return;
      while (!((Iterator)localObject1).hasNext())
      {
        ((RelativeLayout)localObject1).setVisibility(0);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(paramBaseViewHolder);
        paramBaseViewHolder = UIUtils.a(str);
        localObject1 = ((ProfileFeedPresenter)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter).jdField_a_of_type_JavaUtilList.iterator();
      }
      localObject2 = (MomeriesYearNode)((Iterator)localObject1).next();
    } while (((MomeriesYearNode)localObject2).year != paramBaseViewHolder[0]);
    localTextView.setVisibility(0);
    localTextView.setText(String.format("共%d个小视频", new Object[] { Integer.valueOf(((MomeriesYearNode)localObject2).videoCount) }));
  }
  
  public void a(boolean paramBoolean)
  {
    c(paramBoolean);
  }
  
  public boolean a()
  {
    if (c()) {
      return super.a();
    }
    return true;
  }
  
  protected BaseViewHolder b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970726, paramViewGroup, false));
    paramViewGroup.a(2131371726).setOnClickListener(paramViewGroup);
    a(paramViewGroup);
    return paramViewGroup;
  }
  
  protected void b()
  {
    super.b();
    h();
  }
  
  protected int d_()
  {
    return super.d_() + 1;
  }
  
  public void f_(boolean paramBoolean)
  {
    super.f_(paramBoolean);
    if (paramBoolean) {
      h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesFeedSegment
 * JD-Core Version:    0.7.0.1
 */