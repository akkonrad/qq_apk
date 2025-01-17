package com.tencent.qqprotect.qsec;

import java.util.HashMap;
import mqq.app.MobileQQ;

public class QSecRuntimeImpl
  implements IQSecRuntime
{
  public static IQSecRuntime a;
  private HashMap a;
  
  public QSecRuntimeImpl()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_ComTencentQqprotectQsecIQSecRuntime = this;
  }
  
  public void a(IRuntimeInterface paramIRuntimeInterface)
  {
    String str = paramIRuntimeInterface.getInterfaceName();
    if ((str != null) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))) {
      this.jdField_a_of_type_JavaUtilHashMap.put(str, paramIRuntimeInterface);
    }
  }
  
  public Object getApplicationContext()
  {
    return MobileQQ.sMobileQQ;
  }
  
  public Object getQQAppInterface()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public int getRuntimeVersion()
  {
    return 1;
  }
  
  public IRuntimeInterface queryRuntimeInterface(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    IRuntimeInterface localIRuntimeInterface2 = (IRuntimeInterface)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    IRuntimeInterface localIRuntimeInterface1 = localIRuntimeInterface2;
    if (localIRuntimeInterface2 != null)
    {
      localIRuntimeInterface1 = localIRuntimeInterface2;
      if (!paramString.equals(localIRuntimeInterface2.getInterfaceName())) {
        localIRuntimeInterface1 = null;
      }
    }
    return localIRuntimeInterface1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecRuntimeImpl
 * JD-Core Version:    0.7.0.1
 */