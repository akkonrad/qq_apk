package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpWebCgiAsyncTask2
  extends HttpWebCgiAsyncTask
{
  public HttpWebCgiAsyncTask2(String paramString1, String paramString2, HttpWebCgiAsyncTask.Callback paramCallback, int paramInt, Bundle paramBundle)
  {
    super(paramString1, paramString2, paramCallback, paramInt, paramBundle);
  }
  
  protected JSONObject a(HashMap... paramVarArgs)
  {
    if (isCancelled()) {
      return null;
    }
    Object localObject = paramVarArgs[0];
    if (((((HashMap)localObject).get("CONTEXT") instanceof Context)) && ((((HashMap)localObject).get("BUNDLE") instanceof Bundle)))
    {
      paramVarArgs = (Context)((HashMap)localObject).get("CONTEXT");
      localObject = (Bundle)((HashMap)localObject).get("BUNDLE");
    }
    for (;;)
    {
      try
      {
        Bundle localBundle = new Bundle();
        String str1 = ((Bundle)localObject).getString("Cookie");
        String str2 = ((Bundle)localObject).getString("Referer");
        String str3 = ((Bundle)localObject).getString("Origin");
        if (str1 != null)
        {
          localBundle.putString("Cookie", str1);
          ((Bundle)localObject).remove("Cookie");
        }
        if (str2 != null)
        {
          localBundle.putString("Referer", str2);
          ((Bundle)localObject).remove("Referer");
        }
        if (str3 != null)
        {
          localBundle.putString("Origin", str3);
          ((Bundle)localObject).remove("Origin");
        }
        paramVarArgs = new JSONObject(HttpUtil.a(paramVarArgs, this.a, this.b, (Bundle)localObject, localBundle));
      }
      catch (IOException paramVarArgs)
      {
        QLog.w("HttpWebCgiAsyncTask", 1, paramVarArgs.getMessage(), paramVarArgs);
        paramVarArgs = null;
        continue;
      }
      catch (JSONException paramVarArgs)
      {
        QLog.w("HttpWebCgiAsyncTask", 1, paramVarArgs.getMessage(), paramVarArgs);
        paramVarArgs = null;
        continue;
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        QLog.w("HttpWebCgiAsyncTask", 1, paramVarArgs.getMessage(), paramVarArgs);
      }
      return paramVarArgs;
      paramVarArgs = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2
 * JD-Core Version:    0.7.0.1
 */