import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.qphone.base.util.QLog;

public class rsh
  implements Runnable
{
  public rsh(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "checkPESourceDowned onShow First");
    }
    PokeItemHelper.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rsh
 * JD-Core Version:    0.7.0.1
 */