package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import java.util.HashMap;

public class BaseViewHolder
  implements View.OnClickListener, View.OnLongClickListener
{
  public int a;
  public SparseArray a;
  public View a;
  public ChildViewClickListener a;
  public Object a;
  public String a;
  public HashMap a;
  public int b;
  public SparseArray b;
  public int c = -1;
  
  public BaseViewHolder(View paramView)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    paramView.setTag(this);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public View a(int paramInt)
  {
    View localView2 = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localView1);
    }
    return localView1;
  }
  
  public Object a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a(ChildViewClickListener paramChildViewClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener = paramChildViewClickListener;
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramObject);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener.a(this.jdField_b_of_type_Int, paramView, this.jdField_a_of_type_JavaLangObject, this);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener.b(this.jdField_b_of_type_Int, paramView, this.jdField_a_of_type_JavaLangObject, this);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder
 * JD-Core Version:    0.7.0.1
 */