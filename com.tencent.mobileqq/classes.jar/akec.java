import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class akec
  implements View.OnClickListener
{
  public akec(QQCustomDialog paramQQCustomDialog, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog, 1);
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akec
 * JD-Core Version:    0.7.0.1
 */