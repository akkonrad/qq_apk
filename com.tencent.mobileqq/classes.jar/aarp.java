import android.view.View;
import com.tencent.mobileqq.ark.ArkAiAppPanel;
import com.tencent.widget.HorizontalListView;

public class aarp
  implements Runnable
{
  public aarp(ArkAiAppPanel paramArkAiAppPanel) {}
  
  public void run()
  {
    View localView = ArkAiAppPanel.a(this.a).getSelectedView();
    if (localView != null) {
      localView.setSelected(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aarp
 * JD-Core Version:    0.7.0.1
 */