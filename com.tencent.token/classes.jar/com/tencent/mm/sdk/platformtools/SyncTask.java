package com.tencent.mm.sdk.platformtools;

public abstract class SyncTask<R>
{
  private final long bg;
  private long bh;
  private long bi;
  private Runnable bj = new SyncTask.1(this);
  private Object lock = new Object();
  private R result;
  
  public SyncTask()
  {
    this(0L, null);
  }
  
  public SyncTask(long paramLong, R paramR)
  {
    this.bg = paramLong;
    this.result = paramR;
  }
  
  /* Error */
  public R exec(android.os.Handler paramHandler)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +15 -> 16
    //   4: ldc 51
    //   6: ldc 53
    //   8: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: aload_0
    //   12: invokevirtual 63	com/tencent/mm/sdk/platformtools/SyncTask:run	()Ljava/lang/Object;
    //   15: areturn
    //   16: invokestatic 69	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   19: invokevirtual 73	java/lang/Thread:getId	()J
    //   22: aload_1
    //   23: invokevirtual 79	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   26: invokevirtual 84	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   29: invokevirtual 73	java/lang/Thread:getId	()J
    //   32: lcmp
    //   33: ifne +15 -> 48
    //   36: ldc 51
    //   38: ldc 86
    //   40: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokevirtual 63	com/tencent/mm/sdk/platformtools/SyncTask:run	()Ljava/lang/Object;
    //   47: areturn
    //   48: aload_0
    //   49: invokestatic 91	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   52: putfield 42	com/tencent/mm/sdk/platformtools/SyncTask:bh	J
    //   55: aload_0
    //   56: getfield 25	com/tencent/mm/sdk/platformtools/SyncTask:lock	Ljava/lang/Object;
    //   59: astore 4
    //   61: aload 4
    //   63: monitorenter
    //   64: aload_1
    //   65: aload_0
    //   66: getfield 32	com/tencent/mm/sdk/platformtools/SyncTask:bj	Ljava/lang/Runnable;
    //   69: invokevirtual 95	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   72: pop
    //   73: aload_0
    //   74: getfield 25	com/tencent/mm/sdk/platformtools/SyncTask:lock	Ljava/lang/Object;
    //   77: aload_0
    //   78: getfield 34	com/tencent/mm/sdk/platformtools/SyncTask:bg	J
    //   81: invokevirtual 99	java/lang/Object:wait	(J)V
    //   84: aload 4
    //   86: monitorexit
    //   87: aload_0
    //   88: getfield 42	com/tencent/mm/sdk/platformtools/SyncTask:bh	J
    //   91: invokestatic 103	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   94: lstore_2
    //   95: ldc 51
    //   97: ldc 105
    //   99: iconst_4
    //   100: anewarray 5	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: new 107	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   112: aload_0
    //   113: getfield 36	com/tencent/mm/sdk/platformtools/SyncTask:result	Ljava/lang/Object;
    //   116: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: aastore
    //   123: dup
    //   124: iconst_1
    //   125: lload_2
    //   126: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   129: aastore
    //   130: dup
    //   131: iconst_2
    //   132: aload_0
    //   133: getfield 45	com/tencent/mm/sdk/platformtools/SyncTask:bi	J
    //   136: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   139: aastore
    //   140: dup
    //   141: iconst_3
    //   142: lload_2
    //   143: aload_0
    //   144: getfield 45	com/tencent/mm/sdk/platformtools/SyncTask:bi	J
    //   147: lsub
    //   148: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   151: aastore
    //   152: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_0
    //   156: getfield 36	com/tencent/mm/sdk/platformtools/SyncTask:result	Ljava/lang/Object;
    //   159: areturn
    //   160: astore_1
    //   161: aload 4
    //   163: monitorexit
    //   164: aload_1
    //   165: athrow
    //   166: astore_1
    //   167: aload_1
    //   168: invokevirtual 129	java/lang/InterruptedException:printStackTrace	()V
    //   171: goto -84 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	SyncTask
    //   0	174	1	paramHandler	android.os.Handler
    //   94	49	2	l	long
    // Exception table:
    //   from	to	target	type
    //   64	87	160	finally
    //   55	64	166	java/lang/InterruptedException
    //   161	166	166	java/lang/InterruptedException
  }
  
  protected abstract R run();
  
  public void setResult(R arg1)
  {
    this.result = ???;
    synchronized (this.lock)
    {
      this.lock.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SyncTask
 * JD-Core Version:    0.7.0.1
 */