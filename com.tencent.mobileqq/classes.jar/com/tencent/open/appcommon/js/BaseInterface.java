package com.tencent.open.appcommon.js;

import aldr;
import alds;
import aldt;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsbridge.JsBridge.JsBridgeListener;
import com.tencent.mobileqq.jsbridge.JsBridge.JsHandler;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.StringAddition;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseInterface
  extends JsBridge.JsHandler
{
  protected static final int NO_AUTH_CODE = -1;
  protected static final String NO_AUTH_MSG = "baby,you don't have permission";
  public static final String TAG = BaseInterface.class.getName();
  protected static final Pattern qqPattern = Pattern.compile("^http://(\\w+\\.)+qq\\.com/.*");
  public List batchCallbackQueue = new ArrayList();
  protected String currentUrl = "";
  public boolean firstIn = true;
  protected boolean jsRight = true;
  public TimerTask mTask;
  public int optLef;
  
  public void addResult(WebView paramWebView, long paramLong1, String paramString, long paramLong2, int paramInt)
  {
    LogUtility.c(TAG, "callBatch addResult result : " + paramString + ", timeout : " + paramLong2 + ", queueLimit : " + paramInt);
    if (this.firstIn)
    {
      Timer localTimer = ThreadManager.getTimer();
      aldr localaldr = new aldr(this, paramWebView, paramLong1);
      this.mTask = localaldr;
      localTimer.schedule(localaldr, paramLong2, paramLong2);
      this.firstIn = false;
    }
    try
    {
      this.batchCallbackQueue.add(paramString);
      if ((this.batchCallbackQueue.size() >= this.optLef) || (this.batchCallbackQueue.size() >= paramInt))
      {
        LogUtility.c(TAG, "callBatch one batch complete , call batchCallback once !!!");
        this.mTask.cancel();
        this.firstIn = true;
        batchCallback(paramWebView, paramLong1);
      }
      return;
    }
    finally {}
  }
  
  public void batchCallback(WebView paramWebView, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      this.optLef -= this.batchCallbackQueue.size();
      Iterator localIterator = this.batchCallbackQueue.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!str.equals("void")) {
          localArrayList.add(str);
        }
      }
      this.batchCallbackQueue.clear();
    }
    finally {}
    if (localArrayList.size() > 0)
    {
      new Handler(Looper.getMainLooper()).post(new alds(this, paramLong, localArrayList, paramWebView));
      return;
    }
    LogUtility.c(TAG, "Response<callBatch> AsyncInterface no need response");
  }
  
  protected void batchCallbackError(WebView paramWebView, long paramLong, String paramString)
  {
    LogUtility.c(TAG, "batchCallbackError guid : " + paramLong + ", msg : " + paramString);
    new Handler(Looper.getMainLooper()).post(new aldt(this, paramLong, paramString, paramWebView));
  }
  
  public void call(String paramString, List paramList, JsBridge.JsBridgeListener paramJsBridgeListener)
  {
    int j = 0;
    long l2 = System.currentTimeMillis();
    Object localObject3 = getClass().getMethods();
    int k = localObject3.length;
    int i = 0;
    Object localObject1;
    if (i < k)
    {
      localObject1 = localObject3[i];
      if ((!((Method)localObject1).getName().equals(paramString)) || (((Method)localObject1).getParameterTypes().length != paramList.size())) {}
    }
    label647:
    for (;;)
    {
      if (localObject1 == null) {}
      label427:
      label494:
      for (;;)
      {
        try
        {
          localObject3 = Class.forName("com.tencent.open.appcommon.js.BaseJsCallBack");
          if (localObject3 != null)
          {
            localObject5 = ((Class)localObject3).getMethods();
            if ((localObject5 != null) && (localObject5.length > 0))
            {
              k = localObject5.length;
              i = j;
              if (i < k)
              {
                localObject3 = localObject5[i];
                long l1;
                if ((((Method)localObject3).getName().equals(paramString)) && (((Method)localObject3).getParameterTypes().length == paramList.size()))
                {
                  localObject1 = localObject3;
                  l1 = System.currentTimeMillis();
                  localObject5 = new StringBuilder().append("AsyncInterface:[");
                  if (localObject1 != null) {
                    continue;
                  }
                  localObject3 = "";
                  LogUtility.b("TIME", (String)localObject3 + "]:Reflct find method cost::time6-time5=" + (l1 - l2));
                  if (localObject1 == null) {
                    break label427;
                  }
                }
                try
                {
                  if (paramList.size() != 0) {
                    continue;
                  }
                  localObject3 = ((Method)localObject1).invoke(this, new Object[0]);
                  l2 = System.currentTimeMillis();
                  StringBuilder localStringBuilder = new StringBuilder().append("AsyncInterface:[");
                  if (localObject1 != null) {
                    continue;
                  }
                  localObject5 = "";
                  LogUtility.b("TIME", (String)localObject5 + "]:Invoke find method cost:time7-time6=" + (l2 - l1));
                  localObject1 = ((Method)localObject1).getReturnType();
                  if ((localObject1 != Void.TYPE) && (localObject1 != Void.class)) {
                    break label494;
                  }
                  if (!(paramJsBridgeListener instanceof OpenJsBridge.OpenJsBridgeListener)) {
                    continue;
                  }
                  ((OpenJsBridge.OpenJsBridgeListener)paramJsBridgeListener).a(paramString, null);
                  return;
                }
                catch (IllegalAccessException localIllegalAccessException)
                {
                  if (paramJsBridgeListener == null) {
                    break label427;
                  }
                  if (!(paramJsBridgeListener instanceof OpenJsBridge.OpenJsBridgeListener)) {
                    break label619;
                  }
                  ((OpenJsBridge.OpenJsBridgeListener)paramJsBridgeListener).b(paramString);
                  QLog.d("JB", 4, "cannot found match method,maybe your method using args type is NO String? request method:class:" + getClass().getSimpleName() + paramString + " args:" + paramList);
                  if (paramJsBridgeListener == null) {
                    continue;
                  }
                  if (!(paramJsBridgeListener instanceof OpenJsBridge.OpenJsBridgeListener)) {
                    break label647;
                  }
                  ((OpenJsBridge.OpenJsBridgeListener)paramJsBridgeListener).b(paramString);
                  return;
                  if (paramJsBridgeListener == null) {
                    continue;
                  }
                  if (!customCallback()) {
                    break label546;
                  }
                  if ((paramJsBridgeListener instanceof OpenJsBridge.OpenJsBridgeListener)) {
                    continue;
                  }
                  paramJsBridgeListener.a(localObject4.toString());
                  return;
                }
                catch (IllegalArgumentException localIllegalArgumentException)
                {
                  for (;;)
                  {
                    if (paramJsBridgeListener != null)
                    {
                      if (!(paramJsBridgeListener instanceof OpenJsBridge.OpenJsBridgeListener)) {
                        break;
                      }
                      ((OpenJsBridge.OpenJsBridgeListener)paramJsBridgeListener).b(paramString);
                    }
                  }
                  if (!(paramJsBridgeListener instanceof OpenJsBridge.OpenJsBridgeListener)) {
                    break label588;
                  }
                  ((OpenJsBridge.OpenJsBridgeListener)paramJsBridgeListener).a(paramString, localObject4);
                  return;
                }
                catch (InvocationTargetException localInvocationTargetException)
                {
                  Object localObject4;
                  for (;;)
                  {
                    if (paramJsBridgeListener != null)
                    {
                      if (!(paramJsBridgeListener instanceof OpenJsBridge.OpenJsBridgeListener)) {
                        break;
                      }
                      ((OpenJsBridge.OpenJsBridgeListener)paramJsBridgeListener).b(paramString);
                    }
                  }
                  paramJsBridgeListener.a(localObject4);
                  return;
                }
                catch (Exception localException1)
                {
                  for (;;)
                  {
                    if (paramJsBridgeListener != null) {
                      if ((paramJsBridgeListener instanceof OpenJsBridge.OpenJsBridgeListener))
                      {
                        ((OpenJsBridge.OpenJsBridgeListener)paramJsBridgeListener).b(paramString);
                        continue;
                        paramJsBridgeListener.a();
                        continue;
                        paramJsBridgeListener.a();
                        continue;
                        paramJsBridgeListener.a();
                      }
                      else
                      {
                        paramJsBridgeListener.a();
                      }
                    }
                  }
                  paramJsBridgeListener.a();
                  return;
                }
                i += 1;
              }
            }
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          localObject4 = null;
          continue;
          i += 1;
          continue;
          localObject4 = ((Method)localObject1).getName();
          continue;
          localObject4 = ((Method)localObject1).invoke(this, paramList.toArray());
          continue;
          Object localObject5 = ((Method)localObject1).getName();
          continue;
          paramJsBridgeListener.a(null);
          return;
        }
      }
      label546:
      label588:
      label619:
      Object localObject2 = null;
    }
  }
  
  public void callBatch(WebView paramWebView, HashMap paramHashMap, long paramLong1, String paramString, long paramLong2, int paramInt)
  {
    label104:
    String str3;
    String str1;
    String str2;
    ArrayList localArrayList;
    int j;
    label303:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            JSONArray localJSONArray = new JSONArray(URLDecoder.decode(paramString, "UTF-8"));
            this.optLef = localJSONArray.length();
            int i = 0;
            if (i < localJSONArray.length())
            {
              paramString = localJSONArray.optJSONObject(i);
              if (paramString != null) {
                break label104;
              }
              i += 1;
            }
            str3 = paramString.optString("ns");
          }
          catch (JSONException paramHashMap)
          {
            LogUtility.b(TAG, "callBatch request params format err", paramHashMap);
            batchCallbackError(paramWebView, paramLong1, "callBatch request params format err");
            return;
          }
          catch (UnsupportedEncodingException paramHashMap)
          {
            LogUtility.b(TAG, "callBatch decode params format err", paramHashMap);
            batchCallbackError(paramWebView, paramLong1, "callBatch callBatch decode params format err");
            return;
          }
          str1 = paramString.optString("method");
          str2 = paramString.optString("guid");
          paramString = paramString.optString("args");
          localArrayList = new ArrayList();
          try
          {
            paramString = new JSONArray(paramString);
            j = 0;
            while (j < paramString.length())
            {
              localArrayList.add(paramString.getString(j));
              j += 1;
            }
          }
          catch (Exception paramString)
          {
            LogUtility.e(TAG, "callBatch args error : " + paramString.toString());
            this.optLef -= 1;
          }
        }
        if (AsyncMethodMap.jdField_a_of_type_JavaUtilArrayList.contains(str1)) {
          localArrayList.add(str2);
        }
        paramString = (Class)AsyncMethodMap.jdField_a_of_type_JavaUtilHashMap.get(str3);
      } while (paramString == null);
      Method[] arrayOfMethod = paramString.getMethods();
      localObject = null;
      int k = arrayOfMethod.length;
      j = 0;
      paramString = localObject;
      if (j < k)
      {
        paramString = arrayOfMethod[j];
        if ((!paramString.getName().equals(str1)) || (paramString.getParameterTypes().length != localArrayList.size())) {
          break;
        }
      }
    } while (paramString == null);
    for (Object localObject = paramHashMap.get(str3);; localObject = paramString.invoke(localObject, localArrayList.toArray()))
    {
      try
      {
        LogUtility.b(TAG, "callBatch <call> class : " + localObject.getClass().getName() + " , method : " + str1 + "\n , args : " + localArrayList.toString());
        if (localArrayList.size() != 0) {
          continue;
        }
        localObject = paramString.invoke(localObject, new Object[0]);
        paramString = paramString.getReturnType();
        if ((paramString != Void.TYPE) && (paramString != Void.class)) {
          break label525;
        }
        addResult(paramWebView, paramLong1, "void", paramLong2, paramInt);
      }
      catch (Exception paramString)
      {
        LogUtility.c(TAG, "callBatch error", paramString);
      }
      break;
      j += 1;
      break label303;
    }
    label525:
    if ((localObject instanceof String))
    {
      paramString = ((String)localObject).replace("\\", "\\\\").replace("'", "\\'");
      paramString = "'" + paramString + "'";
    }
    for (;;)
    {
      addResult(paramWebView, paramLong1, "['interface." + str1 + "',{'guid':" + str2 + ",'r':0,'data':" + paramString + "}]", paramLong2, paramInt);
      break;
      if (((localObject instanceof Number)) || ((localObject instanceof Long)) || ((localObject instanceof Integer)) || ((localObject instanceof Double)) || ((localObject instanceof Float))) {
        paramString = localObject.toString();
      } else if ((localObject instanceof Boolean)) {
        paramString = localObject.toString();
      } else {
        paramString = "'undefined'";
      }
    }
  }
  
  public void destroy()
  {
    if (this.mTask != null)
    {
      this.mTask.cancel();
      this.mTask = null;
    }
  }
  
  public void doOnCreate() {}
  
  public void doOnDestroy() {}
  
  public void doOnPause() {}
  
  public void doOnResume() {}
  
  public abstract String getInterfaceName();
  
  public boolean hasRight()
  {
    if (!this.jsRight) {
      LogUtility.e("AppStore", " js interface has no permission, " + this.currentUrl);
    }
    return this.jsRight;
  }
  
  void setCurrentUrl(String paramString)
  {
    this.currentUrl = paramString.toLowerCase();
    try
    {
      if ((StringAddition.a(this.currentUrl)) || (this.currentUrl.startsWith("file://")))
      {
        this.jsRight = true;
        return;
      }
      if (qqPattern.matcher(this.currentUrl).find())
      {
        this.jsRight = true;
        return;
      }
    }
    catch (Exception paramString)
    {
      this.jsRight = true;
      return;
    }
    this.jsRight = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.appcommon.js.BaseInterface
 * JD-Core Version:    0.7.0.1
 */