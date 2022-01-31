package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class FunctionSearchResultGroupView
  implements ISearchResultGroupView
{
  protected View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private List jdField_a_of_type_JavaUtilList;
  private TextView b;
  
  public FunctionSearchResultGroupView(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130971529, paramViewGroup, false);
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362715));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375015));
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public LinearLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public TextView b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.FunctionSearchResultGroupView
 * JD-Core Version:    0.7.0.1
 */