import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.widget.ActionSheet;

public class vsh
  implements View.OnClickListener
{
  public vsh(DiscussChatPie paramDiscussChatPie, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((DiscussChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie) != null) && (DiscussChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie).isShowing())) {
      DiscussChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie).dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie.a.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie.a.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie.a = null;
    }
    DiscussChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vsh
 * JD-Core Version:    0.7.0.1
 */