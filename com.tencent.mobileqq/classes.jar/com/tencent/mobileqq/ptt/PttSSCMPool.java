package com.tencent.mobileqq.ptt;

import agtn;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.util.ArrayList;
import java.util.Iterator;

public class PttSSCMPool
{
  private static int jdField_a_of_type_Int = 5;
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString = PttSSCMPool.class.getSimpleName();
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  static
  {
    jdField_a_of_type_Long = 60000L;
  }
  
  public static SSCM a()
  {
    try
    {
      if (jdField_a_of_type_JavaUtilArrayList == null) {
        jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      Object localObject3 = b();
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject3 = new PttSSCM();
        ((SSCM)localObject3).a();
        jdField_a_of_type_JavaUtilArrayList.add(new agtn((SSCM)localObject3));
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "can't find sscm object, add new one, size= " + jdField_a_of_type_JavaUtilArrayList.size());
          localObject1 = localObject3;
        }
      }
      return localObject1;
    }
    finally {}
  }
  
  public static void a()
  {
    try
    {
      jdField_a_of_type_JavaUtilArrayList = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(SSCM paramSSCM)
  {
    for (;;)
    {
      agtn localagtn;
      try
      {
        Object localObject = jdField_a_of_type_JavaUtilArrayList;
        if (localObject == null) {}else {
          localObject = jdField_a_of_type_JavaUtilArrayList.iterator();
        }
        if (!((Iterator)localObject).hasNext()) {
          continue;
        }
        localagtn = (agtn)((Iterator)localObject).next();
        if (paramSSCM != localagtn.jdField_a_of_type_ComTencentWsttSSCMSSCM) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "return sscm, current size=" + jdField_a_of_type_JavaUtilArrayList.size());
        }
        if (jdField_a_of_type_JavaUtilArrayList.size() > jdField_a_of_type_Int)
        {
          ((Iterator)localObject).remove();
          continue;
        }
        localagtn.jdField_a_of_type_Boolean = false;
      }
      finally {}
      localagtn.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    }
  }
  
  private static SSCM b()
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Object localObject = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      agtn localagtn = (agtn)((Iterator)localObject).next();
      if (!localagtn.jdField_a_of_type_Boolean)
      {
        localObject = localagtn.jdField_a_of_type_ComTencentWsttSSCMSSCM;
        localagtn.jdField_a_of_type_Boolean = true;
        long l = SystemClock.elapsedRealtime();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "query for sscm, get one expired:" + (l - localagtn.jdField_a_of_type_Long));
        }
        if (l - localagtn.jdField_a_of_type_Long > jdField_a_of_type_Long) {
          localagtn.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
        }
        return localObject;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.PttSSCMPool
 * JD-Core Version:    0.7.0.1
 */