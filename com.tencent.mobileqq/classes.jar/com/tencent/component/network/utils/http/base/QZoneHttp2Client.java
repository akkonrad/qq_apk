package com.tencent.component.network.utils.http.base;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.internal.Util;
import com.tencent.component.network.utils.http.HttpUtil;
import com.tencent.component.network.utils.http.HttpUtil.ClientOptions;
import com.tencent.component.network.utils.http.HttpUtil.RequestOptions;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class QZoneHttp2Client
  extends OkHttpClient
{
  public QZoneHttp2Client(HttpUtil.ClientOptions paramClientOptions)
  {
    if (paramClientOptions != null)
    {
      setConnectTimeout(paramClientOptions.c, TimeUnit.MILLISECONDS);
      setReadTimeout(paramClientOptions.e, TimeUnit.MILLISECONDS);
      setWriteTimeout(paramClientOptions.e, TimeUnit.MILLISECONDS);
    }
    long l = paramClientOptions.jdField_a_of_type_Long;
    setConnectionPool(new ConnectionPool(paramClientOptions.jdField_a_of_type_Int, l * 1000L));
    setHostnameVerifier(SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    setProtocols(Util.immutableList(new Protocol[] { Protocol.HTTP_2, Protocol.HTTP_1_1 }));
  }
  
  public Call a(Request paramRequest, HttpUtil.RequestOptions paramRequestOptions)
  {
    if (paramRequest == null) {
      return null;
    }
    paramRequestOptions = HttpUtil.a(paramRequestOptions);
    if ((paramRequestOptions != null) && (paramRequestOptions != Proxy.NO_PROXY)) {
      return newCall(paramRequest, paramRequestOptions);
    }
    return newCall(paramRequest, Proxy.NO_PROXY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.http.base.QZoneHttp2Client
 * JD-Core Version:    0.7.0.1
 */