import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.ArrayList;

public class anp
  extends TroopObserver
{
  public anp(ForwardRecentActivity paramForwardRecentActivity) {}
  
  protected void a(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      ForwardRecentActivity.b(this.a);
    }
  }
  
  protected void a(boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramArrayList != null) && (paramArrayList.size() > 0) && (paramBoolean2)) {
      ForwardRecentActivity.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     anp
 * JD-Core Version:    0.7.0.1
 */