import android.os.Bundle;
import com.tencent.mobileqq.compatible.ActionListener;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class ahxc
  implements Runnable
{
  public ahxc(MobileQQServiceBase paramMobileQQServiceBase, ToServiceMsg paramToServiceMsg, ActionListener paramActionListener, Class paramClass) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg == null) {}
    for (Object localObject = "";; localObject = this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getServiceCmd())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MobileQQServiceBase", 2, "req cmd: " + (String)localObject);
      }
      if ((this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg != null) && ("MessageSvc.PbSendMsg".equalsIgnoreCase((String)localObject)))
      {
        long l1 = this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData.getLong("msg_send_time", 0L);
        if (l1 != 0L)
        {
          long l2 = System.currentTimeMillis();
          this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData.putLong("msg_request_time", l2);
          this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData.putLong("msg_send_to_request_cost", l2 - l1);
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqServiceMobileQQServiceBase.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_ComTencentMobileqqCompatibleActionListener, this.jdField_a_of_type_JavaLangClass);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("MobileQQServiceBase", 2, "handleRequest Exception. cmd = " + (String)localObject, localException);
        localObject = new FromServiceMsg(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getUin(), (String)localObject);
        ((FromServiceMsg)localObject).setMsgFail();
        this.jdField_a_of_type_ComTencentMobileqqServiceMobileQQServiceBase.a(false, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, (FromServiceMsg)localObject, localException);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (!QLog.isColorLevel()) {
          break label259;
        }
        QLog.d("MobileQQServiceBase", 2, "handleRequest OutOfMemoryError. cmd = " + (String)localObject);
        localObject = new FromServiceMsg(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getUin(), (String)localObject);
        ((FromServiceMsg)localObject).setMsgFail();
        this.jdField_a_of_type_ComTencentMobileqqServiceMobileQQServiceBase.a(false, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, (FromServiceMsg)localObject, null);
      }
    }
    label259:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ahxc
 * JD-Core Version:    0.7.0.1
 */