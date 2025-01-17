package com.tencent.mobileqq.teamwork;

import aimc;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class NoSSLv3SocketFactory
  extends SSLSocketFactory
{
  private final SSLSocketFactory a;
  
  public NoSSLv3SocketFactory()
  {
    this.a = HttpsURLConnection.getDefaultSSLSocketFactory();
  }
  
  public NoSSLv3SocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    this.a = paramSSLSocketFactory;
  }
  
  private Socket a(Socket paramSocket)
  {
    if ((paramSocket instanceof SSLSocket))
    {
      paramSocket = new aimc(this, (SSLSocket)paramSocket, null);
      ((aimc)paramSocket).setEnabledProtocols(new String[] { "TLSv1.1", "TLSv1.2" });
      return paramSocket;
    }
    return paramSocket;
  }
  
  public Socket createSocket(String paramString, int paramInt)
  {
    return a(this.a.createSocket(paramString, paramInt));
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    return a(this.a.createSocket(paramString, paramInt1, paramInetAddress, paramInt2));
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    return a(this.a.createSocket(paramInetAddress, paramInt));
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    return a(this.a.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2));
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return a(this.a.createSocket(paramSocket, paramString, paramInt, paramBoolean));
  }
  
  public String[] getDefaultCipherSuites()
  {
    return this.a.getDefaultCipherSuites();
  }
  
  public String[] getSupportedCipherSuites()
  {
    return this.a.getSupportedCipherSuites();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.NoSSLv3SocketFactory
 * JD-Core Version:    0.7.0.1
 */