package com.tencent.mobileqq.apollo.store.webview;

import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class BridgeStream
  extends InputStream
{
  private BufferedInputStream jdField_a_of_type_JavaIoBufferedInputStream;
  private ByteArrayOutputStream jdField_a_of_type_JavaIoByteArrayOutputStream;
  private final WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  private BufferedInputStream jdField_b_of_type_JavaIoBufferedInputStream;
  private boolean jdField_b_of_type_Boolean = true;
  
  public BridgeStream(BridgeStream.IBridgeStreamCallback paramIBridgeStreamCallback, ByteArrayOutputStream paramByteArrayOutputStream, BufferedInputStream paramBufferedInputStream)
  {
    if (paramBufferedInputStream != null)
    {
      this.jdField_a_of_type_JavaIoBufferedInputStream = paramBufferedInputStream;
      this.jdField_a_of_type_Boolean = false;
    }
    if (paramByteArrayOutputStream != null)
    {
      this.jdField_a_of_type_JavaIoByteArrayOutputStream = paramByteArrayOutputStream;
      this.jdField_b_of_type_JavaIoBufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(paramByteArrayOutputStream.toByteArray()));
      this.jdField_b_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIBridgeStreamCallback);
      return;
      this.jdField_a_of_type_JavaIoByteArrayOutputStream = new ByteArrayOutputStream();
    }
  }
  
  /* Error */
  @TargetApi(9)
  public void close()
  {
    // Byte code:
    //   0: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +43 -> 46
    //   6: ldc 64
    //   8: iconst_2
    //   9: new 66	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   16: ldc 69
    //   18: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: getfield 17	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_a_of_type_Boolean	Z
    //   25: invokevirtual 76	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   28: ldc 78
    //   30: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: getfield 19	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_b_of_type_Boolean	Z
    //   37: invokevirtual 76	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   40: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_0
    //   47: getfield 41	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_b_of_type_JavaIoBufferedInputStream	Ljava/io/BufferedInputStream;
    //   50: ifnull +15 -> 65
    //   53: aload_0
    //   54: getfield 41	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_b_of_type_JavaIoBufferedInputStream	Ljava/io/BufferedInputStream;
    //   57: invokevirtual 88	java/io/BufferedInputStream:close	()V
    //   60: aload_0
    //   61: aconst_null
    //   62: putfield 41	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_b_of_type_JavaIoBufferedInputStream	Ljava/io/BufferedInputStream;
    //   65: aload_0
    //   66: getfield 21	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_a_of_type_JavaIoBufferedInputStream	Ljava/io/BufferedInputStream;
    //   69: ifnull +15 -> 84
    //   72: aload_0
    //   73: getfield 21	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_a_of_type_JavaIoBufferedInputStream	Ljava/io/BufferedInputStream;
    //   76: invokevirtual 88	java/io/BufferedInputStream:close	()V
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 21	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_a_of_type_JavaIoBufferedInputStream	Ljava/io/BufferedInputStream;
    //   84: aload_0
    //   85: getfield 48	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   88: invokevirtual 92	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   91: checkcast 94	com/tencent/mobileqq/apollo/store/webview/BridgeStream$IBridgeStreamCallback
    //   94: astore_2
    //   95: aload_2
    //   96: ifnull +30 -> 126
    //   99: aload_0
    //   100: getfield 17	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_a_of_type_Boolean	Z
    //   103: ifeq +29 -> 132
    //   106: aload_0
    //   107: getfield 19	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_b_of_type_Boolean	Z
    //   110: ifeq +22 -> 132
    //   113: iconst_1
    //   114: istore_1
    //   115: aload_2
    //   116: iload_1
    //   117: aload_0
    //   118: getfield 23	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_a_of_type_JavaIoByteArrayOutputStream	Ljava/io/ByteArrayOutputStream;
    //   121: invokeinterface 97 3 0
    //   126: aload_0
    //   127: aconst_null
    //   128: putfield 23	com/tencent/mobileqq/apollo/store/webview/BridgeStream:jdField_a_of_type_JavaIoByteArrayOutputStream	Ljava/io/ByteArrayOutputStream;
    //   131: return
    //   132: iconst_0
    //   133: istore_1
    //   134: goto -19 -> 115
    //   137: astore_2
    //   138: ldc 64
    //   140: iconst_2
    //   141: new 66	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   148: ldc 99
    //   150: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_2
    //   154: invokevirtual 102	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   157: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload_2
    //   167: instanceof 107
    //   170: ifeq +8 -> 178
    //   173: aload_2
    //   174: checkcast 107	java/io/IOException
    //   177: athrow
    //   178: new 107	java/io/IOException
    //   181: dup
    //   182: aload_2
    //   183: invokespecial 110	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	BridgeStream
    //   114	20	1	bool	boolean
    //   94	22	2	localIBridgeStreamCallback	BridgeStream.IBridgeStreamCallback
    //   137	46	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   46	65	137	java/lang/Throwable
    //   65	84	137	java/lang/Throwable
    //   84	95	137	java/lang/Throwable
    //   99	113	137	java/lang/Throwable
    //   115	126	137	java/lang/Throwable
    //   126	131	137	java/lang/Throwable
  }
  
  @TargetApi(9)
  public int read()
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_b_of_type_JavaIoBufferedInputStream != null) && (!this.jdField_b_of_type_Boolean))
        {
          i = this.jdField_b_of_type_JavaIoBufferedInputStream.read();
          int j = i;
          if (-1 == i)
          {
            this.jdField_b_of_type_Boolean = true;
            j = i;
            if (this.jdField_a_of_type_JavaIoBufferedInputStream != null)
            {
              j = i;
              if (!this.jdField_a_of_type_Boolean)
              {
                j = this.jdField_a_of_type_JavaIoBufferedInputStream.read();
                if (-1 == j) {
                  continue;
                }
                this.jdField_a_of_type_JavaIoByteArrayOutputStream.write(j);
              }
            }
          }
          return j;
          this.jdField_a_of_type_Boolean = true;
          continue;
          throw new IOException(localThrowable2);
        }
      }
      catch (Throwable localThrowable1)
      {
        QLog.e("Apollo_BridgeStream", 2, "read error:" + localThrowable1.getMessage());
        if ((localThrowable1 instanceof IOException)) {
          throw ((IOException)localThrowable1);
        }
      }
      finally {}
      int i = -1;
    }
  }
  
  public int read(@NonNull byte[] paramArrayOfByte)
  {
    try
    {
      int i = read(paramArrayOfByte, 0, paramArrayOfByte.length);
      return i;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public int read(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = -1;
    for (;;)
    {
      int j;
      int m;
      try
      {
        j = paramArrayOfByte.length;
        if (((paramInt1 | paramInt2) < 0) || (paramInt1 > j) || (j - paramInt1 < paramInt2)) {
          break label109;
        }
        j = 0;
        if (j >= paramInt2) {
          break label117;
        }
        try
        {
          m = read();
          if (m != -1) {
            break label87;
          }
          if (j != 0) {
            continue;
          }
          paramInt1 = k;
        }
        catch (IOException paramArrayOfByte)
        {
          if (j == 0) {
            continue;
          }
          paramInt1 = j;
          continue;
          throw paramArrayOfByte;
        }
        return paramInt1;
      }
      finally {}
      paramInt1 = j;
      continue;
      label87:
      int i = (byte)m;
      paramArrayOfByte[(paramInt1 + j)] = i;
      j += 1;
      continue;
      label109:
      throw new ArrayIndexOutOfBoundsException();
      label117:
      paramInt1 = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.BridgeStream
 * JD-Core Version:    0.7.0.1
 */