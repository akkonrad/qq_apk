import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;

class son
  implements Runnable
{
  son(sol paramsol) {}
  
  public void run()
  {
    Card localCard = ((FriendsManager)this.a.a.app.getManager(50)).a(this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
    this.a.a.a.jdField_a_of_type_ComTencentMobileqqDataCard = localCard;
    if (localCard != null) {
      this.a.a.runOnUiThread(new soo(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     son
 * JD-Core Version:    0.7.0.1
 */