import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;

class bsx
  implements DialogInterface.OnDismissListener
{
  bsx(bsw parambsw) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.jdField_a_of_type_ComTencentWidgetMenuPopupDialog = null;
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      paramDialogInterface = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      if ((paramDialogInterface instanceof BaseBubbleBuilder)) {
        ((BaseBubbleBuilder)paramDialogInterface).b();
      }
    }
    com.tencent.widget.MenuPopupDialog.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bsx
 * JD-Core Version:    0.7.0.1
 */