import com.tencent.mobileqq.activity.NotifyPCActiveActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

public class tdq
  extends CardObserver
{
  public tdq(NotifyPCActiveActivity paramNotifyPCActiveActivity) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (paramBoolean1)
    {
      SettingCloneUtil.writeValue(this.a.app.getApp(), paramString2, null, "qqsetting_pcactive_key", true);
      QLog.i("CardObserver_onSetPCActiveState", 1, "Set the PC Active State " + paramBoolean1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tdq
 * JD-Core Version:    0.7.0.1
 */