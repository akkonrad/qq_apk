import com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class gry
  extends TimerTask
{
  public gry(OldHttpEngine.OldHttpCommunicatorListner paramOldHttpCommunicatorListner) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.a(9004, -1, "nonetwork");
    this.a.b(this.a.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg, this.a.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gry
 * JD-Core Version:    0.7.0.1
 */