import android.widget.LinearLayout;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloPanelAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class yyf
  implements Runnable
{
  public yyf(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter != null) && (this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_ComTencentWidgetHorizontalListView != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "func initLastApolloPanel begins. Thread id = " + Thread.currentThread().getId());
      }
      this.a.jdField_a_of_type_JavaUtilList.clear();
      this.a.jdField_a_of_type_JavaUtilList.add(this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder);
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yyf
 * JD-Core Version:    0.7.0.1
 */