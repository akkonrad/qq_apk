import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import java.util.List;
import mqq.os.MqqHandler;

public class wgf
  implements Runnable
{
  public wgf(ChatHistoryBubbleListForTroopFragment paramChatHistoryBubbleListForTroopFragment, int paramInt) {}
  
  public void run()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_JavaLangString, 1, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.b, 20);
    if (localList != null) {
      ThreadManager.getUIHandler().post(new wgg(this, localList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wgf
 * JD-Core Version:    0.7.0.1
 */