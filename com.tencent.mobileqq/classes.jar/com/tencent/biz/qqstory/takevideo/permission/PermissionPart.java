package com.tencent.biz.qqstory.takevideo.permission;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public abstract class PermissionPart
{
  protected final int a;
  protected Context a;
  public PermissionPart.PartCallback a;
  protected final String a;
  protected boolean a;
  protected boolean b;
  
  public PermissionPart(Context paramContext, String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public abstract int a();
  
  public abstract int a(int paramInt);
  
  public abstract View a(int paramInt, ViewGroup paramViewGroup);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, View paramView);
  
  public void a(PermissionPart.PartCallback paramPartCallback)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionPermissionPart$PartCallback = paramPartCallback;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.permission.PermissionPart
 * JD-Core Version:    0.7.0.1
 */