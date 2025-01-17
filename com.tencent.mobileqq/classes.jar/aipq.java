import android.os.Bundle;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor;
import com.tencent.open.data.SharedPrefs;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.SSOAccountObserver;

class aipq
  extends SSOAccountObserver
{
  aipq(aipp paramaipp) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    QLog.w("Q.share.ForwardSdkShareProcessor", 1, "GetSKeyStep|onFailed|account=" + paramString + ",ret=" + paramInt2);
    this.a.b.b(9401, "get sKey failed");
    this.a.c();
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.share.ForwardSdkShareProcessor", 2, "GetSKeyStep|onGetTicketNoPasswd|account=" + paramString + ",type=" + paramInt);
    }
    long l = System.currentTimeMillis();
    if (paramInt == 4096)
    {
      ForwardSdkShareProcessor.d(this.a.b, new String(paramArrayOfByte));
      aipp.a(this.a).set(true);
      SharedPrefs.a(paramString, l);
      this.a.b();
      return;
    }
    this.a.b.b(9401, "get sKey failed");
    this.a.c();
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    QLog.w("Q.share.ForwardSdkShareProcessor", 1, "GetSKeyStep|onUserCancel|action=" + paramInt);
    this.a.b.b(9401, "onUserCancel");
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipq
 * JD-Core Version:    0.7.0.1
 */