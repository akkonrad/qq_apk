import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.widget.ActionSheet;

class aays
  implements DialogInterface.OnDismissListener
{
  aays(aayr paramaayr, ActionSheet paramActionSheet) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    ArkAppCenter.b("ArkApp.DebugOnlineActivity", String.format("ClearData actionsheet is closed", new Object[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aays
 * JD-Core Version:    0.7.0.1
 */