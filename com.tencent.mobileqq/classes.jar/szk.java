import com.tencent.mobileqq.activity.LikeSettingActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.LikeRankingListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class szk
  extends CardObserver
{
  public szk(LikeSettingActivity paramLikeSettingActivity) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LikeSettingActivity", 2, "onSetCardSwitch.isSuccess=" + paramBoolean1 + ",uin=" + paramString + ",forNearPeople=" + paramBoolean2 + ",allowed=" + paramBoolean3);
    }
    if ((!this.a.app.getCurrentAccountUin().equals(paramString)) || (!paramBoolean2)) {}
    while (paramBoolean1) {
      return;
    }
    QQToast.a(this.a, 1, 2131436066, 0).b(this.a.getTitleBarHeight());
    LikeSettingActivity.a(this.a, this.a.c.a(), paramBoolean3);
  }
  
  protected void b(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LikeSettingActivity", 2, "onGetCardSwitch.isSuccess=" + paramBoolean1 + ",uin=" + paramString + ",voteAllowed=" + paramBoolean2 + ",praiseStatusAllowed=" + paramBoolean3);
    }
    if (!this.a.app.getCurrentAccountUin().equals(paramString)) {}
    while (!paramBoolean1) {
      return;
    }
    LikeSettingActivity.a(this.a, this.a.c.a(), paramBoolean2);
  }
  
  protected void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LikeSettingActivity", 2, "onGetNotifyOnLikeRankingList.isSuccess=" + paramBoolean1 + ",open=" + paramBoolean2);
    }
    if (paramBoolean1)
    {
      LikeSettingActivity.a(this.a, this.a.b.a(), paramBoolean2);
      this.a.a.a(paramBoolean2);
    }
  }
  
  protected void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LikeSettingActivity", 2, "onSetNotifyOnLikeRankingList.isSuccess=" + paramBoolean1 + ",open=" + paramBoolean2);
    }
    if (!paramBoolean1)
    {
      QQToast.a(this.a, 1, 2131436066, 0).b(this.a.getTitleBarHeight());
      LikeSettingActivity.a(this.a, this.a.d.a(), this.a.a.a());
      return;
    }
    this.a.a.a(paramBoolean2);
  }
  
  protected void f(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LikeSettingActivity", 2, "onSetPartakeLikeRankingList.isSuccess=" + paramBoolean1 + ",open=" + paramBoolean2);
    }
    if (!paramBoolean1)
    {
      QQToast.a(this.a, 1, 2131436066, 0).b(this.a.getTitleBarHeight());
      LikeSettingActivity.a(this.a, this.a.d.a(), this.a.a.c());
      return;
    }
    this.a.a.b(paramBoolean2);
    if (!paramBoolean2)
    {
      this.a.b.setVisibility(8);
      return;
    }
    this.a.b.setVisibility(0);
  }
  
  protected void g(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LikeSettingActivity", 2, "onGetPartakeLikeRankingList.isSuccess=" + paramBoolean1 + ",open=" + paramBoolean2);
    }
    if (paramBoolean1)
    {
      LikeSettingActivity.a(this.a, this.a.d.a(), paramBoolean2);
      this.a.a.b(paramBoolean2);
      if (!paramBoolean2) {
        this.a.b.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.a.b.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     szk
 * JD-Core Version:    0.7.0.1
 */