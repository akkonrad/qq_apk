import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.List;
import mqq.os.MqqHandler;

public class rtu
  implements Runnable
{
  public rtu(BaseChatPie paramBaseChatPie, List paramList) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i));
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(52, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rtu
 * JD-Core Version:    0.7.0.1
 */