package com.tencent.smtt.sdk;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.IconListener;

@Deprecated
public class WebIconDatabase
{
  private static WebIconDatabase mInstance;
  
  private static WebIconDatabase createInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new WebIconDatabase();
      }
      WebIconDatabase localWebIconDatabase = mInstance;
      return localWebIconDatabase;
    }
    finally {}
  }
  
  public static WebIconDatabase getInstance()
  {
    return createInstance();
  }
  
  public void bulkRequestIconForPageUrl(ContentResolver paramContentResolver, String paramString, IconListener paramIconListener) {}
  
  public void close()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().closeIconDB();
      return;
    }
    android.webkit.WebIconDatabase.getInstance().close();
  }
  
  public void open(String paramString)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().openIconDB(paramString);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().open(paramString);
  }
  
  public void releaseIconForPageUrl(String paramString)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().releaseIconForPageUrl(paramString);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(paramString);
  }
  
  public void removeAllIcons()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().removeAllIcons();
      return;
    }
    android.webkit.WebIconDatabase.getInstance().removeAllIcons();
  }
  
  public void requestIconForPageUrl(String paramString, final IconListener paramIconListener)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().requestIconForPageUrl(paramString, new IconListener()
      {
        public void onReceivedIcon(String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          paramIconListener.onReceivedIcon(paramAnonymousString, paramAnonymousBitmap);
        }
      });
      return;
    }
    android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(paramString, new android.webkit.WebIconDatabase.IconListener()
    {
      public void onReceivedIcon(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        paramIconListener.onReceivedIcon(paramAnonymousString, paramAnonymousBitmap);
      }
    });
  }
  
  public void retainIconForPageUrl(String paramString)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().retainIconForPageUrl(paramString);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(paramString);
  }
  
  @Deprecated
  public static abstract interface IconListener
  {
    public abstract void onReceivedIcon(String paramString, Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebIconDatabase
 * JD-Core Version:    0.7.0.1
 */