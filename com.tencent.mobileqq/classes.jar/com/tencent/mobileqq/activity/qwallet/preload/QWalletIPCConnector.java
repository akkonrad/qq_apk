package com.tencent.mobileqq.activity.qwallet.preload;

import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import xgd;
import xge;

public class QWalletIPCConnector
{
  private static volatile QWalletIPCConnector jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadQWalletIPCConnector;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public static QWalletIPCConnector a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadQWalletIPCConnector == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadQWalletIPCConnector == null) {
        jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadQWalletIPCConnector = new QWalletIPCConnector();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadQWalletIPCConnector;
    }
    finally {}
  }
  
  private void b()
  {
    this.b = true;
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCConnector", 2, "begin connect:");
    }
    QIPCClientHelper.getInstance().getClient().addListener(new xgd(this));
    long l = System.currentTimeMillis();
    QIPCClientHelper.getInstance().getClient().connect(new xge(this, l));
  }
  
  public void a()
  {
    if ((!this.jdField_a_of_type_Boolean) && (!this.b)) {
      b();
    }
    if (!this.jdField_a_of_type_Boolean) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (!bool) {}
        try
        {
          this.jdField_a_of_type_JavaLangObject.wait(500L);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCConnector
 * JD-Core Version:    0.7.0.1
 */