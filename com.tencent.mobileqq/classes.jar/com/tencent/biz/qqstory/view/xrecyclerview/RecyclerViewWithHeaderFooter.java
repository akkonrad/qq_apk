package com.tencent.biz.qqstory.view.xrecyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecyclerViewWithHeaderFooter
  extends RecyclerView
{
  private RecyclerViewHeaderViewAdapter.ContentDataObserver jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewHeaderViewAdapter$ContentDataObserver;
  private final List jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  private final List b = new ArrayList();
  
  public RecyclerViewWithHeaderFooter(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecyclerViewWithHeaderFooter(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RecyclerViewWithHeaderFooter(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramView);
  }
  
  public void b(View paramView)
  {
    this.b.add(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      super.onInterceptTouchEvent(paramMotionEvent);
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramMotionEvent.getAction() == 1) {
        this.jdField_a_of_type_Boolean = false;
      }
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilList.size() <= 0)
    {
      localObject = paramAdapter;
      if (this.b.size() <= 0) {}
    }
    else
    {
      localObject = new RecyclerViewHeaderViewAdapter(paramAdapter);
      paramAdapter = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramAdapter.hasNext()) {
        ((RecyclerViewHeaderViewAdapter)localObject).a((View)paramAdapter.next());
      }
      paramAdapter = this.b.iterator();
      while (paramAdapter.hasNext()) {
        ((RecyclerViewHeaderViewAdapter)localObject).b((View)paramAdapter.next());
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewHeaderViewAdapter$ContentDataObserver != null) {
        ((RecyclerViewHeaderViewAdapter)localObject).a(this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewHeaderViewAdapter$ContentDataObserver);
      }
    }
    super.setAdapter((RecyclerView.Adapter)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.xrecyclerview.RecyclerViewWithHeaderFooter
 * JD-Core Version:    0.7.0.1
 */