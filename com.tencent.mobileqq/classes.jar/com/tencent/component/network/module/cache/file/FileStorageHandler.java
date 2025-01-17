package com.tencent.component.network.module.cache.file;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import java.util.concurrent.atomic.AtomicInteger;
import pkh;

public class FileStorageHandler
  implements FileCacheService.StorageHandler
{
  private static final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final FileStorageHandler.Collector jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileStorageHandler$Collector;
  private Future jdField_a_of_type_ComTencentComponentNetworkUtilsThreadFuture;
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  public FileStorageHandler(FileStorageHandler.Collector paramCollector)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileStorageHandler$Collector = paramCollector;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {
      return paramInt1;
    }
    if (paramInt2 / paramInt1 < 0.12F) {}
    for (float f = 0.05F;; f = 0.1F) {
      return (int)(f * paramInt1);
    }
  }
  
  private void a(Context paramContext)
  {
    if (paramContext == null) {}
    while (a()) {
      return;
    }
  }
  
  private boolean a()
  {
    long l1 = ((1.0F - 1.0F / (this.jdField_a_of_type_Int / 6.0F + 1.0F)) * 1800000.0F);
    long l2 = System.currentTimeMillis();
    if (l2 - this.jdField_a_of_type_Long >= l1) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (this.jdField_a_of_type_Int < 2147483647) {
          this.jdField_a_of_type_Int += 1;
        }
        this.jdField_a_of_type_Long = l2;
      }
      return bool;
    }
  }
  
  public void a(FileCacheService paramFileCacheService, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() < 2) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    QDLog.c("downloader", "low storage: totalSize=" + paramLong1 + ", availableSize=" + paramLong2 + ", external=" + paramBoolean);
    try
    {
      if ((this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadFuture != null) && (!this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadFuture.isDone())) {
        return;
      }
    }
    finally {}
    paramFileCacheService = paramFileCacheService.a();
    this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadFuture = PriorityThreadPool.getDefault().submit(new pkh(this, paramBoolean, paramFileCacheService));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.cache.file.FileStorageHandler
 * JD-Core Version:    0.7.0.1
 */