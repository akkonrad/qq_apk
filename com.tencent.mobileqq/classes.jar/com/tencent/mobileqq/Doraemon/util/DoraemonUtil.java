package com.tencent.mobileqq.Doraemon.util;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.Serializable;
import mqq.os.MqqHandler;
import rfj;
import rfk;
import rfl;

public class DoraemonUtil
{
  public static Serializable a(APIParam paramAPIParam, String paramString, Serializable paramSerializable)
  {
    if (paramAPIParam == null) {}
    do
    {
      return paramSerializable;
      paramAPIParam = (Serializable)paramAPIParam.get(paramString);
    } while (paramAPIParam == null);
    return paramAPIParam;
  }
  
  public static Number a(APIParam paramAPIParam, String paramString, Number paramNumber)
  {
    return (Number)a(paramAPIParam, paramString, paramNumber);
  }
  
  public static void a(APICallback paramAPICallback, int paramInt)
  {
    ThreadManager.getUIHandler().post(new rfl(paramAPICallback, paramInt));
  }
  
  public static void a(APICallback paramAPICallback, int paramInt, String paramString)
  {
    ThreadManager.getUIHandler().post(new rfk(paramAPICallback, paramInt, paramString));
  }
  
  public static void a(APICallback paramAPICallback, APIParam paramAPIParam)
  {
    ThreadManager.getUIHandler().post(new rfj(paramAPICallback, paramAPIParam));
  }
  
  public static boolean a()
  {
    return BaseApplicationImpl.sProcessId == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.util.DoraemonUtil
 * JD-Core Version:    0.7.0.1
 */