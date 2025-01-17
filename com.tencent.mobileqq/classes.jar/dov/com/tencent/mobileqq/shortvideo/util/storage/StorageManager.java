package dov.com.tencent.mobileqq.shortvideo.util.storage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import aoqq;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class StorageManager
{
  public static long a;
  static StorageManager jdField_a_of_type_DovComTencentMobileqqShortvideoUtilStorageStorageManager;
  static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static long b;
  final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aoqq(this);
  public StorageManager.OnSdCardChangedListener a;
  public String a;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean;
  public String b;
  long c = 0L;
  
  static
  {
    jdField_a_of_type_Long = 57671680L;
    jdField_b_of_type_Long = 209715200L;
  }
  
  StorageManager()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    c();
    b();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
    localIntentFilter.addAction("android.intent.action.MEDIA_EJECT");
    localIntentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_REMOVED");
    localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
    localIntentFilter.addDataScheme("file");
    VideoEnvironment.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static long a(String paramString)
  {
    try
    {
      paramString = new StatFs(paramString);
      long l = paramString.getAvailableBlocks();
      int i = paramString.getBlockSize();
      return i * l;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("StorageManager", 2, "getFreeSpace throw an Exception!", paramString);
      }
    }
    return 0L;
  }
  
  public static StorageManager a()
  {
    if (jdField_a_of_type_DovComTencentMobileqqShortvideoUtilStorageStorageManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_DovComTencentMobileqqShortvideoUtilStorageStorageManager == null) {
        jdField_a_of_type_DovComTencentMobileqqShortvideoUtilStorageStorageManager = new StorageManager();
      }
      return jdField_a_of_type_DovComTencentMobileqqShortvideoUtilStorageStorageManager;
    }
  }
  
  /* Error */
  static boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: invokestatic 131	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5: invokevirtual 135	java/lang/Thread:getId	()J
    //   8: lstore_2
    //   9: new 137	java/io/File
    //   12: dup
    //   13: new 139	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   20: aload_0
    //   21: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 146
    //   26: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: lload_2
    //   30: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 154	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 157	java/io/File:exists	()Z
    //   44: ifeq +22 -> 66
    //   47: aload_0
    //   48: invokevirtual 160	java/io/File:delete	()Z
    //   51: ifeq +8 -> 59
    //   54: aload_0
    //   55: invokevirtual 163	java/io/File:createNewFile	()Z
    //   58: istore_1
    //   59: aload_0
    //   60: invokevirtual 160	java/io/File:delete	()Z
    //   63: pop
    //   64: iload_1
    //   65: ireturn
    //   66: aload_0
    //   67: invokevirtual 163	java/io/File:createNewFile	()Z
    //   70: istore_1
    //   71: goto -12 -> 59
    //   74: astore 4
    //   76: aload 4
    //   78: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
    //   81: aload_0
    //   82: invokevirtual 160	java/io/File:delete	()Z
    //   85: pop
    //   86: iconst_0
    //   87: ireturn
    //   88: astore 4
    //   90: aload_0
    //   91: invokevirtual 160	java/io/File:delete	()Z
    //   94: pop
    //   95: aload 4
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramString	String
    //   1	70	1	bool	boolean
    //   8	22	2	l	long
    //   74	3	4	localThrowable	Throwable
    //   88	8	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   40	47	74	java/lang/Throwable
    //   47	59	74	java/lang/Throwable
    //   66	71	74	java/lang/Throwable
    //   40	47	88	finally
    //   47	59	88	finally
    //   66	71	88	finally
    //   76	81	88	finally
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      VideoEnvironment.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(StorageManager.OnSdCardChangedListener paramOnSdCardChangedListener)
  {
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilStorageStorageManager$OnSdCardChangedListener = paramOnSdCardChangedListener;
  }
  
  public void b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      return;
      this.jdField_b_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "/Android/data/com.tencent.mobileqq/qq/video");
      if (QLog.isColorLevel())
      {
        QLog.e("TAG", 2, "updateStorePath:storeVideoPath=" + this.jdField_b_of_type_JavaLangString);
        QLog.e("TAG", 2, "updateStorePath:maxAvailableSizePath=" + this.jdField_a_of_type_JavaLangString);
      }
      try
      {
        File localFile = new File(this.jdField_b_of_type_JavaLangString);
        if (!localFile.exists())
        {
          localFile.mkdirs();
          return;
        }
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_JavaLangString = null;
      }
    }
  }
  
  public void c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaLangString = "";
      this.c = 0L;
      Object localObject1 = Environment.getExternalStorageDirectory().getAbsolutePath();
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsValue(localObject1)) {
        this.jdField_a_of_type_JavaUtilHashMap.put("external_card", localObject1);
      }
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          String str = (String)((Iterator)localObject1).next();
          try
          {
            Object localObject3 = new File(str);
            if ((((File)localObject3).exists()) && (((File)localObject3).canWrite()) && (a(str)))
            {
              localObject3 = new StatFs(str);
              long l = ((StatFs)localObject3).getAvailableBlocks() * ((StatFs)localObject3).getBlockSize();
              if ((l > 0L) && (this.c < l))
              {
                this.c = l;
                this.jdField_a_of_type_JavaLangString = str;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.storage.StorageManager
 * JD-Core Version:    0.7.0.1
 */