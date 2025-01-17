package com.tencent.biz.qqstory.network;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class BatchHandlerListPuller
{
  protected BatchHandlerListPuller.IPullResultCallback a;
  protected String a;
  protected List a;
  protected AtomicBoolean a;
  protected boolean a;
  protected List b;
  protected AtomicBoolean b;
  protected List c = new ArrayList();
  protected List d = new ArrayList();
  
  public BatchHandlerListPuller(List paramList)
  {
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.net:BatchHandlerListPuller";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((BatchNetHandler)localIterator.next()).a(this);
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList);
  }
  
  public static BatchHandlerListPuller a(ArrayList paramArrayList)
  {
    ArrayList localArrayList1 = new ArrayList();
    int j;
    for (int i = 0;; i = j)
    {
      if (i < paramArrayList.size())
      {
        j = Math.min(paramArrayList.size(), i + 20);
        if (i < j) {}
      }
      else
      {
        return new BatchHandlerListPuller(localArrayList1);
      }
      List localList = paramArrayList.subList(i, j);
      ArrayList localArrayList2 = new ArrayList();
      i = 0;
      while (i < localList.size())
      {
        localArrayList2.add(new QQUserUIItem.UserID("", (String)localList.get(i)));
        i += 1;
      }
      localArrayList1.add(new GetUserInfoHandler(1, localArrayList2));
    }
  }
  
  public static BatchHandlerListPuller a(@NonNull List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!StoryVideoItem.isFakeVid(str))
      {
        StoryVideoItem localStoryVideoItem = localStoryManager.a(str);
        if ((localStoryVideoItem == null) || (localStoryVideoItem.mBasicInfoState != 1) || (localStoryVideoItem.mVideoIndex == 0L)) {
          localArrayList.add(str);
        }
      }
    }
    paramList = new ArrayList();
    int j;
    for (int i = 0;; i = j)
    {
      if (i < localArrayList.size())
      {
        j = Math.min(localArrayList.size(), i + 20);
        if (i < j) {}
      }
      else
      {
        return new BatchHandlerListPuller(paramList);
      }
      paramList.add(new VidToBasicInfoHandler(localArrayList.subList(i, j)));
    }
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller$IPullResultCallback = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(BatchHandlerListPuller.IPullResultCallback paramIPullResultCallback)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller$IPullResultCallback = paramIPullResultCallback;
  }
  
  /* Error */
  public void a(BatchNetHandler paramBatchNetHandler)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/tencent/biz/qqstory/network/BatchHandlerListPuller:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   6: aload_1
    //   7: invokeinterface 151 2 0
    //   12: pop
    //   13: aload_0
    //   14: getfield 31	com/tencent/biz/qqstory/network/BatchHandlerListPuller:c	Ljava/util/List;
    //   17: aload_1
    //   18: invokeinterface 113 2 0
    //   23: pop
    //   24: aload_0
    //   25: getfield 42	com/tencent/biz/qqstory/network/BatchHandlerListPuller:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   28: astore_1
    //   29: aload_0
    //   30: getfield 29	com/tencent/biz/qqstory/network/BatchHandlerListPuller:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   33: invokeinterface 48 1 0
    //   38: ifne +105 -> 143
    //   41: aload_0
    //   42: getfield 33	com/tencent/biz/qqstory/network/BatchHandlerListPuller:d	Ljava/util/List;
    //   45: invokeinterface 48 1 0
    //   50: ifne +93 -> 143
    //   53: iconst_1
    //   54: istore_2
    //   55: aload_1
    //   56: iload_2
    //   57: invokevirtual 53	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   60: aload_0
    //   61: getfield 29	com/tencent/biz/qqstory/network/BatchHandlerListPuller:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   64: invokeinterface 48 1 0
    //   69: ifne +71 -> 140
    //   72: aload_0
    //   73: getfield 146	com/tencent/biz/qqstory/network/BatchHandlerListPuller:jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller$IPullResultCallback	Lcom/tencent/biz/qqstory/network/BatchHandlerListPuller$IPullResultCallback;
    //   76: ifnull +19 -> 95
    //   79: aload_0
    //   80: getfield 146	com/tencent/biz/qqstory/network/BatchHandlerListPuller:jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller$IPullResultCallback	Lcom/tencent/biz/qqstory/network/BatchHandlerListPuller$IPullResultCallback;
    //   83: aload_0
    //   84: getfield 42	com/tencent/biz/qqstory/network/BatchHandlerListPuller:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   87: invokevirtual 153	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   90: invokeinterface 157 2 0
    //   95: aload_0
    //   96: getfield 22	com/tencent/biz/qqstory/network/BatchHandlerListPuller:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   99: astore_3
    //   100: new 159	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   107: ldc 162
    //   109: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: astore 4
    //   114: aload_0
    //   115: getfield 42	com/tencent/biz/qqstory/network/BatchHandlerListPuller:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   118: invokevirtual 153	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   121: ifeq +27 -> 148
    //   124: ldc 168
    //   126: astore_1
    //   127: aload_3
    //   128: aload 4
    //   130: aload_1
    //   131: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 176	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload_0
    //   141: monitorexit
    //   142: return
    //   143: iconst_0
    //   144: istore_2
    //   145: goto -90 -> 55
    //   148: new 159	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   155: aload_0
    //   156: getfield 33	com/tencent/biz/qqstory/network/BatchHandlerListPuller:d	Ljava/util/List;
    //   159: invokeinterface 48 1 0
    //   164: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: ldc 181
    //   169: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: astore_1
    //   176: goto -49 -> 127
    //   179: astore_1
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_1
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	BatchHandlerListPuller
    //   0	184	1	paramBatchNetHandler	BatchNetHandler
    //   54	91	2	bool	boolean
    //   99	29	3	str	String
    //   112	17	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	53	179	finally
    //   55	95	179	finally
    //   95	124	179	finally
    //   127	140	179	finally
    //   148	176	179	finally
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = (paramString + ":BatchHandlerListPuller");
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/tencent/biz/qqstory/network/BatchHandlerListPuller:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   6: invokeinterface 48 1 0
    //   11: istore_1
    //   12: iload_1
    //   13: ifle +9 -> 22
    //   16: iconst_1
    //   17: istore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_2
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_2
    //   24: goto -6 -> 18
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	BatchHandlerListPuller
    //   11	2	1	i	int
    //   17	7	2	bool	boolean
    //   27	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	27	finally
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
        if (bool) {
          return;
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        if (this.jdField_a_of_type_Boolean)
        {
          SLog.d(this.jdField_a_of_type_JavaLangString, "Task list is empty , return result now");
          if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller$IPullResultCallback == null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller$IPullResultCallback.a(this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
          continue;
        }
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      }
      finally {}
      Iterator localIterator;
      int i = 0;
      while (localIterator.hasNext())
      {
        BatchNetHandler localBatchNetHandler = (BatchNetHandler)localIterator.next();
        this.jdField_b_of_type_JavaUtilList.add(localBatchNetHandler);
        localBatchNetHandler.a();
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      SLog.d(this.jdField_a_of_type_JavaLangString, "Run! Request count = %d", new Object[] { Integer.valueOf(i) });
    }
  }
  
  /* Error */
  public void b(BatchNetHandler paramBatchNetHandler)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 40	com/tencent/biz/qqstory/network/BatchHandlerListPuller:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   8: invokevirtual 153	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   11: ifeq +8 -> 19
    //   14: aload_1
    //   15: invokevirtual 204	com/tencent/biz/qqstory/network/BatchNetHandler:a	()Z
    //   18: istore_2
    //   19: iload_2
    //   20: ifne +135 -> 155
    //   23: aload_0
    //   24: getfield 29	com/tencent/biz/qqstory/network/BatchHandlerListPuller:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   27: aload_1
    //   28: invokeinterface 151 2 0
    //   33: pop
    //   34: aload_0
    //   35: getfield 33	com/tencent/biz/qqstory/network/BatchHandlerListPuller:d	Ljava/util/List;
    //   38: aload_1
    //   39: invokeinterface 113 2 0
    //   44: pop
    //   45: aload_0
    //   46: getfield 42	com/tencent/biz/qqstory/network/BatchHandlerListPuller:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   49: iconst_0
    //   50: invokevirtual 53	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   53: aload_0
    //   54: getfield 29	com/tencent/biz/qqstory/network/BatchHandlerListPuller:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   57: invokeinterface 48 1 0
    //   62: ifne +73 -> 135
    //   65: aload_0
    //   66: getfield 146	com/tencent/biz/qqstory/network/BatchHandlerListPuller:jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller$IPullResultCallback	Lcom/tencent/biz/qqstory/network/BatchHandlerListPuller$IPullResultCallback;
    //   69: ifnull +19 -> 88
    //   72: aload_0
    //   73: getfield 146	com/tencent/biz/qqstory/network/BatchHandlerListPuller:jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller$IPullResultCallback	Lcom/tencent/biz/qqstory/network/BatchHandlerListPuller$IPullResultCallback;
    //   76: aload_0
    //   77: getfield 42	com/tencent/biz/qqstory/network/BatchHandlerListPuller:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   80: invokevirtual 153	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   83: invokeinterface 157 2 0
    //   88: aload_0
    //   89: getfield 22	com/tencent/biz/qqstory/network/BatchHandlerListPuller:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   92: astore 4
    //   94: new 159	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   101: ldc 162
    //   103: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: astore 5
    //   108: aload_0
    //   109: getfield 42	com/tencent/biz/qqstory/network/BatchHandlerListPuller:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   112: invokevirtual 153	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   115: ifeq +43 -> 158
    //   118: ldc 168
    //   120: astore_3
    //   121: aload 4
    //   123: aload 5
    //   125: aload_3
    //   126: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 176	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_0
    //   136: getfield 22	com/tencent/biz/qqstory/network/BatchHandlerListPuller:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   139: ldc 206
    //   141: iconst_1
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_1
    //   148: aastore
    //   149: invokestatic 210	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   152: invokestatic 176	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_0
    //   156: monitorexit
    //   157: return
    //   158: new 159	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   165: aload_0
    //   166: getfield 33	com/tencent/biz/qqstory/network/BatchHandlerListPuller:d	Ljava/util/List;
    //   169: invokeinterface 48 1 0
    //   174: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   177: ldc 181
    //   179: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: astore_3
    //   186: goto -65 -> 121
    //   189: astore_1
    //   190: aload_0
    //   191: monitorexit
    //   192: aload_1
    //   193: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	BatchHandlerListPuller
    //   0	194	1	paramBatchNetHandler	BatchNetHandler
    //   1	19	2	bool	boolean
    //   120	66	3	str1	String
    //   92	30	4	str2	String
    //   106	18	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   4	19	189	finally
    //   23	88	189	finally
    //   88	118	189	finally
    //   121	135	189	finally
    //   135	155	189	finally
    //   158	186	189	finally
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.BatchHandlerListPuller
 * JD-Core Version:    0.7.0.1
 */