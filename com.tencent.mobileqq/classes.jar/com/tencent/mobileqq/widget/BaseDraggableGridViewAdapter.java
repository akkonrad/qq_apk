package com.tencent.mobileqq.widget;

import aktz;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class BaseDraggableGridViewAdapter
{
  DraggableGridView a;
  
  public abstract int a();
  
  public abstract int a(int paramInt);
  
  public abstract View a(LayoutInflater paramLayoutInflater, int paramInt1, int paramInt2, ViewGroup paramViewGroup);
  
  public abstract View a(LayoutInflater paramLayoutInflater, int paramInt, ViewGroup paramViewGroup);
  
  public abstract Object a(int paramInt);
  
  public abstract Object a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void a(View paramView, int paramInt);
  
  public abstract void a(View paramView, int paramInt1, int paramInt2);
  
  public int b()
  {
    return 1;
  }
  
  public int b(int paramInt)
  {
    return 0;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.a.a(paramInt1, paramInt2);
  }
  
  public void c()
  {
    ((aktz)this.a.a()).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BaseDraggableGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */