import android.text.TextUtils;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.activities.DevLittleVideoItemBuilder;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class qal
  implements Runnable
{
  public qal(DevLittleVideoItemBuilder paramDevLittleVideoItemBuilder, MessageForDevLittleVideo paramMessageForDevLittleVideo) {}
  
  public void run()
  {
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder.a.a(51);
    DeviceMsgHandle localDeviceMsgHandle = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder.a.a(49);
    for (;;)
    {
      synchronized (localDeviceMsgHandle.b)
      {
        Iterator localIterator = localDeviceMsgHandle.b.entrySet().iterator();
        if (localIterator.hasNext())
        {
          if (((MessageRecord)((Map.Entry)localIterator.next()).getValue()).uniseq != this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.uniseq) {
            continue;
          }
          i = 1;
          if ((i == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.videoFileKey)))
          {
            long l = localSmartDeviceProxyMgr.a(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.videoFileKey, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.fileKey2, 2201);
            localDeviceMsgHandle.b.put(Long.valueOf(l), this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo);
          }
          return;
        }
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qal
 * JD-Core Version:    0.7.0.1
 */