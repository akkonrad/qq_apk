import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class tkc
  implements View.OnClickListener
{
  public tkc(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a == null)
    {
      this.a.a = ((ActionSheet)ActionSheetHelper.a(this.a, null));
      this.a.a.b(2131431690);
      this.a.a.b(2131431563);
      this.a.a.c(2131433015);
      this.a.a.a(new tkd(this));
    }
    if (!this.a.a.isShowing()) {
      this.a.a.show();
    }
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_menu", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tkc
 * JD-Core Version:    0.7.0.1
 */