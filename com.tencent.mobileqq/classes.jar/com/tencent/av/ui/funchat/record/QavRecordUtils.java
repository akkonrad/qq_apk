package com.tencent.av.ui.funchat.record;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.ui.QavVideoRecordUICtrl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kdi;

public class QavRecordUtils
{
  public static int a(String paramString, int paramInt)
  {
    QLog.i("QavRecordUtils", 1, "parseMaxRecordTime " + paramString + ", def=" + paramInt);
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return paramInt;
      i = paramString.lastIndexOf("#");
    } while ((i < 0) || (i == paramString.length() - 1));
    paramString = paramString.substring(i + 1);
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (Throwable paramString) {}
    return paramInt;
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordUtils", 2, "convertMp3ToPcm path=" + paramString);
    }
    if (!QavVideoRecordUICtrl.f())
    {
      QLog.i("QavRecordUtils", 1, "convertMp3ToPcm system not support");
      return;
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      QLog.i("QavRecordUtils", 1, "convertMp3ToPcm, dir not exist");
      return;
    }
    if (!paramString.isDirectory())
    {
      QLog.i("QavRecordUtils", 1, "convertMp3ToPcm, dir not a directory");
      return;
    }
    paramString = paramString.listFiles();
    if ((paramString == null) || (paramString.length == 0))
    {
      QLog.i("QavRecordUtils", 1, "convertMp3ToPcm files == null || files.length == 0");
      return;
    }
    AudioFileDecoder localAudioFileDecoder = new AudioFileDecoder(48000, 16, 1);
    localAudioFileDecoder.a(new kdi());
    int i = 0;
    if (i < paramString.length)
    {
      Object localObject = paramString[i];
      String str;
      if ((localObject.exists()) && (localObject.isFile()) && (localObject.getName().endsWith(".mp3")))
      {
        str = localObject.getAbsolutePath().replace(".mp3", ".pcm");
        File localFile = new File(str);
        if ((localFile.exists()) && (localFile.length() > 0L)) {
          QLog.i("QavRecordUtils", 1, "convertMp3ToPcm file exists, skip, " + localFile.getName());
        }
      }
      for (;;)
      {
        i += 1;
        break;
        long l1 = System.currentTimeMillis();
        try
        {
          localAudioFileDecoder.a(localObject.getAbsolutePath(), str);
          long l2 = System.currentTimeMillis();
          QLog.i("QavRecordUtils", 1, "convertMp3ToPcm decode file=" + localObject.getName() + ", cost=" + (l2 - l1));
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.e("QavRecordUtils", 1, "convertMp3ToPcm decode exception:" + localThrowable, localThrowable);
            QavRecordReporter.a(false, -7);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("QavRecordUtils", 2, "convertMp3ToPcm skip file=" + localObject.getName());
        }
      }
    }
    QLog.i("QavRecordUtils", 1, "convertMp3ToPcm DONE");
  }
  
  public static boolean a()
  {
    boolean bool2 = false;
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    int i = Build.VERSION.SDK_INT;
    boolean bool1 = bool2;
    if ("Meizu".equalsIgnoreCase(str1))
    {
      if (i != 22) {
        break label89;
      }
      bool1 = true;
    }
    for (;;)
    {
      QLog.i("QavRecordUtils", 1, "isRubbishDeviceNotSupportPcm brand=" + str1 + ", model=" + str2 + ", api=" + i + ", result=" + bool1);
      return bool1;
      label89:
      if ((i == 21) && ("M040".equalsIgnoreCase(str2)))
      {
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (i == 21)
        {
          bool1 = bool2;
          if ("MX5".equalsIgnoreCase(str2)) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    if (paramVideoAppInterface.a(2))
    {
      paramVideoAppInterface = (EffectPendantTools)paramVideoAppInterface.a(2);
      if ((paramVideoAppInterface != null) && (paramVideoAppInterface.a() != null)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("avredpacket_sp", 4);
      int j = ((SharedPreferences)localObject).getInt("pcm_" + paramString, 0);
      ((SharedPreferences)localObject).edit().putInt("pcm_" + paramString, j + 1).commit();
      localObject = QavRecordDpc.a();
      if (localObject == null) {}
      for (int i = 1;; i = ((QavRecordDpc)localObject).k)
      {
        QLog.i("QavRecordUtils", 1, "canConvertPCM md5=" + paramString + ", count=" + j + ", limit=" + i);
        if (j >= i) {
          break;
        }
        return true;
      }
      return false;
    }
    catch (Throwable paramString)
    {
      QLog.e("QavRecordUtils", 1, "canConvertPCM Throwable=" + paramString, paramString);
    }
    return false;
  }
  
  public static boolean b(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    if (paramVideoAppInterface.a(3))
    {
      paramVideoAppInterface = (FaceItem)((EffectFaceManager)paramVideoAppInterface.a(3)).a();
      if ((paramVideoAppInterface != null) && ("pendant".equalsIgnoreCase(paramVideoAppInterface.getType()))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavRecordUtils
 * JD-Core Version:    0.7.0.1
 */