package com.tencent.mobileqq.app;

import java.util.ArrayList;
import java.util.HashMap;

public class GlobalSearchObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1)
    {
      paramObject = (HashMap)paramObject;
      a(paramBoolean, (ArrayList)paramObject.get("mq_kandian_svc_results"), (ArrayList)paramObject.get("mq_kandian_svc_sentences"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.GlobalSearchObserver
 * JD-Core Version:    0.7.0.1
 */