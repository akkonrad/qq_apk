package com.tencent.biz.pubaccount.readinjoy.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ChannelInfo;

public class ReadInJoyVideoInfoViewGroup
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter;
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private Set jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private final int c = 10;
  
  public ReadInJoyVideoInfoViewGroup(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public ReadInJoyVideoInfoViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  @TargetApi(11)
  public ReadInJoyVideoInfoViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    int j;
    int i;
    oidb_cmd0x68b.ChannelInfo localChannelInfo;
    int k;
    if ((getMeasuredWidth() != 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (!this.jdField_a_of_type_Boolean))
    {
      removeAllViews();
      j = getMeasuredWidth();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mLabelListObj != null)
      {
        i = 0;
        if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mLabelListObj.size())
        {
          localChannelInfo = (oidb_cmd0x68b.ChannelInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mLabelListObj.get(i);
          if (this.b == localChannelInfo.uint32_channel_id.get()) {
            k = j;
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      j = k;
      break;
      Object localObject2 = ReadInJoyUtils.a(localChannelInfo);
      k = j;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        continue;
      }
      Object localObject1 = new ReadInJoyVideoTopicTextView(this.jdField_a_of_type_AndroidContentContext);
      ((ReadInJoyVideoTopicTextView)localObject1).setTopicText((String)localObject2);
      int m = ((ReadInJoyVideoTopicTextView)localObject1).a();
      k = m;
      if (i != 0) {
        k = m + DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      }
      JSONObject localJSONObject;
      if (j > DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 1.0F) + k)
      {
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        if (i != 0) {
          ((LinearLayout.LayoutParams)localObject2).setMargins(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0, 0, 0);
        }
        ((ReadInJoyVideoTopicTextView)localObject1).setId(2131362202);
        ((ReadInJoyVideoTopicTextView)localObject1).setTag(localChannelInfo);
        if ((this.jdField_a_of_type_AndroidWidgetBaseAdapter instanceof ReadInJoyBaseAdapter)) {
          ((ReadInJoyVideoTopicTextView)localObject1).setOnClickListener((ReadInJoyBaseAdapter)this.jdField_a_of_type_AndroidWidgetBaseAdapter);
        }
        ((ReadInJoyVideoTopicTextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        addView((View)localObject1);
        if (!this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID))) {
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("channel_id", this.b);
        label306:
        if (localChannelInfo.uint32_is_topic.get() == 1)
        {
          localObject1 = "0X80088BA";
          label322:
          if (localChannelInfo.uint32_is_topic.get() != 1) {
            break label408;
          }
        }
        label408:
        for (localObject2 = "0X80088BA";; localObject2 = "0X8007BE5")
        {
          PublicAccountReportUtils.a(null, "", (String)localObject1, (String)localObject2, 0, 0, "2", "", localChannelInfo.uint32_channel_id.get() + "", VideoReporter.a("", "", "", "", localJSONObject), false);
          k = j - k;
          break;
          localObject1 = "0X8007BE5";
          break label322;
        }
        this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID));
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        break label306;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = getDefaultSize(0, paramInt1);
    int i = j;
    if (j == 0) {
      i = this.jdField_a_of_type_Int;
    }
    this.jdField_a_of_type_Int = i;
    super.onMeasure(paramInt1, paramInt2);
    a();
  }
  
  public void setArticleInfo(BaseArticleInfo paramBaseArticleInfo, BaseAdapter paramBaseAdapter, int paramInt, Set paramSet)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    this.b = paramInt;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyVideoInfoViewGroup
 * JD-Core Version:    0.7.0.1
 */