import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberListAdapter;

public class ueo
  implements Runnable
{
  public ueo(TroopTransferActivity paramTroopTransferActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ueo
 * JD-Core Version:    0.7.0.1
 */