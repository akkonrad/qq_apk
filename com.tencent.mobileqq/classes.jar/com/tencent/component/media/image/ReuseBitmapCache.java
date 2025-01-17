package com.tencent.component.media.image;

import android.graphics.Bitmap;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;

public class ReuseBitmapCache
{
  public static final String TAG = "AdvanceBitmapPool";
  private static ReuseBitmapCache jdField_a_of_type_ComTencentComponentMediaImageReuseBitmapCache;
  ReuseBitmapPool jdField_a_of_type_ComTencentComponentMediaImageReuseBitmapPool;
  ReuseBitmapPool b;
  
  private ReuseBitmapCache(int paramInt)
  {
    String str = ImageManagerEnv.g().getProcessName(ImageManagerEnv.getAppContext());
    int k = 0;
    int i = k;
    if (str != null)
    {
      i = k;
      if (str.contains(":picture")) {
        i = 1;
      }
    }
    k = ImageDefaultConfig.getScreenWidth(ImageManagerEnv.getAppContext());
    int m = ImageDefaultConfig.getScreenHeight(ImageManagerEnv.getAppContext());
    if (i != 0)
    {
      i = paramInt >> 1;
      this.jdField_a_of_type_ComTencentComponentMediaImageReuseBitmapPool = new ReuseBitmapPool(paramInt - i, k * k, k * m * 4);
      this.b = new ReuseBitmapPool(i, k * 4 * m, k * m * 4 * 2);
      return;
    }
    i = paramInt >> 2;
    int n = k * k;
    if (i <= n)
    {
      i = paramInt;
      paramInt = j;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentComponentMediaImageReuseBitmapPool = new ReuseBitmapPool(i, n, k * m * 4);
      this.b = new ReuseBitmapPool(paramInt, k * 4 * k, k * m * 4);
      return;
      j = paramInt - i;
      paramInt = i;
      i = j;
    }
  }
  
  public static ReuseBitmapCache getInstance(int paramInt)
  {
    if (jdField_a_of_type_ComTencentComponentMediaImageReuseBitmapCache == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentComponentMediaImageReuseBitmapCache == null)
      {
        ImageManagerEnv.getLogger().d("AdvanceBitmapPool", new Object[] { "maxSize:" + paramInt });
        jdField_a_of_type_ComTencentComponentMediaImageReuseBitmapCache = new ReuseBitmapCache(paramInt);
      }
      return jdField_a_of_type_ComTencentComponentMediaImageReuseBitmapCache;
    }
    finally {}
  }
  
  /* Error */
  public boolean addBitMapIntoPool(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 55	com/tencent/component/media/image/ReuseBitmapCache:jdField_a_of_type_ComTencentComponentMediaImageReuseBitmapPool	Lcom/tencent/component/media/image/ReuseBitmapPool;
    //   6: aload_1
    //   7: invokevirtual 94	com/tencent/component/media/image/ReuseBitmapPool:addBitMapIntoPool	(Landroid/graphics/Bitmap;)Z
    //   10: ifne +16 -> 26
    //   13: aload_0
    //   14: getfield 57	com/tencent/component/media/image/ReuseBitmapCache:b	Lcom/tencent/component/media/image/ReuseBitmapPool;
    //   17: aload_1
    //   18: invokevirtual 94	com/tencent/component/media/image/ReuseBitmapPool:addBitMapIntoPool	(Landroid/graphics/Bitmap;)Z
    //   21: istore_2
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_2
    //   25: ireturn
    //   26: iconst_1
    //   27: istore_2
    //   28: goto -6 -> 22
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	ReuseBitmapCache
    //   0	36	1	paramBitmap	Bitmap
    //   21	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	22	31	finally
  }
  
  public Bitmap getBitmapFromPool(int paramInt)
  {
    try
    {
      Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentComponentMediaImageReuseBitmapPool.getBitmapFromPool(paramInt);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null) {
        localBitmap1 = this.b.getBitmapFromPool(paramInt);
      }
      return localBitmap1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ReuseBitmapCache
 * JD-Core Version:    0.7.0.1
 */