package com.tencent.biz.pubaccount.util;

import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ReadinjoyH5ElementManager
{
  public static String a;
  private List a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "ReadinjoyH5ElementManager";
  }
  
  public ReadinjoyH5ElementManager()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        ReadinjoyH5ElementManager.H5Element localH5Element = (ReadinjoyH5ElementManager.H5Element)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localH5Element != null) && (paramString.equals(localH5Element.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_JavaUtilList.remove(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void a(String paramString, Rect paramRect)
  {
    if ((TextUtils.isEmpty(paramString)) || (a(paramString))) {
      return;
    }
    ReadinjoyH5ElementManager.H5Element localH5Element = new ReadinjoyH5ElementManager.H5Element();
    localH5Element.jdField_a_of_type_JavaLangString = paramString;
    localH5Element.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    this.jdField_a_of_type_JavaUtilList.add(localH5Element);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilList.isEmpty();
  }
  
  public boolean a(Point paramPoint)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "pt.x = " + paramPoint.x + "  pt.y=" + paramPoint.y);
    }
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        ReadinjoyH5ElementManager.H5Element localH5Element = (ReadinjoyH5ElementManager.H5Element)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localH5Element != null) && (localH5Element.jdField_a_of_type_AndroidGraphicsRect != null) && (localH5Element.jdField_a_of_type_AndroidGraphicsRect.contains(paramPoint.x, paramPoint.y))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        ReadinjoyH5ElementManager.H5Element localH5Element = (ReadinjoyH5ElementManager.H5Element)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localH5Element != null) && (paramString.equals(localH5Element.jdField_a_of_type_JavaLangString))) {
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadinjoyH5ElementManager
 * JD-Core Version:    0.7.0.1
 */