import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;

public class akby
  extends BroadcastReceiver
{
  public akby(BusinessCommonConfig paramBusinessCommonConfig, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    int i;
    do
    {
      do
      {
        return;
      } while (!"tencent.businessnotify.subprocess.to.qq".equals(paramIntent.getAction()));
      i = paramIntent.getIntExtra("event", 0);
      QLog.w(BusinessCommonConfig.a, 1, "收到其他进程的通知, event[" + i + "]");
    } while (i != 1);
    BusinessCommonConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akby
 * JD-Core Version:    0.7.0.1
 */