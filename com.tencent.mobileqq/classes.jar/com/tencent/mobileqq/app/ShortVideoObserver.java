package com.tencent.mobileqq.app;

public class ShortVideoObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Object[]))) {}
    for (paramObject = (Object[])paramObject;; paramObject = null)
    {
      switch (paramInt)
      {
      }
      do
      {
        return;
      } while (paramObject == null);
      a(paramBoolean, ((Integer)paramObject[0]).intValue());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ShortVideoObserver
 * JD-Core Version:    0.7.0.1
 */