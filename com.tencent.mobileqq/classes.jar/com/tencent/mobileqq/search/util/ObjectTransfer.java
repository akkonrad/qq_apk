package com.tencent.mobileqq.search.util;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ObjectTransfer
{
  public static ObjectTransfer a;
  public long a;
  public Map a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqSearchUtilObjectTransfer = new ObjectTransfer();
  }
  
  private ObjectTransfer()
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public static ObjectTransfer a()
  {
    return jdField_a_of_type_ComTencentMobileqqSearchUtilObjectTransfer;
  }
  
  public long a(Object paramObject)
  {
    long l;
    if (paramObject == null) {
      l = -9223372036854775808L;
    }
    for (;;)
    {
      return l;
      try
      {
        l = this.jdField_a_of_type_Long;
        this.jdField_a_of_type_Long = (1L + l);
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), new WeakReference(paramObject));
      }
      finally {}
    }
  }
  
  /* Error */
  public Object a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/tencent/mobileqq/search/util/ObjectTransfer:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: lload_1
    //   7: invokestatic 34	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10: invokeinterface 50 2 0
    //   15: checkcast 36	java/lang/ref/WeakReference
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +12 -> 32
    //   23: aload_3
    //   24: invokevirtual 53	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: areturn
    //   32: aconst_null
    //   33: astore_3
    //   34: goto -6 -> 28
    //   37: astore_3
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_3
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	ObjectTransfer
    //   0	42	1	paramLong	long
    //   18	16	3	localObject1	Object
    //   37	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	37	finally
    //   23	28	37	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.ObjectTransfer
 * JD-Core Version:    0.7.0.1
 */