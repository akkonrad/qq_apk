import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppShareMultiItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.service.message.MessageRecordFactory;

public class uuw
  implements DialogInterface.OnClickListener
{
  public uuw(ArkAppShareMultiItemBuilder paramArkAppShareMultiItemBuilder, MessageForArkApp paramMessageForArkApp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (MessageForArkApp)MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp);
    if (paramDialogInterface.msgData == null) {
      if (paramDialogInterface.ark_app_message == null) {
        ArkAppCenter.b("ArkApp", String.format("resendMessage, msgData and ark_app_message are null", new Object[0]));
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppShareMultiItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)
    {
      return;
      paramDialogInterface.msgData = paramDialogInterface.ark_app_message.toBytes();
    }
    if ((paramDialogInterface.ark_app_message.containStructMsg == null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.containStructMsg != null)) {
      paramDialogInterface.ark_app_message.containStructMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.containStructMsg;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppShareMultiItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppShareMultiItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppShareMultiItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppShareMultiItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDialogInterface, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uuw
 * JD-Core Version:    0.7.0.1
 */