import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.transfile.TransProcessorHandler;

public class uli
  extends TransProcessorHandler
{
  public uli(FileTransferManager paramFileTransferManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uli
 * JD-Core Version:    0.7.0.1
 */