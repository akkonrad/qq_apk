import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.activities.DevicePttItemBuilder;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.qphone.base.util.QLog;

public class qaw
  implements Runnable
{
  public qaw(DevicePttItemBuilder paramDevicePttItemBuilder, MessageForPtt paramMessageForPtt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTrans", 2, "downloadPtt istroop" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop + " itemType " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.itemType + " uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.uniseq);
    }
    DeviceAVFileMsgObserver localDeviceAVFileMsgObserver = ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.a.a(49)).a();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt instanceof MessageForDevPtt)) {
      localDeviceAVFileMsgObserver.a((MessageForDevPtt)this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qaw
 * JD-Core Version:    0.7.0.1
 */