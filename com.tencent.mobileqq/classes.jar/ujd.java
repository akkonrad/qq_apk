import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.activateFriend.PositionActivatePage;
import com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.util.WeakReference;

public class ujd
  implements View.OnClickListener
{
  public ujd(PositionActivatePage paramPositionActivatePage) {}
  
  public void onClick(View paramView)
  {
    if ((PositionActivatePage.a(this.a) != null) && (PositionActivatePage.a(this.a).get() != null))
    {
      paramView = new Intent((Context)PositionActivatePage.a(this.a).get(), SendBirthdayWishesActivity.class);
      paramView.putExtra("key_msg_type", 1);
      paramView.putExtra("key_friend_list", this.a.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.a());
      paramView.putExtra("key_roam_city", this.a.jdField_a_of_type_JavaLangString);
      ((ActivateFriendActivity)PositionActivatePage.a(this.a).get()).startActivityForResult(paramView, 1000);
      ((ActivateFriendActivity)PositionActivatePage.a(this.a).get()).overridePendingTransition(2131034123, 2131034131);
      ReportController.b(((ActivateFriendActivity)PositionActivatePage.a(this.a).get()).app, "CliOper", "", "", "0X8004E06", "0X8004E06", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ujd
 * JD-Core Version:    0.7.0.1
 */