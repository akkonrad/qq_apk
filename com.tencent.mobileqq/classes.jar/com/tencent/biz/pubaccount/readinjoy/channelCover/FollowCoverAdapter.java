package com.tencent.biz.pubaccount.readinjoy.channelCover;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import java.util.ArrayList;
import java.util.List;
import lip;

public class FollowCoverAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      TopicRecommendFeedsInfo.TopicRecommendInfo localTopicRecommendInfo = new TopicRecommendFeedsInfo.TopicRecommendInfo();
      this.jdField_a_of_type_JavaUtilArrayList.add(localTopicRecommendInfo);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      paramList = new TopicRecommendFeedsInfo.TopicRecommendInfo();
      this.jdField_a_of_type_JavaUtilArrayList.add(paramList);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size() - 1)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
    if ((paramInt == 0) || (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size() - 1))
    {
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(AIOUtils.a(2.0F, (Resources)localObject1), AIOUtils.a(100.0F, (Resources)localObject1)));
      }
    }
    lip locallip;
    do
    {
      return paramViewGroup;
      if (paramView != null) {
        break;
      }
      locallip = new lip(null);
      paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(AIOUtils.a(100.0F, (Resources)localObject1), AIOUtils.a(100.0F, (Resources)localObject1)));
      paramViewGroup = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      paramViewGroup.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewGroup.setRadius(5.0F);
      paramViewGroup.d(false);
      locallip.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramViewGroup;
      paramView.addView(paramViewGroup);
      paramViewGroup = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      paramViewGroup.setRadius(5.0F);
      paramViewGroup.d(false);
      paramViewGroup.setBackgroundColor(1711276032);
      locallip.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView = paramViewGroup;
      paramView.addView(paramViewGroup);
      paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(AIOUtils.a(9.0F, (Resources)localObject1), AIOUtils.a(6.0F, (Resources)localObject1), AIOUtils.a(9.0F, (Resources)localObject1), 0);
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramViewGroup.setTextColor(-1);
      paramViewGroup.setTextSize(14.0F);
      paramViewGroup.setMaxLines(2);
      paramViewGroup.setEllipsize(TextUtils.TruncateAt.END);
      paramViewGroup.getPaint().setFakeBoldText(true);
      locallip.jdField_a_of_type_AndroidWidgetTextView = paramViewGroup;
      paramView.addView(paramViewGroup);
      paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(AIOUtils.a(8.0F, (Resources)localObject1), 0, 0, AIOUtils.a(8.0F, (Resources)localObject1));
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramViewGroup.setPadding(AIOUtils.a(5.0F, (Resources)localObject1), 0, AIOUtils.a(5.0F, (Resources)localObject1), 0);
      paramViewGroup.setTextColor(-7745469);
      paramViewGroup.setTextSize(11.0F);
      paramViewGroup.setBackgroundResource(2130840832);
      locallip.jdField_b_of_type_AndroidWidgetTextView = paramViewGroup;
      paramView.addView(paramViewGroup);
      paramView.setTag(locallip);
      localObject1 = (TopicRecommendFeedsInfo.TopicRecommendInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramViewGroup = paramView;
    } while (localObject1 == null);
    paramViewGroup = new ColorDrawable(-1);
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = paramViewGroup;
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = paramViewGroup;
    ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
    if (!TextUtils.isEmpty(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject1).d))
    {
      paramViewGroup = URLDrawable.getDrawable(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject1).d, (URLDrawable.URLDrawableOptions)localObject2);
      if (paramViewGroup.getStatus() == 2) {
        paramViewGroup.restartDownload();
      }
      locallip.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup = new StringBuilder();
      if (!TextUtils.isEmpty(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject1).c)) {
        paramViewGroup.append(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject1).c);
      }
      if (!TextUtils.isEmpty(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject1).a)) {
        paramViewGroup.append(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject1).a);
      }
      locallip.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.toString());
      if (((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject1).b > 0) {
        break label642;
      }
      locallip.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return paramView;
      locallip = (lip)paramView.getTag();
      break;
      locallip.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramViewGroup);
    }
    label642:
    if (((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject1).b < 1000)
    {
      locallip.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      locallip.jdField_b_of_type_AndroidWidgetTextView.setText("+" + ((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject1).b);
      return paramView;
    }
    locallip.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    locallip.jdField_b_of_type_AndroidWidgetTextView.setText("+999");
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelCover.FollowCoverAdapter
 * JD-Core Version:    0.7.0.1
 */