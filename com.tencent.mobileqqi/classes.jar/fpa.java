import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

public class fpa
  implements Runnable
{
  public fpa(ProxyManager paramProxyManager) {}
  
  public void run()
  {
    ProxyManager.a(this.a, System.currentTimeMillis());
    while (!this.a.jdField_a_of_type_Boolean) {
      synchronized (this.a.jdField_a_of_type_JavaUtilVector)
      {
        try
        {
          this.a.jdField_a_of_type_JavaUtilVector.wait(10000L);
          if ((!this.a.jdField_a_of_type_JavaUtilVector.isEmpty()) && (ProxyManager.a(this.a))) {
            this.a.c();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.MsgProxy", 2, "writeRunable Exception:" + localException);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fpa
 * JD-Core Version:    0.7.0.1
 */