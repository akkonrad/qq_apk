import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.net.URLEncoder;

public class esq
  implements View.OnClickListener
{
  public esq(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    if (!BannerManager.a(this.a)) {
      return;
    }
    BannerManager.a(this.a, false);
    new Handler().postDelayed(new esr(this), 1000L);
    paramView = (QQAppInterface)BannerManager.a(this.a).getAppRuntime();
    String str = paramView.a();
    Object localObject = new StringBuilder("https://aq.qq.com/en/change_psw/mobile/mobile_change_mqq_reg_input_pwd");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append("source_id=2997");
    ((StringBuilder)localObject).append("&uin=");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("&plat=1");
    ((StringBuilder)localObject).append("&app=1");
    ((StringBuilder)localObject).append("&version=6.0.0.6500");
    ((StringBuilder)localObject).append("&device=" + URLEncoder.encode(Build.DEVICE));
    ((StringBuilder)localObject).append("&system=" + Build.VERSION.RELEASE);
    ((StringBuilder)localObject).append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
    localObject = ((StringBuilder)localObject).toString();
    Intent localIntent = new Intent();
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("url", (String)localObject);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    VasWebviewUtil.a(BannerManager.a(this.a), (String)localObject, 32768L, localIntent, false, -1);
    PhoneNumLoginImpl.a().a(paramView);
    BannerManager.a(this.a).sendEmptyMessageDelayed(4, 1000L);
    ReportController.b(paramView, "CliOper", "", "", "Mobile_signup", "Clk_blue_pw", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     esq
 * JD-Core Version:    0.7.0.1
 */