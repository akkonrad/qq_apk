package com.tencent.mobileqq.profile.like;

import SummaryCard.TPraiseInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class PraiseConfigHelper
{
  public static int a;
  public static Vector a;
  private static AtomicBoolean a;
  public static int b = 2000;
  public static int c;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_Int = 10;
  }
  
  public static List a(List paramList)
  {
    Object localObject = paramList;
    if (c == 0)
    {
      localObject = paramList;
      if (paramList != null)
      {
        localObject = paramList;
        if (!paramList.isEmpty())
        {
          localObject = new ArrayList();
          ArrayList localArrayList = new ArrayList();
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            TPraiseInfo localTPraiseInfo = (TPraiseInfo)paramList.next();
            if (localTPraiseInfo.uCustomId > 0L) {
              ((List)localObject).add(localTPraiseInfo);
            } else {
              localArrayList.add(localTPraiseInfo);
            }
          }
          ((List)localObject).addAll(localArrayList);
        }
      }
    }
    return localObject;
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {}
    JSONObject localJSONObject;
    JSONArray localJSONArray;
    for (;;)
    {
      try
      {
        QLog.e("PraiseConfigHelper", 1, "parseJson, app null");
        return;
      }
      finally {}
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
      {
        localJSONObject = VasQuickUpdateManager.a(paramAppRuntime, "praise.config.json", true, null);
        if (localJSONObject == null) {
          break label201;
        }
        localJSONArray = localJSONObject.optJSONArray("colorEntries");
        if ((localJSONArray != null) && (localJSONArray.length() > 0)) {
          if (jdField_a_of_type_JavaUtilVector == null)
          {
            jdField_a_of_type_JavaUtilVector = new Vector();
            break label211;
          }
        }
      }
    }
    for (;;)
    {
      if (i < localJSONArray.length())
      {
        String str = localJSONArray.optString(i);
        if (TextUtils.isEmpty(str)) {
          break label216;
        }
        paramAppRuntime = str;
        if (!str.startsWith("http:")) {
          paramAppRuntime = "http:" + str;
        }
        jdField_a_of_type_JavaUtilVector.add(paramAppRuntime);
        break label216;
        jdField_a_of_type_JavaUtilVector.clear();
      }
      else
      {
        jdField_a_of_type_Int = localJSONObject.optInt("playNum", 10);
        b = (int)(localJSONObject.optDouble("downloadTimeLimit", 2.0D) * 1000.0D);
        c = localJSONObject.optInt("praiseFlyOrder", 0);
        label201:
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        break;
      }
      label211:
      int i = 0;
      continue;
      label216:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.like.PraiseConfigHelper
 * JD-Core Version:    0.7.0.1
 */