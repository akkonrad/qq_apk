package com.tencent.mobileqq.shortvideo.mediacodec;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.mediacodec.AndroidCodec;
import com.tencent.av.mediacodec.AndroidCodec.BufferData;
import com.tencent.av.mediacodec.DeviceCheck;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
public class ShortVideoCodec
  extends AndroidCodec
{
  public static int e;
  public static String e;
  
  static
  {
    jdField_e_of_type_JavaLangString = "ShortVideoCodec";
    jdField_e_of_type_Int = -1;
  }
  
  @SuppressLint({"NewApi"})
  public static List a(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        if ((!paramBoolean) || ((!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE"))))
        {
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int j = 0;
          while (j < arrayOfString.length)
          {
            if (arrayOfString[j].equalsIgnoreCase(paramString)) {
              localArrayList.add(localMediaCodecInfo);
            }
            j += 1;
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static int b(Context paramContext)
  {
    if (jdField_e_of_type_Int >= 0) {
      return jdField_e_of_type_Int;
    }
    jdField_e_of_type_Int = 0;
    if (paramContext == null) {
      return jdField_e_of_type_Int;
    }
    VcControllerImpl.loadLibrary(paramContext);
    if (Build.VERSION.SDK_INT < 16) {
      return jdField_e_of_type_Int;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      a();
      if (!jdField_b_of_type_Boolean)
      {
        jdField_e_of_type_Int = 0;
        return jdField_e_of_type_Int;
      }
    }
    if (DeviceCheck.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_e_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature device is in white list.");
      }
      if (DeviceCheck.e()) {
        jdField_e_of_type_Int = 1;
      }
      if (!b()) {
        break label146;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_e_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature device is in white list.");
      }
      if (DeviceCheck.f()) {
        jdField_e_of_type_Int += 2;
      }
    }
    for (;;)
    {
      return jdField_e_of_type_Int;
      if (!DeviceCheck.e()) {
        break;
      }
      jdField_e_of_type_Int = 1;
      break;
      label146:
      if (DeviceCheck.f()) {
        jdField_e_of_type_Int += 2;
      }
    }
  }
  
  public static boolean b()
  {
    if (Build.VERSION.SDK_INT < 19) {}
    do
    {
      return false;
      if ((Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) && (Build.MODEL.equalsIgnoreCase("MI 3")) && (Build.PRODUCT.equalsIgnoreCase("pisces"))) {
        return DeviceCheck.f();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (Build.MODEL.equalsIgnoreCase("N5207")) && (Build.PRODUCT.equalsIgnoreCase("N5207"))) {
        return DeviceCheck.f();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("GT-I9500"))) {
        return DeviceCheck.f();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("Meizu")) && (Build.MODEL.equalsIgnoreCase("MX4"))) {
        return DeviceCheck.f();
      }
    } while ((!Build.MANUFACTURER.equalsIgnoreCase("Meizu")) || (!Build.MODEL.equalsIgnoreCase("MX4 Pro")));
    return DeviceCheck.f();
  }
  
  public MediaCodec a()
  {
    return this.a;
  }
  
  public AndroidCodec.BufferData b()
  {
    label404:
    label510:
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        localObject1 = this.a;
        if (localObject1 == null)
        {
          localObject1 = null;
          return localObject1;
        }
        localObject1 = new AndroidCodec.BufferData(this);
        i = this.a.dequeueOutputBuffer(((AndroidCodec.BufferData)localObject1).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, jdField_c_of_type_Int);
        switch (i)
        {
        case -3: 
          if (i < 0) {
            break label510;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_e_of_type_JavaLangString, 2, "dequeueOutputBuffer ok,index = " + i + ",BufferInfo[flags = " + ((AndroidCodec.BufferData)localObject1).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags + ",offset=" + ((AndroidCodec.BufferData)localObject1).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset + ",size= " + ((AndroidCodec.BufferData)localObject1).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size + ",TimeUs=" + ((AndroidCodec.BufferData)localObject1).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs + "]");
          }
          if (Build.VERSION.SDK_INT > 20) {
            break label404;
          }
          ((AndroidCodec.BufferData)localObject1).jdField_a_of_type_JavaNioByteBuffer = this.jdField_b_of_type_ArrayOfJavaNioByteBuffer[i];
          ((AndroidCodec.BufferData)localObject1).jdField_a_of_type_Int = i;
          ((AndroidCodec.BufferData)localObject1).jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_b_of_type_AndroidMediaMediaFormat;
          continue;
          if (QLog.isColorLevel()) {
            QLog.e(jdField_e_of_type_JavaLangString, 2, "INFO_OUTPUT_BUFFERS_CHANGED");
          }
          this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.a.getOutputBuffers();
          ((AndroidCodec.BufferData)localObject1).jdField_a_of_type_Int = -3;
        }
      }
      finally {}
      ((AndroidCodec.BufferData)localObject1).jdField_a_of_type_Int = -2;
      this.jdField_b_of_type_AndroidMediaMediaFormat = this.a.getOutputFormat();
      if (this.jdField_b_of_type_AndroidMediaMediaFormat != null)
      {
        ((AndroidCodec.BufferData)localObject1).jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_b_of_type_AndroidMediaMediaFormat;
        if (this.d == jdField_b_of_type_Int)
        {
          if (this.jdField_b_of_type_AndroidMediaMediaFormat.containsKey("color-format"))
          {
            i = this.jdField_b_of_type_AndroidMediaMediaFormat.getInteger("color-format");
            if (QLog.isColorLevel()) {
              QLog.e(jdField_e_of_type_JavaLangString, 2, "New color format " + i + "[0x" + Integer.toHexString(i) + "]");
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e(jdField_e_of_type_JavaLangString, 2, "EncCodec,INFO_OUTPUT_FORMAT_CHANGED");
          break label510;
          if (QLog.isColorLevel()) {
            QLog.e(jdField_e_of_type_JavaLangString, 2, "dequeueOutputBuffer timed out!");
          }
          localObject2.jdField_a_of_type_Int = -1;
          continue;
          localObject2.jdField_a_of_type_Int = i;
          try
          {
            localObject2.jdField_a_of_type_JavaNioByteBuffer = ((ByteBuffer)jdField_b_of_type_JavaLangReflectMethod.invoke(this.a, new Object[] { Integer.valueOf(i) }));
            localObject2.jdField_a_of_type_AndroidMediaMediaFormat = ((MediaFormat)jdField_c_of_type_JavaLangReflectMethod.invoke(this.a, new Object[] { Integer.valueOf(i) }));
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            localIllegalAccessException.printStackTrace();
            localObject2.jdField_a_of_type_Boolean = false;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            localIllegalArgumentException.printStackTrace();
            localObject2.jdField_a_of_type_Boolean = false;
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            localInvocationTargetException.printStackTrace();
            localObject2.jdField_a_of_type_Boolean = false;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediacodec.ShortVideoCodec
 * JD-Core Version:    0.7.0.1
 */