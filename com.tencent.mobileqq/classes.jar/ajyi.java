import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugReporter;
import com.tencent.pb.unifiedebug.RemoteDebugReportMsg.RemoteLogRsp;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class ajyi
  implements BusinessObserver
{
  public ajyi(UnifiedDebugReporter paramUnifiedDebugReporter) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("extra_data");
      if (paramBundle == null) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        RemoteDebugReportMsg.RemoteLogRsp localRemoteLogRsp = new RemoteDebugReportMsg.RemoteLogRsp();
        localRemoteLogRsp.mergeFrom(paramBundle);
        if (localRemoteLogRsp.i32_ret.has())
        {
          paramInt = localRemoteLogRsp.i32_ret.get();
          if (QLog.isColorLevel()) {
            QLog.d("UnifiedDebugReporter", 2, "onReceive: retCode=" + paramInt);
          }
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("UnifiedDebugReporter", 2, "onReceive: exception=" + paramBundle.getMessage());
        return;
      }
    }
    QLog.e("UnifiedDebugReporter", 2, "onReceive: isSuccess=" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyi
 * JD-Core Version:    0.7.0.1
 */