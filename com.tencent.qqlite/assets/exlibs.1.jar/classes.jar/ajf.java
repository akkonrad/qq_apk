import android.text.TextUtils;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateResult;
import com.tencent.mobileqq.widget.QQToast;

public class ajf
  extends BizTroopObserver
{
  public ajf(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    int i = -1;
    this.a.f();
    if ((!paramBoolean) && (paramObject != null)) {}
    try
    {
      int j = ((TroopCreateLogic.TroopCreateResult)paramObject).b;
      i = j;
    }
    catch (Exception paramObject)
    {
      label29:
      break label29;
    }
    i = TroopCreateLogic.TroopCreateResult.a(i);
    if (i == 0) {}
    do
    {
      do
      {
        return;
        QQToast.a(this.a, i, 0).b(this.a.getTitleBarHeight());
        return;
        if (paramObject != null) {
          break;
        }
        i = TroopCreateLogic.TroopCreateResult.a(-1);
      } while (i == 0);
      QQToast.a(this.a, i, 0).b(this.a.getTitleBarHeight());
      return;
      paramObject = (TroopInfo)paramObject;
    } while (TextUtils.isEmpty(paramObject.troopuin));
    DiscussionInfoCardActivity.c(this.a);
    TroopCreateLogicActivity.a(this.a.app, this.a, paramObject.troopuin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ajf
 * JD-Core Version:    0.7.0.1
 */