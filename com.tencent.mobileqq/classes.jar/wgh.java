import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import java.util.List;
import mqq.os.MqqHandler;

public class wgh
  implements Runnable
{
  public wgh(ChatHistoryBubbleListForTroopFragment paramChatHistoryBubbleListForTroopFragment, int paramInt) {}
  
  public void run()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_JavaLangString, 1, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.jdField_a_of_type_Long, 20);
    if (localList != null) {
      ThreadManager.getUIHandler().post(new wgi(this, localList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wgh
 * JD-Core Version:    0.7.0.1
 */