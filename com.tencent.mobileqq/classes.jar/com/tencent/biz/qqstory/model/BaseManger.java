package com.tencent.biz.qqstory.model;

import java.util.concurrent.atomic.AtomicBoolean;

public class BaseManger
  implements IManager
{
  public AtomicBoolean c = new AtomicBoolean(false);
  
  public void a() {}
  
  public void b()
  {
    this.c.set(true);
  }
  
  public boolean b()
  {
    return this.c.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.BaseManger
 * JD-Core Version:    0.7.0.1
 */