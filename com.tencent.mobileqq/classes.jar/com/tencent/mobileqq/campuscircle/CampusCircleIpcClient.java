package com.tencent.mobileqq.campuscircle;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class CampusCircleIpcClient
  implements EIPCResultCallback
{
  private static CampusCircleIpcClient a;
  
  public static CampusCircleIpcClient a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new CampusCircleIpcClient();
      }
      return a;
    }
    finally {}
  }
  
  /* Error */
  public Bundle a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +11 -> 16
    //   8: ldc 26
    //   10: iconst_2
    //   11: ldc 28
    //   13: invokestatic 32	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: new 34	android/os/Bundle
    //   19: dup
    //   20: invokespecial 35	android/os/Bundle:<init>	()V
    //   23: astore_1
    //   24: invokestatic 41	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   27: invokevirtual 45	com/tencent/mobileqq/qipc/QIPCClientHelper:getClient	()Leipc/EIPCClient;
    //   30: ldc 47
    //   32: ldc 49
    //   34: aload_1
    //   35: invokevirtual 55	eipc/EIPCClient:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Leipc/EIPCResult;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +26 -> 66
    //   43: aload_1
    //   44: invokevirtual 60	eipc/EIPCResult:isSuccess	()Z
    //   47: ifeq +19 -> 66
    //   50: aload_1
    //   51: getfield 64	eipc/EIPCResult:data	Landroid/os/Bundle;
    //   54: ifnull +12 -> 66
    //   57: aload_1
    //   58: getfield 64	eipc/EIPCResult:data	Landroid/os/Bundle;
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: areturn
    //   66: aconst_null
    //   67: astore_1
    //   68: goto -6 -> 62
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	CampusCircleIpcClient
    //   23	45	1	localObject1	Object
    //   71	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	71	finally
    //   16	39	71	finally
    //   43	62	71	finally
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleIpcClient", 2, "reportMedalRedPoint");
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("from", "web");
      QIPCClientHelper.getInstance().callServer("CampusCircleIpcServer_Model", "action_report_medal_red_point", localBundle, this);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 26
    //   10: iconst_2
    //   11: new 82	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   18: ldc 85
    //   20: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_1
    //   24: invokevirtual 92	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 32	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: lload_1
    //   34: lconst_0
    //   35: lcmp
    //   36: ifge +14 -> 50
    //   39: ldc 26
    //   41: iconst_1
    //   42: ldc 98
    //   44: invokestatic 32	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: new 34	android/os/Bundle
    //   53: dup
    //   54: invokespecial 35	android/os/Bundle:<init>	()V
    //   57: astore_3
    //   58: aload_3
    //   59: ldc 100
    //   61: lload_1
    //   62: invokevirtual 104	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   65: invokestatic 41	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   68: ldc 47
    //   70: ldc 106
    //   72: aload_3
    //   73: aload_0
    //   74: invokevirtual 79	com/tencent/mobileqq/qipc/QIPCClientHelper:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Leipc/EIPCResultCallback;)V
    //   77: goto -30 -> 47
    //   80: astore_3
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_3
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	CampusCircleIpcClient
    //   0	85	1	paramLong	long
    //   57	16	3	localBundle	Bundle
    //   80	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	33	80	finally
    //   39	47	80	finally
    //   50	77	80	finally
  }
  
  public void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleIpcClient", 2, "clearRedPoint_confess");
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("from", "web");
      localBundle.putString("tag", paramString);
      QIPCClientHelper.getInstance().getClient().callServer("CampusCircleIpcServer_Model", "action_confess_clear_red_point", localBundle, this);
      return;
    }
    finally {}
  }
  
  /* Error */
  public Bundle b()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +11 -> 18
    //   10: ldc 26
    //   12: iconst_2
    //   13: ldc 117
    //   15: invokestatic 32	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: new 34	android/os/Bundle
    //   21: dup
    //   22: invokespecial 35	android/os/Bundle:<init>	()V
    //   25: astore_3
    //   26: invokestatic 41	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   29: invokevirtual 45	com/tencent/mobileqq/qipc/QIPCClientHelper:getClient	()Leipc/EIPCClient;
    //   32: ldc 47
    //   34: ldc 119
    //   36: aload_3
    //   37: invokevirtual 55	eipc/EIPCClient:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Leipc/EIPCResult;
    //   40: astore_3
    //   41: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +64 -> 108
    //   47: new 82	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   54: ldc 121
    //   56: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: astore 4
    //   61: aload_3
    //   62: ifnull +73 -> 135
    //   65: iconst_1
    //   66: istore_1
    //   67: aload 4
    //   69: iload_1
    //   70: invokevirtual 124	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   73: ldc 126
    //   75: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: astore 4
    //   80: aload_3
    //   81: ifnull +59 -> 140
    //   84: aload_3
    //   85: invokevirtual 60	eipc/EIPCResult:isSuccess	()Z
    //   88: ifeq +52 -> 140
    //   91: iload_2
    //   92: istore_1
    //   93: ldc 26
    //   95: iconst_4
    //   96: aload 4
    //   98: iload_1
    //   99: invokevirtual 124	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   102: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 129	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aload_3
    //   109: ifnull +36 -> 145
    //   112: aload_3
    //   113: invokevirtual 60	eipc/EIPCResult:isSuccess	()Z
    //   116: ifeq +29 -> 145
    //   119: aload_3
    //   120: getfield 64	eipc/EIPCResult:data	Landroid/os/Bundle;
    //   123: ifnull +22 -> 145
    //   126: aload_3
    //   127: getfield 64	eipc/EIPCResult:data	Landroid/os/Bundle;
    //   130: astore_3
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_3
    //   134: areturn
    //   135: iconst_0
    //   136: istore_1
    //   137: goto -70 -> 67
    //   140: iconst_0
    //   141: istore_1
    //   142: goto -49 -> 93
    //   145: aconst_null
    //   146: astore_3
    //   147: goto -16 -> 131
    //   150: astore_3
    //   151: aload_0
    //   152: monitorexit
    //   153: aload_3
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	CampusCircleIpcClient
    //   66	76	1	bool1	boolean
    //   1	91	2	bool2	boolean
    //   25	122	3	localObject1	Object
    //   150	4	3	localObject2	Object
    //   59	38	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   4	18	150	finally
    //   18	61	150	finally
    //   67	80	150	finally
    //   84	91	150	finally
    //   93	108	150	finally
    //   112	131	150	finally
  }
  
  public void b()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleIpcClient", 2, "clearRedPoint_allPeopleVote");
      }
      QIPCClientHelper.getInstance().getClient().callServer("CampusCircleIpcServer_Model", "action_allpeoplevote_clearredpoint", new Bundle());
      return;
    }
    finally {}
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onCallback, result=").append(paramEIPCResult).append(", data=");
      if (paramEIPCResult != null) {
        break label50;
      }
    }
    label50:
    for (paramEIPCResult = "null";; paramEIPCResult = paramEIPCResult.data)
    {
      QLog.d("CampusCircleIpcClient", 2, paramEIPCResult);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCircleIpcClient
 * JD-Core Version:    0.7.0.1
 */