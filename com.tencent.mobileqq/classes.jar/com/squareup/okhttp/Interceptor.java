package com.squareup.okhttp;

import java.io.IOException;

public abstract interface Interceptor
{
  public abstract Response intercept(Chain paramChain)
    throws IOException;
  
  public static abstract interface Chain
  {
    public abstract Connection connection();
    
    public abstract Response proceed(Request paramRequest)
      throws IOException;
    
    public abstract Request request();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.Interceptor
 * JD-Core Version:    0.7.0.1
 */