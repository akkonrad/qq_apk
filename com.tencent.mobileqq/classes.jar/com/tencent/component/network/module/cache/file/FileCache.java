package com.tencent.component.network.module.cache.file;

import com.tencent.component.network.module.cache.common.LruCache;
import com.tencent.component.network.utils.FileUtils;

public class FileCache
  extends LruCache
{
  public FileCache(int paramInt)
  {
    super(paramInt);
  }
  
  private static int a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return 0;
    }
    return 1;
  }
  
  protected int a(Object paramObject, String paramString)
  {
    return a(paramString);
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      FileUtils.delete(paramString);
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject, String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {}
    while ((paramString1 != null) && (paramString1.equals(paramString2))) {
      return;
    }
    try
    {
      a(paramString1);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.cache.file.FileCache
 * JD-Core Version:    0.7.0.1
 */