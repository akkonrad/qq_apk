package com.tencent.feedback.upload;

import android.content.Context;
import com.tencent.feedback.common.g;
import com.tencent.feedback.proguard.N;
import com.tencent.feedback.proguard.O;
import com.tencent.feedback.proguard.a;
import com.tencent.feedback.proguard.t;
import com.tencent.feedback.proguard.w;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class f
  implements e
{
  private static f a = null;
  private List<d> b = new ArrayList(2);
  private List<UploadHandleListener> c = new ArrayList(5);
  private c d;
  private Context e = null;
  private boolean f = true;
  private int g = 0;
  
  private f(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {}
    for (;;)
    {
      this.e = paramContext;
      this.f = paramBoolean;
      this.d = c.a(this.e);
      return;
      Context localContext = paramContext.getApplicationContext();
      if (localContext != null) {
        paramContext = localContext;
      }
    }
  }
  
  private int a()
  {
    try
    {
      int i = this.g;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private O a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        Object localObject = new com.tencent.feedback.proguard.d();
        ((com.tencent.feedback.proguard.d)localObject).e();
        ((com.tencent.feedback.proguard.d)localObject).a("utf-8");
        ((com.tencent.feedback.proguard.d)localObject).a(paramArrayOfByte);
        paramArrayOfByte = ((com.tencent.feedback.proguard.d)localObject).b("detail", new O());
        if (!O.class.isInstance(paramArrayOfByte)) {
          break label179;
        }
        com.tencent.feedback.common.e.b("rqdp{  covert to ResponsePackage}", new Object[0]);
        paramArrayOfByte = (O)O.class.cast(paramArrayOfByte);
        localObject = paramArrayOfByte;
        if (paramArrayOfByte != null)
        {
          localObject = paramArrayOfByte;
          if (paramArrayOfByte.c != null)
          {
            localObject = paramArrayOfByte;
            if (paramArrayOfByte.c.length > 0)
            {
              com.tencent.feedback.common.e.b("resp buf %d", new Object[] { Integer.valueOf(paramArrayOfByte.c.length) });
              paramArrayOfByte.c = a.b(paramArrayOfByte.c, 2, 1, t.a(this.e).b().e());
              localObject = paramArrayOfByte;
              if (paramArrayOfByte.c == null)
              {
                com.tencent.feedback.common.e.d("resp sbuffer error!", new Object[0]);
                localObject = null;
              }
            }
          }
        }
        return localObject;
      }
      catch (Throwable paramArrayOfByte)
      {
        if (!com.tencent.feedback.common.e.a(paramArrayOfByte)) {
          paramArrayOfByte.printStackTrace();
        }
      }
      return null;
      label179:
      paramArrayOfByte = null;
    }
  }
  
  public static f a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        a = new f(paramContext, true);
        com.tencent.feedback.common.e.b("rqdp{  create uphandler up:true}", new Object[0]);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static f a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      if (a == null)
      {
        a = new f(paramContext, paramBoolean);
        com.tencent.feedback.common.e.b("rqdp{  create uphandler up:}%b", new Object[] { Boolean.valueOf(paramBoolean) });
      }
      if (a.e() != paramBoolean)
      {
        a.a(paramBoolean);
        com.tencent.feedback.common.e.b("rqdp{  change uphandler up:}%b", new Object[] { Boolean.valueOf(paramBoolean) });
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a(int paramInt)
  {
    try
    {
      this.g = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    UploadHandleListener[] arrayOfUploadHandleListener = b();
    if (arrayOfUploadHandleListener != null)
    {
      int j = arrayOfUploadHandleListener.length;
      int i = 0;
      while (i < j)
      {
        arrayOfUploadHandleListener[i].onUploadEnd(paramInt1, paramInt2, paramLong1, paramLong2, paramBoolean, paramString);
        i += 1;
      }
    }
  }
  
  private static void a(List<d> paramList, int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramList == null) || (paramArrayOfByte == null)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        d locald = (d)paramList.next();
        if (locald != null) {
          try
          {
            com.tencent.feedback.common.e.b("rqdp{  key:}%d rqdp{  handler: }%s", new Object[] { Integer.valueOf(paramInt), locald.getClass().toString() });
            locald.a(paramInt, paramArrayOfByte, true);
          }
          catch (Throwable localThrowable)
          {
            if (!com.tencent.feedback.common.e.a(localThrowable)) {
              localThrowable.printStackTrace();
            }
            com.tencent.feedback.common.e.d("rqdp{  handle error key:}%d", new Object[] { Integer.valueOf(paramInt) });
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      this.f = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static byte[] b(AbstractUploadDatas paramAbstractUploadDatas)
  {
    if (paramAbstractUploadDatas != null) {
      try
      {
        paramAbstractUploadDatas = paramAbstractUploadDatas.a();
        if (paramAbstractUploadDatas != null)
        {
          com.tencent.feedback.common.e.b("rqdp{  [pid:}%s rqdp{  \nbid:}%s_%s rqdp{  \nsv:}%s \n]", new Object[] { paramAbstractUploadDatas.c, paramAbstractUploadDatas.c, paramAbstractUploadDatas.d, paramAbstractUploadDatas.f });
          com.tencent.feedback.proguard.d locald = new com.tencent.feedback.proguard.d();
          locald.e();
          locald.a("utf-8");
          locald.a(1);
          locald.c("RqdServer");
          locald.d("sync");
          locald.a("detail", paramAbstractUploadDatas);
          paramAbstractUploadDatas = locald.a();
          return paramAbstractUploadDatas;
        }
      }
      catch (Throwable paramAbstractUploadDatas)
      {
        if (!com.tencent.feedback.common.e.a(paramAbstractUploadDatas)) {
          paramAbstractUploadDatas.printStackTrace();
        }
        AbstractUploadDatas.d();
      }
    }
    return null;
  }
  
  /* Error */
  private UploadHandleListener[] b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/tencent/feedback/upload/f:c	Ljava/util/List;
    //   6: ifnull +36 -> 42
    //   9: aload_0
    //   10: getfield 39	com/tencent/feedback/upload/f:c	Ljava/util/List;
    //   13: invokeinterface 241 1 0
    //   18: ifle +24 -> 42
    //   21: aload_0
    //   22: getfield 39	com/tencent/feedback/upload/f:c	Ljava/util/List;
    //   25: iconst_0
    //   26: anewarray 166	com/tencent/feedback/upload/UploadHandleListener
    //   29: invokeinterface 245 2 0
    //   34: checkcast 247	[Lcom/tencent/feedback/upload/UploadHandleListener;
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: areturn
    //   42: aconst_null
    //   43: astore_1
    //   44: goto -6 -> 38
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	f
    //   37	7	1	arrayOfUploadHandleListener	UploadHandleListener[]
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	47	finally
  }
  
  private c c()
  {
    try
    {
      c localc = this.d;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private List<d> d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/tencent/feedback/upload/f:b	Ljava/util/List;
    //   6: ifnull +31 -> 37
    //   9: aload_0
    //   10: getfield 37	com/tencent/feedback/upload/f:b	Ljava/util/List;
    //   13: invokeinterface 241 1 0
    //   18: ifle +19 -> 37
    //   21: new 32	java/util/ArrayList
    //   24: dup
    //   25: aload_0
    //   26: getfield 37	com/tencent/feedback/upload/f:b	Ljava/util/List;
    //   29: invokespecial 252	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: aconst_null
    //   38: astore_1
    //   39: goto -6 -> 33
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	f
    //   32	7	1	localArrayList	ArrayList
    //   42	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	33	42	finally
  }
  
  private boolean e()
  {
    try
    {
      boolean bool = this.f;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(AbstractUploadDatas paramAbstractUploadDatas)
  {
    if (!e())
    {
      if (paramAbstractUploadDatas.b != 1111)
      {
        com.tencent.feedback.common.e.b("rqdp{   Not UpProc not req }%d", new Object[] { Integer.valueOf(paramAbstractUploadDatas.b()) });
        return;
      }
      com.tencent.feedback.common.e.b("rqdp{   NotUpProc com req start}", new Object[0]);
    }
    if (!g.b(this.e))
    {
      com.tencent.feedback.common.e.c("rqdp{  doUpload network is disabled!}", new Object[0]);
      return;
    }
    a(com.tencent.feedback.common.f.a(this.e));
    if (paramAbstractUploadDatas == null)
    {
      com.tencent.feedback.common.e.d("rqdp{  upData == null?}", new Object[0]);
      return;
    }
    int m = paramAbstractUploadDatas.b();
    long l4 = 0L;
    long l3 = 0L;
    boolean bool5 = false;
    boolean bool1 = false;
    boolean bool4 = false;
    int k = -1;
    Object localObject1 = b();
    int j;
    if (localObject1 != null)
    {
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject1[i].onUploadStart(m);
        i += 1;
      }
    }
    localObject1 = paramAbstractUploadDatas.c();
    if (localObject1 == null)
    {
      com.tencent.feedback.common.e.d("rqdp{  url error}", new Object[0]);
      a(m, -1, 0L, 0L, false, "url error");
      return;
    }
    com.tencent.feedback.common.e.b("rqdp{  start upload cmd:}%d rqdp{  url:}%s rqdp{  datas:}%s", new Object[] { Integer.valueOf(m), localObject1, paramAbstractUploadDatas.getClass().toString() });
    Object localObject4 = b(paramAbstractUploadDatas);
    if (localObject4 == null)
    {
      com.tencent.feedback.common.e.d("rqdp{  sData error}", new Object[0]);
      a(m, -1, 0L, 0L, false, "sData error");
      return;
    }
    Object localObject5 = c();
    if (localObject5 == null)
    {
      com.tencent.feedback.common.e.d("rqdp{  reqH error}", new Object[0]);
      a(m, -1, 0L, 0L, false, "reqH error");
      return;
    }
    Object localObject6 = com.tencent.feedback.common.c.a(this.e);
    HashMap localHashMap = new HashMap();
    localHashMap.put("pid", ((com.tencent.feedback.common.c)localObject6).b());
    localHashMap.put("bid", ((com.tencent.feedback.common.c)localObject6).b());
    localHashMap.put("pver", ((com.tencent.feedback.common.c)localObject6).B());
    int i = k;
    long l1 = l4;
    long l2 = l3;
    boolean bool2 = bool4;
    boolean bool3 = bool5;
    try
    {
      localObject6 = new b();
      i = k;
      l1 = l4;
      l2 = l3;
      bool2 = bool4;
      bool3 = bool5;
      localObject1 = ((c)localObject5).a((String)localObject1, (byte[])localObject4, (b)localObject6, localHashMap);
      if (localObject1 != null) {
        break label703;
      }
      i = k;
      l1 = l4;
      l2 = l3;
      bool2 = bool4;
      bool3 = bool5;
      a(a() + 1);
      i = k;
      l1 = l4;
      l2 = l3;
      bool2 = bool4;
      bool3 = bool5;
      l4 = ((b)localObject6).a();
      i = k;
      l1 = l4;
      l2 = l3;
      bool2 = bool4;
      bool3 = bool5;
      l3 = ((b)localObject6).b();
      i = k;
      l1 = l4;
      l2 = l3;
      bool2 = bool4;
      bool3 = bool5;
      localObject1 = a((byte[])localObject1);
      j = k;
      if (localObject1 == null) {
        break label1226;
      }
      i = k;
      l1 = l4;
      l2 = l3;
      bool2 = bool4;
      bool3 = bool5;
      j = ((O)localObject1).b;
      i = j;
      l1 = l4;
      l2 = l3;
      bool2 = bool4;
      bool3 = bool5;
      if (((O)localObject1).a != 0) {
        break label788;
      }
      bool1 = true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          if (!com.tencent.feedback.common.e.a(localThrowable)) {
            localThrowable.printStackTrace();
          }
          a(m, i, l1, l2, false, localThrowable.toString());
          com.tencent.feedback.common.e.d("rqdp{  req error} %s", new Object[] { localThrowable.toString() });
          return;
        }
        finally
        {
          bool3 = bool2;
          continue;
        }
        bool1 = false;
        continue;
        i = j;
        l1 = l4;
        l2 = l3;
        bool2 = bool1;
        bool3 = bool1;
        localObject4 = com.tencent.feedback.common.c.a(this.e);
        if (localObject4 != null)
        {
          i = j;
          l1 = l4;
          l2 = l3;
          bool2 = bool1;
          bool3 = bool1;
          ((com.tencent.feedback.common.c)localObject4).c(localThrowable.d);
          i = j;
          l1 = l4;
          l2 = l3;
          bool2 = bool1;
          bool3 = bool1;
          localObject5 = new Date();
          i = j;
          l1 = l4;
          l2 = l3;
          bool2 = bool1;
          bool3 = bool1;
          ((com.tencent.feedback.common.c)localObject4).a(localThrowable.e - ((Date)localObject5).getTime());
          i = j;
          l1 = l4;
          l2 = l3;
          bool2 = bool1;
          bool3 = bool1;
          com.tencent.feedback.common.e.a("rqdp{  fix ip:}%s rqdp{  tmgap:}%d", new Object[] { ((com.tencent.feedback.common.c)localObject4).i(), Long.valueOf(((com.tencent.feedback.common.c)localObject4).j()) });
        }
        i = j;
        l1 = l4;
        l2 = l3;
        bool2 = bool1;
        bool3 = bool1;
        localObject4 = localThrowable.c;
        if (localObject4 != null) {
          continue;
        }
        i = j;
        l1 = l4;
        l2 = l3;
        bool2 = bool1;
        bool3 = bool1;
        com.tencent.feedback.common.e.c("rqdp{  no response}", new Object[0]);
      }
    }
    finally
    {
      paramAbstractUploadDatas.done(bool3);
    }
    i = j;
    l1 = l4;
    l2 = l3;
    bool2 = bool1;
    bool3 = bool1;
    com.tencent.feedback.common.e.b("[req] request finish: result=%b requestCmd=%d, responseCmd=%d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(m), Integer.valueOf(j) });
    for (;;)
    {
      i = j;
      l1 = l4;
      l2 = l3;
      bool2 = bool1;
      bool3 = bool1;
      a(m, j, l4, l3, bool1, null);
      paramAbstractUploadDatas.done(bool1);
      return;
      label703:
      i = k;
      l1 = l4;
      l2 = l3;
      bool2 = bool4;
      bool3 = bool5;
      a(0);
      break;
      label788:
      label1226:
      do
      {
        i = j;
        l1 = l4;
        l2 = l3;
        bool2 = bool1;
        bool3 = bool1;
        localObject5 = d();
        if (localObject5 != null)
        {
          i = j;
          l1 = l4;
          l2 = l3;
          bool2 = bool1;
          bool3 = bool1;
          if (((List)localObject5).size() > 0) {}
        }
        else
        {
          i = j;
          l1 = l4;
          l2 = l3;
          bool2 = bool1;
          bool3 = bool1;
          com.tencent.feedback.common.e.b("rqdp{  no handler!}", new Object[0]);
          break;
        }
        i = j;
        l1 = l4;
        l2 = l3;
        bool2 = bool1;
        bool3 = bool1;
        k = localObject2.b;
        if (k == 0)
        {
          i = j;
          l1 = l4;
          l2 = l3;
          bool2 = bool1;
          bool3 = bool1;
          com.tencent.feedback.common.e.a("rqdp{  response no datas}", new Object[0]);
          break;
        }
        i = j;
        l1 = l4;
        l2 = l3;
        bool2 = bool1;
        bool3 = bool1;
        a((List)localObject5, k, (byte[])localObject4);
        break;
        if (paramAbstractUploadDatas == null) {
          break;
        }
      } while (localObject3 != null);
    }
  }
  
  public final boolean a(UploadHandleListener paramUploadHandleListener)
  {
    boolean bool;
    if (paramUploadHandleListener == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        if (!this.c.contains(paramUploadHandleListener)) {
          this.c.add(paramUploadHandleListener);
        }
        bool = true;
      }
      finally {}
    }
  }
  
  public final boolean a(d paramd)
  {
    boolean bool;
    if (paramd == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        if (!this.b.contains(paramd)) {
          this.b.add(paramd);
        }
        bool = true;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.upload.f
 * JD-Core Version:    0.7.0.1
 */