package com.tencent.widget;

import java.util.HashMap;

public class ActionMenuItem
{
  public int a;
  public String a;
  public HashMap a;
  public int b;
  public int c;
  public int d;
  
  public ActionMenuItem(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramString, paramInt2, paramInt3, 1);
  }
  
  public ActionMenuItem(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.b = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt2;
    this.d = paramInt3;
    this.jdField_a_of_type_Int = paramInt4;
  }
  
  public ActionMenuItem(String paramString, int paramInt1, int paramInt2)
  {
    this(0, paramString, paramInt1, paramInt2);
  }
  
  public Object a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.widget.ActionMenuItem
 * JD-Core Version:    0.7.0.1
 */