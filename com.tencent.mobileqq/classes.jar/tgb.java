import android.text.TextUtils;
import com.tencent.mobileqq.activity.PhoneUnityPhoneLoginActivity;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;

public class tgb
  extends SecSvcObserver
{
  public tgb(PhoneUnityPhoneLoginActivity paramPhoneUnityPhoneLoginActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt == 0) && (PhoneUnityPhoneLoginActivity.a(this.a) != null))
    {
      PhoneUnityPhoneLoginActivity.a(this.a).setOnCheckedChangeListener(null);
      PhoneUnityPhoneLoginActivity.a(this.a).setChecked(true);
      PhoneUnityPhoneLoginActivity.a(this.a).setOnCheckedChangeListener(this.a);
      return;
    }
    if (paramInt == 39)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8005BFD", "0X8005BFD", 0, 0, "", "", "", "");
      DialogUtil.a(this.a, 230, this.a.getString(2131436856), this.a.getString(2131436857), null, this.a.getString(2131436628), new tgc(this), null).show();
      return;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = this.a.getString(2131436851);
    }
    QQToast.a(this.a, str, 0).b(this.a.getTitleBarHeight());
  }
  
  public void b(int paramInt, String paramString)
  {
    if ((paramInt == 0) && (PhoneUnityPhoneLoginActivity.a(this.a) != null))
    {
      PhoneUnityPhoneLoginActivity.a(this.a).setOnCheckedChangeListener(null);
      PhoneUnityPhoneLoginActivity.a(this.a).setChecked(false);
      PhoneUnityPhoneLoginActivity.a(this.a).setOnCheckedChangeListener(this.a);
      return;
    }
    String str;
    if (paramInt == 36) {
      str = this.a.getString(2131436853);
    }
    for (;;)
    {
      QQToast.a(this.a, str, 0).b(this.a.getTitleBarHeight());
      return;
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.a.getString(2131436852);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tgb
 * JD-Core Version:    0.7.0.1
 */