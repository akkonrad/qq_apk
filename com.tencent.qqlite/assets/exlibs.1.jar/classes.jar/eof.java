import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.widget.QQToast;

class eof
  implements Runnable
{
  eof(eoe parameoe) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = (BaseActivity)this.a.a.a;
    if (localBaseActivity != null) {
      QQToast.a(localBaseActivity, localBaseActivity.getString(2131362326), 0).b(localBaseActivity.getTitleBarHeight());
    }
    this.a.cancel();
    this.a.a.a();
    this.a.a.a(localBaseActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eof
 * JD-Core Version:    0.7.0.1
 */