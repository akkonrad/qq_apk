package com.tencent.component.network.utils.http.base;

import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.params.HttpParams;
import plf;

public class SniSSLSocketFactory
  extends SSLSocketFactory
{
  public SniSSLSocketFactory(KeyStore paramKeyStore)
  {
    super(paramKeyStore);
    setHostnameVerifier(new plf(this));
  }
  
  public static void a(Socket paramSocket, String paramString)
  {
    if ((paramSocket != null) && ((paramSocket instanceof SSLSocket))) {}
    for (paramSocket = (SSLSocket)paramSocket;; paramSocket = null)
    {
      if (paramSocket != null) {}
      try
      {
        SniSSLSocketFactory.HostNameSetter.a(paramString, paramSocket);
        return;
      }
      catch (Exception paramSocket)
      {
        paramSocket.printStackTrace();
        return;
      }
    }
  }
  
  public Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, HttpParams paramHttpParams)
  {
    return super.connectSocket(paramSocket, paramString, paramInt1, paramInetAddress, paramInt2, paramHttpParams);
  }
  
  public Socket createSocket()
  {
    return super.createSocket();
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return super.createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.http.base.SniSSLSocketFactory
 * JD-Core Version:    0.7.0.1
 */