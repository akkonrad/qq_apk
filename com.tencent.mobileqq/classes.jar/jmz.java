import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.service.QavWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcall.QCallCardHandler.OnGetQCallCardListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class jmz
  implements QCallCardHandler.OnGetQCallCardListener
{
  public jmz(QQServiceForAV paramQQServiceForAV) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onGetQCallNickName");
    }
    new QavWrapper(((QQAppInterface)this.a.a()).getApp().getApplicationContext()).a(new jna(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jmz
 * JD-Core Version:    0.7.0.1
 */