package com.tencent.mobileqq.app;

import java.util.List;
import tencent.im.nearfield_discuss.nearfield_discuss.BusiRespHead;

public class NearFieldDiscussObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void a(boolean paramBoolean, List paramList, int paramInt1, int paramInt2, nearfield_discuss.BusiRespHead paramBusiRespHead, int paramInt3, int paramInt4, long paramLong) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      a(paramBoolean, paramObject);
      return;
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        a(paramBoolean, (List)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), (nearfield_discuss.BusiRespHead)paramObject[3], ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), ((Long)paramObject[6]).longValue());
        return;
      }
      a(paramBoolean, null, -1, -1, null, -1, -1, -1L);
      return;
    } while (!paramBoolean);
    b(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearFieldDiscussObserver
 * JD-Core Version:    0.7.0.1
 */