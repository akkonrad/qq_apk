package com.tencent.qqprotect.qsec;

import alyc;
import com.tencent.qqprotect.common.QSecRptController;

public class RptImpl
  implements IRpt, IRuntimeInterface
{
  private static volatile RptImpl a;
  
  private RptImpl()
  {
    QSecFramework.a(3, new alyc(this));
  }
  
  public static RptImpl a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new RptImpl();
      }
      return a;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 1) {
      QSecRptController.a(paramString, paramInt2);
    }
    while (paramInt1 != 2) {
      return;
    }
    QSecRptController.b(paramString, paramInt2);
  }
  
  public String getInterfaceName()
  {
    return "Rpt";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.RptImpl
 * JD-Core Version:    0.7.0.1
 */