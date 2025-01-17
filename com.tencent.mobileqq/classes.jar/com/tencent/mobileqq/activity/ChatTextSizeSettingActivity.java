package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import java.util.ArrayList;
import sfg;

public class ChatTextSizeSettingActivity
  extends IphoneTitleBarActivity
{
  public int a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new sfg(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private ViewGroup c;
  private ViewGroup d;
  
  public ChatTextSizeSettingActivity()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public static int a(Context paramContext)
  {
    int i = paramContext.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    paramContext.getResources().getDimensionPixelSize(2131558422);
    switch (i)
    {
    default: 
      return paramContext.getResources().getDimensionPixelSize(2131558422);
    case 1: 
      return paramContext.getResources().getDimensionPixelSize(2131558423);
    case 2: 
      return paramContext.getResources().getDimensionPixelSize(2131558424);
    }
    return paramContext.getResources().getDimensionPixelSize(2131558425);
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = (ImageView)((ViewGroup)this.jdField_a_of_type_JavaUtilArrayList.get(i)).findViewById(2131363738);
      if (i == paramInt) {
        ((ImageView)localObject).setVisibility(0);
      }
      for (;;)
      {
        i += 1;
        break;
        ((ImageView)localObject).setVisibility(4);
      }
    }
    Object localObject = getSharedPreferences("setting_text_size", 0).edit();
    ((SharedPreferences.Editor)localObject).putInt("chat_text_size_type", paramInt);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130968777);
    setTitle(getString(2131433595));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131363735));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131363739));
    this.c = ((ViewGroup)findViewById(2131363740));
    this.d = ((ViewGroup)findViewById(2131363741));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.d);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.c.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(getResources().getDimensionPixelSize(2131558422)));
    this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(getResources().getDimensionPixelSize(2131558423)));
    this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(getResources().getDimensionPixelSize(2131558424)));
    this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(getResources().getDimensionPixelSize(2131558425)));
    this.jdField_a_of_type_Int = getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    a(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatTextSizeSettingActivity
 * JD-Core Version:    0.7.0.1
 */