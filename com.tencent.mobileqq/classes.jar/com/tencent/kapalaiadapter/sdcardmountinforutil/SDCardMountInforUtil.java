package com.tencent.kapalaiadapter.sdcardmountinforutil;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SDCardMountInforUtil
  implements ISDCardMountInfor
{
  private static SDCardMountInforUtil mSelf;
  private final String HEAD_CONF = "mount_point";
  private final String HEAD_FSTAB = "dev_mount";
  private final int PATH = 2;
  public final String ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();
  private final int SDK_VERSION_LEVEL_1 = 0;
  private final int SDK_VERSION_LEVEL_2 = 1;
  private final int SDK_VERSION_LEVEL_3 = 2;
  private final File VOLD_CONF = new File(Environment.getRootDirectory().getAbsoluteFile() + File.separator + "etc" + File.separator + "vold.conf");
  private final File VOLD_FSTAB = new File(Environment.getRootDirectory().getAbsoluteFile() + File.separator + "etc" + File.separator + "vold.fstab");
  private ArrayList<String> allPath = new ArrayList();
  private ArrayList<String> cache = new ArrayList();
  private Context mContext;
  private final BroadcastReceiver sdcardListener = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      paramAnonymousContext = paramAnonymousIntent.getAction();
      if (("android.intent.action.MEDIA_MOUNTED".equals(paramAnonymousContext)) || ("android.intent.action.MEDIA_SCANNER_STARTED".equals(paramAnonymousContext)) || ("android.intent.action.MEDIA_SCANNER_FINISHED".equals(paramAnonymousContext)) || ("android.intent.action.MEDIA_REMOVED".equals(paramAnonymousContext)) || ("android.intent.action.MEDIA_UNMOUNTED".equals(paramAnonymousContext)) || ("android.intent.action.MEDIA_BAD_REMOVAL".equals(paramAnonymousContext))) {
        SDCardMountInforUtil.this.initVoldFstabORVoldConfToCache(SDCardMountInforUtil.this.sdk_level);
      }
    }
  };
  private int sdk_level = 0;
  
  private SDCardMountInforUtil(Context paramContext)
  {
    this.mContext = paramContext;
    registerSDCardListener(paramContext);
    if (version() < 8) {
      this.sdk_level = 0;
    }
    for (;;)
    {
      initVoldFstabORVoldConfToCache(this.sdk_level);
      return;
      if (version() < 11) {
        this.sdk_level = 1;
      } else {
        this.sdk_level = 2;
      }
    }
  }
  
  public static SDCardMountInforUtil getSelf(Context paramContext)
  {
    try
    {
      if (mSelf == null) {
        mSelf = new SDCardMountInforUtil(paramContext);
      }
      paramContext = mSelf;
      return paramContext;
    }
    finally {}
  }
  
  private void initVoldConf()
  {
    this.cache.clear();
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader(this.VOLD_CONF));
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        if (str.startsWith("mount_point")) {
          this.cache.add(str);
        }
      }
      loadSdCards();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    for (;;)
    {
      return;
      localException.close();
      this.cache.trimToSize();
    }
  }
  
  private void initVoldFstab()
  {
    this.cache.clear();
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader(this.VOLD_FSTAB));
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        if (str.startsWith("dev_mount")) {
          this.cache.add(str);
        }
      }
      loadSdCards();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    for (;;)
    {
      return;
      localException.close();
      this.cache.trimToSize();
    }
  }
  
  private void initVoldFstabORVoldConfToCache(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      reflectGetVolumePaths();
      return;
    case 0: 
      initVoldConf();
      return;
    }
    initVoldFstab();
  }
  
  private boolean isIgnore(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      paramString = new File(paramString);
      if ((!paramString.exists()) || (paramString.list() == null)) {
        break;
      }
      paramString = paramString.list();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramString[i];
        Log.i("kapalai", "--------" + str);
        i += 1;
      }
    }
    return true;
  }
  
  private void loadSdCards()
  {
    this.allPath.clear();
    int i = 0;
    int k;
    for (int j = 0; i < this.cache.size(); j = k)
    {
      k = j;
      if (this.cache.get(i) != null)
      {
        String[] arrayOfString = ((String)this.cache.get(i)).split(" ");
        k = j;
        if (arrayOfString != null)
        {
          k = j;
          if (!isIgnore(arrayOfString[2]))
          {
            this.allPath.add(j, arrayOfString[2]);
            k = j + 1;
          }
        }
      }
      i += 1;
    }
    if (!this.allPath.contains(this.ROOT)) {
      this.allPath.add(j, this.ROOT);
    }
  }
  
  @TargetApi(9)
  private void reflectGetVolumePaths()
  {
    int i = 0;
    if (this.sdk_level == 2)
    {
      this.allPath.clear();
      Object localObject = (StorageManager)this.mContext.getSystemService("storage");
      try
      {
        localObject = (String[])localObject.getClass().getMethod("getVolumePaths", new Class[0]).invoke(localObject, new Object[0]);
        int j = localObject.length;
        while ((i < j) && (!isIgnore(localObject[i])))
        {
          this.allPath.add(i, localObject[i]);
          i += 1;
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void registerSDCardListener(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.MEDIA_MOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
    localIntentFilter.addAction("android.intent.action.MEDIA_REMOVED");
    localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
    localIntentFilter.addDataScheme("file");
    paramContext.registerReceiver(this.sdcardListener, localIntentFilter);
  }
  
  public ArrayList<String> getAllPath()
  {
    if (this.allPath.size() < 1) {
      initVoldFstabORVoldConfToCache(this.sdk_level);
    }
    return this.allPath;
  }
  
  public boolean isExSdcard(String paramString)
  {
    if (paramString == null) {}
    File localFile;
    do
    {
      return false;
      localFile = new File(paramString);
    } while ((paramString.endsWith(this.ROOT)) || (!localFile.exists()));
    return true;
  }
  
  public void removeSDCardListener(Context paramContext)
  {
    paramContext.unregisterReceiver(this.sdcardListener);
  }
  
  public int version()
  {
    return Build.VERSION.SDK_INT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.kapalaiadapter.sdcardmountinforutil.SDCardMountInforUtil
 * JD-Core Version:    0.7.0.1
 */