import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.app.ThreadRegulator.CpuBusyness;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class znx
  extends MqqHandler
{
  public znx(ThreadRegulator paramThreadRegulator, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (ThreadRegulator.CpuBusyness)paramMessage.obj;
    if (paramMessage != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThreadManager.Regulaotr", 2, paramMessage.jdField_a_of_type_Int + " cost " + (paramMessage.b - paramMessage.jdField_a_of_type_Long) + ", paused " + paramMessage.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
      }
      paramMessage.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     znx
 * JD-Core Version:    0.7.0.1
 */