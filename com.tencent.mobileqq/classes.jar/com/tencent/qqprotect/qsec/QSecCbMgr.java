package com.tencent.qqprotect.qsec;

import alxj;
import alxk;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.util.Pair;
import com.tencent.ims.QQProtectCommon.QQProtectQueryHead;
import com.tencent.ims.QSecControlBitsQuery.QSecCbQuery;
import com.tencent.ims.QSecControlBitsQuery.QSecCbQueryBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.common.QPDirUtils;
import com.tencent.qqprotect.common.QPMiscUtils;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class QSecCbMgr
{
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  public QSecCbMgr()
  {
    SecSvcHandlerHelper.a("MobileQQprotect.QSecCb", new alxj(this));
    a();
  }
  
  private Pair a(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      paramString = new Pair(Integer.valueOf(Integer.parseInt(paramString)), Byte.valueOf((byte)paramJSONObject.getInt(paramString)));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private String a()
  {
    return QPDirUtils.a() + File.separator + "QSecCb.dat";
  }
  
  private void a()
  {
    byte[] arrayOfByte = new QSecStoreUtil().a(a(), null, 1);
    if (arrayOfByte != null) {
      a(arrayOfByte);
    }
  }
  
  private void a(long paramLong)
  {
    alxk localalxk = new alxk(this);
    QSecFramework.a().postDelayed(localalxk, paramLong);
  }
  
  private void a(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.getInt("ver") != 1) {
          return;
        }
        paramString = paramString.getJSONObject("cbs");
        if (paramString == null) {
          continue;
        }
        Iterator localIterator = paramString.keys();
        if (localIterator == null) {
          continue;
        }
        if (!localIterator.hasNext()) {
          continue;
        }
        localPair = a((String)localIterator.next(), paramString);
        if (localPair == null) {
          continue;
        }
        localByte = (Byte)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localPair.first);
        if (localByte != null) {
          continue;
        }
        localLinkedList.add(localPair);
      }
      catch (Exception paramString)
      {
        Pair localPair;
        Byte localByte;
        paramString.printStackTrace();
        b();
        if (localLinkedList.isEmpty()) {
          return;
        }
        paramString = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        if (!paramString.hasNext()) {
          return;
        }
        ((QSecCbMgr.IControlBitChangeListener)paramString.next()).a(localLinkedList);
        continue;
        if (localByte.byteValue() == ((Byte)localPair.second).byteValue()) {
          continue;
        }
        localLinkedList.add(localPair);
        continue;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPair.first, localPair.second);
    }
  }
  
  /* Error */
  private void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 193	java/io/DataInputStream
    //   3: dup
    //   4: new 195	java/io/ByteArrayInputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 197	java/io/ByteArrayInputStream:<init>	([B)V
    //   12: invokespecial 200	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore 4
    //   17: aload 4
    //   19: astore_1
    //   20: aload 4
    //   22: invokevirtual 204	java/io/DataInputStream:readInt	()I
    //   25: istore_3
    //   26: aload 4
    //   28: astore_1
    //   29: aload 4
    //   31: invokevirtual 207	java/io/DataInputStream:readByte	()B
    //   34: istore_2
    //   35: aload 4
    //   37: astore_1
    //   38: aload_0
    //   39: getfield 16	com/tencent/qqprotect/qsec/QSecCbMgr:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   42: iload_3
    //   43: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: iload_2
    //   47: invokestatic 61	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   50: invokevirtual 171	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   53: pop
    //   54: goto -37 -> 17
    //   57: astore 5
    //   59: aload 4
    //   61: astore_1
    //   62: aload 5
    //   64: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   67: aload 4
    //   69: ifnull +8 -> 77
    //   72: aload 4
    //   74: invokevirtual 211	java/io/DataInputStream:close	()V
    //   77: return
    //   78: astore_1
    //   79: aload_1
    //   80: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   83: return
    //   84: astore 4
    //   86: aconst_null
    //   87: astore_1
    //   88: aload_1
    //   89: ifnull +7 -> 96
    //   92: aload_1
    //   93: invokevirtual 211	java/io/DataInputStream:close	()V
    //   96: aload 4
    //   98: athrow
    //   99: astore_1
    //   100: aload_1
    //   101: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   104: goto -8 -> 96
    //   107: astore 4
    //   109: goto -21 -> 88
    //   112: astore 5
    //   114: aconst_null
    //   115: astore 4
    //   117: goto -58 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	QSecCbMgr
    //   0	120	1	paramArrayOfByte	byte[]
    //   34	13	2	b	byte
    //   25	18	3	i	int
    //   15	58	4	localDataInputStream	java.io.DataInputStream
    //   84	13	4	localObject1	Object
    //   107	1	4	localObject2	Object
    //   115	1	4	localObject3	Object
    //   57	6	5	localIOException1	java.io.IOException
    //   112	1	5	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   20	26	57	java/io/IOException
    //   29	35	57	java/io/IOException
    //   38	54	57	java/io/IOException
    //   72	77	78	java/io/IOException
    //   0	17	84	finally
    //   92	96	99	java/io/IOException
    //   20	26	107	finally
    //   29	35	107	finally
    //   38	54	107	finally
    //   62	67	107	finally
    //   0	17	112	java/io/IOException
  }
  
  /* Error */
  private byte[] a()
  {
    // Byte code:
    //   0: new 214	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 215	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: new 217	java/io/DataOutputStream
    //   11: dup
    //   12: aload_2
    //   13: invokespecial 220	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore 4
    //   18: aload_0
    //   19: getfield 16	com/tencent/qqprotect/qsec/QSecCbMgr:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   22: invokevirtual 224	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   25: invokeinterface 227 1 0
    //   30: astore_1
    //   31: aload_1
    //   32: invokeinterface 142 1 0
    //   37: ifeq +80 -> 117
    //   40: aload_1
    //   41: invokeinterface 146 1 0
    //   46: checkcast 229	java/util/Map$Entry
    //   49: astore_3
    //   50: aload 4
    //   52: aload_3
    //   53: invokeinterface 232 1 0
    //   58: checkcast 43	java/lang/Integer
    //   61: invokevirtual 235	java/lang/Integer:intValue	()I
    //   64: invokevirtual 239	java/io/DataOutputStream:writeInt	(I)V
    //   67: aload 4
    //   69: aload_3
    //   70: invokeinterface 242 1 0
    //   75: checkcast 58	java/lang/Byte
    //   78: invokevirtual 189	java/lang/Byte:byteValue	()B
    //   81: invokevirtual 245	java/io/DataOutputStream:writeByte	(I)V
    //   84: goto -53 -> 31
    //   87: astore_3
    //   88: aload_2
    //   89: astore_1
    //   90: aload 4
    //   92: astore_2
    //   93: aload_3
    //   94: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   97: aload_1
    //   98: ifnull +7 -> 105
    //   101: aload_1
    //   102: invokevirtual 246	java/io/ByteArrayOutputStream:close	()V
    //   105: aload_2
    //   106: ifnull +7 -> 113
    //   109: aload_2
    //   110: invokevirtual 247	java/io/DataOutputStream:close	()V
    //   113: aconst_null
    //   114: astore_2
    //   115: aload_2
    //   116: areturn
    //   117: aload_2
    //   118: invokevirtual 250	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   121: astore_1
    //   122: aload_2
    //   123: ifnull +7 -> 130
    //   126: aload_2
    //   127: invokevirtual 246	java/io/ByteArrayOutputStream:close	()V
    //   130: aload_1
    //   131: astore_2
    //   132: aload 4
    //   134: ifnull -19 -> 115
    //   137: aload 4
    //   139: invokevirtual 247	java/io/DataOutputStream:close	()V
    //   142: aload_1
    //   143: areturn
    //   144: astore_2
    //   145: aload_2
    //   146: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   149: aload_1
    //   150: areturn
    //   151: astore_2
    //   152: aload_2
    //   153: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   156: goto -26 -> 130
    //   159: astore_1
    //   160: aload_1
    //   161: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   164: goto -59 -> 105
    //   167: astore_1
    //   168: aload_1
    //   169: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   172: goto -59 -> 113
    //   175: astore_1
    //   176: aconst_null
    //   177: astore_3
    //   178: aconst_null
    //   179: astore_2
    //   180: aload_3
    //   181: ifnull +7 -> 188
    //   184: aload_3
    //   185: invokevirtual 246	java/io/ByteArrayOutputStream:close	()V
    //   188: aload_2
    //   189: ifnull +7 -> 196
    //   192: aload_2
    //   193: invokevirtual 247	java/io/DataOutputStream:close	()V
    //   196: aload_1
    //   197: athrow
    //   198: astore_3
    //   199: aload_3
    //   200: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   203: goto -15 -> 188
    //   206: astore_2
    //   207: aload_2
    //   208: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   211: goto -15 -> 196
    //   214: astore_1
    //   215: aconst_null
    //   216: astore 4
    //   218: aload_2
    //   219: astore_3
    //   220: aload 4
    //   222: astore_2
    //   223: goto -43 -> 180
    //   226: astore_1
    //   227: aload_2
    //   228: astore_3
    //   229: aload 4
    //   231: astore_2
    //   232: goto -52 -> 180
    //   235: astore 4
    //   237: aload_1
    //   238: astore_3
    //   239: aload 4
    //   241: astore_1
    //   242: goto -62 -> 180
    //   245: astore_3
    //   246: aconst_null
    //   247: astore_1
    //   248: aconst_null
    //   249: astore_2
    //   250: goto -157 -> 93
    //   253: astore_3
    //   254: aload_2
    //   255: astore_1
    //   256: aconst_null
    //   257: astore_2
    //   258: goto -165 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	QSecCbMgr
    //   30	120	1	localObject1	Object
    //   159	2	1	localIOException1	java.io.IOException
    //   167	2	1	localIOException2	java.io.IOException
    //   175	22	1	localObject2	Object
    //   214	1	1	localObject3	Object
    //   226	12	1	localObject4	Object
    //   241	15	1	localObject5	Object
    //   7	125	2	localObject6	Object
    //   144	2	2	localIOException3	java.io.IOException
    //   151	2	2	localIOException4	java.io.IOException
    //   179	14	2	localObject7	Object
    //   206	13	2	localIOException5	java.io.IOException
    //   222	36	2	localObject8	Object
    //   49	21	3	localEntry	java.util.Map.Entry
    //   87	7	3	localIOException6	java.io.IOException
    //   177	8	3	localObject9	Object
    //   198	2	3	localIOException7	java.io.IOException
    //   219	20	3	localObject10	Object
    //   245	1	3	localIOException8	java.io.IOException
    //   253	1	3	localIOException9	java.io.IOException
    //   16	214	4	localDataOutputStream	java.io.DataOutputStream
    //   235	5	4	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   18	31	87	java/io/IOException
    //   31	84	87	java/io/IOException
    //   117	122	87	java/io/IOException
    //   137	142	144	java/io/IOException
    //   126	130	151	java/io/IOException
    //   101	105	159	java/io/IOException
    //   109	113	167	java/io/IOException
    //   0	8	175	finally
    //   184	188	198	java/io/IOException
    //   192	196	206	java/io/IOException
    //   8	18	214	finally
    //   18	31	226	finally
    //   31	84	226	finally
    //   117	122	226	finally
    //   93	97	235	finally
    //   0	8	245	java/io/IOException
    //   8	18	253	java/io/IOException
  }
  
  private void b()
  {
    byte[] arrayOfByte = a();
    if (arrayOfByte != null) {
      new QSecStoreUtil().a(a(), arrayOfByte, null, 1);
    }
  }
  
  public byte a(int paramInt)
  {
    Byte localByte = (Byte)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localByte != null) {
      return localByte.byteValue();
    }
    return -1;
  }
  
  public void a(QSecCbMgr.IControlBitChangeListener paramIControlBitChangeListener)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramIControlBitChangeListener);
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.Cb", 2, "Start to query cb!");
      }
      Object localObject1 = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localObject1 == null) {
        return;
      }
      localObject1 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("QSecCbLqt", 0);
      if (!paramBoolean)
      {
        long l1 = ((SharedPreferences)localObject1).getLong("qt", 0L);
        long l2 = new Date().getTime();
        l1 = l2 - l1;
        if (l1 < 28800000L)
        {
          a(28800000L - l1);
          return;
        }
      }
      localObject1 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject1).putLong("qt", new Date().getTime());
      ((SharedPreferences.Editor)localObject1).commit();
      localObject1 = QPMiscUtils.a(0);
      if (localObject1 == null) {
        return;
      }
      QSecControlBitsQuery.QSecCbQueryBody localQSecCbQueryBody = new QSecControlBitsQuery.QSecCbQueryBody();
      QSecControlBitsQuery.QSecCbQuery localQSecCbQuery = new QSecControlBitsQuery.QSecCbQuery();
      localQSecCbQueryBody.u32_cfg_id.set(1);
      localQSecCbQueryBody.u32_qsec_ver.set(33751040);
      localQSecCbQuery.cb_query_head.set((MessageMicro)localObject1);
      localQSecCbQuery.cb_query_body.set(localQSecCbQueryBody);
      SecSvcHandlerHelper.a("MobileQQprotect.QSecCb", localQSecCbQuery.toByteArray());
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return;
    }
    finally
    {
      a(28800000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecCbMgr
 * JD-Core Version:    0.7.0.1
 */