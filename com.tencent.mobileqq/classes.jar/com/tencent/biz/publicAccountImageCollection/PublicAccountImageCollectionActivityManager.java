package com.tencent.biz.publicAccountImageCollection;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import java.util.Stack;

public class PublicAccountImageCollectionActivityManager
{
  private static int jdField_a_of_type_Int = 3;
  private static PublicAccountImageCollectionActivityManager jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionActivityManager;
  private static String jdField_a_of_type_JavaLangString = "PublicAccountImageCollectionActivityManager";
  private static Stack jdField_a_of_type_JavaUtilStack;
  
  public static PublicAccountImageCollectionActivityManager a()
  {
    if (jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionActivityManager == null) {
      jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionActivityManager = new PublicAccountImageCollectionActivityManager();
    }
    return jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionActivityManager;
  }
  
  private void b()
  {
    Activity localActivity = (Activity)jdField_a_of_type_JavaUtilStack.firstElement();
    if (localActivity != null)
    {
      localActivity.finish();
      jdField_a_of_type_JavaUtilStack.remove(localActivity);
    }
  }
  
  public int a()
  {
    if (jdField_a_of_type_JavaUtilStack != null)
    {
      int i = jdField_a_of_type_JavaUtilStack.size();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getActivityStackNum = " + i);
      }
      return i;
    }
    return 0;
  }
  
  public void a()
  {
    if ((jdField_a_of_type_JavaUtilStack != null) && (jdField_a_of_type_JavaUtilStack.size() > jdField_a_of_type_Int))
    {
      int j = jdField_a_of_type_JavaUtilStack.size();
      int k = jdField_a_of_type_Int;
      int i = 0;
      while (i < j - k)
      {
        b();
        i += 1;
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (jdField_a_of_type_JavaUtilStack == null) {
      jdField_a_of_type_JavaUtilStack = new Stack();
    }
    jdField_a_of_type_JavaUtilStack.add(paramActivity);
  }
  
  public void b(Activity paramActivity)
  {
    if ((jdField_a_of_type_JavaUtilStack != null) && (paramActivity != null)) {
      jdField_a_of_type_JavaUtilStack.remove(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionActivityManager
 * JD-Core Version:    0.7.0.1
 */