package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.app.ThreadManager;

public class ManageThread
  extends Step
{
  protected boolean a()
  {
    ThreadManager.init();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.ManageThread
 * JD-Core Version:    0.7.0.1
 */