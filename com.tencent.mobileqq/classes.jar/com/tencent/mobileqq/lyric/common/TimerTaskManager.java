package com.tencent.mobileqq.lyric.common;

import aecm;
import aecn;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimerTaskManager
{
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private ScheduledThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor;
  
  public TimerTaskManager()
  {
    a();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor == null) {
      this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor = new aecm(this, 1);
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/tencent/mobileqq/lyric/common/TimerTaskManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 33 2 0
    //   12: checkcast 35	aecn
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull +128 -> 145
    //   20: ldc 37
    //   22: ldc 39
    //   24: iconst_1
    //   25: anewarray 4	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: aload_1
    //   31: aastore
    //   32: invokestatic 45	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   35: invokestatic 51	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   38: pop
    //   39: aload_3
    //   40: invokestatic 54	aecn:a	(Laecn;)Ljava/util/concurrent/ScheduledFuture;
    //   43: ifnull +14 -> 57
    //   46: aload_3
    //   47: invokestatic 54	aecn:a	(Laecn;)Ljava/util/concurrent/ScheduledFuture;
    //   50: iconst_1
    //   51: invokeinterface 60 2 0
    //   56: pop
    //   57: aload_0
    //   58: getfield 21	com/tencent/mobileqq/lyric/common/TimerTaskManager:jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor	Ljava/util/concurrent/ScheduledThreadPoolExecutor;
    //   61: aload_3
    //   62: invokestatic 63	aecn:a	(Laecn;)Ljava/lang/Runnable;
    //   65: invokevirtual 69	java/util/concurrent/ScheduledThreadPoolExecutor:remove	(Ljava/lang/Runnable;)Z
    //   68: istore_2
    //   69: aload_0
    //   70: getfield 21	com/tencent/mobileqq/lyric/common/TimerTaskManager:jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor	Ljava/util/concurrent/ScheduledThreadPoolExecutor;
    //   73: invokevirtual 72	java/util/concurrent/ScheduledThreadPoolExecutor:purge	()V
    //   76: ldc 37
    //   78: new 74	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   85: ldc 77
    //   87: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: iload_2
    //   91: invokevirtual 84	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   94: ldc 86
    //   96: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_0
    //   100: getfield 21	com/tencent/mobileqq/lyric/common/TimerTaskManager:jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor	Ljava/util/concurrent/ScheduledThreadPoolExecutor;
    //   103: invokevirtual 90	java/util/concurrent/ScheduledThreadPoolExecutor:toString	()Ljava/lang/String;
    //   106: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 94	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   115: pop
    //   116: aload_3
    //   117: invokestatic 97	aecn:a	(Laecn;)Lcom/tencent/mobileqq/lyric/common/TimerTaskManager$TimerTaskRunnable;
    //   120: iconst_0
    //   121: invokestatic 102	com/tencent/mobileqq/lyric/common/TimerTaskManager$TimerTaskRunnable:a	(Lcom/tencent/mobileqq/lyric/common/TimerTaskManager$TimerTaskRunnable;Z)Z
    //   124: pop
    //   125: aload_3
    //   126: aconst_null
    //   127: invokestatic 105	aecn:a	(Laecn;Lcom/tencent/mobileqq/lyric/common/TimerTaskManager$TimerTaskRunnable;)Lcom/tencent/mobileqq/lyric/common/TimerTaskManager$TimerTaskRunnable;
    //   130: pop
    //   131: aload_0
    //   132: getfield 16	com/tencent/mobileqq/lyric/common/TimerTaskManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   135: aload_1
    //   136: invokeinterface 107 2 0
    //   141: pop
    //   142: aload_0
    //   143: monitorexit
    //   144: return
    //   145: ldc 37
    //   147: ldc 109
    //   149: iconst_1
    //   150: anewarray 4	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: aload_1
    //   156: aastore
    //   157: invokestatic 45	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   160: invokestatic 51	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   163: pop
    //   164: goto -22 -> 142
    //   167: astore_1
    //   168: aload_0
    //   169: monitorexit
    //   170: aload_1
    //   171: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	TimerTaskManager
    //   0	172	1	paramString	String
    //   68	23	2	bool	boolean
    //   15	111	3	localaecn	aecn
    // Exception table:
    //   from	to	target	type
    //   2	16	167	finally
    //   20	57	167	finally
    //   57	142	167	finally
    //   145	164	167	finally
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, TimerTaskManager.TimerTaskRunnable paramTimerTaskRunnable)
  {
    try
    {
      Log.i("LyricTimerTaskManager", String.format("schedule begin [%s].", new Object[] { paramString }));
      if (paramString == null) {
        throw new IllegalArgumentException("taskName 参数不能为 null.");
      }
    }
    finally {}
    if ((paramLong1 < 0L) || (paramLong2 <= 0L)) {
      throw new IllegalArgumentException("delay 或者 period 不合法.");
    }
    if (paramTimerTaskRunnable == null) {
      throw new IllegalArgumentException("runnable 参数不能为 null.");
    }
    a();
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      Log.i("LyricTimerTaskManager", String.format("schedule -> cancel duplication of name[%s].", new Object[] { paramString }));
      a(paramString);
    }
    Log.i("LyricTimerTaskManager", String.format("schedule -> create new Task [%s][period : %d].", new Object[] { paramString, Long.valueOf(paramLong2) }));
    paramTimerTaskRunnable = aecn.a(paramTimerTaskRunnable);
    aecn.a(paramTimerTaskRunnable, paramLong2);
    aecn.a(paramTimerTaskRunnable, paramString);
    aecn.a(paramTimerTaskRunnable, this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.scheduleWithFixedDelay(aecn.a(paramTimerTaskRunnable), paramLong1, paramLong2, TimeUnit.MILLISECONDS));
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramTimerTaskRunnable);
    Log.i("LyricTimerTaskManager", String.format("schedule end [%s].", new Object[] { paramString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.common.TimerTaskManager
 * JD-Core Version:    0.7.0.1
 */