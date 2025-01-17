package com.tencent.open.base.http;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.rookery.asyncHttpClient.AsyncHttpClient.CustomSSLSocketFactory;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.OpenConfig;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;
import org.json.JSONObject;

@SuppressLint({"DefaultLocale"})
public class HttpBaseUtil
{
  protected static final String a;
  public static HashMap a;
  protected static boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = HttpBaseUtil.class.getName();
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaUtilHashMap = new HashMap(64);
  }
  
  protected static int a()
  {
    int i = -1;
    if (Build.VERSION.SDK_INT < 11) {
      if (CommonDataAdapter.a().a() != null)
      {
        int j = Proxy.getPort(CommonDataAdapter.a().a());
        i = j;
        if (j < 0) {
          i = Proxy.getDefaultPort();
        }
      }
    }
    String str;
    do
    {
      return i;
      return Proxy.getDefaultPort();
      str = System.getProperty("http.proxyPort");
    } while (TextUtils.isEmpty(str));
    try
    {
      i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return -1;
  }
  
  protected static HttpBaseUtil.HttpResponseBean a(String paramString1, String paramString2, Bundle paramBundle)
  {
    return a(paramString1, paramString2, paramBundle, null);
  }
  
  public static HttpBaseUtil.HttpResponseBean a(String paramString1, String paramString2, Bundle paramBundle, HttpContext paramHttpContext)
  {
    if (!AppNetConnInfo.isNetSupport()) {
      throw new HttpBaseUtil.NetworkUnavailableException("network unavailable");
    }
    for (;;)
    {
      Object localObject1;
      HttpClient localHttpClient;
      int j;
      try
      {
        str1 = paramBundle.getString("needhttpcache");
        localObject2 = paramBundle.getString("LastModifyUseString");
        paramBundle.remove("needhttpcache");
        paramBundle.remove("LastModifyUseString");
        localObject1 = paramBundle.getString("appid_for_getting_config");
        paramBundle.remove("appid_for_getting_config");
        localHttpClient = a((String)localObject1, paramString1);
        localObject1 = null;
        i = paramString1.length();
        if (paramString2.equals("GET"))
        {
          localObject1 = a(paramBundle);
          j = ((String)localObject1).length();
          if (paramString1.indexOf("?") == -1)
          {
            paramString2 = paramString1 + "?";
            paramString2 = paramString2 + (String)localObject1;
            localObject1 = paramString1 + (String)localObject1;
            paramString1 = new HttpGet(paramString2);
            paramString1.addHeader("Accept-Encoding", "gzip");
            if (paramBundle.containsKey("Referer")) {
              paramString1.addHeader("Referer", paramBundle.getString("Referer"));
            }
            if (paramBundle.containsKey("Cookie")) {
              paramString1.addHeader("Cookie", paramBundle.getString("Cookie"));
            }
            paramString1.addHeader("Content-Type", "application/x-www-form-urlencoded");
            if (str1 == null) {
              break label1046;
            }
            paramString1.addHeader("If-None-Match", HttpCacheService.a().a((String)localObject1));
            if (localObject2 != null)
            {
              paramString1.addHeader("If-Modified-Since", "\"" + HttpCacheService.a().b((String)localObject1) + "\"");
              break label1046;
              if ((paramString1 != null) && (!paramString1.containsHeader("Cookie"))) {
                paramString1.setHeader("Cookie", b());
              }
              if (paramHttpContext != null) {
                break label1022;
              }
              paramString1 = localHttpClient.execute(paramString1);
              a(paramString1);
              return new HttpBaseUtil.HttpResponseBean(paramString1, i);
            }
          }
          else
          {
            if ((paramString1.endsWith("&")) || (TextUtils.isEmpty((CharSequence)localObject1))) {
              break label1041;
            }
            paramString2 = paramString1 + "&";
            continue;
          }
          paramString1.addHeader("If-Modified-Since", "\"" + HttpCacheService.a().a((String)localObject1) + "\"");
          LogUtility.c(jdField_a_of_type_JavaLangString, "add header. If-None-Match:" + HttpCacheService.a().a((String)localObject1) + "; If-Modified-Since:" + HttpCacheService.a().a((String)localObject1));
        }
      }
      catch (MalformedURLException paramString1)
      {
        throw new MalformedURLException(paramString1.getMessage());
        if (!paramString2.equals("POST")) {
          break label1035;
        }
        localObject1 = new HttpPost(paramString1);
        ((HttpPost)localObject1).addHeader("Accept-Encoding", "gzip");
        ((HttpPost)localObject1).addHeader("Content-Type", "application/x-www-form-urlencoded");
        boolean bool = paramBundle.getBoolean("doAuthorize", false);
        paramBundle.remove("doAuthorize");
        paramString1 = paramBundle.getString("cmshow_download_key");
        if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals("cmshow_downLoad")))
        {
          if (paramBundle.containsKey("Referer")) {
            ((HttpPost)localObject1).addHeader("Referer", paramBundle.getString("Referer"));
          }
          if (paramBundle.containsKey("Cookie")) {
            ((HttpPost)localObject1).addHeader("Cookie", paramBundle.getString("Cookie"));
          }
          if ((paramBundle.containsKey("Postbody")) && (paramBundle.containsKey("needBodyCompatible")) && (paramBundle.getBoolean("needBodyCompatible"))) {
            ((HttpPost)localObject1).addHeader("Postbody", paramBundle.getString("Postbody"));
          }
        }
        if (bool)
        {
          localObject2 = new ArrayList();
          Iterator localIterator = paramBundle.keySet().iterator();
          if (localIterator.hasNext())
          {
            str2 = (String)localIterator.next();
            if ((paramBundle.get(str2) instanceof String))
            {
              ((List)localObject2).add(new BasicNameValuePair(str2, (String)paramBundle.get(str2)));
              continue;
            }
          }
        }
      }
      catch (IOException paramString1)
      {
        String str1;
        String str2;
        throw paramString1;
        if (!(paramBundle.get(str2) instanceof String[])) {
          continue;
        }
        String[] arrayOfString = (String[])paramBundle.get(str2);
        int k = arrayOfString.length;
        paramString1 = null;
        j = 0;
        if (j < k)
        {
          str1 = arrayOfString[j];
          if (TextUtils.isEmpty(paramString1))
          {
            paramString1 = str1;
            break label1056;
          }
          paramString1 = paramString1 + "," + str1;
          break label1056;
        }
        ((List)localObject2).add(new BasicNameValuePair(str2, paramString1));
        continue;
      }
      catch (Exception paramString1)
      {
        Object localObject2;
        throw new Exception(paramString1);
        if (!paramBundle.containsKey("method")) {
          ((List)localObject2).add(new BasicNameValuePair("method", paramString2));
        }
        ((HttpPost)localObject1).setEntity(new UrlEncodedFormEntity((List)localObject2, "UTF-8"));
        break label1065;
        if ((paramBundle.containsKey("Postbody")) && ((!paramBundle.containsKey("needBodyCompatible")) || (!paramBundle.getBoolean("needBodyCompatible"))))
        {
          ((HttpPost)localObject1).setEntity(new ByteArrayEntity(paramBundle.getString("Postbody").getBytes()));
          break label1065;
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        throw new Exception(paramString1);
      }
      ((HttpPost)localObject1).setEntity(new ByteArrayEntity(a(paramBundle).getBytes()));
      break label1065;
      label1022:
      paramString1 = localHttpClient.execute(paramString1, paramHttpContext);
      continue;
      label1035:
      paramString1 = (String)localObject1;
      continue;
      label1041:
      paramString2 = paramString1;
      continue;
      label1046:
      int i = j + i;
      continue;
      label1056:
      j += 1;
      continue;
      label1065:
      paramString1 = (String)localObject1;
    }
  }
  
  protected static HttpBaseUtil.NetworkProxy a(Context paramContext)
  {
    if (paramContext == null) {}
    int i;
    do
    {
      do
      {
        return null;
      } while (NetworkUtil.b(paramContext) != 0);
      paramContext = a();
      i = a();
    } while ((TextUtils.isEmpty(paramContext)) || (i < 0));
    return new HttpBaseUtil.NetworkProxy(paramContext, i);
  }
  
  public static HttpBaseUtil.Statistic a(String paramString1, String paramString2, Bundle paramBundle)
  {
    return a(paramString1, paramString2, paramBundle, 0);
  }
  
  protected static HttpBaseUtil.Statistic a(String paramString1, String paramString2, Bundle paramBundle, int paramInt)
  {
    int i = 1;
    String str1 = "";
    String str6 = paramBundle.getString("needhttpcache");
    String str4 = paramBundle.getString("LastModifyUseString");
    String str7 = MsfSdkUtils.insertMtype("yingyongbao", paramString1);
    String str8 = paramBundle.getString("downloadfile");
    paramBundle.remove("downloadfile");
    String str5 = paramBundle.getString("cmshow_download_key");
    paramString1 = a(str7, paramString2, paramBundle);
    paramBundle.remove("needhttpcache");
    paramBundle.remove("LastModifyUseString");
    HttpResponse localHttpResponse = paramString1.jdField_a_of_type_OrgApacheHttpHttpResponse;
    int j = paramString1.jdField_a_of_type_Int;
    int k = localHttpResponse.getStatusLine().getStatusCode();
    String str2 = null;
    long l2 = 0L;
    paramString1 = "";
    if (localHttpResponse.containsHeader("Etag")) {
      str2 = localHttpResponse.getFirstHeader("Etag").getValue();
    }
    long l1 = l2;
    Object localObject = paramString1;
    if (localHttpResponse.containsHeader("Last-Modified"))
    {
      localObject = localHttpResponse.getFirstHeader("Last-Modified");
      if (str4 != null)
      {
        localObject = ((Header)localObject).getValue();
        l1 = l2;
      }
    }
    else
    {
      str4 = null;
      if ("GET".equals(paramString2))
      {
        str4 = a(str7, paramBundle);
        LogUtility.c(jdField_a_of_type_JavaLangString, "url2=" + str4);
      }
      if (k != 200) {
        break label468;
      }
      if (str8 == null) {
        break label459;
      }
      paramString1 = str1;
      if (!TextUtils.isEmpty(str5))
      {
        paramString1 = str1;
        if (str5.equals("cmshow_downLoad"))
        {
          paramString1 = str1;
          if (a(localHttpResponse).booleanValue()) {
            paramString1 = a(localHttpResponse);
          }
        }
      }
      label297:
      paramInt = i;
      paramBundle = paramString1;
      if (str6 != null)
      {
        paramInt = i;
        paramBundle = paramString1;
        if ("GET".equals(paramString2))
        {
          HttpCacheService.a().a(str4, str2, l1, paramString1, (String)localObject);
          paramBundle = paramString1;
          paramInt = i;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        paramString1 = new HttpBaseUtil.Statistic(paramBundle, j, paramInt);
        if ((!TextUtils.isEmpty(str5)) && (str5.equals("cmshow_downLoad")) && (!a(localHttpResponse).booleanValue())) {
          paramString1.a = localHttpResponse.getEntity().getContent();
        }
        return paramString1;
        try
        {
          l1 = Long.parseLong(((Header)localObject).getValue());
          localObject = paramString1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          LogUtility.c(jdField_a_of_type_JavaLangString, " Parse Last-Modified to Long Exception: " + localNumberFormatException.getMessage());
          l1 = 0L;
          String str3 = paramString1;
        }
      }
      break;
      label459:
      paramString1 = a(localHttpResponse);
      break label297;
      label468:
      if ((k != 304) || (str2 == null)) {
        break label581;
      }
      paramString1 = str1;
      if (str4 != null) {
        paramString1 = HttpCacheService.a().c(str4);
      }
      if ((paramString1 == null) || ("".equals(paramString1)))
      {
        LogUtility.e(jdField_a_of_type_JavaLangString, "Get response from cache error. remove cache and retry. retryCount=" + paramInt);
        if (str4 != null) {
          HttpCacheService.a().a(str4);
        }
        paramBundle.putString("needhttpcache", "nothing");
        if (paramInt < 1) {
          a(str7, paramString2, paramBundle, paramInt);
        }
      }
      paramInt = 0;
      paramBundle = paramString1;
    }
    label581:
    LogUtility.e(jdField_a_of_type_JavaLangString, "request" + str7 + "http server return error, statuscode:" + k);
    throw new HttpBaseUtil.HttpStatusException("http status code error:" + k);
  }
  
  protected static Boolean a(HttpResponse paramHttpResponse)
  {
    paramHttpResponse = paramHttpResponse.getFirstHeader("Content-Encoding");
    if ((paramHttpResponse != null) && (paramHttpResponse.getValue().toLowerCase().indexOf("gzip") > -1)) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  protected static String a()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      if (CommonDataAdapter.a().a() != null)
      {
        String str2 = Proxy.getHost(CommonDataAdapter.a().a());
        String str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = Proxy.getDefaultHost();
        }
        return str1;
      }
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
  }
  
  public static String a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = paramBundle.get((String)localObject1);
      if (((localObject2 instanceof String)) || ((localObject2 instanceof String[]))) {
        if ((localObject2 instanceof String[]))
        {
          int j;
          if (i != 0)
          {
            i = 0;
            localStringBuilder.append(URLEncoder.encode((String)localObject1)).append("=");
            localObject1 = (String[])paramBundle.getStringArray((String)localObject1);
            j = 0;
            label118:
            if (j >= localObject1.length) {
              break label179;
            }
            if (j != 0) {
              break label158;
            }
            localStringBuilder.append(URLEncoder.encode(localObject1[j]));
          }
          for (;;)
          {
            j += 1;
            break label118;
            localStringBuilder.append("&");
            break;
            label158:
            localStringBuilder.append(",").append(URLEncoder.encode(localObject1[j]));
          }
        }
        else
        {
          label179:
          if (i != 0) {
            i = 0;
          }
          for (;;)
          {
            localStringBuilder.append(URLEncoder.encode((String)localObject1)).append("=").append(URLEncoder.encode(paramBundle.getString((String)localObject1)));
            break;
            localStringBuilder.append("&");
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(InputStream paramInputStream)
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      localStringBuilder.append(str);
    }
    paramInputStream.close();
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString.equals("false")) {
      str = "{value : false}";
    }
    paramString = str;
    if (str.equals("true")) {
      paramString = "{value : true}";
    }
    str = paramString;
    if (paramString.contains("allback(")) {
      str = paramString.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
    }
    return str;
  }
  
  protected static String a(String paramString, Bundle paramBundle)
  {
    String str = a(paramBundle);
    if (paramString.indexOf("?") == -1) {
      paramBundle = paramString + "?";
    }
    for (;;)
    {
      return paramBundle + str;
      paramBundle = paramString;
      if (!paramString.endsWith("&"))
      {
        paramBundle = paramString;
        if (!TextUtils.isEmpty(str)) {
          paramBundle = paramString + "&";
        }
      }
    }
  }
  
  /* Error */
  @SuppressLint({"DefaultLocale"})
  public static String a(HttpResponse paramHttpResponse)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 9
    //   6: ldc_w 347
    //   9: astore 8
    //   11: aload_0
    //   12: invokeinterface 417 1 0
    //   17: astore 5
    //   19: aload_0
    //   20: ldc_w 531
    //   23: invokeinterface 378 2 0
    //   28: ifeq +47 -> 75
    //   31: aload_0
    //   32: ldc_w 531
    //   35: invokeinterface 382 2 0
    //   40: invokeinterface 387 1 0
    //   45: invokestatic 431	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   48: lstore_3
    //   49: getstatic 21	com/tencent/open/base/http/HttpBaseUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   52: new 143	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   59: ldc_w 533
    //   62: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: lload_3
    //   66: invokevirtual 225	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 234	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload 5
    //   77: invokeinterface 423 1 0
    //   82: astore 5
    //   84: aload_0
    //   85: ldc_w 462
    //   88: invokeinterface 382 2 0
    //   93: astore 6
    //   95: aload 6
    //   97: ifnull +72 -> 169
    //   100: aload 6
    //   102: invokeinterface 387 1 0
    //   107: invokevirtual 465	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   110: ldc 158
    //   112: invokevirtual 141	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   115: iconst_m1
    //   116: if_icmple +53 -> 169
    //   119: new 535	java/util/zip/GZIPInputStream
    //   122: dup
    //   123: aload 5
    //   125: invokespecial 536	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   128: astore 6
    //   130: aload 6
    //   132: invokestatic 538	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   135: astore 7
    //   137: aload 7
    //   139: astore_0
    //   140: aload 5
    //   142: ifnull +8 -> 150
    //   145: aload 5
    //   147: invokevirtual 541	java/io/InputStream:close	()V
    //   150: aload_0
    //   151: astore 5
    //   153: aload 6
    //   155: ifnull +11 -> 166
    //   158: aload 6
    //   160: invokevirtual 541	java/io/InputStream:close	()V
    //   163: aload_0
    //   164: astore 5
    //   166: aload 5
    //   168: areturn
    //   169: aload 5
    //   171: invokestatic 538	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   174: astore 6
    //   176: aload 6
    //   178: astore_0
    //   179: aconst_null
    //   180: astore 6
    //   182: goto -42 -> 140
    //   185: astore 5
    //   187: getstatic 21	com/tencent/open/base/http/HttpBaseUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   190: ldc_w 543
    //   193: aload 5
    //   195: invokestatic 546	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   198: aload_0
    //   199: areturn
    //   200: astore 7
    //   202: aconst_null
    //   203: astore 5
    //   205: aload 9
    //   207: astore 6
    //   209: getstatic 21	com/tencent/open/base/http/HttpBaseUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   212: new 143	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   219: ldc_w 548
    //   222: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload 7
    //   227: invokevirtual 549	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   230: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: aload 7
    //   238: invokestatic 546	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   241: aload_0
    //   242: invokeinterface 553 1 0
    //   247: astore_0
    //   248: aload_0
    //   249: arraylength
    //   250: istore_2
    //   251: iconst_0
    //   252: istore_1
    //   253: iload_1
    //   254: iload_2
    //   255: if_icmpge +63 -> 318
    //   258: aload_0
    //   259: iload_1
    //   260: aaload
    //   261: astore 7
    //   263: getstatic 21	com/tencent/open/base/http/HttpBaseUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   266: new 143	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   273: ldc_w 555
    //   276: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload 7
    //   281: invokeinterface 556 1 0
    //   286: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc_w 558
    //   292: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 7
    //   297: invokeinterface 387 1 0
    //   302: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 444	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: iload_1
    //   312: iconst_1
    //   313: iadd
    //   314: istore_1
    //   315: goto -62 -> 253
    //   318: aload 5
    //   320: ifnull +8 -> 328
    //   323: aload 5
    //   325: invokevirtual 541	java/io/InputStream:close	()V
    //   328: aload 8
    //   330: astore 5
    //   332: aload 6
    //   334: ifnull -168 -> 166
    //   337: aload 6
    //   339: invokevirtual 541	java/io/InputStream:close	()V
    //   342: ldc_w 347
    //   345: areturn
    //   346: astore_0
    //   347: getstatic 21	com/tencent/open/base/http/HttpBaseUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   350: ldc_w 543
    //   353: aload_0
    //   354: invokestatic 546	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   357: ldc_w 347
    //   360: areturn
    //   361: astore_0
    //   362: aconst_null
    //   363: astore 5
    //   365: aload 7
    //   367: astore 6
    //   369: aload 5
    //   371: ifnull +8 -> 379
    //   374: aload 5
    //   376: invokevirtual 541	java/io/InputStream:close	()V
    //   379: aload 6
    //   381: ifnull +8 -> 389
    //   384: aload 6
    //   386: invokevirtual 541	java/io/InputStream:close	()V
    //   389: aload_0
    //   390: athrow
    //   391: astore 5
    //   393: getstatic 21	com/tencent/open/base/http/HttpBaseUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   396: ldc_w 543
    //   399: aload 5
    //   401: invokestatic 546	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   404: goto -15 -> 389
    //   407: astore_0
    //   408: aload 7
    //   410: astore 6
    //   412: goto -43 -> 369
    //   415: astore_0
    //   416: goto -47 -> 369
    //   419: astore_0
    //   420: goto -51 -> 369
    //   423: astore 7
    //   425: aload 9
    //   427: astore 6
    //   429: goto -220 -> 209
    //   432: astore 7
    //   434: goto -225 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	437	0	paramHttpResponse	HttpResponse
    //   252	63	1	i	int
    //   250	6	2	j	int
    //   48	18	3	l	long
    //   17	153	5	localObject1	Object
    //   185	9	5	localException1	Exception
    //   203	172	5	str1	String
    //   391	9	5	localException2	Exception
    //   93	335	6	localObject2	Object
    //   1	137	7	str2	String
    //   200	37	7	localException3	Exception
    //   261	148	7	localObject3	Object
    //   423	1	7	localException4	Exception
    //   432	1	7	localException5	Exception
    //   9	320	8	str3	String
    //   4	422	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   145	150	185	java/lang/Exception
    //   158	163	185	java/lang/Exception
    //   19	75	200	java/lang/Exception
    //   75	84	200	java/lang/Exception
    //   323	328	346	java/lang/Exception
    //   337	342	346	java/lang/Exception
    //   19	75	361	finally
    //   75	84	361	finally
    //   374	379	391	java/lang/Exception
    //   384	389	391	java/lang/Exception
    //   84	95	407	finally
    //   100	130	407	finally
    //   169	176	407	finally
    //   130	137	415	finally
    //   209	251	419	finally
    //   263	311	419	finally
    //   84	95	423	java/lang/Exception
    //   100	130	423	java/lang/Exception
    //   169	176	423	java/lang/Exception
    //   130	137	432	java/lang/Exception
  }
  
  public static HttpClient a(String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      try
      {
        Object localObject = KeyStore.getInstance(KeyStore.getDefaultType());
        ((KeyStore)localObject).load(null, null);
        localObject = new AsyncHttpClient.CustomSSLSocketFactory((KeyStore)localObject);
        ((SSLSocketFactory)localObject).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        int j = OpenConfig.a(CommonDataAdapter.a().a(), paramString1).a("Common_HttpConnectionTimeout");
        LogUtility.c("OpenConfig_agent", "config 3:Common_HttpConnectionTimeout     config_value:" + j + "   appid:" + paramString1 + "     url:" + paramString2);
        int i = j;
        if (j == 0) {
          i = 15000;
        }
        LogUtility.c("OpenConfig_agent", "config 3:Common_HttpConnectionTimeout     result_value:" + i + "   appid:" + paramString1 + "     url:" + paramString2);
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, i);
        j = OpenConfig.a(CommonDataAdapter.a().a(), paramString1).a("Common_SocketConnectionTimeout");
        LogUtility.c("OpenConfig_agent", "config 4:Common_SocketConnectionTimeout   config_value:" + j + "   appid:" + paramString1 + "     url:" + paramString2);
        i = j;
        if (j == 0) {
          i = 30000;
        }
        LogUtility.c("OpenConfig_agent", "config 4:Common_SocketConnectionTimeout   result_value:" + i + "   appid:" + paramString1 + "     url:" + paramString2);
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, i);
        HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(localBasicHttpParams, "UTF-8");
        HttpProtocolParams.setUserAgent(localBasicHttpParams, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        paramString1 = new SchemeRegistry();
        paramString1.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        paramString1.register(new Scheme("https", (SocketFactory)localObject, 443));
        paramString1 = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, paramString1), localBasicHttpParams);
        paramString2 = a(CommonDataAdapter.a().a());
        if (paramString2 != null)
        {
          paramString2 = new HttpHost(paramString2.jdField_a_of_type_JavaLangString, paramString2.jdField_a_of_type_Int);
          paramString1.getParams().setParameter("http.route.default-proxy", paramString2);
        }
        return paramString1;
      }
      catch (Exception localException)
      {
        localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        continue;
      }
      SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
    }
  }
  
  public static JSONObject a(String paramString)
  {
    String str = paramString;
    if (paramString.equals("false")) {
      str = "{value : false}";
    }
    paramString = str;
    if (str.equals("true")) {
      paramString = "{value : true}";
    }
    str = paramString;
    if (paramString.contains("allback(")) {
      str = paramString.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
    }
    return new JSONObject(str);
  }
  
  public static void a(HttpResponse paramHttpResponse)
  {
    LogUtility.c(jdField_a_of_type_JavaLangString, "----setCookie");
    if (paramHttpResponse != null) {}
    for (Object localObject1 = paramHttpResponse.getHeaders("Set-Cookie");; localObject1 = null)
    {
      if ((localObject1 == null) || (localObject1.length == 0))
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "----there are no cookies");
        return;
      }
      paramHttpResponse = "";
      int i = 0;
      Object localObject2;
      while (i < localObject1.length)
      {
        localObject2 = paramHttpResponse + localObject1[i].getValue();
        paramHttpResponse = (HttpResponse)localObject2;
        if (i != localObject1.length - 1) {
          paramHttpResponse = (String)localObject2 + "; ";
        }
        i += 1;
      }
      localObject1 = paramHttpResponse.split("; ");
      int j = localObject1.length;
      i = 0;
      label134:
      String str;
      if (i < j)
      {
        paramHttpResponse = localObject1[i].trim();
        if (jdField_a_of_type_JavaUtilHashMap.containsKey(paramHttpResponse.split("=")[0])) {
          jdField_a_of_type_JavaUtilHashMap.remove(paramHttpResponse.split("=")[0]);
        }
        localObject2 = jdField_a_of_type_JavaUtilHashMap;
        str = paramHttpResponse.split("=")[0];
        if (paramHttpResponse.split("=").length != 1) {
          break label228;
        }
        paramHttpResponse = "";
      }
      for (;;)
      {
        ((HashMap)localObject2).put(str, paramHttpResponse);
        i += 1;
        break label134;
        break;
        label228:
        if (paramHttpResponse.split("=").length == 2) {
          paramHttpResponse = paramHttpResponse.split("=")[1];
        } else {
          paramHttpResponse = paramHttpResponse.split("=", 2)[1];
        }
      }
    }
  }
  
  public static String b()
  {
    jdField_a_of_type_JavaUtilHashMap.put("uin", b(String.valueOf(CommonDataAdapter.a().a())));
    jdField_a_of_type_JavaUtilHashMap.put("skey", CommonDataAdapter.a().a());
    jdField_a_of_type_JavaUtilHashMap.put("qua", CommonDataAdapter.a().f());
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    String str2;
    for (String str1 = ""; localIterator.hasNext(); str1 = str1 + str2 + "=" + (String)jdField_a_of_type_JavaUtilHashMap.get(str2) + "; ") {
      str2 = (String)localIterator.next();
    }
    return str1;
  }
  
  public static String b(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.length() < 10)
      {
        localObject = new StringBuilder("o");
        int i = paramString.length();
        while (i < 10)
        {
          ((StringBuilder)localObject).append("0");
          i += 1;
        }
        localObject = paramString;
      }
    }
    else {
      return localObject;
    }
    return "o" + paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.base.http.HttpBaseUtil
 * JD-Core Version:    0.7.0.1
 */