package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;

public class GuideViewHolder
  extends BaseViewHolder
{
  public GuideViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.itemView.setTag(Integer.valueOf(3));
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (TextUtils.isEmpty(paramMsgTabNodeInfo.c)) {}
    for (paramMsgTabNodeInfo = "日迹介绍";; paramMsgTabNodeInfo = paramMsgTabNodeInfo.c)
    {
      localTextView.setText(paramMsgTabNodeInfo);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843571);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.GuideViewHolder
 * JD-Core Version:    0.7.0.1
 */