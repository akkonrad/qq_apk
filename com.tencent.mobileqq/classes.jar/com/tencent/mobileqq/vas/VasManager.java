package com.tencent.mobileqq.vas;

import akhz;
import akia;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.Manager;

public class VasManager
  implements Manager
{
  private final ArrayList a = new ArrayList();
  
  public static VasManager.CompleteListener a(VasManager.CompleteListener paramCompleteListener)
  {
    return new akia(paramCompleteListener);
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramString == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      synchronized (this.a)
      {
        i = this.a.size() - 1;
        if (i >= 0)
        {
          akhz localakhz = (akhz)this.a.get(i);
          if (paramString.equals(localakhz.jdField_a_of_type_JavaLangString))
          {
            this.a.remove(i);
            localArrayList.add(localakhz);
          }
        }
        else
        {
          paramString = localArrayList.iterator();
          if (!paramString.hasNext()) {
            break;
          }
          ??? = (akhz)paramString.next();
          ((akhz)???).jdField_a_of_type_ComTencentMobileqqVasVasManager$CompleteListener.a(paramObject, ((akhz)???).jdField_a_of_type_JavaLangObject);
        }
      }
      i -= 1;
    }
  }
  
  public void b(String arg1, VasManager.CompleteListener paramCompleteListener, Object paramObject)
  {
    if (paramCompleteListener != null)
    {
      paramCompleteListener = new akhz(paramCompleteListener, paramObject, ???);
      synchronized (this.a)
      {
        this.a.add(paramCompleteListener);
        return;
      }
    }
  }
  
  public void onDestroy()
  {
    synchronized (this.a)
    {
      this.a.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasManager
 * JD-Core Version:    0.7.0.1
 */