import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.data.ChatMessage;

public class wbc
  implements DialogInterface.OnClickListener
{
  public wbc(TroopChatPie paramTroopChatPie, ChatMessage paramChatMessage) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.e(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wbc
 * JD-Core Version:    0.7.0.1
 */