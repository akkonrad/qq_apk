package com.tencent.weiyun.transmission.utils.thread;

public abstract interface Future<T>
{
  public abstract void cancel();
  
  public abstract T get();
  
  public abstract boolean isCancelled();
  
  public abstract boolean isDone();
  
  public abstract void waitDone();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.transmission.utils.thread.Future
 * JD-Core Version:    0.7.0.1
 */