import com.tencent.mobileqq.activity.contact.newfriend.ContactMatchBuilder;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.newfriend.ContactMatchMessage;
import mqq.os.MqqHandler;

public class wjl
  implements Runnable
{
  public wjl(ContactMatchBuilder paramContactMatchBuilder) {}
  
  public void run()
  {
    ((PhoneContactManagerImp)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a(((ContactMatchMessage)this.a.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a);
    ThreadManager.getUIHandler().post(new wjm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wjl
 * JD-Core Version:    0.7.0.1
 */