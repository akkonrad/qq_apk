import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity;
import java.util.HashSet;

public class bjj
  implements View.OnClickListener
{
  public bjj(SetTroopAdminsActivity paramSetTroopAdminsActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_JavaUtilHashSet.clear();
    paramView = this.a;
    boolean bool;
    if (!this.a.jdField_a_of_type_Boolean)
    {
      bool = true;
      paramView.jdField_a_of_type_Boolean = bool;
      if (!this.a.jdField_a_of_type_Boolean) {
        break label91;
      }
      SetTroopAdminsActivity.a(this.a).setText(2131363444);
      SetTroopAdminsActivity.a(this.a).setEnabled(false);
    }
    for (;;)
    {
      if (SetTroopAdminsActivity.a(this.a) != null) {
        SetTroopAdminsActivity.a(this.a).notifyDataSetChanged();
      }
      return;
      bool = false;
      break;
      label91:
      SetTroopAdminsActivity.b(this.a).setText(2131363447);
      SetTroopAdminsActivity.a(this.a).setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bjj
 * JD-Core Version:    0.7.0.1
 */