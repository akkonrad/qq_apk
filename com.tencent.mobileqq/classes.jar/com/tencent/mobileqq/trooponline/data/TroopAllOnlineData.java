package com.tencent.mobileqq.trooponline.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.util.List;

public class TroopAllOnlineData
  extends Entity
{
  public static final String TAG = "TroopAllOnlineData";
  public List memberUinList;
  public long nextReqTime;
  @unique
  public String troopUin;
  public byte[] uinData;
  
  /* Error */
  protected void postRead()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 28	com/tencent/mobileqq/persistence/Entity:postRead	()V
    //   4: aload_0
    //   5: getfield 30	com/tencent/mobileqq/trooponline/data/TroopAllOnlineData:uinData	[B
    //   8: ifnull +11 -> 19
    //   11: aload_0
    //   12: getfield 30	com/tencent/mobileqq/trooponline/data/TroopAllOnlineData:uinData	[B
    //   15: arraylength
    //   16: ifne +4 -> 20
    //   19: return
    //   20: new 32	java/io/ObjectInputStream
    //   23: dup
    //   24: new 34	java/io/ByteArrayInputStream
    //   27: dup
    //   28: aload_0
    //   29: getfield 30	com/tencent/mobileqq/trooponline/data/TroopAllOnlineData:uinData	[B
    //   32: invokespecial 37	java/io/ByteArrayInputStream:<init>	([B)V
    //   35: invokespecial 40	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore_2
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: invokevirtual 44	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   45: astore_3
    //   46: aload_2
    //   47: astore_1
    //   48: aload_3
    //   49: instanceof 46
    //   52: ifeq +13 -> 65
    //   55: aload_2
    //   56: astore_1
    //   57: aload_0
    //   58: aload_3
    //   59: checkcast 46	java/util/List
    //   62: putfield 48	com/tencent/mobileqq/trooponline/data/TroopAllOnlineData:memberUinList	Ljava/util/List;
    //   65: aload_2
    //   66: ifnull -47 -> 19
    //   69: aload_2
    //   70: invokevirtual 51	java/io/ObjectInputStream:close	()V
    //   73: return
    //   74: astore_1
    //   75: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq -59 -> 19
    //   81: ldc 8
    //   83: iconst_2
    //   84: new 59	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   91: ldc 62
    //   93: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_1
    //   97: invokevirtual 70	java/io/IOException:toString	()Ljava/lang/String;
    //   100: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: return
    //   110: astore_3
    //   111: aconst_null
    //   112: astore_2
    //   113: aload_2
    //   114: astore_1
    //   115: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +33 -> 151
    //   121: aload_2
    //   122: astore_1
    //   123: ldc 8
    //   125: iconst_2
    //   126: new 59	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   133: ldc 62
    //   135: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_3
    //   139: invokevirtual 76	java/lang/Exception:toString	()Ljava/lang/String;
    //   142: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload_2
    //   152: ifnull -133 -> 19
    //   155: aload_2
    //   156: invokevirtual 51	java/io/ObjectInputStream:close	()V
    //   159: return
    //   160: astore_1
    //   161: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq -145 -> 19
    //   167: ldc 8
    //   169: iconst_2
    //   170: new 59	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   177: ldc 62
    //   179: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_1
    //   183: invokevirtual 70	java/io/IOException:toString	()Ljava/lang/String;
    //   186: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: return
    //   196: astore_2
    //   197: aconst_null
    //   198: astore_1
    //   199: aload_1
    //   200: ifnull +7 -> 207
    //   203: aload_1
    //   204: invokevirtual 51	java/io/ObjectInputStream:close	()V
    //   207: aload_2
    //   208: athrow
    //   209: astore_1
    //   210: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq -6 -> 207
    //   216: ldc 8
    //   218: iconst_2
    //   219: new 59	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   226: ldc 62
    //   228: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_1
    //   232: invokevirtual 70	java/io/IOException:toString	()Ljava/lang/String;
    //   235: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: goto -37 -> 207
    //   247: astore_2
    //   248: goto -49 -> 199
    //   251: astore_3
    //   252: goto -139 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	TroopAllOnlineData
    //   40	17	1	localObjectInputStream1	java.io.ObjectInputStream
    //   74	23	1	localIOException1	java.io.IOException
    //   114	9	1	localObjectInputStream2	java.io.ObjectInputStream
    //   160	23	1	localIOException2	java.io.IOException
    //   198	6	1	localObject1	java.lang.Object
    //   209	23	1	localIOException3	java.io.IOException
    //   38	118	2	localObjectInputStream3	java.io.ObjectInputStream
    //   196	12	2	localObject2	java.lang.Object
    //   247	1	2	localObject3	java.lang.Object
    //   45	14	3	localObject4	java.lang.Object
    //   110	29	3	localException1	java.lang.Exception
    //   251	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   69	73	74	java/io/IOException
    //   20	39	110	java/lang/Exception
    //   155	159	160	java/io/IOException
    //   20	39	196	finally
    //   203	207	209	java/io/IOException
    //   41	46	247	finally
    //   48	55	247	finally
    //   57	65	247	finally
    //   115	121	247	finally
    //   123	151	247	finally
    //   41	46	251	java/lang/Exception
    //   48	55	251	java/lang/Exception
    //   57	65	251	java/lang/Exception
  }
  
  /* Error */
  protected void prewrite()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 79	com/tencent/mobileqq/persistence/Entity:prewrite	()V
    //   4: aload_0
    //   5: getfield 48	com/tencent/mobileqq/trooponline/data/TroopAllOnlineData:memberUinList	Ljava/util/List;
    //   8: ifnull +15 -> 23
    //   11: aload_0
    //   12: getfield 48	com/tencent/mobileqq/trooponline/data/TroopAllOnlineData:memberUinList	Ljava/util/List;
    //   15: invokeinterface 83 1 0
    //   20: ifne +4 -> 24
    //   23: return
    //   24: new 85	java/io/ByteArrayOutputStream
    //   27: dup
    //   28: invokespecial 86	java/io/ByteArrayOutputStream:<init>	()V
    //   31: astore_3
    //   32: new 88	java/io/ObjectOutputStream
    //   35: dup
    //   36: aload_3
    //   37: invokespecial 91	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   40: astore_2
    //   41: aload_2
    //   42: astore_1
    //   43: aload_2
    //   44: aload_0
    //   45: getfield 48	com/tencent/mobileqq/trooponline/data/TroopAllOnlineData:memberUinList	Ljava/util/List;
    //   48: invokevirtual 95	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   51: aload_2
    //   52: astore_1
    //   53: aload_2
    //   54: invokevirtual 98	java/io/ObjectOutputStream:flush	()V
    //   57: aload_2
    //   58: astore_1
    //   59: aload_0
    //   60: aload_3
    //   61: invokevirtual 102	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   64: putfield 30	com/tencent/mobileqq/trooponline/data/TroopAllOnlineData:uinData	[B
    //   67: aload_2
    //   68: ifnull -45 -> 23
    //   71: aload_2
    //   72: invokevirtual 103	java/io/ObjectOutputStream:close	()V
    //   75: return
    //   76: astore_1
    //   77: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq -57 -> 23
    //   83: ldc 8
    //   85: iconst_2
    //   86: new 59	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   93: ldc 105
    //   95: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_1
    //   99: invokevirtual 70	java/io/IOException:toString	()Ljava/lang/String;
    //   102: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: return
    //   112: astore_3
    //   113: aconst_null
    //   114: astore_2
    //   115: aload_2
    //   116: astore_1
    //   117: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +33 -> 153
    //   123: aload_2
    //   124: astore_1
    //   125: ldc 8
    //   127: iconst_2
    //   128: new 59	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   135: ldc 105
    //   137: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_3
    //   141: invokevirtual 70	java/io/IOException:toString	()Ljava/lang/String;
    //   144: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: aload_2
    //   154: ifnull -131 -> 23
    //   157: aload_2
    //   158: invokevirtual 103	java/io/ObjectOutputStream:close	()V
    //   161: return
    //   162: astore_1
    //   163: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq -143 -> 23
    //   169: ldc 8
    //   171: iconst_2
    //   172: new 59	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   179: ldc 105
    //   181: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_1
    //   185: invokevirtual 70	java/io/IOException:toString	()Ljava/lang/String;
    //   188: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: return
    //   198: astore_2
    //   199: aconst_null
    //   200: astore_1
    //   201: aload_1
    //   202: ifnull +7 -> 209
    //   205: aload_1
    //   206: invokevirtual 103	java/io/ObjectOutputStream:close	()V
    //   209: aload_2
    //   210: athrow
    //   211: astore_1
    //   212: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq -6 -> 209
    //   218: ldc 8
    //   220: iconst_2
    //   221: new 59	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   228: ldc 105
    //   230: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_1
    //   234: invokevirtual 70	java/io/IOException:toString	()Ljava/lang/String;
    //   237: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: goto -37 -> 209
    //   249: astore_2
    //   250: goto -49 -> 201
    //   253: astore_3
    //   254: goto -139 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	TroopAllOnlineData
    //   42	17	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   76	23	1	localIOException1	java.io.IOException
    //   116	9	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   162	23	1	localIOException2	java.io.IOException
    //   200	6	1	localObject1	java.lang.Object
    //   211	23	1	localIOException3	java.io.IOException
    //   40	118	2	localObjectOutputStream3	java.io.ObjectOutputStream
    //   198	12	2	localObject2	java.lang.Object
    //   249	1	2	localObject3	java.lang.Object
    //   31	30	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   112	29	3	localIOException4	java.io.IOException
    //   253	1	3	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   71	75	76	java/io/IOException
    //   24	41	112	java/io/IOException
    //   157	161	162	java/io/IOException
    //   24	41	198	finally
    //   205	209	211	java/io/IOException
    //   43	51	249	finally
    //   53	57	249	finally
    //   59	67	249	finally
    //   117	123	249	finally
    //   125	153	249	finally
    //   43	51	253	java/io/IOException
    //   53	57	253	java/io/IOException
    //   59	67	253	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.data.TroopAllOnlineData
 * JD-Core Version:    0.7.0.1
 */