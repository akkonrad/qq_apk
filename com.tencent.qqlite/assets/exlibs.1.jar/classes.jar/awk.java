import com.tencent.mobileqq.activity.NearPeopleFilterActivity;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.widget.QQToast;

public class awk
  implements ConditionSearchManager.IConfigListener
{
  public awk(NearPeopleFilterActivity paramNearPeopleFilterActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.a.e();
    if (!paramBoolean) {
      QQToast.a(this.a, 2131364405, 0).b(this.a.getTitleBarHeight());
    }
    while (paramInt != 2) {
      return;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     awk
 * JD-Core Version:    0.7.0.1
 */