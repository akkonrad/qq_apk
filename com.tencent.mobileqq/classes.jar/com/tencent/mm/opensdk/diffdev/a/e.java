package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.utils.Log;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

public final class e
{
  public static byte[] b(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.SDK.NetUtil", "httpGet, url is null");
      return null;
    }
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    paramString = new HttpGet(paramString);
    if (paramInt >= 0) {}
    try
    {
      HttpConnectionParams.setSoTimeout(localDefaultHttpClient.getParams(), paramInt);
      paramString = localDefaultHttpClient.execute(paramString);
      if (paramString.getStatusLine().getStatusCode() != 200)
      {
        Log.e("MicroMsg.SDK.NetUtil", "httpGet fail, status code = " + paramString.getStatusLine().getStatusCode());
        return null;
      }
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.SDK.NetUtil", "httpGet, Exception ex = " + paramString.getMessage());
      return null;
      paramString = EntityUtils.toByteArray(paramString.getEntity());
      return paramString;
    }
    catch (IncompatibleClassChangeError paramString)
    {
      Log.e("MicroMsg.SDK.NetUtil", "httpGet, IncompatibleClassChangeError ex = " + paramString.getMessage());
      return null;
    }
    catch (Throwable paramString)
    {
      Log.e("MicroMsg.SDK.NetUtil", "httpGet, Throwable ex = " + paramString.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.e
 * JD-Core Version:    0.7.0.1
 */