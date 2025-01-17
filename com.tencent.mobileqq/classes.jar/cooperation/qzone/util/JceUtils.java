package cooperation.qzone.util;

import PUSH_COMM_STRUCT.BinaryPushInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.io.ByteArrayOutputStream;
import java.util.zip.Inflater;

public class JceUtils
{
  public static JceStruct a(Class paramClass, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramClass = (JceStruct)paramClass.newInstance();
      paramArrayOfByte = new JceInputStream(paramArrayOfByte);
      paramArrayOfByte.setServerEncoding("utf8");
      paramClass.readFrom(paramArrayOfByte);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public static byte[] a(JceStruct paramJceStruct)
  {
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding("utf8");
    paramJceStruct.writeTo(localJceOutputStream);
    return localJceOutputStream.toByteArray();
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject1 = paramArrayOfByte;
    Object localObject2;
    if (paramArrayOfByte != null)
    {
      localObject2 = (BinaryPushInfo)a(BinaryPushInfo.class, paramArrayOfByte);
      if (((BinaryPushInfo)localObject2).compressType != 0L) {
        break label32;
      }
      localObject1 = ((BinaryPushInfo)localObject2).pushBuffer;
    }
    label32:
    do
    {
      return localObject1;
      localObject1 = paramArrayOfByte;
    } while (((BinaryPushInfo)localObject2).compressType != 2L);
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      localObject1 = new Inflater();
      ((Inflater)localObject1).setInput(((BinaryPushInfo)localObject2).pushBuffer, 0, ((BinaryPushInfo)localObject2).pushBuffer.length);
      localObject2 = new byte[4096];
      localByteArrayOutputStream = new ByteArrayOutputStream();
      while (!((Inflater)localObject1).finished()) {
        localByteArrayOutputStream.write((byte[])localObject2, 0, ((Inflater)localObject1).inflate((byte[])localObject2));
      }
      localException.end();
    }
    catch (Exception localException)
    {
      QZLog.e("JceUtils.inflateByte", "Push Buf decompresse error!", localException);
      return paramArrayOfByte;
    }
    byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.JceUtils
 * JD-Core Version:    0.7.0.1
 */