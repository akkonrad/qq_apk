import android.view.View;
import com.tencent.mobileqq.activity.selectmember.FriendTabView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedFooterExpandableListView;
import com.tencent.widget.PinnedFooterExpandableListView.FooterExpandListViewListener;

public class xyx
  implements PinnedFooterExpandableListView.FooterExpandListViewListener
{
  public xyx(FriendTabView paramFriendTabView) {}
  
  public void a()
  {
    this.a.a = true;
    FriendTabView.a(this.a).setFooterEnable(false);
  }
  
  public void a(PinnedFooterExpandableListView paramPinnedFooterExpandableListView, View paramView, int paramInt)
  {
    if (!this.a.a)
    {
      if (paramInt - 1 >= 0) {
        paramPinnedFooterExpandableListView.b(paramInt - 1);
      }
      for (;;)
      {
        this.a.a = true;
        FriendTabView.a(this.a).setFooterEnable(false);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("FriendTabView", 2, "header group unusal: " + paramInt);
        }
      }
    }
    if (paramPinnedFooterExpandableListView.c(paramInt))
    {
      paramPinnedFooterExpandableListView.b(paramInt);
      return;
    }
    paramPinnedFooterExpandableListView.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xyx
 * JD-Core Version:    0.7.0.1
 */