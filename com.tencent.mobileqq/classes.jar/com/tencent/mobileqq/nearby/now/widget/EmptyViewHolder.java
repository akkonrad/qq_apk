package com.tencent.mobileqq.nearby.now.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EmptyViewHolder
  extends CommonViewHolder
{
  public EmptyViewHolder(View paramView)
  {
    super(paramView);
  }
  
  public static EmptyViewHolder a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return new EmptyViewHolder(LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.widget.EmptyViewHolder
 * JD-Core Version:    0.7.0.1
 */