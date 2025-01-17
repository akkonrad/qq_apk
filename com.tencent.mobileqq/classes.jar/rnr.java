import QQService.SvcDevLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class rnr
  extends FriendListObserver
{
  public rnr(AuthDevActivity paramAuthDevActivity) {}
  
  protected void onDelAuthDevResult(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "onDelAuthDevResult.isSuccess=" + paramBoolean + " errorMsg=" + paramString + " index=" + paramInt);
    }
    AuthDevActivity.c(this.a);
    if (paramBoolean)
    {
      if ((paramInt > -1) && (paramInt < AuthDevActivity.a(this.a).size()))
      {
        paramString = (SvcDevLoginInfo)AuthDevActivity.a(this.a).get(paramInt);
        if (Arrays.equals(NetConnInfoCenter.GUID, paramString.vecGuid))
        {
          this.a.app.updateSubAccountLogin(this.a.app.getAccount(), false);
          this.a.app.getApplication().refreAccountList();
          QQSettingUtil.a(this.a, this.a.app, true);
          return;
        }
        if (paramInt < AuthDevActivity.a(this.a).size())
        {
          AuthDevActivity.a(this.a).remove(paramInt);
          AuthDevActivity.a(this.a, AuthDevActivity.a(this.a));
        }
      }
      QQToast.a(this.a.getApplicationContext(), 2, this.a.getString(2131436586), 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131436585), 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, paramString, 0).b(this.a.getTitleBarHeight());
  }
  
  protected void onGetAuthDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    AuthDevActivity.a(this.a).setVisibility(8);
    if (!AuthDevActivity.a(this.a)) {
      return;
    }
    if ((paramBoolean) && (paramSvcRspGetDevLoginInfo != null) && (paramSvcRspGetDevLoginInfo.iResult == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "onGetAuthDevResult.success");
      }
      AuthDevActivity.a(this.a, paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.devlock.AuthDevActivity", 2, "------------------------------------------------------------------------------");
        paramSvcRspGetDevLoginInfo = AuthDevActivity.a(this.a).iterator();
        while (paramSvcRspGetDevLoginInfo.hasNext())
        {
          SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.next();
          if (localSvcDevLoginInfo != null) {
            QLog.d("Q.devlock.AuthDevActivity", 2, "SvcDevLoginInfo.iAppId=" + localSvcDevLoginInfo.iAppId + " iLoginTime=" + localSvcDevLoginInfo.iLoginTime + " strLoginLocation=" + localSvcDevLoginInfo.strLoginLocation + " iLoginPlatform=" + localSvcDevLoginInfo.iLoginPlatform + " strDeviceName=" + localSvcDevLoginInfo.strDeviceName + " strDeviceTypeInfo" + localSvcDevLoginInfo.strDeviceTypeInfo);
          }
        }
        QLog.d("Q.devlock.AuthDevActivity", 2, "------------------------------------------------------------------------------");
      }
      AuthDevActivity.a(this.a, AuthDevActivity.a(this.a));
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevActivity", 2, "onGetAuthDevResult.isSuccess=" + paramBoolean);
      if (paramSvcRspGetDevLoginInfo != null) {
        break label312;
      }
      QLog.d("Q.devlock.AuthDevActivity", 2, "onGetAuthDevResult.data is null");
    }
    for (;;)
    {
      AuthDevActivity.a(this.a).setVisibility(4);
      QQToast.a(this.a, 1, this.a.getString(2131436584), 0).b(this.a.getTitleBarHeight());
      return;
      label312:
      QLog.d("Q.devlock.AuthDevActivity", 2, "onGetAuthDevResult.data.iResult=" + paramSvcRspGetDevLoginInfo.iResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rnr
 * JD-Core Version:    0.7.0.1
 */