import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.richmedia.VideoSendTaskManager;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ahgs
  implements Runnable
{
  ahgs(ahgr paramahgr, UpCallBack.SendResult paramSendResult) {}
  
  public void run()
  {
    if ((TransferRequest)VideoSendTaskManager.a(this.jdField_a_of_type_Ahgr.a).get(ahgr.a(this.jdField_a_of_type_Ahgr)) != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPicUpCallBack$SendResult.a != 0) {
        break label85;
      }
      if (QLog.isColorLevel()) {
        QLog.i("PreUploadVideo", 2, "[onSend]ResultOk id=" + ahgr.a(this.jdField_a_of_type_Ahgr));
      }
      this.jdField_a_of_type_Ahgr.a(this.jdField_a_of_type_ComTencentMobileqqPicUpCallBack$SendResult);
    }
    label85:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("PreUploadVideo", 2, "[onSend]ResultFail id=" + ahgr.a(this.jdField_a_of_type_Ahgr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahgs
 * JD-Core Version:    0.7.0.1
 */