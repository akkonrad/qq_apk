import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FMRecentFileActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.RecentFileAdapter.ItemHolder;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class fvx
  implements View.OnClickListener
{
  public fvx(FMRecentFileActivity paramFMRecentFileActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (RecentFileAdapter.ItemHolder)paramView.getTag();
    fvy localfvy = new fvy(this, paramView);
    fvz localfvz = new fvz(this);
    if ((paramView.a.nOpType == 1) || (paramView.a.nOpType == 5) || (paramView.a.nOpType == 8))
    {
      DialogUtil.a(this.a.a(), 230, this.a.getString(2131558690), this.a.getString(2131558688), 2131561746, 2131562539, localfvy, localfvz).show();
      return;
    }
    DialogUtil.a(this.a.a(), 230, this.a.getString(2131558689), this.a.getString(2131558687), 2131561746, 2131562539, localfvy, localfvz).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fvx
 * JD-Core Version:    0.7.0.1
 */