import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.DropdownView;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

class auc
  implements View.OnClickListener
{
  auc(aua paramaua, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Aua.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.removeTextChangedListener(this.jdField_a_of_type_Aua.a.b);
    paramView = (SimpleAccount)this.jdField_a_of_type_Aua.a.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
    LoginActivity.a(this.jdField_a_of_type_Aua.a, paramView);
    this.jdField_a_of_type_Aua.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_a_of_type_Aua.a.b);
    this.jdField_a_of_type_Aua.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.jdField_a_of_type_Aua.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.clearFocus();
    this.jdField_a_of_type_Aua.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonVisible(false);
    this.jdField_a_of_type_Aua.a.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.a().setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     auc
 * JD-Core Version:    0.7.0.1
 */