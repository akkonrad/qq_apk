import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ajud
  implements Runnable
{
  private final WeakReference a;
  
  public ajud(TroopMoreDetailView paramTroopMoreDetailView)
  {
    this.a = new WeakReference(paramTroopMoreDetailView);
  }
  
  public void run()
  {
    TroopMoreDetailView localTroopMoreDetailView = (TroopMoreDetailView)this.a.get();
    if (localTroopMoreDetailView == null) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
      } while (localTroopMoreDetailView.getContext() == null);
      localArrayList = TroopInfoActivity.a(localTroopMoreDetailView.getContext(), localTroopMoreDetailView.a);
    } while (localArrayList == null);
    ThreadManager.getUIHandler().post(new ajue(this, localTroopMoreDetailView, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajud
 * JD-Core Version:    0.7.0.1
 */