import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomSingleButtonDialog;

public class hho
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public hho(QQCustomSingleButtonDialog paramQQCustomSingleButtonDialog, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.a.onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.a(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hho
 * JD-Core Version:    0.7.0.1
 */