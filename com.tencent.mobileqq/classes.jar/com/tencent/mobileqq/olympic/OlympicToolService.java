package com.tencent.mobileqq.olympic;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class OlympicToolService
  extends MobileQQServiceBase
{
  OlympicToolAppInterface jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface;
  Random jdField_a_of_type_JavaUtilRandom = new Random();
  
  OlympicToolService(OlympicToolAppInterface paramOlympicToolAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OlympicToolService", 2, "new OlympicToolService");
    }
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface = paramOlympicToolAppInterface;
    jdField_a_of_type_Int = Math.abs(this.jdField_a_of_type_JavaUtilRandom.nextInt());
  }
  
  public AppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface;
  }
  
  protected void a()
  {
    try
    {
      super.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    super.b(paramToServiceMsg, null, OlympicToolServlet.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicToolService
 * JD-Core Version:    0.7.0.1
 */