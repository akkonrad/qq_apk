import android.view.View;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class dwm
  implements ActionSheet.OnButtonClickListener
{
  dwm(dwl paramdwl) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    TroopMemberListActivity.a(this.a.a);
    this.a.a.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dwm
 * JD-Core Version:    0.7.0.1
 */