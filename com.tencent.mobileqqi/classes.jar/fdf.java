import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.adapter.TroopListAdapter2.OnTroopListClickListener;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListItem;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListViewItemTag;

public class fdf
  implements View.OnClickListener
{
  public fdf(TroopListAdapter2 paramTroopListAdapter2) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if (!(paramView instanceof TroopListAdapter2.TroopListViewItemTag)) {}
    do
    {
      return;
      paramView = (TroopListAdapter2.TroopListViewItemTag)paramView;
    } while ((paramView.a == null) || (paramView.a.a == null));
    this.a.a.a(paramView.a.a, paramView.a.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fdf
 * JD-Core Version:    0.7.0.1
 */