import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.statistics.ReportController;

public class cco
  implements View.OnClickListener
{
  public cco(SearchResultDialog paramSearchResultDialog, int paramInt) {}
  
  public void onClick(View paramView)
  {
    SearchResultDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog).setText(SearchResultDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog));
    SearchResultDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog).setSelection(SearchResultDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog).length());
    ReportController.b(SearchResultDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog), "CliOper", "", "", "Search", "Last_search", this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.b(this.jdField_a_of_type_Int), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cco
 * JD-Core Version:    0.7.0.1
 */