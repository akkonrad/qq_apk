package c.t.m.g;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public final class ab
{
  private static ab a = new ab();
  private Timer b = new Timer("ConnectionTimer", true);
  private Map<Runnable, TimerTask> c = new ConcurrentHashMap();
  
  public static ab a()
  {
    return a;
  }
  
  /* Error */
  private void a(Runnable paramRunnable, boolean paramBoolean, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 39	c/t/m/g/ab:a	(Ljava/lang/Runnable;)Z
    //   7: pop
    //   8: new 41	c/t/m/g/ac
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 44	c/t/m/g/ac:<init>	(Ljava/lang/Runnable;)V
    //   16: astore 5
    //   18: iload_2
    //   19: ifeq +30 -> 49
    //   22: aload_0
    //   23: getfield 34	c/t/m/g/ab:b	Ljava/util/Timer;
    //   26: aload 5
    //   28: lload_3
    //   29: lload_3
    //   30: invokevirtual 48	java/util/Timer:schedule	(Ljava/util/TimerTask;JJ)V
    //   33: aload_0
    //   34: getfield 25	c/t/m/g/ab:c	Ljava/util/Map;
    //   37: aload_1
    //   38: aload 5
    //   40: invokeinterface 54 3 0
    //   45: pop
    //   46: aload_1
    //   47: monitorexit
    //   48: return
    //   49: aload_0
    //   50: getfield 34	c/t/m/g/ab:b	Ljava/util/Timer;
    //   53: aload 5
    //   55: lload_3
    //   56: invokevirtual 57	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   59: goto -26 -> 33
    //   62: astore 5
    //   64: aload_1
    //   65: monitorexit
    //   66: aload 5
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	ab
    //   0	69	1	paramRunnable	Runnable
    //   0	69	2	paramBoolean	boolean
    //   0	69	3	paramLong	long
    //   16	38	5	localac	ac
    //   62	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	62	finally
    //   22	33	62	finally
    //   33	48	62	finally
    //   49	59	62	finally
  }
  
  public final void a(Runnable paramRunnable, long paramLong)
  {
    a(paramRunnable, false, paramLong);
  }
  
  public final boolean a(Runnable paramRunnable)
  {
    try
    {
      TimerTask localTimerTask = (TimerTask)this.c.get(paramRunnable);
      if (localTimerTask != null)
      {
        this.c.remove(paramRunnable);
        boolean bool = localTimerTask.cancel();
        return bool;
      }
      return true;
    }
    finally {}
  }
  
  public final void b(Runnable paramRunnable, long paramLong)
  {
    a(paramRunnable, true, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.ab
 * JD-Core Version:    0.7.0.1
 */