import android.os.Looper;
import android.os.Message;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.mobileqq.transfile.TransProcessorHandler;

public class pxo
  extends TransProcessorHandler
{
  public pxo(DeviceAVFileMsgObserver paramDeviceAVFileMsgObserver, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pxo
 * JD-Core Version:    0.7.0.1
 */