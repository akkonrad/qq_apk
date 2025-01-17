package com.tencent.gdtad.views.viewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class GdtViewPagerAdapter
  extends PagerAdapter
{
  private List a;
  
  public View a(int paramInt)
  {
    if ((this.a == null) || (paramInt < 0) || (paramInt >= this.a.size())) {
      return null;
    }
    return (View)this.a.get(paramInt);
  }
  
  public void a(List paramList)
  {
    this.a = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.a.get(paramInt));
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.addView((View)this.a.get(paramInt));
    return this.a.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.views.viewpager.GdtViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */