import android.bluetooth.BluetoothDevice;
import com.tencent.device.qfind.BlePeerInfo;
import com.tencent.device.qfind.QFindBLEScanMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

class qcq
  implements Runnable
{
  qcq(qcp paramqcp, BluetoothDevice paramBluetoothDevice, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    BlePeerInfo localBlePeerInfo = new BlePeerInfo();
    localBlePeerInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getName();
    localBlePeerInfo.b = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getAddress();
    localBlePeerInfo.jdField_a_of_type_Boolean = false;
    BlePeerInfo.a(this.jdField_a_of_type_ArrayOfByte, localBlePeerInfo);
    if ((localBlePeerInfo.jdField_a_of_type_JavaUtilList != null) && (localBlePeerInfo.jdField_a_of_type_JavaUtilList.contains("0000feba-0000-1000-8000-00805f9b34fb")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE_ex", 2, "onLeScan name=" + localBlePeerInfo.jdField_a_of_type_JavaLangString + " pid:" + localBlePeerInfo.jdField_a_of_type_Int + " address:" + localBlePeerInfo.b + " ; blePeerInfo.ble_id = " + localBlePeerInfo.c);
      }
      if ((localBlePeerInfo.jdField_a_of_type_Int == 0) || (localBlePeerInfo.jdField_a_of_type_ArrayOfByte == null) || (!this.jdField_a_of_type_Qcp.a.b.contains(new Long(localBlePeerInfo.jdField_a_of_type_Int)))) {}
    }
    for (;;)
    {
      try
      {
        QFindBLEScanMgr.b(this.jdField_a_of_type_Qcp.a);
        boolean bool1 = QFindBLEScanMgr.a(this.jdField_a_of_type_Qcp.a, localBlePeerInfo);
        bool2 = QFindBLEScanMgr.a(this.jdField_a_of_type_Qcp.a, localBlePeerInfo, bool1);
        if (QLog.isColorLevel()) {
          QLog.i("QFindBLE_ex", 2, "onLeScan blePeerInfo.ble_id = " + localBlePeerInfo.c + " ; needReportLoc = " + bool1 + " ; needReport = " + bool2);
        }
        if ((!bool2) || (!bool1)) {
          continue;
        }
        QFindBLEScanMgr.a(this.jdField_a_of_type_Qcp.a, localBlePeerInfo.jdField_a_of_type_Int, localBlePeerInfo.a());
      }
      catch (Exception localException)
      {
        boolean bool2;
        continue;
      }
      this.jdField_a_of_type_Qcp.a.a.postDelayed(new qcr(this), this.jdField_a_of_type_Qcp.a.i);
      return;
      if (bool2) {
        QFindBLEScanMgr.a(this.jdField_a_of_type_Qcp.a, localBlePeerInfo, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qcq
 * JD-Core Version:    0.7.0.1
 */