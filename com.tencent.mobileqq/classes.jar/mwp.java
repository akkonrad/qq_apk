import android.app.Activity;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public final class mwp
  implements BusinessObserver
{
  public mwp(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new mwq(this, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwp
 * JD-Core Version:    0.7.0.1
 */