import android.content.res.Resources;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGridItem;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver;
import com.tencent.mobileqq.data.ActivateFriendItem;
import java.util.ArrayList;

public class uiz
  extends ActivateFriendsObserver
{
  public uiz(ActivateFriendGrid paramActivateFriendGrid) {}
  
  public void b()
  {
    if ((ActivateFriendGrid.a(this.a) == null) || (ActivateFriendGrid.b(this.a) == null)) {
      return;
    }
    int i = 0;
    label23:
    if (i < ActivateFriendGrid.a(this.a).size())
    {
      if (!this.a.a.c(((ActivateFriendItem)ActivateFriendGrid.a(this.a).get(i)).uin, 2)) {
        break label122;
      }
      ((ActivateFriendGridItem)ActivateFriendGrid.b(this.a).get(i)).setChecked(false);
      ((ActivateFriendGridItem)ActivateFriendGrid.b(this.a).get(i)).setBirthday(this.a.getResources().getString(2131437258));
    }
    for (;;)
    {
      i += 1;
      break label23;
      break;
      label122:
      if (this.a.a.b(((ActivateFriendItem)ActivateFriendGrid.a(this.a).get(i)).uin, 2))
      {
        ((ActivateFriendGridItem)ActivateFriendGrid.b(this.a).get(i)).setChecked(false);
        ((ActivateFriendGridItem)ActivateFriendGrid.b(this.a).get(i)).setBirthday(this.a.getResources().getString(2131437259));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uiz
 * JD-Core Version:    0.7.0.1
 */