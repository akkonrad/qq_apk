import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberListAdapter;

public class dys
  implements Runnable
{
  public dys(TroopTransferActivity paramTroopTransferActivity) {}
  
  public void run()
  {
    try
    {
      if (this.a.a != null) {
        this.a.a.notifyDataSetChanged();
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dys
 * JD-Core Version:    0.7.0.1
 */