import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver;
import com.tencent.qphone.base.util.QLog;

public class uiv
  extends ActivateFriendsObserver
{
  public uiv(ActivateFriendActivity paramActivateFriendActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.MainActivity", 2, "onReceiveBirthDayPushUpdate");
    }
    ActivateFriendActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uiv
 * JD-Core Version:    0.7.0.1
 */