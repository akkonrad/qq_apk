import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.MsgTabUnreadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class wqx
  implements MsgTabUnreadListener
{
  public wqx(MainAssistObserver paramMainAssistObserver) {}
  
  public void a(int paramInt)
  {
    if ((this.a.a == null) || (this.a.a.app == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = this.a.a.app;
    this.a.a(32, 16, Integer.valueOf(paramInt));
    Intent localIntent = new Intent("com.tencent.qq.syncQQMessage");
    localQQAppInterface.getApp().sendBroadcast(localIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d("fetchUnReadCount", 4, String.format("MainAssistObserver消息tab, nUnreadCount[%s]", new Object[] { Integer.valueOf(paramInt) }));
    }
    ReadinjoySPEventReport.a().a(paramInt);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SplashActivity", 4, String.format("onRefresh, needReGetUnread[%s], nUnReadCount[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if ((!paramBoolean) && (paramInt >= 0))
    {
      a(paramInt);
      return;
    }
    ThreadManager.executeOnSubThread(new wqy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wqx
 * JD-Core Version:    0.7.0.1
 */