import android.widget.LinearLayout;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Iterator;
import java.util.List;

class aeoi
  implements Runnable
{
  aeoi(aeoh paramaeoh, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aeoh.a.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_Aeoh.a.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Boolean);
    int j;
    int i;
    aepr localaepr;
    int k;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      j = 0;
      i = 0;
      if (localIterator.hasNext())
      {
        localaepr = (aepr)localIterator.next();
        if (localaepr.a == 1)
        {
          k = j;
          j = i + 1;
          i = k;
        }
      }
    }
    for (;;)
    {
      k = j;
      j = i;
      i = k;
      break;
      if (localaepr.a == 0)
      {
        k = j + 1;
        j = i;
        i = k;
        continue;
        ReportController.b(this.jdField_a_of_type_Aeoh.a.a.app, "dc00899", "Grp_wolf", "", "invite_page", "exp_invite", 0, 0, "" + i, "" + j, "", "");
        if (this.jdField_a_of_type_Boolean) {
          ReportController.b(this.jdField_a_of_type_Aeoh.a.a.app, "dc00899", "Grp_wolf", "", "invite_page", "exp_more", 0, 0, "", "", "", "");
        }
      }
      else
      {
        k = i;
        i = j;
        j = k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeoi
 * JD-Core Version:    0.7.0.1
 */