package com.tencent.component.media.image;

import com.tencent.component.media.annotation.Public;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;

@Public
public class ImageLoader$Options
  extends ImageLoader.ImageOptions
{
  public static final int DEFAULT_GIF_TYPE = 2;
  public static final int DEFAULT_IMAGE_TYPE = 1;
  public static final int DEFAULT_PANORAMA_ORIG_TYPE = 4;
  public static final int DEFAULT_PANORAMA_THUMB_TYPE = 3;
  public static final int DEFAULT_TYPE = 0;
  public static final boolean DEFAULT_USE_MAIN_THREAD = false;
  private static LinkedList a = new LinkedList();
  public int arg1;
  public int arg2;
  public boolean disableHitRateReport = false;
  public String errCode;
  public ImageProcessor extraProcessor;
  public String fileRootPath = null;
  public boolean isGifPlayWhileDownloading = false;
  public boolean isPreDecode = false;
  public int mImageType = 0;
  public boolean needCallBackProcessPercent = false;
  public boolean needRecycle = false;
  public boolean needShowPhotoGifAnimation = false;
  public Object obj;
  public long photoDelayTimeInMs = 200L;
  public ArrayList photoList;
  public long totalSize;
  public String type;
  @Public
  public boolean useMainThread = false;
  public WeakReference watermarkDrawableRef;
  
  static
  {
    localLinkedList = a;
    int i = 0;
    for (;;)
    {
      if (i < 50) {}
      try
      {
        a.add(new Options());
        i += 1;
      }
      finally {}
    }
  }
  
  public static Options copy(Options paramOptions)
  {
    if (paramOptions == null) {
      return null;
    }
    Options localOptions = obtain();
    localOptions.needRecycle = paramOptions.needRecycle;
    localOptions.useMainThread = paramOptions.useMainThread;
    localOptions.extraProcessor = paramOptions.extraProcessor;
    localOptions.obj = paramOptions.obj;
    localOptions.arg1 = paramOptions.arg1;
    localOptions.arg2 = paramOptions.arg2;
    localOptions.totalSize = paramOptions.totalSize;
    localOptions.clipWidth = paramOptions.clipWidth;
    localOptions.clipHeight = paramOptions.clipHeight;
    localOptions.preferQuality = paramOptions.preferQuality;
    localOptions.priority = paramOptions.priority;
    localOptions.justCover = paramOptions.justCover;
    localOptions.needCallBackProcessPercent = paramOptions.needCallBackProcessPercent;
    localOptions.needShowGifAnimation = paramOptions.needShowGifAnimation;
    localOptions.imageConfig = paramOptions.imageConfig;
    localOptions.processor = paramOptions.processor;
    localOptions.fileRootPath = paramOptions.fileRootPath;
    localOptions.isPreDecode = paramOptions.isPreDecode;
    localOptions.type = paramOptions.type;
    localOptions.needShowPhotoGifAnimation = paramOptions.needShowPhotoGifAnimation;
    localOptions.photoDelayTimeInMs = paramOptions.photoDelayTimeInMs;
    localOptions.photoList = paramOptions.photoList;
    localOptions.isGifPlayWhileDownloading = paramOptions.isGifPlayWhileDownloading;
    localOptions.mImageType = paramOptions.mImageType;
    localOptions.errCode = paramOptions.errCode;
    localOptions.watermarkDrawableRef = paramOptions.watermarkDrawableRef;
    localOptions.needCache = paramOptions.needCache;
    return localOptions;
  }
  
  public static Options obtain()
  {
    synchronized (a)
    {
      Options localOptions = (Options)a.poll();
      ??? = localOptions;
      if (localOptions == null) {
        ??? = new Options();
      }
      ((Options)???).needRecycle = true;
      return ???;
    }
  }
  
  public void recycle()
  {
    if (this.needRecycle)
    {
      this.useMainThread = false;
      this.extraProcessor = null;
      this.obj = null;
      this.arg1 = 0;
      this.arg2 = 0;
      this.totalSize = 0L;
      this.clipWidth = -1;
      this.clipHeight = -1;
      this.preferQuality = false;
      this.priority = true;
      this.justCover = true;
      this.needCallBackProcessPercent = false;
      this.needShowGifAnimation = false;
      this.imageConfig = DEFAULT_IMAGE_CONFIG;
      this.processor = DEFAULT_PROCESSOR;
      this.fileRootPath = null;
      this.type = null;
      this.needShowPhotoGifAnimation = false;
      this.photoDelayTimeInMs = 200L;
      this.photoList = null;
      this.isGifPlayWhileDownloading = false;
      this.mImageType = 0;
      this.isPreDecode = false;
      this.errCode = null;
      this.watermarkDrawableRef = null;
      this.needCache = true;
      synchronized (a)
      {
        a.add(this);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageLoader.Options
 * JD-Core Version:    0.7.0.1
 */