import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.webprocess.WebProcessManager.WebProcessStartListener;
import com.tencent.qphone.base.util.QLog;

class tms
  implements WebProcessManager.WebProcessStartListener
{
  tms(tmr paramtmr, QQSettingMe paramQQSettingMe) {}
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (QQSettingMe.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe) != null)) {
      QQSettingMe.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe).a();
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("WebPreloadTask preloadWebProcess isProcessExist: ");
      if (paramBoolean) {
        break label64;
      }
    }
    label64:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("QQSettingRedesign", 2, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tms
 * JD-Core Version:    0.7.0.1
 */