import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.CrashGuard;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.concurrent.atomic.AtomicBoolean;

public class amrf
  implements Runnable
{
  public amrf(CrashGuard paramCrashGuard, long paramLong) {}
  
  public void run()
  {
    this.jdField_a_of_type_CooperationQzoneCrashGuard.isTimeOvered.set(true);
    QLog.i("QZLog", 1, "clear crash count with no crash");
    LocalMultiProcConfig.putInt4Uin("key_crash_count", 0, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amrf
 * JD-Core Version:    0.7.0.1
 */