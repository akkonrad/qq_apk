import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

public class yio
  implements Runnable
{
  public yio(TroopListAdapter2 paramTroopListAdapter2) {}
  
  public void run()
  {
    List localList = TroopListAdapter2.a(this.a);
    ThreadManager.getUIHandler().post(new yip(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yio
 * JD-Core Version:    0.7.0.1
 */